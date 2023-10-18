package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class u1c extends n1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k1c l;
    public k1c m;
    public k1c n;
    public k1c o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public j2c u;
    public t0c v;

    public u1c(int i, t0c t0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), t0cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = new AtomicBoolean(false);
        this.v = null;
        this.v = t0cVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.n1c, com.baidu.tieba.l1c
    public void f(MediaSample mediaSample) {
        k1c k1cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (k1cVar = this.l) != null) {
            k1cVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(j2c j2cVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{j2cVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = j2cVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.l1c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.n1c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            k1c k1cVar = this.m;
            if (k1cVar != null) {
                k1cVar.p();
                this.m = null;
            }
            k1c k1cVar2 = this.n;
            if (k1cVar2 != null) {
                k1cVar2.p();
                this.n = null;
            }
            k1c k1cVar3 = this.o;
            if (k1cVar3 != null) {
                k1cVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.n1c
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            k1c k1cVar = this.m;
            if (k1cVar != null) {
                k1cVar.x();
            }
            k1c k1cVar2 = this.n;
            if (k1cVar2 != null) {
                k1cVar2.x();
            }
            k1c k1cVar3 = this.o;
            if (k1cVar3 != null) {
                k1cVar3.x();
            }
            TLog.g(this, "VideoDecodeFilter stop");
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p = false;
            this.q = false;
        }
    }

    @Override // com.baidu.tieba.n1c, com.baidu.tieba.l1c
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        k1c k1cVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new v1c(this.u, this.r, this.s, this.v, this.b);
                    p0c p0cVar = this.g.get();
                    if (p0cVar != null) {
                        this.m.s(p0cVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new w1c(this.v, this.b);
                    p0c p0cVar2 = this.g.get();
                    if (p0cVar2 != null) {
                        this.o.s(p0cVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new v1c(this.u, this.r, this.s, this.v, this.b);
                p0c p0cVar3 = this.g.get();
                if (p0cVar3 != null) {
                    this.m.s(p0cVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new x1c(this.v, this.b);
                p0c p0cVar4 = this.g.get();
                if (p0cVar4 != null) {
                    this.n.s(p0cVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (k1cVar != null && !k1cVar.equals(this.l)) {
            k1cVar.x();
        }
        k1c k1cVar2 = this.l;
        if (k1cVar2 != null) {
            k1cVar2.r(this.h);
            WeakReference<p0c> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.n1c, com.baidu.tieba.l1c
    public void d(String str, Object obj, int i, boolean z) {
        k1c k1cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (k1cVar = this.l) != null) {
            k1cVar.d(str, obj, i, z);
        }
    }
}
