package com.baidu.wallet.paysdk.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes5.dex */
public class DxmPaySDKProvider extends RouterProvider {
    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        registerAction("gotoWalletService", new EnterWalletServiceAction());
        registerAction("enterClearRnAuthBack", new EnterWalletClearRnAuthBackAction());
        registerAction("enterSetRnAuthResult", new EnterWalletSetRnAuthResultAction());
        registerAction("enterDoPayWithParams", new EnterWalletDoPayWithParamsAction());
        registerAction("enterDoInnerBind", new EnterWalletDoInnerBindAction());
        registerAction("enterDoRnAuth", new EnterWalletDoRnAuthAction());
        registerAction("enterGetPayMethod", new EnterWalletGetPayMethodAction());
        registerAction("enterChangePayMethod", new EnterWalletChangePayMethodAction());
        registerAction("enterPreOrderPay", new EnterWalletPreOrderPayAction());
        registerAction("enterIdCardDetect", new EnterWalletIdCardDetectAction());
        registerAction("enterDoRemotePay", new EnterWalletDoRemotePayAction());
    }
}
