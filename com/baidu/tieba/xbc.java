package com.baidu.tieba;

import com.baidu.tieba.sac;
import com.baidu.tieba.vac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class xbc implements sac.a<Long> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final TimeUnit b;
    public final vac c;

    /* loaded from: classes8.dex */
    public class a implements fbc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yac a;

        public a(xbc xbcVar, yac yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xbcVar, yacVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yacVar;
        }

        @Override // com.baidu.tieba.fbc
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.onNext(0L);
                    this.a.onCompleted();
                } catch (Throwable th) {
                    ebc.f(th, this.a);
                }
            }
        }
    }

    public xbc(long j, TimeUnit timeUnit, vac vacVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, vacVar};
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
        this.c = vacVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public void call(yac<? super Long> yacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
            vac.a createWorker = this.c.createWorker();
            yacVar.b(createWorker);
            createWorker.c(new a(this, yacVar), this.a, this.b);
        }
    }
}
