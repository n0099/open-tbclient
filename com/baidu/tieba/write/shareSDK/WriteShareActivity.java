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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import com.baidu.tieba.write.view.ShareSDKImageView;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
public class WriteShareActivity extends BaseActivity<WriteShareActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a ask;
    private String eUt;
    private String fEJ;
    private String fEK;
    private String fEL;
    private String fEM;
    private PackageManager fEN;
    private PackageInfo fEO;
    private int fEP;
    private o fEQ;
    com.baidu.tieba.write.shareSDK.a fER;
    private com.baidu.tieba.write.view.e fEU;
    private com.baidu.tieba.write.view.e fEV;
    private String mAppName;
    private PostPrefixData mPrefixData;
    private String mShareContent;
    private byte[] mShareLocalImageData;
    private String mShareTitle;
    private String packageName;
    private WriteData fau = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener eeQ = null;
    private boolean fES = false;
    private boolean fET = false;
    private e.b fEW = new c(this);
    private e.b fEX = new g(this);
    private e.b fEY = new h(this);
    private final a.b fEZ = new i(this);
    private final a.c fFa = new j(this);
    private DialogInterface.OnKeyListener fFb = new k(this);
    private View.OnClickListener fFc = new l(this);
    private View.OnClickListener fFd = new m(this);
    private View.OnClickListener fFe = new n(this);
    private final View.OnFocusChangeListener fFf = new d(this);

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
        this.fEN = getPageContext().getPageActivity().getPackageManager();
        bkx();
        boolean bky = bky();
        initData(bundle);
        nl();
        if (!bky) {
            if (TextUtils.isEmpty(this.eUt)) {
                si(u.j.share_parameter_invalid_tip);
            } else {
                si(u.j.share_content_empty_tip);
            }
        } else if (TbadkCoreApplication.isLogin()) {
            bkz();
        } else {
            login();
        }
        TiebaStatic.log("share4sdk");
    }

    private void bkx() {
        this.packageName = getCallingPackage();
        if (this.fEN != null && this.packageName != null) {
            try {
                this.fEO = this.fEN.getPackageInfo(this.packageName, 64);
                if (this.fEO != null) {
                    if (this.fEO.applicationInfo != null && this.fEO.applicationInfo.loadLabel(this.fEN) != null) {
                        this.mAppName = this.fEO.applicationInfo.loadLabel(this.fEN).toString();
                    }
                    if (this.fEO.signatures != null && this.fEO.signatures.length > 0 && this.fEO.signatures[0] != null) {
                        this.fEM = bc.u(this.fEO.signatures[0].toByteArray());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                BdLog.e(e.getMessage());
                this.mAppName = null;
                this.fEM = null;
            }
        }
        try {
            Bundle extras = getIntent().getExtras();
            this.fEJ = extras.getString("ShareUrl");
            this.fEK = extras.getString("ShareImageUrl");
            this.mShareLocalImageData = extras.getByteArray("ShareImageData");
            this.mShareTitle = extras.getString("ShareTitle");
            this.mShareContent = extras.getString("ShareContent");
            this.fEL = extras.getString("ShareTargetBaName");
            if (TextUtils.isEmpty(this.mAppName)) {
                this.mAppName = extras.getString("appName");
            }
            if (TextUtils.isEmpty(this.fEM)) {
                this.fEM = extras.getString("appSign");
            }
            this.eUt = extras.getString("appKey");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean bky() {
        return (TextUtils.isEmpty(this.eUt) || (TextUtils.isEmpty(this.mShareContent) && TextUtils.isEmpty(this.fEK) && this.mShareLocalImageData == null)) ? false : true;
    }

    private void login() {
        TbadkCoreApplication.isSDKLogin = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
    }

    private void bkz() {
        if (TextUtils.isEmpty(this.fEL)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentAccount(), 0, true, 23008)));
        } else {
            bkA();
        }
    }

    private void bkA() {
        this.fEQ.bkI();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        this.fER.qP(this.fau.getForumName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkB() {
        if (this.fEU == null) {
            this.fEU = new com.baidu.tieba.write.view.e(getActivity());
            this.fEU.li(false);
            this.fEU.sk(u.f.icon_send_ok);
            this.fEU.sn(u.j.share_alert_success);
            this.fEU.a(u.j.share_stay_in_tieba, this.fEW);
            this.fEU.b(u.j.back, this.fEY);
            this.fEU.a(this.fFb);
            this.fEU.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkC() {
        if (this.fEV == null) {
            this.fEV = new com.baidu.tieba.write.view.e(getActivity());
            this.fEV.sk(u.f.icon_send_error);
            this.fEV.sl(u.f.btn_w_square);
            this.fEV.sm(u.d.common_color_10039);
            this.fEV.sn(u.j.share_alert_fail);
            this.fEV.a(u.j.share_keep_sending, this.fEX);
            this.fEV.b(u.j.back, this.fEY);
            this.fEV.a(this.fFb);
            this.fEV.g(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkD() {
        if (this.ask != null) {
            this.ask.cancelLoadData();
        }
    }

    protected void bkE() {
        if (this.ask != null) {
            this.ask.bdx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bkD();
        bkE();
        Jd();
        super.onDestroy();
    }

    private void Jd() {
        ShareSDKImageView bkS;
        if (this.fEQ != null && (bkS = this.fEQ.bkS()) != null) {
            bkS.setImageBitmap(null);
        }
    }

    public WriteData bdu() {
        return this.fau;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fEQ != null && this.fEQ.bkO() != null && this.fEQ.bkO().isShowing()) {
                com.baidu.adp.lib.h.j.a(this.fEQ.bkO(), getPageContext().getPageActivity());
                return true;
            }
            bkD();
            if (this.fET) {
                setResult(-1);
            } else {
                setResult(0);
            }
            com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fEQ != null) {
            this.fEQ.onChangeSkinType(i);
        }
    }

    private void nl() {
        setContentView(u.h.write_share_activity);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.fEQ = new o(this);
        this.fEQ.S(this.fFc);
        this.fEQ.T(this.fFd);
        this.fEQ.a(this.fFf);
        this.fEQ.U(this.fFe);
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
                com.baidu.tbadk.core.d.b.c(this.mActivity, 200, false);
                this.mActivity.finish();
            }
        }
    }

    public void si(int i) {
        com.baidu.adp.lib.util.k.b(getPageContext().getContext(), i);
        new Handler().postDelayed(new a(getPageContext().getPageActivity()), 3500L);
    }

    private void initData(Bundle bundle) {
        this.ask = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.ask.a(this.fFa);
        this.ask.a(this.fEZ);
        this.fER = new com.baidu.tieba.write.shareSDK.a(this, new e(this));
        this.eeQ = new f(this);
        this.fau = new WriteData();
        this.fau.setType(3);
        if (bundle != null) {
            this.fau.setForumName(bundle.getString("forum_name"));
            this.fau.setShareSummaryTitle(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE));
            this.fau.setShareSummaryContent(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT));
            this.fau.setShareSummaryImg(bundle.getString(WriteShareActivityConfig.SHARE_SUMMARY_IMG));
            this.fau.setShareApiKey(bundle.getString(WriteShareActivityConfig.SHARE_API_KEY));
            this.fau.setShareAppName(bundle.getString(WriteShareActivityConfig.SHARE_APP_NAME));
            this.fau.setShareSignKey(bundle.getString(WriteShareActivityConfig.SHARE_SIGN_KEY));
            this.fau.setShareReferUrl(bundle.getString(WriteShareActivityConfig.SHARE_REFER_URL));
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
        } else {
            this.fau.setForumName(this.fEL);
            this.fau.setShareSummaryTitle(this.mShareTitle);
            this.fau.setShareSummaryContent(this.mShareContent);
            this.fau.setShareApiKey(this.eUt);
            this.fau.setShareAppName(this.mAppName);
            this.fau.setShareSignKey(this.fEM);
            this.fau.setShareReferUrl(this.fEJ);
            boolean dd = com.baidu.tbadk.core.util.m.dd(this.fEK);
            if ((this.mShareLocalImageData != null && this.mShareLocalImageData.length > 0) || dd) {
                this.ask.d(this.mShareLocalImageData, this.fEK);
                this.fau.setShareLocalImageUri(this.fEK);
                this.fau.setShareLocalImageData(this.mShareLocalImageData);
                this.ask.TM();
                this.fau.setShareImageType(WriteData.SHARE_SDK_LOCAL_IMAGE);
            } else {
                this.fau.setShareSummaryImg(this.fEK);
                this.fau.setShareImageType(WriteData.SHARE_SDK_NET_IMAGE);
            }
        }
        String shareSummaryImg = this.fau.getShareSummaryImg();
        if (shareSummaryImg == null || shareSummaryImg.trim().length() == 0) {
            this.fau.setShareSummaryImg("");
        }
        String shareSummaryTitle = this.fau.getShareSummaryTitle();
        if (shareSummaryTitle == null || shareSummaryTitle.trim().length() == 0) {
            this.fau.setShareSummaryTitle("");
        }
        String shareSummaryContent = this.fau.getShareSummaryContent();
        if (shareSummaryContent == null || shareSummaryContent.trim().length() == 0) {
            this.fau.setShareSummaryContent("");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("forum_name", this.fau.getForumName());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_TITLE, this.fau.getShareSummaryTitle());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_CONTENT, this.fau.getShareSummaryContent());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG, this.fau.getShareSummaryImg());
        bundle.putString(WriteShareActivityConfig.SHARE_REFER_URL, this.fau.getShareReferUrl());
        bundle.putString(WriteShareActivityConfig.SHARE_API_KEY, this.fau.getShareApiKey());
        bundle.putString(WriteShareActivityConfig.SHARE_APP_NAME, this.fau.getShareAppName());
        bundle.putString(WriteShareActivityConfig.SHARE_SIGN_KEY, this.fau.getShareSignKey());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, this.fau.getShareSummaryImgWidth());
        bundle.putInt(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, this.fau.getShareSummaryImgHeight());
        bundle.putString(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fau.getShareSummaryImgType());
        bundle.putSerializable("prefix_data", this.mPrefixData);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String editable;
        super.onRestoreInstanceState(bundle);
        if (this.fEQ != null && this.fEQ.aRU() != null && (editable = this.fEQ.aRU().getEditableText().toString()) != null) {
            this.fEQ.aRU().setText(TbFaceManager.CP().z(getPageContext().getContext(), editable));
            this.fEQ.aRU().setSelection(this.fEQ.aRU().getText().length());
        }
    }

    public void sj(int i) {
        this.fEP = i;
    }

    public int bkF() {
        return this.fEP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        bkD();
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.fEP != this.mPrefixData.getPrefixs().size() - 1) {
            this.fau.setTitle(String.valueOf(this.fEQ.bkR().getText().toString()) + this.fEQ.bkN().getText().toString());
        } else {
            this.fau.setTitle(this.fEQ.bkN().getText().toString());
        }
        this.fau.setContent(this.fEQ.aRU().getText().toString());
        this.ask.d(this.fau);
        this.fau.setVcode(null);
        this.ask.bdu().setVoice(null);
        this.ask.bdu().setVoiceDuringTime(-1);
        if (this.ask.bdv()) {
            showLoadingDialog(getPageContext().getString(u.j.sending), this.eeQ);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            this.fES = false;
            if (i2 == -1) {
                bkB();
                if (this.fEU != null) {
                    this.fET = true;
                    this.fEU.bli();
                }
                setResult(-1);
                return;
            }
            bkC();
            if (this.fEV != null) {
                this.fET = false;
                this.fEV.bli();
            }
            setResult(0);
        } else if (i == 23008) {
            if (i2 == -1) {
                if (intent != null) {
                    this.fEL = intent.getStringExtra(PersonBarActivityConfig.BAR_NAME);
                    this.fau.setForumName(this.fEL);
                    bkA();
                    return;
                }
                finish();
                return;
            }
            finish();
        } else if (i == 11003) {
            TbadkCoreApplication.isSDKLogin = false;
            if (i2 == -1) {
                bkz();
            } else {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.fEQ.bkN());
        HidenSoftKeyPad(this.mInputManager, this.fEQ.aRU());
        super.onPause();
    }

    public void bkH() {
        HidenSoftKeyPad(this.mInputManager, this.fEQ.bkN());
        HidenSoftKeyPad(this.mInputManager, this.fEQ.aRU());
    }
}
