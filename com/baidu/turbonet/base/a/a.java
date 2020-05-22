package com.baidu.turbonet.base.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.support.multidex.MultiDex;
import com.baidu.turbonet.base.BuildConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class a {
    public static void install(Context context) {
        if (BuildConfig.isMultidexEnabled()) {
            if (Build.VERSION.SDK_INT < 21 && !fD(context)) {
                com.baidu.turbonet.base.a.g("base_multidex", "Skipping multidex installation: not needed for process.", new Object[0]);
                return;
            }
            MultiDex.install(context);
            com.baidu.turbonet.base.a.g("base_multidex", "Completed multidex installation.", new Object[0]);
        }
    }

    private static String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (SecurityException e) {
            return null;
        }
    }

    private static boolean fD(Context context) {
        try {
            Object invoke = Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null && (invoke instanceof Boolean)) {
                if (((Boolean) invoke).booleanValue()) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchMethodException e3) {
        } catch (InvocationTargetException e4) {
        }
        String processName = getProcessName(context);
        if (processName != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    return true;
                }
                return !applicationInfo.metaData.getBoolean(new StringBuilder().append(processName).append(".ignore_multidex").toString(), false);
            } catch (PackageManager.NameNotFoundException e5) {
                return true;
            }
        }
        return true;
    }
}
