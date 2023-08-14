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
public class lwb extends ewb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bwb l;
    public bwb m;
    public bwb n;
    public bwb o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public axb u;
    public kvb v;

    public lwb(int i, kvb kvbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), kvbVar};
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
        this.v = kvbVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.ewb, com.baidu.tieba.cwb
    public void f(MediaSample mediaSample) {
        bwb bwbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (bwbVar = this.l) != null) {
            bwbVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(axb axbVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{axbVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = axbVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.cwb
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.ewb
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            bwb bwbVar = this.m;
            if (bwbVar != null) {
                bwbVar.p();
                this.m = null;
            }
            bwb bwbVar2 = this.n;
            if (bwbVar2 != null) {
                bwbVar2.p();
                this.n = null;
            }
            bwb bwbVar3 = this.o;
            if (bwbVar3 != null) {
                bwbVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.ewb
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            bwb bwbVar = this.m;
            if (bwbVar != null) {
                bwbVar.x();
            }
            bwb bwbVar2 = this.n;
            if (bwbVar2 != null) {
                bwbVar2.x();
            }
            bwb bwbVar3 = this.o;
            if (bwbVar3 != null) {
                bwbVar3.x();
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

    @Override // com.baidu.tieba.ewb, com.baidu.tieba.cwb
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        bwb bwbVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new mwb(this.u, this.r, this.s, this.v, this.b);
                    gvb gvbVar = this.g.get();
                    if (gvbVar != null) {
                        this.m.s(gvbVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new nwb(this.v, this.b);
                    gvb gvbVar2 = this.g.get();
                    if (gvbVar2 != null) {
                        this.o.s(gvbVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new mwb(this.u, this.r, this.s, this.v, this.b);
                gvb gvbVar3 = this.g.get();
                if (gvbVar3 != null) {
                    this.m.s(gvbVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new owb(this.v, this.b);
                gvb gvbVar4 = this.g.get();
                if (gvbVar4 != null) {
                    this.n.s(gvbVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (bwbVar != null && !bwbVar.equals(this.l)) {
            bwbVar.x();
        }
        bwb bwbVar2 = this.l;
        if (bwbVar2 != null) {
            bwbVar2.r(this.h);
            WeakReference<gvb> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.ewb, com.baidu.tieba.cwb
    public void d(String str, Object obj, int i, boolean z) {
        bwb bwbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (bwbVar = this.l) != null) {
            bwbVar.d(str, obj, i, z);
        }
    }
}
