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
import com.baidu.tbadk.coreExtra.data.t;
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
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.u;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0056a, VoiceManager.c, u.a, e.a {
    private static int hLU = 0;
    private com.baidu.tbadk.editortools.i bss;
    private String btV;
    private LocationModel btW;
    private NewWriteModel btX;
    private VoiceManager dEn;
    private LinearLayout fPu;
    private PlayVoiceBntNew fPv;
    private ImageView fPx;
    private TextView gQN;
    private com.baidu.tieba.write.e gQO;
    private ImageView gQP;
    private View gQQ;
    private int gQq;
    private com.baidu.tieba.write.b hIo;
    private LinearLayout hKH;
    private LinearLayout hKI;
    private View hKK;
    private Toast hKL;
    private AdditionData hKM;
    private RelativeLayout hKN;
    private TextView hKO;
    private TextView hKP;
    private TextView hKQ;
    List<z> hKR;
    z hKS;
    private int hKT;
    private String hKU;
    private int hKV;
    private PostCategoryView hKW;
    private HotTopicBussinessData hKZ;
    private f hLC;
    private View hLa;
    private View hLb;
    private TextView hLc;
    private TextView hLd;
    private com.baidu.tieba.write.editor.d hLh;
    private com.baidu.tieba.write.b hLi;
    private com.baidu.tieba.view.d hLp;
    private View hLv;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hKE = "";
    private boolean hKF = false;
    private WriteData mData = null;
    private boolean hLr = false;
    private boolean hKG = false;
    private boolean hLs = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gQI = null;
    private HeadImageView hLt = null;
    private View gQJ = null;
    private LinearLayout gQL = null;
    private EditText gQM = null;
    private FeedBackModel hKJ = null;
    private FeedBackTopListView hLu = null;
    private ArrayList<com.baidu.tieba.write.d> hJA = new ArrayList<>();
    private String foh = null;
    private final KeyEvent drs = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View bgB = null;
    private TextView hLw = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hLx = null;
    private final Handler mHandler = new Handler();
    private boolean hLy = false;
    private String hLz = null;
    private RelativeLayout mParent = null;
    private String bub = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int buc = 0;
    private int hLA = 0;
    private WriteImagesInfo hLB = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hLD = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hLE = null;
    private ScrollView hKX = null;
    private EditText hLF = null;
    private View hLG = null;
    private View hLH = null;
    private View hLI = null;
    private EditText hLJ = null;
    private TextView hLK = null;
    private TextView hLL = null;
    private TextWatcher hLM = null;
    private TextWatcher hLN = null;
    private boolean hKY = false;
    private boolean hLO = false;
    private com.baidu.tbadk.core.view.b bCC = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hLP = null;
    private TbImageView hLQ = null;
    private View hLR = null;
    private Dialog hLS = null;
    private LinearLayout hLT = null;
    private boolean hLV = false;
    private long hLW = -1000;
    private boolean hLX = false;
    private String hpO = "2";
    private int hEN = 0;
    private String hLY = "";
    private String hLe = "";
    private int hLf = 0;
    private SpannableStringBuilder hLg = new SpannableStringBuilder();
    private boolean hLZ = false;
    private final HttpMessageListener hMa = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.foh)) {
                    WriteActivity.this.foh = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nX(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.foh)) {
                    WriteActivity.this.foh = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.foh);
                    WriteActivity.this.nX(true);
                }
            }
        }
    };
    private TbFaceManager.a hLj = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
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
    private final AntiHelper.a dFl = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXx));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXx));
        }
    };
    private final NewWriteModel.d bum = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.avi();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hIo.aw(null);
                WriteActivity.this.hIo.nF(false);
                WriteActivity.this.hLi.aw(null);
                WriteActivity.this.hLi.nF(false);
                if (z) {
                    WriteActivity.this.cn(z);
                    if (WriteActivity.this.d(writeData)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                u.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                u.b(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                u.c(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            u.b("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            u.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.E(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hLY)) {
                            TiebaStatic.log(new ak("c11731").ab("obj_id", WriteActivity.this.hLY));
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
                    WriteActivity.this.hIo.aw(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hLi.aw(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hIo.un(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hLi.un(postWriteCallBackData.getErrorString());
                    if (!v.E(WriteActivity.this.hIo.bFG())) {
                        WriteActivity.this.nO(true);
                        WriteActivity.this.nU(true);
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
                        if (WriteActivity.this.hLs) {
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
    private final LocationModel.a buk = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
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
            if (aVar != null && !StringUtils.isNull(aVar.bxA())) {
                WriteActivity.this.b(2, true, aVar.bxA());
            } else {
                gA(null);
            }
        }
    };
    private final CustomMessageListener hdm = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.btW.mR(false);
                    WriteActivity.this.btW.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.btW.mR(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hLk = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hLl = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIo = WriteActivity.this.bIo();
            if (bIo >= 0 && bIo < WriteActivity.this.gQM.getText().length()) {
                WriteActivity.this.gQM.setSelection(bIo);
            }
        }
    };
    private boolean hLm = true;
    private final View.OnFocusChangeListener gQG = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gQI || view == WriteActivity.this.bgB || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hLm = true;
                    WriteActivity.this.bIp();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gQI);
                    if (WriteActivity.this.bss != null) {
                        WriteActivity.this.bss.Jm();
                    }
                } else if (view == WriteActivity.this.gQI) {
                    WriteActivity.this.gQN.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gQM && z) {
                WriteActivity.this.hLm = false;
                WriteActivity.this.bIp();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.gQM);
                if (WriteActivity.this.bss != null) {
                    WriteActivity.this.bss.Jm();
                }
            }
            WriteActivity.this.bIs();
        }
    };
    private TextWatcher hLn = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
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
            if (WriteActivity.this.hLi != null) {
                if (!WriteActivity.this.hLi.bFJ()) {
                    WriteActivity.this.nU(false);
                }
                WriteActivity.this.hLi.nG(false);
                WriteActivity.this.bIt();
            }
        }
    };
    private TextWatcher hLo = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
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
            if (WriteActivity.this.hIo != null) {
                if (!WriteActivity.this.hIo.bFJ()) {
                    WriteActivity.this.nO(false);
                }
                WriteActivity.this.hIo.nG(false);
            }
        }
    };
    private final a.InterfaceC0234a fWh = new a.InterfaceC0234a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
            WriteActivity.this.foh = null;
            WriteActivity.this.nX(false);
            WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void nU(boolean z) {
        if (bIE() != null && bIE().getVisibility() == 0 && bIE().getText() != null) {
            int selectionEnd = bIE().getSelectionEnd();
            SpannableStringBuilder b = this.hLi.b(bIE().getText());
            if (b != null) {
                this.hLi.nG(true);
                bIE().setText(b);
                if (z && this.hLi.bFH() >= 0) {
                    bIE().requestFocus();
                    bIE().setSelection(this.hLi.bFH());
                } else {
                    bIE().setSelection(selectionEnd);
                }
                this.hLi.nF(this.hLi.bFH() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nO(boolean z) {
        if (bID() != null && bID().getText() != null) {
            int selectionEnd = bID().getSelectionEnd();
            SpannableStringBuilder b = this.hIo.b(bID().getText());
            if (b != null) {
                this.hIo.nG(true);
                bID().setText(b);
                if (z && this.hIo.bFH() >= 0) {
                    bID().requestFocus();
                    bID().setSelection(this.hIo.bFH());
                } else {
                    bID().setSelection(selectionEnd);
                }
                this.hIo.nF(this.hIo.bFH() >= 0);
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
        } else if (this.btW.bxI()) {
            LD();
        } else {
            this.btW.mR(false);
            b(1, true, null);
            this.btW.bxG();
        }
    }

    private void LF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.btW.ahm();
                } else {
                    WriteActivity.this.buk.LR();
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
        aVar.AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIo() {
        int selectionEnd = bID().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bID().getText().getSpans(0, bID().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bID().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bID().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIp() {
        if (this.bss != null) {
            this.bss.setBarLauncherEnabled(!this.hLm);
            this.bss.g(true, 26);
            this.bss.g(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hKY) {
            this.gQI.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hLI.setVisibility(8);
            } else {
                this.hLI.setVisibility(0);
            }
            a(this.hLL, this.hLF);
            a(this.hLK, this.hLJ);
            bsJ();
        }
        if (this.hLr) {
            this.hLm = true;
            bIp();
            if (this.bss != null) {
                this.bss.Jm();
            }
            this.gQI.requestFocus();
            ShowSoftKeyPadDelay(this.gQI);
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
            bJa();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bIL();
            }
            nY(true);
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
        this.hLi = new com.baidu.tieba.write.b();
        this.hLi.xg(d.C0141d.cp_cont_i);
        this.hLi.xh(d.C0141d.cp_cont_h_alpha85);
        this.hIo = new com.baidu.tieba.write.b();
        this.hIo.xg(d.C0141d.cp_cont_i);
        this.hIo.xh(d.C0141d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            xM(this.hEN);
        }
        initUI();
        bIQ();
        this.btW = new LocationModel(this);
        this.btW.a(this.buk);
        registerListener(this.hdm);
        registerListener(this.hLk);
        initEditor();
        bJc();
        if (this.hKY) {
            this.hLE.setEditorTools(this.bss);
        } else {
            this.gQM.requestFocus();
        }
        Jo();
        bIL();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bss = new com.baidu.tbadk.editortools.i(getActivity());
        this.bss.setBarMaxLauCount(5);
        this.bss.setMoreButtonAtEnd(true);
        this.bss.setBarLauncherType(1);
        this.bss.cf(true);
        this.bss.cg(true);
        this.bss.setMoreLauncherIcon(d.f.write_more);
        this.bss.setBackgroundColorId(d.C0141d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bIO();
                break;
            default:
                bIq();
                break;
        }
        this.bss.Ld();
        if (this.hKH != null) {
            this.hKH.addView(this.bss);
        }
        bIr();
        this.bss.th();
        com.baidu.tbadk.editortools.l hG = this.bss.hG(6);
        if (hG != null && !TextUtils.isEmpty(this.bub)) {
            ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.bub);
                }
            });
        }
        if (!this.hKY) {
            this.bss.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.bss.Jm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.bss.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bIM() {
        this.hLG = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hLI = this.hLG.findViewById(d.g.live_post_title_container);
        this.hLF = (EditText) this.hLG.findViewById(d.g.live_post_content);
        this.hLD = (GridView) this.hLG.findViewById(d.g.photoLiveGridView);
        this.hLJ = (EditText) this.hLG.findViewById(d.g.live_post_title);
        this.hLK = (TextView) this.hLG.findViewById(d.g.titleOverPlusNumber);
        this.hLL = (TextView) this.hLG.findViewById(d.g.contentOverPlusNumber);
        this.hLH = this.hLG.findViewById(d.g.live_interval_view);
        this.hLK.setText(String.valueOf(20));
        this.hLL.setText(String.valueOf(233));
        this.hLG.setVisibility(0);
        this.hLK.setVisibility(0);
        this.hLL.setVisibility(0);
        this.hLJ.setHint(d.j.tips_title_limit_new);
        this.hLJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hLO = true;
                    WriteActivity.this.hLm = true;
                    WriteActivity.this.bIp();
                    if (WriteActivity.this.bss != null) {
                        WriteActivity.this.bss.Jm();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hLF.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hLF.setHint(d.j.live_write_input_content_update);
        }
        this.hLF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hLO = false;
                    WriteActivity.this.hLm = false;
                    WriteActivity.this.bIp();
                    if (WriteActivity.this.bss != null) {
                        WriteActivity.this.bss.Jm();
                    }
                }
            }
        });
        this.hLF.requestFocus();
        this.hLF.addTextChangedListener(bIS());
        this.hLJ.requestFocus();
        this.hLJ.addTextChangedListener(bIS());
        this.hLJ.setOnClickListener(this.hLl);
        this.hLF.setOnClickListener(this.hLl);
        this.hLE = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hLD);
        this.hLE.xy(6);
        this.hLD.setAdapter((ListAdapter) this.hLE);
        View findViewById = this.hLG.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bHy() {
                WriteActivity.this.aTO();
            }
        });
        bIN();
    }

    private void bIN() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hLJ.setText(this.mData.getTitle());
                this.hLJ.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hKY) {
            bIX();
        }
        if (this.bss.Lf()) {
            this.bss.Jm();
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
            albumActivityConfig.setCallFrom(this.hpO);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bIO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.bss.K(arrayList);
        r hI = this.bss.hI(5);
        if (hI != null) {
            hI.btb = 2;
            hI.bsZ = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.bsZ = d.f.write_at;
        this.bss.b(aVar);
        this.bss.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bIq() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        CustomResponsedMessage runTask;
        r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.bsZ = d.f.write_picture;
        this.bss.b(dVar);
        Boolean bIV = bIV();
        if (!this.hLr && bIV != null && bIV.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.byg() && q.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), r.class)) != null && (rVar5 = (r) runTask.getData()) != null) {
            rVar5.btb = 3;
            rVar5.bsZ = d.f.write_recorder;
            this.bss.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.bsZ = d.f.write_at;
        this.bss.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.btb = 5;
            rVar4.bsZ = d.f.write_privilege;
            this.bss.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.btb = 6;
            rVar3.bsZ = this.hLr ? d.f.write_location : d.f.icon_post_more_location;
            this.bss.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.bss.b(aVar2);
        aVar2.bsZ = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.btd = true;
            rVar2.btb = 9;
            rVar2.bsZ = 0;
            this.bss.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), r.class);
        if (runTask5 != null && (rVar = (r) runTask5.getData()) != null) {
            rVar.btd = true;
            rVar.btb = 10;
            rVar.bsZ = 0;
            this.bss.b(rVar);
        }
        if (this.hKM == null) {
            if (this.hLh == null) {
                this.hLh = new com.baidu.tieba.write.editor.d(getActivity(), this.hpO);
                this.hLh.aO(this.mData.getForumId(), this.privateThread);
            }
            this.bss.b(this.hLh);
        }
        this.bss.K(arrayList);
        r hI = this.bss.hI(5);
        if (hI != null) {
            hI.btb = 1;
            hI.bsZ = d.f.write_emotion;
        }
    }

    private void bIr() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bIC()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bIC()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bIF();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bdg();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bJa();
                        WriteActivity.this.bsJ();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.xN(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hKM == null) {
                            WriteActivity.this.LG();
                            return;
                        }
                        switch (WriteActivity.this.buc) {
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
                        if (WriteActivity.this.btW != null) {
                            WriteActivity.this.btW.mR(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.foh = null;
                        } else {
                            WriteActivity.this.foh = (String) aVar.data;
                        }
                        WriteActivity.this.nX(false);
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
                            WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.bss.Lf()) {
                                        WriteActivity.this.bss.Jm();
                                        WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bsJ();
                        if (WriteActivity.this.gQM != null) {
                            WriteActivity.this.gQM.requestFocus();
                        }
                        WriteActivity.this.bss.Jm();
                        WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQM);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").s("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hKF = true;
                        WriteActivity.this.nV(true);
                        if (WriteActivity.this.bIE().isFocused()) {
                            WriteActivity.this.hKE = "from_title";
                        } else if (WriteActivity.this.bID().isFocused()) {
                            WriteActivity.this.hKE = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hKI.setVisibility(0);
                        WriteActivity.this.hKI.requestFocus();
                        WriteActivity.this.bsJ();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hKI.hasFocus()) {
                            WriteActivity.this.gQM.requestFocus();
                            WriteActivity.this.gQM.setSelection(WriteActivity.this.gQM.getText().toString().length());
                        }
                        WriteActivity.this.hKI.setVisibility(8);
                        WriteActivity.this.bsJ();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bss.a(16, bVar);
        this.bss.a(14, bVar);
        this.bss.a(24, bVar);
        this.bss.a(3, bVar);
        this.bss.a(10, bVar);
        this.bss.a(11, bVar);
        this.bss.a(12, bVar);
        this.bss.a(13, bVar);
        this.bss.a(15, bVar);
        this.bss.a(18, bVar);
        this.bss.a(20, bVar);
        this.bss.a(25, bVar);
        this.bss.a(27, bVar);
        this.bss.a(29, bVar);
        this.bss.a(43, bVar);
        this.bss.a(45, bVar);
        this.bss.a(53, bVar);
        this.bss.a(48, bVar);
        this.bss.a(46, bVar);
        this.bss.a(49, bVar);
        this.bss.a(47, bVar);
        this.bss.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LG() {
        if (this.btW.ahi()) {
            if (this.btW.bxI()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bxE().getLocationData().bxA());
                return;
            }
            b(1, true, null);
            this.btW.bxG();
            return;
        }
        b(0, true, null);
    }

    protected void bsB() {
        if (this.btX != null) {
            this.btX.cancelLoadData();
        }
        if (this.hKJ != null) {
            this.hKJ.cancelLoadData();
        }
        if (this.btW != null) {
            this.btW.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bsB();
        bIU();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hLC != null) {
            this.hLC.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHJ() {
        if (this.mData != null && this.mData.getType() == 2 && this.hLy) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bIE().getText().toString());
            this.mData.setContent(bID().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    u.b(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    u.b("24591571", this.mData);
                }
            } else if (type == 1) {
                u.c(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                u.b(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                u.c(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gQO != null && this.gQO.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gQO, getPageContext().getPageActivity());
                return true;
            } else if (this.bss.Lf()) {
                this.bss.Jm();
                return true;
            } else {
                bsB();
                bHJ();
                return true;
            }
        }
        if (i == 67 && (text = bID().getText()) != null) {
            int selectionStart = bID().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bID().onKeyDown(67, this.drs);
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
        getLayoutMode().aM(this.hLT);
        if (this.hLQ != null && i == 1) {
            this.hLQ.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0141d.cp_link_tip_a, 1);
        bIp();
        aj.t(this.hLG, d.C0141d.cp_bg_line_d);
        aj.t(this.gQJ, d.C0141d.cp_bg_line_c);
        aj.t(this.hLH, d.C0141d.cp_bg_line_c);
        aj.t(bIE(), d.C0141d.cp_bg_line_d);
        aj.c(this.fPx, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.foh)) {
            aj.t(bID(), d.C0141d.cp_bg_line_d);
        }
        bsJ();
        this.bss.onChangeSkinType(i);
        if (this.hKW != null) {
            this.hKW.En();
        }
        aj.r(this.mName, d.C0141d.cp_cont_b);
        bIs();
        bIt();
        if (this.hIo != null) {
            this.hIo.onChangeSkinType();
        }
        if (this.hLi != null) {
            this.hLi.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIs() {
        if (this.gQI.hasFocus()) {
            this.gQI.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQI.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
        if (this.gQM.hasFocus()) {
            this.gQM.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        } else {
            this.gQM.setHintTextColor(aj.getColor(d.C0141d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIt() {
        if (this.gQI != null && this.gQI.getText() != null && this.gQI.getText().toString() != null && this.gQI.getPaint() != null) {
            if (this.gQI.getText().toString().length() == 0) {
                this.gQI.getPaint().setFakeBoldText(false);
            } else if (this.gQI.getText().toString().length() > 0) {
                this.gQI.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.bCC = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hKY = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.r(this.mName, d.C0141d.cp_cont_b);
        this.hLw = (TextView) findViewById(d.g.btn_image_problem);
        bIv();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gQG);
        this.hKX = (ScrollView) findViewById(d.g.write_scrollview);
        this.hKX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gQM != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gQM);
                    }
                    if (WriteActivity.this.bss != null) {
                        WriteActivity.this.bss.Jm();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hLu = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hLv = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hKH = (LinearLayout) findViewById(d.g.tool_view);
        this.hKH.setContentDescription("..");
        this.hKI = (LinearLayout) findViewById(d.g.title_view);
        this.gQJ = findViewById(d.g.interval_view);
        this.hLa = findViewById(d.g.hot_topic_fourm_view);
        this.hLb = findViewById(d.g.hot_topic_divider);
        this.hLc = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hLd = (TextView) findViewById(d.g.change_one_tv);
        bsI();
        if (this.hKY) {
            this.hKX.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bIM();
        } else {
            this.hLC = new f(getPageContext(), this.mRootView);
            f fVar = this.hLC;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.nM(z);
        }
        bsK();
        if (this.hLr || this.hKG) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aYg) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gQL = (LinearLayout) findViewById(d.g.post_content_container);
        this.gQL.setDrawingCacheEnabled(false);
        this.gQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.gQM.requestFocus();
                WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.fPu = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fPv = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fPx = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bdg();
            }
        });
        this.bgB.setOnFocusChangeListener(this.gQG);
        this.bgB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bsB();
                WriteActivity.this.bHJ();
            }
        });
        this.hLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bIy();
        i(bIV());
        bIA();
        bIu();
        bIR();
        bIT();
        bIp();
        bIz();
        bsH();
        bIG();
        if (this.mData.getType() == 4 && this.gQQ != null && this.hKK != null) {
            this.gQQ.setVisibility(8);
            this.hKK.setVisibility(8);
        }
        bsJ();
        bIP();
    }

    private void bIu() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hLr || this.hKG) {
                        if (this.hLs) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.hpO != null && this.hpO.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.hpO != null && this.hpO.equals("2")) {
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
                    this.gQI.setVisibility(0);
                    this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gQI.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hLH.setVisibility(8);
                    return;
                case 7:
                    this.gQI.setVisibility(0);
                    this.gQM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bIv() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bIw() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hLr && !this.hKG && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIE() != null) {
                bIE().setText(d);
                bIE().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fPu.setVisibility(0);
            this.fPv.setVoiceModel(voiceModel);
            this.fPv.byf();
            bsJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdg() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eZ(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fPu.setVisibility(8);
        this.fPv.aEa();
        this.fPv.setVoiceModel(null);
        r hI = this.bss.hI(6);
        if (hI != null && hI.bsm != null) {
            hI.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bsJ();
    }

    private void bIx() {
        this.hKR = null;
        this.hKT = -1;
        this.hKV = -1;
        com.baidu.tieba.frs.ab mX = aa.awm().mX(1);
        if (mX != null) {
            this.hKR = mX.dHk;
            this.hKT = getIntent().getIntExtra("category_id", -1);
            if (this.hKR != null && !this.hKR.isEmpty() && this.hKT >= 0) {
                this.hKS = new z();
                this.hKS.dHg = 0;
                this.hKS.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hKV = this.hKS.dHg;
                this.hKU = this.hKS.name;
                for (z zVar : this.hKR) {
                    if (zVar.dHg == this.hKT) {
                        this.hKV = zVar.dHg;
                        this.hKU = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIy() {
        if (this.hKR != null && !this.hKR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hKW = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hKW.setText(this.hKU);
            this.hKW.b(this.hKR, this.hKS, this.hKV);
            this.hKW.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        WriteActivity.this.hKW.setText(avVar.name);
                        WriteActivity.this.mData.setCategoryTo(avVar.dHg);
                        WriteActivity.this.hKV = avVar.dHg;
                        WriteActivity.this.hKW.bHB();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hKW.bHA();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIE());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bID());
                }
            });
        }
    }

    private void bIP() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hLp = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hLp.setTitle(d.j.no_disturb_start_time);
        this.hLp.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hLp);
        this.hLp.setButton(-2, getPageContext().getString(d.j.cancel), this.hLp);
        return this.hLp;
    }

    private void bIz() {
        this.hKN = (RelativeLayout) findViewById(d.g.addition_container);
        this.hKO = (TextView) findViewById(d.g.addition_create_time);
        this.hKP = (TextView) findViewById(d.g.addition_last_time);
        this.hKQ = (TextView) findViewById(d.g.addition_last_content);
        if (this.hKM != null) {
            this.hKN.setVisibility(0);
            this.hKO.setText(getPageContext().getString(d.j.write_addition_create) + am.z(this.hKM.getCreateTime() * 1000));
            if (this.hKM.getAlreadyCount() == 0) {
                this.hKP.setVisibility(8);
            } else {
                this.hKP.setText(getPageContext().getString(d.j.write_addition_last) + am.z(this.hKM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hKM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hKQ.setText(lastAdditionContent);
            } else {
                this.hKQ.setVisibility(8);
            }
            bID().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hKM.getAlreadyCount()), Integer.valueOf(this.hKM.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hKN.setVisibility(8);
    }

    private void bsH() {
        this.gQQ = findViewById(d.g.post_prefix_layout);
        this.gQN = (TextView) findViewById(d.g.post_prefix);
        this.hKK = findViewById(d.g.prefix_divider);
        this.gQP = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gQQ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gQq = 1;
            this.gQQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gQN.setVisibility(0);
                    WriteActivity.this.gQQ.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gQO, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.bss.Jm();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQI);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gQM);
                }
            });
            this.gQP = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQP.setVisibility(0);
                this.gQN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gQN.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gQO, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.bss.Jm();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIE());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bID());
                    }
                });
            }
            this.gQO = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gQO.a(this);
            this.gQO.setMaxHeight(l.t(getActivity(), d.e.ds510));
            this.gQO.setOutsideTouchable(true);
            this.gQO.setFocusable(true);
            this.gQO.setOnDismissListener(this);
            this.gQO.setBackgroundDrawable(aj.getDrawable(d.C0141d.cp_bg_line_d));
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_cont_c);
            aj.s(this.gQN, d.C0141d.cp_bg_line_d);
            aj.c(this.gQP, d.f.icon_frs_arrow_n);
            this.gQN.setTextColor(color);
            this.hJA.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hJA.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gQO.addView(dVar);
            }
            this.gQO.setCurrentIndex(0);
            this.gQN.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.gQQ.setVisibility(8);
    }

    private void bIQ() {
        if (this.hLr && this.mData != null) {
            this.hLu.setVisibility(0);
            this.hLv.setVisibility(0);
            this.hKJ = new FeedBackModel(getPageContext());
            this.hKJ.uI(this.mData.getForumName());
            this.hKJ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hLu.setVisibility(8);
                        WriteActivity.this.hLv.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hLu.setVisibility(8);
                        WriteActivity.this.hLv.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hLu.a(feedBackModel.bId(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bIA() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hLi.bFI()) {
                        WriteActivity.this.showToast(WriteActivity.this.hLi.bFK());
                        WriteActivity.this.nU(true);
                    } else if (WriteActivity.this.hIo.bFI()) {
                        WriteActivity.this.showToast(WriteActivity.this.hIo.bFK());
                        WriteActivity.this.nO(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIE());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bID());
                        WriteActivity.this.bss.Jm();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hLr) {
                                WriteActivity.this.bHK();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.s("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bIJ();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bHK();
                        }
                        TiebaStatic.log(new ak("c12262").ab("obj_locate", WriteActivity.this.hpO));
                    }
                }
            }
        });
    }

    protected void bIR() {
        this.hLx = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hLx.dk(getPageContext().getString(d.j.is_save_draft)).aZ(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bIE().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bID().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    u.b(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    u.c(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
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
                    u.b(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    u.c(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.hLx.b(getPageContext());
    }

    protected void bsI() {
        this.hLt = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hLt.setIsRound(true);
        this.hLt.setDrawBorder(false);
        this.hLt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ec = o.ec(currentPortrait);
            this.hLt.setUrl(ec);
            this.hLt.startLoad(ec, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hLt.setVisibility(0);
        }
        this.gQI = (EditText) findViewById(d.g.post_title);
        this.gQI.setOnClickListener(this.hLl);
        this.gQI.setOnFocusChangeListener(this.gQG);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gQI.setText(this.mData.getTitle());
                this.gQI.setSelection(this.mData.getTitle().length());
            } else if (this.hLs) {
                this.gQI.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gQI.addTextChangedListener(this.hLn);
        if (!this.mData.getHaveDraft()) {
            bIw();
            this.hLX = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gQI.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gQI.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bIS() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hMd;
            private EditText rD = null;
            private TextView ry = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bsJ();
                if (WriteActivity.this.hKY) {
                    this.hMd = this.rD.getSelectionStart();
                    this.rD.setSelection(this.hMd);
                    WriteActivity.this.a(this.ry, this.rD);
                }
                if (this.rD != WriteActivity.this.hLJ || WriteActivity.this.hLi == null || WriteActivity.this.hLi.bFJ()) {
                    if (this.rD == WriteActivity.this.hLF && WriteActivity.this.hIo != null && !WriteActivity.this.hIo.bFJ()) {
                        WriteActivity.this.nO(false);
                    }
                } else {
                    WriteActivity.this.nU(false);
                }
                if (WriteActivity.this.hLi != null) {
                    WriteActivity.this.hLi.nG(false);
                }
                if (WriteActivity.this.hIo != null) {
                    WriteActivity.this.hIo.nG(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hKY || !WriteActivity.this.hLO) {
                    if (WriteActivity.this.hKY) {
                        if (this.rD != WriteActivity.this.hLF || this.ry != WriteActivity.this.hLL) {
                            this.rD = WriteActivity.this.hLF;
                            this.ry = WriteActivity.this.hLL;
                        }
                    }
                } else if (this.rD != WriteActivity.this.hLJ || this.ry != WriteActivity.this.hLK) {
                    this.rD = WriteActivity.this.hLJ;
                    this.ry = WriteActivity.this.hLK;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hKY && this.hLO) {
            if (this.hLM != null) {
                this.hLJ.removeTextChangedListener(this.hLM);
            }
            this.hLM = textWatcher;
        } else if (this.hKY) {
            if (this.hLN != null) {
                this.hLF.removeTextChangedListener(this.hLN);
            }
            this.hLN = textWatcher;
        }
        return textWatcher;
    }

    private long i(EditText editText) {
        if (editText == this.hLF) {
            return 233L;
        }
        if (editText != this.hLJ) {
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

    protected void bsK() {
        this.gQM = (EditText) findViewById(d.g.post_content);
        this.gQM.setDrawingCacheEnabled(false);
        this.gQM.setOnClickListener(this.hLl);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mw().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gQM.setText(W);
            this.gQM.setSelection(W.length());
        } else if (this.mData.getType() == 2) {
            if (this.hLy) {
                if (this.hLz != null && this.hLz.length() > 0) {
                    this.gQM.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hLz}));
                    this.gQM.setSelection(this.gQM.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gQM.setText(format);
                this.gQM.setSelection(format.length());
            }
        }
        this.gQM.setOnFocusChangeListener(this.gQG);
        this.gQM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gQM.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQM.addTextChangedListener(this.hLo);
        if (this.mData.getType() == 0) {
            this.hLZ = true;
        } else {
            nX(true);
            this.hLZ = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gQM.setHint(d.j.write_input_content);
        } else {
            this.gQM.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nX(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hKY) {
            bID().setPadding(0, 0, 0, 0);
            bID().setBackgroundDrawable(null);
            aj.t(bID(), d.C0141d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.foh) && this.hKM == null) {
                com.baidu.adp.lib.f.c.nm().a(this.foh, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.bID().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bID(), true, WriteActivity.this.fWh);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIC() {
        int i = 5000;
        if (this.hKM != null) {
            i = 1000;
        }
        return bID().getText() != null && bID().getText().length() >= i;
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hKE)) {
                this.hKE = "";
                bID().requestFocus();
                if (bID().getText() != null && bID().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bID().getSelectionStart();
                    editable = bID().getText();
                }
            } else if ("from_title".equals(this.hKE)) {
                this.hKE = "";
                bIE().requestFocus();
                if (bIE().getText() != null && bIE().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIE().getSelectionStart();
                    editable = bIE().getText();
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
    public void nV(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bID().getText().getSpans(0, bID().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hKL == null) {
                this.hKL = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hKL.show();
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
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bID().getSelectionStart(), aVar, FP);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bID() != null && bID().getText() != null) {
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
                int selectionStart = bID().getSelectionStart() - 1;
                if (bID().getText().length() > 1 && selectionStart >= 0 && bID().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bID().getText().insert(bID().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bID().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bID().getText().insert(bID().getSelectionStart(), spannableString2);
            }
            Editable text = bID().getText();
            if (text != null) {
                this.hLg.clear();
                this.hLg.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hLg);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bID().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bID().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bID().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bID() {
        return this.hKY ? this.hLF : this.gQM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIE() {
        return this.hKY ? this.hLJ : this.gQI;
    }

    protected void bIF() {
        Editable text;
        if (bID() != null && (text = bID().getText()) != null) {
            int selectionStart = bID().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bID().onKeyDown(67, this.drs);
            }
            bID().onKeyDown(67, this.drs);
            int selectionStart2 = bID().getSelectionStart();
            if (text != null) {
                this.hLg.clear();
                this.hLg.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hLg);
                bID().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hLr = true;
        }
    }

    private void bIT() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIU() {
        try {
            if (this.hLx != null) {
                this.hLx.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.bCC.d(null);
        this.bCC.ga(d.j.sending);
        this.bCC.bq(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.bCC.bq(false);
    }

    private Boolean bIV() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bub = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsJ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIE() != null) {
                str = bIE().getText().toString();
            }
            if (bID() != null) {
                str2 = bID().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gQq == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hKI.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nW(true);
                            return;
                        }
                    } else if (this.hKI.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nW(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hKI.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nW(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hKY) {
                    nW(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nW(true);
                }
            }
            if (this.mData.getType() == 4) {
                nW(l(this.hLF) && k(this.hLJ));
            } else if (this.mData.getType() == 5) {
                nW(l(this.hLF));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nW(true);
            } else if (this.mData.getVideoInfo() != null) {
                nW(true);
            } else {
                nW(false);
            }
        }
    }

    public void nW(boolean z) {
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
        this.btX = new NewWriteModel(this);
        this.btX.b(this.bum);
        registerListener(this.hMa);
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
            this.hLr = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hLs = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hLy = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hLz = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.btV = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hKM = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hKM != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hLA = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hLY = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hpO = bundle.getString("KEY_CALL_FROM");
            this.hEN = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hLr = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hLs = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hLy = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hLz = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hKM = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hKM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hLA = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hLY = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hpO = intent.getStringExtra("KEY_CALL_FROM");
            this.hEN = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hLr);
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
                u.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                u.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            u.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            u.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            u.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        this.foh = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hKG = true;
        }
        bIx();
        try {
            this.hLP = bJb();
        } catch (Throwable th) {
            this.hLP = null;
        }
    }

    private void bIG() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hLt.setVisibility(8);
            this.hLa.setVisibility(0);
            this.hLb.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gQI.setText(com.baidu.tbadk.plugins.a.hd(uJ(this.mList.get(0).mTopicName)));
                this.gQI.setMovementMethod(com.baidu.tieba.view.e.bEQ());
            }
            this.hLc.setText(this.mList.get(0).mForumName);
            this.gQI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hLe.equals(charSequence.toString())) {
                        WriteActivity.this.hLf = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString hd;
                    if (!WriteActivity.this.hLe.equals(editable.toString()) && (hd = com.baidu.tbadk.plugins.a.hd(editable.toString())) != null) {
                        WriteActivity.this.hLe = hd.toString();
                        WriteActivity.this.gQI.setText(hd);
                        if (WriteActivity.this.hLf <= WriteActivity.this.gQI.getText().length()) {
                            WriteActivity.this.gQI.setSelection(WriteActivity.this.hLf);
                        }
                    }
                }
            });
            this.hLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
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
                this.gQI.setText(hd);
            }
            this.hLc.setText(hotTopicBussinessData.mForumName);
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

    @Override // com.baidu.tieba.tbadkCore.u.a
    public void a(WriteData writeData) {
        String str;
        String uJ;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (k.isEmpty(bIE().getText().toString()) || this.hLX || ((this.hLr || this.hKG) && !k.isEmpty(writeData.getTitle()))) {
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
                            bIE().setText(hd);
                            bIE().setSelection(hd.length() > uJ.length() ? uJ.length() : hd.length());
                        }
                    } else {
                        SpannableString hd2 = com.baidu.tbadk.plugins.a.hd(this.mData.getTitle());
                        if (hd2 != null) {
                            bIE().setText(hd2);
                            bIE().setSelection(this.mData.getTitle().length() > hd2.length() ? hd2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bIw();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bID().getText().toString()) || this.hLr || this.hKG) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Mw().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hLj);
                    bID().setText(a2);
                    bID().setSelection(a2.length());
                    if (this.hKY) {
                        a(this.hLL, this.hLF);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bJa();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bIL();
                    }
                    nY(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIW();
                }
                bsJ();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hKR != null) {
                    this.hKV = this.hKS.dHg;
                    this.hKU = this.hKS.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hKR.size()) {
                            break;
                        }
                        z zVar = this.hKR.get(i);
                        if (categoryTo != zVar.dHg) {
                            i++;
                        } else {
                            this.hKV = categoryTo;
                            this.hKU = zVar.name;
                            this.mData.setCategoryTo(this.hKV);
                            break;
                        }
                    }
                    if (this.hKW != null) {
                        this.hKW.setText(this.hKU);
                        this.hKW.b(this.hKR, this.hKS, this.hKV);
                    }
                }
                this.bss.Jm();
                return;
            }
            return;
        }
        bIW();
        bIw();
    }

    private void bIW() {
        if ((!this.hKY || this.hLE != null) && this.hLD != null) {
            this.hLE.c(this.writeImagesInfo);
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hLy);
        if (this.hLr) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.btV);
        if (this.hKM != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hKM));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hLA);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hpO);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hEN);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bID().getEditableText().toString();
        if (obj != null) {
            bID().setText(TbFaceManager.Mw().a(getPageContext().getPageActivity(), obj, this.hLj));
            bID().setSelection(bID().getText().length());
        }
    }

    private String bIH() {
        return (bID() == null || bID().getText() == null) ? "" : bID().getText().toString();
    }

    private String bII() {
        if (this.mData == null || bIE() == null || bIE().getVisibility() != 0 || bIE().getText() == null) {
            return "";
        }
        String obj = bIE().getText().toString();
        if (this.mPrefixData != null && v.D(this.mPrefixData.getPrefixs()) > 0 && this.gQq != 0 && this.mData.getType() != 4 && this.gQN != null && this.gQN.getText() != null) {
            obj = this.gQN.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uK(String str) {
        if (this.mData != null && this.hKI != null) {
            if (this.hKI.getVisibility() == 0) {
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
    public void bHK() {
        bsB();
        this.mData.setContent(bIH());
        uK(bII());
        if (this.hLr || this.hKG) {
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
        if (this.hKT >= 0) {
            this.mData.setCategoryFrom(this.hKT);
        }
        if (this.hKV >= 0) {
            this.mData.setCategoryTo(this.hKV);
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
        this.mData.setHasLocationData(this.btW != null && this.btW.ahi());
        if (this.writeImagesInfo != null) {
            this.btX.mT(this.writeImagesInfo.size() > 0);
        }
        if (!v.E(this.mList) && this.hKZ != null && this.hKZ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hKZ.mForumId));
            this.mData.setForumName(this.hKZ.mForumName);
        }
        this.btX.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.btX.getWriteData().setVoice(this.mVoiceModel.getId());
                this.btX.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.btX.getWriteData().setVoice(null);
                this.btX.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.btX.getWriteData().setVoice(null);
            this.btX.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.btX.byh()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.btX.startPostWrite();
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
            if (this.hKM != null) {
                i2 = this.hKM.getTotalCount();
                i = this.hKM.getAlreadyCount() + 1;
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
                if (this.gQI == getCurrentFocus()) {
                    bID().clearFocus();
                    this.gQI.requestFocus();
                    if (this.bss != null) {
                        this.bss.Jm();
                    }
                    ShowSoftKeyPadDelay(this.gQI);
                } else {
                    bID().requestFocus();
                    if (this.bss != null) {
                        this.bss.Jm();
                    }
                    ShowSoftKeyPadDelay(this.gQM);
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
                            bID().getText().insert(bID().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    u.b(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null && postWriteCallBackData2.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    u.c(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    u.b(this.mData.getForumId() + "photolive", (WriteData) null);
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
                                bIZ();
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
                        if (this.hLZ) {
                            nX(true);
                            this.hLZ = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hKY) {
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
                        this.bss.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.bss.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.bss.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bsJ();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hKF) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hKF = false;
                            }
                            sb2.append(stringExtra);
                            gq(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.E(this.mList) && !v.E(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hKZ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hKZ);
                }
            }
        } else if (i2 == 0) {
            if (this.bss != null && !this.bss.Lf()) {
                this.gQM.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.bss.Jm();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    LJ();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIY();
                    if (this.hLZ) {
                        nX(true);
                        this.hLZ = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gQI == getCurrentFocus()) {
                        bID().clearFocus();
                        this.gQI.requestFocus();
                        if (this.bss != null) {
                            this.bss.Jm();
                        }
                        ShowSoftKeyPadDelay(this.gQI);
                        return;
                    }
                    bID().requestFocus();
                    if (this.bss != null) {
                        this.bss.Jm();
                    }
                    ShowSoftKeyPadDelay(this.gQM);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hIo.aw(postWriteCallBackData.getSensitiveWords());
                        this.hLi.aw(postWriteCallBackData.getSensitiveWords());
                        if (!v.E(this.hIo.bFG())) {
                            nO(true);
                            nU(true);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.btV = String.valueOf(System.currentTimeMillis());
                    ai.a(getPageContext(), this.btV);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIY();
                    return;
                case 25004:
                    if ("from_title".equals(this.hKE)) {
                        bIE().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hKE)) {
                        bID().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIJ() {
        if ("1".equals(this.hpO)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hpO)) {
            this.mData.setCanNoForum(false);
        }
        bIK();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hpO);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bHK();
    }

    private void bIK() {
        if (this.bss != null) {
            this.bss.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIX() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIY() {
        if (this.hKY) {
            this.hLE.c(this.writeImagesInfo);
            aTO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTO() {
        this.hLE.notifyDataSetChanged();
        this.hLD.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hLE.notifyDataSetChanged();
                WriteActivity.this.hLD.invalidateViews();
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
        if (this.hKY) {
            ai(intent);
            bIY();
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
            bIY();
            nY(true);
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

    private void bIZ() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void aj(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hLB.parseJson(stringExtra);
            this.hLB.updateQuality();
            if (this.hLB.getChosedFiles() != null && this.hLB.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hLB.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hLB.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIE());
        HidenSoftKeyPad(this.mInputManager, bID());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ak(Intent intent) {
        c(intent, true);
    }

    private void B(Intent intent) {
        this.btV = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.btV;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ao(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aq(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.btV, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bJa();
            bIL();
        }
        nY(true);
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
                bJa();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bIL();
                }
            }
            nY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJa() {
        if (this.bss.hI(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void LJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.btV));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nY(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hLC != null) {
            this.hLC.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.dEn == null) {
            this.dEn = VoiceManager.instance();
        }
        return this.dEn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avi() {
        this.dEn = getVoiceManager();
        this.dEn.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.vR(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dFl) != null) {
                    TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXx));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hKM == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                o(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.buc = i;
        if (this.bss != null) {
            this.bss.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIL() {
        if (!this.hKY) {
            if (this.bss != null) {
                this.bss.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.bss.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hLC != null) {
                this.hLC.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (this.bss != null) {
            this.bss.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.hJA.size()) {
            for (int i2 = 0; i2 < this.hJA.size(); i2++) {
                this.hJA.get(i2).nI(false);
            }
            this.hJA.get(i).nI(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void vm(int i) {
        this.gQq = i;
        this.gQO.setCurrentIndex(i);
        xI(i);
        this.gQN.setText(this.mPrefixData.getPrefixs().get(i));
        bsJ();
        com.baidu.adp.lib.g.g.a(this.gQO, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gQQ.setSelected(false);
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
                ai.a(getPageContext(), this.btV);
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
        if (this.hLV && System.currentTimeMillis() - this.hLW < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hLV = false;
        }
        if (this.hLh != null && !z) {
            this.hLh.bfm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uL(String str) {
        if (!k.isEmpty(str) && this.hLS != null) {
            uM(str);
            this.hLS.dismiss();
        }
    }

    private void cs(Context context) {
        hLU = l.aq(context);
    }

    private void uM(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hLV = true;
        bJa();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bIL();
        }
        nY(true);
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

    private File bJb() {
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

    private void bJc() {
        if (this.hLP != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cs(getActivity());
            this.hLR = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hLR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hLP != null) {
                        WriteActivity.this.uL(WriteActivity.this.hLP.getAbsolutePath());
                    }
                }
            });
            this.hLQ = (TbImageView) this.hLR.findViewById(d.g.rec_img_view);
            this.hLT = (LinearLayout) this.hLR.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hLP.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hLP.getAbsolutePath());
                Bitmap e = e(this.hLP.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (e != null) {
                    this.hLQ.setImageBitmap(e);
                    this.hLQ.setDrawBorder(true);
                    this.hLQ.setBorderWidth(2);
                    this.hLQ.setBorderColor(aj.getColor(d.C0141d.common_color_10264));
                    this.hLS = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hLS.setCanceledOnTouchOutside(true);
                    this.hLS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hLV) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hLW = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hLS.setContentView(this.hLR);
                    this.hLS.show();
                    Window window = this.hLS.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hLU / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
            this.hKF = false;
            this.hKE = "";
            if ("from_content".equals(str)) {
                this.hKE = "from_content";
            } else if ("from_title".equals(str)) {
                this.hKE = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nV(false);
            }
        }
    }

    public void Jo() {
        if (this.hLr || !v.E(this.mList)) {
            this.hKI.setVisibility(0);
            this.hKI.requestFocus();
            this.bss.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hKI.setVisibility(8);
    }
}
