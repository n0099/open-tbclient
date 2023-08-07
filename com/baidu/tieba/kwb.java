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
public class kwb extends dwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public awb l;
    public awb m;
    public awb n;
    public awb o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public zwb u;
    public jvb v;

    public kwb(int i, jvb jvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), jvbVar};
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
        this.v = jvbVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.dwb, com.baidu.tieba.bwb
    public void f(MediaSample mediaSample) {
        awb awbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (awbVar = this.l) != null) {
            awbVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(zwb zwbVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zwbVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = zwbVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.bwb
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.dwb
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            awb awbVar = this.m;
            if (awbVar != null) {
                awbVar.p();
                this.m = null;
            }
            awb awbVar2 = this.n;
            if (awbVar2 != null) {
                awbVar2.p();
                this.n = null;
            }
            awb awbVar3 = this.o;
            if (awbVar3 != null) {
                awbVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.dwb
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            awb awbVar = this.m;
            if (awbVar != null) {
                awbVar.x();
            }
            awb awbVar2 = this.n;
            if (awbVar2 != null) {
                awbVar2.x();
            }
            awb awbVar3 = this.o;
            if (awbVar3 != null) {
                awbVar3.x();
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

    @Override // com.baidu.tieba.dwb, com.baidu.tieba.bwb
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        awb awbVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new lwb(this.u, this.r, this.s, this.v, this.b);
                    fvb fvbVar = this.g.get();
                    if (fvbVar != null) {
                        this.m.s(fvbVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new mwb(this.v, this.b);
                    fvb fvbVar2 = this.g.get();
                    if (fvbVar2 != null) {
                        this.o.s(fvbVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new lwb(this.u, this.r, this.s, this.v, this.b);
                fvb fvbVar3 = this.g.get();
                if (fvbVar3 != null) {
                    this.m.s(fvbVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new nwb(this.v, this.b);
                fvb fvbVar4 = this.g.get();
                if (fvbVar4 != null) {
                    this.n.s(fvbVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (awbVar != null && !awbVar.equals(this.l)) {
            awbVar.x();
        }
        awb awbVar2 = this.l;
        if (awbVar2 != null) {
            awbVar2.r(this.h);
            WeakReference<fvb> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.dwb, com.baidu.tieba.bwb
    public void d(String str, Object obj, int i, boolean z) {
        awb awbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (awbVar = this.l) != null) {
            awbVar.d(str, obj, i, z);
        }
    }
}
