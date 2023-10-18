package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.pms.model.PMSException;
import com.baidu.tieba.h6c;
import com.baidu.tieba.l82;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class x82 extends t82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public n6c<? super me4> c;
    public n6c<? super ke4> d;
    public xi4 e;
    public ik3<Exception> f;
    public gd4<me4> g;
    public gd4<ke4> h;
    public n6c<ne4> i;

    public abstract int U();

    public abstract PMSDownloadType V();

    public abstract String W();

    public abstract String X();

    public abstract ih3 b0(ke4 ke4Var);

    public abstract ih3 c0(me4 me4Var);

    /* loaded from: classes8.dex */
    public class a extends dd4<me4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x82 a;

        public a(x82 x82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gd4
        /* renamed from: l */
        public String d(me4 me4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, me4Var)) == null) {
                return this.a.X();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void c(me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, me4Var) == null) {
                super.c(me4Var);
                p22.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: r */
        public void f(me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, me4Var) == null) {
                super.f(me4Var);
                if (x82.j) {
                    Log.i("UpdateCoreCallback", "framework onDownloading");
                }
                this.a.g0(me4Var);
            }
        }

        @Override // com.baidu.tieba.id4
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
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: o */
        public void e(me4 me4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, me4Var, je4Var) == null) {
                super.e(me4Var, je4Var);
                p22.k("UpdateCoreCallback", "onDownloadError:" + je4Var);
                this.a.e.l(me4Var);
                ih3 ih3Var = new ih3();
                ih3Var.k(13L);
                ih3Var.i(je4Var.a);
                ih3Var.d("Framework包下载失败");
                ih3Var.f(je4Var.toString());
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(me4Var, ih3Var));
                }
                l82.c().a(me4Var, this.a.V(), ih3Var);
                sl4.k(me4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: p */
        public void i(me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, me4Var) == null) {
                super.i(me4Var);
                p22.k("UpdateCoreCallback", "onFileDownloaded: " + me4Var.i);
                ih3 c0 = this.a.c0(me4Var);
                if (c0 == null) {
                    this.a.e.m(me4Var);
                    if (this.a.c != null) {
                        this.a.c.onNext(me4Var);
                        this.a.c.onCompleted();
                    }
                    md4.i().m(me4Var);
                    l82.c().b(me4Var, this.a.V());
                    qj3.a();
                    return;
                }
                this.a.e.l(me4Var);
                if (this.a.c != null) {
                    this.a.c.onError(new PkgDownloadError(me4Var, c0));
                }
                l82.c().a(me4Var, this.a.V(), c0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends dd4<ke4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x82 a;

        public b(x82 x82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gd4
        /* renamed from: l */
        public String d(ke4 ke4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ke4Var)) == null) {
                return this.a.W();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void c(ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ke4Var) == null) {
                super.c(ke4Var);
                p22.k("UpdateCoreCallback", "onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: r */
        public void f(ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ke4Var) == null) {
                super.f(ke4Var);
                if (x82.j) {
                    Log.i("UpdateCoreCallback", "extension onDownloading");
                }
                this.a.f0(ke4Var);
            }
        }

        @Override // com.baidu.tieba.id4
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
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: o */
        public void e(ke4 ke4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ke4Var, je4Var) == null) {
                super.e(ke4Var, je4Var);
                p22.k("UpdateCoreCallback", "onDownloadError:" + je4Var);
                this.a.e.l(ke4Var);
                ih3 ih3Var = new ih3();
                ih3Var.k(14L);
                ih3Var.i(je4Var.a);
                ih3Var.d("Extension下载失败");
                ih3Var.f(je4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ke4Var, ih3Var));
                }
                l82.c().a(ke4Var, this.a.V(), ih3Var);
                sl4.k(ke4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: p */
        public void i(ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ke4Var) == null) {
                super.i(ke4Var);
                p22.k("UpdateCoreCallback", "onFileDownloaded: " + ke4Var.i);
                ih3 b0 = this.a.b0(ke4Var);
                if (b0 == null) {
                    this.a.e.m(ke4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(ke4Var);
                        this.a.d.onCompleted();
                    }
                    md4.i().m(ke4Var);
                    l82.c().b(ke4Var, this.a.V());
                    return;
                }
                this.a.e.l(ke4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ke4Var, b0));
                }
                l82.c().a(ke4Var, this.a.V(), b0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me4 a;
        public final /* synthetic */ x82 b;

        public c(x82 x82Var, me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var, me4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x82Var;
            this.a = me4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.c != null) {
                    this.b.c.onError(new PkgDownloadError(this.a, ih3Var));
                }
            }
        }

        @Override // com.baidu.tieba.l82.c
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

    /* loaded from: classes8.dex */
    public class d implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ke4 a;
        public final /* synthetic */ x82 b;

        public d(x82 x82Var, ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var, ke4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x82Var;
            this.a = ke4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                this.b.e.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ih3Var));
                }
            }
        }

        @Override // com.baidu.tieba.l82.c
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

    /* loaded from: classes8.dex */
    public class e implements h6c.a<me4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x82 a;

        public e(x82 x82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super me4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.c = n6cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements h6c.a<ke4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x82 a;

        public f(x82 x82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super ke4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.d = n6cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class g extends n6c<ne4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x82 e;

        public g(x82 x82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = x82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i6c
        /* renamed from: g */
        public void onNext(ne4 ne4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ne4Var) == null) {
                p22.k("UpdateCoreCallback", "单个包下载、业务层处理完成：" + ne4Var.i);
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                p22.l("UpdateCoreCallback", "OnError", th);
                this.e.d0(new Exception("UpdateCoreCallback failed by Download error = ", th));
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                p22.k("UpdateCoreCallback", "包下载完成");
                this.e.e0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254167, "Lcom/baidu/tieba/x82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254167, "Lcom/baidu/tieba/x82;");
                return;
            }
        }
        j = am1.a;
    }

    @Override // com.baidu.tieba.kd4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (j) {
                Log.e("UpdateCoreCallback", "onFetchSuccess:");
            }
        }
    }

    @Override // com.baidu.tieba.kd4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            p22.k("UpdateCoreCallback", "onNoPackage:");
            e0();
        }
    }

    public final n6c<ne4> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.i == null) {
                this.i = new g(this);
            }
            return this.i;
        }
        return (n6c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<ke4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new b(this);
            }
            return this.h;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<me4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.g == null) {
                this.g = new a(this);
            }
            return this.g;
        }
        return (gd4) invokeV.objValue;
    }

    public x82(ik3<Exception> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ik3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = ik3Var;
    }

    @Override // com.baidu.tieba.kd4
    public void G(xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xi4Var) == null) {
            super.G(xi4Var);
            if (xi4Var == null) {
                return;
            }
            this.e = xi4Var;
            if (!xi4Var.k()) {
                Z();
            }
        }
    }

    public void a0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, exc) == null) {
            p22.l("UpdateCoreCallback", "notifyFinalCallback", exc);
            ik3<Exception> ik3Var = this.f;
            if (ik3Var != null) {
                ik3Var.a(exc);
            }
            this.f = null;
        }
    }

    public void d0(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, exc) == null) {
            p22.k("UpdateCoreCallback", "onUpdateFailed setLatestUpdateTime = 0");
            qi4.d(U(), 0L);
            mp3.a(0L);
            a0(new Exception("UpdateCoreCallback onUpdateFailed: cause by = ", exc));
        }
    }

    public final void f0(ke4 ke4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ke4Var) == null) {
            l82.c().d(ke4Var, new d(this, ke4Var));
        }
    }

    public final void g0(me4 me4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, me4Var) == null) {
            l82.c().d(me4Var, new c(this, me4Var));
        }
    }

    @Override // com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, je4Var) == null) {
            super.C(je4Var);
            p22.k("UpdateCoreCallback", "onFetchError: " + je4Var.toString());
            if (je4Var.a == 1010) {
                e0();
                return;
            }
            d0(new PMSException("UpdateCoreCallback failed by fetch error = " + je4Var, je4Var));
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.e.e()) {
                arrayList.add(h6c.d(new e(this)));
            }
            if (this.e.d()) {
                arrayList.add(h6c.d(new f(this)));
            }
            if (!arrayList.isEmpty()) {
                h6c.q(arrayList).F(Y());
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            p22.k("UpdateCoreCallback", "onUpdateSuccess setLatestUpdateTime = " + currentTimeMillis);
            qi4.d(U(), currentTimeMillis);
            a0(null);
        }
    }
}
