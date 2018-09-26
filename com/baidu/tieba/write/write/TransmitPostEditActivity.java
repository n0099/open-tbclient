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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.at;
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
    private EditorTools aPA;
    private LocationModel aRc;
    private NewWriteModel aRd;
    private OriginalThreadCardView frB;
    private int gKE;
    private TextView gLb;
    private com.baidu.tieba.write.d gLc;
    private ImageView gLd;
    private View gLe;
    private com.baidu.tieba.write.editor.b hHB;
    private e hHE;
    private com.baidu.tieba.view.b hHL;
    private LinearLayout hHf;
    private LinearLayout hHg;
    private View hHi;
    private Toast hHk;
    private AdditionData hHl;
    private RelativeLayout hHm;
    private TextView hHn;
    private TextView hHo;
    private TextView hHp;
    List<x> hHq;
    x hHr;
    private int hHs;
    private String hHt;
    private int hHu;
    private PostCategoryView hHv;
    private HotTopicBussinessData hHy;
    private TextView hHz;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hHc = "";
    private boolean hHd = false;
    private WriteData mData = null;
    private boolean hHe = false;
    private InputMethodManager mInputManager = null;
    private EditText gKW = null;
    private View gKX = null;
    private LinearLayout gKZ = null;
    private EditText gLa = null;
    private FeedBackModel hHh = null;
    private ArrayList<WritePrefixItemLayout> hHj = new ArrayList<>();
    private final KeyEvent daZ = new KeyEvent(0, 67);
    private View aEa = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aRh = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aRi = 0;
    private View mRootView = null;
    private ScrollView hHw = null;
    private boolean hHx = false;
    private com.baidu.tbadk.core.view.d aZn = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String dOX = "2";
    private SpannableStringBuilder hHA = new SpannableStringBuilder();
    private boolean hHC = false;
    private final b hHD = new b();
    private TbFaceManager.a hHF = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan hw(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.oh());
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
    private final AntiHelper.a dtp = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atM));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atM));
        }
    };
    private final NewWriteModel.d aRr = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hHD.aA(null);
                if (z) {
                    TransmitPostEditActivity.this.bX(z);
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
                    TransmitPostEditActivity.this.hHD.wi(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hHD.aA(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hHD.b(TransmitPostEditActivity.this.gKW, TransmitPostEditActivity.this.gLa);
                } else if ((vVar == null || writeData == null || vVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (vVar != null && writeData != null && vVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(vVar.getVcode_md5());
                    writeData.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData.setVcodeExtra(vVar.DF());
                    if (com.baidu.tbadk.q.a.il(vVar.DE())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.DE())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aRp = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Jz() {
            TransmitPostEditActivity.this.showToast(e.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void hl(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(e.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bzo())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bzo());
            } else {
                hl(null);
            }
        }
    };
    private final CustomMessageListener gXP = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aRc.mT(false);
                    TransmitPostEditActivity.this.aRc.cy(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aRc.mT(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hHG = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hHH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bKj = TransmitPostEditActivity.this.bKj();
            if (bKj >= 0 && bKj < TransmitPostEditActivity.this.gLa.getText().length()) {
                TransmitPostEditActivity.this.gLa.setSelection(bKj);
            }
        }
    };
    private boolean hHI = true;
    private final View.OnFocusChangeListener gKU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.gKW || view == TransmitPostEditActivity.this.aEa || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hHI = true;
                    TransmitPostEditActivity.this.bKk();
                    if (TransmitPostEditActivity.this.aPA != null) {
                        TransmitPostEditActivity.this.aPA.Hf();
                    }
                    l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gKW);
                } else if (view == TransmitPostEditActivity.this.gKW) {
                    TransmitPostEditActivity.this.gLb.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.gLa && z) {
                TransmitPostEditActivity.this.hHI = false;
                TransmitPostEditActivity.this.bKk();
                TransmitPostEditActivity.this.aPA.Hf();
                l.b(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gLa);
            }
            TransmitPostEditActivity.this.bKq();
        }
    };
    private TextWatcher hHJ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hHN = "";
        private String hHO;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hHO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hHO != null ? this.hHO.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.buz();
            TransmitPostEditActivity.this.bKr();
            EditText bKC = TransmitPostEditActivity.this.bKC();
            if (editable != null && bKC != null && bKC.getText() != null) {
                if (this.hHN == null || !this.hHN.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hHD != null) {
                        this.hHN = bKC.getText().toString();
                        TransmitPostEditActivity.this.hHD.k(bKC);
                        return;
                    }
                    return;
                }
                bKC.setSelection(bKC.getSelectionEnd());
            }
        }
    };
    private TextWatcher hHK = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hHO;
        private String hHP = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hHO = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hHO != null ? this.hHO.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.buz();
            EditText bKB = TransmitPostEditActivity.this.bKB();
            if (editable != null && bKB != null && bKB.getText() != null) {
                int selectionEnd = bKB.getSelectionEnd();
                if (this.hHP == null || !this.hHP.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hHD != null) {
                        this.hHP = bKB.getText().toString();
                        TransmitPostEditActivity.this.hHD.k(bKB);
                        return;
                    }
                    return;
                }
                bKB.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jk() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Jl() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Jn();
        } else if (this.aRc.bzw()) {
            Jk();
        } else {
            this.aRc.mT(false);
            b(1, true, null);
            this.aRc.bzu();
        }
    }

    private void Jn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cp(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kK()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aRc.ahI();
                } else {
                    TransmitPostEditActivity.this.aRp.Jz();
                }
                aVar2.dismiss();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bKj() {
        int selectionEnd = bKB().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bKB().getText().getSpans(0, bKB().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bKB().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bKB().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKk() {
        if (this.aPA != null) {
            this.aPA.setBarLauncherEnabled(!this.hHI);
            this.aPA.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hHx) {
            this.gKW.setVisibility(8);
            buz();
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
        this.aRc = new LocationModel(this);
        this.aRc.a(this.aRp);
        registerListener(this.gXP);
        registerListener(this.hHG);
        initEditor();
        this.gLa.requestFocus();
        bqI();
        bKK();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aPA = new EditorTools(getActivity());
        this.aPA.setBarMaxLauCount(4);
        this.aPA.setMoreButtonAtEnd(true);
        this.aPA.setBarLauncherType(1);
        this.aPA.bP(true);
        this.aPA.bQ(true);
        this.aPA.setMoreLauncherIcon(e.f.write_more);
        this.aPA.setBackgroundColorId(e.d.cp_bg_line_d);
        bKl();
        this.aPA.IK();
        if (this.hHf != null) {
            this.hHf.addView(this.aPA);
        }
        bKm();
        this.aPA.pI();
        com.baidu.tbadk.editortools.g eW = this.aPA.eW(6);
        if (eW != null && !TextUtils.isEmpty(this.aRh)) {
            ((View) eW).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aRh);
                }
            });
        }
        if (!this.hHx) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aPA.Hf();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bKo();
    }

    private void bKl() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aQh = e.f.write_at;
        this.aPA.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aPA.b(aVar2);
        aVar2.aQh = e.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aQj = 4;
            kVar.aQh = e.f.icon_post_location_selector;
            this.aPA.b(kVar);
        }
        if (this.hHl == null) {
            if (this.hHB == null) {
                this.hHB = new com.baidu.tieba.write.editor.b(getActivity(), this.dOX);
                this.hHB.bJm();
                this.hHB.setFrom("from_share_write");
                this.hHB.aU(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aPA.b(this.hHB);
        }
        this.aPA.G(arrayList);
        com.baidu.tbadk.editortools.k eZ = this.aPA.eZ(5);
        if (eZ != null) {
            eZ.aQj = 1;
            eZ.aQh = e.f.write_emotion;
        }
    }

    private void bKm() {
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
                            TiebaStatic.log(new am("c12608").w("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bKA()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bKA()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof o)) {
                            TransmitPostEditActivity.this.d((o) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bKD();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.buz();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hHl == null) {
                            TransmitPostEditActivity.this.Jo();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aRi) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.bs(pageActivity)) {
                                    TransmitPostEditActivity.this.Jl();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.Jk();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aRc != null) {
                            TransmitPostEditActivity.this.aRc.mT(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.al(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aPA.IM()) {
                                        TransmitPostEditActivity.this.aPA.Hf();
                                        TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(e.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(e.j.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.buz();
                        if (TransmitPostEditActivity.this.gLa != null) {
                            TransmitPostEditActivity.this.gLa.requestFocus();
                        }
                        TransmitPostEditActivity.this.aPA.Hf();
                        TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gLa);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hHd = true;
                        TransmitPostEditActivity.this.nX(true);
                        if (TransmitPostEditActivity.this.bKC().isFocused()) {
                            TransmitPostEditActivity.this.hHc = "from_title";
                        } else if (TransmitPostEditActivity.this.bKB().isFocused()) {
                            TransmitPostEditActivity.this.hHc = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hHg.setVisibility(0);
                        TransmitPostEditActivity.this.hHg.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hHg.hasFocus()) {
                            TransmitPostEditActivity.this.gLa.requestFocus();
                            TransmitPostEditActivity.this.gLa.setSelection(TransmitPostEditActivity.this.gLa.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hHg.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aPA.setActionListener(31, bVar);
        this.aPA.setActionListener(16, bVar);
        this.aPA.setActionListener(14, bVar);
        this.aPA.setActionListener(24, bVar);
        this.aPA.setActionListener(3, bVar);
        this.aPA.setActionListener(10, bVar);
        this.aPA.setActionListener(11, bVar);
        this.aPA.setActionListener(12, bVar);
        this.aPA.setActionListener(13, bVar);
        this.aPA.setActionListener(15, bVar);
        this.aPA.setActionListener(18, bVar);
        this.aPA.setActionListener(20, bVar);
        this.aPA.setActionListener(25, bVar);
        this.aPA.setActionListener(27, bVar);
        this.aPA.setActionListener(29, bVar);
        this.aPA.setActionListener(43, bVar);
        this.aPA.setActionListener(45, bVar);
        this.aPA.setActionListener(53, bVar);
        this.aPA.setActionListener(48, bVar);
        this.aPA.setActionListener(46, bVar);
        this.aPA.setActionListener(49, bVar);
        this.aPA.setActionListener(47, bVar);
        this.aPA.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo() {
        if (this.aRc.ahE()) {
            if (this.aRc.bzw()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bzs().getLocationData().bzo());
                return;
            }
            b(1, true, null);
            this.aRc.bzu();
            return;
        }
        b(0, true, null);
    }

    protected void bur() {
        if (this.aRd != null) {
            this.aRd.cancelLoadData();
        }
        if (this.hHh != null) {
            this.hHh.cancelLoadData();
        }
        if (this.aRc != null) {
            this.aRc.cancelLoadData();
        }
    }

    private void bKn() {
        if (this.hHE != null) {
            this.hHE.hideTip();
        }
    }

    private void bKo() {
        if (this.hHE == null) {
            this.hHE = new e(getPageContext());
        }
        this.hHE.c(this.aPA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bKn();
        TiebaPrepareImageService.StopService();
        bur();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKp() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bKC().getText().toString());
        this.mData.setContent(bKB().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gLc != null && this.gLc.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gLc, getPageContext().getPageActivity());
                return true;
            } else if (this.aPA.IM()) {
                this.aPA.Hf();
                return true;
            } else {
                bur();
                bKp();
                return true;
            }
        }
        if (i == 67 && (text = bKB().getText()) != null) {
            int selectionStart = bKB().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bKB().onKeyDown(67, this.daZ);
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
        al.c(this.mPost, e.d.cp_link_tip_a, 1);
        bKk();
        al.j(this.gKX, e.d.cp_bg_line_c);
        al.j(bKC(), e.d.cp_bg_line_d);
        al.j(bKB(), e.d.cp_bg_line_d);
        buz();
        this.aPA.onChangeSkinType(i);
        if (this.hHv != null) {
            this.hHv.BQ();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bKq();
        bKr();
        if (this.hHD != null) {
            this.hHD.c(bKC(), bKB());
        }
        this.frB.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKq() {
        if (this.gKW.hasFocus()) {
            this.gKW.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gKW.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.gLa.hasFocus()) {
            this.gLa.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.gLa.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        if (this.gKW != null) {
            if (this.gKW.getText().toString().length() == 0) {
                this.gKW.getPaint().setFakeBoldText(false);
            } else if (this.gKW.getText().toString().length() > 0) {
                this.gKW.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aZn = new com.baidu.tbadk.core.view.d(getPageContext());
        this.hHx = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        bKt();
        this.hHw = (ScrollView) findViewById(e.g.write_scrollview);
        this.hHw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gLa != null) {
                        l.a(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gLa);
                    }
                    if (TransmitPostEditActivity.this.aPA != null) {
                        TransmitPostEditActivity.this.aPA.Hf();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.hHf = (LinearLayout) findViewById(e.g.tool_view);
        this.hHf.setContentDescription("..");
        this.hHg = (LinearLayout) findViewById(e.g.title_view);
        this.gKX = findViewById(e.g.interval_view);
        this.hHz = (TextView) findViewById(e.g.hot_topic_title_edt);
        buy();
        if (this.hHx) {
            this.hHw.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        buA();
        bKz();
        this.gKZ = (LinearLayout) findViewById(e.g.post_content_container);
        this.gKZ.setDrawingCacheEnabled(false);
        this.gKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.gLa.requestFocus();
            }
        });
        this.aEa.setOnFocusChangeListener(this.gKU);
        this.aEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bur();
                TransmitPostEditActivity.this.bKp();
            }
        });
        bKw();
        bKy();
        bKs();
        bKk();
        bKx();
        bux();
        bKE();
        if (this.mData.getType() == 4 && this.gLe != null && this.hHi != null) {
            this.gLe.setVisibility(8);
            this.hHi.setVisibility(8);
        }
        buz();
        ShowSoftKeyPad(this.mInputManager, this.gKW);
    }

    private void bKs() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.dOX != null && this.dOX.equals("1")) {
                        this.mName.setText(e.j.share_to_home_page);
                    } else if (this.dOX != null && this.dOX.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(e.j.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(e.j.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(e.j.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gKW.setVisibility(0);
                    this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(e.j.send_reply);
                    this.gLa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gKW.setVisibility(8);
                    return;
            }
        }
    }

    private void bKt() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0141e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gKU);
    }

    private void bKu() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hHe && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bKC() != null) {
                bKC().setText(c);
                bKC().setSelection(c.length());
            }
        }
    }

    private void bKv() {
        this.hHq = null;
        this.hHs = -1;
        this.hHu = -1;
        z lh = y.axO().lh(1);
        if (lh != null) {
            this.hHq = lh.dvD;
            this.hHs = getIntent().getIntExtra("category_id", -1);
            if (this.hHq != null && !this.hHq.isEmpty() && this.hHs >= 0) {
                this.hHr = new x();
                this.hHr.dvz = 0;
                this.hHr.name = getPageContext().getResources().getString(e.j.category_auto);
                this.hHu = this.hHr.dvz;
                this.hHt = this.hHr.name;
                for (x xVar : this.hHq) {
                    if (xVar.dvz == this.hHs) {
                        this.hHu = xVar.dvz;
                        this.hHt = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bKw() {
        if (this.hHq != null && !this.hHq.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.hHv = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.hHv.setText(this.hHt);
            this.hHv.setCategoryContainerData(this.hHq, this.hHr, this.hHu);
            this.hHv.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.hHv.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dvz);
                        TransmitPostEditActivity.this.hHu = atVar.dvz;
                        TransmitPostEditActivity.this.hHv.bJX();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hHv.bJW();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bKC());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bKB());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hHL = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hHL.setTitle(e.j.no_disturb_start_time);
        this.hHL.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.hHL);
        this.hHL.setButton(-2, getPageContext().getString(e.j.cancel), this.hHL);
        return this.hHL;
    }

    private void bKx() {
        this.hHm = (RelativeLayout) findViewById(e.g.addition_container);
        this.hHn = (TextView) findViewById(e.g.addition_create_time);
        this.hHo = (TextView) findViewById(e.g.addition_last_time);
        this.hHp = (TextView) findViewById(e.g.addition_last_content);
        if (this.hHl != null) {
            this.hHm.setVisibility(0);
            this.hHn.setText(getPageContext().getString(e.j.write_addition_create) + ao.A(this.hHl.getCreateTime() * 1000));
            if (this.hHl.getAlreadyCount() == 0) {
                this.hHo.setVisibility(8);
            } else {
                this.hHo.setText(getPageContext().getString(e.j.write_addition_last) + ao.A(this.hHl.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hHl.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hHp.setText(lastAdditionContent);
            } else {
                this.hHp.setVisibility(8);
            }
            bKB().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.hHl.getAlreadyCount()), Integer.valueOf(this.hHl.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.hHm.setVisibility(8);
    }

    private void bux() {
        this.gLe = findViewById(e.g.post_prefix_layout);
        this.gLb = (TextView) findViewById(e.g.post_prefix);
        this.hHi = findViewById(e.g.prefix_divider);
        this.gLd = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gLe.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gKE = 1;
            this.gLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.gLb.setVisibility(0);
                    TransmitPostEditActivity.this.gLe.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gLc, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aPA.Hf();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gKW);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gLa);
                }
            });
            this.gLd = (ImageView) findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.gLd.setVisibility(0);
                this.gLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.gLb.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gLc, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aPA.Hf();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bKC());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bKB());
                    }
                });
            }
            this.gLc = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gLc.a(this);
            this.gLc.setMaxHeight(l.h(getActivity(), e.C0141e.ds510));
            this.gLc.setOutsideTouchable(true);
            this.gLc.setFocusable(true);
            this.gLc.setOnDismissListener(this);
            this.gLc.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_c);
            al.i(this.gLb, e.d.cp_bg_line_d);
            al.c(this.gLd, e.f.icon_frs_arrow_n);
            this.gLb.setTextColor(color);
            this.hHj.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hHj.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gLc.addView(writePrefixItemLayout);
            }
            this.gLc.setCurrentIndex(0);
            this.gLb.setText(prefixs.get(1));
            wg(1);
            return;
        }
        this.gLe.setVisibility(8);
    }

    protected void bKy() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kK()) {
                    TransmitPostEditActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hHD.a(TransmitPostEditActivity.this.gKW, TransmitPostEditActivity.this.gLa)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hHD.bIi());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bKC());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bKB());
                    TransmitPostEditActivity.this.aPA.Hf();
                    TiebaStatic.log(new am("c12608").w("obj_locate", 7));
                    TransmitPostEditActivity.this.bKI();
                }
            }
        });
    }

    protected void buy() {
        this.gKW = (EditText) findViewById(e.g.post_title);
        this.gKW.setOnClickListener(this.hHH);
        this.gKW.setOnFocusChangeListener(this.gKU);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gKW.setText(this.mData.getTitle());
            this.gKW.setSelection(this.mData.getTitle().length());
        }
        this.gKW.addTextChangedListener(this.hHJ);
        if (!this.mData.getHaveDraft()) {
            bKu();
        }
        this.gKW.setHint(getResources().getString(e.j.post_title_hint));
    }

    protected void buA() {
        this.gLa = (EditText) findViewById(e.g.post_content);
        this.gLa.setDrawingCacheEnabled(false);
        this.gLa.setOnClickListener(this.hHH);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString al = TbFaceManager.Kf().al(getPageContext().getPageActivity(), this.mData.getContent());
            this.gLa.setText(al);
            this.gLa.setSelection(al.length());
        }
        this.gLa.setOnFocusChangeListener(this.gKU);
        this.gLa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aPA.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gLa.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gLa.addTextChangedListener(this.hHK);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gLa.setHint(e.j.share_video_default);
        } else {
            this.gLa.setHint(e.j.share_txt_default);
        }
    }

    private void bKz() {
        this.frB = (OriginalThreadCardView) findViewById(e.g.write_original_thread_cardview);
        this.frB.setVisibility(0);
        this.frB.b(this.mOriginalThreadInfo);
        this.frB.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKA() {
        int i = 5000;
        if (this.hHl != null) {
            i = 1000;
        }
        return bKB().getText() != null && bKB().getText().length() >= i;
    }

    private void hc(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hHc)) {
                this.hHc = "";
                bKB().requestFocus();
                if (bKB().getText() != null && bKB().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bKB().getSelectionStart();
                    editable = bKB().getText();
                }
            } else if ("from_title".equals(this.hHc)) {
                this.hHc = "";
                bKC().requestFocus();
                if (bKC().getText() != null && bKC().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bKC().getSelectionStart();
                    editable = bKC().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nX(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(o oVar) {
        if (((ImageSpan[]) bKB().getText().getSpans(0, bKB().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hHk == null) {
                this.hHk = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.hHk.show();
            return;
        }
        String name = oVar.getName();
        final EmotionGroupType Dv = oVar.Dv();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jn().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bKB().getSelectionStart(), aVar, Dv);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bKB() != null && bKB().getText() != null) {
            Bitmap oh = aVar.oh();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(oh);
            int width = oh.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, oh.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bKB().getSelectionStart() - 1;
                if (bKB().getText().length() > 1 && selectionStart >= 0 && bKB().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bKB().getText().insert(bKB().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bKB().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bKB().getText().insert(bKB().getSelectionStart(), spannableString2);
            }
            Editable text = bKB().getText();
            if (text != null) {
                this.hHA.clear();
                this.hHA.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hHA);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bKB().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bKB().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bKB().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bKB() {
        return this.gLa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bKC() {
        return this.gKW;
    }

    protected void bKD() {
        Editable text;
        if (bKB() != null && (text = bKB().getText()) != null) {
            int selectionStart = bKB().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bKB().onKeyDown(67, this.daZ);
            }
            bKB().onKeyDown(67, this.daZ);
            int selectionStart2 = bKB().getSelectionStart();
            this.hHA.clear();
            this.hHA.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hHA);
            bKB().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aZn.d(null);
        this.aZn.dq(e.j.sending);
        this.aZn.aZ(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aZn.aZ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buz() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bKC() != null) {
                str = bKC().getText().toString();
            }
            if (bKB() != null) {
                str2 = bKB().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gKE == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nY(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nY(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nY(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hHx) {
                    nY(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nY(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nY(true);
            } else if (this.mData.getVideoInfo() != null) {
                nY(true);
            } else {
                nY(false);
            }
        }
    }

    private void nY(boolean z) {
        al.b(this.mPost, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aRd = new NewWriteModel(this);
        this.aRd.b(this.aRr);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bur();
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
                this.hHl = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hHl != null);
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
            this.dOX = bundle.getString("KEY_CALL_FROM");
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
            this.hHl = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hHl != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.dOX = intent.getStringExtra("KEY_CALL_FROM");
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
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(e.j.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hHe = true;
        }
        bKv();
    }

    private void bKE() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gKW.setText(com.baidu.tbadk.plugins.b.hL(com.baidu.tbadk.plugins.b.hM(hotTopicBussinessData.mTopicName)));
            this.gKW.setMovementMethod(com.baidu.tieba.view.c.bHk());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString hL = com.baidu.tbadk.plugins.b.hL(com.baidu.tbadk.plugins.b.hM(hotTopicBussinessData.mTopicName));
            if (hL != null) {
                this.gKW.setText(hL);
            }
            this.hHz.setText(hotTopicBussinessData.mForumName);
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
        if (this.hHl != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hHl));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.dOX);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bKB().getEditableText().toString();
        if (obj != null) {
            bKB().setText(TbFaceManager.Kf().a(getPageContext().getPageActivity(), obj, this.hHF));
            bKB().setSelection(bKB().getText().length());
        }
    }

    private String bKF() {
        if (bKB() == null || bKB().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bKB().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(e.j.share_video_default);
            }
            return getString(e.j.share_txt_default);
        }
        return bKB().getText().toString();
    }

    private String bKG() {
        if (this.mData == null || bKC() == null || bKC().getVisibility() != 0 || bKC().getText() == null) {
            return "";
        }
        String obj = bKC().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.y(this.mPrefixData.getPrefixs()) > 0 && this.gKE != 0 && this.mData.getType() != 4 && this.gLb != null && this.gLb.getText() != null) {
            obj = this.gLb.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bKH() {
        bur();
        this.mData.setContent(bKF());
        this.mData.setTitle(bKG());
        if (this.hHs >= 0) {
            this.mData.setCategoryFrom(this.hHs);
        }
        if (this.hHu >= 0) {
            this.mData.setCategoryTo(this.hHu);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aRc != null && this.aRc.ahE());
        this.aRd.mV(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.z(this.mList) && this.hHy != null && this.hHy.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hHy.mForumId));
            this.mData.setForumName(this.hHy.mForumName);
        }
        this.aRd.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aRd.getWriteData().setVoice(null);
        this.aRd.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kK()) {
            showToast(e.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        this.aRd.startPostWrite();
    }

    private void v(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hHl != null) {
                i2 = this.hHl.getTotalCount();
                i = this.hHl.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(e.j.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aPA != null && !this.aPA.IM()) {
                    bKB().requestFocus();
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
                            bKB().getText().insert(bKB().getSelectionStart(), sb.toString());
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
                        if (this.hHd) {
                            sb2.append(com.baidu.tbadk.plugins.b.aYK);
                            this.hHd = false;
                        }
                        sb2.append(stringExtra);
                        hc(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.z(this.mList) && !com.baidu.tbadk.core.util.v.z(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hHy = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hHy);
            }
        } else if (i2 == 0) {
            if (this.aPA != null && !this.aPA.IM()) {
                this.gLa.requestFocus();
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
                        this.hHD.wi(postWriteCallBackData.getErrorString());
                        this.hHD.aA(postWriteCallBackData.getSensitiveWords());
                        this.hHD.b(this.gKW, this.gLa);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hHc)) {
                        bKC().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hHc)) {
                        bKB().requestFocus();
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
    public void bKI() {
        if ("1".equals(this.dOX)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.dOX)) {
            this.mData.setCanNoForum(false);
        }
        bKJ();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.dOX);
        bKH();
    }

    private void bKJ() {
        if (this.aPA != null) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bKC());
        HidenSoftKeyPad(this.mInputManager, bKB());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dtp) != null) {
                    TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atM));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hHl == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                v(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aRi = i;
        if (this.aPA != null) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bKK() {
        if (!this.hHx && this.aPA != null) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aPA.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(boolean z) {
        if (this.aPA != null) {
            this.aPA.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void wg(int i) {
        if (i < this.hHj.size()) {
            for (int i2 = 0; i2 < this.hHj.size(); i2++) {
                this.hHj.get(i2).nO(false);
            }
            this.hHj.get(i).nO(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void tH(int i) {
        this.gKE = i;
        this.gLc.setCurrentIndex(i);
        wg(i);
        this.gLb.setText(this.mPrefixData.getPrefixs().get(i));
        buz();
        com.baidu.adp.lib.g.g.a(this.gLc, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gLe.setSelected(false);
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
            Jl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hHC = z;
        if (this.hHB != null && !z) {
            this.hHB.aqM();
        }
        if (this.hHE != null && !z) {
            bKn();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hHC && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hHd = false;
            this.hHc = "";
            if ("from_content".equals(str)) {
                this.hHc = "from_content";
            } else if ("from_title".equals(str)) {
                this.hHc = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hK(String.valueOf(charSequence.charAt(i)))) {
                nX(false);
            }
        }
    }

    public void bqI() {
        if (!com.baidu.tbadk.core.util.v.z(this.mList)) {
            this.hHg.setVisibility(0);
            this.hHg.requestFocus();
            this.aPA.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hHg.setVisibility(8);
    }
}
