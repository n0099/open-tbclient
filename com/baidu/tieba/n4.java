package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k6;
import com.baidu.tieba.y6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n4 implements y6.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t4 a;
    public k6<u4> b;
    public w4<?, ?> c;
    public float d;

    public n4() {
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
        this.b = new k6<>(true, 3, u4.class);
        d(0.016666668f);
    }

    @Override // com.baidu.tieba.y6.c
    public void a(y6 y6Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, y6Var, jsonValue) == null) {
            String str = (String) y6Var.l("name", String.class, jsonValue);
            this.a = (t4) y6Var.l("emitter", t4.class, jsonValue);
            this.b.b((k6) y6Var.m("influencers", k6.class, u4.class, jsonValue));
            this.c = (w4) y6Var.l("renderer", w4.class, jsonValue);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.dispose();
            k6.b<u4> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            update(o0.b.e());
        }
    }

    public void c(w0 w0Var, r4 r4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, w0Var, r4Var) == null) {
            this.a.f(w0Var, r4Var);
            k6.b<u4> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().f(w0Var, r4Var);
            }
            this.c.f(w0Var, r4Var);
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
            k6.b<u4> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }
}
