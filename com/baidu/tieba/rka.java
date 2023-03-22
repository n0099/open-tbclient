package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* JADX WARN: Incorrect class signature, class is equals to this class: <TResult:Ljava/lang/Object;>Ljava/lang/Object;Lcom/baidu/tieba/rka;Lcom/baidu/tieba/dla;Lcom/baidu/tieba/ela<TTResult;>; */
/* loaded from: classes6.dex */
public class rka<TResult> implements dla, dla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CountDownLatch a;

    public rka() {
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
        this.a = new CountDownLatch(1);
    }
}
