package com.baidu.wallet.home.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes5.dex */
public class EnterWalletHomeProvider extends RouterProvider {
    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        registerAction("wallethome", new StartWalletHomeAction());
    }
}
