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
public class qjc extends jjc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gjc l;
    public gjc m;
    public gjc n;
    public gjc o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public AtomicBoolean t;
    public fkc u;
    public pic v;

    public qjc(int i, pic picVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), picVar};
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
        this.v = picVar;
        this.b = i;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.jjc, com.baidu.tieba.hjc
    public void f(MediaSample mediaSample) {
        gjc gjcVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mediaSample) == null) && this.t.get() && (gjcVar = this.l) != null) {
            gjcVar.f(mediaSample);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public void B(fkc fkcVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fkcVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.u = fkcVar;
            this.s = z2;
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.hjc
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t.set(true);
        }
    }

    @Override // com.baidu.tieba.jjc
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = null;
            this.v = null;
            gjc gjcVar = this.m;
            if (gjcVar != null) {
                gjcVar.p();
                this.m = null;
            }
            gjc gjcVar2 = this.n;
            if (gjcVar2 != null) {
                gjcVar2.p();
                this.n = null;
            }
            gjc gjcVar3 = this.o;
            if (gjcVar3 != null) {
                gjcVar3.p();
                this.o = null;
            }
        }
    }

    @Override // com.baidu.tieba.jjc
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t.set(false);
            gjc gjcVar = this.m;
            if (gjcVar != null) {
                gjcVar.x();
            }
            gjc gjcVar2 = this.n;
            if (gjcVar2 != null) {
                gjcVar2.x();
            }
            gjc gjcVar3 = this.o;
            if (gjcVar3 != null) {
                gjcVar3.x();
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

    @Override // com.baidu.tieba.jjc, com.baidu.tieba.hjc
    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.t.get()) {
            return;
        }
        TLog.g(this, "H264UseHWDecode :" + this.p + ", H265UseHWDecode :" + this.q + ", netCode:" + i);
        gjc gjcVar = this.l;
        if (2002 == i) {
            if (this.q) {
                if (this.m == null) {
                    this.m = new rjc(this.u, this.r, this.s, this.v, this.b);
                    lic licVar = this.g.get();
                    if (licVar != null) {
                        this.m.s(licVar);
                    }
                }
                this.l = this.m;
                this.v.z(3);
                TLog.g(this, "hw decoder h265");
            } else {
                if (this.o == null) {
                    this.o = new sjc(this.v, this.b);
                    lic licVar2 = this.g.get();
                    if (licVar2 != null) {
                        this.o.s(licVar2);
                    }
                }
                this.l = this.o;
                this.v.z(4);
                TLog.g(this, "ittiam decoder h265");
            }
        } else if (this.p) {
            if (this.m == null) {
                this.m = new rjc(this.u, this.r, this.s, this.v, this.b);
                lic licVar3 = this.g.get();
                if (licVar3 != null) {
                    this.m.s(licVar3);
                }
            }
            this.l = this.m;
            this.v.z(1);
            TLog.g(this, "hw decoder h264");
        } else {
            if (this.n == null) {
                this.n = new tjc(this.v, this.b);
                lic licVar4 = this.g.get();
                if (licVar4 != null) {
                    this.n.s(licVar4);
                }
            }
            this.l = this.n;
            this.v.z(2);
            TLog.g(this, "ffmpeg decoder h264");
        }
        if (gjcVar != null && !gjcVar.equals(this.l)) {
            gjcVar.x();
        }
        gjc gjcVar2 = this.l;
        if (gjcVar2 != null) {
            gjcVar2.r(this.h);
            WeakReference<lic> weakReference = this.g;
            if (weakReference != null) {
                this.l.s(weakReference.get());
            }
            this.l.t(this.c);
            this.l.q(this.e);
            this.l.k(this.d);
            this.l.a();
        }
    }

    @Override // com.baidu.tieba.jjc, com.baidu.tieba.hjc
    public void d(String str, Object obj, int i, boolean z) {
        gjc gjcVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (gjcVar = this.l) != null) {
            gjcVar.d(str, obj, i, z);
        }
    }
}
