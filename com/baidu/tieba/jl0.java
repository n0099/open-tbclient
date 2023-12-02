package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes6.dex */
public final class jl0 {
    public static /* synthetic */ Interceptable $ic;
    public static final jl0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947887003, "Lcom/baidu/tieba/jl0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947887003, "Lcom/baidu/tieba/jl0;");
                return;
            }
        }
        a = new jl0();
    }

    public jl0() {
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

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ij0.b().a().a("reward_form_switch", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ void e(jl0 jl0Var, Context context, in0 in0Var, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        jl0Var.d(context, in0Var, str);
    }

    public final boolean a(in0 in0Var) {
        InterceptResult invokeL;
        tm0 tm0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, in0Var)) == null) {
            xm0 xm0Var = in0Var.m;
            if (xm0Var != null && (tm0Var = xm0Var.p) != null && tm0Var.e) {
                if (xm0Var != null && tm0Var != null) {
                    str = tm0Var.a;
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z || !ef0.o(str)) {
                return false;
            }
            return Intrinsics.areEqual(new ve0(str).a(), "rewardWebPanel");
        }
        return invokeL.booleanValue;
    }

    public final String c(String str, in0 adModel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, adModel)) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            String str2 = (str == null || (r13 = StringsKt__StringsJVMKt.replace$default(str, "__PANEL_CMD__", adModel.g(), false, 4, (Object) null)) == null) ? "" : "";
            String str3 = adModel.f.c;
            Intrinsics.checkNotNullExpressionValue(str3, "adModel.common.scheme");
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str2, "__CONVERT_CMD__", str3, false, 4, (Object) null), "__WEBPANEL_CMD__", adModel.o(), false, 4, (Object) null);
        }
        return (String) invokeLL.objValue;
    }

    public final void d(Context context, in0 adModel, String str) {
        boolean z;
        String str2;
        String str3;
        tm0 tm0Var;
        tm0 tm0Var2;
        tm0 tm0Var3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, adModel, str) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            if (context == null) {
                return;
            }
            boolean z2 = false;
            if (adModel.q() && a(adModel)) {
                xm0 xm0Var = adModel.m;
                String str4 = null;
                if (xm0Var != null && (tm0Var3 = xm0Var.p) != null) {
                    str2 = tm0Var3.a;
                } else {
                    str2 = null;
                }
                if (l11.f(str2)) {
                    xm0 xm0Var2 = adModel.m;
                    if (xm0Var2 != null && (tm0Var2 = xm0Var2.p) != null) {
                        str3 = tm0Var2.b;
                    } else {
                        str3 = null;
                    }
                    if (!((str3 == null || str3.length() == 0) ? true : true)) {
                        qe0.b(str3);
                        return;
                    }
                    xm0 xm0Var3 = adModel.m;
                    if (xm0Var3 != null && (tm0Var = xm0Var3.p) != null) {
                        str4 = tm0Var.a;
                    }
                    Intrinsics.checkNotNull(str4);
                    df0.b(context, str4);
                    return;
                }
            }
            if (str != null) {
                if (str.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    qe0.c(str, context);
                    return;
                }
            }
            String g = adModel.g();
            if (g.length() == 0) {
                z2 = true;
            }
            if (z2) {
                g = adModel.f.c;
                Intrinsics.checkNotNullExpressionValue(g, "adModel.common.scheme");
            }
            qe0.c(g, context);
        }
    }
}
