package com.baidu.wallet.lightapp.entrance;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class InitWebviewPoolAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        LightappWebViewCenter.getInstance().initLightappWebViewPool((Activity) context);
    }
}
