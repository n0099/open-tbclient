package com.bytedance.sdk.openadsdk.core.j;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static AtomicInteger f66521a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(268267764, "Lcom/bytedance/sdk/openadsdk/core/j/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(268267764, "Lcom/bytedance/sdk/openadsdk/core/j/g;");
                return;
            }
        }
        f66521a = new AtomicInteger(1);
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f66521a.get() == 1 : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            boolean z = true;
            if (i2 == 1 || i2 == 2) {
                try {
                    if (f66521a.get() != i2) {
                        try {
                            f66521a.set(i2);
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            if (z) {
                            }
                        }
                    } else {
                        z = false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                if (z) {
                    return;
                }
                String str = "switch status changed: " + a();
                if (a()) {
                    o.b();
                    return;
                }
                try {
                    if (o.c() != null) {
                        o.c().b();
                    }
                    if (o.e() != null) {
                        o.e().b();
                    }
                    if (o.d() != null) {
                        o.d().b();
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    if (o.g() != null) {
                        o.g().a();
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    if (o.i() != null) {
                        o.i().b();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }
}
