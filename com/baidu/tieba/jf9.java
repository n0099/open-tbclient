package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lf9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class jf9 implements lf9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public if9 a;
    public b b;
    public Thread c;
    public List<lf9> d;
    public int e;
    public int f;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jf9 a;

        public a(jf9 jf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jf9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jf9 jf9Var = this.a;
                if (jf9Var.j(jf9Var.a)) {
                    if (wi9.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((lf9) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                jf9 jf9Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                jf9Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(hf9 hf9Var);
    }

    public jf9(if9 if9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {if9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = if9Var;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.lf9.a
    public void a(lf9 lf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lf9Var) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.lf9.a
    public void b(lf9 lf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lf9Var) == null) {
            int k = this.e + lf9Var.k();
            this.e = k;
            n(k);
            if (lf9Var == null || !lf9Var.m()) {
                return;
            }
            hf9 k2 = k(lf9Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.lf9.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.lf9.a
    public void d(String str, lf9 lf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, lf9Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!wi9.e(this.d)) {
                for (lf9 lf9Var : this.d) {
                    lf9Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(if9 if9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, if9Var)) == null) {
            if (if9Var == null || wi9.e(if9Var.c())) {
                return false;
            }
            List<kf9> c = if9Var.c();
            hf9 hf9Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (qf9.o(c.get(i2).b())) {
                    z = true;
                }
                if (!wi9.e(c.get(i2).a())) {
                    for (gf9 gf9Var : c.get(i2).a()) {
                        if (gf9Var != null) {
                            if (gf9Var.c()) {
                                if (hf9Var == null) {
                                    hf9Var = gf9Var.a();
                                }
                                if (hf9Var != null) {
                                    int k = hf9Var.k(gf9Var.a());
                                    z2 = ((hf9.g & k) == 0 && (hf9.i & k) == 0 && (k & hf9.h) == 0) ? false : true;
                                }
                                if (gf9Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(gf9Var.a().f())) {
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
                nf9 nf9Var = new nf9();
                nf9Var.c(z2 ? 50 : 90);
                nf9Var.e(this);
                this.d.add(nf9Var);
                mf9 mf9Var = new mf9();
                mf9Var.c(z2 ? 50 : 10);
                mf9Var.e(this);
                this.d.add(mf9Var);
                nf9Var.f(mf9Var);
            } else {
                mf9 mf9Var2 = new mf9();
                mf9Var2.c(100);
                mf9Var2.e(this);
                this.d.add(mf9Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final hf9 k(if9 if9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, if9Var)) == null) {
            if (if9Var != null && wi9.b(if9Var.c()) == 1 && wi9.b(if9Var.c().get(0).a()) == 1) {
                gf9 gf9Var = if9Var.c().get(0).a().get(0);
                if (gf9Var.b() == null || gf9Var.b().isNeedEdit() || !gf9Var.c()) {
                    return null;
                }
                return gf9Var.a();
            }
            return null;
        }
        return (hf9) invokeL.objValue;
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

    public final void o(hf9 hf9Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, hf9Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(hf9Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || wi9.e(this.d)) {
            return;
        }
        for (lf9 lf9Var : this.d) {
            lf9Var.h();
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
            hf9 k = k(this.a);
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
