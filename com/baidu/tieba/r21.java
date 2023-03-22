package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class r21 implements u21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ScheduledExecutorService a;
    public ScheduledExecutorService b;

    public r21() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ScheduledThreadPoolExecutor(15);
        this.b = new ScheduledThreadPoolExecutor(1);
    }

    @Override // com.baidu.tieba.u21
    public void a(@NonNull Runnable runnable, @NonNull String str, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{runnable, str, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.baidu.tieba.u21
    public void b(@NonNull Runnable runnable, @NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{runnable, str, Long.valueOf(j)}) == null) {
            this.b.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }
}
