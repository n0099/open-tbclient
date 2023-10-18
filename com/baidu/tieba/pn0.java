package com.baidu.tieba;

import android.app.Application;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, application) == null) {
            df1.b(application);
        }
    }
}
