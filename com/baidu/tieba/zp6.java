package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class zp6 {
    public static /* synthetic */ Interceptable $ic;
    public static final View.OnClickListener a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948367689, "Lcom/baidu/tieba/zp6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948367689, "Lcom/baidu/tieba/zp6;");
                return;
            }
        }
        a = new View.OnClickListener() { // from class: com.baidu.tieba.xp6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    zp6.a(view2);
                }
            }
        };
    }

    public static final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view2) == null) {
            sr6.b().b(new rd5("recommend_fun_ad", null));
        }
    }
}
