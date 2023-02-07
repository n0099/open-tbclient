package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d8;
import com.baidu.tieba.h7;
import com.baidu.tieba.i7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n4 implements o7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h7<m4> a;
    public final h7<x4> b;
    public final h7<v4> c;
    public final h7<Mesh> d;
    public final h7<w4> e;
    public final h7<o7> f;
    public d8<a5, i7<String, Matrix4>> g;

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
        this.a = new h7<>();
        this.b = new h7<>();
        this.c = new h7<>();
        this.d = new h7<>();
        this.e = new h7<>();
        this.f = new h7<>();
        this.g = new d8<>();
    }

    public n4(c5 c5Var, v5 v5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c5Var, v5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new h7<>();
        this.b = new h7<>();
        this.c = new h7<>();
        this.d = new h7<>();
        this.e = new h7<>();
        this.f = new h7<>();
        this.g = new d8<>();
        l(c5Var, v5Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.b.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.b.get(i2).d(true);
            }
            for (int i3 = 0; i3 < i; i3++) {
                this.b.get(i3).b(true);
            }
        }
    }

    @Override // com.baidu.tieba.o7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h7.b<o7> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public Iterable<o7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public m4 f(ModelMaterial modelMaterial, v5 v5Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, v5Var)) == null) {
            m4 m4Var = new m4();
            m4Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                m4Var.h(new p4(p4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                m4Var.h(new p4(p4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                m4Var.h(new p4(p4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                m4Var.h(new p4(p4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                m4Var.h(new p4(p4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                m4Var.h(new q4(q4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                m4Var.h(new o4(770, 771, modelMaterial.h));
            }
            d8 d8Var = new d8();
            h7<j5> h7Var = modelMaterial.i;
            if (h7Var != null) {
                h7.b<j5> it = h7Var.iterator();
                while (it.hasNext()) {
                    j5 next = it.next();
                    if (d8Var.a(next.a)) {
                        load = (Texture) d8Var.c(next.a);
                    } else {
                        load = v5Var.load(next.a);
                        d8Var.i(next.a, load);
                        this.f.a(load);
                    }
                    u5 u5Var = new u5(load);
                    u5Var.b = load.h();
                    u5Var.c = load.f();
                    u5Var.d = load.j();
                    u5Var.e = load.k();
                    Vector2 vector2 = next.b;
                    if (vector2 == null) {
                        f = 0.0f;
                    } else {
                        f = vector2.x;
                    }
                    Vector2 vector22 = next.b;
                    if (vector22 == null) {
                        f2 = 0.0f;
                    } else {
                        f2 = vector22.y;
                    }
                    Vector2 vector23 = next.c;
                    if (vector23 == null) {
                        f3 = 1.0f;
                    } else {
                        f3 = vector23.x;
                    }
                    Vector2 vector24 = next.c;
                    if (vector24 == null) {
                        f4 = 1.0f;
                    } else {
                        f4 = vector24.y;
                    }
                    int i = next.d;
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 7) {
                                        if (i != 8) {
                                            if (i == 10) {
                                                m4Var.h(new r4(r4.p, u5Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            m4Var.h(new r4(r4.l, u5Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        m4Var.h(new r4(r4.m, u5Var, f, f2, f3, f4));
                                    }
                                } else {
                                    m4Var.h(new r4(r4.k, u5Var, f, f2, f3, f4));
                                }
                            } else {
                                m4Var.h(new r4(r4.n, u5Var, f, f2, f3, f4));
                            }
                        } else {
                            m4Var.h(new r4(r4.o, u5Var, f, f2, f3, f4));
                        }
                    } else {
                        m4Var.h(new r4(r4.j, u5Var, f, f2, f3, f4));
                    }
                }
            }
            return m4Var;
        }
        return (m4) invokeLL.objValue;
    }

    public void g(d5 d5Var) {
        boolean z;
        e5[] e5VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d5Var) == null) {
            int i2 = 0;
            for (e5 e5Var : d5Var.c) {
                i2 += e5Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            a4 a4Var = new a4(d5Var.a);
            int length = d5Var.b.length / (a4Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, a4Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(d5Var.b, mesh.m(), d5Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (e5 e5Var2 : d5Var.c) {
                w4 w4Var = new w4();
                w4Var.a = e5Var2.a;
                w4Var.b = e5Var2.c;
                w4Var.c = i3;
                if (z) {
                    i = e5Var2.b.length;
                } else {
                    i = length;
                }
                w4Var.d = i;
                w4Var.e = mesh;
                if (z) {
                    mesh.j().put(e5Var2.b);
                }
                i3 += w4Var.d;
                this.e.a(w4Var);
            }
            mesh.j().position(0);
            h7.b<w4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public void q(Iterable<f5> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (f5 f5Var : iterable) {
                this.b.a(p(f5Var));
            }
            d8.a<a5, i7<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                d8.b next = b.next();
                K k = next.a;
                if (((a5) k).a == null) {
                    ((a5) k).a = new i7<>(x4.class, Matrix4.class);
                }
                ((a5) next.a).a.clear();
                i7.a a = ((i7) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    d8.b next2 = a.next();
                    ((a5) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public x4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (x4) invokeL.objValue;
    }

    public void o(Iterable<d5> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (d5 d5Var : iterable) {
                g(d5Var);
            }
        }
    }

    public x4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (x4) invokeLZ.objValue;
    }

    public void l(c5 c5Var, v5 v5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c5Var, v5Var) == null) {
            o(c5Var.b);
            n(c5Var.c, v5Var);
            q(c5Var.d);
            m(c5Var.e);
            a();
        }
    }

    public void n(Iterable<ModelMaterial> iterable, v5 v5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, v5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, v5Var));
            }
        }
    }

    public x4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return x4.f(this.b, str, z, z2);
        }
        return (x4) invokeCommon.objValue;
    }

    public void m(Iterable<b5> iterable) {
        h7<z4<Quaternion>> h7Var;
        h7<z4<Vector3>> h7Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (b5 b5Var : iterable) {
                v4 v4Var = new v4();
                String str = b5Var.a;
                h7.b<g5> it = b5Var.b.iterator();
                while (it.hasNext()) {
                    g5 next = it.next();
                    x4 i = i(next.a);
                    if (i != null) {
                        y4 y4Var = new y4();
                        if (next.b != null) {
                            h7<z4<Vector3>> h7Var3 = new h7<>();
                            y4Var.a = h7Var3;
                            h7Var3.e(next.b.b);
                            h7.b<h5<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                h5<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > v4Var.a) {
                                    v4Var.a = f;
                                }
                                h7<z4<Vector3>> h7Var4 = y4Var.a;
                                float f2 = next2.a;
                                Vector3 vector33 = next2.b;
                                if (vector33 == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = vector33;
                                }
                                h7Var4.a(new z4<>(f2, new Vector3(vector32)));
                            }
                        }
                        if (next.c != null) {
                            h7<z4<Quaternion>> h7Var5 = new h7<>();
                            y4Var.b = h7Var5;
                            h7Var5.e(next.c.b);
                            h7.b<h5<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                h5<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > v4Var.a) {
                                    v4Var.a = f3;
                                }
                                h7<z4<Quaternion>> h7Var6 = y4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion2 = next3.b;
                                if (quaternion2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = quaternion2;
                                }
                                h7Var6.a(new z4<>(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (next.d != null) {
                            h7<z4<Vector3>> h7Var7 = new h7<>();
                            y4Var.c = h7Var7;
                            h7Var7.e(next.d.b);
                            h7.b<h5<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                h5<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > v4Var.a) {
                                    v4Var.a = f5;
                                }
                                h7<z4<Vector3>> h7Var8 = y4Var.c;
                                float f6 = next4.a;
                                Vector3 vector34 = next4.b;
                                if (vector34 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = vector34;
                                }
                                h7Var8.a(new z4<>(f6, new Vector3(vector3)));
                            }
                        }
                        h7<z4<Vector3>> h7Var9 = y4Var.a;
                        if ((h7Var9 != null && h7Var9.b > 0) || (((h7Var = y4Var.b) != null && h7Var.b > 0) || ((h7Var2 = y4Var.c) != null && h7Var2.b > 0))) {
                            v4Var.b.a(y4Var);
                        }
                    }
                }
                if (v4Var.b.b > 0) {
                    this.c.a(v4Var);
                }
            }
        }
    }

    public x4 p(f5 f5Var) {
        InterceptResult invokeL;
        w4 w4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, f5Var)) == null) {
            x4 x4Var = new x4();
            x4Var.a = f5Var.a;
            Vector3 vector3 = f5Var.b;
            if (vector3 != null) {
                x4Var.d.set(vector3);
            }
            Quaternion quaternion = f5Var.c;
            if (quaternion != null) {
                x4Var.e.set(quaternion);
            }
            Vector3 vector32 = f5Var.d;
            if (vector32 != null) {
                x4Var.f.set(vector32);
            }
            i5[] i5VarArr = f5Var.e;
            if (i5VarArr != null) {
                for (i5 i5Var : i5VarArr) {
                    m4 m4Var = null;
                    if (i5Var.b != null) {
                        h7.b<w4> it = this.e.iterator();
                        while (it.hasNext()) {
                            w4Var = it.next();
                            if (i5Var.b.equals(w4Var.a)) {
                                break;
                            }
                        }
                    }
                    w4Var = null;
                    if (i5Var.a != null) {
                        h7.b<m4> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            m4 next = it2.next();
                            if (i5Var.a.equals(next.d)) {
                                m4Var = next;
                                break;
                            }
                        }
                    }
                    if (w4Var != null && m4Var != null) {
                        a5 a5Var = new a5();
                        x4Var.i.a(a5Var);
                        i7<String, Matrix4> i7Var = i5Var.c;
                        if (i7Var != null) {
                            this.g.i(a5Var, i7Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + x4Var.a);
                    }
                }
            }
            f5[] f5VarArr = f5Var.f;
            if (f5VarArr != null) {
                for (f5 f5Var2 : f5VarArr) {
                    x4Var.a(p(f5Var2));
                }
            }
            return x4Var;
        }
        return (x4) invokeL.objValue;
    }
}
