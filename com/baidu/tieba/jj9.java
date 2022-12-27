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
/* loaded from: classes5.dex */
public class jj9 extends hj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tj9 h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends il9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ cj9 d;
        public final /* synthetic */ jj9 e;

        public a(jj9 jj9Var, String str, int i, AudioPlayData audioPlayData, cj9 cj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jj9Var, str, Integer.valueOf(i), audioPlayData, cj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jj9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = cj9Var;
        }

        @Override // com.baidu.tieba.il9, com.baidu.tieba.hl9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || mj9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.il9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new cj9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.il9, com.baidu.tieba.hl9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                jj9 jj9Var = this.e;
                jj9Var.i((int) (((((jj9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public jj9() {
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

    @Override // com.baidu.tieba.hj9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            tj9 tj9Var = this.h;
            if (tj9Var != null) {
                tj9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.hj9
    public void d(ej9 ej9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ej9Var) == null) {
            if (ej9Var == null || sm9.e(ej9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(ej9Var)) {
                l(ej9Var);
            } else {
                String a2 = ej9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(ej9Var);
                x(ej9Var);
                List<gj9> c = ej9Var.c();
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

    @Override // com.baidu.tieba.hj9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            tj9 tj9Var = this.h;
            if (tj9Var != null) {
                tj9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(cj9 cj9Var, int i) {
        ej9 ej9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, cj9Var, i) == null) || (ej9Var = this.d) == null || ej9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(cj9Var);
    }

    public final void r(gj9 gj9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, gj9Var, i) == null) || gj9Var == null || sm9.e(gj9Var.a()) || this.f || this.e) {
            return;
        }
        for (cj9 cj9Var : gj9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(cj9Var)) {
                v(cj9Var, i);
            } else {
                q(cj9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(cj9 cj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cj9Var)) == null) {
            if (cj9Var == null || cj9Var.b() == null || !cj9Var.c()) {
                return false;
            }
            if (!mj9.o(cj9Var.b().mSoundTypes) && cj9Var.b().mSpeed == 1.0f && cj9Var.b().start == 0 && cj9Var.b().end == -1 && cj9Var.b().volume == 1.0f) {
                return (cj9Var.a() == null || "audio/mp4a-latm".equals(cj9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(cj9 cj9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, cj9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = cj9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            tj9 tj9Var = new tj9(b.audioPath, a2, b.mSoundTypes);
            this.h = tj9Var;
            tj9Var.S(new a(this, a2, i, b, cj9Var));
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
            g("dealAudioPlayData exception:" + xm9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(ej9 ej9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ej9Var) == null) || ej9Var == null || sm9.e(ej9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ej9Var.c().size(); i++) {
            arrayList.add(new gj9(new ArrayList()));
        }
        ej9 ej9Var2 = new ej9(arrayList);
        this.d = ej9Var2;
        ej9Var2.e(ej9Var.b());
        this.d.d(ej9Var.a());
    }

    public final void y(ej9 ej9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ej9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<gj9> c = ej9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
