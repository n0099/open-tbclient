package com.baidu.wallet.lightapp.entrance;

import android.content.Context;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class LangbrigeInvokeAction implements RouterAction {
    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        if (hashMap != null) {
            LightAppWrapper.getInstance().lightappInvoke(context, (String) hashMap.get("options"), (ILightappInvokerCallback) hashMap.get("invoke_callback"));
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errorMsg", "参数异常");
        routerCallback.onResult(3, hashMap2);
    }
}
