package com.baidu.wallet.api;

import android.content.Context;
import com.baidu.apollon.NoProguard;
import java.util.Set;
/* loaded from: classes6.dex */
public interface ILightappInvoker extends NoProguard {
    Set<String> getMethodList();

    void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback);
}
