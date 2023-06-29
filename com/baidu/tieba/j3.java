package com.baidu.tieba;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class j3 extends h3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, t6<j3>> j;
    public transient /* synthetic */ FieldHolder $fh;
    public k3 i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306628, "Lcom/baidu/tieba/j3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306628, "Lcom/baidu/tieba/j3;");
                return;
            }
        }
        j = new HashMap();
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i.a();
        }
        return invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (u()) {
                this.b = x0.e.a();
                v(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
    }

    public static void s(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            j.remove(application);
        }
    }

    public static void t(Application application) {
        t6<j3> t6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, application) != null) || (t6Var = j.get(application)) == null) {
            return;
        }
        for (int i = 0; i < t6Var.b; i++) {
            t6Var.get(i).w();
        }
    }

    public final void v(k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k3Var) == null) {
            if (this.i != null && k3Var.a() != this.i.a()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = k3Var;
            a();
            x0.g.O(35866, 0, k3Var.b(), k3Var.getWidth(), k3Var.getHeight(), k3Var.d(), 0, k3Var.b(), k3Var.e(), null);
            if (!k3Var.isPrepared()) {
                k3Var.prepare();
            }
            k3Var.c();
            l(this.c, this.d);
            m(this.e, this.f);
            x0.e.N(this.a, 0);
        }
    }
}
