package com.bytedance.sdk.openadsdk.core.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class b {
    public static void a(@NonNull Activity activity, @NonNull String[] strArr, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i2);
        }
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable th) {
                th.printStackTrace();
                return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
            }
        }
        throw new IllegalArgumentException("permission is null");
    }
}
