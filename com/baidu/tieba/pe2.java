package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.de2;
import com.baidu.tieba.sac;
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
public abstract class pe2 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public yac<? super ek4> c;
    public yac<? super ck4> d;
    public po4 e;
    public aq3<Exception> f;
    public yi4<ek4> g;
    public yi4<ck4> h;
    public yac<fk4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract an3 b0(ck4 ck4Var);

    public abstract an3 c0(ek4 ek4Var);

    /* loaded from: classes7.dex */
    public class a extends vi4<ek4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe2 a;

        public a(pe2 pe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(ek4 ek4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ek4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void c(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ek4Var) == null) {
                super.c(ek4Var);
                h82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void f(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ek4Var) == null) {
                super.f(ek4Var);
                if (pe2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(ek4Var);
            }
        }

        @Override // com.baidu.tieba.aj4
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
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(ek4 ek4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ek4Var, bk4Var) == null) {
                super.e(ek4Var, bk4Var);
                h82.k("UpdateCoreCallback", "onDownloadError:" + bk4Var);
                this.a.e.l(ek4Var);
                an3 an3Var = new an3();
                an3Var.k(13L);
                an3Var.i(bk4Var.a);
                an3Var.d("Framework包下载失败");
                an3Var.f(bk4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ek4Var, an3Var));
                }
                de2.c().a(ek4Var, this.a.V(), an3Var);
                lr4.k(ek4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ek4Var) == null) {
                super.i(ek4Var);
                h82.k("UpdateCoreCallback", "onFileDownloaded: " + ek4Var.i);
                an3 c0 = this.a.c0(ek4Var);
                if (c0 == null) {
                    this.a.e.m(ek4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(ek4Var);
                        this.a.c.onCompleted();
                    }
                    ej4.i().m(ek4Var);
                    de2.c().b(ek4Var, this.a.V());
                    ip3.a();
                    return;
                }
                this.a.e.l(ek4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ek4Var, c0));
                }
                de2.c().a(ek4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends vi4<ck4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe2 a;

        public b(pe2 pe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(ck4 ck4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ck4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void c(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ck4Var) == null) {
                super.c(ck4Var);
                h82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void f(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ck4Var) == null) {
                super.f(ck4Var);
                if (pe2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(ck4Var);
            }
        }

        @Override // com.baidu.tieba.aj4
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
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(ck4 ck4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ck4Var, bk4Var) == null) {
                super.e(ck4Var, bk4Var);
                h82.k("UpdateCoreCallback", "onDownloadError:" + bk4Var);
                this.a.e.l(ck4Var);
                an3 an3Var = new an3();
                an3Var.k(14L);
                an3Var.i(bk4Var.a);
                an3Var.d("Extension下载失败");
                an3Var.f(bk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ck4Var, an3Var));
                }
                de2.c().a(ck4Var, this.a.V(), an3Var);
                lr4.k(ck4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ck4Var) == null) {
                super.i(ck4Var);
                h82.k("UpdateCoreCallback", "onFileDownloaded: " + ck4Var.i);
                an3 b0 = this.a.b0(ck4Var);
                if (b0 == null) {
                    this.a.e.m(ck4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(ck4Var);
                        this.a.d.onCompleted();
                    }
                    ej4.i().m(ck4Var);
                    de2.c().b(ck4Var, this.a.V());
                    return;
                }
                this.a.e.l(ck4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ck4Var, b0));
                }
                de2.c().a(ck4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek4 a;
        public final /* synthetic */ pe2 b;

        public c(pe2 pe2Var, ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe2Var, ek4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pe2Var;
            this.a = ek4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, an3Var));
                }
            }
        }

        @Override // com.baidu.tieba.de2.c
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
    public class d implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck4 a;
        public final /* synthetic */ pe2 b;

        public d(pe2 pe2Var, ck4 ck4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe2Var, ck4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pe2Var;
            this.a = ck4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, an3Var));
                }
            }
        }

        @Override // com.baidu.tieba.de2.c
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
    public class e implements sac.a<ek4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe2 a;

        public e(pe2 pe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super ek4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.c = yacVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements sac.a<ck4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe2 a;

        public f(pe2 pe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
        public void call(yac<? super ck4> yacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, yacVar) != null) {
                return;
            }
            this.a.d = yacVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends yac<fk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe2 e;

        public g(pe2 pe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = pe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tac
        /* renamed from: g */
        public void onNext(fk4 fk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fk4Var) == null) {
                h82.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + fk4Var.i);
            }
        }

        @Override // com.baidu.tieba.tac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                h82.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.tac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h82.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948059084, "Lcom/baidu/tieba/pe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948059084, "Lcom/baidu/tieba/pe2;");
                return;
            }
        }
        j = rr1.a;
    }

    @Override // com.baidu.tieba.cj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.cj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            h82.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final yac<fk4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (yac) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ck4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ek4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (yi4) invokeV.objValue;
    }

    public pe2(aq3<Exception> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aq3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = aq3Var;
    }

    @Override // com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, po4Var) == null) {
            super.G(po4Var);
            if (po4Var == null) {
                return;
            }
            this.e = po4Var;
            if (!po4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            h82.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            aq3<Exception> aq3Var = this.f;
            if (aq3Var != null) {
                aq3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            h82.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            io4.d(U(), 0L);
            ev3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(ck4 ck4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ck4Var) == null) {
            de2.c().d(ck4Var, new d(this, ck4Var));
        }
    }

    public final void g0(ek4 ek4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ek4Var) == null) {
            de2.c().d(ek4Var, new c(this, ek4Var));
        }
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
            super.C(bk4Var);
            h82.k("UpdateCoreCallback", "onFetchError: " + bk4Var.toString());
            if (bk4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + bk4Var, bk4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(sac.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(sac.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                sac.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            h82.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            io4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
