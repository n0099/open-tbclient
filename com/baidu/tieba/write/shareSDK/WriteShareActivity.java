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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a aud;
    private String cjS;
    private String dDU;
    private com.baidu.tieba.write.view.e dUA;
    private String dUo;
    private String dUp;
    private String dUq;
    private String dUr;
    private PackageManager dUs;
    private PackageInfo dUt;
    private int dUu;
    private o dUv;
    com.baidu.tieba.write.shareSDK.a dUw;
    private com.baidu.tieba.write.view.e dUz;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData dJy = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cPd = null;
    private boolean dUx = false;
    private boolean dUy = false;
    private e.b dUB = new c(this);
    private e.b dUC = new g(this);
    private e.b dUD = new h(this);
    private final a.b dUE = new i(this);
    private final a.c dUF = new j(this);
    private DialogInterface.OnKeyListener dUG = new k(this);
    private View.OnClickListener dUH = new l(this);
    private View.OnClickListener dUI = new m(this);
    private View.OnClickListener dUJ = new n(this);
    private final View.OnFocusChangeListener dUK = new d(this);

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
        this.dUs = getPageContext().getPageActivity().getPackageManager();
        aKy();
        boolean aKz = aKz();
        initData(bundle);
        initUI();
        if (!aKz) {
            if (TextUtils.isEmpty(this.dDU)) {
                oi(n.j.share_parameter_invalid_tip);
            } else {
                oi(n.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            aKB();
        } else {
            aKA();
        }
        TiebaStatic.log("share4sdk");
    }

    private void aKy() {
        this.packageName = getCallingPackage();
        if (this.dUs != null && this.packageName != null) {
            try {
                this.dUt = this.dUs.getPackageInfo(this.packageName, 64);
                if (this.dUt != null) {
                    if (this.dUt.applicationInfo != null && this.dUt.applicationInfo.loadLabel(this.dUs) != null) {
                        this.cjS = this.dUt.applicationInfo.loadLabel(this.dUs).toString();
                    }
                    if (this.dUt.signatures != null && this.dUt.signatures.length > 0 && this.dUt.signatures[0] != null) {
                        this.dUr = az.P(this.dUt.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.cjS = null;
                this.dUr = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.dUo = extras.getString("ShareUrl");
            this.dUp = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.dUq = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.cjS)) {
                this.cjS = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.dUr)) {
                this.dUr = extras.getString("appSign");
            }
            this.dDU = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean aKz() {
        return (TextUtils.isEmpty(this.dDU) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.dUp) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void aKA() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void aKB() {
        if (TextUtils.isEmpty(this.dUq)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            aKC();
        }
    }

    private void aKC() {
        this.dUv.aKK();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        this.dUw.no(this.dJy.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKD() {
        if (this.dUz == null) {
            this.dUz = new com.baidu.tieba.write.view.e(getActivity());
            this.dUz.hP(false);
            this.dUz.ol(n.f.icon_send_ok);
            this.dUz.oo(n.j.share_alert_success);
            this.dUz.a(n.j.share_stay_in_tieba, this.dUB);
            this.dUz.b(n.j.back, this.dUD);
            this.dUz.a(this.dUG);
            this.dUz.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKE() {
        if (this.dUA == null) {
            this.dUA = new com.baidu.tieba.write.view.e(getActivity());
            this.dUA.ol(n.f.icon_send_error);
            this.dUA.om(n.f.btn_w_square);
            this.dUA.on(n.d.dialog_bdalert_title);
            this.dUA.oo(n.j.share_alert_fail);
            this.dUA.a(n.j.share_keep_sending, this.dUC);
            this.dUA.b(n.j.back, this.dUD);
            this.dUA.a(this.dUG);
            this.dUA.f(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKF() {
        if (this.aud != null) {
            this.aud.cancelLoadData();
        }
    }

    protected void aKG() {
        if (this.aud != null) {
            this.aud.aGC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        aKF();
        aKG();
        GP();
        super.onDestroy();
    }

    private void GP() {
        ShareSDKImageView aKU;
        if (this.dUv != null && (aKU = this.dUv.aKU()) != null) {
            aKU.setImageBitmap(null);
        }
    }

    public WriteData aGz() {
        return this.dJy;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dUv != null && this.dUv.aKQ() != null && this.dUv.aKQ().isShowing()) {
                com.baidu.adp.lib.h.j.a(this.dUv.aKQ(), getPageContext().getPageActivity());
                return true;
            }
            aKF();
            if (this.dUy) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dUv != null) {
            this.dUv.onChangeSkinType(i);
        }
    }

    private void initUI() {
        setContentView(n.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.dUv = new o(this);
        this.dUv.O(this.dUH);
        this.dUv.P(this.dUI);
        this.dUv.a(this.dUK);
        this.dUv.Q(this.dUJ);
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
                com.baidu.tbadk.core.c.b.b(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void oi(int i) {
        com.baidu.adp.lib.util.k.c(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.aud = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aud.a(this.dUF);
        this.aud.a(this.dUE);
        this.dUw = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.cPd = new f(this);
        this.dJy = new WriteData();
        this.dJy.setType(3);
        if (bundle != null) {
            this.dJy.setForumName(bundle.getString("forum_name"));
            this.dJy.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.dJy.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.dJy.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.dJy.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.dJy.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.dJy.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.dJy.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.dJy.setForumName(this.dUq);
            this.dJy.setShareSummaryTitle(this.mShareTitle);
            this.dJy.setShareSummaryContent(this.mShareContent);
            this.dJy.setShareApiKey(this.dDU);
            this.dJy.setShareAppName(this.cjS);
            this.dJy.setShareSignKey(this.dUr);
            this.dJy.setShareReferUrl(this.dUo);
            boolean df = com.baidu.tbadk.core.util.n.df(this.dUp);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || df) {
                this.aud.c(this.mShareLocalImageData, this.dUp);
                this.dJy.setShareLocalImageUri(this.dUp);
                this.dJy.setShareLocalImageData(this.mShareLocalImageData);
                this.aud.LH();
                this.dJy.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.dJy.setShareSummaryImg(this.dUp);
                this.dJy.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.dJy.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.dJy.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.dJy.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.dJy.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.dJy.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.dJy.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.dJy.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.dJy.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.dJy.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.dJy.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.dJy.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.dJy.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.dJy.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.dJy.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.dJy.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.dJy.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dJy.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.dUv != null && this.dUv.auG() != null && (editable = this.dUv.auG().getEditableText().toString()) != null) {
            this.dUv.auG().setText(TbFaceManager.CL().G(getPageContext().getContext(), editable));
            this.dUv.auG().setSelection(this.dUv.auG().getText().length());
        }
    }

    public void oj(int i) {
        this.dUu = i;
    }

    public int aKH() {
        return this.dUu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKI() {
        aKF();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.dUu != this.mPrefixData.getPrefixs().size() - 1) {
            this.dJy.setTitle(String.valueOf(this.dUv.aKT().getText().toString()) + this.dUv.aKP().getText().toString());
        } else {
            this.dJy.setTitle(this.dUv.aKP().getText().toString());
        }
        this.dJy.setContent(this.dUv.auG().getText().toString());
        this.aud.c(this.dJy);
        this.dJy.setVcode(null);
        this.aud.aGz().setVoice(null);
        this.aud.aGz().setVoiceDuringTime(-1);
        if (this.aud.aGA()) {
            showLoadingDialog(getPageContext().getString(n.j.sending), this.cPd);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.dUx = false;
            if (i2 == -1) {
                aKD();
                if (this.dUz != null) {
                    this.dUy = true;
                    this.dUz.aKX();
                }
                setResult(-1);
                return;
            }
            aKE();
            if (this.dUA != null) {
                this.dUy = false;
                this.dUA.aKX();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.dUq = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.dJy.setForumName(this.dUq);
                    aKC();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                aKB();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.dUv.aKP());
        HidenSoftKeyPad(this.mInputManager, this.dUv.auG());
        super.onPause();
    }

    public void aKJ() {
        HidenSoftKeyPad(this.mInputManager, this.dUv.aKP());
        HidenSoftKeyPad(this.mInputManager, this.dUv.auG());
    }
}
