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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.d;
import com.baidu.tieba.write.view.PostCategoryView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0062a, d.a {
    private EditorTools aMl;
    private LocationModel aNN;
    private NewWriteModel aNO;
    private OriginalThreadCardView fkk;
    private int gCY;
    private TextView gDv;
    private com.baidu.tieba.write.d gDw;
    private ImageView gDx;
    private View gDy;
    private LinearLayout hyG;
    private LinearLayout hyH;
    private View hyJ;
    private Toast hyL;
    private AdditionData hyM;
    private RelativeLayout hyN;
    private TextView hyO;
    private TextView hyP;
    private TextView hyQ;
    List<x> hyR;
    x hyS;
    private int hyT;
    private String hyU;
    private int hyV;
    private PostCategoryView hyW;
    private HotTopicBussinessData hyZ;
    private TextView hza;
    private com.baidu.tieba.write.editor.b hzc;
    private e hzf;
    private com.baidu.tieba.view.b hzm;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hyD = "";
    private boolean hyE = false;
    private WriteData mData = null;
    private boolean hyF = false;
    private InputMethodManager mInputManager = null;
    private EditText gDq = null;
    private View gDr = null;
    private LinearLayout gDt = null;
    private EditText gDu = null;
    private FeedBackModel hyI = null;
    private ArrayList<WritePrefixItemLayout> hyK = new ArrayList<>();
    private final KeyEvent cVk = new KeyEvent(0, 67);
    private View aAZ = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aNS = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aNT = 0;
    private View mRootView = null;
    private ScrollView hyX = null;
    private boolean hyY = false;
    private com.baidu.tbadk.core.view.a aVY = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String dHW = "2";
    private SpannableStringBuilder hzb = new SpannableStringBuilder();
    private boolean hzd = false;
    private final b hze = new b();
    private TbFaceManager.a hzg = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan ha(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.nb());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.f(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dnt = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arn));
        }
    };
    private final NewWriteModel.d aOc = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hze.az(null);
                if (z) {
                    TransmitPostEditActivity.this.bK(z);
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
                    TransmitPostEditActivity.this.hze.vv(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hze.az(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hze.b(TransmitPostEditActivity.this.gDq, TransmitPostEditActivity.this.gDu);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Cu());
                    if (com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Ct())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aOa = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Ij() {
            TransmitPostEditActivity.this.showToast(d.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gP(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bwJ())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bwJ());
            } else {
                gP(null);
            }
        }
    };
    private final CustomMessageListener gQj = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aNN.mw(false);
                    TransmitPostEditActivity.this.aNN.co(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aNN.mw(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hzh = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hzi = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bHo = TransmitPostEditActivity.this.bHo();
            if (bHo >= 0 && bHo < TransmitPostEditActivity.this.gDu.getText().length()) {
                TransmitPostEditActivity.this.gDu.setSelection(bHo);
            }
        }
    };
    private boolean hzj = true;
    private final View.OnFocusChangeListener gDo = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gDq || view == TransmitPostEditActivity.this.aAZ || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hzj = true;
                    TransmitPostEditActivity.this.bHp();
                    if (TransmitPostEditActivity.this.aMl != null) {
                        TransmitPostEditActivity.this.aMl.FP();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gDq);
                } else if (view == TransmitPostEditActivity.this.gDq) {
                    TransmitPostEditActivity.this.gDv.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gDu && z) {
                TransmitPostEditActivity.this.hzj = false;
                TransmitPostEditActivity.this.bHp();
                TransmitPostEditActivity.this.aMl.FP();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gDu);
            }
            TransmitPostEditActivity.this.bHv();
        }
    };
    private TextWatcher hzk = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hzo = "";
        private String hzp;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzp = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzp != null ? this.hzp.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.brT();
            TransmitPostEditActivity.this.bHw();
            EditText bHH = TransmitPostEditActivity.this.bHH();
            if (editable != null && bHH != null && bHH.getText() != null) {
                if (this.hzo == null || !this.hzo.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hze != null) {
                        this.hzo = bHH.getText().toString();
                        TransmitPostEditActivity.this.hze.k(bHH);
                        return;
                    }
                    return;
                }
                bHH.setSelection(bHH.getSelectionEnd());
            }
        }
    };
    private TextWatcher hzl = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hzp;
        private String hzq = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hzp = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hzp != null ? this.hzp.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.brT();
            EditText bHG = TransmitPostEditActivity.this.bHG();
            if (editable != null && bHG != null && bHG.getText() != null) {
                int selectionEnd = bHG.getSelectionEnd();
                if (this.hzq == null || !this.hzq.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hze != null) {
                        this.hzq = bHG.getText().toString();
                        TransmitPostEditActivity.this.hze.k(bHG);
                        return;
                    }
                    return;
                }
                bHG.setSelection(selectionEnd);
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
    public void HU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void HV() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HX();
        } else if (this.aNN.bwR()) {
            HU();
        } else {
            this.aNN.mw(false);
            b(1, true, null);
            this.aNN.bwP();
        }
    }

    private void HX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cf(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aNN.afU();
                } else {
                    TransmitPostEditActivity.this.aOa.Ij();
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
        aVar.xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHo() {
        int selectionEnd = bHG().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bHG().getText().getSpans(0, bHG().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bHG().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bHG().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHp() {
        if (this.aMl != null) {
            this.aMl.setBarLauncherEnabled(!this.hzj);
            this.aMl.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hyY) {
            this.gDq.setVisibility(8);
            brT();
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
        this.aNN = new LocationModel(this);
        this.aNN.a(this.aOa);
        registerListener(this.gQj);
        registerListener(this.hzh);
        initEditor();
        this.gDu.requestFocus();
        boa();
        bHP();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aMl = new EditorTools(getActivity());
        this.aMl.setBarMaxLauCount(4);
        this.aMl.setMoreButtonAtEnd(true);
        this.aMl.setBarLauncherType(1);
        this.aMl.bC(true);
        this.aMl.bD(true);
        this.aMl.setMoreLauncherIcon(d.f.write_more);
        this.aMl.setBackgroundColorId(d.C0140d.cp_bg_line_d);
        bHq();
        this.aMl.Hu();
        if (this.hyG != null) {
            this.hyG.addView(this.aMl);
        }
        bHr();
        this.aMl.oF();
        com.baidu.tbadk.editortools.g eL = this.aMl.eL(6);
        if (eL != null && !TextUtils.isEmpty(this.aNS)) {
            ((View) eL).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aNS);
                }
            });
        }
        if (!this.hyY) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aMl.FP();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bHt();
    }

    private void bHq() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aMS = d.f.write_at;
        this.aMl.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aMl.b(aVar2);
        aVar2.aMS = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aMU = 4;
            kVar.aMS = d.f.icon_post_location_selector;
            this.aMl.b(kVar);
        }
        if (this.hyM == null) {
            if (this.hzc == null) {
                this.hzc = new com.baidu.tieba.write.editor.b(getActivity(), this.dHW);
                this.hzc.bGs();
                this.hzc.setFrom("from_share_write");
                this.hzc.aP(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aMl.b(this.hzc);
        }
        this.aMl.F(arrayList);
        com.baidu.tbadk.editortools.k eO = this.aMl.eO(5);
        if (eO != null) {
            eO.aMU = 1;
            eO.aMS = d.f.write_emotion;
        }
    }

    private void bHr() {
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
                            TiebaStatic.log(new an("c12608").r("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bHF()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bHF()) {
                            TransmitPostEditActivity.this.showToast(d.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bHI();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.brT();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hyM == null) {
                            TransmitPostEditActivity.this.HY();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aNT) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ac.aN(pageActivity)) {
                                    TransmitPostEditActivity.this.HV();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.HU();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aNN != null) {
                            TransmitPostEditActivity.this.aNN.mw(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.af(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(anVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aMl.Hw()) {
                                        TransmitPostEditActivity.this.aMl.FP();
                                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.brT();
                        if (TransmitPostEditActivity.this.gDu != null) {
                            TransmitPostEditActivity.this.gDu.requestFocus();
                        }
                        TransmitPostEditActivity.this.aMl.FP();
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gDu);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hyE = true;
                        TransmitPostEditActivity.this.nA(true);
                        if (TransmitPostEditActivity.this.bHH().isFocused()) {
                            TransmitPostEditActivity.this.hyD = "from_title";
                        } else if (TransmitPostEditActivity.this.bHG().isFocused()) {
                            TransmitPostEditActivity.this.hyD = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hyH.setVisibility(0);
                        TransmitPostEditActivity.this.hyH.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hyH.hasFocus()) {
                            TransmitPostEditActivity.this.gDu.requestFocus();
                            TransmitPostEditActivity.this.gDu.setSelection(TransmitPostEditActivity.this.gDu.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hyH.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aMl.setActionListener(31, bVar);
        this.aMl.setActionListener(16, bVar);
        this.aMl.setActionListener(14, bVar);
        this.aMl.setActionListener(24, bVar);
        this.aMl.setActionListener(3, bVar);
        this.aMl.setActionListener(10, bVar);
        this.aMl.setActionListener(11, bVar);
        this.aMl.setActionListener(12, bVar);
        this.aMl.setActionListener(13, bVar);
        this.aMl.setActionListener(15, bVar);
        this.aMl.setActionListener(18, bVar);
        this.aMl.setActionListener(20, bVar);
        this.aMl.setActionListener(25, bVar);
        this.aMl.setActionListener(27, bVar);
        this.aMl.setActionListener(29, bVar);
        this.aMl.setActionListener(43, bVar);
        this.aMl.setActionListener(45, bVar);
        this.aMl.setActionListener(53, bVar);
        this.aMl.setActionListener(48, bVar);
        this.aMl.setActionListener(46, bVar);
        this.aMl.setActionListener(49, bVar);
        this.aMl.setActionListener(47, bVar);
        this.aMl.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY() {
        if (this.aNN.afQ()) {
            if (this.aNN.bwR()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bwN().getLocationData().bwJ());
                return;
            }
            b(1, true, null);
            this.aNN.bwP();
            return;
        }
        b(0, true, null);
    }

    protected void brL() {
        if (this.aNO != null) {
            this.aNO.cancelLoadData();
        }
        if (this.hyI != null) {
            this.hyI.cancelLoadData();
        }
        if (this.aNN != null) {
            this.aNN.cancelLoadData();
        }
    }

    private void bHs() {
        if (this.hzf != null) {
            this.hzf.hideTip();
        }
    }

    private void bHt() {
        if (this.hzf == null) {
            this.hzf = new e(getPageContext());
        }
        this.hzf.c(this.aMl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bHs();
        TiebaPrepareImageService.StopService();
        brL();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHu() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bHH().getText().toString());
        this.mData.setContent(bHG().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gDw != null && this.gDw.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gDw, getPageContext().getPageActivity());
                return true;
            } else if (this.aMl.Hw()) {
                this.aMl.FP();
                return true;
            } else {
                brL();
                bHu();
                return true;
            }
        }
        if (i == 67 && (text = bHG().getText()) != null) {
            int selectionStart = bHG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHG().onKeyDown(67, this.cVk);
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
        am.c(this.mPost, d.C0140d.cp_link_tip_a, 1);
        bHp();
        am.j(this.gDr, d.C0140d.cp_bg_line_c);
        am.j(bHH(), d.C0140d.cp_bg_line_d);
        am.j(bHG(), d.C0140d.cp_bg_line_d);
        brT();
        this.aMl.onChangeSkinType(i);
        if (this.hyW != null) {
            this.hyW.AG();
        }
        am.h(this.mName, d.C0140d.cp_cont_b);
        bHv();
        bHw();
        if (this.hze != null) {
            this.hze.c(bHH(), bHG());
        }
        this.fkk.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHv() {
        if (this.gDq.hasFocus()) {
            this.gDq.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        } else {
            this.gDq.setHintTextColor(am.getColor(d.C0140d.cp_cont_d));
        }
        if (this.gDu.hasFocus()) {
            this.gDu.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        } else {
            this.gDu.setHintTextColor(am.getColor(d.C0140d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHw() {
        if (this.gDq != null) {
            if (this.gDq.getText().toString().length() == 0) {
                this.gDq.getPaint().setFakeBoldText(false);
            } else if (this.gDq.getText().toString().length() > 0) {
                this.gDq.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aVY = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hyY = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.h(this.mName, d.C0140d.cp_cont_b);
        bHy();
        this.hyX = (ScrollView) findViewById(d.g.write_scrollview);
        this.hyX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gDu != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gDu);
                    }
                    if (TransmitPostEditActivity.this.aMl != null) {
                        TransmitPostEditActivity.this.aMl.FP();
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
        this.hyG = (LinearLayout) findViewById(d.g.tool_view);
        this.hyG.setContentDescription("..");
        this.hyH = (LinearLayout) findViewById(d.g.title_view);
        this.gDr = findViewById(d.g.interval_view);
        this.hza = (TextView) findViewById(d.g.hot_topic_title_edt);
        brS();
        if (this.hyY) {
            this.hyX.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        brU();
        bHE();
        this.gDt = (LinearLayout) findViewById(d.g.post_content_container);
        this.gDt.setDrawingCacheEnabled(false);
        this.gDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.gDu.requestFocus();
            }
        });
        this.aAZ.setOnFocusChangeListener(this.gDo);
        this.aAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.brL();
                TransmitPostEditActivity.this.bHu();
            }
        });
        bHB();
        bHD();
        bHx();
        bHp();
        bHC();
        brR();
        bHJ();
        if (this.mData.getType() == 4 && this.gDy != null && this.hyJ != null) {
            this.gDy.setVisibility(8);
            this.hyJ.setVisibility(8);
        }
        brT();
        ShowSoftKeyPad(this.mInputManager, this.gDq);
    }

    private void bHx() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.dHW != null && this.dHW.equals("1")) {
                        this.mName.setText(d.j.share_to_home_page);
                    } else if (this.dHW != null && this.dHW.equals("2")) {
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
                    this.gDq.setVisibility(0);
                    this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.j.publish_photo_live);
                    this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.j.send_reply);
                    this.gDu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gDq.setVisibility(8);
                    return;
            }
        }
    }

    private void bHy() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.f(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gDo);
    }

    private void bHz() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hyF && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = ap.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bHH() != null) {
                bHH().setText(d);
                bHH().setSelection(d.length());
            }
        }
    }

    private void bHA() {
        this.hyR = null;
        this.hyT = -1;
        this.hyV = -1;
        z kF = y.avI().kF(1);
        if (kF != null) {
            this.hyR = kF.dpy;
            this.hyT = getIntent().getIntExtra("category_id", -1);
            if (this.hyR != null && !this.hyR.isEmpty() && this.hyT >= 0) {
                this.hyS = new x();
                this.hyS.dpu = 0;
                this.hyS.name = getPageContext().getResources().getString(d.j.category_auto);
                this.hyV = this.hyS.dpu;
                this.hyU = this.hyS.name;
                for (x xVar : this.hyR) {
                    if (xVar.dpu == this.hyT) {
                        this.hyV = xVar.dpu;
                        this.hyU = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bHB() {
        if (this.hyR != null && !this.hyR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hyW = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hyW.setText(this.hyU);
            this.hyW.setCategoryContainerData(this.hyR, this.hyS, this.hyV);
            this.hyW.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.hyW.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dpu);
                        TransmitPostEditActivity.this.hyV = atVar.dpu;
                        TransmitPostEditActivity.this.hyW.bHc();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hyW.bHb();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHH());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHG());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hzm = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hzm.setTitle(d.j.no_disturb_start_time);
        this.hzm.setButton(-1, getPageContext().getString(d.j.alert_yes_button), this.hzm);
        this.hzm.setButton(-2, getPageContext().getString(d.j.cancel), this.hzm);
        return this.hzm;
    }

    private void bHC() {
        this.hyN = (RelativeLayout) findViewById(d.g.addition_container);
        this.hyO = (TextView) findViewById(d.g.addition_create_time);
        this.hyP = (TextView) findViewById(d.g.addition_last_time);
        this.hyQ = (TextView) findViewById(d.g.addition_last_content);
        if (this.hyM != null) {
            this.hyN.setVisibility(0);
            this.hyO.setText(getPageContext().getString(d.j.write_addition_create) + ap.w(this.hyM.getCreateTime() * 1000));
            if (this.hyM.getAlreadyCount() == 0) {
                this.hyP.setVisibility(8);
            } else {
                this.hyP.setText(getPageContext().getString(d.j.write_addition_last) + ap.w(this.hyM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hyM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hyQ.setText(lastAdditionContent);
            } else {
                this.hyQ.setVisibility(8);
            }
            bHG().setHint(String.format(getPageContext().getString(d.j.write_addition_hint), Integer.valueOf(this.hyM.getAlreadyCount()), Integer.valueOf(this.hyM.getTotalCount())));
            this.mName.setText(d.j.write_addition_title);
            return;
        }
        this.hyN.setVisibility(8);
    }

    private void brR() {
        this.gDy = findViewById(d.g.post_prefix_layout);
        this.gDv = (TextView) findViewById(d.g.post_prefix);
        this.hyJ = findViewById(d.g.prefix_divider);
        this.gDx = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gDy.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gCY = 1;
            this.gDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gDv.setVisibility(0);
                    TransmitPostEditActivity.this.gDy.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gDw, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aMl.FP();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gDq);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gDu);
                }
            });
            this.gDx = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gDx.setVisibility(0);
                this.gDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gDv.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gDw, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aMl.FP();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHH());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHG());
                    }
                });
            }
            this.gDw = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gDw.a(this);
            this.gDw.setMaxHeight(l.f(getActivity(), d.e.ds510));
            this.gDw.setOutsideTouchable(true);
            this.gDw.setFocusable(true);
            this.gDw.setOnDismissListener(this);
            this.gDw.setBackgroundDrawable(am.getDrawable(d.C0140d.cp_bg_line_d));
            int color = am.getColor(d.C0140d.cp_cont_b);
            int color2 = am.getColor(d.C0140d.cp_cont_c);
            am.i(this.gDv, d.C0140d.cp_bg_line_d);
            am.c(this.gDx, d.f.icon_frs_arrow_n);
            this.gDv.setTextColor(color);
            this.hyK.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hyK.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gDw.addView(writePrefixItemLayout);
            }
            this.gDw.setCurrentIndex(0);
            this.gDv.setText(prefixs.get(1));
            vG(1);
            return;
        }
        this.gDy.setVisibility(8);
    }

    protected void bHD() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jE()) {
                    TransmitPostEditActivity.this.showToast(d.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hze.a(TransmitPostEditActivity.this.gDq, TransmitPostEditActivity.this.gDu)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hze.bFn());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHH());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bHG());
                    TransmitPostEditActivity.this.aMl.FP();
                    TiebaStatic.log(new an("c12608").r("obj_locate", 7));
                    TransmitPostEditActivity.this.bHN();
                }
            }
        });
    }

    protected void brS() {
        this.gDq = (EditText) findViewById(d.g.post_title);
        this.gDq.setOnClickListener(this.hzi);
        this.gDq.setOnFocusChangeListener(this.gDo);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gDq.setText(this.mData.getTitle());
            this.gDq.setSelection(this.mData.getTitle().length());
        }
        this.gDq.addTextChangedListener(this.hzk);
        if (!this.mData.getHaveDraft()) {
            bHz();
        }
        this.gDq.setHint(getResources().getString(d.j.post_title_hint));
    }

    protected void brU() {
        this.gDu = (EditText) findViewById(d.g.post_content);
        this.gDu.setDrawingCacheEnabled(false);
        this.gDu.setOnClickListener(this.hzi);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString W = TbFaceManager.IP().W(getPageContext().getPageActivity(), this.mData.getContent());
            this.gDu.setText(W);
            this.gDu.setSelection(W.length());
        }
        this.gDu.setOnFocusChangeListener(this.gDo);
        this.gDu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gDu.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gDu.addTextChangedListener(this.hzl);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gDu.setHint(d.j.share_video_default);
        } else {
            this.gDu.setHint(d.j.share_txt_default);
        }
    }

    private void bHE() {
        this.fkk = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.fkk.setVisibility(0);
        this.fkk.b(this.mOriginalThreadInfo);
        this.fkk.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHF() {
        int i = 5000;
        if (this.hyM != null) {
            i = 1000;
        }
        return bHG().getText() != null && bHG().getText().length() >= i;
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hyD)) {
                this.hyD = "";
                bHG().requestFocus();
                if (bHG().getText() != null && bHG().getText().length() + str.length() > 5000) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHG().getSelectionStart();
                    editable = bHG().getText();
                }
            } else if ("from_title".equals(this.hyD)) {
                this.hyD = "";
                bHH().requestFocus();
                if (bHH().getText() != null && bHH().getText().length() + str.length() > 31) {
                    showToast(d.j.over_limit_tip);
                    return;
                } else {
                    i = bHH().getSelectionStart();
                    editable = bHH().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nA(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bHG().getText().getSpans(0, bHG().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hyL == null) {
                this.hyL = Toast.makeText(getPageContext().getPageActivity(), d.j.too_many_face, 0);
            }
            this.hyL.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Cl = nVar.Cl();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ih().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bHG().getSelectionStart(), aVar, Cl);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bHG() != null && bHG().getText() != null) {
            Bitmap nb = aVar.nb();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(nb);
            int width = nb.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, nb.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.f(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bHG().getSelectionStart() - 1;
                if (bHG().getText().length() > 1 && selectionStart >= 0 && bHG().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bHG().getText().insert(bHG().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bHG().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bHG().getText().insert(bHG().getSelectionStart(), spannableString2);
            }
            Editable text = bHG().getText();
            if (text != null) {
                this.hzb.clear();
                this.hzb.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hzb);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bHG().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bHG().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bHG().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHG() {
        return this.gDu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bHH() {
        return this.gDq;
    }

    protected void bHI() {
        Editable text;
        if (bHG() != null && (text = bHG().getText()) != null) {
            int selectionStart = bHG().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bHG().onKeyDown(67, this.cVk);
            }
            bHG().onKeyDown(67, this.cVk);
            int selectionStart2 = bHG().getSelectionStart();
            this.hzb.clear();
            this.hzb.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hzb);
            bHG().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVY.d(null);
        this.aVY.df(d.j.sending);
        this.aVY.aM(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVY.aM(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brT() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bHH() != null) {
                str = bHH().getText().toString();
            }
            if (bHG() != null) {
                str2 = bHG().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gCY == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nB(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nB(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nB(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hyY) {
                    nB(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nB(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nB(true);
            } else if (this.mData.getVideoInfo() != null) {
                nB(true);
            } else {
                nB(false);
            }
        }
    }

    private void nB(boolean z) {
        am.b(this.mPost, d.C0140d.cp_link_tip_a, d.C0140d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aNO = new NewWriteModel(this);
        this.aNO.b(this.aOc);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.brL();
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
                this.hyM = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hyM != null);
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
            this.dHW = bundle.getString("KEY_CALL_FROM");
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
            this.hyM = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hyM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.dHW = intent.getStringExtra("KEY_CALL_FROM");
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
            this.hyF = true;
        }
        bHA();
    }

    private void bHJ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gDq.setText(com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName)));
            this.gDq.setMovementMethod(com.baidu.tieba.view.c.bEr());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString hp = com.baidu.tbadk.plugins.b.hp(com.baidu.tbadk.plugins.b.hq(hotTopicBussinessData.mTopicName));
            if (hp != null) {
                this.gDq.setText(hp);
            }
            this.hza.setText(hotTopicBussinessData.mForumName);
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
        if (this.hyM != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hyM));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dHW);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bHG().getEditableText().toString();
        if (obj != null) {
            bHG().setText(TbFaceManager.IP().a(getPageContext().getPageActivity(), obj, this.hzg));
            bHG().setSelection(bHG().getText().length());
        }
    }

    private String bHK() {
        if (bHG() == null || bHG().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bHG().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.j.share_video_default);
            }
            return getString(d.j.share_txt_default);
        }
        return bHG().getText().toString();
    }

    private String bHL() {
        if (this.mData == null || bHH() == null || bHH().getVisibility() != 0 || bHH().getText() == null) {
            return "";
        }
        String obj = bHH().getText().toString();
        if (this.mPrefixData != null && w.y(this.mPrefixData.getPrefixs()) > 0 && this.gCY != 0 && this.mData.getType() != 4 && this.gDv != null && this.gDv.getText() != null) {
            obj = this.gDv.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bHM() {
        brL();
        this.mData.setContent(bHK());
        this.mData.setTitle(bHL());
        if (this.hyT >= 0) {
            this.mData.setCategoryFrom(this.hyT);
        }
        if (this.hyV >= 0) {
            this.mData.setCategoryTo(this.hyV);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aNN != null && this.aNN.afQ());
        this.aNO.my(this.writeImagesInfo.size() > 0);
        if (!w.z(this.mList) && this.hyZ != null && this.hyZ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hyZ.mForumId));
            this.mData.setForumName(this.hyZ.mForumName);
        }
        this.aNO.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aNO.getWriteData().setVoice(null);
        this.aNO.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.jE()) {
            showToast(d.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.j.sending), this.mDialogCancelListener);
        this.aNO.startPostWrite();
    }

    private void r(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hyM != null) {
                i2 = this.hyM.getTotalCount();
                i = this.hyM.getAlreadyCount() + 1;
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
                if (this.aMl != null && !this.aMl.Hw()) {
                    bHG().requestFocus();
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
                            bHG().getText().insert(bHG().getSelectionStart(), sb.toString());
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
                        if (this.hyE) {
                            sb2.append(com.baidu.tbadk.plugins.b.aVv);
                            this.hyE = false;
                        }
                        sb2.append(stringExtra);
                        gG(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !w.z(this.mList) && !w.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hyZ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hyZ);
            }
        } else if (i2 == 0) {
            if (this.aMl != null && !this.aMl.Hw()) {
                this.gDu.requestFocus();
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
                        this.hze.vv(postWriteCallBackData.getErrorString());
                        this.hze.az(postWriteCallBackData.getSensitiveWords());
                        this.hze.b(this.gDq, this.gDu);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hyD)) {
                        bHH().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hyD)) {
                        bHG().requestFocus();
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
    public void bHN() {
        if ("1".equals(this.dHW)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dHW)) {
            this.mData.setCanNoForum(false);
        }
        bHO();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.dHW);
        bHM();
    }

    private void bHO() {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bHH());
        HidenSoftKeyPad(this.mInputManager, bHG());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dnt) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arn));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hyM == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aNT = i;
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bHP() {
        if (!this.hyY && this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aMl.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vG(int i) {
        if (i < this.hyK.size()) {
            for (int i2 = 0; i2 < this.hyK.size(); i2++) {
                this.hyK.get(i2).nr(false);
            }
            this.hyK.get(i).nr(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void th(int i) {
        this.gCY = i;
        this.gDw.setCurrentIndex(i);
        vG(i);
        this.gDv.setText(this.mPrefixData.getPrefixs().get(i));
        brT();
        com.baidu.adp.lib.g.g.a(this.gDw, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gDy.setSelected(false);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            HV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hzd = z;
        if (this.hzc != null && !z) {
            this.hzc.aoX();
        }
        if (this.hzf != null && !z) {
            bHs();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hzd && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hyE = false;
            this.hyD = "";
            if ("from_content".equals(str)) {
                this.hyD = "from_content";
            } else if ("from_title".equals(str)) {
                this.hyD = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.ho(String.valueOf(charSequence.charAt(i)))) {
                nA(false);
            }
        }
    }

    public void boa() {
        if (!w.z(this.mList)) {
            this.hyH.setVisibility(0);
            this.hyH.requestFocus();
            this.aMl.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hyH.setVisibility(8);
    }
}
