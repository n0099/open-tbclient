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
/* loaded from: classes8.dex */
public class wcb extends ucb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gdb h;
    public int i;
    public int j;

    /* loaded from: classes8.dex */
    public class a extends veb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ pcb d;
        public final /* synthetic */ wcb e;

        public a(wcb wcbVar, String str, int i, AudioPlayData audioPlayData, pcb pcbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wcbVar, str, Integer.valueOf(i), audioPlayData, pcbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = wcbVar;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = pcbVar;
        }

        @Override // com.baidu.tieba.veb, com.baidu.tieba.ueb
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || zcb.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.baidu.tieba.veb
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new pcb(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.veb, com.baidu.tieba.ueb
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                wcb wcbVar = this.e;
                wcbVar.i((int) (((((wcbVar.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public wcb() {
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

    @Override // com.baidu.tieba.ucb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            gdb gdbVar = this.h;
            if (gdbVar != null) {
                gdbVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.ucb
    public void d(rcb rcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rcbVar) == null) {
            if (rcbVar == null || fgb.e(rcbVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(rcbVar)) {
                l(rcbVar);
            } else {
                String a2 = rcbVar.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(rcbVar);
                x(rcbVar);
                List<tcb> c = rcbVar.c();
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

    @Override // com.baidu.tieba.ucb
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gdb gdbVar = this.h;
            if (gdbVar != null) {
                gdbVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(pcb pcbVar, int i) {
        rcb rcbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, pcbVar, i) == null) || (rcbVar = this.d) == null || rcbVar.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(pcbVar);
    }

    public final void r(tcb tcbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, tcbVar, i) == null) || tcbVar == null || fgb.e(tcbVar.a()) || this.f || this.e) {
            return;
        }
        for (pcb pcbVar : tcbVar.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(pcbVar)) {
                v(pcbVar, i);
            } else {
                q(pcbVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(pcb pcbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pcbVar)) == null) {
            if (pcbVar == null || pcbVar.b() == null || !pcbVar.c()) {
                return false;
            }
            if (!zcb.o(pcbVar.b().mSoundTypes) && pcbVar.b().mSpeed == 1.0f && pcbVar.b().start == 0 && pcbVar.b().end == -1 && pcbVar.b().volume == 1.0f) {
                return (pcbVar.a() == null || "audio/mp4a-latm".equals(pcbVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(pcb pcbVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, pcbVar, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = pcbVar.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            gdb gdbVar = new gdb(b.audioPath, a2, b.mSoundTypes);
            this.h = gdbVar;
            gdbVar.S(new a(this, a2, i, b, pcbVar));
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
            g("dealAudioPlayData exception:" + kgb.g(e));
            e.printStackTrace();
        }
    }

    public final void x(rcb rcbVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, rcbVar) == null) || rcbVar == null || fgb.e(rcbVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < rcbVar.c().size(); i++) {
            arrayList.add(new tcb(new ArrayList()));
        }
        rcb rcbVar2 = new rcb(arrayList);
        this.d = rcbVar2;
        rcbVar2.e(rcbVar.b());
        this.d.d(rcbVar.a());
    }

    public final void y(rcb rcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rcbVar) == null) {
            this.i = 0;
            this.j = 0;
            List<tcb> c = rcbVar.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
