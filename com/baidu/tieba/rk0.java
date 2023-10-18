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
/* loaded from: classes7.dex */
public final class rk0 {
    public static /* synthetic */ Interceptable $ic;
    public static final rk0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948124370, "Lcom/baidu/tieba/rk0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948124370, "Lcom/baidu/tieba/rk0;");
                return;
            }
        }
        a = new rk0();
    }

    public rk0() {
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

    public static /* synthetic */ void e(rk0 rk0Var, Context context, pm0 pm0Var, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        rk0Var.d(context, pm0Var, str);
    }

    public final boolean a(pm0 pm0Var) {
        InterceptResult invokeL;
        bm0 bm0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pm0Var)) == null) {
            fm0 fm0Var = pm0Var.m;
            if (fm0Var != null && (bm0Var = fm0Var.p) != null && bm0Var.e) {
                if (fm0Var != null && bm0Var != null) {
                    str = bm0Var.a;
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
            if (z || !me0.o(str)) {
                return false;
            }
            return Intrinsics.areEqual(new de0(str).a(), "rewardWebPanel");
        }
        return invokeL.booleanValue;
    }

    public final String c(String str, pm0 adModel) {
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

    public final void d(Context context, pm0 adModel, String str) {
        boolean z;
        String str2;
        String str3;
        bm0 bm0Var;
        bm0 bm0Var2;
        bm0 bm0Var3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, adModel, str) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            if (context == null) {
                return;
            }
            boolean z2 = false;
            if (adModel.p() && a(adModel)) {
                fm0 fm0Var = adModel.m;
                String str4 = null;
                if (fm0Var != null && (bm0Var3 = fm0Var.p) != null) {
                    str2 = bm0Var3.a;
                } else {
                    str2 = null;
                }
                if (r01.f(str2)) {
                    fm0 fm0Var2 = adModel.m;
                    if (fm0Var2 != null && (bm0Var2 = fm0Var2.p) != null) {
                        str3 = bm0Var2.b;
                    } else {
                        str3 = null;
                    }
                    if (!((str3 == null || str3.length() == 0) ? true : true)) {
                        yd0.b(str3);
                        return;
                    }
                    fm0 fm0Var3 = adModel.m;
                    if (fm0Var3 != null && (bm0Var = fm0Var3.p) != null) {
                        str4 = bm0Var.a;
                    }
                    Intrinsics.checkNotNull(str4);
                    le0.b(context, str4);
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
                    yd0.c(str, context);
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
            yd0.c(f, context);
        }
    }
}
