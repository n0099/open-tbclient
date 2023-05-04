package com.baidu.tieba;

import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, runnable) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, "live-feedpage-" + lb0.a().b(), 3);
        }
    }

    public static void b(Runnable runnable, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, runnable, str, i) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, str, i);
        }
    }
}
