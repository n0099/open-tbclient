package com.baidu.titan.sdk.initer;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.annotation.DisableIntercept;
@DisableIntercept
/* loaded from: classes13.dex */
public class TitanIniter {
    public static Context sContext;

    public static Context getAppContext() {
        Context context = sContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("must call TitanIniter.init");
    }

    public static void init(Context context) {
        if (context instanceof Application) {
            sContext = context;
        } else {
            sContext = context.getApplicationContext();
        }
        if (sContext == null) {
            throw new IllegalStateException("context.getApplicationContext == null");
        }
    }
}
