package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.util.ArrayMap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.d.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0056a, VoiceManager.c, t.a, e.a {
    private static int hLw = 0;
    private com.baidu.tbadk.editortools.i bsp;
    private String btS;
    private LocationModel btT;
    private NewWriteModel btU;
    private VoiceManager dEk;
    private LinearLayout fPe;
    private PlayVoiceBntNew fPf;
    private ImageView fPh;
    private View gQA;
    private int gQa;
    private TextView gQx;
    private com.baidu.tieba.write.e gQy;
    private ImageView gQz;
    private com.baidu.tieba.write.b hHQ;
    private HotTopicBussinessData hKB;
    private View hKC;
    private View hKD;
    private TextView hKE;
    private TextView hKF;
    private com.baidu.tieba.write.editor.d hKJ;
    private com.baidu.tieba.write.b hKK;
    private com.baidu.tieba.view.d hKR;
    private View hKX;
    private LinearLayout hKj;
    private LinearLayout hKk;
    private View hKm;
    private Toast hKn;
    private AdditionData hKo;
    private RelativeLayout hKp;
    private TextView hKq;
    private TextView hKr;
    private TextView hKs;
    List<z> hKt;
    z hKu;
    private int hKv;
    private String hKw;
    private int hKx;
    private PostCategoryView hKy;
    private f hLe;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hKg = "";
    private boolean hKh = false;
    private WriteData mData = null;
    private boolean hKT = false;
    private boolean hKi = false;
    private boolean hKU = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gQs = null;
    private HeadImageView hKV = null;
    private View gQt = null;
    private LinearLayout gQv = null;
    private EditText gQw = null;
    private FeedBackModel hKl = null;
    private FeedBackTopListView hKW = null;
    private ArrayList<com.baidu.tieba.write.d> hJc = new ArrayList<>();
    private String fnR = null;
    private final KeyEvent drp = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View bgy = null;
    private TextView hKY = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hKZ = null;
    private final Handler mHandler = new Handler();
    private boolean hLa = false;
    private String hLb = null;
    private RelativeLayout mParent = null;
    private String btY = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int btZ = 0;
    private int hLc = 0;
    private WriteImagesInfo hLd = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hLf = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hLg = null;
    private ScrollView hKz = null;
    private EditText hLh = null;
    private View hLi = null;
    private View hLj = null;
    private View hLk = null;
    private EditText hLl = null;
    private TextView hLm = null;
    private TextView hLn = null;
    private TextWatcher hLo = null;
    private TextWatcher hLp = null;
    private boolean hKA = false;
    private boolean hLq = false;
    private com.baidu.tbadk.core.view.b bCz = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hLr = null;
    private TbImageView hLs = null;
    private View hLt = null;
    private Dialog hLu = null;
    private LinearLayout hLv = null;
    private boolean hLx = false;
    private long hLy = -1000;
    private boolean hLz = false;
    private String hpq = "2";
    private int hEp = 0;
    private String hLA = "";
    private String hKG = "";
    private int hKH = 0;
    private SpannableStringBuilder hKI = new SpannableStringBuilder();
    private boolean hLB = false;
    private final HttpMessageListener hLC = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fnR)) {
                    WriteActivity.this.fnR = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nS(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fnR)) {
                    WriteActivity.this.fnR = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fnR);
                    WriteActivity.this.nS(true);
                }
            }
        }
    };
    private TbFaceManager.a hKL = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gL(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.sh());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.i(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dFi = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXv));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXv));
        }
    };
    private final NewWriteModel.d buj = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.avh();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hHQ.aw(null);
                WriteActivity.this.hHQ.nA(false);
                WriteActivity.this.hKK.aw(null);
                WriteActivity.this.hKK.nA(false);
                if (z) {
                    WriteActivity.this.cn(z);
                    if (WriteActivity.this.d(writeData)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                t.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                t.b(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                t.c(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.b("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.E(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hLA)) {
                            TiebaStatic.log(new ak("c11731").ab("obj_id", WriteActivity.this.hLA));
                        }
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hHQ.aw(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hKK.aw(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hHQ.un(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hKK.un(postWriteCallBackData.getErrorString());
                    if (!v.E(WriteActivity.this.hHQ.bFB())) {
                        WriteActivity.this.nJ(true);
                        WriteActivity.this.nP(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FX());
                    if (com.baidu.tbadk.p.a.hx(tVar.FW())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FW());
                        if (WriteActivity.this.hKU) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, newVcodeActivityConfig));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a buh = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void LQ() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gA(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bxv())) {
                WriteActivity.this.b(2, true, aVar.bxv());
            } else {
                gA(null);
            }
        }
    };
    private final CustomMessageListener hcO = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.btT.mM(false);
                    WriteActivity.this.btT.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.btT.mM(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hKM = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hKN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIj = WriteActivity.this.bIj();
            if (bIj >= 0 && bIj < WriteActivity.this.gQw.getText().length()) {
                WriteActivity.this.gQw.setSelection(bIj);
            }
        }
    };
    private boolean hKO = true;
    private final View.OnFocusChangeListener gQq = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gQs || view == WriteActivity.this.bgy || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hKO = true;
                    WriteActivity.this.bIk();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gQs);
                    if (WriteActivity.this.bsp != null) {
                        WriteActivity.this.bsp.Jl();
                    }
                } else if (view == WriteActivity.this.gQs) {
                    WriteActivity.this.gQx.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gQw && z) {
                WriteActivity.this.hKO = false;
                WriteActivity.this.bIk();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.gQw);
                if (WriteActivity.this.bsp != null) {
                    WriteActivity.this.bsp.Jl();
                }
            }
            WriteActivity.this.bIn();
        }
    };
    private TextWatcher hKP = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bsI();
            if (WriteActivity.this.hKK != null) {
                if (!WriteActivity.this.hKK.bFE()) {
                    WriteActivity.this.nP(false);
                }
                WriteActivity.this.hKK.nB(false);
                WriteActivity.this.bIo();
            }
        }
    };
    private TextWatcher hKQ = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bsI();
            if (WriteActivity.this.hHQ != null) {
                if (!WriteActivity.this.hHQ.bFE()) {
                    WriteActivity.this.nJ(false);
                }
                WriteActivity.this.hHQ.nB(false);
            }
        }
    };
    private final a.InterfaceC0234a fVR = new a.InterfaceC0234a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
            WriteActivity.this.fnR = null;
            WriteActivity.this.nS(false);
            WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(boolean z) {
        if (bIz() != null && bIz().getVisibility() == 0 && bIz().getText() != null) {
            int selectionEnd = bIz().getSelectionEnd();
            SpannableStringBuilder b = this.hKK.b(bIz().getText());
            if (b != null) {
                this.hKK.nB(true);
                bIz().setText(b);
                if (z && this.hKK.bFC() >= 0) {
                    bIz().requestFocus();
                    bIz().setSelection(this.hKK.bFC());
                } else {
                    bIz().setSelection(selectionEnd);
                }
                this.hKK.nA(this.hKK.bFC() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        if (bIy() != null && bIy().getText() != null) {
            int selectionEnd = bIy().getSelectionEnd();
            SpannableStringBuilder b = this.hHQ.b(bIy().getText());
            if (b != null) {
                this.hHQ.nB(true);
                bIy().setText(b);
                if (z && this.hHQ.bFC() >= 0) {
                    bIy().requestFocus();
                    bIy().setSelection(this.hHQ.bFC());
                } else {
                    bIy().setSelection(selectionEnd);
                }
                this.hHQ.nA(this.hHQ.bFC() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LC() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void LD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            LE();
        } else if (this.btT.bxD()) {
            LC();
        } else {
            this.btT.mM(false);
            b(1, true, null);
            this.btT.bxB();
        }
    }

    private void LE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.btT.ahl();
                } else {
                    WriteActivity.this.buh.LQ();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIj() {
        int selectionEnd = bIy().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIy().getText().getSpans(0, bIy().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIy().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIy().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        if (this.bsp != null) {
            this.bsp.setBarLauncherEnabled(!this.hKO);
            this.bsp.g(true, 26);
            this.bsp.g(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hKA) {
            this.gQs.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hLk.setVisibility(8);
            } else {
                this.hLk.setVisibility(0);
            }
            a(this.hLn, this.hLh);
            a(this.hLm, this.hLl);
            bsI();
        }
        if (this.hKT) {
            this.hKO = true;
            bIk();
            if (this.bsp != null) {
                this.bsp.Jl();
            }
            this.gQs.requestFocus();
            ShowSoftKeyPadDelay(this.gQs);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        String stringExtra;
        super.onNewIntent(intent);
        if (intent != null && (stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING")) != null && this.writeImagesInfo != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            bIV();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bIG();
            }
            nT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        this.hKK = new com.baidu.tieba.write.b();
        this.hKK.xg(d.C0141d.cp_cont_i);
        this.hKK.xh(d.C0141d.cp_cont_h_alpha85);
        this.hHQ = new com.baidu.tieba.write.b();
        this.hHQ.xg(d.C0141d.cp_cont_i);
        this.hHQ.xh(d.C0141d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            xM(this.hEp);
        }
        initUI();
        bIL();
        this.btT = new LocationModel(this);
        this.btT.a(this.buh);
        registerListener(this.hcO);
        registerListener(this.hKM);
        initEditor();
        bIX();
        if (this.hKA) {
            this.hLg.setEditorTools(this.bsp);
        } else {
            this.gQw.requestFocus();
        }
        Jn();
        bIG();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bsp = new com.baidu.tbadk.editortools.i(getActivity());
        this.bsp.setBarMaxLauCount(5);
        this.bsp.setMoreButtonAtEnd(true);
        this.bsp.setBarLauncherType(1);
        this.bsp.cf(true);
        this.bsp.cg(true);
        this.bsp.setMoreLauncherIcon(d.f.write_more);
        this.bsp.setBackgroundColorId(d.C0141d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bIJ();
                break;
            default:
                bIl();
                break;
        }
        this.bsp.Lc();
        if (this.hKj != null) {
            this.hKj.addView(this.bsp);
        }
        bIm();
        this.bsp.th();
        com.baidu.tbadk.editortools.l hG = this.bsp.hG(6);
        if (hG != null && !TextUtils.isEmpty(this.btY)) {
            ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.btY);
                }
            });
        }
        if (!this.hKA) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bsp.Jl();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bIH() {
        this.hLi = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hLk = this.hLi.findViewById(d.g.live_post_title_container);
        this.hLh = (EditText) this.hLi.findViewById(d.g.live_post_content);
        this.hLf = (GridView) this.hLi.findViewById(d.g.photoLiveGridView);
        this.hLl = (EditText) this.hLi.findViewById(d.g.live_post_title);
        this.hLm = (TextView) this.hLi.findViewById(d.g.titleOverPlusNumber);
        this.hLn = (TextView) this.hLi.findViewById(d.g.contentOverPlusNumber);
        this.hLj = this.hLi.findViewById(d.g.live_interval_view);
        this.hLm.setText(String.valueOf(20));
        this.hLn.setText(String.valueOf(233));
        this.hLi.setVisibility(0);
        this.hLm.setVisibility(0);
        this.hLn.setVisibility(0);
        this.hLl.setHint(d.j.tips_title_limit_new);
        this.hLl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hLq = true;
                    WriteActivity.this.hKO = true;
                    WriteActivity.this.bIk();
                    if (WriteActivity.this.bsp != null) {
                        WriteActivity.this.bsp.Jl();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hLh.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hLh.setHint(d.j.live_write_input_content_update);
        }
        this.hLh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hLq = false;
                    WriteActivity.this.hKO = false;
                    WriteActivity.this.bIk();
                    if (WriteActivity.this.bsp != null) {
                        WriteActivity.this.bsp.Jl();
                    }
                }
            }
        });
        this.hLh.requestFocus();
        this.hLh.addTextChangedListener(bIN());
        this.hLl.requestFocus();
        this.hLl.addTextChangedListener(bIN());
        this.hLl.setOnClickListener(this.hKN);
        this.hLh.setOnClickListener(this.hKN);
        this.hLg = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hLf);
        this.hLg.xy(6);
        this.hLf.setAdapter((ListAdapter) this.hLg);
        View findViewById = this.hLi.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bHt() {
                WriteActivity.this.aTN();
            }
        });
        bII();
    }

    private void bII() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hLl.setText(this.mData.getTitle());
                this.hLl.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hKA) {
            bIS();
        }
        if (this.bsp.Le()) {
            this.bsp.Jl();
        }
        xM(0);
    }

    private void xM(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hpq);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bIJ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.bsp.K(arrayList);
        r hI = this.bsp.hI(5);
        if (hI != null) {
            hI.bsY = 2;
            hI.bsW = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.bsW = d.f.write_at;
        this.bsp.b(aVar);
        this.bsp.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bIl() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        CustomResponsedMessage runTask;
        r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.bsW = d.f.write_picture;
        this.bsp.b(dVar);
        Boolean bIQ = bIQ();
        if (!this.hKT && bIQ != null && bIQ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.byb() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), r.class)) != null && (rVar5 = (r) runTask.getData()) != null) {
            rVar5.bsY = 3;
            rVar5.bsW = d.f.write_recorder;
            this.bsp.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.bsW = d.f.write_at;
        this.bsp.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.bsY = 5;
            rVar4.bsW = d.f.write_privilege;
            this.bsp.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.bsY = 6;
            rVar3.bsW = this.hKT ? d.f.write_location : d.f.icon_post_more_location;
            this.bsp.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.bsp.b(aVar2);
        aVar2.bsW = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.bta = true;
            rVar2.bsY = 9;
            rVar2.bsW = 0;
            this.bsp.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), r.class);
        if (runTask5 != null && (rVar = (r) runTask5.getData()) != null) {
            rVar.bta = true;
            rVar.bsY = 10;
            rVar.bsW = 0;
            this.bsp.b(rVar);
        }
        if (this.hKo == null) {
            if (this.hKJ == null) {
                this.hKJ = new com.baidu.tieba.write.editor.d(getActivity(), this.hpq);
                this.hKJ.aO(this.mData.getForumId(), this.privateThread);
            }
            this.bsp.b(this.hKJ);
        }
        this.bsp.K(arrayList);
        r hI = this.bsp.hI(5);
        if (hI != null) {
            hI.bsY = 1;
            hI.bsW = d.f.write_emotion;
        }
    }

    private void bIm() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bIx()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bIx()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bIA();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bdf();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIV();
                        WriteActivity.this.bsI();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xN(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hKo == null) {
                            WriteActivity.this.LF();
                            return;
                        }
                        switch (WriteActivity.this.btZ) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aS(pageActivity)) {
                                    WriteActivity.this.LD();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.LC();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.btT != null) {
                            WriteActivity.this.btT.mM(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fnR = null;
                        } else {
                            WriteActivity.this.fnR = (String) aVar.data;
                        }
                        WriteActivity.this.nS(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ab(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.bsp.Le()) {
                                        WriteActivity.this.bsp.Jl();
                                        WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.j.plugin_video_not_active), WriteActivity.this.getResources().getString(d.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.j.plugin_video_install_tips), WriteActivity.this.getResources().getString(d.j.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bsI();
                        if (WriteActivity.this.gQw != null) {
                            WriteActivity.this.gQw.requestFocus();
                        }
                        WriteActivity.this.bsp.Jl();
                        WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQw);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hKh = true;
                        WriteActivity.this.nQ(true);
                        if (WriteActivity.this.bIz().isFocused()) {
                            WriteActivity.this.hKg = "from_title";
                        } else if (WriteActivity.this.bIy().isFocused()) {
                            WriteActivity.this.hKg = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hKk.setVisibility(0);
                        WriteActivity.this.hKk.requestFocus();
                        WriteActivity.this.bsI();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hKk.hasFocus()) {
                            WriteActivity.this.gQw.requestFocus();
                            WriteActivity.this.gQw.setSelection(WriteActivity.this.gQw.getText().toString().length());
                        }
                        WriteActivity.this.hKk.setVisibility(8);
                        WriteActivity.this.bsI();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bsp.a(16, bVar);
        this.bsp.a(14, bVar);
        this.bsp.a(24, bVar);
        this.bsp.a(3, bVar);
        this.bsp.a(10, bVar);
        this.bsp.a(11, bVar);
        this.bsp.a(12, bVar);
        this.bsp.a(13, bVar);
        this.bsp.a(15, bVar);
        this.bsp.a(18, bVar);
        this.bsp.a(20, bVar);
        this.bsp.a(25, bVar);
        this.bsp.a(27, bVar);
        this.bsp.a(29, bVar);
        this.bsp.a(43, bVar);
        this.bsp.a(45, bVar);
        this.bsp.a(53, bVar);
        this.bsp.a(48, bVar);
        this.bsp.a(46, bVar);
        this.bsp.a(49, bVar);
        this.bsp.a(47, bVar);
        this.bsp.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LF() {
        if (this.btT.ahh()) {
            if (this.btT.bxD()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bxz().getLocationData().bxv());
                return;
            }
            b(1, true, null);
            this.btT.bxB();
            return;
        }
        b(0, true, null);
    }

    protected void bsA() {
        if (this.btU != null) {
            this.btU.cancelLoadData();
        }
        if (this.hKl != null) {
            this.hKl.cancelLoadData();
        }
        if (this.btT != null) {
            this.btT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bsA();
        bIP();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hLe != null) {
            this.hLe.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHE() {
        if (this.mData != null && this.mData.getType() == 2 && this.hLa) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bIz().getText().toString());
            this.mData.setContent(bIy().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.b("24591571", this.mData);
                }
            } else if (type == 1) {
                t.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                t.b(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                t.c(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gQy != null && this.gQy.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gQy, getPageContext().getPageActivity());
                return true;
            } else if (this.bsp.Le()) {
                this.bsp.Jl();
                return true;
            } else {
                bsA();
                bHE();
                return true;
            }
        }
        if (i == 67 && (text = bIy().getText()) != null) {
            int selectionStart = bIy().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIy().onKeyDown(67, this.drp);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.mParent);
        getLayoutMode().aM(this.hLv);
        if (this.hLs != null && i == 1) {
            this.hLs.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0141d.cp_link_tip_a, 1);
        bIk();
        aj.t(this.hLi, d.C0141d.cp_bg_line_d);
        aj.t(this.gQt, d.C0141d.cp_bg_line_c);
        aj.t(this.hLj, d.C0141d.cp_bg_line_c);
        aj.t(bIz(), d.C0141d.cp_bg_line_d);
        aj.c(this.fPh, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fnR)) {
            aj.t(bIy(), d.C0141d.cp_bg_line_d);
        }
        bsI();
        this.bsp.onChangeSkinType(i);
        if (this.hKy != null) {
            this.hKy.Em();
        }
        aj.r(this.mName, d.C0141d.cp_cont_b);
        bIn();
        bIo();
        if (this.hHQ != null) {
            this.hHQ.onChangeSkinType();
        }
        if (this.hKK != null) {
            this.hKK.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        if (this.gQs.hasFocus()) {
            this.gQs.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQs.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
        if (this.gQw.hasFocus()) {
            this.gQw.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQw.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIo() {
        if (this.gQs != null && this.gQs.getText() != null && this.gQs.getText().toString() != null && this.gQs.getPaint() != null) {
            if (this.gQs.getText().toString().length() == 0) {
                this.gQs.getPaint().setFakeBoldText(false);
            } else if (this.gQs.getText().toString().length() > 0) {
                this.gQs.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bCz = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hKA = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0141d.cp_cont_b);
        this.hKY = (TextView) findViewById(d.g.btn_image_problem);
        bIq();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gQq);
        this.hKz = (ScrollView) findViewById(d.g.write_scrollview);
        this.hKz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gQw != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gQw);
                    }
                    if (WriteActivity.this.bsp != null) {
                        WriteActivity.this.bsp.Jl();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hKW = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hKX = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hKj = (LinearLayout) findViewById(d.g.tool_view);
        this.hKj.setContentDescription("..");
        this.hKk = (LinearLayout) findViewById(d.g.title_view);
        this.gQt = findViewById(d.g.interval_view);
        this.hKC = findViewById(d.g.hot_topic_fourm_view);
        this.hKD = findViewById(d.g.hot_topic_divider);
        this.hKE = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hKF = (TextView) findViewById(d.g.change_one_tv);
        bsH();
        if (this.hKA) {
            this.hKz.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bIH();
        } else {
            this.hLe = new f(getPageContext(), this.mRootView);
            f fVar = this.hLe;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.nH(z);
        }
        bsJ();
        if (this.hKT || this.hKi) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aYe) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gQv = (LinearLayout) findViewById(d.g.post_content_container);
        this.gQv.setDrawingCacheEnabled(false);
        this.gQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.gQw.requestFocus();
                WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.fPe = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fPf = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fPh = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fPh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bdf();
            }
        });
        this.bgy.setOnFocusChangeListener(this.gQq);
        this.bgy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bsA();
                WriteActivity.this.bHE();
            }
        });
        this.hKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bIt();
        i(bIQ());
        bIv();
        bIp();
        bIM();
        bIO();
        bIk();
        bIu();
        bsG();
        bIB();
        if (this.mData.getType() == 4 && this.gQA != null && this.hKm != null) {
            this.gQA.setVisibility(8);
            this.hKm.setVisibility(8);
        }
        bsI();
        bIK();
    }

    private void bIp() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hKT || this.hKi) {
                        if (this.hKU) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.hpq != null && this.hpq.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.hpq != null && this.hpq.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.j.post_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gQs.setVisibility(0);
                    this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gQs.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hLj.setVisibility(8);
                    return;
                case 7:
                    this.gQs.setVisibility(0);
                    this.gQw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bIq() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bIr() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hKT && !this.hKi && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIz() != null) {
                bIz().setText(d);
                bIz().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fPe.setVisibility(0);
            this.fPf.setVoiceModel(voiceModel);
            this.fPf.bya();
            bsI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdf() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eZ(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fPe.setVisibility(8);
        this.fPf.aDZ();
        this.fPf.setVoiceModel(null);
        r hI = this.bsp.hI(6);
        if (hI != null && hI.bsj != null) {
            hI.bsj.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bsI();
    }

    private void bIs() {
        this.hKt = null;
        this.hKv = -1;
        this.hKx = -1;
        com.baidu.tieba.frs.ab mX = aa.awk().mX(1);
        if (mX != null) {
            this.hKt = mX.dHf;
            this.hKv = getIntent().getIntExtra("category_id", -1);
            if (this.hKt != null && !this.hKt.isEmpty() && this.hKv >= 0) {
                this.hKu = new z();
                this.hKu.dHb = 0;
                this.hKu.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hKx = this.hKu.dHb;
                this.hKw = this.hKu.name;
                for (z zVar : this.hKt) {
                    if (zVar.dHb == this.hKv) {
                        this.hKx = zVar.dHb;
                        this.hKw = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIt() {
        if (this.hKt != null && !this.hKt.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hKy = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hKy.setText(this.hKw);
            this.hKy.b(this.hKt, this.hKu, this.hKx);
            this.hKy.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        WriteActivity.this.hKy.setText(avVar.name);
                        WriteActivity.this.mData.setCategoryTo(avVar.dHb);
                        WriteActivity.this.hKx = avVar.dHb;
                        WriteActivity.this.hKy.bHw();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hKy.bHv();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIz());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIy());
                }
            });
        }
    }

    private void bIK() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hKR = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hKR.setTitle(d.j.no_disturb_start_time);
        this.hKR.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hKR);
        this.hKR.setButton(-2, getPageContext().getString(d.j.cancel), this.hKR);
        return this.hKR;
    }

    private void bIu() {
        this.hKp = (RelativeLayout) findViewById(d.g.addition_container);
        this.hKq = (TextView) findViewById(d.g.addition_create_time);
        this.hKr = (TextView) findViewById(d.g.addition_last_time);
        this.hKs = (TextView) findViewById(d.g.addition_last_content);
        if (this.hKo != null) {
            this.hKp.setVisibility(0);
            this.hKq.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hKo.getCreateTime() * 1000));
            if (this.hKo.getAlreadyCount() == 0) {
                this.hKr.setVisibility(8);
            } else {
                this.hKr.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hKo.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hKo.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hKs.setText(lastAdditionContent);
            } else {
                this.hKs.setVisibility(8);
            }
            bIy().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hKo.getAlreadyCount()), Integer.valueOf(this.hKo.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hKp.setVisibility(8);
    }

    private void bsG() {
        this.gQA = findViewById(d.g.post_prefix_layout);
        this.gQx = (TextView) findViewById(d.g.post_prefix);
        this.hKm = findViewById(d.g.prefix_divider);
        this.gQz = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gQA.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQa = 1;
            this.gQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gQx.setVisibility(0);
                    WriteActivity.this.gQA.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gQy, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.bsp.Jl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQs);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQw);
                }
            });
            this.gQz = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQz.setVisibility(0);
                this.gQx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gQx.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gQy, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.bsp.Jl();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIz());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIy());
                    }
                });
            }
            this.gQy = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gQy.a(this);
            this.gQy.setMaxHeight(l.t(getActivity(), d.e.ds510));
            this.gQy.setOutsideTouchable(true);
            this.gQy.setFocusable(true);
            this.gQy.setOnDismissListener(this);
            this.gQy.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_d));
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_cont_c);
            aj.s(this.gQx, d.C0141d.cp_bg_line_d);
            aj.c(this.gQz, d.f.icon_frs_arrow_n);
            this.gQx.setTextColor(color);
            this.hJc.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hJc.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gQy.addView(dVar);
            }
            this.gQy.setCurrentIndex(0);
            this.gQx.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gQA.setVisibility(8);
    }

    private void bIL() {
        if (this.hKT && this.mData != null) {
            this.hKW.setVisibility(0);
            this.hKX.setVisibility(0);
            this.hKl = new FeedBackModel(getPageContext());
            this.hKl.uI(this.mData.getForumName());
            this.hKl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hKW.setVisibility(8);
                        WriteActivity.this.hKX.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hKW.setVisibility(8);
                        WriteActivity.this.hKX.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hKW.a(feedBackModel.bHY(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bIv() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hKK.bFD()) {
                        WriteActivity.this.showToast(WriteActivity.this.hKK.bFF());
                        WriteActivity.this.nP(true);
                    } else if (WriteActivity.this.hHQ.bFD()) {
                        WriteActivity.this.showToast(WriteActivity.this.hHQ.bFF());
                        WriteActivity.this.nJ(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIz());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIy());
                        WriteActivity.this.bsp.Jl();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hKT) {
                                WriteActivity.this.bHF();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.s("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bIE();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bHF();
                        }
                        TiebaStatic.log(new ak("c12262").ab("obj_locate", WriteActivity.this.hpq));
                    }
                }
            }
        });
    }

    protected void bIM() {
        this.hKZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hKZ.dk(getPageContext().getString(d.j.is_save_draft)).aZ(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bIz().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bIy().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.j.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.j.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    t.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.hKZ.b(getPageContext());
    }

    protected void bsH() {
        this.hKV = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hKV.setIsRound(true);
        this.hKV.setDrawBorder(false);
        this.hKV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ec = o.ec(currentPortrait);
            this.hKV.setUrl(ec);
            this.hKV.startLoad(ec, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hKV.setVisibility(0);
        }
        this.gQs = (EditText) findViewById(d.g.post_title);
        this.gQs.setOnClickListener(this.hKN);
        this.gQs.setOnFocusChangeListener(this.gQq);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gQs.setText(this.mData.getTitle());
                this.gQs.setSelection(this.mData.getTitle().length());
            } else if (this.hKU) {
                this.gQs.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gQs.addTextChangedListener(this.hKP);
        if (!this.mData.getHaveDraft()) {
            bIr();
            this.hLz = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gQs.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gQs.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bIN() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hLF;
            private EditText rD = null;
            private TextView ry = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bsI();
                if (WriteActivity.this.hKA) {
                    this.hLF = this.rD.getSelectionStart();
                    this.rD.setSelection(this.hLF);
                    WriteActivity.this.a(this.ry, this.rD);
                }
                if (this.rD != WriteActivity.this.hLl || WriteActivity.this.hKK == null || WriteActivity.this.hKK.bFE()) {
                    if (this.rD == WriteActivity.this.hLh && WriteActivity.this.hHQ != null && !WriteActivity.this.hHQ.bFE()) {
                        WriteActivity.this.nJ(false);
                    }
                } else {
                    WriteActivity.this.nP(false);
                }
                if (WriteActivity.this.hKK != null) {
                    WriteActivity.this.hKK.nB(false);
                }
                if (WriteActivity.this.hHQ != null) {
                    WriteActivity.this.hHQ.nB(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hKA || !WriteActivity.this.hLq) {
                    if (WriteActivity.this.hKA) {
                        if (this.rD != WriteActivity.this.hLh || this.ry != WriteActivity.this.hLn) {
                            this.rD = WriteActivity.this.hLh;
                            this.ry = WriteActivity.this.hLn;
                        }
                    }
                } else if (this.rD != WriteActivity.this.hLl || this.ry != WriteActivity.this.hLm) {
                    this.rD = WriteActivity.this.hLl;
                    this.ry = WriteActivity.this.hLm;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hKA && this.hLq) {
            if (this.hLo != null) {
                this.hLl.removeTextChangedListener(this.hLo);
            }
            this.hLo = textWatcher;
        } else if (this.hKA) {
            if (this.hLp != null) {
                this.hLh.removeTextChangedListener(this.hLp);
            }
            this.hLp = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.hLh) {
            return 233L;
        }
        if (editText != this.hLl) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long i = i(editText);
            long j = i - j(editText);
            String valueOf = String.valueOf(j);
            if (i == 20) {
                if (j < 0) {
                    if (j < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(aj.getColor(d.C0141d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
                }
            } else if (j < 0) {
                if (j < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0141d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long j(EditText editText) {
        return com.baidu.tieba.write.b.a.u(editText.getText().toString().trim());
    }

    protected void bsJ() {
        this.gQw = (EditText) findViewById(d.g.post_content);
        this.gQw.setDrawingCacheEnabled(false);
        this.gQw.setOnClickListener(this.hKN);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mv().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gQw.setText(W);
            this.gQw.setSelection(W.length());
        } else if (this.mData.getType() == 2) {
            if (this.hLa) {
                if (this.hLb != null && this.hLb.length() > 0) {
                    this.gQw.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hLb}));
                    this.gQw.setSelection(this.gQw.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gQw.setText(format);
                this.gQw.setSelection(format.length());
            }
        }
        this.gQw.setOnFocusChangeListener(this.gQq);
        this.gQw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gQw.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQw.addTextChangedListener(this.hKQ);
        if (this.mData.getType() == 0) {
            this.hLB = true;
        } else {
            nS(true);
            this.hLB = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gQw.setHint(d.j.write_input_content);
        } else {
            this.gQw.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nS(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hKA) {
            bIy().setPadding(0, 0, 0, 0);
            bIy().setBackgroundDrawable(null);
            aj.t(bIy(), d.C0141d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fnR) && this.hKo == null) {
                com.baidu.adp.lib.f.c.nm().a(this.fnR, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.sh() != null && aVar.sl() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.sh(), aVar.sh().getNinePatchChunk(), aVar.sl(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bIy().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bIy(), true, WriteActivity.this.fVR);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIx() {
        int i = 5000;
        if (this.hKo != null) {
            i = 1000;
        }
        return bIy().getText() != null && bIy().getText().length() >= i;
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hKg)) {
                this.hKg = "";
                bIy().requestFocus();
                if (bIy().getText() != null && bIy().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIy().getSelectionStart();
                    editable = bIy().getText();
                }
            } else if ("from_title".equals(this.hKg)) {
                this.hKg = "";
                bIz().requestFocus();
                if (bIz().getText() != null && bIz().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIz().getSelectionStart();
                    editable = bIz().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bIy().getText().getSpans(0, bIy().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hKn == null) {
                this.hKn = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hKn.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType FO = nVar.FO();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nm().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bIy().getSelectionStart(), aVar, FO);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIy() != null && bIy().getText() != null) {
            Bitmap sh = aVar.sh();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(sh);
            int width = sh.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, sh.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bIy().getSelectionStart() - 1;
                if (bIy().getText().length() > 1 && selectionStart >= 0 && bIy().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIy().getText().insert(bIy().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIy().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIy().getText().insert(bIy().getSelectionStart(), spannableString2);
            }
            Editable text = bIy().getText();
            if (text != null) {
                this.hKI.clear();
                this.hKI.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hKI);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIy().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIy().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIy().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIy() {
        return this.hKA ? this.hLh : this.gQw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIz() {
        return this.hKA ? this.hLl : this.gQs;
    }

    protected void bIA() {
        Editable text;
        if (bIy() != null && (text = bIy().getText()) != null) {
            int selectionStart = bIy().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIy().onKeyDown(67, this.drp);
            }
            bIy().onKeyDown(67, this.drp);
            int selectionStart2 = bIy().getSelectionStart();
            if (text != null) {
                this.hKI.clear();
                this.hKI.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hKI);
                bIy().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hKT = true;
        }
    }

    private void bIO() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIP() {
        try {
            if (this.hKZ != null) {
                this.hKZ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bCz.d(null);
        this.bCz.ga(d.j.sending);
        this.bCz.bq(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bCz.bq(false);
    }

    private Boolean bIQ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.btY = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsI() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIz() != null) {
                str = bIz().getText().toString();
            }
            if (bIy() != null) {
                str2 = bIy().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gQa == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hKk.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nR(true);
                            return;
                        }
                    } else if (this.hKk.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nR(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hKk.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nR(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hKA) {
                    nR(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nR(true);
                }
            }
            if (this.mData.getType() == 4) {
                nR(l(this.hLh) && k(this.hLl));
            } else if (this.mData.getType() == 5) {
                nR(l(this.hLh));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nR(true);
            } else if (this.mData.getVideoInfo() != null) {
                nR(true);
            } else {
                nR(false);
            }
        }
    }

    public void nR(boolean z) {
        if (z) {
            aj.d(this.mPost, d.C0141d.cp_link_tip_a, d.C0141d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.e(this.mPost, d.C0141d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean k(EditText editText) {
        long j = j(editText);
        return j <= 20 && j > 0;
    }

    private boolean l(EditText editText) {
        long j = j(editText);
        if (j > 233) {
            return false;
        }
        return j > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.btU = new NewWriteModel(this);
        this.btU.b(this.buj);
        registerListener(this.hLC);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bsA();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            this.mData.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(bundle.getInt("floor_num", 0));
            this.hKT = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hKU = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hLa = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hLb = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.btS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hKo = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hKo != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hLc = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hLA = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hpq = bundle.getString("KEY_CALL_FROM");
            this.hEp = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hKT = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hKU = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hLa = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hLb = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hKo = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hKo != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hLc = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hLA = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hpq = intent.getStringExtra("KEY_CALL_FROM");
            this.hEp = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
            stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
        }
        if (this.mData.getType() == 9) {
            this.mData.setEntranceType(1);
        } else if (this.mData.getType() == 10) {
            this.mData.setEntranceType(2);
            this.mData.setType(9);
        } else if (this.mData.getType() == 0) {
            this.mData.setEntranceType(3);
        }
        this.mData.setIsUserFeedback(this.hKT);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mData.getType() == 0 || this.mData.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                t.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                t.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            t.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            t.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            t.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        this.fnR = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hKi = true;
        }
        bIs();
        try {
            this.hLr = bIW();
        } catch (Throwable th) {
            this.hLr = null;
        }
    }

    private void bIB() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hKV.setVisibility(8);
            this.hKC.setVisibility(0);
            this.hKD.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gQs.setText(com.baidu.tbadk.plugins.a.hd(uJ(this.mList.get(0).mTopicName)));
                this.gQs.setMovementMethod(com.baidu.tieba.view.e.bEL());
            }
            this.hKE.setText(this.mList.get(0).mForumName);
            this.gQs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hKG.equals(charSequence.toString())) {
                        WriteActivity.this.hKH = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString hd;
                    if (!WriteActivity.this.hKG.equals(editable.toString()) && (hd = com.baidu.tbadk.plugins.a.hd(editable.toString())) != null) {
                        WriteActivity.this.hKG = hd.toString();
                        WriteActivity.this.gQs.setText(hd);
                        if (WriteActivity.this.hKH <= WriteActivity.this.gQs.getText().length()) {
                            WriteActivity.this.gQs.setSelection(WriteActivity.this.hKH);
                        }
                    }
                }
            });
            this.hKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mData.getType() == 7) {
                        TiebaStatic.log("c12016");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicChangeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 25005, WriteActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString hd = com.baidu.tbadk.plugins.a.hd(uJ(hotTopicBussinessData.mTopicName));
            if (hd != null) {
                this.gQs.setText(hd);
            }
            this.hKE.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uJ(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String uJ;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (k.isEmpty(bIz().getText().toString()) || this.hLz || ((this.hKT || this.hKi) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.E(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.f(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            uJ = this.mData.getTitle();
                        } else {
                            uJ = uJ(str);
                        }
                        SpannableString hd = com.baidu.tbadk.plugins.a.hd(uJ);
                        if (hd != null) {
                            bIz().setText(hd);
                            bIz().setSelection(hd.length() > uJ.length() ? uJ.length() : hd.length());
                        }
                    } else {
                        SpannableString hd2 = com.baidu.tbadk.plugins.a.hd(this.mData.getTitle());
                        if (hd2 != null) {
                            bIz().setText(hd2);
                            bIz().setSelection(this.mData.getTitle().length() > hd2.length() ? hd2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bIr();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bIy().getText().toString()) || this.hKT || this.hKi) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Mv().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hKL);
                    bIy().setText(a2);
                    bIy().setSelection(a2.length());
                    if (this.hKA) {
                        a(this.hLn, this.hLh);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIV();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bIG();
                    }
                    nT(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIR();
                }
                bsI();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hKt != null) {
                    this.hKx = this.hKu.dHb;
                    this.hKw = this.hKu.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hKt.size()) {
                            break;
                        }
                        z zVar = this.hKt.get(i);
                        if (categoryTo != zVar.dHb) {
                            i++;
                        } else {
                            this.hKx = categoryTo;
                            this.hKw = zVar.name;
                            this.mData.setCategoryTo(this.hKx);
                            break;
                        }
                    }
                    if (this.hKy != null) {
                        this.hKy.setText(this.hKw);
                        this.hKy.b(this.hKt, this.hKu, this.hKx);
                    }
                }
                this.bsp.Jl();
                return;
            }
            return;
        }
        bIR();
        bIr();
    }

    private void bIR() {
        if ((!this.hKA || this.hLg != null) && this.hLf != null) {
            this.hLg.c(this.writeImagesInfo);
            aTN();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.mData.getFloor());
        bundle.putInt("floor_num", this.mData.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hLa);
        if (this.hKT) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.btS);
        if (this.hKo != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hKo));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hLc);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hpq);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hEp);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIy().getEditableText().toString();
        if (obj != null) {
            bIy().setText(TbFaceManager.Mv().a(getPageContext().getPageActivity(), obj, this.hKL));
            bIy().setSelection(bIy().getText().length());
        }
    }

    private String bIC() {
        return (bIy() == null || bIy().getText() == null) ? "" : bIy().getText().toString();
    }

    private String bID() {
        if (this.mData == null || bIz() == null || bIz().getVisibility() != 0 || bIz().getText() == null) {
            return "";
        }
        String obj = bIz().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gQa != 0 && this.mData.getType() != 4 && this.gQx != null && this.gQx.getText() != null) {
            obj = this.gQx.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uK(String str) {
        if (this.mData != null && this.hKk != null) {
            if (this.hKk.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.mData.setIsNoTitle(true);
                    this.mData.setTitle("");
                    return;
                }
                this.mData.setIsNoTitle(false);
                this.mData.setTitle(str);
                return;
            }
            this.mData.setIsNoTitle(true);
            this.mData.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHF() {
        bsA();
        this.mData.setContent(bIC());
        uK(bID());
        if (this.hKT || this.hKi) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                uK(string + this.mData.getTitle());
            }
            String str = getResources().getString(d.j.app_name) + getResources().getString(d.j.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.j.oJ()) {
                    sb.append(com.baidu.adp.lib.util.j.oR());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hKv >= 0) {
            this.mData.setCategoryFrom(this.hKv);
        }
        if (this.hKx >= 0) {
            this.mData.setCategoryTo(this.hKx);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo != null && this.writeImagesInfo.size() > 0) {
            Iterator<ImageFileInfo> it = this.writeImagesInfo.getChosedFiles().iterator();
            int i = 0;
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.isFromCamera()) {
                    i++;
                }
                i = i;
            }
            this.mData.setTakePhotoNum(i);
        }
        this.mData.setHasLocationData(this.btT != null && this.btT.ahh());
        if (this.writeImagesInfo != null) {
            this.btU.mO(this.writeImagesInfo.size() > 0);
        }
        if (!v.E(this.mList) && this.hKB != null && this.hKB.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hKB.mForumId));
            this.mData.setForumName(this.hKB.mForumName);
        }
        this.btU.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.btU.getWriteData().setVoice(this.mVoiceModel.getId());
                this.btU.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.btU.getWriteData().setVoice(null);
                this.btU.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.btU.getWriteData().setVoice(null);
            this.btU.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.btU.byc()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.btU.startPostWrite();
        }
    }

    private void o(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hKo != null) {
                i2 = this.hKo.getTotalCount();
                i = this.hKo.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.j.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        l.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    private void a(PostWriteCallBackData postWriteCallBackData, String str) {
        if (postWriteCallBackData != null) {
            sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, str, 18003)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.gQs == getCurrentFocus()) {
                    bIy().clearFocus();
                    this.gQs.requestFocus();
                    if (this.bsp != null) {
                        this.bsp.Jl();
                    }
                    ShowSoftKeyPadDelay(this.gQs);
                } else {
                    bIy().requestFocus();
                    if (this.bsp != null) {
                        this.bsp.Jl();
                    }
                    ShowSoftKeyPadDelay(this.gQw);
                }
                ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("name_show") : null;
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < stringArrayListExtra.size()) {
                            sb.append("@");
                            sb.append(stringArrayListExtra.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            bIy().getText().insert(bIy().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    t.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null && postWriteCallBackData2.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    t.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    t.b(this.mData.getForumId() + "photolive", (WriteData) null);
                    a(postWriteCallBackData2, "from_write");
                }
                j(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.FINISH_SELF, false)) {
                            finish();
                            return;
                        }
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                bIU();
                            } else {
                                ag(intent);
                            }
                        } else if (intExtra == 1) {
                            aj(intent);
                        } else {
                            af(intent);
                            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hLB) {
                            nS(true);
                            this.hLB = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hKA) {
                        C(intent);
                        bsI();
                        return;
                    }
                    ai(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.bsp.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.bsp.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.bsp.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bsI();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hKh) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hKh = false;
                            }
                            sb2.append(stringExtra);
                            gq(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hKB = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hKB);
                }
            }
        } else if (i2 == 0) {
            if (this.bsp != null && !this.bsp.Le()) {
                this.gQw.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.bsp.Jl();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    LI();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIT();
                    if (this.hLB) {
                        nS(true);
                        this.hLB = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gQs == getCurrentFocus()) {
                        bIy().clearFocus();
                        this.gQs.requestFocus();
                        if (this.bsp != null) {
                            this.bsp.Jl();
                        }
                        ShowSoftKeyPadDelay(this.gQs);
                        return;
                    }
                    bIy().requestFocus();
                    if (this.bsp != null) {
                        this.bsp.Jl();
                    }
                    ShowSoftKeyPadDelay(this.gQw);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hHQ.aw(postWriteCallBackData.getSensitiveWords());
                        this.hKK.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hHQ.bFB())) {
                            nJ(true);
                            nP(true);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.btS = String.valueOf(System.currentTimeMillis());
                    ai.a(getPageContext(), this.btS);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIT();
                    return;
                case 25004:
                    if ("from_title".equals(this.hKg)) {
                        bIz().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hKg)) {
                        bIy().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIE() {
        if ("1".equals(this.hpq)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hpq)) {
            this.mData.setCanNoForum(false);
        }
        bIF();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hpq);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bHF();
    }

    private void bIF() {
        if (this.bsp != null) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIS() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIT() {
        if (this.hKA) {
            this.hLg.c(this.writeImagesInfo);
            aTN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTN() {
        this.hLg.notifyDataSetChanged();
        this.hLf.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hLg.notifyDataSetChanged();
                WriteActivity.this.hLf.invalidateViews();
            }
        }, 550L);
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bsI();
    }

    private void af(Intent intent) {
        if (this.hKA) {
            ai(intent);
            bIT();
        } else {
            ak(intent);
        }
        bsI();
    }

    private void ai(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIT();
            nT(true);
        }
    }

    private void ag(Intent intent) {
        if (this.writeImagesInfo != null) {
            B(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void bIU() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aj(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hLd.parseJson(stringExtra);
            this.hLd.updateQuality();
            if (this.hLd.getChosedFiles() != null && this.hLd.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hLd.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hLd.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIz());
        HidenSoftKeyPad(this.mInputManager, bIy());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ak(Intent intent) {
        c(intent, true);
    }

    private void B(Intent intent) {
        this.btS = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.btS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ao(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aq(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.btS, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIV();
            bIG();
        }
        nT(true);
    }

    private void C(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bIV();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bIG();
                }
            }
            nT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIV() {
        if (this.bsp.hI(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void LI() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.btS));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nT(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hLe != null) {
            this.hLe.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dEk == null) {
            this.dEk = VoiceManager.instance();
        }
        return this.dEk;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avh() {
        this.dEk = getVoiceManager();
        this.dEk.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dFi) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXv));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hKo == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.btZ = i;
        if (this.bsp != null) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIG() {
        if (!this.hKA) {
            if (this.bsp != null) {
                this.bsp.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.bsp.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hLe != null) {
                this.hLe.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (this.bsp != null) {
            this.bsp.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hJc.size()) {
            for (int i2 = 0; i2 < this.hJc.size(); i2++) {
                this.hJc.get(i2).nD(false);
            }
            this.hJc.get(i).nD(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gQa = i;
        this.gQy.setCurrentIndex(i);
        xI(i);
        this.gQx.setText(this.mPrefixData.getPrefixs().get(i));
        bsI();
        com.baidu.adp.lib.g.g.a(this.gQy, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gQA.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes2.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.mData != null) {
            if (this.mData.getType() == 4) {
                return "a015";
            }
            if (this.mData.getType() == 5) {
                return "a016";
            }
        }
        return null;
    }

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0056a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            LD();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aT(getApplicationContext())) {
                ai.a(getPageContext(), this.btS);
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hLx && System.currentTimeMillis() - this.hLy < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hLx = false;
        }
        if (this.hKJ != null && !z) {
            this.hKJ.bfl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uL(String str) {
        if (!k.isEmpty(str) && this.hLu != null) {
            uM(str);
            this.hLu.dismiss();
        }
    }

    private void cs(Context context) {
        hLw = l.aq(context);
    }

    private void uM(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hLx = true;
        bIV();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bIG();
        }
        nT(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4300=4] */
    private static Bitmap e(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!k.isEmpty(str) && i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                bitmap = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i2, i3) * i) / Math.min(i2, i3));
            } catch (Exception e) {
                bitmap = null;
            } catch (Throwable th2) {
                bitmap = null;
                th = th2;
            }
            try {
                bitmap2 = BitmapHelper.getResizedBitmap(bitmap, i);
                if (bitmap != null && bitmap != bitmap2 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
            } catch (Exception e2) {
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                return bitmap2;
            } catch (Throwable th3) {
                th = th3;
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return bitmap2;
    }

    private File bIW() {
        Cursor query = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "bucket_display_name", "datetaken", "mime_type"}, null, null, "datetaken DESC");
        if (query == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getName();
        String name2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getName();
        try {
            query.moveToFirst();
            while (!query.isAfterLast()) {
                String string = query.getString(query.getColumnIndex("_data"));
                File file = new File(string);
                if ((currentTimeMillis - file.lastModified()) / 60000 > 1) {
                    break;
                }
                String upperCase = string.toUpperCase();
                if (upperCase.contains("DCIM/CAMERA") || upperCase.contains("DCIM/100ANDRO") || upperCase.contains("DCIM/100MEDIA") || upperCase.contains("SCREENSHOTS") || upperCase.contains(name.toUpperCase()) || upperCase.contains(name2.toUpperCase())) {
                    return file;
                }
                query.moveToNext();
            }
            return null;
        } finally {
            query.close();
        }
    }

    private void bIX() {
        if (this.hLr != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cs(getActivity());
            this.hLt = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hLr != null) {
                        WriteActivity.this.uL(WriteActivity.this.hLr.getAbsolutePath());
                    }
                }
            });
            this.hLs = (TbImageView) this.hLt.findViewById(d.g.rec_img_view);
            this.hLv = (LinearLayout) this.hLt.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hLr.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hLr.getAbsolutePath());
                Bitmap e = e(this.hLr.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (e != null) {
                    this.hLs.setImageBitmap(e);
                    this.hLs.setDrawBorder(true);
                    this.hLs.setBorderWidth(2);
                    this.hLs.setBorderColor(aj.getColor(d.C0141d.common_color_10264));
                    this.hLu = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hLu.setCanceledOnTouchOutside(true);
                    this.hLu.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hLx) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hLy = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hLu.setContentView(this.hLt);
                    this.hLu.show();
                    Window window = this.hLu.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hLw / 18) + getResources().getDimensionPixelSize(d.e.ds12);
                    attributes.width = getResources().getDimensionPixelSize(d.e.ds168);
                    attributes.height = getResources().getDimensionPixelSize(d.e.ds278);
                    window.setAttributes(attributes);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hKh = false;
            this.hKg = "";
            if ("from_content".equals(str)) {
                this.hKg = "from_content";
            } else if ("from_title".equals(str)) {
                this.hKg = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nQ(false);
            }
        }
    }

    public void Jn() {
        if (this.hKT || !v.E(this.mList)) {
            this.hKk.setVisibility(0);
            this.hKk.requestFocus();
            this.bsp.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hKk.setVisibility(8);
    }
}
