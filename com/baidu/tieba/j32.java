package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class j32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, qs1> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832288, "Lcom/baidu/tieba/j32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832288, "Lcom/baidu/tieba/j32;");
                return;
            }
        }
        a = vm1.a;
        b = new HashMap(2);
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && c()) {
            b();
        }
    }

    public static qs1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("ConsoleCache", "create new sConsole");
            }
            k32.n(true);
            return ed2.V().g0().b(AppRuntime.getAppContext());
        }
        return (qs1) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            k63 c0 = k63.c0();
            if (c0 != null && !TextUtils.isEmpty(c0.b)) {
                return i32.b(ny1.a(c0.b));
            }
            if (a) {
                Log.w("ConsoleCache", "swanApp is null or appId is empty");
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized qs1 b() {
        InterceptResult invokeV;
        String str;
        qs1 qs1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (j32.class) {
                k63 c0 = k63.c0();
                if (c0 != null && !TextUtils.isEmpty(c0.getAppId())) {
                    str = c0.getAppId();
                    String a2 = ny1.a(str);
                    qs1Var = b.get(a2);
                    if (qs1Var == null) {
                        e();
                        qs1Var = a();
                        b.put(a2, qs1Var);
                        if (a) {
                            Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                        }
                    }
                    if (a) {
                        Log.d("ConsoleCache", "get sconsole for appId - " + str);
                    }
                }
                str = "_no_id_";
                String a22 = ny1.a(str);
                qs1Var = b.get(a22);
                if (qs1Var == null) {
                }
                if (a) {
                }
            }
            return qs1Var;
        }
        return (qs1) invokeV.objValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (j32.class) {
                if (b.size() > 0) {
                    for (String str : b.keySet()) {
                        qs1 qs1Var = b.get(str);
                        if (qs1Var != null) {
                            qs1Var.C();
                        }
                    }
                    b.clear();
                }
            }
        }
    }
}
