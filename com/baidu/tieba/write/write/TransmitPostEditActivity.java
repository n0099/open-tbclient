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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0040a, h.a {
    private OriginalThreadCardView Zh;
    private EditorTools ciA;
    private LocationModel ckd;
    private NewWriteModel cke;
    private boolean isPrivacy;
    private TextView iwS;
    private com.baidu.tieba.write.h iwT;
    private ImageView iwU;
    private View iwV;
    private int iwv;
    private LinearLayout jsJ;
    private LinearLayout jsK;
    private View jsM;
    private Toast jsO;
    private AdditionData jsP;
    private RelativeLayout jsQ;
    private TextView jsR;
    private TextView jsS;
    private TextView jsT;
    List<v> jsU;
    v jsV;
    private int jsW;
    private String jsX;
    private int jsY;
    private PostCategoryView jsZ;
    private HotTopicBussinessData jtc;
    private TextView jtd;
    private com.baidu.tieba.write.editor.b jtf;
    private e jti;
    private com.baidu.tieba.view.b jtp;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jsG = "";
    private boolean jsH = false;
    private WriteData mData = null;
    private boolean jsI = false;
    private InputMethodManager mInputManager = null;
    private EditText iwN = null;
    private View iwO = null;
    private LinearLayout iwQ = null;
    private EditText iwR = null;
    private FeedBackModel jsL = null;
    private ArrayList<WritePrefixItemLayout> jsN = new ArrayList<>();
    private final KeyEvent eHG = new KeyEvent(0, 67);
    private View bVY = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String cki = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ckj = 0;
    private View mRootView = null;
    private ScrollView jta = null;
    private boolean jtb = false;
    private com.baidu.tbadk.core.view.b csN = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String fxv = "2";
    private SpannableStringBuilder jte = new SpannableStringBuilder();
    private boolean jtg = false;
    private final b jth = new b();
    private TbFaceManager.a jtj = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a fae = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLj));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLj));
        }
    };
    private final NewWriteModel.d cks = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.jth.aE(null);
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
                    TransmitPostEditActivity.this.jth.El(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jth.aE(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jth.b(TransmitPostEditActivity.this.iwN, TransmitPostEditActivity.this.iwR);
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
                    if (com.baidu.tbadk.u.a.pV(xVar.agD())) {
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
        public void amK() {
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
            if (aVar != null && !StringUtils.isNull(aVar.ceU())) {
                TransmitPostEditActivity.this.b(2, true, aVar.ceU());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener iID = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.ckd.qb(false);
                    TransmitPostEditActivity.this.ckd.ea(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.ckd.qb(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jtk = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jtl = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cqs = TransmitPostEditActivity.this.cqs();
            if (cqs >= 0 && cqs < TransmitPostEditActivity.this.iwR.getText().length()) {
                TransmitPostEditActivity.this.iwR.setSelection(cqs);
            }
        }
    };
    private boolean jtm = true;
    private final View.OnFocusChangeListener iwL = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iwN || view == TransmitPostEditActivity.this.bVY || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.jtm = true;
                    TransmitPostEditActivity.this.cqt();
                    if (TransmitPostEditActivity.this.ciA != null) {
                        TransmitPostEditActivity.this.ciA.akq();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iwN);
                } else if (view == TransmitPostEditActivity.this.iwN) {
                    TransmitPostEditActivity.this.iwS.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iwR && z) {
                TransmitPostEditActivity.this.jtm = false;
                TransmitPostEditActivity.this.cqt();
                TransmitPostEditActivity.this.ciA.akq();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iwR);
            }
            TransmitPostEditActivity.this.cqz();
        }
    };
    private TextWatcher jtn = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jtr = "";
        private String jts;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jts = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jts != null ? this.jts.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cbr();
            TransmitPostEditActivity.this.cqA();
            EditText cqL = TransmitPostEditActivity.this.cqL();
            if (editable != null && cqL != null && cqL.getText() != null) {
                if (this.jtr == null || !this.jtr.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jth != null) {
                        this.jtr = cqL.getText().toString();
                        TransmitPostEditActivity.this.jth.o(cqL);
                        return;
                    }
                    return;
                }
                cqL.setSelection(cqL.getSelectionEnd());
            }
        }
    };
    private TextWatcher jto = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jts;
        private String jtt = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jts = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jts != null ? this.jts.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cbr();
            EditText cqK = TransmitPostEditActivity.this.cqK();
            if (editable != null && cqK != null && cqK.getText() != null) {
                int selectionEnd = cqK.getSelectionEnd();
                if (this.jtt == null || !this.jtt.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jth != null) {
                        this.jtt = cqK.getText().toString();
                        TransmitPostEditActivity.this.jth.o(cqK);
                        return;
                    }
                    return;
                }
                cqK.setSelection(selectionEnd);
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
    public void amv() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void amw() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amy();
        } else if (this.ckd.cfb()) {
            amv();
        } else {
            this.ckd.qb(false);
            b(1, true, null);
            this.ckd.ceZ();
        }
    }

    private void amy() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gD(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.ckd.aNK();
                } else {
                    TransmitPostEditActivity.this.ckq.amK();
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
    public int cqs() {
        int selectionEnd = cqK().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cqK().getText().getSpans(0, cqK().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cqK().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cqK().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqt() {
        if (this.ciA != null) {
            this.ciA.setBarLauncherEnabled(!this.jtm);
            this.ciA.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jtb) {
            this.iwN.setVisibility(8);
            cbr();
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
        registerListener(this.iID);
        registerListener(this.jtk);
        initEditor();
        this.iwR.requestFocus();
        bXu();
        cqT();
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
        this.ciA.setBackgroundColorId(d.C0236d.cp_bg_line_d);
        cqu();
        this.ciA.alU();
        if (this.jsJ != null) {
            this.jsJ.addView(this.ciA);
        }
        cqv();
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
        if (!this.jtb) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ciA.akq();
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
        cqx();
    }

    private void cqu() {
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
        if (this.jsP == null) {
            if (this.jtf == null) {
                this.jtf = new com.baidu.tieba.write.editor.b(getActivity(), this.fxv);
                this.jtf.cps();
                this.jtf.setFrom("from_share_write");
                this.jtf.bw(this.mData.getForumId(), this.mPrivateThread);
            }
            this.ciA.b(this.jtf);
        }
        this.ciA.ab(arrayList);
        com.baidu.tbadk.editortools.k jw = this.ciA.jw(5);
        if (jw != null) {
            jw.cjk = 1;
            jw.cji = d.f.write_emotion;
        }
    }

    private void cqv() {
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
                        if (TransmitPostEditActivity.this.cqJ()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cqJ()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cqM();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cbr();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jsP == null) {
                            TransmitPostEditActivity.this.amz();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.ckj) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.cR(pageActivity)) {
                                    TransmitPostEditActivity.this.amw();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.amv();
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
                                    if (TransmitPostEditActivity.this.ciA.alW()) {
                                        TransmitPostEditActivity.this.ciA.akq();
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
                        TransmitPostEditActivity.this.cbr();
                        if (TransmitPostEditActivity.this.iwR != null) {
                            TransmitPostEditActivity.this.iwR.requestFocus();
                        }
                        TransmitPostEditActivity.this.ciA.akq();
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwR);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jsH = true;
                        TransmitPostEditActivity.this.rh(true);
                        if (TransmitPostEditActivity.this.cqL().isFocused()) {
                            TransmitPostEditActivity.this.jsG = "from_title";
                        } else if (TransmitPostEditActivity.this.cqK().isFocused()) {
                            TransmitPostEditActivity.this.jsG = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jsK.setVisibility(0);
                        TransmitPostEditActivity.this.jsK.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jsK.hasFocus()) {
                            TransmitPostEditActivity.this.iwR.requestFocus();
                            TransmitPostEditActivity.this.iwR.setSelection(TransmitPostEditActivity.this.iwR.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jsK.setVisibility(8);
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
    public void amz() {
        if (this.ckd.aNG()) {
            if (this.ckd.cfb()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.ceX().getLocationData().ceU());
                return;
            }
            b(1, true, null);
            this.ckd.ceZ();
            return;
        }
        b(0, true, null);
    }

    protected void cbj() {
        if (this.cke != null) {
            this.cke.cancelLoadData();
        }
        if (this.jsL != null) {
            this.jsL.cancelLoadData();
        }
        if (this.ckd != null) {
            this.ckd.cancelLoadData();
        }
    }

    private void cqw() {
        if (this.jti != null) {
            this.jti.hideTip();
        }
    }

    private void cqx() {
        if (this.jti == null) {
            this.jti = new e(getPageContext());
        }
        this.jti.c(this.ciA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cqw();
        TiebaPrepareImageService.StopService();
        cbj();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqy() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(cqL().getText().toString());
        this.mData.setContent(cqK().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iwT != null && this.iwT.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iwT, getPageContext().getPageActivity());
                return true;
            } else if (this.ciA.alW()) {
                this.ciA.akq();
                return true;
            } else {
                cbj();
                cqy();
                return true;
            }
        }
        if (i == 67 && (text = cqK().getText()) != null) {
            int selectionStart = cqK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqK().onKeyDown(67, this.eHG);
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
        al.d(this.mPost, d.C0236d.cp_link_tip_a, 1);
        cqt();
        al.l(this.iwO, d.C0236d.cp_bg_line_c);
        al.l(cqL(), d.C0236d.cp_bg_line_d);
        al.l(cqK(), d.C0236d.cp_bg_line_d);
        cbr();
        this.ciA.onChangeSkinType(i);
        if (this.jsZ != null) {
            this.jsZ.aeK();
        }
        al.j(this.mName, d.C0236d.cp_cont_b);
        cqz();
        cqA();
        if (this.jth != null) {
            this.jth.c(cqL(), cqK());
        }
        this.Zh.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqz() {
        if (this.iwN.hasFocus()) {
            this.iwN.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        } else {
            this.iwN.setHintTextColor(al.getColor(d.C0236d.cp_cont_d));
        }
        if (this.iwR.hasFocus()) {
            this.iwR.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        } else {
            this.iwR.setHintTextColor(al.getColor(d.C0236d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqA() {
        if (this.iwN != null) {
            if (this.iwN.getText().toString().length() == 0) {
                this.iwN.getPaint().setFakeBoldText(false);
            } else if (this.iwN.getText().toString().length() > 0) {
                this.iwN.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.csN = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jtb = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, d.C0236d.cp_cont_b);
        cqC();
        this.jta = (ScrollView) findViewById(d.g.write_scrollview);
        this.jta.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iwR != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iwR);
                    }
                    if (TransmitPostEditActivity.this.ciA != null) {
                        TransmitPostEditActivity.this.ciA.akq();
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
        this.jsJ = (LinearLayout) findViewById(d.g.tool_view);
        this.jsJ.setContentDescription("..");
        this.jsK = (LinearLayout) findViewById(d.g.title_view);
        this.iwO = findViewById(d.g.interval_view);
        this.jtd = (TextView) findViewById(d.g.hot_topic_title_edt);
        cbq();
        if (this.jtb) {
            this.jta.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cbs();
        cqI();
        this.iwQ = (LinearLayout) findViewById(d.g.post_content_container);
        this.iwQ.setDrawingCacheEnabled(false);
        this.iwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iwR.requestFocus();
            }
        });
        this.bVY.setOnFocusChangeListener(this.iwL);
        this.bVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cbj();
                TransmitPostEditActivity.this.cqy();
            }
        });
        cqF();
        cqH();
        cqB();
        cqt();
        cqG();
        cbp();
        cqN();
        if (this.mData.getType() == 4 && this.iwV != null && this.jsM != null) {
            this.iwV.setVisibility(8);
            this.jsM.setVisibility(8);
        }
        cbr();
        ShowSoftKeyPad(this.mInputManager, this.iwN);
    }

    private void cqB() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.fxv != null && this.fxv.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.fxv != null && this.fxv.equals("2")) {
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
                    this.iwN.setVisibility(0);
                    this.iwR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.iwR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.iwR.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iwN.setVisibility(8);
                    return;
            }
        }
    }

    private void cqC() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iwL);
    }

    private void cqD() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jsI && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String f = ap.f(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(f) && cqL() != null) {
                cqL().setText(f);
                cqL().setSelection(f.length());
            }
        }
    }

    private void cqE() {
        this.jsU = null;
        this.jsW = -1;
        this.jsY = -1;
        com.baidu.tieba.frs.x qp = w.bek().qp(1);
        if (qp != null) {
            this.jsU = qp.fcF;
            this.jsW = getIntent().getIntExtra("category_id", -1);
            if (this.jsU != null && !this.jsU.isEmpty() && this.jsW >= 0) {
                this.jsV = new v();
                this.jsV.fcB = 0;
                this.jsV.name = getPageContext().getResources().getString(d.j.category_auto);
                this.jsY = this.jsV.fcB;
                this.jsX = this.jsV.name;
                for (v vVar : this.jsU) {
                    if (vVar.fcB == this.jsW) {
                        this.jsY = vVar.fcB;
                        this.jsX = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cqF() {
        if (this.jsU != null && !this.jsU.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.jsZ = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.jsZ.setText(this.jsX);
            this.jsZ.setCategoryContainerData(this.jsU, this.jsV, this.jsY);
            this.jsZ.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jsZ.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.fcB);
                        TransmitPostEditActivity.this.jsY = arVar.fcB;
                        TransmitPostEditActivity.this.jsZ.cqg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jsZ.cqf();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqL());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqK());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jtp = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jtp.setTitle(d.j.no_disturb_start_time);
        this.jtp.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.jtp);
        this.jtp.setButton(-2, getPageContext().getString(d.j.cancel), this.jtp);
        return this.jtp;
    }

    private void cqG() {
        this.jsQ = (RelativeLayout) findViewById(d.g.addition_container);
        this.jsR = (TextView) findViewById(d.g.addition_create_time);
        this.jsS = (TextView) findViewById(d.g.addition_last_time);
        this.jsT = (TextView) findViewById(d.g.addition_last_content);
        if (this.jsP != null) {
            this.jsQ.setVisibility(0);
            this.jsR.setText(getPageContext().getString(d.j.write_addition_create) + ap.ao(this.jsP.getCreateTime() * 1000));
            if (this.jsP.getAlreadyCount() == 0) {
                this.jsS.setVisibility(8);
            } else {
                this.jsS.setText(getPageContext().getString(d.j.write_addition_last) + ap.ao(this.jsP.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jsP.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jsT.setText(lastAdditionContent);
            } else {
                this.jsT.setVisibility(8);
            }
            cqK().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.jsP.getAlreadyCount()), Integer.valueOf(this.jsP.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.jsQ.setVisibility(8);
    }

    private void cbp() {
        this.iwV = findViewById(d.g.post_prefix_layout);
        this.iwS = (TextView) findViewById(d.g.post_prefix);
        this.jsM = findViewById(d.g.prefix_divider);
        this.iwU = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iwV.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.iwv = 1;
            this.iwV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iwS.setVisibility(0);
                    TransmitPostEditActivity.this.iwV.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iwT, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.ciA.akq();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwN);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwR);
                }
            });
            this.iwU = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.iwU.setVisibility(0);
                this.iwS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iwS.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iwT, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.ciA.akq();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqL());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqK());
                    }
                });
            }
            this.iwT = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iwT.a(this);
            this.iwT.setMaxHeight(l.h(getActivity(), d.e.ds510));
            this.iwT.setOutsideTouchable(true);
            this.iwT.setFocusable(true);
            this.iwT.setOnDismissListener(this);
            this.iwT.setBackgroundDrawable(al.getDrawable(d.C0236d.cp_bg_line_d));
            int color = al.getColor(d.C0236d.cp_cont_b);
            int color2 = al.getColor(d.C0236d.cp_cont_c);
            al.k(this.iwS, d.C0236d.cp_bg_line_d);
            al.c(this.iwU, d.f.icon_frs_arrow_n);
            this.iwS.setTextColor(color);
            this.jsN.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jsN.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iwT.addView(writePrefixItemLayout);
            }
            this.iwT.setCurrentIndex(0);
            this.iwS.setText(prefixs.get(1));
            By(1);
            return;
        }
        this.iwV.setVisibility(8);
    }

    protected void cqH() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jth.a(TransmitPostEditActivity.this.iwN, TransmitPostEditActivity.this.iwR)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jth.cnZ());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqL());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqK());
                    TransmitPostEditActivity.this.ciA.akq();
                    TiebaStatic.log(new am("c12608").T("obj_locate", 7));
                    TransmitPostEditActivity.this.cqR();
                }
            }
        });
    }

    protected void cbq() {
        this.iwN = (EditText) findViewById(d.g.post_title);
        this.iwN.setOnClickListener(this.jtl);
        this.iwN.setOnFocusChangeListener(this.iwL);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.iwN.setText(this.mData.getTitle());
            this.iwN.setSelection(this.mData.getTitle().length());
        }
        this.iwN.addTextChangedListener(this.jtn);
        if (!this.mData.getHaveDraft()) {
            cqD();
        }
        this.iwN.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void cbs() {
        this.iwR = (EditText) findViewById(d.g.post_content);
        this.iwR.setDrawingCacheEnabled(false);
        this.iwR.setOnClickListener(this.jtl);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.anp().ax(getPageContext().getPageActivity(), this.mData.getContent());
            this.iwR.setText(ax);
            this.iwR.setSelection(ax.length());
        }
        this.iwR.setOnFocusChangeListener(this.iwL);
        this.iwR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.ciA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iwR.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwR.addTextChangedListener(this.jto);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iwR.setHint(d.j.share_video_default);
        } else {
            this.iwR.setHint(d.j.share_txt_default);
        }
    }

    private void cqI() {
        this.Zh = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.Zh.setVisibility(0);
        this.Zh.b(this.mOriginalThreadInfo);
        this.Zh.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqJ() {
        int i = 5000;
        if (this.jsP != null) {
            i = 1000;
        }
        return cqK().getText() != null && cqK().getText().length() >= i;
    }

    private void oM(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jsG)) {
                this.jsG = "";
                cqK().requestFocus();
                if (cqK().getText() != null && cqK().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqK().getSelectionStart();
                    editable = cqK().getText();
                }
            } else if ("from_title".equals(this.jsG)) {
                this.jsG = "";
                cqL().requestFocus();
                if (cqL().getText() != null && cqL().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqL().getSelectionStart();
                    editable = cqL().getText();
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
        if (((ImageSpan[]) cqK().getText().getSpans(0, cqK().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jsO == null) {
                this.jsO = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.jsO.show();
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
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cqK().getSelectionStart(), aVar, agt);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cqK() != null && cqK().getText() != null) {
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
                int selectionStart = cqK().getSelectionStart() - 1;
                if (cqK().getText().length() > 1 && selectionStart >= 0 && cqK().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cqK().getText().insert(cqK().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cqK().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cqK().getText().insert(cqK().getSelectionStart(), spannableString2);
            }
            Editable text = cqK().getText();
            if (text != null) {
                this.jte.clear();
                this.jte.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jte);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cqK().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cqK().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cqK().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqK() {
        return this.iwR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqL() {
        return this.iwN;
    }

    protected void cqM() {
        Editable text;
        if (cqK() != null && (text = cqK().getText()) != null) {
            int selectionStart = cqK().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqK().onKeyDown(67, this.eHG);
            }
            cqK().onKeyDown(67, this.eHG);
            int selectionStart2 = cqK().getSelectionStart();
            this.jte.clear();
            this.jte.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jte);
            cqK().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.csN.e(null);
        this.csN.hG(d.j.sending);
        this.csN.dJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.csN.dJ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbr() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cqL() != null) {
                str = cqL().getText().toString();
            }
            if (cqK() != null) {
                str2 = cqK().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.iwv == 0) {
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
                if (!this.jtb) {
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
        al.c(this.mPost, d.C0236d.cp_link_tip_a, d.C0236d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.cke = new NewWriteModel(this);
        this.cke.b(this.cks);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cbj();
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
                this.jsP = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jsP != null);
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
            this.fxv = bundle.getString("KEY_CALL_FROM");
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
            this.jsP = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jsP != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fxv = intent.getStringExtra("KEY_CALL_FROM");
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
            this.jsI = true;
        }
        cqE();
    }

    private void cqN() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iwN.setText(com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName)));
            this.iwN.setMovementMethod(com.baidu.tieba.view.c.cmX());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString pv = com.baidu.tbadk.plugins.b.pv(com.baidu.tbadk.plugins.b.pw(hotTopicBussinessData.mTopicName));
            if (pv != null) {
                this.iwN.setText(pv);
            }
            this.jtd.setText(hotTopicBussinessData.mForumName);
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
        if (this.jsP != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jsP));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fxv);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cqK().getEditableText().toString();
        if (obj != null) {
            cqK().setText(TbFaceManager.anp().a(getPageContext().getPageActivity(), obj, this.jtj));
            cqK().setSelection(cqK().getText().length());
        }
    }

    private String cqO() {
        if (cqK() == null || cqK().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cqK().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return cqK().getText().toString();
    }

    private String cqP() {
        if (this.mData == null || cqL() == null || cqL().getVisibility() != 0 || cqL().getText() == null) {
            return "";
        }
        String obj = cqL().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) > 0 && this.iwv != 0 && this.mData.getType() != 4 && this.iwS != null && this.iwS.getText() != null) {
            obj = this.iwS.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void cqQ() {
        cbj();
        this.mData.setContent(cqO());
        this.mData.setTitle(cqP());
        if (this.jsW >= 0) {
            this.mData.setCategoryFrom(this.jsW);
        }
        if (this.jsY >= 0) {
            this.mData.setCategoryTo(this.jsY);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.ckd != null && this.ckd.aNG());
        this.cke.qd(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.T(this.mList) && this.jtc != null && this.jtc.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jtc.mForumId));
            this.mData.setForumName(this.jtc.mForumName);
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
            if (this.jsP != null) {
                i2 = this.jsP.getTotalCount();
                i = this.jsP.getAlreadyCount() + 1;
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
                if (this.ciA != null && !this.ciA.alW()) {
                    cqK().requestFocus();
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
                            cqK().getText().insert(cqK().getSelectionStart(), sb.toString());
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
                        if (this.jsH) {
                            sb2.append(com.baidu.tbadk.plugins.b.csk);
                            this.jsH = false;
                        }
                        sb2.append(stringExtra);
                        oM(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.T(this.mList) && !com.baidu.tbadk.core.util.v.T(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.jtc = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.jtc);
            }
        } else if (i2 == 0) {
            if (this.ciA != null && !this.ciA.alW()) {
                this.iwR.requestFocus();
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
                        this.jth.El(postWriteCallBackData.getErrorString());
                        this.jth.aE(postWriteCallBackData.getSensitiveWords());
                        this.jth.b(this.iwN, this.iwR);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.jsG)) {
                        cqL().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jsG)) {
                        cqK().requestFocus();
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
    public void cqR() {
        if ("1".equals(this.fxv)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fxv)) {
            this.mData.setCanNoForum(false);
        }
        cqS();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.fxv);
        cqQ();
    }

    private void cqS() {
        if (this.ciA != null) {
            this.ciA.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cqL());
        HidenSoftKeyPad(this.mInputManager, cqK());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.fae) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLj));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jsP == null) {
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

    private void cqT() {
        if (!this.jtb && this.ciA != null) {
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
        if (i < this.jsN.size()) {
            for (int i2 = 0; i2 < this.jsN.size(); i2++) {
                this.jsN.get(i2).qY(false);
            }
            this.jsN.get(i).qY(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void yZ(int i) {
        this.iwv = i;
        this.iwT.setCurrentIndex(i);
        By(i);
        this.iwS.setText(this.mPrefixData.getPrefixs().get(i));
        cbr();
        com.baidu.adp.lib.g.g.a(this.iwT, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iwV.setSelected(false);
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
            amw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jtg = z;
        if (this.jtf != null && !z) {
            this.jtf.aWQ();
        }
        if (this.jti != null && !z) {
            cqw();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jtg && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jsH = false;
            this.jsG = "";
            if ("from_content".equals(str)) {
                this.jsG = "from_content";
            } else if ("from_title".equals(str)) {
                this.jsG = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.pu(String.valueOf(charSequence.charAt(i)))) {
                rh(false);
            }
        }
    }

    public void bXu() {
        if (!com.baidu.tbadk.core.util.v.T(this.mList)) {
            this.jsK.setVisibility(0);
            this.jsK.requestFocus();
            this.ciA.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jsK.setVisibility(8);
    }
}
