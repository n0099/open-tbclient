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
/* loaded from: classes7.dex */
public class nta extends lta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xta h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends mva {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ gta d;
        public final /* synthetic */ nta e;

        public a(nta ntaVar, String str, int i, AudioPlayData audioPlayData, gta gtaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ntaVar, str, Integer.valueOf(i), audioPlayData, gtaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ntaVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = gtaVar;
        }

        @Override // com.baidu.tieba.mva, com.baidu.tieba.lva
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || qta.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.mva
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new gta(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.mva, com.baidu.tieba.lva
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                nta ntaVar = this.e;
                ntaVar.i((int) (((((ntaVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public nta() {
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

    @Override // com.baidu.tieba.lta
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            xta xtaVar = this.h;
            if (xtaVar != null) {
                xtaVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.lta
    public void d(ita itaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, itaVar) == null) {
            if (itaVar == null || wwa.e(itaVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(itaVar)) {
                l(itaVar);
            } else {
                String a2 = itaVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(itaVar);
                x(itaVar);
                List<kta> c = itaVar.c();
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

    @Override // com.baidu.tieba.lta
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xta xtaVar = this.h;
            if (xtaVar != null) {
                xtaVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(gta gtaVar, int i) {
        ita itaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, gtaVar, i) == null) || (itaVar = this.d) == null || itaVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(gtaVar);
    }

    public final void r(kta ktaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, ktaVar, i) == null) || ktaVar == null || wwa.e(ktaVar.a()) || this.f || this.e) {
            return;
        }
        for (gta gtaVar : ktaVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(gtaVar)) {
                v(gtaVar, i);
            } else {
                q(gtaVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(gta gtaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gtaVar)) == null) {
            if (gtaVar == null || gtaVar.b() == null || !gtaVar.c()) {
                return false;
            }
            if (!qta.o(gtaVar.b().mSoundTypes) && gtaVar.b().mSpeed == 1.0f && gtaVar.b().start == 0 && gtaVar.b().end == -1 && gtaVar.b().volume == 1.0f) {
                return (gtaVar.a() == null || "audio/mp4a-latm".equals(gtaVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(gta gtaVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, gtaVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = gtaVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            xta xtaVar = new xta(b.audioPath, a2, b.mSoundTypes);
            this.h = xtaVar;
            xtaVar.S(new a(this, a2, i, b, gtaVar));
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
            g("dealAudioPlayData exception:" + bxa.g(e));
            e.printStackTrace();
        }
    }

    public final void x(ita itaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, itaVar) == null) || itaVar == null || wwa.e(itaVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < itaVar.c().size(); i++) {
            arrayList.add(new kta(new ArrayList()));
        }
        ita itaVar2 = new ita(arrayList);
        this.d = itaVar2;
        itaVar2.e(itaVar.b());
        this.d.d(itaVar.a());
    }

    public final void y(ita itaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, itaVar) == null) {
            this.i = 0;
            this.j = 0;
            List<kta> c = itaVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
