package com.baidu.tieba.passaccount.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
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
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FileHelper;
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
import com.repackage.at4;
import com.repackage.bm4;
import com.repackage.dm4;
import com.repackage.gy4;
import com.repackage.ki;
import com.repackage.mh4;
import com.repackage.ns4;
import com.repackage.og;
import com.repackage.pg;
import com.repackage.sk4;
import com.repackage.ts4;
import com.repackage.ys4;
import com.tachikoma.core.component.input.InputType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes3.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SOCIAL_TYPE_QQ = 3;
    public static final int SOCIAL_TYPE_WEIBO = 1;
    public static final int SOCIAL_TYPE_WEIXIN = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String fromDialogType;
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
    public gy4 mInputUserNameDialog;
    public int mLoginTypeForStatistic;
    public String mOldTbs;
    public Activity mPassActivity;
    public final bm4.a mReLoginCallback;
    public String mScheme;
    public int mSocialType;
    public int mTab;
    public WebAuthResult mWebAuthResult;
    public String minePageStatisticKey;
    public String minePageStatisticLocate;
    public String preFrom;

    /* loaded from: classes3.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        public a(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginActivity;
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
                ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                this.a.loginResult = -1;
                this.a.finishForResult(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.a.mWebAuthResult = webAuthResult;
                this.a.mPassActivity = webAuthResult.activity;
                ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
                this.a.passLoginSucc();
                this.a.loginResult = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        public b(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginActivity;
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
                ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                this.a.loginResult = -1;
                this.a.finishForResult(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.a.mWebAuthResult = webAuthResult;
                this.a.mPassActivity = webAuthResult.activity;
                ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
                this.a.passLoginSucc();
                this.a.loginResult = 0;
                this.a.processMinePageLoginStatistic();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        public c(LoginActivity loginActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginActivity;
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
                this.a.loginResult = -1;
                this.a.finishForResult(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.a.mWebAuthResult = webAuthResult;
                this.a.mPassActivity = webAuthResult.activity;
                this.a.passLoginSucc();
                this.a.loginResult = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements bm4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        /* loaded from: classes3.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    this.a.a.destroyWaitingDialog();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginActivity;
        }

        @Override // com.repackage.bm4.a
        public void a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
                this.a.closeLoadingDialog();
                this.a.showToast(str2);
                if (this.a.mPassActivity instanceof BaseSSOLoginActivity) {
                    this.a.mPassActivity.finish();
                }
                this.a.finishForResult(0);
            }
        }

        @Override // com.repackage.bm4.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.getLoadingDialog() == null || !this.a.getLoadingDialog().c()) {
                    LoginActivity loginActivity = this.a;
                    loginActivity.showLoadingDialog(loginActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1027), new a(this));
                }
            }
        }

        @Override // com.repackage.bm4.a
        public void c(AccountData accountData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
                if (this.a.mWebAuthResult != null) {
                    str = this.a.mWebAuthResult.getLoginType();
                    if (ki.isEmpty(str) && this.a.mWebAuthResult.activity != null) {
                        str = this.a.mWebAuthResult.activity.getClass().getSimpleName();
                    }
                } else {
                    str = null;
                }
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", this.a.mLoginTypeForStatistic).param(TiebaStatic.Params.OBJ_URL, this.a.mFromUrl).param("obj_param1", this.a.preFrom).param(TiebaStatic.Params.OBJ_PARAM2, this.a.fromDialogType).param(TiebaStatic.Params.OBJ_PARAM3, str));
                this.a.closeLoadingDialog();
                if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                    this.a.goToMainEntrance(accountData);
                    if (UbsABTestHelper.isBackUserTest()) {
                        mh4.x().r();
                        return;
                    }
                    return;
                }
                this.a.showInputDialog(accountData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountData a;
        public final /* synthetic */ LoginActivity b;

        public e(LoginActivity loginActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loginActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = loginActivity;
            this.a = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dm4.g(this.a);
                ns4.a(DI.ACCOUNT, -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements gy4.e {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loginActivity;
        }

        @Override // com.repackage.gy4.e
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            if (!ki.isEmpty(this.mCustomLoginCssUrl)) {
                String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(this.mCustomLoginCssUrl);
                if (!ki.isEmpty(customLoginCssStoragePath) && FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
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
    public void finishForResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65554, this, i) == null) {
            ILoginListener iLoginListener = this.loginListener;
            if (iLoginListener != null) {
                if (i == 0) {
                    iLoginListener.onFail();
                } else if (i == -1) {
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
            setResult(i, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMainEntrance(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, accountData) == null) {
            saveAccountInfo(accountData);
            ns4.a(DI.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
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
                ys4 k = ys4.k();
                if (k.h("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    this.mTab = 2;
                    ys4 k2 = ys4.k();
                    k2.u("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                } else {
                    this.mTab = 2;
                }
            }
            if (ts4.b() != null) {
                ts4.g(getPageContext().getPageActivity(), this.mTab, false);
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
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        }
    }

    private boolean isAutoLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? this.isAutoLogin && !TextUtils.isEmpty(this.mScheme) && this.mScheme.startsWith("tiebaclient://passlogin") : invokeV.booleanValue;
    }

    private boolean isThirdLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            int i = this.mSocialType;
            return i == 1 || i == 2 || i == 3;
        }
        return invokeV.booleanValue;
    }

    private void loadThirdPartyLogin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, this, i) == null) {
            PassportSDK passportSDK = PassportSDK.getInstance();
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            if (i == 1) {
                webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
            } else if (i == 2) {
                webSocialLoginDTO.socialType = SocialType.WEIXIN;
            } else if (i == 3) {
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
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            Intent intent = getIntent();
            this.mClose = intent.getBooleanExtra("close", false);
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
            String stringExtra = intent.getStringExtra("from");
            this.preFrom = stringExtra;
            if (ki.isEmpty(stringExtra)) {
                this.preFrom = getPreExtraPageKey();
            }
            this.fromDialogType = intent.getStringExtra("fromDialog");
            Serializable serializableExtra = getIntent().getSerializableExtra("login_dialog_login_listener");
            if (serializableExtra instanceof ILoginListener) {
                this.loginListener = (ILoginListener) serializableExtra;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passLoginSucc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.mAccountLoginTask = bm4.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMinePageLoginStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            DialogLoginHelper.addMinePageLoginDialogSuccessLog(this.minePageStatisticKey, this.minePageStatisticLocate);
        }
    }

    private void saveAccountInfo(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, accountData) == null) {
            pg.a().c(new e(this, accountData));
            ns4.a(DI.ACCOUNT, -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            sk4.g(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputDialog(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, accountData) == null) {
            this.mOldTbs = TbadkCoreApplication.getCurrentTbs();
            if (this.mInputUserNameDialog == null) {
                gy4 gy4Var = new gy4(this.mPassActivity);
                this.mInputUserNameDialog = gy4Var;
                gy4Var.x(this.mReLoginCallback);
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
            TiebaStatic.log(new StatisticItem("c12947").param(TiebaStatic.Params.OBJ_URL, this.mFromUrl).param("obj_param1", this.preFrom).param(TiebaStatic.Params.OBJ_PARAM2, this.fromDialogType));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.jumpTo == 1) {
                int i = this.mTab;
                if (i == -1) {
                    i = 2;
                }
                this.mTab = i;
                ts4.g(getPageContext().getPageActivity(), this.mTab, false);
            }
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            gy4 gy4Var = this.mInputUserNameDialog;
            if (gy4Var != null) {
                gy4Var.s();
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
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, onCancelListener) == null) && og.e(this.mPassActivity)) {
            if (str == null) {
                str = getString(R.string.obfuscated_res_0x7f0f0037);
            }
            at4 at4Var = new at4(this.mPassActivity);
            this.mWaitingDialog = at4Var;
            at4Var.j(str);
            this.mWaitingDialog.e(onCancelListener);
            this.mWaitingDialog.d(false);
            this.mWaitingDialog.f(true);
            this.mWaitingDialog.h(true);
        }
    }
}
