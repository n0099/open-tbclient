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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.p;
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
public class TransmitPostEditActivity extends BaseActivity<TransmitPostEditActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0073a, d.a {
    private EditorTools aZc;
    private LocationModel baF;
    private NewWriteModel baG;
    private OriginalThreadCardView fLg;
    private int heD;
    private TextView hfa;
    private com.baidu.tieba.write.d hfb;
    private ImageView hfc;
    private View hfd;
    private LinearLayout ibF;
    private LinearLayout ibG;
    private View ibI;
    private Toast ibK;
    private AdditionData ibL;
    private RelativeLayout ibM;
    private TextView ibN;
    private TextView ibO;
    private TextView ibP;
    List<x> ibQ;
    x ibR;
    private int ibS;
    private String ibT;
    private int ibU;
    private PostCategoryView ibV;
    private HotTopicBussinessData ibY;
    private TextView ibZ;
    private com.baidu.tieba.write.editor.b icb;
    private e ice;
    private com.baidu.tieba.view.b icl;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String ibC = "";
    private boolean ibD = false;
    private WriteData mData = null;
    private boolean ibE = false;
    private InputMethodManager mInputManager = null;
    private EditText heV = null;
    private View heW = null;
    private LinearLayout heY = null;
    private EditText heZ = null;
    private FeedBackModel ibH = null;
    private ArrayList<WritePrefixItemLayout> ibJ = new ArrayList<>();
    private final KeyEvent dup = new KeyEvent(0, 67);
    private View aNz = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String baK = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int baL = 0;
    private View mRootView = null;
    private ScrollView ibW = null;
    private boolean ibX = false;
    private com.baidu.tbadk.core.view.d biQ = null;
    private String mFrom = "write";
    private String eih = "2";
    private SpannableStringBuilder ica = new SpannableStringBuilder();
    private boolean icc = false;
    private final b icd = new b();
    private TbFaceManager.a icf = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan is(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.ot());
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
    private final AntiHelper.a dME = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDo));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDo));
        }
    };
    private final NewWriteModel.d baU = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.icd.aA(null);
                if (z) {
                    TransmitPostEditActivity.this.cB(z);
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
                    TransmitPostEditActivity.this.icd.xK(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.icd.aA(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.icd.b(TransmitPostEditActivity.this.heV, TransmitPostEditActivity.this.heZ);
                } else if ((xVar == null || writeData == null || xVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    TransmitPostEditActivity.this.c(false, postWriteCallBackData);
                } else if (xVar != null && writeData != null && xVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.Hl());
                    if (com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                        TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.Hk())));
                        return;
                    }
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                    TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(TransmitPostEditActivity.this.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };
    private final LocationModel.a baS = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Nf() {
            TransmitPostEditActivity.this.showToast(e.j.no_network_guide);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void dk(String str) {
            TransmitPostEditActivity transmitPostEditActivity = TransmitPostEditActivity.this;
            if (StringUtils.isNull(str)) {
                str = TransmitPostEditActivity.this.getPageContext().getString(e.j.location_fail);
            }
            transmitPostEditActivity.showToast(str);
            TransmitPostEditActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bFu())) {
                TransmitPostEditActivity.this.b(2, true, aVar.bFu());
            } else {
                dk(null);
            }
        }
    };
    private final CustomMessageListener hrV = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.baF.nB(false);
                    TransmitPostEditActivity.this.baF.cQ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.baF.nB(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener icg = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener ich = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bQy = TransmitPostEditActivity.this.bQy();
            if (bQy >= 0 && bQy < TransmitPostEditActivity.this.heZ.getText().length()) {
                TransmitPostEditActivity.this.heZ.setSelection(bQy);
            }
        }
    };
    private boolean ici = true;
    private final View.OnFocusChangeListener heT = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.heV || view == TransmitPostEditActivity.this.aNz || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.ici = true;
                    TransmitPostEditActivity.this.bQz();
                    if (TransmitPostEditActivity.this.aZc != null) {
                        TransmitPostEditActivity.this.aZc.KM();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.heV);
                } else if (view == TransmitPostEditActivity.this.heV) {
                    TransmitPostEditActivity.this.hfa.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.heZ && z) {
                TransmitPostEditActivity.this.ici = false;
                TransmitPostEditActivity.this.bQz();
                TransmitPostEditActivity.this.aZc.KM();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.heZ);
            }
            TransmitPostEditActivity.this.bQF();
        }
    };
    private TextWatcher icj = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String icn = "";
        private String ico;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ico = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ico != null ? this.ico.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bAC();
            TransmitPostEditActivity.this.bQG();
            EditText bQR = TransmitPostEditActivity.this.bQR();
            if (editable != null && bQR != null && bQR.getText() != null) {
                if (this.icn == null || !this.icn.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.icd != null) {
                        this.icn = bQR.getText().toString();
                        TransmitPostEditActivity.this.icd.k(bQR);
                        return;
                    }
                    return;
                }
                bQR.setSelection(bQR.getSelectionEnd());
            }
        }
    };
    private TextWatcher ick = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String ico;
        private String icp = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ico = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.ico != null ? this.ico.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bAC();
            EditText bQQ = TransmitPostEditActivity.this.bQQ();
            if (editable != null && bQQ != null && bQQ.getText() != null) {
                int selectionEnd = bQQ.getSelectionEnd();
                if (this.icp == null || !this.icp.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.icd != null) {
                        this.icp = bQQ.getText().toString();
                        TransmitPostEditActivity.this.icd.k(bQQ);
                        return;
                    }
                    return;
                }
                bQQ.setSelection(selectionEnd);
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
    public void MQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void MR() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(e.j.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MT();
        } else if (this.baF.bFB()) {
            MQ();
        } else {
            this.baF.nB(false);
            b(1, true, null);
            this.baF.bFz();
        }
    }

    private void MT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.baF.amP();
                } else {
                    TransmitPostEditActivity.this.baS.Nf();
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
        aVar.BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bQy() {
        int selectionEnd = bQQ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bQQ().getText().getSpans(0, bQQ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bQQ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bQQ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQz() {
        if (this.aZc != null) {
            this.aZc.setBarLauncherEnabled(!this.ici);
            this.aZc.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ibX) {
            this.heV.setVisibility(8);
            bAC();
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
        this.baF = new LocationModel(this);
        this.baF.a(this.baS);
        registerListener(this.hrV);
        registerListener(this.icg);
        initEditor();
        this.heZ.requestFocus();
        bwG();
        bQZ();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aZc = new EditorTools(getActivity());
        this.aZc.setBarMaxLauCount(4);
        this.aZc.setMoreButtonAtEnd(true);
        this.aZc.setBarLauncherType(1);
        this.aZc.ct(true);
        this.aZc.cu(true);
        this.aZc.setMoreLauncherIcon(e.f.write_more);
        this.aZc.setBackgroundColorId(e.d.cp_bg_line_d);
        bQA();
        this.aZc.Mq();
        if (this.ibF != null) {
            this.ibF.addView(this.aZc);
        }
        bQB();
        this.aZc.pR();
        com.baidu.tbadk.editortools.g fI = this.aZc.fI(6);
        if (fI != null && !TextUtils.isEmpty(this.baK)) {
            ((View) fI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.baK);
                }
            });
        }
        if (!this.ibX) {
            this.aZc.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aZc.KM();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aZc.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aZc.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (this.mData.getType() == 0) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
        bQD();
    }

    private void bQA() {
        com.baidu.tbadk.editortools.k kVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 2);
        aVar.aZJ = e.f.write_at;
        this.aZc.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aZc.b(aVar2);
        aVar2.aZJ = e.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aZL = 4;
            kVar.aZJ = e.f.icon_post_location_selector;
            this.aZc.b(kVar);
        }
        if (this.ibL == null) {
            if (this.icb == null) {
                this.icb = new com.baidu.tieba.write.editor.b(getActivity(), this.eih);
                this.icb.bPB();
                this.icb.setFrom("from_share_write");
                this.icb.ba(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aZc.b(this.icb);
        }
        this.aZc.w(arrayList);
        com.baidu.tbadk.editortools.k fL = this.aZc.fL(5);
        if (fL != null) {
            fL.aZL = 1;
            fL.aZJ = e.f.write_emotion;
        }
    }

    private void bQB() {
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
                            TiebaStatic.log(new am("c12608").y("obj_locate", i));
                        }
                    }
                    if (aVar.code == 16) {
                        if (TransmitPostEditActivity.this.bQP()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else {
                            TransmitPostEditActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(TransmitPostEditActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 24) {
                        if (TransmitPostEditActivity.this.bQP()) {
                            TransmitPostEditActivity.this.showToast(e.j.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof p)) {
                            TransmitPostEditActivity.this.d((p) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        TransmitPostEditActivity.this.bQS();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        TransmitPostEditActivity.this.bAC();
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && TransmitPostEditActivity.this.ibL == null) {
                            TransmitPostEditActivity.this.MU();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.baL) {
                            case 0:
                                Activity pageActivity = TransmitPostEditActivity.this.getPageContext().getPageActivity();
                                if (ab.bC(pageActivity)) {
                                    TransmitPostEditActivity.this.MR();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                TransmitPostEditActivity.this.MQ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (TransmitPostEditActivity.this.baF != null) {
                            TransmitPostEditActivity.this.baF.nB(true);
                        }
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        am amVar = new am("c10645");
                        if (TransmitPostEditActivity.this.mData != null) {
                            str = TransmitPostEditActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        amVar.aB(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(amVar);
                        if (TransmitPostEditActivity.this.mData == null || (videoInfo = TransmitPostEditActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aZc.Ms()) {
                                        TransmitPostEditActivity.this.aZc.KM();
                                        TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bAC();
                        if (TransmitPostEditActivity.this.heZ != null) {
                            TransmitPostEditActivity.this.heZ.requestFocus();
                        }
                        TransmitPostEditActivity.this.aZc.KM();
                        TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.heZ);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.ibD = true;
                        TransmitPostEditActivity.this.oH(true);
                        if (TransmitPostEditActivity.this.bQR().isFocused()) {
                            TransmitPostEditActivity.this.ibC = "from_title";
                        } else if (TransmitPostEditActivity.this.bQQ().isFocused()) {
                            TransmitPostEditActivity.this.ibC = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.ibG.setVisibility(0);
                        TransmitPostEditActivity.this.ibG.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.ibG.hasFocus()) {
                            TransmitPostEditActivity.this.heZ.requestFocus();
                            TransmitPostEditActivity.this.heZ.setSelection(TransmitPostEditActivity.this.heZ.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.ibG.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aZc.setActionListener(31, bVar);
        this.aZc.setActionListener(16, bVar);
        this.aZc.setActionListener(14, bVar);
        this.aZc.setActionListener(24, bVar);
        this.aZc.setActionListener(3, bVar);
        this.aZc.setActionListener(10, bVar);
        this.aZc.setActionListener(11, bVar);
        this.aZc.setActionListener(12, bVar);
        this.aZc.setActionListener(13, bVar);
        this.aZc.setActionListener(15, bVar);
        this.aZc.setActionListener(18, bVar);
        this.aZc.setActionListener(20, bVar);
        this.aZc.setActionListener(25, bVar);
        this.aZc.setActionListener(27, bVar);
        this.aZc.setActionListener(29, bVar);
        this.aZc.setActionListener(43, bVar);
        this.aZc.setActionListener(45, bVar);
        this.aZc.setActionListener(53, bVar);
        this.aZc.setActionListener(48, bVar);
        this.aZc.setActionListener(46, bVar);
        this.aZc.setActionListener(49, bVar);
        this.aZc.setActionListener(47, bVar);
        this.aZc.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU() {
        if (this.baF.amL()) {
            if (this.baF.bFB()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bFx().getLocationData().bFu());
                return;
            }
            b(1, true, null);
            this.baF.bFz();
            return;
        }
        b(0, true, null);
    }

    protected void bAu() {
        if (this.baG != null) {
            this.baG.cancelLoadData();
        }
        if (this.ibH != null) {
            this.ibH.cancelLoadData();
        }
        if (this.baF != null) {
            this.baF.cancelLoadData();
        }
    }

    private void bQC() {
        if (this.ice != null) {
            this.ice.hideTip();
        }
    }

    private void bQD() {
        if (this.ice == null) {
            this.ice = new e(getPageContext());
        }
        this.ice.c(this.aZc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bQC();
        TiebaPrepareImageService.StopService();
        bAu();
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQE() {
        if (this.mData == null) {
            finish();
            return;
        }
        this.mData.setTitle(bQR().getText().toString());
        this.mData.setContent(bQQ().getText().toString());
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.hfb != null && this.hfb.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.hfb, getPageContext().getPageActivity());
                return true;
            } else if (this.aZc.Ms()) {
                this.aZc.KM();
                return true;
            } else {
                bAu();
                bQE();
                return true;
            }
        }
        if (i == 67 && (text = bQQ().getText()) != null) {
            int selectionStart = bQQ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQQ().onKeyDown(67, this.dup);
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
        bQz();
        al.j(this.heW, e.d.cp_bg_line_c);
        al.j(bQR(), e.d.cp_bg_line_d);
        al.j(bQQ(), e.d.cp_bg_line_d);
        bAC();
        this.aZc.onChangeSkinType(i);
        if (this.ibV != null) {
            this.ibV.Fw();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bQF();
        bQG();
        if (this.icd != null) {
            this.icd.c(bQR(), bQQ());
        }
        this.fLg.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQF() {
        if (this.heV.hasFocus()) {
            this.heV.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.heV.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.heZ.hasFocus()) {
            this.heZ.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.heZ.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQG() {
        if (this.heV != null) {
            if (this.heV.getText().toString().length() == 0) {
                this.heV.getPaint().setFakeBoldText(false);
            } else if (this.heV.getText().toString().length() > 0) {
                this.heV.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.biQ = new com.baidu.tbadk.core.view.d(getPageContext());
        this.ibX = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        bQI();
        this.ibW = (ScrollView) findViewById(e.g.write_scrollview);
        this.ibW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.heZ != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.heZ);
                    }
                    if (TransmitPostEditActivity.this.aZc != null) {
                        TransmitPostEditActivity.this.aZc.KM();
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
        this.ibF = (LinearLayout) findViewById(e.g.tool_view);
        this.ibF.setContentDescription("..");
        this.ibG = (LinearLayout) findViewById(e.g.title_view);
        this.heW = findViewById(e.g.interval_view);
        this.ibZ = (TextView) findViewById(e.g.hot_topic_title_edt);
        bAB();
        if (this.ibX) {
            this.ibW.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bAD();
        bQO();
        this.heY = (LinearLayout) findViewById(e.g.post_content_container);
        this.heY.setDrawingCacheEnabled(false);
        this.heY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.heZ.requestFocus();
            }
        });
        this.aNz.setOnFocusChangeListener(this.heT);
        this.aNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TransmitPostEditActivity.this.bAu();
                TransmitPostEditActivity.this.bQE();
            }
        });
        bQL();
        bQN();
        bQH();
        bQz();
        bQM();
        bAA();
        bQT();
        if (this.mData.getType() == 4 && this.hfd != null && this.ibI != null) {
            this.hfd.setVisibility(8);
            this.ibI.setVisibility(8);
        }
        bAC();
        ShowSoftKeyPad(this.mInputManager, this.heV);
    }

    private void bQH() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.eih != null && this.eih.equals("1")) {
                        this.mName.setText(e.j.share_to_home_page);
                    } else if (this.eih != null && this.eih.equals("2")) {
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
                    this.heV.setVisibility(0);
                    this.heZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.heZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(e.j.send_reply);
                    this.heZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.heV.setVisibility(8);
                    return;
            }
        }
    }

    private void bQI() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.heT);
    }

    private void bQJ() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.ibE && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bQR() != null) {
                bQR().setText(c);
                bQR().setSelection(c.length());
            }
        }
    }

    private void bQK() {
        this.ibQ = null;
        this.ibS = -1;
        this.ibU = -1;
        z mB = y.aDD().mB(1);
        if (mB != null) {
            this.ibQ = mB.dOR;
            this.ibS = getIntent().getIntExtra("category_id", -1);
            if (this.ibQ != null && !this.ibQ.isEmpty() && this.ibS >= 0) {
                this.ibR = new x();
                this.ibR.dON = 0;
                this.ibR.name = getPageContext().getResources().getString(e.j.category_auto);
                this.ibU = this.ibR.dON;
                this.ibT = this.ibR.name;
                for (x xVar : this.ibQ) {
                    if (xVar.dON == this.ibS) {
                        this.ibU = xVar.dON;
                        this.ibT = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bQL() {
        if (this.ibQ != null && !this.ibQ.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.ibV = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.ibV.setText(this.ibT);
            this.ibV.setCategoryContainerData(this.ibQ, this.ibR, this.ibU);
            this.ibV.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.ibV.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dON);
                        TransmitPostEditActivity.this.ibU = atVar.dON;
                        TransmitPostEditActivity.this.ibV.bQm();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.ibV.bQl();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQR());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQQ());
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.icl = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.icl.setTitle(e.j.no_disturb_start_time);
        this.icl.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.icl);
        this.icl.setButton(-2, getPageContext().getString(e.j.cancel), this.icl);
        return this.icl;
    }

    private void bQM() {
        this.ibM = (RelativeLayout) findViewById(e.g.addition_container);
        this.ibN = (TextView) findViewById(e.g.addition_create_time);
        this.ibO = (TextView) findViewById(e.g.addition_last_time);
        this.ibP = (TextView) findViewById(e.g.addition_last_content);
        if (this.ibL != null) {
            this.ibM.setVisibility(0);
            this.ibN.setText(getPageContext().getString(e.j.write_addition_create) + ao.M(this.ibL.getCreateTime() * 1000));
            if (this.ibL.getAlreadyCount() == 0) {
                this.ibO.setVisibility(8);
            } else {
                this.ibO.setText(getPageContext().getString(e.j.write_addition_last) + ao.M(this.ibL.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ibL.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ibP.setText(lastAdditionContent);
            } else {
                this.ibP.setVisibility(8);
            }
            bQQ().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.ibL.getAlreadyCount()), Integer.valueOf(this.ibL.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.ibM.setVisibility(8);
    }

    private void bAA() {
        this.hfd = findViewById(e.g.post_prefix_layout);
        this.hfa = (TextView) findViewById(e.g.post_prefix);
        this.ibI = findViewById(e.g.prefix_divider);
        this.hfc = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.hfd.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.heD = 1;
            this.hfd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.hfa.setVisibility(0);
                    TransmitPostEditActivity.this.hfd.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.hfb, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aZc.KM();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.heV);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.heZ);
                }
            });
            this.hfc = (ImageView) findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.hfc.setVisibility(0);
                this.hfa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.hfa.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.hfb, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aZc.KM();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQR());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQQ());
                    }
                });
            }
            this.hfb = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.hfb.a(this);
            this.hfb.setMaxHeight(l.h(getActivity(), e.C0210e.ds510));
            this.hfb.setOutsideTouchable(true);
            this.hfb.setFocusable(true);
            this.hfb.setOnDismissListener(this);
            this.hfb.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_c);
            al.i(this.hfa, e.d.cp_bg_line_d);
            al.c(this.hfc, e.f.icon_frs_arrow_n);
            this.hfa.setTextColor(color);
            this.ibJ.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ibJ.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.hfb.addView(writePrefixItemLayout);
            }
            this.hfb.setCurrentIndex(0);
            this.hfa.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.hfd.setVisibility(8);
    }

    protected void bQN() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.icd.a(TransmitPostEditActivity.this.heV, TransmitPostEditActivity.this.heZ)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.icd.bOx());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQR());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQQ());
                    TransmitPostEditActivity.this.aZc.KM();
                    TiebaStatic.log(new am("c12608").y("obj_locate", 7));
                    TransmitPostEditActivity.this.bQX();
                }
            }
        });
    }

    protected void bAB() {
        this.heV = (EditText) findViewById(e.g.post_title);
        this.heV.setOnClickListener(this.ich);
        this.heV.setOnFocusChangeListener(this.heT);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.heV.setText(this.mData.getTitle());
            this.heV.setSelection(this.mData.getTitle().length());
        }
        this.heV.addTextChangedListener(this.icj);
        if (!this.mData.getHaveDraft()) {
            bQJ();
        }
        this.heV.setHint(getResources().getString(e.j.post_title_hint));
    }

    protected void bAD() {
        this.heZ = (EditText) findViewById(e.g.post_content);
        this.heZ.setDrawingCacheEnabled(false);
        this.heZ.setOnClickListener(this.ich);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.NL().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.heZ.setText(ak);
            this.heZ.setSelection(ak.length());
        }
        this.heZ.setOnFocusChangeListener(this.heT);
        this.heZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aZc.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.heZ.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.heZ.addTextChangedListener(this.ick);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.heZ.setHint(e.j.share_video_default);
        } else {
            this.heZ.setHint(e.j.share_txt_default);
        }
    }

    private void bQO() {
        this.fLg = (OriginalThreadCardView) findViewById(e.g.write_original_thread_cardview);
        this.fLg.setVisibility(0);
        this.fLg.b(this.mOriginalThreadInfo);
        this.fLg.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQP() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.ibL != null) {
            i = 1000;
        }
        return bQQ().getText() != null && bQQ().getText().length() >= i;
    }

    private void hY(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ibC)) {
                this.ibC = "";
                bQQ().requestFocus();
                if (bQQ().getText() != null && bQQ().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQQ().getSelectionStart();
                    editable = bQQ().getText();
                }
            } else if ("from_title".equals(this.ibC)) {
                this.ibC = "";
                bQR().requestFocus();
                if (bQR().getText() != null && bQR().getText().length() + str.length() > 31) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQR().getSelectionStart();
                    editable = bQR().getText();
                }
            }
            if (editable != null && i >= 0 && i <= editable.length()) {
                editable.insert(i, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oH(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(p pVar) {
        if (((ImageSpan[]) bQQ().getText().getSpans(0, bQQ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.ibK == null) {
                this.ibK = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.ibK.show();
            return;
        }
        String name = pVar.getName();
        final EmotionGroupType Ha = pVar.Ha();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.jA().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass18) aVar, str, i);
                    if (aVar != null) {
                        TransmitPostEditActivity.this.a(spannableStringBuilder, TransmitPostEditActivity.this.bQQ().getSelectionStart(), aVar, Ha);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bQQ() != null && bQQ().getText() != null) {
            Bitmap ot = aVar.ot();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(ot);
            int width = ot.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, ot.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.i(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bQQ().getSelectionStart() - 1;
                if (bQQ().getText().length() > 1 && selectionStart >= 0 && bQQ().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bQQ().getText().insert(bQQ().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bQQ().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bQQ().getText().insert(bQQ().getSelectionStart(), spannableString2);
            }
            Editable text = bQQ().getText();
            if (text != null) {
                this.ica.clear();
                this.ica.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.ica);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bQQ().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bQQ().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bQQ().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQQ() {
        return this.heZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQR() {
        return this.heV;
    }

    protected void bQS() {
        Editable text;
        if (bQQ() != null && (text = bQQ().getText()) != null) {
            int selectionStart = bQQ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQQ().onKeyDown(67, this.dup);
            }
            bQQ().onKeyDown(67, this.dup);
            int selectionStart2 = bQQ().getSelectionStart();
            this.ica.clear();
            this.ica.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.ica);
            bQQ().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.biQ.d(null);
        this.biQ.ec(e.j.sending);
        this.biQ.bB(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.biQ.bB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAC() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bQR() != null) {
                str = bQR().getText().toString();
            }
            if (bQQ() != null) {
                str2 = bQQ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    this.mPrefixData.getPrefixs();
                    if (this.heD == 0) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else {
                            this.mData.setIsNoTitle(false);
                            oI(true);
                            return;
                        }
                    } else {
                        this.mData.setIsNoTitle(false);
                        oI(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else {
                    this.mData.setIsNoTitle(false);
                    oI(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.ibX) {
                    oI(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    oI(true);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                oI(true);
            } else if (this.mData.getVideoInfo() != null) {
                oI(true);
            } else {
                oI(false);
            }
        }
    }

    private void oI(boolean z) {
        al.b(this.mPost, e.d.cp_link_tip_a, e.d.s_navbar_title_color);
    }

    private void initData(Bundle bundle) {
        String str;
        this.baG = new NewWriteModel(this);
        this.baG.b(this.baU);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.19
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                TransmitPostEditActivity.this.destroyWaitingDialog();
                TransmitPostEditActivity.this.bAu();
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
                this.ibL = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.ibL != null);
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
            this.eih = bundle.getString("KEY_CALL_FROM");
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
            this.ibL = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.ibL != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.eih = intent.getStringExtra("KEY_CALL_FROM");
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
            this.ibE = true;
        }
        bQK();
    }

    private void bQT() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.heV.setText(com.baidu.tbadk.plugins.b.iH(com.baidu.tbadk.plugins.b.iI(hotTopicBussinessData.mTopicName)));
            this.heV.setMovementMethod(com.baidu.tieba.view.c.bNx());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString iH = com.baidu.tbadk.plugins.b.iH(com.baidu.tbadk.plugins.b.iI(hotTopicBussinessData.mTopicName));
            if (iH != null) {
                this.heV.setText(iH);
            }
            this.ibZ.setText(hotTopicBussinessData.mForumName);
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
        if (this.ibL != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ibL));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.eih);
        if (this.mOriginalThreadInfo != null) {
            bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(this.mOriginalThreadInfo));
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bQQ().getEditableText().toString();
        if (obj != null) {
            bQQ().setText(TbFaceManager.NL().a(getPageContext().getPageActivity(), obj, this.icf));
            bQQ().setSelection(bQQ().getText().length());
        }
    }

    private String bQU() {
        if (bQQ() == null || bQQ().getText() == null) {
            return "";
        }
        if (StringUtils.isNull(bQQ().getText().toString())) {
            if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
                return getString(e.j.share_video_default);
            }
            return getString(e.j.share_txt_default);
        }
        return bQQ().getText().toString();
    }

    private String bQV() {
        if (this.mData == null || bQR() == null || bQR().getVisibility() != 0 || bQR().getText() == null) {
            return "";
        }
        String obj = bQR().getText().toString();
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.heD != 0 && this.mData.getType() != 4 && this.hfa != null && this.hfa.getText() != null) {
            obj = this.hfa.getText().toString() + obj;
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void bQW() {
        bAu();
        this.mData.setContent(bQU());
        this.mData.setTitle(bQV());
        if (this.ibS >= 0) {
            this.mData.setCategoryFrom(this.ibS);
        }
        if (this.ibU >= 0) {
            this.mData.setCategoryTo(this.ibU);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.baF != null && this.baF.amL());
        this.baG.nD(this.writeImagesInfo.size() > 0);
        if (!v.I(this.mList) && this.ibY != null && this.ibY.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.ibY.mForumId));
            this.mData.setForumName(this.ibY.mForumName);
        }
        this.baG.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.baG.getWriteData().setVoice(null);
        this.baG.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        this.baG.startPostWrite();
    }

    private void u(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.ibL != null) {
                i2 = this.ibL.getTotalCount();
                i = this.ibL.getAlreadyCount() + 1;
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
                if (this.aZc != null && !this.aZc.Ms()) {
                    bQQ().requestFocus();
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
                            bQQ().getText().insert(bQQ().getSelectionStart(), sb.toString());
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
                        if (this.ibD) {
                            sb2.append(com.baidu.tbadk.plugins.b.bio);
                            this.ibD = false;
                        }
                        sb2.append(stringExtra);
                        hY(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.ibY = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.ibY);
            }
        } else if (i2 == 0) {
            if (this.aZc != null && !this.aZc.Ms()) {
                this.heZ.requestFocus();
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
                        this.icd.xK(postWriteCallBackData.getErrorString());
                        this.icd.aA(postWriteCallBackData.getSensitiveWords());
                        this.icd.b(this.heV, this.heZ);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.ibC)) {
                        bQR().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ibC)) {
                        bQQ().requestFocus();
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
    public void bQX() {
        if ("1".equals(this.eih)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.eih)) {
            this.mData.setCanNoForum(false);
        }
        bQY();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.eih);
        bQW();
    }

    private void bQY() {
        if (this.aZc != null) {
            this.aZc.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bQR());
        HidenSoftKeyPad(this.mInputManager, bQQ());
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dME) != null) {
                    TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDo));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.ibL == null) {
                    if (!d(postWriteCallBackData)) {
                        com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                        return;
                    }
                    return;
                }
                u(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.baL = i;
        if (this.aZc != null) {
            this.aZc.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bQZ() {
        if (!this.ibX && this.aZc != null) {
            this.aZc.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aZc.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        if (this.aZc != null) {
            this.aZc.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.ibJ.size()) {
            for (int i2 = 0; i2 < this.ibJ.size(); i2++) {
                this.ibJ.get(i2).oy(false);
            }
            this.ibJ.get(i).oy(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void vj(int i) {
        this.heD = i;
        this.hfb.setCurrentIndex(i);
        xI(i);
        this.hfa.setText(this.mPrefixData.getPrefixs().get(i));
        bAC();
        com.baidu.adp.lib.g.g.a(this.hfb, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.hfd.setSelected(false);
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
            MR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.icc = z;
        if (this.icb != null && !z) {
            this.icb.bmw();
        }
        if (this.ice != null && !z) {
            bQC();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.icc && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ibD = false;
            this.ibC = "";
            if ("from_content".equals(str)) {
                this.ibC = "from_content";
            } else if ("from_title".equals(str)) {
                this.ibC = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.iG(String.valueOf(charSequence.charAt(i)))) {
                oH(false);
            }
        }
    }

    public void bwG() {
        if (!v.I(this.mList)) {
            this.ibG.setVisibility(0);
            this.ibG.requestFocus();
            this.aZc.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.ibG.setVisibility(8);
    }
}
