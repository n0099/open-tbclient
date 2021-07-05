package com.baidu.tieba.medialive.thirdaccount;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.ILoginListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.s0;
/* loaded from: classes5.dex */
public class ThirdPartyAccountServiceImpl implements ThirdPartAccountService {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ThirdPartAccountService.LoginResultCallback f18467a;

    /* renamed from: b  reason: collision with root package name */
    public static final ILoginListener f18468b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements SapiCallback<OAuthResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThirdPartAccountService.OpenAccessTokenCallback f18469e;

        public a(ThirdPartyAccountServiceImpl thirdPartyAccountServiceImpl, ThirdPartAccountService.OpenAccessTokenCallback openAccessTokenCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thirdPartyAccountServiceImpl, openAccessTokenCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18469e = openAccessTokenCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(OAuthResult oAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oAuthResult) == null) {
                this.f18469e.onFailed("accessToken is null");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(OAuthResult oAuthResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oAuthResult) == null) || oAuthResult == null) {
                return;
            }
            try {
                this.f18469e.onResult(oAuthResult.accessToken);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

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
        f18468b = new ILoginListener() { // from class: com.baidu.tieba.medialive.thirdaccount.ThirdPartyAccountServiceImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onCancel() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ThirdPartyAccountServiceImpl.f18467a.onResult(-2);
                }
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onFail() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    ThirdPartyAccountServiceImpl.f18467a.onResult(-1);
                }
            }

            @Override // com.baidu.tbadk.ala.ILoginListener
            public void onSuccess() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    ThirdPartyAccountServiceImpl.f18467a.onResult(0);
                }
            }
        };
    }

    public ThirdPartyAccountServiceImpl() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void bindPhone(Context context, ThirdPartAccountService.BindPhoneCallback bindPhoneCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bindPhoneCallback) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void getOpenAccessToken(ThirdPartAccountService.OpenAccessTokenCallback openAccessTokenCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openAccessTokenCallback, z) == null) {
            String bduss = TbadkCoreApplication.getCurrentAccountInfo().getBDUSS();
            if (TextUtils.isEmpty(bduss)) {
                openAccessTokenCallback.onFailed("bduss is null");
            } else {
                SapiAccountManager.getInstance().getAccountService().oauthAccessToken(new a(this, openAccessTokenCallback), bduss, TbConfig.PassConfig.OAUTH_OPEN_PLATFORM_ID, z);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService
    public void showLoginDialog(Context context, ThirdPartAccountService.LoginResultCallback loginResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, loginResultCallback) == null) {
            s0 s0Var = new s0(context, "");
            s0Var.e(f18468b);
            DialogLoginHelper.checkUpIsLogin(s0Var);
            f18467a = loginResultCallback;
        }
    }
}
