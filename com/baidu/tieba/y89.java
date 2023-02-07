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
/* loaded from: classes7.dex */
public final class y89 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "databases";
    public static final String b = "shared_prefs";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948284175, "Lcom/baidu/tieba/y89;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948284175, "Lcom/baidu/tieba/y89;");
        }
    }

    public static final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c(g99.f());
            e();
            d();
            g99.a();
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a();
            f();
            h();
            g();
        }
    }

    public static final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState()) && g99.c(g99.d().getExternalCacheDir())) {
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
            return g99.c(g99.d().getCacheDir());
        }
        return invokeV.booleanValue;
    }

    public static final boolean f() {
        InterceptResult invokeV;
        String parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            File filesDir = g99.d().getFilesDir();
            if (filesDir == null) {
                parent = null;
            } else {
                parent = filesDir.getParent();
            }
            return g99.c(new File(parent, a));
        }
        return invokeV.booleanValue;
    }

    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return g99.c(g99.d().getFilesDir());
        }
        return invokeV.booleanValue;
    }

    public static final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return g99.c(g99.g(str));
        }
        return invokeL.booleanValue;
    }

    public static final boolean h() {
        InterceptResult invokeV;
        String parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            File filesDir = g99.d().getFilesDir();
            if (filesDir == null) {
                parent = null;
            } else {
                parent = filesDir.getParent();
            }
            boolean c = g99.c(new File(parent, b));
            if (c) {
                g99.b();
            }
            return c;
        }
        return invokeV.booleanValue;
    }
}
