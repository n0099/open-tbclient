package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterWalletDoRnAuthAction implements RouterAction {
    private void a(Context context, HashMap<String, String> hashMap, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().doRNAuth(context, hashMap, new RNAuthCallBack() { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDoRnAuthAction.1
            @Override // com.baidu.wallet.rnauth.RNAuthCallBack
            public void onRNAuthResult(int i2, String str) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("statusCode", Integer.valueOf(i2));
                    hashMap2.put("authDesc", str);
                    routerCallback.onResult(0, hashMap2);
                }
            }
        });
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null) {
            a(context, hashMap, routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
