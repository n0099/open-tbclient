package com.baidu.tieba;

import android.app.Application;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ts0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, application) == null) {
            uk1.b(application);
        }
    }
}
