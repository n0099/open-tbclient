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
import com.baidu.tieba.na2;
import com.baidu.tieba.pm4;
import com.baidu.tieba.ru2;
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
public class se2 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public dp4 c;
    public pe2 d;
    public final List<vk4> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public ij4<pm4.a> i;
    public mj4<vk4> j;
    public final mj4<wk4> k;

    @Override // com.baidu.tieba.ze2
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class b extends ij4<pm4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se2 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pm4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, pm4.a aVar) {
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
                        lf2.c(this.a.g.appId);
                    }
                    kk2.f(this.a.b);
                }
            }
        }

        public b(se2 se2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se2Var;
        }

        @Override // com.baidu.tieba.ij4
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                fe3.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: q */
        public String d(pm4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return nf2.g();
                }
                if (i != 1) {
                    return null;
                }
                return nf2.i();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: u */
        public void c(pm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                v82.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        @Override // com.baidu.tieba.oj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ij4
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    fe3.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        @Override // com.baidu.tieba.ij4
        public void o(pm4.a aVar, PMSAppInfo pMSAppInfo, pk4 pk4Var) {
            PMSAppInfo pMSAppInfo2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, pk4Var) == null) {
                v82.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + pk4Var.a + " errorMsg=" + pk4Var.b + " errorDetails=" + pk4Var.d);
                if (this.a.d != null) {
                    this.a.d.f(pk4Var);
                }
                if (pk4Var.a == 1010) {
                    if (aVar == null) {
                        pMSAppInfo2 = null;
                    } else {
                        pMSAppInfo2 = aVar.g;
                    }
                    if (pMSAppInfo2 == null) {
                        pMSAppInfo2 = pMSAppInfo;
                    }
                    this.a.X(pMSAppInfo2, pMSAppInfo);
                    if (lf2.m(pk4Var) && pMSAppInfo2 != null) {
                        lf2.c(pMSAppInfo2.appId);
                        return;
                    }
                    return;
                }
                this.a.g = true;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void e(pm4.a aVar, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, pk4Var) == null) {
                super.e(aVar, pk4Var);
                v82.k("SwanAppBatchDownloadCallback", "onDownloadError：" + pk4Var.toString());
                kk2.f(aVar.b);
                on3 on3Var = new on3();
                on3Var.k(11L);
                on3Var.i(pk4Var.a);
                on3Var.d("批量下载，主包下载失败：" + aVar.b);
                on3Var.f(pk4Var.toString());
                if (aVar.a != 0) {
                    if (se2.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + on3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    re2.c().a(aVar.d, PMSDownloadType.BATCH, on3Var);
                    v82.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    zr4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: s */
        public void i(pm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                v82.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: t */
        public void a(pm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (se2.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: v */
        public void f(pm4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (se2.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                kk2.f(aVar.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se2 a;

        public a(se2 se2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = sj4.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (vk4 vk4Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(vk4Var);
                        }
                        this.a.W();
                    }
                }
                if (se2.l) {
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
        public final /* synthetic */ se2 c;

        public c(se2 se2Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se2Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = se2Var;
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
                if (sj4.i().l(this.b)) {
                    nf2.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends cf2<se2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(se2 se2Var, se2 se2Var2) {
            super(se2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se2Var, se2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ze2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = se2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void e(vk4 vk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, vk4Var, pk4Var) == null) {
                super.q(vk4Var, pk4Var);
                kk2.f(vk4Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: u */
        public void f(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, vk4Var) == null) {
                super.f(vk4Var);
                kk2.f(vk4Var.o);
            }
        }

        @Override // com.baidu.tieba.cf2
        public void p(@NonNull vk4 vk4Var, @Nullable on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vk4Var, on3Var) == null) {
                super.p(vk4Var, on3Var);
                if (on3Var == null) {
                    this.c.e.add(vk4Var);
                } else if (se2.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + vk4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + on3Var);
                }
                kk2.f(vk4Var.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends af2<se2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(se2 se2Var, se2 se2Var2) {
            super(se2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se2Var, se2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ze2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = se2Var;
        }

        @Override // com.baidu.tieba.af2
        public void r(@NonNull wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wk4Var) == null) {
                if (se2.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + wk4Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(wk4Var);
                }
                this.b.W();
            }
        }

        @Override // com.baidu.tieba.af2
        public void u(wk4 wk4Var, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wk4Var, on3Var) == null) {
                v82.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + wk4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + on3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948148457, "Lcom/baidu/tieba/se2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948148457, "Lcom/baidu/tieba/se2;");
                return;
            }
        }
        l = fs1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public se2() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((pe2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.qj4
    public mj4<vk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            v82.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.tieba.qj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            v82.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.tieba.qj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            v82.k("SwanAppBatchDownloadCallback", "onNoPackage");
            pe2 pe2Var = this.d;
            if (pe2Var != null) {
                pe2Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.qj4
    public mj4<wk4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public ij4<pm4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (ij4) invokeV.objValue;
    }

    public se2(pe2 pe2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pe2Var};
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
        this.d = pe2Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }

    @Override // com.baidu.tieba.qj4
    public void G(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dp4Var) == null) {
            super.G(dp4Var);
            this.c = dp4Var;
            kk2.e(dp4Var);
            v82.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + dp4Var.n());
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) != null) || pMSAppInfo == null) {
            return;
        }
        po3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk4Var) == null) {
            super.C(pk4Var);
            v82.k("SwanAppBatchDownloadCallback", "onFetchError: " + pk4Var.toString());
            pe2 pe2Var = this.d;
            if (pe2Var != null) {
                pe2Var.b(pk4Var.a);
            }
        }
    }

    public final boolean V(pm4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!ip3.a(new File(aVar.d.a), aVar.d.m)) {
                v82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            on3 m = nf2.m(aVar.d, this);
            if (m != null) {
                v82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            nf2.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!sj4.i().a(aVar.d, aVar.g)) {
                v82.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                nf2.o(aVar.g);
            }
            nf2.b(aVar.d);
            uk4 uk4Var = aVar.d;
            if (uk4Var != null) {
                hc3.c(ru2.e.i(uk4Var.g, String.valueOf(uk4Var.i)).getAbsolutePath(), true);
            }
            uk4 uk4Var2 = aVar.d;
            if (uk4Var2 == null || uk4Var2.h != 0 || ((c2 = na2.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            ke2 i2 = ke2.i();
            uk4 uk4Var3 = aVar.d;
            i2.f(uk4Var3.g, uk4Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        pe2 pe2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet == n && !this.g && (pe2Var = this.d) != null) {
                pe2Var.a();
            }
        }
    }

    @Override // com.baidu.tieba.qj4, com.baidu.tieba.nj4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            v82.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                po3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            pe2 pe2Var = this.d;
            if (pe2Var != null) {
                pe2Var.h();
            }
            if (!lk2.a()) {
                v82.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
                fk2 d2 = hk2.c().d();
                CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
                ql2 l2 = ql2.l();
                l2.i(7);
                d2.t(copyOnWriteArraySet, false, l2.k());
            }
        }
    }
}
