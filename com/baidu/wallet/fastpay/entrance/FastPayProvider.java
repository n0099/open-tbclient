package com.baidu.wallet.fastpay.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes5.dex */
public class FastPayProvider extends RouterProvider {
    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        registerAction("doPhoneCharge", new DoPhoneChargeAction());
    }
}
