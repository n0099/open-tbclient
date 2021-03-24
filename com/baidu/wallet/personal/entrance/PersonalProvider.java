package com.baidu.wallet.personal.entrance;

import com.baidu.wallet.router.RouterProvider;
/* loaded from: classes5.dex */
public class PersonalProvider extends RouterProvider {
    @Override // com.baidu.wallet.router.RouterProvider
    public void registerActions() {
        registerAction("entercoupon", new EnterCouponPageAction());
    }
}
