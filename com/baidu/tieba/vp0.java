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
/* loaded from: classes8.dex */
public final class vp0 {
    public static /* synthetic */ Interceptable $ic;
    public static final vp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248339, "Lcom/baidu/tieba/vp0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248339, "Lcom/baidu/tieba/vp0;");
                return;
            }
        }
        a = new vp0();
    }

    public vp0() {
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

    public static /* synthetic */ void e(vp0 vp0Var, Context context, tr0 tr0Var, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        vp0Var.d(context, tr0Var, str);
    }

    public final boolean a(tr0 tr0Var) {
        InterceptResult invokeL;
        fr0 fr0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tr0Var)) == null) {
            jr0 jr0Var = tr0Var.m;
            if (jr0Var != null && (fr0Var = jr0Var.p) != null && fr0Var.e) {
                if (jr0Var != null && fr0Var != null) {
                    str = fr0Var.a;
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
            if (z || !qj0.o(str)) {
                return false;
            }
            return Intrinsics.areEqual(new hj0(str).a(), "rewardWebPanel");
        }
        return invokeL.booleanValue;
    }

    public final String c(String str, tr0 adModel) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, adModel)) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            String str2 = (str == null || (r13 = StringsKt__StringsJVMKt.replace$default(str, "__PANEL_CMD__", adModel.f(), false, 4, (Object) null)) == null) ? "" : "";
            String str3 = adModel.f.c;
            Intrinsics.checkNotNullExpressionValue(str3, "adModel.common.scheme");
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str2, "__CONVERT_CMD__", str3, false, 4, (Object) null), "__WEB_PANEL_CMD__", adModel.n(), false, 4, (Object) null);
        }
        return (String) invokeLL.objValue;
    }

    public final void d(Context context, tr0 adModel, String str) {
        boolean z;
        String str2;
        String str3;
        fr0 fr0Var;
        fr0 fr0Var2;
        fr0 fr0Var3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, adModel, str) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            if (context == null) {
                return;
            }
            boolean z2 = false;
            if (adModel.p() && a(adModel)) {
                jr0 jr0Var = adModel.m;
                String str4 = null;
                if (jr0Var != null && (fr0Var3 = jr0Var.p) != null) {
                    str2 = fr0Var3.a;
                } else {
                    str2 = null;
                }
                if (f61.f(str2)) {
                    jr0 jr0Var2 = adModel.m;
                    if (jr0Var2 != null && (fr0Var2 = jr0Var2.p) != null) {
                        str3 = fr0Var2.b;
                    } else {
                        str3 = null;
                    }
                    if (!((str3 == null || str3.length() == 0) ? true : true)) {
                        cj0.b(str3);
                        return;
                    }
                    jr0 jr0Var3 = adModel.m;
                    if (jr0Var3 != null && (fr0Var = jr0Var3.p) != null) {
                        str4 = fr0Var.a;
                    }
                    Intrinsics.checkNotNull(str4);
                    pj0.b(context, str4);
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
                    cj0.c(str, context);
                    return;
                }
            }
            String f = adModel.f();
            if (f.length() == 0) {
                z2 = true;
            }
            if (z2) {
                f = adModel.f.c;
                Intrinsics.checkNotNullExpressionValue(f, "adModel.common.scheme");
            }
            cj0.c(f, context);
        }
    }
}
