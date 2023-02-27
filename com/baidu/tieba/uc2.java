package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.ic2;
import com.baidu.tieba.sma;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class uc2 extends qc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public yma<? super ji4> c;
    public yma<? super hi4> d;
    public um4 e;
    public fo3<Exception> f;
    public dh4<ji4> g;
    public dh4<hi4> h;
    public yma<ki4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract fl3 b0(hi4 hi4Var);

    public abstract fl3 c0(ji4 ji4Var);

    /* loaded from: classes6.dex */
    public class a extends ah4<ji4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc2 a;

        public a(uc2 uc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dh4
        /* renamed from: l */
        public String d(ji4 ji4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ji4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: q */
        public void c(ji4 ji4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ji4Var) == null) {
                super.c(ji4Var);
                m62.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: r */
        public void f(ji4 ji4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ji4Var) == null) {
                super.f(ji4Var);
                if (uc2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(ji4Var);
            }
        }

        @Override // com.baidu.tieba.fh4
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
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: o */
        public void e(ji4 ji4Var, gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ji4Var, gi4Var) == null) {
                super.e(ji4Var, gi4Var);
                m62.k("UpdateCoreCallback", "onDownloadError:" + gi4Var);
                this.a.e.l(ji4Var);
                fl3 fl3Var = new fl3();
                fl3Var.k(13L);
                fl3Var.i(gi4Var.a);
                fl3Var.d("Framework包下载失败");
                fl3Var.f(gi4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ji4Var, fl3Var));
                }
                ic2.c().a(ji4Var, this.a.V(), fl3Var);
                qp4.k(ji4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: p */
        public void i(ji4 ji4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ji4Var) == null) {
                super.i(ji4Var);
                m62.k("UpdateCoreCallback", "onFileDownloaded: " + ji4Var.i);
                fl3 c0 = this.a.c0(ji4Var);
                if (c0 == null) {
                    this.a.e.m(ji4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(ji4Var);
                        this.a.c.onCompleted();
                    }
                    jh4.i().m(ji4Var);
                    ic2.c().b(ji4Var, this.a.V());
                    nn3.a();
                    return;
                }
                this.a.e.l(ji4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ji4Var, c0));
                }
                ic2.c().a(ji4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ah4<hi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc2 a;

        public b(uc2 uc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dh4
        /* renamed from: l */
        public String d(hi4 hi4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hi4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: q */
        public void c(hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hi4Var) == null) {
                super.c(hi4Var);
                m62.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: r */
        public void f(hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hi4Var) == null) {
                super.f(hi4Var);
                if (uc2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(hi4Var);
            }
        }

        @Override // com.baidu.tieba.fh4
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
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: o */
        public void e(hi4 hi4Var, gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hi4Var, gi4Var) == null) {
                super.e(hi4Var, gi4Var);
                m62.k("UpdateCoreCallback", "onDownloadError:" + gi4Var);
                this.a.e.l(hi4Var);
                fl3 fl3Var = new fl3();
                fl3Var.k(14L);
                fl3Var.i(gi4Var.a);
                fl3Var.d("Extension下载失败");
                fl3Var.f(gi4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(hi4Var, fl3Var));
                }
                ic2.c().a(hi4Var, this.a.V(), fl3Var);
                qp4.k(hi4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
        /* renamed from: p */
        public void i(hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hi4Var) == null) {
                super.i(hi4Var);
                m62.k("UpdateCoreCallback", "onFileDownloaded: " + hi4Var.i);
                fl3 b0 = this.a.b0(hi4Var);
                if (b0 == null) {
                    this.a.e.m(hi4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(hi4Var);
                        this.a.d.onCompleted();
                    }
                    jh4.i().m(hi4Var);
                    ic2.c().b(hi4Var, this.a.V());
                    return;
                }
                this.a.e.l(hi4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(hi4Var, b0));
                }
                ic2.c().a(hi4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ic2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji4 a;
        public final /* synthetic */ uc2 b;

        public c(uc2 uc2Var, ji4 ji4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var, ji4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uc2Var;
            this.a = ji4Var;
        }

        @Override // com.baidu.tieba.ic2.c
        public void b(PMSDownloadType pMSDownloadType, fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, fl3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, fl3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ic2.c
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

    /* loaded from: classes6.dex */
    public class d implements ic2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi4 a;
        public final /* synthetic */ uc2 b;

        public d(uc2 uc2Var, hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var, hi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uc2Var;
            this.a = hi4Var;
        }

        @Override // com.baidu.tieba.ic2.c
        public void b(PMSDownloadType pMSDownloadType, fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, fl3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, fl3Var));
                }
            }
        }

        @Override // com.baidu.tieba.ic2.c
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

    /* loaded from: classes6.dex */
    public class e implements sma.a<ji4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc2 a;

        public e(uc2 uc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public void call(yma<? super ji4> ymaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ymaVar) != null) {
                return;
            }
            this.a.c = ymaVar;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements sma.a<hi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc2 a;

        public f(uc2 uc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sma.a, com.baidu.tieba.gna
        public void call(yma<? super hi4> ymaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ymaVar) != null) {
                return;
            }
            this.a.d = ymaVar;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends yma<ki4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc2 e;

        public g(uc2 uc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = uc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tma
        /* renamed from: g */
        public void onNext(ki4 ki4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ki4Var) == null) {
                m62.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + ki4Var.i);
            }
        }

        @Override // com.baidu.tieba.tma
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                m62.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.tma
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m62.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206117, "Lcom/baidu/tieba/uc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206117, "Lcom/baidu/tieba/uc2;");
                return;
            }
        }
        j = wp1.a;
    }

    @Override // com.baidu.tieba.hh4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.hh4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            m62.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final yma<ki4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (yma) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh4
    public dh4<hi4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (dh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh4
    public dh4<ji4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (dh4) invokeV.objValue;
    }

    public uc2(fo3<Exception> fo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fo3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = fo3Var;
    }

    @Override // com.baidu.tieba.hh4
    public void G(um4 um4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, um4Var) == null) {
            super.G(um4Var);
            if (um4Var == null) {
                return;
            }
            this.e = um4Var;
            if (!um4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            m62.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            fo3<Exception> fo3Var = this.f;
            if (fo3Var != null) {
                fo3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            m62.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            nm4.d(U(), 0L);
            jt3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(hi4 hi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hi4Var) == null) {
            ic2.c().d(hi4Var, new d(this, hi4Var));
        }
    }

    public final void g0(ji4 ji4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ji4Var) == null) {
            ic2.c().d(ji4Var, new c(this, ji4Var));
        }
    }

    @Override // com.baidu.tieba.hh4
    public void C(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gi4Var) == null) {
            super.C(gi4Var);
            m62.k("UpdateCoreCallback", "onFetchError: " + gi4Var.toString());
            if (gi4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + gi4Var, gi4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(sma.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(sma.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                sma.i(arrayList).u(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            m62.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            nm4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
