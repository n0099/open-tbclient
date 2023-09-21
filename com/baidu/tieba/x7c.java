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
public class x7c extends q7c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n7c l;
    public n7c m;
    public n7c n;
    public n7c o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public m8c u;
    public w6c v;

    public x7c(int i, w6c w6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), w6cVar};
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
        this.v = w6cVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.q7c, com.baidu.tieba.o7c
    public void f(MediaSample mediaSample) {
        n7c n7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (n7cVar = this.l) != null) {
            n7cVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(m8c m8cVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{m8cVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = m8cVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.o7c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.q7c
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            n7c n7cVar = this.m;
            if (n7cVar != null) {
                n7cVar.p();
                this.m = null;
            }
            n7c n7cVar2 = this.n;
            if (n7cVar2 != null) {
                n7cVar2.p();
                this.n = null;
            }
            n7c n7cVar3 = this.o;
            if (n7cVar3 != null) {
                n7cVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.q7c
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            n7c n7cVar = this.m;
            if (n7cVar != null) {
                n7cVar.x();
            }
            n7c n7cVar2 = this.n;
            if (n7cVar2 != null) {
                n7cVar2.x();
            }
            n7c n7cVar3 = this.o;
            if (n7cVar3 != null) {
                n7cVar3.x();
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

    @Override // com.baidu.tieba.q7c, com.baidu.tieba.o7c
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        n7c n7cVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new y7c(this.u, this.r, this.s, this.v, this.b);
                    s6c s6cVar = this.g.get();
                    if (s6cVar != null) {
                        this.m.s(s6cVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new z7c(this.v, this.b);
                    s6c s6cVar2 = this.g.get();
                    if (s6cVar2 != null) {
                        this.o.s(s6cVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new y7c(this.u, this.r, this.s, this.v, this.b);
                s6c s6cVar3 = this.g.get();
                if (s6cVar3 != null) {
                    this.m.s(s6cVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new a8c(this.v, this.b);
                s6c s6cVar4 = this.g.get();
                if (s6cVar4 != null) {
                    this.n.s(s6cVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (n7cVar != null && !n7cVar.equals(this.l)) {
            n7cVar.x();
        }
        n7c n7cVar2 = this.l;
        if (n7cVar2 != null) {
            n7cVar2.r(this.h);
            WeakReference<s6c> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.q7c, com.baidu.tieba.o7c
    public void d(String str, Object obj, int i, boolean z) {
        n7c n7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (n7cVar = this.l) != null) {
            n7cVar.d(str, obj, i, z);
        }
    }
}
