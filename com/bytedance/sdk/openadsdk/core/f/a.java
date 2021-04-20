package com.bytedance.sdk.openadsdk.core.f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28021a = "a";

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b(context, str);
        }
        return c(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r0 == 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r0 == 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        r7 = r7.replaceFirst("android.permission.", "android:").toLowerCase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        r7 = "android:read_phone_state";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        r7 = "android:fine_location";
     */
    @RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str) {
        String str2 = f28021a;
        u.f(str2, "checkPermissinKITKATNew，permission：" + str);
        char c2 = 65535;
        boolean z = false;
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1888586689) {
                if (hashCode != -63024214) {
                    if (hashCode == -5573545 && str.equals("android.permission.READ_PHONE_STATE")) {
                        c2 = 2;
                    }
                } else if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    c2 = 0;
                }
            } else if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                c2 = 1;
            }
            String str3 = "android:coarse_location";
            int checkOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(str3, Binder.getCallingUid(), context.getPackageName());
            String str4 = f28021a;
            u.f(str4, "checkPermissinKITKATNew，locationOp,permission：" + checkOp + "," + str3);
            if (checkOp != 0) {
                try {
                    String str5 = f28021a;
                    u.f(str5, "checkPermissinKITKATNew，false,permission：" + str3);
                    return false;
                } catch (Exception e2) {
                    e = e2;
                    String str6 = f28021a;
                    u.f(str6, "权限检查出错时默认返回有权限，异常代码：" + e);
                    return z;
                }
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            z = true;
        }
    }

    public static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
