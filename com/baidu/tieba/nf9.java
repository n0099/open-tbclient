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
public class nf9 extends lf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xf9 h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends mh9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ gf9 d;
        public final /* synthetic */ nf9 e;

        public a(nf9 nf9Var, String str, int i, AudioPlayData audioPlayData, gf9 gf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf9Var, str, Integer.valueOf(i), audioPlayData, gf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nf9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = gf9Var;
        }

        @Override // com.baidu.tieba.mh9, com.baidu.tieba.lh9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || qf9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.mh9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new gf9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.mh9, com.baidu.tieba.lh9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                nf9 nf9Var = this.e;
                nf9Var.i((int) (((((nf9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public nf9() {
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

    @Override // com.baidu.tieba.lf9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            xf9 xf9Var = this.h;
            if (xf9Var != null) {
                xf9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.lf9
    public void d(if9 if9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, if9Var) == null) {
            if (if9Var == null || wi9.e(if9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(if9Var)) {
                l(if9Var);
            } else {
                String a2 = if9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(if9Var);
                x(if9Var);
                List<kf9> c = if9Var.c();
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

    @Override // com.baidu.tieba.lf9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xf9 xf9Var = this.h;
            if (xf9Var != null) {
                xf9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(gf9 gf9Var, int i) {
        if9 if9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, gf9Var, i) == null) || (if9Var = this.d) == null || if9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(gf9Var);
    }

    public final void r(kf9 kf9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, kf9Var, i) == null) || kf9Var == null || wi9.e(kf9Var.a()) || this.f || this.e) {
            return;
        }
        for (gf9 gf9Var : kf9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(gf9Var)) {
                v(gf9Var, i);
            } else {
                q(gf9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(gf9 gf9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gf9Var)) == null) {
            if (gf9Var == null || gf9Var.b() == null || !gf9Var.c()) {
                return false;
            }
            if (!qf9.o(gf9Var.b().mSoundTypes) && gf9Var.b().mSpeed == 1.0f && gf9Var.b().start == 0 && gf9Var.b().end == -1 && gf9Var.b().volume == 1.0f) {
                return (gf9Var.a() == null || "audio/mp4a-latm".equals(gf9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(gf9 gf9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, gf9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = gf9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            xf9 xf9Var = new xf9(b.audioPath, a2, b.mSoundTypes);
            this.h = xf9Var;
            xf9Var.S(new a(this, a2, i, b, gf9Var));
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
            g("dealAudioPlayData exception:" + bj9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(if9 if9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, if9Var) == null) || if9Var == null || wi9.e(if9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < if9Var.c().size(); i++) {
            arrayList.add(new kf9(new ArrayList()));
        }
        if9 if9Var2 = new if9(arrayList);
        this.d = if9Var2;
        if9Var2.e(if9Var.b());
        this.d.d(if9Var.a());
    }

    public final void y(if9 if9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, if9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<kf9> c = if9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
