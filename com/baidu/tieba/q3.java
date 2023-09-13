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
/* loaded from: classes7.dex */
public class q3 {
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
    public final e3 s;
    public float t;
    public float u;
    public float v;
    public float w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448313355, "Lcom/baidu/tieba/q3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448313355, "Lcom/baidu/tieba/q3;");
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

    public q3(q3 q3Var, e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q3Var, e3Var};
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
        this.s = new e3(e3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        this.a = q3Var.a;
        this.b = q3Var.b;
        this.c = q3Var.c;
        this.d = q3Var.d;
        this.e = q3Var.e;
        this.f = q3Var.f;
        this.g = q3Var.g;
        this.h = q3Var.h;
        this.i = q3Var.i;
        this.j = q3Var.j;
        this.k = q3Var.k;
        this.l = q3Var.l;
        this.m = q3Var.m;
        this.n = q3Var.n;
        this.o = q3Var.o;
        this.p = q3Var.p;
        this.t = q3Var.t;
        this.v = q3Var.v;
        this.w = q3Var.w;
        this.u = q3Var.u;
        float[] fArr = new float[q3Var.q.length];
        this.q = fArr;
        float[] fArr2 = q3Var.q;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        this.r = q3Var.r;
        this.s.e(e3Var);
    }

    public q3(w3 w3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w3Var};
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
        this.s = new e3(e3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        l(new w3[]{null, null, null, null, w3Var, null, null, null, null});
    }

    public q3(w3 w3Var, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {w3Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
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
        this.s = new e3(e3.e);
        this.t = -1.0f;
        this.u = -1.0f;
        this.v = -1.0f;
        this.w = -1.0f;
        if (w3Var != null) {
            int c = (w3Var.c() - i) - i2;
            int b = (w3Var.b() - i3) - i4;
            w3[] w3VarArr = new w3[9];
            if (i3 > 0) {
                if (i > 0) {
                    w3VarArr[0] = new w3(w3Var, 0, 0, i, i3);
                }
                if (c > 0) {
                    w3VarArr[1] = new w3(w3Var, i, 0, c, i3);
                }
                if (i2 > 0) {
                    w3VarArr[2] = new w3(w3Var, i + c, 0, i2, i3);
                }
            }
            if (b > 0) {
                if (i > 0) {
                    w3VarArr[3] = new w3(w3Var, 0, i3, i, b);
                }
                if (c > 0) {
                    w3VarArr[4] = new w3(w3Var, i, i3, c, b);
                }
                if (i2 > 0) {
                    w3VarArr[5] = new w3(w3Var, i + c, i3, i2, b);
                }
            }
            if (i4 > 0) {
                if (i > 0) {
                    w3VarArr[6] = new w3(w3Var, 0, i3 + b, i, i4);
                }
                if (c > 0) {
                    w3VarArr[7] = new w3(w3Var, i, i3 + b, c, i4);
                }
                if (i2 > 0) {
                    w3VarArr[8] = new w3(w3Var, i + c, i3 + b, i2, i4);
                }
            }
            if (i == 0 && c == 0) {
                w3VarArr[1] = w3VarArr[2];
                w3VarArr[4] = w3VarArr[5];
                w3VarArr[7] = w3VarArr[8];
                w3VarArr[2] = null;
                w3VarArr[5] = null;
                w3VarArr[8] = null;
            }
            if (i3 == 0 && b == 0) {
                w3VarArr[3] = w3VarArr[6];
                w3VarArr[4] = w3VarArr[7];
                w3VarArr[5] = w3VarArr[8];
                w3VarArr[6] = null;
                w3VarArr[7] = null;
                w3VarArr[8] = null;
            }
            l(w3VarArr);
            return;
        }
        throw new IllegalArgumentException("region cannot be null.");
    }

    public final int a(w3 w3Var, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{w3Var, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Texture texture = this.a;
            if (texture == null) {
                this.a = w3Var.f();
            } else if (texture != w3Var.f()) {
                throw new IllegalArgumentException("All regions must be from the same texture.");
            }
            float f = w3Var.b;
            float f2 = w3Var.e;
            float f3 = w3Var.d;
            float f4 = w3Var.c;
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

    public final void l(w3[] w3VarArr) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, w3VarArr) == null) {
            if (w3VarArr[6] != null) {
                this.b = a(w3VarArr[6], false, false);
                this.k = w3VarArr[6].c();
                this.p = w3VarArr[6].b();
            } else {
                this.b = -1;
            }
            if (w3VarArr[7] != null) {
                w3 w3Var = w3VarArr[7];
                if (w3VarArr[6] == null && w3VarArr[8] == null) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                this.c = a(w3Var, z6, false);
                this.m = Math.max(this.m, w3VarArr[7].c());
                this.p = Math.max(this.p, w3VarArr[7].b());
            } else {
                this.c = -1;
            }
            if (w3VarArr[8] != null) {
                this.d = a(w3VarArr[8], false, false);
                this.l = Math.max(this.l, w3VarArr[8].c());
                this.p = Math.max(this.p, w3VarArr[8].b());
            } else {
                this.d = -1;
            }
            if (w3VarArr[3] != null) {
                w3 w3Var2 = w3VarArr[3];
                if (w3VarArr[0] == null && w3VarArr[6] == null) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                this.e = a(w3Var2, false, z5);
                this.k = Math.max(this.k, w3VarArr[3].c());
                this.n = Math.max(this.n, w3VarArr[3].b());
            } else {
                this.e = -1;
            }
            if (w3VarArr[4] != null) {
                w3 w3Var3 = w3VarArr[4];
                if (w3VarArr[3] == null && w3VarArr[5] == null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (w3VarArr[1] == null && w3VarArr[7] == null) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.f = a(w3Var3, z3, z4);
                this.m = Math.max(this.m, w3VarArr[4].c());
                this.n = Math.max(this.n, w3VarArr[4].b());
            } else {
                this.f = -1;
            }
            if (w3VarArr[5] != null) {
                w3 w3Var4 = w3VarArr[5];
                if (w3VarArr[2] == null && w3VarArr[8] == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.g = a(w3Var4, false, z2);
                this.l = Math.max(this.l, w3VarArr[5].c());
                this.n = Math.max(this.n, w3VarArr[5].b());
            } else {
                this.g = -1;
            }
            if (w3VarArr[0] != null) {
                this.h = a(w3VarArr[0], false, false);
                this.k = Math.max(this.k, w3VarArr[0].c());
                this.o = Math.max(this.o, w3VarArr[0].b());
            } else {
                this.h = -1;
            }
            if (w3VarArr[1] != null) {
                w3 w3Var5 = w3VarArr[1];
                if (w3VarArr[0] == null && w3VarArr[2] == null) {
                    z = false;
                } else {
                    z = true;
                }
                this.i = a(w3Var5, z, false);
                this.m = Math.max(this.m, w3VarArr[1].c());
                this.o = Math.max(this.o, w3VarArr[1].b());
            } else {
                this.i = -1;
            }
            if (w3VarArr[2] != null) {
                this.j = a(w3VarArr[2], false, false);
                this.l = Math.max(this.l, w3VarArr[2].c());
                this.o = Math.max(this.o, w3VarArr[2].b());
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
