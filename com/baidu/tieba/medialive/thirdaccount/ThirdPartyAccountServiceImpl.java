package com.baidu.tieba.medialive.thirdaccount;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ThirdPartyAccountServiceImpl implements ThirdPartAccountService {
    public static /* synthetic */ Interceptable $ic;
    public static ThirdPartAccountService.LoginResultCallback a;
    public static final ILoginListener b;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void bindPhone(Context context, ThirdPartAccountService.BindPhoneCallback bindPhoneCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bindPhoneCallback) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements SapiCallback<OAuthResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThirdPartAccountService.OpenAccessTokenCallback a;

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

        public a(ThirdPartyAccountServiceImpl thirdPartyAccountServiceImpl, ThirdPartAccountService.OpenAccessTokenCallback openAccessTokenCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thirdPartyAccountServiceImpl, openAccessTokenCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = openAccessTokenCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(OAuthResult oAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oAuthResult) == null) {
                this.a.onFailed("accessToken is null");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(OAuthResult oAuthResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oAuthResult) == null) && oAuthResult != null) {
                try {
                    this.a.onResult(oAuthResult.accessToken);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2128429864, "Lcom/baidu/tieba/medialive/thirdaccount/ThirdPartyAccountServiceImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2128429864, "Lcom/baidu/tieba/medialive/thirdaccount/ThirdPartyAccountServiceImpl;");
                return;
            }
        }
        b = new ILoginListener() { // from class: com.baidu.tieba.medialive.thirdaccount.ThirdPartyAccountServiceImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onCancel() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && ThirdPartyAccountServiceImpl.a != null) {
                    ThirdPartyAccountServiceImpl.a.onResult(-2);
                }
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onFail() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ThirdPartyAccountServiceImpl.a != null) {
                    ThirdPartyAccountServiceImpl.a.onResult(-1);
                }
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onSuccess() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ThirdPartyAccountServiceImpl.a != null) {
                    ThirdPartyAccountServiceImpl.a.onResult(0);
                }
            }
        };
    }

    public ThirdPartyAccountServiceImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void getOpenAccessToken(ThirdPartAccountService.OpenAccessTokenCallback openAccessTokenCallback, boolean z) {
        String bduss;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openAccessTokenCallback, z) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo == null) {
                bduss = "";
            } else {
                bduss = currentAccountInfo.getBDUSS();
            }
            if (TextUtils.isEmpty(bduss)) {
                openAccessTokenCallback.onFailed("bduss is null");
            } else if (SapiAccountManager.getInstance().getAccountService() == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
                openAccessTokenCallback.onFailed("pass not init");
            } else {
                SapiAccountManager.getInstance().getAccountService().oauthAccessToken(new a(this, openAccessTokenCallback), bduss, TbConfig.PassConfig.OAUTH_OPEN_PLATFORM_ID, z);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void showLoginDialog(Context context, ThirdPartAccountService.LoginResultCallback loginResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, loginResultCallback) == null) {
            LoginDialogData loginDialogData = new LoginDialogData(context, "");
            loginDialogData.setLoginListener(b);
            DialogLoginHelper.checkUpIsLogin(loginDialogData);
            a = loginResultCallback;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void showLoginDialog(Context context, String str, ThirdPartAccountService.LoginResultCallback loginResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, loginResultCallback) == null) {
            showLoginDialog(context, loginResultCallback);
        }
    }
}
