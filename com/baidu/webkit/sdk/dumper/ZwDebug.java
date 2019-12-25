package com.baidu.webkit.sdk.dumper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.a.a.a.a.a.a.a;
import com.baidu.webkit.internal.ApisInteractWithMario;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes9.dex */
public class ZwDebug {
    private static boolean debugModel = false;

    public static void clearCrashKey(String str) {
        ApisInteractWithMario.clearCrashKey(str);
    }

    public static void crashIntentionally() {
        if (debugModel) {
            WebViewFactory.getProvider().getStatics().crashIntentionally();
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
                a.a(e);
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        ApisInteractWithMario.setCrashKeyValue(str, str2);
    }
}
