package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes8.dex */
public final class xb1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 3072;
    public static final xb1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948294498, "Lcom/baidu/tieba/xb1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948294498, "Lcom/baidu/tieba/xb1;");
                return;
            }
        }
        b = new xb1();
    }

    public xb1() {
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
    public static final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, str, str2) != null) || str == null) {
            return;
        }
        if (str2 == null) {
            if (yb1.a()) {
                Log.d("NadBrowser@DEBUG@" + str, " >>>>>>>> " + str2);
            }
        } else if (yb1.a()) {
            if (str2.length() <= a) {
                Log.d("NadBrowser@DEBUG@" + str, " >>>>>>>> " + str2);
                return;
            }
            String str3 = str2;
            while (true) {
                int length = str3.length();
                int i = a;
                if (length > i) {
                    if (str3 != null) {
                        String substring = str3.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        str3 = StringsKt__StringsJVMKt.replace$default(str3, substring, "", false, 4, (Object) null);
                        Log.d("NadBrowser@DEBUG@" + str, " >>>>>>>> " + substring);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    return;
                }
            }
        }
    }

    @JvmStatic
    public static final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && yb1.a()) {
            Log.e("NadBrowser@ERROR@" + str, "printLog: >>>>>>>> " + str2);
        }
    }

    @JvmStatic
    public static final void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) && context != null && yb1.a()) {
            Toast.makeText(context, str, 0).show();
        }
    }

    @JvmStatic
    public static final void d(Exception exception) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, exception) == null) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            if (!yb1.a()) {
                return;
            }
            throw exception;
        }
    }
}
