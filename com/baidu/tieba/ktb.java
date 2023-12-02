package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.mtb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ktb implements mtb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jtb a;
    public b b;
    public Thread c;
    public List<mtb> d;
    public int e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ktb a;

        public a(ktb ktbVar) {
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
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ktb ktbVar = this.a;
                if (ktbVar.j(ktbVar.a)) {
                    if (xwb.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((mtb) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                ktb ktbVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                ktbVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(itb itbVar);
    }

    public ktb(jtb jtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jtbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jtbVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.mtb.a
    public void a(mtb mtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mtbVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.mtb.a
    public void b(mtb mtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mtbVar) == null) {
            int k = this.e + mtbVar.k();
            this.e = k;
            n(k);
            if (mtbVar == null || !mtbVar.m()) {
                return;
            }
            itb k2 = k(mtbVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.mtb.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.mtb.a
    public void d(String str, mtb mtbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, mtbVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!xwb.e(this.d)) {
                for (mtb mtbVar : this.d) {
                    mtbVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(jtb jtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jtbVar)) == null) {
            if (jtbVar == null || xwb.e(jtbVar.c())) {
                return false;
            }
            List<ltb> c = jtbVar.c();
            itb itbVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (rtb.o(c.get(i2).b())) {
                    z = true;
                }
                if (!xwb.e(c.get(i2).a())) {
                    for (htb htbVar : c.get(i2).a()) {
                        if (htbVar != null) {
                            if (htbVar.c()) {
                                if (itbVar == null) {
                                    itbVar = htbVar.a();
                                }
                                if (itbVar != null) {
                                    int k = itbVar.k(htbVar.a());
                                    z2 = ((itb.g & k) == 0 && (itb.i & k) == 0 && (k & itb.h) == 0) ? false : true;
                                }
                                if (htbVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(htbVar.a().f())) {
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
                otb otbVar = new otb();
                otbVar.c(z2 ? 50 : 90);
                otbVar.e(this);
                this.d.add(otbVar);
                ntb ntbVar = new ntb();
                ntbVar.c(z2 ? 50 : 10);
                ntbVar.e(this);
                this.d.add(ntbVar);
                otbVar.f(ntbVar);
            } else {
                ntb ntbVar2 = new ntb();
                ntbVar2.c(100);
                ntbVar2.e(this);
                this.d.add(ntbVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final itb k(jtb jtbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jtbVar)) == null) {
            if (jtbVar != null && xwb.b(jtbVar.c()) == 1 && xwb.b(jtbVar.c().get(0).a()) == 1) {
                htb htbVar = jtbVar.c().get(0).a().get(0);
                if (htbVar.b() == null || htbVar.b().isNeedEdit() || !htbVar.c()) {
                    return null;
                }
                return htbVar.a();
            }
            return null;
        }
        return (itb) invokeL.objValue;
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

    public final void o(itb itbVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, itbVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(itbVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || xwb.e(this.d)) {
            return;
        }
        for (mtb mtbVar : this.d) {
            mtbVar.h();
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
            itb k = k(this.a);
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
