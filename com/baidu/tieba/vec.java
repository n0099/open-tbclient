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
public class vec extends oec {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lec l;
    public lec m;
    public lec n;
    public lec o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public kfc u;
    public udc v;

    public vec(int i, udc udcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), udcVar};
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
        this.v = udcVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.oec, com.baidu.tieba.mec
    public void f(MediaSample mediaSample) {
        lec lecVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (lecVar = this.l) != null) {
            lecVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(kfc kfcVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{kfcVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = kfcVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.mec
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.oec
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            lec lecVar = this.m;
            if (lecVar != null) {
                lecVar.p();
                this.m = null;
            }
            lec lecVar2 = this.n;
            if (lecVar2 != null) {
                lecVar2.p();
                this.n = null;
            }
            lec lecVar3 = this.o;
            if (lecVar3 != null) {
                lecVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.oec
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            lec lecVar = this.m;
            if (lecVar != null) {
                lecVar.x();
            }
            lec lecVar2 = this.n;
            if (lecVar2 != null) {
                lecVar2.x();
            }
            lec lecVar3 = this.o;
            if (lecVar3 != null) {
                lecVar3.x();
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

    @Override // com.baidu.tieba.oec, com.baidu.tieba.mec
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        lec lecVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new wec(this.u, this.r, this.s, this.v, this.b);
                    qdc qdcVar = this.g.get();
                    if (qdcVar != null) {
                        this.m.s(qdcVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new xec(this.v, this.b);
                    qdc qdcVar2 = this.g.get();
                    if (qdcVar2 != null) {
                        this.o.s(qdcVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new wec(this.u, this.r, this.s, this.v, this.b);
                qdc qdcVar3 = this.g.get();
                if (qdcVar3 != null) {
                    this.m.s(qdcVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new yec(this.v, this.b);
                qdc qdcVar4 = this.g.get();
                if (qdcVar4 != null) {
                    this.n.s(qdcVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (lecVar != null && !lecVar.equals(this.l)) {
            lecVar.x();
        }
        lec lecVar2 = this.l;
        if (lecVar2 != null) {
            lecVar2.r(this.h);
            WeakReference<qdc> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.oec, com.baidu.tieba.mec
    public void d(String str, Object obj, int i, boolean z) {
        lec lecVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (lecVar = this.l) != null) {
            lecVar.d(str, obj, i, z);
        }
    }
}
