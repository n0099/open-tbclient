package com.baidu.wallet.lightapp.entrance;

import android.app.Application;
import android.content.Context;
import com.baidu.wallet.lightapp.business.LightappBrowseActivity;
import com.baidu.wallet.lightapp.multipage.LangbridgeActivity;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class RemoveH5LifeCycleCbAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (hashMap != null) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) hashMap.get("lifeCycleCb");
            Object obj = hashMap.get("activity");
            if (obj == null || activityLifecycleCallbacks == null) {
                return;
            }
            if (obj instanceof LightappBrowseActivity) {
                ((LightappBrowseActivity) obj).removeLifeCycleListener(activityLifecycleCallbacks);
            } else if (obj instanceof LangbridgeActivity) {
                ((LangbridgeActivity) obj).removeLifeCycleListener(activityLifecycleCallbacks);
            }
            routerCallback.onResult(0, null);
        }
    }
}
