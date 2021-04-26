package com.baidu.wallet.paysdk.entrance;

import android.content.Context;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class EnterWalletSetRnAuthResultAction implements RouterAction {
    private void a(int i2, String str) {
        RNAuthCallBack rNAuthBack = BaiduPay.getInstance().getRNAuthBack();
        if (rNAuthBack != null) {
            rNAuthBack.onRNAuthResult(i2, str);
            BaiduPay.getInstance().clearRNAuthBack();
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap hashMap2 = new HashMap();
        if (hashMap == null || !hashMap.containsKey("statusCode") || !(hashMap.get("statusCode") instanceof Integer) || !hashMap.containsKey("desc")) {
            if (routerCallback != null) {
                hashMap2.put("errorMsg", "params-error");
                routerCallback.onResult(3, hashMap2);
                return;
            }
            return;
        }
        a(((Integer) hashMap.get("statusCode")).intValue(), (String) hashMap.get("desc"));
        if (routerCallback != null) {
            hashMap2.put("desc", "success");
            routerCallback.onResult(0, hashMap2);
        }
    }
}
