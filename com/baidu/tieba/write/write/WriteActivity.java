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
    private static int hLJ = 0;
    private com.baidu.tbadk.editortools.i bsC;
    private String bug;
    private LocationModel buh;
    private NewWriteModel bui;
    private VoiceManager dEw;
    private LinearLayout fPp;
    private PlayVoiceBntNew fPq;
    private ImageView fPs;
    private TextView gQM;
    private com.baidu.tieba.write.e gQN;
    private ImageView gQO;
    private View gQP;
    private int gQp;
    private com.baidu.tieba.write.b hId;
    private Toast hKA;
    private AdditionData hKB;
    private RelativeLayout hKC;
    private TextView hKD;
    private TextView hKE;
    private TextView hKF;
    List<z> hKG;
    z hKH;
    private int hKI;
    private String hKJ;
    private int hKK;
    private PostCategoryView hKL;
    private HotTopicBussinessData hKO;
    private View hKP;
    private View hKQ;
    private TextView hKR;
    private TextView hKS;
    private com.baidu.tieba.write.editor.d hKW;
    private com.baidu.tieba.write.b hKX;
    private LinearLayout hKw;
    private LinearLayout hKx;
    private View hKz;
    private com.baidu.tieba.view.d hLe;
    private View hLk;
    private f hLr;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hKt = "";
    private boolean hKu = false;
    private WriteData mData = null;
    private boolean hLg = false;
    private boolean hKv = false;
    private boolean hLh = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gQH = null;
    private HeadImageView hLi = null;
    private View gQI = null;
    private LinearLayout gQK = null;
    private EditText gQL = null;
    private FeedBackModel hKy = null;
    private FeedBackTopListView hLj = null;
    private ArrayList<com.baidu.tieba.write.d> hJp = new ArrayList<>();
    private String fod = null;
    private final KeyEvent drB = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View bgK = null;
    private TextView hLl = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hLm = null;
    private final Handler mHandler = new Handler();
    private boolean hLn = false;
    private String hLo = null;
    private RelativeLayout mParent = null;
    private String bum = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int bun = 0;
    private int hLp = 0;
    private WriteImagesInfo hLq = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hLs = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hLt = null;
    private ScrollView hKM = null;
    private EditText hLu = null;
    private View hLv = null;
    private View hLw = null;
    private View hLx = null;
    private EditText hLy = null;
    private TextView hLz = null;
    private TextView hLA = null;
    private TextWatcher hLB = null;
    private TextWatcher hLC = null;
    private boolean hKN = false;
    private boolean hLD = false;
    private com.baidu.tbadk.core.view.b bCM = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hLE = null;
    private TbImageView hLF = null;
    private View hLG = null;
    private Dialog hLH = null;
    private LinearLayout hLI = null;
    private boolean hLK = false;
    private long hLL = -1000;
    private boolean hLM = false;
    private String hpD = "2";
    private int hEC = 0;
    private String hLN = "";
    private String hKT = "";
    private int hKU = 0;
    private SpannableStringBuilder hKV = new SpannableStringBuilder();
    private boolean hLO = false;
    private final HttpMessageListener hLP = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.fod)) {
                    WriteActivity.this.fod = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nS(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.fod)) {
                    WriteActivity.this.fod = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.fod);
                    WriteActivity.this.nS(true);
                }
            }
        }
    };
    private TbFaceManager.a hKY = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a dFu = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXH));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXH));
        }
    };
    private final NewWriteModel.d buw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.avi();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hId.aw(null);
                WriteActivity.this.hId.nA(false);
                WriteActivity.this.hKX.aw(null);
                WriteActivity.this.hKX.nA(false);
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
                        if (!v.E(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hLN)) {
                            TiebaStatic.log(new ak("c11731").ab("obj_id", WriteActivity.this.hLN));
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
                    WriteActivity.this.hId.aw(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hKX.aw(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hId.un(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hKX.un(postWriteCallBackData.getErrorString());
                    if (!v.E(WriteActivity.this.hId.bFC())) {
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
                    writeData.setVcodeExtra(tVar.FY());
                    if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX());
                        if (WriteActivity.this.hLh) {
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
    private final LocationModel.a buu = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void LR() {
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
            if (aVar != null && !StringUtils.isNull(aVar.bxw())) {
                WriteActivity.this.b(2, true, aVar.bxw());
            } else {
                gA(null);
            }
        }
    };
    private final CustomMessageListener hdd = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.buh.mM(false);
                    WriteActivity.this.buh.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.buh.mM(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hKZ = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hLa = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIk = WriteActivity.this.bIk();
            if (bIk >= 0 && bIk < WriteActivity.this.gQL.getText().length()) {
                WriteActivity.this.gQL.setSelection(bIk);
            }
        }
    };
    private boolean hLb = true;
    private final View.OnFocusChangeListener gQF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gQH || view == WriteActivity.this.bgK || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hLb = true;
                    WriteActivity.this.bIl();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gQH);
                    if (WriteActivity.this.bsC != null) {
                        WriteActivity.this.bsC.Jm();
                    }
                } else if (view == WriteActivity.this.gQH) {
                    WriteActivity.this.gQM.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gQL && z) {
                WriteActivity.this.hLb = false;
                WriteActivity.this.bIl();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.gQL);
                if (WriteActivity.this.bsC != null) {
                    WriteActivity.this.bsC.Jm();
                }
            }
            WriteActivity.this.bIo();
        }
    };
    private TextWatcher hLc = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bsJ();
            if (WriteActivity.this.hKX != null) {
                if (!WriteActivity.this.hKX.bFF()) {
                    WriteActivity.this.nP(false);
                }
                WriteActivity.this.hKX.nB(false);
                WriteActivity.this.bIp();
            }
        }
    };
    private TextWatcher hLd = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bsJ();
            if (WriteActivity.this.hId != null) {
                if (!WriteActivity.this.hId.bFF()) {
                    WriteActivity.this.nJ(false);
                }
                WriteActivity.this.hId.nB(false);
            }
        }
    };
    private final a.InterfaceC0233a fWc = new a.InterfaceC0233a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0233a
        public void onRefresh() {
            WriteActivity.this.fod = null;
            WriteActivity.this.nS(false);
            WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
        if (bIA() != null && bIA().getVisibility() == 0 && bIA().getText() != null) {
            int selectionEnd = bIA().getSelectionEnd();
            SpannableStringBuilder b = this.hKX.b(bIA().getText());
            if (b != null) {
                this.hKX.nB(true);
                bIA().setText(b);
                if (z && this.hKX.bFD() >= 0) {
                    bIA().requestFocus();
                    bIA().setSelection(this.hKX.bFD());
                } else {
                    bIA().setSelection(selectionEnd);
                }
                this.hKX.nA(this.hKX.bFD() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        if (bIz() != null && bIz().getText() != null) {
            int selectionEnd = bIz().getSelectionEnd();
            SpannableStringBuilder b = this.hId.b(bIz().getText());
            if (b != null) {
                this.hId.nB(true);
                bIz().setText(b);
                if (z && this.hId.bFD() >= 0) {
                    bIz().requestFocus();
                    bIz().setSelection(this.hId.bFD());
                } else {
                    bIz().setSelection(selectionEnd);
                }
                this.hId.nA(this.hId.bFD() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LD() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void LE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            LF();
        } else if (this.buh.bxE()) {
            LD();
        } else {
            this.buh.mM(false);
            b(1, true, null);
            this.buh.bxC();
        }
    }

    private void LF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.buh.ahm();
                } else {
                    WriteActivity.this.buu.LR();
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
    public int bIk() {
        int selectionEnd = bIz().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIz().getText().getSpans(0, bIz().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIz().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIz().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIl() {
        if (this.bsC != null) {
            this.bsC.setBarLauncherEnabled(!this.hLb);
            this.bsC.g(true, 26);
            this.bsC.g(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hKN) {
            this.gQH.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hLx.setVisibility(8);
            } else {
                this.hLx.setVisibility(0);
            }
            a(this.hLA, this.hLu);
            a(this.hLz, this.hLy);
            bsJ();
        }
        if (this.hLg) {
            this.hLb = true;
            bIl();
            if (this.bsC != null) {
                this.bsC.Jm();
            }
            this.gQH.requestFocus();
            ShowSoftKeyPadDelay(this.gQH);
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
            bIW();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bIH();
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
        this.hKX = new com.baidu.tieba.write.b();
        this.hKX.xf(d.C0140d.cp_cont_i);
        this.hKX.xg(d.C0140d.cp_cont_h_alpha85);
        this.hId = new com.baidu.tieba.write.b();
        this.hId.xf(d.C0140d.cp_cont_i);
        this.hId.xg(d.C0140d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            xL(this.hEC);
        }
        initUI();
        bIM();
        this.buh = new LocationModel(this);
        this.buh.a(this.buu);
        registerListener(this.hdd);
        registerListener(this.hKZ);
        initEditor();
        bIY();
        if (this.hKN) {
            this.hLt.setEditorTools(this.bsC);
        } else {
            this.gQL.requestFocus();
        }
        Jo();
        bIH();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bsC = new com.baidu.tbadk.editortools.i(getActivity());
        this.bsC.setBarMaxLauCount(5);
        this.bsC.setMoreButtonAtEnd(true);
        this.bsC.setBarLauncherType(1);
        this.bsC.cf(true);
        this.bsC.cg(true);
        this.bsC.setMoreLauncherIcon(d.f.write_more);
        this.bsC.setBackgroundColorId(d.C0140d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bIK();
                break;
            default:
                bIm();
                break;
        }
        this.bsC.Ld();
        if (this.hKw != null) {
            this.hKw.addView(this.bsC);
        }
        bIn();
        this.bsC.th();
        com.baidu.tbadk.editortools.l hG = this.bsC.hG(6);
        if (hG != null && !TextUtils.isEmpty(this.bum)) {
            ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.bum);
                }
            });
        }
        if (!this.hKN) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bsC.Jm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bII() {
        this.hLv = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hLx = this.hLv.findViewById(d.g.live_post_title_container);
        this.hLu = (EditText) this.hLv.findViewById(d.g.live_post_content);
        this.hLs = (GridView) this.hLv.findViewById(d.g.photoLiveGridView);
        this.hLy = (EditText) this.hLv.findViewById(d.g.live_post_title);
        this.hLz = (TextView) this.hLv.findViewById(d.g.titleOverPlusNumber);
        this.hLA = (TextView) this.hLv.findViewById(d.g.contentOverPlusNumber);
        this.hLw = this.hLv.findViewById(d.g.live_interval_view);
        this.hLz.setText(String.valueOf(20));
        this.hLA.setText(String.valueOf(233));
        this.hLv.setVisibility(0);
        this.hLz.setVisibility(0);
        this.hLA.setVisibility(0);
        this.hLy.setHint(d.j.tips_title_limit_new);
        this.hLy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hLD = true;
                    WriteActivity.this.hLb = true;
                    WriteActivity.this.bIl();
                    if (WriteActivity.this.bsC != null) {
                        WriteActivity.this.bsC.Jm();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hLu.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hLu.setHint(d.j.live_write_input_content_update);
        }
        this.hLu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hLD = false;
                    WriteActivity.this.hLb = false;
                    WriteActivity.this.bIl();
                    if (WriteActivity.this.bsC != null) {
                        WriteActivity.this.bsC.Jm();
                    }
                }
            }
        });
        this.hLu.requestFocus();
        this.hLu.addTextChangedListener(bIO());
        this.hLy.requestFocus();
        this.hLy.addTextChangedListener(bIO());
        this.hLy.setOnClickListener(this.hLa);
        this.hLu.setOnClickListener(this.hLa);
        this.hLt = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hLs);
        this.hLt.xx(6);
        this.hLs.setAdapter((ListAdapter) this.hLt);
        View findViewById = this.hLv.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bHu() {
                WriteActivity.this.aTO();
            }
        });
        bIJ();
    }

    private void bIJ() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hLy.setText(this.mData.getTitle());
                this.hLy.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hKN) {
            bIT();
        }
        if (this.bsC.Lf()) {
            this.bsC.Jm();
        }
        xL(0);
    }

    private void xL(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hpD);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bIK() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.bsC.K(arrayList);
        r hI = this.bsC.hI(5);
        if (hI != null) {
            hI.btl = 2;
            hI.btj = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.btj = d.f.write_at;
        this.bsC.b(aVar);
        this.bsC.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bIm() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        CustomResponsedMessage runTask;
        r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.btj = d.f.write_picture;
        this.bsC.b(dVar);
        Boolean bIR = bIR();
        if (!this.hLg && bIR != null && bIR.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.byc() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), r.class)) != null && (rVar5 = (r) runTask.getData()) != null) {
            rVar5.btl = 3;
            rVar5.btj = d.f.write_recorder;
            this.bsC.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.btj = d.f.write_at;
        this.bsC.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.btl = 5;
            rVar4.btj = d.f.write_privilege;
            this.bsC.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.btl = 6;
            rVar3.btj = this.hLg ? d.f.write_location : d.f.icon_post_more_location;
            this.bsC.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.bsC.b(aVar2);
        aVar2.btj = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.bto = true;
            rVar2.btl = 9;
            rVar2.btj = 0;
            this.bsC.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), r.class);
        if (runTask5 != null && (rVar = (r) runTask5.getData()) != null) {
            rVar.bto = true;
            rVar.btl = 10;
            rVar.btj = 0;
            this.bsC.b(rVar);
        }
        if (this.hKB == null) {
            if (this.hKW == null) {
                this.hKW = new com.baidu.tieba.write.editor.d(getActivity(), this.hpD);
                this.hKW.aO(this.mData.getForumId(), this.privateThread);
            }
            this.bsC.b(this.hKW);
        }
        this.bsC.K(arrayList);
        r hI = this.bsC.hI(5);
        if (hI != null) {
            hI.btl = 1;
            hI.btj = d.f.write_emotion;
        }
    }

    private void bIn() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bIy()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bIy()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bIB();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bdg();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIW();
                        WriteActivity.this.bsJ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xM(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hKB == null) {
                            WriteActivity.this.LG();
                            return;
                        }
                        switch (WriteActivity.this.bun) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aS(pageActivity)) {
                                    WriteActivity.this.LE();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.LD();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.buh != null) {
                            WriteActivity.this.buh.mM(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.fod = null;
                        } else {
                            WriteActivity.this.fod = (String) aVar.data;
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
                            WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.bsC.Lf()) {
                                        WriteActivity.this.bsC.Jm();
                                        WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bsJ();
                        if (WriteActivity.this.gQL != null) {
                            WriteActivity.this.gQL.requestFocus();
                        }
                        WriteActivity.this.bsC.Jm();
                        WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQL);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hKu = true;
                        WriteActivity.this.nQ(true);
                        if (WriteActivity.this.bIA().isFocused()) {
                            WriteActivity.this.hKt = "from_title";
                        } else if (WriteActivity.this.bIz().isFocused()) {
                            WriteActivity.this.hKt = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hKx.setVisibility(0);
                        WriteActivity.this.hKx.requestFocus();
                        WriteActivity.this.bsJ();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hKx.hasFocus()) {
                            WriteActivity.this.gQL.requestFocus();
                            WriteActivity.this.gQL.setSelection(WriteActivity.this.gQL.getText().toString().length());
                        }
                        WriteActivity.this.hKx.setVisibility(8);
                        WriteActivity.this.bsJ();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bsC.a(16, bVar);
        this.bsC.a(14, bVar);
        this.bsC.a(24, bVar);
        this.bsC.a(3, bVar);
        this.bsC.a(10, bVar);
        this.bsC.a(11, bVar);
        this.bsC.a(12, bVar);
        this.bsC.a(13, bVar);
        this.bsC.a(15, bVar);
        this.bsC.a(18, bVar);
        this.bsC.a(20, bVar);
        this.bsC.a(25, bVar);
        this.bsC.a(27, bVar);
        this.bsC.a(29, bVar);
        this.bsC.a(43, bVar);
        this.bsC.a(45, bVar);
        this.bsC.a(53, bVar);
        this.bsC.a(48, bVar);
        this.bsC.a(46, bVar);
        this.bsC.a(49, bVar);
        this.bsC.a(47, bVar);
        this.bsC.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LG() {
        if (this.buh.ahi()) {
            if (this.buh.bxE()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bxA().getLocationData().bxw());
                return;
            }
            b(1, true, null);
            this.buh.bxC();
            return;
        }
        b(0, true, null);
    }

    protected void bsB() {
        if (this.bui != null) {
            this.bui.cancelLoadData();
        }
        if (this.hKy != null) {
            this.hKy.cancelLoadData();
        }
        if (this.buh != null) {
            this.buh.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bsB();
        bIQ();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hLr != null) {
            this.hLr.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHF() {
        if (this.mData != null && this.mData.getType() == 2 && this.hLn) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bIA().getText().toString());
            this.mData.setContent(bIz().getText().toString());
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
            if (this.gQN != null && this.gQN.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gQN, getPageContext().getPageActivity());
                return true;
            } else if (this.bsC.Lf()) {
                this.bsC.Jm();
                return true;
            } else {
                bsB();
                bHF();
                return true;
            }
        }
        if (i == 67 && (text = bIz().getText()) != null) {
            int selectionStart = bIz().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIz().onKeyDown(67, this.drB);
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
        getLayoutMode().aM(this.hLI);
        if (this.hLF != null && i == 1) {
            this.hLF.setBorderColor(aj.getColor(d.C0140d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0140d.cp_link_tip_a, 1);
        bIl();
        aj.t(this.hLv, d.C0140d.cp_bg_line_d);
        aj.t(this.gQI, d.C0140d.cp_bg_line_c);
        aj.t(this.hLw, d.C0140d.cp_bg_line_c);
        aj.t(bIA(), d.C0140d.cp_bg_line_d);
        aj.c(this.fPs, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.fod)) {
            aj.t(bIz(), d.C0140d.cp_bg_line_d);
        }
        bsJ();
        this.bsC.onChangeSkinType(i);
        if (this.hKL != null) {
            this.hKL.En();
        }
        aj.r(this.mName, d.C0140d.cp_cont_b);
        bIo();
        bIp();
        if (this.hId != null) {
            this.hId.onChangeSkinType();
        }
        if (this.hKX != null) {
            this.hKX.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIo() {
        if (this.gQH.hasFocus()) {
            this.gQH.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        } else {
            this.gQH.setHintTextColor(aj.getColor(d.C0140d.cp_cont_d));
        }
        if (this.gQL.hasFocus()) {
            this.gQL.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        } else {
            this.gQL.setHintTextColor(aj.getColor(d.C0140d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIp() {
        if (this.gQH != null && this.gQH.getText() != null && this.gQH.getText().toString() != null && this.gQH.getPaint() != null) {
            if (this.gQH.getText().toString().length() == 0) {
                this.gQH.getPaint().setFakeBoldText(false);
            } else if (this.gQH.getText().toString().length() > 0) {
                this.gQH.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bCM = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hKN = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0140d.cp_cont_b);
        this.hLl = (TextView) findViewById(d.g.btn_image_problem);
        bIr();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gQF);
        this.hKM = (ScrollView) findViewById(d.g.write_scrollview);
        this.hKM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gQL != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gQL);
                    }
                    if (WriteActivity.this.bsC != null) {
                        WriteActivity.this.bsC.Jm();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hLj = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hLk = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hKw = (LinearLayout) findViewById(d.g.tool_view);
        this.hKw.setContentDescription("..");
        this.hKx = (LinearLayout) findViewById(d.g.title_view);
        this.gQI = findViewById(d.g.interval_view);
        this.hKP = findViewById(d.g.hot_topic_fourm_view);
        this.hKQ = findViewById(d.g.hot_topic_divider);
        this.hKR = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hKS = (TextView) findViewById(d.g.change_one_tv);
        bsI();
        if (this.hKN) {
            this.hKM.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bII();
        } else {
            this.hLr = new f(getPageContext(), this.mRootView);
            f fVar = this.hLr;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.nH(z);
        }
        bsK();
        if (this.hLg || this.hKv) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aYq) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gQK = (LinearLayout) findViewById(d.g.post_content_container);
        this.gQK.setDrawingCacheEnabled(false);
        this.gQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.gQL.requestFocus();
                WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.fPp = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fPq = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fPs = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fPs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bdg();
            }
        });
        this.bgK.setOnFocusChangeListener(this.gQF);
        this.bgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bsB();
                WriteActivity.this.bHF();
            }
        });
        this.hLl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bIu();
        i(bIR());
        bIw();
        bIq();
        bIN();
        bIP();
        bIl();
        bIv();
        bsH();
        bIC();
        if (this.mData.getType() == 4 && this.gQP != null && this.hKz != null) {
            this.gQP.setVisibility(8);
            this.hKz.setVisibility(8);
        }
        bsJ();
        bIL();
    }

    private void bIq() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hLg || this.hKv) {
                        if (this.hLh) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.hpD != null && this.hpD.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.hpD != null && this.hpD.equals("2")) {
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
                    this.gQH.setVisibility(0);
                    this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gQH.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hLw.setVisibility(8);
                    return;
                case 7:
                    this.gQH.setVisibility(0);
                    this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bIr() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bIs() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hLg && !this.hKv && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIA() != null) {
                bIA().setText(d);
                bIA().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fPp.setVisibility(0);
            this.fPq.setVoiceModel(voiceModel);
            this.fPq.byb();
            bsJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdg() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eZ(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fPp.setVisibility(8);
        this.fPq.aEa();
        this.fPq.setVoiceModel(null);
        r hI = this.bsC.hI(6);
        if (hI != null && hI.bsw != null) {
            hI.bsw.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bsJ();
    }

    private void bIt() {
        this.hKG = null;
        this.hKI = -1;
        this.hKK = -1;
        com.baidu.tieba.frs.ab mX = aa.awl().mX(1);
        if (mX != null) {
            this.hKG = mX.dHr;
            this.hKI = getIntent().getIntExtra("category_id", -1);
            if (this.hKG != null && !this.hKG.isEmpty() && this.hKI >= 0) {
                this.hKH = new z();
                this.hKH.dHn = 0;
                this.hKH.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hKK = this.hKH.dHn;
                this.hKJ = this.hKH.name;
                for (z zVar : this.hKG) {
                    if (zVar.dHn == this.hKI) {
                        this.hKK = zVar.dHn;
                        this.hKJ = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIu() {
        if (this.hKG != null && !this.hKG.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hKL = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hKL.setText(this.hKJ);
            this.hKL.b(this.hKG, this.hKH, this.hKK);
            this.hKL.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        WriteActivity.this.hKL.setText(avVar.name);
                        WriteActivity.this.mData.setCategoryTo(avVar.dHn);
                        WriteActivity.this.hKK = avVar.dHn;
                        WriteActivity.this.hKL.bHx();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hKL.bHw();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIA());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIz());
                }
            });
        }
    }

    private void bIL() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hLe = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hLe.setTitle(d.j.no_disturb_start_time);
        this.hLe.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hLe);
        this.hLe.setButton(-2, getPageContext().getString(d.j.cancel), this.hLe);
        return this.hLe;
    }

    private void bIv() {
        this.hKC = (RelativeLayout) findViewById(d.g.addition_container);
        this.hKD = (TextView) findViewById(d.g.addition_create_time);
        this.hKE = (TextView) findViewById(d.g.addition_last_time);
        this.hKF = (TextView) findViewById(d.g.addition_last_content);
        if (this.hKB != null) {
            this.hKC.setVisibility(0);
            this.hKD.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hKB.getCreateTime() * 1000));
            if (this.hKB.getAlreadyCount() == 0) {
                this.hKE.setVisibility(8);
            } else {
                this.hKE.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hKB.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hKB.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hKF.setText(lastAdditionContent);
            } else {
                this.hKF.setVisibility(8);
            }
            bIz().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hKB.getAlreadyCount()), Integer.valueOf(this.hKB.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hKC.setVisibility(8);
    }

    private void bsH() {
        this.gQP = findViewById(d.g.post_prefix_layout);
        this.gQM = (TextView) findViewById(d.g.post_prefix);
        this.hKz = findViewById(d.g.prefix_divider);
        this.gQO = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gQP.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQp = 1;
            this.gQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gQM.setVisibility(0);
                    WriteActivity.this.gQP.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gQN, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.bsC.Jm();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQH);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQL);
                }
            });
            this.gQO = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQO.setVisibility(0);
                this.gQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gQM.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gQN, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.bsC.Jm();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIA());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIz());
                    }
                });
            }
            this.gQN = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gQN.a(this);
            this.gQN.setMaxHeight(l.t(getActivity(), d.e.ds510));
            this.gQN.setOutsideTouchable(true);
            this.gQN.setFocusable(true);
            this.gQN.setOnDismissListener(this);
            this.gQN.setBackgroundDrawable(aj.getDrawable(d.C0140d.cp_bg_line_d));
            int color = aj.getColor(d.C0140d.cp_cont_b);
            int color2 = aj.getColor(d.C0140d.cp_cont_c);
            aj.s(this.gQM, d.C0140d.cp_bg_line_d);
            aj.c(this.gQO, d.f.icon_frs_arrow_n);
            this.gQM.setTextColor(color);
            this.hJp.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hJp.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gQN.addView(dVar);
            }
            this.gQN.setCurrentIndex(0);
            this.gQM.setText(prefixs.get(1));
            xH(1);
            return;
        }
        this.gQP.setVisibility(8);
    }

    private void bIM() {
        if (this.hLg && this.mData != null) {
            this.hLj.setVisibility(0);
            this.hLk.setVisibility(0);
            this.hKy = new FeedBackModel(getPageContext());
            this.hKy.uI(this.mData.getForumName());
            this.hKy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hLj.setVisibility(8);
                        WriteActivity.this.hLk.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hLj.setVisibility(8);
                        WriteActivity.this.hLk.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hLj.a(feedBackModel.bHZ(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bIw() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hKX.bFE()) {
                        WriteActivity.this.showToast(WriteActivity.this.hKX.bFG());
                        WriteActivity.this.nP(true);
                    } else if (WriteActivity.this.hId.bFE()) {
                        WriteActivity.this.showToast(WriteActivity.this.hId.bFG());
                        WriteActivity.this.nJ(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIA());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIz());
                        WriteActivity.this.bsC.Jm();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hLg) {
                                WriteActivity.this.bHG();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.s("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bIF();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bHG();
                        }
                        TiebaStatic.log(new ak("c12262").ab("obj_locate", WriteActivity.this.hpD));
                    }
                }
            }
        });
    }

    protected void bIN() {
        this.hLm = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hLm.dk(getPageContext().getString(d.j.is_save_draft)).aZ(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bIA().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bIz().getText().toString());
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
        this.hLm.b(getPageContext());
    }

    protected void bsI() {
        this.hLi = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hLi.setIsRound(true);
        this.hLi.setDrawBorder(false);
        this.hLi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ec = o.ec(currentPortrait);
            this.hLi.setUrl(ec);
            this.hLi.startLoad(ec, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hLi.setVisibility(0);
        }
        this.gQH = (EditText) findViewById(d.g.post_title);
        this.gQH.setOnClickListener(this.hLa);
        this.gQH.setOnFocusChangeListener(this.gQF);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gQH.setText(this.mData.getTitle());
                this.gQH.setSelection(this.mData.getTitle().length());
            } else if (this.hLh) {
                this.gQH.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gQH.addTextChangedListener(this.hLc);
        if (!this.mData.getHaveDraft()) {
            bIs();
            this.hLM = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gQH.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gQH.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bIO() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hLS;
            private EditText rE = null;
            private TextView rz = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bsJ();
                if (WriteActivity.this.hKN) {
                    this.hLS = this.rE.getSelectionStart();
                    this.rE.setSelection(this.hLS);
                    WriteActivity.this.a(this.rz, this.rE);
                }
                if (this.rE != WriteActivity.this.hLy || WriteActivity.this.hKX == null || WriteActivity.this.hKX.bFF()) {
                    if (this.rE == WriteActivity.this.hLu && WriteActivity.this.hId != null && !WriteActivity.this.hId.bFF()) {
                        WriteActivity.this.nJ(false);
                    }
                } else {
                    WriteActivity.this.nP(false);
                }
                if (WriteActivity.this.hKX != null) {
                    WriteActivity.this.hKX.nB(false);
                }
                if (WriteActivity.this.hId != null) {
                    WriteActivity.this.hId.nB(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hKN || !WriteActivity.this.hLD) {
                    if (WriteActivity.this.hKN) {
                        if (this.rE != WriteActivity.this.hLu || this.rz != WriteActivity.this.hLA) {
                            this.rE = WriteActivity.this.hLu;
                            this.rz = WriteActivity.this.hLA;
                        }
                    }
                } else if (this.rE != WriteActivity.this.hLy || this.rz != WriteActivity.this.hLz) {
                    this.rE = WriteActivity.this.hLy;
                    this.rz = WriteActivity.this.hLz;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hKN && this.hLD) {
            if (this.hLB != null) {
                this.hLy.removeTextChangedListener(this.hLB);
            }
            this.hLB = textWatcher;
        } else if (this.hKN) {
            if (this.hLC != null) {
                this.hLu.removeTextChangedListener(this.hLC);
            }
            this.hLC = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.hLu) {
            return 233L;
        }
        if (editText != this.hLy) {
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
                    textView.setTextColor(aj.getColor(d.C0140d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
                }
            } else if (j < 0) {
                if (j < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0140d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long j(EditText editText) {
        return com.baidu.tieba.write.b.a.u(editText.getText().toString().trim());
    }

    protected void bsK() {
        this.gQL = (EditText) findViewById(d.g.post_content);
        this.gQL.setDrawingCacheEnabled(false);
        this.gQL.setOnClickListener(this.hLa);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mw().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gQL.setText(W);
            this.gQL.setSelection(W.length());
        } else if (this.mData.getType() == 2) {
            if (this.hLn) {
                if (this.hLo != null && this.hLo.length() > 0) {
                    this.gQL.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hLo}));
                    this.gQL.setSelection(this.gQL.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gQL.setText(format);
                this.gQL.setSelection(format.length());
            }
        }
        this.gQL.setOnFocusChangeListener(this.gQF);
        this.gQL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gQL.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQL.addTextChangedListener(this.hLd);
        if (this.mData.getType() == 0) {
            this.hLO = true;
        } else {
            nS(true);
            this.hLO = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gQL.setHint(d.j.write_input_content);
        } else {
            this.gQL.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nS(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hKN) {
            bIz().setPadding(0, 0, 0, 0);
            bIz().setBackgroundDrawable(null);
            aj.t(bIz(), d.C0140d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.fod) && this.hKB == null) {
                com.baidu.adp.lib.f.c.nm().a(this.fod, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.bIz().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bIz(), true, WriteActivity.this.fWc);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIy() {
        int i = 5000;
        if (this.hKB != null) {
            i = 1000;
        }
        return bIz().getText() != null && bIz().getText().length() >= i;
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hKt)) {
                this.hKt = "";
                bIz().requestFocus();
                if (bIz().getText() != null && bIz().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIz().getSelectionStart();
                    editable = bIz().getText();
                }
            } else if ("from_title".equals(this.hKt)) {
                this.hKt = "";
                bIA().requestFocus();
                if (bIA().getText() != null && bIA().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIA().getSelectionStart();
                    editable = bIA().getText();
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
        if (((ImageSpan[]) bIz().getText().getSpans(0, bIz().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hKA == null) {
                this.hKA = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hKA.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType FP = nVar.FP();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.nm().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bIz().getSelectionStart(), aVar, FP);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIz() != null && bIz().getText() != null) {
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
                int selectionStart = bIz().getSelectionStart() - 1;
                if (bIz().getText().length() > 1 && selectionStart >= 0 && bIz().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIz().getText().insert(bIz().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIz().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIz().getText().insert(bIz().getSelectionStart(), spannableString2);
            }
            Editable text = bIz().getText();
            if (text != null) {
                this.hKV.clear();
                this.hKV.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hKV);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIz().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIz().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIz().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIz() {
        return this.hKN ? this.hLu : this.gQL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIA() {
        return this.hKN ? this.hLy : this.gQH;
    }

    protected void bIB() {
        Editable text;
        if (bIz() != null && (text = bIz().getText()) != null) {
            int selectionStart = bIz().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIz().onKeyDown(67, this.drB);
            }
            bIz().onKeyDown(67, this.drB);
            int selectionStart2 = bIz().getSelectionStart();
            if (text != null) {
                this.hKV.clear();
                this.hKV.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hKV);
                bIz().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hLg = true;
        }
    }

    private void bIP() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIQ() {
        try {
            if (this.hLm != null) {
                this.hLm.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bCM.d(null);
        this.bCM.ga(d.j.sending);
        this.bCM.bq(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bCM.bq(false);
    }

    private Boolean bIR() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bum = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsJ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIA() != null) {
                str = bIA().getText().toString();
            }
            if (bIz() != null) {
                str2 = bIz().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gQp == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hKx.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nR(true);
                            return;
                        }
                    } else if (this.hKx.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nR(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hKx.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nR(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hKN) {
                    nR(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nR(true);
                }
            }
            if (this.mData.getType() == 4) {
                nR(l(this.hLu) && k(this.hLy));
            } else if (this.mData.getType() == 5) {
                nR(l(this.hLu));
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
            aj.d(this.mPost, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.e(this.mPost, d.C0140d.cp_cont_d, 1);
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
        this.bui = new NewWriteModel(this);
        this.bui.b(this.buw);
        registerListener(this.hLP);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bsB();
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
            this.hLg = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hLh = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hLn = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hLo = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.bug = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hKB = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hKB != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hLp = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hLN = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hpD = bundle.getString("KEY_CALL_FROM");
            this.hEC = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hLg = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hLh = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hLn = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hLo = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hKB = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hKB != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hLp = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hLN = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hpD = intent.getStringExtra("KEY_CALL_FROM");
            this.hEC = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hLg);
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
        this.fod = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hKv = true;
        }
        bIt();
        try {
            this.hLE = bIX();
        } catch (Throwable th) {
            this.hLE = null;
        }
    }

    private void bIC() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hLi.setVisibility(8);
            this.hKP.setVisibility(0);
            this.hKQ.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gQH.setText(com.baidu.tbadk.plugins.a.hd(uJ(this.mList.get(0).mTopicName)));
                this.gQH.setMovementMethod(com.baidu.tieba.view.e.bEM());
            }
            this.hKR.setText(this.mList.get(0).mForumName);
            this.gQH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hKT.equals(charSequence.toString())) {
                        WriteActivity.this.hKU = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString hd;
                    if (!WriteActivity.this.hKT.equals(editable.toString()) && (hd = com.baidu.tbadk.plugins.a.hd(editable.toString())) != null) {
                        WriteActivity.this.hKT = hd.toString();
                        WriteActivity.this.gQH.setText(hd);
                        if (WriteActivity.this.hKU <= WriteActivity.this.gQH.getText().length()) {
                            WriteActivity.this.gQH.setSelection(WriteActivity.this.hKU);
                        }
                    }
                }
            });
            this.hKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
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
                this.gQH.setText(hd);
            }
            this.hKR.setText(hotTopicBussinessData.mForumName);
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
                if (k.isEmpty(bIA().getText().toString()) || this.hLM || ((this.hLg || this.hKv) && !k.isEmpty(writeData.getTitle()))) {
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
                            bIA().setText(hd);
                            bIA().setSelection(hd.length() > uJ.length() ? uJ.length() : hd.length());
                        }
                    } else {
                        SpannableString hd2 = com.baidu.tbadk.plugins.a.hd(this.mData.getTitle());
                        if (hd2 != null) {
                            bIA().setText(hd2);
                            bIA().setSelection(this.mData.getTitle().length() > hd2.length() ? hd2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bIs();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bIz().getText().toString()) || this.hLg || this.hKv) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Mw().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hKY);
                    bIz().setText(a2);
                    bIz().setSelection(a2.length());
                    if (this.hKN) {
                        a(this.hLA, this.hLu);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIW();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bIH();
                    }
                    nT(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIS();
                }
                bsJ();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hKG != null) {
                    this.hKK = this.hKH.dHn;
                    this.hKJ = this.hKH.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hKG.size()) {
                            break;
                        }
                        z zVar = this.hKG.get(i);
                        if (categoryTo != zVar.dHn) {
                            i++;
                        } else {
                            this.hKK = categoryTo;
                            this.hKJ = zVar.name;
                            this.mData.setCategoryTo(this.hKK);
                            break;
                        }
                    }
                    if (this.hKL != null) {
                        this.hKL.setText(this.hKJ);
                        this.hKL.b(this.hKG, this.hKH, this.hKK);
                    }
                }
                this.bsC.Jm();
                return;
            }
            return;
        }
        bIS();
        bIs();
    }

    private void bIS() {
        if ((!this.hKN || this.hLt != null) && this.hLs != null) {
            this.hLt.c(this.writeImagesInfo);
            aTO();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hLn);
        if (this.hLg) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.bug);
        if (this.hKB != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hKB));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hLp);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hpD);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hEC);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIz().getEditableText().toString();
        if (obj != null) {
            bIz().setText(TbFaceManager.Mw().a(getPageContext().getPageActivity(), obj, this.hKY));
            bIz().setSelection(bIz().getText().length());
        }
    }

    private String bID() {
        return (bIz() == null || bIz().getText() == null) ? "" : bIz().getText().toString();
    }

    private String bIE() {
        if (this.mData == null || bIA() == null || bIA().getVisibility() != 0 || bIA().getText() == null) {
            return "";
        }
        String obj = bIA().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gQp != 0 && this.mData.getType() != 4 && this.gQM != null && this.gQM.getText() != null) {
            obj = this.gQM.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uK(String str) {
        if (this.mData != null && this.hKx != null) {
            if (this.hKx.getVisibility() == 0) {
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
    public void bHG() {
        bsB();
        this.mData.setContent(bID());
        uK(bIE());
        if (this.hLg || this.hKv) {
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
        if (this.hKI >= 0) {
            this.mData.setCategoryFrom(this.hKI);
        }
        if (this.hKK >= 0) {
            this.mData.setCategoryTo(this.hKK);
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
        this.mData.setHasLocationData(this.buh != null && this.buh.ahi());
        if (this.writeImagesInfo != null) {
            this.bui.mO(this.writeImagesInfo.size() > 0);
        }
        if (!v.E(this.mList) && this.hKO != null && this.hKO.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hKO.mForumId));
            this.mData.setForumName(this.hKO.mForumName);
        }
        this.bui.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.bui.getWriteData().setVoice(this.mVoiceModel.getId());
                this.bui.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.bui.getWriteData().setVoice(null);
                this.bui.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.bui.getWriteData().setVoice(null);
            this.bui.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.bui.byd()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.bui.startPostWrite();
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
            if (this.hKB != null) {
                i2 = this.hKB.getTotalCount();
                i = this.hKB.getAlreadyCount() + 1;
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
                if (this.gQH == getCurrentFocus()) {
                    bIz().clearFocus();
                    this.gQH.requestFocus();
                    if (this.bsC != null) {
                        this.bsC.Jm();
                    }
                    ShowSoftKeyPadDelay(this.gQH);
                } else {
                    bIz().requestFocus();
                    if (this.bsC != null) {
                        this.bsC.Jm();
                    }
                    ShowSoftKeyPadDelay(this.gQL);
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
                            bIz().getText().insert(bIz().getSelectionStart(), sb.toString());
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
                                bIV();
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
                        if (this.hLO) {
                            nS(true);
                            this.hLO = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hKN) {
                        C(intent);
                        bsJ();
                        return;
                    }
                    ai(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.bsC.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bsJ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hKu) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hKu = false;
                            }
                            sb2.append(stringExtra);
                            gq(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hKO = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hKO);
                }
            }
        } else if (i2 == 0) {
            if (this.bsC != null && !this.bsC.Lf()) {
                this.gQL.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.bsC.Jm();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    LJ();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIU();
                    if (this.hLO) {
                        nS(true);
                        this.hLO = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gQH == getCurrentFocus()) {
                        bIz().clearFocus();
                        this.gQH.requestFocus();
                        if (this.bsC != null) {
                            this.bsC.Jm();
                        }
                        ShowSoftKeyPadDelay(this.gQH);
                        return;
                    }
                    bIz().requestFocus();
                    if (this.bsC != null) {
                        this.bsC.Jm();
                    }
                    ShowSoftKeyPadDelay(this.gQL);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hId.aw(postWriteCallBackData.getSensitiveWords());
                        this.hKX.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hId.bFC())) {
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
                    this.bug = String.valueOf(System.currentTimeMillis());
                    ai.a(getPageContext(), this.bug);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIU();
                    return;
                case 25004:
                    if ("from_title".equals(this.hKt)) {
                        bIA().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hKt)) {
                        bIz().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIF() {
        if ("1".equals(this.hpD)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hpD)) {
            this.mData.setCanNoForum(false);
        }
        bIG();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hpD);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bHG();
    }

    private void bIG() {
        if (this.bsC != null) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIT() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIU() {
        if (this.hKN) {
            this.hLt.c(this.writeImagesInfo);
            aTO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTO() {
        this.hLt.notifyDataSetChanged();
        this.hLs.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hLt.notifyDataSetChanged();
                WriteActivity.this.hLs.invalidateViews();
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
        bsJ();
    }

    private void af(Intent intent) {
        if (this.hKN) {
            ai(intent);
            bIU();
        } else {
            ak(intent);
        }
        bsJ();
    }

    private void ai(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIU();
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

    private void bIV() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aj(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hLq.parseJson(stringExtra);
            this.hLq.updateQuality();
            if (this.hLq.getChosedFiles() != null && this.hLq.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hLq.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hLq.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIA());
        HidenSoftKeyPad(this.mInputManager, bIz());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ak(Intent intent) {
        c(intent, true);
    }

    private void B(Intent intent) {
        this.bug = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.bug;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ao(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aq(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.bug, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIW();
            bIH();
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
                bIW();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bIH();
                }
            }
            nT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIW() {
        if (this.bsC.hI(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void LJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.bug));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nT(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hLr != null) {
            this.hLr.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dEw == null) {
            this.dEw = VoiceManager.instance();
        }
        return this.dEw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avi() {
        this.dEw = getVoiceManager();
        this.dEw.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vQ(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dFu) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXH));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hKB == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.bun = i;
        if (this.bsC != null) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIH() {
        if (!this.hKN) {
            if (this.bsC != null) {
                this.bsC.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.bsC.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hLr != null) {
                this.hLr.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (this.bsC != null) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xH(int i) {
        if (i < this.hJp.size()) {
            for (int i2 = 0; i2 < this.hJp.size(); i2++) {
                this.hJp.get(i2).nD(false);
            }
            this.hJp.get(i).nD(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vl(int i) {
        this.gQp = i;
        this.gQN.setCurrentIndex(i);
        xH(i);
        this.gQM.setText(this.mPrefixData.getPrefixs().get(i));
        bsJ();
        com.baidu.adp.lib.g.g.a(this.gQN, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gQP.setSelected(false);
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
            LE();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aT(getApplicationContext())) {
                ai.a(getPageContext(), this.bug);
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
        if (this.hLK && System.currentTimeMillis() - this.hLL < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hLK = false;
        }
        if (this.hKW != null && !z) {
            this.hKW.bfm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uL(String str) {
        if (!k.isEmpty(str) && this.hLH != null) {
            uM(str);
            this.hLH.dismiss();
        }
    }

    private void cs(Context context) {
        hLJ = l.aq(context);
    }

    private void uM(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hLK = true;
        bIW();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bIH();
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

    private File bIX() {
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

    private void bIY() {
        if (this.hLE != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cs(getActivity());
            this.hLG = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hLE != null) {
                        WriteActivity.this.uL(WriteActivity.this.hLE.getAbsolutePath());
                    }
                }
            });
            this.hLF = (TbImageView) this.hLG.findViewById(d.g.rec_img_view);
            this.hLI = (LinearLayout) this.hLG.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hLE.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hLE.getAbsolutePath());
                Bitmap e = e(this.hLE.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (e != null) {
                    this.hLF.setImageBitmap(e);
                    this.hLF.setDrawBorder(true);
                    this.hLF.setBorderWidth(2);
                    this.hLF.setBorderColor(aj.getColor(d.C0140d.common_color_10264));
                    this.hLH = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hLH.setCanceledOnTouchOutside(true);
                    this.hLH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hLK) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hLL = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hLH.setContentView(this.hLG);
                    this.hLH.show();
                    Window window = this.hLH.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hLJ / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
            this.hKu = false;
            this.hKt = "";
            if ("from_content".equals(str)) {
                this.hKt = "from_content";
            } else if ("from_title".equals(str)) {
                this.hKt = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nQ(false);
            }
        }
    }

    public void Jo() {
        if (this.hLg || !v.E(this.mList)) {
            this.hKx.setVisibility(0);
            this.hKx.requestFocus();
            this.bsC.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hKx.setVisibility(8);
    }
}
