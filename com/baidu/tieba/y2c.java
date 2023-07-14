package com.baidu.tieba;

import com.baidu.tieba.u1c;
import com.baidu.tieba.x1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class y2c implements u1c.a<Long> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final TimeUnit b;
    public final x1c c;

    /* loaded from: classes8.dex */
    public class a implements h2c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a2c a;

        public a(y2c y2cVar, a2c a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y2cVar, a2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a2cVar;
        }

        @Override // com.baidu.tieba.h2c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.onNext(0L);
                    this.a.onCompleted();
                } catch (Throwable th) {
                    g2c.f(th, this.a);
                }
            }
        }
    }

    public y2c(long j, TimeUnit timeUnit, x1c x1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, x1cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = timeUnit;
        this.c = x1cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public void call(a2c<? super Long> a2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a2cVar) == null) {
            x1c.a createWorker = this.c.createWorker();
            a2cVar.b(createWorker);
            createWorker.c(new a(this, a2cVar), this.a, this.b);
        }
    }
}
