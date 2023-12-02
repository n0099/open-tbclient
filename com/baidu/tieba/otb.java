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
public class otb extends mtb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ytb h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends nvb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ htb d;
        public final /* synthetic */ otb e;

        public a(otb otbVar, String str, int i, AudioPlayData audioPlayData, htb htbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {otbVar, str, Integer.valueOf(i), audioPlayData, htbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = otbVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = htbVar;
        }

        @Override // com.baidu.tieba.nvb, com.baidu.tieba.mvb
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || rtb.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.nvb
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new htb(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.nvb, com.baidu.tieba.mvb
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                otb otbVar = this.e;
                otbVar.i((int) (((((otbVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public otb() {
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

    @Override // com.baidu.tieba.mtb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            ytb ytbVar = this.h;
            if (ytbVar != null) {
                ytbVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.mtb
    public void d(jtb jtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jtbVar) == null) {
            if (jtbVar == null || xwb.e(jtbVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(jtbVar)) {
                l(jtbVar);
            } else {
                String a2 = jtbVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(jtbVar);
                x(jtbVar);
                List<ltb> c = jtbVar.c();
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

    @Override // com.baidu.tieba.mtb
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ytb ytbVar = this.h;
            if (ytbVar != null) {
                ytbVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(htb htbVar, int i) {
        jtb jtbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, htbVar, i) == null) || (jtbVar = this.d) == null || jtbVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(htbVar);
    }

    public final void r(ltb ltbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, ltbVar, i) == null) || ltbVar == null || xwb.e(ltbVar.a()) || this.f || this.e) {
            return;
        }
        for (htb htbVar : ltbVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(htbVar)) {
                v(htbVar, i);
            } else {
                q(htbVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(htb htbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, htbVar)) == null) {
            if (htbVar == null || htbVar.b() == null || !htbVar.c()) {
                return false;
            }
            if (!rtb.o(htbVar.b().mSoundTypes) && htbVar.b().mSpeed == 1.0f && htbVar.b().start == 0 && htbVar.b().end == -1 && htbVar.b().volume == 1.0f) {
                return (htbVar.a() == null || "audio/mp4a-latm".equals(htbVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(htb htbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, htbVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = htbVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            ytb ytbVar = new ytb(b.audioPath, a2, b.mSoundTypes);
            this.h = ytbVar;
            ytbVar.S(new a(this, a2, i, b, htbVar));
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
            g("dealAudioPlayData exception:" + cxb.g(e));
            e.printStackTrace();
        }
    }

    public final void x(jtb jtbVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jtbVar) == null) || jtbVar == null || xwb.e(jtbVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jtbVar.c().size(); i++) {
            arrayList.add(new ltb(new ArrayList()));
        }
        jtb jtbVar2 = new jtb(arrayList);
        this.d = jtbVar2;
        jtbVar2.e(jtbVar.b());
        this.d.d(jtbVar.a());
    }

    public final void y(jtb jtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jtbVar) == null) {
            this.i = 0;
            this.j = 0;
            List<ltb> c = jtbVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
