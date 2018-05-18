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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0045a, d.a {
    private EditorTools aCT;
    private LocationModel aEw;
    private NewWriteModel aEx;
    private OriginalThreadCardView eUI;
    private TextView gmW;
    private com.baidu.tieba.write.d gmX;
    private ImageView gmY;
    private View gmZ;
    private int gmz;
    private AdditionData hhA;
    private RelativeLayout hhB;
    private TextView hhC;
    private TextView hhD;
    private TextView hhE;
    List<v> hhF;
    v hhG;
    private int hhH;
    private String hhI;
    private int hhJ;
    private PostCategoryView hhK;
    private HotTopicBussinessData hhN;
    private TextView hhO;
    private com.baidu.tieba.write.editor.b hhQ;
    private e hhT;
    private LinearLayout hhu;
    private LinearLayout hhv;
    private View hhx;
    private Toast hhz;
    private com.baidu.tieba.view.b hia;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String hhr = "";
    private boolean hhs = false;
    private WriteData mData = null;
    private boolean hht = false;
    private InputMethodManager mInputManager = null;
    private EditText gmR = null;
    private View gmS = null;
    private LinearLayout gmU = null;
    private EditText gmV = null;
    private FeedBackModel hhw = null;
    private ArrayList<WritePrefixItemLayout> hhy = new ArrayList<>();
    private final KeyEvent cLp = new KeyEvent(0, 67);
    private View asg = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String aEB = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aEC = 0;
    private View mRootView = null;
    private ScrollView hhL = null;
    private boolean hhM = false;
    private com.baidu.tbadk.core.view.a aNd = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private String gMy = "2";
    private SpannableStringBuilder hhP = new SpannableStringBuilder();
    private boolean hhR = false;
    private final b hhS = new b();
    private TbFaceManager.a hhU = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gC(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.kl());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.d(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a cZl = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajb));
        }
    };
    private final NewWriteModel.d aEL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.hhS.ax(null);
                if (z) {
                    TransmitPostEditActivity.this.bF(z);
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
                    TransmitPostEditActivity.this.hhS.uE(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.hhS.ax(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.hhS.b(TransmitPostEditActivity.this.gmR, TransmitPostEditActivity.this.gmV);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yK());
                    if (com.baidu.tbadk.p.a.hr(tVar.yJ())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yJ())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a aEJ = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Es() {
            TransmitPostEditActivity.this.showToast(d.k.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gq(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(d.k.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bsy())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bsy());
            } else {
                gq(null);
            }
        }
    };
    private final CustomMessageListener gzI = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.aEw.mu(false);
                    TransmitPostEditActivity.this.aEw.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.aEw.mu(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hhV = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hhW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bCW = TransmitPostEditActivity.this.bCW();
            if (bCW >= 0 && bCW < TransmitPostEditActivity.this.gmV.getText().length()) {
                TransmitPostEditActivity.this.gmV.setSelection(bCW);
            }
        }
    };
    private boolean hhX = true;
    private final View.OnFocusChangeListener gmP = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            if (view2 == TransmitPostEditActivity.this.gmR || view2 == TransmitPostEditActivity.this.asg || view2 == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.hhX = true;
                    TransmitPostEditActivity.this.bCX();
                    if (TransmitPostEditActivity.this.aCT != null) {
                        TransmitPostEditActivity.this.aCT.BY();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gmR);
                } else if (view2 == TransmitPostEditActivity.this.gmR) {
                    TransmitPostEditActivity.this.gmW.setVisibility(0);
                }
            }
            if (view2 == TransmitPostEditActivity.this.gmV && z) {
                TransmitPostEditActivity.this.hhX = false;
                TransmitPostEditActivity.this.bCX();
                TransmitPostEditActivity.this.aCT.BY();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.gmV);
            }
            TransmitPostEditActivity.this.bDd();
        }
    };
    private TextWatcher hhY = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String hic = "";
        private String hie;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hie = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hie != null ? this.hie.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bnQ();
            TransmitPostEditActivity.this.bDe();
            EditText bDp = TransmitPostEditActivity.this.bDp();
            if (editable != null && bDp != null && bDp.getText() != null) {
                if (this.hic == null || !this.hic.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hhS != null) {
                        this.hic = bDp.getText().toString();
                        TransmitPostEditActivity.this.hhS.k(bDp);
                        return;
                    }
                    return;
                }
                bDp.setSelection(bDp.getSelectionEnd());
            }
        }
    };
    private TextWatcher hhZ = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String hie;
        private String hif = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hie = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hie != null ? this.hie.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bnQ();
            EditText bDo = TransmitPostEditActivity.this.bDo();
            if (editable != null && bDo != null && bDo.getText() != null) {
                int selectionEnd = bDo.getSelectionEnd();
                if (this.hif == null || !this.hif.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.hhS != null) {
                        this.hif = bDo.getText().toString();
                        TransmitPostEditActivity.this.hhS.k(bDo);
                        return;
                    }
                    return;
                }
                bDo.setSelection(selectionEnd);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || an.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ee() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Ef() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Eg();
        } else if (this.aEw.bsG()) {
            Ee();
        } else {
            this.aEw.mu(false);
            b(1, true, null);
            this.aEw.bsE();
        }
    }

    private void Eg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ca(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.gP()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.aEw.abu();
                } else {
                    TransmitPostEditActivity.this.aEJ.Es();
                }
                aVar2.dismiss();
            }
        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TransmitPostEditActivity.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCW() {
        int selectionEnd = bDo().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bDo().getText().getSpans(0, bDo().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bDo().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bDo().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCX() {
        if (this.aCT != null) {
            this.aCT.setBarLauncherEnabled(!this.hhX);
            this.aCT.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hhM) {
            this.gmR.setVisibility(8);
            bnQ();
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
        this.aEw = new LocationModel(this);
        this.aEw.a(this.aEJ);
        registerListener(this.gzI);
        registerListener(this.hhV);
        initEditor();
        this.gmV.requestFocus();
        bjV();
        bDx();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aCT = new EditorTools(getActivity());
        this.aCT.setBarMaxLauCount(4);
        this.aCT.setMoreButtonAtEnd(true);
        this.aCT.setBarLauncherType(1);
        this.aCT.bx(true);
        this.aCT.by(true);
        this.aCT.setMoreLauncherIcon(d.f.write_more);
        this.aCT.setBackgroundColorId(d.C0126d.cp_bg_line_d);
        bCY();
        this.aCT.DE();
        if (this.hhu != null) {
            this.hhu.addView(this.aCT);
        }
        bCZ();
        this.aCT.lM();
        com.baidu.tbadk.editortools.g eF = this.aCT.eF(6);
        if (eF != null && !TextUtils.isEmpty(this.aEB)) {
            ((View) eF).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.aEB);
                }
            });
        }
        if (!this.hhM) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aCT.BY();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bDb();
    }

    private void bCY() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aDA = d.f.write_at;
        this.aCT.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aCT.b(aVar2);
        aVar2.aDA = d.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aDC = 4;
            kVar.aDA = d.f.icon_post_location_selector;
            this.aCT.b(kVar);
        }
        if (this.hhA == null) {
            if (this.hhQ == null) {
                this.hhQ = new com.baidu.tieba.write.editor.b(getActivity(), this.gMy);
                this.hhQ.bCa();
                this.hhQ.setFrom("from_share_write");
                this.hhQ.aP(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aCT.b(this.hhQ);
        }
        this.aCT.C(arrayList);
        com.baidu.tbadk.editortools.k eI = this.aCT.eI(5);
        if (eI != null) {
            eI.aDC = 1;
            eI.aDA = d.f.write_emotion;
        }
    }

    private void bCZ() {
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
                            TiebaStatic.log(new al("c12608").r("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bDn()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bDn()) {
                            TransmitPostEditActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            TransmitPostEditActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bDq();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bnQ();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.hhA == null) {
                            TransmitPostEditActivity.this.Eh();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.aEC) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.aC(pageActivity)) {
                                    TransmitPostEditActivity.this.Ef();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.Ee();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.aEw != null) {
                            TransmitPostEditActivity.this.aEw.mu(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        al alVar = new al("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        alVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(alVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aCT.DG()) {
                                        TransmitPostEditActivity.this.aCT.BY();
                                        TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(TransmitPostEditActivity.this.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.k.plugin_video_not_active), TransmitPostEditActivity.this.getResources().getString(d.k.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(TransmitPostEditActivity.this.getPageContext(), TransmitPostEditActivity.this.getResources().getString(d.k.plugin_video_install_tips), TransmitPostEditActivity.this.getResources().getString(d.k.plugin_go_install));
                            return;
                        }
                        TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bnQ();
                        if (TransmitPostEditActivity.this.gmV != null) {
                            TransmitPostEditActivity.this.gmV.requestFocus();
                        }
                        TransmitPostEditActivity.this.aCT.BY();
                        TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gmV);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.hhs = true;
                        TransmitPostEditActivity.this.nw(true);
                        if (TransmitPostEditActivity.this.bDp().isFocused()) {
                            TransmitPostEditActivity.this.hhr = "from_title";
                        } else if (TransmitPostEditActivity.this.bDo().isFocused()) {
                            TransmitPostEditActivity.this.hhr = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.hhv.setVisibility(0);
                        TransmitPostEditActivity.this.hhv.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.hhv.hasFocus()) {
                            TransmitPostEditActivity.this.gmV.requestFocus();
                            TransmitPostEditActivity.this.gmV.setSelection(TransmitPostEditActivity.this.gmV.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.hhv.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aCT.setActionListener(31, bVar);
        this.aCT.setActionListener(16, bVar);
        this.aCT.setActionListener(14, bVar);
        this.aCT.setActionListener(24, bVar);
        this.aCT.setActionListener(3, bVar);
        this.aCT.setActionListener(10, bVar);
        this.aCT.setActionListener(11, bVar);
        this.aCT.setActionListener(12, bVar);
        this.aCT.setActionListener(13, bVar);
        this.aCT.setActionListener(15, bVar);
        this.aCT.setActionListener(18, bVar);
        this.aCT.setActionListener(20, bVar);
        this.aCT.setActionListener(25, bVar);
        this.aCT.setActionListener(27, bVar);
        this.aCT.setActionListener(29, bVar);
        this.aCT.setActionListener(43, bVar);
        this.aCT.setActionListener(45, bVar);
        this.aCT.setActionListener(53, bVar);
        this.aCT.setActionListener(48, bVar);
        this.aCT.setActionListener(46, bVar);
        this.aCT.setActionListener(49, bVar);
        this.aCT.setActionListener(47, bVar);
        this.aCT.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        if (this.aEw.abq()) {
            if (this.aEw.bsG()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bsC().getLocationData().bsy());
                return;
            }
            b(1, true, null);
            this.aEw.bsE();
            return;
        }
        b(0, true, null);
    }

    protected void bnI() {
        if (this.aEx != null) {
            this.aEx.cancelLoadData();
        }
        if (this.hhw != null) {
            this.hhw.cancelLoadData();
        }
        if (this.aEw != null) {
            this.aEw.cancelLoadData();
        }
    }

    private void bDa() {
        if (this.hhT != null) {
            this.hhT.hideTip();
        }
    }

    private void bDb() {
        if (this.hhT == null) {
            this.hhT = new e(getPageContext());
        }
        this.hhT.c(this.aCT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bDa();
        TiebaPrepareImageService.StopService();
        bnI();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDc() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bDp().getText().toString());
        this.mData.setContent(bDo().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.gmX != null && this.gmX.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gmX, getPageContext().getPageActivity());
                return true;
            } else if (this.aCT.DG()) {
                this.aCT.BY();
                return true;
            } else {
                bnI();
                bDc();
                return true;
            }
        }
        if (i == 67 && (text = bDo().getText()) != null) {
            int selectionStart = bDo().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDo().onKeyDown(67, this.cLp);
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
        getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ak.c(this.mPost, d.C0126d.cp_link_tip_a, 1);
        bCX();
        ak.j(this.gmS, d.C0126d.cp_bg_line_c);
        ak.j(bDp(), d.C0126d.cp_bg_line_d);
        ak.j(bDo(), d.C0126d.cp_bg_line_d);
        bnQ();
        this.aCT.onChangeSkinType(i);
        if (this.hhK != null) {
            this.hhK.wX();
        }
        ak.h(this.mName, d.C0126d.cp_cont_b);
        bDd();
        bDe();
        if (this.hhS != null) {
            this.hhS.c(bDp(), bDo());
        }
        this.eUI.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDd() {
        if (this.gmR.hasFocus()) {
            this.gmR.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.gmR.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
        if (this.gmV.hasFocus()) {
            this.gmV.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.gmV.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDe() {
        if (this.gmR != null) {
            if (this.gmR.getText().toString().length() == 0) {
                this.gmR.getPaint().setFakeBoldText(false);
            } else if (this.gmR.getText().toString().length() > 0) {
                this.gmR.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.aNd = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hhM = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ak.h(this.mName, d.C0126d.cp_cont_b);
        bDg();
        this.hhL = (ScrollView) findViewById(d.g.write_scrollview);
        this.hhL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.gmV != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.gmV);
                    }
                    if (TransmitPostEditActivity.this.aCT != null) {
                        TransmitPostEditActivity.this.aCT.BY();
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
        this.hhu = (LinearLayout) findViewById(d.g.tool_view);
        this.hhu.setContentDescription("..");
        this.hhv = (LinearLayout) findViewById(d.g.title_view);
        this.gmS = findViewById(d.g.interval_view);
        this.hhO = (TextView) findViewById(d.g.hot_topic_title_edt);
        bnP();
        if (this.hhM) {
            this.hhL.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bnR();
        bDm();
        this.gmU = (LinearLayout) findViewById(d.g.post_content_container);
        this.gmU.setDrawingCacheEnabled(false);
        this.gmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view2.requestFocus();
                TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.gmV.requestFocus();
            }
        });
        this.asg.setOnFocusChangeListener(this.gmP);
        this.asg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TransmitPostEditActivity.this.bnI();
                TransmitPostEditActivity.this.bDc();
            }
        });
        bDj();
        bDl();
        bDf();
        bCX();
        bDk();
        bnO();
        bDr();
        if (this.mData.getType() == 4 && this.gmZ != null && this.hhx != null) {
            this.gmZ.setVisibility(8);
            this.hhx.setVisibility(8);
        }
        bnQ();
        ShowSoftKeyPad(this.mInputManager, this.gmR);
    }

    private void bDf() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.gMy != null && this.gMy.equals("1")) {
                        this.mName.setText(d.k.share_to_home_page);
                    } else if (this.gMy != null && this.gMy.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(d.k.share_to) + this.mData.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(d.k.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(d.k.bar);
                        }
                        this.mName.setText(str2);
                    } else {
                        this.mName.setText("");
                    }
                    this.gmR.setVisibility(0);
                    this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                default:
                    this.mName.setText(d.k.send_reply);
                    this.gmV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gmR.setVisibility(8);
                    return;
            }
        }
    }

    private void bDg() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gmP);
    }

    private void bDh() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hht && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = an.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bDp() != null) {
                bDp().setText(d);
                bDp().setSelection(d.length());
            }
        }
    }

    private void bDi() {
        this.hhF = null;
        this.hhH = -1;
        this.hhJ = -1;
        x kj = w.aqE().kj(1);
        if (kj != null) {
            this.hhF = kj.dbj;
            this.hhH = getIntent().getIntExtra("category_id", -1);
            if (this.hhF != null && !this.hhF.isEmpty() && this.hhH >= 0) {
                this.hhG = new v();
                this.hhG.dbf = 0;
                this.hhG.name = getPageContext().getResources().getString(d.k.category_auto);
                this.hhJ = this.hhG.dbf;
                this.hhI = this.hhG.name;
                for (v vVar : this.hhF) {
                    if (vVar.dbf == this.hhH) {
                        this.hhJ = vVar.dbf;
                        this.hhI = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bDj() {
        if (this.hhF != null && !this.hhF.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hhK = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hhK.setText(this.hhI);
            this.hhK.setCategoryContainerData(this.hhF, this.hhG, this.hhJ);
            this.hhK.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view2, com.baidu.tieba.frs.ar arVar) {
                    if (arVar != null) {
                        TransmitPostEditActivity.this.hhK.setText(arVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(arVar.dbf);
                        TransmitPostEditActivity.this.hhJ = arVar.dbf;
                        TransmitPostEditActivity.this.hhK.bCL();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TransmitPostEditActivity.this.hhK.bCK();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDp());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDo());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hia = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hia.setTitle(d.k.no_disturb_start_time);
        this.hia.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.hia);
        this.hia.setButton(-2, getPageContext().getString(d.k.cancel), this.hia);
        return this.hia;
    }

    private void bDk() {
        this.hhB = (RelativeLayout) findViewById(d.g.addition_container);
        this.hhC = (TextView) findViewById(d.g.addition_create_time);
        this.hhD = (TextView) findViewById(d.g.addition_last_time);
        this.hhE = (TextView) findViewById(d.g.addition_last_content);
        if (this.hhA != null) {
            this.hhB.setVisibility(0);
            this.hhC.setText(getPageContext().getString(d.k.write_addition_create) + an.s(this.hhA.getCreateTime() * 1000));
            if (this.hhA.getAlreadyCount() == 0) {
                this.hhD.setVisibility(8);
            } else {
                this.hhD.setText(getPageContext().getString(d.k.write_addition_last) + an.s(this.hhA.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hhA.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hhE.setText(lastAdditionContent);
            } else {
                this.hhE.setVisibility(8);
            }
            bDo().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.hhA.getAlreadyCount()), Integer.valueOf(this.hhA.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.hhB.setVisibility(8);
    }

    private void bnO() {
        this.gmZ = findViewById(d.g.post_prefix_layout);
        this.gmW = (TextView) findViewById(d.g.post_prefix);
        this.hhx = findViewById(d.g.prefix_divider);
        this.gmY = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gmZ.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gmz = 1;
            this.gmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TransmitPostEditActivity.this.gmW.setVisibility(0);
                    TransmitPostEditActivity.this.gmZ.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gmX, view2, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aCT.BY();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gmR);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.gmV);
                }
            });
            this.gmY = (ImageView) findViewById(d.g.prefix_icon);
            if (size > 1) {
                this.gmY.setVisibility(0);
                this.gmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TransmitPostEditActivity.this.gmW.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.gmX, view2, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aCT.BY();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDp());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDo());
                    }
                });
            }
            this.gmX = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gmX.a(this);
            this.gmX.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.gmX.setOutsideTouchable(true);
            this.gmX.setFocusable(true);
            this.gmX.setOnDismissListener(this);
            this.gmX.setBackgroundDrawable(ak.getDrawable(d.C0126d.cp_bg_line_d));
            int color = ak.getColor(d.C0126d.cp_cont_b);
            int color2 = ak.getColor(d.C0126d.cp_cont_c);
            ak.i(this.gmW, d.C0126d.cp_bg_line_d);
            ak.c(this.gmY, d.f.icon_frs_arrow_n);
            this.gmW.setTextColor(color);
            this.hhy.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hhy.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gmX.addView(writePrefixItemLayout);
            }
            this.gmX.setCurrentIndex(0);
            this.gmW.setText(prefixs.get(1));
            vg(1);
            return;
        }
        this.gmZ.setVisibility(8);
    }

    protected void bDl() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    TransmitPostEditActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.hhS.a(TransmitPostEditActivity.this.gmR, TransmitPostEditActivity.this.gmV)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.hhS.bAW());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDp());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bDo());
                    TransmitPostEditActivity.this.aCT.BY();
                    TiebaStatic.log(new al("c12608").r("obj_locate", 7));
                    TransmitPostEditActivity.this.bDv();
                }
            }
        });
    }

    protected void bnP() {
        this.gmR = (EditText) findViewById(d.g.post_title);
        this.gmR.setOnClickListener(this.hhW);
        this.gmR.setOnFocusChangeListener(this.gmP);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.gmR.setText(this.mData.getTitle());
            this.gmR.setSelection(this.mData.getTitle().length());
        }
        this.gmR.addTextChangedListener(this.hhY);
        if (!this.mData.getHaveDraft()) {
            bDh();
        }
        this.gmR.setHint(getResources().getString(d.k.post_title_hint));
    }

    protected void bnR() {
        this.gmV = (EditText) findViewById(d.g.post_content);
        this.gmV.setDrawingCacheEnabled(false);
        this.gmV.setOnClickListener(this.hhW);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString R = TbFaceManager.EX().R(getPageContext().getPageActivity(), this.mData.getContent());
            this.gmV.setText(R);
            this.gmV.setSelection(R.length());
        }
        this.gmV.setOnFocusChangeListener(this.gmP);
        this.gmV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    TransmitPostEditActivity.this.aCT.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.gmV.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gmV.addTextChangedListener(this.hhZ);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.gmV.setHint(d.k.share_video_default);
        } else {
            this.gmV.setHint(d.k.share_txt_default);
        }
    }

    private void bDm() {
        this.eUI = (OriginalThreadCardView) findViewById(d.g.write_original_thread_cardview);
        this.eUI.setVisibility(0);
        this.eUI.b(this.mOriginalThreadInfo);
        this.eUI.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDn() {
        int i = 5000;
        if (this.hhA != null) {
            i = 1000;
        }
        return bDo().getText() != null && bDo().getText().length() >= i;
    }

    private void gh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hhr)) {
                this.hhr = "";
                bDo().requestFocus();
                if (bDo().getText() != null && bDo().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDo().getSelectionStart();
                    editable = bDo().getText();
                }
            } else if ("from_title".equals(this.hhr)) {
                this.hhr = "";
                bDp().requestFocus();
                if (bDp().getText() != null && bDp().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDp().getSelectionStart();
                    editable = bDp().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bDo().getText().getSpans(0, bDo().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hhz == null) {
                this.hhz = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.hhz.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType yB = nVar.yB();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fp().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bDo().getSelectionStart(), aVar, yB);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bDo() != null && bDo().getText() != null) {
            Bitmap kl = aVar.kl();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kl);
            int width = kl.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, kl.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.d(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bDo().getSelectionStart() - 1;
                if (bDo().getText().length() > 1 && selectionStart >= 0 && bDo().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bDo().getText().insert(bDo().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bDo().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bDo().getText().insert(bDo().getSelectionStart(), spannableString2);
            }
            Editable text = bDo().getText();
            if (text != null) {
                this.hhP.clear();
                this.hhP.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hhP);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bDo().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bDo().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bDo().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDo() {
        return this.gmV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDp() {
        return this.gmR;
    }

    protected void bDq() {
        Editable text;
        if (bDo() != null && (text = bDo().getText()) != null) {
            int selectionStart = bDo().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDo().onKeyDown(67, this.cLp);
            }
            bDo().onKeyDown(67, this.cLp);
            int selectionStart2 = bDo().getSelectionStart();
            this.hhP.clear();
            this.hhP.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.hhP);
            bDo().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aNd.d(null);
        this.aNd.da(d.k.sending);
        this.aNd.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aNd.aI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnQ() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bDp() != null) {
                str = bDp().getText().toString();
            }
            if (bDo() != null) {
                str2 = bDo().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.gmz == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            nx(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        nx(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    nx(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hhM) {
                    nx(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nx(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                nx(true);
            } else if (this.mData.getVideoInfo() != null) {
                nx(true);
            } else {
                nx(false);
            }
        }
    }

    private void nx(boolean z) {
        ak.b(this.mPost, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.aEx = new NewWriteModel(this);
        this.aEx.b(this.aEL);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bnI();
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
                this.hhA = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hhA != null);
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
            this.gMy = bundle.getString("KEY_CALL_FROM");
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
            this.hhA = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hhA != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.gMy = intent.getStringExtra("KEY_CALL_FROM");
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
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(d.k.write_no_prefix));
        }
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.videoId != null) {
            this.mData.setVideoId(this.mOriginalThreadInfo.videoId);
            this.mData.setOriginalVideoCover(this.mOriginalThreadInfo.showPicUrl);
            this.mData.setOriginalVideoTitle(this.mOriginalThreadInfo.showText);
        }
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hht = true;
        }
        bDi();
    }

    private void bDr() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gmR.setText(com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName)));
            this.gmR.setMovementMethod(com.baidu.tieba.view.c.bAb());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString gT = com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName));
            if (gT != null) {
                this.gmR.setText(gT);
            }
            this.hhO.setText(hotTopicBussinessData.mForumName);
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
        if (this.hhA != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hhA));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gMy);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bDo().getEditableText().toString();
        if (obj != null) {
            bDo().setText(TbFaceManager.EX().a(getPageContext().getPageActivity(), obj, this.hhU));
            bDo().setSelection(bDo().getText().length());
        }
    }

    private String bDs() {
        if (bDo() == null || bDo().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bDo().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(d.k.share_video_default);
            }
            return getString(d.k.share_txt_default);
        }
        return bDo().getText().toString();
    }

    private String bDt() {
        if (this.mData == null || bDp() == null || bDp().getVisibility() != 0 || bDp().getText() == null) {
            return "";
        }
        String obj = bDp().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) > 0 && this.gmz != 0 && this.mData.getType() != 4 && this.gmW != null && this.gmW.getText() != null) {
            obj = this.gmW.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bDu() {
        bnI();
        this.mData.setContent(bDs());
        this.mData.setTitle(bDt());
        if (this.hhH >= 0) {
            this.mData.setCategoryFrom(this.hhH);
        }
        if (this.hhJ >= 0) {
            this.mData.setCategoryTo(this.hhJ);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.aEw != null && this.aEw.abq());
        this.aEx.mw(this.writeImagesInfo.size() > 0);
        if (!com.baidu.tbadk.core.util.v.w(this.mList) && this.hhN != null && this.hhN.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hhN.mForumId));
            this.mData.setForumName(this.hhN.mForumName);
        }
        this.aEx.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.aEx.getWriteData().setVoice(null);
        this.aEx.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.gP()) {
            showToast(d.k.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
        this.aEx.startPostWrite();
    }

    private void q(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.hhA != null) {
                i2 = this.hhA.getTotalCount();
                i = this.hhA.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(d.k.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                if (this.aCT != null && !this.aCT.DG()) {
                    bDo().requestFocus();
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
                            bDo().getText().insert(bDo().getSelectionStart(), sb.toString());
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
                        if (this.hhs) {
                            sb2.append(com.baidu.tbadk.plugins.b.aMA);
                            this.hhs = false;
                        }
                        sb2.append(stringExtra);
                        gh(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.w(this.mList) && !com.baidu.tbadk.core.util.v.w(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.hhN = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.hhN);
            }
        } else if (i2 == 0) {
            if (this.aCT != null && !this.aCT.DG()) {
                this.gmV.requestFocus();
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
                        this.hhS.uE(postWriteCallBackData.getErrorString());
                        this.hhS.ax(postWriteCallBackData.getSensitiveWords());
                        this.hhS.b(this.gmR, this.gmV);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.hhr)) {
                        bDp().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hhr)) {
                        bDo().requestFocus();
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
    public void bDv() {
        if ("1".equals(this.gMy)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.gMy)) {
            this.mData.setCanNoForum(false);
        }
        bDw();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.gMy);
        bDu();
    }

    private void bDw() {
        if (this.aCT != null) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bDp());
        HidenSoftKeyPad(this.mInputManager, bDo());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.ts(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cZl) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajb));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hhA == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aEC = i;
        if (this.aCT != null) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bDx() {
        if (!this.hhM && this.aCT != null) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aCT.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aCT != null) {
            this.aCT.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vg(int i) {
        if (i < this.hhy.size()) {
            for (int i2 = 0; i2 < this.hhy.size(); i2++) {
                this.hhy.get(i2).nn(false);
            }
            this.hhy.get(i).nn(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sN(int i) {
        this.gmz = i;
        this.gmX.setCurrentIndex(i);
        vg(i);
        this.gmW.setText(this.mPrefixData.getPrefixs().get(i));
        bnQ();
        com.baidu.adp.lib.g.g.a(this.gmX, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gmZ.setSelected(false);
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0045a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Ef();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hhR = z;
        if (this.hhQ != null && !z) {
            this.hhQ.akW();
        }
        if (this.hhT != null && !z) {
            bDa();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(d.a.activity_open_from_bottom, d.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.hhR && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hhs = false;
            this.hhr = "";
            if ("from_content".equals(str)) {
                this.hhr = "from_content";
            } else if ("from_title".equals(str)) {
                this.hhr = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.gS(String.valueOf(charSequence.charAt(i)))) {
                nw(false);
            }
        }
    }

    public void bjV() {
        if (!com.baidu.tbadk.core.util.v.w(this.mList)) {
            this.hhv.setVisibility(0);
            this.hhv.requestFocus();
            this.aCT.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hhv.setVisibility(8);
    }
}
