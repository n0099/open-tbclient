package com.baidu.tieba.write.shareSDK;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ShareSDKImageView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a arO;
    private int cRS;
    private o cRT;
    com.baidu.tieba.write.shareSDK.a cRU;
    private com.baidu.tieba.write.view.e cRX;
    private com.baidu.tieba.write.view.e cRY;
    private String czp;
    private String czq;
    private String czr;
    private String czs;
    private String czt;
    private String czu;
    private PackageManager czv;
    private PackageInfo czw;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData cKS = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cjo = null;
    private boolean cRV = false;
    private boolean cRW = false;
    private e.b cRZ = new c(this);
    private e.b cSa = new g(this);
    private e.b cSb = new h(this);
    private final a.b cSc = new i(this);
    private final a.c cSd = new j(this);
    private DialogInterface.OnKeyListener cSe = new k(this);
    private View.OnClickListener cSf = new l(this);
    private View.OnClickListener cSg = new m(this);
    private View.OnClickListener cSh = new n(this);
    private final View.OnFocusChangeListener cSi = new d(this);

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
        this.czv = getPageContext().getPageActivity().getPackageManager();
        amD();
        boolean auk = auk();
        initData(bundle);
        initUI();
        if (!auk) {
            if (TextUtils.isEmpty(this.czt)) {
                ko(i.C0057i.share_parameter_invalid_tip);
            } else {
                ko(i.C0057i.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            amF();
        } else {
            Go();
        }
        TiebaStatic.log("share4sdk");
    }

    private void amD() {
        this.packageName = getCallingPackage();
        if (this.czv != null && this.packageName != null) {
            try {
                this.czw = this.czv.getPackageInfo(this.packageName, 64);
                if (this.czw != null) {
                    if (this.czw.applicationInfo != null && this.czw.applicationInfo.loadLabel(this.czv) != null) {
                        this.czs = this.czw.applicationInfo.loadLabel(this.czv).toString();
                    }
                    if (this.czw.signatures != null && this.czw.signatures.length > 0 && this.czw.signatures[0] != null) {
                        this.czu = as.P(this.czw.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.czs = null;
                this.czu = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.czp = extras.getString("ShareUrl");
            this.czq = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.czr = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.czs)) {
                this.czs = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.czu)) {
                this.czu = extras.getString("appSign");
            }
            this.czt = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean auk() {
        return (TextUtils.isEmpty(this.czt) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.czq) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void Go() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void amF() {
        if (TextUtils.isEmpty(this.czr)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aul();
        }
    }

    private void aul() {
        this.cRT.aut();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.cRU.lb(this.cKS.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aum() {
        if (this.cRX == null) {
            this.cRX = new com.baidu.tieba.write.view.e(getActivity());
            this.cRX.fV(false);
            this.cRX.kr(i.e.icon_send_ok);
            this.cRX.ku(i.C0057i.share_alert_success);
            this.cRX.a(i.C0057i.share_stay_in_tieba, this.cRZ);
            this.cRX.b(i.C0057i.back, this.cSb);
            this.cRX.a(this.cSe);
            this.cRX.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aun() {
        if (this.cRY == null) {
            this.cRY = new com.baidu.tieba.write.view.e(getActivity());
            this.cRY.kr(i.e.icon_send_error);
            this.cRY.ks(i.e.btn_w_square);
            this.cRY.kt(i.c.dialog_bdalert_title);
            this.cRY.ku(i.C0057i.share_alert_fail);
            this.cRY.a(i.C0057i.share_keep_sending, this.cSa);
            this.cRY.b(i.C0057i.back, this.cSb);
            this.cRY.a(this.cSe);
            this.cRY.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auo() {
        if (this.arO != null) {
            this.arO.cancelLoadData();
        }
    }

    protected void aup() {
        if (this.arO != null) {
            this.arO.arf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        auo();
        aup();
        FF();
        super.onDestroy();
    }

    private void FF() {
        ShareSDKImageView auE;
        if (this.cRT != null && (auE = this.cRT.auE()) != null) {
            auE.setImageBitmap(null);
        }
    }

    public WriteData ard() {
        return this.cKS;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cRT != null && this.cRT.auA() != null && this.cRT.auA().isShowing()) {
                com.baidu.adp.lib.g.j.a(this.cRT.auA(), getPageContext().getPageActivity());
                return true;
            }
            auo();
            if (this.cRW) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cRT != null) {
            this.cRT.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(i.g.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cRT = new o(this);
        this.cRT.I(this.cSf);
        this.cRT.J(this.cSg);
        this.cRT.a(this.cSi);
        this.cRT.K(this.cSh);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
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
                com.baidu.tbadk.core.c.b.a(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void ko(int i) {
        com.baidu.adp.lib.util.k.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.arO = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.arO.a(this.cSd);
        this.arO.a(this.cSc);
        this.cRU = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.cjo = new f(this);
        this.cKS = new WriteData();
        this.cKS.setType(3);
        if (bundle != null) {
            this.cKS.setForumName(bundle.getString("forum_name"));
            this.cKS.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.cKS.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.cKS.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.cKS.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.cKS.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.cKS.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.cKS.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.cKS.setForumName(this.czr);
            this.cKS.setShareSummaryTitle(this.mShareTitle);
            this.cKS.setShareSummaryContent(this.mShareContent);
            this.cKS.setShareApiKey(this.czt);
            this.cKS.setShareAppName(this.czs);
            this.cKS.setShareSignKey(this.czu);
            this.cKS.setShareReferUrl(this.czp);
            boolean cL = com.baidu.tbadk.core.util.n.cL(this.czq);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || cL) {
                this.arO.c(this.mShareLocalImageData, this.czq);
                this.cKS.setShareLocalImageUri(this.czq);
                this.cKS.setShareLocalImageData(this.mShareLocalImageData);
                this.arO.JZ();
                this.cKS.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.cKS.setShareSummaryImg(this.czq);
                this.cKS.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.cKS.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.cKS.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.cKS.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.cKS.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.cKS.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.cKS.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.cKS.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.cKS.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.cKS.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.cKS.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.cKS.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.cKS.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.cKS.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.cKS.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.cKS.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.cKS.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cKS.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.cRT != null && this.cRT.auz() != null && (editable = this.cRT.auz().getEditableText().toString()) != null) {
            this.cRT.auz().setText(TbFaceManager.Cd().H(getPageContext().getContext(), editable));
            this.cRT.auz().setSelection(this.cRT.auz().getText().length());
        }
    }

    public void kp(int i) {
        this.cRS = i;
    }

    public int auq() {
        return this.cRS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aur() {
        auo();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cRS != this.mPrefixData.getPrefixs().size() - 1) {
            this.cKS.setTitle(String.valueOf(this.cRT.auD().getText().toString()) + this.cRT.auy().getText().toString());
        } else {
            this.cKS.setTitle(this.cRT.auy().getText().toString());
        }
        this.cKS.setContent(this.cRT.auz().getText().toString());
        this.arO.c(this.cKS);
        this.cKS.setVcode(null);
        this.arO.ard().setVoice(null);
        this.arO.ard().setVoiceDuringTime(-1);
        if (this.arO.are()) {
            showLoadingDialog(getPageContext().getString(i.C0057i.sending), this.cjo);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.cRV = false;
            if (i2 == -1) {
                aum();
                if (this.cRX != null) {
                    this.cRW = true;
                    this.cRX.auH();
                }
                setResult(-1);
                return;
            }
            aun();
            if (this.cRY != null) {
                this.cRW = false;
                this.cRY.auH();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.czr = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.cKS.setForumName(this.czr);
                    aul();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                amF();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cRT.auy());
        HidenSoftKeyPad(this.mInputManager, this.cRT.auz());
        super.onPause();
    }

    public void aus() {
        HidenSoftKeyPad(this.mInputManager, this.cRT.auy());
        HidenSoftKeyPad(this.mInputManager, this.cRT.auz());
    }
}
