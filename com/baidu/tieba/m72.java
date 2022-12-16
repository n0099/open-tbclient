package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.a72;
import com.baidu.tieba.b3a;
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
public abstract class m72 extends i72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public h3a<? super bd4> c;
    public h3a<? super zc4> d;
    public mh4 e;
    public xi3<Exception> f;
    public vb4<bd4> g;
    public vb4<zc4> h;
    public h3a<cd4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract xf3 b0(zc4 zc4Var);

    public abstract xf3 c0(bd4 bd4Var);

    /* loaded from: classes5.dex */
    public class a extends sb4<bd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m72 a;

        public a(m72 m72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(bd4 bd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bd4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void c(bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bd4Var) == null) {
                super.c(bd4Var);
                e12.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: r */
        public void f(bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bd4Var) == null) {
                super.f(bd4Var);
                if (m72.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(bd4Var);
            }
        }

        @Override // com.baidu.tieba.xb4
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
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(bd4 bd4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bd4Var, yc4Var) == null) {
                super.e(bd4Var, yc4Var);
                e12.k("UpdateCoreCallback", "onDownloadError:" + yc4Var);
                this.a.e.l(bd4Var);
                xf3 xf3Var = new xf3();
                xf3Var.k(13L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("Framework包下载失败");
                xf3Var.f(yc4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(bd4Var, xf3Var));
                }
                a72.c().a(bd4Var, this.a.V(), xf3Var);
                ik4.k(bd4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bd4Var) == null) {
                super.i(bd4Var);
                e12.k("UpdateCoreCallback", "onFileDownloaded: " + bd4Var.i);
                xf3 c0 = this.a.c0(bd4Var);
                if (c0 == null) {
                    this.a.e.m(bd4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(bd4Var);
                        this.a.c.onCompleted();
                    }
                    bc4.i().m(bd4Var);
                    a72.c().b(bd4Var, this.a.V());
                    fi3.a();
                    return;
                }
                this.a.e.l(bd4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(bd4Var, c0));
                }
                a72.c().a(bd4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends sb4<zc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m72 a;

        public b(m72 m72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(zc4 zc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zc4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void c(zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, zc4Var) == null) {
                super.c(zc4Var);
                e12.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: r */
        public void f(zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, zc4Var) == null) {
                super.f(zc4Var);
                if (m72.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(zc4Var);
            }
        }

        @Override // com.baidu.tieba.xb4
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
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(zc4 zc4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, zc4Var, yc4Var) == null) {
                super.e(zc4Var, yc4Var);
                e12.k("UpdateCoreCallback", "onDownloadError:" + yc4Var);
                this.a.e.l(zc4Var);
                xf3 xf3Var = new xf3();
                xf3Var.k(14L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("Extension下载失败");
                xf3Var.f(yc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(zc4Var, xf3Var));
                }
                a72.c().a(zc4Var, this.a.V(), xf3Var);
                ik4.k(zc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zc4Var) == null) {
                super.i(zc4Var);
                e12.k("UpdateCoreCallback", "onFileDownloaded: " + zc4Var.i);
                xf3 b0 = this.a.b0(zc4Var);
                if (b0 == null) {
                    this.a.e.m(zc4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(zc4Var);
                        this.a.d.onCompleted();
                    }
                    bc4.i().m(zc4Var);
                    a72.c().b(zc4Var, this.a.V());
                    return;
                }
                this.a.e.l(zc4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(zc4Var, b0));
                }
                a72.c().a(zc4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bd4 a;
        public final /* synthetic */ m72 b;

        public c(m72 m72Var, bd4 bd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m72Var, bd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m72Var;
            this.a = bd4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, xf3Var));
                }
            }
        }

        @Override // com.baidu.tieba.a72.c
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

    /* loaded from: classes5.dex */
    public class d implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zc4 a;
        public final /* synthetic */ m72 b;

        public d(m72 m72Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m72Var, zc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m72Var;
            this.a = zc4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, xf3Var));
                }
            }
        }

        @Override // com.baidu.tieba.a72.c
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

    /* loaded from: classes5.dex */
    public class e implements b3a.a<bd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m72 a;

        public e(m72 m72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super bd4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.c = h3aVar;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements b3a.a<zc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m72 a;

        public f(m72 m72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public void call(h3a<? super zc4> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, h3aVar) != null) {
                return;
            }
            this.a.d = h3aVar;
        }
    }

    /* loaded from: classes5.dex */
    public class g extends h3a<cd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m72 e;

        public g(m72 m72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c3a
        /* renamed from: g */
        public void onNext(cd4 cd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cd4Var) == null) {
                e12.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + cd4Var.i);
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                e12.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e12.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925505, "Lcom/baidu/tieba/m72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925505, "Lcom/baidu/tieba/m72;");
                return;
            }
        }
        j = ok1.a;
    }

    @Override // com.baidu.tieba.zb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.zb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            e12.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final h3a<cd4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (h3a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<zc4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<bd4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (vb4) invokeV.objValue;
    }

    public m72(xi3<Exception> xi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xi3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = xi3Var;
    }

    @Override // com.baidu.tieba.zb4
    public void G(mh4 mh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mh4Var) == null) {
            super.G(mh4Var);
            if (mh4Var == null) {
                return;
            }
            this.e = mh4Var;
            if (!mh4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            e12.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            xi3<Exception> xi3Var = this.f;
            if (xi3Var != null) {
                xi3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            e12.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            fh4.d(U(), 0L);
            bo3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(zc4 zc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zc4Var) == null) {
            a72.c().d(zc4Var, new d(this, zc4Var));
        }
    }

    public final void g0(bd4 bd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bd4Var) == null) {
            a72.c().d(bd4Var, new c(this, bd4Var));
        }
    }

    @Override // com.baidu.tieba.zb4
    public void C(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yc4Var) == null) {
            super.C(yc4Var);
            e12.k("UpdateCoreCallback", "onFetchError: " + yc4Var.toString());
            if (yc4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + yc4Var, yc4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(b3a.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(b3a.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                b3a.i(arrayList).u(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            e12.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            fh4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
