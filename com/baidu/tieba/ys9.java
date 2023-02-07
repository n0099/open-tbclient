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
public class ys9 extends ws9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public it9 h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends xu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ rs9 d;
        public final /* synthetic */ ys9 e;

        public a(ys9 ys9Var, String str, int i, AudioPlayData audioPlayData, rs9 rs9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys9Var, str, Integer.valueOf(i), audioPlayData, rs9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ys9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = rs9Var;
        }

        @Override // com.baidu.tieba.xu9, com.baidu.tieba.wu9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || bt9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.xu9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new rs9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.xu9, com.baidu.tieba.wu9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                ys9 ys9Var = this.e;
                ys9Var.i((int) (((((ys9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public ys9() {
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

    @Override // com.baidu.tieba.ws9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            it9 it9Var = this.h;
            if (it9Var != null) {
                it9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.ws9
    public void d(ts9 ts9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ts9Var) == null) {
            if (ts9Var == null || hw9.e(ts9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(ts9Var)) {
                l(ts9Var);
            } else {
                String a2 = ts9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(ts9Var);
                x(ts9Var);
                List<vs9> c = ts9Var.c();
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

    @Override // com.baidu.tieba.ws9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            it9 it9Var = this.h;
            if (it9Var != null) {
                it9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(rs9 rs9Var, int i) {
        ts9 ts9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, rs9Var, i) == null) || (ts9Var = this.d) == null || ts9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(rs9Var);
    }

    public final void r(vs9 vs9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, vs9Var, i) == null) || vs9Var == null || hw9.e(vs9Var.a()) || this.f || this.e) {
            return;
        }
        for (rs9 rs9Var : vs9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(rs9Var)) {
                v(rs9Var, i);
            } else {
                q(rs9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(rs9 rs9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rs9Var)) == null) {
            if (rs9Var == null || rs9Var.b() == null || !rs9Var.c()) {
                return false;
            }
            if (!bt9.o(rs9Var.b().mSoundTypes) && rs9Var.b().mSpeed == 1.0f && rs9Var.b().start == 0 && rs9Var.b().end == -1 && rs9Var.b().volume == 1.0f) {
                return (rs9Var.a() == null || "audio/mp4a-latm".equals(rs9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(rs9 rs9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, rs9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = rs9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            it9 it9Var = new it9(b.audioPath, a2, b.mSoundTypes);
            this.h = it9Var;
            it9Var.S(new a(this, a2, i, b, rs9Var));
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
            g("dealAudioPlayData exception:" + mw9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(ts9 ts9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ts9Var) == null) || ts9Var == null || hw9.e(ts9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ts9Var.c().size(); i++) {
            arrayList.add(new vs9(new ArrayList()));
        }
        ts9 ts9Var2 = new ts9(arrayList);
        this.d = ts9Var2;
        ts9Var2.e(ts9Var.b());
        this.d.d(ts9Var.a());
    }

    public final void y(ts9 ts9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ts9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<vs9> c = ts9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
