package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.android.pay.BindBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterWalletDoInnerBindAction implements RouterAction {
    private void a(Context context, final boolean z, String str, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().doInnerBind(context, new BindBack() { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDoInnerBindAction.1
            @Override // com.baidu.android.pay.BindBack
            public boolean isHideLoadingDialog() {
                return z;
            }

            @Override // com.baidu.android.pay.BindBack
            public void onBindResult(int i, String str2) {
                if (routerCallback != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("statusCode", Integer.valueOf(i));
                    hashMap.put("params", str2);
                    routerCallback.onResult(0, hashMap);
                }
            }
        }, new HashMap(), str);
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context != null && hashMap != null && hashMap.containsKey("showDialog") && (hashMap.get("showDialog") instanceof Boolean) && hashMap.containsKey("orderInfo") && (hashMap.get("orderInfo") instanceof String)) {
            a(context, ((Boolean) hashMap.get("showDialog")).booleanValue(), (String) hashMap.get("orderInfo"), routerCallback);
        } else if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", "params-error");
            routerCallback.onResult(3, hashMap2);
        }
    }
}
