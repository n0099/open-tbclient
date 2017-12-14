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
import com.baidu.c.a.a;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.s;
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
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.o;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0023a, VoiceManager.c, t.a, e.a {
    private static int hlX = 0;
    private com.baidu.tbadk.editortools.i aBZ;
    private String aDC;
    private LocationModel aDD;
    private NewWriteModel aDE;
    private VoiceManager cHh;
    private LinearLayout eXs;
    private PlayVoiceBntNew eXt;
    private ImageView eXv;
    private TextView gkO;
    private com.baidu.tieba.write.e gkP;
    private ImageView gkQ;
    private View gkR;
    private int gku;
    private com.baidu.tieba.write.b hiz;
    private LinearLayout hkM;
    private LinearLayout hkN;
    private View hkP;
    private Toast hkQ;
    private AdditionData hkR;
    private RelativeLayout hkS;
    private TextView hkT;
    private TextView hkU;
    private TextView hkV;
    List<z> hkW;
    z hkX;
    private int hkY;
    private String hkZ;
    private f hlF;
    private int hla;
    private PostCategoryView hlb;
    private HotTopicBussinessData hle;
    private View hlf;
    private View hlg;
    private TextView hlh;
    private TextView hli;
    private com.baidu.tieba.write.editor.d hlm;
    private com.baidu.tieba.write.b hln;
    private com.baidu.tieba.view.c hlt;
    private View hlz;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hkJ = "";
    private boolean hkK = false;
    private WriteData mData = null;
    private boolean hlv = false;
    private boolean hkL = false;
    private boolean hlw = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gkL = null;
    private HeadImageView hlx = null;
    private View gkM = null;
    private LinearLayout bHs = null;
    private EditText bHr = null;
    private FeedBackModel hkO = null;
    private FeedBackTopListView hly = null;
    private ArrayList<com.baidu.tieba.write.d> hjH = new ArrayList<>();
    private String ewC = null;
    private final KeyEvent cvm = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aqB = null;
    private TextView hlA = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hlB = null;
    private final Handler mHandler = new Handler();
    private boolean hlC = false;
    private String hlD = null;
    private RelativeLayout mParent = null;
    private String aDI = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDJ = 0;
    private int hlE = 0;
    private WriteImagesInfo fIu = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hlG = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hlH = null;
    private ScrollView hlc = null;
    private EditText hlI = null;
    private View hlJ = null;
    private View hlK = null;
    private View hlL = null;
    private EditText hlM = null;
    private TextView hlN = null;
    private TextView hlO = null;
    private TextWatcher hlP = null;
    private TextWatcher hlQ = null;
    private boolean hld = false;
    private boolean hlR = false;
    private com.baidu.tbadk.core.view.b aMB = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hlS = null;
    private TbImageView hlT = null;
    private View hlU = null;
    private Dialog hlV = null;
    private LinearLayout hlW = null;
    private boolean hlY = false;
    private long hlZ = -1000;
    private boolean hma = false;
    private String gRk = "2";
    private int hfd = 0;
    private String hmb = "";
    private String hlj = "";
    private int hlk = 0;
    private SpannableStringBuilder hll = new SpannableStringBuilder();
    private boolean hmc = false;
    private final HttpMessageListener hmd = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ewC)) {
                    WriteActivity.this.ewC = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.oj(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ewC)) {
                    WriteActivity.this.ewC = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ewC);
                    WriteActivity.this.oj(true);
                }
            }
        }
    };
    private TbFaceManager.a hlo = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gl(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kK());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new ImageSpan(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a cHZ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahJ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahJ));
        }
    };
    private final NewWriteModel.d aDS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.alC();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hiz.aC(null);
                WriteActivity.this.hiz.nT(false);
                WriteActivity.this.hln.aC(null);
                WriteActivity.this.hln.nT(false);
                if (z) {
                    WriteActivity.this.bG(z);
                    if (WriteActivity.this.d(writeData)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                t.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                t.c(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                t.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra("need_save_draft", true)) {
                            t.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.w(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hmb)) {
                            TiebaStatic.log(new ak("c11731").ac("obj_id", WriteActivity.this.hmb));
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
                    WriteActivity.this.hiz.aC(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hln.aC(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hiz.uB(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hln.uB(postWriteCallBackData.getErrorString());
                    if (!v.w(WriteActivity.this.hiz.bFE())) {
                        WriteActivity.this.ob(true);
                        WriteActivity.this.oh(true);
                    }
                } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.yk());
                    if (com.baidu.tbadk.p.a.hc(sVar.yj())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.yj());
                        if (WriteActivity.this.hlw) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aDQ = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DT() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void ga(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bxz())) {
                WriteActivity.this.a(2, true, aVar.bxz());
            } else {
                ga(null);
            }
        }
    };
    private final CustomMessageListener gEb = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aDD.ng(false);
                    WriteActivity.this.aDD.ci(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aDD.ng(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener hlp = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hlq = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIg = WriteActivity.this.bIg();
            if (bIg >= 0 && bIg < WriteActivity.this.bHr.getText().length()) {
                WriteActivity.this.bHr.setSelection(bIg);
            }
        }
    };
    private boolean hlr = true;
    private final View.OnFocusChangeListener bHy = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gkL || view == WriteActivity.this.aqB || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hlr = true;
                    WriteActivity.this.bIh();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gkL);
                    if (WriteActivity.this.aBZ != null) {
                        WriteActivity.this.aBZ.Bn();
                    }
                } else if (view == WriteActivity.this.gkL) {
                    WriteActivity.this.gkO.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.bHr && z) {
                WriteActivity.this.hlr = false;
                WriteActivity.this.bIh();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.bHr);
                if (WriteActivity.this.aBZ != null) {
                    WriteActivity.this.aBZ.Bn();
                }
            }
            WriteActivity.this.bIk();
        }
    };
    private TextWatcher bHA = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bqs();
            if (WriteActivity.this.hln != null) {
                if (!WriteActivity.this.hln.bFH()) {
                    WriteActivity.this.oh(false);
                }
                WriteActivity.this.hln.nU(false);
                WriteActivity.this.bIl();
            }
        }
    };
    private TextWatcher hls = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bqs();
            if (WriteActivity.this.hiz != null) {
                if (!WriteActivity.this.hiz.bFH()) {
                    WriteActivity.this.ob(false);
                }
                WriteActivity.this.hiz.nU(false);
            }
        }
    };
    private final a.InterfaceC0141a fdW = new a.InterfaceC0141a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0141a
        public void kW() {
            WriteActivity.this.ewC = null;
            WriteActivity.this.oj(false);
            WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(boolean z) {
        if (bIw() != null && bIw().getVisibility() == 0 && bIw().getText() != null) {
            int selectionEnd = bIw().getSelectionEnd();
            SpannableStringBuilder b = this.hln.b(bIw().getText());
            if (b != null) {
                this.hln.nU(true);
                bIw().setText(b);
                if (z && this.hln.bFF() >= 0) {
                    bIw().requestFocus();
                    bIw().setSelection(this.hln.bFF());
                } else {
                    bIw().setSelection(selectionEnd);
                }
                this.hln.nT(this.hln.bFF() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
        if (bIv() != null && bIv().getText() != null) {
            int selectionEnd = bIv().getSelectionEnd();
            SpannableStringBuilder b = this.hiz.b(bIv().getText());
            if (b != null) {
                this.hiz.nU(true);
                bIv().setText(b);
                if (z && this.hiz.bFF() >= 0) {
                    bIv().requestFocus();
                    bIv().setSelection(this.hiz.bFF());
                } else {
                    bIv().setSelection(selectionEnd);
                }
                this.hiz.nT(this.hiz.bFF() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void DF() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DG();
        } else if (this.aDD.bxH()) {
            DE();
        } else {
            this.aDD.ng(false);
            a(1, true, (String) null);
            this.aDD.bxF();
        }
    }

    private void DG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.hh()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aDD.YN();
                } else {
                    WriteActivity.this.aDQ.DT();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIg() {
        int selectionEnd = bIv().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIv().getText().getSpans(0, bIv().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIv().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIv().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        if (this.aBZ != null) {
            this.aBZ.setBarLauncherEnabled(!this.hlr);
            this.aBZ.d(true, 26);
            this.aBZ.d(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hld) {
            this.gkL.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hlL.setVisibility(8);
            } else {
                this.hlL.setVisibility(0);
            }
            b(this.hlO, this.hlI);
            b(this.hlN, this.hlM);
            bqs();
        }
        if (this.hlv) {
            this.hlr = true;
            bIh();
            if (this.aBZ != null) {
                this.aBZ.Bn();
            }
            this.gkL.requestFocus();
            ShowSoftKeyPadDelay(this.gkL);
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
            bIP();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bIC();
            }
            ok(true);
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
        this.hln = new com.baidu.tieba.write.b();
        this.hln.vM(d.C0096d.cp_cont_i);
        this.hln.vN(d.C0096d.cp_cont_h_alpha85);
        this.hiz = new com.baidu.tieba.write.b();
        this.hiz.vM(d.C0096d.cp_cont_i);
        this.hiz.vN(d.C0096d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            ws(this.hfd);
        }
        initUI();
        bIH();
        this.aDD = new LocationModel(this);
        this.aDD.a(this.aDQ);
        registerListener(this.gEb);
        registerListener(this.hlp);
        initEditor();
        bIR();
        if (this.hld) {
            this.hlH.setEditorTools(this.aBZ);
        } else {
            this.bHr.requestFocus();
        }
        Bp();
        bIC();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBZ = new com.baidu.tbadk.editortools.i(getActivity());
        this.aBZ.setBarMaxLauCount(5);
        this.aBZ.setMoreButtonAtEnd(true);
        this.aBZ.setBarLauncherType(1);
        this.aBZ.by(true);
        this.aBZ.bz(true);
        this.aBZ.setMoreLauncherIcon(d.f.write_more);
        this.aBZ.setBackgroundColorId(d.C0096d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bIF();
                break;
            default:
                bIi();
                break;
        }
        this.aBZ.Df();
        if (this.hkM != null) {
            this.hkM.addView(this.aBZ);
        }
        bIj();
        this.aBZ.lE();
        com.baidu.tbadk.editortools.l eN = this.aBZ.eN(6);
        if (eN != null && !TextUtils.isEmpty(this.aDI)) {
            ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aDI);
                }
            });
        }
        if (!this.hld) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aBZ.Bn();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bID() {
        this.hlJ = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hlL = this.hlJ.findViewById(d.g.live_post_title_container);
        this.hlI = (EditText) this.hlJ.findViewById(d.g.live_post_content);
        this.hlG = (GridView) this.hlJ.findViewById(d.g.photoLiveGridView);
        this.hlM = (EditText) this.hlJ.findViewById(d.g.live_post_title);
        this.hlN = (TextView) this.hlJ.findViewById(d.g.titleOverPlusNumber);
        this.hlO = (TextView) this.hlJ.findViewById(d.g.contentOverPlusNumber);
        this.hlK = this.hlJ.findViewById(d.g.live_interval_view);
        this.hlN.setText(String.valueOf(20));
        this.hlO.setText(String.valueOf(233));
        this.hlJ.setVisibility(0);
        this.hlN.setVisibility(0);
        this.hlO.setVisibility(0);
        this.hlM.setHint(d.j.tips_title_limit_new);
        this.hlM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hlR = true;
                    WriteActivity.this.hlr = true;
                    WriteActivity.this.bIh();
                    if (WriteActivity.this.aBZ != null) {
                        WriteActivity.this.aBZ.Bn();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hlI.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hlI.setHint(d.j.live_write_input_content_update);
        }
        this.hlI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hlR = false;
                    WriteActivity.this.hlr = false;
                    WriteActivity.this.bIh();
                    if (WriteActivity.this.aBZ != null) {
                        WriteActivity.this.aBZ.Bn();
                    }
                }
            }
        });
        this.hlI.requestFocus();
        this.hlI.addTextChangedListener(bdX());
        this.hlM.requestFocus();
        this.hlM.addTextChangedListener(bdX());
        this.hlM.setOnClickListener(this.hlq);
        this.hlI.setOnClickListener(this.hlq);
        this.hlH = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hlG);
        this.hlH.we(6);
        this.hlG.setAdapter((ListAdapter) this.hlH);
        View findViewById = this.hlJ.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bHq() {
                WriteActivity.this.aKU();
            }
        });
        bIE();
    }

    private void bIE() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hlM.setText(this.mData.getTitle());
                this.hlM.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hld) {
            bIN();
        }
        if (this.aBZ.Dh()) {
            this.aBZ.Bn();
        }
        ws(0);
    }

    private void ws(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gRk);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bIF() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aBZ.B(arrayList);
        r eP = this.aBZ.eP(5);
        if (eP != null) {
            eP.aCI = 2;
            eP.aCG = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aCG = d.f.write_at;
        this.aBZ.b(aVar);
        this.aBZ.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bIi() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        CustomResponsedMessage runTask;
        r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aCG = d.f.write_picture;
        this.aBZ.b(dVar);
        Boolean bIL = bIL();
        if (!this.hlv && bIL != null && bIL.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.byc() && o.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), r.class)) != null && (rVar5 = (r) runTask.getData()) != null) {
            rVar5.aCI = 3;
            rVar5.aCG = d.f.write_recorder;
            this.aBZ.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.aCG = d.f.write_at;
        this.aBZ.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), r.class);
        if (runTask2 != null && (rVar4 = (r) runTask2.getData()) != null) {
            rVar4.aCI = 5;
            rVar4.aCG = d.f.write_privilege;
            this.aBZ.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask3 != null && (rVar3 = (r) runTask3.getData()) != null) {
            rVar3.aCI = 6;
            rVar3.aCG = this.hlv ? d.f.write_location : d.f.icon_post_more_location;
            this.aBZ.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.aBZ.b(aVar2);
        aVar2.aCG = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), r.class);
        if (runTask4 != null && (rVar2 = (r) runTask4.getData()) != null) {
            rVar2.aCK = true;
            rVar2.aCI = 9;
            rVar2.aCG = 0;
            this.aBZ.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), r.class);
        if (runTask5 != null && (rVar = (r) runTask5.getData()) != null) {
            rVar.aCK = true;
            rVar.aCI = 10;
            rVar.aCG = 0;
            this.aBZ.b(rVar);
        }
        if (this.hkR == null) {
            if (this.hlm == null) {
                this.hlm = new com.baidu.tieba.write.editor.d(getActivity(), this.gRk);
                this.hlm.aL(this.mData.getForumId(), this.privateThread);
            }
            this.aBZ.b(this.hlm);
        }
        this.aBZ.B(arrayList);
        r eP = this.aBZ.eP(5);
        if (eP != null) {
            eP.aCI = 1;
            eP.aCG = d.f.write_emotion;
        }
    }

    private void bIj() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bIu()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bIu()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bIx();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aUh();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIP();
                        WriteActivity.this.bqs();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.wt(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hkR == null) {
                            WriteActivity.this.DH();
                            return;
                        }
                        switch (WriteActivity.this.aDJ) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aH(pageActivity)) {
                                    WriteActivity.this.DF();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.DE();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aDD != null) {
                            WriteActivity.this.aDD.ng(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ewC = null;
                        } else {
                            WriteActivity.this.ewC = (String) aVar.data;
                        }
                        WriteActivity.this.oj(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aBZ.Dh()) {
                                        WriteActivity.this.aBZ.Bn();
                                        WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bqs();
                        if (WriteActivity.this.bHr != null) {
                            WriteActivity.this.bHr.requestFocus();
                        }
                        WriteActivity.this.aBZ.Bn();
                        WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHr);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hkK = true;
                        WriteActivity.this.oi(true);
                        if (WriteActivity.this.bIw().isFocused()) {
                            WriteActivity.this.hkJ = "from_title";
                        } else if (WriteActivity.this.bIv().isFocused()) {
                            WriteActivity.this.hkJ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hkN.setVisibility(0);
                        WriteActivity.this.hkN.requestFocus();
                        WriteActivity.this.bqs();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hkN.hasFocus()) {
                            WriteActivity.this.bHr.requestFocus();
                            WriteActivity.this.bHr.setSelection(WriteActivity.this.bHr.getText().toString().length());
                        }
                        WriteActivity.this.hkN.setVisibility(8);
                        WriteActivity.this.bqs();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aBZ.a(16, bVar);
        this.aBZ.a(14, bVar);
        this.aBZ.a(24, bVar);
        this.aBZ.a(3, bVar);
        this.aBZ.a(10, bVar);
        this.aBZ.a(11, bVar);
        this.aBZ.a(12, bVar);
        this.aBZ.a(13, bVar);
        this.aBZ.a(15, bVar);
        this.aBZ.a(18, bVar);
        this.aBZ.a(20, bVar);
        this.aBZ.a(25, bVar);
        this.aBZ.a(27, bVar);
        this.aBZ.a(29, bVar);
        this.aBZ.a(43, bVar);
        this.aBZ.a(45, bVar);
        this.aBZ.a(53, bVar);
        this.aBZ.a(48, bVar);
        this.aBZ.a(46, bVar);
        this.aBZ.a(49, bVar);
        this.aBZ.a(47, bVar);
        this.aBZ.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wt(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DH() {
        if (this.aDD.YJ()) {
            if (this.aDD.bxH()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bxD().getLocationData().bxz());
                return;
            }
            a(1, true, (String) null);
            this.aDD.bxF();
            return;
        }
        a(0, true, (String) null);
    }

    protected void bqk() {
        if (this.aDE != null) {
            this.aDE.cancelLoadData();
        }
        if (this.hkO != null) {
            this.hkO.cancelLoadData();
        }
        if (this.aDD != null) {
            this.aDD.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bqk();
        bIK();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hlF != null) {
            this.hlF.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHB() {
        if (this.mData != null && this.mData.getType() == 2 && this.hlC) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bIw().getText().toString());
            this.mData.setContent(bIv().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    t.c("24591571", this.mData);
                }
            } else if (type == 1) {
                t.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                t.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                t.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gkP != null && this.gkP.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gkP, getPageContext().getPageActivity());
                return true;
            } else if (this.aBZ.Dh()) {
                this.aBZ.Bn();
                return true;
            } else {
                bqk();
                bHB();
                return true;
            }
        }
        if (i == 67 && (text = bIv().getText()) != null) {
            int selectionStart = bIv().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIv().onKeyDown(67, this.cvm);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.hlW);
        if (this.hlT != null && i == 1) {
            this.hlT.setBorderColor(aj.getColor(d.C0096d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.C0096d.cp_link_tip_a, 1);
        bIh();
        aj.k(this.hlJ, d.C0096d.cp_bg_line_d);
        aj.k(this.gkM, d.C0096d.cp_bg_line_c);
        aj.k(this.hlK, d.C0096d.cp_bg_line_c);
        aj.k(bIw(), d.C0096d.cp_bg_line_d);
        aj.c(this.eXv, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.ewC)) {
            aj.k(bIv(), d.C0096d.cp_bg_line_d);
        }
        bqs();
        this.aBZ.onChangeSkinType(i);
        if (this.hlb != null) {
            this.hlb.wC();
        }
        aj.i(this.mName, d.C0096d.cp_cont_b);
        bIk();
        bIl();
        if (this.hiz != null) {
            this.hiz.onChangeSkinType();
        }
        if (this.hln != null) {
            this.hln.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        if (this.gkL.hasFocus()) {
            this.gkL.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
        } else {
            this.gkL.setHintTextColor(aj.getColor(d.C0096d.cp_cont_d));
        }
        if (this.bHr.hasFocus()) {
            this.bHr.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
        } else {
            this.bHr.setHintTextColor(aj.getColor(d.C0096d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIl() {
        if (this.gkL != null && this.gkL.getText() != null && this.gkL.getText().toString() != null && this.gkL.getPaint() != null) {
            if (this.gkL.getText().toString().length() == 0) {
                this.gkL.getPaint().setFakeBoldText(false);
            } else if (this.gkL.getText().toString().length() > 0) {
                this.gkL.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aMB = new com.baidu.tbadk.core.view.b(getPageContext());
        this.hld = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aqB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.C0096d.cp_cont_b);
        this.hlA = (TextView) findViewById(d.g.btn_image_problem);
        bIn();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.bHy);
        this.hlc = (ScrollView) findViewById(d.g.write_scrollview);
        this.hlc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.bHr != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.bHr);
                    }
                    if (WriteActivity.this.aBZ != null) {
                        WriteActivity.this.aBZ.Bn();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hly = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hlz = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hkM = (LinearLayout) findViewById(d.g.tool_view);
        this.hkM.setContentDescription("..");
        this.hkN = (LinearLayout) findViewById(d.g.title_view);
        this.gkM = findViewById(d.g.interval_view);
        this.hlf = findViewById(d.g.hot_topic_fourm_view);
        this.hlg = findViewById(d.g.hot_topic_divider);
        this.hlh = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hli = (TextView) findViewById(d.g.change_one_tv);
        bqr();
        if (this.hld) {
            this.hlc.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bID();
        } else {
            this.hlF = new f(getPageContext(), this.mRootView);
            f fVar = this.hlF;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.oa(z);
        }
        XH();
        if (this.hlv || this.hkL) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ait) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.bHs = (LinearLayout) findViewById(d.g.post_content_container);
        this.bHs.setDrawingCacheEnabled(false);
        this.bHs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bHr.requestFocus();
                WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.eXs = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.eXt = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.eXv = (ImageView) findViewById(d.g.iv_delete_voice);
        this.eXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.aUh();
            }
        });
        this.aqB.setOnFocusChangeListener(this.bHy);
        this.aqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bqk();
                WriteActivity.this.bHB();
            }
        });
        this.hlA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bIq();
        i(bIL());
        bIs();
        bIm();
        bII();
        bIJ();
        bIh();
        bIr();
        bqq();
        bIy();
        if (this.mData.getType() == 4 && this.gkR != null && this.hkP != null) {
            this.gkR.setVisibility(8);
            this.hkP.setVisibility(8);
        }
        bqs();
        bIG();
    }

    private void bIm() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hlv || this.hkL) {
                        if (this.hlw) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.gRk != null && this.gRk.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.gRk != null && this.gRk.equals("2")) {
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
                    this.gkL.setVisibility(0);
                    this.bHr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.bHr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gkL.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.bHr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hlK.setVisibility(8);
                    return;
                case 7:
                    this.gkL.setVisibility(0);
                    this.bHr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bIn() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bIo() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hlv && !this.hkL && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIw() != null) {
                bIw().setText(d);
                bIw().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.eXs.setVisibility(0);
            this.eXt.setVoiceModel(voiceModel);
            bqs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUh() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.ez(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.eXs.setVisibility(8);
        this.eXt.setVoiceModel(null);
        r eP = this.aBZ.eP(6);
        if (eP != null && eP.aBT != null) {
            eP.aBT.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bqs();
    }

    private void bIp() {
        this.hkW = null;
        this.hkY = -1;
        this.hla = -1;
        com.baidu.tieba.frs.ab jV = aa.amx().jV(1);
        if (jV != null) {
            this.hkW = jV.cKh;
            this.hkY = getIntent().getIntExtra("category_id", -1);
            if (this.hkW != null && !this.hkW.isEmpty() && this.hkY >= 0) {
                this.hkX = new z();
                this.hkX.cKd = 0;
                this.hkX.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hla = this.hkX.cKd;
                this.hkZ = this.hkX.name;
                for (z zVar : this.hkW) {
                    if (zVar.cKd == this.hkY) {
                        this.hla = zVar.cKd;
                        this.hkZ = zVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIq() {
        if (this.hkW != null && !this.hkW.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hlb = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hlb.setText(this.hkZ);
            this.hlb.b(this.hkW, this.hkX, this.hla);
            this.hlb.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, au auVar) {
                    if (auVar != null) {
                        WriteActivity.this.hlb.setText(auVar.name);
                        WriteActivity.this.mData.setCategoryTo(auVar.cKd);
                        WriteActivity.this.hla = auVar.cKd;
                        WriteActivity.this.hlb.bHt();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hlb.bHs();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIw());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIv());
                }
            });
        }
    }

    private void bIG() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hlt = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hlt.setTitle(d.j.no_disturb_start_time);
        this.hlt.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hlt);
        this.hlt.setButton(-2, getPageContext().getString(d.j.cancel), this.hlt);
        return this.hlt;
    }

    private void bIr() {
        this.hkS = (RelativeLayout) findViewById(d.g.addition_container);
        this.hkT = (TextView) findViewById(d.g.addition_create_time);
        this.hkU = (TextView) findViewById(d.g.addition_last_time);
        this.hkV = (TextView) findViewById(d.g.addition_last_content);
        if (this.hkR != null) {
            this.hkS.setVisibility(0);
            this.hkT.setText(getPageContext().getString(d.j.write_addition_create) + am.r(this.hkR.getCreateTime() * 1000));
            if (this.hkR.getAlreadyCount() == 0) {
                this.hkU.setVisibility(8);
            } else {
                this.hkU.setText(getPageContext().getString(d.j.write_addition_last) + am.r(this.hkR.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hkR.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hkV.setText(lastAdditionContent);
            } else {
                this.hkV.setVisibility(8);
            }
            bIv().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hkR.getAlreadyCount()), Integer.valueOf(this.hkR.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hkS.setVisibility(8);
    }

    private void bqq() {
        this.gkR = findViewById(d.g.post_prefix_layout);
        this.gkO = (TextView) findViewById(d.g.post_prefix);
        this.hkP = findViewById(d.g.prefix_divider);
        this.gkQ = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gkR.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gku = 1;
            this.gkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gkO.setVisibility(0);
                    WriteActivity.this.gkR.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gkP, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aBZ.Bn();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gkL);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHr);
                }
            });
            this.gkQ = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gkQ.setVisibility(0);
                this.gkO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gkO.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gkP, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aBZ.Bn();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIw());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIv());
                    }
                });
            }
            this.gkP = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gkP.a(this);
            this.gkP.setMaxHeight(l.f(getActivity(), d.e.ds510));
            this.gkP.setOutsideTouchable(true);
            this.gkP.setFocusable(true);
            this.gkP.setOnDismissListener(this);
            this.gkP.setBackgroundDrawable(aj.getDrawable(d.C0096d.cp_bg_line_d));
            int color = aj.getColor(d.C0096d.cp_cont_b);
            int color2 = aj.getColor(d.C0096d.cp_cont_c);
            aj.j(this.gkO, d.C0096d.cp_bg_line_d);
            aj.c(this.gkQ, d.f.icon_frs_arrow_n);
            this.gkO.setTextColor(color);
            this.hjH.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hjH.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gkP.addView(dVar);
            }
            this.gkP.setCurrentIndex(0);
            this.gkO.setText(prefixs.get(1));
            wo(1);
            return;
        }
        this.gkR.setVisibility(8);
    }

    private void bIH() {
        if (this.hlv && this.mData != null) {
            this.hly.setVisibility(0);
            this.hlz.setVisibility(0);
            this.hkO = new FeedBackModel(getPageContext());
            this.hkO.uV(this.mData.getForumName());
            this.hkO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hly.setVisibility(8);
                        WriteActivity.this.hlz.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hly.setVisibility(8);
                        WriteActivity.this.hlz.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hly.a(feedBackModel.bHV(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bIs() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hln.bFG()) {
                        WriteActivity.this.showToast(WriteActivity.this.hln.bFI());
                        WriteActivity.this.oh(true);
                    } else if (WriteActivity.this.hiz.bFG()) {
                        WriteActivity.this.showToast(WriteActivity.this.hiz.bFI());
                        WriteActivity.this.ob(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIw());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIv());
                        WriteActivity.this.aBZ.Bn();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hlv) {
                                WriteActivity.this.bHC();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bIA();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bHC();
                        }
                        TiebaStatic.log(new ak("c12262").ac("obj_locate", WriteActivity.this.gRk));
                    }
                }
            }
        });
    }

    protected void bII() {
        this.hlB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hlB.cS(getPageContext().getString(d.j.is_save_draft)).ao(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bIw().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bIv().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    t.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    t.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
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
                    t.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    t.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.hlB.b(getPageContext());
    }

    protected void bqr() {
        this.hlx = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hlx.setIsRound(true);
        this.hlx.setDrawBorder(false);
        this.hlx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dE = com.baidu.tbadk.core.util.o.dE(currentPortrait);
            this.hlx.setUrl(dE);
            this.hlx.startLoad(dE, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hlx.setVisibility(0);
        }
        this.gkL = (EditText) findViewById(d.g.post_title);
        this.gkL.setOnClickListener(this.hlq);
        this.gkL.setOnFocusChangeListener(this.bHy);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gkL.setText(this.mData.getTitle());
                this.gkL.setSelection(this.mData.getTitle().length());
            } else if (this.hlw) {
                this.gkL.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gkL.addTextChangedListener(this.bHA);
        if (!this.mData.getHaveDraft()) {
            bIo();
            this.hma = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gkL.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gkL.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bdX() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int bHD;
            private EditText dVi = null;
            private TextView abT = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bqs();
                if (WriteActivity.this.hld) {
                    this.bHD = this.dVi.getSelectionStart();
                    this.dVi.setSelection(this.bHD);
                    WriteActivity.this.b(this.abT, this.dVi);
                }
                if (this.dVi != WriteActivity.this.hlM || WriteActivity.this.hln == null || WriteActivity.this.hln.bFH()) {
                    if (this.dVi == WriteActivity.this.hlI && WriteActivity.this.hiz != null && !WriteActivity.this.hiz.bFH()) {
                        WriteActivity.this.ob(false);
                    }
                } else {
                    WriteActivity.this.oh(false);
                }
                if (WriteActivity.this.hln != null) {
                    WriteActivity.this.hln.nU(false);
                }
                if (WriteActivity.this.hiz != null) {
                    WriteActivity.this.hiz.nU(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hld || !WriteActivity.this.hlR) {
                    if (WriteActivity.this.hld) {
                        if (this.dVi != WriteActivity.this.hlI || this.abT != WriteActivity.this.hlO) {
                            this.dVi = WriteActivity.this.hlI;
                            this.abT = WriteActivity.this.hlO;
                        }
                    }
                } else if (this.dVi != WriteActivity.this.hlM || this.abT != WriteActivity.this.hlN) {
                    this.dVi = WriteActivity.this.hlM;
                    this.abT = WriteActivity.this.hlN;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hld && this.hlR) {
            if (this.hlP != null) {
                this.hlM.removeTextChangedListener(this.hlP);
            }
            this.hlP = textWatcher;
        } else if (this.hld) {
            if (this.hlQ != null) {
                this.hlI.removeTextChangedListener(this.hlQ);
            }
            this.hlQ = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.hlI) {
            return 233L;
        }
        if (editText != this.hlM) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long k = k(editText);
            long i = k - i(editText);
            String valueOf = String.valueOf(i);
            if (k == 20) {
                if (i < 0) {
                    if (i < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(aj.getColor(d.C0096d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0096d.cp_cont_d));
                }
            } else if (i < 0) {
                if (i < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0096d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0096d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long i(EditText editText) {
        return com.baidu.tieba.write.b.a.g(editText.getText().toString().trim());
    }

    protected void XH() {
        this.bHr = (EditText) findViewById(d.g.post_content);
        this.bHr.setDrawingCacheEnabled(false);
        this.bHr.setOnClickListener(this.hlq);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString T = TbFaceManager.Ez().T(getPageContext().getPageActivity(), this.mData.getContent());
            this.bHr.setText(T);
            this.bHr.setSelection(T.length());
        } else if (this.mData.getType() == 2) {
            if (this.hlC) {
                if (this.hlD != null && this.hlD.length() > 0) {
                    this.bHr.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hlD}));
                    this.bHr.setSelection(this.bHr.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.bHr.setText(format);
                this.bHr.setSelection(format.length());
            }
        }
        this.bHr.setOnFocusChangeListener(this.bHy);
        this.bHr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.bHr.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bHr.addTextChangedListener(this.hls);
        if (this.mData.getType() == 0) {
            this.hmc = true;
        } else {
            oj(true);
            this.hmc = false;
        }
        if (this.mData.isUserFeedback()) {
            this.bHr.setHint(d.j.write_input_content);
        } else {
            this.bHr.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void oj(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hld) {
            bIv().setPadding(0, 0, 0, 0);
            bIv().setBackgroundDrawable(null);
            aj.k(bIv(), d.C0096d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ewC) && this.hkR == null) {
                com.baidu.adp.lib.f.c.fJ().a(this.ewC, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.kK() != null && aVar.kO() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kK(), aVar.kK().getNinePatchChunk(), aVar.kO(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bIv().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bIv(), true, WriteActivity.this.fdW);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIu() {
        int i = 5000;
        if (this.hkR != null) {
            i = 1000;
        }
        return bIv().getText() != null && bIv().getText().length() >= i;
    }

    private void fR(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hkJ)) {
                this.hkJ = "";
                bIv().requestFocus();
                if (bIv().getText() != null && bIv().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIv().getSelectionStart();
                    editable = bIv().getText();
                }
            } else if ("from_title".equals(this.hkJ)) {
                this.hkJ = "";
                bIw().requestFocus();
                if (bIw().getText() != null && bIw().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bIw().getSelectionStart();
                    editable = bIw().getText();
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
    public void oi(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bIv().getText().getSpans(0, bIv().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hkQ == null) {
                this.hkQ = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hkQ.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType yb = nVar.yb();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bIv().getSelectionStart(), aVar, yb);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIv() != null && bIv().getText() != null) {
            Bitmap kK = aVar.kK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kK);
            int width = kK.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kK.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bIv().getSelectionStart() - 1;
                if (bIv().getText().length() > 1 && selectionStart >= 0 && bIv().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIv().getText().insert(bIv().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIv().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIv().getText().insert(bIv().getSelectionStart(), spannableString2);
            }
            Editable text = bIv().getText();
            if (text != null) {
                this.hll.clear();
                this.hll.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hll);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIv().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIv().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIv().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIv() {
        return this.hld ? this.hlI : this.bHr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIw() {
        return this.hld ? this.hlM : this.gkL;
    }

    protected void bIx() {
        Editable text;
        if (bIv() != null && (text = bIv().getText()) != null) {
            int selectionStart = bIv().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIv().onKeyDown(67, this.cvm);
            }
            bIv().onKeyDown(67, this.cvm);
            int selectionStart2 = bIv().getSelectionStart();
            if (text != null) {
                this.hll.clear();
                this.hll.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hll);
                bIv().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hlv = true;
        }
    }

    private void bIJ() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bIK() {
        try {
            if (this.hlB != null) {
                this.hlB.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aMB.c(null);
        this.aMB.db(d.j.sending);
        this.aMB.aE(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aMB.aE(false);
    }

    private Boolean bIL() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aDI = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqs() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIw() != null) {
                str = bIw().getText().toString();
            }
            if (bIv() != null) {
                str2 = bIv().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gku == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hkN.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            dy(true);
                            return;
                        }
                    } else if (this.hkN.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        dy(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hkN.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    dy(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hld) {
                    dy(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dy(true);
                }
            }
            if (this.mData.getType() == 4) {
                dy(m(this.hlI) && l(this.hlM));
            } else if (this.mData.getType() == 5) {
                dy(m(this.hlI));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                dy(true);
            } else if (this.mData.getVideoInfo() != null) {
                dy(true);
            } else {
                dy(false);
            }
        }
    }

    public void dy(boolean z) {
        if (z) {
            aj.b(this.mPost, d.C0096d.cp_link_tip_a, d.C0096d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.c(this.mPost, d.C0096d.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean l(EditText editText) {
        long i = i(editText);
        return i <= 20 && i > 0;
    }

    private boolean m(EditText editText) {
        long i = i(editText);
        if (i > 233) {
            return false;
        }
        return i > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.aDE = new NewWriteModel(this);
        this.aDE.b(this.aDS);
        registerListener(this.hmd);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bqk();
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
            this.hlv = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hlw = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hlC = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hlD = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aDC = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hkR = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hkR != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hlE = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hmb = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gRk = bundle.getString("KEY_CALL_FROM");
            this.hfd = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hlv = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hlw = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hlC = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hlD = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hkR = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hkR != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hlE = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hmb = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gRk = intent.getStringExtra("KEY_CALL_FROM");
            this.hfd = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hlv);
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
        this.ewC = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hkL = true;
        }
        bIp();
        try {
            this.hlS = bIQ();
        } catch (Throwable th) {
            this.hlS = null;
        }
    }

    private void bIy() {
        if (v.v(this.mList) > 0 && this.mList.get(0) != null) {
            this.hlx.setVisibility(8);
            this.hlf.setVisibility(0);
            this.hlg.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gkL.setText(com.baidu.tbadk.plugins.a.gI(uW(this.mList.get(0).mTopicName)));
                this.gkL.setMovementMethod(com.baidu.tieba.view.d.bEK());
            }
            this.hlh.setText(this.mList.get(0).mForumName);
            this.gkL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hlj.equals(charSequence.toString())) {
                        WriteActivity.this.hlk = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gI;
                    if (!WriteActivity.this.hlj.equals(editable.toString()) && (gI = com.baidu.tbadk.plugins.a.gI(editable.toString())) != null) {
                        WriteActivity.this.hlj = gI.toString();
                        WriteActivity.this.gkL.setText(gI);
                        if (WriteActivity.this.hlk <= WriteActivity.this.gkL.getText().length()) {
                            WriteActivity.this.gkL.setSelection(WriteActivity.this.hlk);
                        }
                    }
                }
            });
            this.hli.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.mData.getType() == 7) {
                        TiebaStatic.log("c12016");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 25005, WriteActivity.this.mList)));
                }
            });
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gI = com.baidu.tbadk.plugins.a.gI(uW(hotTopicBussinessData.mTopicName));
            if (gI != null) {
                this.gkL.setText(gI);
            }
            this.hlh.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uW(String str) {
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
        String uW;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (k.isEmpty(bIw().getText().toString()) || this.hma || ((this.hlv || this.hkL) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.w(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            uW = this.mData.getTitle();
                        } else {
                            uW = uW(str);
                        }
                        SpannableString gI = com.baidu.tbadk.plugins.a.gI(uW);
                        if (gI != null) {
                            bIw().setText(gI);
                            bIw().setSelection(gI.length() > uW.length() ? uW.length() : gI.length());
                        }
                    } else {
                        SpannableString gI2 = com.baidu.tbadk.plugins.a.gI(this.mData.getTitle());
                        if (gI2 != null) {
                            bIw().setText(gI2);
                            bIw().setSelection(this.mData.getTitle().length() > gI2.length() ? gI2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bIo();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bIv().getText().toString()) || this.hlv || this.hkL) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ez().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hlo);
                    bIv().setText(a2);
                    bIv().setSelection(a2.length());
                    if (this.hld) {
                        b(this.hlO, this.hlI);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIP();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bIC();
                    }
                    ok(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bIM();
                }
                bqs();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hkW != null) {
                    this.hla = this.hkX.cKd;
                    this.hkZ = this.hkX.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hkW.size()) {
                            break;
                        }
                        z zVar = this.hkW.get(i);
                        if (categoryTo != zVar.cKd) {
                            i++;
                        } else {
                            this.hla = categoryTo;
                            this.hkZ = zVar.name;
                            this.mData.setCategoryTo(this.hla);
                            break;
                        }
                    }
                    if (this.hlb != null) {
                        this.hlb.setText(this.hkZ);
                        this.hlb.b(this.hkW, this.hkX, this.hla);
                    }
                }
                this.aBZ.Bn();
                return;
            }
            return;
        }
        bIM();
        bIo();
    }

    private void bIM() {
        if ((!this.hld || this.hlH != null) && this.hlG != null) {
            this.hlH.c(this.writeImagesInfo);
            aKU();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hlC);
        if (this.hlv) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDC);
        if (this.hkR != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hkR));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hlE);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gRk);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hfd);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIv().getEditableText().toString();
        if (obj != null) {
            bIv().setText(TbFaceManager.Ez().a(getPageContext().getPageActivity(), obj, this.hlo));
            bIv().setSelection(bIv().getText().length());
        }
    }

    private String bIz() {
        return (bIv() == null || bIv().getText() == null) ? "" : bIv().getText().toString();
    }

    private String beA() {
        if (this.mData == null || bIw() == null || bIw().getVisibility() != 0 || bIw().getText() == null) {
            return "";
        }
        String obj = bIw().getText().toString();
        if (this.mPrefixData != null && v.v(this.mPrefixData.getPrefixs()) > 0 && this.gku != 0 && this.mData.getType() != 4 && this.gkO != null && this.gkO.getText() != null) {
            obj = this.gkO.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uX(String str) {
        if (this.mData != null && this.hkN != null) {
            if (this.hkN.getVisibility() == 0) {
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
    public void bHC() {
        bqk();
        this.mData.setContent(bIz());
        uX(beA());
        if (this.hlv || this.hkL) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                uX(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.hh()) {
                    sb.append(com.baidu.adp.lib.util.j.hp());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hkY >= 0) {
            this.mData.setCategoryFrom(this.hkY);
        }
        if (this.hla >= 0) {
            this.mData.setCategoryTo(this.hla);
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
        this.mData.setHasLocationData(this.aDD != null && this.aDD.YJ());
        if (this.writeImagesInfo != null) {
            this.aDE.ni(this.writeImagesInfo.size() > 0);
        }
        if (!v.w(this.mList) && this.hle != null && this.hle.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hle.mForumId));
            this.mData.setForumName(this.hle.mForumName);
        }
        this.aDE.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aDE.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aDE.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aDE.getWriteData().setVoice(null);
                this.aDE.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aDE.getWriteData().setVoice(null);
            this.aDE.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aDE.byd()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.hh()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.aDE.startPostWrite();
        }
    }

    private void t(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hkR != null) {
                i2 = this.hkR.getTotalCount();
                i = this.hkR.getAlreadyCount() + 1;
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
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, str, 18003)));
        }
    }

    @Override // android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                bIv().requestFocus();
                if (this.aBZ != null) {
                    this.aBZ.Bn();
                }
                ShowSoftKeyPadDelay(this.bHr);
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
                            bIv().getText().insert(bIv().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    t.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData2 != null && postWriteCallBackData2.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData2, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    t.d(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    t.c(this.mData.getForumId() + "photolive", (WriteData) null);
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
                                bfv();
                            } else {
                                ai(intent);
                            }
                        } else if (intExtra == 1) {
                            Y(intent);
                        } else {
                            ah(intent);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hmc) {
                            oj(true);
                            this.hmc = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hld) {
                        A(intent);
                        bqs();
                        return;
                    }
                    ak(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aBZ.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bqs();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hkK) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hkK = false;
                            }
                            sb2.append(stringExtra);
                            fR(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.w(this.mList) && !v.w(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hle = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hle);
                }
            }
        } else if (i2 == 0) {
            if (this.aBZ != null && !this.aBZ.Dh()) {
                this.bHr.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aBZ.Bn();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    DK();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIO();
                    if (this.hmc) {
                        oj(true);
                        this.hmc = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    bIv().requestFocus();
                    if (this.aBZ != null) {
                        this.aBZ.Bn();
                    }
                    ShowSoftKeyPadDelay(this.bHr);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hiz.aC(postWriteCallBackData.getSensitiveWords());
                        this.hln.aC(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.hiz.bFE())) {
                            ob(true);
                            oh(true);
                            return;
                        }
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aDC = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aDC);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bIO();
                    return;
                case 25004:
                    if ("from_title".equals(this.hkJ)) {
                        bIw().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hkJ)) {
                        bIv().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIA() {
        if ("1".equals(this.gRk)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.gRk)) {
            this.mData.setCanNoForum(false);
        }
        bIB();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.gRk);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bHC();
    }

    private void bIB() {
        if (this.aBZ != null) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIN() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIO() {
        if (this.hld) {
            this.hlH.c(this.writeImagesInfo);
            aKU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKU() {
        this.hlH.notifyDataSetChanged();
        this.hlG.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hlH.notifyDataSetChanged();
                WriteActivity.this.hlG.invalidateViews();
            }
        }, 550L);
    }

    public void q(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bqs();
    }

    private void ah(Intent intent) {
        if (this.hld) {
            ak(intent);
            bIO();
        } else {
            al(intent);
        }
        bqs();
    }

    private void ak(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIO();
            ok(true);
        }
    }

    private void ai(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, size)));
            }
        }
    }

    private void bfv() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void Y(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fIu.parseJson(stringExtra);
            this.fIu.updateQuality();
            if (this.fIu.getChosedFiles() != null && this.fIu.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fIu.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fIu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIw());
        HidenSoftKeyPad(this.mInputManager, bIv());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void al(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aDC = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDC;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ac(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ae(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDC, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIP();
            bIC();
        }
        ok(true);
    }

    private void A(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bIP();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bIC();
                }
            }
            ok(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIP() {
        if (this.aBZ.eP(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DK() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aDC));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void ok(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hlF != null) {
            this.hlF.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cHh == null) {
            this.cHh = VoiceManager.instance();
        }
        return this.cHh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void alC() {
        this.cHh = getVoiceManager();
        this.cHh.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.uB(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cHZ) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahJ));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hkR == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                t(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDJ = i;
        if (this.aBZ != null) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bIC() {
        if (!this.hld) {
            if (this.aBZ != null) {
                this.aBZ.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aBZ.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hlF != null) {
                this.hlF.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (this.aBZ != null) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wo(int i) {
        if (i < this.hjH.size()) {
            for (int i2 = 0; i2 < this.hjH.size(); i2++) {
                this.hjH.get(i2).nW(false);
            }
            this.hjH.get(i).nW(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void tN(int i) {
        this.gku = i;
        this.gkP.setCurrentIndex(i);
        wo(i);
        this.gkO.setText(this.mPrefixData.getPrefixs().get(i));
        bqs();
        com.baidu.adp.lib.g.g.a(this.gkP, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gkR.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.c.a.a.InterfaceC0023a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            DF();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aI(getApplicationContext())) {
                ai.b(getPageContext(), this.aDC);
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
        if (this.hlY && System.currentTimeMillis() - this.hlZ < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hlY = false;
        }
        if (this.hlm != null && !z) {
            this.hlm.aWp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY(String str) {
        if (!k.isEmpty(str) && this.hlV != null) {
            uZ(str);
            this.hlV.dismiss();
        }
    }

    private void cl(Context context) {
        hlX = l.ae(context);
    }

    private void uZ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hlY = true;
        bIP();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bIC();
        }
        ok(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4279=4] */
    private static Bitmap d(String str, float f) {
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

    private File bIQ() {
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

    private void bIR() {
        if (this.hlS != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cl(getActivity());
            this.hlU = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hlU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hlS != null) {
                        WriteActivity.this.uY(WriteActivity.this.hlS.getAbsolutePath());
                    }
                }
            });
            this.hlT = (TbImageView) this.hlU.findViewById(d.g.rec_img_view);
            this.hlW = (LinearLayout) this.hlU.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hlS.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hlS.getAbsolutePath());
                Bitmap d = d(this.hlS.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (d != null) {
                    this.hlT.setImageBitmap(d);
                    this.hlT.setDrawBorder(true);
                    this.hlT.setBorderWidth(2);
                    this.hlT.setBorderColor(aj.getColor(d.C0096d.common_color_10264));
                    this.hlV = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hlV.setCanceledOnTouchOutside(true);
                    this.hlV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hlY) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hlZ = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hlV.setContentView(this.hlU);
                    this.hlV.show();
                    Window window = this.hlV.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hlX / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
            this.hkK = false;
            this.hkJ = "";
            if ("from_content".equals(str)) {
                this.hkJ = "from_content";
            } else if ("from_title".equals(str)) {
                this.hkJ = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                oi(false);
            }
        }
    }

    public void Bp() {
        if (this.hlv || !v.w(this.mList)) {
            this.hkN.setVisibility(0);
            this.hkN.requestFocus();
            this.aBZ.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hkN.setVisibility(8);
    }
}
