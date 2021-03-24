package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.IPrecashierCallback;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterWalletPreOrderPayAction implements RouterAction {
    private void a(Context context, String str, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().preOrderPay(context, str, new IPrecashierCallback() { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletPreOrderPayAction.1
            @Override // com.baidu.wallet.api.IPrecashierCallback
            public void onResult(String str2) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", str2);
                    routerCallback.onResult(0, hashMap);
                }
            }
        });
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("options") && (hashMap.get("options") instanceof String)) {
            a(context, (String) hashMap.get("options"), routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
