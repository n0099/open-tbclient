package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ucb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class scb implements ucb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rcb a;
    public b b;
    public Thread c;
    public List<ucb> d;
    public int e;
    public int f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ scb a;

        public a(scb scbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                scb scbVar = this.a;
                if (scbVar.j(scbVar.a)) {
                    if (fgb.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((ucb) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                scb scbVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                scbVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(qcb qcbVar);
    }

    public scb(rcb rcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rcbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = rcbVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.ucb.a
    public void a(ucb ucbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ucbVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.ucb.a
    public void b(ucb ucbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ucbVar) == null) {
            int k = this.e + ucbVar.k();
            this.e = k;
            n(k);
            if (ucbVar == null || !ucbVar.m()) {
                return;
            }
            qcb k2 = k(ucbVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.ucb.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.ucb.a
    public void d(String str, ucb ucbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ucbVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!fgb.e(this.d)) {
                for (ucb ucbVar : this.d) {
                    ucbVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(rcb rcbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rcbVar)) == null) {
            if (rcbVar == null || fgb.e(rcbVar.c())) {
                return false;
            }
            List<tcb> c = rcbVar.c();
            qcb qcbVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (zcb.o(c.get(i2).b())) {
                    z = true;
                }
                if (!fgb.e(c.get(i2).a())) {
                    for (pcb pcbVar : c.get(i2).a()) {
                        if (pcbVar != null) {
                            if (pcbVar.c()) {
                                if (qcbVar == null) {
                                    qcbVar = pcbVar.a();
                                }
                                if (qcbVar != null) {
                                    int k = qcbVar.k(pcbVar.a());
                                    z2 = ((qcb.g & k) == 0 && (qcb.i & k) == 0 && (k & qcb.h) == 0) ? false : true;
                                }
                                if (pcbVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(pcbVar.a().f())) {
                                    z = true;
                                }
                                z3 = true;
                            }
                            i++;
                            if (i > 1) {
                                z2 = true;
                            }
                            if (z2 && z && z3) {
                                break;
                            }
                        }
                    }
                }
                if (z2 && z && z3) {
                    break;
                }
            }
            if (z) {
                wcb wcbVar = new wcb();
                wcbVar.c(z2 ? 50 : 90);
                wcbVar.e(this);
                this.d.add(wcbVar);
                vcb vcbVar = new vcb();
                vcbVar.c(z2 ? 50 : 10);
                vcbVar.e(this);
                this.d.add(vcbVar);
                wcbVar.f(vcbVar);
            } else {
                vcb vcbVar2 = new vcb();
                vcbVar2.c(100);
                vcbVar2.e(this);
                this.d.add(vcbVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final qcb k(rcb rcbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rcbVar)) == null) {
            if (rcbVar != null && fgb.b(rcbVar.c()) == 1 && fgb.b(rcbVar.c().get(0).a()) == 1) {
                pcb pcbVar = rcbVar.c().get(0).a().get(0);
                if (pcbVar.b() == null || pcbVar.b().isNeedEdit() || !pcbVar.c()) {
                    return null;
                }
                return pcbVar.a();
            }
            return null;
        }
        return (qcb) invokeL.objValue;
    }

    public final void l() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureCancel();
    }

    public final void m(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureFail(str);
    }

    public final void n(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(i);
    }

    public final void o(qcb qcbVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, qcbVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(qcbVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || fgb.e(this.d)) {
            return;
        }
        for (ucb ucbVar : this.d) {
            ucbVar.h();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.clear();
            this.e = 0;
            this.f = 0;
            qcb k = k(this.a);
            if (k != null && k.i()) {
                o(k);
                return;
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
                this.c = null;
            }
            Thread thread2 = new Thread(new a(this));
            this.c = thread2;
            thread2.start();
        }
    }
}
