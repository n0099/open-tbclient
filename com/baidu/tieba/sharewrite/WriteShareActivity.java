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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.a;
import com.baidu.tieba.sharewrite.b;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private PackageManager crv;
    private NewWriteModel dYy;
    private String dtO;
    private String kHI;
    private String kHJ;
    private String kHK;
    private PackageInfo kHL;
    private int kHN;
    private c kHO;
    b kHP;
    private com.baidu.tieba.sharewrite.a kHS;
    private com.baidu.tieba.sharewrite.a kHT;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData kHM = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gPv = null;
    private boolean kHQ = false;
    private boolean kHR = false;
    private a.b kHU = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.kHM.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b kHV = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHO.cSU());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHO.cSV());
            WriteShareActivity.this.cSN();
            aVar.dismiss();
        }
    };
    private a.b kHW = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.kHR) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b kHX = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.kHM.setShareSummaryImg("");
                WriteShareActivity.this.kHM.setShareSummaryImgHeight(0);
                WriteShareActivity.this.kHM.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.kHM.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.kHM.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.kHM.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c kHY = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cSH();
                if (WriteShareActivity.this.kHS != null) {
                    WriteShareActivity.this.kHR = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.kHS.cSC();
                }
            } else if (aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cSI();
                if (WriteShareActivity.this.kHT != null) {
                    WriteShareActivity.this.kHR = false;
                    WriteShareActivity.this.kHT.cSC();
                }
            } else {
                writeData.setVcodeMD5(aaVar.getVcode_md5());
                writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                writeData.setVcodeExtra(aaVar.aSf());
                WriteShareActivity.this.kHQ = true;
                if (com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSe())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener kHZ = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.kHO != null && WriteShareActivity.this.kHO.cSW() != null && WriteShareActivity.this.kHO.cSW().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.kHO.cSW(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cSJ();
                if (WriteShareActivity.this.kHR) {
                    WriteShareActivity.this.setResult(-1);
                } else {
                    WriteShareActivity.this.setResult(0);
                }
                com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
                WriteShareActivity.this.finish();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener kIa = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cSJ();
            if (WriteShareActivity.this.kHR) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener kIb = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHO.cSU());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHO.cSV());
            WriteShareActivity.this.cSN();
        }
    };
    private View.OnClickListener kIc = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.kHO.cSV().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHO.cSV());
        }
    };
    private final View.OnFocusChangeListener fBa = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.kHO != null) {
                if (view == WriteShareActivity.this.kHO.cSU() || view == WriteShareActivity.this.kHO.cSX() || view == WriteShareActivity.this.kHO.cSY()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHO.cSU());
                    } else if (view == WriteShareActivity.this.kHO.cSU() && WriteShareActivity.this.kHO.cSZ() != null) {
                        WriteShareActivity.this.kHO.cSZ().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.kHO.cSV()) {
                    if (z) {
                        WriteShareActivity.this.kHO.cSV().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.kHO.cSV().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHO.cSU());
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
        this.crv = getPageContext().getPageActivity().getPackageManager();
        bpu();
        boolean cSE = cSE();
        initData(bundle);
        initUI();
        if (!cSE) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                CJ(R.string.share_parameter_invalid_tip);
            } else {
                CJ(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cSF();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bpu() {
        this.packageName = getCallingPackage();
        if (this.crv != null && this.packageName != null) {
            try {
                this.kHL = this.crv.getPackageInfo(this.packageName, 64);
                if (this.kHL != null) {
                    if (this.kHL.applicationInfo != null && this.kHL.applicationInfo.loadLabel(this.crv) != null) {
                        this.mAppName = this.kHL.applicationInfo.loadLabel(this.crv).toString();
                    }
                    if (this.kHL.signatures != null && this.kHL.signatures.length > 0 && this.kHL.signatures[0] != null) {
                        this.kHK = as.getAPKHexMD5(this.kHL.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.kHK = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.kHI = extras.getString("ShareUrl");
            this.dtO = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.kHJ = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.kHK)) {
                this.kHK = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cSE() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dtO) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cSF() {
        if (TextUtils.isEmpty(this.kHJ)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cSG();
        }
    }

    private void cSG() {
        this.kHO.cSP();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kHP.Kn(this.kHM.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSH() {
        if (this.kHS == null) {
            this.kHS = new com.baidu.tieba.sharewrite.a(getActivity());
            this.kHS.tD(false);
            this.kHS.CF(R.drawable.icon_send_ok);
            this.kHS.CI(R.string.share_alert_success);
            this.kHS.a(R.string.share_stay_in_tieba, this.kHU);
            this.kHS.b(R.string.back, this.kHW);
            this.kHS.a(this.kHZ);
            this.kHS.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSI() {
        if (this.kHT == null) {
            this.kHT = new com.baidu.tieba.sharewrite.a(getActivity());
            this.kHT.CF(R.drawable.icon_send_error);
            this.kHT.CG(R.drawable.btn_w_square);
            this.kHT.CH(R.color.common_color_10039);
            this.kHT.CI(R.string.share_alert_fail);
            this.kHT.a(R.string.share_keep_sending, this.kHV);
            this.kHT.b(R.string.back, this.kHW);
            this.kHT.a(this.kHZ);
            this.kHT.f(getPageContext());
        }
    }

    protected void cSJ() {
        if (this.dYy != null) {
            this.dYy.cancelLoadData();
        }
    }

    protected void cSK() {
        if (this.dYy != null) {
            this.dYy.cXB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cSJ();
        cSK();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cTa;
        if (this.kHO != null && (cTa = this.kHO.cTa()) != null) {
            cTa.setImageBitmap(null);
        }
    }

    public WriteData cSL() {
        return this.kHM;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kHO != null && this.kHO.cSW() != null && this.kHO.cSW().isShowing()) {
                g.dismissPopupWindow(this.kHO.cSW(), getPageContext().getPageActivity());
                return true;
            }
            cSJ();
            if (this.kHR) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kHO != null) {
            this.kHO.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kHO = new c(this);
        this.kHO.ac(this.kIa);
        this.kHO.ad(this.kIb);
        this.kHO.b(this.fBa);
        this.kHO.ae(this.kIc);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
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
                com.baidu.tbadk.core.e.b.c(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void CJ(int i) {
        l.showLongToast(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.dYy = new NewWriteModel(this);
        this.dYy.a(this.kHY);
        this.dYy.a(this.kHX);
        this.kHP = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.kHO != null) {
                            WriteShareActivity.this.kHO.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.kHO.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.kHO.a((PostPrefixData) null);
            }
        });
        this.gPv = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cSJ();
            }
        };
        this.kHM = new WriteData();
        this.kHM.setType(3);
        if (bundle != null) {
            this.kHM.setForumName(bundle.getString("forum_name"));
            this.kHM.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.kHM.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.kHM.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.kHM.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.kHM.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.kHM.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.kHM.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.kHM.setForumName(this.kHJ);
            this.kHM.setShareSummaryTitle(this.mShareTitle);
            this.kHM.setShareSummaryContent(this.mShareContent);
            this.kHM.setShareApiKey(this.mAppKey);
            this.kHM.setShareAppName(this.mAppName);
            this.kHM.setShareSignKey(this.kHK);
            this.kHM.setShareReferUrl(this.kHI);
            boolean isLocalImagePath = m.isLocalImagePath(this.dtO);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.dYy.d(this.mShareLocalImageData, this.dtO);
                this.kHM.setShareLocalImageUri(this.dtO);
                this.kHM.setShareLocalImageData(this.mShareLocalImageData);
                this.dYy.bLl();
                this.kHM.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.kHM.setShareSummaryImg(this.dtO);
                this.kHM.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.kHM.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.kHM.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.kHM.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.kHM.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.kHM.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.kHM.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.kHM.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.kHM.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.kHM.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.kHM.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.kHM.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.kHM.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.kHM.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.kHM.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.kHM.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.kHM.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.kHM.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.kHO != null && this.kHO.cSV() != null && (obj = this.kHO.cSV().getEditableText().toString()) != null) {
            this.kHO.cSV().setText(TbFaceManager.aYj().aj(getPageContext().getContext(), obj));
            this.kHO.cSV().setSelection(this.kHO.cSV().getText().length());
        }
    }

    public void CK(int i) {
        this.kHN = i;
    }

    public int cSM() {
        return this.kHN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSN() {
        cSJ();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.kHN != this.mPrefixData.getPrefixs().size() - 1) {
            this.kHM.setTitle(this.kHO.cSZ().getText().toString() + this.kHO.cSU().getText().toString());
        } else {
            this.kHM.setTitle(this.kHO.cSU().getText().toString());
        }
        this.kHM.setContent(this.kHO.cSV().getText().toString());
        this.dYy.d(this.kHM);
        this.kHM.setVcode(null);
        this.dYy.cSL().setVoice(null);
        this.dYy.cSL().setVoiceDuringTime(-1);
        if (this.dYy.cXz()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gPv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.kHQ = false;
            if (i2 == -1) {
                cSH();
                if (this.kHS != null) {
                    this.kHR = true;
                    this.kHS.cSC();
                }
                setResult(-1);
                return;
            }
            cSI();
            if (this.kHT != null) {
                this.kHR = false;
                this.kHT.cSC();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.kHJ = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.kHM.setForumName(this.kHJ);
                    cSG();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cSF();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.kHO.cSU());
        HidenSoftKeyPad(this.mInputManager, this.kHO.cSV());
        super.onPause();
    }

    public void cSO() {
        HidenSoftKeyPad(this.mInputManager, this.kHO.cSU());
        HidenSoftKeyPad(this.mInputManager, this.kHO.cSV());
    }
}
