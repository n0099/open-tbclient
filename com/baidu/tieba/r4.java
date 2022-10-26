package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class r4 {
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
    public b7 i;
    public r4 j;
    public final b7 k;

    public r4() {
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
        this.i = new b7(2);
        this.k = new b7(2);
    }

    public static r4 f(b7 b7Var, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{b7Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i = b7Var.b;
            if (z2) {
                for (int i2 = 0; i2 < i; i2++) {
                    r4 r4Var = (r4) b7Var.get(i2);
                    if (r4Var.a.equalsIgnoreCase(str)) {
                        return r4Var;
                    }
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    r4 r4Var2 = (r4) b7Var.get(i3);
                    if (r4Var2.a.equals(str)) {
                        return r4Var2;
                    }
                }
            }
            if (z) {
                for (int i4 = 0; i4 < i; i4++) {
                    r4 f = f(((r4) b7Var.get(i4)).k, str, true, z2);
                    if (f != null) {
                        return f;
                    }
                }
                return null;
            }
            return null;
        }
        return (r4) invokeCommon.objValue;
    }

    public int a(r4 r4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r4Var)) == null) {
            return h(-1, r4Var);
        }
        return invokeL.intValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            c();
            e();
            if (z) {
                b7.b it = this.k.iterator();
                while (it.hasNext()) {
                    ((r4) it.next()).d(true);
                }
            }
        }
    }

    public boolean i(r4 r4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, r4Var)) == null) {
            if (!this.k.j(r4Var, true)) {
                return false;
            }
            r4Var.j = null;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(boolean z) {
        Matrix4[] matrix4Arr;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            b7.b it = this.i.iterator();
            while (it.hasNext()) {
                u4 u4Var = (u4) it.next();
                c7 c7Var = u4Var.a;
                if (c7Var != null && (matrix4Arr = u4Var.b) != null && (i = c7Var.c) == matrix4Arr.length) {
                    for (int i2 = 0; i2 < i; i2++) {
                        u4Var.b[i2].set(((r4[]) u4Var.a.a)[i2].h).mul(((Matrix4[]) u4Var.a.b)[i2]);
                    }
                }
            }
            if (z) {
                b7.b it2 = this.k.iterator();
                while (it2.hasNext()) {
                    ((r4) it2.next()).b(true);
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

    public r4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (r4) invokeV.objValue;
    }

    public Matrix4 e() {
        InterceptResult invokeV;
        r4 r4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.b && (r4Var = this.j) != null) {
                this.h.set(r4Var.h).mul(this.g);
            } else {
                this.h.set(this.g);
            }
            return this.h;
        }
        return (Matrix4) invokeV.objValue;
    }

    public int h(int i, r4 r4Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, r4Var)) == null) {
            for (r4 r4Var2 = this; r4Var2 != null; r4Var2 = r4Var2.g()) {
                if (r4Var2 == r4Var) {
                    throw new GdxRuntimeException("Cannot add a parent as a child");
                }
            }
            r4 g = r4Var.g();
            if (g != null && !g.i(r4Var)) {
                throw new GdxRuntimeException("Could not remove child from its current parent");
            }
            if (i >= 0) {
                b7 b7Var = this.k;
                if (i < b7Var.b) {
                    b7Var.insert(i, r4Var);
                    r4Var.j = this;
                    return i;
                }
            }
            b7 b7Var2 = this.k;
            int i2 = b7Var2.b;
            b7Var2.a(r4Var);
            i = i2;
            r4Var.j = this;
            return i;
        }
        return invokeIL.intValue;
    }
}
