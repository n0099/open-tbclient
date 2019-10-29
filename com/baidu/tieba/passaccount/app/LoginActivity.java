package com.baidu.tieba.passaccount.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.g.h;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.activity.social.BaseSSOLoginActivity;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private String agP;
    private c cul;
    private BdAsyncTask<?, ?, ?> dgE;
    private WebAuthResult hFk;
    private Activity hFl;
    private String hFo;
    private String hFq;
    private int hFr;
    private boolean hFs;
    private int hFj = 1;
    private String hFm = null;
    private int hFn = -2;
    private boolean mClose = false;
    private int hFp = -1;
    private final a.InterfaceC0280a dhc = new a.InterfaceC0280a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0280a
        public void onBeforeLogin(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().isShowing()) {
                LoginActivity.this.showLoadingDialog(LoginActivity.this.getPageContext().getString(R.string.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.3.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        LoginActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0280a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new an("c12948").O("obj_type", LoginActivity.this.hFj).bS(TiebaInitialize.Params.OBJ_URL, LoginActivity.this.hFo));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.o(accountData);
            } else {
                LoginActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0280a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.hFl instanceof BaseSSOLoginActivity) {
                LoginActivity.this.hFl.finish();
            }
            LoginActivity.this.wh(0);
        }
    };

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoginActivityConfig.lastStartActivityTime = System.currentTimeMillis();
        bPi();
        bPj();
        TiebaStatic.log(new an("c12947").bS(TiebaInitialize.Params.OBJ_URL, this.hFo));
    }

    private void bPi() {
        Intent intent = getIntent();
        this.mClose = intent.getBooleanExtra("close", false);
        this.hFp = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.hFo = intent.getStringExtra("url");
        this.hFr = intent.getIntExtra(LoginActivityConfig.SOCIAL_TYPE, 0);
        this.hFq = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.agP = intent.getStringExtra("activity_id");
        this.hFs = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
    }

    protected void bPj() {
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception e) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SAPI_INIT, TbadkCoreApplication.getInst().getApp()));
        }
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_INIT_RIM_SDK, (Class) null);
        PassManagerStatic.bPt();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && confignation.fastLoginFeatureList != null) {
            confignation.fastLoginFeatureList.clear();
            confignation.fastLoginFeatureList.addAll(PassManagerStatic.bPr());
        }
        bPm();
        if (bPk()) {
            wg(this.hFr);
        } else {
            bJE();
        }
    }

    private boolean bPk() {
        return this.hFr == 1 || this.hFr == 2 || this.hFr == 3;
    }

    private void bJE() {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        if (d.ft().af("android_pass_login_sms_enable") == 1) {
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
        passportSDK.startLogin(getActivity(), new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.hFk = webAuthResult;
                LoginActivity.this.hFl = webAuthResult.activity;
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                LoginActivity.this.bPl();
                LoginActivity.this.hFn = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                LoginActivity.this.hFn = -1;
                LoginActivity.this.wh(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        }, webLoginDTO);
    }

    private void wg(int i) {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        if (i == 1) {
            webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
        } else if (i == 2) {
            webSocialLoginDTO.socialType = SocialType.WEIXIN;
        } else if (i == 3) {
            webSocialLoginDTO.socialType = SocialType.QQ_SSO;
        }
        WebAuthListener webAuthListener = new WebAuthListener() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.2
            @Override // com.baidu.sapi2.shell.listener.WebAuthListener
            public void beforeSuccess(SapiAccount sapiAccount) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.this.hFk = webAuthResult;
                LoginActivity.this.hFl = webAuthResult.activity;
                LoginActivity.this.bPl();
                LoginActivity.this.hFn = 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.this.hFn = -1;
                LoginActivity.this.wh(0);
            }

            @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                super.onFinish();
            }
        };
        if (this.hFs) {
            try {
                Field declaredField = passportSDK.getClass().getDeclaredField("webAuthListener");
                declaredField.setAccessible(true);
                declaredField.set(passportSDK, webAuthListener);
                Field declaredField2 = passportSDK.getClass().getDeclaredField("socialLoginDTO");
                declaredField2.setAccessible(true);
                declaredField2.set(passportSDK, webSocialLoginDTO);
                AbstractThirdPartyService thirdPartyService = passportSDK.getThirdPartyService();
                if (thirdPartyService != null) {
                    thirdPartyService.loadThirdPartyLogin(this, webSocialLoginDTO.socialType, 2002);
                    return;
                }
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
                return;
            }
        }
        passportSDK.loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        int i = 1;
        p(accountData);
        com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.mClose) {
            if (this.hFk != null) {
                this.hFk.finishActivity();
            }
            wh(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        if (intExtra != -1) {
            i = intExtra;
        } else if (b.alR().getBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), true)) {
            b.alR().putBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), false);
        }
        com.baidu.tbadk.core.f.b.c(this.hFl, i, false);
        if (this.hFk != null) {
            this.hFk.finishActivity();
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.hFn)));
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPl() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            if (this.dgE != null) {
                this.dgE.cancel();
            }
            this.dgE = a.agr().a(session.username, session.bduss, "", null, this.dhc);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.isActivityCanShowDialogOrPopupWindow(this.hFl)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.hFl);
            this.mWaitingDialog.setTipString(str);
            this.mWaitingDialog.setCancelListener(onCancelListener);
            this.mWaitingDialog.setAutoSetCancelable(false);
            this.mWaitingDialog.setCancelable(true);
            this.mWaitingDialog.setDialogVisiable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(int i) {
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        intent.putExtra(LoginActivityConfig.SOCIAL_TYPE, this.hFr);
        intent.putExtra("activity_id", this.agP);
        intent.putExtra(LoginActivityConfig.IS_FROM_AIAPP, this.hFs);
        setResult(i, intent);
        finish();
    }

    private void p(final AccountData accountData) {
        h.ga().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        });
        com.baidu.tbadk.core.e.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.initCookie(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_WEBVIEW_LOGIN, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        this.hFm = TbadkCoreApplication.getCurrentTbs();
        if (this.cul == null) {
            this.cul = new c(this.hFl);
            this.cul.a(this.dhc);
            this.cul.b(new c.a() { // from class: com.baidu.tieba.passaccount.app.LoginActivity.5
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    TbadkCoreApplication.getInst().setTbs(LoginActivity.this.hFm);
                    if (LoginActivity.this.hFk != null) {
                        LoginActivity.this.hFk.finishActivity();
                    }
                    LoginActivity.this.finish();
                }
            });
        }
        this.cul.asz();
        this.cul.setAccountData(accountData);
        this.cul.asv();
    }

    private boolean bPm() {
        if (!aq.isEmpty(this.hFq)) {
            String nI = m.nI(this.hFq);
            if (!aq.isEmpty(nI) && m.nG(nI)) {
                SapiAccountManager.getInstance().getConfignation().skin = nI;
                return true;
            }
        }
        SapiAccountManager.getInstance().getConfignation().skin = "file:///android_asset/sapi_theme/style.css";
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hFp == 1) {
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 2, false);
        }
        if (this.dgE != null) {
            this.dgE.cancel();
        }
        if (this.cul != null) {
            this.cul.onDestroy();
        }
        this.hFk = null;
        this.hFl = null;
        super.onDestroy();
    }
}
