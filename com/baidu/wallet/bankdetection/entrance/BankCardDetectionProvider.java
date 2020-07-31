package com.baidu.wallet.bankdetection.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes9.dex */
public class BankCardDetectionProvider extends RouterProvider {
    protected void registerActions() {
        registerAction("bankcarddetction", new BankCardDetectionAction());
        registerAction("clearcallback", new ClearBankcardDetectCallBack());
    }
}
