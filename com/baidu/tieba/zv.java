package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
/* loaded from: classes8.dex */
public final class zv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448324081, "Lcom/baidu/tieba/zv;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448324081, "Lcom/baidu/tieba/zv;");
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final jt a(Class<? extends rt<uq>> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            return new jt(cls, uq.class);
        }
        return (jt) invokeL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final kt b(Class<? extends zt<yq>> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, cls, z)) == null) {
            return new kt(cls, yq.class, z);
        }
        return (kt) invokeLZ.objValue;
    }

    @JvmStatic
    public static final jt c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a(aw.class);
        }
        return (jt) invokeV.objValue;
    }

    @JvmStatic
    public static final kt d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return b(bw.class, true);
        }
        return (kt) invokeV.objValue;
    }
}
