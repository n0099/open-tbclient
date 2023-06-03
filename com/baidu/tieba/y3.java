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
import com.baidu.tieba.o7;
import com.baidu.tieba.s6;
import com.baidu.tieba.t6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class y3 implements z6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s6<x3> a;
    public final s6<i4> b;
    public final s6<g4> c;
    public final s6<Mesh> d;
    public final s6<h4> e;
    public final s6<z6> f;
    public o7<l4, t6<String, Matrix4>> g;

    public y3() {
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
        this.a = new s6<>();
        this.b = new s6<>();
        this.c = new s6<>();
        this.d = new s6<>();
        this.e = new s6<>();
        this.f = new s6<>();
        this.g = new o7<>();
    }

    public y3(n4 n4Var, g5 g5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n4Var, g5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new s6<>();
        this.b = new s6<>();
        this.c = new s6<>();
        this.d = new s6<>();
        this.e = new s6<>();
        this.f = new s6<>();
        this.g = new o7<>();
        l(n4Var, g5Var);
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

    @Override // com.baidu.tieba.z6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s6.b<z6> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public Iterable<z6> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public x3 f(ModelMaterial modelMaterial, g5 g5Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, g5Var)) == null) {
            x3 x3Var = new x3();
            x3Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                x3Var.h(new a4(a4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                x3Var.h(new a4(a4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                x3Var.h(new a4(a4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                x3Var.h(new a4(a4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                x3Var.h(new a4(a4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                x3Var.h(new b4(b4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                x3Var.h(new z3(770, 771, modelMaterial.h));
            }
            o7 o7Var = new o7();
            s6<u4> s6Var = modelMaterial.i;
            if (s6Var != null) {
                s6.b<u4> it = s6Var.iterator();
                while (it.hasNext()) {
                    u4 next = it.next();
                    if (o7Var.a(next.a)) {
                        load = (Texture) o7Var.c(next.a);
                    } else {
                        load = g5Var.load(next.a);
                        o7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    f5 f5Var = new f5(load);
                    f5Var.b = load.h();
                    f5Var.c = load.f();
                    f5Var.d = load.j();
                    f5Var.e = load.k();
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
                                                x3Var.h(new c4(c4.p, f5Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            x3Var.h(new c4(c4.l, f5Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        x3Var.h(new c4(c4.m, f5Var, f, f2, f3, f4));
                                    }
                                } else {
                                    x3Var.h(new c4(c4.k, f5Var, f, f2, f3, f4));
                                }
                            } else {
                                x3Var.h(new c4(c4.n, f5Var, f, f2, f3, f4));
                            }
                        } else {
                            x3Var.h(new c4(c4.o, f5Var, f, f2, f3, f4));
                        }
                    } else {
                        x3Var.h(new c4(c4.j, f5Var, f, f2, f3, f4));
                    }
                }
            }
            return x3Var;
        }
        return (x3) invokeLL.objValue;
    }

    public void g(o4 o4Var) {
        boolean z;
        p4[] p4VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, o4Var) == null) {
            int i2 = 0;
            for (p4 p4Var : o4Var.c) {
                i2 += p4Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            l3 l3Var = new l3(o4Var.a);
            int length = o4Var.b.length / (l3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, l3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(o4Var.b, mesh.m(), o4Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (p4 p4Var2 : o4Var.c) {
                h4 h4Var = new h4();
                h4Var.a = p4Var2.a;
                h4Var.b = p4Var2.c;
                h4Var.c = i3;
                if (z) {
                    i = p4Var2.b.length;
                } else {
                    i = length;
                }
                h4Var.d = i;
                h4Var.e = mesh;
                if (z) {
                    mesh.j().put(p4Var2.b);
                }
                i3 += h4Var.d;
                this.e.a(h4Var);
            }
            mesh.j().position(0);
            s6.b<h4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public void q(Iterable<q4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (q4 q4Var : iterable) {
                this.b.a(p(q4Var));
            }
            o7.a<l4, t6<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                o7.b next = b.next();
                K k = next.a;
                if (((l4) k).a == null) {
                    ((l4) k).a = new t6<>(i4.class, Matrix4.class);
                }
                ((l4) next.a).a.clear();
                t6.a a = ((t6) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    o7.b next2 = a.next();
                    ((l4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public i4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (i4) invokeL.objValue;
    }

    public void o(Iterable<o4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (o4 o4Var : iterable) {
                g(o4Var);
            }
        }
    }

    public i4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (i4) invokeLZ.objValue;
    }

    public void l(n4 n4Var, g5 g5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n4Var, g5Var) == null) {
            o(n4Var.b);
            n(n4Var.c, g5Var);
            q(n4Var.d);
            m(n4Var.e);
            a();
        }
    }

    public void n(Iterable<ModelMaterial> iterable, g5 g5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, g5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, g5Var));
            }
        }
    }

    public i4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return i4.f(this.b, str, z, z2);
        }
        return (i4) invokeCommon.objValue;
    }

    public void m(Iterable<m4> iterable) {
        s6<k4<Quaternion>> s6Var;
        s6<k4<Vector3>> s6Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (m4 m4Var : iterable) {
                g4 g4Var = new g4();
                String str = m4Var.a;
                s6.b<r4> it = m4Var.b.iterator();
                while (it.hasNext()) {
                    r4 next = it.next();
                    i4 i = i(next.a);
                    if (i != null) {
                        j4 j4Var = new j4();
                        if (next.b != null) {
                            s6<k4<Vector3>> s6Var3 = new s6<>();
                            j4Var.a = s6Var3;
                            s6Var3.e(next.b.b);
                            s6.b<s4<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                s4<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > g4Var.a) {
                                    g4Var.a = f;
                                }
                                s6<k4<Vector3>> s6Var4 = j4Var.a;
                                float f2 = next2.a;
                                Vector3 vector33 = next2.b;
                                if (vector33 == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = vector33;
                                }
                                s6Var4.a(new k4<>(f2, new Vector3(vector32)));
                            }
                        }
                        if (next.c != null) {
                            s6<k4<Quaternion>> s6Var5 = new s6<>();
                            j4Var.b = s6Var5;
                            s6Var5.e(next.c.b);
                            s6.b<s4<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                s4<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > g4Var.a) {
                                    g4Var.a = f3;
                                }
                                s6<k4<Quaternion>> s6Var6 = j4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion2 = next3.b;
                                if (quaternion2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = quaternion2;
                                }
                                s6Var6.a(new k4<>(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (next.d != null) {
                            s6<k4<Vector3>> s6Var7 = new s6<>();
                            j4Var.c = s6Var7;
                            s6Var7.e(next.d.b);
                            s6.b<s4<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                s4<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > g4Var.a) {
                                    g4Var.a = f5;
                                }
                                s6<k4<Vector3>> s6Var8 = j4Var.c;
                                float f6 = next4.a;
                                Vector3 vector34 = next4.b;
                                if (vector34 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = vector34;
                                }
                                s6Var8.a(new k4<>(f6, new Vector3(vector3)));
                            }
                        }
                        s6<k4<Vector3>> s6Var9 = j4Var.a;
                        if ((s6Var9 != null && s6Var9.b > 0) || (((s6Var = j4Var.b) != null && s6Var.b > 0) || ((s6Var2 = j4Var.c) != null && s6Var2.b > 0))) {
                            g4Var.b.a(j4Var);
                        }
                    }
                }
                if (g4Var.b.b > 0) {
                    this.c.a(g4Var);
                }
            }
        }
    }

    public i4 p(q4 q4Var) {
        InterceptResult invokeL;
        h4 h4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, q4Var)) == null) {
            i4 i4Var = new i4();
            i4Var.a = q4Var.a;
            Vector3 vector3 = q4Var.b;
            if (vector3 != null) {
                i4Var.d.set(vector3);
            }
            Quaternion quaternion = q4Var.c;
            if (quaternion != null) {
                i4Var.e.set(quaternion);
            }
            Vector3 vector32 = q4Var.d;
            if (vector32 != null) {
                i4Var.f.set(vector32);
            }
            t4[] t4VarArr = q4Var.e;
            if (t4VarArr != null) {
                for (t4 t4Var : t4VarArr) {
                    x3 x3Var = null;
                    if (t4Var.b != null) {
                        s6.b<h4> it = this.e.iterator();
                        while (it.hasNext()) {
                            h4Var = it.next();
                            if (t4Var.b.equals(h4Var.a)) {
                                break;
                            }
                        }
                    }
                    h4Var = null;
                    if (t4Var.a != null) {
                        s6.b<x3> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            x3 next = it2.next();
                            if (t4Var.a.equals(next.d)) {
                                x3Var = next;
                                break;
                            }
                        }
                    }
                    if (h4Var != null && x3Var != null) {
                        l4 l4Var = new l4();
                        i4Var.i.a(l4Var);
                        t6<String, Matrix4> t6Var = t4Var.c;
                        if (t6Var != null) {
                            this.g.i(l4Var, t6Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + i4Var.a);
                    }
                }
            }
            q4[] q4VarArr = q4Var.f;
            if (q4VarArr != null) {
                for (q4 q4Var2 : q4VarArr) {
                    i4Var.a(p(q4Var2));
                }
            }
            return i4Var;
        }
        return (i4) invokeL.objValue;
    }
}
