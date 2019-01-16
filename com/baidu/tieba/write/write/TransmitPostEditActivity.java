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
    private EditorTools aZb;
    private LocationModel baE;
    private NewWriteModel baF;
    private OriginalThreadCardView fLf;
    private int heC;
    private TextView heZ;
    private com.baidu.tieba.write.d hfa;
    private ImageView hfb;
    private View hfc;
    private LinearLayout ibE;
    private LinearLayout ibF;
    private View ibH;
    private Toast ibJ;
    private AdditionData ibK;
    private RelativeLayout ibL;
    private TextView ibM;
    private TextView ibN;
    private TextView ibO;
    List<x> ibP;
    x ibQ;
    private int ibR;
    private String ibS;
    private int ibT;
    private PostCategoryView ibU;
    private HotTopicBussinessData ibX;
    private TextView ibY;
    private com.baidu.tieba.write.editor.b ica;
    private e icd;
    private com.baidu.tieba.view.b ick;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private NavigationBar mNavigationBar;
    private OriginalThreadInfo mOriginalThreadInfo;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private int mPrivateThread;
    private String ibB = "";
    private boolean ibC = false;
    private WriteData mData = null;
    private boolean ibD = false;
    private InputMethodManager mInputManager = null;
    private EditText heU = null;
    private View heV = null;
    private LinearLayout heX = null;
    private EditText heY = null;
    private FeedBackModel ibG = null;
    private ArrayList<WritePrefixItemLayout> ibI = new ArrayList<>();
    private final KeyEvent duo = new KeyEvent(0, 67);
    private View aNy = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout mParent = null;
    private String baJ = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int baK = 0;
    private View mRootView = null;
    private ScrollView ibV = null;
    private boolean ibW = false;
    private com.baidu.tbadk.core.view.d biP = null;
    private String mFrom = "write";
    private String eig = "2";
    private SpannableStringBuilder ibZ = new SpannableStringBuilder();
    private boolean icb = false;
    private final b icc = new b();
    private TbFaceManager.a ice = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.1
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
    private final AntiHelper.a dMD = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.12
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDn));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDn));
        }
    };
    private final NewWriteModel.d baT = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.20
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.x xVar, WriteData writeData, AntiData antiData) {
            TransmitPostEditActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && TransmitPostEditActivity.this.mData != null) {
                TransmitPostEditActivity.this.icc.aA(null);
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
                    TransmitPostEditActivity.this.icc.xK(postWriteCallBackData.getErrorString());
                    TransmitPostEditActivity.this.icc.aA(postWriteCallBackData.getSensitiveWords());
                    TransmitPostEditActivity.this.icc.b(TransmitPostEditActivity.this.heU, TransmitPostEditActivity.this.heY);
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
    private final LocationModel.a baR = new LocationModel.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.21
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
    private final CustomMessageListener hrU = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    TransmitPostEditActivity.this.baE.nB(false);
                    TransmitPostEditActivity.this.baE.cQ(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    TransmitPostEditActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                TransmitPostEditActivity.this.baE.nB(true);
                TransmitPostEditActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener icf = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TransmitPostEditActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener icg = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.24
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bQy = TransmitPostEditActivity.this.bQy();
            if (bQy >= 0 && bQy < TransmitPostEditActivity.this.heY.getText().length()) {
                TransmitPostEditActivity.this.heY.setSelection(bQy);
            }
        }
    };
    private boolean ich = true;
    private final View.OnFocusChangeListener heS = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == TransmitPostEditActivity.this.heU || view == TransmitPostEditActivity.this.aNy || view == TransmitPostEditActivity.this.mPost) {
                if (z) {
                    TransmitPostEditActivity.this.ich = true;
                    TransmitPostEditActivity.this.bQz();
                    if (TransmitPostEditActivity.this.aZb != null) {
                        TransmitPostEditActivity.this.aZb.KM();
                    }
                    l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.heU);
                } else if (view == TransmitPostEditActivity.this.heU) {
                    TransmitPostEditActivity.this.heZ.setVisibility(0);
                }
            }
            if (view == TransmitPostEditActivity.this.heY && z) {
                TransmitPostEditActivity.this.ich = false;
                TransmitPostEditActivity.this.bQz();
                TransmitPostEditActivity.this.aZb.KM();
                l.c(TransmitPostEditActivity.this.getActivity(), TransmitPostEditActivity.this.heY);
            }
            TransmitPostEditActivity.this.bQF();
        }
    };
    private TextWatcher ici = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.5
        private String icm = "";
        private String icn;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.icn = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.icn != null ? this.icn.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bAC();
            TransmitPostEditActivity.this.bQG();
            EditText bQR = TransmitPostEditActivity.this.bQR();
            if (editable != null && bQR != null && bQR.getText() != null) {
                if (this.icm == null || !this.icm.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.icc != null) {
                        this.icm = bQR.getText().toString();
                        TransmitPostEditActivity.this.icc.k(bQR);
                        return;
                    }
                    return;
                }
                bQR.setSelection(bQR.getSelectionEnd());
            }
        }
    };
    private TextWatcher icj = new TextWatcher() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.6
        private String icn;
        private String ico = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.icn = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.icn != null ? this.icn.toString().length() : 0)) {
                TransmitPostEditActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TransmitPostEditActivity.this.bAC();
            EditText bQQ = TransmitPostEditActivity.this.bQQ();
            if (editable != null && bQQ != null && bQQ.getText() != null) {
                int selectionEnd = bQQ.getSelectionEnd();
                if (this.ico == null || !this.ico.equals(editable.toString())) {
                    if (TransmitPostEditActivity.this.icc != null) {
                        this.ico = bQQ.getText().toString();
                        TransmitPostEditActivity.this.icc.k(bQQ);
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
        } else if (this.baE.bFB()) {
            MQ();
        } else {
            this.baE.nB(false);
            b(1, true, null);
            this.baE.bFz();
        }
    }

    private void MT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.b(1, true, null);
                    TransmitPostEditActivity.this.baE.amP();
                } else {
                    TransmitPostEditActivity.this.baR.Nf();
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
        if (this.aZb != null) {
            this.aZb.setBarLauncherEnabled(!this.ich);
            this.aZb.setBarLauncherEnabled(true, 26);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ibW) {
            this.heU.setVisibility(8);
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
        this.baE = new LocationModel(this);
        this.baE.a(this.baR);
        registerListener(this.hrU);
        registerListener(this.icf);
        initEditor();
        this.heY.requestFocus();
        bwG();
        bQZ();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aZb = new EditorTools(getActivity());
        this.aZb.setBarMaxLauCount(4);
        this.aZb.setMoreButtonAtEnd(true);
        this.aZb.setBarLauncherType(1);
        this.aZb.ct(true);
        this.aZb.cu(true);
        this.aZb.setMoreLauncherIcon(e.f.write_more);
        this.aZb.setBackgroundColorId(e.d.cp_bg_line_d);
        bQA();
        this.aZb.Mq();
        if (this.ibE != null) {
            this.ibE.addView(this.aZb);
        }
        bQB();
        this.aZb.pR();
        com.baidu.tbadk.editortools.g fI = this.aZb.fI(6);
        if (fI != null && !TextUtils.isEmpty(this.baJ)) {
            ((View) fI).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.baJ);
                }
            });
        }
        if (!this.ibW) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aZb.KM();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
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
        aVar.aZI = e.f.write_at;
        this.aZb.b(aVar);
        com.baidu.tbadk.editortools.c.a aVar2 = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
        this.aZb.b(aVar2);
        aVar2.aZI = e.f.icon_post_topic_selector;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask != null && (kVar = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar.aZK = 4;
            kVar.aZI = e.f.icon_post_location_selector;
            this.aZb.b(kVar);
        }
        if (this.ibK == null) {
            if (this.ica == null) {
                this.ica = new com.baidu.tieba.write.editor.b(getActivity(), this.eig);
                this.ica.bPB();
                this.ica.setFrom("from_share_write");
                this.ica.ba(this.mData.getForumId(), this.mPrivateThread);
            }
            this.aZb.b(this.ica);
        }
        this.aZb.w(arrayList);
        com.baidu.tbadk.editortools.k fL = this.aZb.fL(5);
        if (fL != null) {
            fL.aZK = 1;
            fL.aZI = e.f.write_emotion;
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
                        if (aVar.data != null && TransmitPostEditActivity.this.ibK == null) {
                            TransmitPostEditActivity.this.MU();
                            return;
                        }
                        switch (TransmitPostEditActivity.this.baK) {
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
                        if (TransmitPostEditActivity.this.baE != null) {
                            TransmitPostEditActivity.this.baE.nB(true);
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
                            TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (TransmitPostEditActivity.this.aZb.Ms()) {
                                        TransmitPostEditActivity.this.aZb.KM();
                                        TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        TransmitPostEditActivity.this.mData.setVideoInfo(null);
                        TransmitPostEditActivity.this.bAC();
                        if (TransmitPostEditActivity.this.heY != null) {
                            TransmitPostEditActivity.this.heY.requestFocus();
                        }
                        TransmitPostEditActivity.this.aZb.KM();
                        TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        TransmitPostEditActivity.this.ShowSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.heY);
                    } else if (aVar.code == 43) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        TransmitPostEditActivity.this.ibC = true;
                        TransmitPostEditActivity.this.oH(true);
                        if (TransmitPostEditActivity.this.bQR().isFocused()) {
                            TransmitPostEditActivity.this.ibB = "from_title";
                        } else if (TransmitPostEditActivity.this.bQQ().isFocused()) {
                            TransmitPostEditActivity.this.ibB = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        TransmitPostEditActivity.this.ibF.setVisibility(0);
                        TransmitPostEditActivity.this.ibF.requestFocus();
                    } else if (aVar.code == 53) {
                        if (TransmitPostEditActivity.this.ibF.hasFocus()) {
                            TransmitPostEditActivity.this.heY.requestFocus();
                            TransmitPostEditActivity.this.heY.setSelection(TransmitPostEditActivity.this.heY.getText().toString().length());
                        }
                        TransmitPostEditActivity.this.ibF.setVisibility(8);
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        TransmitPostEditActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aZb.setActionListener(31, bVar);
        this.aZb.setActionListener(16, bVar);
        this.aZb.setActionListener(14, bVar);
        this.aZb.setActionListener(24, bVar);
        this.aZb.setActionListener(3, bVar);
        this.aZb.setActionListener(10, bVar);
        this.aZb.setActionListener(11, bVar);
        this.aZb.setActionListener(12, bVar);
        this.aZb.setActionListener(13, bVar);
        this.aZb.setActionListener(15, bVar);
        this.aZb.setActionListener(18, bVar);
        this.aZb.setActionListener(20, bVar);
        this.aZb.setActionListener(25, bVar);
        this.aZb.setActionListener(27, bVar);
        this.aZb.setActionListener(29, bVar);
        this.aZb.setActionListener(43, bVar);
        this.aZb.setActionListener(45, bVar);
        this.aZb.setActionListener(53, bVar);
        this.aZb.setActionListener(48, bVar);
        this.aZb.setActionListener(46, bVar);
        this.aZb.setActionListener(49, bVar);
        this.aZb.setActionListener(47, bVar);
        this.aZb.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU() {
        if (this.baE.amL()) {
            if (this.baE.bFB()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bFx().getLocationData().bFu());
                return;
            }
            b(1, true, null);
            this.baE.bFz();
            return;
        }
        b(0, true, null);
    }

    protected void bAu() {
        if (this.baF != null) {
            this.baF.cancelLoadData();
        }
        if (this.ibG != null) {
            this.ibG.cancelLoadData();
        }
        if (this.baE != null) {
            this.baE.cancelLoadData();
        }
    }

    private void bQC() {
        if (this.icd != null) {
            this.icd.hideTip();
        }
    }

    private void bQD() {
        if (this.icd == null) {
            this.icd = new e(getPageContext());
        }
        this.icd.c(this.aZb);
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
            if (this.hfa != null && this.hfa.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.hfa, getPageContext().getPageActivity());
                return true;
            } else if (this.aZb.Ms()) {
                this.aZb.KM();
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
                bQQ().onKeyDown(67, this.duo);
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
        al.j(this.heV, e.d.cp_bg_line_c);
        al.j(bQR(), e.d.cp_bg_line_d);
        al.j(bQQ(), e.d.cp_bg_line_d);
        bAC();
        this.aZb.onChangeSkinType(i);
        if (this.ibU != null) {
            this.ibU.Fw();
        }
        al.h(this.mName, e.d.cp_cont_b);
        bQF();
        bQG();
        if (this.icc != null) {
            this.icc.c(bQR(), bQQ());
        }
        this.fLf.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQF() {
        if (this.heU.hasFocus()) {
            this.heU.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.heU.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
        if (this.heY.hasFocus()) {
            this.heY.setHintTextColor(al.getColor(e.d.cp_cont_e));
        } else {
            this.heY.setHintTextColor(al.getColor(e.d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQG() {
        if (this.heU != null) {
            if (this.heU.getText().toString().length() == 0) {
                this.heU.getPaint().setFakeBoldText(false);
            } else if (this.heU.getText().toString().length() > 0) {
                this.heU.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.biP = new com.baidu.tbadk.core.view.d(getPageContext());
        this.ibW = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(e.h.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(e.f.icon_topbar_close, e.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        al.h(this.mName, e.d.cp_cont_b);
        bQI();
        this.ibV = (ScrollView) findViewById(e.g.write_scrollview);
        this.ibV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (TransmitPostEditActivity.this.heY != null) {
                        l.b(TransmitPostEditActivity.this.getPageContext().getContext(), TransmitPostEditActivity.this.heY);
                    }
                    if (TransmitPostEditActivity.this.aZb != null) {
                        TransmitPostEditActivity.this.aZb.KM();
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
        this.ibE = (LinearLayout) findViewById(e.g.tool_view);
        this.ibE.setContentDescription("..");
        this.ibF = (LinearLayout) findViewById(e.g.title_view);
        this.heV = findViewById(e.g.interval_view);
        this.ibY = (TextView) findViewById(e.g.hot_topic_title_edt);
        bAB();
        if (this.ibW) {
            this.ibV.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
        }
        bAD();
        bQO();
        this.heX = (LinearLayout) findViewById(e.g.post_content_container);
        this.heX.setDrawingCacheEnabled(false);
        this.heX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                TransmitPostEditActivity.this.heY.requestFocus();
            }
        });
        this.aNy.setOnFocusChangeListener(this.heS);
        this.aNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.9
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
        if (this.mData.getType() == 4 && this.hfc != null && this.ibH != null) {
            this.hfc.setVisibility(8);
            this.ibH.setVisibility(8);
        }
        bAC();
        ShowSoftKeyPad(this.mInputManager, this.heU);
    }

    private void bQH() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.eig != null && this.eig.equals("1")) {
                        this.mName.setText(e.j.share_to_home_page);
                    } else if (this.eig != null && this.eig.equals("2")) {
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
                    this.heU.setVisibility(0);
                    this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                case 4:
                    this.mName.setText(e.j.publish_photo_live);
                    this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(UIMsg.m_AppUI.MSG_APP_GPS)});
                    return;
                default:
                    this.mName.setText(e.j.send_reply);
                    this.heY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.heU.setVisibility(8);
                    return;
            }
        }
    }

    private void bQI() {
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(e.j.share));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.h(getPageContext().getPageActivity(), e.C0210e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.heS);
    }

    private void bQJ() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.ibD && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String c = ao.c(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(c) && bQR() != null) {
                bQR().setText(c);
                bQR().setSelection(c.length());
            }
        }
    }

    private void bQK() {
        this.ibP = null;
        this.ibR = -1;
        this.ibT = -1;
        z mB = y.aDD().mB(1);
        if (mB != null) {
            this.ibP = mB.dOQ;
            this.ibR = getIntent().getIntExtra("category_id", -1);
            if (this.ibP != null && !this.ibP.isEmpty() && this.ibR >= 0) {
                this.ibQ = new x();
                this.ibQ.dOM = 0;
                this.ibQ.name = getPageContext().getResources().getString(e.j.category_auto);
                this.ibT = this.ibQ.dOM;
                this.ibS = this.ibQ.name;
                for (x xVar : this.ibP) {
                    if (xVar.dOM == this.ibR) {
                        this.ibT = xVar.dOM;
                        this.ibS = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bQL() {
        if (this.ibP != null && !this.ibP.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(e.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(e.g.interval_view_cate).setVisibility(0);
            this.ibU = (PostCategoryView) linearLayout.findViewById(e.g.category_selected);
            this.ibU.setText(this.ibS);
            this.ibU.setCategoryContainerData(this.ibP, this.ibQ, this.ibT);
            this.ibU.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.10
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, at atVar) {
                    if (atVar != null) {
                        TransmitPostEditActivity.this.ibU.setText(atVar.name);
                        TransmitPostEditActivity.this.mData.setCategoryTo(atVar.dOM);
                        TransmitPostEditActivity.this.ibT = atVar.dOM;
                        TransmitPostEditActivity.this.ibU.bQm();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.ibU.bQl();
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
        this.ick = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.13
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.ick.setTitle(e.j.no_disturb_start_time);
        this.ick.setButton(-1, getPageContext().getString(e.j.alert_yes_button), this.ick);
        this.ick.setButton(-2, getPageContext().getString(e.j.cancel), this.ick);
        return this.ick;
    }

    private void bQM() {
        this.ibL = (RelativeLayout) findViewById(e.g.addition_container);
        this.ibM = (TextView) findViewById(e.g.addition_create_time);
        this.ibN = (TextView) findViewById(e.g.addition_last_time);
        this.ibO = (TextView) findViewById(e.g.addition_last_content);
        if (this.ibK != null) {
            this.ibL.setVisibility(0);
            this.ibM.setText(getPageContext().getString(e.j.write_addition_create) + ao.M(this.ibK.getCreateTime() * 1000));
            if (this.ibK.getAlreadyCount() == 0) {
                this.ibN.setVisibility(8);
            } else {
                this.ibN.setText(getPageContext().getString(e.j.write_addition_last) + ao.M(this.ibK.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.ibK.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.ibO.setText(lastAdditionContent);
            } else {
                this.ibO.setVisibility(8);
            }
            bQQ().setHint(String.format(getPageContext().getString(e.j.write_addition_hint), Integer.valueOf(this.ibK.getAlreadyCount()), Integer.valueOf(this.ibK.getTotalCount())));
            this.mName.setText(e.j.write_addition_title);
            return;
        }
        this.ibL.setVisibility(8);
    }

    private void bAA() {
        this.hfc = findViewById(e.g.post_prefix_layout);
        this.heZ = (TextView) findViewById(e.g.post_prefix);
        this.ibH = findViewById(e.g.prefix_divider);
        this.hfb = (ImageView) findViewById(e.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.hfc.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.heC = 1;
            this.hfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TransmitPostEditActivity.this.heZ.setVisibility(0);
                    TransmitPostEditActivity.this.hfc.setSelected(true);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.hfa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                    TransmitPostEditActivity.this.aZb.KM();
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.heU);
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.heY);
                }
            });
            this.hfb = (ImageView) findViewById(e.g.prefix_icon);
            if (size > 1) {
                this.hfb.setVisibility(0);
                this.heZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.15
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TransmitPostEditActivity.this.heZ.setSelected(true);
                        com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(TransmitPostEditActivity.this.hfa, view, 0, l.dip2px(TransmitPostEditActivity.this.getPageContext().getPageActivity(), 1.0f));
                        TransmitPostEditActivity.this.aZb.KM();
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQR());
                        TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQQ());
                    }
                });
            }
            this.hfa = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.hfa.a(this);
            this.hfa.setMaxHeight(l.h(getActivity(), e.C0210e.ds510));
            this.hfa.setOutsideTouchable(true);
            this.hfa.setFocusable(true);
            this.hfa.setOnDismissListener(this);
            this.hfa.setBackgroundDrawable(al.getDrawable(e.d.cp_bg_line_d));
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_cont_c);
            al.i(this.heZ, e.d.cp_bg_line_d);
            al.c(this.hfb, e.f.icon_frs_arrow_n);
            this.heZ.setTextColor(color);
            this.ibI.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.ibI.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    writePrefixItemLayout.setPrefixTextColor(color2);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.hfa.addView(writePrefixItemLayout);
            }
            this.hfa.setCurrentIndex(0);
            this.heZ.setText(prefixs.get(1));
            xI(1);
            return;
        }
        this.hfc.setVisibility(8);
    }

    protected void bQN() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.kV()) {
                    TransmitPostEditActivity.this.showToast(e.j.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (TransmitPostEditActivity.this.icc.a(TransmitPostEditActivity.this.heU, TransmitPostEditActivity.this.heY)) {
                        TransmitPostEditActivity.this.showToast(TransmitPostEditActivity.this.icc.bOx());
                        return;
                    }
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQR());
                    TransmitPostEditActivity.this.HidenSoftKeyPad(TransmitPostEditActivity.this.mInputManager, TransmitPostEditActivity.this.bQQ());
                    TransmitPostEditActivity.this.aZb.KM();
                    TiebaStatic.log(new am("c12608").y("obj_locate", 7));
                    TransmitPostEditActivity.this.bQX();
                }
            }
        });
    }

    protected void bAB() {
        this.heU = (EditText) findViewById(e.g.post_title);
        this.heU.setOnClickListener(this.icg);
        this.heU.setOnFocusChangeListener(this.heS);
        if ((this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) && this.mData.getTitle() != null) {
            this.heU.setText(this.mData.getTitle());
            this.heU.setSelection(this.mData.getTitle().length());
        }
        this.heU.addTextChangedListener(this.ici);
        if (!this.mData.getHaveDraft()) {
            bQJ();
        }
        this.heU.setHint(getResources().getString(e.j.post_title_hint));
    }

    protected void bAD() {
        this.heY = (EditText) findViewById(e.g.post_content);
        this.heY.setDrawingCacheEnabled(false);
        this.heY.setOnClickListener(this.icg);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString ak = TbFaceManager.NL().ak(getPageContext().getPageActivity(), this.mData.getContent());
            this.heY.setText(ak);
            this.heY.setSelection(ak.length());
        }
        this.heY.setOnFocusChangeListener(this.heS);
        this.heY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.TransmitPostEditActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    TransmitPostEditActivity.this.aZb.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TransmitPostEditActivity.this.heY.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.heY.addTextChangedListener(this.icj);
        if (this.mOriginalThreadInfo != null && this.mOriginalThreadInfo.showType == 3) {
            this.heY.setHint(e.j.share_video_default);
        } else {
            this.heY.setHint(e.j.share_txt_default);
        }
    }

    private void bQO() {
        this.fLf = (OriginalThreadCardView) findViewById(e.g.write_original_thread_cardview);
        this.fLf.setVisibility(0);
        this.fLf.b(this.mOriginalThreadInfo);
        this.fLf.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQP() {
        int i = UIMsg.m_AppUI.MSG_APP_GPS;
        if (this.ibK != null) {
            i = 1000;
        }
        return bQQ().getText() != null && bQQ().getText().length() >= i;
    }

    private void hY(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.ibB)) {
                this.ibB = "";
                bQQ().requestFocus();
                if (bQQ().getText() != null && bQQ().getText().length() + str.length() > 5000) {
                    showToast(e.j.over_limit_tip);
                    return;
                } else {
                    i = bQQ().getSelectionStart();
                    editable = bQQ().getText();
                }
            } else if ("from_title".equals(this.ibB)) {
                this.ibB = "";
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
            if (this.ibJ == null) {
                this.ibJ = Toast.makeText(getPageContext().getPageActivity(), e.j.too_many_face, 0);
            }
            this.ibJ.show();
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
                this.ibZ.clear();
                this.ibZ.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.ibZ);
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
        return this.heY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bQR() {
        return this.heU;
    }

    protected void bQS() {
        Editable text;
        if (bQQ() != null && (text = bQQ().getText()) != null) {
            int selectionStart = bQQ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bQQ().onKeyDown(67, this.duo);
            }
            bQQ().onKeyDown(67, this.duo);
            int selectionStart2 = bQQ().getSelectionStart();
            this.ibZ.clear();
            this.ibZ.append((CharSequence) text);
            text.clear();
            text.append((CharSequence) this.ibZ);
            bQQ().setSelection(selectionStart2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.biP.d(null);
        this.biP.ec(e.j.sending);
        this.biP.bB(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.biP.bB(false);
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
                    if (this.heC == 0) {
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
                if (!this.ibW) {
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
        this.baF = new NewWriteModel(this);
        this.baF.b(this.baT);
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
                this.ibK = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.ibK != null);
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
            this.eig = bundle.getString("KEY_CALL_FROM");
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
            this.ibK = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.ibK != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.mPrivateThread = intent.getIntExtra("private_thread", 0);
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.eig = intent.getStringExtra("KEY_CALL_FROM");
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
            this.ibD = true;
        }
        bQK();
    }

    private void bQT() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) v.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.heU.setText(com.baidu.tbadk.plugins.b.iH(com.baidu.tbadk.plugins.b.iI(hotTopicBussinessData.mTopicName)));
            this.heU.setMovementMethod(com.baidu.tieba.view.c.bNx());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        if (hotTopicBussinessData != null) {
            SpannableString iH = com.baidu.tbadk.plugins.b.iH(com.baidu.tbadk.plugins.b.iI(hotTopicBussinessData.mTopicName));
            if (iH != null) {
                this.heU.setText(iH);
            }
            this.ibY.setText(hotTopicBussinessData.mForumName);
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
        if (this.ibK != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.ibK));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.eig);
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
            bQQ().setText(TbFaceManager.NL().a(getPageContext().getPageActivity(), obj, this.ice));
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
        if (this.mPrefixData != null && v.H(this.mPrefixData.getPrefixs()) > 0 && this.heC != 0 && this.mData.getType() != 4 && this.heZ != null && this.heZ.getText() != null) {
            obj = this.heZ.getText().toString() + obj;
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
        if (this.ibR >= 0) {
            this.mData.setCategoryFrom(this.ibR);
        }
        if (this.ibT >= 0) {
            this.mData.setCategoryTo(this.ibT);
        }
        this.mData.setWriteImagesInfo(this.writeImagesInfo);
        this.mData.setHasLocationData(this.baE != null && this.baE.amL());
        this.baF.nD(this.writeImagesInfo.size() > 0);
        if (!v.I(this.mList) && this.ibX != null && this.ibX.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.ibX.mForumId));
            this.mData.setForumName(this.ibX.mForumName);
        }
        this.baF.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        this.baF.getWriteData().setVoice(null);
        this.baF.getWriteData().setVoiceDuringTime(-1);
        if (!com.baidu.adp.lib.util.j.kV()) {
            showToast(e.j.neterror);
            return;
        }
        showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        this.baF.startPostWrite();
    }

    private void u(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.ibK != null) {
                i2 = this.ibK.getTotalCount();
                i = this.ibK.getAlreadyCount() + 1;
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
                if (this.aZb != null && !this.aZb.Ms()) {
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
                        if (this.ibC) {
                            sb2.append(com.baidu.tbadk.plugins.b.bin);
                            this.ibC = false;
                        }
                        sb2.append(stringExtra);
                        hY(sb2.toString());
                    }
                }
            } else if (i == 25005 && intent != null && !v.I(this.mList) && !v.I(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                this.ibX = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                a(this.ibX);
            }
        } else if (i2 == 0) {
            if (this.aZb != null && !this.aZb.Ms()) {
                this.heY.requestFocus();
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
                        this.icc.xK(postWriteCallBackData.getErrorString());
                        this.icc.aA(postWriteCallBackData.getSensitiveWords());
                        this.icc.b(this.heU, this.heY);
                        return;
                    }
                    return;
                case 25004:
                    if ("from_title".equals(this.ibB)) {
                        bQR().requestFocus();
                        return;
                    } else if ("from_content".equals(this.ibB)) {
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
        if ("1".equals(this.eig)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.eig)) {
            this.mData.setCanNoForum(false);
        }
        bQY();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setIsShareThread(true);
        if (this.mOriginalThreadInfo != null && !StringUtils.isNull(this.mOriginalThreadInfo.threadId)) {
            this.mData.setOriginalThreadId(this.mOriginalThreadInfo.threadId);
        }
        this.mData.setCallFrom(this.eig);
        bQW();
    }

    private void bQY() {
        if (this.aZb != null) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(54, 15, null));
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
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dMD) != null) {
                    TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDn));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(e.j.send_share_thread_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.ibK == null) {
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
        this.baK = i;
        if (this.aZb != null) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bQZ() {
        if (!this.ibW && this.aZb != null) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            this.aZb.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        if (this.aZb != null) {
            this.aZb.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void xI(int i) {
        if (i < this.ibI.size()) {
            for (int i2 = 0; i2 < this.ibI.size(); i2++) {
                this.ibI.get(i2).oy(false);
            }
            this.ibI.get(i).oy(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void vj(int i) {
        this.heC = i;
        this.hfa.setCurrentIndex(i);
        xI(i);
        this.heZ.setText(this.mPrefixData.getPrefixs().get(i));
        bAC();
        com.baidu.adp.lib.g.g.a(this.hfa, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.hfc.setSelected(false);
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
        this.icb = z;
        if (this.ica != null && !z) {
            this.ica.bmw();
        }
        if (this.icd != null && !z) {
            bQC();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        super.overridePendingTransition(e.a.activity_open_from_bottom, e.a.activity_close_from_top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2, String str) {
        if (this.icb && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.ibC = false;
            this.ibB = "";
            if ("from_content".equals(str)) {
                this.ibB = "from_content";
            } else if ("from_title".equals(str)) {
                this.ibB = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.iG(String.valueOf(charSequence.charAt(i)))) {
                oH(false);
            }
        }
    }

    public void bwG() {
        if (!v.I(this.mList)) {
            this.ibF.setVisibility(0);
            this.ibF.requestFocus();
            this.aZb.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.ibF.setVisibility(8);
    }
}
