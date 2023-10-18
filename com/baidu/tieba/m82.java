package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.h42;
import com.baidu.tieba.jg4;
import com.baidu.tieba.lo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class m82 extends t82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public xi4 c;
    public j82 d;
    public final List<pe4> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public cd4<jg4.a> i;
    public gd4<pe4> j;
    public final gd4<qe4> k;

    @Override // com.baidu.tieba.t82
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class b extends cd4<jg4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m82 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jg4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, jg4.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.b.a.V(this.a)) {
                        this.b.a.W();
                        if (this.b.a.d != null) {
                            this.b.a.d.c(this.a);
                        }
                        f92.c(this.a.g.appId);
                    }
                    ee2.f(this.a.b);
                }
            }
        }

        public b(m82 m82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m82Var;
        }

        @Override // com.baidu.tieba.cd4
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                z73.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gd4
        /* renamed from: q */
        public String d(jg4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return h92.g();
                }
                if (i != 1) {
                    return null;
                }
                return h92.i();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: u */
        public void c(jg4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                p22.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        @Override // com.baidu.tieba.id4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.cd4
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    z73.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        @Override // com.baidu.tieba.cd4
        public void o(jg4.a aVar, PMSAppInfo pMSAppInfo, je4 je4Var) {
            PMSAppInfo pMSAppInfo2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, je4Var) == null) {
                p22.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + je4Var.a + " errorMsg=" + je4Var.b + " errorDetails=" + je4Var.d);
                if (this.a.d != null) {
                    this.a.d.f(je4Var);
                }
                if (je4Var.a == 1010) {
                    if (aVar == null) {
                        pMSAppInfo2 = null;
                    } else {
                        pMSAppInfo2 = aVar.g;
                    }
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    this.a.X(pMSAppInfo2, pMSAppInfo);
                    if (f92.m(je4Var) && pMSAppInfo2 != null) {
                        f92.c(pMSAppInfo2.appId);
                        return;
                    }
                    return;
                }
                this.a.g = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: r */
        public void e(jg4.a aVar, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, je4Var) == null) {
                super.e(aVar, je4Var);
                p22.k("SwanAppBatchDownloadCallback", "onDownloadError：" + je4Var.toString());
                ee2.f(aVar.b);
                ih3 ih3Var = new ih3();
                ih3Var.k(11L);
                ih3Var.i(je4Var.a);
                ih3Var.d("批量下载，主包下载失败：" + aVar.b);
                ih3Var.f(je4Var.toString());
                if (aVar.a != 0) {
                    if (m82.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + ih3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    l82.c().a(aVar.d, PMSDownloadType.BATCH, ih3Var);
                    p22.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    sl4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: s */
        public void i(jg4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                p22.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: t */
        public void a(jg4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (m82.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: v */
        public void f(jg4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (m82.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                ee2.f(aVar.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m82 a;

        public a(m82 m82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = md4.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (pe4 pe4Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(pe4Var);
                        }
                        this.a.W();
                    }
                }
                if (m82.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ m82 c;

        public c(m82 m82Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m82Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m82Var;
            this.a = pMSAppInfo;
            this.b = pMSAppInfo2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PMSAppInfo pMSAppInfo = this.a;
                if (pMSAppInfo != null) {
                    pMSAppInfo.updateInstallSrc(this.c.J());
                    this.b.copyLocalAppInfoData(this.a);
                } else {
                    this.b.updateInstallSrc(this.c.J());
                }
                this.b.initMaxAgeInfo();
                if (md4.i().l(this.b)) {
                    h92.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends w82<m82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m82 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(m82 m82Var, m82 m82Var2) {
            super(m82Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m82Var, m82Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((t82) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void e(pe4 pe4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, pe4Var, je4Var) == null) {
                super.q(pe4Var, je4Var);
                ee2.f(pe4Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: u */
        public void f(pe4 pe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, pe4Var) == null) {
                super.f(pe4Var);
                ee2.f(pe4Var.o);
            }
        }

        @Override // com.baidu.tieba.w82
        public void p(@NonNull pe4 pe4Var, @Nullable ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pe4Var, ih3Var) == null) {
                super.p(pe4Var, ih3Var);
                if (ih3Var == null) {
                    this.c.e.add(pe4Var);
                } else if (m82.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + pe4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ih3Var);
                }
                ee2.f(pe4Var.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends u82<m82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m82 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(m82 m82Var, m82 m82Var2) {
            super(m82Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m82Var, m82Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((t82) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m82Var;
        }

        @Override // com.baidu.tieba.u82
        public void r(@NonNull qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qe4Var) == null) {
                if (m82.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + qe4Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(qe4Var);
                }
                this.b.W();
            }
        }

        @Override // com.baidu.tieba.u82
        public void u(qe4 qe4Var, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qe4Var, ih3Var) == null) {
                p22.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + qe4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ih3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947926466, "Lcom/baidu/tieba/m82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947926466, "Lcom/baidu/tieba/m82;");
                return;
            }
        }
        l = am1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m82() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((j82) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.kd4
    public gd4<pe4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            p22.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.tieba.kd4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            p22.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.tieba.kd4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            p22.k("SwanAppBatchDownloadCallback", "onNoPackage");
            j82 j82Var = this.d;
            if (j82Var != null) {
                j82Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.kd4
    public gd4<qe4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public cd4<jg4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (cd4) invokeV.objValue;
    }

    public m82(j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j82Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = new b(this);
        this.j = new d(this, this);
        this.k = new e(this, this);
        this.d = j82Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }

    @Override // com.baidu.tieba.kd4
    public void G(xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xi4Var) == null) {
            super.G(xi4Var);
            this.c = xi4Var;
            ee2.e(xi4Var);
            p22.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + xi4Var.n());
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) != null) || pMSAppInfo == null) {
            return;
        }
        ji3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je4Var) == null) {
            super.C(je4Var);
            p22.k("SwanAppBatchDownloadCallback", "onFetchError: " + je4Var.toString());
            j82 j82Var = this.d;
            if (j82Var != null) {
                j82Var.b(je4Var.a);
            }
        }
    }

    public final boolean V(jg4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!cj3.a(new File(aVar.d.a), aVar.d.m)) {
                p22.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            ih3 m = h92.m(aVar.d, this);
            if (m != null) {
                p22.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            h92.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!md4.i().a(aVar.d, aVar.g)) {
                p22.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                h92.o(aVar.g);
            }
            h92.b(aVar.d);
            oe4 oe4Var = aVar.d;
            if (oe4Var != null) {
                b63.c(lo2.e.i(oe4Var.g, String.valueOf(oe4Var.i)).getAbsolutePath(), true);
            }
            oe4 oe4Var2 = aVar.d;
            if (oe4Var2 == null || oe4Var2.h != 0 || ((c2 = h42.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            e82 i2 = e82.i();
            oe4 oe4Var3 = aVar.d;
            i2.f(oe4Var3.g, oe4Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        j82 j82Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet == n && !this.g && (j82Var = this.d) != null) {
                j82Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.kd4, com.baidu.tieba.hd4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            p22.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                ji3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            j82 j82Var = this.d;
            if (j82Var != null) {
                j82Var.h();
            }
            if (!fe2.a()) {
                p22.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
                zd2 d2 = be2.c().d();
                CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
                kf2 l2 = kf2.l();
                l2.i(7);
                d2.t(copyOnWriteArraySet, false, l2.k());
            }
        }
    }
}
