package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Texture a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float[] q;
    public int r;
    public final y2 s;
    public float t;
    public float u;
    public float v;
    public float w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307589, "Lcom/baidu/tieba/k3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307589, "Lcom/baidu/tieba/k3;");
            }
        }
    }

    public float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p;
        }
        return invokeV.floatValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f = this.w;
            if (f == -1.0f) {
                return b();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f = this.t;
            if (f == -1.0f) {
                return c();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f = this.u;
            if (f == -1.0f) {
                return h();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.v;
            if (f == -1.0f) {
                return i();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return invokeV.floatValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.o + this.n + this.p;
        }
        return invokeV.floatValue;
    }

    public float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k + this.m + this.l;
        }
        return invokeV.floatValue;
    }

    public k3(k3 k3Var, y2 y2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k3Var, y2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new y2(y2.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        this.a = k3Var.a;
        this.b = k3Var.b;
        this.c = k3Var.c;
        this.d = k3Var.d;
        this.e = k3Var.e;
        this.f = k3Var.f;
        this.g = k3Var.g;
        this.h = k3Var.h;
        this.i = k3Var.i;
        this.j = k3Var.j;
        this.k = k3Var.k;
        this.l = k3Var.l;
        this.m = k3Var.m;
        this.n = k3Var.n;
        this.o = k3Var.o;
        this.p = k3Var.p;
        this.t = k3Var.t;
        this.v = k3Var.v;
        this.w = k3Var.w;
        this.u = k3Var.u;
        float[] fArr = new float[k3Var.q.length];
        this.q = fArr;
        float[] fArr2 = k3Var.q;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        this.r = k3Var.r;
        this.s.e(y2Var);
    }

    public k3(q3 q3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q3Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new y2(y2.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        l(new q3[]{null, null, null, null, q3Var, null, null, null, null});
    }

    public k3(q3 q3Var, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {q3Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = new float[180];
        this.s = new y2(y2.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        if (q3Var != null) {
            int c = (q3Var.c() - i) - i2;
            int b = (q3Var.b() - i3) - i4;
            q3[] q3VarArr = new q3[9];
            if (i3 > 0) {
                if (i > 0) {
                    q3VarArr[0] = new q3(q3Var, 0, 0, i, i3);
                }
                if (c > 0) {
                    q3VarArr[1] = new q3(q3Var, i, 0, c, i3);
                }
                if (i2 > 0) {
                    q3VarArr[2] = new q3(q3Var, i + c, 0, i2, i3);
                }
            }
            if (b > 0) {
                if (i > 0) {
                    q3VarArr[3] = new q3(q3Var, 0, i3, i, b);
                }
                if (c > 0) {
                    q3VarArr[4] = new q3(q3Var, i, i3, c, b);
                }
                if (i2 > 0) {
                    q3VarArr[5] = new q3(q3Var, i + c, i3, i2, b);
                }
            }
            if (i4 > 0) {
                if (i > 0) {
                    q3VarArr[6] = new q3(q3Var, 0, i3 + b, i, i4);
                }
                if (c > 0) {
                    q3VarArr[7] = new q3(q3Var, i, i3 + b, c, i4);
                }
                if (i2 > 0) {
                    q3VarArr[8] = new q3(q3Var, i + c, i3 + b, i2, i4);
                }
            }
            if (i == 0 && c == 0) {
                q3VarArr[1] = q3VarArr[2];
                q3VarArr[4] = q3VarArr[5];
                q3VarArr[7] = q3VarArr[8];
                q3VarArr[2] = null;
                q3VarArr[5] = null;
                q3VarArr[8] = null;
            }
            if (i3 == 0 && b == 0) {
                q3VarArr[3] = q3VarArr[6];
                q3VarArr[4] = q3VarArr[7];
                q3VarArr[5] = q3VarArr[8];
                q3VarArr[6] = null;
                q3VarArr[7] = null;
                q3VarArr[8] = null;
            }
            l(q3VarArr);
            return;
        }
        throw new IllegalArgumentException("region cannot be null.");
    }

    public final int a(q3 q3Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{q3Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Texture texture = this.a;
            if (texture == null) {
                this.a = q3Var.f();
            } else if (texture != q3Var.f()) {
                throw new IllegalArgumentException("All regions must be from the same texture.");
            }
            float f = q3Var.b;
            float f2 = q3Var.e;
            float f3 = q3Var.d;
            float f4 = q3Var.c;
            if (this.a.f() == Texture.TextureFilter.Linear || this.a.h() == Texture.TextureFilter.Linear) {
                if (z) {
                    float x = 0.5f / this.a.x();
                    f += x;
                    f3 -= x;
                }
                if (z2) {
                    float u = 0.5f / this.a.u();
                    f2 -= u;
                    f4 += u;
                }
            }
            float[] fArr = this.q;
            int i = this.r;
            fArr[i + 3] = f;
            fArr[i + 4] = f2;
            fArr[i + 8] = f;
            fArr[i + 9] = f4;
            fArr[i + 13] = f3;
            fArr[i + 14] = f4;
            fArr[i + 18] = f3;
            fArr[i + 19] = f2;
            this.r = i + 20;
            return i;
        }
        return invokeCommon.intValue;
    }

    public final void l(q3[] q3VarArr) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, q3VarArr) == null) {
            if (q3VarArr[6] != null) {
                this.b = a(q3VarArr[6], false, false);
                this.k = q3VarArr[6].c();
                this.p = q3VarArr[6].b();
            } else {
                this.b = -1;
            }
            if (q3VarArr[7] != null) {
                q3 q3Var = q3VarArr[7];
                if (q3VarArr[6] == null && q3VarArr[8] == null) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                this.c = a(q3Var, z6, false);
                this.m = Math.max(this.m, q3VarArr[7].c());
                this.p = Math.max(this.p, q3VarArr[7].b());
            } else {
                this.c = -1;
            }
            if (q3VarArr[8] != null) {
                this.d = a(q3VarArr[8], false, false);
                this.l = Math.max(this.l, q3VarArr[8].c());
                this.p = Math.max(this.p, q3VarArr[8].b());
            } else {
                this.d = -1;
            }
            if (q3VarArr[3] != null) {
                q3 q3Var2 = q3VarArr[3];
                if (q3VarArr[0] == null && q3VarArr[6] == null) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                this.e = a(q3Var2, false, z5);
                this.k = Math.max(this.k, q3VarArr[3].c());
                this.n = Math.max(this.n, q3VarArr[3].b());
            } else {
                this.e = -1;
            }
            if (q3VarArr[4] != null) {
                q3 q3Var3 = q3VarArr[4];
                if (q3VarArr[3] == null && q3VarArr[5] == null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (q3VarArr[1] == null && q3VarArr[7] == null) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.f = a(q3Var3, z3, z4);
                this.m = Math.max(this.m, q3VarArr[4].c());
                this.n = Math.max(this.n, q3VarArr[4].b());
            } else {
                this.f = -1;
            }
            if (q3VarArr[5] != null) {
                q3 q3Var4 = q3VarArr[5];
                if (q3VarArr[2] == null && q3VarArr[8] == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.g = a(q3Var4, false, z2);
                this.l = Math.max(this.l, q3VarArr[5].c());
                this.n = Math.max(this.n, q3VarArr[5].b());
            } else {
                this.g = -1;
            }
            if (q3VarArr[0] != null) {
                this.h = a(q3VarArr[0], false, false);
                this.k = Math.max(this.k, q3VarArr[0].c());
                this.o = Math.max(this.o, q3VarArr[0].b());
            } else {
                this.h = -1;
            }
            if (q3VarArr[1] != null) {
                q3 q3Var5 = q3VarArr[1];
                if (q3VarArr[0] == null && q3VarArr[2] == null) {
                    z = false;
                } else {
                    z = true;
                }
                this.i = a(q3Var5, z, false);
                this.m = Math.max(this.m, q3VarArr[1].c());
                this.o = Math.max(this.o, q3VarArr[1].b());
            } else {
                this.i = -1;
            }
            if (q3VarArr[2] != null) {
                this.j = a(q3VarArr[2], false, false);
                this.l = Math.max(this.l, q3VarArr[2].c());
                this.o = Math.max(this.o, q3VarArr[2].b());
            } else {
                this.j = -1;
            }
            int i = this.r;
            float[] fArr = this.q;
            if (i < fArr.length) {
                float[] fArr2 = new float[i];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                this.q = fArr2;
            }
        }
    }

    public void m(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.k *= f;
            this.l *= f;
            this.o *= f2;
            this.p *= f2;
            this.m *= f;
            this.n *= f2;
            float f3 = this.t;
            if (f3 != -1.0f) {
                this.t = f3 * f;
            }
            float f4 = this.u;
            if (f4 != -1.0f) {
                this.u = f4 * f;
            }
            float f5 = this.v;
            if (f5 != -1.0f) {
                this.v = f5 * f2;
            }
            float f6 = this.w;
            if (f6 != -1.0f) {
                this.w = f6 * f2;
            }
        }
    }

    public void n(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.t = f;
            this.u = f2;
            this.v = f3;
            this.w = f4;
        }
    }
}
