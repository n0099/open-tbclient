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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
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
import com.baidu.tieba.tbadkCore.imgView.e;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.d;
import com.baidu.tieba.write.view.NewFrameMultiImgToolView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0022a, VoiceManager.c, r.a, d.a {
    private static int gMy = 0;
    private i aAB;
    private VoiceData.VoiceModel aCl;
    private String aCm;
    private LocationModel aCn;
    private NewWriteModel aCo;
    private VoiceManager cqg;
    private TextView fPA;
    private com.baidu.tieba.write.d fPB;
    private ImageView fPC;
    private View fPD;
    private int fPg;
    private com.baidu.tieba.write.a gJr;
    private LinearLayout gLG;
    private LinearLayout gLH;
    private View gLK;
    private View gLL;
    private Toast gLR;
    private AdditionData gLS;
    private RelativeLayout gLT;
    private TextView gLU;
    private TextView gLV;
    private TextView gLW;
    List<y> gLY;
    y gLZ;
    private HotTopicBussinessData gMD;
    private View gME;
    private View gMF;
    private TextView gMG;
    private TextView gMH;
    private com.baidu.tieba.write.b.b gMM;
    private com.baidu.tieba.view.a gMT;
    private int gMa;
    private String gMb;
    private int gMc;
    private PostCategoryView gMd;
    private NewFrameMultiImgToolView gMe;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gLA = "";
    private boolean gLB = false;
    private WriteData mData = null;
    private boolean gLC = false;
    private boolean gLD = false;
    private boolean gLE = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fPx = null;
    private HeadImageView gLF = null;
    private View fPy = null;
    private LinearLayout btu = null;
    private EditText btt = null;
    private FeedBackModel gLI = null;
    private FeedBackTopListView gLJ = null;
    private ArrayList<com.baidu.tieba.write.c> gKD = new ArrayList<>();
    private String ehV = null;
    private final KeyEvent gLM = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View apM = null;
    private TextView gLN = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gLO = null;
    private final Handler mHandler = new Handler();
    private boolean gLP = false;
    private String gLQ = null;
    private RelativeLayout mParent = null;
    private String aCs = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aCu = 0;
    private int gLX = 0;
    private WriteImagesInfo fpL = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gMf = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gMg = null;
    private ScrollView gMh = null;
    private EditText gMi = null;
    private View gMj = null;
    private View gMk = null;
    private View gMl = null;
    private EditText gMm = null;
    private TextView gMn = null;
    private TextView gMo = null;
    private TextWatcher gMp = null;
    private TextWatcher gMq = null;
    private boolean gMr = false;
    private boolean gMs = false;
    private com.baidu.tbadk.core.view.a aLe = null;
    private String aie = AlbumActivityConfig.FROM_WRITE;
    private File gMt = null;
    private TbImageView gMu = null;
    private View gMv = null;
    private Dialog gMw = null;
    private LinearLayout gMx = null;
    private boolean gMz = false;
    private long gMA = -1000;
    private boolean gMB = false;
    private String gIn = "2";
    private boolean gMC = false;
    private String gMI = "";
    private String gMJ = "";
    private int gMK = 0;
    private SpannableStringBuilder gML = new SpannableStringBuilder();
    private final HttpMessageListener gMN = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ehV)) {
                    WriteActivity.this.ehV = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nw(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ehV)) {
                    WriteActivity.this.ehV = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ehV);
                    WriteActivity.this.nw(true);
                }
            }
        }
    };
    private TbFaceManager.a gMO = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gb(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kN());
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
    private final AntiHelper.a cqX = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.agX));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.agX));
        }
    };
    private final NewWriteModel.d aCE = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.ahc();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                if (z) {
                    WriteActivity.this.bK(z);
                    if (WriteActivity.this.c(writeData)) {
                        WriteActivity.this.a(true, postWriteCallBackData);
                    }
                    if (WriteActivity.this.mData.getType() != 0 && WriteActivity.this.mData.getType() != 9) {
                        if (WriteActivity.this.mData.getType() != 7) {
                            if (WriteActivity.this.mData.getType() == 1) {
                                r.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                            } else if (WriteActivity.this.mData.getType() == 4) {
                                r.c(WriteActivity.this.mData.getForumId() + "photolive", (WriteData) null);
                                if (postWriteCallBackData != null) {
                                    WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE, 18003)));
                                }
                            } else if (WriteActivity.this.mData.getType() == 5) {
                                r.d(WriteActivity.this.mData.getThreadId() + "updatephotolive", (WriteData) null);
                            }
                        } else if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            r.c("24591571", (WriteData) null);
                        }
                    } else {
                        if (WriteActivity.this.getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                            r.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                            if (postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(WriteActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET, 18003)));
                            }
                        }
                        if (!v.u(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gMI)) {
                            TiebaStatic.log(new ak("c11731").ac("obj_id", WriteActivity.this.gMI));
                        }
                    }
                    WriteActivity.this.d(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, postWriteCallBackData);
                    intent.putExtras(bundle);
                    WriteActivity.this.setResult(-1, intent);
                    WriteActivity.this.finish();
                } else if ((qVar == null || writeData == null || qVar.getVcode_pic_url() == null || AntiHelper.h(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.a(false, postWriteCallBackData);
                } else if (qVar != null && writeData != null && qVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.xT());
                    if (com.baidu.tbadk.p.a.gS(qVar.xS())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xS());
                        if (WriteActivity.this.gLE) {
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
    private final LocationModel.a aCC = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Dk() {
            WriteActivity.this.showToast(d.l.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void fQ(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.l.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.brS())) {
                WriteActivity.this.a(2, true, aVar.brS());
            } else {
                fQ(null);
            }
        }
    };
    private final CustomMessageListener giI = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aCn.mD(false);
                    WriteActivity.this.aCn.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aCn.mD(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener gMP = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener gMQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bAW = WriteActivity.this.bAW();
            if (bAW >= 0 && bAW < WriteActivity.this.btt.getText().length()) {
                WriteActivity.this.btt.setSelection(bAW);
            }
        }
    };
    private boolean gMR = true;
    private final View.OnFocusChangeListener btA = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fPx || view == WriteActivity.this.apM || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gMR = true;
                    WriteActivity.this.bAX();
                    if (WriteActivity.this.aAB != null) {
                        WriteActivity.this.aAB.AH();
                    }
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.fPx);
                } else if (view == WriteActivity.this.fPx) {
                    WriteActivity.this.fPA.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.btt && z) {
                WriteActivity.this.gMR = false;
                WriteActivity.this.bAX();
                WriteActivity.this.aAB.AH();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.btt);
            }
        }
    };
    private TextWatcher btC = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bkM();
        }
    };
    private TextWatcher gMS = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bkM();
        }
    };
    private final a.InterfaceC0124a eKZ = new a.InterfaceC0124a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0124a
        public void lc() {
            WriteActivity.this.ehV = null;
            WriteActivity.this.nw(false);
            WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aie)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void CW() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.l.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            CX();
        } else if (this.aCn.bsa()) {
            CV();
        } else {
            this.aCn.mD(false);
            a(1, true, (String) null);
            this.aCn.brY();
        }
    }

    private void CX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aCn.UW();
                } else {
                    WriteActivity.this.aCC.Dk();
                }
                aVar2.dismiss();
            }
        }).b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.45
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bAW() {
        int selectionEnd = bBo().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bBo().getText().getSpans(0, bBo().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bBo().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bBo().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAX() {
        if (this.aAB != null) {
            this.aAB.setBarLauncherEnabled(!this.gMR);
            this.aAB.d(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gMr) {
            this.fPx.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gMl.setVisibility(8);
            } else {
                this.gMl.setVisibility(0);
            }
            b(this.gMo, this.gMi);
            b(this.gMn, this.gMm);
            bkM();
        }
        if (this.gLC) {
            this.gMR = true;
            bAX();
            if (this.aAB != null) {
                this.aAB.AH();
            }
            this.fPx.requestFocus();
            ShowSoftKeyPadDelay(this.fPx);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        bBk();
        this.aCn = new LocationModel(this);
        this.aCn.a(this.aCC);
        registerListener(this.giI);
        registerListener(this.gMP);
        initEditor();
        bBC();
        if (this.gMr) {
            this.gMg.setEditorTools(this.aAB);
        } else {
            this.btt.requestFocus();
        }
        AJ();
        Df();
        this.gJr = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aAB = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aAB.setBarMaxLauCount(6);
        } else {
            this.aAB.setBarMaxLauCount(5);
        }
        this.aAB.setMoreButtonAtEnd(true);
        this.aAB.setBarLauncherType(1);
        this.aAB.bB(true);
        this.aAB.setMoreLauncherIcon(d.g.write_more);
        this.aAB.setBackgroundColorId(d.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bBa();
                break;
            default:
                bBb();
                break;
        }
        this.aAB.Cu();
        if (this.gLG != null) {
            this.gLG.addView(this.aAB);
        }
        bBc();
        this.aAB.lM();
        com.baidu.tbadk.editortools.l eM = this.aAB.eM(6);
        if (eM != null && !TextUtils.isEmpty(this.aCs)) {
            ((View) eM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aCs);
                }
            });
        }
        if (!this.gMr) {
            this.aAB.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aAB.AH();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aAB.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aAB.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.btz = this.mData.getForumName() + getResources().getString(d.l.forum);
        }
        this.aAB.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gMe != null) {
            this.gMe.setEditorTools(this.aAB);
            this.gMe.bAh();
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.aie);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bAY() {
        this.gMj = this.mRootView.findViewById(d.h.photo_live_scroll);
        this.gMl = this.gMj.findViewById(d.h.live_post_title_container);
        this.gMi = (EditText) this.gMj.findViewById(d.h.live_post_content);
        this.gMf = (GridView) this.gMj.findViewById(d.h.photoLiveGridView);
        this.gMm = (EditText) this.gMj.findViewById(d.h.live_post_title);
        this.gMn = (TextView) this.gMj.findViewById(d.h.titleOverPlusNumber);
        this.gMo = (TextView) this.gMj.findViewById(d.h.contentOverPlusNumber);
        this.gMk = this.gMj.findViewById(d.h.live_interval_view);
        this.gMn.setText(String.valueOf(20));
        this.gMo.setText(String.valueOf(233));
        this.gMj.setVisibility(0);
        this.gMn.setVisibility(0);
        this.gMo.setVisibility(0);
        this.gMm.setHint(d.l.tips_title_limit_new);
        this.gMm.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gMs = true;
                    WriteActivity.this.gMR = true;
                    WriteActivity.this.bAX();
                    if (WriteActivity.this.aAB != null) {
                        WriteActivity.this.aAB.AH();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gMi.setHint(d.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gMi.setHint(d.l.live_write_input_content_update);
        }
        this.gMi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gMs = false;
                    WriteActivity.this.gMR = false;
                    WriteActivity.this.bAX();
                    if (WriteActivity.this.aAB != null) {
                        WriteActivity.this.aAB.AH();
                    }
                }
            }
        });
        this.gMi.requestFocus();
        this.gMi.addTextChangedListener(aYY());
        this.gMm.requestFocus();
        this.gMm.addTextChangedListener(aYY());
        this.gMm.setOnClickListener(this.gMQ);
        this.gMi.setOnClickListener(this.gMQ);
        this.gMg = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gMf);
        this.gMg.uW(6);
        this.gMf.setAdapter((ListAdapter) this.gMg);
        View findViewById = this.gMj.findViewById(d.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bAm() {
                WriteActivity.this.aHC();
            }
        });
        bAZ();
    }

    private void bAZ() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gMm.setText(this.mData.getTitle());
                this.gMm.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.gMr) {
            bBy();
        }
        if (this.aAB.Cw()) {
            this.aAB.AH();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", this.aie);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bBa() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aAB.z(arrayList);
        com.baidu.tbadk.editortools.r eO = this.aAB.eO(5);
        if (eO != null) {
            eO.aBj = 2;
            eO.aBh = d.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aBh = d.g.write_at;
        this.aAB.b(aVar);
        this.aAB.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bBb() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aBh = d.g.write_picture;
            this.aAB.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aAB.b(aVar);
        aVar.aBh = d.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aBj = 6;
            rVar4.aBh = d.g.write_privilege;
            this.aAB.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aBh = d.g.write_at;
        this.aAB.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aBl = true;
            rVar3.aBj = 9;
            rVar3.aBh = 0;
            this.aAB.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aBl = true;
            rVar2.aBj = 10;
            rVar2.aBh = 0;
            this.aAB.b(rVar2);
        }
        Boolean bBt = bBt();
        if (!this.gLC && bBt != null && bBt.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bsu() && m.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aBj = 2;
            rVar.aBh = d.g.write_recorder;
            this.aAB.b(rVar);
        }
        if (this.gLS == null) {
            if (this.gMM == null) {
                this.gMM = new com.baidu.tieba.write.b.b(getActivity(), this.gIn);
            }
            this.aAB.b(this.gMM);
        }
        this.aAB.z(arrayList);
        com.baidu.tbadk.editortools.r eO = this.aAB.eO(5);
        if (eO != null) {
            eO.aBj = 1;
            eO.aBh = d.g.write_emotion;
        }
    }

    private void bBc() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                int size;
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bBn()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bBn()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.d((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bBq();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aCl = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.bkM();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aCl = null;
                        WriteActivity.this.bkM();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bBA();
                        WriteActivity.this.bkM();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            int intValue = ((Integer) aVar.data).intValue();
                            if (WriteActivity.this.writeImagesInfo != null && WriteActivity.this.writeImagesInfo.getChosedFiles() != null && (size = WriteActivity.this.writeImagesInfo.getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12012, WriteActivity.this.writeImagesInfo, intValue)));
                            }
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gLS == null) {
                            WriteActivity.this.CY();
                            return;
                        }
                        switch (WriteActivity.this.aCu) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aI(pageActivity)) {
                                    WriteActivity.this.CW();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.CV();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ehV = null;
                        } else {
                            WriteActivity.this.ehV = (String) aVar.data;
                        }
                        WriteActivity.this.nw(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ac("fid", str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aAB.Cw()) {
                                        WriteActivity.this.aAB.AH();
                                        WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(WriteActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.l.plugin_video_not_active), WriteActivity.this.getResources().getString(d.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(WriteActivity.this.getPageContext(), WriteActivity.this.getResources().getString(d.l.plugin_video_install_tips), WriteActivity.this.getResources().getString(d.l.plugin_go_install));
                            return;
                        }
                        WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bkM();
                        if (WriteActivity.this.btt != null) {
                            WriteActivity.this.btt.requestFocus();
                        }
                        WriteActivity.this.aAB.AH();
                        WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.btt);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gLB = true;
                        WriteActivity.this.nx(true);
                        if (WriteActivity.this.bBp().isFocused()) {
                            WriteActivity.this.gLA = "from_title";
                        } else if (WriteActivity.this.bBo().isFocused()) {
                            WriteActivity.this.gLA = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.gLH.setVisibility(0);
                        WriteActivity.this.gLH.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gJr.cm(WriteActivity.this.getThreadTitle(), WriteActivity.this.bBw());
                        TiebaStatic.log(new ak("c12258").ac("obj_locate", WriteActivity.this.gIn));
                    }
                }
            }
        };
        this.aAB.a(16, bVar);
        this.aAB.a(14, bVar);
        this.aAB.a(24, bVar);
        this.aAB.a(3, bVar);
        this.aAB.a(10, bVar);
        this.aAB.a(11, bVar);
        this.aAB.a(12, bVar);
        this.aAB.a(13, bVar);
        this.aAB.a(15, bVar);
        this.aAB.a(18, bVar);
        this.aAB.a(25, bVar);
        this.aAB.a(27, bVar);
        this.aAB.a(29, bVar);
        this.aAB.a(43, bVar);
        this.aAB.a(45, bVar);
        this.aAB.a(48, bVar);
        this.aAB.a(46, bVar);
        this.aAB.a(49, bVar);
        this.aAB.a(47, bVar);
        this.aAB.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY() {
        if (this.aCn.US()) {
            if (this.aCn.bsa()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.brW().getLocationData().brS());
                return;
            }
            a(1, true, (String) null);
            this.aCn.brY();
            return;
        }
        a(0, true, (String) null);
    }

    protected void bkE() {
        if (this.aCo != null) {
            this.aCo.cancelLoadData();
        }
        if (this.gLI != null) {
            this.gLI.cancelLoadData();
        }
        if (this.aCn != null) {
            this.aCn.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bkE();
        bBs();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gJr != null) {
            this.gJr.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAv() {
        if (this.mData != null && this.mData.getType() == 2 && this.gLP) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bBp().getText().toString());
            this.mData.setContent(bBo().getText().toString());
            int type = this.mData.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    r.c(this.mData.getForumId(), this.mData);
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                    r.c("24591571", this.mData);
                }
            } else if (type == 1) {
                r.d(this.mData.getThreadId(), this.mData);
            } else if (type == 4) {
                r.c(this.mData.getForumId() + "photolive", this.mData);
            } else if (type == 5) {
                r.d(this.mData.getThreadId() + "updatephotolive", this.mData);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.fPB != null && this.fPB.isShowing()) {
                g.a(this.fPB, getPageContext().getPageActivity());
                return true;
            } else if (this.aAB.Cw()) {
                this.aAB.AH();
                return true;
            } else {
                bkE();
                bAv();
                return true;
            }
        }
        if (i == 67 && (text = bBo().getText()) != null) {
            int selectionStart = bBo().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bBo().onKeyDown(67, this.gLM);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.gMx);
        if (this.gMu != null && i == 1) {
            this.gMu.setBorderColor(aj.getColor(d.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.e.cp_link_tip_a, 1);
        bAX();
        aj.k(this.gMj, d.e.cp_bg_line_d);
        aj.k(this.fPy, d.e.cp_bg_line_c);
        aj.k(this.gMk, d.e.cp_bg_line_c);
        aj.k(bBp(), d.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.ehV)) {
            aj.k(bBo(), d.e.cp_bg_line_d);
        }
        bkM();
        this.aAB.onChangeSkinType(i);
        if (this.gMd != null) {
            this.gMd.wu();
        }
        aj.i(this.mName, d.e.cp_cont_b);
        this.fPx.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.btt.setHintTextColor(aj.getColor(d.e.cp_cont_e));
    }

    private void bBd() {
        this.gMe = (NewFrameMultiImgToolView) this.mRootView.findViewById(d.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gMe.initView();
        this.gMe.setVisibility(0);
        this.gMe.setAsyncLocalImageLoader(bVar);
        if (this.gMe.getDragLayer() != null && this.gMe.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gMe.getDragLayer());
            bVar2.a((e) this.gMe.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) this.gMe.getDragHorizonScrollView());
            this.gMe.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(d.f.ds44));
            this.gMe.getDragHorizonScrollView().setPadding((int) getResources().getDimension(d.f.ds0));
            this.gMe.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            if (this.mData.getType() != 9) {
                this.gMe.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gMe));
            }
            this.gMe.getDragHorizonScrollView().setOnSwapDataListener(this.gMe);
            this.gMe.getDragHorizonScrollView().setMaxItemNum(10);
        }
    }

    private View a(Context context, final s sVar) {
        ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int dimension = (int) getResources().getDimension(d.f.ds194);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(dimension, dimension);
        }
        imageView.setLayoutParams(layoutParams);
        aj.c(imageView, d.g.new_frame_btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(d.l.add));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sVar != null) {
                    sVar.b(new com.baidu.tbadk.editortools.a(48, -1, true));
                }
            }
        });
        return imageView;
    }

    private void initUI() {
        this.aLe = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gMr = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.apM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apM.getLayoutParams();
            layoutParams.leftMargin = l.f(getActivity(), d.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apM != null && (this.apM.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apM.getLayoutParams();
            layoutParams2.width = -2;
            this.apM.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.e.cp_cont_b);
        this.gLN = (TextView) findViewById(d.h.btn_image_problem);
        bBe();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = l.f(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.btA);
        this.gMh = (ScrollView) findViewById(d.h.write_scrollview);
        this.gMh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.btt != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.btt);
                    }
                    if (WriteActivity.this.aAB != null) {
                        WriteActivity.this.aAB.AH();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gLJ = (FeedBackTopListView) findViewById(d.h.feedback_top_list);
        this.gLK = findViewById(d.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.gLG = (LinearLayout) findViewById(d.h.tool_view);
        this.gLG.setContentDescription("..");
        this.gLH = (LinearLayout) findViewById(d.h.title_view);
        this.fPy = findViewById(d.h.interval_view);
        this.gME = findViewById(d.h.hot_topic_fourm_view);
        this.gMF = findViewById(d.h.hot_topic_divider);
        this.gMG = (TextView) findViewById(d.h.hot_topic_title_edt);
        this.gMH = (TextView) findViewById(d.h.change_one_tv);
        bkL();
        if (this.gMr) {
            this.gMh.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bAY();
        } else {
            bBd();
        }
        TG();
        if (this.gLC || this.gLD) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahF) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.btu = (LinearLayout) findViewById(d.h.post_content_container);
        this.btu.setDrawingCacheEnabled(false);
        this.btu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.btt.requestFocus();
                WriteActivity.this.aAB.AH();
            }
        });
        this.apM.setOnFocusChangeListener(this.btA);
        this.apM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bkE();
                WriteActivity.this.bAv();
            }
        });
        this.gLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bBh();
        h(bBt());
        bBl();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gLC || this.gLD) {
                    if (this.gLE) {
                        this.mName.setText(d.l.feedback_vcode);
                    } else {
                        this.mName.setText(d.l.feedback);
                    }
                } else {
                    this.mName.setText(d.l.post_new_thread);
                }
                this.fPx.setVisibility(0);
                this.btt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.l.send_reply);
                this.btt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fPx.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.l.publish_photo_live);
                this.btt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gMk.setVisibility(8);
                break;
            case 7:
                this.fPx.setVisibility(0);
                this.btt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.l.post_drift_bottle);
                break;
        }
        bBm();
        bBr();
        bAX();
        bBj();
        bkK();
        bBu();
        if (this.mData.getType() == 4 && this.fPD != null && this.gLL != null) {
            this.fPD.setVisibility(8);
            this.gLL.setVisibility(8);
        }
        bkM();
        ShowSoftKeyPad(this.mInputManager, this.fPx);
        bBi();
    }

    private void bBe() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.send_post));
    }

    private void bBf() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gLC && !this.gLD && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bBp() != null) {
                bBp().setText(d);
                bBp().setSelection(d.length());
            }
        }
    }

    private void bBg() {
        this.gLY = null;
        this.gMa = -1;
        this.gMc = -1;
        aa jg = z.ahW().jg(1);
        if (jg != null) {
            this.gLY = jg.ctd;
            this.gMa = getIntent().getIntExtra("category_id", -1);
            if (this.gLY != null && !this.gLY.isEmpty() && this.gMa >= 0) {
                this.gLZ = new y();
                this.gLZ.csZ = 0;
                this.gLZ.name = getPageContext().getResources().getString(d.l.category_auto);
                this.gMc = this.gLZ.csZ;
                this.gMb = this.gLZ.name;
                for (y yVar : this.gLY) {
                    if (yVar.csZ == this.gMa) {
                        this.gMc = yVar.csZ;
                        this.gMb = yVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bBh() {
        if (this.gLY != null && !this.gLY.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.h.interval_view_cate).setVisibility(0);
            this.gMd = (PostCategoryView) linearLayout.findViewById(d.h.category_selected);
            this.gMd.setText(this.gMb);
            this.gMd.b(this.gLY, this.gLZ, this.gMc);
            this.gMd.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.gMd.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.csZ);
                        WriteActivity.this.gMc = atVar.csZ;
                        WriteActivity.this.gMd.bAo();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gMd.bAn();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBp());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBo());
                }
            });
        }
    }

    private void bBi() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gMT = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gMT.setTitle(d.l.no_disturb_start_time);
        this.gMT.setButton(-1, getPageContext().getString(d.l.alert_yes_button), this.gMT);
        this.gMT.setButton(-2, getPageContext().getString(d.l.cancel), this.gMT);
        return this.gMT;
    }

    private void bBj() {
        this.gLT = (RelativeLayout) findViewById(d.h.addition_container);
        this.gLU = (TextView) findViewById(d.h.addition_create_time);
        this.gLV = (TextView) findViewById(d.h.addition_last_time);
        this.gLW = (TextView) findViewById(d.h.addition_last_content);
        if (this.gLS != null) {
            this.gLT.setVisibility(0);
            this.gLU.setText(getPageContext().getString(d.l.write_addition_create) + am.r(this.gLS.getCreateTime() * 1000));
            if (this.gLS.getAlreadyCount() == 0) {
                this.gLV.setVisibility(8);
            } else {
                this.gLV.setText(getPageContext().getString(d.l.write_addition_last) + am.r(this.gLS.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gLS.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gLW.setText(lastAdditionContent);
            } else {
                this.gLW.setVisibility(8);
            }
            bBo().setHint(String.format(getPageContext().getString(d.l.write_addition_hint), Integer.valueOf(this.gLS.getAlreadyCount()), Integer.valueOf(this.gLS.getTotalCount())));
            this.mName.setText(d.l.write_addition_title);
            return;
        }
        this.gLT.setVisibility(8);
    }

    private void bkK() {
        this.fPD = findViewById(d.h.post_prefix_layout);
        this.fPA = (TextView) findViewById(d.h.post_prefix);
        this.gLL = findViewById(d.h.prefix_divider);
        this.fPC = (ImageView) findViewById(d.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fPD.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fPg = 1;
            this.fPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fPA.setVisibility(0);
                    WriteActivity.this.fPD.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fPB, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aAB.AH();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fPx);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.btt);
                }
            });
            this.fPC = (ImageView) findViewById(d.h.prefix_icon);
            if (size > 1) {
                this.fPC.setVisibility(0);
                this.fPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fPA.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fPB, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aAB.AH();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBp());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBo());
                    }
                });
            }
            this.fPB = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.fPB.a(this);
            this.fPB.setMaxHeight(l.f(getActivity(), d.f.ds510));
            this.fPB.setOutsideTouchable(true);
            this.fPB.setFocusable(true);
            this.fPB.setOnDismissListener(this);
            this.fPB.setBackgroundDrawable(aj.getDrawable(d.e.cp_bg_line_d));
            int color = aj.getColor(d.e.cp_cont_b);
            int color2 = aj.getColor(d.e.cp_cont_c);
            aj.j(this.fPA, d.e.cp_bg_line_d);
            aj.c(this.fPC, d.g.icon_frs_arrow_n);
            this.fPA.setTextColor(color);
            this.gKD.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.c cVar = new com.baidu.tieba.write.c(getActivity());
                this.gKD.add(cVar);
                cVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    cVar.setPrefixTextColor(color2);
                } else {
                    cVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    cVar.setDividerStyle(false);
                }
                this.fPB.addView(cVar);
            }
            this.fPB.setCurrentIndex(0);
            this.fPA.setText(prefixs.get(1));
            vg(1);
            return;
        }
        this.fPD.setVisibility(8);
    }

    private void bBk() {
        if (this.gLC && this.mData != null) {
            this.gLJ.setVisibility(0);
            this.gLK.setVisibility(0);
            this.gLI = new FeedBackModel(this);
            this.gLI.to(this.mData.getForumName());
            this.gLI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gLJ.setVisibility(8);
                        WriteActivity.this.gLK.setVisibility(8);
                        WriteActivity.this.showToast(d.l.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gLJ.setVisibility(8);
                        WriteActivity.this.gLK.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gLJ.a(feedBackModel.bAP(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bBl() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.hh()) {
                    WriteActivity.this.showToast(d.l.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBp());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBo());
                    WriteActivity.this.aAB.AH();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.gLC) {
                            WriteActivity.this.bAw();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            ak akVar = new ak("c12102");
                            akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(akVar);
                            if (WriteActivity.this.gJr.byI()) {
                                WriteActivity.this.bBx();
                            } else {
                                WriteActivity.this.gMC = true;
                                WriteActivity.this.gJr.cm(WriteActivity.this.getThreadTitle(), WriteActivity.this.bBw());
                            }
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bAw();
                    }
                    TiebaStatic.log(new ak("c12262").ac("obj_locate", WriteActivity.this.gIn));
                }
            }
        });
    }

    protected void bBm() {
        this.gLO = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gLO.cL(getPageContext().getString(d.l.is_save_draft)).aq(false).a(getPageContext().getString(d.l.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bBp().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bBo().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    r.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    r.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.l.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.l.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    r.c(WriteActivity.this.mData.getForumId(), (WriteData) null);
                } else if (type == 1) {
                    r.d(WriteActivity.this.mData.getThreadId(), (WriteData) null);
                }
                WriteActivity.this.finish();
            }
        });
        this.gLO.b(getPageContext());
    }

    protected void bkL() {
        this.gLF = (HeadImageView) findViewById(d.h.user_head_portrait);
        this.gLF.setIsRound(true);
        this.gLF.setDrawBorder(false);
        this.gLF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dy = o.dy(currentPortrait);
            this.gLF.setUrl(dy);
            this.gLF.c(dy, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gLF.setVisibility(0);
        }
        this.fPx = (EditText) findViewById(d.h.post_title);
        this.fPx.setOnClickListener(this.gMQ);
        this.fPx.setOnFocusChangeListener(this.btA);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fPx.setText(this.mData.getTitle());
                this.fPx.setSelection(this.mData.getTitle().length());
            } else if (this.gLE) {
                this.fPx.setText(getResources().getString(d.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fPx.addTextChangedListener(this.btC);
        if (!this.mData.getHaveDraft()) {
            bBf();
            this.gMB = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fPx.setHint(getResources().getString(d.l.feedback_title_hint));
        } else {
            this.fPx.setHint(getResources().getString(d.l.post_title_hint));
        }
    }

    private TextWatcher aYY() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int btF;
            private EditText dEw = null;
            private TextView abi = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bkM();
                if (WriteActivity.this.gMr) {
                    this.btF = this.dEw.getSelectionStart();
                    this.dEw.setSelection(this.btF);
                    WriteActivity.this.b(this.abi, this.dEw);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gMr || !WriteActivity.this.gMs) {
                    if (WriteActivity.this.gMr) {
                        if (this.dEw != WriteActivity.this.gMi || this.abi != WriteActivity.this.gMo) {
                            this.dEw = WriteActivity.this.gMi;
                            this.abi = WriteActivity.this.gMo;
                        }
                    }
                } else if (this.dEw != WriteActivity.this.gMm || this.abi != WriteActivity.this.gMn) {
                    this.dEw = WriteActivity.this.gMm;
                    this.abi = WriteActivity.this.gMn;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gMr && this.gMs) {
            if (this.gMp != null) {
                this.gMm.removeTextChangedListener(this.gMp);
            }
            this.gMp = textWatcher;
        } else if (this.gMr) {
            if (this.gMq != null) {
                this.gMi.removeTextChangedListener(this.gMq);
            }
            this.gMq = textWatcher;
        }
        return textWatcher;
    }

    private long h(EditText editText) {
        if (editText == this.gMi) {
            return 233L;
        }
        if (editText != this.gMm) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long h = h(editText);
            long f = h - f(editText);
            String valueOf = String.valueOf(f);
            if (h == 20) {
                if (f < 0) {
                    if (f < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(aj.getColor(d.e.common_color_10159));
                } else {
                    textView.setTextColor(aj.getColor(d.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(aj.getColor(d.e.common_color_10159));
            } else {
                textView.setTextColor(aj.getColor(d.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void TG() {
        this.btt = (EditText) findViewById(d.h.post_content);
        this.btt.setDrawingCacheEnabled(false);
        this.btt.setOnClickListener(this.gMQ);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString T = TbFaceManager.DS().T(getPageContext().getPageActivity(), this.mData.getContent());
            this.btt.setText(T);
            this.btt.setSelection(T.length());
        } else if (this.mData.getType() == 2) {
            if (this.gLP) {
                if (this.gLQ != null && this.gLQ.length() > 0) {
                    this.btt.setText(getPageContext().getPageActivity().getString(d.l.reply_sub_floor, new Object[]{this.gLQ}));
                    this.btt.setSelection(this.btt.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.btt.setText(format);
                this.btt.setSelection(format.length());
            }
        }
        this.btt.setOnFocusChangeListener(this.btA);
        this.btt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aAB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.btt.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.btt.addTextChangedListener(this.gMS);
        nw(true);
        if (this.mData.isUserFeedback()) {
            this.btt.setHint(d.l.write_input_content);
        } else {
            this.btt.setHint(d.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nw(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gMr) {
            bBo().setPadding(0, 0, 0, 0);
            bBo().setBackgroundDrawable(null);
            aj.k(bBo(), d.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ehV) && this.gLS == null) {
                com.baidu.adp.lib.f.c.fJ().a(this.ehV, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.kN() != null && aVar.kR() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kN(), aVar.kN().getNinePatchChunk(), aVar.kR(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bBo().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bBo(), true, WriteActivity.this.eKZ);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBn() {
        int i = 5000;
        if (this.gLS != null) {
            i = 1000;
        }
        return bBo().getText() != null && bBo().getText().length() >= i;
    }

    private void fG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gLA)) {
                this.gLA = "";
                bBo().requestFocus();
                if (bBo().getText() != null && bBo().getText().length() + str.length() > 5000) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bBo().getSelectionStart();
                    editable = bBo().getText();
                }
            } else if ("from_title".equals(this.gLA)) {
                this.gLA = "";
                bBp().requestFocus();
                if (bBp().getText() != null && bBp().getText().length() + str.length() > 31) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bBp().getSelectionStart();
                    editable = bBp().getText();
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
    public void nx(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bBo().getText().getSpans(0, bBo().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gLR == null) {
                this.gLR = Toast.makeText(getPageContext().getPageActivity(), d.l.too_many_face, 0);
            }
            this.gLR.show();
            return;
        }
        String name = lVar.getName();
        final EmotionGroupType xK = lVar.xK();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bBo().getSelectionStart(), aVar, xK);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bBo() != null && bBo().getText() != null) {
            Bitmap kN = aVar.kN();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kN);
            int width = kN.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kN.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bBo().getSelectionStart() - 1;
                if (bBo().getText().length() > 1 && selectionStart >= 0 && bBo().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bBo().getText().insert(bBo().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bBo().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bBo().getText().insert(bBo().getSelectionStart(), spannableString2);
            }
            Editable text = bBo().getText();
            if (text != null) {
                this.gML.clear();
                this.gML.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gML);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bBo().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bBo().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bBo().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bBo() {
        return this.gMr ? this.gMi : this.btt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bBp() {
        return this.gMr ? this.gMm : this.fPx;
    }

    protected void bBq() {
        Editable text;
        if (bBo() != null && (text = bBo().getText()) != null) {
            int selectionStart = bBo().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bBo().onKeyDown(67, this.gLM);
            }
            bBo().onKeyDown(67, this.gLM);
            int selectionStart2 = bBo().getSelectionStart();
            if (text != null) {
                this.gML.clear();
                this.gML.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gML);
                bBo().setSelection(selectionStart2);
            }
        }
    }

    private void h(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.l.feedback_bar_name).equals(str)) {
            this.gLC = true;
        }
    }

    private void bBr() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bBs() {
        try {
            if (this.gLO != null) {
                this.gLO.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aLe.c(null);
        this.aLe.da(d.l.sending);
        this.aLe.aG(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aLe.aG(false);
    }

    private Boolean bBt() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aCs = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkM() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bBp() != null) {
                str = bBp().getText().toString();
            }
            if (bBo() != null) {
                str2 = bBo().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fPg == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dj(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dj(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dj(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gMr) {
                    dj(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dj(true);
                }
            }
            if (this.mData.getType() == 4) {
                dj(j(this.gMi) && i(this.gMm));
            } else if (this.mData.getType() == 5) {
                dj(j(this.gMi));
            } else if (!TextUtils.isEmpty(str2) || this.aCl != null) {
                dj(true);
            } else if (this.mData.getVideoInfo() != null) {
                dj(true);
            } else {
                dj(false);
            }
        }
    }

    private void dj(boolean z) {
        if (z) {
            aj.b(this.mPost, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        aj.c(this.mPost, d.e.cp_cont_d, 1);
        this.mPost.setEnabled(false);
    }

    private boolean i(EditText editText) {
        long f = f(editText);
        return f <= 20 && f > 0;
    }

    private boolean j(EditText editText) {
        long f = f(editText);
        if (f > 233) {
            return false;
        }
        return f > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        String stringExtra;
        this.aCo = new NewWriteModel(this);
        this.aCo.b(this.aCE);
        registerListener(this.gMN);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bkE();
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
            this.gLC = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gLE = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gLP = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gLQ = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
            this.aCm = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gLS = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gLS != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gLX = bundle.getInt("mem_type", 0);
            this.aie = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gMI = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gIn = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gLC = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gLE = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gLP = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gLQ = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gLS = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gLS != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gLX = intent.getIntExtra("mem_type", 0);
            this.aie = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gMI = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gIn = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gLC);
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
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                r.c(this.mData.getForumId(), this);
            }
        } else if (this.mData.getType() == 7) {
            if (getIntent().getBooleanExtra(WriteActivityConfig.IS_SAVE_DRAFTE, true)) {
                r.c("24591571", this);
            }
        } else if (this.mData.getType() == 1) {
            r.a(this.mData.getThreadId(), this);
        } else if (this.mData.getType() == 4) {
            r.c(this.mData.getForumId() + "photolive", this);
        } else if (this.mData.getType() == 5) {
            r.a(this.mData.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.l.write_no_prefix));
        }
        this.ehV = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gLD = true;
        }
        bBg();
        try {
            this.gMt = bBB();
        } catch (Throwable th) {
            this.gMt = null;
        }
    }

    private void bBu() {
        if (v.t(this.mList) > 0 && this.mList.get(0) != null) {
            this.gLF.setVisibility(8);
            this.gME.setVisibility(0);
            this.gMF.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fPx.setText(com.baidu.tbadk.plugins.a.gy(tp(this.mList.get(0).mTopicName)));
                this.fPx.setMovementMethod(com.baidu.tieba.view.b.bxO());
            }
            this.gMG.setText(this.mList.get(0).mForumName);
            this.fPx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gMJ.equals(charSequence.toString())) {
                        WriteActivity.this.gMK = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gy;
                    if (!WriteActivity.this.gMJ.equals(editable.toString()) && (gy = com.baidu.tbadk.plugins.a.gy(editable.toString())) != null) {
                        WriteActivity.this.gMJ = gy.toString();
                        WriteActivity.this.fPx.setText(gy);
                        if (WriteActivity.this.gMK <= WriteActivity.this.fPx.getText().length()) {
                            WriteActivity.this.fPx.setSelection(WriteActivity.this.gMK);
                        }
                    }
                }
            });
            this.gMH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
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
            SpannableString gy = com.baidu.tbadk.plugins.a.gy(tp(hotTopicBussinessData.mTopicName));
            if (gy != null) {
                this.fPx.setText(gy);
            }
            this.gMG.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String tp(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        String tp;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!k.isEmpty(writeData.getTitle())) {
                    this.gLH.setVisibility(0);
                    this.gLH.requestFocus();
                    this.aAB.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (k.isEmpty(bBp().getText().toString()) || this.gMB || ((this.gLC || this.gLD) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.u(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            tp = this.mData.getTitle();
                        } else {
                            tp = tp(str);
                        }
                        SpannableString gy = com.baidu.tbadk.plugins.a.gy(tp);
                        if (gy != null) {
                            bBp().setText(gy);
                            bBp().setSelection(gy.length() > tp.length() ? tp.length() : gy.length());
                        }
                    } else {
                        SpannableString gy2 = com.baidu.tbadk.plugins.a.gy(this.mData.getTitle());
                        if (gy2 != null) {
                            bBp().setText(gy2);
                            bBp().setSelection(this.mData.getTitle().length() > gy2.length() ? gy2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bBf();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aAB.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bBo().getText().toString()) || this.gLC || this.gLD) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.DS().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gMO);
                    bBo().setText(a2);
                    bBo().setSelection(a2.length());
                    if (this.gMr) {
                        b(this.gMo, this.gMi);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bBA();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Df();
                    }
                    ny(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bBv();
                }
                bkM();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gLY != null) {
                    this.gMc = this.gLZ.csZ;
                    this.gMb = this.gLZ.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gLY.size()) {
                            break;
                        }
                        y yVar = this.gLY.get(i);
                        if (categoryTo != yVar.csZ) {
                            i++;
                        } else {
                            this.gMc = categoryTo;
                            this.gMb = yVar.name;
                            this.mData.setCategoryTo(this.gMc);
                            break;
                        }
                    }
                    if (this.gMd != null) {
                        this.gMd.setText(this.gMb);
                        this.gMd.b(this.gLY, this.gLZ, this.gMc);
                    }
                }
                this.aAB.AH();
                return;
            }
            return;
        }
        bBv();
        bBf();
    }

    private void bBv() {
        if ((!this.gMr || this.gMg != null) && this.gMf != null) {
            this.gMg.c(this.writeImagesInfo);
            aHC();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gLP);
        if (this.gLC) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCm);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gLS);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gLX);
        bundle.putString("from", this.aie);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gIn);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bBo().getEditableText().toString();
        if (obj != null) {
            bBo().setText(TbFaceManager.DS().a(getPageContext().getPageActivity(), obj, this.gMO));
            bBo().setSelection(bBo().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bBw() {
        return (bBo() == null || bBo().getText() == null) ? "" : bBo().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || bBp() == null || bBp().getText() == null) {
            return "";
        }
        String obj = bBp().getText().toString();
        if (this.mPrefixData != null && v.t(this.mPrefixData.getPrefixs()) > 0 && this.fPg != 0 && this.mData.getType() != 4 && this.fPA != null && this.fPA.getText() != null) {
            obj = this.fPA.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAw() {
        bkE();
        this.mData.setContent(bBw());
        this.mData.setTitle(getThreadTitle());
        if (this.gLC || this.gLD) {
            String string = getResources().getString(d.l.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                this.mData.setTitle(string + this.mData.getTitle());
            }
            String str = getResources().getString(d.l.app_name) + getResources().getString(d.l.tieba_client);
            if (TextUtils.isEmpty(this.mData.getContent()) || !this.mData.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (j.hh()) {
                    sb.append(j.hp());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.gMa >= 0) {
            this.mData.setCategoryFrom(this.gMa);
        }
        if (this.gMc >= 0) {
            this.mData.setCategoryTo(this.gMc);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aCn != null && this.aCn.US());
        this.aCo.mF(this.writeImagesInfo.size() > 0);
        if (!v.u(this.mList) && this.gMD != null && this.gMD.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gMD.mForumId));
            this.mData.setForumName(this.gMD.mForumName);
        }
        this.aCo.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aCl != null) {
            if (this.aCl.getId() != null) {
                this.aCo.getWriteData().setVoice(this.aCl.getId());
                this.aCo.getWriteData().setVoiceDuringTime(this.aCl.duration);
            } else {
                this.aCo.getWriteData().setVoice(null);
                this.aCo.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aCo.getWriteData().setVoice(null);
            this.aCo.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aCo.bsv()) {
            showToast(d.l.write_img_limit);
        } else if (!j.hh()) {
            showToast(d.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.l.sending), this.mDialogCancelListener);
            this.aCo.startPostWrite();
        }
    }

    private void r(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.gLS != null) {
                i2 = this.gLS.getTotalCount();
                i = this.gLS.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.l.write_addition_left_count), Integer.valueOf(i2 - i)));
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
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.aAB != null && !this.aAB.Cw()) {
                    bBo().requestFocus();
                    this.mInputManager.toggleSoftInput(0, 2);
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
                            bBo().getText().insert(bBo().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                if (this.mData.getType() == 0 || this.mData.getType() == 9) {
                    r.c(this.mData.getForumId(), (WriteData) null);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIsCopyTWZhibo() == 3) {
                        a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE_TARGET);
                    }
                } else if (this.mData.getType() == 1) {
                    r.d(this.mData.getThreadId(), (WriteData) null);
                } else if (this.mData.getType() == 4) {
                    r.c(this.mData.getForumId() + "photolive", (WriteData) null);
                    a(postWriteCallBackData, PhotoLiveActivityConfig.KEY_FROM_WRITE);
                }
                d(postWriteCallBackData);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                baw();
                            } else {
                                ad(intent);
                            }
                        } else if (intExtra == 1) {
                            U(intent);
                        } else {
                            ac(intent);
                            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.a(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gMr) {
                        A(intent);
                        bkM();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aAB.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aAB.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aAB.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bkM();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gLB) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gLB = false;
                            }
                            sb2.append(stringExtra);
                            fG(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.u(this.mList)) {
                    if (!v.u(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gMD = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gMD);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gJr.aa(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.btz = this.gJr.byH();
                        this.aAB.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gMC) {
                        bBx();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aAB != null && !this.aAB.Cw()) {
                this.btt.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Db();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bBz();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aCm = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aCm);
                    return;
                case 12012:
                    bBz();
                    return;
                case 25004:
                    if ("from_title".equals(this.gLA)) {
                        bBp().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gLA)) {
                        bBo().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBx() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gJr.byG());
        this.mData.setCallFrom(this.gIn);
        this.mData.setRecommendExt(this.gJr.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bAw();
    }

    private void bBy() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bBz() {
        if (this.gMr) {
            this.gMg.c(this.writeImagesInfo);
            aHC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHC() {
        this.gMg.notifyDataSetChanged();
        this.gMf.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gMg.notifyDataSetChanged();
                WriteActivity.this.gMf.invalidateViews();
            }
        }, 550L);
    }

    public void u(LinkedList<ImageFileInfo> linkedList) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null) {
            chosedFiles.clear();
            if (linkedList != null) {
                chosedFiles.addAll(linkedList);
            }
        }
        bkM();
    }

    private void ac(Intent intent) {
        if (this.gMr) {
            af(intent);
            bBz();
        } else {
            ag(intent);
        }
        bkM();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bBz();
            ny(true);
        }
    }

    private void ad(Intent intent) {
        if (this.writeImagesInfo != null) {
            z(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void baw() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void U(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fpL.parseJson(stringExtra);
            this.fpL.updateQuality();
            if (this.fpL.getChosedFiles() != null && this.fpL.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fpL.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fpL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bBp());
        HidenSoftKeyPad(this.mInputManager, bBo());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ag(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aCm = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCm;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ad(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCm, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bBA();
            Df();
        }
        ny(true);
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
                bBA();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Df();
                }
            }
            ny(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBA() {
        if (this.aAB.eO(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Db() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.t(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aCm));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void ny(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cqg == null) {
            this.cqg = VoiceManager.instance();
        }
        return this.cqg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ahc() {
        this.cqg = getVoiceManager();
        this.cqg.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tF(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cqX) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.agX));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gLS == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aCu = i;
        if (this.aAB != null) {
            this.aAB.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aAB.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Df() {
        if (!this.gMr) {
            if (this.aAB != null) {
                this.aAB.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aAB.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gMe != null) {
                this.gMe.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gMe.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (this.aAB != null) {
            this.aAB.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vg(int i) {
        if (i < this.gKD.size()) {
            for (int i2 = 0; i2 < this.gKD.size(); i2++) {
                this.gKD.get(i2).nn(false);
            }
            this.gKD.get(i).nn(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sS(int i) {
        this.fPg = i;
        this.fPB.setCurrentIndex(i);
        vg(i);
        this.fPA.setText(this.mPrefixData.getPrefixs().get(i));
        bkM();
        g.a(this.fPB, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fPD.setSelected(false);
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
            CW();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aJ(getApplicationContext())) {
                ai.b(getPageContext(), this.aCm);
            } else {
                showToast(d.l.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.l.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gMz && System.currentTimeMillis() - this.gMA < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.gMz = false;
        }
        if (this.gMM != null && !z) {
            this.gMM.aRq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(String str) {
        if (!k.isEmpty(str) && this.gMw != null) {
            tr(str);
            this.gMw.dismiss();
        }
    }

    private void ca(Context context) {
        gMy = l.af(context);
    }

    private void tr(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gMz = true;
        bBA();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Df();
        }
        ny(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3973=4] */
    private static Bitmap c(String str, float f) {
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

    private File bBB() {
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

    private void bBC() {
        if (this.gMt != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ca(getActivity());
            this.gMv = getPageContext().getPageActivity().getLayoutInflater().inflate(d.j.rec_dialog, (ViewGroup) null);
            this.gMv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gMt != null) {
                        WriteActivity.this.tq(WriteActivity.this.gMt.getAbsolutePath());
                    }
                }
            });
            this.gMu = (TbImageView) this.gMv.findViewById(d.h.rec_img_view);
            this.gMx = (LinearLayout) this.gMv.findViewById(d.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gMt.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gMt.getAbsolutePath());
                Bitmap c = c(this.gMt.getAbsolutePath(), getResources().getDimensionPixelSize(d.f.ds160));
                if (c != null) {
                    this.gMu.setImageBitmap(c);
                    this.gMu.setDrawBorder(true);
                    this.gMu.setBorderWidth(2);
                    this.gMu.setBorderColor(aj.getColor(d.e.common_color_10264));
                    this.gMw = new Dialog(getActivity(), d.m.bubble_dialog);
                    this.gMw.setCanceledOnTouchOutside(true);
                    this.gMw.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gMz) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gMA = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gMw.setContentView(this.gMv);
                    this.gMw.show();
                    Window window = this.gMw.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.f.ds28);
                    attributes.y = (gMy / 18) + getResources().getDimensionPixelSize(d.f.ds12);
                    attributes.width = getResources().getDimensionPixelSize(d.f.ds168);
                    attributes.height = getResources().getDimensionPixelSize(d.f.ds278);
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
            this.gLB = false;
            this.gLA = "";
            if ("from_content".equals(str)) {
                this.gLA = "from_content";
            } else if ("from_title".equals(str)) {
                this.gLA = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                nx(false);
            }
        }
    }

    public void AJ() {
        if (this.gLC || !v.u(this.mList)) {
            this.gLH.setVisibility(0);
            this.gLH.requestFocus();
            this.aAB.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.gLH.setVisibility(8);
    }
}
