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
    private static int gMO = 0;
    private i aAN;
    private LocationModel aCA;
    private NewWriteModel aCB;
    private VoiceData.VoiceModel aCy;
    private String aCz;
    private VoiceManager cqs;
    private TextView fPP;
    private com.baidu.tieba.write.d fPQ;
    private ImageView fPR;
    private View fPS;
    private int fPv;
    private com.baidu.tieba.write.a gJH;
    private LinearLayout gLW;
    private LinearLayout gLX;
    private HotTopicBussinessData gMT;
    private View gMU;
    private View gMV;
    private TextView gMW;
    private TextView gMX;
    private View gMa;
    private View gMb;
    private Toast gMh;
    private AdditionData gMi;
    private RelativeLayout gMj;
    private TextView gMk;
    private TextView gMl;
    private TextView gMm;
    List<y> gMo;
    y gMp;
    private int gMq;
    private String gMr;
    private int gMs;
    private PostCategoryView gMt;
    private NewFrameMultiImgToolView gMu;
    private com.baidu.tieba.write.b.b gNc;
    private com.baidu.tieba.view.a gNj;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gLQ = "";
    private boolean gLR = false;
    private WriteData mData = null;
    private boolean gLS = false;
    private boolean gLT = false;
    private boolean gLU = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fPM = null;
    private HeadImageView gLV = null;
    private View fPN = null;
    private LinearLayout btG = null;
    private EditText btF = null;
    private FeedBackModel gLY = null;
    private FeedBackTopListView gLZ = null;
    private ArrayList<com.baidu.tieba.write.c> gKT = new ArrayList<>();
    private String eij = null;
    private final KeyEvent gMc = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View apY = null;
    private TextView gMd = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gMe = null;
    private final Handler mHandler = new Handler();
    private boolean gMf = false;
    private String gMg = null;
    private RelativeLayout mParent = null;
    private String aCF = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aCH = 0;
    private int gMn = 0;
    private WriteImagesInfo fqa = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gMv = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gMw = null;
    private ScrollView gMx = null;
    private EditText gMy = null;
    private View gMz = null;
    private View gMA = null;
    private View gMB = null;
    private EditText gMC = null;
    private TextView gMD = null;
    private TextView gME = null;
    private TextWatcher gMF = null;
    private TextWatcher gMG = null;
    private boolean gMH = false;
    private boolean gMI = false;
    private com.baidu.tbadk.core.view.a aLr = null;
    private String aiq = AlbumActivityConfig.FROM_WRITE;
    private File gMJ = null;
    private TbImageView gMK = null;
    private View gML = null;
    private Dialog gMM = null;
    private LinearLayout gMN = null;
    private boolean gMP = false;
    private long gMQ = -1000;
    private boolean gMR = false;
    private String gID = "2";
    private boolean gMS = false;
    private String gMY = "";
    private String gMZ = "";
    private int gNa = 0;
    private SpannableStringBuilder gNb = new SpannableStringBuilder();
    private final HttpMessageListener gNd = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eij)) {
                    WriteActivity.this.eij = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nx(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eij)) {
                    WriteActivity.this.eij = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eij);
                    WriteActivity.this.nx(true);
                }
            }
        }
    };
    private TbFaceManager.a gNe = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gc(String str) {
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
    private final AntiHelper.a crk = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahj));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahj));
        }
    };
    private final NewWriteModel.d aCR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.ahh();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                if (z) {
                    WriteActivity.this.bL(z);
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
                        if (!v.u(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gMY)) {
                            TiebaStatic.log(new ak("c11731").ad("obj_id", WriteActivity.this.gMY));
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
                    writeData.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.p.a.gT(qVar.xZ())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.xZ());
                        if (WriteActivity.this.gLU) {
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
    private final LocationModel.a aCP = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.41
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Dq() {
            WriteActivity.this.showToast(d.l.no_network_guide);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void fR(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.l.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bsa())) {
                WriteActivity.this.a(2, true, aVar.bsa());
            } else {
                fR(null);
            }
        }
    };
    private final CustomMessageListener giX = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aCA.mE(false);
                    WriteActivity.this.aCA.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aCA.mE(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener gNf = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener gNg = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bBd = WriteActivity.this.bBd();
            if (bBd >= 0 && bBd < WriteActivity.this.btF.getText().length()) {
                WriteActivity.this.btF.setSelection(bBd);
            }
        }
    };
    private boolean gNh = true;
    private final View.OnFocusChangeListener btM = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fPM || view == WriteActivity.this.apY || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gNh = true;
                    WriteActivity.this.bBe();
                    if (WriteActivity.this.aAN != null) {
                        WriteActivity.this.aAN.AN();
                    }
                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.fPM);
                } else if (view == WriteActivity.this.fPM) {
                    WriteActivity.this.fPP.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.btF && z) {
                WriteActivity.this.gNh = false;
                WriteActivity.this.bBe();
                WriteActivity.this.aAN.AN();
                l.b(WriteActivity.this.getActivity(), WriteActivity.this.btF);
            }
        }
    };
    private TextWatcher btO = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bkU();
        }
    };
    private TextWatcher gNi = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bkU();
        }
    };
    private final a.InterfaceC0124a eLn = new a.InterfaceC0124a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0124a
        public void lc() {
            WriteActivity.this.eij = null;
            WriteActivity.this.nx(false);
            WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void d(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.aiq)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Db() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Dc() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.l.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Dd();
        } else if (this.aCA.bsi()) {
            Db();
        } else {
            this.aCA.mE(false);
            a(1, true, (String) null);
            this.aCA.bsg();
        }
    }

    private void Dd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cd(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (j.hh()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.aCA.Va();
                } else {
                    WriteActivity.this.aCP.Dq();
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
        aVar.ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBd() {
        int selectionEnd = bBv().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bBv().getText().getSpans(0, bBv().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bBv().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bBv().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBe() {
        if (this.aAN != null) {
            this.aAN.setBarLauncherEnabled(!this.gNh);
            this.aAN.d(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gMH) {
            this.fPM.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gMB.setVisibility(8);
            } else {
                this.gMB.setVisibility(0);
            }
            b(this.gME, this.gMy);
            b(this.gMD, this.gMC);
            bkU();
        }
        if (this.gLS) {
            this.gNh = true;
            bBe();
            if (this.aAN != null) {
                this.aAN.AN();
            }
            this.fPM.requestFocus();
            ShowSoftKeyPadDelay(this.fPM);
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
        bBr();
        this.aCA = new LocationModel(this);
        this.aCA.a(this.aCP);
        registerListener(this.giX);
        registerListener(this.gNf);
        initEditor();
        bBJ();
        if (this.gMH) {
            this.gMw.setEditorTools(this.aAN);
        } else {
            this.btF.requestFocus();
        }
        AP();
        Dl();
        this.gJH = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aAN = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aAN.setBarMaxLauCount(6);
        } else {
            this.aAN.setBarMaxLauCount(5);
        }
        this.aAN.setMoreButtonAtEnd(true);
        this.aAN.setBarLauncherType(1);
        this.aAN.bC(true);
        this.aAN.setMoreLauncherIcon(d.g.write_more);
        this.aAN.setBackgroundColorId(d.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bBh();
                break;
            default:
                bBi();
                break;
        }
        this.aAN.CA();
        if (this.gLW != null) {
            this.gLW.addView(this.aAN);
        }
        bBj();
        this.aAN.lM();
        com.baidu.tbadk.editortools.l eN = this.aAN.eN(6);
        if (eN != null && !TextUtils.isEmpty(this.aCF)) {
            ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aCF);
                }
            });
        }
        if (!this.gMH) {
            this.aAN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aAN.AN();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aAN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aAN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.btL = this.mData.getForumName() + getResources().getString(d.l.forum);
        }
        this.aAN.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gMu != null) {
            this.gMu.setEditorTools(this.aAN);
            this.gMu.bAo();
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.aiq);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bBf() {
        this.gMz = this.mRootView.findViewById(d.h.photo_live_scroll);
        this.gMB = this.gMz.findViewById(d.h.live_post_title_container);
        this.gMy = (EditText) this.gMz.findViewById(d.h.live_post_content);
        this.gMv = (GridView) this.gMz.findViewById(d.h.photoLiveGridView);
        this.gMC = (EditText) this.gMz.findViewById(d.h.live_post_title);
        this.gMD = (TextView) this.gMz.findViewById(d.h.titleOverPlusNumber);
        this.gME = (TextView) this.gMz.findViewById(d.h.contentOverPlusNumber);
        this.gMA = this.gMz.findViewById(d.h.live_interval_view);
        this.gMD.setText(String.valueOf(20));
        this.gME.setText(String.valueOf(233));
        this.gMz.setVisibility(0);
        this.gMD.setVisibility(0);
        this.gME.setVisibility(0);
        this.gMC.setHint(d.l.tips_title_limit_new);
        this.gMC.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gMI = true;
                    WriteActivity.this.gNh = true;
                    WriteActivity.this.bBe();
                    if (WriteActivity.this.aAN != null) {
                        WriteActivity.this.aAN.AN();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gMy.setHint(d.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gMy.setHint(d.l.live_write_input_content_update);
        }
        this.gMy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gMI = false;
                    WriteActivity.this.gNh = false;
                    WriteActivity.this.bBe();
                    if (WriteActivity.this.aAN != null) {
                        WriteActivity.this.aAN.AN();
                    }
                }
            }
        });
        this.gMy.requestFocus();
        this.gMy.addTextChangedListener(aZe());
        this.gMC.requestFocus();
        this.gMC.addTextChangedListener(aZe());
        this.gMC.setOnClickListener(this.gNg);
        this.gMy.setOnClickListener(this.gNg);
        this.gMw = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gMv);
        this.gMw.uX(6);
        this.gMv.setAdapter((ListAdapter) this.gMw);
        View findViewById = this.gMz.findViewById(d.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bAt() {
                WriteActivity.this.aHH();
            }
        });
        bBg();
    }

    private void bBg() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gMC.setText(this.mData.getTitle());
                this.gMC.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.gMH) {
            bBF();
        }
        if (this.aAN.CC()) {
            this.aAN.AN();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", this.aiq);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bBh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aAN.z(arrayList);
        com.baidu.tbadk.editortools.r eP = this.aAN.eP(5);
        if (eP != null) {
            eP.aBv = 2;
            eP.aBt = d.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aBt = d.g.write_at;
        this.aAN.b(aVar);
        this.aAN.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bBi() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aBt = d.g.write_picture;
            this.aAN.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aAN.b(aVar);
        aVar.aBt = d.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aBv = 6;
            rVar4.aBt = d.g.write_privilege;
            this.aAN.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aBt = d.g.write_at;
        this.aAN.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aBx = true;
            rVar3.aBv = 9;
            rVar3.aBt = 0;
            this.aAN.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aBx = true;
            rVar2.aBv = 10;
            rVar2.aBt = 0;
            this.aAN.b(rVar2);
        }
        Boolean bBA = bBA();
        if (!this.gLS && bBA != null && bBA.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.bsD() && m.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aBv = 2;
            rVar.aBt = d.g.write_recorder;
            this.aAN.b(rVar);
        }
        if (this.gMi == null) {
            if (this.gNc == null) {
                this.gNc = new com.baidu.tieba.write.b.b(getActivity(), this.gID);
            }
            this.aAN.b(this.gNc);
        }
        this.aAN.z(arrayList);
        com.baidu.tbadk.editortools.r eP = this.aAN.eP(5);
        if (eP != null) {
            eP.aBv = 1;
            eP.aBt = d.g.write_emotion;
        }
    }

    private void bBj() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                int size;
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bBu()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bBu()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.d((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bBx();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aCy = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.bkU();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aCy = null;
                        WriteActivity.this.bkU();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bBH();
                        WriteActivity.this.bkU();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            int intValue = ((Integer) aVar.data).intValue();
                            if (WriteActivity.this.writeImagesInfo != null && WriteActivity.this.writeImagesInfo.getChosedFiles() != null && (size = WriteActivity.this.writeImagesInfo.getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12012, WriteActivity.this.writeImagesInfo, intValue)));
                            }
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gMi == null) {
                            WriteActivity.this.De();
                            return;
                        }
                        switch (WriteActivity.this.aCH) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aJ(pageActivity)) {
                                    WriteActivity.this.Dc();
                                    return;
                                } else {
                                    ab.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Db();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eij = null;
                        } else {
                            WriteActivity.this.eij = (String) aVar.data;
                        }
                        WriteActivity.this.nx(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ad("fid", str);
                        TiebaStatic.log(akVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aAN.CC()) {
                                        WriteActivity.this.aAN.AN();
                                        WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bkU();
                        if (WriteActivity.this.btF != null) {
                            WriteActivity.this.btF.requestFocus();
                        }
                        WriteActivity.this.aAN.AN();
                        WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.btF);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gLR = true;
                        WriteActivity.this.ny(true);
                        if (WriteActivity.this.bBw().isFocused()) {
                            WriteActivity.this.gLQ = "from_title";
                        } else if (WriteActivity.this.bBv().isFocused()) {
                            WriteActivity.this.gLQ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.gLX.setVisibility(0);
                        WriteActivity.this.gLX.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gJH.cn(WriteActivity.this.getThreadTitle(), WriteActivity.this.bBD());
                        TiebaStatic.log(new ak("c12258").ad("obj_locate", WriteActivity.this.gID));
                    }
                }
            }
        };
        this.aAN.a(16, bVar);
        this.aAN.a(14, bVar);
        this.aAN.a(24, bVar);
        this.aAN.a(3, bVar);
        this.aAN.a(10, bVar);
        this.aAN.a(11, bVar);
        this.aAN.a(12, bVar);
        this.aAN.a(13, bVar);
        this.aAN.a(15, bVar);
        this.aAN.a(18, bVar);
        this.aAN.a(25, bVar);
        this.aAN.a(27, bVar);
        this.aAN.a(29, bVar);
        this.aAN.a(43, bVar);
        this.aAN.a(45, bVar);
        this.aAN.a(48, bVar);
        this.aAN.a(46, bVar);
        this.aAN.a(49, bVar);
        this.aAN.a(47, bVar);
        this.aAN.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De() {
        if (this.aCA.UW()) {
            if (this.aCA.bsi()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.bse().getLocationData().bsa());
                return;
            }
            a(1, true, (String) null);
            this.aCA.bsg();
            return;
        }
        a(0, true, (String) null);
    }

    protected void bkM() {
        if (this.aCB != null) {
            this.aCB.cancelLoadData();
        }
        if (this.gLY != null) {
            this.gLY.cancelLoadData();
        }
        if (this.aCA != null) {
            this.aCA.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        bkM();
        bBz();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gJH != null) {
            this.gJH.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAC() {
        if (this.mData != null && this.mData.getType() == 2 && this.gMf) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bBw().getText().toString());
            this.mData.setContent(bBv().getText().toString());
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
            if (this.fPQ != null && this.fPQ.isShowing()) {
                g.a(this.fPQ, getPageContext().getPageActivity());
                return true;
            } else if (this.aAN.CC()) {
                this.aAN.AN();
                return true;
            } else {
                bkM();
                bAC();
                return true;
            }
        }
        if (i == 67 && (text = bBv().getText()) != null) {
            int selectionStart = bBv().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bBv().onKeyDown(67, this.gMc);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.mParent);
        getLayoutMode().t(this.gMN);
        if (this.gMK != null && i == 1) {
            this.gMK.setBorderColor(aj.getColor(d.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.e.cp_link_tip_a, 1);
        bBe();
        aj.k(this.gMz, d.e.cp_bg_line_d);
        aj.k(this.fPN, d.e.cp_bg_line_c);
        aj.k(this.gMA, d.e.cp_bg_line_c);
        aj.k(bBw(), d.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.eij)) {
            aj.k(bBv(), d.e.cp_bg_line_d);
        }
        bkU();
        this.aAN.onChangeSkinType(i);
        if (this.gMt != null) {
            this.gMt.wB();
        }
        aj.i(this.mName, d.e.cp_cont_b);
        this.fPM.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.btF.setHintTextColor(aj.getColor(d.e.cp_cont_e));
    }

    private void bBk() {
        this.gMu = (NewFrameMultiImgToolView) this.mRootView.findViewById(d.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gMu.initView();
        this.gMu.setVisibility(0);
        this.gMu.setAsyncLocalImageLoader(bVar);
        if (this.gMu.getDragLayer() != null && this.gMu.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gMu.getDragLayer());
            bVar2.a((e) this.gMu.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) this.gMu.getDragHorizonScrollView());
            this.gMu.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(d.f.ds44));
            this.gMu.getDragHorizonScrollView().setPadding((int) getResources().getDimension(d.f.ds0));
            this.gMu.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            if (this.mData.getType() != 9) {
                this.gMu.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gMu));
            }
            this.gMu.getDragHorizonScrollView().setOnSwapDataListener(this.gMu);
            this.gMu.getDragHorizonScrollView().setMaxItemNum(10);
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
        this.aLr = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gMH = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.apY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apY.getLayoutParams();
            layoutParams.leftMargin = l.f(getActivity(), d.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.apY != null && (this.apY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.apY.getLayoutParams();
            layoutParams2.width = -2;
            this.apY.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        aj.i(this.mName, d.e.cp_cont_b);
        this.gMd = (TextView) findViewById(d.h.btn_image_problem);
        bBl();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = l.f(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.btM);
        this.gMx = (ScrollView) findViewById(d.h.write_scrollview);
        this.gMx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.btF != null) {
                        l.a(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.btF);
                    }
                    if (WriteActivity.this.aAN != null) {
                        WriteActivity.this.aAN.AN();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gLZ = (FeedBackTopListView) findViewById(d.h.feedback_top_list);
        this.gMa = findViewById(d.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.gLW = (LinearLayout) findViewById(d.h.tool_view);
        this.gLW.setContentDescription("..");
        this.gLX = (LinearLayout) findViewById(d.h.title_view);
        this.fPN = findViewById(d.h.interval_view);
        this.gMU = findViewById(d.h.hot_topic_fourm_view);
        this.gMV = findViewById(d.h.hot_topic_divider);
        this.gMW = (TextView) findViewById(d.h.hot_topic_title_edt);
        this.gMX = (TextView) findViewById(d.h.change_one_tv);
        bkT();
        if (this.gMH) {
            this.gMx.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bBf();
        } else {
            bBk();
        }
        TK();
        if (this.gLS || this.gLT) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahR) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.btG = (LinearLayout) findViewById(d.h.post_content_container);
        this.btG.setDrawingCacheEnabled(false);
        this.btG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.btF.requestFocus();
                WriteActivity.this.aAN.AN();
            }
        });
        this.apY.setOnFocusChangeListener(this.btM);
        this.apY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bkM();
                WriteActivity.this.bAC();
            }
        });
        this.gMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bBo();
        h(bBA());
        bBs();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gLS || this.gLT) {
                    if (this.gLU) {
                        this.mName.setText(d.l.feedback_vcode);
                    } else {
                        this.mName.setText(d.l.feedback);
                    }
                } else {
                    this.mName.setText(d.l.post_new_thread);
                }
                this.fPM.setVisibility(0);
                this.btF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.l.send_reply);
                this.btF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fPM.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.l.publish_photo_live);
                this.btF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gMA.setVisibility(8);
                break;
            case 7:
                this.fPM.setVisibility(0);
                this.btF.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.l.post_drift_bottle);
                break;
        }
        bBt();
        bBy();
        bBe();
        bBq();
        bkS();
        bBB();
        if (this.mData.getType() == 4 && this.fPS != null && this.gMb != null) {
            this.fPS.setVisibility(8);
            this.gMb.setVisibility(8);
        }
        bkU();
        ShowSoftKeyPad(this.mInputManager, this.fPM);
        bBp();
    }

    private void bBl() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.send_post));
    }

    private void bBm() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gLS && !this.gLT && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bBw() != null) {
                bBw().setText(d);
                bBw().setSelection(d.length());
            }
        }
    }

    private void bBn() {
        this.gMo = null;
        this.gMq = -1;
        this.gMs = -1;
        aa jh = z.aib().jh(1);
        if (jh != null) {
            this.gMo = jh.ctp;
            this.gMq = getIntent().getIntExtra("category_id", -1);
            if (this.gMo != null && !this.gMo.isEmpty() && this.gMq >= 0) {
                this.gMp = new y();
                this.gMp.ctl = 0;
                this.gMp.name = getPageContext().getResources().getString(d.l.category_auto);
                this.gMs = this.gMp.ctl;
                this.gMr = this.gMp.name;
                for (y yVar : this.gMo) {
                    if (yVar.ctl == this.gMq) {
                        this.gMs = yVar.ctl;
                        this.gMr = yVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bBo() {
        if (this.gMo != null && !this.gMo.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.h.interval_view_cate).setVisibility(0);
            this.gMt = (PostCategoryView) linearLayout.findViewById(d.h.category_selected);
            this.gMt.setText(this.gMr);
            this.gMt.b(this.gMo, this.gMp, this.gMs);
            this.gMt.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.gMt.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.ctl);
                        WriteActivity.this.gMs = atVar.ctl;
                        WriteActivity.this.gMt.bAv();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gMt.bAu();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBw());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBv());
                }
            });
        }
    }

    private void bBp() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gNj = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gNj.setTitle(d.l.no_disturb_start_time);
        this.gNj.setButton(-1, getPageContext().getString(d.l.alert_yes_button), this.gNj);
        this.gNj.setButton(-2, getPageContext().getString(d.l.cancel), this.gNj);
        return this.gNj;
    }

    private void bBq() {
        this.gMj = (RelativeLayout) findViewById(d.h.addition_container);
        this.gMk = (TextView) findViewById(d.h.addition_create_time);
        this.gMl = (TextView) findViewById(d.h.addition_last_time);
        this.gMm = (TextView) findViewById(d.h.addition_last_content);
        if (this.gMi != null) {
            this.gMj.setVisibility(0);
            this.gMk.setText(getPageContext().getString(d.l.write_addition_create) + am.q(this.gMi.getCreateTime() * 1000));
            if (this.gMi.getAlreadyCount() == 0) {
                this.gMl.setVisibility(8);
            } else {
                this.gMl.setText(getPageContext().getString(d.l.write_addition_last) + am.q(this.gMi.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gMi.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gMm.setText(lastAdditionContent);
            } else {
                this.gMm.setVisibility(8);
            }
            bBv().setHint(String.format(getPageContext().getString(d.l.write_addition_hint), Integer.valueOf(this.gMi.getAlreadyCount()), Integer.valueOf(this.gMi.getTotalCount())));
            this.mName.setText(d.l.write_addition_title);
            return;
        }
        this.gMj.setVisibility(8);
    }

    private void bkS() {
        this.fPS = findViewById(d.h.post_prefix_layout);
        this.fPP = (TextView) findViewById(d.h.post_prefix);
        this.gMb = findViewById(d.h.prefix_divider);
        this.fPR = (ImageView) findViewById(d.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fPS.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fPv = 1;
            this.fPS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fPP.setVisibility(0);
                    WriteActivity.this.fPS.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fPQ, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aAN.AN();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fPM);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.btF);
                }
            });
            this.fPR = (ImageView) findViewById(d.h.prefix_icon);
            if (size > 1) {
                this.fPR.setVisibility(0);
                this.fPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fPP.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fPQ, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aAN.AN();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBw());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBv());
                    }
                });
            }
            this.fPQ = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.fPQ.a(this);
            this.fPQ.setMaxHeight(l.f(getActivity(), d.f.ds510));
            this.fPQ.setOutsideTouchable(true);
            this.fPQ.setFocusable(true);
            this.fPQ.setOnDismissListener(this);
            this.fPQ.setBackgroundDrawable(aj.getDrawable(d.e.cp_bg_line_d));
            int color = aj.getColor(d.e.cp_cont_b);
            int color2 = aj.getColor(d.e.cp_cont_c);
            aj.j(this.fPP, d.e.cp_bg_line_d);
            aj.c(this.fPR, d.g.icon_frs_arrow_n);
            this.fPP.setTextColor(color);
            this.gKT.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.c cVar = new com.baidu.tieba.write.c(getActivity());
                this.gKT.add(cVar);
                cVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    cVar.setPrefixTextColor(color2);
                } else {
                    cVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    cVar.setDividerStyle(false);
                }
                this.fPQ.addView(cVar);
            }
            this.fPQ.setCurrentIndex(0);
            this.fPP.setText(prefixs.get(1));
            vh(1);
            return;
        }
        this.fPS.setVisibility(8);
    }

    private void bBr() {
        if (this.gLS && this.mData != null) {
            this.gLZ.setVisibility(0);
            this.gMa.setVisibility(0);
            this.gLY = new FeedBackModel(this);
            this.gLY.tp(this.mData.getForumName());
            this.gLY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gLZ.setVisibility(8);
                        WriteActivity.this.gMa.setVisibility(8);
                        WriteActivity.this.showToast(d.l.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gLZ.setVisibility(8);
                        WriteActivity.this.gMa.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gLZ.a(feedBackModel.bAW(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bBs() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!j.hh()) {
                    WriteActivity.this.showToast(d.l.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBw());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bBv());
                    WriteActivity.this.aAN.AN();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.gLS) {
                            WriteActivity.this.bAD();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            ak akVar = new ak("c12102");
                            akVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(akVar);
                            if (WriteActivity.this.gJH.byP()) {
                                WriteActivity.this.bBE();
                            } else {
                                WriteActivity.this.gMS = true;
                                WriteActivity.this.gJH.cn(WriteActivity.this.getThreadTitle(), WriteActivity.this.bBD());
                            }
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bAD();
                    }
                    TiebaStatic.log(new ak("c12262").ad("obj_locate", WriteActivity.this.gID));
                }
            }
        });
    }

    protected void bBt() {
        this.gMe = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gMe.cM(getPageContext().getString(d.l.is_save_draft)).ar(false).a(getPageContext().getString(d.l.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bBw().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bBv().getText().toString());
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
        this.gMe.b(getPageContext());
    }

    protected void bkT() {
        this.gLV = (HeadImageView) findViewById(d.h.user_head_portrait);
        this.gLV.setIsRound(true);
        this.gLV.setDrawBorder(false);
        this.gLV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dz = o.dz(currentPortrait);
            this.gLV.setUrl(dz);
            this.gLV.c(dz, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gLV.setVisibility(0);
        }
        this.fPM = (EditText) findViewById(d.h.post_title);
        this.fPM.setOnClickListener(this.gNg);
        this.fPM.setOnFocusChangeListener(this.btM);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fPM.setText(this.mData.getTitle());
                this.fPM.setSelection(this.mData.getTitle().length());
            } else if (this.gLU) {
                this.fPM.setText(getResources().getString(d.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fPM.addTextChangedListener(this.btO);
        if (!this.mData.getHaveDraft()) {
            bBm();
            this.gMR = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fPM.setHint(getResources().getString(d.l.feedback_title_hint));
        } else {
            this.fPM.setHint(getResources().getString(d.l.post_title_hint));
        }
    }

    private TextWatcher aZe() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int btR;
            private EditText dEK = null;
            private TextView abv = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bkU();
                if (WriteActivity.this.gMH) {
                    this.btR = this.dEK.getSelectionStart();
                    this.dEK.setSelection(this.btR);
                    WriteActivity.this.b(this.abv, this.dEK);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gMH || !WriteActivity.this.gMI) {
                    if (WriteActivity.this.gMH) {
                        if (this.dEK != WriteActivity.this.gMy || this.abv != WriteActivity.this.gME) {
                            this.dEK = WriteActivity.this.gMy;
                            this.abv = WriteActivity.this.gME;
                        }
                    }
                } else if (this.dEK != WriteActivity.this.gMC || this.abv != WriteActivity.this.gMD) {
                    this.dEK = WriteActivity.this.gMC;
                    this.abv = WriteActivity.this.gMD;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gMH && this.gMI) {
            if (this.gMF != null) {
                this.gMC.removeTextChangedListener(this.gMF);
            }
            this.gMF = textWatcher;
        } else if (this.gMH) {
            if (this.gMG != null) {
                this.gMy.removeTextChangedListener(this.gMG);
            }
            this.gMG = textWatcher;
        }
        return textWatcher;
    }

    private long h(EditText editText) {
        if (editText == this.gMy) {
            return 233L;
        }
        if (editText != this.gMC) {
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

    protected void TK() {
        this.btF = (EditText) findViewById(d.h.post_content);
        this.btF.setDrawingCacheEnabled(false);
        this.btF.setOnClickListener(this.gNg);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString Y = TbFaceManager.DY().Y(getPageContext().getPageActivity(), this.mData.getContent());
            this.btF.setText(Y);
            this.btF.setSelection(Y.length());
        } else if (this.mData.getType() == 2) {
            if (this.gMf) {
                if (this.gMg != null && this.gMg.length() > 0) {
                    this.btF.setText(getPageContext().getPageActivity().getString(d.l.reply_sub_floor, new Object[]{this.gMg}));
                    this.btF.setSelection(this.btF.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.btF.setText(format);
                this.btF.setSelection(format.length());
            }
        }
        this.btF.setOnFocusChangeListener(this.btM);
        this.btF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aAN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.btF.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.btF.addTextChangedListener(this.gNi);
        nx(true);
        if (this.mData.isUserFeedback()) {
            this.btF.setHint(d.l.write_input_content);
        } else {
            this.btF.setHint(d.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nx(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gMH) {
            bBv().setPadding(0, 0, 0, 0);
            bBv().setBackgroundDrawable(null);
            aj.k(bBv(), d.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eij) && this.gMi == null) {
                com.baidu.adp.lib.f.c.fJ().a(this.eij, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.bBv().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bBv(), true, WriteActivity.this.eLn);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBu() {
        int i = 5000;
        if (this.gMi != null) {
            i = 1000;
        }
        return bBv().getText() != null && bBv().getText().length() >= i;
    }

    private void fH(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gLQ)) {
                this.gLQ = "";
                bBv().requestFocus();
                if (bBv().getText() != null && bBv().getText().length() + str.length() > 5000) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bBv().getSelectionStart();
                    editable = bBv().getText();
                }
            } else if ("from_title".equals(this.gLQ)) {
                this.gLQ = "";
                bBw().requestFocus();
                if (bBw().getText() != null && bBw().getText().length() + str.length() > 31) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bBw().getSelectionStart();
                    editable = bBw().getText();
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
    public void ny(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void d(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bBv().getText().getSpans(0, bBv().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gMh == null) {
                this.gMh = Toast.makeText(getPageContext().getPageActivity(), d.l.too_many_face, 0);
            }
            this.gMh.show();
            return;
        }
        String name = lVar.getName();
        final EmotionGroupType xR = lVar.xR();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bBv().getSelectionStart(), aVar, xR);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bBv() != null && bBv().getText() != null) {
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
                int selectionStart = bBv().getSelectionStart() - 1;
                if (bBv().getText().length() > 1 && selectionStart >= 0 && bBv().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bBv().getText().insert(bBv().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bBv().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bBv().getText().insert(bBv().getSelectionStart(), spannableString2);
            }
            Editable text = bBv().getText();
            if (text != null) {
                this.gNb.clear();
                this.gNb.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gNb);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bBv().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bBv().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bBv().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bBv() {
        return this.gMH ? this.gMy : this.btF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bBw() {
        return this.gMH ? this.gMC : this.fPM;
    }

    protected void bBx() {
        Editable text;
        if (bBv() != null && (text = bBv().getText()) != null) {
            int selectionStart = bBv().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bBv().onKeyDown(67, this.gMc);
            }
            bBv().onKeyDown(67, this.gMc);
            int selectionStart2 = bBv().getSelectionStart();
            if (text != null) {
                this.gNb.clear();
                this.gNb.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gNb);
                bBv().setSelection(selectionStart2);
            }
        }
    }

    private void h(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.l.feedback_bar_name).equals(str)) {
            this.gLS = true;
        }
    }

    private void bBy() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bBz() {
        try {
            if (this.gMe != null) {
                this.gMe.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aLr.c(null);
        this.aLr.db(d.l.sending);
        this.aLr.aH(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aLr.aH(false);
    }

    private Boolean bBA() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aCF = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkU() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bBw() != null) {
                str = bBw().getText().toString();
            }
            if (bBv() != null) {
                str2 = bBv().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fPv == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dk(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dk(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dk(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gMH) {
                    dk(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dk(true);
                }
            }
            if (this.mData.getType() == 4) {
                dk(j(this.gMy) && i(this.gMC));
            } else if (this.mData.getType() == 5) {
                dk(j(this.gMy));
            } else if (!TextUtils.isEmpty(str2) || this.aCy != null) {
                dk(true);
            } else if (this.mData.getVideoInfo() != null) {
                dk(true);
            } else {
                dk(false);
            }
        }
    }

    private void dk(boolean z) {
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
        this.aCB = new NewWriteModel(this);
        this.aCB.b(this.aCR);
        registerListener(this.gNd);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bkM();
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
            this.gLS = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gLU = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gMf = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gMg = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
            this.aCz = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gMi = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gMi != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gMn = bundle.getInt("mem_type", 0);
            this.aiq = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gMY = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gID = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gLS = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gLU = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gMf = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gMg = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gMi = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gMi != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gMn = intent.getIntExtra("mem_type", 0);
            this.aiq = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gMY = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gID = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gLS);
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
        this.eij = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gLT = true;
        }
        bBn();
        try {
            this.gMJ = bBI();
        } catch (Throwable th) {
            this.gMJ = null;
        }
    }

    private void bBB() {
        if (v.t(this.mList) > 0 && this.mList.get(0) != null) {
            this.gLV.setVisibility(8);
            this.gMU.setVisibility(0);
            this.gMV.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fPM.setText(com.baidu.tbadk.plugins.a.gz(tq(this.mList.get(0).mTopicName)));
                this.fPM.setMovementMethod(com.baidu.tieba.view.b.bxX());
            }
            this.gMW.setText(this.mList.get(0).mForumName);
            this.fPM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gMZ.equals(charSequence.toString())) {
                        WriteActivity.this.gNa = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gz;
                    if (!WriteActivity.this.gMZ.equals(editable.toString()) && (gz = com.baidu.tbadk.plugins.a.gz(editable.toString())) != null) {
                        WriteActivity.this.gMZ = gz.toString();
                        WriteActivity.this.fPM.setText(gz);
                        if (WriteActivity.this.gNa <= WriteActivity.this.fPM.getText().length()) {
                            WriteActivity.this.fPM.setSelection(WriteActivity.this.gNa);
                        }
                    }
                }
            });
            this.gMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.35
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
            SpannableString gz = com.baidu.tbadk.plugins.a.gz(tq(hotTopicBussinessData.mTopicName));
            if (gz != null) {
                this.fPM.setText(gz);
            }
            this.gMW.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String tq(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        String tq;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!k.isEmpty(writeData.getTitle())) {
                    this.gLX.setVisibility(0);
                    this.gLX.requestFocus();
                    this.aAN.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (k.isEmpty(bBw().getText().toString()) || this.gMR || ((this.gLS || this.gLT) && !k.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!v.u(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            tq = this.mData.getTitle();
                        } else {
                            tq = tq(str);
                        }
                        SpannableString gz = com.baidu.tbadk.plugins.a.gz(tq);
                        if (gz != null) {
                            bBw().setText(gz);
                            bBw().setSelection(gz.length() > tq.length() ? tq.length() : gz.length());
                        }
                    } else {
                        SpannableString gz2 = com.baidu.tbadk.plugins.a.gz(this.mData.getTitle());
                        if (gz2 != null) {
                            bBw().setText(gz2);
                            bBw().setSelection(this.mData.getTitle().length() > gz2.length() ? gz2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bBm();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aAN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((k.isEmpty(bBv().getText().toString()) || this.gLS || this.gLT) && !k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.DY().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gNe);
                    bBv().setText(a2);
                    bBv().setSelection(a2.length());
                    if (this.gMH) {
                        b(this.gME, this.gMy);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bBH();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        Dl();
                    }
                    nz(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bBC();
                }
                bkU();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gMo != null) {
                    this.gMs = this.gMp.ctl;
                    this.gMr = this.gMp.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gMo.size()) {
                            break;
                        }
                        y yVar = this.gMo.get(i);
                        if (categoryTo != yVar.ctl) {
                            i++;
                        } else {
                            this.gMs = categoryTo;
                            this.gMr = yVar.name;
                            this.mData.setCategoryTo(this.gMs);
                            break;
                        }
                    }
                    if (this.gMt != null) {
                        this.gMt.setText(this.gMr);
                        this.gMt.b(this.gMo, this.gMp, this.gMs);
                    }
                }
                this.aAN.AN();
                return;
            }
            return;
        }
        bBC();
        bBm();
    }

    private void bBC() {
        if ((!this.gMH || this.gMw != null) && this.gMv != null) {
            this.gMw.c(this.writeImagesInfo);
            aHH();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gMf);
        if (this.gLS) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING, this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aCz);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gMi);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gMn);
        bundle.putString("from", this.aiq);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gID);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bBv().getEditableText().toString();
        if (obj != null) {
            bBv().setText(TbFaceManager.DY().a(getPageContext().getPageActivity(), obj, this.gNe));
            bBv().setSelection(bBv().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bBD() {
        return (bBv() == null || bBv().getText() == null) ? "" : bBv().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || bBw() == null || bBw().getText() == null) {
            return "";
        }
        String obj = bBw().getText().toString();
        if (this.mPrefixData != null && v.t(this.mPrefixData.getPrefixs()) > 0 && this.fPv != 0 && this.mData.getType() != 4 && this.fPP != null && this.fPP.getText() != null) {
            obj = this.fPP.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAD() {
        bkM();
        this.mData.setContent(bBD());
        this.mData.setTitle(getThreadTitle());
        if (this.gLS || this.gLT) {
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
        if (this.gMq >= 0) {
            this.mData.setCategoryFrom(this.gMq);
        }
        if (this.gMs >= 0) {
            this.mData.setCategoryTo(this.gMs);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aCA != null && this.aCA.UW());
        this.aCB.mG(this.writeImagesInfo.size() > 0);
        if (!v.u(this.mList) && this.gMT != null && this.gMT.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gMT.mForumId));
            this.mData.setForumName(this.gMT.mForumName);
        }
        this.aCB.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aCy != null) {
            if (this.aCy.getId() != null) {
                this.aCB.getWriteData().setVoice(this.aCy.getId());
                this.aCB.getWriteData().setVoiceDuringTime(this.aCy.duration);
            } else {
                this.aCB.getWriteData().setVoice(null);
                this.aCB.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aCB.getWriteData().setVoice(null);
            this.aCB.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aCB.bsE()) {
            showToast(d.l.write_img_limit);
        } else if (!j.hh()) {
            showToast(d.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.l.sending), this.mDialogCancelListener);
            this.aCB.startPostWrite();
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
            if (this.gMi != null) {
                i2 = this.gMi.getTotalCount();
                i = this.gMi.getAlreadyCount() + 1;
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
                if (this.aAN != null && !this.aAN.CC()) {
                    bBv().requestFocus();
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
                            bBv().getText().insert(bBv().getSelectionStart(), sb.toString());
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
                                baC();
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
                    if (!this.gMH) {
                        A(intent);
                        bkU();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aAN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aAN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aAN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bkU();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gLR) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gLR = false;
                            }
                            sb2.append(stringExtra);
                            fH(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !v.u(this.mList)) {
                    if (!v.u(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gMT = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gMT);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gJH.aa(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.btL = this.gJH.byO();
                        this.aAN.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gMS) {
                        bBE();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aAN != null && !this.aAN.CC()) {
                this.btF.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    Dh();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bBG();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aCz = String.valueOf(System.currentTimeMillis());
                    ai.b(getPageContext(), this.aCz);
                    return;
                case 12012:
                    bBG();
                    return;
                case 25004:
                    if ("from_title".equals(this.gLQ)) {
                        bBw().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gLQ)) {
                        bBv().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBE() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gJH.byN());
        this.mData.setCallFrom(this.gID);
        this.mData.setRecommendExt(this.gJH.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bAD();
    }

    private void bBF() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bBG() {
        if (this.gMH) {
            this.gMw.c(this.writeImagesInfo);
            aHH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHH() {
        this.gMw.notifyDataSetChanged();
        this.gMv.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gMw.notifyDataSetChanged();
                WriteActivity.this.gMv.invalidateViews();
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
        bkU();
    }

    private void ac(Intent intent) {
        if (this.gMH) {
            af(intent);
            bBG();
        } else {
            ag(intent);
        }
        bkU();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bBG();
            nz(true);
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

    private void baC() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void U(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fqa.parseJson(stringExtra);
            this.fqa.updateQuality();
            if (this.fqa.getChosedFiles() != null && this.fqa.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fqa.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fqa.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bBw());
        HidenSoftKeyPad(this.mInputManager, bBv());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ag(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aCz = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aCz;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ad(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aCz, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bBH();
            Dl();
        }
        nz(true);
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
                bBH();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    Dl();
                }
            }
            nz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBH() {
        if (this.aAN.eP(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Dh() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.t(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aCz));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nz(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cqs == null) {
            this.cqs = VoiceManager.instance();
        }
        return this.cqs;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ahh() {
        this.cqs = getVoiceManager();
        this.cqs.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tG(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.crk) != null) {
                    TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahj));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gMi == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aCH = i;
        if (this.aAN != null) {
            this.aAN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aAN.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void Dl() {
        if (!this.gMH) {
            if (this.aAN != null) {
                this.aAN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aAN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gMu != null) {
                this.gMu.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gMu.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (this.aAN != null) {
            this.aAN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vh(int i) {
        if (i < this.gKT.size()) {
            for (int i2 = 0; i2 < this.gKT.size(); i2++) {
                this.gKT.get(i2).no(false);
            }
            this.gKT.get(i).no(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sT(int i) {
        this.fPv = i;
        this.fPQ.setCurrentIndex(i);
        vh(i);
        this.fPP.setText(this.mPrefixData.getPrefixs().get(i));
        bkU();
        g.a(this.fPQ, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fPS.setSelected(false);
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
            Dc();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aK(getApplicationContext())) {
                ai.b(getPageContext(), this.aCz);
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
        if (this.gMP && System.currentTimeMillis() - this.gMQ < 800) {
            l.a(getPageContext().getPageActivity(), getCurrentFocus());
            this.gMP = false;
        }
        if (this.gNc != null && !z) {
            this.gNc.aRv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr(String str) {
        if (!k.isEmpty(str) && this.gMM != null) {
            ts(str);
            this.gMM.dismiss();
        }
    }

    private void cb(Context context) {
        gMO = l.af(context);
    }

    private void ts(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gMP = true;
        bBH();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            Dl();
        }
        nz(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3973=4] */
    private static Bitmap b(String str, float f) {
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

    private File bBI() {
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

    private void bBJ() {
        if (this.gMJ != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cb(getActivity());
            this.gML = getPageContext().getPageActivity().getLayoutInflater().inflate(d.j.rec_dialog, (ViewGroup) null);
            this.gML.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gMJ != null) {
                        WriteActivity.this.tr(WriteActivity.this.gMJ.getAbsolutePath());
                    }
                }
            });
            this.gMK = (TbImageView) this.gML.findViewById(d.h.rec_img_view);
            this.gMN = (LinearLayout) this.gML.findViewById(d.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gMJ.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gMJ.getAbsolutePath());
                Bitmap b = b(this.gMJ.getAbsolutePath(), getResources().getDimensionPixelSize(d.f.ds160));
                if (b != null) {
                    this.gMK.setImageBitmap(b);
                    this.gMK.setDrawBorder(true);
                    this.gMK.setBorderWidth(2);
                    this.gMK.setBorderColor(aj.getColor(d.e.common_color_10264));
                    this.gMM = new Dialog(getActivity(), d.m.bubble_dialog);
                    this.gMM.setCanceledOnTouchOutside(true);
                    this.gMM.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gMP) {
                                l.a(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gMQ = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gMM.setContentView(this.gML);
                    this.gMM.show();
                    Window window = this.gMM.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.f.ds28);
                    attributes.y = (gMO / 18) + getResources().getDimensionPixelSize(d.f.ds12);
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
            this.gLR = false;
            this.gLQ = "";
            if ("from_content".equals(str)) {
                this.gLQ = "from_content";
            } else if ("from_title".equals(str)) {
                this.gLQ = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                ny(false);
            }
        }
    }

    public void AP() {
        if (this.gLS || !v.u(this.mList)) {
            this.gLX.setVisibility(0);
            this.gLX.requestFocus();
            this.aAN.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.gLX.setVisibility(8);
    }
}
