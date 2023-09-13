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
public class k3 extends i3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, u6<k3>> j;
    public transient /* synthetic */ FieldHolder $fh;
    public l3 i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307589, "Lcom/baidu/tieba/k3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307589, "Lcom/baidu/tieba/k3;");
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
                this.b = y0.e.a();
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
        u6<k3> u6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, application) != null) || (u6Var = j.get(application)) == null) {
            return;
        }
        for (int i = 0; i < u6Var.b; i++) {
            u6Var.get(i).w();
        }
    }

    public final void v(l3 l3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l3Var) == null) {
            if (this.i != null && l3Var.a() != this.i.a()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = l3Var;
            a();
            y0.g.O(35866, 0, l3Var.b(), l3Var.getWidth(), l3Var.getHeight(), l3Var.d(), 0, l3Var.b(), l3Var.e(), null);
            if (!l3Var.isPrepared()) {
                l3Var.prepare();
            }
            l3Var.c();
            l(this.c, this.d);
            m(this.e, this.f);
            y0.e.N(this.a, 0);
        }
    }
}
