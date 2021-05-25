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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.activity.social.BaseSSOLoginActivity;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.LoginDefaultTypeSmsSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import d.a.c.e.m.g;
import d.a.c.e.m.h;
import d.a.c.e.p.k;
import d.a.m0.r.l.a;
import d.a.m0.s.i.b;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes4.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    public static final int SOCIAL_TYPE_QQ = 3;
    public static final int SOCIAL_TYPE_WEIBO = 1;
    public static final int SOCIAL_TYPE_WEIXIN = 2;
    public boolean isFromAiapp;
    public ILoginListener loginListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public String mActivityId;
    public String mCustomLoginCssUrl;
    public String mFromUrl;
    public d.a.m0.s.i.b mInputUserNameDialog;
    public Activity mPassActivity;
    public int mSocialType;
    public WebAuthResult mWebAuthResult;
    public int mLoginTypeForStatistic = 1;
    public String mOldTbs = null;
    public int loginResult = -2;
    public boolean mClose = false;
    public int jumpTo = -1;
    public int mTab = -1;
    public final a.InterfaceC1141a mReLoginCallback = new c();

    /* loaded from: classes4.dex */
    public class a extends WebAuthListener {
        public a() {
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            super.onFinish();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            d.a.m0.r.z.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
            LoginActivity.this.loginResult = -1;
            LoginActivity.this.finishForResult(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            LoginActivity.this.mWebAuthResult = webAuthResult;
            LoginActivity.this.mPassActivity = webAuthResult.activity;
            d.a.m0.r.z.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
            LoginActivity.this.passLoginSucc();
            LoginActivity.this.loginResult = 0;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends WebAuthListener {
        public b() {
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            super.onFinish();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            LoginActivity.this.loginResult = -1;
            LoginActivity.this.finishForResult(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            LoginActivity.this.mWebAuthResult = webAuthResult;
            LoginActivity.this.mPassActivity = webAuthResult.activity;
            LoginActivity.this.passLoginSucc();
            LoginActivity.this.loginResult = 0;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC1141a {

        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnCancelListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                LoginActivity.this.destroyWaitingDialog();
            }
        }

        public c() {
        }

        @Override // d.a.m0.r.l.a.InterfaceC1141a
        public void a(String str, int i2, String str2) {
            d.a.m0.r.z.a.a("account", -1L, 0, "login_pass_cslogin_fail", i2, str2, new Object[0]);
            LoginActivity.this.closeLoadingDialog();
            LoginActivity.this.showToast(str2);
            if (LoginActivity.this.mPassActivity instanceof BaseSSOLoginActivity) {
                LoginActivity.this.mPassActivity.finish();
            }
            LoginActivity.this.finishForResult(0);
        }

        @Override // d.a.m0.r.l.a.InterfaceC1141a
        public void b(String str) {
            if (LoginActivity.this.getLoadingDialog() == null || !LoginActivity.this.getLoadingDialog().c()) {
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.showLoadingDialog(loginActivity.getPageContext().getString(R.string.sapi_logining), new a());
            }
        }

        @Override // d.a.m0.r.l.a.InterfaceC1141a
        public void c(AccountData accountData) {
            d.a.m0.r.z.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
            TiebaStatic.log(new StatisticItem("c12948").param("obj_type", LoginActivity.this.mLoginTypeForStatistic).param(TiebaStatic.Params.OBJ_URL, LoginActivity.this.mFromUrl));
            LoginActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                LoginActivity.this.goToMainEntrance(accountData);
                if (d.a.m0.b.d.f()) {
                    d.a.m0.a.c.y().r();
                    return;
                }
                return;
            }
            LoginActivity.this.showInputDialog(accountData);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f18747e;

        public d(AccountData accountData) {
            this.f18747e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.l.c.g(this.f18747e);
            d.a.m0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.e {
        public e() {
        }

        @Override // d.a.m0.s.i.b.e
        public void a(AccountData accountData) {
            TbadkCoreApplication.getInst().setTbs(LoginActivity.this.mOldTbs);
            if (LoginActivity.this.mWebAuthResult != null) {
                LoginActivity.this.mWebAuthResult.finishActivity();
            }
            LoginActivity.this.finish();
        }
    }

    private boolean checkAndSetCustomLoginCss() {
        if (!k.isEmpty(this.mCustomLoginCssUrl)) {
            String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(this.mCustomLoginCssUrl);
            if (!k.isEmpty(customLoginCssStoragePath) && FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
                if (SapiAccountManager.getInstance().getConfignation() != null) {
                    SapiAccountManager.getInstance().getConfignation().skin = customLoginCssStoragePath;
                    return true;
                }
                return true;
            }
        }
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            SapiAccountManager.getInstance().getConfignation().skin = "file:///android_asset/sapi_theme/style.css";
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishForResult(int i2) {
        ILoginListener iLoginListener = this.loginListener;
        if (iLoginListener != null) {
            if (i2 == 0) {
                iLoginListener.onFail();
            } else if (i2 == -1) {
                iLoginListener.onSuccess();
            } else {
                iLoginListener.onCancel();
            }
            this.loginListener = null;
        }
        Intent intent = new Intent();
        intent.putExtra(HttpRequest.BDUSS, TbadkCoreApplication.getCurrentBduss());
        intent.putExtra("social_type", this.mSocialType);
        intent.putExtra("activity_id", this.mActivityId);
        intent.putExtra(LoginActivityConfig.IS_FROM_AIAPP, this.isFromAiapp);
        setResult(i2, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMainEntrance(AccountData accountData) {
        saveAccountInfo(accountData);
        d.a.m0.r.z.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.getInst().onUserChanged(getIntent());
        if (this.mClose) {
            WebAuthResult webAuthResult = this.mWebAuthResult;
            if (webAuthResult != null) {
                webAuthResult.finishActivity();
            }
            finishForResult(-1);
            return;
        }
        int intExtra = getIntent().getIntExtra("locate_type", -1);
        this.mTab = intExtra;
        if (intExtra == -1) {
            d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
            if (j.g("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                this.mTab = 2;
                d.a.m0.r.d0.b j2 = d.a.m0.r.d0.b.j();
                j2.t("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            } else {
                this.mTab = 2;
            }
        }
        WebAuthResult webAuthResult2 = this.mWebAuthResult;
        if (webAuthResult2 != null) {
            webAuthResult2.finishActivity();
        }
        finish();
    }

    private void initWeiboSdk() {
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
    }

    private boolean isThirdLogin() {
        int i2 = this.mSocialType;
        return i2 == 1 || i2 == 2 || i2 == 3;
    }

    private void loadThirdPartyLogin(int i2) {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        if (i2 == 1) {
            webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
        } else if (i2 == 2) {
            webSocialLoginDTO.socialType = SocialType.WEIXIN;
        } else if (i2 == 3) {
            webSocialLoginDTO.socialType = SocialType.QQ_SSO;
        }
        b bVar = new b();
        if (this.isFromAiapp) {
            try {
                Field declaredField = passportSDK.getClass().getDeclaredField("webAuthListener");
                declaredField.setAccessible(true);
                declaredField.set(passportSDK, bVar);
                Field declaredField2 = passportSDK.getClass().getDeclaredField("socialLoginDTO");
                declaredField2.setAccessible(true);
                declaredField2.set(passportSDK, webSocialLoginDTO);
                passportSDK.loadThirdPartyLogin(bVar, webSocialLoginDTO);
                return;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return;
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
                return;
            }
        }
        passportSDK.loadThirdPartyLogin(bVar, webSocialLoginDTO);
    }

    private void parseIntent() {
        Intent intent = getIntent();
        this.mClose = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.jumpTo = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
        this.mFromUrl = intent.getStringExtra("url");
        this.mSocialType = intent.getIntExtra("social_type", 0);
        this.mCustomLoginCssUrl = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
        this.mActivityId = intent.getStringExtra("activity_id");
        this.isFromAiapp = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
        Serializable serializableExtra = getIntent().getSerializableExtra("login_dialog_login_listener");
        if (serializableExtra instanceof ILoginListener) {
            this.loginListener = (ILoginListener) serializableExtra;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passLoginSucc() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = d.a.m0.r.l.a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
        }
    }

    private void saveAccountInfo(AccountData accountData) {
        h.a().c(new d(accountData));
        d.a.m0.r.z.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        d.a.m0.l.a.f(TbadkCoreApplication.getInst());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputDialog(AccountData accountData) {
        this.mOldTbs = TbadkCoreApplication.getCurrentTbs();
        if (this.mInputUserNameDialog == null) {
            d.a.m0.s.i.b bVar = new d.a.m0.s.i.b(this.mPassActivity);
            this.mInputUserNameDialog = bVar;
            bVar.x(this.mReLoginCallback);
            this.mInputUserNameDialog.v(new e());
        }
        this.mInputUserNameDialog.p();
        this.mInputUserNameDialog.u(accountData);
        this.mInputUserNameDialog.y();
    }

    private void startLogin() {
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        if (SwitchManager.getInstance().findType(LoginDefaultTypeSmsSwitch.SWITCH_NAME) == 1) {
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
        passportSDK.startLogin(getActivity(), new a(), webLoginDTO);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.loginResult)));
        super.finish();
    }

    public void initPass() {
        List<FastLoginFeature> list;
        try {
            SapiAccountManager.getInstance().getConfignation();
        } catch (Exception unused) {
            sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
            confignation.setAgreeDangerousProtocol(true);
        }
        MessageManager.getInstance().runTask(2921332, (Class) null);
        PassManagerStatic.z();
        SapiConfiguration confignation2 = SapiAccountManager.getInstance().getConfignation();
        if (confignation2 != null && (list = confignation2.fastLoginFeatureList) != null) {
            list.clear();
            confignation2.fastLoginFeatureList.addAll(PassManagerStatic.l());
        }
        checkAndSetCustomLoginCss();
        if (isThirdLogin()) {
            loadThirdPartyLogin(this.mSocialType);
        } else {
            startLogin();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LoginActivityConfig.lastStartActivityTime = System.currentTimeMillis();
        parseIntent();
        initPass();
        initWeiboSdk();
        TiebaStatic.log(new StatisticItem("c12947").param(TiebaStatic.Params.OBJ_URL, this.mFromUrl));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jumpTo == 1) {
            int i2 = this.mTab;
            if (i2 == -1) {
                i2 = 2;
            }
            this.mTab = i2;
            d.a.m0.r.a0.b.g(getPageContext().getPageActivity(), this.mTab, false);
        }
        BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
        d.a.m0.s.i.b bVar = this.mInputUserNameDialog;
        if (bVar != null) {
            bVar.s();
        }
        this.mWebAuthResult = null;
        this.mPassActivity = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (g.e(this.mPassActivity)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            d.a.m0.r.f0.a aVar = new d.a.m0.r.f0.a(this.mPassActivity);
            this.mWaitingDialog = aVar;
            aVar.j(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(true);
            this.mWaitingDialog.h(true);
        }
    }
}
