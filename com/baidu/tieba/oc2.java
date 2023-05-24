package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.cc2;
import com.baidu.tieba.i7b;
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
public abstract class oc2 extends kc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public o7b<? super di4> c;
    public o7b<? super bi4> d;
    public om4 e;
    public zn3<Exception> f;
    public xg4<di4> g;
    public xg4<bi4> h;
    public o7b<ei4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract zk3 b0(bi4 bi4Var);

    public abstract zk3 c0(di4 di4Var);

    /* loaded from: classes6.dex */
    public class a extends ug4<di4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc2 a;

        public a(oc2 oc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg4
        /* renamed from: l */
        public String d(di4 di4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, di4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void c(di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, di4Var) == null) {
                super.c(di4Var);
                g62.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: r */
        public void f(di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, di4Var) == null) {
                super.f(di4Var);
                if (oc2.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(di4Var);
            }
        }

        @Override // com.baidu.tieba.zg4
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
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: o */
        public void e(di4 di4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, di4Var, ai4Var) == null) {
                super.e(di4Var, ai4Var);
                g62.k("UpdateCoreCallback", "onDownloadError:" + ai4Var);
                this.a.e.l(di4Var);
                zk3 zk3Var = new zk3();
                zk3Var.k(13L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("Framework包下载失败");
                zk3Var.f(ai4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(di4Var, zk3Var));
                }
                cc2.c().a(di4Var, this.a.V(), zk3Var);
                kp4.k(di4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: p */
        public void i(di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, di4Var) == null) {
                super.i(di4Var);
                g62.k("UpdateCoreCallback", "onFileDownloaded: " + di4Var.i);
                zk3 c0 = this.a.c0(di4Var);
                if (c0 == null) {
                    this.a.e.m(di4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(di4Var);
                        this.a.c.onCompleted();
                    }
                    dh4.i().m(di4Var);
                    cc2.c().b(di4Var, this.a.V());
                    hn3.a();
                    return;
                }
                this.a.e.l(di4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(di4Var, c0));
                }
                cc2.c().a(di4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ug4<bi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc2 a;

        public b(oc2 oc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg4
        /* renamed from: l */
        public String d(bi4 bi4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bi4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void c(bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bi4Var) == null) {
                super.c(bi4Var);
                g62.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: r */
        public void f(bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bi4Var) == null) {
                super.f(bi4Var);
                if (oc2.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(bi4Var);
            }
        }

        @Override // com.baidu.tieba.zg4
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
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: o */
        public void e(bi4 bi4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bi4Var, ai4Var) == null) {
                super.e(bi4Var, ai4Var);
                g62.k("UpdateCoreCallback", "onDownloadError:" + ai4Var);
                this.a.e.l(bi4Var);
                zk3 zk3Var = new zk3();
                zk3Var.k(14L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("Extension下载失败");
                zk3Var.f(ai4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bi4Var, zk3Var));
                }
                cc2.c().a(bi4Var, this.a.V(), zk3Var);
                kp4.k(bi4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: p */
        public void i(bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bi4Var) == null) {
                super.i(bi4Var);
                g62.k("UpdateCoreCallback", "onFileDownloaded: " + bi4Var.i);
                zk3 b0 = this.a.b0(bi4Var);
                if (b0 == null) {
                    this.a.e.m(bi4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(bi4Var);
                        this.a.d.onCompleted();
                    }
                    dh4.i().m(bi4Var);
                    cc2.c().b(bi4Var, this.a.V());
                    return;
                }
                this.a.e.l(bi4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(bi4Var, b0));
                }
                cc2.c().a(bi4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di4 a;
        public final /* synthetic */ oc2 b;

        public c(oc2 oc2Var, di4 di4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc2Var, di4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oc2Var;
            this.a = di4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, zk3Var));
                }
            }
        }

        @Override // com.baidu.tieba.cc2.c
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
    public class d implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bi4 a;
        public final /* synthetic */ oc2 b;

        public d(oc2 oc2Var, bi4 bi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc2Var, bi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oc2Var;
            this.a = bi4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, zk3Var));
                }
            }
        }

        @Override // com.baidu.tieba.cc2.c
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
    public class e implements i7b.a<di4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc2 a;

        public e(oc2 oc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public void call(o7b<? super di4> o7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, o7bVar) != null) {
                return;
            }
            this.a.c = o7bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements i7b.a<bi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc2 a;

        public f(oc2 oc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i7b.a, com.baidu.tieba.w7b
        public void call(o7b<? super bi4> o7bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, o7bVar) != null) {
                return;
            }
            this.a.d = o7bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends o7b<ei4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc2 e;

        public g(oc2 oc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j7b
        /* renamed from: g */
        public void onNext(ei4 ei4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ei4Var) == null) {
                g62.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + ei4Var.i);
            }
        }

        @Override // com.baidu.tieba.j7b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                g62.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.j7b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g62.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948027371, "Lcom/baidu/tieba/oc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948027371, "Lcom/baidu/tieba/oc2;");
                return;
            }
        }
        j = qp1.a;
    }

    @Override // com.baidu.tieba.bh4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.bh4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            g62.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final o7b<ei4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (o7b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<bi4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (xg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<di4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (xg4) invokeV.objValue;
    }

    public oc2(zn3<Exception> zn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zn3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = zn3Var;
    }

    @Override // com.baidu.tieba.bh4
    public void G(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, om4Var) == null) {
            super.G(om4Var);
            if (om4Var == null) {
                return;
            }
            this.e = om4Var;
            if (!om4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            g62.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            zn3<Exception> zn3Var = this.f;
            if (zn3Var != null) {
                zn3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            g62.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            hm4.d(U(), 0L);
            dt3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(bi4 bi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bi4Var) == null) {
            cc2.c().d(bi4Var, new d(this, bi4Var));
        }
    }

    public final void g0(di4 di4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, di4Var) == null) {
            cc2.c().d(di4Var, new c(this, di4Var));
        }
    }

    @Override // com.baidu.tieba.bh4
    public void C(ai4 ai4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ai4Var) == null) {
            super.C(ai4Var);
            g62.k("UpdateCoreCallback", "onFetchError: " + ai4Var.toString());
            if (ai4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + ai4Var, ai4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(i7b.a(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(i7b.a(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                i7b.k(arrayList).w(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            g62.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            hm4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
