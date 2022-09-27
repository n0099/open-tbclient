package com.baidu.tieba;

import android.content.Context;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        ma9 c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || (c = sa9.c()) == null) {
            return;
        }
        c.b();
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ka9 a = sa9.a();
            if (a != null) {
                return a.getAppContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ka9 a = sa9.a();
            return a != null ? a.c(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ka9 a = sa9.a();
            if (a != null) {
                return a.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static IBinder e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ma9 c = sa9.c();
            if (c != null) {
                return c.a(str);
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public static int f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            ka9 a = sa9.a();
            return a != null ? a.getInt(str, i) : i;
        }
        return invokeLI.intValue;
    }

    public static long g(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j)) == null) {
            ka9 a = sa9.a();
            return a != null ? a.getLong(str, j) : j;
        }
        return invokeLJ.longValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            ka9 a = sa9.a();
            return a != null ? a.e(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static m99 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sa9.e() : (m99) invokeV.objValue;
    }

    public static q99 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? sa9.f() : (q99) invokeV.objValue;
    }

    public static String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            ka9 a = sa9.a();
            return a != null ? a.b(z) : "";
        }
        return (String) invokeZ.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            la9 b = sa9.b();
            if (b != null) {
                return b.isAgreePrivacy();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            ka9 a = sa9.a();
            if (a != null) {
                return a.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void n(String str, int i) {
        ka9 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65549, null, str, i) == null) || (a = sa9.a()) == null) {
            return;
        }
        a.putInt(str, i);
    }

    public static void o(String str, long j) {
        ka9 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65550, null, str, j) == null) || (a = sa9.a()) == null) {
            return;
        }
        a.putLong(str, j);
    }

    public static void p(String str, String str2) {
        ka9 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) || (a = sa9.a()) == null) {
            return;
        }
        a.putString(str, str2);
    }

    public static void q(int i) {
        ka9 a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, null, i) == null) || (a = sa9.a()) == null) {
            return;
        }
        a.a(i);
    }
}
