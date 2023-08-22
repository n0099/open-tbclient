package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.n7c;
import com.baidu.tieba.zd2;
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
public abstract class le2 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public t7c<? super ak4> c;
    public t7c<? super yj4> d;
    public lo4 e;
    public wp3<Exception> f;
    public ui4<ak4> g;
    public ui4<yj4> h;
    public t7c<bk4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract wm3 b0(yj4 yj4Var);

    public abstract wm3 c0(ak4 ak4Var);

    /* loaded from: classes7.dex */
    public class a extends ri4<ak4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le2 a;

        public a(le2 le2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: l */
        public String d(ak4 ak4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ak4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void c(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ak4Var) == null) {
                super.c(ak4Var);
                d82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: r */
        public void f(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ak4Var) == null) {
                super.f(ak4Var);
                if (le2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(ak4Var);
            }
        }

        @Override // com.baidu.tieba.wi4
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
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: o */
        public void e(ak4 ak4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ak4Var, xj4Var) == null) {
                super.e(ak4Var, xj4Var);
                d82.k("UpdateCoreCallback", "onDownloadError:" + xj4Var);
                this.a.e.l(ak4Var);
                wm3 wm3Var = new wm3();
                wm3Var.k(13L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("Framework包下载失败");
                wm3Var.f(xj4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ak4Var, wm3Var));
                }
                zd2.c().a(ak4Var, this.a.V(), wm3Var);
                hr4.k(ak4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: p */
        public void i(ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ak4Var) == null) {
                super.i(ak4Var);
                d82.k("UpdateCoreCallback", "onFileDownloaded: " + ak4Var.i);
                wm3 c0 = this.a.c0(ak4Var);
                if (c0 == null) {
                    this.a.e.m(ak4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(ak4Var);
                        this.a.c.onCompleted();
                    }
                    aj4.i().m(ak4Var);
                    zd2.c().b(ak4Var, this.a.V());
                    ep3.a();
                    return;
                }
                this.a.e.l(ak4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(ak4Var, c0));
                }
                zd2.c().a(ak4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ri4<yj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le2 a;

        public b(le2 le2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: l */
        public String d(yj4 yj4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yj4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void c(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, yj4Var) == null) {
                super.c(yj4Var);
                d82.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: r */
        public void f(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, yj4Var) == null) {
                super.f(yj4Var);
                if (le2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(yj4Var);
            }
        }

        @Override // com.baidu.tieba.wi4
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
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: o */
        public void e(yj4 yj4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, yj4Var, xj4Var) == null) {
                super.e(yj4Var, xj4Var);
                d82.k("UpdateCoreCallback", "onDownloadError:" + xj4Var);
                this.a.e.l(yj4Var);
                wm3 wm3Var = new wm3();
                wm3Var.k(14L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("Extension下载失败");
                wm3Var.f(xj4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(yj4Var, wm3Var));
                }
                zd2.c().a(yj4Var, this.a.V(), wm3Var);
                hr4.k(yj4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: p */
        public void i(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yj4Var) == null) {
                super.i(yj4Var);
                d82.k("UpdateCoreCallback", "onFileDownloaded: " + yj4Var.i);
                wm3 b0 = this.a.b0(yj4Var);
                if (b0 == null) {
                    this.a.e.m(yj4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(yj4Var);
                        this.a.d.onCompleted();
                    }
                    aj4.i().m(yj4Var);
                    zd2.c().b(yj4Var, this.a.V());
                    return;
                }
                this.a.e.l(yj4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(yj4Var, b0));
                }
                zd2.c().a(yj4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ak4 a;
        public final /* synthetic */ le2 b;

        public c(le2 le2Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var, ak4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = le2Var;
            this.a = ak4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, wm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.zd2.c
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
    public class d implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj4 a;
        public final /* synthetic */ le2 b;

        public d(le2 le2Var, yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var, yj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = le2Var;
            this.a = yj4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, wm3Var));
                }
            }
        }

        @Override // com.baidu.tieba.zd2.c
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
    public class e implements n7c.a<ak4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le2 a;

        public e(le2 le2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public void call(t7c<? super ak4> t7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t7cVar) != null) {
                return;
            }
            this.a.c = t7cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements n7c.a<yj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le2 a;

        public f(le2 le2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n7c.a, com.baidu.tieba.b8c
        public void call(t7c<? super yj4> t7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t7cVar) != null) {
                return;
            }
            this.a.d = t7cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends t7c<bk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le2 e;

        public g(le2 le2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = le2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o7c
        /* renamed from: g */
        public void onNext(bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
                d82.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + bk4Var.i);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                d82.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d82.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939920, "Lcom/baidu/tieba/le2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939920, "Lcom/baidu/tieba/le2;");
                return;
            }
        }
        j = nr1.a;
    }

    @Override // com.baidu.tieba.yi4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            d82.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final t7c<bk4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (t7c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<yj4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<ak4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (ui4) invokeV.objValue;
    }

    public le2(wp3<Exception> wp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = wp3Var;
    }

    @Override // com.baidu.tieba.yi4
    public void G(lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lo4Var) == null) {
            super.G(lo4Var);
            if (lo4Var == null) {
                return;
            }
            this.e = lo4Var;
            if (!lo4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            d82.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            wp3<Exception> wp3Var = this.f;
            if (wp3Var != null) {
                wp3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            d82.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            eo4.d(U(), 0L);
            av3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(yj4 yj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, yj4Var) == null) {
            zd2.c().d(yj4Var, new d(this, yj4Var));
        }
    }

    public final void g0(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ak4Var) == null) {
            zd2.c().d(ak4Var, new c(this, ak4Var));
        }
    }

    @Override // com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xj4Var) == null) {
            super.C(xj4Var);
            d82.k("UpdateCoreCallback", "onFetchError: " + xj4Var.toString());
            if (xj4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + xj4Var, xj4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(n7c.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(n7c.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                n7c.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            d82.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            eo4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
