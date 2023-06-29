package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h7;
import com.baidu.tieba.t6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w4 implements h7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c5 a;
    public t6<d5> b;
    public f5<?, ?> c;
    public float d;

    public w4() {
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
        this.b = new t6<>(true, 3, d5.class);
        d(0.016666668f);
    }

    @Override // com.baidu.tieba.h7.c
    public void a(h7 h7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, h7Var, jsonValue) == null) {
            String str = (String) h7Var.l("name", String.class, jsonValue);
            this.a = (c5) h7Var.l("emitter", c5.class, jsonValue);
            this.b.b((t6) h7Var.m("influencers", t6.class, d5.class, jsonValue));
            this.c = (f5) h7Var.l("renderer", f5.class, jsonValue);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.dispose();
            t6.b<d5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            update(x0.b.e());
        }
    }

    public void c(f1 f1Var, a5 a5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, f1Var, a5Var) == null) {
            this.a.f(f1Var, a5Var);
            t6.b<d5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().f(f1Var, a5Var);
            }
            this.c.f(f1Var, a5Var);
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
            t6.b<d5> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }
}
