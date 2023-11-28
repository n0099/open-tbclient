package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.d92;
import com.baidu.tieba.eoc;
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
public abstract class p92 extends l92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public koc<? super ef4> c;
    public koc<? super cf4> d;
    public pj4 e;
    public al3<Exception> f;
    public yd4<ef4> g;
    public yd4<cf4> h;
    public koc<ff4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract ai3 b0(cf4 cf4Var);

    public abstract ai3 c0(ef4 ef4Var);

    /* loaded from: classes7.dex */
    public class a extends vd4<ef4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;

        public a(p92 p92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4
        /* renamed from: l */
        public String d(ef4 ef4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ef4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void c(ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ef4Var) == null) {
                super.c(ef4Var);
                h32.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: r */
        public void f(ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ef4Var) == null) {
                super.f(ef4Var);
                if (p92.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(ef4Var);
            }
        }

        @Override // com.baidu.tieba.ae4
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
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: o */
        public void e(ef4 ef4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ef4Var, bf4Var) == null) {
                super.e(ef4Var, bf4Var);
                h32.k("UpdateCoreCallback", "onDownloadError:" + bf4Var);
                this.a.e.l(ef4Var);
                ai3 ai3Var = new ai3();
                ai3Var.k(13L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("Framework包下载失败");
                ai3Var.f(bf4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ef4Var, ai3Var));
                }
                d92.c().a(ef4Var, this.a.V(), ai3Var);
                km4.k(ef4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: p */
        public void i(ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ef4Var) == null) {
                super.i(ef4Var);
                h32.k("UpdateCoreCallback", "onFileDownloaded: " + ef4Var.i);
                ai3 c0 = this.a.c0(ef4Var);
                if (c0 == null) {
                    this.a.e.m(ef4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(ef4Var);
                        this.a.c.onCompleted();
                    }
                    ee4.i().m(ef4Var);
                    d92.c().b(ef4Var, this.a.V());
                    ik3.a();
                    return;
                }
                this.a.e.l(ef4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ef4Var, c0));
                }
                d92.c().a(ef4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends vd4<cf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;

        public b(p92 p92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4
        /* renamed from: l */
        public String d(cf4 cf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cf4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void c(cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, cf4Var) == null) {
                super.c(cf4Var);
                h32.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: r */
        public void f(cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, cf4Var) == null) {
                super.f(cf4Var);
                if (p92.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(cf4Var);
            }
        }

        @Override // com.baidu.tieba.ae4
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
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: o */
        public void e(cf4 cf4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, cf4Var, bf4Var) == null) {
                super.e(cf4Var, bf4Var);
                h32.k("UpdateCoreCallback", "onDownloadError:" + bf4Var);
                this.a.e.l(cf4Var);
                ai3 ai3Var = new ai3();
                ai3Var.k(14L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("Extension下载失败");
                ai3Var.f(bf4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(cf4Var, ai3Var));
                }
                d92.c().a(cf4Var, this.a.V(), ai3Var);
                km4.k(cf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: p */
        public void i(cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cf4Var) == null) {
                super.i(cf4Var);
                h32.k("UpdateCoreCallback", "onFileDownloaded: " + cf4Var.i);
                ai3 b0 = this.a.b0(cf4Var);
                if (b0 == null) {
                    this.a.e.m(cf4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(cf4Var);
                        this.a.d.onCompleted();
                    }
                    ee4.i().m(cf4Var);
                    d92.c().b(cf4Var, this.a.V());
                    return;
                }
                this.a.e.l(cf4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(cf4Var, b0));
                }
                d92.c().a(cf4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef4 a;
        public final /* synthetic */ p92 b;

        public c(p92 p92Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var, ef4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p92Var;
            this.a = ef4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, ai3Var));
                }
            }
        }

        @Override // com.baidu.tieba.d92.c
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
    public class d implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf4 a;
        public final /* synthetic */ p92 b;

        public d(p92 p92Var, cf4 cf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var, cf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p92Var;
            this.a = cf4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ai3Var));
                }
            }
        }

        @Override // com.baidu.tieba.d92.c
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
    public class e implements eoc.a<ef4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;

        public e(p92 p92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super ef4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.c = kocVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements eoc.a<cf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;

        public f(p92 p92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super cf4> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, kocVar) != null) {
                return;
            }
            this.a.d = kocVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends koc<ff4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 e;

        public g(p92 p92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = p92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.foc
        /* renamed from: g */
        public void onNext(ff4 ff4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ff4Var) == null) {
                h32.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + ff4Var.i);
            }
        }

        @Override // com.baidu.tieba.foc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                h32.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.foc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h32.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016800, "Lcom/baidu/tieba/p92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016800, "Lcom/baidu/tieba/p92;");
                return;
            }
        }
        j = sm1.a;
    }

    @Override // com.baidu.tieba.ce4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.ce4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            h32.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final koc<ff4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (koc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<cf4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (yd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<ef4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (yd4) invokeV.objValue;
    }

    public p92(al3<Exception> al3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {al3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = al3Var;
    }

    @Override // com.baidu.tieba.ce4
    public void G(pj4 pj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pj4Var) == null) {
            super.G(pj4Var);
            if (pj4Var == null) {
                return;
            }
            this.e = pj4Var;
            if (!pj4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            h32.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            al3<Exception> al3Var = this.f;
            if (al3Var != null) {
                al3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            h32.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            ij4.d(U(), 0L);
            eq3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(cf4 cf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, cf4Var) == null) {
            d92.c().d(cf4Var, new d(this, cf4Var));
        }
    }

    public final void g0(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ef4Var) == null) {
            d92.c().d(ef4Var, new c(this, ef4Var));
        }
    }

    @Override // com.baidu.tieba.ce4
    public void C(bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bf4Var) == null) {
            super.C(bf4Var);
            h32.k("UpdateCoreCallback", "onFetchError: " + bf4Var.toString());
            if (bf4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + bf4Var, bf4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(eoc.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(eoc.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                eoc.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            h32.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            ij4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
