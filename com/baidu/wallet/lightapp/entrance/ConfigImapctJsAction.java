package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.business.a;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ConfigImapctJsAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (routerCallback == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        if (hashMap != null && hashMap.size() != 0) {
            String[] strArr = (String[]) hashMap.get("configs");
            String[] strArr2 = (String[]) hashMap.get("keys");
            if (strArr != null && strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
                a.a(context, SdkInitResponse.getInstance().getJsHookURl(context), strArr, strArr2);
                routerCallback.onResult(0, hashMap2);
                return;
            }
            hashMap2.put("errorMsg", "reqValueInvalid");
            routerCallback.onResult(1, hashMap2);
            return;
        }
        hashMap2.put("errorMsg", "reqValueInvalid");
        routerCallback.onResult(1, hashMap2);
    }
}
