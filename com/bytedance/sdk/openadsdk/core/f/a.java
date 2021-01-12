package com.bytedance.sdk.openadsdk.core.f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6537a = a.class.getSimpleName();

    public static boolean a(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? b(context, str) : c(context, str);
    }

    @RequiresApi(api = 19)
    private static boolean b(Context context, String str) {
        Exception exc;
        boolean z;
        String str2;
        u.f(f6537a, "checkPermissinKITKATNew，permission：" + str);
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c = 1;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c = 0;
                        break;
                    }
                    break;
                case -5573545:
                    if (str.equals("android.permission.READ_PHONE_STATE")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str2 = "android:coarse_location";
                    break;
                case 1:
                    str2 = "android:fine_location";
                    break;
                case 2:
                    str2 = "android:read_phone_state";
                    break;
                default:
                    str2 = str.replaceFirst("android.permission.", "android:").toLowerCase();
                    break;
            }
            int checkOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(str2, Binder.getCallingUid(), context.getPackageName());
            u.f(f6537a, "checkPermissinKITKATNew，locationOp,permission：" + checkOp + "," + str2);
            if (checkOp != 0) {
                try {
                    u.f(f6537a, "checkPermissinKITKATNew，false,permission：" + str2);
                    return false;
                } catch (Exception e) {
                    exc = e;
                    z = false;
                    u.f(f6537a, "权限检查出错时默认返回有权限，异常代码：" + exc);
                    return z;
                }
            }
            return true;
        } catch (Exception e2) {
            exc = e2;
            z = true;
        }
    }

    private static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
