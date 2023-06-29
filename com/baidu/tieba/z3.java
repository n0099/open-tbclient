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
import com.baidu.tieba.p7;
import com.baidu.tieba.t6;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z3 implements a7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t6<y3> a;
    public final t6<j4> b;
    public final t6<h4> c;
    public final t6<Mesh> d;
    public final t6<i4> e;
    public final t6<a7> f;
    public p7<m4, u6<String, Matrix4>> g;

    public z3() {
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
        this.a = new t6<>();
        this.b = new t6<>();
        this.c = new t6<>();
        this.d = new t6<>();
        this.e = new t6<>();
        this.f = new t6<>();
        this.g = new p7<>();
    }

    public z3(o4 o4Var, h5 h5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o4Var, h5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new t6<>();
        this.b = new t6<>();
        this.c = new t6<>();
        this.d = new t6<>();
        this.e = new t6<>();
        this.f = new t6<>();
        this.g = new p7<>();
        l(o4Var, h5Var);
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

    @Override // com.baidu.tieba.a7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            t6.b<a7> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public Iterable<a7> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public y3 f(ModelMaterial modelMaterial, h5 h5Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, h5Var)) == null) {
            y3 y3Var = new y3();
            y3Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                y3Var.h(new b4(b4.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                y3Var.h(new b4(b4.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                y3Var.h(new b4(b4.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                y3Var.h(new b4(b4.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                y3Var.h(new b4(b4.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                y3Var.h(new c4(c4.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                y3Var.h(new a4(770, 771, modelMaterial.h));
            }
            p7 p7Var = new p7();
            t6<v4> t6Var = modelMaterial.i;
            if (t6Var != null) {
                t6.b<v4> it = t6Var.iterator();
                while (it.hasNext()) {
                    v4 next = it.next();
                    if (p7Var.a(next.a)) {
                        load = (Texture) p7Var.c(next.a);
                    } else {
                        load = h5Var.load(next.a);
                        p7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    g5 g5Var = new g5(load);
                    g5Var.b = load.h();
                    g5Var.c = load.f();
                    g5Var.d = load.j();
                    g5Var.e = load.k();
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
                                                y3Var.h(new d4(d4.p, g5Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            y3Var.h(new d4(d4.l, g5Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        y3Var.h(new d4(d4.m, g5Var, f, f2, f3, f4));
                                    }
                                } else {
                                    y3Var.h(new d4(d4.k, g5Var, f, f2, f3, f4));
                                }
                            } else {
                                y3Var.h(new d4(d4.n, g5Var, f, f2, f3, f4));
                            }
                        } else {
                            y3Var.h(new d4(d4.o, g5Var, f, f2, f3, f4));
                        }
                    } else {
                        y3Var.h(new d4(d4.j, g5Var, f, f2, f3, f4));
                    }
                }
            }
            return y3Var;
        }
        return (y3) invokeLL.objValue;
    }

    public void g(p4 p4Var) {
        boolean z;
        q4[] q4VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p4Var) == null) {
            int i2 = 0;
            for (q4 q4Var : p4Var.c) {
                i2 += q4Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            m3 m3Var = new m3(p4Var.a);
            int length = p4Var.b.length / (m3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, m3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(p4Var.b, mesh.m(), p4Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (q4 q4Var2 : p4Var.c) {
                i4 i4Var = new i4();
                i4Var.a = q4Var2.a;
                i4Var.b = q4Var2.c;
                i4Var.c = i3;
                if (z) {
                    i = q4Var2.b.length;
                } else {
                    i = length;
                }
                i4Var.d = i;
                i4Var.e = mesh;
                if (z) {
                    mesh.j().put(q4Var2.b);
                }
                i3 += i4Var.d;
                this.e.a(i4Var);
            }
            mesh.j().position(0);
            t6.b<i4> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public void q(Iterable<r4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (r4 r4Var : iterable) {
                this.b.a(p(r4Var));
            }
            p7.a<m4, u6<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                p7.b next = b.next();
                K k = next.a;
                if (((m4) k).a == null) {
                    ((m4) k).a = new u6<>(j4.class, Matrix4.class);
                }
                ((m4) next.a).a.clear();
                u6.a a = ((u6) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    p7.b next2 = a.next();
                    ((m4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public j4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (j4) invokeL.objValue;
    }

    public void o(Iterable<p4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (p4 p4Var : iterable) {
                g(p4Var);
            }
        }
    }

    public j4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (j4) invokeLZ.objValue;
    }

    public void l(o4 o4Var, h5 h5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, o4Var, h5Var) == null) {
            o(o4Var.b);
            n(o4Var.c, h5Var);
            q(o4Var.d);
            m(o4Var.e);
            a();
        }
    }

    public void n(Iterable<ModelMaterial> iterable, h5 h5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, h5Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, h5Var));
            }
        }
    }

    public j4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return j4.f(this.b, str, z, z2);
        }
        return (j4) invokeCommon.objValue;
    }

    public void m(Iterable<n4> iterable) {
        t6<l4<Quaternion>> t6Var;
        t6<l4<Vector3>> t6Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (n4 n4Var : iterable) {
                h4 h4Var = new h4();
                String str = n4Var.a;
                t6.b<s4> it = n4Var.b.iterator();
                while (it.hasNext()) {
                    s4 next = it.next();
                    j4 i = i(next.a);
                    if (i != null) {
                        k4 k4Var = new k4();
                        if (next.b != null) {
                            t6<l4<Vector3>> t6Var3 = new t6<>();
                            k4Var.a = t6Var3;
                            t6Var3.e(next.b.b);
                            t6.b<t4<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                t4<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > h4Var.a) {
                                    h4Var.a = f;
                                }
                                t6<l4<Vector3>> t6Var4 = k4Var.a;
                                float f2 = next2.a;
                                Vector3 vector33 = next2.b;
                                if (vector33 == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = vector33;
                                }
                                t6Var4.a(new l4<>(f2, new Vector3(vector32)));
                            }
                        }
                        if (next.c != null) {
                            t6<l4<Quaternion>> t6Var5 = new t6<>();
                            k4Var.b = t6Var5;
                            t6Var5.e(next.c.b);
                            t6.b<t4<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                t4<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > h4Var.a) {
                                    h4Var.a = f3;
                                }
                                t6<l4<Quaternion>> t6Var6 = k4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion2 = next3.b;
                                if (quaternion2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = quaternion2;
                                }
                                t6Var6.a(new l4<>(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (next.d != null) {
                            t6<l4<Vector3>> t6Var7 = new t6<>();
                            k4Var.c = t6Var7;
                            t6Var7.e(next.d.b);
                            t6.b<t4<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                t4<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > h4Var.a) {
                                    h4Var.a = f5;
                                }
                                t6<l4<Vector3>> t6Var8 = k4Var.c;
                                float f6 = next4.a;
                                Vector3 vector34 = next4.b;
                                if (vector34 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = vector34;
                                }
                                t6Var8.a(new l4<>(f6, new Vector3(vector3)));
                            }
                        }
                        t6<l4<Vector3>> t6Var9 = k4Var.a;
                        if ((t6Var9 != null && t6Var9.b > 0) || (((t6Var = k4Var.b) != null && t6Var.b > 0) || ((t6Var2 = k4Var.c) != null && t6Var2.b > 0))) {
                            h4Var.b.a(k4Var);
                        }
                    }
                }
                if (h4Var.b.b > 0) {
                    this.c.a(h4Var);
                }
            }
        }
    }

    public j4 p(r4 r4Var) {
        InterceptResult invokeL;
        i4 i4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, r4Var)) == null) {
            j4 j4Var = new j4();
            j4Var.a = r4Var.a;
            Vector3 vector3 = r4Var.b;
            if (vector3 != null) {
                j4Var.d.set(vector3);
            }
            Quaternion quaternion = r4Var.c;
            if (quaternion != null) {
                j4Var.e.set(quaternion);
            }
            Vector3 vector32 = r4Var.d;
            if (vector32 != null) {
                j4Var.f.set(vector32);
            }
            u4[] u4VarArr = r4Var.e;
            if (u4VarArr != null) {
                for (u4 u4Var : u4VarArr) {
                    y3 y3Var = null;
                    if (u4Var.b != null) {
                        t6.b<i4> it = this.e.iterator();
                        while (it.hasNext()) {
                            i4Var = it.next();
                            if (u4Var.b.equals(i4Var.a)) {
                                break;
                            }
                        }
                    }
                    i4Var = null;
                    if (u4Var.a != null) {
                        t6.b<y3> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            y3 next = it2.next();
                            if (u4Var.a.equals(next.d)) {
                                y3Var = next;
                                break;
                            }
                        }
                    }
                    if (i4Var != null && y3Var != null) {
                        m4 m4Var = new m4();
                        j4Var.i.a(m4Var);
                        u6<String, Matrix4> u6Var = u4Var.c;
                        if (u6Var != null) {
                            this.g.i(m4Var, u6Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + j4Var.a);
                    }
                }
            }
            r4[] r4VarArr = r4Var.f;
            if (r4VarArr != null) {
                for (r4 r4Var2 : r4VarArr) {
                    j4Var.a(p(r4Var2));
                }
            }
            return j4Var;
        }
        return (j4) invokeL.objValue;
    }
}
