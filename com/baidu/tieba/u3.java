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
import com.baidu.tieba.k7;
import com.baidu.tieba.o6;
import com.baidu.tieba.p6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u3 implements v6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o6<t3> a;
    public final o6<e4> b;
    public final o6<c4> c;
    public final o6<Mesh> d;
    public final o6<d4> e;
    public final o6<v6> f;
    public k7<h4, p6<String, Matrix4>> g;

    public u3() {
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
        this.a = new o6<>();
        this.b = new o6<>();
        this.c = new o6<>();
        this.d = new o6<>();
        this.e = new o6<>();
        this.f = new o6<>();
        this.g = new k7<>();
    }

    public u3(j4 j4Var, c5 c5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j4Var, c5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new o6<>();
        this.b = new o6<>();
        this.c = new o6<>();
        this.d = new o6<>();
        this.e = new o6<>();
        this.f = new o6<>();
        this.g = new k7<>();
        l(j4Var, c5Var);
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

    @Override // com.baidu.tieba.v6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o6.b<v6> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public Iterable<v6> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public t3 f(ModelMaterial modelMaterial, c5 c5Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, c5Var)) == null) {
            t3 t3Var = new t3();
            t3Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                t3Var.h(new w3(w3.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                t3Var.h(new w3(w3.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                t3Var.h(new w3(w3.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                t3Var.h(new w3(w3.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                t3Var.h(new w3(w3.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                t3Var.h(new x3(x3.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                t3Var.h(new v3(770, 771, modelMaterial.h));
            }
            k7 k7Var = new k7();
            o6<q4> o6Var = modelMaterial.i;
            if (o6Var != null) {
                o6.b<q4> it = o6Var.iterator();
                while (it.hasNext()) {
                    q4 next = it.next();
                    if (k7Var.a(next.a)) {
                        load = (Texture) k7Var.c(next.a);
                    } else {
                        load = c5Var.load(next.a);
                        k7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    b5 b5Var = new b5(load);
                    b5Var.b = load.h();
                    b5Var.c = load.f();
                    b5Var.d = load.j();
                    b5Var.e = load.k();
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
                                                t3Var.h(new y3(y3.p, b5Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            t3Var.h(new y3(y3.l, b5Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        t3Var.h(new y3(y3.m, b5Var, f, f2, f3, f4));
                                    }
                                } else {
                                    t3Var.h(new y3(y3.k, b5Var, f, f2, f3, f4));
                                }
                            } else {
                                t3Var.h(new y3(y3.n, b5Var, f, f2, f3, f4));
                            }
                        } else {
                            t3Var.h(new y3(y3.o, b5Var, f, f2, f3, f4));
                        }
                    } else {
                        t3Var.h(new y3(y3.j, b5Var, f, f2, f3, f4));
                    }
                }
            }
            return t3Var;
        }
        return (t3) invokeLL.objValue;
    }

    public void g(k4 k4Var) {
        boolean z;
        l4[] l4VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, k4Var) == null) {
            int i2 = 0;
            for (l4 l4Var : k4Var.c) {
                i2 += l4Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            h3 h3Var = new h3(k4Var.a);
            int length = k4Var.b.length / (h3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, h3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(k4Var.b, mesh.m(), k4Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (l4 l4Var2 : k4Var.c) {
                d4 d4Var = new d4();
                d4Var.a = l4Var2.a;
                d4Var.b = l4Var2.c;
                d4Var.c = i3;
                if (z) {
                    i = l4Var2.b.length;
                } else {
                    i = length;
                }
                d4Var.d = i;
                d4Var.e = mesh;
                if (z) {
                    mesh.j().put(l4Var2.b);
                }
                i3 += d4Var.d;
                this.e.a(d4Var);
            }
            mesh.j().position(0);
            o6.b<d4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public void q(Iterable<m4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (m4 m4Var : iterable) {
                this.b.a(p(m4Var));
            }
            k7.a<h4, p6<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                k7.b next = b.next();
                K k = next.a;
                if (((h4) k).a == null) {
                    ((h4) k).a = new p6<>(e4.class, Matrix4.class);
                }
                ((h4) next.a).a.clear();
                p6.a a = ((p6) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    k7.b next2 = a.next();
                    ((h4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public e4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (e4) invokeL.objValue;
    }

    public void o(Iterable<k4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (k4 k4Var : iterable) {
                g(k4Var);
            }
        }
    }

    public e4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (e4) invokeLZ.objValue;
    }

    public void l(j4 j4Var, c5 c5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j4Var, c5Var) == null) {
            o(j4Var.b);
            n(j4Var.c, c5Var);
            q(j4Var.d);
            m(j4Var.e);
            a();
        }
    }

    public void n(Iterable<ModelMaterial> iterable, c5 c5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, c5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, c5Var));
            }
        }
    }

    public e4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return e4.f(this.b, str, z, z2);
        }
        return (e4) invokeCommon.objValue;
    }

    public void m(Iterable<i4> iterable) {
        o6<g4<Quaternion>> o6Var;
        o6<g4<Vector3>> o6Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (i4 i4Var : iterable) {
                c4 c4Var = new c4();
                String str = i4Var.a;
                o6.b<n4> it = i4Var.b.iterator();
                while (it.hasNext()) {
                    n4 next = it.next();
                    e4 i = i(next.a);
                    if (i != null) {
                        f4 f4Var = new f4();
                        if (next.b != null) {
                            o6<g4<Vector3>> o6Var3 = new o6<>();
                            f4Var.a = o6Var3;
                            o6Var3.e(next.b.b);
                            o6.b<o4<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                o4<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > c4Var.a) {
                                    c4Var.a = f;
                                }
                                o6<g4<Vector3>> o6Var4 = f4Var.a;
                                float f2 = next2.a;
                                Vector3 vector33 = next2.b;
                                if (vector33 == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = vector33;
                                }
                                o6Var4.a(new g4<>(f2, new Vector3(vector32)));
                            }
                        }
                        if (next.c != null) {
                            o6<g4<Quaternion>> o6Var5 = new o6<>();
                            f4Var.b = o6Var5;
                            o6Var5.e(next.c.b);
                            o6.b<o4<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                o4<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > c4Var.a) {
                                    c4Var.a = f3;
                                }
                                o6<g4<Quaternion>> o6Var6 = f4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion2 = next3.b;
                                if (quaternion2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = quaternion2;
                                }
                                o6Var6.a(new g4<>(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (next.d != null) {
                            o6<g4<Vector3>> o6Var7 = new o6<>();
                            f4Var.c = o6Var7;
                            o6Var7.e(next.d.b);
                            o6.b<o4<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                o4<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > c4Var.a) {
                                    c4Var.a = f5;
                                }
                                o6<g4<Vector3>> o6Var8 = f4Var.c;
                                float f6 = next4.a;
                                Vector3 vector34 = next4.b;
                                if (vector34 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = vector34;
                                }
                                o6Var8.a(new g4<>(f6, new Vector3(vector3)));
                            }
                        }
                        o6<g4<Vector3>> o6Var9 = f4Var.a;
                        if ((o6Var9 != null && o6Var9.b > 0) || (((o6Var = f4Var.b) != null && o6Var.b > 0) || ((o6Var2 = f4Var.c) != null && o6Var2.b > 0))) {
                            c4Var.b.a(f4Var);
                        }
                    }
                }
                if (c4Var.b.b > 0) {
                    this.c.a(c4Var);
                }
            }
        }
    }

    public e4 p(m4 m4Var) {
        InterceptResult invokeL;
        d4 d4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, m4Var)) == null) {
            e4 e4Var = new e4();
            e4Var.a = m4Var.a;
            Vector3 vector3 = m4Var.b;
            if (vector3 != null) {
                e4Var.d.set(vector3);
            }
            Quaternion quaternion = m4Var.c;
            if (quaternion != null) {
                e4Var.e.set(quaternion);
            }
            Vector3 vector32 = m4Var.d;
            if (vector32 != null) {
                e4Var.f.set(vector32);
            }
            p4[] p4VarArr = m4Var.e;
            if (p4VarArr != null) {
                for (p4 p4Var : p4VarArr) {
                    t3 t3Var = null;
                    if (p4Var.b != null) {
                        o6.b<d4> it = this.e.iterator();
                        while (it.hasNext()) {
                            d4Var = it.next();
                            if (p4Var.b.equals(d4Var.a)) {
                                break;
                            }
                        }
                    }
                    d4Var = null;
                    if (p4Var.a != null) {
                        o6.b<t3> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            t3 next = it2.next();
                            if (p4Var.a.equals(next.d)) {
                                t3Var = next;
                                break;
                            }
                        }
                    }
                    if (d4Var != null && t3Var != null) {
                        h4 h4Var = new h4();
                        e4Var.i.a(h4Var);
                        p6<String, Matrix4> p6Var = p4Var.c;
                        if (p6Var != null) {
                            this.g.i(h4Var, p6Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + e4Var.a);
                    }
                }
            }
            m4[] m4VarArr = m4Var.f;
            if (m4VarArr != null) {
                for (m4 m4Var2 : m4VarArr) {
                    e4Var.a(p(m4Var2));
                }
            }
            return e4Var;
        }
        return (e4) invokeL.objValue;
    }
}
