package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.scb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qcb implements scb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pcb a;
    public b b;
    public Thread c;
    public List<scb> d;
    public int e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qcb a;

        public a(qcb qcbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qcbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qcbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qcb qcbVar = this.a;
                if (qcbVar.j(qcbVar.a)) {
                    if (dgb.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((scb) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                qcb qcbVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                qcbVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(ocb ocbVar);
    }

    public qcb(pcb pcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pcbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pcbVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.scb.a
    public void a(scb scbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, scbVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.scb.a
    public void b(scb scbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scbVar) == null) {
            int k = this.e + scbVar.k();
            this.e = k;
            n(k);
            if (scbVar == null || !scbVar.m()) {
                return;
            }
            ocb k2 = k(scbVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.scb.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.scb.a
    public void d(String str, scb scbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, scbVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!dgb.e(this.d)) {
                for (scb scbVar : this.d) {
                    scbVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(pcb pcbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pcbVar)) == null) {
            if (pcbVar == null || dgb.e(pcbVar.c())) {
                return false;
            }
            List<rcb> c = pcbVar.c();
            ocb ocbVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (xcb.o(c.get(i2).b())) {
                    z = true;
                }
                if (!dgb.e(c.get(i2).a())) {
                    for (ncb ncbVar : c.get(i2).a()) {
                        if (ncbVar != null) {
                            if (ncbVar.c()) {
                                if (ocbVar == null) {
                                    ocbVar = ncbVar.a();
                                }
                                if (ocbVar != null) {
                                    int k = ocbVar.k(ncbVar.a());
                                    z2 = ((ocb.g & k) == 0 && (ocb.i & k) == 0 && (k & ocb.h) == 0) ? false : true;
                                }
                                if (ncbVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(ncbVar.a().f())) {
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
                ucb ucbVar = new ucb();
                ucbVar.c(z2 ? 50 : 90);
                ucbVar.e(this);
                this.d.add(ucbVar);
                tcb tcbVar = new tcb();
                tcbVar.c(z2 ? 50 : 10);
                tcbVar.e(this);
                this.d.add(tcbVar);
                ucbVar.f(tcbVar);
            } else {
                tcb tcbVar2 = new tcb();
                tcbVar2.c(100);
                tcbVar2.e(this);
                this.d.add(tcbVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final ocb k(pcb pcbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pcbVar)) == null) {
            if (pcbVar != null && dgb.b(pcbVar.c()) == 1 && dgb.b(pcbVar.c().get(0).a()) == 1) {
                ncb ncbVar = pcbVar.c().get(0).a().get(0);
                if (ncbVar.b() == null || ncbVar.b().isNeedEdit() || !ncbVar.c()) {
                    return null;
                }
                return ncbVar.a();
            }
            return null;
        }
        return (ocb) invokeL.objValue;
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

    public final void o(ocb ocbVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, ocbVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(ocbVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || dgb.e(this.d)) {
            return;
        }
        for (scb scbVar : this.d) {
            scbVar.h();
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
            ocb k = k(this.a);
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
