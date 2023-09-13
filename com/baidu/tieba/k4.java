package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;
    public final Vector3 d;
    public final Quaternion e;
    public final Vector3 f;
    public final Matrix4 g;
    public final Matrix4 h;
    public u6<n4> i;
    public k4 j;
    public final u6<k4> k;

    public k4() {
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
        this.b = true;
        this.d = new Vector3();
        this.e = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
        this.f = new Vector3(1.0f, 1.0f, 1.0f);
        this.g = new Matrix4();
        this.h = new Matrix4();
        this.i = new u6<>(2);
        this.k = new u6<>(2);
    }

    public static k4 f(u6<k4> u6Var, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{u6Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i = u6Var.b;
            if (z2) {
                for (int i2 = 0; i2 < i; i2++) {
                    k4 k4Var = u6Var.get(i2);
                    if (k4Var.a.equalsIgnoreCase(str)) {
                        return k4Var;
                    }
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    k4 k4Var2 = u6Var.get(i3);
                    if (k4Var2.a.equals(str)) {
                        return k4Var2;
                    }
                }
            }
            if (z) {
                for (int i4 = 0; i4 < i; i4++) {
                    k4 f = f(u6Var.get(i4).k, str, true, z2);
                    if (f != null) {
                        return f;
                    }
                }
                return null;
            }
            return null;
        }
        return (k4) invokeCommon.objValue;
    }

    public <T extends k4> int a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            return h(-1, t);
        }
        return invokeL.intValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c();
            e();
            if (z) {
                u6.b<k4> it = this.k.iterator();
                while (it.hasNext()) {
                    it.next().d(true);
                }
            }
        }
    }

    public <T extends k4> boolean i(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t)) == null) {
            if (!this.k.i(t, true)) {
                return false;
            }
            t.j = null;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(boolean z) {
        Matrix4[] matrix4Arr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            u6.b<n4> it = this.i.iterator();
            while (it.hasNext()) {
                n4 next = it.next();
                v6<k4, Matrix4> v6Var = next.a;
                if (v6Var != null && (matrix4Arr = next.b) != null && (i = v6Var.c) == matrix4Arr.length) {
                    for (int i2 = 0; i2 < i; i2++) {
                        next.b[i2].set(next.a.a[i2].h).mul(next.a.b[i2]);
                    }
                }
            }
            if (z) {
                u6.b<k4> it2 = this.k.iterator();
                while (it2.hasNext()) {
                    it2.next().b(true);
                }
            }
        }
    }

    public Matrix4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.c) {
                this.g.set(this.d, this.e, this.f);
            }
            return this.g;
        }
        return (Matrix4) invokeV.objValue;
    }

    public k4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (k4) invokeV.objValue;
    }

    public Matrix4 e() {
        InterceptResult invokeV;
        k4 k4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b && (k4Var = this.j) != null) {
                this.h.set(k4Var.h).mul(this.g);
            } else {
                this.h.set(this.g);
            }
            return this.h;
        }
        return (Matrix4) invokeV.objValue;
    }

    public <T extends k4> int h(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, t)) == null) {
            for (k4 k4Var = this; k4Var != null; k4Var = k4Var.g()) {
                if (k4Var == t) {
                    throw new GdxRuntimeException("Cannot add a parent as a child");
                }
            }
            k4 g = t.g();
            if (g != null && !g.i(t)) {
                throw new GdxRuntimeException("Could not remove child from its current parent");
            }
            if (i >= 0) {
                u6<k4> u6Var = this.k;
                if (i < u6Var.b) {
                    u6Var.insert(i, t);
                    t.j = this;
                    return i;
                }
            }
            u6<k4> u6Var2 = this.k;
            int i2 = u6Var2.b;
            u6Var2.a(t);
            i = i2;
            t.j = this;
            return i;
        }
        return invokeIL.intValue;
    }
}
