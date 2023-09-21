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
public final class up0 {
    public static /* synthetic */ Interceptable $ic;
    public static final up0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218548, "Lcom/baidu/tieba/up0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218548, "Lcom/baidu/tieba/up0;");
                return;
            }
        }
        a = new up0();
    }

    public up0() {
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

    public static /* synthetic */ void e(up0 up0Var, Context context, sr0 sr0Var, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        up0Var.d(context, sr0Var, str);
    }

    public final boolean a(sr0 sr0Var) {
        InterceptResult invokeL;
        er0 er0Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sr0Var)) == null) {
            ir0 ir0Var = sr0Var.m;
            if (ir0Var != null && (er0Var = ir0Var.p) != null && er0Var.e) {
                if (ir0Var != null && er0Var != null) {
                    str = er0Var.a;
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
            if (z || !pj0.o(str)) {
                return false;
            }
            return Intrinsics.areEqual(new gj0(str).a(), "rewardWebPanel");
        }
        return invokeL.booleanValue;
    }

    public final String c(String str, sr0 adModel) {
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

    public final void d(Context context, sr0 adModel, String str) {
        boolean z;
        String str2;
        String str3;
        er0 er0Var;
        er0 er0Var2;
        er0 er0Var3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, adModel, str) == null) {
            Intrinsics.checkNotNullParameter(adModel, "adModel");
            if (context == null) {
                return;
            }
            boolean z2 = false;
            if (adModel.p() && a(adModel)) {
                ir0 ir0Var = adModel.m;
                String str4 = null;
                if (ir0Var != null && (er0Var3 = ir0Var.p) != null) {
                    str2 = er0Var3.a;
                } else {
                    str2 = null;
                }
                if (e61.f(str2)) {
                    ir0 ir0Var2 = adModel.m;
                    if (ir0Var2 != null && (er0Var2 = ir0Var2.p) != null) {
                        str3 = er0Var2.b;
                    } else {
                        str3 = null;
                    }
                    if (!((str3 == null || str3.length() == 0) ? true : true)) {
                        bj0.b(str3);
                        return;
                    }
                    ir0 ir0Var3 = adModel.m;
                    if (ir0Var3 != null && (er0Var = ir0Var3.p) != null) {
                        str4 = er0Var.a;
                    }
                    Intrinsics.checkNotNull(str4);
                    oj0.b(context, str4);
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
                    bj0.c(str, context);
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
            bj0.c(f, context);
        }
    }
}
