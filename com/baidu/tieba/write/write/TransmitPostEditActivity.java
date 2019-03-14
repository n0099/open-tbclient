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
import com.baidu.e.a.a;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.h;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0042a, h.a {
    private OriginalThreadCardView Zi;
    private EditorTools ciA;
    private LocationModel ckd;
    private NewWriteModel cke;
    private boolean isPrivacy;
    private TextView iwL;
    private com.baidu.tieba.write.h iwM;
    private ImageView iwN;
    private View iwO;
    private int iwo;
    private LinearLayout jsB;
    private LinearLayout jsC;
    private View jsE;
    private Toast jsG;
    private AdditionData jsH;
    private RelativeLayout jsI;
    private TextView jsJ;
    private TextView jsK;
    private TextView jsL;
    List<v> jsM;
    v jsN;
    private int jsO;
    private String jsP;
    private int jsQ;
    private PostCategoryView jsR;
    private HotTopicBussinessData jsU;
    private TextView jsV;
    private com.baidu.tieba.write.editor.b jsX;
    private e jta;
    private com.baidu.tieba.view.b jth;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jsy = "";
    private boolean jsz = false;
    private WriteData mData = null;
    private boolean jsA = false;
    private InputMethodManager mInputManager = null;
    private EditText iwG = null;
    private View iwH = null;
    private LinearLayout iwJ = null;
    private EditText iwK = null;
    private FeedBackModel jsD = null;
    private ArrayList<WritePrefixItemLayout> jsF = new ArrayList<>();
    private final KeyEvent eHC = new KeyEvent(0, 67);
    private View bVZ = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String cki = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ckj = 0;
    private View mRootView = null;
    private ScrollView jsS = null;
    private boolean jsT = false;
    private com.baidu.tbadk.core.view.b csK = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String fxu = "2";
    private SpannableStringBuilder jsW = new SpannableStringBuilder();
    private boolean jsY = false;
    private final b jsZ = new b();
    private TbFaceManager.a jtb = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan pe(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.oy());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.g(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a fad = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLk));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLk));
        }
    };
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.jsZ.aE(null);
                if (z) {
                    TransmitPostEditActivity.this.eP(z);
                    TransmitPostEditActivity.this.c(true, postWriteCallBackData);
                    TransmitPostEditActivity.this.k(postWriteCallBackData);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    TransmitPostEditActivity.this.setResult(-1, intent);
                    TransmitPostEditActivity.this.finish();
                } else if (postWriteCallBackData.isSensitiveError()) {
                    TransmitPostEditActivity.this.showToast(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jsZ.Ej(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jsZ.aE(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jsZ.b(TransmitPostEditActivity.this.iwG, TransmitPostEditActivity.this.iwK);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agE());
                    if (com.baidu.tbadk.u.a.pT(xVar.agD())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agD())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a ckq = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void amJ() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void onFail(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.ceW())) {
                TransmitPostEditActivity.this.b(2, true, aVar.ceW());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener iIv = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.ckd.qb(false);
                    TransmitPostEditActivity.this.ckd.dZ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.ckd.qb(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jtc = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jtd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cqv = TransmitPostEditActivity.this.cqv();
            if (cqv >= 0 && cqv < TransmitPostEditActivity.this.iwK.getText().length()) {
                TransmitPostEditActivity.this.iwK.setSelection(cqv);
            }
        }
    };
    private boolean jte = true;
    private final View.OnFocusChangeListener iwE = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iwG || view == TransmitPostEditActivity.this.bVZ || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.jte = true;
                    TransmitPostEditActivity.this.cqw();
                    if (TransmitPostEditActivity.this.ciA != null) {
                        TransmitPostEditActivity.this.ciA.akp();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iwG);
                } else if (view == TransmitPostEditActivity.this.iwG) {
                    TransmitPostEditActivity.this.iwL.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iwK && z) {
                TransmitPostEditActivity.this.jte = false;
                TransmitPostEditActivity.this.cqw();
                TransmitPostEditActivity.this.ciA.akp();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iwK);
            }
            TransmitPostEditActivity.this.cqC();
        }
    };
    private TextWatcher jtf = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jtj = "";
        private String jtk;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jtk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jtk != null ? this.jtk.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cbt();
            TransmitPostEditActivity.this.cqD();
            EditText cqO = TransmitPostEditActivity.this.cqO();
            if (editable != null && cqO != null && cqO.getText() != null) {
                if (this.jtj == null || !this.jtj.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jsZ != null) {
                        this.jtj = cqO.getText().toString();
                        TransmitPostEditActivity.this.jsZ.o(cqO);
                        return;
                    }
                    return;
                }
                cqO.setSelection(cqO.getSelectionEnd());
            }
        }
    };
    private TextWatcher jtg = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jtk;
        private String jtl = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jtk = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jtk != null ? this.jtk.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cbt();
            EditText cqN = TransmitPostEditActivity.this.cqN();
            if (editable != null && cqN != null && cqN.getText() != null) {
                int selectionEnd = cqN.getSelectionEnd();
                if (this.jtl == null || !this.jtl.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jsZ != null) {
                        this.jtl = cqN.getText().toString();
                        TransmitPostEditActivity.this.jsZ.o(cqN);
                        return;
                    }
                    return;
                }
                cqN.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ap.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void amv() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amx();
        } else if (this.ckd.cfd()) {
            amu();
        } else {
            this.ckd.qb(false);
            b(1, true, null);
            this.ckd.cfb();
        }
    }

    private void amx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gD(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.ckd.aNJ();
                } else {
                    TransmitPostEditActivity.this.ckq.amJ();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqv() {
        int selectionEnd = cqN().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cqN().getText().getSpans(0, cqN().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cqN().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cqN().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqw() {
        if (this.ciA != null) {
            this.ciA.setBarLauncherEnabled(!this.jte);
            this.ciA.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jsT) {
            this.iwG.setVisibility(8);
            cbt();
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
        initUI();
        this.ckd = new LocationModel(this);
        this.ckd.a(this.ckq);
        registerListener(this.iIv);
        registerListener(this.jtc);
        initEditor();
        this.iwK.requestFocus();
        bXw();
        cqW();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.ciA = new EditorTools(getActivity());
        this.ciA.setBarMaxLauCount(4);
        this.ciA.setMoreButtonAtEnd(true);
        this.ciA.setBarLauncherType(1);
        this.ciA.eH(true);
        this.ciA.eI(true);
        this.ciA.setMoreLauncherIcon(d.f.write_more);
        this.ciA.setBackgroundColorId(d.C0277d.cp_bg_line_d);
        cqx();
        this.ciA.alT();
        if (this.jsB != null) {
            this.jsB.addView(this.ciA);
        }
        cqy();
        this.ciA.qT();
        com.baidu.tbadk.editortools.g jt = this.ciA.jt(6);
        if (jt != null && !TextUtils.isEmpty(this.cki)) {
            ((View) jt).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.cki);
                }
            });
        }
        if (!this.jsT) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ciA.akp();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        cqA();
    }

    private void cqx() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.cji = d.f.write_at;
        this.ciA.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.ciA.b(aVar2);
        aVar2.cji = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.cjk = 4;
            kVar.cji = d.f.icon_post_location_selector;
            this.ciA.b(kVar);
        }
        if (this.jsH == null) {
            if (this.jsX == null) {
                this.jsX = new com.baidu.tieba.write.editor.b(getActivity(), this.fxu);
                this.jsX.cpv();
                this.jsX.setFrom("from_share_write");
                this.jsX.bw(this.mData.getForumId(), this.mPrivateThread);
            }
            this.ciA.b(this.jsX);
        }
        this.ciA.ab(arrayList);
        com.baidu.tbadk.editortools.k jw = this.ciA.jw(5);
        if (jw != null) {
            jw.cjk = 1;
            jw.cji = d.f.write_emotion;
        }
    }

    private void cqy() {
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
                            TiebaStatic.log(new am("c12608").T("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.cqM()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cqM()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cqP();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cbt();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jsH == null) {
                            TransmitPostEditActivity.this.amy();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.ckj) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.cR(pageActivity)) {
                                    TransmitPostEditActivity.this.amv();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.amu();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.ckd != null) {
                            TransmitPostEditActivity.this.ckd.qb(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.bJ(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.ciA.alV()) {
                                        TransmitPostEditActivity.this.ciA.akp();
                                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.cbt();
                        if (TransmitPostEditActivity.this.iwK != null) {
                            TransmitPostEditActivity.this.iwK.requestFocus();
                        }
                        TransmitPostEditActivity.this.ciA.akp();
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwK);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jsz = true;
                        TransmitPostEditActivity.this.rh(true);
                        if (TransmitPostEditActivity.this.cqO().isFocused()) {
                            TransmitPostEditActivity.this.jsy = "from_title";
                        } else if (TransmitPostEditActivity.this.cqN().isFocused()) {
                            TransmitPostEditActivity.this.jsy = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jsC.setVisibility(0);
                        TransmitPostEditActivity.this.jsC.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jsC.hasFocus()) {
                            TransmitPostEditActivity.this.iwK.requestFocus();
                            TransmitPostEditActivity.this.iwK.setSelection(TransmitPostEditActivity.this.iwK.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jsC.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.ciA.setActionListener(31, bVar);
        this.ciA.setActionListener(16, bVar);
        this.ciA.setActionListener(14, bVar);
        this.ciA.setActionListener(24, bVar);
        this.ciA.setActionListener(3, bVar);
        this.ciA.setActionListener(10, bVar);
        this.ciA.setActionListener(11, bVar);
        this.ciA.setActionListener(12, bVar);
        this.ciA.setActionListener(13, bVar);
        this.ciA.setActionListener(15, bVar);
        this.ciA.setActionListener(18, bVar);
        this.ciA.setActionListener(20, bVar);
        this.ciA.setActionListener(25, bVar);
        this.ciA.setActionListener(27, bVar);
        this.ciA.setActionListener(29, bVar);
        this.ciA.setActionListener(43, bVar);
        this.ciA.setActionListener(45, bVar);
        this.ciA.setActionListener(53, bVar);
        this.ciA.setActionListener(48, bVar);
        this.ciA.setActionListener(46, bVar);
        this.ciA.setActionListener(49, bVar);
        this.ciA.setActionListener(47, bVar);
        this.ciA.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amy() {
        if (this.ckd.aNF()) {
            if (this.ckd.cfd()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.ceZ().getLocationData().ceW());
                return;
            }
            b(1, true, null);
            this.ckd.cfb();
            return;
        }
        b(0, true, null);
    }

    protected void cbl() {
        if (this.cke != null) {
            this.cke.cancelLoadData();
        }
        if (this.jsD != null) {
            this.jsD.cancelLoadData();
        }
        if (this.ckd != null) {
            this.ckd.cancelLoadData();
        }
    }

    private void cqz() {
        if (this.jta != null) {
            this.jta.hideTip();
        }
    }

    private void cqA() {
        if (this.jta == null) {
            this.jta = new e(getPageContext());
        }
        this.jta.c(this.ciA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cqz();
        TiebaPrepareImageService.StopService();
        cbl();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqB() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(cqO().getText().toString());
        this.mData.setContent(cqN().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iwM != null && this.iwM.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iwM, getPageContext().getPageActivity());
                return true;
            } else if (this.ciA.alV()) {
                this.ciA.akp();
                return true;
            } else {
                cbl();
                cqB();
                return true;
            }
        }
        if (i == 67 && (text = cqN().getText()) != null) {
            int selectionStart = cqN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqN().onKeyDown(67, this.eHC);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.d(this.mPost, d.C0277d.cp_link_tip_a, 1);
        cqw();
        al.l(this.iwH, d.C0277d.cp_bg_line_c);
        al.l(cqO(), d.C0277d.cp_bg_line_d);
        al.l(cqN(), d.C0277d.cp_bg_line_d);
        cbt();
        this.ciA.onChangeSkinType(i);
        if (this.jsR != null) {
            this.jsR.aeK();
        }
        al.j(this.mName, d.C0277d.cp_cont_b);
        cqC();
        cqD();
        if (this.jsZ != null) {
            this.jsZ.c(cqO(), cqN());
        }
        this.Zi.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqC() {
        if (this.iwG.hasFocus()) {
            this.iwG.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwG.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
        if (this.iwK.hasFocus()) {
            this.iwK.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwK.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqD() {
        if (this.iwG != null) {
            if (this.iwG.getText().toString().length() == 0) {
                this.iwG.getPaint().setFakeBoldText(false);
            } else if (this.iwG.getText().toString().length() > 0) {
                this.iwG.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.csK = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jsT = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, d.C0277d.cp_cont_b);
        cqF();
        this.jsS = (ScrollView) findViewById(d.g.write_scrollview);
        this.jsS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iwK != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iwK);
                    }
                    if (TransmitPostEditActivity.this.ciA != null) {
                        TransmitPostEditActivity.this.ciA.akp();
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
        this.jsB = (LinearLayout) findViewById(d.g.tool_view);
        this.jsB.setContentDescription("..");
        this.jsC = (LinearLayout) findViewById(d.g.title_view);
        this.iwH = findViewById(d.g.interval_view);
        this.jsV = (TextView) findViewById(d.g.hot_topic_title_edt);
        cbs();
        if (this.jsT) {
            this.jsS.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cbu();
        cqL();
        this.iwJ = (LinearLayout) findViewById(d.g.post_content_container);
        this.iwJ.setDrawingCacheEnabled(false);
        this.iwJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iwK.requestFocus();
            }
        });
        this.bVZ.setOnFocusChangeListener(this.iwE);
        this.bVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cbl();
                TransmitPostEditActivity.this.cqB();
            }
        });
        cqI();
        cqK();
        cqE();
        cqw();
        cqJ();
        cbr();
        cqQ();
        if (this.mData.getType() == 4 && this.iwO != null && this.jsE != null) {
            this.iwO.setVisibility(8);
            this.jsE.setVisibility(8);
        }
        cbt();
        ShowSoftKeyPad(this.mInputManager, this.iwG);
    }

    private void cqE() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.fxu != null && this.fxu.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.fxu != null && this.fxu.equals("2")) {
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
                    this.iwG.setVisibility(0);
                    this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.iwK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iwG.setVisibility(8);
                    return;
            }
        }
    }

    private void cqF() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iwE);
    }

    private void cqG() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jsA && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String f = ap.f(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(f) && cqO() != null) {
                cqO().setText(f);
                cqO().setSelection(f.length());
            }
        }
    }

    private void cqH() {
        this.jsM = null;
        this.jsO = -1;
        this.jsQ = -1;
        com.baidu.tieba.frs.x qp = w.bej().qp(1);
        if (qp != null) {
            this.jsM = qp.fcE;
            this.jsO = getIntent().getIntExtra("category_id", -1);
            if (this.jsM != null && !this.jsM.isEmpty() && this.jsO >= 0) {
                this.jsN = new v();
                this.jsN.fcA = 0;
                this.jsN.name = getPageContext().getResources().getString(d.j.category_auto);
                this.jsQ = this.jsN.fcA;
                this.jsP = this.jsN.name;
                for (v vVar : this.jsM) {
                    if (vVar.fcA == this.jsO) {
                        this.jsQ = vVar.fcA;
                        this.jsP = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cqI() {
        if (this.jsM != null && !this.jsM.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.jsR = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.jsR.setText(this.jsP);
            this.jsR.setCategoryContainerData(this.jsM, this.jsN, this.jsQ);
            this.jsR.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jsR.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.fcA);
                        TransmitPostEditActivity.this.jsQ = arVar.fcA;
                        TransmitPostEditActivity.this.jsR.cqj();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jsR.cqi();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqO());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqN());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jth = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jth.setTitle(d.j.no_disturb_start_time);
        this.jth.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.jth);
        this.jth.setButton(-2, getPageContext().getString(d.j.cancel), this.jth);
        return this.jth;
    }

    private void cqJ() {
        this.jsI = (RelativeLayout) findViewById(d.g.addition_container);
        this.jsJ = (TextView) findViewById(d.g.addition_create_time);
        this.jsK = (TextView) findViewById(d.g.addition_last_time);
        this.jsL = (TextView) findViewById(d.g.addition_last_content);
        if (this.jsH != null) {
            this.jsI.setVisibility(0);
            this.jsJ.setText(getPageContext().getString(d.j.write_addition_create) + ap.ao(this.jsH.getCreateTime() * 1000));
            if (this.jsH.getAlreadyCount() == 0) {
                this.jsK.setVisibility(8);
            } else {
                this.jsK.setText(getPageContext().getString(d.j.write_addition_last) + ap.ao(this.jsH.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jsH.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jsL.setText(lastAdditionContent);
            } else {
                this.jsL.setVisibility(8);
            }
            cqN().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.jsH.getAlreadyCount()), Integer.valueOf(this.jsH.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.jsI.setVisibility(8);
    }

    private void cbr() {
        this.iwO = findViewById(d.g.post_prefix_layout);
        this.iwL = (TextView) findViewById(d.g.post_prefix);
        this.jsE = findViewById(d.g.prefix_divider);
        this.iwN = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iwO.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iwo = 1;
            this.iwO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iwL.setVisibility(0);
                    TransmitPostEditActivity.this.iwO.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iwM, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.ciA.akp();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwG);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwK);
                }
            });
            this.iwN = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.iwN.setVisibility(0);
                this.iwL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iwL.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iwM, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.ciA.akp();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqO());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqN());
                    }
                });
            }
            this.iwM = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iwM.a(this);
            this.iwM.setMaxHeight(l.h(getActivity(), d.e.ds510));
            this.iwM.setOutsideTouchable(true);
            this.iwM.setFocusable(true);
            this.iwM.setOnDismissListener(this);
            this.iwM.setBackgroundDrawable(al.getDrawable(d.C0277d.cp_bg_line_d));
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_cont_c);
            al.k(this.iwL, d.C0277d.cp_bg_line_d);
            al.c(this.iwN, d.f.icon_frs_arrow_n);
            this.iwL.setTextColor(color);
            this.jsF.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jsF.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iwM.addView(writePrefixItemLayout);
            }
            this.iwM.setCurrentIndex(0);
            this.iwL.setText(prefixs.get(1));
            By(1);
            return;
        }
        this.iwO.setVisibility(8);
    }

    protected void cqK() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jsZ.a(TransmitPostEditActivity.this.iwG, TransmitPostEditActivity.this.iwK)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jsZ.coc());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqO());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqN());
                    TransmitPostEditActivity.this.ciA.akp();
                    TiebaStatic.log(new am("c12608").T("obj_locate", 7));
                    TransmitPostEditActivity.this.cqU();
                }
            }
        });
    }

    protected void cbs() {
        this.iwG = (EditText) findViewById(d.g.post_title);
        this.iwG.setOnClickListener(this.jtd);
        this.iwG.setOnFocusChangeListener(this.iwE);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.iwG.setText(this.mData.getTitle());
            this.iwG.setSelection(this.mData.getTitle().length());
        }
        this.iwG.addTextChangedListener(this.jtf);
        if (!this.mData.getHaveDraft()) {
            cqG();
        }
        this.iwG.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void cbu() {
        this.iwK = (EditText) findViewById(d.g.post_content);
        this.iwK.setDrawingCacheEnabled(false);
        this.iwK.setOnClickListener(this.jtd);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.ano().ax(getPageContext().getPageActivity(), this.mData.getContent());
            this.iwK.setText(ax);
            this.iwK.setSelection(ax.length());
        }
        this.iwK.setOnFocusChangeListener(this.iwE);
        this.iwK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iwK.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwK.addTextChangedListener(this.jtg);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iwK.setHint(d.j.share_video_default);
        } else {
            this.iwK.setHint(d.j.share_txt_default);
        }
    }

    private void cqL() {
        this.Zi = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.Zi.setVisibility(0);
        this.Zi.b(this.mOriginalThreadInfo);
        this.Zi.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqM() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jsH != null) {
            i = 1000;
        }
        return cqN().getText() != null && cqN().getText().length() >= i;
    }

    private void oM(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jsy)) {
                this.jsy = "";
                cqN().requestFocus();
                if (cqN().getText() != null && cqN().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqN().getSelectionStart();
                    editable = cqN().getText();
                }
            } else if ("from_title".equals(this.jsy)) {
                this.jsy = "";
                cqO().requestFocus();
                if (cqO().getText() != null && cqO().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqO().getSelectionStart();
                    editable = cqO().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void e(p pVar) {
        if (((ImageSpan[]) cqN().getText().getSpans(0, cqN().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jsG == null) {
                this.jsG = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.jsG.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType agt = pVar.agt();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jB().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cqN().getSelectionStart(), aVar, agt);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cqN() != null && cqN().getText() != null) {
            Bitmap oy = aVar.oy();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(oy);
            int width = oy.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, oy.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.g(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = cqN().getSelectionStart() - 1;
                if (cqN().getText().length() > 1 && selectionStart >= 0 && cqN().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cqN().getText().insert(cqN().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cqN().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cqN().getText().insert(cqN().getSelectionStart(), spannableString2);
            }
            Editable text = cqN().getText();
            if (text != null) {
                this.jsW.clear();
                this.jsW.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jsW);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cqN().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cqN().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cqN().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqN() {
        return this.iwK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqO() {
        return this.iwG;
    }

    protected void cqP() {
        Editable text;
        if (cqN() != null && (text = cqN().getText()) != null) {
            int selectionStart = cqN().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqN().onKeyDown(67, this.eHC);
            }
            cqN().onKeyDown(67, this.eHC);
            int selectionStart2 = cqN().getSelectionStart();
            this.jsW.clear();
            this.jsW.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jsW);
            cqN().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.csK.e(null);
        this.csK.hG(d.j.sending);
        this.csK.dJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.csK.dJ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbt() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cqO() != null) {
                str = cqO().getText().toString();
            }
            if (cqN() != null) {
                str2 = cqN().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iwo == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            ri(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        ri(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    ri(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.jsT) {
                    ri(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    ri(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ri(true);
            } else if (this.mData.getVideoInfo() != null) {
                ri(true);
            } else {
                ri(false);
            }
        }
    }

    private void ri(boolean z) {
        al.c(this.mPost, d.C0277d.cp_link_tip_a, d.C0277d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.cke = new NewWriteModel(this);
        this.cke.b(this.cks);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cbl();
            }
        };
        this.mData = new WriteData();
        if (bundle != null) {
            this.mData.setType(bundle.getInt("type", 0));
            this.mData.setForumId(bundle.getString("forum_id"));
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(bundle.getString("thread_id"));
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.jsH = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jsH != null);
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
            this.fxu = bundle.getString("KEY_CALL_FROM");
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
            this.mData.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
            this.mData.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
            this.mData.setThreadId(intent.getStringExtra("thread_id"));
            this.jsH = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jsH != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fxu = intent.getStringExtra("KEY_CALL_FROM");
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
        this.writeImagesInfo.setMaxImagesAllowed(this.mData.getType() == 4 ? 6 : 9);
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
            this.jsA = true;
        }
        cqH();
    }

    private void cqQ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iwG.setText(com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName)));
            this.iwG.setMovementMethod(com.baidu.tieba.view.c.cna());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString pv = com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName));
            if (pv != null) {
                this.iwG.setText(pv);
            }
            this.jsV.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.mData.getType());
        bundle.putString("forum_id", this.mData.getForumId());
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.mData.getFirstDir());
        bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.mData.getSecondDir());
        bundle.putString("thread_id", this.mData.getThreadId());
        bundle.putInt("private_thread", this.mPrivateThread);
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        if (this.jsH != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jsH));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fxu);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cqN().getEditableText().toString();
        if (obj != null) {
            cqN().setText(TbFaceManager.ano().a(getPageContext().getPageActivity(), obj, this.jtb));
            cqN().setSelection(cqN().getText().length());
        }
    }

    private String cqR() {
        if (cqN() == null || cqN().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cqN().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return cqN().getText().toString();
    }

    private String cqS() {
        if (this.mData == null || cqO() == null || cqO().getVisibility() != 0 || cqO().getText() == null) {
            return "";
        }
        String obj = cqO().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) > 0 && this.iwo != 0 && this.mData.getType() != 4 && this.iwL != null && this.iwL.getText() != null) {
            obj = this.iwL.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void cqT() {
        cbl();
        this.mData.setContent(cqR());
        this.mData.setTitle(cqS());
        if (this.jsO >= 0) {
            this.mData.setCategoryFrom(this.jsO);
        }
        if (this.jsQ >= 0) {
            this.mData.setCategoryTo(this.jsQ);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.ckd != null && this.ckd.aNF());
        this.cke.qd(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.T(this.mList) && this.jsU != null && this.jsU.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jsU.mForumId));
            this.mData.setForumName(this.jsU.mForumName);
        }
        this.cke.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.cke.getWriteData().setVoice(null);
        this.cke.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kY()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.cke.startPostWrite();
    }

    private void A(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jsH != null) {
                i2 = this.jsH.getTotalCount();
                i = this.jsH.getAlreadyCount() + 1;
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
                if (this.ciA != null && !this.ciA.alV()) {
                    cqN().requestFocus();
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
                            cqN().getText().insert(cqN().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                k((intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data"));
                setResult(-1, intent);
                finish();
            } else if (i == 25004) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (!StringUtils.isNull(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (this.jsz) {
                            sb2.append(com.baidu.tbadk.plugins.b.csi);
                            this.jsz = false;
                        }
                        sb2.append(stringExtra);
                        oM(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.T(this.mList) && !com.baidu.tbadk.core.util.v.T(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.jsU = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.jsU);
            }
        } else if (i2 == 0) {
            if (this.ciA != null && !this.ciA.alV()) {
                this.iwK.requestFocus();
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
                        this.jsZ.Ej(postWriteCallBackData.getErrorString());
                        this.jsZ.aE(postWriteCallBackData.getSensitiveWords());
                        this.jsZ.b(this.iwG, this.iwK);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.jsy)) {
                        cqO().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jsy)) {
                        cqN().requestFocus();
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
    public void cqU() {
        if ("1".equals(this.fxu)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fxu)) {
            this.mData.setCanNoForum(false);
        }
        cqV();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.fxu);
        cqT();
    }

    private void cqV() {
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cqO());
        HidenSoftKeyPad(this.mInputManager, cqN());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fad) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLk));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jsH == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                A(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ckj = i;
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cqW() {
        if (!this.jsT && this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.ciA.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void By(int i) {
        if (i < this.jsF.size()) {
            for (int i2 = 0; i2 < this.jsF.size(); i2++) {
                this.jsF.get(i2).qY(false);
            }
            this.jsF.get(i).qY(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void yZ(int i) {
        this.iwo = i;
        this.iwM.setCurrentIndex(i);
        By(i);
        this.iwL.setText(this.mPrefixData.getPrefixs().get(i));
        cbt();
        com.baidu.adp.lib.g.g.a(this.iwM, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iwO.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes3.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.getCurrentFocus());
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            amv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jsY = z;
        if (this.jsX != null && !z) {
            this.jsX.aWP();
        }
        if (this.jta != null && !z) {
            cqz();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jsY && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jsz = false;
            this.jsy = "";
            if ("from_content".equals(str)) {
                this.jsy = "from_content";
            } else if ("from_title".equals(str)) {
                this.jsy = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.pu(String.valueOf(charSequence.charAt(i)))) {
                rh(false);
            }
        }
    }

    public void bXw() {
        if (!com.baidu.tbadk.core.util.v.T(this.mList)) {
            this.jsC.setVisibility(0);
            this.jsC.requestFocus();
            this.ciA.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jsC.setVisibility(8);
    }
}
