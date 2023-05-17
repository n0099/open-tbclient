package com.bytedance.pangle.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    public static final char[] a = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String b;

    public static boolean a() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(@NonNull Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        String packageName = context.getPackageName();
        return (TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true;
    }

    public static String b(Context context) {
        if (b == null) {
            File file = new File(context.getApplicationInfo().sourceDir);
            String[] a2 = com.bytedance.pangle.util.a.b.a(file);
            if (TextUtils.isEmpty(a2[0])) {
                a2 = com.bytedance.pangle.util.a.a.a(file);
            }
            String str = a2[0];
            b = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.e(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + a2[2]);
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b1654612903156dc(String str) {
        while (true) {
            char c = 'J';
            char c2 = '7';
            while (true) {
                switch (c) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c2) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                break;
                            default:
                                switch (c2) {
                                }
                        }
                        c = 'I';
                        c2 = '`';
                        break;
                    case 'J':
                        switch (c2) {
                        }
                        c = 'I';
                        c2 = '`';
                        break;
                    default:
                        c = 'H';
                }
            }
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ i);
        }
        return new String(charArray);
    }
}
