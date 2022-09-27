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
public class md9 extends kd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wd9 h;
    public int i;
    public int j;

    /* loaded from: classes5.dex */
    public class a extends lf9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ fd9 d;
        public final /* synthetic */ md9 e;

        public a(md9 md9Var, String str, int i, AudioPlayData audioPlayData, fd9 fd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md9Var, str, Integer.valueOf(i), audioPlayData, fd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = md9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = fd9Var;
        }

        @Override // com.baidu.tieba.lf9, com.baidu.tieba.kf9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || pd9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.lf9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new fd9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.lf9, com.baidu.tieba.kf9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                md9 md9Var = this.e;
                md9Var.i((int) (((((md9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public md9() {
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

    @Override // com.baidu.tieba.kd9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            wd9 wd9Var = this.h;
            if (wd9Var != null) {
                wd9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.kd9
    public void d(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hd9Var) == null) {
            if (hd9Var == null || vg9.e(hd9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(hd9Var)) {
                l(hd9Var);
            } else {
                String a2 = hd9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(hd9Var);
                x(hd9Var);
                List<jd9> c = hd9Var.c();
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

    @Override // com.baidu.tieba.kd9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            wd9 wd9Var = this.h;
            if (wd9Var != null) {
                wd9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(fd9 fd9Var, int i) {
        hd9 hd9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, fd9Var, i) == null) || (hd9Var = this.d) == null || hd9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(fd9Var);
    }

    public final void r(jd9 jd9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, jd9Var, i) == null) || jd9Var == null || vg9.e(jd9Var.a()) || this.f || this.e) {
            return;
        }
        for (fd9 fd9Var : jd9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(fd9Var)) {
                v(fd9Var, i);
            } else {
                q(fd9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(fd9 fd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fd9Var)) == null) {
            if (fd9Var == null || fd9Var.b() == null || !fd9Var.c()) {
                return false;
            }
            if (!pd9.o(fd9Var.b().mSoundTypes) && fd9Var.b().mSpeed == 1.0f && fd9Var.b().start == 0 && fd9Var.b().end == -1 && fd9Var.b().volume == 1.0f) {
                return (fd9Var.a() == null || "audio/mp4a-latm".equals(fd9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(fd9 fd9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, fd9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = fd9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            wd9 wd9Var = new wd9(b.audioPath, a2, b.mSoundTypes);
            this.h = wd9Var;
            wd9Var.S(new a(this, a2, i, b, fd9Var));
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
            g("dealAudioPlayData exception:" + ah9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, hd9Var) == null) || hd9Var == null || vg9.e(hd9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < hd9Var.c().size(); i++) {
            arrayList.add(new jd9(new ArrayList()));
        }
        hd9 hd9Var2 = new hd9(arrayList);
        this.d = hd9Var2;
        hd9Var2.e(hd9Var.b());
        this.d.d(hd9Var.a());
    }

    public final void y(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hd9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<jd9> c = hd9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
