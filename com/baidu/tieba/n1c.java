package com.baidu.tieba;

import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.common.ConcurrentLinkedQueueX;
import com.yy.transvod.player.core.TransVodProxy;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class n1c extends s1c implements l1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int c;
    public l1c d;
    public m1c e;
    public ConcurrentLinkedQueueX<MediaSample> f;
    public WeakReference<p0c> g;
    public String h;
    public boolean i;
    public boolean j;
    public Object k;

    @Override // com.baidu.tieba.l1c
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    public void f(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mediaSample) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public n1c() {
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
        this.c = -1;
        this.d = null;
        this.e = null;
        this.f = new ConcurrentLinkedQueueX<>();
        this.g = new WeakReference<>(null);
        this.h = null;
        this.i = true;
        this.j = false;
        this.k = new Object();
    }

    public void d(String str, Object obj, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, obj, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this.k) {
                if (this.d != null && z) {
                    this.d.d(str, obj, i, z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.l1c
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.i = z;
        }
    }

    public final void k(l1c l1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, l1cVar) == null) {
            synchronized (this.k) {
                this.d = l1cVar;
            }
        }
    }

    public final void m(int i) {
        TransVodProxy i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int g = this.e.g();
            if ((g == 6 || g == 7) && (i2 = this.e.i()) != null) {
                i2.c(i);
            }
        }
    }

    public final void q(m1c m1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, m1cVar) == null) {
            this.e = m1cVar;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.h = str;
        }
    }

    public void s(p0c p0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, p0cVar) == null) {
            this.g = new WeakReference<>(p0cVar);
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.c = i;
        }
    }

    public final void w(MediaSample mediaSample) {
        x0c f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mediaSample) == null) {
            int g = this.e.g();
            if ((g == 6 || g == 7) && (f = this.e.f()) != null) {
                f.e(mediaSample);
            }
        }
    }

    public final void j(int i, int i2, MediaInfo mediaInfo) {
        p0c p0cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, mediaInfo) == null) && mediaInfo != null) {
            if ((i != mediaInfo.b || i2 != mediaInfo.c) && (p0cVar = this.g.get()) != null) {
                Message obtain = Message.obtain();
                obtain.what = SpeedStatsStampTable.HOME_VIEW_ON_LAYOUT_END_STAMP_KEY;
                obtain.arg1 = mediaInfo.b;
                obtain.arg2 = mediaInfo.c;
                p0cVar.a(obtain, this.a);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = -1;
            synchronized (this.k) {
                this.d = null;
            }
        }
    }

    public final void n(MediaSample mediaSample) {
        w0c h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSample) == null) && (h = this.e.h()) != null && mediaSample.g != null) {
            h.d(mediaSample, this.g.get(), this.h);
            mediaSample.g.p = null;
            mediaSample.I = null;
            mediaSample.J = null;
        }
    }

    public final void v(MediaSample mediaSample, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, mediaSample, i, str) == null) {
            int g = this.e.g();
            if (g == 6 || g == 7) {
                this.e.f();
            }
        }
    }
}
