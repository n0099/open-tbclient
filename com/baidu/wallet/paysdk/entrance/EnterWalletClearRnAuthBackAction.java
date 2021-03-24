package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterWalletClearRnAuthBackAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        BaiduPay.getInstance().clearRNAuthBack();
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("desc", "success");
            routerCallback.onResult(0, hashMap2);
        }
    }
}
