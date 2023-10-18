package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pbb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class nbb implements pbb.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mbb a;
    public b b;
    public Thread c;
    public List<pbb> d;
    public int e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nbb a;

        public a(nbb nbbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nbbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nbbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nbb nbbVar = this.a;
                if (nbbVar.j(nbbVar.a)) {
                    if (afb.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((pbb) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                nbb nbbVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                nbbVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(lbb lbbVar);
    }

    public nbb(mbb mbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mbbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mbbVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.pbb.a
    public void a(pbb pbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbbVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.pbb.a
    public void b(pbb pbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbbVar) == null) {
            int k = this.e + pbbVar.k();
            this.e = k;
            n(k);
            if (pbbVar == null || !pbbVar.m()) {
                return;
            }
            lbb k2 = k(pbbVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.pbb.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.pbb.a
    public void d(String str, pbb pbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, pbbVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!afb.e(this.d)) {
                for (pbb pbbVar : this.d) {
                    pbbVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(mbb mbbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mbbVar)) == null) {
            if (mbbVar == null || afb.e(mbbVar.c())) {
                return false;
            }
            List<obb> c = mbbVar.c();
            lbb lbbVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (ubb.o(c.get(i2).b())) {
                    z = true;
                }
                if (!afb.e(c.get(i2).a())) {
                    for (kbb kbbVar : c.get(i2).a()) {
                        if (kbbVar != null) {
                            if (kbbVar.c()) {
                                if (lbbVar == null) {
                                    lbbVar = kbbVar.a();
                                }
                                if (lbbVar != null) {
                                    int k = lbbVar.k(kbbVar.a());
                                    z2 = ((lbb.g & k) == 0 && (lbb.i & k) == 0 && (k & lbb.h) == 0) ? false : true;
                                }
                                if (kbbVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(kbbVar.a().f())) {
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
                rbb rbbVar = new rbb();
                rbbVar.c(z2 ? 50 : 90);
                rbbVar.e(this);
                this.d.add(rbbVar);
                qbb qbbVar = new qbb();
                qbbVar.c(z2 ? 50 : 10);
                qbbVar.e(this);
                this.d.add(qbbVar);
                rbbVar.f(qbbVar);
            } else {
                qbb qbbVar2 = new qbb();
                qbbVar2.c(100);
                qbbVar2.e(this);
                this.d.add(qbbVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final lbb k(mbb mbbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mbbVar)) == null) {
            if (mbbVar != null && afb.b(mbbVar.c()) == 1 && afb.b(mbbVar.c().get(0).a()) == 1) {
                kbb kbbVar = mbbVar.c().get(0).a().get(0);
                if (kbbVar.b() == null || kbbVar.b().isNeedEdit() || !kbbVar.c()) {
                    return null;
                }
                return kbbVar.a();
            }
            return null;
        }
        return (lbb) invokeL.objValue;
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

    public final void o(lbb lbbVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, lbbVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(lbbVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || afb.e(this.d)) {
            return;
        }
        for (pbb pbbVar : this.d) {
            pbbVar.h();
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
            lbb k = k(this.a);
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
