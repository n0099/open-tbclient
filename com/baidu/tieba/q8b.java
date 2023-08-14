package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u8b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import java.io.File;
/* loaded from: classes7.dex */
public class q8b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public u8b g;
    public u8b.f h;
    public u8b.b i;
    public u8b.e j;
    public a9b k;
    public String l;
    public int m;
    public SurfaceTexture n;
    public int o;
    public int p;
    public b9b q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;

    public q8b() {
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
        this.a = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.c = RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
        this.d = 1;
        this.e = 1.0f;
        this.f = 0.0f;
        this.p = -100;
        this.s = false;
        this.t = 10000;
        this.u = 30;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            u8b u8bVar = this.g;
            if (u8bVar != null) {
                u8bVar.c();
                this.g.l(null);
            }
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public void b(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            this.f = f;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.o = i;
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || i <= 0 || i2 <= 0) {
            return;
        }
        if (this.o <= 0) {
            this.o = RecordConstants.VIDEO_CONSTANT_WIDTH;
        }
        this.a = i;
        this.b = i2;
        if (i2 > i) {
            int i3 = this.o;
            i2 = ((i2 * i3) / i) - (((i3 * i2) / i) % 16);
            i = i3;
        } else if (i2 < i) {
            int i4 = this.o;
            i = ((i * i4) / i2) - (((i4 * i) / i2) % 16);
            i2 = i4;
        }
        this.a = i;
        this.b = i2;
    }

    public void e(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceTexture) == null) {
            this.n = surfaceTexture;
        }
    }

    public void f(u8b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void g(u8b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void h(a9b a9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, a9bVar) == null) {
            this.k = a9bVar;
        }
    }

    public void i(b9b b9bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b9bVar) == null) {
            this.q = b9bVar;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.l = str;
            try {
                u8b u8bVar = new u8b();
                this.g = u8bVar;
                u8bVar.d(this.e);
                this.g.B(this.p);
                if (this.f != 0.0f) {
                    this.g.A(this.f);
                }
                this.g.l(this.h);
                this.g.i(this.i);
                this.g.k(this.j);
                this.g.r(this.q);
                this.g.E(this.r);
                this.g.I(this.s);
                this.g.s(this.v);
            } catch (Throwable th) {
                j9b.c("VideoRecorder", th.toString());
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.v = z;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.c = i;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.r = z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.m++;
            try {
                if (this.g != null && this.g.u(2)) {
                    File file = new File(this.l);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (this.f == 90.0f || this.f == 270.0f) {
                        int i = this.a;
                        this.a = this.b;
                        this.b = i;
                    }
                    this.g.j(new u8b.d(file, this.a, this.b, this.c, this.u, null, this.n.getTimestamp(), this.t));
                }
                if (this.g == null || this.m % this.d != 0 || this.k == null) {
                    return;
                }
                this.k.a(this.g, this.n);
            } catch (Throwable th) {
                j9b.c("VideoRecorder", th.toString());
            }
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.u = i;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.s = z;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.t = i;
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            u8b u8bVar = this.g;
            if (u8bVar != null) {
                return u8bVar.u(1);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.p = i;
        }
    }

    public void t(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
            this.e = f;
            if (Math.abs(f - 3.0f) < 0.01f) {
                this.d = 2;
                return;
            }
            int i = (Math.abs(this.e - 2.0f) > 0.01f ? 1 : (Math.abs(this.e - 2.0f) == 0.01f ? 0 : -1));
            this.d = 1;
        }
    }
}
