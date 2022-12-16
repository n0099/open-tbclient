package com.baidu.tieba;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class n04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mb2 a;

    public n04() {
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
            mb2 mb2Var = this.a;
            boolean z = false;
            if (mb2Var == null) {
                return false;
            }
            boolean f = o04.f(mb2Var.n());
            boolean f2 = o04.f(this.a.x());
            JSEvent jSEvent = null;
            if (f || f2) {
                jSEvent = o04.j(motionEvent);
            }
            if (f) {
                z = this.a.dispatchEvent(jSEvent);
            }
            if (f2 && this.a.u0()) {
                this.a.x().dispatchEvent(jSEvent);
            }
            o04.g(true);
            return z;
        }
        return invokeL.booleanValue;
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            o04.m(i, i2);
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            o04.l(i, i2);
        }
    }

    public void c(mb2 mb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mb2Var) == null) {
            this.a = mb2Var;
        }
    }
}
