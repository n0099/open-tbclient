package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ntb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ltb implements ntb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ktb a;
    public b b;
    public Thread c;
    public List<ntb> d;
    public int e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ltb a;

        public a(ltb ltbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ltbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ltbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ltb ltbVar = this.a;
                if (ltbVar.j(ltbVar.a)) {
                    if (ywb.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((ntb) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                ltb ltbVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                ltbVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(jtb jtbVar);
    }

    public ltb(ktb ktbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ktbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ktbVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.ntb.a
    public void a(ntb ntbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ntbVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.ntb.a
    public void b(ntb ntbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ntbVar) == null) {
            int k = this.e + ntbVar.k();
            this.e = k;
            n(k);
            if (ntbVar == null || !ntbVar.m()) {
                return;
            }
            jtb k2 = k(ntbVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.ntb.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.ntb.a
    public void d(String str, ntb ntbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ntbVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!ywb.e(this.d)) {
                for (ntb ntbVar : this.d) {
                    ntbVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(ktb ktbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ktbVar)) == null) {
            if (ktbVar == null || ywb.e(ktbVar.c())) {
                return false;
            }
            List<mtb> c = ktbVar.c();
            jtb jtbVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (stb.o(c.get(i2).b())) {
                    z = true;
                }
                if (!ywb.e(c.get(i2).a())) {
                    for (itb itbVar : c.get(i2).a()) {
                        if (itbVar != null) {
                            if (itbVar.c()) {
                                if (jtbVar == null) {
                                    jtbVar = itbVar.a();
                                }
                                if (jtbVar != null) {
                                    int k = jtbVar.k(itbVar.a());
                                    z2 = ((jtb.g & k) == 0 && (jtb.i & k) == 0 && (k & jtb.h) == 0) ? false : true;
                                }
                                if (itbVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(itbVar.a().f())) {
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
                ptb ptbVar = new ptb();
                ptbVar.c(z2 ? 50 : 90);
                ptbVar.e(this);
                this.d.add(ptbVar);
                otb otbVar = new otb();
                otbVar.c(z2 ? 50 : 10);
                otbVar.e(this);
                this.d.add(otbVar);
                ptbVar.f(otbVar);
            } else {
                otb otbVar2 = new otb();
                otbVar2.c(100);
                otbVar2.e(this);
                this.d.add(otbVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final jtb k(ktb ktbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ktbVar)) == null) {
            if (ktbVar != null && ywb.b(ktbVar.c()) == 1 && ywb.b(ktbVar.c().get(0).a()) == 1) {
                itb itbVar = ktbVar.c().get(0).a().get(0);
                if (itbVar.b() == null || itbVar.b().isNeedEdit() || !itbVar.c()) {
                    return null;
                }
                return itbVar.a();
            }
            return null;
        }
        return (jtb) invokeL.objValue;
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

    public final void o(jtb jtbVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, jtbVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(jtbVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || ywb.e(this.d)) {
            return;
        }
        for (ntb ntbVar : this.d) {
            ntbVar.h();
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
            jtb k = k(this.a);
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
