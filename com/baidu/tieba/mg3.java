package com.baidu.tieba;

import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mg3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947971664, "Lcom/baidu/tieba/mg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947971664, "Lcom/baidu/tieba/mg3;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a(Context context, IBinder iBinder) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, iBinder) == null) || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        try {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        } catch (Exception e) {
            if (a) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Context context, boolean z) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(z ? 2 : 0, 2);
    }
}
