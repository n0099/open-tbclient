package com.bytedance.sdk.openadsdk.core.g;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f30299a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(268178205, "Lcom/bytedance/sdk/openadsdk/core/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(268178205, "Lcom/bytedance/sdk/openadsdk/core/g/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return b(context, str);
            }
            return c(context, str);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r0 == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r0 == 2) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        r7 = r7.replaceFirst("android.permission.", "android:").toLowerCase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
        r7 = "android:read_phone_state";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
        r7 = "android:fine_location";
     */
    @RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, context, str)) != null) {
            return invokeLL.booleanValue;
        }
        String str2 = f30299a;
        k.f(str2, "checkPermissinKITKATNew，permission：" + str);
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
            String str4 = f30299a;
            k.f(str4, "checkPermissinKITKATNew，locationOp,permission：" + checkOp + "," + str3);
            if (checkOp != 0) {
                try {
                    String str5 = f30299a;
                    k.f(str5, "checkPermissinKITKATNew，false,permission：" + str3);
                    return false;
                } catch (Exception e2) {
                    e = e2;
                    String str6 = f30299a;
                    k.f(str6, "权限检查出错时默认返回有权限，异常代码：" + e);
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) ? context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 : invokeLL.booleanValue;
    }
}
