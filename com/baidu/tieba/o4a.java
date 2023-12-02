package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o4a {
    public static /* synthetic */ Interceptable $ic;
    public static final o4a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983661, "Lcom/baidu/tieba/o4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983661, "Lcom/baidu/tieba/o4a;");
                return;
            }
        }
        a = new o4a();
    }

    public o4a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean a(List<l05> list, p05 p05Var, mwa mwaVar, vv9 vv9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{list, p05Var, mwaVar, vv9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || mwaVar == null || vv9Var == null || !z || !d(vv9Var) || !TbadkCoreApplication.isLogin() || i4a.h(mwaVar) || vv9Var.a()) {
                return false;
            }
            l05 l05Var = new l05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0371), p05Var);
            list.add(l05Var);
            d5b.f(l05Var.d, mwaVar);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @JvmStatic
    public static final boolean b(SparseArray<?> sparseArray, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{sparseArray, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (sparseArray == null) {
                return z;
            }
            if (sparseArray.get(i) instanceof Boolean) {
                Object obj = sparseArray.get(i);
                if (obj != null) {
                    return ((Boolean) obj).booleanValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @JvmStatic
    public static final String c(SparseArray<?> sparseArray, int i, String def) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, sparseArray, i, def)) == null) {
            Intrinsics.checkNotNullParameter(def, "def");
            if (sparseArray == null) {
                return def;
            }
            if (sparseArray.get(i) instanceof String) {
                Object obj = sparseArray.get(i);
                if (obj != null) {
                    return (String) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return def;
        }
        return (String) invokeLIL.objValue;
    }

    @JvmStatic
    public static final boolean d(vv9 vv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, vv9Var)) == null) {
            if (vv9Var != null) {
                return vv9Var.b();
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
