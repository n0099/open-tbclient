package com.baidu.tieba.sharewrite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.e;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.sina.weibo.sdk.constant.WBConstants;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private NewWriteModel aRd;
    private String gKA;
    private String gKB;
    private PackageManager gKC;
    private PackageInfo gKD;
    private int gKE;
    private c gKF;
    b gKG;
    private com.baidu.tieba.sharewrite.a gKJ;
    private com.baidu.tieba.sharewrite.a gKK;
    private String gKy;
    private String gKz;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData mData = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private boolean gKH = false;
    private boolean gKI = false;
    private a.b gKL = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.mData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b gKM = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gKF.buB());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gKF.buC());
            WriteShareActivity.this.buu();
            aVar.dismiss();
        }
    };
    private a.b gKN = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.gKI) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b gKO = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.mData.setShareSummaryImg("");
                WriteShareActivity.this.mData.setShareSummaryImgHeight(0);
                WriteShareActivity.this.mData.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.mData.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.mData.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.mData.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c gKP = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, v vVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.bup();
                if (WriteShareActivity.this.gKJ != null) {
                    WriteShareActivity.this.gKI = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.gKJ.buk();
                }
            } else if (vVar == null || writeData == null || vVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.buq();
                if (WriteShareActivity.this.gKK != null) {
                    WriteShareActivity.this.gKI = false;
                    WriteShareActivity.this.gKK.buk();
                }
            } else {
                writeData.setVcodeMD5(vVar.getVcode_md5());
                writeData.setVcodeUrl(vVar.getVcode_pic_url());
                writeData.setVcodeExtra(vVar.DF());
                WriteShareActivity.this.gKH = true;
                if (com.baidu.tbadk.q.a.il(vVar.DE())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.DE())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener gKQ = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.gKF != null && WriteShareActivity.this.gKF.buD() != null && WriteShareActivity.this.gKF.buD().isShowing()) {
                    g.a(WriteShareActivity.this.gKF.buD(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.bur();
                if (WriteShareActivity.this.gKI) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gKR = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.bur();
            if (WriteShareActivity.this.gKI) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.d(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener gKS = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gKF.buB());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gKF.buC());
            WriteShareActivity.this.buu();
        }
    };
    private View.OnClickListener gKT = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.gKF.buC().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gKF.buC());
        }
    };
    private final View.OnFocusChangeListener gKU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.gKF != null) {
                if (view == WriteShareActivity.this.gKF.buB() || view == WriteShareActivity.this.gKF.buE() || view == WriteShareActivity.this.gKF.buF()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gKF.buB());
                    } else if (view == WriteShareActivity.this.gKF.buB() && WriteShareActivity.this.gKF.buG() != null) {
                        WriteShareActivity.this.gKF.buG().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.gKF.buC()) {
                    if (z) {
                        WriteShareActivity.this.gKF.buC().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.gKF.buC().setHint(e.j.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.gKF.buB());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getWindow().setSoftInputMode(18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteShareActivity.class.getPackage().getName());
        super.onCreate(bundle);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        setSwipeBackEnabled(false);
        this.gKC = getPageContext().getPageActivity().getPackageManager();
        ahR();
        boolean bum = bum();
        initData(bundle);
        initUI();
        if (!bum) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                tF(e.j.share_parameter_invalid_tip);
            } else {
                tF(e.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bun();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void ahR() {
        this.packageName = getCallingPackage();
        if (this.gKC != null && this.packageName != null) {
            try {
                this.gKD = this.gKC.getPackageInfo(this.packageName, 64);
                if (this.gKD != null) {
                    if (this.gKD.applicationInfo != null && this.gKD.applicationInfo.loadLabel(this.gKC) != null) {
                        this.mAppName = this.gKD.applicationInfo.loadLabel(this.gKC).toString();
                    }
                    if (this.gKD.signatures != null && this.gKD.signatures.length > 0 && this.gKD.signatures[0] != null) {
                        this.gKB = ar.E(this.gKD.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.gKB = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.gKy = extras.getString("ShareUrl");
            this.gKz = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.gKA = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.gKB)) {
                this.gKB = extras.getString("appSign");
            }
            this.mAppKey = extras.getString(WBConstants.SSO_APP_KEY);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bum() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.gKz) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        sendMessage(new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void bun() {
        if (TextUtils.isEmpty(this.gKA)) {
            sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            buo();
        }
    }

    private void buo() {
        this.gKF.buw();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gKG.tZ(this.mData.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        if (this.gKJ == null) {
            this.gKJ = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gKJ.mx(false);
            this.gKJ.tB(e.f.icon_send_ok);
            this.gKJ.tE(e.j.share_alert_success);
            this.gKJ.a(e.j.share_stay_in_tieba, this.gKL);
            this.gKJ.b(e.j.back, this.gKN);
            this.gKJ.a(this.gKQ);
            this.gKJ.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buq() {
        if (this.gKK == null) {
            this.gKK = new com.baidu.tieba.sharewrite.a(getActivity());
            this.gKK.tB(e.f.icon_send_error);
            this.gKK.tC(e.f.btn_w_square);
            this.gKK.tD(e.d.common_color_10039);
            this.gKK.tE(e.j.share_alert_fail);
            this.gKK.a(e.j.share_keep_sending, this.gKM);
            this.gKK.b(e.j.back, this.gKN);
            this.gKK.a(this.gKQ);
            this.gKK.f(getPageContext());
        }
    }

    protected void bur() {
        if (this.aRd != null) {
            this.aRd.cancelLoadData();
        }
    }

    protected void bus() {
        if (this.aRd != null) {
            this.aRd.ajs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bur();
        bus();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView buH;
        if (this.gKF != null && (buH = this.gKF.buH()) != null) {
            buH.setImageBitmap(null);
        }
    }

    public WriteData getWriteData() {
        return this.mData;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gKF != null && this.gKF.buD() != null && this.gKF.buD().isShowing()) {
                g.a(this.gKF.buD(), getPageContext().getPageActivity());
                return true;
            }
            bur();
            if (this.gKI) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gKF != null) {
            this.gKF.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(e.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gKF = new c(this);
        this.gKF.T(this.gKR);
        this.gKF.U(this.gKS);
        this.gKF.b(this.gKU);
        this.gKF.V(this.gKT);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private Activity mActivity;

        public a(Activity activity) {
            this.mActivity = null;
            this.mActivity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mActivity != null) {
                WriteShareActivity.this.setResult(0);
                com.baidu.tbadk.core.e.b.d(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void tF(int i) {
        l.g(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aRd = new NewWriteModel(this);
        this.aRd.a(this.gKP);
        this.aRd.a(this.gKO);
        this.gKG = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(e.j.write_no_prefix));
                        if (WriteShareActivity.this.gKF != null) {
                            WriteShareActivity.this.gKF.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gKF.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.gKF.a((PostPrefixData) null);
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.bur();
            }
        };
        this.mData = new WriteData();
        this.mData.setType(3);
        if (bundle != null) {
            this.mData.setForumName(bundle.getString("forum_name"));
            this.mData.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.mData.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.mData.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.mData.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.mData.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.mData.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.mData.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.mData.setForumName(this.gKA);
            this.mData.setShareSummaryTitle(this.mShareTitle);
            this.mData.setShareSummaryContent(this.mShareContent);
            this.mData.setShareApiKey(this.mAppKey);
            this.mData.setShareAppName(this.mAppName);
            this.mData.setShareSignKey(this.gKB);
            this.mData.setShareReferUrl(this.gKy);
            boolean eH = com.baidu.tbadk.core.util.l.eH(this.gKz);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || eH) {
                this.aRd.f(this.mShareLocalImageData, this.gKz);
                this.mData.setShareLocalImageUri(this.gKz);
                this.mData.setShareLocalImageData(this.mShareLocalImageData);
                this.aRd.ase();
                this.mData.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.mData.setShareSummaryImg(this.gKz);
                this.mData.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.mData.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.mData.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.mData.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.mData.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.mData.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.mData.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.mData.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.mData.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.mData.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.mData.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.mData.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.mData.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.mData.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.mData.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.mData.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.mData.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.mData.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.gKF != null && this.gKF.buC() != null && (obj = this.gKF.buC().getEditableText().toString()) != null) {
            this.gKF.buC().setText(TbFaceManager.Kf().al(getPageContext().getContext(), obj));
            this.gKF.buC().setSelection(this.gKF.buC().getText().length());
        }
    }

    public void tG(int i) {
        this.gKE = i;
    }

    public int but() {
        return this.gKE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buu() {
        bur();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.gKE != this.mPrefixData.getPrefixs().size() - 1) {
            this.mData.setTitle(this.gKF.buG().getText().toString() + this.gKF.buB().getText().toString());
        } else {
            this.mData.setTitle(this.gKF.buB().getText().toString());
        }
        this.mData.setContent(this.gKF.buC().getText().toString());
        this.aRd.setWriteData(this.mData);
        this.mData.setVcode(null);
        this.aRd.getWriteData().setVoice(null);
        this.aRd.getWriteData().setVoiceDuringTime(-1);
        if (this.aRd.startPostWrite()) {
            showLoadingDialog(getPageContext().getString(e.j.sending), this.mDialogCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.gKH = false;
            if (i2 == -1) {
                bup();
                if (this.gKJ != null) {
                    this.gKI = true;
                    this.gKJ.buk();
                }
                setResult(-1);
                return;
            }
            buq();
            if (this.gKK != null) {
                this.gKI = false;
                this.gKK.buk();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.gKA = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.mData.setForumName(this.gKA);
                    buo();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bun();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.gKF.buB());
        HidenSoftKeyPad(this.mInputManager, this.gKF.buC());
        super.onPause();
    }

    public void buv() {
        HidenSoftKeyPad(this.mInputManager, this.gKF.buB());
        HidenSoftKeyPad(this.mInputManager, this.gKF.buC());
    }
}
