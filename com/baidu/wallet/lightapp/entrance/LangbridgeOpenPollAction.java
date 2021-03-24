package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.multipage.LangbridgeSettings;
import com.baidu.wallet.lightapp.multipage.h;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class LangbridgeOpenPollAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        HashMap hashMap2 = new HashMap();
        LangbridgeSettings a2 = h.a().a(context);
        if (a2 != null) {
            hashMap2.put("openPoll", Boolean.valueOf(!a2.MW_USE_OLD || a2.MW_ON));
        }
        routerCallback.onResult(0, hashMap2);
    }
}
