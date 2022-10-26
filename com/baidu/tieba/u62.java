package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.i62;
import com.baidu.tieba.xx9;
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
public abstract class u62 extends q62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public dy9 c;
    public dy9 d;
    public ug4 e;
    public fi3 f;
    public db4 g;
    public db4 h;
    public dy9 i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract ff3 b0(hc4 hc4Var);

    public abstract ff3 c0(jc4 jc4Var);

    /* loaded from: classes6.dex */
    public class a extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u62 a;

        public a(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(jc4 jc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jc4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void c(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jc4Var) == null) {
                super.c(jc4Var);
                m02.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: r */
        public void f(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jc4Var) == null) {
                super.f(jc4Var);
                if (u62.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(jc4Var);
            }
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(jc4 jc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, jc4Var, gc4Var) == null) {
                super.e(jc4Var, gc4Var);
                m02.k("UpdateCoreCallback", "onDownloadError:" + gc4Var);
                this.a.e.l(jc4Var);
                ff3 ff3Var = new ff3();
                ff3Var.k(13L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("Framework包下载失败");
                ff3Var.f(gc4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(jc4Var, ff3Var));
                }
                i62.c().a(jc4Var, this.a.V(), ff3Var);
                qj4.k(jc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jc4Var) == null) {
                super.i(jc4Var);
                m02.k("UpdateCoreCallback", "onFileDownloaded: " + jc4Var.i);
                ff3 c0 = this.a.c0(jc4Var);
                if (c0 == null) {
                    this.a.e.m(jc4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(jc4Var);
                        this.a.c.onCompleted();
                    }
                    jb4.i().m(jc4Var);
                    i62.c().b(jc4Var, this.a.V());
                    nh3.a();
                    return;
                }
                this.a.e.l(jc4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(jc4Var, c0));
                }
                i62.c().a(jc4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u62 a;

        public b(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(hc4 hc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hc4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void c(hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hc4Var) == null) {
                super.c(hc4Var);
                m02.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: r */
        public void f(hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hc4Var) == null) {
                super.f(hc4Var);
                if (u62.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(hc4Var);
            }
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(hc4 hc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hc4Var, gc4Var) == null) {
                super.e(hc4Var, gc4Var);
                m02.k("UpdateCoreCallback", "onDownloadError:" + gc4Var);
                this.a.e.l(hc4Var);
                ff3 ff3Var = new ff3();
                ff3Var.k(14L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("Extension下载失败");
                ff3Var.f(gc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(hc4Var, ff3Var));
                }
                i62.c().a(hc4Var, this.a.V(), ff3Var);
                qj4.k(hc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hc4Var) == null) {
                super.i(hc4Var);
                m02.k("UpdateCoreCallback", "onFileDownloaded: " + hc4Var.i);
                ff3 b0 = this.a.b0(hc4Var);
                if (b0 == null) {
                    this.a.e.m(hc4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(hc4Var);
                        this.a.d.onCompleted();
                    }
                    jb4.i().m(hc4Var);
                    i62.c().b(hc4Var, this.a.V());
                    return;
                }
                this.a.e.l(hc4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(hc4Var, b0));
                }
                i62.c().a(hc4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc4 a;
        public final /* synthetic */ u62 b;

        public c(u62 u62Var, jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u62Var, jc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u62Var;
            this.a = jc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, ff3Var));
                }
            }
        }

        @Override // com.baidu.tieba.i62.c
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
    public class d implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc4 a;
        public final /* synthetic */ u62 b;

        public d(u62 u62Var, hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u62Var, hc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u62Var;
            this.a = hc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ff3Var));
                }
            }
        }

        @Override // com.baidu.tieba.i62.c
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
    public class e implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u62 a;

        public e(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.c = dy9Var;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u62 a;

        public f(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.d = dy9Var;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends dy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u62 e;

        public g(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = u62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yx9
        /* renamed from: g */
        public void onNext(kc4 kc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kc4Var) == null) {
                m02.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + kc4Var.i);
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                m02.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m02.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948162872, "Lcom/baidu/tieba/u62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948162872, "Lcom/baidu/tieba/u62;");
                return;
            }
        }
        j = wj1.a;
    }

    @Override // com.baidu.tieba.hb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.hb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            m02.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final dy9 Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (dy9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public db4 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public db4 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (db4) invokeV.objValue;
    }

    public u62(fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = fi3Var;
    }

    @Override // com.baidu.tieba.hb4
    public void G(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ug4Var) == null) {
            super.G(ug4Var);
            if (ug4Var == null) {
                return;
            }
            this.e = ug4Var;
            if (!ug4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            m02.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            fi3 fi3Var = this.f;
            if (fi3Var != null) {
                fi3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            m02.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            ng4.d(U(), 0L);
            jn3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(hc4 hc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hc4Var) == null) {
            i62.c().d(hc4Var, new d(this, hc4Var));
        }
    }

    public final void g0(jc4 jc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jc4Var) == null) {
            i62.c().d(jc4Var, new c(this, jc4Var));
        }
    }

    @Override // com.baidu.tieba.hb4
    public void C(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gc4Var) == null) {
            super.C(gc4Var);
            m02.k("UpdateCoreCallback", "onFetchError: " + gc4Var.toString());
            if (gc4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + gc4Var, gc4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(xx9.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(xx9.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                xx9.i(arrayList).u(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            m02.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            ng4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
