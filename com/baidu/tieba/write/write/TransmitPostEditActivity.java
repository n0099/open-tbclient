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
    private EditorTools ciC;
    private LocationModel ckf;
    private NewWriteModel ckg;
    private boolean isPrivacy;
    private int ivY;
    private TextView iwv;
    private com.baidu.tieba.write.h iww;
    private ImageView iwx;
    private View iwy;
    private TextView jsA;
    private TextView jsB;
    List<v> jsC;
    v jsD;
    private int jsE;
    private String jsF;
    private int jsG;
    private PostCategoryView jsH;
    private HotTopicBussinessData jsK;
    private TextView jsL;
    private com.baidu.tieba.write.editor.b jsN;
    private e jsQ;
    private com.baidu.tieba.view.b jsX;
    private LinearLayout jsr;
    private LinearLayout jss;
    private View jsu;
    private Toast jsw;
    private AdditionData jsx;
    private RelativeLayout jsy;
    private TextView jsz;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String jso = "";
    private boolean jsp = false;
    private WriteData mData = null;
    private boolean jsq = false;
    private InputMethodManager mInputManager = null;
    private EditText iwq = null;
    private View iwr = null;
    private LinearLayout iwt = null;
    private EditText iwu = null;
    private FeedBackModel jst = null;
    private ArrayList<WritePrefixItemLayout> jsv = new ArrayList<>();
    private final KeyEvent eHo = new KeyEvent(0, 67);
    private View bWb = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String ckk = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int ckl = 0;
    private View mRootView = null;
    private ScrollView jsI = null;
    private boolean jsJ = false;
    private com.baidu.tbadk.core.view.b csM = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String fxi = "2";
    private SpannableStringBuilder jsM = new SpannableStringBuilder();
    private boolean jsO = false;
    private final b jsP = new b();
    private TbFaceManager.a jsR = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan pf(String str) {
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
    private final AntiHelper.a eZP = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLm));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLm));
        }
    };
    private final NewWriteModel.d cku = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.jsP.aE(null);
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
                    TransmitPostEditActivity.this.jsP.Ei(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.jsP.aE(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.jsP.b(TransmitPostEditActivity.this.iwq, TransmitPostEditActivity.this.iwu);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agB());
                    if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agA())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a cks = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void amG() {
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
            if (aVar != null && !StringUtils.isNull(aVar.ceS())) {
                TransmitPostEditActivity.this.b(2, true, aVar.ceS());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener iIg = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.ckf.qb(false);
                    TransmitPostEditActivity.this.ckf.ea(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.ckf.qb(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener jsS = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener jsT = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int cqt = TransmitPostEditActivity.this.cqt();
            if (cqt >= 0 && cqt < TransmitPostEditActivity.this.iwu.getText().length()) {
                TransmitPostEditActivity.this.iwu.setSelection(cqt);
            }
        }
    };
    private boolean jsU = true;
    private final View.OnFocusChangeListener iwo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.iwq || view == TransmitPostEditActivity.this.bWb || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.jsU = true;
                    TransmitPostEditActivity.this.cqu();
                    if (TransmitPostEditActivity.this.ciC != null) {
                        TransmitPostEditActivity.this.ciC.akm();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iwq);
                } else if (view == TransmitPostEditActivity.this.iwq) {
                    TransmitPostEditActivity.this.iwv.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.iwu && z) {
                TransmitPostEditActivity.this.jsU = false;
                TransmitPostEditActivity.this.cqu();
                TransmitPostEditActivity.this.ciC.akm();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.iwu);
            }
            TransmitPostEditActivity.this.cqA();
        }
    };
    private TextWatcher jsV = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String jsZ = "";
        private String jta;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jta = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jta != null ? this.jta.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cbp();
            TransmitPostEditActivity.this.cqB();
            EditText cqM = TransmitPostEditActivity.this.cqM();
            if (editable != null && cqM != null && cqM.getText() != null) {
                if (this.jsZ == null || !this.jsZ.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jsP != null) {
                        this.jsZ = cqM.getText().toString();
                        TransmitPostEditActivity.this.jsP.o(cqM);
                        return;
                    }
                    return;
                }
                cqM.setSelection(cqM.getSelectionEnd());
            }
        }
    };
    private TextWatcher jsW = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String jta;
        private String jtb = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.jta = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.jta != null ? this.jta.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.cbp();
            EditText cqL = TransmitPostEditActivity.this.cqL();
            if (editable != null && cqL != null && cqL.getText() != null) {
                int selectionEnd = cqL.getSelectionEnd();
                if (this.jtb == null || !this.jtb.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.jsP != null) {
                        this.jtb = cqL.getText().toString();
                        TransmitPostEditActivity.this.jsP.o(cqL);
                        return;
                    }
                    return;
                }
                cqL.setSelection(selectionEnd);
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
    public void amr() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void ams() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amu();
        } else if (this.ckf.ceZ()) {
            amr();
        } else {
            this.ckf.qb(false);
            b(1, true, null);
            this.ckf.ceX();
        }
    }

    private void amu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gC(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.ckf.aNy();
                } else {
                    TransmitPostEditActivity.this.cks.amG();
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
        aVar.aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqt() {
        int selectionEnd = cqL().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) cqL().getText().getSpans(0, cqL().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = cqL().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = cqL().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqu() {
        if (this.ciC != null) {
            this.ciC.setBarLauncherEnabled(!this.jsU);
            this.ciC.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jsJ) {
            this.iwq.setVisibility(8);
            cbp();
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
        this.ckf = new LocationModel(this);
        this.ckf.a(this.cks);
        registerListener(this.iIg);
        registerListener(this.jsS);
        initEditor();
        this.iwu.requestFocus();
        bXs();
        cqU();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.ciC = new EditorTools(getActivity());
        this.ciC.setBarMaxLauCount(4);
        this.ciC.setMoreButtonAtEnd(true);
        this.ciC.setBarLauncherType(1);
        this.ciC.eH(true);
        this.ciC.eI(true);
        this.ciC.setMoreLauncherIcon(d.f.write_more);
        this.ciC.setBackgroundColorId(d.C0277d.cp_bg_line_d);
        cqv();
        this.ciC.alQ();
        if (this.jsr != null) {
            this.jsr.addView(this.ciC);
        }
        cqw();
        this.ciC.qT();
        com.baidu.tbadk.editortools.g js = this.ciC.js(6);
        if (js != null && !TextUtils.isEmpty(this.ckk)) {
            ((View) js).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.ckk);
                }
            });
        }
        if (!this.jsJ) {
            this.ciC.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.ciC.akm();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.ciC.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.ciC.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        cqy();
    }

    private void cqv() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.cjk = d.f.write_at;
        this.ciC.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.ciC.b(aVar2);
        aVar2.cjk = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.cjm = 4;
            kVar.cjk = d.f.icon_post_location_selector;
            this.ciC.b(kVar);
        }
        if (this.jsx == null) {
            if (this.jsN == null) {
                this.jsN = new com.baidu.tieba.write.editor.b(getActivity(), this.fxi);
                this.jsN.cpt();
                this.jsN.setFrom("from_share_write");
                this.jsN.bw(this.mData.getForumId(), this.mPrivateThread);
            }
            this.ciC.b(this.jsN);
        }
        this.ciC.ab(arrayList);
        com.baidu.tbadk.editortools.k jv = this.ciC.jv(5);
        if (jv != null) {
            jv.cjm = 1;
            jv.cjk = d.f.write_emotion;
        }
    }

    private void cqw() {
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
                        if (TransmitPostEditActivity.this.cqK()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.cqK()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.e((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.cqN();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.cbp();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.jsx == null) {
                            TransmitPostEditActivity.this.amv();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.ckl) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.cR(pageActivity)) {
                                    TransmitPostEditActivity.this.ams();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.amr();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.ckf != null) {
                            TransmitPostEditActivity.this.ckf.qb(true);
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
                            TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.ciC.alS()) {
                                        TransmitPostEditActivity.this.ciC.akm();
                                        TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.cbp();
                        if (TransmitPostEditActivity.this.iwu != null) {
                            TransmitPostEditActivity.this.iwu.requestFocus();
                        }
                        TransmitPostEditActivity.this.ciC.akm();
                        TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwu);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.jsp = true;
                        TransmitPostEditActivity.this.rh(true);
                        if (TransmitPostEditActivity.this.cqM().isFocused()) {
                            TransmitPostEditActivity.this.jso = "from_title";
                        } else if (TransmitPostEditActivity.this.cqL().isFocused()) {
                            TransmitPostEditActivity.this.jso = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.jss.setVisibility(0);
                        TransmitPostEditActivity.this.jss.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.jss.hasFocus()) {
                            TransmitPostEditActivity.this.iwu.requestFocus();
                            TransmitPostEditActivity.this.iwu.setSelection(TransmitPostEditActivity.this.iwu.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.jss.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.ciC.setActionListener(31, bVar);
        this.ciC.setActionListener(16, bVar);
        this.ciC.setActionListener(14, bVar);
        this.ciC.setActionListener(24, bVar);
        this.ciC.setActionListener(3, bVar);
        this.ciC.setActionListener(10, bVar);
        this.ciC.setActionListener(11, bVar);
        this.ciC.setActionListener(12, bVar);
        this.ciC.setActionListener(13, bVar);
        this.ciC.setActionListener(15, bVar);
        this.ciC.setActionListener(18, bVar);
        this.ciC.setActionListener(20, bVar);
        this.ciC.setActionListener(25, bVar);
        this.ciC.setActionListener(27, bVar);
        this.ciC.setActionListener(29, bVar);
        this.ciC.setActionListener(43, bVar);
        this.ciC.setActionListener(45, bVar);
        this.ciC.setActionListener(53, bVar);
        this.ciC.setActionListener(48, bVar);
        this.ciC.setActionListener(46, bVar);
        this.ciC.setActionListener(49, bVar);
        this.ciC.setActionListener(47, bVar);
        this.ciC.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amv() {
        if (this.ckf.aNu()) {
            if (this.ckf.ceZ()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.ceV().getLocationData().ceS());
                return;
            }
            b(1, true, null);
            this.ckf.ceX();
            return;
        }
        b(0, true, null);
    }

    protected void cbh() {
        if (this.ckg != null) {
            this.ckg.cancelLoadData();
        }
        if (this.jst != null) {
            this.jst.cancelLoadData();
        }
        if (this.ckf != null) {
            this.ckf.cancelLoadData();
        }
    }

    private void cqx() {
        if (this.jsQ != null) {
            this.jsQ.hideTip();
        }
    }

    private void cqy() {
        if (this.jsQ == null) {
            this.jsQ = new e(getPageContext());
        }
        this.jsQ.c(this.ciC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cqx();
        TiebaPrepareImageService.StopService();
        cbh();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqz() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(cqM().getText().toString());
        this.mData.setContent(cqL().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.iww != null && this.iww.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.iww, getPageContext().getPageActivity());
                return true;
            } else if (this.ciC.alS()) {
                this.ciC.akm();
                return true;
            } else {
                cbh();
                cqz();
                return true;
            }
        }
        if (i == 67 && (text = cqL().getText()) != null) {
            int selectionStart = cqL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqL().onKeyDown(67, this.eHo);
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
        cqu();
        al.l(this.iwr, d.C0277d.cp_bg_line_c);
        al.l(cqM(), d.C0277d.cp_bg_line_d);
        al.l(cqL(), d.C0277d.cp_bg_line_d);
        cbp();
        this.ciC.onChangeSkinType(i);
        if (this.jsH != null) {
            this.jsH.aeH();
        }
        al.j(this.mName, d.C0277d.cp_cont_b);
        cqA();
        cqB();
        if (this.jsP != null) {
            this.jsP.c(cqM(), cqL());
        }
        this.Zi.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqA() {
        if (this.iwq.hasFocus()) {
            this.iwq.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwq.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
        if (this.iwu.hasFocus()) {
            this.iwu.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        } else {
            this.iwu.setHintTextColor(al.getColor(d.C0277d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqB() {
        if (this.iwq != null) {
            if (this.iwq.getText().toString().length() == 0) {
                this.iwq.getPaint().setFakeBoldText(false);
            } else if (this.iwq.getText().toString().length() > 0) {
                this.iwq.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.csM = new com.baidu.tbadk.core.view.b(getPageContext());
        this.jsJ = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.j(this.mName, d.C0277d.cp_cont_b);
        cqD();
        this.jsI = (ScrollView) findViewById(d.g.write_scrollview);
        this.jsI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.iwu != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.iwu);
                    }
                    if (TransmitPostEditActivity.this.ciC != null) {
                        TransmitPostEditActivity.this.ciC.akm();
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
        this.jsr = (LinearLayout) findViewById(d.g.tool_view);
        this.jsr.setContentDescription("..");
        this.jss = (LinearLayout) findViewById(d.g.title_view);
        this.iwr = findViewById(d.g.interval_view);
        this.jsL = (TextView) findViewById(d.g.hot_topic_title_edt);
        cbo();
        if (this.jsJ) {
            this.jsI.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        cbq();
        cqJ();
        this.iwt = (LinearLayout) findViewById(d.g.post_content_container);
        this.iwt.setDrawingCacheEnabled(false);
        this.iwt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.iwu.requestFocus();
            }
        });
        this.bWb.setOnFocusChangeListener(this.iwo);
        this.bWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.cbh();
                TransmitPostEditActivity.this.cqz();
            }
        });
        cqG();
        cqI();
        cqC();
        cqu();
        cqH();
        cbn();
        cqO();
        if (this.mData.getType() == 4 && this.iwy != null && this.jsu != null) {
            this.iwy.setVisibility(8);
            this.jsu.setVisibility(8);
        }
        cbp();
        ShowSoftKeyPad(this.mInputManager, this.iwq);
    }

    private void cqC() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.fxi != null && this.fxi.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.fxi != null && this.fxi.equals("2")) {
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
                    this.iwq.setVisibility(0);
                    this.iwu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.iwu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.iwu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.iwq.setVisibility(8);
                    return;
            }
        }
    }

    private void cqD() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.iwo);
    }

    private void cqE() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.jsq && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String f = ap.f(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(f) && cqM() != null) {
                cqM().setText(f);
                cqM().setSelection(f.length());
            }
        }
    }

    private void cqF() {
        this.jsC = null;
        this.jsE = -1;
        this.jsG = -1;
        com.baidu.tieba.frs.x ql = w.beh().ql(1);
        if (ql != null) {
            this.jsC = ql.fcr;
            this.jsE = getIntent().getIntExtra("category_id", -1);
            if (this.jsC != null && !this.jsC.isEmpty() && this.jsE >= 0) {
                this.jsD = new v();
                this.jsD.fcn = 0;
                this.jsD.name = getPageContext().getResources().getString(d.j.category_auto);
                this.jsG = this.jsD.fcn;
                this.jsF = this.jsD.name;
                for (v vVar : this.jsC) {
                    if (vVar.fcn == this.jsE) {
                        this.jsG = vVar.fcn;
                        this.jsF = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void cqG() {
        if (this.jsC != null && !this.jsC.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.jsH = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.jsH.setText(this.jsF);
            this.jsH.setCategoryContainerData(this.jsC, this.jsD, this.jsG);
            this.jsH.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.jsH.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.fcn);
                        TransmitPostEditActivity.this.jsG = arVar.fcn;
                        TransmitPostEditActivity.this.jsH.cqh();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.jsH.cqg();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqM());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqL());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.jsX = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.jsX.setTitle(d.j.no_disturb_start_time);
        this.jsX.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.jsX);
        this.jsX.setButton(-2, getPageContext().getString(d.j.cancel), this.jsX);
        return this.jsX;
    }

    private void cqH() {
        this.jsy = (RelativeLayout) findViewById(d.g.addition_container);
        this.jsz = (TextView) findViewById(d.g.addition_create_time);
        this.jsA = (TextView) findViewById(d.g.addition_last_time);
        this.jsB = (TextView) findViewById(d.g.addition_last_content);
        if (this.jsx != null) {
            this.jsy.setVisibility(0);
            this.jsz.setText(getPageContext().getString(d.j.write_addition_create) + ap.ao(this.jsx.getCreateTime() * 1000));
            if (this.jsx.getAlreadyCount() == 0) {
                this.jsA.setVisibility(8);
            } else {
                this.jsA.setText(getPageContext().getString(d.j.write_addition_last) + ap.ao(this.jsx.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.jsx.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.jsB.setText(lastAdditionContent);
            } else {
                this.jsB.setVisibility(8);
            }
            cqL().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.jsx.getAlreadyCount()), Integer.valueOf(this.jsx.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.jsy.setVisibility(8);
    }

    private void cbn() {
        this.iwy = findViewById(d.g.post_prefix_layout);
        this.iwv = (TextView) findViewById(d.g.post_prefix);
        this.jsu = findViewById(d.g.prefix_divider);
        this.iwx = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.iwy.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ivY = 1;
            this.iwy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.iwv.setVisibility(0);
                    TransmitPostEditActivity.this.iwy.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iww, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.ciC.akm();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwq);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.iwu);
                }
            });
            this.iwx = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.iwx.setVisibility(0);
                this.iwv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.iwv.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.iww, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.ciC.akm();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqM());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqL());
                    }
                });
            }
            this.iww = new com.baidu.tieba.write.h(getPageContext().getPageActivity());
            this.iww.a(this);
            this.iww.setMaxHeight(l.h(getActivity(), d.e.ds510));
            this.iww.setOutsideTouchable(true);
            this.iww.setFocusable(true);
            this.iww.setOnDismissListener(this);
            this.iww.setBackgroundDrawable(al.getDrawable(d.C0277d.cp_bg_line_d));
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_cont_c);
            al.k(this.iwv, d.C0277d.cp_bg_line_d);
            al.c(this.iwx, d.f.icon_frs_arrow_n);
            this.iwv.setTextColor(color);
            this.jsv.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.jsv.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.iww.addView(writePrefixItemLayout);
            }
            this.iww.setCurrentIndex(0);
            this.iwv.setText(prefixs.get(1));
            Bu(1);
            return;
        }
        this.iwy.setVisibility(8);
    }

    protected void cqI() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.jsP.a(TransmitPostEditActivity.this.iwq, TransmitPostEditActivity.this.iwu)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.jsP.coa());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqM());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.cqL());
                    TransmitPostEditActivity.this.ciC.akm();
                    TiebaStatic.log(new am("c12608").T("obj_locate", 7));
                    TransmitPostEditActivity.this.cqS();
                }
            }
        });
    }

    protected void cbo() {
        this.iwq = (EditText) findViewById(d.g.post_title);
        this.iwq.setOnClickListener(this.jsT);
        this.iwq.setOnFocusChangeListener(this.iwo);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.iwq.setText(this.mData.getTitle());
            this.iwq.setSelection(this.mData.getTitle().length());
        }
        this.iwq.addTextChangedListener(this.jsV);
        if (!this.mData.getHaveDraft()) {
            cqE();
        }
        this.iwq.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void cbq() {
        this.iwu = (EditText) findViewById(d.g.post_content);
        this.iwu.setDrawingCacheEnabled(false);
        this.iwu.setOnClickListener(this.jsT);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ax = TbFaceManager.anl().ax(getPageContext().getPageActivity(), this.mData.getContent());
            this.iwu.setText(ax);
            this.iwu.setSelection(ax.length());
        }
        this.iwu.setOnFocusChangeListener(this.iwo);
        this.iwu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.ciC.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.iwu.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.iwu.addTextChangedListener(this.jsW);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.iwu.setHint(d.j.share_video_default);
        } else {
            this.iwu.setHint(d.j.share_txt_default);
        }
    }

    private void cqJ() {
        this.Zi = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.Zi.setVisibility(0);
        this.Zi.b(this.mOriginalThreadInfo);
        this.Zi.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqK() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.jsx != null) {
            i = 1000;
        }
        return cqL().getText() != null && cqL().getText().length() >= i;
    }

    private void oN(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.jso)) {
                this.jso = "";
                cqL().requestFocus();
                if (cqL().getText() != null && cqL().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqL().getSelectionStart();
                    editable = cqL().getText();
                }
            } else if ("from_title".equals(this.jso)) {
                this.jso = "";
                cqM().requestFocus();
                if (cqM().getText() != null && cqM().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = cqM().getSelectionStart();
                    editable = cqM().getText();
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
        if (((ImageSpan[]) cqL().getText().getSpans(0, cqL().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.jsw == null) {
                this.jsw = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.jsw.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType agq = pVar.agq();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jB().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.cqL().getSelectionStart(), aVar, agq);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && cqL() != null && cqL().getText() != null) {
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
                int selectionStart = cqL().getSelectionStart() - 1;
                if (cqL().getText().length() > 1 && selectionStart >= 0 && cqL().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    cqL().getText().insert(cqL().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            cqL().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                cqL().getText().insert(cqL().getSelectionStart(), spannableString2);
            }
            Editable text = cqL().getText();
            if (text != null) {
                this.jsM.clear();
                this.jsM.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.jsM);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && cqL().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    cqL().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                cqL().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqL() {
        return this.iwu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText cqM() {
        return this.iwq;
    }

    protected void cqN() {
        Editable text;
        if (cqL() != null && (text = cqL().getText()) != null) {
            int selectionStart = cqL().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                cqL().onKeyDown(67, this.eHo);
            }
            cqL().onKeyDown(67, this.eHo);
            int selectionStart2 = cqL().getSelectionStart();
            this.jsM.clear();
            this.jsM.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.jsM);
            cqL().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.csM.e(null);
        this.csM.hF(d.j.sending);
        this.csM.dJ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.csM.dJ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbp() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (cqM() != null) {
                str = cqM().getText().toString();
            }
            if (cqL() != null) {
                str2 = cqL().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.ivY == 0) {
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
                if (!this.jsJ) {
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
        this.ckg = new NewWriteModel(this);
        this.ckg.b(this.cku);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.cbh();
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
                this.jsx = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.jsx != null);
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
            this.fxi = bundle.getString("KEY_CALL_FROM");
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
            this.jsx = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.jsx != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.fxi = intent.getStringExtra("KEY_CALL_FROM");
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
            this.jsq = true;
        }
        cqF();
    }

    private void cqO() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.iwq.setText(com.baidu.tbadk.plugins.b.pw(com.baidu.tbadk.plugins.b.px(hotTopicBussinessData.mTopicName)));
            this.iwq.setMovementMethod(com.baidu.tieba.view.c.cmY());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString pw = com.baidu.tbadk.plugins.b.pw(com.baidu.tbadk.plugins.b.px(hotTopicBussinessData.mTopicName));
            if (pw != null) {
                this.iwq.setText(pw);
            }
            this.jsL.setText(hotTopicBussinessData.mForumName);
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
        if (this.jsx != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.jsx));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.fxi);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = cqL().getEditableText().toString();
        if (obj != null) {
            cqL().setText(TbFaceManager.anl().a(getPageContext().getPageActivity(), obj, this.jsR));
            cqL().setSelection(cqL().getText().length());
        }
    }

    private String cqP() {
        if (cqL() == null || cqL().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(cqL().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return cqL().getText().toString();
    }

    private String cqQ() {
        if (this.mData == null || cqM() == null || cqM().getVisibility() != 0 || cqM().getText() == null) {
            return "";
        }
        String obj = cqM().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.S(this.mPrefixData.getPrefixs()) > 0 && this.ivY != 0 && this.mData.getType() != 4 && this.iwv != null && this.iwv.getText() != null) {
            obj = this.iwv.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void cqR() {
        cbh();
        this.mData.setContent(cqP());
        this.mData.setTitle(cqQ());
        if (this.jsE >= 0) {
            this.mData.setCategoryFrom(this.jsE);
        }
        if (this.jsG >= 0) {
            this.mData.setCategoryTo(this.jsG);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.ckf != null && this.ckf.aNu());
        this.ckg.qd(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.T(this.mList) && this.jsK != null && this.jsK.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.jsK.mForumId));
            this.mData.setForumName(this.jsK.mForumName);
        }
        this.ckg.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.ckg.getWriteData().setVoice(null);
        this.ckg.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kY()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.ckg.startPostWrite();
    }

    private void A(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.jsx != null) {
                i2 = this.jsx.getTotalCount();
                i = this.jsx.getAlreadyCount() + 1;
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
                if (this.ciC != null && !this.ciC.alS()) {
                    cqL().requestFocus();
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
                            cqL().getText().insert(cqL().getSelectionStart(), sb.toString());
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
                        if (this.jsp) {
                            sb2.append(com.baidu.tbadk.plugins.b.csk);
                            this.jsp = false;
                        }
                        sb2.append(stringExtra);
                        oN(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.T(this.mList) && !com.baidu.tbadk.core.util.v.T(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.jsK = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.jsK);
            }
        } else if (i2 == 0) {
            if (this.ciC != null && !this.ciC.alS()) {
                this.iwu.requestFocus();
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
                        this.jsP.Ei(postWriteCallBackData.getErrorString());
                        this.jsP.aE(postWriteCallBackData.getSensitiveWords());
                        this.jsP.b(this.iwq, this.iwu);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.jso)) {
                        cqM().requestFocus();
                        return;
                    } else if ("from_content".equals(this.jso)) {
                        cqL().requestFocus();
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
    public void cqS() {
        if ("1".equals(this.fxi)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.fxi)) {
            this.mData.setCanNoForum(false);
        }
        cqT();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.fxi);
        cqR();
    }

    private void cqT() {
        if (this.ciC != null) {
            this.ciC.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, cqM());
        HidenSoftKeyPad(this.mInputManager, cqL());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.aD(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.eZP) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLm));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.jsx == null) {
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
        this.ckl = i;
        if (this.ciC != null) {
            this.ciC.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void cqU() {
        if (!this.jsJ && this.ciC != null) {
            this.ciC.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.ciC.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (this.ciC != null) {
            this.ciC.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Bu(int i) {
        if (i < this.jsv.size()) {
            for (int i2 = 0; i2 < this.jsv.size(); i2++) {
                this.jsv.get(i2).qY(false);
            }
            this.jsv.get(i).qY(true);
        }
    }

    @Override // com.baidu.tieba.write.h.a
    public void yV(int i) {
        this.ivY = i;
        this.iww.setCurrentIndex(i);
        Bu(i);
        this.iwv.setText(this.mPrefixData.getPrefixs().get(i));
        cbp();
        com.baidu.adp.lib.g.g.a(this.iww, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.iwy.setSelected(false);
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
            ams();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.jsO = z;
        if (this.jsN != null && !z) {
            this.jsN.aWN();
        }
        if (this.jsQ != null && !z) {
            cqx();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.jsO && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.jsp = false;
            this.jso = "";
            if ("from_content".equals(str)) {
                this.jso = "from_content";
            } else if ("from_title".equals(str)) {
                this.jso = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.pv(String.valueOf(charSequence.charAt(i)))) {
                rh(false);
            }
        }
    }

    public void bXs() {
        if (!com.baidu.tbadk.core.util.v.T(this.mList)) {
            this.jss.setVisibility(0);
            this.jss.requestFocus();
            this.ciC.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.jss.setVisibility(8);
    }
}
