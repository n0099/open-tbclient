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
/* loaded from: classes7.dex */
public class tjb extends mjb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jjb l;
    public jjb m;
    public jjb n;
    public jjb o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public ikb u;
    public sib v;

    public tjb(int i, sib sibVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), sibVar};
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
        this.v = sibVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.mjb, com.baidu.tieba.kjb
    public void f(MediaSample mediaSample) {
        jjb jjbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (jjbVar = this.l) != null) {
            jjbVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(ikb ikbVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ikbVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = ikbVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.kjb
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.mjb
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            jjb jjbVar = this.m;
            if (jjbVar != null) {
                jjbVar.p();
                this.m = null;
            }
            jjb jjbVar2 = this.n;
            if (jjbVar2 != null) {
                jjbVar2.p();
                this.n = null;
            }
            jjb jjbVar3 = this.o;
            if (jjbVar3 != null) {
                jjbVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.mjb
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            jjb jjbVar = this.m;
            if (jjbVar != null) {
                jjbVar.x();
            }
            jjb jjbVar2 = this.n;
            if (jjbVar2 != null) {
                jjbVar2.x();
            }
            jjb jjbVar3 = this.o;
            if (jjbVar3 != null) {
                jjbVar3.x();
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

    @Override // com.baidu.tieba.mjb, com.baidu.tieba.kjb
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        jjb jjbVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new ujb(this.u, this.r, this.s, this.v, this.b);
                    oib oibVar = this.g.get();
                    if (oibVar != null) {
                        this.m.s(oibVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new vjb(this.v, this.b);
                    oib oibVar2 = this.g.get();
                    if (oibVar2 != null) {
                        this.o.s(oibVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new ujb(this.u, this.r, this.s, this.v, this.b);
                oib oibVar3 = this.g.get();
                if (oibVar3 != null) {
                    this.m.s(oibVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new wjb(this.v, this.b);
                oib oibVar4 = this.g.get();
                if (oibVar4 != null) {
                    this.n.s(oibVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (jjbVar != null && !jjbVar.equals(this.l)) {
            jjbVar.x();
        }
        jjb jjbVar2 = this.l;
        if (jjbVar2 != null) {
            jjbVar2.r(this.h);
            WeakReference<oib> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.mjb, com.baidu.tieba.kjb
    public void d(String str, Object obj, int i, boolean z) {
        jjb jjbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (jjbVar = this.l) != null) {
            jjbVar.d(str, obj, i, z);
        }
    }
}
