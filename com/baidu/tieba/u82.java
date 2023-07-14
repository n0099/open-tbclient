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
/* loaded from: classes8.dex */
public class u82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, ay1> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948164794, "Lcom/baidu/tieba/u82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948164794, "Lcom/baidu/tieba/u82;");
                return;
            }
        }
        a = fs1.a;
        b = new HashMap(2);
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && c()) {
            b();
        }
    }

    public static ay1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("ConsoleCache", "create new sConsole");
            }
            v82.n(true);
            return pi2.U().f0().b(AppRuntime.getAppContext());
        }
        return (ay1) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            vb3 b0 = vb3.b0();
            if (b0 != null && !TextUtils.isEmpty(b0.b)) {
                return t82.b(x32.a(b0.b));
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
    public static synchronized ay1 b() {
        InterceptResult invokeV;
        String str;
        ay1 ay1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (u82.class) {
                vb3 b0 = vb3.b0();
                if (b0 != null && !TextUtils.isEmpty(b0.getAppId())) {
                    str = b0.getAppId();
                    String a2 = x32.a(str);
                    ay1Var = b.get(a2);
                    if (ay1Var == null) {
                        e();
                        ay1Var = a();
                        b.put(a2, ay1Var);
                        if (a) {
                            Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                        }
                    }
                    if (a) {
                        Log.d("ConsoleCache", "get sconsole for appId - " + str);
                    }
                }
                str = "_no_id_";
                String a22 = x32.a(str);
                ay1Var = b.get(a22);
                if (ay1Var == null) {
                }
                if (a) {
                }
            }
            return ay1Var;
        }
        return (ay1) invokeV.objValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (u82.class) {
                if (b.size() > 0) {
                    for (String str : b.keySet()) {
                        ay1 ay1Var = b.get(str);
                        if (ay1Var != null) {
                            ay1Var.D();
                        }
                    }
                    b.clear();
                }
            }
        }
    }
}
