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
import com.baidu.a.a.a;
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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.x;
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
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0000a, VoiceManager.c, r.a, d.a {
    private static int gGA = 0;
    private i aCi;
    private VoiceData.VoiceModel aDR;
    private String aDS;
    private LocationModel aDT;
    private NewWriteModel aDU;
    private String ajt;
    private VoiceManager ciW;
    private LinearLayout evg;
    private int fQC;
    private TextView fQW;
    private com.baidu.tieba.write.d fQX;
    private ImageView fQY;
    private View fQZ;
    private LinearLayout gFJ;
    private View gFM;
    private View gFN;
    private Toast gFT;
    private AdditionData gFU;
    private RelativeLayout gFV;
    private TextView gFW;
    private TextView gFX;
    private TextView gFY;
    private com.baidu.tieba.write.a gGE;
    private HotTopicBussinessData gGG;
    private View gGH;
    private View gGI;
    private TextView gGJ;
    private TextView gGK;
    private com.baidu.tieba.write.b.b gGP;
    private com.baidu.tieba.view.a gGV;
    List<x> gGa;
    x gGb;
    private int gGc;
    private String gGd;
    private int gGe;
    private PostCategoryView gGf;
    private NewFrameMultiImgToolView gGg;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private String gFE = "";
    private boolean gFF = false;
    private WriteData mData = null;
    private boolean gFG = false;
    private boolean gFH = false;
    private boolean gFI = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText fQT = null;
    private HeadImageView gDG = null;
    private View fQU = null;
    private LinearLayout bqo = null;
    private EditText bqn = null;
    private FeedBackModel gFK = null;
    private FeedBackTopListView gFL = null;
    private ArrayList<com.baidu.tieba.write.c> gEH = new ArrayList<>();
    private String ecz = null;
    private final KeyEvent gFO = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View arm = null;
    private TextView gFP = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a gFQ = null;
    private final Handler mHandler = new Handler();
    private boolean gFR = false;
    private String gFS = null;
    private RelativeLayout mParent = null;
    private String aDZ = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aEc = 0;
    private int gFZ = 0;
    private WriteImagesInfo fsK = new WriteImagesInfo();
    private View mRootView = null;
    private GridView gGh = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a gGi = null;
    private ScrollView gGj = null;
    private EditText gGk = null;
    private View gGl = null;
    private View gGm = null;
    private View gGn = null;
    private EditText gGo = null;
    private TextView gGp = null;
    private TextView gGq = null;
    private TextWatcher gGr = null;
    private TextWatcher gGs = null;
    private boolean gGt = false;
    private boolean gGu = false;
    private com.baidu.tbadk.core.view.a aMk = null;
    private File gGv = null;
    private TbImageView gGw = null;
    private View gGx = null;
    private Dialog gGy = null;
    private LinearLayout gGz = null;
    private boolean gGB = false;
    private long gGC = -1000;
    private boolean gGD = false;
    private String gCj = "2";
    private boolean gGF = false;
    private String gGL = "";
    private String gGM = "";
    private int gGN = 0;
    private SpannableStringBuilder gGO = new SpannableStringBuilder();
    private final HttpMessageListener gGQ = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ecz)) {
                    WriteActivity.this.ecz = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nh(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ecz)) {
                    WriteActivity.this.ecz = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ecz);
                    WriteActivity.this.nh(true);
                }
            }
        }
    };
    private TbFaceManager.a gGR = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gk(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.a.a.class);
            com.baidu.adp.widget.a.a aVar = runTask != null ? (com.baidu.adp.widget.a.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kX());
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
    private final NewWriteModel.d aEl = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.afo();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                if (z) {
                    WriteActivity.this.bN(z);
                    WriteActivity.this.a(true, postWriteCallBackData);
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
                        if (!u.v(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.gGL)) {
                            TiebaStatic.log(new aj("c11731").aa("obj_id", WriteActivity.this.gGL));
                        }
                    }
                    WriteActivity.this.c(postWriteCallBackData);
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
                    writeData.setVcodeExtra(qVar.yy());
                    if (com.baidu.tbadk.q.a.gY(qVar.yx())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12006, writeData, false, qVar.yx());
                        if (WriteActivity.this.gFI) {
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
    private final LocationModel.a aEj = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DR() {
            WriteActivity.this.showToast(d.l.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void ga(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.l.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bta())) {
                WriteActivity.this.b(2, true, aVar.bta());
            } else {
                ga(null);
            }
        }
    };
    private final CustomMessageListener gjZ = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aDT.mA(false);
                    WriteActivity.this.aDT.cj(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aDT.mA(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private final View.OnClickListener gGS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bzP = WriteActivity.this.bzP();
            if (bzP >= 0 && bzP < WriteActivity.this.bqn.getText().length()) {
                WriteActivity.this.bqn.setSelection(bzP);
            }
        }
    };
    private boolean gGT = true;
    private final View.OnFocusChangeListener bqu = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.fQT || view == WriteActivity.this.arm || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.gGT = true;
                    WriteActivity.this.bzQ();
                    if (WriteActivity.this.aCi != null) {
                        WriteActivity.this.aCi.Bu();
                    }
                    k.c(WriteActivity.this.getActivity(), WriteActivity.this.fQT);
                } else if (view == WriteActivity.this.fQT) {
                    WriteActivity.this.fQW.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.bqn && z) {
                WriteActivity.this.gGT = false;
                WriteActivity.this.bzQ();
                WriteActivity.this.aCi.Bu();
                k.c(WriteActivity.this.getActivity(), WriteActivity.this.bqn);
            }
        }
    };
    private TextWatcher bqw = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.7
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bmd();
        }
    };
    private TextWatcher gGU = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.8
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WriteActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bmd();
        }
    };
    private final a.InterfaceC0118a eQq = new a.InterfaceC0118a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0118a
        public void lj() {
            WriteActivity.this.ecz = null;
            WriteActivity.this.nh(false);
            WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.ajt)) {
            TiebaStatic.log("c10867");
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void DD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.l.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DE();
        } else if (this.aDT.bti()) {
            DC();
        } else {
            this.aDT.mA(false);
            b(1, true, null);
            this.aDT.btg();
        }
    }

    private void DE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cc(d.l.location_app_permission_prompt).a(d.l.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aDT.Tq();
                } else {
                    WriteActivity.this.aEj.DR();
                }
                aVar2.dismiss();
            }
        }).b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzP() {
        int selectionEnd = bAh().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bAh().getText().getSpans(0, bAh().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bAh().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bAh().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzQ() {
        if (this.aCi != null) {
            this.aCi.setBarLauncherEnabled(!this.gGT);
            this.aCi.c(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.gGt) {
            this.fQT.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.gGn.setVisibility(8);
            } else {
                this.gGn.setVisibility(0);
            }
            b(this.gGq, this.gGk);
            b(this.gGp, this.gGo);
            bmd();
        }
        if (this.gFG) {
            this.fQT.requestFocus();
            ShowSoftKeyPadDelay(this.fQT);
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
        bAd();
        this.aDT = new LocationModel(this);
        this.aDT.a(this.aEj);
        registerListener(this.gjZ);
        initEditor();
        bAv();
        if (this.gGt) {
            this.gGi.setEditorTools(this.aCi);
        } else {
            this.bqn.requestFocus();
        }
        Bw();
        DN();
        this.gGE = new com.baidu.tieba.write.a(getPageContext(), this.mData);
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aCi = new i(getActivity());
        if (9 == this.mData.getType()) {
            this.aCi.setBarMaxLauCount(6);
        } else {
            this.aCi.setBarMaxLauCount(5);
        }
        this.aCi.setMoreButtonAtEnd(true);
        this.aCi.setBarLauncherType(1);
        this.aCi.bE(true);
        this.aCi.setMoreLauncherIcon(d.g.write_more);
        this.aCi.setBackgroundColorId(d.e.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bzT();
                break;
            default:
                bzU();
                break;
        }
        this.aCi.Db();
        if (this.gFJ != null) {
            this.gFJ.addView(this.aCi);
        }
        bzV();
        this.aCi.lT();
        l eC = this.aCi.eC(6);
        if (eC != null && !TextUtils.isEmpty(this.aDZ)) {
            ((View) eC).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aDZ);
                }
            });
        }
        if (!this.gGt) {
            this.aCi.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aCi.Bu();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aCi.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aCi.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
        cVar.context = getPageContext();
        if (this.mData.getForumName() != null) {
            cVar.bqt = this.mData.getForumName() + getResources().getString(d.l.bar);
        }
        this.aCi.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
        if (this.gGg != null) {
            this.gGg.setEditorTools(this.aCi);
            this.gGg.bzb();
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bzR() {
        this.gGl = this.mRootView.findViewById(d.h.photo_live_scroll);
        this.gGn = this.gGl.findViewById(d.h.live_post_title_container);
        this.gGk = (EditText) this.gGl.findViewById(d.h.live_post_content);
        this.gGh = (GridView) this.gGl.findViewById(d.h.photoLiveGridView);
        this.gGo = (EditText) this.gGl.findViewById(d.h.live_post_title);
        this.gGp = (TextView) this.gGl.findViewById(d.h.titleOverPlusNumber);
        this.gGq = (TextView) this.gGl.findViewById(d.h.contentOverPlusNumber);
        this.gGm = this.gGl.findViewById(d.h.live_interval_view);
        this.gGp.setText(String.valueOf(20));
        this.gGq.setText(String.valueOf(233));
        this.gGl.setVisibility(0);
        this.gGp.setVisibility(0);
        this.gGq.setVisibility(0);
        this.gGo.setHint(d.l.tips_title_limit_new);
        this.gGo.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gGu = true;
                    WriteActivity.this.gGT = true;
                    WriteActivity.this.bzQ();
                    if (WriteActivity.this.aCi != null) {
                        WriteActivity.this.aCi.Bu();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.gGk.setHint(d.l.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.gGk.setHint(d.l.live_write_input_content_update);
        }
        this.gGk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.gGu = false;
                    WriteActivity.this.gGT = false;
                    WriteActivity.this.bzQ();
                    if (WriteActivity.this.aCi != null) {
                        WriteActivity.this.aCi.Bu();
                    }
                }
            }
        });
        this.gGk.requestFocus();
        this.gGk.addTextChangedListener(baG());
        this.gGo.requestFocus();
        this.gGo.addTextChangedListener(baG());
        this.gGo.setOnClickListener(this.gGS);
        this.gGk.setOnClickListener(this.gGS);
        this.gGi = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.gGh);
        this.gGi.uo(6);
        this.gGh.setAdapter((ListAdapter) this.gGi);
        View findViewById = this.gGl.findViewById(d.h.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bzg() {
                WriteActivity.this.aGr();
            }
        });
        bzS();
    }

    private void bzS() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.gGo.setText(this.mData.getTitle());
                this.gGo.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void d(com.baidu.tbadk.editortools.a aVar) {
        if (this.gGt) {
            new com.baidu.tbadk.editortools.a(14, -1, 1);
            bAr();
        }
        if (this.aCi.Dd()) {
            this.aCi.Bu();
        }
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumId();
        }
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra("forum_id", str);
        albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
        albumActivityConfig.setRequestCode(12002);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    private void bzT() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aCi.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aCi.eE(5);
        if (eE != null) {
            eE.aCP = 2;
            eE.aCN = d.g.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aCN = d.g.write_at;
        this.aCi.b(aVar);
        this.aCi.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bzU() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.r rVar3;
        com.baidu.tbadk.editortools.r rVar4;
        if (this.mData.getType() == 9) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
            dVar.aCN = d.g.write_picture;
            this.aCi.b(dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        this.aCi.b(aVar);
        aVar.aCN = d.g.write_hot_topic;
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask2 != null && (rVar4 = (com.baidu.tbadk.editortools.r) runTask2.getData()) != null) {
            rVar4.aCP = 6;
            rVar4.aCN = d.g.write_privilege;
            this.aCi.b(rVar4);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 5);
        aVar2.aCN = d.g.write_at;
        this.aCi.b(aVar2);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask3 != null && (rVar3 = (com.baidu.tbadk.editortools.r) runTask3.getData()) != null) {
            rVar3.aCR = true;
            rVar3.aCP = 9;
            rVar3.aCN = 0;
            this.aCi.b(rVar3);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.r.class);
        if (runTask4 != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
            rVar2.aCR = true;
            rVar2.aCP = 10;
            rVar2.aCN = 0;
            this.aCi.b(rVar2);
        }
        Boolean bAm = bAm();
        if (!this.gFG && bAm != null && bAm.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.btD() && m.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, getActivity()), com.baidu.tbadk.editortools.r.class)) != null && (rVar = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar.aCP = 2;
            rVar.aCN = d.g.write_recorder;
            this.aCi.b(rVar);
        }
        if (this.gFU == null) {
            if (this.gGP == null) {
                this.gGP = new com.baidu.tieba.write.b.b(getActivity(), this.gCj);
            }
            this.aCi.b(this.gGP);
        }
        this.aCi.A(arrayList);
        com.baidu.tbadk.editortools.r eE = this.aCi.eE(5);
        if (eE != null) {
            eE.aCP = 1;
            eE.aCN = d.g.write_emotion;
        }
    }

    private void bzV() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                int size;
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bAg()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12004, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        WriteActivity.this.d(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bAg()) {
                            WriteActivity.this.showToast(d.l.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            WriteActivity.this.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bAj();
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            WriteActivity.this.aDR = (VoiceData.VoiceModel) aVar.data;
                            WriteActivity.this.bmd();
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aDR = null;
                        WriteActivity.this.bmd();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bAt();
                        WriteActivity.this.bmd();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            int intValue = ((Integer) aVar.data).intValue();
                            if (WriteActivity.this.writeImagesInfo != null && WriteActivity.this.writeImagesInfo.getChosedFiles() != null && (size = WriteActivity.this.writeImagesInfo.getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), 12012, WriteActivity.this.writeImagesInfo, intValue)));
                            }
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.gFU == null) {
                            WriteActivity.this.DF();
                            return;
                        }
                        switch (WriteActivity.this.aEc) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (aa.aD(pageActivity)) {
                                    WriteActivity.this.DD();
                                    return;
                                } else {
                                    aa.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.DC();
                                return;
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ecz = null;
                        } else {
                            WriteActivity.this.ecz = (String) aVar.data;
                        }
                        WriteActivity.this.nh(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        aj ajVar = new aj("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        ajVar.aa("fid", str);
                        TiebaStatic.log(ajVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aCi.Dd()) {
                                        WriteActivity.this.aCi.Bu();
                                        WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bmd();
                        if (WriteActivity.this.bqn != null) {
                            WriteActivity.this.bqn.requestFocus();
                        }
                        WriteActivity.this.aCi.Bu();
                        WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bqn);
                    } else if (aVar.code == 40) {
                        if (((aVar.data instanceof String) || aVar.data == null) && WriteActivity.this.mData != null) {
                            WriteActivity.this.mData.setGraffitiFileName((String) aVar.data);
                            WriteActivity.this.bmd();
                        }
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.gFF = true;
                        WriteActivity.this.ni(true);
                        if (WriteActivity.this.bAi().isFocused()) {
                            WriteActivity.this.gFE = "from_title";
                        } else if (WriteActivity.this.bAh().isFocused()) {
                            WriteActivity.this.gFE = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.evg.setVisibility(0);
                        WriteActivity.this.evg.requestFocus();
                    } else if (aVar.code == 51) {
                        WriteActivity.this.gGE.cm(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAp());
                        TiebaStatic.log(new aj("c12258").aa("obj_locate", WriteActivity.this.gCj));
                    }
                }
            }
        };
        this.aCi.a(16, bVar);
        this.aCi.a(14, bVar);
        this.aCi.a(24, bVar);
        this.aCi.a(3, bVar);
        this.aCi.a(10, bVar);
        this.aCi.a(11, bVar);
        this.aCi.a(12, bVar);
        this.aCi.a(13, bVar);
        this.aCi.a(15, bVar);
        this.aCi.a(18, bVar);
        this.aCi.a(25, bVar);
        this.aCi.a(27, bVar);
        this.aCi.a(29, bVar);
        this.aCi.a(40, bVar);
        this.aCi.a(43, bVar);
        this.aCi.a(45, bVar);
        this.aCi.a(48, bVar);
        this.aCi.a(46, bVar);
        this.aCi.a(49, bVar);
        this.aCi.a(47, bVar);
        this.aCi.a(51, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF() {
        if (this.aDT.Tm()) {
            if (this.aDT.bti()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bte().getLocationData().bta());
                return;
            }
            b(1, true, null);
            this.aDT.btg();
            return;
        }
        b(0, true, null);
    }

    protected void blV() {
        if (this.aDU != null) {
            this.aDU.cancelLoadData();
        }
        if (this.gFK != null) {
            this.gFK.cancelLoadData();
        }
        if (this.aDT != null) {
            this.aDT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        blV();
        bAl();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gGE != null) {
            this.gGE.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzo() {
        if (this.mData != null && this.mData.getType() == 2 && this.gFR) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bAi().getText().toString());
            this.mData.setContent(bAh().getText().toString());
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
            if (this.fQX != null && this.fQX.isShowing()) {
                g.a(this.fQX, getPageContext().getPageActivity());
                return true;
            } else if (this.aCi.Dd()) {
                this.aCi.Bu();
                return true;
            } else {
                blV();
                bzo();
                return true;
            }
        }
        if (i == 67 && (text = bAh().getText()) != null) {
            int selectionStart = bAh().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAh().onKeyDown(67, this.gFO);
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
        getLayoutMode().t(this.gGz);
        if (this.gGw != null && i == 1) {
            this.gGw.setBorderColor(ai.getColor(d.e.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ai.c(this.mPost, d.e.cp_link_tip_a, 1);
        bzQ();
        ai.k(this.gGl, d.e.cp_bg_line_d);
        ai.k(this.fQU, d.e.cp_bg_line_c);
        ai.k(this.gGm, d.e.cp_bg_line_c);
        ai.k(bAi(), d.e.cp_bg_line_d);
        if (TextUtils.isEmpty(this.ecz)) {
            ai.k(bAh(), d.e.cp_bg_line_d);
        }
        bmd();
        this.aCi.onChangeSkinType(i);
        if (this.gGf != null) {
            this.gGf.xd();
        }
        ai.i(this.mName, d.e.cp_cont_b);
        this.fQT.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.bqn.setHintTextColor(ai.getColor(d.e.cp_cont_e));
    }

    private void bzW() {
        this.gGg = (NewFrameMultiImgToolView) this.mRootView.findViewById(d.h.muti_image_upload_1);
        com.baidu.tbadk.img.b bVar = new com.baidu.tbadk.img.b();
        this.gGg.initView();
        this.gGg.setVisibility(0);
        this.gGg.setAsyncLocalImageLoader(bVar);
        if (this.gGg.getDragLayer() != null && this.gGg.getDragHorizonScrollView() != null) {
            com.baidu.tieba.tbadkCore.imgView.b bVar2 = new com.baidu.tieba.tbadkCore.imgView.b(getPageContext().getContext());
            bVar2.a(this.gGg.getDragLayer());
            bVar2.a((e) this.gGg.getDragHorizonScrollView());
            bVar2.a((com.baidu.tieba.tbadkCore.imgView.d) this.gGg.getDragHorizonScrollView());
            this.gGg.getDragHorizonScrollView().setStartEndSpace((int) getResources().getDimension(d.f.ds44));
            this.gGg.getDragHorizonScrollView().setPadding((int) getResources().getDimension(d.f.ds0));
            this.gGg.getDragHorizonScrollView().setNeedRecomputeAddView(false);
            if (this.mData.getType() != 9) {
                this.gGg.getDragHorizonScrollView().setAddView(a(getPageContext().getContext(), this.gGg));
            }
            this.gGg.getDragHorizonScrollView().setOnSwapDataListener(this.gGg);
            this.gGg.getDragHorizonScrollView().setMaxItemNum(10);
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
        ai.c(imageView, d.g.new_frame_btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setClickable(true);
        imageView.setContentDescription(context.getString(d.l.add));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
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
        this.aMk = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gGt = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.j.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.arm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.arm.getLayoutParams();
            layoutParams.leftMargin = k.g(getActivity(), d.f.ds10);
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.arm != null && (this.arm.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.arm.getLayoutParams();
            layoutParams2.width = -2;
            this.arm.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.g.write_close_selector, d.g.write_close_selector);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ai.i(this.mName, d.e.cp_cont_b);
        this.gFP = (TextView) findViewById(d.h.btn_image_problem);
        bzX();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams3.rightMargin = k.g(getPageContext().getPageActivity(), d.f.ds16);
        this.mPost.setLayoutParams(layoutParams3);
        this.mPost.setOnFocusChangeListener(this.bqu);
        this.gGj = (ScrollView) findViewById(d.h.write_scrollview);
        this.gGj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.bqn != null) {
                        k.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.bqn);
                    }
                    if (WriteActivity.this.aCi != null) {
                        WriteActivity.this.aCi.Bu();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gFL = (FeedBackTopListView) findViewById(d.h.feedback_top_list);
        this.gFM = findViewById(d.h.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.h.parent);
        this.gFJ = (LinearLayout) findViewById(d.h.tool_view);
        this.gFJ.setContentDescription("..");
        this.evg = (LinearLayout) findViewById(d.h.title_view);
        this.fQU = findViewById(d.h.interval_view);
        this.gGH = findViewById(d.h.hot_topic_fourm_view);
        this.gGI = findViewById(d.h.hot_topic_divider);
        this.gGJ = (TextView) findViewById(d.h.hot_topic_title_edt);
        this.gGK = (TextView) findViewById(d.h.change_one_tv);
        bmc();
        if (this.gGt) {
            this.gGj.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bzR();
        } else {
            bzW();
        }
        Sk();
        if (this.gFG || this.gFH) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aiU) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.h.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.h.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.bqo = (LinearLayout) findViewById(d.h.post_content_container);
        this.bqo.setDrawingCacheEnabled(false);
        this.bqo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bqn.requestFocus();
                WriteActivity.this.aCi.Bu();
            }
        });
        this.arm.setOnFocusChangeListener(this.bqu);
        this.arm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.blV();
                WriteActivity.this.bzo();
            }
        });
        this.gFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bAa();
        j(bAm());
        bAe();
        switch (this.mData.getType()) {
            case 0:
            case 9:
                if (this.gFG || this.gFH) {
                    if (this.gFI) {
                        this.mName.setText(d.l.feedback_vcode);
                    } else {
                        this.mName.setText(d.l.feedback);
                    }
                } else {
                    this.mName.setText(d.l.post_new_thread);
                }
                this.fQT.setVisibility(0);
                this.bqn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
            default:
                this.mName.setText(d.l.send_reply);
                this.bqn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.fQT.setVisibility(8);
                break;
            case 4:
                this.mName.setText(d.l.publish_photo_live);
                this.bqn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                break;
            case 5:
                this.mName.setText(getPageContext().getResources().getString(d.l.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                this.gGm.setVisibility(8);
                break;
            case 7:
                this.fQT.setVisibility(0);
                this.bqn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                this.mName.setText(d.l.post_drift_bottle);
                break;
        }
        bAf();
        bAk();
        bzQ();
        bAc();
        bmb();
        bAn();
        if (this.mData.getType() == 4 && this.fQZ != null && this.gFN != null) {
            this.fQZ.setVisibility(8);
            this.gFN.setVisibility(8);
        }
        bmd();
        ShowSoftKeyPad(this.mInputManager, this.fQT);
        bAb();
    }

    private void bzX() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.l.send_post));
    }

    private void bzY() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.gFG && !this.gFH && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = al.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bAi() != null) {
                bAi().setText(c);
                bAi().setSelection(c.length());
            }
        }
    }

    private void bzZ() {
        this.gGa = null;
        this.gGc = -1;
        this.gGe = -1;
        z iJ = y.agf().iJ(1);
        if (iJ != null) {
            this.gGa = iJ.clO;
            this.gGc = getIntent().getIntExtra("category_id", -1);
            if (this.gGa != null && !this.gGa.isEmpty() && this.gGc >= 0) {
                this.gGb = new x();
                this.gGb.clK = 0;
                this.gGb.name = getPageContext().getResources().getString(d.l.category_auto);
                this.gGe = this.gGb.clK;
                this.gGd = this.gGb.name;
                for (x xVar : this.gGa) {
                    if (xVar.clK == this.gGc) {
                        this.gGe = xVar.clK;
                        this.gGd = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bAa() {
        if (this.gGa != null && !this.gGa.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.h.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.h.interval_view_cate).setVisibility(0);
            this.gGf = (PostCategoryView) linearLayout.findViewById(d.h.category_selected);
            this.gGf.setText(this.gGd);
            this.gGf.b(this.gGa, this.gGb, this.gGe);
            this.gGf.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, as asVar) {
                    if (asVar != null) {
                        WriteActivity.this.gGf.setText(asVar.name);
                        WriteActivity.this.mData.setCategoryTo(asVar.clK);
                        WriteActivity.this.gGe = asVar.clK;
                        WriteActivity.this.gGf.bzi();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.gGf.bzh();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAi());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAh());
                }
            });
        }
    }

    private void bAb() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.gGV = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.gGV.setTitle(d.l.no_disturb_start_time);
        this.gGV.setButton(-1, getPageContext().getString(d.l.alert_yes_button), this.gGV);
        this.gGV.setButton(-2, getPageContext().getString(d.l.alert_no_button), this.gGV);
        return this.gGV;
    }

    private void bAc() {
        this.gFV = (RelativeLayout) findViewById(d.h.addition_container);
        this.gFW = (TextView) findViewById(d.h.addition_create_time);
        this.gFX = (TextView) findViewById(d.h.addition_last_time);
        this.gFY = (TextView) findViewById(d.h.addition_last_content);
        if (this.gFU != null) {
            this.gFV.setVisibility(0);
            this.gFW.setText(getPageContext().getString(d.l.write_addition_create) + al.r(this.gFU.getCreateTime() * 1000));
            if (this.gFU.getAlreadyCount() == 0) {
                this.gFX.setVisibility(8);
            } else {
                this.gFX.setText(getPageContext().getString(d.l.write_addition_last) + al.r(this.gFU.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.gFU.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.gFY.setText(lastAdditionContent);
            } else {
                this.gFY.setVisibility(8);
            }
            bAh().setHint(String.format(getPageContext().getString(d.l.write_addition_hint), Integer.valueOf(this.gFU.getAlreadyCount()), Integer.valueOf(this.gFU.getTotalCount())));
            this.mName.setText(d.l.write_addition_title);
            return;
        }
        this.gFV.setVisibility(8);
    }

    private void bmb() {
        this.fQZ = findViewById(d.h.post_prefix_layout);
        this.fQW = (TextView) findViewById(d.h.post_prefix);
        this.gFN = findViewById(d.h.prefix_divider);
        this.fQY = (ImageView) findViewById(d.h.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.fQZ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.fQC = 1;
            this.fQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.fQW.setVisibility(0);
                    WriteActivity.this.fQZ.setSelected(true);
                    g.showPopupWindowAsDropDown(WriteActivity.this.fQX, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aCi.Bu();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.fQT);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bqn);
                }
            });
            this.fQY = (ImageView) findViewById(d.h.prefix_icon);
            if (size > 1) {
                this.fQY.setVisibility(0);
                this.fQW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.fQW.setSelected(true);
                        g.showPopupWindowAsDropDown(WriteActivity.this.fQX, view, 0, k.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                        WriteActivity.this.aCi.Bu();
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAi());
                        WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAh());
                    }
                });
            }
            this.fQX = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.fQX.a(this);
            this.fQX.setMaxHeight(k.g(getActivity(), d.f.ds510));
            this.fQX.setOutsideTouchable(true);
            this.fQX.setFocusable(true);
            this.fQX.setOnDismissListener(this);
            this.fQX.setBackgroundDrawable(ai.getDrawable(d.e.cp_bg_line_d));
            int color = ai.getColor(d.e.cp_cont_b);
            int color2 = ai.getColor(d.e.cp_cont_c);
            ai.j(this.fQW, d.e.cp_bg_line_d);
            ai.c(this.fQY, d.g.icon_frs_arrow_n);
            this.fQW.setTextColor(color);
            this.gEH.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.c cVar = new com.baidu.tieba.write.c(getActivity());
                this.gEH.add(cVar);
                cVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    cVar.setPrefixTextColor(color2);
                } else {
                    cVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    cVar.setDividerStyle(false);
                }
                this.fQX.addView(cVar);
            }
            this.fQX.ub(0);
            this.fQW.setText(prefixs.get(1));
            uy(1);
            return;
        }
        this.fQZ.setVisibility(8);
    }

    private void bAd() {
        if (this.gFG && this.mData != null) {
            this.gFL.setVisibility(0);
            this.gFM.setVisibility(0);
            this.gFK = new FeedBackModel(this);
            this.gFK.th(this.mData.getForumName());
            this.gFK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void g(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.gFL.setVisibility(8);
                        WriteActivity.this.gFM.setVisibility(8);
                        WriteActivity.this.showToast(d.l.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.gFL.setVisibility(8);
                        WriteActivity.this.gFM.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.gFL.a(feedBackModel.bzI(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bAe() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.i.hr()) {
                    WriteActivity.this.showToast(d.l.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAi());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bAh());
                    WriteActivity.this.aCi.Bu();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.gFG) {
                            WriteActivity.this.bzp();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            aj ajVar = new aj("c12102");
                            ajVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(ajVar);
                            if (WriteActivity.this.gGE.bxz()) {
                                WriteActivity.this.bAq();
                            } else {
                                WriteActivity.this.gGF = true;
                                WriteActivity.this.gGE.cm(WriteActivity.this.getThreadTitle(), WriteActivity.this.bAp());
                            }
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bzp();
                    }
                    TiebaStatic.log(new aj("c12262").aa("obj_locate", WriteActivity.this.gCj));
                }
            }
        });
    }

    protected void bAf() {
        this.gFQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.gFQ.cT(getPageContext().getString(d.l.is_save_draft)).ar(false).a(getPageContext().getString(d.l.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bAi().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bAh().getText().toString());
                int type = WriteActivity.this.mData.getType();
                if (type == 0 || type == 9) {
                    r.c(WriteActivity.this.mData.getForumId(), WriteActivity.this.mData);
                } else if (type == 1) {
                    r.d(WriteActivity.this.mData.getThreadId(), WriteActivity.this.mData);
                }
                WriteActivity.this.showToast(d.l.draft_save_success);
                WriteActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WriteActivity.this.finish();
                    }
                }, 1000L);
            }
        }).b(getPageContext().getString(d.l.not_save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.22
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
        this.gFQ.b(getPageContext());
    }

    protected void bmc() {
        this.gDG = (HeadImageView) findViewById(d.h.user_head_portrait);
        this.gDG.setIsRound(true);
        this.gDG.setDrawBorder(false);
        this.gDG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dL = n.dL(currentPortrait);
            this.gDG.setUrl(dL);
            this.gDG.c(dL, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.gDG.setVisibility(0);
        }
        this.fQT = (EditText) findViewById(d.h.post_title);
        this.fQT.setOnClickListener(this.gGS);
        this.fQT.setOnFocusChangeListener(this.bqu);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.fQT.setText(this.mData.getTitle());
                this.fQT.setSelection(this.mData.getTitle().length());
            } else if (this.gFI) {
                this.fQT.setText(getResources().getString(d.l.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.fQT.addTextChangedListener(this.bqw);
        if (!this.mData.getHaveDraft()) {
            bzY();
            this.gGD = true;
        }
        if (this.mData.isUserFeedback()) {
            this.fQT.setHint(getResources().getString(d.l.feedback_title_hint));
        } else {
            this.fQT.setHint(getResources().getString(d.l.post_title_hint));
        }
    }

    private TextWatcher baG() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            private int bqz;
            private EditText dza = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bmd();
                if (WriteActivity.this.gGt) {
                    this.bqz = this.dza.getSelectionStart();
                    this.dza.setSelection(this.bqz);
                    WriteActivity.this.b(this.mTextView, this.dza);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.gGt || !WriteActivity.this.gGu) {
                    if (WriteActivity.this.gGt) {
                        if (this.dza != WriteActivity.this.gGk || this.mTextView != WriteActivity.this.gGq) {
                            this.dza = WriteActivity.this.gGk;
                            this.mTextView = WriteActivity.this.gGq;
                        }
                    }
                } else if (this.dza != WriteActivity.this.gGo || this.mTextView != WriteActivity.this.gGp) {
                    this.dza = WriteActivity.this.gGo;
                    this.mTextView = WriteActivity.this.gGp;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.gGt && this.gGu) {
            if (this.gGr != null) {
                this.gGo.removeTextChangedListener(this.gGr);
            }
            this.gGr = textWatcher;
        } else if (this.gGt) {
            if (this.gGs != null) {
                this.gGk.removeTextChangedListener(this.gGs);
            }
            this.gGs = textWatcher;
        }
        return textWatcher;
    }

    private long h(EditText editText) {
        if (editText == this.gGk) {
            return 233L;
        }
        if (editText != this.gGo) {
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
                    textView.setTextColor(ai.getColor(d.e.common_color_10159));
                } else {
                    textView.setTextColor(ai.getColor(d.e.cp_cont_d));
                }
            } else if (f < 0) {
                if (f < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ai.getColor(d.e.common_color_10159));
            } else {
                textView.setTextColor(ai.getColor(d.e.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long f(EditText editText) {
        return com.baidu.tieba.write.c.a.g(editText.getText().toString().trim());
    }

    protected void Sk() {
        this.bqn = (EditText) findViewById(d.h.post_content);
        this.bqn.setDrawingCacheEnabled(false);
        this.bqn.setOnClickListener(this.gGS);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString Y = TbFaceManager.Ew().Y(getPageContext().getPageActivity(), this.mData.getContent());
            this.bqn.setText(Y);
            this.bqn.setSelection(Y.length());
        } else if (this.mData.getType() == 2) {
            if (this.gFR) {
                if (this.gFS != null && this.gFS.length() > 0) {
                    this.bqn.setText(getPageContext().getPageActivity().getString(d.l.reply_sub_floor, new Object[]{this.gFS}));
                    this.bqn.setSelection(this.bqn.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.l.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.bqn.setText(format);
                this.bqn.setSelection(format.length());
            }
        }
        this.bqn.setOnFocusChangeListener(this.bqu);
        this.bqn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aCi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.bqn.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bqn.addTextChangedListener(this.gGU);
        nh(true);
        if (this.mData.isUserFeedback()) {
            this.bqn.setHint(d.l.write_input_content);
        } else {
            this.bqn.setHint(d.l.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nh(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.gGt) {
            bAh().setPadding(0, 0, 0, 0);
            bAh().setBackgroundDrawable(null);
            ai.k(bAh(), d.e.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.ecz) && this.gFU == null) {
                com.baidu.adp.lib.f.c.fU().a(this.ecz, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.27
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass27) aVar, str, i);
                        if (aVar != null && aVar.kX() != null && aVar.lb() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.kX(), aVar.kX().getNinePatchChunk(), aVar.lb(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bAh().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bAh(), true, WriteActivity.this.eQq);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAg() {
        int i = 5000;
        if (this.gFU != null) {
            i = 1000;
        }
        return bAh().getText() != null && bAh().getText().length() >= i;
    }

    private void fQ(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.gFE)) {
                this.gFE = "";
                bAh().requestFocus();
                if (bAh().getText() != null && bAh().getText().length() + str.length() > 5000) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAh().getSelectionStart();
                    editable = bAh().getText();
                }
            } else if ("from_title".equals(this.gFE)) {
                this.gFE = "";
                bAi().requestFocus();
                if (bAi().getText() != null && bAi().getText().length() + str.length() > 31) {
                    showToast(d.l.over_limit_tip);
                    return;
                } else {
                    i = bAi().getSelectionStart();
                    editable = bAi().getText();
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
    public void ni(boolean z) {
        if (!com.baidu.tbadk.plugins.a.a(getPageContext(), z, false)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD)));
        }
    }

    protected void b(com.baidu.tbadk.coreExtra.data.l lVar) {
        if (((ImageSpan[]) bAh().getText().getSpans(0, bAh().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.gFT == null) {
                this.gFT = Toast.makeText(getPageContext().getPageActivity(), d.l.too_many_face, 0);
            }
            this.gFT.show();
            return;
        }
        String name = lVar.getName();
        final EmotionGroupType yp = lVar.yp();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fU().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass29) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bAh().getSelectionStart(), aVar, yp);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bAh() != null && bAh().getText() != null) {
            Bitmap kX = aVar.kX();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kX);
            int width = kX.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kX.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bAh().getSelectionStart() - 1;
                if (bAh().getText().length() > 1 && selectionStart >= 0 && bAh().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bAh().getText().insert(bAh().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bAh().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bAh().getText().insert(bAh().getSelectionStart(), spannableString2);
            }
            Editable text = bAh().getText();
            if (text != null) {
                this.gGO.clear();
                this.gGO.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gGO);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bAh().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bAh().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bAh().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAh() {
        return this.gGt ? this.gGk : this.bqn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bAi() {
        return this.gGt ? this.gGo : this.fQT;
    }

    protected void bAj() {
        Editable text;
        if (bAh() != null && (text = bAh().getText()) != null) {
            int selectionStart = bAh().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bAh().onKeyDown(67, this.gFO);
            }
            bAh().onKeyDown(67, this.gFO);
            int selectionStart2 = bAh().getSelectionStart();
            if (text != null) {
                this.gGO.clear();
                this.gGO.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.gGO);
                bAh().setSelection(selectionStart2);
            }
        }
    }

    private void j(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.l.feedback_bar_name).equals(str)) {
            this.gFG = true;
        }
    }

    private void bAk() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bAl() {
        try {
            if (this.gFQ != null) {
                this.gFQ.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aMk.c(null);
        this.aMk.dc(d.l.sending);
        this.aMk.aH(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aMk.aH(false);
    }

    private Boolean bAm() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aDZ = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmd() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bAi() != null) {
                str = bAi().getText().toString();
            }
            if (bAh() != null) {
                str2 = bAh().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.fQC == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            dg(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dg(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    dg(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.gGt) {
                    dg(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    dg(true);
                }
            }
            if (this.mData.getType() == 4) {
                dg(j(this.gGk) && i(this.gGo));
            } else if (this.mData.getType() == 5) {
                dg(j(this.gGk));
            } else if (!TextUtils.isEmpty(str2) || this.aDR != null) {
                dg(true);
            } else if (this.mData.getVideoInfo() != null) {
                dg(true);
            } else if (!StringUtils.isNull(this.mData.getGraffitiFileName())) {
                dg(true);
            } else {
                dg(false);
            }
        }
    }

    private void dg(boolean z) {
        if (z) {
            ai.b(this.mPost, d.e.cp_link_tip_a, d.e.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        ai.c(this.mPost, d.e.cp_cont_d, 1);
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
        this.aDU = new NewWriteModel(this);
        this.aDU.b(this.aEl);
        registerListener(this.gGQ);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.blV();
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
            this.gFG = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.gFI = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gFR = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gFS = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.aDS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.gFU = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gFU != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.mPostTopicData = (PostTopicData) bundle.getSerializable("hot_topic");
            this.gFZ = bundle.getInt("mem_type", 0);
            this.ajt = bundle.getString("from");
            this.forumLevel = bundle.getInt(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.mData.setTitle(bundle.getString(WriteActivityConfig.TITLE));
            this.mData.setContent(bundle.getString(WriteActivityConfig.CONTENT));
            this.mList = (List) bundle.getSerializable(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gGL = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gCj = bundle.getString(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = null;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.mData.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.mData.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.gFG = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.gFI = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.gFR = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.gFS = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra(WriteActivityConfig.KEY_WRITE_LEVEL, -1);
            this.gFU = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.mData.setIsAddition(this.gFU != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.gFZ = intent.getIntExtra("mem_type", 0);
            this.ajt = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra(WriteActivityConfig.TITLE));
            this.mData.setContent(intent.getStringExtra(WriteActivityConfig.CONTENT));
            this.mList = (List) intent.getSerializableExtra(WriteActivityConfig.HOT_TOPIC_POST_FORUM);
            this.gGL = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gCj = intent.getStringExtra(WriteActivityConfig.KEY_CALL_FROM);
            stringExtra = intent.getStringExtra(WriteActivityConfig.KEY_WRITE_IMAGES_INFO_STRING);
        }
        this.mData.setIsUserFeedback(this.gFG);
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
        this.ecz = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.gFH = true;
        }
        bzZ();
        try {
            this.gGv = bAu();
        } catch (Throwable th) {
            this.gGv = null;
        }
    }

    private void bAn() {
        if (u.u(this.mList) > 0 && this.mList.get(0) != null) {
            this.gDG.setVisibility(8);
            this.gGH.setVisibility(0);
            this.gGI.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.fQT.setText(com.baidu.tbadk.plugins.a.gD(ti(this.mList.get(0).mTopicName)));
                this.fQT.setMovementMethod(com.baidu.tieba.view.b.bwE());
            }
            this.gGJ.setText(this.mList.get(0).mForumName);
            this.fQT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!WriteActivity.this.gGM.equals(charSequence.toString())) {
                        WriteActivity.this.gGN = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gD;
                    if (!WriteActivity.this.gGM.equals(editable.toString()) && (gD = com.baidu.tbadk.plugins.a.gD(editable.toString())) != null) {
                        WriteActivity.this.gGM = gD.toString();
                        WriteActivity.this.fQT.setText(gD);
                        if (WriteActivity.this.gGN <= WriteActivity.this.fQT.getText().length()) {
                            WriteActivity.this.fQT.setSelection(WriteActivity.this.gGN);
                        }
                    }
                }
            });
            this.gGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
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
            SpannableString gD = com.baidu.tbadk.plugins.a.gD(ti(hotTopicBussinessData.mTopicName));
            if (gD != null) {
                this.fQT.setText(gD);
            }
            this.gGJ.setText(hotTopicBussinessData.mForumName);
        }
    }

    private String ti(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("#").append(str).append("#");
        return sb.toString();
    }

    @Override // com.baidu.tieba.tbadkCore.r.a
    public void a(WriteData writeData) {
        String ti;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (!j.isEmpty(writeData.getTitle())) {
                    this.evg.setVisibility(0);
                    this.evg.requestFocus();
                    this.aCi.b(new com.baidu.tbadk.editortools.a(21, 15, null));
                }
                if (j.isEmpty(bAi().getText().toString()) || this.gGD || ((this.gFG || this.gFH) && !j.isEmpty(writeData.getTitle()))) {
                    this.mData.setTitle(writeData.getTitle());
                    if (!u.v(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) u.c(this.mList, 0);
                        String str = hotTopicBussinessData != null ? hotTopicBussinessData.mTopicName : null;
                        if (StringUtils.isNull(str)) {
                            ti = this.mData.getTitle();
                        } else {
                            ti = ti(str);
                        }
                        SpannableString gD = com.baidu.tbadk.plugins.a.gD(ti);
                        if (gD != null) {
                            bAi().setText(gD);
                            bAi().setSelection(gD.length() > ti.length() ? ti.length() : gD.length());
                        }
                    } else {
                        SpannableString gD2 = com.baidu.tbadk.plugins.a.gD(this.mData.getTitle());
                        if (gD2 != null) {
                            bAi().setText(gD2);
                            bAi().setSelection(this.mData.getTitle().length() > gD2.length() ? gD2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bzY();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aCi.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((j.isEmpty(bAh().getText().toString()) || this.gFG || this.gFH) && !j.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.Ew().a(getPageContext().getPageActivity(), this.mData.getContent(), this.gGR);
                    bAh().setText(a2);
                    bAh().setSelection(a2.length());
                    if (this.gGt) {
                        b(this.gGq, this.gGk);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bAt();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        DN();
                    }
                    nj(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bAo();
                }
                bmd();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.gGa != null) {
                    this.gGe = this.gGb.clK;
                    this.gGd = this.gGb.name;
                    int i = 0;
                    while (true) {
                        if (i == this.gGa.size()) {
                            break;
                        }
                        x xVar = this.gGa.get(i);
                        if (categoryTo != xVar.clK) {
                            i++;
                        } else {
                            this.gGe = categoryTo;
                            this.gGd = xVar.name;
                            this.mData.setCategoryTo(this.gGe);
                            break;
                        }
                    }
                    if (this.gGf != null) {
                        this.gGf.setText(this.gGd);
                        this.gGf.b(this.gGa, this.gGb, this.gGe);
                    }
                }
                this.mData.setGraffitiFileName(writeData.getGraffitiFileName());
                this.aCi.b(new com.baidu.tbadk.editortools.a(42, 24, this.mData.getGraffitiFileName()));
                this.aCi.Bu();
                return;
            }
            return;
        }
        bAo();
        bzY();
    }

    private void bAo() {
        if ((!this.gGt || this.gGi != null) && this.gGh != null) {
            this.gGi.c(this.writeImagesInfo);
            aGr();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.gFR);
        if (this.gFG) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aDS);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.gFU);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putSerializable("hot_topic", this.mPostTopicData);
        bundle.putInt("mem_type", this.gFZ);
        bundle.putString("from", this.ajt);
        bundle.putString(WriteActivityConfig.KEY_CALL_FROM, this.gCj);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bAh().getEditableText().toString();
        if (obj != null) {
            bAh().setText(TbFaceManager.Ew().a(getPageContext().getPageActivity(), obj, this.gGR));
            bAh().setSelection(bAh().getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bAp() {
        return (bAh() == null || bAh().getText() == null) ? "" : bAh().getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getThreadTitle() {
        if (this.mData == null || bAi() == null || bAi().getText() == null) {
            return "";
        }
        String obj = bAi().getText().toString();
        if (this.mPrefixData != null && u.u(this.mPrefixData.getPrefixs()) > 0 && this.fQC != 0 && this.mData.getType() != 4 && this.fQW != null && this.fQW.getText() != null) {
            obj = this.fQW.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzp() {
        blV();
        this.mData.setContent(bAp());
        this.mData.setTitle(getThreadTitle());
        if (this.gFG || this.gFH) {
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
                if (com.baidu.adp.lib.util.i.hr()) {
                    sb.append(com.baidu.adp.lib.util.i.hz());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.gGc >= 0) {
            this.mData.setCategoryFrom(this.gGc);
        }
        if (this.gGe >= 0) {
            this.mData.setCategoryTo(this.gGe);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aDT != null && this.aDT.Tm());
        this.aDU.mC(this.writeImagesInfo.size() > 0);
        if (!u.v(this.mList) && this.gGG != null && this.gGG.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.gGG.mForumId));
            this.mData.setForumName(this.gGG.mForumName);
        }
        this.aDU.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.aDR != null) {
            if (this.aDR.getId() != null) {
                this.aDU.getWriteData().setVoice(this.aDR.getId());
                this.aDU.getWriteData().setVoiceDuringTime(this.aDR.duration);
            } else {
                this.aDU.getWriteData().setVoice(null);
                this.aDU.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aDU.getWriteData().setVoice(null);
            this.aDU.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aDU.btE()) {
            showToast(d.l.write_img_limit);
        } else if (!com.baidu.adp.lib.util.i.hr()) {
            showToast(d.l.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.l.sending), this.mDialogCancelListener);
            this.aDU.startPostWrite();
        }
    }

    private void p(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.gFU != null) {
                i2 = this.gFU.getTotalCount();
                i = this.gFU.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.l.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        k.showToast(getPageContext().getPageActivity(), sb.toString());
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
                if (this.aCi != null && !this.aCi.Dd()) {
                    bAh().requestFocus();
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
                            bAh().getText().insert(bAh().getSelectionStart(), sb.toString());
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
                c(postWriteCallBackData);
                setResult(-1, intent);
                finish();
            } else if (i != 12010 && i != 12009) {
                if (i == 12002) {
                    if (intent != null) {
                        int intExtra = intent.getIntExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 0);
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            if (intExtra == 1) {
                                bce();
                            } else {
                                af(intent);
                            }
                        } else if (intExtra == 1) {
                            X(intent);
                        } else {
                            ae(intent);
                            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    k.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                    }
                } else if (i == 12012) {
                    if (!this.gGt) {
                        B(intent);
                        bmd();
                        return;
                    }
                    ah(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aCi.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aCi.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aCi.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bmd();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25001) {
                    com.baidu.tieba.graffiti.b.N(intent);
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.gFF) {
                                sb2.append(HotSelectActivityConfig.HOT_TOPIC_SING);
                                this.gFF = false;
                            }
                            sb2.append(stringExtra);
                            fQ(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !u.v(this.mList)) {
                    if (!u.v(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                        this.gGG = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                        a(this.gGG);
                    }
                } else if (i == 25018) {
                    if (intent != null) {
                        this.gGE.ac(intent);
                        com.baidu.tieba.write.a.c cVar = new com.baidu.tieba.write.a.c();
                        cVar.context = getPageContext();
                        cVar.bqt = this.gGE.bxy();
                        this.aCi.b(new com.baidu.tbadk.editortools.a(50, 15, cVar));
                    }
                    if (this.gGF) {
                        bAq();
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.aCi != null && !this.aCi.Dd()) {
                this.bqn.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case 12001:
                    DI();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bAs();
                    return;
                case 12006:
                case 12009:
                default:
                    return;
                case 12010:
                    this.aDS = String.valueOf(System.currentTimeMillis());
                    ah.b(getPageContext(), this.aDS);
                    return;
                case 12012:
                    bAs();
                    return;
                case 25004:
                    if ("from_title".equals(this.gFE)) {
                        bAi().requestFocus();
                        return;
                    } else if ("from_content".equals(this.gFE)) {
                        bAh().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAq() {
        this.mData.setCanNoForum(true);
        this.mData.setTransmitForumData(this.gGE.bxx());
        this.mData.setCallFrom(this.gCj);
        this.mData.setRecommendExt(this.gGE.getRecommendExt());
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bzp();
    }

    private void bAr() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bAs() {
        if (this.gGt) {
            this.gGi.c(this.writeImagesInfo);
            aGr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        this.gGi.notifyDataSetChanged();
        this.gGh.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.gGi.notifyDataSetChanged();
                WriteActivity.this.gGh.invalidateViews();
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
        bmd();
    }

    private void ae(Intent intent) {
        if (this.gGt) {
            ah(intent);
            bAs();
        } else {
            ai(intent);
        }
        bmd();
    }

    private void ah(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bAs();
            nj(true);
        }
    }

    private void af(Intent intent) {
        if (this.writeImagesInfo != null) {
            A(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size)));
            }
        }
    }

    private void bce() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void X(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.fsK.parseJson(stringExtra);
            this.fsK.updateQuality();
            if (this.fsK.getChosedFiles() != null && this.fsK.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.fsK.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.fsK.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bAi());
        HidenSoftKeyPad(this.mInputManager, bAh());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void A(Intent intent) {
        this.aDS = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aDS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, k.dip2px(getPageContext().getPageActivity(), k.ag(getPageContext().getPageActivity())), k.dip2px(getPageContext().getPageActivity(), k.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aDS, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bAt();
            DN();
        }
        nj(true);
    }

    private void B(Intent intent) {
        c(intent, false);
    }

    private void c(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                bAt();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    DN();
                }
            }
            nj(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAt() {
        if (this.aCi.eE(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void DI() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.s(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aDS));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nj(boolean z) {
        this.writeImagesInfo.getChosedFiles();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.ciW == null) {
            this.ciW = VoiceManager.instance();
        }
        return this.ciW;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afo() {
        this.ciW = getVoiceManager();
        this.ciW.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tn(postWriteCallBackData.getErrorCode())) {
                AntiHelper.ar(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.l.error_write);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.gFU == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.c(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                p(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aEc = i;
        if (this.aCi != null) {
            this.aCi.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
            if (z) {
                this.aCi.b(new com.baidu.tbadk.editortools.a(2, 7, " "));
            }
        }
    }

    private void DN() {
        if (!this.gGt) {
            if (this.aCi != null) {
                this.aCi.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aCi.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            if (this.gGg != null) {
                this.gGg.b(new com.baidu.tbadk.editortools.a(46, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.gGg.b(new com.baidu.tbadk.editortools.a(46, 28, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (this.aCi != null) {
            this.aCi.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void uy(int i) {
        if (i < this.gEH.size()) {
            for (int i2 = 0; i2 < this.gEH.size(); i2++) {
                this.gEH.get(i2).mZ(false);
            }
            this.gEH.get(i).mZ(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sz(int i) {
        this.fQC = i;
        this.fQX.ub(i);
        uy(i);
        this.fQW.setText(this.mPrefixData.getPrefixs().get(i));
        bmd();
        g.a(this.fQX, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.fQZ.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            k.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
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

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            DD();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = aa.a(strArr, iArr);
            if (aa.aE(getApplicationContext())) {
                ah.b(getPageContext(), this.aDS);
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
        if (this.gGB && System.currentTimeMillis() - this.gGC < 800) {
            k.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.gGB = false;
        }
        if (this.gGP != null && !z) {
            this.gGP.byB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(String str) {
        if (!j.isEmpty(str) && this.gGy != null) {
            tk(str);
            this.gGy.dismiss();
        }
    }

    private void bQ(Context context) {
        gGA = k.ah(context);
    }

    private void tk(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.l.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.gGB = true;
        bAt();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            DN();
        }
        nj(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3941=4] */
    private static Bitmap c(String str, float f) {
        Bitmap bitmap;
        Throwable th;
        Bitmap bitmap2 = null;
        int i = (int) f;
        if (!j.isEmpty(str) && i > 0) {
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

    private File bAu() {
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
                if ((currentTimeMillis - file.lastModified()) / TbConfig.USE_TIME_INTERVAL > 1) {
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

    private void bAv() {
        if (this.gGv != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            bQ(getActivity());
            this.gGx = getPageContext().getPageActivity().getLayoutInflater().inflate(d.j.rec_dialog, (ViewGroup) null);
            this.gGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.gGv != null) {
                        WriteActivity.this.tj(WriteActivity.this.gGv.getAbsolutePath());
                    }
                }
            });
            this.gGw = (TbImageView) this.gGx.findViewById(d.h.rec_img_view);
            this.gGz = (LinearLayout) this.gGx.findViewById(d.h.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.gGv.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.gGv.getAbsolutePath());
                Bitmap c = c(this.gGv.getAbsolutePath(), getResources().getDimensionPixelSize(d.f.ds160));
                if (c != null) {
                    this.gGw.setImageBitmap(c);
                    this.gGw.setDrawBorder(true);
                    this.gGw.setBorderWidth(2);
                    this.gGw.setBorderColor(ai.getColor(d.e.common_color_10264));
                    this.gGy = new Dialog(getActivity(), d.m.bubble_dialog);
                    this.gGy.setCanceledOnTouchOutside(true);
                    this.gGy.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.gGB) {
                                k.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.gGC = System.currentTimeMillis();
                            }
                        }
                    });
                    this.gGy.setContentView(this.gGx);
                    this.gGy.show();
                    Window window = this.gGy.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.f.ds28);
                    attributes.y = (gGA / 18) + getResources().getDimensionPixelSize(d.f.ds12);
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
            this.gFF = false;
            this.gFE = "";
            if ("from_content".equals(str)) {
                this.gFE = "from_content";
            } else if ("from_title".equals(str)) {
                this.gFE = "from_title";
            }
            if (HotSelectActivityConfig.HOT_TOPIC_SING.equals(String.valueOf(charSequence.charAt(i)))) {
                ni(false);
            }
        }
    }

    public void Bw() {
        if (this.gFG || !u.v(this.mList)) {
            this.evg.setVisibility(0);
            this.evg.requestFocus();
            this.aCi.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.evg.setVisibility(8);
    }
}
