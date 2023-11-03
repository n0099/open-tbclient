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
/* loaded from: classes9.dex */
public class y2 extends x2 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, h3<y2>> j;
    public transient /* synthetic */ FieldHolder $fh;
    public z2 i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448321012, "Lcom/baidu/tieba/y2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448321012, "Lcom/baidu/tieba/y2;");
                return;
            }
        }
        j = new HashMap();
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i.a();
        }
        return invokeV.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (o()) {
                this.b = o1.c.a();
                p(this.i);
                return;
            }
            throw new GdxRuntimeException("Tried to reload an unmanaged TextureArray");
        }
    }

    public static void m(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            j.remove(application);
        }
    }

    public static void n(Application application) {
        h3<y2> h3Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, application) != null) || (h3Var = j.get(application)) == null) {
            return;
        }
        for (int i = 0; i < h3Var.b; i++) {
            h3Var.get(i).q();
        }
    }

    public final void p(z2 z2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2Var) == null) {
            if (this.i != null && z2Var.a() != this.i.a()) {
                throw new GdxRuntimeException("New data must have the same managed status as the old data");
            }
            this.i = z2Var;
            b();
            o1.e.G(35866, 0, z2Var.b(), z2Var.getWidth(), z2Var.getHeight(), z2Var.d(), 0, z2Var.b(), z2Var.e(), null);
            if (!z2Var.isPrepared()) {
                z2Var.prepare();
            }
            z2Var.c();
            f(this.c, this.d);
            g(this.e, this.f);
            o1.c.F(this.a, 0);
        }
    }
}
