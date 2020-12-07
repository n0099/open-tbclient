package com.baidu.webkit.sdk.dumper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.baidu.webkit.internal.ApisInteractWithMario;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes12.dex */
public class ZwDebug {
    private static boolean debugModel;

    public static void clearCrashKey(String str) {
        ApisInteractWithMario.clearCrashKey(str);
    }

    public static void crashIntentionally(int i) {
        if (debugModel) {
            WebViewFactory.getProvider().getStatics().crashIntentionally(i);
        }
    }

    public static boolean debugModel() {
        return debugModel;
    }

    public static synchronized void init(Context context) {
        synchronized (ZwDebug.class) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    debugModel = (applicationInfo.flags & 2) != 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        ApisInteractWithMario.setCrashKeyValue(str, str2);
    }
}
