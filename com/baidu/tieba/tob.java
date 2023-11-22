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
public class tob extends rob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dpb h;
    public int i;
    public int j;

    /* loaded from: classes8.dex */
    public class a extends sqb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ mob d;
        public final /* synthetic */ tob e;

        public a(tob tobVar, String str, int i, AudioPlayData audioPlayData, mob mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tobVar, str, Integer.valueOf(i), audioPlayData, mobVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = tobVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = mobVar;
        }

        @Override // com.baidu.tieba.sqb, com.baidu.tieba.rqb
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || wob.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.sqb
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new mob(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.sqb, com.baidu.tieba.rqb
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                tob tobVar = this.e;
                tobVar.i((int) (((((tobVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public tob() {
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

    @Override // com.baidu.tieba.rob
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            dpb dpbVar = this.h;
            if (dpbVar != null) {
                dpbVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.rob
    public void d(oob oobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oobVar) == null) {
            if (oobVar == null || csb.e(oobVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(oobVar)) {
                l(oobVar);
            } else {
                String a2 = oobVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(oobVar);
                x(oobVar);
                List<qob> c = oobVar.c();
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

    @Override // com.baidu.tieba.rob
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dpb dpbVar = this.h;
            if (dpbVar != null) {
                dpbVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(mob mobVar, int i) {
        oob oobVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, mobVar, i) == null) || (oobVar = this.d) == null || oobVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(mobVar);
    }

    public final void r(qob qobVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, qobVar, i) == null) || qobVar == null || csb.e(qobVar.a()) || this.f || this.e) {
            return;
        }
        for (mob mobVar : qobVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(mobVar)) {
                v(mobVar, i);
            } else {
                q(mobVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(mob mobVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mobVar)) == null) {
            if (mobVar == null || mobVar.b() == null || !mobVar.c()) {
                return false;
            }
            if (!wob.o(mobVar.b().mSoundTypes) && mobVar.b().mSpeed == 1.0f && mobVar.b().start == 0 && mobVar.b().end == -1 && mobVar.b().volume == 1.0f) {
                return (mobVar.a() == null || "audio/mp4a-latm".equals(mobVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(mob mobVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, mobVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = mobVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            dpb dpbVar = new dpb(b.audioPath, a2, b.mSoundTypes);
            this.h = dpbVar;
            dpbVar.S(new a(this, a2, i, b, mobVar));
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
            g("dealAudioPlayData exception:" + hsb.g(e));
            e.printStackTrace();
        }
    }

    public final void x(oob oobVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, oobVar) == null) || oobVar == null || csb.e(oobVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < oobVar.c().size(); i++) {
            arrayList.add(new qob(new ArrayList()));
        }
        oob oobVar2 = new oob(arrayList);
        this.d = oobVar2;
        oobVar2.e(oobVar.b());
        this.d.d(oobVar.a());
    }

    public final void y(oob oobVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oobVar) == null) {
            this.i = 0;
            this.j = 0;
            List<qob> c = oobVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
