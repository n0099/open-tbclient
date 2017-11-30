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
import com.baidu.b.a.a;
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
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.y;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0022a, VoiceManager.c, t.a, e.a {
    private static int hjf = 0;
    private com.baidu.tbadk.editortools.i aBU;
    private String aDx;
    private LocationModel aDy;
    private NewWriteModel aDz;
    private VoiceManager cGZ;
    private LinearLayout eWp;
    private PlayVoiceBntNew eWq;
    private ImageView eWs;
    private int ghM;
    private TextView gih;
    private com.baidu.tieba.write.e gii;
    private ImageView gij;
    private View gik;
    private com.baidu.tieba.write.b hfG;
    private LinearLayout hhT;
    private LinearLayout hhU;
    private View hhW;
    private Toast hhX;
    private AdditionData hhY;
    private RelativeLayout hhZ;
    private com.baidu.tieba.view.c hiB;
    private View hiH;
    private f hiN;
    private TextView hia;
    private TextView hib;
    private TextView hic;
    List<y> hie;
    y hif;
    private int hig;
    private String hih;
    private int hii;
    private PostCategoryView hij;
    private HotTopicBussinessData him;
    private View hin;
    private View hio;
    private TextView hip;
    private TextView hiq;
    private com.baidu.tieba.write.editor.c hiu;
    private com.baidu.tieba.write.b hiv;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private String hhQ = "";
    private boolean hhR = false;
    private WriteData mData = null;
    private boolean hiD = false;
    private boolean hhS = false;
    private boolean hiE = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gie = null;
    private HeadImageView hiF = null;
    private View gif = null;
    private LinearLayout bHo = null;
    private EditText bHn = null;
    private FeedBackModel hhV = null;
    private FeedBackTopListView hiG = null;
    private ArrayList<com.baidu.tieba.write.d> hgO = new ArrayList<>();
    private String evy = null;
    private final KeyEvent cvd = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aqy = null;
    private TextView hiI = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hiJ = null;
    private final Handler mHandler = new Handler();
    private boolean hiK = false;
    private String hiL = null;
    private RelativeLayout mParent = null;
    private String aDD = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDE = 0;
    private int hiM = 0;
    private WriteImagesInfo fHC = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hiO = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hiP = null;
    private ScrollView hik = null;
    private EditText hiQ = null;
    private View hiR = null;
    private View hiS = null;
    private View hiT = null;
    private EditText hiU = null;
    private TextView hiV = null;
    private TextView hiW = null;
    private TextWatcher hiX = null;
    private TextWatcher hiY = null;
    private boolean hil = false;
    private boolean hiZ = false;
    private com.baidu.tbadk.core.view.a aMx = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hja = null;
    private TbImageView hjb = null;
    private View hjc = null;
    private Dialog hjd = null;
    private LinearLayout hje = null;
    private boolean hjg = false;
    private long hjh = -1000;
    private boolean hji = false;
    private String hef = "2";
    private int hcn = 0;
    private String hjj = "";
    private String hir = "";
    private int his = 0;
    private SpannableStringBuilder hit = new SpannableStringBuilder();
    private boolean hjk = false;
    private final HttpMessageListener hjl = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.evy)) {
                    WriteActivity.this.evy = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.oi(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.evy)) {
                    WriteActivity.this.evy = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.evy);
                    WriteActivity.this.oi(true);
                }
            }
        }
    };
    private TbFaceManager.a hiw = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gm(String str) {
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
    private final AntiHelper.a cHQ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahP));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahP));
        }
    };
    private final NewWriteModel.d aDN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.als();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hfG.aB(null);
                WriteActivity.this.hfG.nS(false);
                WriteActivity.this.hiv.aB(null);
                WriteActivity.this.hiv.nS(false);
                if (z) {
                    WriteActivity.this.bF(z);
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
                        if (!v.w(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hjj)) {
                            TiebaStatic.log(new ak("c11731").ac("obj_id", WriteActivity.this.hjj));
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
                    WriteActivity.this.hfG.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hiv.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hfG.uw(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hiv.uw(postWriteCallBackData.getErrorString());
                    if (!v.w(WriteActivity.this.hfG.bES())) {
                        WriteActivity.this.oa(true);
                        WriteActivity.this.og(true);
                    }
                } else if ((rVar == null || writeData == null || rVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (rVar != null && writeData != null && rVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yj());
                    if (com.baidu.tbadk.p.a.he(rVar.yi())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, rVar.yi());
                        if (WriteActivity.this.hiE) {
                            newVcodeActivityConfig.setHideFeedBackButton();
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newVcodeActivityConfig));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), writeData, 12006)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteActivity.this.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aDL = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DS() {
            WriteActivity.this.showToast(d.j.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gb(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.j.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwS())) {
                WriteActivity.this.a(2, true, aVar.bwS());
            } else {
                gb(null);
            }
        }
    };
    private final CustomMessageListener gBs = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aDy.ne(false);
                    WriteActivity.this.aDy.ch(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aDy.ne(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener hix = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hiy = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHt = WriteActivity.this.bHt();
            if (bHt >= 0 && bHt < WriteActivity.this.bHn.getText().length()) {
                WriteActivity.this.bHn.setSelection(bHt);
            }
        }
    };
    private boolean hiz = true;
    private final View.OnFocusChangeListener bHu = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gie || view == WriteActivity.this.aqy || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hiz = true;
                    WriteActivity.this.bHu();
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.gie);
                    if (WriteActivity.this.aBU != null) {
                        WriteActivity.this.aBU.Bm();
                    }
                } else if (view == WriteActivity.this.gie) {
                    WriteActivity.this.gih.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.bHn && z) {
                WriteActivity.this.hiz = false;
                WriteActivity.this.bHu();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.bHn);
                if (WriteActivity.this.aBU != null) {
                    WriteActivity.this.aBU.Bm();
                }
            }
            WriteActivity.this.bHx();
        }
    };
    private TextWatcher bHw = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bpM();
            if (WriteActivity.this.hiv != null) {
                if (!WriteActivity.this.hiv.bEV()) {
                    WriteActivity.this.og(false);
                }
                WriteActivity.this.hiv.nT(false);
                WriteActivity.this.bHy();
            }
        }
    };
    private TextWatcher hiA = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bpM();
            if (WriteActivity.this.hfG != null) {
                if (!WriteActivity.this.hfG.bEV()) {
                    WriteActivity.this.oa(false);
                }
                WriteActivity.this.hfG.nT(false);
            }
        }
    };
    private final a.InterfaceC0126a fcV = new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0126a
        public void kW() {
            WriteActivity.this.evy = null;
            WriteActivity.this.oi(false);
            WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void og(boolean z) {
        if (bHJ() != null && bHJ().getVisibility() == 0 && bHJ().getText() != null) {
            int selectionEnd = bHJ().getSelectionEnd();
            SpannableStringBuilder b = this.hiv.b(bHJ().getText());
            if (b != null) {
                this.hiv.nT(true);
                bHJ().setText(b);
                if (z && this.hiv.bET() >= 0) {
                    bHJ().requestFocus();
                    bHJ().setSelection(this.hiv.bET());
                } else {
                    bHJ().setSelection(selectionEnd);
                }
                this.hiv.nS(this.hiv.bET() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        if (bHI() != null && bHI().getText() != null) {
            int selectionEnd = bHI().getSelectionEnd();
            SpannableStringBuilder b = this.hfG.b(bHI().getText());
            if (b != null) {
                this.hfG.nT(true);
                bHI().setText(b);
                if (z && this.hfG.bET() >= 0) {
                    bHI().requestFocus();
                    bHI().setSelection(this.hfG.bET());
                } else {
                    bHI().setSelection(selectionEnd);
                }
                this.hfG.nS(this.hfG.bET() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DD() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void DE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DF();
        } else if (this.aDy.bxa()) {
            DD();
        } else {
            this.aDy.ne(false);
            a(1, true, (String) null);
            this.aDy.bwY();
        }
    }

    private void DF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.hh()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aDy.YM();
                } else {
                    WriteActivity.this.aDL.DS();
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
        aVar.tk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHt() {
        int selectionEnd = bHI().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHI().getText().getSpans(0, bHI().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHI().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHI().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHu() {
        if (this.aBU != null) {
            this.aBU.setBarLauncherEnabled(!this.hiz);
            this.aBU.d(true, 26);
            this.aBU.d(true, 2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hil) {
            this.gie.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hiT.setVisibility(8);
            } else {
                this.hiT.setVisibility(0);
            }
            b(this.hiW, this.hiQ);
            b(this.hiV, this.hiU);
            bpM();
        }
        if (this.hiD) {
            this.hiz = true;
            bHu();
            if (this.aBU != null) {
                this.aBU.Bm();
            }
            this.gie.requestFocus();
            ShowSoftKeyPadDelay(this.gie);
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
            bIc();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bHP();
            }
            oj(true);
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
        this.hiv = new com.baidu.tieba.write.b();
        this.hiv.vA(d.C0082d.cp_cont_i);
        this.hiv.vB(d.C0082d.cp_cont_h_alpha85);
        this.hfG = new com.baidu.tieba.write.b();
        this.hfG.vA(d.C0082d.cp_cont_i);
        this.hfG.vB(d.C0082d.cp_cont_h_alpha85);
        if (this.mData.getType() == 0) {
            wf(this.hcn);
        }
        initUI();
        bHU();
        this.aDy = new LocationModel(this);
        this.aDy.a(this.aDL);
        registerListener(this.gBs);
        registerListener(this.hix);
        initEditor();
        bIe();
        if (this.hil) {
            this.hiP.setEditorTools(this.aBU);
        } else {
            this.bHn.requestFocus();
        }
        Bo();
        bHP();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBU = new com.baidu.tbadk.editortools.i(getActivity());
        this.aBU.setBarMaxLauCount(5);
        this.aBU.setMoreButtonAtEnd(true);
        this.aBU.setBarLauncherType(1);
        this.aBU.bx(true);
        this.aBU.by(true);
        this.aBU.setMoreLauncherIcon(d.f.write_more);
        this.aBU.setBackgroundColorId(d.C0082d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bHS();
                break;
            default:
                bHv();
                break;
        }
        this.aBU.De();
        if (this.hhT != null) {
            this.hhT.addView(this.aBU);
        }
        bHw();
        this.aBU.lE();
        com.baidu.tbadk.editortools.l eN = this.aBU.eN(6);
        if (eN != null && !TextUtils.isEmpty(this.aDD)) {
            ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aDD);
                }
            });
        }
        if (!this.hil) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aBU.Bm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
    }

    private void bHQ() {
        this.hiR = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hiT = this.hiR.findViewById(d.g.live_post_title_container);
        this.hiQ = (EditText) this.hiR.findViewById(d.g.live_post_content);
        this.hiO = (GridView) this.hiR.findViewById(d.g.photoLiveGridView);
        this.hiU = (EditText) this.hiR.findViewById(d.g.live_post_title);
        this.hiV = (TextView) this.hiR.findViewById(d.g.titleOverPlusNumber);
        this.hiW = (TextView) this.hiR.findViewById(d.g.contentOverPlusNumber);
        this.hiS = this.hiR.findViewById(d.g.live_interval_view);
        this.hiV.setText(String.valueOf(20));
        this.hiW.setText(String.valueOf(233));
        this.hiR.setVisibility(0);
        this.hiV.setVisibility(0);
        this.hiW.setVisibility(0);
        this.hiU.setHint(d.j.tips_title_limit_new);
        this.hiU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hiZ = true;
                    WriteActivity.this.hiz = true;
                    WriteActivity.this.bHu();
                    if (WriteActivity.this.aBU != null) {
                        WriteActivity.this.aBU.Bm();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hiQ.setHint(d.j.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hiQ.setHint(d.j.live_write_input_content_update);
        }
        this.hiQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hiZ = false;
                    WriteActivity.this.hiz = false;
                    WriteActivity.this.bHu();
                    if (WriteActivity.this.aBU != null) {
                        WriteActivity.this.aBU.Bm();
                    }
                }
            }
        });
        this.hiQ.requestFocus();
        this.hiQ.addTextChangedListener(bdP());
        this.hiU.requestFocus();
        this.hiU.addTextChangedListener(bdP());
        this.hiU.setOnClickListener(this.hiy);
        this.hiQ.setOnClickListener(this.hiy);
        this.hiP = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hiO);
        this.hiP.vR(6);
        this.hiO.setAdapter((ListAdapter) this.hiP);
        View findViewById = this.hiR.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bGE() {
                WriteActivity.this.aKL();
            }
        });
        bHR();
    }

    private void bHR() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hiU.setText(this.mData.getTitle());
                this.hiU.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hil) {
            bIa();
        }
        if (this.aBU.Dg()) {
            this.aBU.Bm();
        }
        wf(0);
    }

    private void wf(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bHS() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aBU.B(arrayList);
        com.baidu.tbadk.editortools.r eP = this.aBU.eP(5);
        if (eP != null) {
            eP.aCD = 2;
            eP.aCB = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aCB = d.f.write_at;
        this.aBU.b(aVar);
        this.aBU.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bHv() {
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aCB = d.f.write_picture;
        this.aBU.b(dVar);
        Boolean bHY = bHY();
        if (!this.hiD && bHY != null && bHY.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bxv() && o.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar5 = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar5.aCD = 3;
            rVar5.aCB = d.f.write_recorder;
            this.aBU.b(rVar5);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 4);
        aVar.aCB = d.f.write_at;
        this.aBU.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aCD = 5;
            rVar4.aCB = d.f.write_privilege;
            this.aBU.b(rVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aCD = 6;
            rVar3.aCB = this.hiD ? d.f.write_location : d.f.icon_post_more_location;
            this.aBU.b(rVar3);
        }
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 7);
        this.aBU.b(aVar2);
        aVar2.aCB = d.f.icon_post_more_topic;
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aCF = true;
            rVar2.aCD = 9;
            rVar2.aCB = 0;
            this.aBU.b(rVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask5 != null && (rVar = (com.baidu.tbadk.editortools.r) runTask5.getData()) != null) {
            rVar.aCF = true;
            rVar.aCD = 10;
            rVar.aCB = 0;
            this.aBU.b(rVar);
        }
        if (this.hhY == null) {
            if (this.hiu == null) {
                this.hiu = new com.baidu.tieba.write.editor.c(getActivity(), this.hef);
            }
            this.aBU.b(this.hiu);
        }
        this.aBU.B(arrayList);
        com.baidu.tbadk.editortools.r eP = this.aBU.eP(5);
        if (eP != null) {
            eP.aCD = 1;
            eP.aCB = d.f.write_emotion;
        }
    }

    private void bHw() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bHH()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ak("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bHH()) {
                            WriteActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof m)) {
                            WriteActivity.this.d((m) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bHK();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aTY();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bIc();
                        WriteActivity.this.bpM();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.wg(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new ak("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hhY == null) {
                            WriteActivity.this.DG();
                            return;
                        }
                        switch (WriteActivity.this.aDE) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aK(pageActivity)) {
                                    WriteActivity.this.DE();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.DD();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aDy != null) {
                            WriteActivity.this.aDy.ne(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.evy = null;
                        } else {
                            WriteActivity.this.evy = (String) aVar.data;
                        }
                        WriteActivity.this.oi(false);
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
                            WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aBU.Dg()) {
                                        WriteActivity.this.aBU.Bm();
                                        WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bpM();
                        if (WriteActivity.this.bHn != null) {
                            WriteActivity.this.bHn.requestFocus();
                        }
                        WriteActivity.this.aBU.Bm();
                        WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHn);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ak("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hhR = true;
                        WriteActivity.this.oh(true);
                        if (WriteActivity.this.bHJ().isFocused()) {
                            WriteActivity.this.hhQ = "from_title";
                        } else if (WriteActivity.this.bHI().isFocused()) {
                            WriteActivity.this.hhQ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hhU.setVisibility(0);
                        WriteActivity.this.hhU.requestFocus();
                        WriteActivity.this.bpM();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hhU.hasFocus()) {
                            WriteActivity.this.bHn.requestFocus();
                            WriteActivity.this.bHn.setSelection(WriteActivity.this.bHn.getText().toString().length());
                        }
                        WriteActivity.this.hhU.setVisibility(8);
                        WriteActivity.this.bpM();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aBU.a(16, bVar);
        this.aBU.a(14, bVar);
        this.aBU.a(24, bVar);
        this.aBU.a(3, bVar);
        this.aBU.a(10, bVar);
        this.aBU.a(11, bVar);
        this.aBU.a(12, bVar);
        this.aBU.a(13, bVar);
        this.aBU.a(15, bVar);
        this.aBU.a(18, bVar);
        this.aBU.a(20, bVar);
        this.aBU.a(25, bVar);
        this.aBU.a(27, bVar);
        this.aBU.a(29, bVar);
        this.aBU.a(43, bVar);
        this.aBU.a(45, bVar);
        this.aBU.a(53, bVar);
        this.aBU.a(48, bVar);
        this.aBU.a(46, bVar);
        this.aBU.a(49, bVar);
        this.aBU.a(47, bVar);
        this.aBU.a(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DG() {
        if (this.aDy.YI()) {
            if (this.aDy.bxa()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bwW().getLocationData().bwS());
                return;
            }
            a(1, true, (String) null);
            this.aDy.bwY();
            return;
        }
        a(0, true, (String) null);
    }

    protected void bpE() {
        if (this.aDz != null) {
            this.aDz.cancelLoadData();
        }
        if (this.hhV != null) {
            this.hhV.cancelLoadData();
        }
        if (this.aDy != null) {
            this.aDy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bpE();
        bHX();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hiN != null) {
            this.hiN.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGP() {
        if (this.mData != null && this.mData.getType() == 2 && this.hiK) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bHJ().getText().toString());
            this.mData.setContent(bHI().getText().toString());
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
            if (this.gii != null && this.gii.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gii, getPageContext().getPageActivity());
                return true;
            } else if (this.aBU.Dg()) {
                this.aBU.Bm();
                return true;
            } else {
                bpE();
                bGP();
                return true;
            }
        }
        if (i == 67 && (text = bHI().getText()) != null) {
            int selectionStart = bHI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHI().onKeyDown(67, this.cvd);
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
        getLayoutMode().t(this.hje);
        if (this.hjb != null && i == 1) {
            this.hjb.setBorderColor(aj.getColor(d.C0082d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.C0082d.cp_link_tip_a, 1);
        bHu();
        aj.k(this.hiR, d.C0082d.cp_bg_line_d);
        aj.k(this.gif, d.C0082d.cp_bg_line_c);
        aj.k(this.hiS, d.C0082d.cp_bg_line_c);
        aj.k(bHJ(), d.C0082d.cp_bg_line_d);
        aj.c(this.eWs, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.evy)) {
            aj.k(bHI(), d.C0082d.cp_bg_line_d);
        }
        bpM();
        this.aBU.onChangeSkinType(i);
        if (this.hij != null) {
            this.hij.wE();
        }
        aj.i(this.mName, d.C0082d.cp_cont_b);
        bHx();
        bHy();
        if (this.hfG != null) {
            this.hfG.onChangeSkinType();
        }
        if (this.hiv != null) {
            this.hiv.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHx() {
        if (this.gie.hasFocus()) {
            this.gie.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        } else {
            this.gie.setHintTextColor(aj.getColor(d.C0082d.cp_cont_d));
        }
        if (this.bHn.hasFocus()) {
            this.bHn.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        } else {
            this.bHn.setHintTextColor(aj.getColor(d.C0082d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        if (this.gie != null && this.gie.getText() != null && this.gie.getText().toString() != null && this.gie.getPaint() != null) {
            if (this.gie.getText().toString().length() == 0) {
                this.gie.getPaint().setFakeBoldText(false);
            } else if (this.gie.getText().toString().length() > 0) {
                this.gie.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aMx = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hil = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aqy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.C0082d.cp_cont_b);
        this.hiI = (TextView) findViewById(d.g.btn_image_problem);
        bHA();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.bHu);
        this.hik = (ScrollView) findViewById(d.g.write_scrollview);
        this.hik.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.bHn != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.bHn);
                    }
                    if (WriteActivity.this.aBU != null) {
                        WriteActivity.this.aBU.Bm();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hiG = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hiH = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hhT = (LinearLayout) findViewById(d.g.tool_view);
        this.hhT.setContentDescription("..");
        this.hhU = (LinearLayout) findViewById(d.g.title_view);
        this.gif = findViewById(d.g.interval_view);
        this.hin = findViewById(d.g.hot_topic_fourm_view);
        this.hio = findViewById(d.g.hot_topic_divider);
        this.hip = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hiq = (TextView) findViewById(d.g.change_one_tv);
        bpL();
        if (this.hil) {
            this.hik.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bHQ();
        } else {
            this.hiN = new f(getPageContext(), this.mRootView);
            f fVar = this.hiN;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            fVar.nZ(z);
        }
        XG();
        if (this.hiD || this.hhS) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aiz) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.bHo = (LinearLayout) findViewById(d.g.post_content_container);
        this.bHo.setDrawingCacheEnabled(false);
        this.bHo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bHn.requestFocus();
                WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.eWp = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.eWq = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.eWs = (ImageView) findViewById(d.g.iv_delete_voice);
        this.eWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.aTY();
            }
        });
        this.aqy.setOnFocusChangeListener(this.bHu);
        this.aqy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bpE();
                WriteActivity.this.bGP();
            }
        });
        this.hiI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bHD();
        i(bHY());
        bHF();
        bHz();
        bHV();
        bHW();
        bHu();
        bHE();
        bpK();
        bHL();
        if (this.mData.getType() == 4 && this.gik != null && this.hhW != null) {
            this.gik.setVisibility(8);
            this.hhW.setVisibility(8);
        }
        bpM();
        bHT();
    }

    private void bHz() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hiD || this.hhS) {
                        if (this.hiE) {
                            this.mName.setText(d.j.feedback_vcode);
                        } else {
                            this.mName.setText(d.j.feedback);
                        }
                    } else if (this.hef != null && this.hef.equals("1")) {
                        this.mName.setText(d.j.post_to_home_page);
                    } else if (this.hef != null && this.hef.equals("2")) {
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
                    this.gie.setVisibility(0);
                    this.bHn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.j.send_reply);
                    this.bHn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gie.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.bHn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.j.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hiS.setVisibility(8);
                    return;
                case 7:
                    this.gie.setVisibility(0);
                    this.bHn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.j.post_drift_bottle);
                    return;
            }
        }
    }

    private void bHA() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.send_post));
    }

    private void bHB() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hiD && !this.hhS && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bHJ() != null) {
                bHJ().setText(d);
                bHJ().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.eWp.setVisibility(0);
            this.eWq.setVoiceModel(voiceModel);
            bpM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTY() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.ez(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.eWp.setVisibility(8);
        this.eWq.setVoiceModel(null);
        com.baidu.tbadk.editortools.r eP = this.aBU.eP(6);
        if (eP != null && eP.aBO != null) {
            eP.aBO.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bpM();
    }

    private void bHC() {
        this.hie = null;
        this.hig = -1;
        this.hii = -1;
        aa jT = z.amo().jT(1);
        if (jT != null) {
            this.hie = jT.cJX;
            this.hig = getIntent().getIntExtra("category_id", -1);
            if (this.hie != null && !this.hie.isEmpty() && this.hig >= 0) {
                this.hif = new y();
                this.hif.cJT = 0;
                this.hif.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hii = this.hif.cJT;
                this.hih = this.hif.name;
                for (y yVar : this.hie) {
                    if (yVar.cJT == this.hig) {
                        this.hii = yVar.cJT;
                        this.hih = yVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHD() {
        if (this.hie != null && !this.hie.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hij = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hij.setText(this.hih);
            this.hij.b(this.hie, this.hif, this.hii);
            this.hij.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hij.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.cJT);
                        WriteActivity.this.hii = atVar.cJT;
                        WriteActivity.this.hij.bGH();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hij.bGG();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHJ());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHI());
                }
            });
        }
    }

    private void bHT() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hiB = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hiB.setTitle(d.j.no_disturb_start_time);
        this.hiB.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hiB);
        this.hiB.setButton(-2, getPageContext().getString(d.j.cancel), this.hiB);
        return this.hiB;
    }

    private void bHE() {
        this.hhZ = (RelativeLayout) findViewById(d.g.addition_container);
        this.hia = (TextView) findViewById(d.g.addition_create_time);
        this.hib = (TextView) findViewById(d.g.addition_last_time);
        this.hic = (TextView) findViewById(d.g.addition_last_content);
        if (this.hhY != null) {
            this.hhZ.setVisibility(0);
            this.hia.setText(getPageContext().getString(d.j.write_addition_create) + am.r(this.hhY.getCreateTime() * 1000));
            if (this.hhY.getAlreadyCount() == 0) {
                this.hib.setVisibility(8);
            } else {
                this.hib.setText(getPageContext().getString(d.j.write_addition_last) + am.r(this.hhY.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hhY.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hic.setText(lastAdditionContent);
            } else {
                this.hic.setVisibility(8);
            }
            bHI().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hhY.getAlreadyCount()), Integer.valueOf(this.hhY.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hhZ.setVisibility(8);
    }

    private void bpK() {
        this.gik = findViewById(d.g.post_prefix_layout);
        this.gih = (TextView) findViewById(d.g.post_prefix);
        this.hhW = findViewById(d.g.prefix_divider);
        this.gij = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gik.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ghM = 1;
            this.gik.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gih.setVisibility(0);
                    WriteActivity.this.gik.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gii, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aBU.Bm();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gie);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHn);
                }
            });
            this.gij = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gij.setVisibility(0);
                this.gih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.gih.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gii, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aBU.Bm();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHJ());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHI());
                    }
                });
            }
            this.gii = new com.baidu.tieba.write.e(getPageContext().getPageActivity());
            this.gii.a(this);
            this.gii.setMaxHeight(l.f(getActivity(), d.e.ds510));
            this.gii.setOutsideTouchable(true);
            this.gii.setFocusable(true);
            this.gii.setOnDismissListener(this);
            this.gii.setBackgroundDrawable(aj.getDrawable(d.C0082d.cp_bg_line_d));
            int color = aj.getColor(d.C0082d.cp_cont_b);
            int color2 = aj.getColor(d.C0082d.cp_cont_c);
            aj.j(this.gih, d.C0082d.cp_bg_line_d);
            aj.c(this.gij, d.f.icon_frs_arrow_n);
            this.gih.setTextColor(color);
            this.hgO.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.d dVar = new com.baidu.tieba.write.d(getActivity());
                this.hgO.add(dVar);
                dVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    dVar.setPrefixTextColor(color2);
                } else {
                    dVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    dVar.setDividerStyle(false);
                }
                this.gii.addView(dVar);
            }
            this.gii.setCurrentIndex(0);
            this.gih.setText(prefixs.get(1));
            wb(1);
            return;
        }
        this.gik.setVisibility(8);
    }

    private void bHU() {
        if (this.hiD && this.mData != null) {
            this.hiG.setVisibility(0);
            this.hiH.setVisibility(0);
            this.hhV = new FeedBackModel(getPageContext());
            this.hhV.uQ(this.mData.getForumName());
            this.hhV.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hiG.setVisibility(8);
                        WriteActivity.this.hiH.setVisibility(8);
                        WriteActivity.this.showToast(d.j.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hiG.setVisibility(8);
                        WriteActivity.this.hiH.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hiG.a(feedBackModel.bHi(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bHF() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    WriteActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hiv.bEU()) {
                        WriteActivity.this.showToast(WriteActivity.this.hiv.bEW());
                        WriteActivity.this.og(true);
                    } else if (WriteActivity.this.hfG.bEU()) {
                        WriteActivity.this.showToast(WriteActivity.this.hfG.bEW());
                        WriteActivity.this.oa(true);
                    } else {
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHJ());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bHI());
                        WriteActivity.this.aBU.Bm();
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.hiD) {
                                WriteActivity.this.bGQ();
                                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                            } else {
                                ak akVar = new ak("c12102");
                                akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                                TiebaStatic.log(akVar);
                                WriteActivity.this.bHN();
                            }
                        } else {
                            TiebaStatic.log("c12015");
                            WriteActivity.this.bGQ();
                        }
                        TiebaStatic.log(new ak("c12262").ac("obj_locate", WriteActivity.this.hef));
                    }
                }
            }
        });
    }

    protected void bHV() {
        this.hiJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hiJ.cS(getPageContext().getString(d.j.is_save_draft)).ao(false).a(getPageContext().getString(d.j.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bHJ().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bHI().getText().toString());
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
        this.hiJ.b(getPageContext());
    }

    protected void bpL() {
        this.hiF = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hiF.setIsRound(true);
        this.hiF.setDrawBorder(false);
        this.hiF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dE = com.baidu.tbadk.core.util.o.dE(currentPortrait);
            this.hiF.setUrl(dE);
            this.hiF.startLoad(dE, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hiF.setVisibility(0);
        }
        this.gie = (EditText) findViewById(d.g.post_title);
        this.gie.setOnClickListener(this.hiy);
        this.gie.setOnFocusChangeListener(this.bHu);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gie.setText(this.mData.getTitle());
                this.gie.setSelection(this.mData.getTitle().length());
            } else if (this.hiE) {
                this.gie.setText(getResources().getString(d.j.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gie.addTextChangedListener(this.bHw);
        if (!this.mData.getHaveDraft()) {
            bHB();
            this.hji = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gie.setHint(getResources().getString(d.j.feedback_title_hint));
        } else {
            this.gie.setHint(getResources().getString(d.j.post_title_hint));
        }
    }

    private TextWatcher bdP() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int bHz;
            private EditText dUd = null;
            private TextView abZ = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bpM();
                if (WriteActivity.this.hil) {
                    this.bHz = this.dUd.getSelectionStart();
                    this.dUd.setSelection(this.bHz);
                    WriteActivity.this.b(this.abZ, this.dUd);
                }
                if (this.dUd != WriteActivity.this.hiU || WriteActivity.this.hiv == null || WriteActivity.this.hiv.bEV()) {
                    if (this.dUd == WriteActivity.this.hiQ && WriteActivity.this.hfG != null && !WriteActivity.this.hfG.bEV()) {
                        WriteActivity.this.oa(false);
                    }
                } else {
                    WriteActivity.this.og(false);
                }
                if (WriteActivity.this.hiv != null) {
                    WriteActivity.this.hiv.nT(false);
                }
                if (WriteActivity.this.hfG != null) {
                    WriteActivity.this.hfG.nT(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hil || !WriteActivity.this.hiZ) {
                    if (WriteActivity.this.hil) {
                        if (this.dUd != WriteActivity.this.hiQ || this.abZ != WriteActivity.this.hiW) {
                            this.dUd = WriteActivity.this.hiQ;
                            this.abZ = WriteActivity.this.hiW;
                        }
                    }
                } else if (this.dUd != WriteActivity.this.hiU || this.abZ != WriteActivity.this.hiV) {
                    this.dUd = WriteActivity.this.hiU;
                    this.abZ = WriteActivity.this.hiV;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hil && this.hiZ) {
            if (this.hiX != null) {
                this.hiU.removeTextChangedListener(this.hiX);
            }
            this.hiX = textWatcher;
        } else if (this.hil) {
            if (this.hiY != null) {
                this.hiQ.removeTextChangedListener(this.hiY);
            }
            this.hiY = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.hiQ) {
            return 233L;
        }
        if (editText != this.hiU) {
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
                    textView.setTextColor(aj.getColor(d.C0082d.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.C0082d.cp_cont_d));
                }
            } else if (i < 0) {
                if (i < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.C0082d.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.C0082d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long i(EditText editText) {
        return com.baidu.tieba.write.b.a.g(editText.getText().toString().trim());
    }

    protected void XG() {
        this.bHn = (EditText) findViewById(d.g.post_content);
        this.bHn.setDrawingCacheEnabled(false);
        this.bHn.setOnClickListener(this.hiy);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.Ey().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.bHn.setText(U);
            this.bHn.setSelection(U.length());
        } else if (this.mData.getType() == 2) {
            if (this.hiK) {
                if (this.hiL != null && this.hiL.length() > 0) {
                    this.bHn.setText(getPageContext().getPageActivity().getString(d.j.reply_sub_floor, new Object[]{this.hiL}));
                    this.bHn.setSelection(this.bHn.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.j.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.bHn.setText(format);
                this.bHn.setSelection(format.length());
            }
        }
        this.bHn.setOnFocusChangeListener(this.bHu);
        this.bHn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.bHn.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bHn.addTextChangedListener(this.hiA);
        if (this.mData.getType() == 0) {
            this.hjk = true;
        } else {
            oi(true);
            this.hjk = false;
        }
        if (this.mData.isUserFeedback()) {
            this.bHn.setHint(d.j.write_input_content);
        } else {
            this.bHn.setHint(d.j.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void oi(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hil) {
            bHI().setPadding(0, 0, 0, 0);
            bHI().setBackgroundDrawable(null);
            aj.k(bHI(), d.C0082d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.evy) && this.hhY == null) {
                com.baidu.adp.lib.f.c.fJ().a(this.evy, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.bHI().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bHI(), true, WriteActivity.this.fcV);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHH() {
        int i = 5000;
        if (this.hhY != null) {
            i = 1000;
        }
        return bHI().getText() != null && bHI().getText().length() >= i;
    }

    private void fS(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hhQ)) {
                this.hhQ = "";
                bHI().requestFocus();
                if (bHI().getText() != null && bHI().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHI().getSelectionStart();
                    editable = bHI().getText();
                }
            } else if ("from_title".equals(this.hhQ)) {
                this.hhQ = "";
                bHJ().requestFocus();
                if (bHJ().getText() != null && bHJ().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHJ().getSelectionStart();
                    editable = bHJ().getText();
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
    public void oh(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(m mVar) {
        if (((ImageSpan[]) bHI().getText().getSpans(0, bHI().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hhX == null) {
                this.hhX = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hhX.show();
            return;
        }
        String name = mVar.getName();
        final EmotionGroupType ya = mVar.ya();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bHI().getSelectionStart(), aVar, ya);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHI() != null && bHI().getText() != null) {
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
                int selectionStart = bHI().getSelectionStart() - 1;
                if (bHI().getText().length() > 1 && selectionStart >= 0 && bHI().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHI().getText().insert(bHI().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHI().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHI().getText().insert(bHI().getSelectionStart(), spannableString2);
            }
            Editable text = bHI().getText();
            if (text != null) {
                this.hit.clear();
                this.hit.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hit);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHI().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHI().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHI().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHI() {
        return this.hil ? this.hiQ : this.bHn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHJ() {
        return this.hil ? this.hiU : this.gie;
    }

    protected void bHK() {
        Editable text;
        if (bHI() != null && (text = bHI().getText()) != null) {
            int selectionStart = bHI().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHI().onKeyDown(67, this.cvd);
            }
            bHI().onKeyDown(67, this.cvd);
            int selectionStart2 = bHI().getSelectionStart();
            if (text != null) {
                this.hit.clear();
                this.hit.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hit);
                bHI().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.j.feedback_bar_name).equals(str)) {
            this.hiD = true;
        }
    }

    private void bHW() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bHX() {
        try {
            if (this.hiJ != null) {
                this.hiJ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aMx.c(null);
        this.aMx.db(d.j.sending);
        this.aMx.aE(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aMx.aE(false);
    }

    private Boolean bHY() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aDD = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpM() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHJ() != null) {
                str = bHJ().getText().toString();
            }
            if (bHI() != null) {
                str2 = bHI().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.ghM == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hhU.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            dx(true);
                            return;
                        }
                    } else if (this.hhU.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        dx(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hhU.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    dx(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hil) {
                    dx(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dx(true);
                }
            }
            if (this.mData.getType() == 4) {
                dx(m(this.hiQ) && l(this.hiU));
            } else if (this.mData.getType() == 5) {
                dx(m(this.hiQ));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                dx(true);
            } else if (this.mData.getVideoInfo() != null) {
                dx(true);
            } else {
                dx(false);
            }
        }
    }

    public void dx(boolean z) {
        if (z) {
            aj.b(this.mPost, d.C0082d.cp_link_tip_a, d.C0082d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.c(this.mPost, d.C0082d.cp_cont_d, 1);
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
        this.aDz = new NewWriteModel(this);
        this.aDz.b(this.aDN);
        registerListener(this.hjl);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bpE();
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
            this.hiD = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hiE = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hiK = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hiL = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aDx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hhY = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hhY != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hiM = bundle.getInt("mem_type", 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hjj = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hef = bundle.getString("KEY_CALL_FROM");
            this.hcn = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.hiD = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hiE = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hiK = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hiL = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.hhY = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hhY != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hiM = intent.getIntExtra("mem_type", 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hjj = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hef = intent.getStringExtra("KEY_CALL_FROM");
            this.hcn = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hiD);
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
        this.evy = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hhS = true;
        }
        bHC();
        try {
            this.hja = bId();
        } catch (Throwable th) {
            this.hja = null;
        }
    }

    private void bHL() {
        if (v.v(this.mList) > 0 && this.mList.get(0) != null) {
            this.hiF.setVisibility(8);
            this.hin.setVisibility(0);
            this.hio.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gie.setText(com.baidu.tbadk.plugins.a.gJ(uR(this.mList.get(0).mTopicName)));
                this.gie.setMovementMethod(com.baidu.tieba.view.d.bEa());
            }
            this.hip.setText(this.mList.get(0).mForumName);
            this.gie.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.hir.equals(charSequence.toString())) {
                        WriteActivity.this.his = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gJ;
                    if (!WriteActivity.this.hir.equals(editable.toString()) && (gJ = com.baidu.tbadk.plugins.a.gJ(editable.toString())) != null) {
                        WriteActivity.this.hir = gJ.toString();
                        WriteActivity.this.gie.setText(gJ);
                        if (WriteActivity.this.his <= WriteActivity.this.gie.getText().length()) {
                            WriteActivity.this.gie.setSelection(WriteActivity.this.his);
                        }
                    }
                }
            });
            this.hiq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
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
            SpannableString gJ = com.baidu.tbadk.plugins.a.gJ(uR(hotTopicBussinessData.mTopicName));
            if (gJ != null) {
                this.gie.setText(gJ);
            }
            this.hip.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String uR(String str) {
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
        String uR;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (k.isEmpty(bHJ().getText().toString()) || this.hji || ((this.hiD || this.hhS) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.w(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            uR = this.mData.getTitle();
                        } else {
                            uR = uR(str);
                        }
                        SpannableString gJ = com.baidu.tbadk.plugins.a.gJ(uR);
                        if (gJ != null) {
                            bHJ().setText(gJ);
                            bHJ().setSelection(gJ.length() > uR.length() ? uR.length() : gJ.length());
                        }
                    } else {
                        SpannableString gJ2 = com.baidu.tbadk.plugins.a.gJ(this.mData.getTitle());
                        if (gJ2 != null) {
                            bHJ().setText(gJ2);
                            bHJ().setSelection(this.mData.getTitle().length() > gJ2.length() ? gJ2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bHB();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bHI().getText().toString()) || this.hiD || this.hhS) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ey().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hiw);
                    bHI().setText(a2);
                    bHI().setSelection(a2.length());
                    if (this.hil) {
                        b(this.hiW, this.hiQ);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bIc();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bHP();
                    }
                    oj(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bHZ();
                }
                bpM();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hie != null) {
                    this.hii = this.hif.cJT;
                    this.hih = this.hif.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hie.size()) {
                            break;
                        }
                        y yVar = this.hie.get(i);
                        if (categoryTo != yVar.cJT) {
                            i++;
                        } else {
                            this.hii = categoryTo;
                            this.hih = yVar.name;
                            this.mData.setCategoryTo(this.hii);
                            break;
                        }
                    }
                    if (this.hij != null) {
                        this.hij.setText(this.hih);
                        this.hij.b(this.hie, this.hif, this.hii);
                    }
                }
                this.aBU.Bm();
                return;
            }
            return;
        }
        bHZ();
        bHB();
    }

    private void bHZ() {
        if ((!this.hil || this.hiP != null) && this.hiO != null) {
            this.hiP.c(this.writeImagesInfo);
            aKL();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hiK);
        if (this.hiD) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDx);
        if (this.hhY != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hhY));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt("mem_type", this.hiM);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hef);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hcn);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHI().getEditableText().toString();
        if (obj != null) {
            bHI().setText(TbFaceManager.Ey().a(getPageContext().getPageActivity(), obj, this.hiw));
            bHI().setSelection(bHI().getText().length());
        }
    }

    private String bHM() {
        return (bHI() == null || bHI().getText() == null) ? "" : bHI().getText().toString();
    }

    private String bes() {
        if (this.mData == null || bHJ() == null || bHJ().getVisibility() != 0 || bHJ().getText() == null) {
            return "";
        }
        String obj = bHJ().getText().toString();
        if (this.mPrefixData != null && v.v(this.mPrefixData.getPrefixs()) > 0 && this.ghM != 0 && this.mData.getType() != 4 && this.gih != null && this.gih.getText() != null) {
            obj = this.gih.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uS(String str) {
        if (this.mData != null && this.hhU != null) {
            if (this.hhU.getVisibility() == 0) {
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
    public void bGQ() {
        bpE();
        this.mData.setContent(bHM());
        uS(bes());
        if (this.hiD || this.hhS) {
            String string = getResources().getString(d.j.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                uS(string + this.mData.getTitle());
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
        if (this.hig >= 0) {
            this.mData.setCategoryFrom(this.hig);
        }
        if (this.hii >= 0) {
            this.mData.setCategoryTo(this.hii);
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
        this.mData.setHasLocationData(this.aDy != null && this.aDy.YI());
        if (this.writeImagesInfo != null) {
            this.aDz.ng(this.writeImagesInfo.size() > 0);
        }
        if (!v.w(this.mList) && this.him != null && this.him.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.him.mForumId));
            this.mData.setForumName(this.him.mForumName);
        }
        this.aDz.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aDz.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aDz.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aDz.getWriteData().setVoice(null);
                this.aDz.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aDz.getWriteData().setVoice(null);
            this.aDz.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aDz.bxw()) {
            showToast(d.j.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.hh()) {
            showToast(d.j.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
            this.aDz.startPostWrite();
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
            if (this.hhY != null) {
                i2 = this.hhY.getTotalCount();
                i = this.hhY.getAlreadyCount() + 1;
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
                bHI().requestFocus();
                if (this.aBU != null) {
                    this.aBU.Bm();
                }
                ShowSoftKeyPadDelay(this.bHn);
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
                            bHI().getText().insert(bHI().getSelectionStart(), sb.toString());
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
                                bfn();
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
                        if (this.hjk) {
                            oi(true);
                            this.hjk = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hil) {
                        A(intent);
                        bpM();
                        return;
                    }
                    ak(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aBU.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aBU.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aBU.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bpM();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hhR) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.hhR = false;
                            }
                            sb2.append(stringExtra);
                            fS(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.w(this.mList) && !v.w(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.him = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.him);
                }
            }
        } else if (i2 == 0) {
            if (this.aBU != null && !this.aBU.Dg()) {
                this.bHn.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aBU.Bm();
            }
            switch (i) {
                case 12001:
                    DJ();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bIb();
                    if (this.hjk) {
                        oi(true);
                        this.hjk = false;
                        return;
                    }
                    return;
                case 12004:
                    bHI().requestFocus();
                    if (this.aBU != null) {
                        this.aBU.Bm();
                    }
                    ShowSoftKeyPadDelay(this.bHn);
                    return;
                case 12006:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hfG.aB(postWriteCallBackData.getSensitiveWords());
                        this.hiv.aB(postWriteCallBackData.getSensitiveWords());
                        if (!v.w(this.hfG.bES())) {
                            oa(true);
                            og(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 12009:
                default:
                    return;
                case 12010:
                    this.aDx = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aDx);
                    return;
                case 12012:
                    bIb();
                    return;
                case 25004:
                    if ("from_title".equals(this.hhQ)) {
                        bHJ().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hhQ)) {
                        bHI().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHN() {
        if ("1".equals(this.hef)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hef)) {
            this.mData.setCanNoForum(false);
        }
        bHO();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hef);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bGQ();
    }

    private void bHO() {
        if (this.aBU != null) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bIa() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bIb() {
        if (this.hil) {
            this.hiP.c(this.writeImagesInfo);
            aKL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKL() {
        this.hiP.notifyDataSetChanged();
        this.hiO.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hiP.notifyDataSetChanged();
                WriteActivity.this.hiO.invalidateViews();
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
        bpM();
    }

    private void ah(Intent intent) {
        if (this.hil) {
            ak(intent);
            bIb();
        } else {
            al(intent);
        }
        bpM();
    }

    private void ak(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bIb();
            oj(true);
        }
    }

    private void ai(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bfn() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void Y(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fHC.parseJson(stringExtra);
            this.fHC.updateQuality();
            if (this.fHC.getChosedFiles() != null && this.fHC.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fHC.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fHC.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHJ());
        HidenSoftKeyPad(this.mInputManager, bHI());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void al(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aDx = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDx;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ac(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ae(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDx, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bIc();
            bHP();
        }
        oj(true);
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
                bIc();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bHP();
                }
            }
            oj(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIc() {
        if (this.aBU.eP(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DJ() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aDx));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void oj(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hiN != null) {
            this.hiN.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cGZ == null) {
            this.cGZ = VoiceManager.instance();
        }
        return this.cGZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void als() {
        this.cGZ = getVoiceManager();
        this.cGZ.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.uq(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cHQ) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahP));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hhY == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                t(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDE = i;
        if (this.aBU != null) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHP() {
        if (!this.hil) {
            if (this.aBU != null) {
                this.aBU.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aBU.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hiN != null) {
                this.hiN.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aBU != null) {
            this.aBU.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wb(int i) {
        if (i < this.hgO.size()) {
            for (int i2 = 0; i2 < this.hgO.size(); i2++) {
                this.hgO.get(i2).nV(false);
            }
            this.hgO.get(i).nV(true);
        }
    }

    @Override // com.baidu.tieba.write.e.a
    public void tC(int i) {
        this.ghM = i;
        this.gii.setCurrentIndex(i);
        wb(i);
        this.gih.setText(this.mPrefixData.getPrefixs().get(i));
        bpM();
        com.baidu.adp.lib.g.g.a(this.gii, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gik.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.b.a.a.InterfaceC0022a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            DE();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aL(getApplicationContext())) {
                ai.b(getPageContext(), this.aDx);
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
        if (this.hjg && System.currentTimeMillis() - this.hjh < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.hjg = false;
        }
        if (this.hiu != null && !z) {
            this.hiu.aWg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uT(String str) {
        if (!k.isEmpty(str) && this.hjd != null) {
            uU(str);
            this.hjd.dismiss();
        }
    }

    private void cm(Context context) {
        hjf = l.ae(context);
    }

    private void uU(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.j.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hjg = true;
        bIc();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bHP();
        }
        oj(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4273=4] */
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

    private File bId() {
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

    private void bIe() {
        if (this.hja != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cm(getActivity());
            this.hjc = getPageContext().getPageActivity().getLayoutInflater().inflate(d.h.rec_dialog, (ViewGroup) null);
            this.hjc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hja != null) {
                        WriteActivity.this.uT(WriteActivity.this.hja.getAbsolutePath());
                    }
                }
            });
            this.hjb = (TbImageView) this.hjc.findViewById(d.g.rec_img_view);
            this.hje = (LinearLayout) this.hjc.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hja.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hja.getAbsolutePath());
                Bitmap d = d(this.hja.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (d != null) {
                    this.hjb.setImageBitmap(d);
                    this.hjb.setDrawBorder(true);
                    this.hjb.setBorderWidth(2);
                    this.hjb.setBorderColor(aj.getColor(d.C0082d.common_color_10264));
                    this.hjd = new Dialog(getActivity(), d.k.bubble_dialog);
                    this.hjd.setCanceledOnTouchOutside(true);
                    this.hjd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hjg) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hjh = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hjd.setContentView(this.hjc);
                    this.hjd.show();
                    Window window = this.hjd.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hjf / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
            this.hhR = false;
            this.hhQ = "";
            if ("from_content".equals(str)) {
                this.hhQ = "from_content";
            } else if ("from_title".equals(str)) {
                this.hhQ = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                oh(false);
            }
        }
    }

    public void Bo() {
        if (this.hiD || !v.w(this.mList)) {
            this.hhU.setVisibility(0);
            this.hhU.requestFocus();
            this.aBU.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hhU.setVisibility(8);
    }
}
