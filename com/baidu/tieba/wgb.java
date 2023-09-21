package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class wgb extends ugb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ghb h;
    public int i;
    public int j;

    /* loaded from: classes8.dex */
    public class a extends vib {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ pgb d;
        public final /* synthetic */ wgb e;

        public a(wgb wgbVar, String str, int i, AudioPlayData audioPlayData, pgb pgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgbVar, str, Integer.valueOf(i), audioPlayData, pgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wgbVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = pgbVar;
        }

        @Override // com.baidu.tieba.vib, com.baidu.tieba.uib
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || zgb.o(audioPlayData.mSoundTypes)) {
                    this.e.g(str);
                    this.e.h.cancel();
                } else {
                    this.e.h.cancel();
                    this.e.q(this.d, this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.vib
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new pgb(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.vib, com.baidu.tieba.uib
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                wgb wgbVar = this.e;
                wgbVar.i((int) (((((wgbVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public wgb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ugb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            ghb ghbVar = this.h;
            if (ghbVar != null) {
                ghbVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.ugb
    public void d(rgb rgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rgbVar) == null) {
            if (rgbVar == null || fkb.e(rgbVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(rgbVar)) {
                l(rgbVar);
            } else {
                String a2 = rgbVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(rgbVar);
                x(rgbVar);
                List<tgb> c = rgbVar.c();
                int size = c.size();
                for (int i = 0; i < size; i++) {
                    r(c.get(i), i);
                }
                if (this.e || this.f) {
                    return;
                }
                l(this.d);
            }
        }
    }

    @Override // com.baidu.tieba.ugb
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ghb ghbVar = this.h;
            if (ghbVar != null) {
                ghbVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(pgb pgbVar, int i) {
        rgb rgbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, pgbVar, i) == null) || (rgbVar = this.d) == null || rgbVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(pgbVar);
    }

    public final void r(tgb tgbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tgbVar, i) == null) || tgbVar == null || fkb.e(tgbVar.a()) || this.f || this.e) {
            return;
        }
        for (pgb pgbVar : tgbVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(pgbVar)) {
                v(pgbVar, i);
            } else {
                q(pgbVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(pgb pgbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pgbVar)) == null) {
            if (pgbVar == null || pgbVar.b() == null || !pgbVar.c()) {
                return false;
            }
            if (!zgb.o(pgbVar.b().mSoundTypes) && pgbVar.b().mSpeed == 1.0f && pgbVar.b().start == 0 && pgbVar.b().end == -1 && pgbVar.b().volume == 1.0f) {
                return (pgbVar.a() == null || "audio/mp4a-latm".equals(pgbVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(pgb pgbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, pgbVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = pgbVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            ghb ghbVar = new ghb(b.audioPath, a2, b.mSoundTypes);
            this.h = ghbVar;
            ghbVar.S(new a(this, a2, i, b, pgbVar));
            this.h.D(b.mSoundTypes);
            this.h.G(b.mSpeed);
            this.h.H(b.volume);
            this.h.B(b.start);
            this.h.R(b.end);
            this.h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e) {
            g("dealAudioPlayData exception:" + kkb.g(e));
            e.printStackTrace();
        }
    }

    public final void x(rgb rgbVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, rgbVar) == null) || rgbVar == null || fkb.e(rgbVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < rgbVar.c().size(); i++) {
            arrayList.add(new tgb(new ArrayList()));
        }
        rgb rgbVar2 = new rgb(arrayList);
        this.d = rgbVar2;
        rgbVar2.e(rgbVar.b());
        this.d.d(rgbVar.a());
    }

    public final void y(rgb rgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rgbVar) == null) {
            this.i = 0;
            this.j = 0;
            List<tgb> c = rgbVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
