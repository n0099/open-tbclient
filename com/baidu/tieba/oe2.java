package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.ce2;
import com.baidu.tieba.kcc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class oe2 extends ke2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public qcc<? super dk4> c;
    public qcc<? super bk4> d;
    public oo4 e;
    public zp3<Exception> f;
    public xi4<dk4> g;
    public xi4<bk4> h;
    public qcc<ek4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract zm3 b0(bk4 bk4Var);

    public abstract zm3 c0(dk4 dk4Var);

    /* loaded from: classes7.dex */
    public class a extends ui4<dk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe2 a;

        public a(oe2 oe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi4
        /* renamed from: l */
        public String d(dk4 dk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dk4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void c(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dk4Var) == null) {
                super.c(dk4Var);
                g82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: r */
        public void f(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dk4Var) == null) {
                super.f(dk4Var);
                if (oe2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(dk4Var);
            }
        }

        @Override // com.baidu.tieba.zi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: o */
        public void e(dk4 dk4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, dk4Var, ak4Var) == null) {
                super.e(dk4Var, ak4Var);
                g82.k("UpdateCoreCallback", "onDownloadError:" + ak4Var);
                this.a.e.l(dk4Var);
                zm3 zm3Var = new zm3();
                zm3Var.k(13L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("Framework包下载失败");
                zm3Var.f(ak4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(dk4Var, zm3Var));
                }
                ce2.c().a(dk4Var, this.a.V(), zm3Var);
                kr4.k(dk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: p */
        public void i(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dk4Var) == null) {
                super.i(dk4Var);
                g82.k("UpdateCoreCallback", "onFileDownloaded: " + dk4Var.i);
                zm3 c0 = this.a.c0(dk4Var);
                if (c0 == null) {
                    this.a.e.m(dk4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(dk4Var);
                        this.a.c.onCompleted();
                    }
                    dj4.i().m(dk4Var);
                    ce2.c().b(dk4Var, this.a.V());
                    hp3.a();
                    return;
                }
                this.a.e.l(dk4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(dk4Var, c0));
                }
                ce2.c().a(dk4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ui4<bk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe2 a;

        public b(oe2 oe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi4
        /* renamed from: l */
        public String d(bk4 bk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bk4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void c(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bk4Var) == null) {
                super.c(bk4Var);
                g82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: r */
        public void f(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bk4Var) == null) {
                super.f(bk4Var);
                if (oe2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(bk4Var);
            }
        }

        @Override // com.baidu.tieba.zi4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: o */
        public void e(bk4 bk4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bk4Var, ak4Var) == null) {
                super.e(bk4Var, ak4Var);
                g82.k("UpdateCoreCallback", "onDownloadError:" + ak4Var);
                this.a.e.l(bk4Var);
                zm3 zm3Var = new zm3();
                zm3Var.k(14L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("Extension下载失败");
                zm3Var.f(ak4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bk4Var, zm3Var));
                }
                ce2.c().a(bk4Var, this.a.V(), zm3Var);
                kr4.k(bk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: p */
        public void i(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bk4Var) == null) {
                super.i(bk4Var);
                g82.k("UpdateCoreCallback", "onFileDownloaded: " + bk4Var.i);
                zm3 b0 = this.a.b0(bk4Var);
                if (b0 == null) {
                    this.a.e.m(bk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(bk4Var);
                        this.a.d.onCompleted();
                    }
                    dj4.i().m(bk4Var);
                    ce2.c().b(bk4Var, this.a.V());
                    return;
                }
                this.a.e.l(bk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bk4Var, b0));
                }
                ce2.c().a(bk4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk4 a;
        public final /* synthetic */ oe2 b;

        public c(oe2 oe2Var, dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe2Var, dk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oe2Var;
            this.a = dk4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, zm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.e.m(this.a);
                if (this.b.c != null) {
                    this.b.c.onNext(this.a);
                    this.b.c.onCompleted();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk4 a;
        public final /* synthetic */ oe2 b;

        public d(oe2 oe2Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe2Var, bk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oe2Var;
            this.a = bk4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, zm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.e.m(this.a);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements kcc.a<dk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe2 a;

        public e(oe2 oe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super dk4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.c = qccVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements kcc.a<bk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe2 a;

        public f(oe2 oe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kcc.a, com.baidu.tieba.ycc
        public void call(qcc<? super bk4> qccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, qccVar) != null) {
                return;
            }
            this.a.d = qccVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends qcc<ek4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe2 e;

        public g(oe2 oe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lcc
        /* renamed from: g */
        public void onNext(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ek4Var) == null) {
                g82.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + ek4Var.i);
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                g82.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.lcc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g82.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029293, "Lcom/baidu/tieba/oe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029293, "Lcom/baidu/tieba/oe2;");
                return;
            }
        }
        j = qr1.a;
    }

    @Override // com.baidu.tieba.bj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.bj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            g82.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final qcc<ek4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (qcc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<bk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<dk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (xi4) invokeV.objValue;
    }

    public oe2(zp3<Exception> zp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zp3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = zp3Var;
    }

    @Override // com.baidu.tieba.bj4
    public void G(oo4 oo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oo4Var) == null) {
            super.G(oo4Var);
            if (oo4Var == null) {
                return;
            }
            this.e = oo4Var;
            if (!oo4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            g82.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            zp3<Exception> zp3Var = this.f;
            if (zp3Var != null) {
                zp3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            g82.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            ho4.d(U(), 0L);
            dv3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bk4Var) == null) {
            ce2.c().d(bk4Var, new d(this, bk4Var));
        }
    }

    public final void g0(dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dk4Var) == null) {
            ce2.c().d(dk4Var, new c(this, dk4Var));
        }
    }

    @Override // com.baidu.tieba.bj4
    public void C(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ak4Var) == null) {
            super.C(ak4Var);
            g82.k("UpdateCoreCallback", "onFetchError: " + ak4Var.toString());
            if (ak4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + ak4Var, ak4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(kcc.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(kcc.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                kcc.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            g82.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            ho4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
