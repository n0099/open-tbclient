package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.c.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.e;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0023a, e.a {
    private com.baidu.tbadk.editortools.i aBZ;
    private LocationModel aDD;
    private NewWriteModel aDE;
    private OriginalThreadCardView eGV;
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
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hkJ = "";
    private boolean hkK = false;
    private WriteData mData = null;
    private boolean hkL = false;
    private InputMethodManager mInputManager = null;
    private EditText gkL = null;
    private View gkM = null;
    private LinearLayout bHs = null;
    private EditText bHr = null;
    private FeedBackModel hkO = null;
    private ArrayList<com.baidu.tieba.write.d> hjH = new ArrayList<>();
    private final KeyEvent cvm = new KeyEvent(0, 67);
    private View aqB = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aDI = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aDJ = 0;
    private View mRootView = null;
    private ScrollView hlc = null;
    private boolean hld = false;
    private com.baidu.tbadk.core.view.b aMB = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String gRk = "2";
    private String hlj = "";
    private int hlk = 0;
    private SpannableStringBuilder hll = new SpannableStringBuilder();
    private TbFaceManager.a hlo = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a cHZ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahJ));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahJ));
        }
    };
    private final NewWriteModel.d aDS = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hiz.aC(null);
                TransmitPostEditActivity.this.hiz.nT(false);
                TransmitPostEditActivity.this.hln.aC(null);
                TransmitPostEditActivity.this.hln.nT(false);
                if (z) {
                    TransmitPostEditActivity.this.bG(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    if (TransmitPostEditActivity.this.mData.getType() == 4) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
                    }
                    TransmitPostEditActivity.this.j(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hiz.aC(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hln.aC(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hiz.uB(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hln.uB(postWriteCallBackData.getErrorString());
                    if (!v.w(TransmitPostEditActivity.this.hiz.bFE())) {
                        TransmitPostEditActivity.this.ob(true);
                        TransmitPostEditActivity.this.oh(true);
                    }
                } else if ((sVar == null || writeData == null || sVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (sVar != null && writeData != null && sVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.yk());
                    if (com.baidu.tbadk.p.a.hc(sVar.yj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.yj())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aDQ = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void DT() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void ga(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.a(0, true, (String) null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bxz())) {
                TransmitPostEditActivity.this.a(2, true, aVar.bxz());
            } else {
                ga(null);
            }
        }
    };
    private final CustomMessageListener gEb = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aDD.ng(false);
                    TransmitPostEditActivity.this.aDD.ci(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aDD.ng(true);
                TransmitPostEditActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener hlp = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hlq = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIg = TransmitPostEditActivity.this.bIg();
            if (bIg >= 0 && bIg < TransmitPostEditActivity.this.bHr.getText().length()) {
                TransmitPostEditActivity.this.bHr.setSelection(bIg);
            }
        }
    };
    private boolean hlr = true;
    private final View.OnFocusChangeListener bHy = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gkL || view == TransmitPostEditActivity.this.aqB || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hlr = true;
                    TransmitPostEditActivity.this.bIh();
                    if (TransmitPostEditActivity.this.aBZ != null) {
                        TransmitPostEditActivity.this.aBZ.Bn();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gkL);
                } else if (view == TransmitPostEditActivity.this.gkL) {
                    TransmitPostEditActivity.this.gkO.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.bHr && z) {
                TransmitPostEditActivity.this.hlr = false;
                TransmitPostEditActivity.this.bIh();
                TransmitPostEditActivity.this.aBZ.Bn();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.bHr);
            }
            TransmitPostEditActivity.this.bIk();
        }
    };
    private TextWatcher bHA = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bqs();
            if (TransmitPostEditActivity.this.hln != null) {
                if (!TransmitPostEditActivity.this.hln.bFH()) {
                    TransmitPostEditActivity.this.oh(false);
                }
                TransmitPostEditActivity.this.hln.nU(false);
                TransmitPostEditActivity.this.bIl();
            }
        }
    };
    private TextWatcher hls = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bqs();
            if (TransmitPostEditActivity.this.hiz != null) {
                if (!TransmitPostEditActivity.this.hiz.bFH()) {
                    TransmitPostEditActivity.this.ob(false);
                }
                TransmitPostEditActivity.this.hiz.nU(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
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
        aVar.cd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.hh()) {
                    TransmitPostEditActivity.this.a(1, true, (String) null);
                    TransmitPostEditActivity.this.aDD.YN();
                } else {
                    TransmitPostEditActivity.this.aDQ.DT();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.a(0, true, (String) null);
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
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hld) {
            this.gkL.setVisibility(8);
            bqs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
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
        this.hln = new com.baidu.tieba.write.b();
        this.hln.vM(d.C0096d.cp_cont_i);
        this.hln.vN(d.C0096d.cp_cont_h_alpha85);
        this.hiz = new com.baidu.tieba.write.b();
        this.hiz.vM(d.C0096d.cp_cont_i);
        this.hiz.vN(d.C0096d.cp_cont_h_alpha85);
        initUI();
        this.aDD = new LocationModel(this);
        this.aDD.a(this.aDQ);
        registerListener(this.gEb);
        registerListener(this.hlp);
        initEditor();
        this.bHr.requestFocus();
        Bp();
        bIC();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aBZ = new com.baidu.tbadk.editortools.i(getActivity());
        this.aBZ.setBarMaxLauCount(4);
        this.aBZ.setMoreButtonAtEnd(true);
        this.aBZ.setBarLauncherType(1);
        this.aBZ.by(true);
        this.aBZ.bz(true);
        this.aBZ.setMoreLauncherIcon(d.f.write_more);
        this.aBZ.setBackgroundColorId(d.C0096d.cp_bg_line_d);
        bIi();
        this.aBZ.Df();
        if (this.hkM != null) {
            this.hkM.addView(this.aBZ);
        }
        bIj();
        this.aBZ.lE();
        com.baidu.tbadk.editortools.l eN = this.aBZ.eN(6);
        if (eN != null && !TextUtils.isEmpty(this.aDI)) {
            ((View) eN).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aDI);
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
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    private void bIi() {
        r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aCG = d.f.write_at;
        this.aBZ.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aBZ.b(aVar2);
        aVar2.aCG = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, getActivity()), r.class);
        if (runTask != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aCI = 4;
            rVar.aCG = d.f.icon_post_location_selector;
            this.aBZ.b(rVar);
        }
        if (this.hkR == null) {
            if (this.hlm == null) {
                this.hlm = new com.baidu.tieba.write.editor.d(getActivity(), this.gRk);
                this.hlm.bGI();
                this.hlm.setFrom("from_share_write");
                this.hlm.aL(this.mData.getForumId(), this.mPrivateThread);
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
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.4
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                int i;
                if (aVar != null) {
                    if (aVar.code == 31 && (aVar.data instanceof Integer)) {
                        int intValue = ((Integer) aVar.data).intValue();
                        if (intValue == 5) {
                            i = 4;
                        } else if (intValue == 9) {
                            i = 3;
                        } else if (intValue == 26) {
                            i = 1;
                        } else {
                            i = intValue == 7 ? 2 : 0;
                        }
                        if (i > 0) {
                            TiebaStatic.log(new ak("c12608").r("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bIu()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bIu()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bIx();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bqs();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hkR == null) {
                            TransmitPostEditActivity.this.DH();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aDJ) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aH(pageActivity)) {
                                    TransmitPostEditActivity.this.DF();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.DE();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aDD != null) {
                            TransmitPostEditActivity.this.aDD.ng(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aBZ.Dh()) {
                                        TransmitPostEditActivity.this.aBZ.Bn();
                                        TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.j.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(d.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.j.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(d.j.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bqs();
                        if (TransmitPostEditActivity.this.bHr != null) {
                            TransmitPostEditActivity.this.bHr.requestFocus();
                        }
                        TransmitPostEditActivity.this.aBZ.Bn();
                        TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHr);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hkK = true;
                        TransmitPostEditActivity.this.oi(true);
                        if (TransmitPostEditActivity.this.bIw().isFocused()) {
                            TransmitPostEditActivity.this.hkJ = "from_title";
                        } else if (TransmitPostEditActivity.this.bIv().isFocused()) {
                            TransmitPostEditActivity.this.hkJ = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hkN.setVisibility(0);
                        TransmitPostEditActivity.this.hkN.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hkN.hasFocus()) {
                            TransmitPostEditActivity.this.bHr.requestFocus();
                            TransmitPostEditActivity.this.bHr.setSelection(TransmitPostEditActivity.this.bHr.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hkN.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aBZ.a(31, bVar);
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
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHB() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bIw().getText().toString());
        this.mData.setContent(bIv().getText().toString());
        finish();
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
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.c(this.mPost, d.C0096d.cp_link_tip_a, 1);
        bIh();
        aj.k(this.gkM, d.C0096d.cp_bg_line_c);
        aj.k(bIw(), d.C0096d.cp_bg_line_d);
        aj.k(bIv(), d.C0096d.cp_bg_line_d);
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
        this.eGV.onChangeSkinType();
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
        if (this.gkL != null) {
            if (this.gkL.getText().toString().length() == 0) {
                this.gkL.getPaint().setFakeBoldText(false);
            } else if (this.gkL.getText().toString().length() > 0) {
                this.gkL.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
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
        bIn();
        this.hlc = (ScrollView) findViewById(d.g.write_scrollview);
        this.hlc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.bHr != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.bHr);
                    }
                    if (TransmitPostEditActivity.this.aBZ != null) {
                        TransmitPostEditActivity.this.aBZ.Bn();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
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
        }
        XH();
        bIt();
        this.bHs = (LinearLayout) findViewById(d.g.post_content_container);
        this.bHs.setDrawingCacheEnabled(false);
        this.bHs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bHr.requestFocus();
                TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.aqB.setOnFocusChangeListener(this.bHy);
        this.aqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bqk();
                TransmitPostEditActivity.this.bHB();
            }
        });
        bIq();
        bIs();
        bIm();
        bIh();
        bIr();
        bqq();
        bIy();
        if (this.mData.getType() == 4 && this.gkR != null && this.hkP != null) {
            this.gkR.setVisibility(8);
            this.hkP.setVisibility(8);
        }
        bqs();
        ShowSoftKeyPad(this.mInputManager, this.gkL);
    }

    private void bIm() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.gRk != null && this.gRk.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.gRk != null && this.gRk.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.j.share_to) + this.mData.getForumName(), 9, true, false);
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
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.bHr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.bHr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gkL.setVisibility(8);
                    return;
            }
        }
    }

    private void bIn() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.bHy);
    }

    private void bIo() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hkL && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIw() != null) {
                bIw().setText(d);
                bIw().setSelection(d.length());
            }
        }
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
            this.hlb.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, au auVar) {
                    if (auVar != null) {
                        TransmitPostEditActivity.this.hlb.setText(auVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(auVar.cKd);
                        TransmitPostEditActivity.this.hla = auVar.cKd;
                        TransmitPostEditActivity.this.hlb.bHt();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hlb.bHs();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIw());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIv());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hlt = new com.baidu.tieba.view.c(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
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
            this.gkR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gkO.setVisibility(0);
                    TransmitPostEditActivity.this.gkR.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gkP, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aBZ.Bn();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gkL);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHr);
                }
            });
            this.gkQ = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gkQ.setVisibility(0);
                this.gkO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gkO.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gkP, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aBZ.Bn();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIw());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIv());
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

    protected void bIs() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.hh()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hln.bFG()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hln.bFI());
                        TransmitPostEditActivity.this.oh(true);
                    } else if (TransmitPostEditActivity.this.hiz.bFG()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hiz.bFI());
                        TransmitPostEditActivity.this.ob(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIw());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIv());
                        TransmitPostEditActivity.this.aBZ.Bn();
                        TiebaStatic.log(new ak("c12608").r("obj_locate", 7));
                        TransmitPostEditActivity.this.bIA();
                    }
                }
            }
        });
    }

    protected void bqr() {
        this.gkL = (EditText) findViewById(d.g.post_title);
        this.gkL.setOnClickListener(this.hlq);
        this.gkL.setOnFocusChangeListener(this.bHy);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gkL.setText(this.mData.getTitle());
            this.gkL.setSelection(this.mData.getTitle().length());
        }
        this.gkL.addTextChangedListener(this.bHA);
        if (!this.mData.getHaveDraft()) {
            bIo();
        }
        this.gkL.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void XH() {
        this.bHr = (EditText) findViewById(d.g.post_content);
        this.bHr.setDrawingCacheEnabled(false);
        this.bHr.setOnClickListener(this.hlq);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString T = TbFaceManager.Ez().T(getPageContext().getPageActivity(), this.mData.getContent());
            this.bHr.setText(T);
            this.bHr.setSelection(T.length());
        }
        this.bHr.setOnFocusChangeListener(this.bHy);
        this.bHr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aBZ.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.bHr.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.bHr.addTextChangedListener(this.hls);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.bHr.setHint(d.j.share_video_default);
        } else {
            this.bHr.setHint(d.j.share_txt_default);
        }
    }

    private void bIt() {
        this.eGV = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.eGV.setVisibility(0);
        this.eGV.b(this.mOriginalThreadInfo);
        this.eGV.setEnabled(false);
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
            com.baidu.adp.lib.f.c.fJ().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bIv().getSelectionStart(), aVar, yb);
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
        return this.bHr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIw() {
        return this.gkL;
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
            this.hll.clear();
            this.hll.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hll);
            bIv().setSelection(selectionStart2);
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
                        } else {
                            this.mData.setIsNoTitle(false);
                            dy(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        dy(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
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
            if (!TextUtils.isEmpty(str2)) {
                dy(true);
            } else if (this.mData.getVideoInfo() != null) {
                dy(true);
            } else {
                dy(false);
            }
        }
    }

    private void dy(boolean z) {
        aj.b(this.mPost, d.C0096d.cp_link_tip_a, d.C0096d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aDE = new NewWriteModel(this);
        this.aDE.b(this.aDS);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bqk();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
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
            this.mFrom = bundle.getString("from");
            this.mPrivateThread = bundle.getInt("private_thread");
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.gRk = bundle.getString("KEY_CALL_FROM");
            String string5 = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            if (!StringUtils.isNull(string5)) {
                this.mOriginalThreadInfo = (OriginalThreadInfo) OrmObject.objectWithJsonStr(string5, OriginalThreadInfo.class);
            }
            str = string;
        } else {
            Intent intent = getIntent();
            this.mData.setType(intent.getIntExtra("type", 0));
            this.mData.setForumId(intent.getStringExtra("forum_id"));
            this.mData.setForumName(intent.getStringExtra("forum_name"));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.hkR = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hkR != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gRk = intent.getStringExtra("KEY_CALL_FROM");
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mOriginalThreadInfo = (OriginalThreadInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
            str = stringExtra;
        }
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 10);
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.j.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hkL = true;
        }
        bIp();
    }

    private void bIy() {
        if (v.v(this.mList) > 0 && this.mList.get(0) != null) {
            this.hlf.setVisibility(0);
            this.hlg.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gkL.setText(com.baidu.tbadk.plugins.a.gI(uW(this.mList.get(0).mTopicName)));
                this.gkL.setMovementMethod(com.baidu.tieba.view.d.bEK());
            }
            this.hlh.setText(this.mList.get(0).mForumName);
            this.gkL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hlj.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.hlk = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString gI;
                    if (!TransmitPostEditActivity.this.hlj.equals(editable.toString()) && (gI = com.baidu.tbadk.plugins.a.gI(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hlj = gI.toString();
                        TransmitPostEditActivity.this.gkL.setText(gI);
                        if (TransmitPostEditActivity.this.hlk <= TransmitPostEditActivity.this.gkL.getText().length()) {
                            TransmitPostEditActivity.this.gkL.setSelection(TransmitPostEditActivity.this.hlk);
                        }
                    }
                }
            });
            this.hli.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicChangeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 25005, TransmitPostEditActivity.this.mList)));
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

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.hkR != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hkR));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gRk);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
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
        if (bIv() == null || bIv().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bIv().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bIv().getText().toString();
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

    private void bHC() {
        bqk();
        this.mData.setContent(bIz());
        this.mData.setTitle(beA());
        if (this.hkY >= 0) {
            this.mData.setCategoryFrom(this.hkY);
        }
        if (this.hla >= 0) {
            this.mData.setCategoryTo(this.hla);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aDD != null && this.aDD.YJ());
        this.aDE.ni(this.writeImagesInfo.size() > 0);
        if (!v.w(this.mList) && this.hle != null && this.hle.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hle.mForumId));
            this.mData.setForumName(this.hle.mForumName);
        }
        this.aDE.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aDE.getWriteData().setVoice(null);
        this.aDE.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.hh()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.aDE.startPostWrite();
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

    @Override // android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.aBZ != null && !this.aBZ.Dh()) {
                    bIv().requestFocus();
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
                            bIv().getText().insert(bIv().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                j((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
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
        } else if (i2 == 0) {
            if (this.aBZ != null && !this.aBZ.Dh()) {
                this.bHr.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
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
                default:
                    return;
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
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.gRk);
        bHC();
    }

    private void bIB() {
        if (this.aBZ != null) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIw());
        HidenSoftKeyPad(this.mInputManager, bIv());
        super.onPause();
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
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
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
        if (!this.hld && this.aBZ != null) {
            this.aBZ.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aBZ.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
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
            l.a(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
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
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hlm != null && !z) {
            this.hlm.aWp();
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
        if (!v.w(this.mList)) {
            this.hkN.setVisibility(0);
            this.hkN.requestFocus();
            this.aBZ.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hkN.setVisibility(8);
    }
}
