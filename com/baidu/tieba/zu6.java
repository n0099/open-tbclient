package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class zu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, runnable, str, i) == null) {
            if (!((li) ServiceManager.getService(li.a)).threadABTest()) {
                new Thread(runnable).start();
            } else {
                ExecutorUtilsExt.postOnElastic(runnable, str, i);
            }
        }
    }
}
