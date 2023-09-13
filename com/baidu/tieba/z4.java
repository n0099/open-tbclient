package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class z4 implements b7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u6<x4> a;

    public z4() {
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
        this.a = new u6<>(true, 3, x4.class);
    }

    @Override // com.baidu.tieba.b7
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

    public void a(g1 g1Var, b5 b5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, g1Var, b5Var) == null) {
            u6.b<x4> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().c(g1Var, b5Var);
            }
        }
    }

    public void f(u6<c5<?>> u6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u6Var) == null) {
            u6.b<x4> it = this.a.iterator();
            while (it.hasNext()) {
                x4 next = it.next();
                u6.b<c5<?>> it2 = u6Var.iterator();
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
