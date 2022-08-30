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
import com.baidu.tieba.sb4;
import com.baidu.tieba.sz1;
import com.baidu.tieba.wj2;
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
/* loaded from: classes6.dex */
public class x32 extends e42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public ge4 c;
    public u32 d;
    public final List<y94> e;
    public AtomicInteger f;
    public boolean g;
    public final CopyOnWriteArraySet<String> h;
    public l84<sb4.a> i;
    public p84<y94> j;
    public final p84<z94> k;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x32 a;

        public a(x32 x32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean b = v84.i().b(null, this.a.e, null, null, null);
                if (b) {
                    for (y94 y94Var : this.a.e) {
                        if (this.a.d != null) {
                            this.a.d.g(y94Var);
                        }
                        this.a.W();
                    }
                }
                if (x32.l) {
                    Log.e("SwanAppBatchDownloadCallback", "update subPkgList =" + b + ", size=" + this.a.e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends l84<sb4.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x32 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sb4.a a;
            public final /* synthetic */ b b;

            public a(b bVar, sb4.a aVar) {
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
                        q42.c(this.a.g.appId);
                    }
                    p92.f(this.a.b);
                }
            }
        }

        public b(x32 x32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x32Var;
        }

        @Override // com.baidu.tieba.l84
        public void l(@NonNull PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, pMSAppInfo) == null) && pMSAppInfo.isForbiddenApp()) {
                k33.L(pMSAppInfo.appId, pMSAppInfo.appStatus);
            }
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.l84
        public void o(sb4.a aVar, PMSAppInfo pMSAppInfo, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, pMSAppInfo, s94Var) == null) {
                ay1.k("SwanAppBatchDownloadCallback", "#onSingleFetchError errorNo=" + s94Var.a + " errorMsg=" + s94Var.b + " errorDetails=" + s94Var.d);
                if (this.a.d != null) {
                    this.a.d.f(s94Var);
                }
                if (s94Var.a != 1010) {
                    this.a.g = true;
                    return;
                }
                PMSAppInfo pMSAppInfo2 = aVar == null ? null : aVar.g;
                if (pMSAppInfo2 == null) {
                    pMSAppInfo2 = pMSAppInfo;
                }
                this.a.X(pMSAppInfo2, pMSAppInfo);
                if (!q42.m(s94Var) || pMSAppInfo2 == null) {
                    return;
                }
                q42.c(pMSAppInfo2.appId);
            }
        }

        @Override // com.baidu.tieba.l84
        public void p(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) {
                if (pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                    k33.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
                }
                this.a.X(pMSAppInfo, pMSAppInfo2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: q */
        public String d(sb4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                int i = aVar.c;
                if (i == 0) {
                    return s42.g();
                }
                if (i == 1) {
                    return s42.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: r */
        public void e(sb4.a aVar, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, s94Var) == null) {
                super.e(aVar, s94Var);
                ay1.k("SwanAppBatchDownloadCallback", "onDownloadError：" + s94Var.toString());
                p92.f(aVar.b);
                tc3 tc3Var = new tc3();
                tc3Var.k(11L);
                tc3Var.i(s94Var.a);
                tc3Var.d("批量下载，主包下载失败：" + aVar.b);
                tc3Var.f(s94Var.toString());
                if (aVar.a != 0) {
                    if (x32.l) {
                        Log.e("SwanAppBatchDownloadCallback", "onDownloadError: " + tc3Var.toString());
                    }
                } else if (aVar.d == null) {
                } else {
                    this.a.c.l(aVar.d);
                    w32.c().a(aVar.d, PMSDownloadType.BATCH, tc3Var);
                    ay1.k("SwanAppBatchDownloadCallback", "#onDownloadError del: " + aVar.d.a);
                    ch4.k(aVar.d.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: s */
        public void i(sb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
                super.i(aVar);
                ay1.k("SwanAppBatchDownloadCallback", "onFileDownloaded: " + aVar.d.i);
                this.a.h.add(aVar.b);
                a aVar2 = new a(this, aVar);
                ExecutorUtilsExt.postOnSerial(aVar2, aVar.d.g + " 下载完成，执行签名校验-重命名-解压-DB");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: t */
        public void a(sb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
                super.a(aVar);
                if (x32.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloadProgress: " + aVar.d.b + "/" + aVar.d.k);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: u */
        public void c(sb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
                super.c(aVar);
                ay1.k("SwanAppBatchDownloadCallback", "onDownloadStart: " + aVar.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: v */
        public void f(sb4.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
                if (x32.l) {
                    Log.i("SwanAppBatchDownloadCallback", "onDownloading:" + aVar.b);
                }
                p92.f(aVar.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ x32 c;

        public c(x32 x32Var, PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, pMSAppInfo, pMSAppInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x32Var;
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
                if (v84.i().l(this.b)) {
                    s42.o(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends h42<x32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x32 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x32 x32Var, x32 x32Var2) {
            super(x32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, x32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((e42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x32Var;
        }

        @Override // com.baidu.tieba.h42
        public void p(@NonNull y94 y94Var, @Nullable tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, y94Var, tc3Var) == null) {
                super.p(y94Var, tc3Var);
                if (tc3Var == null) {
                    this.c.e.add(y94Var);
                } else if (x32.l) {
                    Log.w("SwanAppBatchDownloadCallback", "onDownloadAndUnzipFinish " + y94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + tc3Var);
                }
                p92.f(y94Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void e(y94 y94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, y94Var, s94Var) == null) {
                super.q(y94Var, s94Var);
                p92.f(y94Var.o);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: u */
        public void f(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, y94Var) == null) {
                super.f(y94Var);
                p92.f(y94Var.o);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends f42<x32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(x32 x32Var, x32 x32Var2) {
            super(x32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x32Var, x32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((e42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x32Var;
        }

        @Override // com.baidu.tieba.f42
        public void r(@NonNull z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z94Var) == null) {
                if (x32.l) {
                    Log.v("SwanAppBatchDownloadCallback", "onDownloadAndUnzipSuccess:" + z94Var);
                }
                if (this.b.d != null) {
                    this.b.d.e(z94Var);
                }
                this.b.W();
            }
        }

        @Override // com.baidu.tieba.f42
        public void u(z94 z94Var, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z94Var, tc3Var) == null) {
                ay1.k("SwanAppBatchDownloadCallback", "onDownloadOrUnzipFail:" + z94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + tc3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249362, "Lcom/baidu/tieba/x32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249362, "Lcom/baidu/tieba/x32;");
                return;
            }
        }
        l = kh1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x32() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((u32) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.t84
    public p84<y94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (p84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t84
    public void C(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s94Var) == null) {
            super.C(s94Var);
            ay1.k("SwanAppBatchDownloadCallback", "onFetchError: " + s94Var.toString());
            u32 u32Var = this.d;
            if (u32Var != null) {
                u32Var.b(s94Var.a);
            }
        }
    }

    @Override // com.baidu.tieba.t84
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.D();
            ay1.k("SwanAppBatchDownloadCallback", "onFetchStart");
        }
    }

    @Override // com.baidu.tieba.t84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.E();
            ay1.k("SwanAppBatchDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.tieba.t84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.F();
            ay1.k("SwanAppBatchDownloadCallback", "onNoPackage");
            u32 u32Var = this.d;
            if (u32Var != null) {
                u32Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.t84
    public void G(ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ge4Var) == null) {
            super.G(ge4Var);
            this.c = ge4Var;
            p92.e(ge4Var);
            ay1.k("SwanAppBatchDownloadCallback", "onPrepareDownload: " + ge4Var.n());
        }
    }

    @Override // com.baidu.tieba.e42
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 7;
        }
        return invokeV.intValue;
    }

    public final boolean V(sb4.a aVar) {
        InterceptResult invokeL;
        int c2;
        PMSAppInfo pMSAppInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar == null || aVar.d == null || aVar.g == null) {
                return false;
            }
            if (!ne3.a(new File(aVar.d.a), aVar.d.m)) {
                ay1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 签名校验失败");
                return false;
            }
            tc3 m = s42.m(aVar.d, this);
            if (m != null) {
                ay1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 解压失败，" + m);
                return false;
            }
            aVar.g.initMaxAgeInfo();
            s42.k(aVar.g, aVar.d);
            aVar.g.updateInstallSrc(J());
            if (!v84.i().a(aVar.d, aVar.g)) {
                ay1.k("SwanAppBatchDownloadCallback", "onMainPkgDownload: 存储DB失败");
                return false;
            }
            this.c.m(aVar.d);
            if (!aVar.h) {
                s42.o(aVar.g);
            }
            s42.b(aVar.d);
            x94 x94Var = aVar.d;
            if (x94Var != null) {
                m13.c(wj2.e.i(x94Var.g, String.valueOf(x94Var.i)).getAbsolutePath(), true);
            }
            x94 x94Var2 = aVar.d;
            if (x94Var2 == null || x94Var2.h != 0 || ((c2 = sz1.b.c()) > 0 && (pMSAppInfo = aVar.g) != null && ((i = pMSAppInfo.rank) == 0 || i > c2))) {
                return true;
            }
            p32 i2 = p32.i();
            x94 x94Var3 = aVar.d;
            i2.f(x94Var3.g, x94Var3.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        u32 u32Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int incrementAndGet = this.f.incrementAndGet();
            int n = this.c.n();
            if (l) {
                Log.d("SwanAppBatchDownloadCallback", "batch download,total pkg num - " + n + ",success num - " + incrementAndGet);
            }
            if (incrementAndGet != n || this.g || (u32Var = this.d) == null) {
                return;
            }
            u32Var.a();
        }
    }

    public final void X(@Nullable PMSAppInfo pMSAppInfo, @Nullable PMSAppInfo pMSAppInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pMSAppInfo, pMSAppInfo2) == null) || pMSAppInfo == null) {
            return;
        }
        ud3.k(new c(this, pMSAppInfo2, pMSAppInfo), "批量下载-只更新AppInfo-存储DB");
    }

    @Override // com.baidu.tieba.t84, com.baidu.tieba.q84
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            ay1.k("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            if (l) {
                Log.e("SwanAppBatchDownloadCallback", "onTotalPkgDownloadFinish");
            }
            if (!this.e.isEmpty()) {
                ud3.k(new a(this), "SwanAppBatchDownloadCallback");
            }
            u32 u32Var = this.d;
            if (u32Var != null) {
                u32Var.h();
            }
            if (q92.a()) {
                return;
            }
            ay1.k("SwanAppBatchDownloadCallback", "#onTotalPkgDownloadFinish excludeIds=" + this.h);
            k92 d2 = m92.c().d();
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.h;
            va2 l2 = va2.l();
            l2.i(7);
            d2.t(copyOnWriteArraySet, false, l2.k());
        }
    }

    @Override // com.baidu.tieba.t84
    public p84<z94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (p84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t84
    public l84<sb4.a> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (l84) invokeV.objValue;
    }

    public x32(u32 u32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u32Var};
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
        this.d = u32Var;
        this.e = new Vector();
        this.f = new AtomicInteger(0);
        this.h = new CopyOnWriteArraySet<>();
    }
}
