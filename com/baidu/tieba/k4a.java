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
public final class k4a {
    public static /* synthetic */ Interceptable $ic;
    public static final k4a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947864497, "Lcom/baidu/tieba/k4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947864497, "Lcom/baidu/tieba/k4a;");
                return;
            }
        }
        a = new k4a();
    }

    public k4a() {
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
    public static final boolean a(List<i05> list, m05 m05Var, nwa nwaVar, rv9 rv9Var, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{list, m05Var, nwaVar, rv9Var, Boolean.valueOf(z)})) == null) {
            if (list == null || nwaVar == null || rv9Var == null || !z || !d(rv9Var) || !TbadkCoreApplication.isLogin() || e4a.h(nwaVar) || rv9Var.a()) {
                return false;
            }
            i05 i05Var = new i05(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0371), m05Var);
            list.add(i05Var);
            e5b.f(i05Var.d, nwaVar);
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
    public static final boolean d(rv9 rv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, rv9Var)) == null) {
            if (rv9Var != null) {
                return rv9Var.b();
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
