package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.lightapp.business.offlinecache.LangbridgeCacheManager;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class OfflineCacheConfigAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        LangbridgeCacheManager.getInstance().offlineConfigUpdate((String) hashMap.get("config"));
    }
}
