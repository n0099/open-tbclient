package com.baidu.wallet.paysdk.entrance;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterProvider;
import com.dxmpay.wallet.core.beans.BeanConstants;
/* loaded from: classes10.dex */
public class DxmPaySDKProvider extends RouterProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DxmPaySDKProvider() {
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

    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerAction("gotoWalletService", new EnterWalletServiceAction());
            registerAction("enterClearRnAuthBack", new EnterWalletClearRnAuthBackAction());
            registerAction("enterSetRnAuthResult", new EnterWalletSetRnAuthResultAction());
            registerAction("enterDoPayWithParams", new EnterWalletDoPayWithParamsAction());
            registerAction("enterDoInnerBind", new EnterWalletDoInnerBindAction());
            registerAction("enterDoRnAuth", new EnterWalletDoRnAuthAction());
            registerAction("enterGetPayMethod", new EnterWalletGetPayMethodAction());
            registerAction("enterChangePayMethod", new EnterWalletChangePayMethodAction());
            registerAction("enterPreOrderPay", new EnterWalletPreOrderPayAction());
            registerAction("enterDoRemotePay", new EnterWalletDoRemotePayAction());
            registerAction("enterDoPostEvent", new EnterWalletDoPostEventAction());
            registerAction(BeanConstants.SDK_ENTER_WALLET_DXM_PAY_SERVICE, new EnterWalletDxmPayServiceAction());
        }
    }
}
