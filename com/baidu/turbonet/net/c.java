package com.baidu.turbonet.net;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;
/* loaded from: classes.dex */
final class c {
    private static final Object sLock = new Object();
    private static int mfr = 0;

    public static String fF(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append('/');
        sb.append(fG(context));
        sb.append(" (Linux; U; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb.append("; ");
            sb.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb.append("; Build/");
            sb.append(str2);
        }
        sb.append("; TurboNet/");
        sb.append("53.0.2785.116");
        sb.append(')');
        return sb.toString();
    }

    private static int fG(Context context) {
        int i;
        synchronized (sLock) {
            if (mfr == 0) {
                try {
                    mfr = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalStateException("Cannot determine package version");
                }
            }
            i = mfr;
        }
        return i;
    }
}
