package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.c92;
import com.baidu.tieba.ijc;
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
public abstract class o92 extends k92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public ojc<? super df4> c;
    public ojc<? super bf4> d;
    public oj4 e;
    public zk3<Exception> f;
    public xd4<df4> g;
    public xd4<bf4> h;
    public ojc<ef4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract zh3 b0(bf4 bf4Var);

    public abstract zh3 c0(df4 df4Var);

    /* loaded from: classes7.dex */
    public class a extends ud4<df4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o92 a;

        public a(o92 o92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xd4
        /* renamed from: l */
        public String d(df4 df4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, df4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: q */
        public void c(df4 df4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, df4Var) == null) {
                super.c(df4Var);
                g32.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: r */
        public void f(df4 df4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, df4Var) == null) {
                super.f(df4Var);
                if (o92.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(df4Var);
            }
        }

        @Override // com.baidu.tieba.zd4
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
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: o */
        public void e(df4 df4Var, af4 af4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, df4Var, af4Var) == null) {
                super.e(df4Var, af4Var);
                g32.k("UpdateCoreCallback", "onDownloadError:" + af4Var);
                this.a.e.l(df4Var);
                zh3 zh3Var = new zh3();
                zh3Var.k(13L);
                zh3Var.i(af4Var.a);
                zh3Var.d("Framework包下载失败");
                zh3Var.f(af4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(df4Var, zh3Var));
                }
                c92.c().a(df4Var, this.a.V(), zh3Var);
                jm4.k(df4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: p */
        public void i(df4 df4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, df4Var) == null) {
                super.i(df4Var);
                g32.k("UpdateCoreCallback", "onFileDownloaded: " + df4Var.i);
                zh3 c0 = this.a.c0(df4Var);
                if (c0 == null) {
                    this.a.e.m(df4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(df4Var);
                        this.a.c.onCompleted();
                    }
                    de4.i().m(df4Var);
                    c92.c().b(df4Var, this.a.V());
                    hk3.a();
                    return;
                }
                this.a.e.l(df4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(df4Var, c0));
                }
                c92.c().a(df4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ud4<bf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o92 a;

        public b(o92 o92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xd4
        /* renamed from: l */
        public String d(bf4 bf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bf4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: q */
        public void c(bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bf4Var) == null) {
                super.c(bf4Var);
                g32.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: r */
        public void f(bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bf4Var) == null) {
                super.f(bf4Var);
                if (o92.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(bf4Var);
            }
        }

        @Override // com.baidu.tieba.zd4
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
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: o */
        public void e(bf4 bf4Var, af4 af4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bf4Var, af4Var) == null) {
                super.e(bf4Var, af4Var);
                g32.k("UpdateCoreCallback", "onDownloadError:" + af4Var);
                this.a.e.l(bf4Var);
                zh3 zh3Var = new zh3();
                zh3Var.k(14L);
                zh3Var.i(af4Var.a);
                zh3Var.d("Extension下载失败");
                zh3Var.f(af4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bf4Var, zh3Var));
                }
                c92.c().a(bf4Var, this.a.V(), zh3Var);
                jm4.k(bf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: p */
        public void i(bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bf4Var) == null) {
                super.i(bf4Var);
                g32.k("UpdateCoreCallback", "onFileDownloaded: " + bf4Var.i);
                zh3 b0 = this.a.b0(bf4Var);
                if (b0 == null) {
                    this.a.e.m(bf4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(bf4Var);
                        this.a.d.onCompleted();
                    }
                    de4.i().m(bf4Var);
                    c92.c().b(bf4Var, this.a.V());
                    return;
                }
                this.a.e.l(bf4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bf4Var, b0));
                }
                c92.c().a(bf4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ df4 a;
        public final /* synthetic */ o92 b;

        public c(o92 o92Var, df4 df4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var, df4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o92Var;
            this.a = df4Var;
        }

        @Override // com.baidu.tieba.c92.c
        public void b(PMSDownloadType pMSDownloadType, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zh3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, zh3Var));
                }
            }
        }

        @Override // com.baidu.tieba.c92.c
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
    public class d implements c92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf4 a;
        public final /* synthetic */ o92 b;

        public d(o92 o92Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var, bf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o92Var;
            this.a = bf4Var;
        }

        @Override // com.baidu.tieba.c92.c
        public void b(PMSDownloadType pMSDownloadType, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zh3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, zh3Var));
                }
            }
        }

        @Override // com.baidu.tieba.c92.c
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
    public class e implements ijc.a<df4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o92 a;

        public e(o92 o92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(ojc<? super df4> ojcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ojcVar) != null) {
                return;
            }
            this.a.c = ojcVar;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ijc.a<bf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o92 a;

        public f(o92 o92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wjc
        /* renamed from: a */
        public void call(ojc<? super bf4> ojcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, ojcVar) != null) {
                return;
            }
            this.a.d = ojcVar;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends ojc<ef4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o92 e;

        public g(o92 o92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = o92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jjc
        /* renamed from: g */
        public void onNext(ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ef4Var) == null) {
                g32.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + ef4Var.i);
            }
        }

        @Override // com.baidu.tieba.jjc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                g32.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.jjc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g32.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987009, "Lcom/baidu/tieba/o92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987009, "Lcom/baidu/tieba/o92;");
                return;
            }
        }
        j = rm1.a;
    }

    @Override // com.baidu.tieba.be4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.be4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            g32.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final ojc<ef4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (ojc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.be4
    public xd4<bf4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (xd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.be4
    public xd4<df4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (xd4) invokeV.objValue;
    }

    public o92(zk3<Exception> zk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zk3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = zk3Var;
    }

    @Override // com.baidu.tieba.be4
    public void G(oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oj4Var) == null) {
            super.G(oj4Var);
            if (oj4Var == null) {
                return;
            }
            this.e = oj4Var;
            if (!oj4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            g32.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            zk3<Exception> zk3Var = this.f;
            if (zk3Var != null) {
                zk3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            g32.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            hj4.d(U(), 0L);
            dq3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bf4Var) == null) {
            c92.c().d(bf4Var, new d(this, bf4Var));
        }
    }

    public final void g0(df4 df4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, df4Var) == null) {
            c92.c().d(df4Var, new c(this, df4Var));
        }
    }

    @Override // com.baidu.tieba.be4
    public void C(af4 af4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, af4Var) == null) {
            super.C(af4Var);
            g32.k("UpdateCoreCallback", "onFetchError: " + af4Var.toString());
            if (af4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + af4Var, af4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(ijc.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(ijc.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                ijc.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            g32.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            hj4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
