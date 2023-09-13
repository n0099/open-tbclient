package com.baidu.tieba;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class q74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pi2 a;

    public q74() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            pi2 pi2Var = this.a;
            boolean z = false;
            if (pi2Var == null) {
                return false;
            }
            boolean f = r74.f(pi2Var.m());
            boolean f2 = r74.f(this.a.v());
            JSEvent jSEvent = null;
            if (f || f2) {
                jSEvent = r74.j(motionEvent);
            }
            if (f) {
                z = this.a.dispatchEvent(jSEvent);
            }
            if (f2 && this.a.t0()) {
                this.a.v().dispatchEvent(jSEvent);
            }
            r74.g(true);
            return z;
        }
        return invokeL.booleanValue;
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            r74.m(i, i2);
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            r74.l(i, i2);
        }
    }

    public void c(pi2 pi2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pi2Var) == null) {
            this.a = pi2Var;
        }
    }
}
