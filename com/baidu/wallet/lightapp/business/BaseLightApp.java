package com.baidu.wallet.lightapp.business;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.api.ILightAppListener;
import com.baidu.wallet.api.ILightappInvokerCallback;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class BaseLightApp implements ILightAppListener {
    @Override // com.baidu.wallet.api.ILightAppListener
    public boolean callShare(Activity activity, Map<String, String> map, ILightappInvokerCallback iLightappInvokerCallback) {
        return false;
    }

    @Override // com.baidu.wallet.api.ILightAppListener, com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        return Collections.emptySet();
    }

    @Override // com.baidu.wallet.api.ILightAppListener, com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
    }
}
