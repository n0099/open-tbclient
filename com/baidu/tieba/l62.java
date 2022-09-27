package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fx9;
import com.baidu.tieba.h62;
import com.baidu.tieba.p33;
import com.baidu.tieba.vc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class l62 extends p62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public fb4 A;
    public lx9<jc4> B;
    public String c;
    public lx9<? super kc4> d;
    public lx9<? super lc4> e;
    public lx9<? super ic4> f;
    public lx9<? super gc4> g;
    public lx9<? super mc4> h;
    public tg4 i;
    public kc4 j;
    public List<lc4> k;
    public ic4 l;
    public gc4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public lc4 q;
    public long r;
    public final Set<u62> s;
    public final Set<ei3<PMSAppInfo>> t;
    public final oh3 u;
    public cb4<kc4> v;
    public cb4<lc4> w;
    public final cb4<mc4> x;
    public cb4<ic4> y;
    public cb4<gc4> z;

    /* loaded from: classes4.dex */
    public class a extends za4<kc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        /* renamed from: com.baidu.tieba.l62$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0324a implements ei3<p33.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0324a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(p33.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    hb4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        @Override // com.baidu.tieba.za4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb4
        /* renamed from: l */
        public String d(kc4 kc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, kc4Var)) == null) {
                int i = kc4Var.h;
                if (i == 0) {
                    return d72.g();
                }
                if (i == 1) {
                    return d72.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.eb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: o */
        public void e(kc4 kc4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, kc4Var, fc4Var) == null) {
                super.e(kc4Var, fc4Var);
                l02.k("SwanAppPkgDownloadCallback", "onDownloadError：" + fc4Var.toString());
                this.a.i.l(kc4Var);
                ef3 ef3Var = new ef3();
                ef3Var.k(11L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("主包下载失败");
                ef3Var.f(fc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(kc4Var, ef3Var));
                }
                h62.c().a(kc4Var, this.a.k0(), ef3Var);
                pj4.k(kc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: p */
        public void i(kc4 kc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, kc4Var) == null) {
                String l0 = this.a.l0();
                if (l62.C) {
                    qo2.d(l0).e().d(1);
                }
                super.i(kc4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                ef3 z0 = this.a.z0(kc4Var);
                l02.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + kc4Var.i);
                if (z0 == null) {
                    l62 l62Var = this.a;
                    l62Var.j = kc4Var;
                    l62Var.i.m(kc4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(kc4Var);
                        if (l62.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    h62.c().b(kc4Var, this.a.k0());
                    return;
                }
                this.a.i.l(kc4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(kc4Var, z0));
                }
                h62.c().a(kc4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void c(kc4 kc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, kc4Var) == null) {
                String l0 = this.a.l0();
                if (l62.C) {
                    qo2.d(l0).e().d(1);
                }
                super.c(kc4Var);
                l02.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: r */
        public void f(kc4 kc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, kc4Var) == null) {
                String l0 = this.a.l0();
                if (l62.C) {
                    qo2.d(l0).e().d(1);
                }
                super.f(kc4Var);
                if (l62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(kc4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: s */
        public fc4 h(kc4 kc4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{kc4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (l62.C) {
                    qo2.d(l0).f(kc4Var.toString()).d(1);
                }
                C0324a c0324a = new C0324a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                jm2 jm2Var = new jm2();
                jm2Var.u(c0324a);
                jm2Var.K(bundle);
                jm2Var.J(new im2(kc4Var, this.a));
                jm2Var.J(new gm2(kc4Var.m, this.a));
                jm2Var.M(readableByteChannel);
                boolean N = jm2Var.N();
                jm2Var.o(c0324a);
                if (l62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    l02.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    pj4.L(file);
                }
                return N ? new fc4(2300, "业务层处理下载流成功") : new fc4(2301, "业务层处理下载流失败");
            }
            return (fc4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ ei3 b;

        public b(l62 l62Var, Collection collection, ei3 ei3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, collection, ei3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = ei3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Object obj : this.a) {
                    this.b.a(obj);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ei3<u62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei3 a;
        public final /* synthetic */ l62 b;

        public c(l62 l62Var, ei3 ei3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, ei3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l62Var;
            this.a = ei3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u62Var) == null) {
                this.a.a(u62Var);
                l62 l62Var = this.b;
                l62Var.h0(l62Var.s, u62Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ei3<u62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ef3 a;
        public final /* synthetic */ boolean b;

        public d(l62 l62Var, ef3 ef3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, ef3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ef3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u62Var) == null) {
                u62Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ei3<u62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(l62 l62Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(u62 u62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u62Var) == null) {
                u62Var.b(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc4 a;
        public final /* synthetic */ l62 b;

        public f(l62 l62Var, kc4 kc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, kc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l62Var;
            this.a = kc4Var;
        }

        @Override // com.baidu.tieba.h62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                l62 l62Var = this.b;
                kc4 kc4Var = this.a;
                l62Var.j = kc4Var;
                l62Var.i.m(kc4Var);
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
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ef3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc4 a;
        public final /* synthetic */ l62 b;

        public g(l62 l62Var, lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, lc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l62Var;
            this.a = lc4Var;
        }

        @Override // com.baidu.tieba.h62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                l62 l62Var = this.b;
                if (l62Var.k == null) {
                    l62Var.k = new ArrayList();
                }
                lc4 lc4Var = this.a;
                l62 l62Var2 = this.b;
                lc4Var.o = l62Var2.o;
                l62Var2.k.add(lc4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (this.b.i.i()) {
                        return;
                    }
                    this.b.e.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, ef3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic4 a;
        public final /* synthetic */ l62 b;

        public h(l62 l62Var, ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, ic4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l62Var;
            this.a = ic4Var;
        }

        @Override // com.baidu.tieba.h62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                l62 l62Var = this.b;
                ic4 ic4Var = this.a;
                l62Var.l = ic4Var;
                l62Var.i.m(ic4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, ef3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc4 a;
        public final /* synthetic */ l62 b;

        public i(l62 l62Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, gc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l62Var;
            this.a = gc4Var;
        }

        @Override // com.baidu.tieba.h62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                l02.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                l62 l62Var = this.b;
                gc4 gc4Var = this.a;
                l62Var.m = gc4Var;
                l62Var.i.m(gc4Var);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                l02.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + ef3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends lx9<jc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 e;

        public j(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gx9
        /* renamed from: g */
        public void onNext(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jc4Var) == null) {
                l02.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + jc4Var.i);
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l02.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }

        @Override // com.baidu.tieba.gx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                l02.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements fx9.a<kc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public k(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super kc4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.d = lx9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements fx9.a<lc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public l(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super lc4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.e = lx9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements fx9.a<ic4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public m(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super ic4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.f = lx9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements fx9.a<gc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public n(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super gc4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.g = lx9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements fx9.a<mc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public o(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
        public void call(lx9<? super mc4> lx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
                this.a.h = lx9Var;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends s62<l62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(l62 l62Var, l62 l62Var2) {
            super(l62Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, l62Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((p62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l62Var;
        }

        @Override // com.baidu.tieba.s62, com.baidu.tieba.za4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.j0() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.s62
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.s62
        public void p(@NonNull lc4 lc4Var, @Nullable ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, lc4Var, ef3Var) == null) {
                super.p(lc4Var, ef3Var);
                l02.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + lc4Var.i);
                l62 l62Var = this.c;
                if (l62Var.k == null) {
                    l62Var.k = new ArrayList();
                }
                l62 l62Var2 = this.c;
                lc4Var.o = l62Var2.o;
                if (ef3Var == null) {
                    l62Var2.k.add(lc4Var);
                    this.c.i.m(lc4Var);
                    h62.c().b(lc4Var, this.c.k0());
                } else {
                    l62Var2.i.l(lc4Var);
                    h62.c().a(lc4Var, this.c.k0(), ef3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(lc4Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void e(lc4 lc4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, lc4Var, fc4Var) == null) {
                super.q(lc4Var, fc4Var);
                l02.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + fc4Var.toString());
                this.c.i.l(lc4Var);
                ef3 ef3Var = new ef3();
                ef3Var.k(12L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("分包下载失败");
                ef3Var.f(fc4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(lc4Var, ef3Var));
                }
                h62.c().a(lc4Var, this.c.k0(), ef3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s62, com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: s */
        public void c(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, lc4Var) == null) {
                super.c(lc4Var);
                l02.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: u */
        public void f(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lc4Var) == null) {
                super.f(lc4Var);
                this.c.E0(lc4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends q62<l62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(l62 l62Var, l62 l62Var2) {
            super(l62Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, l62Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((p62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l62Var;
        }

        @Override // com.baidu.tieba.za4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.j0() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.q62
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q62
        public void r(@NonNull mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, mc4Var) == null) {
                this.b.i.m(mc4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(mc4Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.q62
        public void u(mc4 mc4Var, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, mc4Var, ef3Var) == null) {
                l02.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + ef3Var);
                this.b.i.l(mc4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(mc4Var, ef3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q62, com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: v */
        public void c(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, mc4Var) == null) {
                super.c(mc4Var);
                l02.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q62, com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: w */
        public void f(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, mc4Var) == null) {
                super.f(mc4Var);
                if (l62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends za4<ic4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public r(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        @Override // com.baidu.tieba.za4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb4
        /* renamed from: l */
        public String d(ic4 ic4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ic4Var)) == null) {
                int i = ic4Var.h;
                if (i == 0) {
                    return d72.h();
                }
                if (i == 1) {
                    return d72.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.eb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: o */
        public void e(ic4 ic4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ic4Var, fc4Var) == null) {
                super.e(ic4Var, fc4Var);
                l02.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + fc4Var.toString());
                this.a.i.l(ic4Var);
                ef3 ef3Var = new ef3();
                ef3Var.k(13L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("Framework包下载失败");
                ef3Var.f(fc4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ic4Var, ef3Var));
                }
                h62.c().a(ic4Var, this.a.k0(), ef3Var);
                pj4.k(ic4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: p */
        public void i(ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ic4Var) == null) {
                super.i(ic4Var);
                l02.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + ic4Var.i);
                ef3 y0 = this.a.y0(ic4Var);
                if (y0 == null) {
                    l62 l62Var = this.a;
                    l62Var.l = ic4Var;
                    l62Var.i.m(ic4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(ic4Var);
                        this.a.f.onCompleted();
                    }
                    h62.c().b(ic4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ic4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ic4Var, y0));
                }
                h62.c().a(ic4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void c(ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ic4Var) == null) {
                super.c(ic4Var);
                l02.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: r */
        public void f(ic4 ic4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ic4Var) == null) {
                super.f(ic4Var);
                if (l62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(ic4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends za4<gc4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public s(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        @Override // com.baidu.tieba.za4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb4
        /* renamed from: l */
        public String d(gc4 gc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gc4Var)) == null) {
                int i = gc4Var.h;
                if (i == 0) {
                    return d72.d();
                }
                if (i == 1) {
                    return d72.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.eb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: o */
        public void e(gc4 gc4Var, fc4 fc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gc4Var, fc4Var) == null) {
                super.e(gc4Var, fc4Var);
                l02.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + fc4Var.toString());
                this.a.i.l(gc4Var);
                ef3 ef3Var = new ef3();
                ef3Var.k(14L);
                ef3Var.i(fc4Var.a);
                ef3Var.d("Extension下载失败");
                ef3Var.f(fc4Var.toString());
                if (l62.C) {
                    Log.e("SwanAppPkgDownloadCallback", ef3Var.toString());
                }
                this.a.q0(gc4Var);
                h62.c().a(gc4Var, this.a.k0(), ef3Var);
                pj4.k(gc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: p */
        public void i(gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, gc4Var) == null) {
                super.i(gc4Var);
                l02.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + gc4Var.i);
                ef3 x0 = this.a.x0(gc4Var);
                if (x0 != null) {
                    if (l62.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + gc4Var.toString());
                    }
                    this.a.i.l(gc4Var);
                    this.a.q0(gc4Var);
                    h62.c().a(gc4Var, this.a.k0(), x0);
                    return;
                }
                l62 l62Var = this.a;
                l62Var.m = gc4Var;
                l62Var.i.m(gc4Var);
                this.a.q0(gc4Var);
                h62.c().b(gc4Var, this.a.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: q */
        public void c(gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gc4Var) == null) {
                super.c(gc4Var);
                l02.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
        /* renamed from: r */
        public void f(gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, gc4Var) == null) {
                super.f(gc4Var);
                if (l62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(gc4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements fb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l62 a;

        public t(l62 l62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l62Var;
        }

        @Override // com.baidu.tieba.fb4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (l62.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                l62 l62Var = this.a;
                l62Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    l62Var.o0(pMSAppInfo);
                    jz2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements ei3<ei3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(l62 l62Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, pMSAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pMSAppInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(ei3<PMSAppInfo> ei3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ei3Var) == null) {
                ei3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(l62 l62Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.add(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(l62 l62Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l62Var, collection, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = collection;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.remove(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894753, "Lcom/baidu/tieba/l62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894753, "Lcom/baidu/tieba/l62;");
                return;
            }
        }
        C = vj1.a;
    }

    public l62(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = "";
        this.r = -1L;
        this.s = new HashSet();
        this.t = new HashSet();
        this.u = new oh3();
        this.v = new a(this);
        this.w = new p(this, this);
        this.x = new q(this, this);
        this.y = new r(this);
        this.z = new s(this);
        this.A = new t(this);
        this.B = new j(this);
        this.o = str;
        this.p = new ArrayList();
    }

    @Override // com.baidu.tieba.gb4
    public cb4<lc4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (cb4) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            ey2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void B0(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gc4Var) == null) {
            h62.c().d(gc4Var, new i(this, gc4Var));
        }
    }

    @Override // com.baidu.tieba.gb4
    public void C(fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fc4Var) == null) {
            l02.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + fc4Var);
            if (fc4Var != null && fc4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(ic4 ic4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ic4Var) == null) {
            h62.c().d(ic4Var, new h(this, ic4Var));
        }
    }

    @Override // com.baidu.tieba.gb4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(kc4 kc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kc4Var) == null) {
            h62.c().d(kc4Var, new f(this, kc4Var));
        }
    }

    @Override // com.baidu.tieba.gb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(lc4 lc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lc4Var) == null) {
            h62.c().d(lc4Var, new g(this, lc4Var));
        }
    }

    public ef3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    ef3 ef3Var = new ef3();
                    ef3Var.k(10L);
                    ef3Var.i(2903L);
                    ef3Var.d("Server未返回主包&AppInfo");
                    return ef3Var;
                }
                PMSAppInfo u2 = ib4.i().u(this.o);
                if (u2 == null) {
                    ef3 ef3Var2 = new ef3();
                    ef3Var2.k(10L);
                    ef3Var2.i(2904L);
                    ef3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return ef3Var2;
                }
                this.n = u2;
                d72.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (ib4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                ef3 ef3Var3 = new ef3();
                ef3Var3.k(10L);
                ef3Var3.i(2906L);
                ef3Var3.d("更新DB失败");
                return ef3Var3;
            }
            kc4 kc4Var = this.j;
            if (kc4Var != null) {
                d72.k(pMSAppInfo, kc4Var);
            } else if (e72.f(this.k)) {
                lc4 lc4Var = this.k.get(0);
                this.q = lc4Var;
                lc4Var.o = this.o;
                d72.l(this.n, lc4Var);
            } else {
                PMSAppInfo u3 = ib4.i().u(this.o);
                if (u3 == null) {
                    ef3 ef3Var4 = new ef3();
                    ef3Var4.k(10L);
                    ef3Var4.i(2905L);
                    ef3Var4.d("Server未返回包数据，本地也没有数据");
                    return ef3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (ib4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                d72.o(this.n);
                return null;
            }
            ef3 ef3Var5 = new ef3();
            ef3Var5.k(10L);
            ef3Var5.i(2906L);
            ef3Var5.d("更新DB失败");
            return ef3Var5;
        }
        return (ef3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb4
    public void G(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tg4Var) == null) {
            super.G(tg4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (tg4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + tg4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = tg4Var;
            if (tg4Var.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = ib4.i().u(this.o);
            l02.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                kc4 kc4Var = this.j;
                if (kc4Var != null) {
                    kc4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                ib4.i().l(u2);
            }
        }
    }

    public l62 e0(ei3<PMSAppInfo> ei3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ei3Var)) == null) {
            f0(this.t, ei3Var);
            return this;
        }
        return (l62) invokeL.objValue;
    }

    public final synchronized <CallbackT> l62 f0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new v(this, collection, callbackt));
                }
            }
            return this;
        }
        return (l62) invokeLL.objValue;
    }

    public synchronized l62 g0(u62 u62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, u62Var)) == null) {
            synchronized (this) {
                f0(this.s, u62Var);
            }
            return this;
        }
        return (l62) invokeL.objValue;
    }

    public final synchronized <CallbackT> l62 h0(Collection<CallbackT> collection, CallbackT callbackt) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, collection, callbackt)) == null) {
            synchronized (this) {
                if (collection != null && callbackt != null) {
                    this.u.a(new w(this, collection, callbackt));
                }
            }
            return this;
        }
        return (l62) invokeLL.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = getClass().toString();
            }
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType k0();

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? hb4.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                ib4.i().z(this.o, i2);
            } else {
                ib4.i().z(this.o, 0);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(fx9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(fx9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(fx9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(fx9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(fx9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            fx9.i(arrayList).u(this.B);
        }
    }

    public l62 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (l62) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gb4
    public fb4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (fb4) invokeV.objValue;
    }

    public final synchronized <CallbackT> l62 p0(@NonNull Collection<CallbackT> collection, @NonNull ei3<CallbackT> ei3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, ei3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, ei3Var));
            }
            return this;
        }
        return (l62) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gb4
    public cb4<mc4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.x : (cb4) invokeV.objValue;
    }

    public final void q0(gc4 gc4Var) {
        lx9<? super gc4> lx9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, gc4Var) == null) || (lx9Var = this.g) == null) {
            return;
        }
        lx9Var.onNext(gc4Var);
        this.g.onCompleted();
    }

    @Override // com.baidu.tieba.gb4
    public cb4<gc4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.z : (cb4) invokeV.objValue;
    }

    public l62 r0(@NonNull ei3<u62> ei3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, ei3Var)) == null) {
            p0(this.s, new c(this, ei3Var));
            return this;
        }
        return (l62) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gb4
    public cb4<ic4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (cb4) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, ef3Var) == null) {
            r0(new d(this, ef3Var, z));
        }
    }

    @Override // com.baidu.tieba.gb4
    public cb4<kc4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (cb4) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = ib4.i().u(this.o);
        if (u2 == null) {
            l02.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (ib4.i().l(this.n)) {
            d72.o(this.n);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            l02.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public ef3 x0(gc4 gc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, gc4Var)) == null) {
            re2 re2Var = new re2();
            re2Var.b = gc4Var.i;
            re2Var.a = gc4Var.j;
            re2Var.c = gc4Var.a;
            re2Var.d = gc4Var.m;
            if (ud2.b(gc4Var.h, re2Var) == null) {
                return null;
            }
            ef3 ef3Var = new ef3();
            ef3Var.k(14L);
            ef3Var.b(2908L);
            ef3Var.d("Extension包更新失败");
            return ef3Var;
        }
        return (ef3) invokeL.objValue;
    }

    public ef3 y0(ic4 ic4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, ic4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + ic4Var);
            }
            vc3.b c2 = vc3.c(ic4Var, ic4Var.h);
            if (!TextUtils.isEmpty(ic4Var.a)) {
                l02.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + ic4Var.a);
                pj4.k(ic4Var.a);
            }
            if (c2.c()) {
                return null;
            }
            ef3 ef3Var = new ef3();
            ef3Var.k(13L);
            ef3Var.b(2907L);
            ef3Var.d("Core包更新失败");
            return ef3Var;
        }
        return (ef3) invokeL.objValue;
    }

    public ef3 z0(kc4 kc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, kc4Var)) == null) {
            if (kc4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(11L);
                ef3Var.i(2310L);
                ef3Var.f("pkg info is empty");
                if3.a().f(ef3Var);
                return ef3Var;
            }
            return null;
        }
        return (ef3) invokeL.objValue;
    }
}
