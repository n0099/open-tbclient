package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tt9 {
    public static /* synthetic */ Interceptable $ic;
    public static final tt9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192880, "Lcom/baidu/tieba/tt9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192880, "Lcom/baidu/tieba/tt9;");
                return;
            }
        }
        a = new tt9();
    }

    public tt9() {
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
    public static final void b(String tid, String pid, boolean z, boolean z2) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tid, pid, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(pid, "pid");
            tt9 tt9Var = a;
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            if (z2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            tt9Var.a(tid, pid, 2, i, i2);
        }
    }

    @JvmStatic
    public static final void c(String tid, String pid, boolean z, boolean z2) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{tid, pid, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(pid, "pid");
            tt9 tt9Var = a;
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            if (z2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            tt9Var.a(tid, pid, 1, i, i2);
        }
    }

    @JvmStatic
    public static final void e(String tid, String pid, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, tid, pid, i) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(pid, "pid");
            a.d("c15453", tid, pid).param("obj_type", i).eventStat();
        }
    }

    @JvmStatic
    public static final void f(String tid, String pid, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, tid, pid, i) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(pid, "pid");
            a.d("c15452", tid, pid).param("obj_type", i).eventStat();
        }
    }

    public final StatisticItem d(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", str2).param("pid", str3);
            Intrinsics.checkNotNullExpressionValue(param, "StatisticItem(key)\n     …baStatic.Params.PID, pid)");
            return param;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public final void a(String str, String str2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            d("c15448", str, str2).param("obj_locate", i).param("obj_type", i2).param("obj_source", i3).eventStat();
        }
    }
}
