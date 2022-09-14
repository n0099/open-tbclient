package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class tc9 implements vc9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sc9 a;
    public b b;
    public Thread c;
    public List<vc9> d;
    public int e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tc9 a;

        public a(tc9 tc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tc9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tc9 tc9Var = this.a;
                if (tc9Var.j(tc9Var.a)) {
                    if (gg9.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((vc9) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                tc9 tc9Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                tc9Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(rc9 rc9Var);
    }

    public tc9(sc9 sc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sc9Var;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.vc9.a
    public void a(vc9 vc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vc9Var) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.vc9.a
    public void b(vc9 vc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vc9Var) == null) {
            int k = this.e + vc9Var.k();
            this.e = k;
            n(k);
            if (vc9Var == null || !vc9Var.m()) {
                return;
            }
            rc9 k2 = k(vc9Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.vc9.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.vc9.a
    public void d(String str, vc9 vc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, vc9Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!gg9.e(this.d)) {
                for (vc9 vc9Var : this.d) {
                    vc9Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(sc9 sc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sc9Var)) == null) {
            if (sc9Var == null || gg9.e(sc9Var.c())) {
                return false;
            }
            List<uc9> c = sc9Var.c();
            rc9 rc9Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (ad9.o(c.get(i2).b())) {
                    z = true;
                }
                if (!gg9.e(c.get(i2).a())) {
                    for (qc9 qc9Var : c.get(i2).a()) {
                        if (qc9Var != null) {
                            if (qc9Var.c()) {
                                if (rc9Var == null) {
                                    rc9Var = qc9Var.a();
                                }
                                if (rc9Var != null) {
                                    int k = rc9Var.k(qc9Var.a());
                                    z2 = ((rc9.g & k) == 0 && (rc9.i & k) == 0 && (k & rc9.h) == 0) ? false : true;
                                }
                                if (qc9Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(qc9Var.a().f())) {
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
                xc9 xc9Var = new xc9();
                xc9Var.c(z2 ? 50 : 90);
                xc9Var.e(this);
                this.d.add(xc9Var);
                wc9 wc9Var = new wc9();
                wc9Var.c(z2 ? 50 : 10);
                wc9Var.e(this);
                this.d.add(wc9Var);
                xc9Var.f(wc9Var);
            } else {
                wc9 wc9Var2 = new wc9();
                wc9Var2.c(100);
                wc9Var2.e(this);
                this.d.add(wc9Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final rc9 k(sc9 sc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sc9Var)) == null) {
            if (sc9Var != null && gg9.b(sc9Var.c()) == 1 && gg9.b(sc9Var.c().get(0).a()) == 1) {
                qc9 qc9Var = sc9Var.c().get(0).a().get(0);
                if (qc9Var.b() == null || qc9Var.b().isNeedEdit() || !qc9Var.c()) {
                    return null;
                }
                return qc9Var.a();
            }
            return null;
        }
        return (rc9) invokeL.objValue;
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

    public final void o(rc9 rc9Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, rc9Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(rc9Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || gg9.e(this.d)) {
            return;
        }
        for (vc9 vc9Var : this.d) {
            vc9Var.h();
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
            rc9 k = k(this.a);
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
