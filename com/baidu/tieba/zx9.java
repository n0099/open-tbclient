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
public class zx9 extends xx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jy9 h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends yz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ sx9 d;
        public final /* synthetic */ zx9 e;

        public a(zx9 zx9Var, String str, int i, AudioPlayData audioPlayData, sx9 sx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zx9Var, str, Integer.valueOf(i), audioPlayData, sx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zx9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = sx9Var;
        }

        @Override // com.baidu.tieba.yz9, com.baidu.tieba.xz9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || cy9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.yz9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new sx9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.yz9, com.baidu.tieba.xz9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                zx9 zx9Var = this.e;
                zx9Var.i((int) (((((zx9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public zx9() {
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

    @Override // com.baidu.tieba.xx9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            jy9 jy9Var = this.h;
            if (jy9Var != null) {
                jy9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.xx9
    public void d(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ux9Var) == null) {
            if (ux9Var == null || i1a.e(ux9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(ux9Var)) {
                l(ux9Var);
            } else {
                String a2 = ux9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(ux9Var);
                x(ux9Var);
                List<wx9> c = ux9Var.c();
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

    @Override // com.baidu.tieba.xx9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            jy9 jy9Var = this.h;
            if (jy9Var != null) {
                jy9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(sx9 sx9Var, int i) {
        ux9 ux9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, sx9Var, i) == null) || (ux9Var = this.d) == null || ux9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(sx9Var);
    }

    public final void r(wx9 wx9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, wx9Var, i) == null) || wx9Var == null || i1a.e(wx9Var.a()) || this.f || this.e) {
            return;
        }
        for (sx9 sx9Var : wx9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(sx9Var)) {
                v(sx9Var, i);
            } else {
                q(sx9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(sx9 sx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sx9Var)) == null) {
            if (sx9Var == null || sx9Var.b() == null || !sx9Var.c()) {
                return false;
            }
            if (!cy9.o(sx9Var.b().mSoundTypes) && sx9Var.b().mSpeed == 1.0f && sx9Var.b().start == 0 && sx9Var.b().end == -1 && sx9Var.b().volume == 1.0f) {
                return (sx9Var.a() == null || "audio/mp4a-latm".equals(sx9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(sx9 sx9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, sx9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = sx9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            jy9 jy9Var = new jy9(b.audioPath, a2, b.mSoundTypes);
            this.h = jy9Var;
            jy9Var.S(new a(this, a2, i, b, sx9Var));
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
            g("dealAudioPlayData exception:" + n1a.g(e));
            e.printStackTrace();
        }
    }

    public final void x(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ux9Var) == null) || ux9Var == null || i1a.e(ux9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ux9Var.c().size(); i++) {
            arrayList.add(new wx9(new ArrayList()));
        }
        ux9 ux9Var2 = new ux9(arrayList);
        this.d = ux9Var2;
        ux9Var2.e(ux9Var.b());
        this.d.d(ux9Var.a());
    }

    public final void y(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ux9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<wx9> c = ux9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
