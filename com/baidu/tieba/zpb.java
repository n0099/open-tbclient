package com.baidu.tieba;

import android.content.Context;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zpb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        oqb c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && (c = uqb.c()) != null) {
            c.b();
        }
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            mqb a = uqb.a();
            if (a != null) {
                return a.getAppContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            mqb a = uqb.a();
            if (a != null) {
                return a.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static opb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return uqb.e();
        }
        return (opb) invokeV.objValue;
    }

    public static spb j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return uqb.f();
        }
        return (spb) invokeV.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            nqb b = uqb.b();
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
            mqb a = uqb.a();
            if (a != null) {
                return a.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            mqb a = uqb.a();
            if (a != null) {
                return a.c(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static IBinder e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            oqb c = uqb.c();
            if (c != null) {
                return c.a(str);
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            mqb a = uqb.a();
            if (a != null) {
                return a.e(str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            mqb a = uqb.a();
            if (a != null) {
                return a.b(z);
            }
            return "";
        }
        return (String) invokeZ.objValue;
    }

    public static void q(int i) {
        mqb a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65552, null, i) == null) && (a = uqb.a()) != null) {
            a.a(i);
        }
    }

    public static int f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i)) == null) {
            mqb a = uqb.a();
            if (a != null) {
                return a.getInt(str, i);
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static long g(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j)) == null) {
            mqb a = uqb.a();
            if (a != null) {
                return a.getLong(str, j);
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    public static void n(String str, int i) {
        mqb a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65549, null, str, i) == null) && (a = uqb.a()) != null) {
            a.putInt(str, i);
        }
    }

    public static void o(String str, long j) {
        mqb a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65550, null, str, j) == null) && (a = uqb.a()) != null) {
            a.putLong(str, j);
        }
    }

    public static void p(String str, String str2) {
        mqb a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) && (a = uqb.a()) != null) {
            a.putString(str, str2);
        }
    }
}
