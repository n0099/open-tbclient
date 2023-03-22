package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p4 implements r6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k6<n4> a;

    public p4() {
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
        this.a = new k6<>(true, 3, n4.class);
    }

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).b();
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).update();
            }
        }
    }

    public void a(w0 w0Var, r4 r4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, w0Var, r4Var) == null) {
            k6.b<n4> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().c(w0Var, r4Var);
            }
        }
    }

    public void f(k6<s4<?>> k6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k6Var) == null) {
            k6.b<n4> it = this.a.iterator();
            while (it.hasNext()) {
                n4 next = it.next();
                k6.b<s4<?>> it2 = k6Var.iterator();
                while (it2.hasNext()) {
                    if (next.c.h(it2.next())) {
                        break;
                    }
                }
            }
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).update(f);
            }
        }
    }
}
