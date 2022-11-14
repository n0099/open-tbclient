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
public class yf9 extends wf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ig9 h;
    public int i;
    public int j;

    /* loaded from: classes6.dex */
    public class a extends xh9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ rf9 d;
        public final /* synthetic */ yf9 e;

        public a(yf9 yf9Var, String str, int i, AudioPlayData audioPlayData, rf9 rf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf9Var, str, Integer.valueOf(i), audioPlayData, rf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yf9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = rf9Var;
        }

        @Override // com.baidu.tieba.xh9, com.baidu.tieba.wh9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || bg9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.xh9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new rf9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.xh9, com.baidu.tieba.wh9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                yf9 yf9Var = this.e;
                yf9Var.i((int) (((((yf9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public yf9() {
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

    @Override // com.baidu.tieba.wf9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            ig9 ig9Var = this.h;
            if (ig9Var != null) {
                ig9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.wf9
    public void d(tf9 tf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tf9Var) == null) {
            if (tf9Var == null || hj9.e(tf9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(tf9Var)) {
                l(tf9Var);
            } else {
                String a2 = tf9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(tf9Var);
                x(tf9Var);
                List<vf9> c = tf9Var.c();
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

    @Override // com.baidu.tieba.wf9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ig9 ig9Var = this.h;
            if (ig9Var != null) {
                ig9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(rf9 rf9Var, int i) {
        tf9 tf9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, rf9Var, i) == null) || (tf9Var = this.d) == null || tf9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(rf9Var);
    }

    public final void r(vf9 vf9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, vf9Var, i) == null) || vf9Var == null || hj9.e(vf9Var.a()) || this.f || this.e) {
            return;
        }
        for (rf9 rf9Var : vf9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(rf9Var)) {
                v(rf9Var, i);
            } else {
                q(rf9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(rf9 rf9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rf9Var)) == null) {
            if (rf9Var == null || rf9Var.b() == null || !rf9Var.c()) {
                return false;
            }
            if (!bg9.o(rf9Var.b().mSoundTypes) && rf9Var.b().mSpeed == 1.0f && rf9Var.b().start == 0 && rf9Var.b().end == -1 && rf9Var.b().volume == 1.0f) {
                return (rf9Var.a() == null || "audio/mp4a-latm".equals(rf9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(rf9 rf9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, rf9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = rf9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            ig9 ig9Var = new ig9(b.audioPath, a2, b.mSoundTypes);
            this.h = ig9Var;
            ig9Var.S(new a(this, a2, i, b, rf9Var));
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
            g("dealAudioPlayData exception:" + mj9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(tf9 tf9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tf9Var) == null) || tf9Var == null || hj9.e(tf9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < tf9Var.c().size(); i++) {
            arrayList.add(new vf9(new ArrayList()));
        }
        tf9 tf9Var2 = new tf9(arrayList);
        this.d = tf9Var2;
        tf9Var2.e(tf9Var.b());
        this.d.d(tf9Var.a());
    }

    public final void y(tf9 tf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tf9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<vf9> c = tf9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
