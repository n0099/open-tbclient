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
/* loaded from: classes6.dex */
public class kob extends dob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aob l;
    public aob m;
    public aob n;
    public aob o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public zob u;
    public jnb v;

    public kob(int i, jnb jnbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), jnbVar};
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
        this.v = jnbVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.dob, com.baidu.tieba.bob
    public void f(MediaSample mediaSample) {
        aob aobVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (aobVar = this.l) != null) {
            aobVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(zob zobVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zobVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = zobVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.bob
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.dob
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            aob aobVar = this.m;
            if (aobVar != null) {
                aobVar.p();
                this.m = null;
            }
            aob aobVar2 = this.n;
            if (aobVar2 != null) {
                aobVar2.p();
                this.n = null;
            }
            aob aobVar3 = this.o;
            if (aobVar3 != null) {
                aobVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.dob
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            aob aobVar = this.m;
            if (aobVar != null) {
                aobVar.x();
            }
            aob aobVar2 = this.n;
            if (aobVar2 != null) {
                aobVar2.x();
            }
            aob aobVar3 = this.o;
            if (aobVar3 != null) {
                aobVar3.x();
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

    @Override // com.baidu.tieba.dob, com.baidu.tieba.bob
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        aob aobVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new lob(this.u, this.r, this.s, this.v, this.b);
                    fnb fnbVar = this.g.get();
                    if (fnbVar != null) {
                        this.m.s(fnbVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new mob(this.v, this.b);
                    fnb fnbVar2 = this.g.get();
                    if (fnbVar2 != null) {
                        this.o.s(fnbVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new lob(this.u, this.r, this.s, this.v, this.b);
                fnb fnbVar3 = this.g.get();
                if (fnbVar3 != null) {
                    this.m.s(fnbVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new nob(this.v, this.b);
                fnb fnbVar4 = this.g.get();
                if (fnbVar4 != null) {
                    this.n.s(fnbVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (aobVar != null && !aobVar.equals(this.l)) {
            aobVar.x();
        }
        aob aobVar2 = this.l;
        if (aobVar2 != null) {
            aobVar2.r(this.h);
            WeakReference<fnb> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.dob, com.baidu.tieba.bob
    public void d(String str, Object obj, int i, boolean z) {
        aob aobVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (aobVar = this.l) != null) {
            aobVar.d(str, obj, i, z);
        }
    }
}
