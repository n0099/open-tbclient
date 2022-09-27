package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.fx9;
import com.baidu.tieba.h62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class t62 extends p62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public lx9<? super ic4> c;
    public lx9<? super gc4> d;
    public tg4 e;
    public ei3<Exception> f;
    public cb4<ic4> g;
    public cb4<gc4> h;
    public lx9<jc4> i;

    /* loaded from: classes5.dex */
    public class a extends za4<ic4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t62 a;

        public a(t62 t62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb4
        /* renamed from: l */
        public String d(ic4 ic4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ic4Var)) == null) ? this.a.X() : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.eb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: o */
        public void e(ic4 ic4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ic4Var, fc4Var) == null) {
                super.e(ic4Var, fc4Var);
                l02.k("UpdateCoreCallback", "onDownloadError:" + fc4Var);
                this.a.e.l(ic4Var);
                ef3 ef3Var = new ef3();
                ef3Var.k(13L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("Framework包下载失败");
                ef3Var.f(fc4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ic4Var, ef3Var));
                }
                h62.c().a(ic4Var, this.a.V(), ef3Var);
                pj4.k(ic4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: p */
        public void i(ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ic4Var) == null) {
                super.i(ic4Var);
                l02.k("UpdateCoreCallback", "onFileDownloaded: " + ic4Var.i);
                ef3 c0 = this.a.c0(ic4Var);
                if (c0 == null) {
                    this.a.e.m(ic4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(ic4Var);
                        this.a.c.onCompleted();
                    }
                    ib4.i().m(ic4Var);
                    h62.c().b(ic4Var, this.a.V());
                    mh3.a();
                    return;
                }
                this.a.e.l(ic4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ic4Var, c0));
                }
                h62.c().a(ic4Var, this.a.V(), c0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void c(ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ic4Var) == null) {
                super.c(ic4Var);
                l02.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: r */
        public void f(ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ic4Var) == null) {
                super.f(ic4Var);
                if (t62.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(ic4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends za4<gc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t62 a;

        public b(t62 t62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb4
        /* renamed from: l */
        public String d(gc4 gc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gc4Var)) == null) ? this.a.W() : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.eb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: o */
        public void e(gc4 gc4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, gc4Var, fc4Var) == null) {
                super.e(gc4Var, fc4Var);
                l02.k("UpdateCoreCallback", "onDownloadError:" + fc4Var);
                this.a.e.l(gc4Var);
                ef3 ef3Var = new ef3();
                ef3Var.k(14L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("Extension下载失败");
                ef3Var.f(fc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(gc4Var, ef3Var));
                }
                h62.c().a(gc4Var, this.a.V(), ef3Var);
                pj4.k(gc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: p */
        public void i(gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gc4Var) == null) {
                super.i(gc4Var);
                l02.k("UpdateCoreCallback", "onFileDownloaded: " + gc4Var.i);
                ef3 b0 = this.a.b0(gc4Var);
                if (b0 == null) {
                    this.a.e.m(gc4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(gc4Var);
                        this.a.d.onCompleted();
                    }
                    ib4.i().m(gc4Var);
                    h62.c().b(gc4Var, this.a.V());
                    return;
                }
                this.a.e.l(gc4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(gc4Var, b0));
                }
                h62.c().a(gc4Var, this.a.V(), b0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void c(gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, gc4Var) == null) {
                super.c(gc4Var);
                l02.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: r */
        public void f(gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gc4Var) == null) {
                super.f(gc4Var);
                if (t62.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(gc4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic4 a;
        public final /* synthetic */ t62 b;

        public c(t62 t62Var, ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t62Var, ic4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t62Var;
            this.a = ic4Var;
        }

        @Override // com.baidu.tieba.h62.c
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

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, ef3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc4 a;
        public final /* synthetic */ t62 b;

        public d(t62 t62Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t62Var, gc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t62Var;
            this.a = gc4Var;
        }

        @Override // com.baidu.tieba.h62.c
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

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ef3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements fx9.a<ic4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t62 a;

        public e(t62 t62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super ic4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.c = lx9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements fx9.a<gc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t62 a;

        public f(t62 t62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super gc4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.d = lx9Var;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends lx9<jc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t62 e;

        public g(t62 t62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gx9
        /* renamed from: g */
        public void onNext(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jc4Var) == null) {
                l02.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + jc4Var.i);
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l02.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                l02.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948133081, "Lcom/baidu/tieba/t62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948133081, "Lcom/baidu/tieba/t62;");
                return;
            }
        }
        j = vj1.a;
    }

    public t62(ei3<Exception> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ei3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = ei3Var;
    }

    @Override // com.baidu.tieba.gb4
    public void C(fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fc4Var) == null) {
            super.C(fc4Var);
            l02.k("UpdateCoreCallback", "onFetchError: " + fc4Var.toString());
            if (fc4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + fc4Var, fc4Var));
        }
    }

    @Override // com.baidu.tieba.gb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.gb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            l02.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    @Override // com.baidu.tieba.gb4
    public void G(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tg4Var) == null) {
            super.G(tg4Var);
            if (tg4Var == null) {
                return;
            }
            this.e = tg4Var;
            if (tg4Var.k()) {
                return;
            }
            Z();
        }
    }

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public final lx9<jc4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (lx9) invokeV.objValue;
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(fx9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(fx9.a(new f(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            fx9.i(arrayList).u(Y());
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            l02.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            ei3<Exception> ei3Var = this.f;
            if (ei3Var != null) {
                ei3Var.a(exc);
            }
            this.f = null;
        }
    }

    public abstract ef3 b0(gc4 gc4Var);

    public abstract ef3 c0(ic4 ic4Var);

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            l02.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            mg4.d(U(), 0L);
            in3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            l02.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            mg4.d(U(), currentTimeMillis);
            a0(null);
        }
    }

    public final void f0(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gc4Var) == null) {
            h62.c().d(gc4Var, new d(this, gc4Var));
        }
    }

    public final void g0(ic4 ic4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ic4Var) == null) {
            h62.c().d(ic4Var, new c(this, ic4Var));
        }
    }

    @Override // com.baidu.tieba.gb4
    public cb4<gc4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (cb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb4
    public cb4<ic4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (cb4) invokeV.objValue;
    }
}
