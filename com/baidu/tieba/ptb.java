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
public class ptb extends ntb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ztb h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends ovb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ itb d;
        public final /* synthetic */ ptb e;

        public a(ptb ptbVar, String str, int i, AudioPlayData audioPlayData, itb itbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ptbVar, str, Integer.valueOf(i), audioPlayData, itbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ptbVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = itbVar;
        }

        @Override // com.baidu.tieba.ovb, com.baidu.tieba.nvb
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || stb.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.ovb
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new itb(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.ovb, com.baidu.tieba.nvb
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                ptb ptbVar = this.e;
                ptbVar.i((int) (((((ptbVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public ptb() {
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

    @Override // com.baidu.tieba.ntb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            ztb ztbVar = this.h;
            if (ztbVar != null) {
                ztbVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.ntb
    public void d(ktb ktbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ktbVar) == null) {
            if (ktbVar == null || ywb.e(ktbVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(ktbVar)) {
                l(ktbVar);
            } else {
                String a2 = ktbVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(ktbVar);
                x(ktbVar);
                List<mtb> c = ktbVar.c();
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

    @Override // com.baidu.tieba.ntb
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ztb ztbVar = this.h;
            if (ztbVar != null) {
                ztbVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(itb itbVar, int i) {
        ktb ktbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, itbVar, i) == null) || (ktbVar = this.d) == null || ktbVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(itbVar);
    }

    public final void r(mtb mtbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, mtbVar, i) == null) || mtbVar == null || ywb.e(mtbVar.a()) || this.f || this.e) {
            return;
        }
        for (itb itbVar : mtbVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(itbVar)) {
                v(itbVar, i);
            } else {
                q(itbVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(itb itbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, itbVar)) == null) {
            if (itbVar == null || itbVar.b() == null || !itbVar.c()) {
                return false;
            }
            if (!stb.o(itbVar.b().mSoundTypes) && itbVar.b().mSpeed == 1.0f && itbVar.b().start == 0 && itbVar.b().end == -1 && itbVar.b().volume == 1.0f) {
                return (itbVar.a() == null || "audio/mp4a-latm".equals(itbVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(itb itbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, itbVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = itbVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            ztb ztbVar = new ztb(b.audioPath, a2, b.mSoundTypes);
            this.h = ztbVar;
            ztbVar.S(new a(this, a2, i, b, itbVar));
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
            g("dealAudioPlayData exception:" + dxb.g(e));
            e.printStackTrace();
        }
    }

    public final void x(ktb ktbVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ktbVar) == null) || ktbVar == null || ywb.e(ktbVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ktbVar.c().size(); i++) {
            arrayList.add(new mtb(new ArrayList()));
        }
        ktb ktbVar2 = new ktb(arrayList);
        this.d = ktbVar2;
        ktbVar2.e(ktbVar.b());
        this.d.d(ktbVar.a());
    }

    public final void y(ktb ktbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ktbVar) == null) {
            this.i = 0;
            this.j = 0;
            List<mtb> c = ktbVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
