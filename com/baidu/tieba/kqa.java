package com.baidu.tieba;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
import java.io.ObjectInput;
/* loaded from: classes5.dex */
public class kqa {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final SharedPreferences b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947923118, "Lcom/baidu/tieba/kqa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947923118, "Lcom/baidu/tieba/kqa;");
                return;
            }
        }
        a = new Object();
        b = FunAdSdk.getAppContext().getSharedPreferences("fun_ad_sdk", 0);
    }

    public static npa b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? (npa) tpa.b(b.getString("key_adcfg", null), new gva() { // from class: com.baidu.tieba.hpa
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gva
            public final Object a(ObjectInput objectInput) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objectInput)) == null) ? kqa.c(objectInput) : invokeL.objValue;
            }
        }) : (npa) invokeV.objValue;
    }

    public static /* synthetic */ npa c(ObjectInput objectInput) {
        return new npa(objectInput.readInt(), objectInput);
    }

    public static void d(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d)}) == null) {
            b.edit().putLong("key_price_total", Double.doubleToRawLongBits(d)).apply();
        }
    }

    public static void e(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65541, null, i, i2, i3) == null) {
            synchronized (a) {
                int j = j();
                int k = k();
                int i4 = i();
                b.edit().putInt("key_rpt_req_c", ((j - i) - i2) - i3).putInt("key_rpt_fai_c", g() - i).putInt("key_rpt_suc_c", k - i2).putInt("key_rpt_mis_c", i4 - i3).apply();
            }
        }
    }

    public static void f(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, str, i) == null) {
            b.edit().putInt(str, i).apply();
        }
    }

    public static /* synthetic */ zpa h(ObjectInput objectInput) {
        return new zpa(objectInput.readInt(), objectInput);
    }

    public static zpa l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? (zpa) tpa.b(b.getString("key_rptcfg", null), new gva() { // from class: com.baidu.tieba.bpa
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.gva
            public final Object a(ObjectInput objectInput) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objectInput)) == null) ? kqa.h(objectInput) : invokeL.objValue;
            }
        }) : (zpa) invokeV.objValue;
    }

    public static double m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Double.longBitsToDouble(b.getLong("key_price_total", 0L)) : invokeV.doubleValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            synchronized (a) {
                f("key_rpt_req_c", j() + 1);
            }
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return b.getInt("key_sid_c_pre_" + str, 0);
        }
        return invokeL.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return b.getInt("key_rpt_fai_c", 0);
        }
        return invokeV.intValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return b.getInt("key_rpt_mis_c", 0);
        }
        return invokeV.intValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return b.getInt("key_rpt_req_c", 0);
        }
        return invokeV.intValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return b.getInt("key_rpt_suc_c", 0);
        }
        return invokeV.intValue;
    }
}
