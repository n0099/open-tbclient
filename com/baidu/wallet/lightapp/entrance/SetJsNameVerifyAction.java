package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.base.LightappJsClient;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class SetJsNameVerifyAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (hashMap != null) {
            LightappJsClient.enableJsNameVerify("1".equals((String) hashMap.get("enableJsNameVerify")));
            routerCallback.onResult(0, null);
        }
    }
}
