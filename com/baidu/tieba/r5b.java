package com.baidu.tieba;

import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class r5b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "databases";
    public static final String b = "app_swan_prefs";
    public static final String c = "shared_prefs";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948074026, "Lcom/baidu/tieba/r5b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948074026, "Lcom/baidu/tieba/r5b;");
        }
    }

    public static final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c(z5b.f());
            e();
            d();
            z5b.a();
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a();
            i();
            f();
            h();
            g();
        }
    }

    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && z5b.c(z5b.d().getExternalCacheDir())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return z5b.c(z5b.d().getCacheDir());
        }
        return invokeV.booleanValue;
    }

    public static final boolean f() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            File filesDir = z5b.d().getFilesDir();
            if (filesDir != null) {
                str = filesDir.getParent();
            } else {
                str = null;
            }
            return z5b.c(new File(str, a));
        }
        return invokeV.booleanValue;
    }

    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return z5b.c(z5b.d().getFilesDir());
        }
        return invokeV.booleanValue;
    }

    public static final boolean i() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File filesDir = z5b.d().getFilesDir();
            if (filesDir != null) {
                str = filesDir.getParent();
            } else {
                str = null;
            }
            return z5b.c(new File(str, b));
        }
        return invokeV.booleanValue;
    }

    public static final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return z5b.c(z5b.g(str));
        }
        return invokeL.booleanValue;
    }

    public static final boolean h() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            File filesDir = z5b.d().getFilesDir();
            if (filesDir != null) {
                str = filesDir.getParent();
            } else {
                str = null;
            }
            boolean c2 = z5b.c(new File(str, c));
            if (c2) {
                z5b.b();
            }
            return c2;
        }
        return invokeV.booleanValue;
    }
}
