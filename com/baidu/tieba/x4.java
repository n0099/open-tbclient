package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i7;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class x4 implements i7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d5 a;
    public u6<e5> b;
    public g5<?, ?> c;
    public float d;

    public x4() {
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
        new Matrix4();
        new Vector3(1.0f, 1.0f, 1.0f);
        this.b = new u6<>(true, 3, e5.class);
        d(0.016666668f);
    }

    @Override // com.baidu.tieba.i7.c
    public void a(i7 i7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, i7Var, jsonValue) == null) {
            String str = (String) i7Var.l("name", String.class, jsonValue);
            this.a = (d5) i7Var.l("emitter", d5.class, jsonValue);
            this.b.b((u6) i7Var.m("influencers", u6.class, e5.class, jsonValue));
            this.c = (g5) i7Var.l("renderer", g5.class, jsonValue);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.dispose();
            u6.b<e5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            update(y0.b.e());
        }
    }

    public void c(g1 g1Var, b5 b5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, g1Var, b5Var) == null) {
            this.a.f(g1Var, b5Var);
            u6.b<e5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().f(g1Var, b5Var);
            }
            this.c.f(g1Var, b5Var);
        }
    }

    public final void d(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.d = f;
        }
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            d(f);
            this.a.update();
            u6.b<e5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }
}
