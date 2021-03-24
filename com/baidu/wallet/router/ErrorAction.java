package com.baidu.wallet.router;

import android.content.Context;
import com.baidu.wallet.core.NoProguard;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ErrorAction implements NoProguard, RouterAction {
    public static final String DEFAULT_MESSAGE = "Something was really wrong.";

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errorMsg", DEFAULT_MESSAGE);
            routerCallback.onResult(5, hashMap2);
        }
    }
}
