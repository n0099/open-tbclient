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
import com.baidu.d.a.a;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.av;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0056a, e.a {
    private com.baidu.tbadk.editortools.i bsC;
    private LocationModel buh;
    private NewWriteModel bui;
    private OriginalThreadCardView fyP;
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
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hKt = "";
    private boolean hKu = false;
    private WriteData mData = null;
    private boolean hKv = false;
    private InputMethodManager mInputManager = null;
    private EditText gQH = null;
    private View gQI = null;
    private LinearLayout gQK = null;
    private EditText gQL = null;
    private FeedBackModel hKy = null;
    private ArrayList<com.baidu.tieba.write.d> hJp = new ArrayList<>();
    private final KeyEvent drB = new KeyEvent(0, 67);
    private View bgK = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String bum = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int bun = 0;
    private View mRootView = null;
    private ScrollView hKM = null;
    private boolean hKN = false;
    private com.baidu.tbadk.core.view.b bCM = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String hpD = "2";
    private String hKT = "";
    private int hKU = 0;
    private SpannableStringBuilder hKV = new SpannableStringBuilder();
    private TbFaceManager.a hKY = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a dFu = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXH));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXH));
        }
    };
    private final NewWriteModel.d buw = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hId.aw(null);
                TransmitPostEditActivity.this.hId.nA(false);
                TransmitPostEditActivity.this.hKX.aw(null);
                TransmitPostEditActivity.this.hKX.nA(false);
                if (z) {
                    TransmitPostEditActivity.this.cn(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    if (TransmitPostEditActivity.this.mData.getType() == 4) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity()).createNormalCfg(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), null, "from_write", 18003)));
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
                    TransmitPostEditActivity.this.hId.aw(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hKX.aw(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hId.un(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hKX.un(postWriteCallBackData.getErrorString());
                    if (!v.E(TransmitPostEditActivity.this.hId.bFC())) {
                        TransmitPostEditActivity.this.nJ(true);
                        TransmitPostEditActivity.this.nP(true);
                    }
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FY());
                    if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX())));
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a buu = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void LR() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gA(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bxw())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bxw());
            } else {
                gA(null);
            }
        }
    };
    private final CustomMessageListener hdd = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.buh.mM(false);
                    TransmitPostEditActivity.this.buh.cg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.buh.mM(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hKZ = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hLa = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIk = TransmitPostEditActivity.this.bIk();
            if (bIk >= 0 && bIk < TransmitPostEditActivity.this.gQL.getText().length()) {
                TransmitPostEditActivity.this.gQL.setSelection(bIk);
            }
        }
    };
    private boolean hLb = true;
    private final View.OnFocusChangeListener gQF = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gQH || view == TransmitPostEditActivity.this.bgK || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hLb = true;
                    TransmitPostEditActivity.this.bIl();
                    if (TransmitPostEditActivity.this.bsC != null) {
                        TransmitPostEditActivity.this.bsC.Jm();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gQH);
                } else if (view == TransmitPostEditActivity.this.gQH) {
                    TransmitPostEditActivity.this.gQM.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gQL && z) {
                TransmitPostEditActivity.this.hLb = false;
                TransmitPostEditActivity.this.bIl();
                TransmitPostEditActivity.this.bsC.Jm();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gQL);
            }
            TransmitPostEditActivity.this.bIo();
        }
    };
    private TextWatcher hLc = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsJ();
            if (TransmitPostEditActivity.this.hKX != null) {
                if (!TransmitPostEditActivity.this.hKX.bFF()) {
                    TransmitPostEditActivity.this.nP(false);
                }
                TransmitPostEditActivity.this.hKX.nB(false);
                TransmitPostEditActivity.this.bIp();
            }
        }
    };
    private TextWatcher hLd = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bsJ();
            if (TransmitPostEditActivity.this.hId != null) {
                if (!TransmitPostEditActivity.this.hId.bFF()) {
                    TransmitPostEditActivity.this.nJ(false);
                }
                TransmitPostEditActivity.this.hId.nB(false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
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
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.buh.ahm();
                } else {
                    TransmitPostEditActivity.this.buu.LR();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
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
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hKN) {
            this.gQH.setVisibility(8);
            bsJ();
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
        this.hKX = new com.baidu.tieba.write.b();
        this.hKX.xf(d.C0140d.cp_cont_i);
        this.hKX.xg(d.C0140d.cp_cont_h_alpha85);
        this.hId = new com.baidu.tieba.write.b();
        this.hId.xf(d.C0140d.cp_cont_i);
        this.hId.xg(d.C0140d.cp_cont_h_alpha85);
        initUI();
        this.buh = new LocationModel(this);
        this.buh.a(this.buu);
        registerListener(this.hdd);
        registerListener(this.hKZ);
        initEditor();
        this.gQL.requestFocus();
        Jo();
        bIH();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.bsC = new com.baidu.tbadk.editortools.i(getActivity());
        this.bsC.setBarMaxLauCount(4);
        this.bsC.setMoreButtonAtEnd(true);
        this.bsC.setBarLauncherType(1);
        this.bsC.cf(true);
        this.bsC.cg(true);
        this.bsC.setMoreLauncherIcon(d.f.write_more);
        this.bsC.setBackgroundColorId(d.C0140d.cp_bg_line_d);
        bIm();
        this.bsC.Ld();
        if (this.hKw != null) {
            this.hKw.addView(this.bsC);
        }
        bIn();
        this.bsC.th();
        com.baidu.tbadk.editortools.l hG = this.bsC.hG(6);
        if (hG != null && !TextUtils.isEmpty(this.bum)) {
            ((View) hG).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.bum);
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
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bIm() {
        r rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.btj = d.f.write_at;
        this.bsC.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.bsC.b(aVar2);
        aVar2.btj = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), r.class);
        if (runTask != null && (rVar = (r) runTask.getData()) != null) {
            rVar.btl = 4;
            rVar.btj = d.f.icon_post_location_selector;
            this.bsC.b(rVar);
        }
        if (this.hKB == null) {
            if (this.hKW == null) {
                this.hKW = new com.baidu.tieba.write.editor.d(getActivity(), this.hpD);
                this.hKW.bGL();
                this.hKW.setFrom("from_share_write");
                this.hKW.aO(this.mData.getForumId(), this.mPrivateThread);
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
                            TiebaStatic.log(new ak("c12608").s("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bIy()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bIy()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bIB();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bsJ();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hKB == null) {
                            TransmitPostEditActivity.this.LG();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.bun) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aS(pageActivity)) {
                                    TransmitPostEditActivity.this.LE();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.LD();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.buh != null) {
                            TransmitPostEditActivity.this.buh.mM(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        ak akVar = new ak("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        akVar.ab(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(akVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.bsC.Lf()) {
                                        TransmitPostEditActivity.this.bsC.Jm();
                                        TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bsJ();
                        if (TransmitPostEditActivity.this.gQL != null) {
                            TransmitPostEditActivity.this.gQL.requestFocus();
                        }
                        TransmitPostEditActivity.this.bsC.Jm();
                        TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQL);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hKu = true;
                        TransmitPostEditActivity.this.nQ(true);
                        if (TransmitPostEditActivity.this.bIA().isFocused()) {
                            TransmitPostEditActivity.this.hKt = "from_title";
                        } else if (TransmitPostEditActivity.this.bIz().isFocused()) {
                            TransmitPostEditActivity.this.hKt = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hKx.setVisibility(0);
                        TransmitPostEditActivity.this.hKx.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hKx.hasFocus()) {
                            TransmitPostEditActivity.this.gQL.requestFocus();
                            TransmitPostEditActivity.this.gQL.setSelection(TransmitPostEditActivity.this.gQL.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hKx.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.bsC.a(31, bVar);
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
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHF() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bIA().getText().toString());
        this.mData.setContent(bIz().getText().toString());
        finish();
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
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aj.e(this.mPost, d.C0140d.cp_link_tip_a, 1);
        bIl();
        aj.t(this.gQI, d.C0140d.cp_bg_line_c);
        aj.t(bIA(), d.C0140d.cp_bg_line_d);
        aj.t(bIz(), d.C0140d.cp_bg_line_d);
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
        this.fyP.onChangeSkinType();
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
        if (this.gQH != null) {
            if (this.gQH.getText().toString().length() == 0) {
                this.gQH.getPaint().setFakeBoldText(false);
            } else if (this.gQH.getText().toString().length() > 0) {
                this.gQH.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
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
        bIr();
        this.hKM = (ScrollView) findViewById(d.g.write_scrollview);
        this.hKM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gQL != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gQL);
                    }
                    if (TransmitPostEditActivity.this.bsC != null) {
                        TransmitPostEditActivity.this.bsC.Jm();
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
        }
        bsK();
        bIx();
        this.gQK = (LinearLayout) findViewById(d.g.post_content_container);
        this.gQK.setDrawingCacheEnabled(false);
        this.gQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.gQL.requestFocus();
                TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            }
        });
        this.bgK.setOnFocusChangeListener(this.gQF);
        this.bgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bsB();
                TransmitPostEditActivity.this.bHF();
            }
        });
        bIu();
        bIw();
        bIq();
        bIl();
        bIv();
        bsH();
        bIC();
        if (this.mData.getType() == 4 && this.gQP != null && this.hKz != null) {
            this.gQP.setVisibility(8);
            this.hKz.setVisibility(8);
        }
        bsJ();
        ShowSoftKeyPad(this.mInputManager, this.gQH);
    }

    private void bIq() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hpD != null && this.hpD.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.hpD != null && this.hpD.equals("2")) {
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
                    this.gQH.setVisibility(0);
                    this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gQL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gQH.setVisibility(8);
                    return;
            }
        }
    }

    private void bIr() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.t(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gQF);
    }

    private void bIs() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hKv && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = am.d(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(d) && bIA() != null) {
                bIA().setText(d);
                bIA().setSelection(d.length());
            }
        }
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
            this.hKL.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, av avVar) {
                    if (avVar != null) {
                        TransmitPostEditActivity.this.hKL.setText(avVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(avVar.dHn);
                        TransmitPostEditActivity.this.hKK = avVar.dHn;
                        TransmitPostEditActivity.this.hKL.bHx();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hKL.bHw();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIA());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIz());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hLe = new com.baidu.tieba.view.d(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
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
            this.gQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gQM.setVisibility(0);
                    TransmitPostEditActivity.this.gQP.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gQN, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.bsC.Jm();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQH);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gQL);
                }
            });
            this.gQO = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gQO.setVisibility(0);
                this.gQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gQM.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gQN, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.bsC.Jm();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIA());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIz());
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

    protected void bIw() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.oJ()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hKX.bFE()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hKX.bFG());
                        TransmitPostEditActivity.this.nP(true);
                    } else if (TransmitPostEditActivity.this.hId.bFE()) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hId.bFG());
                        TransmitPostEditActivity.this.nJ(true);
                    } else {
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIA());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bIz());
                        TransmitPostEditActivity.this.bsC.Jm();
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 7));
                        TransmitPostEditActivity.this.bIF();
                    }
                }
            }
        });
    }

    protected void bsI() {
        this.gQH = (EditText) findViewById(d.g.post_title);
        this.gQH.setOnClickListener(this.hLa);
        this.gQH.setOnFocusChangeListener(this.gQF);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gQH.setText(this.mData.getTitle());
            this.gQH.setSelection(this.mData.getTitle().length());
        }
        this.gQH.addTextChangedListener(this.hLc);
        if (!this.mData.getHaveDraft()) {
            bIs();
        }
        this.gQH.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void bsK() {
        this.gQL = (EditText) findViewById(d.g.post_content);
        this.gQL.setDrawingCacheEnabled(false);
        this.gQL.setOnClickListener(this.hLa);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.Mw().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gQL.setText(W);
            this.gQL.setSelection(W.length());
        }
        this.gQL.setOnFocusChangeListener(this.gQF);
        this.gQL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.bsC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gQL.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gQL.addTextChangedListener(this.hLd);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gQL.setHint(d.j.share_video_default);
        } else {
            this.gQL.setHint(d.j.share_txt_default);
        }
    }

    private void bIx() {
        this.fyP = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fyP.setVisibility(0);
        this.fyP.b(this.mOriginalThreadInfo);
        this.fyP.setEnabled(false);
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
            com.baidu.adp.lib.f.c.nm().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bIz().getSelectionStart(), aVar, FP);
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
        return this.gQL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIA() {
        return this.gQH;
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
            this.hKV.clear();
            this.hKV.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hKV);
            bIz().setSelection(selectionStart2);
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
                        } else {
                            this.mData.setIsNoTitle(false);
                            nR(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nR(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
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
            if (!TextUtils.isEmpty(str2)) {
                nR(true);
            } else if (this.mData.getVideoInfo() != null) {
                nR(true);
            } else {
                nR(false);
            }
        }
    }

    private void nR(boolean z) {
        aj.d(this.mPost, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.bui = new NewWriteModel(this);
        this.bui.b(this.buw);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bsB();
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
            this.mFrom = bundle.getString("from");
            this.mPrivateThread = bundle.getInt("private_thread");
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hpD = bundle.getString("KEY_CALL_FROM");
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
            this.hKB = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hKB != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hpD = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hKv = true;
        }
        bIt();
    }

    private void bIC() {
        if (v.D(this.mList) > 0 && this.mList.get(0) != null) {
            this.hKP.setVisibility(0);
            this.hKQ.setVisibility(0);
            if (this.mData.getType() != 7) {
                this.gQH.setText(com.baidu.tbadk.plugins.a.hd(uJ(this.mList.get(0).mTopicName)));
                this.gQH.setMovementMethod(com.baidu.tieba.view.e.bEM());
            }
            this.hKR.setText(this.mList.get(0).mForumName);
            this.gQH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (!TransmitPostEditActivity.this.hKT.equals(charSequence.toString())) {
                        TransmitPostEditActivity.this.hKU = i + i3;
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    SpannableString hd;
                    if (!TransmitPostEditActivity.this.hKT.equals(editable.toString()) && (hd = com.baidu.tbadk.plugins.a.hd(editable.toString())) != null) {
                        TransmitPostEditActivity.this.hKT = hd.toString();
                        TransmitPostEditActivity.this.gQH.setText(hd);
                        if (TransmitPostEditActivity.this.hKU <= TransmitPostEditActivity.this.gQH.getText().length()) {
                            TransmitPostEditActivity.this.gQH.setSelection(TransmitPostEditActivity.this.hKU);
                        }
                    }
                }
            });
            this.hKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicChangeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 25005, TransmitPostEditActivity.this.mList)));
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
        if (this.hKB != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hKB));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hpD);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
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
        if (bIz() == null || bIz().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bIz().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bIz().getText().toString();
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

    private void bHG() {
        bsB();
        this.mData.setContent(bID());
        this.mData.setTitle(bIE());
        if (this.hKI >= 0) {
            this.mData.setCategoryFrom(this.hKI);
        }
        if (this.hKK >= 0) {
            this.mData.setCategoryTo(this.hKK);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.buh != null && this.buh.ahi());
        this.bui.mO(this.writeImagesInfo.size() > 0);
        if (!v.E(this.mList) && this.hKO != null && this.hKO.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hKO.mForumId));
            this.mData.setForumName(this.hKO.mForumName);
        }
        this.bui.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.bui.getWriteData().setVoice(null);
        this.bui.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.oJ()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.bui.startPostWrite();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                if (this.bsC != null && !this.bsC.Lf()) {
                    bIz().requestFocus();
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
                            bIz().getText().insert(bIz().getSelectionStart(), sb.toString());
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
        } else if (i2 == 0) {
            if (this.bsC != null && !this.bsC.Lf()) {
                this.gQL.requestFocus();
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
                default:
                    return;
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
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.hpD);
        bHG();
    }

    private void bIG() {
        if (this.bsC != null) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIA());
        HidenSoftKeyPad(this.mInputManager, bIz());
        super.onPause();
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
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
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
        if (!this.hKN && this.bsC != null) {
            this.bsC.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.bsC.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0056a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            LE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.hKW != null && !z) {
            this.hKW.bfm();
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
        if (!v.E(this.mList)) {
            this.hKx.setVisibility(0);
            this.hKx.requestFocus();
            this.bsC.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hKx.setVisibility(8);
    }
}
