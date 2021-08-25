package com.baidu.tieba.passaccount.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import c.a.p0.s.q.t0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.OneKeyLoginActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.tieba.passaccount.app.OneKeyLoginActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PassManagerStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f54692a;

    /* renamed from: b  reason: collision with root package name */
    public static SapiConfiguration f54693b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements CustomMessageTask.CustomRunnable<t0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1779a implements ShareModelCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f54694a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ t0 f54695b;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1780a extends OneKeyLoginCallback {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ C1779a f54696a;

                /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC1781a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ OneKeyLoginResult f54697e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ C1780a f54698f;

                    public RunnableC1781a(C1780a c1780a, OneKeyLoginResult oneKeyLoginResult) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c1780a, oneKeyLoginResult};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54698f = c1780a;
                        this.f54697e = oneKeyLoginResult;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            OneKeyLoginResult oneKeyLoginResult = this.f54697e;
                            if (oneKeyLoginResult.enable && !TextUtils.isEmpty(oneKeyLoginResult.sign) && !TextUtils.isEmpty(this.f54697e.encryptPhoneNum) && !TextUtils.isEmpty(this.f54697e.operator)) {
                                if (PassManagerStatic.h(this.f54698f.f54696a.f54694a)) {
                                    DialogLoginHelper.addLoginDialogInvokeLog(this.f54698f.f54696a.f54695b.b(), DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
                                    t0 t0Var = this.f54698f.f54696a.f54695b;
                                    OneKeyLoginResult oneKeyLoginResult2 = this.f54697e;
                                    new LoginDialogActivityConfig(t0Var, oneKeyLoginResult2.encryptPhoneNum, oneKeyLoginResult2.operator, oneKeyLoginResult2.sign).start();
                                }
                            } else if ("first_login_abtest".equals(this.f54698f.f54696a.f54695b.b())) {
                            } else {
                                C1779a c1779a = this.f54698f.f54696a;
                                if (!PassManagerStatic.i(c1779a.f54694a, c1779a.f54695b) && PassManagerStatic.h(this.f54698f.f54696a.f54694a)) {
                                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.f54698f.f54696a.f54694a, true);
                                    loginActivityConfig.setLoginListener(this.f54698f.f54696a.f54695b.c());
                                    loginActivityConfig.start();
                                }
                            }
                        }
                    }
                }

                /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a$a$b */
                /* loaded from: classes7.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ C1780a f54699e;

                    public b(C1780a c1780a) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c1780a};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54699e = c1780a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || "first_login_abtest".equals(this.f54699e.f54696a.f54695b.b())) {
                            return;
                        }
                        C1779a c1779a = this.f54699e.f54696a;
                        if (!PassManagerStatic.i(c1779a.f54694a, c1779a.f54695b) && PassManagerStatic.h(this.f54699e.f54696a.f54694a)) {
                            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.f54699e.f54696a.f54694a, true);
                            loginActivityConfig.setLoginListener(this.f54699e.f54696a.f54695b.c());
                            loginActivityConfig.start();
                        }
                    }
                }

                public C1780a(C1779a c1779a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1779a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54696a = c1779a;
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void available(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                        c.a.e.e.m.e.a().post(new RunnableC1781a(this, oneKeyLoginResult));
                    }
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                        c.a.e.e.m.e.a().post(new b(this));
                    }
                }
            }

            public C1779a(a aVar, Context context, t0 t0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, t0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54694a = context;
                this.f54695b = t0Var;
            }

            @Override // com.baidu.sapi2.callback.ShareModelCallback
            public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                ShareStorage.StorageModel storageModel;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    if (list.size() == 0) {
                        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new C1780a(this));
                    } else if (ListUtils.isEmpty(list) || (storageModel = list.get(0)) == null || !PassManagerStatic.h(this.f54694a)) {
                    } else {
                        String json = new Gson().toJson(storageModel);
                        DialogLoginHelper.addLoginDialogInvokeLog(this.f54695b.b(), DialogLoginHelper.DIALOG_TYPE_SHARE);
                        new LoginDialogActivityConfig(this.f54695b, json).start();
                    }
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<t0> customMessage) {
            InterceptResult invokeL;
            t0 data;
            Context a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || (data = customMessage.getData()) == null || (a2 = data.a()) == null) {
                    return null;
                }
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                    SapiAccountManager.getInstance().setAgreeDangerousProtocol(PermissionUtil.isAgreePrivacyPolicy());
                }
                SapiAccountManager.getInstance().getShareModels(1500L, new C1779a(this, a2, data));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends GlobalCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.sapi2.callback.GlobalCallback
        public void onLoginStatusChange() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921537, 2));
            }
        }

        @Override // com.baidu.sapi2.callback.GlobalCallback
        public void onNeedInitPassSdk() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (PassManagerStatic.f54693b != null) {
                    try {
                        SapiAccountManager.getInstance().init(PassManagerStatic.f54693b);
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921537, 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends AccountCenterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f54700a;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54700a = context;
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onBdussChange() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onBdussChange();
                MessageManager.getInstance().runTask(2921330, null, this.f54700a);
            }
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onFinish(AccountCenterResult accountCenterResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountCenterResult) == null) && accountCenterResult != null && accountCenterResult.isAccountDestory) {
                MessageManager.getInstance().runTask(2921330, null, this.f54700a);
            }
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onSocialBind(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WXEntryActivityConfig(this.f54700a, 230016)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements CustomMessageTask.CustomRunnable<c.a.q0.g2.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c.a.q0.g2.a> customMessage) {
            InterceptResult invokeL;
            BaseResp baseResp;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof c.a.q0.g2.a)) {
                    c.a.q0.g2.a data = customMessage.getData();
                    if (data.f18359a != null && (baseResp = data.f18360b) != null && (baseResp instanceof SendAuth.Resp)) {
                        PassportSDK.getInstance().handleWXLoginResp(data.f18359a, ((SendAuth.Resp) baseResp).state, ((SendAuth.Resp) baseResp).code, data.f18360b.errCode);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends QrLoginCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC1782a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public RunnableC1782a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        Context context = TbadkApplication.getInst().getContext();
                        BdToast.f(context, context.getString(R.string.scan_login_succ), BdToast.DefaultIcon.SUCCESS).q();
                    }
                }
            }

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onFinish(QrLoginResult qrLoginResult) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, qrLoginResult) == null) && qrLoginResult != null && qrLoginResult.getResultCode() == 0) {
                    c.a.e.e.m.e.a().postDelayed(new RunnableC1782a(this), 200L);
                }
            }

            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onLocalLogin(WebAuthResult webAuthResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                }
            }
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
                String data = customMessage.getData();
                if (SapiUtils.isQrLoginSchema(data)) {
                    if ("pc".equals(SapiUtils.parseQrLoginSchema(data).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                        PassManagerStatic.z();
                        PassportSDK.getInstance().loadQrLogin(new a(this), data);
                    }
                    return new CustomResponsedMessage<>(2921339, Boolean.TRUE);
                }
                return new CustomResponsedMessage<>(2921339, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            List<ActivityManager.RunningTaskInfo> runningTasks;
            boolean z;
            ComponentName componentName;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ActivityManager activityManager = (ActivityManager) TbadkApplication.getInst().getSystemService("activity");
                boolean z2 = true;
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    loop0: while (true) {
                        z = true;
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                            if (runningTaskInfo != null && (componentName = runningTaskInfo.topActivity) != null && componentName.getClassName() != null) {
                                String className = runningTaskInfo.topActivity.getClassName();
                                if (className.equals(LoginActivity.class.getName()) || className.equals(com.baidu.sapi2.activity.LoginActivity.class.getName())) {
                                    z = false;
                                }
                            }
                        }
                    }
                    z2 = z;
                }
                return new CustomResponsedMessage<>(2921352, Boolean.valueOf(z2));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements ShareModelCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f54701a;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1783a extends OneKeyLoginCallback {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f54702a;

                /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$h$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC1784a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ OneKeyLoginResult f54703e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ C1783a f54704f;

                    public RunnableC1784a(C1783a c1783a, OneKeyLoginResult oneKeyLoginResult) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c1783a, oneKeyLoginResult};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54704f = c1783a;
                        this.f54703e = oneKeyLoginResult;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            OneKeyLoginResult oneKeyLoginResult = this.f54703e;
                            if (!oneKeyLoginResult.enable || TextUtils.isEmpty(oneKeyLoginResult.sign) || TextUtils.isEmpty(this.f54703e.encryptPhoneNum) || TextUtils.isEmpty(this.f54703e.operator) || !PassManagerStatic.h(this.f54704f.f54702a.f54701a)) {
                                return;
                            }
                            DialogLoginHelper.addLoginDialogInvokeLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
                            Context context = this.f54704f.f54702a.f54701a;
                            OneKeyLoginResult oneKeyLoginResult2 = this.f54703e;
                            new OneKeyLoginActivityConfig(context, oneKeyLoginResult2.encryptPhoneNum, oneKeyLoginResult2.operator, oneKeyLoginResult2.sign).start();
                        }
                    }
                }

                public C1783a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54702a = aVar;
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void available(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                        c.a.e.e.m.e.a().post(new RunnableC1784a(this, oneKeyLoginResult));
                    }
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                        c.a.q0.n.e();
                    }
                }
            }

            public a(h hVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54701a = context;
            }

            @Override // com.baidu.sapi2.callback.ShareModelCallback
            public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                ShareStorage.StorageModel storageModel;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    if (list.size() == 0) {
                        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new C1783a(this));
                    } else if (ListUtils.isEmpty(list) || (storageModel = list.get(0)) == null || !PassManagerStatic.h(this.f54701a)) {
                    } else {
                        String json = new Gson().toJson(storageModel);
                        DialogLoginHelper.addLoginDialogInvokeLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_SHARE);
                        new OneKeyLoginActivityConfig(this.f54701a, json).start();
                    }
                }
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Context data;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || (data = customMessage.getData()) == null) {
                    return null;
                }
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                    SapiAccountManager.getInstance().setAgreeDangerousProtocol(PermissionUtil.isAgreePrivacyPolicy());
                }
                SapiAccountManager.getInstance().getShareModels(1500L, new a(this, data));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements CustomMessageTask.CustomRunnable<Activity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<c.a.p0.t.a.b> run(CustomMessage<Activity> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001268, c.a.q0.g2.d.d.d()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements CustomMessageTask.CustomRunnable<Activity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<c.a.p0.s.l.a> run(CustomMessage<Activity> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001293, c.a.q0.g2.d.a.f()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("com.baidu.sapi2")) {
                TbadkCoreApplication.getInst().incPassportV6CrashCount();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_LOGIN)) {
                        TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, 0)));
                        return 1;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m implements CustomMessageTask.CustomRunnable<Application> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && PermissionUtil.isAgreePrivacyPolicy()) {
                    Application data = customMessage.getData();
                    if (!PassManagerStatic.f54692a) {
                        try {
                            WbSdk.install(data, new AuthInfo(data, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                            boolean unused = PassManagerStatic.f54692a = true;
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class n implements CustomMessageTask.CustomRunnable<Application> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Application> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                PassManagerStatic.m(customMessage.getData());
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class o implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof Context)) {
                    PassManagerStatic.y(customMessage.getData());
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-200009373, "Lcom/baidu/tieba/passaccount/framework/PassManagerStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-200009373, "Lcom/baidu/tieba/passaccount/framework/PassManagerStatic;");
                return;
            }
        }
        q();
        w();
        r();
        o();
        p();
        v();
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
        x();
        u();
        n();
        c.a.q0.g2.d.b.o();
        s();
        t();
    }

    public PassManagerStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                return (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) && !activity.isFinishing();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(Context context, t0 t0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, t0Var)) == null) {
            if ("new_shouye".equals(t0Var.b())) {
                return true;
            }
            if ("sousuo_dianji".equals(t0Var.b())) {
                if (context instanceof BaseActivity) {
                    j(((BaseActivity) context).getPageContext(), t0Var.d());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void j(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, tbPageContext, str) == null) || tbPageContext == null || StringUtils.isNull(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLinkWithOutJumpWebView(tbPageContext, new String[]{str});
    }

    public static FastLoginFeature[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            List<FastLoginFeature> l2 = l();
            FastLoginFeature[] fastLoginFeatureArr = new FastLoginFeature[l2.size()];
            l2.toArray(fastLoginFeatureArr);
            return fastLoginFeatureArr;
        }
        return (FastLoginFeature[]) invokeV.objValue;
    }

    public static List<FastLoginFeature> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(FastLoginFeature.TX_QQ_SSO);
            arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
            arrayList.add(FastLoginFeature.SINA_WEIBO_SSO);
            arrayList.add(FastLoginFeature.YY_SSO);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SapiAccountManager.setGlobalCallback(new b());
            SapiConfiguration.Builder builder = new SapiConfiguration.Builder(context);
            if (c.a.p0.s.d0.b.j().g("is_domain_qa", false)) {
                c.a.p0.t.a.a.f14611a = Domain.DOMAIN_QA;
                builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
            } else {
                builder.setRuntimeEnvironment(c.a.p0.t.a.a.f14611a);
            }
            builder.setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).sofireSdkConfig("200033", "ea737e4f435b53786043369d2e5ace4f", 1).customActionBar(true).skin("file:///android_asset/sapi_theme/style.css").fastLoginSupport(k()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).qqAppID("101462192").sinaAppID("1511099634", PassBioEnv.PASSPORT_DOMAIN).yyOauthConfig("openyy183").setSupportTouchLogin(false).setSupportFaceLogin(true).enableShare(true).forbidPresetPhoneNumber(true);
            builder.setAgreeDangerousProtocol(PermissionUtil.isAgreePrivacyPolicy());
            Domain domain = c.a.p0.t.a.a.f14611a;
            Domain domain2 = Domain.DOMAIN_QA;
            if (domain == domain2) {
                builder.setRuntimeEnvironment(domain2.forceHttps(true));
                builder.debug(true);
            }
            f54693b = builder.build();
            try {
                SapiAccountManager.getInstance().init(f54693b);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            c.a.p0.o0.l.b().E(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921352, new g());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921328, new n());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921438, new m());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            c.a.p0.t.a.a.a();
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginDialogActivityConfig.class, LoginDialogActivity.class);
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(OneKeyLoginActivityConfig.class, OneKeyLoginActivity.class);
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            MessageManager.getInstance().registerListener(new k(2016301));
            UrlManager.getInstance().addListener(new l());
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921530, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921535, new h());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            MessageManager.getInstance().registerListener(new e(2921339));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921339, new f());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921329, new o());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001268, new i());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(2001293, new j());
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921351, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, context) == null) {
            MessageManager.getInstance().runTask(2921332, (Class) null);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session == null || TextUtils.isEmpty(session.bduss)) {
                return;
            }
            AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
            accountCenterDTO.bduss = session.bduss;
            accountCenterDTO.paramsList.add(AccountCenterDTO.HIDE_PERSONAL_DATA);
            accountCenterDTO.paramsList.add(new PassNameValuePair("thirdparty", "0"));
            PassportSDK passportSDK = PassportSDK.getInstance();
            z();
            passportSDK.loadAccountCenter(new c(context), accountCenterDTO);
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, null) == null) || f54693b == null) {
            return;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            f54693b.isNightMode = true;
        } else {
            f54693b.isNightMode = false;
        }
    }
}
