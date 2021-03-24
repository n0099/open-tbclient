package com.baidu.wallet.bankdetection.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes5.dex */
public class BankCardDetectionProvider extends RouterProvider {
    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        registerAction("bankcarddetction", new BankCardDetectionAction());
        registerAction("clearcallback", new ClearBankcardDetectCallBack());
    }
}
