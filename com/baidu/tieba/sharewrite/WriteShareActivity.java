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
    private PackageManager crp;
    private NewWriteModel dYt;
    private String dtK;
    private String kHE;
    private String kHF;
    private String kHG;
    private PackageInfo kHH;
    private int kHJ;
    private c kHK;
    b kHL;
    private com.baidu.tieba.sharewrite.a kHO;
    private com.baidu.tieba.sharewrite.a kHP;
    private String mAppKey;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData kHI = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener gPp = null;
    private boolean kHM = false;
    private boolean kHN = false;
    private a.b kHQ = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.1
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity()).createBackSpecialCfg(WriteShareActivity.this.kHI.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
            aVar.dismiss();
            WriteShareActivity.this.finish();
        }
    };
    private a.b kHR = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.5
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHK.cSW());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHK.cSX());
            WriteShareActivity.this.cSP();
            aVar.dismiss();
        }
    };
    private a.b kHS = new a.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.6
        @Override // com.baidu.tieba.sharewrite.a.b
        public void a(com.baidu.tieba.sharewrite.a aVar) {
            aVar.dismiss();
            if (!WriteShareActivity.this.kHN) {
                WriteShareActivity.this.setResult(0);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private final NewWriteModel.b kHT = new NewWriteModel.b() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.7
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.b
        public void a(ImageUploadResult imageUploadResult, boolean z) {
            if (imageUploadResult == null || imageUploadResult.picInfo == null || imageUploadResult.picInfo.originPic == null) {
                WriteShareActivity.this.kHI.setShareSummaryImg("");
                WriteShareActivity.this.kHI.setShareSummaryImgHeight(0);
                WriteShareActivity.this.kHI.setShareSummaryImgWidth(0);
                return;
            }
            WriteShareActivity.this.kHI.setShareSummaryImg(imageUploadResult.picInfo.originPic.picUrl);
            WriteShareActivity.this.kHI.setShareSummaryImgHeight(imageUploadResult.picInfo.originPic.height);
            WriteShareActivity.this.kHI.setShareSummaryImgWidth(imageUploadResult.picInfo.originPic.width);
        }
    };
    private final NewWriteModel.c kHU = new NewWriteModel.c() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.8
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.c
        public void a(boolean z, String str, aa aaVar, WriteData writeData, AntiData antiData) {
            WriteShareActivity.this.closeLoadingDialog();
            if (z) {
                WriteShareActivity.this.cSJ();
                if (WriteShareActivity.this.kHO != null) {
                    WriteShareActivity.this.kHN = true;
                    WriteShareActivity.this.setResult(-1);
                    WriteShareActivity.this.kHO.cSE();
                }
            } else if (aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null) {
                WriteShareActivity.this.cSK();
                if (WriteShareActivity.this.kHP != null) {
                    WriteShareActivity.this.kHN = false;
                    WriteShareActivity.this.kHP.cSE();
                }
            } else {
                writeData.setVcodeMD5(aaVar.getVcode_md5());
                writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                writeData.setVcodeExtra(aaVar.aSi());
                WriteShareActivity.this.kHM = true;
                if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSh())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteShareActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                }
            }
        }
    };
    private DialogInterface.OnKeyListener kHV = new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.9
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (WriteShareActivity.this.kHK != null && WriteShareActivity.this.kHK.cSY() != null && WriteShareActivity.this.kHK.cSY().isShowing()) {
                    g.dismissPopupWindow(WriteShareActivity.this.kHK.cSY(), WriteShareActivity.this.getPageContext().getPageActivity());
                    return true;
                }
                WriteShareActivity.this.cSL();
                if (WriteShareActivity.this.kHN) {
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
    private View.OnClickListener kHW = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.12
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.cSL();
            if (WriteShareActivity.this.kHN) {
                WriteShareActivity.this.setResult(-1);
            }
            com.baidu.tbadk.core.e.b.c(WriteShareActivity.this.getPageContext().getPageActivity(), 200, false);
            WriteShareActivity.this.finish();
        }
    };
    private View.OnClickListener kHX = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHK.cSW());
            WriteShareActivity.this.HidenSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHK.cSX());
            WriteShareActivity.this.cSP();
        }
    };
    private View.OnClickListener kHY = new View.OnClickListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteShareActivity.this.kHK.cSX().requestFocus();
            WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHK.cSX());
        }
    };
    private final View.OnFocusChangeListener fAV = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (WriteShareActivity.this.kHK != null) {
                if (view == WriteShareActivity.this.kHK.cSW() || view == WriteShareActivity.this.kHK.cSZ() || view == WriteShareActivity.this.kHK.cTa()) {
                    if (z) {
                        WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHK.cSW());
                    } else if (view == WriteShareActivity.this.kHK.cSW() && WriteShareActivity.this.kHK.cTb() != null) {
                        WriteShareActivity.this.kHK.cTb().setVisibility(0);
                    }
                }
                if (view == WriteShareActivity.this.kHK.cSX()) {
                    if (z) {
                        WriteShareActivity.this.kHK.cSX().setHint((CharSequence) null);
                    } else {
                        WriteShareActivity.this.kHK.cSX().setHint(R.string.content);
                    }
                    WriteShareActivity.this.ShowSoftKeyPad(WriteShareActivity.this.mInputManager, WriteShareActivity.this.kHK.cSW());
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
        this.crp = getPageContext().getPageActivity().getPackageManager();
        bpw();
        boolean cSG = cSG();
        initData(bundle);
        initUI();
        if (!cSG) {
            if (TextUtils.isEmpty(this.mAppKey)) {
                CJ(R.string.share_parameter_invalid_tip);
            } else {
                CJ(R.string.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            cSH();
        } else {
            login();
        }
        TiebaStatic.log(CommonStatisticKey.SHARE4SDK);
    }

    private void bpw() {
        this.packageName = getCallingPackage();
        if (this.crp != null && this.packageName != null) {
            try {
                this.kHH = this.crp.getPackageInfo(this.packageName, 64);
                if (this.kHH != null) {
                    if (this.kHH.applicationInfo != null && this.kHH.applicationInfo.loadLabel(this.crp) != null) {
                        this.mAppName = this.kHH.applicationInfo.loadLabel(this.crp).toString();
                    }
                    if (this.kHH.signatures != null && this.kHH.signatures.length > 0 && this.kHH.signatures[0] != null) {
                        this.kHG = as.getAPKHexMD5(this.kHH.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.kHG = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.kHE = extras.getString("ShareUrl");
            this.dtK = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.kHF = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.kHG)) {
                this.kHG = extras.getString("appSign");
            }
            this.mAppKey = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean cSG() {
        return (TextUtils.isEmpty(this.mAppKey) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dtK) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
    }

    private void cSH() {
        if (TextUtils.isEmpty(this.kHF)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, RequestResponseCode.REQUEST_SHARE_FORUM_INFO)));
        } else {
            cSI();
        }
    }

    private void cSI() {
        this.kHK.cSR();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.kHL.Kk(this.kHI.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSJ() {
        if (this.kHO == null) {
            this.kHO = new com.baidu.tieba.sharewrite.a(getActivity());
            this.kHO.tD(false);
            this.kHO.CF(R.drawable.icon_send_ok);
            this.kHO.CI(R.string.share_alert_success);
            this.kHO.a(R.string.share_stay_in_tieba, this.kHQ);
            this.kHO.b(R.string.back, this.kHS);
            this.kHO.a(this.kHV);
            this.kHO.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSK() {
        if (this.kHP == null) {
            this.kHP = new com.baidu.tieba.sharewrite.a(getActivity());
            this.kHP.CF(R.drawable.icon_send_error);
            this.kHP.CG(R.drawable.btn_w_square);
            this.kHP.CH(R.color.common_color_10039);
            this.kHP.CI(R.string.share_alert_fail);
            this.kHP.a(R.string.share_keep_sending, this.kHR);
            this.kHP.b(R.string.back, this.kHS);
            this.kHP.a(this.kHV);
            this.kHP.f(getPageContext());
        }
    }

    protected void cSL() {
        if (this.dYt != null) {
            this.dYt.cancelLoadData();
        }
    }

    protected void cSM() {
        if (this.dYt != null) {
            this.dYt.cXD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        cSL();
        cSM();
        releaseResource();
        super.onDestroy();
    }

    private void releaseResource() {
        ShareSDKImageView cTc;
        if (this.kHK != null && (cTc = this.kHK.cTc()) != null) {
            cTc.setImageBitmap(null);
        }
    }

    public WriteData cSN() {
        return this.kHI;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.kHK != null && this.kHK.cSY() != null && this.kHK.cSY().isShowing()) {
                g.dismissPopupWindow(this.kHK.cSY(), getPageContext().getPageActivity());
                return true;
            }
            cSL();
            if (this.kHN) {
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
        if (this.kHK != null) {
            this.kHK.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(R.layout.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kHK = new c(this);
        this.kHK.ac(this.kHW);
        this.kHK.ad(this.kHX);
        this.kHK.b(this.fAV);
        this.kHK.ae(this.kHY);
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
        this.dYt = new NewWriteModel(this);
        this.dYt.a(this.kHU);
        this.dYt.a(this.kHT);
        this.kHL = new b(this, new b.a() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.10
            @Override // com.baidu.tieba.sharewrite.b.a
            public void a(boolean z, PostPrefixData postPrefixData) {
                if (z) {
                    WriteShareActivity.this.mPrefixData = postPrefixData;
                    if (WriteShareActivity.this.mPrefixData != null && WriteShareActivity.this.mPrefixData.getPrefixs().size() > 0) {
                        WriteShareActivity.this.mPrefixData.getPrefixs().add(WriteShareActivity.this.getPageContext().getString(R.string.write_no_prefix));
                        if (WriteShareActivity.this.kHK != null) {
                            WriteShareActivity.this.kHK.a(WriteShareActivity.this.mPrefixData);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.kHK.a((PostPrefixData) null);
            }

            @Override // com.baidu.tieba.sharewrite.b.a
            public void onFailure() {
                WriteShareActivity.this.mPrefixData = null;
                WriteShareActivity.this.kHK.a((PostPrefixData) null);
            }
        });
        this.gPp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.sharewrite.WriteShareActivity.11
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteShareActivity.this.destroyWaitingDialog();
                WriteShareActivity.this.cSL();
            }
        };
        this.kHI = new WriteData();
        this.kHI.setType(3);
        if (bundle != null) {
            this.kHI.setForumName(bundle.getString("forum_name"));
            this.kHI.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.kHI.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.kHI.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.kHI.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.kHI.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.kHI.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.kHI.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.kHI.setForumName(this.kHF);
            this.kHI.setShareSummaryTitle(this.mShareTitle);
            this.kHI.setShareSummaryContent(this.mShareContent);
            this.kHI.setShareApiKey(this.mAppKey);
            this.kHI.setShareAppName(this.mAppName);
            this.kHI.setShareSignKey(this.kHG);
            this.kHI.setShareReferUrl(this.kHE);
            boolean isLocalImagePath = m.isLocalImagePath(this.dtK);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || isLocalImagePath) {
                this.dYt.e(this.mShareLocalImageData, this.dtK);
                this.kHI.setShareLocalImageUri(this.dtK);
                this.kHI.setShareLocalImageData(this.mShareLocalImageData);
                this.dYt.bLm();
                this.kHI.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.kHI.setShareSummaryImg(this.dtK);
                this.kHI.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.kHI.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.kHI.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.kHI.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.kHI.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.kHI.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.kHI.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.kHI.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.kHI.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.kHI.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.kHI.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.kHI.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.kHI.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.kHI.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.kHI.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.kHI.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.kHI.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.kHI.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String obj;
        super.onRestoreInstanceState(bundle);
        if (this.kHK != null && this.kHK.cSX() != null && (obj = this.kHK.cSX().getEditableText().toString()) != null) {
            this.kHK.cSX().setText(TbFaceManager.aYl().av(getPageContext().getContext(), obj));
            this.kHK.cSX().setSelection(this.kHK.cSX().getText().length());
        }
    }

    public void CK(int i) {
        this.kHJ = i;
    }

    public int cSO() {
        return this.kHJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSP() {
        cSL();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.kHJ != this.mPrefixData.getPrefixs().size() - 1) {
            this.kHI.setTitle(this.kHK.cTb().getText().toString() + this.kHK.cSW().getText().toString());
        } else {
            this.kHI.setTitle(this.kHK.cSW().getText().toString());
        }
        this.kHI.setContent(this.kHK.cSX().getText().toString());
        this.dYt.d(this.kHI);
        this.kHI.setVcode(null);
        this.dYt.cSN().setVoice(null);
        this.dYt.cSN().setVoiceDuringTime(-1);
        if (this.dYt.cXB()) {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.gPp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.kHM = false;
            if (i2 == -1) {
                cSJ();
                if (this.kHO != null) {
                    this.kHN = true;
                    this.kHO.cSE();
                }
                setResult(-1);
                return;
            }
            cSK();
            if (this.kHP != null) {
                this.kHN = false;
                this.kHP.cSE();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.kHF = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.kHI.setForumName(this.kHF);
                    cSI();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                cSH();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.kHK.cSW());
        HidenSoftKeyPad(this.mInputManager, this.kHK.cSX());
        super.onPause();
    }

    public void cSQ() {
        HidenSoftKeyPad(this.mInputManager, this.kHK.cSW());
        HidenSoftKeyPad(this.mInputManager, this.kHK.cSX());
    }
}
