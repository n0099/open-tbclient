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
/* loaded from: classes6.dex */
public class xc9 extends vc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hd9 h;
    public int i;
    public int j;

    /* loaded from: classes6.dex */
    public class a extends we9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ qc9 d;
        public final /* synthetic */ xc9 e;

        public a(xc9 xc9Var, String str, int i, AudioPlayData audioPlayData, qc9 qc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc9Var, str, Integer.valueOf(i), audioPlayData, qc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xc9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = qc9Var;
        }

        @Override // com.baidu.tieba.we9, com.baidu.tieba.ve9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || ad9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.we9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new qc9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.we9, com.baidu.tieba.ve9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                xc9 xc9Var = this.e;
                xc9Var.i((int) (((((xc9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public xc9() {
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

    @Override // com.baidu.tieba.vc9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            hd9 hd9Var = this.h;
            if (hd9Var != null) {
                hd9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.vc9
    public void d(sc9 sc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sc9Var) == null) {
            if (sc9Var == null || gg9.e(sc9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(sc9Var)) {
                l(sc9Var);
            } else {
                String a2 = sc9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(sc9Var);
                x(sc9Var);
                List<uc9> c = sc9Var.c();
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

    @Override // com.baidu.tieba.vc9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hd9 hd9Var = this.h;
            if (hd9Var != null) {
                hd9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(qc9 qc9Var, int i) {
        sc9 sc9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, qc9Var, i) == null) || (sc9Var = this.d) == null || sc9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(qc9Var);
    }

    public final void r(uc9 uc9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, uc9Var, i) == null) || uc9Var == null || gg9.e(uc9Var.a()) || this.f || this.e) {
            return;
        }
        for (qc9 qc9Var : uc9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(qc9Var)) {
                v(qc9Var, i);
            } else {
                q(qc9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(qc9 qc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qc9Var)) == null) {
            if (qc9Var == null || qc9Var.b() == null || !qc9Var.c()) {
                return false;
            }
            if (!ad9.o(qc9Var.b().mSoundTypes) && qc9Var.b().mSpeed == 1.0f && qc9Var.b().start == 0 && qc9Var.b().end == -1 && qc9Var.b().volume == 1.0f) {
                return (qc9Var.a() == null || "audio/mp4a-latm".equals(qc9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(qc9 qc9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, qc9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = qc9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            hd9 hd9Var = new hd9(b.audioPath, a2, b.mSoundTypes);
            this.h = hd9Var;
            hd9Var.S(new a(this, a2, i, b, qc9Var));
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
            g("dealAudioPlayData exception:" + lg9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(sc9 sc9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, sc9Var) == null) || sc9Var == null || gg9.e(sc9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sc9Var.c().size(); i++) {
            arrayList.add(new uc9(new ArrayList()));
        }
        sc9 sc9Var2 = new sc9(arrayList);
        this.d = sc9Var2;
        sc9Var2.e(sc9Var.b());
        this.d.d(sc9Var.a());
    }

    public final void y(sc9 sc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sc9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<uc9> c = sc9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
