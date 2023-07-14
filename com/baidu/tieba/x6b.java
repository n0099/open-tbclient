package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.z6b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class x6b implements z6b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w6b a;
    public b b;
    public Thread c;
    public List<z6b> d;
    public int e;
    public int f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x6b a;

        public a(x6b x6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x6bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x6b x6bVar = this.a;
                if (x6bVar.j(x6bVar.a)) {
                    if (kab.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((z6b) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                x6b x6bVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                x6bVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(v6b v6bVar);
    }

    public x6b(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w6bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = w6bVar;
        this.d = new ArrayList();
    }

    @Override // com.baidu.tieba.z6b.a
    public void a(z6b z6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z6bVar) == null) {
            l();
        }
    }

    @Override // com.baidu.tieba.z6b.a
    public void b(z6b z6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z6bVar) == null) {
            int k = this.e + z6bVar.k();
            this.e = k;
            n(k);
            if (z6bVar == null || !z6bVar.m()) {
                return;
            }
            v6b k2 = k(z6bVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.baidu.tieba.z6b.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.baidu.tieba.z6b.a
    public void d(String str, z6b z6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, z6bVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!kab.e(this.d)) {
                for (z6b z6bVar : this.d) {
                    z6bVar.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(w6b w6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, w6bVar)) == null) {
            if (w6bVar == null || kab.e(w6bVar.c())) {
                return false;
            }
            List<y6b> c = w6bVar.c();
            v6b v6bVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (e7b.o(c.get(i2).b())) {
                    z = true;
                }
                if (!kab.e(c.get(i2).a())) {
                    for (u6b u6bVar : c.get(i2).a()) {
                        if (u6bVar != null) {
                            if (u6bVar.c()) {
                                if (v6bVar == null) {
                                    v6bVar = u6bVar.a();
                                }
                                if (v6bVar != null) {
                                    int k = v6bVar.k(u6bVar.a());
                                    z2 = ((v6b.g & k) == 0 && (v6b.i & k) == 0 && (k & v6b.h) == 0) ? false : true;
                                }
                                if (u6bVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(u6bVar.a().f())) {
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
                b7b b7bVar = new b7b();
                b7bVar.c(z2 ? 50 : 90);
                b7bVar.e(this);
                this.d.add(b7bVar);
                a7b a7bVar = new a7b();
                a7bVar.c(z2 ? 50 : 10);
                a7bVar.e(this);
                this.d.add(a7bVar);
                b7bVar.f(a7bVar);
            } else {
                a7b a7bVar2 = new a7b();
                a7bVar2.c(100);
                a7bVar2.e(this);
                this.d.add(a7bVar2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final v6b k(w6b w6bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, w6bVar)) == null) {
            if (w6bVar != null && kab.b(w6bVar.c()) == 1 && kab.b(w6bVar.c().get(0).a()) == 1) {
                u6b u6bVar = w6bVar.c().get(0).a().get(0);
                if (u6bVar.b() == null || u6bVar.b().isNeedEdit() || !u6bVar.c()) {
                    return null;
                }
                return u6bVar.a();
            }
            return null;
        }
        return (v6b) invokeL.objValue;
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

    public final void o(v6b v6bVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, v6bVar) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(v6bVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || kab.e(this.d)) {
            return;
        }
        for (z6b z6bVar : this.d) {
            z6bVar.h();
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
            v6b k = k(this.a);
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
