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
import com.baidu.tieba.c33;
import com.baidu.tieba.ic3;
import com.baidu.tieba.qw9;
import com.baidu.tieba.u52;
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
/* loaded from: classes6.dex */
public abstract class y52 extends c62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public sa4 A;
    public ww9<wb4> B;
    public String c;
    public ww9<? super xb4> d;
    public ww9<? super yb4> e;
    public ww9<? super vb4> f;
    public ww9<? super tb4> g;
    public ww9<? super zb4> h;
    public gg4 i;
    public xb4 j;
    public List<yb4> k;
    public vb4 l;
    public tb4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public yb4 q;
    public long r;
    public final Set<h62> s;
    public final Set<rh3<PMSAppInfo>> t;
    public final bh3 u;
    public pa4<xb4> v;
    public pa4<yb4> w;
    public final pa4<zb4> x;
    public pa4<vb4> y;
    public pa4<tb4> z;

    /* loaded from: classes6.dex */
    public class a extends ma4<xb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        /* renamed from: com.baidu.tieba.y52$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0480a implements rh3<c33.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0480a(a aVar) {
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
            @Override // com.baidu.tieba.rh3
            /* renamed from: b */
            public void a(c33.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    ua4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        @Override // com.baidu.tieba.ma4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pa4
        /* renamed from: l */
        public String d(xb4 xb4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xb4Var)) == null) {
                int i = xb4Var.h;
                if (i == 0) {
                    return q62.g();
                }
                if (i == 1) {
                    return q62.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: o */
        public void e(xb4 xb4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, xb4Var, sb4Var) == null) {
                super.e(xb4Var, sb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "onDownloadError：" + sb4Var.toString());
                this.a.i.l(xb4Var);
                re3 re3Var = new re3();
                re3Var.k(11L);
                re3Var.i(sb4Var.a);
                re3Var.d("主包下载失败");
                re3Var.f(sb4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xb4Var, re3Var));
                }
                u52.c().a(xb4Var, this.a.k0(), re3Var);
                cj4.k(xb4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: p */
        public void i(xb4 xb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, xb4Var) == null) {
                String l0 = this.a.l0();
                if (y52.C) {
                    do2.d(l0).e().d(1);
                }
                super.i(xb4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                re3 z0 = this.a.z0(xb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + xb4Var.i);
                if (z0 == null) {
                    y52 y52Var = this.a;
                    y52Var.j = xb4Var;
                    y52Var.i.m(xb4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(xb4Var);
                        if (y52.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    u52.c().b(xb4Var, this.a.k0());
                    return;
                }
                this.a.i.l(xb4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xb4Var, z0));
                }
                u52.c().a(xb4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void c(xb4 xb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, xb4Var) == null) {
                String l0 = this.a.l0();
                if (y52.C) {
                    do2.d(l0).e().d(1);
                }
                super.c(xb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: r */
        public void f(xb4 xb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, xb4Var) == null) {
                String l0 = this.a.l0();
                if (y52.C) {
                    do2.d(l0).e().d(1);
                }
                super.f(xb4Var);
                if (y52.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(xb4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: s */
        public sb4 h(xb4 xb4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{xb4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (y52.C) {
                    do2.d(l0).f(xb4Var.toString()).d(1);
                }
                C0480a c0480a = new C0480a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                wl2 wl2Var = new wl2();
                wl2Var.u(c0480a);
                wl2Var.K(bundle);
                wl2Var.J(new vl2(xb4Var, this.a));
                wl2Var.J(new tl2(xb4Var.m, this.a));
                wl2Var.M(readableByteChannel);
                boolean N = wl2Var.N();
                wl2Var.o(c0480a);
                if (y52.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    yz1.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    cj4.L(file);
                }
                return N ? new sb4(2300, "业务层处理下载流成功") : new sb4(2301, "业务层处理下载流失败");
            }
            return (sb4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ rh3 b;

        public b(y52 y52Var, Collection collection, rh3 rh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, collection, rh3Var};
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
            this.b = rh3Var;
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

    /* loaded from: classes6.dex */
    public class c implements rh3<h62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh3 a;
        public final /* synthetic */ y52 b;

        public c(y52 y52Var, rh3 rh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, rh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y52Var;
            this.a = rh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(h62 h62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h62Var) == null) {
                this.a.a(h62Var);
                y52 y52Var = this.b;
                y52Var.h0(y52Var.s, h62Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements rh3<h62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ re3 a;
        public final /* synthetic */ boolean b;

        public d(y52 y52Var, re3 re3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, re3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = re3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(h62 h62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h62Var) == null) {
                h62Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements rh3<h62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(y52 y52Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(h62 h62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h62Var) == null) {
                h62Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xb4 a;
        public final /* synthetic */ y52 b;

        public f(y52 y52Var, xb4 xb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, xb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y52Var;
            this.a = xb4Var;
        }

        @Override // com.baidu.tieba.u52.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                y52 y52Var = this.b;
                xb4 xb4Var = this.a;
                y52Var.j = xb4Var;
                y52Var.i.m(xb4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, re3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb4 a;
        public final /* synthetic */ y52 b;

        public g(y52 y52Var, yb4 yb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, yb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y52Var;
            this.a = yb4Var;
        }

        @Override // com.baidu.tieba.u52.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                y52 y52Var = this.b;
                if (y52Var.k == null) {
                    y52Var.k = new ArrayList();
                }
                yb4 yb4Var = this.a;
                y52 y52Var2 = this.b;
                yb4Var.o = y52Var2.o;
                y52Var2.k.add(yb4Var);
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

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, re3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb4 a;
        public final /* synthetic */ y52 b;

        public h(y52 y52Var, vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, vb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y52Var;
            this.a = vb4Var;
        }

        @Override // com.baidu.tieba.u52.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                y52 y52Var = this.b;
                vb4 vb4Var = this.a;
                y52Var.l = vb4Var;
                y52Var.i.m(vb4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, re3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb4 a;
        public final /* synthetic */ y52 b;

        public i(y52 y52Var, tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, tb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y52Var;
            this.a = tb4Var;
        }

        @Override // com.baidu.tieba.u52.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                yz1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                y52 y52Var = this.b;
                tb4 tb4Var = this.a;
                y52Var.m = tb4Var;
                y52Var.i.m(tb4Var);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                yz1.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + re3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends ww9<wb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 e;

        public j(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rw9
        /* renamed from: g */
        public void onNext(wb4 wb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wb4Var) == null) {
                yz1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + wb4Var.i);
            }
        }

        @Override // com.baidu.tieba.rw9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                yz1.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }

        @Override // com.baidu.tieba.rw9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                yz1.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements qw9.a<xb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public k(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super xb4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.d = ww9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements qw9.a<yb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public l(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super yb4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.e = ww9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements qw9.a<vb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public m(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super vb4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.f = ww9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements qw9.a<tb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public n(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super tb4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.g = ww9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements qw9.a<zb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public o(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
        public void call(ww9<? super zb4> ww9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
                this.a.h = ww9Var;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends f62<y52> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(y52 y52Var, y52 y52Var2) {
            super(y52Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, y52Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y52Var;
        }

        @Override // com.baidu.tieba.f62, com.baidu.tieba.ma4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.j0() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.f62
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c.o : (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.f62
        public void p(@NonNull yb4 yb4Var, @Nullable re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, yb4Var, re3Var) == null) {
                super.p(yb4Var, re3Var);
                yz1.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + yb4Var.i);
                y52 y52Var = this.c;
                if (y52Var.k == null) {
                    y52Var.k = new ArrayList();
                }
                y52 y52Var2 = this.c;
                yb4Var.o = y52Var2.o;
                if (re3Var == null) {
                    y52Var2.k.add(yb4Var);
                    this.c.i.m(yb4Var);
                    u52.c().b(yb4Var, this.c.k0());
                } else {
                    y52Var2.i.l(yb4Var);
                    u52.c().a(yb4Var, this.c.k0(), re3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(yb4Var);
                    if (this.c.i.i()) {
                        return;
                    }
                    this.c.e.onCompleted();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void e(yb4 yb4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, yb4Var, sb4Var) == null) {
                super.q(yb4Var, sb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + sb4Var.toString());
                this.c.i.l(yb4Var);
                re3 re3Var = new re3();
                re3Var.k(12L);
                re3Var.i(sb4Var.a);
                re3Var.d("分包下载失败");
                re3Var.f(sb4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(yb4Var, re3Var));
                }
                u52.c().a(yb4Var, this.c.k0(), re3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f62, com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: s */
        public void c(yb4 yb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, yb4Var) == null) {
                super.c(yb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: u */
        public void f(yb4 yb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yb4Var) == null) {
                super.f(yb4Var);
                this.c.E0(yb4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends d62<y52> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(y52 y52Var, y52 y52Var2) {
            super(y52Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, y52Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y52Var;
        }

        @Override // com.baidu.tieba.ma4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.j0() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.d62
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.k0() : (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.d62
        public void r(@NonNull zb4 zb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, zb4Var) == null) {
                this.b.i.m(zb4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(zb4Var);
                    if (this.b.i.c()) {
                        return;
                    }
                    this.b.h.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.d62
        public void u(zb4 zb4Var, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, zb4Var, re3Var) == null) {
                yz1.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + re3Var);
                this.b.i.l(zb4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(zb4Var, re3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.d62, com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: v */
        public void c(zb4 zb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, zb4Var) == null) {
                super.c(zb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.d62, com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: w */
        public void f(zb4 zb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, zb4Var) == null) {
                super.f(zb4Var);
                if (y52.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends ma4<vb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public r(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        @Override // com.baidu.tieba.ma4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pa4
        /* renamed from: l */
        public String d(vb4 vb4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vb4Var)) == null) {
                int i = vb4Var.h;
                if (i == 0) {
                    return q62.h();
                }
                if (i == 1) {
                    return q62.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: o */
        public void e(vb4 vb4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vb4Var, sb4Var) == null) {
                super.e(vb4Var, sb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + sb4Var.toString());
                this.a.i.l(vb4Var);
                re3 re3Var = new re3();
                re3Var.k(13L);
                re3Var.i(sb4Var.a);
                re3Var.d("Framework包下载失败");
                re3Var.f(sb4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(vb4Var, re3Var));
                }
                u52.c().a(vb4Var, this.a.k0(), re3Var);
                cj4.k(vb4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: p */
        public void i(vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, vb4Var) == null) {
                super.i(vb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + vb4Var.i);
                re3 y0 = this.a.y0(vb4Var);
                if (y0 == null) {
                    y52 y52Var = this.a;
                    y52Var.l = vb4Var;
                    y52Var.i.m(vb4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(vb4Var);
                        this.a.f.onCompleted();
                    }
                    u52.c().b(vb4Var, this.a.k0());
                    return;
                }
                this.a.i.l(vb4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(vb4Var, y0));
                }
                u52.c().a(vb4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void c(vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, vb4Var) == null) {
                super.c(vb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: r */
        public void f(vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, vb4Var) == null) {
                super.f(vb4Var);
                if (y52.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(vb4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends ma4<tb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public s(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        @Override // com.baidu.tieba.ma4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.j0() : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pa4
        /* renamed from: l */
        public String d(tb4 tb4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tb4Var)) == null) {
                int i = tb4Var.h;
                if (i == 0) {
                    return q62.d();
                }
                if (i == 1) {
                    return q62.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: o */
        public void e(tb4 tb4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tb4Var, sb4Var) == null) {
                super.e(tb4Var, sb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + sb4Var.toString());
                this.a.i.l(tb4Var);
                re3 re3Var = new re3();
                re3Var.k(14L);
                re3Var.i(sb4Var.a);
                re3Var.d("Extension下载失败");
                re3Var.f(sb4Var.toString());
                if (y52.C) {
                    Log.e("SwanAppPkgDownloadCallback", re3Var.toString());
                }
                this.a.q0(tb4Var);
                u52.c().a(tb4Var, this.a.k0(), re3Var);
                cj4.k(tb4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: p */
        public void i(tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, tb4Var) == null) {
                super.i(tb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + tb4Var.i);
                re3 x0 = this.a.x0(tb4Var);
                if (x0 != null) {
                    if (y52.C) {
                        Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + tb4Var.toString());
                    }
                    this.a.i.l(tb4Var);
                    this.a.q0(tb4Var);
                    u52.c().a(tb4Var, this.a.k0(), x0);
                    return;
                }
                y52 y52Var = this.a;
                y52Var.m = tb4Var;
                y52Var.i.m(tb4Var);
                this.a.q0(tb4Var);
                u52.c().b(tb4Var, this.a.k0());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void c(tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, tb4Var) == null) {
                super.c(tb4Var);
                yz1.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: r */
        public void f(tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, tb4Var) == null) {
                super.f(tb4Var);
                if (y52.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(tb4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements sa4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;

        public t(y52 y52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
        }

        @Override // com.baidu.tieba.sa4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (y52.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                y52 y52Var = this.a;
                y52Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    y52Var.o0(pMSAppInfo);
                    wy2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements rh3<rh3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(y52 y52Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(rh3<PMSAppInfo> rh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rh3Var) == null) {
                rh3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(y52 y52Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, collection, obj};
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

    /* loaded from: classes6.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(y52 y52Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948281075, "Lcom/baidu/tieba/y52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948281075, "Lcom/baidu/tieba/y52;");
                return;
            }
        }
        C = ij1.a;
    }

    public y52(String str) {
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
        this.u = new bh3();
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

    @Override // com.baidu.tieba.ta4
    public pa4<yb4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.w : (pa4) invokeV.objValue;
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            rx2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final void B0(tb4 tb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tb4Var) == null) {
            u52.c().d(tb4Var, new i(this, tb4Var));
        }
    }

    @Override // com.baidu.tieba.ta4
    public void C(sb4 sb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sb4Var) == null) {
            yz1.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + sb4Var);
            if (sb4Var != null && sb4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void C0(vb4 vb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vb4Var) == null) {
            u52.c().d(vb4Var, new h(this, vb4Var));
        }
    }

    @Override // com.baidu.tieba.ta4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    public final void D0(xb4 xb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xb4Var) == null) {
            u52.c().d(xb4Var, new f(this, xb4Var));
        }
    }

    @Override // com.baidu.tieba.ta4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public final void E0(yb4 yb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yb4Var) == null) {
            u52.c().d(yb4Var, new g(this, yb4Var));
        }
    }

    public re3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    re3 re3Var = new re3();
                    re3Var.k(10L);
                    re3Var.i(2903L);
                    re3Var.d("Server未返回主包&AppInfo");
                    return re3Var;
                }
                PMSAppInfo u2 = va4.i().u(this.o);
                if (u2 == null) {
                    re3 re3Var2 = new re3();
                    re3Var2.k(10L);
                    re3Var2.i(2904L);
                    re3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return re3Var2;
                }
                this.n = u2;
                q62.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (va4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                re3 re3Var3 = new re3();
                re3Var3.k(10L);
                re3Var3.i(2906L);
                re3Var3.d("更新DB失败");
                return re3Var3;
            }
            xb4 xb4Var = this.j;
            if (xb4Var != null) {
                q62.k(pMSAppInfo, xb4Var);
            } else if (r62.f(this.k)) {
                yb4 yb4Var = this.k.get(0);
                this.q = yb4Var;
                yb4Var.o = this.o;
                q62.l(this.n, yb4Var);
            } else {
                PMSAppInfo u3 = va4.i().u(this.o);
                if (u3 == null) {
                    re3 re3Var4 = new re3();
                    re3Var4.k(10L);
                    re3Var4.i(2905L);
                    re3Var4.d("Server未返回包数据，本地也没有数据");
                    return re3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (va4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                q62.o(this.n);
                return null;
            }
            re3 re3Var5 = new re3();
            re3Var5.k(10L);
            re3Var5.i(2906L);
            re3Var5.d("更新DB失败");
            return re3Var5;
        }
        return (re3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public void G(gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gg4Var) == null) {
            super.G(gg4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (gg4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + gg4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = gg4Var;
            if (gg4Var.k()) {
                return;
            }
            n0();
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = va4.i().u(this.o);
            yz1.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                xb4 xb4Var = this.j;
                if (xb4Var != null) {
                    xb4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                va4.i().l(u2);
            }
        }
    }

    public y52 e0(rh3<PMSAppInfo> rh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rh3Var)) == null) {
            f0(this.t, rh3Var);
            return this;
        }
        return (y52) invokeL.objValue;
    }

    public final synchronized <CallbackT> y52 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (y52) invokeLL.objValue;
    }

    public synchronized y52 g0(h62 h62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, h62Var)) == null) {
            synchronized (this) {
                f0(this.s, h62Var);
            }
            return this;
        }
        return (y52) invokeL.objValue;
    }

    public final synchronized <CallbackT> y52 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (y52) invokeLL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? ua4.b(this, "get_launch_id").getString("launch_id", "") : (String) invokeV.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                va4.i().z(this.o, i2);
            } else {
                va4.i().z(this.o, 0);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(qw9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(qw9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(qw9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(qw9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(qw9.a(new o(this)));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            qw9.i(arrayList).u(this.B);
        }
    }

    public y52 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (y52) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public sa4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.A : (sa4) invokeV.objValue;
    }

    public final synchronized <CallbackT> y52 p0(@NonNull Collection<CallbackT> collection, @NonNull rh3<CallbackT> rh3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, rh3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, rh3Var));
            }
            return this;
        }
        return (y52) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public pa4<zb4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.x : (pa4) invokeV.objValue;
    }

    public final void q0(tb4 tb4Var) {
        ww9<? super tb4> ww9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, tb4Var) == null) || (ww9Var = this.g) == null) {
            return;
        }
        ww9Var.onNext(tb4Var);
        this.g.onCompleted();
    }

    @Override // com.baidu.tieba.ta4
    public pa4<tb4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.z : (pa4) invokeV.objValue;
    }

    public y52 r0(@NonNull rh3<h62> rh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, rh3Var)) == null) {
            p0(this.s, new c(this, rh3Var));
            return this;
        }
        return (y52) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public pa4<vb4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.y : (pa4) invokeV.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void t0(boolean z, re3 re3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, re3Var) == null) {
            r0(new d(this, re3Var, z));
        }
    }

    @Override // com.baidu.tieba.ta4
    public pa4<xb4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (pa4) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = va4.i().u(this.o);
        if (u2 == null) {
            yz1.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (va4.i().l(this.n)) {
            q62.o(this.n);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            yz1.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public abstract void w0(Throwable th);

    public re3 x0(tb4 tb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, tb4Var)) == null) {
            ee2 ee2Var = new ee2();
            ee2Var.b = tb4Var.i;
            ee2Var.a = tb4Var.j;
            ee2Var.c = tb4Var.a;
            ee2Var.d = tb4Var.m;
            if (hd2.b(tb4Var.h, ee2Var) == null) {
                return null;
            }
            re3 re3Var = new re3();
            re3Var.k(14L);
            re3Var.b(2908L);
            re3Var.d("Extension包更新失败");
            return re3Var;
        }
        return (re3) invokeL.objValue;
    }

    public re3 y0(vb4 vb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, vb4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + vb4Var);
            }
            ic3.b c2 = ic3.c(vb4Var, vb4Var.h);
            if (!TextUtils.isEmpty(vb4Var.a)) {
                yz1.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + vb4Var.a);
                cj4.k(vb4Var.a);
            }
            if (c2.c()) {
                return null;
            }
            re3 re3Var = new re3();
            re3Var.k(13L);
            re3Var.b(2907L);
            re3Var.d("Core包更新失败");
            return re3Var;
        }
        return (re3) invokeL.objValue;
    }

    public re3 z0(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, xb4Var)) == null) {
            if (xb4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(11L);
                re3Var.i(2310L);
                re3Var.f("pkg info is empty");
                ve3.a().f(re3Var);
                return re3Var;
            }
            return null;
        }
        return (re3) invokeL.objValue;
    }
}
