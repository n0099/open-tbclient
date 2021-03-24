package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import android.content.Intent;
import com.baidu.wallet.lightapp.business.LightappBrowseActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class GetStartIntentAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (hashMap != null) {
            Intent startIntent = LightappBrowseActivity.getStartIntent(context, (String) hashMap.get("url"), ((Boolean) hashMap.get("withAnim")).booleanValue(), ((Boolean) hashMap.get("showShare")).booleanValue());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", startIntent);
            routerCallback.onResult(0, hashMap2);
        }
    }
}
