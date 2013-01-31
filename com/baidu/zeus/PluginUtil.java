package com.baidu.zeus;

import android.content.Context;
import android.util.Log;
/* loaded from: classes.dex */
class PluginUtil {
    private static final String LOGTAG = "PluginUtil";

    PluginUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PluginStub getPluginStub(Context context, String str, String str2) {
        Object newInstance;
        try {
            newInstance = context.createPackageContext(str, 3).getClassLoader().loadClass(str2).newInstance();
        } catch (Exception e) {
            Log.e(LOGTAG, Log.getStackTraceString(e));
        }
        if (newInstance instanceof PluginStub) {
            return (PluginStub) newInstance;
        }
        Log.e(LOGTAG, "The plugin class is not of type PluginStub");
        return null;
    }
}
