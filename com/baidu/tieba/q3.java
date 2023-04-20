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
import com.baidu.tieba.g7;
import com.baidu.tieba.k6;
import com.baidu.tieba.l6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class q3 implements r6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k6<p3> a;
    public final k6<a4> b;
    public final k6<y3> c;
    public final k6<Mesh> d;
    public final k6<z3> e;
    public final k6<r6> f;
    public g7<d4, l6<String, Matrix4>> g;

    public q3() {
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
        this.a = new k6<>();
        this.b = new k6<>();
        this.c = new k6<>();
        this.d = new k6<>();
        this.e = new k6<>();
        this.f = new k6<>();
        this.g = new g7<>();
    }

    public q3(f4 f4Var, y4 y4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f4Var, y4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new k6<>();
        this.b = new k6<>();
        this.c = new k6<>();
        this.d = new k6<>();
        this.e = new k6<>();
        this.f = new k6<>();
        this.g = new g7<>();
        l(f4Var, y4Var);
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

    @Override // com.baidu.tieba.r6
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k6.b<r6> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
        }
    }

    public Iterable<r6> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Iterable) invokeV.objValue;
    }

    public p3 f(ModelMaterial modelMaterial, y4 y4Var) {
        InterceptResult invokeLL;
        Texture load;
        float f;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, modelMaterial, y4Var)) == null) {
            p3 p3Var = new p3();
            p3Var.d = modelMaterial.a;
            if (modelMaterial.b != null) {
                p3Var.h(new s3(s3.g, modelMaterial.b));
            }
            if (modelMaterial.c != null) {
                p3Var.h(new s3(s3.e, modelMaterial.c));
            }
            if (modelMaterial.d != null) {
                p3Var.h(new s3(s3.f, modelMaterial.d));
            }
            if (modelMaterial.e != null) {
                p3Var.h(new s3(s3.h, modelMaterial.e));
            }
            if (modelMaterial.f != null) {
                p3Var.h(new s3(s3.i, modelMaterial.f));
            }
            if (modelMaterial.g > 0.0f) {
                p3Var.h(new t3(t3.e, modelMaterial.g));
            }
            if (modelMaterial.h != 1.0f) {
                p3Var.h(new r3(770, 771, modelMaterial.h));
            }
            g7 g7Var = new g7();
            k6<m4> k6Var = modelMaterial.i;
            if (k6Var != null) {
                k6.b<m4> it = k6Var.iterator();
                while (it.hasNext()) {
                    m4 next = it.next();
                    if (g7Var.a(next.a)) {
                        load = (Texture) g7Var.c(next.a);
                    } else {
                        load = y4Var.load(next.a);
                        g7Var.i(next.a, load);
                        this.f.a(load);
                    }
                    x4 x4Var = new x4(load);
                    x4Var.b = load.h();
                    x4Var.c = load.f();
                    x4Var.d = load.j();
                    x4Var.e = load.k();
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
                                                p3Var.h(new u3(u3.p, x4Var, f, f2, f3, f4));
                                            }
                                        } else {
                                            p3Var.h(new u3(u3.l, x4Var, f, f2, f3, f4));
                                        }
                                    } else {
                                        p3Var.h(new u3(u3.m, x4Var, f, f2, f3, f4));
                                    }
                                } else {
                                    p3Var.h(new u3(u3.k, x4Var, f, f2, f3, f4));
                                }
                            } else {
                                p3Var.h(new u3(u3.n, x4Var, f, f2, f3, f4));
                            }
                        } else {
                            p3Var.h(new u3(u3.o, x4Var, f, f2, f3, f4));
                        }
                    } else {
                        p3Var.h(new u3(u3.j, x4Var, f, f2, f3, f4));
                    }
                }
            }
            return p3Var;
        }
        return (p3) invokeLL.objValue;
    }

    public void g(g4 g4Var) {
        boolean z;
        h4[] h4VarArr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, g4Var) == null) {
            int i2 = 0;
            for (h4 h4Var : g4Var.c) {
                i2 += h4Var.b.length;
            }
            if (i2 > 0) {
                z = true;
            } else {
                z = false;
            }
            d3 d3Var = new d3(g4Var.a);
            int length = g4Var.b.length / (d3Var.b / 4);
            Mesh mesh = new Mesh(true, length, i2, d3Var);
            this.d.a(mesh);
            this.f.a(mesh);
            BufferUtils.a(g4Var.b, mesh.m(), g4Var.b.length, 0);
            mesh.j().clear();
            int i3 = 0;
            for (h4 h4Var2 : g4Var.c) {
                z3 z3Var = new z3();
                z3Var.a = h4Var2.a;
                z3Var.b = h4Var2.c;
                z3Var.c = i3;
                if (z) {
                    i = h4Var2.b.length;
                } else {
                    i = length;
                }
                z3Var.d = i;
                z3Var.e = mesh;
                if (z) {
                    mesh.j().put(h4Var2.b);
                }
                i3 += z3Var.d;
                this.e.a(z3Var);
            }
            mesh.j().position(0);
            k6.b<z3> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().update();
            }
        }
    }

    public void q(Iterable<i4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iterable) == null) {
            this.g.clear();
            for (i4 i4Var : iterable) {
                this.b.a(p(i4Var));
            }
            g7.a<d4, l6<String, Matrix4>> b = this.g.b();
            b.c();
            while (b.hasNext()) {
                g7.b next = b.next();
                K k = next.a;
                if (((d4) k).a == null) {
                    ((d4) k).a = new l6<>(a4.class, Matrix4.class);
                }
                ((d4) next.a).a.clear();
                l6.a a = ((l6) next.b).a();
                a.iterator();
                while (a.hasNext()) {
                    g7.b next2 = a.next();
                    ((d4) next.a).a.e(i((String) next2.a), new Matrix4((Matrix4) next2.b).inv());
                }
            }
        }
    }

    public a4 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return j(str, true);
        }
        return (a4) invokeL.objValue;
    }

    public void o(Iterable<g4> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iterable) == null) {
            for (g4 g4Var : iterable) {
                g(g4Var);
            }
        }
    }

    public a4 j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return k(str, z, false);
        }
        return (a4) invokeLZ.objValue;
    }

    public void l(f4 f4Var, y4 y4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f4Var, y4Var) == null) {
            o(f4Var.b);
            n(f4Var.c, y4Var);
            q(f4Var.d);
            m(f4Var.e);
            a();
        }
    }

    public void n(Iterable<ModelMaterial> iterable, y4 y4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, iterable, y4Var) == null) {
            for (ModelMaterial modelMaterial : iterable) {
                this.a.a(f(modelMaterial, y4Var));
            }
        }
    }

    public a4 k(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return a4.f(this.b, str, z, z2);
        }
        return (a4) invokeCommon.objValue;
    }

    public void m(Iterable<e4> iterable) {
        k6<c4<Quaternion>> k6Var;
        k6<c4<Vector3>> k6Var2;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iterable) == null) {
            for (e4 e4Var : iterable) {
                y3 y3Var = new y3();
                String str = e4Var.a;
                k6.b<j4> it = e4Var.b.iterator();
                while (it.hasNext()) {
                    j4 next = it.next();
                    a4 i = i(next.a);
                    if (i != null) {
                        b4 b4Var = new b4();
                        if (next.b != null) {
                            k6<c4<Vector3>> k6Var3 = new k6<>();
                            b4Var.a = k6Var3;
                            k6Var3.e(next.b.b);
                            k6.b<k4<Vector3>> it2 = next.b.iterator();
                            while (it2.hasNext()) {
                                k4<Vector3> next2 = it2.next();
                                float f = next2.a;
                                if (f > y3Var.a) {
                                    y3Var.a = f;
                                }
                                k6<c4<Vector3>> k6Var4 = b4Var.a;
                                float f2 = next2.a;
                                Vector3 vector33 = next2.b;
                                if (vector33 == null) {
                                    vector32 = i.d;
                                } else {
                                    vector32 = vector33;
                                }
                                k6Var4.a(new c4<>(f2, new Vector3(vector32)));
                            }
                        }
                        if (next.c != null) {
                            k6<c4<Quaternion>> k6Var5 = new k6<>();
                            b4Var.b = k6Var5;
                            k6Var5.e(next.c.b);
                            k6.b<k4<Quaternion>> it3 = next.c.iterator();
                            while (it3.hasNext()) {
                                k4<Quaternion> next3 = it3.next();
                                float f3 = next3.a;
                                if (f3 > y3Var.a) {
                                    y3Var.a = f3;
                                }
                                k6<c4<Quaternion>> k6Var6 = b4Var.b;
                                float f4 = next3.a;
                                Quaternion quaternion2 = next3.b;
                                if (quaternion2 == null) {
                                    quaternion = i.e;
                                } else {
                                    quaternion = quaternion2;
                                }
                                k6Var6.a(new c4<>(f4, new Quaternion(quaternion)));
                            }
                        }
                        if (next.d != null) {
                            k6<c4<Vector3>> k6Var7 = new k6<>();
                            b4Var.c = k6Var7;
                            k6Var7.e(next.d.b);
                            k6.b<k4<Vector3>> it4 = next.d.iterator();
                            while (it4.hasNext()) {
                                k4<Vector3> next4 = it4.next();
                                float f5 = next4.a;
                                if (f5 > y3Var.a) {
                                    y3Var.a = f5;
                                }
                                k6<c4<Vector3>> k6Var8 = b4Var.c;
                                float f6 = next4.a;
                                Vector3 vector34 = next4.b;
                                if (vector34 == null) {
                                    vector3 = i.f;
                                } else {
                                    vector3 = vector34;
                                }
                                k6Var8.a(new c4<>(f6, new Vector3(vector3)));
                            }
                        }
                        k6<c4<Vector3>> k6Var9 = b4Var.a;
                        if ((k6Var9 != null && k6Var9.b > 0) || (((k6Var = b4Var.b) != null && k6Var.b > 0) || ((k6Var2 = b4Var.c) != null && k6Var2.b > 0))) {
                            y3Var.b.a(b4Var);
                        }
                    }
                }
                if (y3Var.b.b > 0) {
                    this.c.a(y3Var);
                }
            }
        }
    }

    public a4 p(i4 i4Var) {
        InterceptResult invokeL;
        z3 z3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, i4Var)) == null) {
            a4 a4Var = new a4();
            a4Var.a = i4Var.a;
            Vector3 vector3 = i4Var.b;
            if (vector3 != null) {
                a4Var.d.set(vector3);
            }
            Quaternion quaternion = i4Var.c;
            if (quaternion != null) {
                a4Var.e.set(quaternion);
            }
            Vector3 vector32 = i4Var.d;
            if (vector32 != null) {
                a4Var.f.set(vector32);
            }
            l4[] l4VarArr = i4Var.e;
            if (l4VarArr != null) {
                for (l4 l4Var : l4VarArr) {
                    p3 p3Var = null;
                    if (l4Var.b != null) {
                        k6.b<z3> it = this.e.iterator();
                        while (it.hasNext()) {
                            z3Var = it.next();
                            if (l4Var.b.equals(z3Var.a)) {
                                break;
                            }
                        }
                    }
                    z3Var = null;
                    if (l4Var.a != null) {
                        k6.b<p3> it2 = this.a.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            p3 next = it2.next();
                            if (l4Var.a.equals(next.d)) {
                                p3Var = next;
                                break;
                            }
                        }
                    }
                    if (z3Var != null && p3Var != null) {
                        d4 d4Var = new d4();
                        a4Var.i.a(d4Var);
                        l6<String, Matrix4> l6Var = l4Var.c;
                        if (l6Var != null) {
                            this.g.i(d4Var, l6Var);
                        }
                    } else {
                        throw new GdxRuntimeException("Invalid node: " + a4Var.a);
                    }
                }
            }
            i4[] i4VarArr = i4Var.f;
            if (i4VarArr != null) {
                for (i4 i4Var2 : i4VarArr) {
                    a4Var.a(p(i4Var2));
                }
            }
            return a4Var;
        }
        return (a4) invokeL.objValue;
    }
}
