package com.baidu.wallet.passport;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletApiExtListener;
/* loaded from: classes13.dex */
public class b implements WalletApiExtListener.LoginstatuSyncListener {
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

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onHandleWalletError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onWebViewLogout(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, syncLoginStatusCb) == null) {
            SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback(this, syncLoginStatusCb) { // from class: com.baidu.wallet.passport.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletApiExtListener.SyncLoginStatusCb a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f53912b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, syncLoginStatusCb};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53912b = this;
                    this.a = syncLoginStatusCb;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                /* renamed from: a */
                public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                    WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, web2NativeLoginResult) == null) || (syncLoginStatusCb2 = this.a) == null) {
                        return;
                    }
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEXPIRED);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                    WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, web2NativeLoginResult) == null) || (syncLoginStatusCb2 = this.a) == null) {
                        return;
                    }
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: c */
                public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                    WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, web2NativeLoginResult) == null) || (syncLoginStatusCb2 = this.a) == null) {
                        return;
                    }
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.FAIL);
                }

                @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
                public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                    WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, web2NativeLoginResult) == null) || (syncLoginStatusCb2 = this.a) == null) {
                        return;
                    }
                    syncLoginStatusCb2.onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult.BDUSSEMPTY);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                    }
                }
            }, true);
        }
    }
}
