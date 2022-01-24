package com.baidu.tieba.passaccount.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import c.a.d.f.m.g;
import c.a.d.f.m.h;
import c.a.d.f.p.m;
import c.a.s0.s.l.a;
import c.a.s0.t.i.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.LoginPostStatisticHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.LoginDefaultTypeSmsSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes12.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SOCIAL_TYPE_QQ = 3;
    public static final int SOCIAL_TYPE_WEIBO = 1;
    public static final int SOCIAL_TYPE_WEIXIN = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAutoLogin;
    public boolean isFromAiapp;
    public int jumpTo;
    public ILoginListener loginListener;
    public int loginResult;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public String mActivityId;
    public boolean mClose;
    public String mCustomLoginCssUrl;
    public String mFromUrl;
    public c.a.s0.t.i.b mInputUserNameDialog;
    public int mLoginTypeForStatistic;
    public String mOldTbs;
    public Activity mPassActivity;
    public final a.InterfaceC0884a mReLoginCallback;
    public String mScheme;
    public int mSocialType;
    public int mTab;
    public WebAuthResult mWebAuthResult;
    public String minePageStatisticKey;
    public String minePageStatisticLocate;
    public int statisticLocate;

    /* loaded from: classes12.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoginActivity f46364e;

        public a(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46364e = loginActivity;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
            }
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onFinish();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                c.a.s0.s.c0.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                this.f46364e.loginResult = -1;
                this.f46364e.finishForResult(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.f46364e.mWebAuthResult = webAuthResult;
                this.f46364e.mPassActivity = webAuthResult.activity;
                c.a.s0.s.c0.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                this.f46364e.passLoginSucc();
                this.f46364e.loginResult = 0;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoginActivity f46365e;

        public b(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46365e = loginActivity;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
            }
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onFinish();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                c.a.s0.s.c0.a.a("account", -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                this.f46365e.loginResult = -1;
                this.f46365e.finishForResult(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.f46365e.mWebAuthResult = webAuthResult;
                this.f46365e.mPassActivity = webAuthResult.activity;
                c.a.s0.s.c0.a.a("account", -1L, 0, "login_pass_success", 0, "", new Object[0]);
                this.f46365e.passLoginSucc();
                this.f46365e.loginResult = 0;
                this.f46365e.processMinePageLoginStatistic();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoginActivity f46366e;

        public c(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46366e = loginActivity;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
            }
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onFinish();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.f46366e.loginResult = -1;
                this.f46366e.finishForResult(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.f46366e.mWebAuthResult = webAuthResult;
                this.f46366e.mPassActivity = webAuthResult.activity;
                this.f46366e.passLoginSucc();
                this.f46366e.loginResult = 0;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements a.InterfaceC0884a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        /* loaded from: classes12.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f46367e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46367e = dVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    this.f46367e.a.destroyWaitingDialog();
                }
            }
        }

        public d(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginActivity;
        }

        @Override // c.a.s0.s.l.a.InterfaceC0884a
        public void onBeforeLogin(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.getLoadingDialog() == null || !this.a.getLoadingDialog().c()) {
                    LoginActivity loginActivity = this.a;
                    loginActivity.showLoadingDialog(loginActivity.getPageContext().getString(R.string.sapi_logining), new a(this));
                }
            }
        }

        @Override // c.a.s0.s.l.a.InterfaceC0884a
        public void onFailure(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
                c.a.s0.s.c0.a.a("account", -1L, 0, "login_pass_cslogin_fail", i2, str2, new Object[0]);
                this.a.closeLoadingDialog();
                this.a.showToast(str2);
                if (this.a.mPassActivity instanceof BaseSSOLoginActivity) {
                    this.a.mPassActivity.finish();
                }
                this.a.finishForResult(0);
            }
        }

        @Override // c.a.s0.s.l.a.InterfaceC0884a
        public void onSuccess(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                c.a.s0.s.c0.a.a("account", -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", this.a.mLoginTypeForStatistic).param(TiebaStatic.Params.OBJ_URL, this.a.mFromUrl));
                this.a.closeLoadingDialog();
                this.a.processPostLoginStatistic();
                if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                    this.a.goToMainEntrance(accountData);
                    if (c.a.s0.b.d.f()) {
                        c.a.s0.a.d.y().r();
                        return;
                    }
                    return;
                }
                this.a.showInputDialog(accountData);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f46368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LoginActivity f46369f;

        public e(LoginActivity loginActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46369f = loginActivity;
            this.f46368e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.s.l.c.g(this.f46368e);
                c.a.s0.s.c0.a.a("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        public f(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginActivity;
        }

        @Override // c.a.s0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                TbadkCoreApplication.getInst().setTbs(this.a.mOldTbs);
                if (this.a.mWebAuthResult != null) {
                    this.a.mWebAuthResult.finishActivity();
                }
                this.a.finish();
            }
        }
    }

    public LoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLoginTypeForStatistic = 1;
        this.mOldTbs = null;
        this.loginResult = -2;
        this.mClose = false;
        this.jumpTo = -1;
        this.isAutoLogin = false;
        this.mScheme = null;
        this.mTab = -1;
        this.mReLoginCallback = new d(this);
    }

    private void autoLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            try {
                this.jumpTo = 1;
                Uri parse = Uri.parse(this.mScheme);
                PassportSDK.getInstance().startSchemeLoginForQA(getActivity(), String.format(LoginActivityConfig.AUTO_LOGIN_URL, parse.getQueryParameter("username"), parse.getQueryParameter(InputType.PASSWORD)), new a(this));
            } catch (Exception unused) {
                this.loginResult = -1;
                finishForResult(0);
            }
        }
    }

    private boolean checkAndSetCustomLoginCss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (!m.isEmpty(this.mCustomLoginCssUrl)) {
                String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(this.mCustomLoginCssUrl);
                if (!m.isEmpty(customLoginCssStoragePath) && FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
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
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishForResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i2) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMainEntrance(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, accountData) == null) {
            saveAccountInfo(accountData);
            c.a.s0.s.c0.a.a("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
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
                c.a.s0.s.i0.b k = c.a.s0.s.i0.b.k();
                if (k.h("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    this.mTab = 2;
                    c.a.s0.s.i0.b k2 = c.a.s0.s.i0.b.k();
                    k2.u("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                } else {
                    this.mTab = 2;
                }
            }
            if (c.a.s0.s.e0.b.b() != null) {
                c.a.s0.s.e0.b.g(getPageContext().getPageActivity(), this.mTab, false);
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.mTab)));
            }
            this.jumpTo = -1;
            WebAuthResult webAuthResult2 = this.mWebAuthResult;
            if (webAuthResult2 != null) {
                webAuthResult2.finishActivity();
            }
            finish();
        }
    }

    private void initWeiboSdk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        }
    }

    private boolean isAutoLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? this.isAutoLogin && !TextUtils.isEmpty(this.mScheme) && this.mScheme.startsWith("tiebaclient://passlogin") : invokeV.booleanValue;
    }

    private boolean isThirdLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int i2 = this.mSocialType;
            return i2 == 1 || i2 == 2 || i2 == 3;
        }
        return invokeV.booleanValue;
    }

    private void loadThirdPartyLogin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, this, i2) == null) {
            PassportSDK passportSDK = PassportSDK.getInstance();
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            if (i2 == 1) {
                webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
            } else if (i2 == 2) {
                webSocialLoginDTO.socialType = SocialType.WEIXIN;
            } else if (i2 == 3) {
                webSocialLoginDTO.socialType = SocialType.QQ_SSO;
            }
            c cVar = new c(this);
            if (this.isFromAiapp) {
                try {
                    Field declaredField = passportSDK.getClass().getDeclaredField("webAuthListener");
                    declaredField.setAccessible(true);
                    declaredField.set(passportSDK, cVar);
                    Field declaredField2 = passportSDK.getClass().getDeclaredField("socialLoginDTO");
                    declaredField2.setAccessible(true);
                    declaredField2.set(passportSDK, webSocialLoginDTO);
                    passportSDK.loadThirdPartyLogin(cVar, webSocialLoginDTO);
                    return;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                    return;
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            passportSDK.loadThirdPartyLogin(cVar, webSocialLoginDTO);
        }
    }

    private void parseIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            Intent intent = getIntent();
            this.mClose = intent.getBooleanExtra(IntentConfig.CLOSE, false);
            this.jumpTo = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
            this.mFromUrl = intent.getStringExtra("url");
            this.mSocialType = intent.getIntExtra("social_type", 0);
            this.mCustomLoginCssUrl = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
            this.mActivityId = intent.getStringExtra("activity_id");
            this.isFromAiapp = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
            this.isAutoLogin = intent.getBooleanExtra(LoginActivityConfig.AUTO_LOGIN, false);
            this.mScheme = intent.getStringExtra("scheme");
            this.minePageStatisticKey = intent.getStringExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_KEY);
            this.minePageStatisticLocate = intent.getStringExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_LOCATE);
            this.statisticLocate = intent.getIntExtra(LoginActivityConfig.STATISTIC_LOCATE, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("login_dialog_login_listener");
            if (serializableExtra instanceof ILoginListener) {
                this.loginListener = (ILoginListener) serializableExtra;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passLoginSucc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.mAccountLoginTask = c.a.s0.s.l.a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMinePageLoginStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            DialogLoginHelper.addMinePageLoginDialogSuccessLog(this.minePageStatisticKey, this.minePageStatisticLocate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPostLoginStatistic() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (i2 = this.statisticLocate) == 0) {
            return;
        }
        LoginPostStatisticHelper.statisticLoginSuccess(LoginPostStatisticHelper.newStatisticData(i2).setType(2));
    }

    private void saveAccountInfo(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, accountData) == null) {
            h.a().c(new e(this, accountData));
            c.a.s0.s.c0.a.a("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            c.a.s0.m.a.f(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputDialog(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, accountData) == null) {
            this.mOldTbs = TbadkCoreApplication.getCurrentTbs();
            if (this.mInputUserNameDialog == null) {
                c.a.s0.t.i.b bVar = new c.a.s0.t.i.b(this.mPassActivity);
                this.mInputUserNameDialog = bVar;
                bVar.x(this.mReLoginCallback);
                this.mInputUserNameDialog.v(new f(this));
            }
            this.mInputUserNameDialog.p();
            this.mInputUserNameDialog.u(accountData);
            this.mInputUserNameDialog.y();
        }
    }

    private void startLogin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            PassportSDK passportSDK = PassportSDK.getInstance();
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.finishActivityAfterSuc = false;
            if (SwitchManager.getInstance().findType(LoginDefaultTypeSmsSwitch.SWITCH_NAME) == 1) {
                webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
            }
            passportSDK.startLogin(getActivity(), new b(this), webLoginDTO);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.loginResult)));
            super.finish();
        }
    }

    public void initPass() {
        SapiConfiguration sapiConfiguration;
        List<FastLoginFeature> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                sapiConfiguration = SapiAccountManager.getInstance().getConfignation();
            } catch (Exception unused) {
                sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
                sapiConfiguration = null;
            }
            if (sapiConfiguration == null) {
                sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
            }
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                SapiAccountManager.getInstance().setAgreeDangerousProtocol(true);
            }
            MessageManager.getInstance().runTask(2921332, (Class) null);
            PassManagerStatic.z();
            SapiConfiguration confignation2 = SapiAccountManager.getInstance().getConfignation();
            if (confignation2 != null && (list = confignation2.fastLoginFeatureList) != null) {
                list.clear();
                confignation2.fastLoginFeatureList.addAll(PassManagerStatic.l());
            }
            checkAndSetCustomLoginCss();
            if (isAutoLogin()) {
                autoLogin();
            } else if (isThirdLogin()) {
                loadThirdPartyLogin(this.mSocialType);
            } else {
                startLogin();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            LoginActivityConfig.lastStartActivityTime = System.currentTimeMillis();
            parseIntent();
            initPass();
            initWeiboSdk();
            TiebaStatic.log(new StatisticItem("c12947").param(TiebaStatic.Params.OBJ_URL, this.mFromUrl));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.jumpTo == 1) {
                int i2 = this.mTab;
                if (i2 == -1) {
                    i2 = 2;
                }
                this.mTab = i2;
                c.a.s0.s.e0.b.g(getPageContext().getPageActivity(), this.mTab, false);
            }
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            c.a.s0.t.i.b bVar = this.mInputUserNameDialog;
            if (bVar != null) {
                bVar.s();
            }
            this.mWebAuthResult = null;
            this.mPassActivity = null;
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            finish();
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, onCancelListener) == null) && g.e(this.mPassActivity)) {
            if (str == null) {
                str = getString(R.string.Waiting);
            }
            c.a.s0.s.k0.a aVar = new c.a.s0.s.k0.a(this.mPassActivity);
            this.mWaitingDialog = aVar;
            aVar.j(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(true);
            this.mWaitingDialog.h(true);
        }
    }
}
