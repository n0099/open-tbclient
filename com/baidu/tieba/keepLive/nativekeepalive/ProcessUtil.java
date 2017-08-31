package com.baidu.tieba.keepLive.nativekeepalive;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
/* loaded from: classes.dex */
public class ProcessUtil {
    public static String getProcessName(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int myPid = Process.myPid();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < runningAppProcesses.size()) {
                if (runningAppProcesses.get(i2).pid != myPid) {
                    i = i2 + 1;
                } else {
                    String str = runningAppProcesses.get(i2).processName;
                    if (str == null) {
                        return "";
                    }
                    return str;
                }
            } else {
                return "";
            }
        }
    }

    public static boolean isMainProcess(Context context) {
        String packageName = context.getPackageName();
        if (StringUtils.isNull(packageName)) {
            return false;
        }
        return packageName.equals(getProcessName(context));
    }

    public static boolean isNativeProcess(Context context) {
        String str = context.getPackageName() + ":guardService";
        String str2 = context.getPackageName() + ":wakeUp";
        String processName = getProcessName(context);
        if (StringUtils.isNull(processName)) {
            return false;
        }
        return processName.equals(str) || processName.equals(str2);
    }
}
