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
public class ro9 extends po9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bp9 h;
    public int i;
    public int j;

    /* loaded from: classes6.dex */
    public class a extends qq9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ ko9 d;
        public final /* synthetic */ ro9 e;

        public a(ro9 ro9Var, String str, int i, AudioPlayData audioPlayData, ko9 ko9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro9Var, str, Integer.valueOf(i), audioPlayData, ko9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ro9Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = ko9Var;
        }

        @Override // com.baidu.tieba.qq9, com.baidu.tieba.pq9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || uo9.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.qq9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new ko9(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.qq9, com.baidu.tieba.pq9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                ro9 ro9Var = this.e;
                ro9Var.i((int) (((((ro9Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public ro9() {
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

    @Override // com.baidu.tieba.po9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            bp9 bp9Var = this.h;
            if (bp9Var != null) {
                bp9Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.po9
    public void d(mo9 mo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mo9Var) == null) {
            if (mo9Var == null || as9.e(mo9Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(mo9Var)) {
                l(mo9Var);
            } else {
                String a2 = mo9Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(mo9Var);
                x(mo9Var);
                List<oo9> c = mo9Var.c();
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

    @Override // com.baidu.tieba.po9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bp9 bp9Var = this.h;
            if (bp9Var != null) {
                bp9Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(ko9 ko9Var, int i) {
        mo9 mo9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, ko9Var, i) == null) || (mo9Var = this.d) == null || mo9Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(ko9Var);
    }

    public final void r(oo9 oo9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, oo9Var, i) == null) || oo9Var == null || as9.e(oo9Var.a()) || this.f || this.e) {
            return;
        }
        for (ko9 ko9Var : oo9Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(ko9Var)) {
                v(ko9Var, i);
            } else {
                q(ko9Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(ko9 ko9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ko9Var)) == null) {
            if (ko9Var == null || ko9Var.b() == null || !ko9Var.c()) {
                return false;
            }
            if (!uo9.o(ko9Var.b().mSoundTypes) && ko9Var.b().mSpeed == 1.0f && ko9Var.b().start == 0 && ko9Var.b().end == -1 && ko9Var.b().volume == 1.0f) {
                return (ko9Var.a() == null || "audio/mp4a-latm".equals(ko9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(ko9 ko9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, ko9Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = ko9Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            bp9 bp9Var = new bp9(b.audioPath, a2, b.mSoundTypes);
            this.h = bp9Var;
            bp9Var.S(new a(this, a2, i, b, ko9Var));
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
            g("dealAudioPlayData exception:" + fs9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(mo9 mo9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, mo9Var) == null) || mo9Var == null || as9.e(mo9Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < mo9Var.c().size(); i++) {
            arrayList.add(new oo9(new ArrayList()));
        }
        mo9 mo9Var2 = new mo9(arrayList);
        this.d = mo9Var2;
        mo9Var2.e(mo9Var.b());
        this.d.d(mo9Var.a());
    }

    public final void y(mo9 mo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mo9Var) == null) {
            this.i = 0;
            this.j = 0;
            List<oo9> c = mo9Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
