package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wf9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class uf9 implements wf9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tf9 a;
    public b b;
    public Thread c;
    public List<wf9> d;
    public int e;
    public int f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uf9 a;

        public a(uf9 uf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uf9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uf9 uf9Var = this.a;
                if (uf9Var.j(uf9Var.a)) {
                    if (hj9.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((wf9) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                uf9 uf9Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                uf9Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(sf9 sf9Var);
    }

    public uf9(tf9 tf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tf9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tf9Var;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.wf9.a
    public void a(wf9 wf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wf9Var) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.wf9.a
    public void b(wf9 wf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wf9Var) == null) {
            int k = this.e + wf9Var.k();
            this.e = k;
            n(k);
            if (wf9Var == null || !wf9Var.m()) {
                return;
            }
            sf9 k2 = k(wf9Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.wf9.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.wf9.a
    public void d(String str, wf9 wf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wf9Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!hj9.e(this.d)) {
                for (wf9 wf9Var : this.d) {
                    wf9Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(tf9 tf9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tf9Var)) == null) {
            if (tf9Var == null || hj9.e(tf9Var.c())) {
                return false;
            }
            List<vf9> c = tf9Var.c();
            sf9 sf9Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (bg9.o(c.get(i2).b())) {
                    z = true;
                }
                if (!hj9.e(c.get(i2).a())) {
                    for (rf9 rf9Var : c.get(i2).a()) {
                        if (rf9Var != null) {
                            if (rf9Var.c()) {
                                if (sf9Var == null) {
                                    sf9Var = rf9Var.a();
                                }
                                if (sf9Var != null) {
                                    int k = sf9Var.k(rf9Var.a());
                                    z2 = ((sf9.g & k) == 0 && (sf9.i & k) == 0 && (k & sf9.h) == 0) ? false : true;
                                }
                                if (rf9Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(rf9Var.a().f())) {
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
                yf9 yf9Var = new yf9();
                yf9Var.c(z2 ? 50 : 90);
                yf9Var.e(this);
                this.d.add(yf9Var);
                xf9 xf9Var = new xf9();
                xf9Var.c(z2 ? 50 : 10);
                xf9Var.e(this);
                this.d.add(xf9Var);
                yf9Var.f(xf9Var);
            } else {
                xf9 xf9Var2 = new xf9();
                xf9Var2.c(100);
                xf9Var2.e(this);
                this.d.add(xf9Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final sf9 k(tf9 tf9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tf9Var)) == null) {
            if (tf9Var != null && hj9.b(tf9Var.c()) == 1 && hj9.b(tf9Var.c().get(0).a()) == 1) {
                rf9 rf9Var = tf9Var.c().get(0).a().get(0);
                if (rf9Var.b() == null || rf9Var.b().isNeedEdit() || !rf9Var.c()) {
                    return null;
                }
                return rf9Var.a();
            }
            return null;
        }
        return (sf9) invokeL.objValue;
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

    public final void o(sf9 sf9Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, sf9Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(sf9Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || hj9.e(this.d)) {
            return;
        }
        for (wf9 wf9Var : this.d) {
            wf9Var.h();
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
            sf9 k = k(this.a);
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
