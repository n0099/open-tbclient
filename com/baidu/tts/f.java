package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.k;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes9.dex */
public class f implements Callable<k.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q1 a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ g c;

    public f(g gVar, q1 q1Var, CountDownLatch countDownLatch) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, q1Var, countDownLatch};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = gVar;
        this.a = q1Var;
        this.b = countDownLatch;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.baidu.tts.k$a, java.lang.Object] */
    @Override // java.util.concurrent.Callable
    public k.a call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.c.a(this.a.b);
            } finally {
                this.b.countDown();
            }
        }
        return invokeV.objValue;
    }
}
