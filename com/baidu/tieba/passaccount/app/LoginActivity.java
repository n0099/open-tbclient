package com.baidu.tieba.passaccount.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.LoginDefaultTypeSmsSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.e45;
import com.baidu.tieba.gw4;
import com.baidu.tieba.hi;
import com.baidu.tieba.ik;
import com.baidu.tieba.it4;
import com.baidu.tieba.k45;
import com.baidu.tieba.lg;
import com.baidu.tieba.mg;
import com.baidu.tieba.p45;
import com.baidu.tieba.passaccount.framework.PassManagerStatic;
import com.baidu.tieba.s45;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.uv4;
import com.baidu.tieba.va5;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes5.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdAsyncTask<?, ?, ?> a;
    public int b;
    public WebAuthResult c;
    public Activity d;
    public va5 e;
    public String f;
    public int g;
    public boolean h;
    public String i;
    public int j;
    public String k;
    public String l;
    public int m;
    public String n;
    public boolean o;
    public boolean p;
    public String q;
    public int r;
    public ILoginListener s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public wv4.a y;

    /* loaded from: classes5.dex */
    public class d implements wv4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        /* loaded from: classes5.dex */
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

        @Override // com.baidu.tieba.wv4.a
        public void a(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
                e45.a(DI.ACCOUNT, -1L, 0, "login_pass_cslogin_fail", i, str2, new Object[0]);
                ik.a().b(Config.DEVICE_PART, "login fail form pass");
                this.a.closeLoadingDialog();
                this.a.showToast(str2);
                if (this.a.d instanceof BaseSSOLoginActivity) {
                    this.a.d.finish();
                }
                this.a.Q1(0);
            }
        }

        @Override // com.baidu.tieba.wv4.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.getLoadingDialog() != null && this.a.getLoadingDialog().c()) {
                    return;
                }
                LoginActivity loginActivity = this.a;
                loginActivity.showLoadingDialog(loginActivity.getPageContext().getString(R.string.sapi_logining), new a(this));
            }
        }

        @Override // com.baidu.tieba.wv4.a
        public void c(AccountData accountData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                e45.a(DI.ACCOUNT, -1L, 0, "login_pass_cslogin_success", 0, "", new Object[0]);
                ik.a().c(Config.DEVICE_PART, "login success form pass");
                if (this.a.c != null) {
                    str = this.a.c.getLoginType();
                    if (hi.isEmpty(str) && this.a.c.activity != null) {
                        str = this.a.c.activity.getClass().getSimpleName();
                    }
                } else {
                    str = null;
                }
                TiebaStatic.log(new StatisticItem("c12948").param("obj_type", this.a.b).param(TiebaStatic.Params.OBJ_URL, this.a.i).param("obj_param1", this.a.v).param(TiebaStatic.Params.OBJ_PARAM2, this.a.w).param(TiebaStatic.Params.OBJ_PARAM3, str));
                this.a.closeLoadingDialog();
                TbadkCoreApplication.getInst().onDeviceFirstLoginChanged(accountData);
                gw4.c().b(1);
                if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                    this.a.R1(accountData);
                } else {
                    this.a.a2(accountData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
            }
        }

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                e45.a(DI.ACCOUNT, -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                this.a.g = -1;
                this.a.Q1(0);
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
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.a.c = webAuthResult;
                this.a.d = webAuthResult.activity;
                e45.a(DI.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
                this.a.X1();
                this.a.g = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
            }
        }

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                e45.a(DI.ACCOUNT, -1L, 0, "login_pass_fail", webAuthResult.getResultCode(), webAuthResult.getResultMsg(), new Object[0]);
                this.a.g = -1;
                this.a.Q1(0);
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
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, webAuthResult) == null) {
                this.a.c = webAuthResult;
                this.a.d = webAuthResult.activity;
                e45.a(DI.ACCOUNT, -1L, 0, "login_pass_success", 0, "", new Object[0]);
                this.a.X1();
                this.a.g = 0;
                this.a.Y1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoginActivity a;

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
            }
        }

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) != null) {
                return;
            }
            this.a.g = -1;
            this.a.Q1(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048581, this, webAuthResult) != null) {
                return;
            }
            this.a.c = webAuthResult;
            this.a.d = webAuthResult.activity;
            this.a.X1();
            this.a.g = 0;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener, com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onFinish();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                uv4.g(this.a);
                e45.a(DI.ACCOUNT, -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements va5.e {
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

        @Override // com.baidu.tieba.va5.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                TbadkCoreApplication.getInst().setTbs(this.a.f);
                if (this.a.c != null) {
                    this.a.c.finishActivity();
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
        this.b = 1;
        this.f = null;
        this.g = -2;
        this.h = false;
        this.j = -1;
        this.k = "";
        this.p = false;
        this.q = null;
        this.r = -1;
        this.y = new d(this);
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.a;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.a = wv4.b().a(session.username, session.bduss, "", null, this.y);
                return;
            }
            finish();
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            PassportSDK passportSDK = PassportSDK.getInstance();
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.finishActivityAfterSuc = false;
            if (SwitchManager.getInstance().findType(LoginDefaultTypeSmsSwitch.SWITCH_NAME) == 1) {
                webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
            }
            passportSDK.startLogin(getActivity(), new b(this), webLoginDTO);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            finish();
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.j = 1;
                Uri parse = Uri.parse(this.q);
                PassportSDK.getInstance().startSchemeLoginForQA(getActivity(), String.format(LoginActivityConfig.AUTO_LOGIN_URL, parse.getQueryParameter("username"), parse.getQueryParameter(com.baidu.sapi2.views.logindialog.view.a.m)), new a(this));
            } catch (Exception unused) {
                this.g = -1;
                Q1(0);
            }
        }
    }

    public final boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!hi.isEmpty(this.l)) {
                String customLoginCssStoragePath = FileHelper.getCustomLoginCssStoragePath(this.l);
                if (!hi.isEmpty(customLoginCssStoragePath) && FileHelper.checkIsCssFile(customLoginCssStoragePath)) {
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

    public final void Q1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            ILoginListener iLoginListener = this.s;
            if (iLoginListener != null) {
                if (i == 0) {
                    iLoginListener.onFail();
                } else if (i == -1) {
                    iLoginListener.onSuccess();
                } else {
                    iLoginListener.onCancel();
                }
                this.s = null;
            }
            Intent intent = new Intent();
            intent.putExtra(HttpRequest.BDUSS, TbadkCoreApplication.getCurrentBduss());
            intent.putExtra("social_type", this.m);
            intent.putExtra("activity_id", this.n);
            intent.putExtra(LoginActivityConfig.IS_FROM_AIAPP, this.o);
            intent.putExtra(LoginDialogActivityConfig.HOME_OPERATE_JUMP_URL, this.x);
            setResult(i, intent);
            finish();
        }
    }

    public final void Z1(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, accountData) == null) {
            mg.a().c(new e(this, accountData));
            e45.a(DI.ACCOUNT, -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            it4.j(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
        }
    }

    public final void R1(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, accountData) == null) {
            Z1(accountData);
            e45.a(DI.ACCOUNT, -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
            TbadkCoreApplication.getInst().onUserChanged(getIntent());
            if (this.h) {
                WebAuthResult webAuthResult = this.c;
                if (webAuthResult != null) {
                    webAuthResult.finishActivity();
                }
                Q1(-1);
                return;
            }
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            this.r = intExtra;
            if (intExtra == -1) {
                p45 m = p45.m();
                if (m.i("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    this.r = 2;
                    p45 m2 = p45.m();
                    m2.w("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                } else {
                    this.r = 2;
                }
            }
            if (k45.b() != null) {
                k45.g(getPageContext().getPageActivity(), this.r, false);
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.r)));
            }
            this.j = -1;
            WebAuthResult webAuthResult2 = this.c;
            if (webAuthResult2 != null) {
                webAuthResult2.finishActivity();
            }
            finish();
        }
    }

    public void S1() {
        SapiConfiguration sapiConfiguration;
        List<FastLoginFeature> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
            PassManagerStatic.A();
            SapiConfiguration confignation2 = SapiAccountManager.getInstance().getConfignation();
            if (confignation2 != null && (list = confignation2.fastLoginFeatureList) != null) {
                list.clear();
                confignation2.fastLoginFeatureList.addAll(PassManagerStatic.l());
            }
            P1();
            if (T1()) {
                O1();
            } else if (U1()) {
                V1(this.m);
            } else {
                b2();
            }
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Intent intent = getIntent();
            this.h = intent.getBooleanExtra("close", false);
            this.j = intent.getIntExtra(LoginActivityConfig.JUMP_AFTER_DESTROY, -1);
            this.i = intent.getStringExtra("url");
            this.k = intent.getStringExtra(IntentConfig.BACK_SCHEME);
            this.m = intent.getIntExtra("social_type", 0);
            this.l = intent.getStringExtra(LoginActivityConfig.CUSTOM_LOGIN_CSS_URL);
            this.n = intent.getStringExtra("activity_id");
            this.o = intent.getBooleanExtra(LoginActivityConfig.IS_FROM_AIAPP, false);
            this.p = intent.getBooleanExtra(LoginActivityConfig.AUTO_LOGIN, false);
            this.q = intent.getStringExtra("scheme");
            this.t = intent.getStringExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_KEY);
            this.u = intent.getStringExtra(LoginDialogActivityConfig.MINE_PAGE_LOGIN_DIALOG_DATA_LOCATE);
            String stringExtra = intent.getStringExtra("from");
            this.v = stringExtra;
            if (hi.isEmpty(stringExtra)) {
                this.v = getPreExtraPageKey();
            }
            this.w = intent.getStringExtra("fromDialog");
            Serializable serializableExtra = getIntent().getSerializableExtra("login_dialog_login_listener");
            if (serializableExtra instanceof ILoginListener) {
                this.s = (ILoginListener) serializableExtra;
            }
            this.x = intent.getStringExtra(LoginDialogActivityConfig.HOME_OPERATE_JUMP_URL);
        }
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.p && !TextUtils.isEmpty(this.q) && this.q.startsWith("tiebaclient://passlogin")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.m;
            if (i == 1 || i == 2 || i == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            DialogLoginHelper.addMinePageLoginDialogSuccessLog(this.t, this.u);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921362, Integer.valueOf(this.g)));
            super.finish();
        }
    }

    public final void V1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
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
            if (this.o) {
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

    public final void a2(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, accountData) == null) {
            this.f = TbadkCoreApplication.getCurrentTbs();
            if (this.e == null) {
                va5 va5Var = new va5(this.d);
                this.e = va5Var;
                va5Var.x(this.y);
                this.e.v(new f(this));
            }
            this.e.p();
            this.e.u(accountData);
            this.e.y();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            LoginActivityConfig.lastStartActivityTime = System.currentTimeMillis();
            W1();
            S1();
            TiebaStatic.log(new StatisticItem("c12947").param(TiebaStatic.Params.OBJ_URL, this.i).param("obj_param1", this.v).param(TiebaStatic.Params.OBJ_PARAM2, this.w));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.j == 1) {
                int i = this.r;
                if (i == -1) {
                    i = 2;
                }
                this.r = i;
                k45.g(getPageContext().getPageActivity(), this.r, false);
            }
            if (this.j == 2 && this.g == 0 && !TextUtils.isEmpty(this.k)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.k));
                if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    startActivity(intent);
                }
            }
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.a;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            va5 va5Var = this.e;
            if (va5Var != null) {
                va5Var.s();
            }
            this.y = null;
            this.c = null;
            this.d = null;
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, str, onCancelListener) != null) || !lg.e(this.d)) {
            return;
        }
        if (str == null) {
            str = getString(R.string.obfuscated_res_0x7f0f003a);
        }
        s45 s45Var = new s45(this.d);
        this.mWaitingDialog = s45Var;
        s45Var.j(str);
        this.mWaitingDialog.e(onCancelListener);
        this.mWaitingDialog.d(false);
        this.mWaitingDialog.f(true);
        this.mWaitingDialog.h(true);
    }
}
