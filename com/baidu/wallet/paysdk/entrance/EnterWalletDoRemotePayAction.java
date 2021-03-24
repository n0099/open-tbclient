package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterWalletDoRemotePayAction implements RouterAction {
    private void a(Context context, String str, final boolean z, HashMap<String, String> hashMap, final RouterCallback routerCallback) {
        BaiduPayDelegate.getInstance().doRemotePay(context, str, new PayCallBack() { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDoRemotePayAction.1
            @Override // com.baidu.android.pay.PayCallBack
            public boolean isHideLoadingDialog() {
                return z;
            }

            @Override // com.baidu.android.pay.PayCallBack
            public void onPayResult(int i, String str2) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("statusCode", Integer.valueOf(i));
                    hashMap2.put("payDesc", str2);
                    routerCallback.onResult(0, hashMap2);
                }
            }
        }, hashMap);
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap<String, String> hashMap2;
        if (context == null || hashMap == null || !hashMap.containsKey("showDialog") || !(hashMap.get("showDialog") instanceof Boolean) || !hashMap.containsKey("orderInfo") || !(hashMap.get("orderInfo") instanceof String)) {
            if (routerCallback != null) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap3);
                return;
            }
            return;
        }
        boolean booleanValue = ((Boolean) hashMap.get("showDialog")).booleanValue();
        String str = (String) hashMap.get("orderInfo");
        if (hashMap.containsKey("params") && (hashMap.get("params") instanceof HashMap)) {
            hashMap2 = (HashMap) hashMap.get("params");
        } else {
            hashMap2 = new HashMap<>();
        }
        a(context, str, booleanValue, hashMap2, routerCallback);
    }
}
