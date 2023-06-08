package com.baidu.tieba.passaccount.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.certification.CertificationCheckParams;
import com.baidu.tbadk.core.account.certification.CertificationRequestParams;
import com.baidu.tbadk.core.account.certification.ICheckCertificationCallback;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LoginDialogActivityConfig;
import com.baidu.tbadk.core.atomData.OneKeyLoginActivityConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.mutiprocess.share.InitWeiboSdkEvent;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tbadk.system.portrait.ChangeSystemPhotoActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.d29;
import com.baidu.tieba.dc5;
import com.baidu.tieba.e29;
import com.baidu.tieba.ec5;
import com.baidu.tieba.g29;
import com.baidu.tieba.gp5;
import com.baidu.tieba.ip5;
import com.baidu.tieba.n95;
import com.baidu.tieba.passaccount.app.LoginActivity;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.tieba.passaccount.app.OneKeyLoginActivity;
import com.baidu.tieba.qx4;
import com.baidu.tieba.r19;
import com.baidu.tieba.s05;
import com.baidu.tieba.s19;
import com.baidu.tieba.ss5;
import com.baidu.tieba.t05;
import com.baidu.tieba.u05;
import com.baidu.tieba.wg;
import com.baidu.tieba.z46;
import com.baidu.tieba.z55;
import com.baidu.tieba.zq8;
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
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PassManagerStatic {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static SapiConfiguration b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements CustomMessageTask.CustomRunnable<LoginDialogData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0412a implements ShareModelCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ LoginDialogData b;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0413a extends OneKeyLoginCallback {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0412a a;

                /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC0414a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OneKeyLoginResult a;
                    public final /* synthetic */ C0413a b;

                    public RunnableC0414a(C0413a c0413a, OneKeyLoginResult oneKeyLoginResult) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0413a, oneKeyLoginResult};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = c0413a;
                        this.a = oneKeyLoginResult;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            OneKeyLoginResult oneKeyLoginResult = this.a;
                            if (oneKeyLoginResult.enable && !TextUtils.isEmpty(oneKeyLoginResult.sign) && !TextUtils.isEmpty(this.a.encryptPhoneNum) && !TextUtils.isEmpty(this.a.operator)) {
                                if (PassManagerStatic.h(this.b.a.a)) {
                                    DialogLoginHelper.addLoginDialogInvokeLog(this.b.a.b.getLocate(), DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
                                    LoginDialogData loginDialogData = this.b.a.b;
                                    OneKeyLoginResult oneKeyLoginResult2 = this.a;
                                    new LoginDialogActivityConfig(loginDialogData, oneKeyLoginResult2.encryptPhoneNum, oneKeyLoginResult2.operator, oneKeyLoginResult2.sign).start();
                                }
                            } else if (LoginDialogData.FIRST_LOGIN_ABTEST.equals(this.b.a.b.getLocate())) {
                            } else {
                                C0412a c0412a = this.b.a;
                                if (!PassManagerStatic.i(c0412a.a, c0412a.b) && PassManagerStatic.h(this.b.a.a)) {
                                    LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.b.a.a, true);
                                    loginActivityConfig.setLoginListener(this.b.a.b.getLoginListener());
                                    loginActivityConfig.setMinePageStatisticParams(this.b.a.b.getMinePageKey(), this.b.a.b.getMinePageLocate());
                                    loginActivityConfig.setFromDialog("onkey_unable");
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
                    public final /* synthetic */ C0413a a;

                    public b(C0413a c0413a) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0413a};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = c0413a;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || LoginDialogData.FIRST_LOGIN_ABTEST.equals(this.a.a.b.getLocate())) {
                            return;
                        }
                        C0412a c0412a = this.a.a;
                        if (!PassManagerStatic.i(c0412a.a, c0412a.b) && PassManagerStatic.h(this.a.a.a)) {
                            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(this.a.a.a, true);
                            loginActivityConfig.setLoginListener(this.a.a.b.getLoginListener());
                            loginActivityConfig.setJumpUrl(this.a.a.b.getJumpUrl());
                            loginActivityConfig.setMinePageStatisticParams(this.a.a.b.getMinePageKey(), this.a.a.b.getMinePageLocate());
                            loginActivityConfig.setFromDialog("onkey_unavailable");
                            loginActivityConfig.start();
                        }
                    }
                }

                public C0413a(C0412a c0412a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0412a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0412a;
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void available(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                        wg.a().post(new RunnableC0414a(this, oneKeyLoginResult));
                    }
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                        wg.a().post(new b(this));
                    }
                }
            }

            public C0412a(a aVar, Context context, LoginDialogData loginDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, loginDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = context;
                this.b = loginDialogData;
            }

            @Override // com.baidu.sapi2.callback.ShareModelCallback
            public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                ShareStorage.StorageModel storageModel;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    if (list.size() == 0) {
                        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new C0413a(this));
                    } else if (!ListUtils.isEmpty(list) && (storageModel = list.get(0)) != null && PassManagerStatic.h(this.a)) {
                        String json = new Gson().toJson(storageModel);
                        DialogLoginHelper.addLoginDialogInvokeLog(this.b.getLocate(), DialogLoginHelper.DIALOG_TYPE_SHARE);
                        new LoginDialogActivityConfig(this.b, json).start();
                    }
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<LoginDialogData> customMessage) {
            InterceptResult invokeL;
            LoginDialogData data;
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || (data = customMessage.getData()) == null || (context = data.getContext()) == null) {
                    return null;
                }
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                if (confignation != null && !confignation.isAgreeDangerousProtocol()) {
                    SapiAccountManager.getInstance().setAgreeDangerousProtocol(PermissionUtil.isAgreePrivacyPolicy());
                }
                SapiAccountManager.getInstance().getShareModels(1500L, new C0412a(this, context, data));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class j implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements ShareModelCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0417a extends OneKeyLoginCallback {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$j$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes7.dex */
                public class RunnableC0418a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OneKeyLoginResult a;
                    public final /* synthetic */ C0417a b;

                    public RunnableC0418a(C0417a c0417a, OneKeyLoginResult oneKeyLoginResult) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0417a, oneKeyLoginResult};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = c0417a;
                        this.a = oneKeyLoginResult;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            OneKeyLoginResult oneKeyLoginResult = this.a;
                            if (oneKeyLoginResult.enable && !TextUtils.isEmpty(oneKeyLoginResult.sign) && !TextUtils.isEmpty(this.a.encryptPhoneNum) && !TextUtils.isEmpty(this.a.operator) && PassManagerStatic.h(this.b.a.a)) {
                                DialogLoginHelper.addLoginDialogInvokeLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
                                Context context = this.b.a.a;
                                OneKeyLoginResult oneKeyLoginResult2 = this.a;
                                new OneKeyLoginActivityConfig(context, oneKeyLoginResult2.encryptPhoneNum, oneKeyLoginResult2.operator, oneKeyLoginResult2.sign).start();
                            }
                        }
                    }
                }

                public C0417a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void available(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                        wg.a().post(new RunnableC0418a(this, oneKeyLoginResult));
                    }
                }

                @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
                public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                        if (UbsABTestHelper.isFirstLoginTestA() && UbsABTestHelper.isNewInterestShowTestA() && TbadkCoreApplication.getInst().getCurrentActivity().toString().contains("MainTabActivity")) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921673));
                        } else if (!LooperBlockSwitch.getIsOn()) {
                            z46.d();
                        } else {
                            z55.p(TbadkCoreApplication.getInst(), "updateDialog", new JSONObject());
                        }
                    }
                }
            }

            public a(j jVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = context;
            }

            @Override // com.baidu.sapi2.callback.ShareModelCallback
            public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                ShareStorage.StorageModel storageModel;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    if (list.size() == 0) {
                        SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new C0417a(this));
                    } else if (!ListUtils.isEmpty(list) && (storageModel = list.get(0)) != null && PassManagerStatic.h(this.a)) {
                        String json = new Gson().toJson(storageModel);
                        DialogLoginHelper.addLoginDialogInvokeLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_SHARE);
                        new OneKeyLoginActivityConfig(this.a, json).start();
                    }
                }
            }
        }

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public static class f implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends QrLoginCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onLocalLogin(WebAuthResult webAuthResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                }
            }

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0415a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public RunnableC0415a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        BdToast b = BdToast.b(context, context.getString(R.string.scan_login_succ));
                        b.g(BdToast.ToastIcon.SUCCESS);
                        b.o();
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.sapi2.callback.QrLoginCallback
            public void onFinish(QrLoginResult qrLoginResult) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, qrLoginResult) == null) && qrLoginResult != null && qrLoginResult.getResultCode() == 0) {
                    wg.a().postDelayed(new RunnableC0415a(this), 200L);
                }
            }
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (customMessage != null && (customMessage.getData() instanceof String)) {
                    String data = customMessage.getData();
                    if (SapiUtils.isQrLoginSchema(data)) {
                        if ("pc".equals(SapiUtils.parseQrLoginSchema(data).get(SapiUtils.KEY_QR_LOGIN_LP))) {
                            PassManagerStatic.A();
                            PassportSDK.getInstance().loadQrLogin(new a(this), data);
                        }
                        return new CustomResponsedMessage<>(2921339, Boolean.TRUE);
                    }
                    return new CustomResponsedMessage<>(2921339, Boolean.FALSE);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class i implements CustomMessageTask.CustomRunnable<CertificationRequestParams> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a extends AccountRealNameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CertificationRequestParams a;

            /* renamed from: com.baidu.tieba.passaccount.framework.PassManagerStatic$i$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0416a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountRealNameResult a;
                public final /* synthetic */ a b;

                public RunnableC0416a(a aVar, AccountRealNameResult accountRealNameResult) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, accountRealNameResult};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = accountRealNameResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.callback.onResult(t05.b(this.a));
                    }
                }
            }

            public a(i iVar, CertificationRequestParams certificationRequestParams) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, certificationRequestParams};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = certificationRequestParams;
            }

            @Override // com.baidu.sapi2.callback.AccountRealNameCallback
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                    if (accountRealNameResult != null) {
                        zq8 defaultLog = DefaultLog.getInstance();
                        defaultLog.c("pass", "实名认证完成：" + this.a.callback + " " + accountRealNameResult.getResultCode() + " " + accountRealNameResult.getResultMsg() + " " + accountRealNameResult.errorStep + " " + accountRealNameResult.juniorRealNameSuc + " " + accountRealNameResult.seniorRealNameSuc + " " + accountRealNameResult.callbackkey);
                    } else {
                        DefaultLog.getInstance().b("pass", "实名认证完成，没有返回值");
                    }
                    super.onFinish(accountRealNameResult);
                    if (this.a.callback != null) {
                        wg.a().post(new RunnableC0416a(this, accountRealNameResult));
                    }
                }
            }
        }

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<CertificationRequestParams> customMessage) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    CertificationRequestParams data = customMessage.getData();
                    SapiAccount session = SapiAccountManager.getInstance().getSession();
                    zq8 defaultLog = DefaultLog.getInstance();
                    StringBuilder sb = new StringBuilder();
                    sb.append("开始获取实名认证状态：");
                    if (session != null) {
                        str = session.bduss;
                    } else {
                        str = "account is null";
                    }
                    sb.append(str);
                    defaultLog.c("pass", sb.toString());
                    if (session != null && !TextUtils.isEmpty(session.bduss)) {
                        RealNameDTO realNameDTO = new RealNameDTO();
                        realNameDTO.bduss = session.bduss;
                        if (TextUtils.isEmpty(data.scene)) {
                            realNameDTO.scene = FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE;
                        } else {
                            realNameDTO.scene = data.scene;
                        }
                        realNameDTO.needCbKey = data.needCbKey;
                        realNameDTO.realNameLevel = data.realNameLevel;
                        realNameDTO.customRealNameUrl = data.customRealNameUrl;
                        PassportSDK.getInstance().loadAccountRealName(TbadkApplication.getInst().getContext(), new a(this, data), realNameDTO);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class h implements CustomMessageTask.CustomRunnable<CertificationCheckParams> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements SapiCallback<CheckUserFaceIdResult> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ICheckCertificationCallback a;

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                }
            }

            public a(h hVar, ICheckCertificationCallback iCheckCertificationCallback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, iCheckCertificationCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iCheckCertificationCallback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: a */
            public void onFailure(CheckUserFaceIdResult checkUserFaceIdResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, checkUserFaceIdResult) == null) {
                    zq8 defaultLog = DefaultLog.getInstance();
                    defaultLog.b("pass", "CheckCertificationResult failed -> code : " + checkUserFaceIdResult.getResultCode() + " | msg : " + checkUserFaceIdResult.getResultMsg());
                    ICheckCertificationCallback iCheckCertificationCallback = this.a;
                    if (iCheckCertificationCallback != null) {
                        iCheckCertificationCallback.onResult(s05.b(checkUserFaceIdResult, false));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: b */
            public void onSuccess(CheckUserFaceIdResult checkUserFaceIdResult) {
                ICheckCertificationCallback iCheckCertificationCallback;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, checkUserFaceIdResult) == null) && (iCheckCertificationCallback = this.a) != null) {
                    iCheckCertificationCallback.onResult(s05.b(checkUserFaceIdResult, true));
                }
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<CertificationCheckParams> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof CertificationCheckParams)) {
                    CertificationCheckParams data = customMessage.getData();
                    ICheckCertificationCallback iCheckCertificationCallback = data.callback;
                    SapiAccount session = SapiAccountManager.getInstance().getSession();
                    if (session != null && !TextUtils.isEmpty(session.bduss)) {
                        SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new a(this, iCheckCertificationCallback), session.bduss, data.params);
                    }
                }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (SapiAccountManager.getInstance().isLogin()) {
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity instanceof BaseActivity) {
                        new s19((BaseActivity) currentActivity).h();
                    }
                }
            }
        }

        @Override // com.baidu.sapi2.callback.GlobalCallback
        public void onNeedInitPassSdk() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (PassManagerStatic.b != null) {
                    try {
                        SapiAccountManager.getInstance().init(PassManagerStatic.b);
                    } catch (Exception e) {
                        BdLog.e(e);
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
        public final /* synthetic */ Context a;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onFinish(AccountCenterResult accountCenterResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountCenterResult) == null) && accountCenterResult != null && accountCenterResult.isAccountDestory) {
                MessageManager.getInstance().runTask(2921330, null, this.a);
            }
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onJumpTo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                super.onJumpTo(str);
                if (UrlManager.getInstance().isUrlValid(str)) {
                    qx4.x(TbadkCoreApplication.getInst().getContext(), "", str, true, true, true);
                }
            }
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onSocialBind(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WXEntryActivityConfig(this.a, 230016)));
            }
        }

        @Override // com.baidu.sapi2.callback.AccountCenterCallback
        public void onBdussChange() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onBdussChange();
                MessageManager.getInstance().runTask(2921330, null, this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements CustomMessageTask.CustomRunnable<r19> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<r19> customMessage) {
            InterceptResult invokeL;
            BaseResp baseResp;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && (customMessage.getData() instanceof r19)) {
                    r19 data = customMessage.getData();
                    if (data.a != null && (baseResp = data.b) != null && (baseResp instanceof SendAuth.Resp)) {
                        PassportSDK.getInstance().handleWXLoginResp(data.a, ((SendAuth.Resp) baseResp).state, ((SendAuth.Resp) baseResp).code, data.b.errCode);
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
        public e(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    public static class g implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public static class k implements CustomMessageTask.CustomRunnable<Activity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ec5> run(CustomMessage<Activity> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2001268, g29.d());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class l implements CustomMessageTask.CustomRunnable<Activity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<u05> run(CustomMessage<Activity> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2001293, d29.e());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    public static class n implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public static class o implements CustomMessageTask.CustomRunnable<Application> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (customMessage == null || !PermissionUtil.isAgreePrivacyPolicy()) {
                    return null;
                }
                if (!gp5.l()) {
                    ip5.i(new InitWeiboSdkEvent());
                    return null;
                }
                Application data = customMessage.getData();
                if (!PassManagerStatic.a) {
                    try {
                        WbSdk.install(data, new AuthInfo(data, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                        boolean unused = PassManagerStatic.a = true;
                    } catch (Exception unused2) {
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class p implements CustomMessageTask.CustomRunnable<Application> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public static class q implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    PassManagerStatic.z(customMessage.getData());
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
        r();
        x();
        s();
        p();
        q();
        w();
        TbadkCoreApplication.getInst().RegisterIntent(ChangeSystemPhotoActivityConfig.class, ChangeSystemPhotoActivity.class);
        y();
        v();
        o();
        e29.o();
        t();
        u();
        n();
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

    public static void A() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65538, null) != null) || b == null) {
            return;
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
            b.isNightMode = true;
        } else {
            b.isNightMode = false;
        }
    }

    public static FastLoginFeature[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(FastLoginFeature.TX_QQ_SSO);
            arrayList.add(FastLoginFeature.TX_WEIXIN_SSO);
            arrayList.add(FastLoginFeature.SINA_WEIBO_SSO);
            arrayList.add(FastLoginFeature.YY_SSO);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921352, new g());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921328, new p());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921438, new o());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            MessageManager.getInstance().registerListener(new m(2016301));
            UrlManager.getInstance().addListener(new n());
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921530, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921535, new j());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921329, new q());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921351, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (!(context instanceof Activity)) {
                return false;
            }
            Activity activity = (Activity) context;
            if ((Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) || activity.isFinishing()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void j(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, tbPageContext, str) == null) && tbPageContext != null && !StringUtils.isNull(str)) {
            UrlManager.getInstance().dealOneLinkWithOutJumpWebView(tbPageContext, new String[]{str});
        }
    }

    public static boolean i(Context context, LoginDialogData loginDialogData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, loginDialogData)) == null) {
            if (LoginDialogData.HOME_PAGE_RESULT_PAGE.equals(loginDialogData.getLocate())) {
                return true;
            }
            if (LoginDialogData.SEARCH_RESULT_PAGE.equals(loginDialogData.getLocate())) {
                if (!(context instanceof BaseActivity)) {
                    return true;
                }
                j(((BaseActivity) context).getPageContext(), loginDialogData.getUrl());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SapiAccountManager.setGlobalCallback(new b());
            SapiConfiguration.Builder builder = new SapiConfiguration.Builder(context);
            if (n95.m().i("is_domain_qa", false)) {
                dc5.a = Domain.DOMAIN_QA;
                builder.setRuntimeEnvironment(Domain.DOMAIN_QA);
            } else {
                builder.setRuntimeEnvironment(dc5.a);
            }
            builder.setProductLineInfo(TbConfig.PassConfig.TPL, "1", TbConfig.PassConfig.ENC_KEY).sofireSdkConfig("200033", "ea737e4f435b53786043369d2e5ace4f", 1).customActionBar(true).skin("file:///android_asset/sapi_theme/style.css").fastLoginSupport(k()).wxAppID(TbConfig.WEIXIN_SHARE_APP_ID).qqAppID("101462192").sinaAppID("1511099634", PassBioEnv.PASSPORT_DOMAIN).yyOauthConfig("openyy183").setSupportTouchLogin(false).setSupportFaceLogin(true).enableShare(true).forbidPresetPhoneNumber(true);
            builder.setAgreeDangerousProtocol(PermissionUtil.isAgreePrivacyPolicy());
            Domain domain = dc5.a;
            Domain domain2 = Domain.DOMAIN_QA;
            if (domain == domain2) {
                builder.setRuntimeEnvironment(domain2.forceHttps(true));
                builder.debug(true);
            }
            b = builder.build();
            try {
                SapiAccountManager.getInstance().init(b);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            ss5.b().A(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921709, new h());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(2921710, new i());
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            dc5.a();
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginActivityConfig.class, LoginActivity.class);
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(LoginDialogActivityConfig.class, LoginDialogActivity.class);
            TbadkCoreApplication.getInst().RegisterOrUpdateIntent(OneKeyLoginActivityConfig.class, OneKeyLoginActivity.class);
        }
    }

    public static void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            MessageManager.getInstance().registerListener(new e(2921339));
            CustomMessageTask customMessageTask = new CustomMessageTask(2921339, new f());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001268, new k());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(2001293, new l());
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
        }
    }

    public static void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, context) == null) {
            MessageManager.getInstance().runTask(2921332, (Class) null);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null && !TextUtils.isEmpty(session.bduss)) {
                AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
                accountCenterDTO.bduss = session.bduss;
                accountCenterDTO.paramsList.add(AccountCenterDTO.HIDE_PERSONAL_DATA);
                accountCenterDTO.paramsList.add(new PassNameValuePair("thirdparty", "0"));
                PassportSDK passportSDK = PassportSDK.getInstance();
                A();
                passportSDK.loadAccountCenter(new c(context), accountCenterDTO);
            }
        }
    }
}
