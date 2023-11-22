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
public class wec extends pec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mec l;
    public mec m;
    public mec n;
    public mec o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public lfc u;
    public vdc v;

    public wec(int i, vdc vdcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), vdcVar};
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
        this.v = vdcVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.pec, com.baidu.tieba.nec
    public void f(MediaSample mediaSample) {
        mec mecVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (mecVar = this.l) != null) {
            mecVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(lfc lfcVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{lfcVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = lfcVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.nec
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.pec
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            mec mecVar = this.m;
            if (mecVar != null) {
                mecVar.p();
                this.m = null;
            }
            mec mecVar2 = this.n;
            if (mecVar2 != null) {
                mecVar2.p();
                this.n = null;
            }
            mec mecVar3 = this.o;
            if (mecVar3 != null) {
                mecVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.pec
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            mec mecVar = this.m;
            if (mecVar != null) {
                mecVar.x();
            }
            mec mecVar2 = this.n;
            if (mecVar2 != null) {
                mecVar2.x();
            }
            mec mecVar3 = this.o;
            if (mecVar3 != null) {
                mecVar3.x();
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

    @Override // com.baidu.tieba.pec, com.baidu.tieba.nec
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        mec mecVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new xec(this.u, this.r, this.s, this.v, this.b);
                    rdc rdcVar = this.g.get();
                    if (rdcVar != null) {
                        this.m.s(rdcVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new yec(this.v, this.b);
                    rdc rdcVar2 = this.g.get();
                    if (rdcVar2 != null) {
                        this.o.s(rdcVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new xec(this.u, this.r, this.s, this.v, this.b);
                rdc rdcVar3 = this.g.get();
                if (rdcVar3 != null) {
                    this.m.s(rdcVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new zec(this.v, this.b);
                rdc rdcVar4 = this.g.get();
                if (rdcVar4 != null) {
                    this.n.s(rdcVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (mecVar != null && !mecVar.equals(this.l)) {
            mecVar.x();
        }
        mec mecVar2 = this.l;
        if (mecVar2 != null) {
            mecVar2.r(this.h);
            WeakReference<rdc> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.pec, com.baidu.tieba.nec
    public void d(String str, Object obj, int i, boolean z) {
        mec mecVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (mecVar = this.l) != null) {
            mecVar.d(str, obj, i, z);
        }
    }
}
