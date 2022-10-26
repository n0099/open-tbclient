package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.i62;
import com.baidu.tieba.q33;
import com.baidu.tieba.wc3;
import com.baidu.tieba.xx9;
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
public abstract class m62 extends q62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public gb4 A;
    public dy9 B;
    public String c;
    public dy9 d;
    public dy9 e;
    public dy9 f;
    public dy9 g;
    public dy9 h;
    public ug4 i;
    public lc4 j;
    public List k;
    public jc4 l;
    public hc4 m;
    public PMSAppInfo n;
    public String o;
    public List p;
    public mc4 q;
    public long r;
    public final Set s;
    public final Set t;
    public final ph3 u;
    public db4 v;
    public db4 w;
    public final db4 x;
    public db4 y;
    public db4 z;

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public abstract PMSDownloadType k0();

    public abstract void w0(Throwable th);

    /* loaded from: classes4.dex */
    public class a extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        /* renamed from: com.baidu.tieba.m62$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0330a implements fi3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0330a(a aVar) {
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
            @Override // com.baidu.tieba.fi3
            /* renamed from: b */
            public void a(q33.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    ib4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(lc4 lc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lc4Var)) == null) {
                int i = lc4Var.h;
                if (i == 0) {
                    return e72.g();
                }
                if (i == 1) {
                    return e72.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void c(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, lc4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (m62.C) {
                ro2.d(l0).e().d(1);
            }
            super.c(lc4Var);
            m02.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ab4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(lc4 lc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, lc4Var, gc4Var) == null) {
                super.e(lc4Var, gc4Var);
                m02.k("SwanAppPkgDownloadCallback", "onDownloadError：" + gc4Var.toString());
                this.a.i.l(lc4Var);
                ff3 ff3Var = new ff3();
                ff3Var.k(11L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("主包下载失败");
                ff3Var.f(gc4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(lc4Var, ff3Var));
                }
                i62.c().a(lc4Var, this.a.k0(), ff3Var);
                qj4.k(lc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, lc4Var) == null) {
                String l0 = this.a.l0();
                if (m62.C) {
                    ro2.d(l0).e().d(1);
                }
                super.i(lc4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                ff3 z0 = this.a.z0(lc4Var);
                m02.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + lc4Var.i);
                if (z0 == null) {
                    m62 m62Var = this.a;
                    m62Var.j = lc4Var;
                    m62Var.i.m(lc4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(lc4Var);
                        if (m62.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    i62.c().b(lc4Var, this.a.k0());
                    return;
                }
                this.a.i.l(lc4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(lc4Var, z0));
                }
                i62.c().a(lc4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: r */
        public void f(lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, lc4Var) == null) {
                String l0 = this.a.l0();
                if (m62.C) {
                    ro2.d(l0).e().d(1);
                }
                super.f(lc4Var);
                if (m62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(lc4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: s */
        public gc4 h(lc4 lc4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{lc4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (m62.C) {
                    ro2.d(l0).f(lc4Var.toString()).d(1);
                }
                C0330a c0330a = new C0330a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                km2 km2Var = new km2();
                km2Var.u(c0330a);
                km2Var.K(bundle);
                km2Var.J(new jm2(lc4Var, this.a));
                km2Var.J(new hm2(lc4Var.m, this.a));
                km2Var.M(readableByteChannel);
                boolean N = km2Var.N();
                km2Var.o(c0330a);
                if (m62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    m02.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    qj4.L(file);
                }
                if (N) {
                    return new gc4(2300, "业务层处理下载流成功");
                }
                return new gc4(2301, "业务层处理下载流失败");
            }
            return (gc4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ fi3 b;

        public b(m62 m62Var, Collection collection, fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, collection, fi3Var};
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
            this.b = fi3Var;
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
    public class c implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi3 a;
        public final /* synthetic */ m62 b;

        public c(m62 m62Var, fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m62Var;
            this.a = fi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(v62 v62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v62Var) == null) {
                this.a.a(v62Var);
                m62 m62Var = this.b;
                m62Var.h0(m62Var.s, v62Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff3 a;
        public final /* synthetic */ boolean b;

        public d(m62 m62Var, ff3 ff3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, ff3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(v62 v62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v62Var) == null) {
                v62Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(m62 m62Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(v62 v62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v62Var) == null) {
                v62Var.b(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc4 a;
        public final /* synthetic */ m62 b;

        public f(m62 m62Var, lc4 lc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, lc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m62Var;
            this.a = lc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                m62 m62Var = this.b;
                lc4 lc4Var = this.a;
                m62Var.j = lc4Var;
                m62Var.i.m(lc4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ff3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc4 a;
        public final /* synthetic */ m62 b;

        public g(m62 m62Var, mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, mc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m62Var;
            this.a = mc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                m62 m62Var = this.b;
                if (m62Var.k == null) {
                    m62Var.k = new ArrayList();
                }
                mc4 mc4Var = this.a;
                m62 m62Var2 = this.b;
                mc4Var.o = m62Var2.o;
                m62Var2.k.add(mc4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, ff3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc4 a;
        public final /* synthetic */ m62 b;

        public h(m62 m62Var, jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, jc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m62Var;
            this.a = jc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                m62 m62Var = this.b;
                jc4 jc4Var = this.a;
                m62Var.l = jc4Var;
                m62Var.i.m(jc4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, ff3Var));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc4 a;
        public final /* synthetic */ m62 b;

        public i(m62 m62Var, hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, hc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m62Var;
            this.a = hc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                m02.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + ff3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.i62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                m02.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                m62 m62Var = this.b;
                hc4 hc4Var = this.a;
                m62Var.m = hc4Var;
                m62Var.i.m(hc4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends dy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 e;

        public j(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yx9
        /* renamed from: g */
        public void onNext(kc4 kc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kc4Var) == null) {
                m02.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + kc4Var.i);
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                m02.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m02.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public k(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.d = dy9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public l(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.e = dy9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public m(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.f = dy9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public n(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.g = dy9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public o(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dy9Var) != null) {
                return;
            }
            this.a.h = dy9Var;
        }
    }

    /* loaded from: classes4.dex */
    public class p extends t62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(m62 m62Var, m62 m62Var2) {
            super(m62Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, m62Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((q62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t62, com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: s */
        public void c(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, mc4Var) == null) {
                super.c(mc4Var);
                m02.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: u */
        public void f(mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mc4Var) == null) {
                super.f(mc4Var);
                this.c.E0(mc4Var);
            }
        }

        @Override // com.baidu.tieba.t62, com.baidu.tieba.ab4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.t62
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.t62
        public void p(mc4 mc4Var, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, mc4Var, ff3Var) == null) {
                super.p(mc4Var, ff3Var);
                m02.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + mc4Var.i);
                m62 m62Var = this.c;
                if (m62Var.k == null) {
                    m62Var.k = new ArrayList();
                }
                m62 m62Var2 = this.c;
                mc4Var.o = m62Var2.o;
                if (ff3Var == null) {
                    m62Var2.k.add(mc4Var);
                    this.c.i.m(mc4Var);
                    i62.c().b(mc4Var, this.c.k0());
                } else {
                    m62Var2.i.l(mc4Var);
                    i62.c().a(mc4Var, this.c.k0(), ff3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(mc4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void e(mc4 mc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, mc4Var, gc4Var) == null) {
                super.q(mc4Var, gc4Var);
                m02.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + gc4Var.toString());
                this.c.i.l(mc4Var);
                ff3 ff3Var = new ff3();
                ff3Var.k(12L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("分包下载失败");
                ff3Var.f(gc4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(mc4Var, ff3Var));
                }
                i62.c().a(mc4Var, this.c.k0(), ff3Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends r62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(m62 m62Var, m62 m62Var2) {
            super(m62Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, m62Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((q62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m62Var;
        }

        @Override // com.baidu.tieba.r62
        public void u(nc4 nc4Var, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, nc4Var, ff3Var) == null) {
                m02.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + ff3Var);
                this.b.i.l(nc4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(nc4Var, ff3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r62, com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: v */
        public void c(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, nc4Var) == null) {
                super.c(nc4Var);
                m02.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ab4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.r62
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.r62
        public void r(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, nc4Var) == null) {
                this.b.i.m(nc4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(nc4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r62, com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: w */
        public void f(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, nc4Var) == null) {
                super.f(nc4Var);
                if (m62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public r(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(jc4 jc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jc4Var)) == null) {
                int i = jc4Var.h;
                if (i == 0) {
                    return e72.h();
                }
                if (i == 1) {
                    return e72.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void c(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jc4Var) == null) {
                super.c(jc4Var);
                m02.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ab4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(jc4 jc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jc4Var, gc4Var) == null) {
                super.e(jc4Var, gc4Var);
                m02.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + gc4Var.toString());
                this.a.i.l(jc4Var);
                ff3 ff3Var = new ff3();
                ff3Var.k(13L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("Framework包下载失败");
                ff3Var.f(gc4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(jc4Var, ff3Var));
                }
                i62.c().a(jc4Var, this.a.k0(), ff3Var);
                qj4.k(jc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, jc4Var) == null) {
                super.i(jc4Var);
                m02.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + jc4Var.i);
                ff3 y0 = this.a.y0(jc4Var);
                if (y0 == null) {
                    m62 m62Var = this.a;
                    m62Var.l = jc4Var;
                    m62Var.i.m(jc4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(jc4Var);
                        this.a.f.onCompleted();
                    }
                    i62.c().b(jc4Var, this.a.k0());
                    return;
                }
                this.a.i.l(jc4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(jc4Var, y0));
                }
                i62.c().a(jc4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: r */
        public void f(jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, jc4Var) == null) {
                super.f(jc4Var);
                if (m62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(jc4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s extends ab4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public s(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db4
        /* renamed from: l */
        public String d(hc4 hc4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hc4Var)) == null) {
                int i = hc4Var.h;
                if (i == 0) {
                    return e72.d();
                }
                if (i == 1) {
                    return e72.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: q */
        public void c(hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hc4Var) == null) {
                super.c(hc4Var);
                m02.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.fb4
        public Bundle m(Bundle bundle, Set set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.ab4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: o */
        public void e(hc4 hc4Var, gc4 gc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hc4Var, gc4Var) == null) {
                super.e(hc4Var, gc4Var);
                m02.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + gc4Var.toString());
                this.a.i.l(hc4Var);
                ff3 ff3Var = new ff3();
                ff3Var.k(14L);
                ff3Var.i(gc4Var.a);
                ff3Var.d("Extension下载失败");
                ff3Var.f(gc4Var.toString());
                if (m62.C) {
                    Log.e("SwanAppPkgDownloadCallback", ff3Var.toString());
                }
                this.a.q0(hc4Var);
                i62.c().a(hc4Var, this.a.k0(), ff3Var);
                qj4.k(hc4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: p */
        public void i(hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hc4Var) == null) {
                super.i(hc4Var);
                m02.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + hc4Var.i);
                ff3 x0 = this.a.x0(hc4Var);
                if (x0 == null) {
                    m62 m62Var = this.a;
                    m62Var.m = hc4Var;
                    m62Var.i.m(hc4Var);
                    this.a.q0(hc4Var);
                    i62.c().b(hc4Var, this.a.k0());
                    return;
                }
                if (m62.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + hc4Var.toString());
                }
                this.a.i.l(hc4Var);
                this.a.q0(hc4Var);
                i62.c().a(hc4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
        /* renamed from: r */
        public void f(hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hc4Var) == null) {
                super.f(hc4Var);
                if (m62.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(hc4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements gb4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m62 a;

        public t(m62 m62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m62Var;
        }

        @Override // com.baidu.tieba.gb4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (m62.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                m62 m62Var = this.a;
                m62Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    m62Var.o0(pMSAppInfo);
                    kz2.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(m62 m62Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fi3Var) == null) {
                fi3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(m62 m62Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, collection, obj};
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

        public w(m62 m62Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m62Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947924544, "Lcom/baidu/tieba/m62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947924544, "Lcom/baidu/tieba/m62;");
                return;
            }
        }
        C = wj1.a;
    }

    @Override // com.baidu.tieba.hb4
    public db4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.hb4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
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

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ib4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public gb4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (gb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public db4 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public db4 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public db4 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public db4 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (db4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            m02.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public m62(String str) {
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
        this.u = new ph3();
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

    @Override // com.baidu.tieba.hb4
    public void G(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ug4Var) == null) {
            super.G(ug4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (ug4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + ug4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = ug4Var;
            if (!ug4Var.k()) {
                n0();
            }
        }
    }

    public ff3 y0(jc4 jc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, jc4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + jc4Var);
            }
            wc3.b c2 = wc3.c(jc4Var, jc4Var.h);
            if (!TextUtils.isEmpty(jc4Var.a)) {
                m02.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + jc4Var.a);
                qj4.k(jc4Var.a);
            }
            if (!c2.c()) {
                ff3 ff3Var = new ff3();
                ff3Var.k(13L);
                ff3Var.b(2907L);
                ff3Var.d("Core包更新失败");
                return ff3Var;
            }
            return null;
        }
        return (ff3) invokeL.objValue;
    }

    public final void B0(hc4 hc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hc4Var) == null) {
            i62.c().d(hc4Var, new i(this, hc4Var));
        }
    }

    public final void C0(jc4 jc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jc4Var) == null) {
            i62.c().d(jc4Var, new h(this, jc4Var));
        }
    }

    public final void D0(lc4 lc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lc4Var) == null) {
            i62.c().d(lc4Var, new f(this, lc4Var));
        }
    }

    public final void E0(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mc4Var) == null) {
            i62.c().d(mc4Var, new g(this, mc4Var));
        }
    }

    public m62 e0(fi3 fi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, fi3Var)) == null) {
            f0(this.t, fi3Var);
            return this;
        }
        return (m62) invokeL.objValue;
    }

    public synchronized m62 g0(v62 v62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, v62Var)) == null) {
            synchronized (this) {
                f0(this.s, v62Var);
            }
            return this;
        }
        return (m62) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                jb4.i().z(this.o, i2);
            } else {
                jb4.i().z(this.o, 0);
            }
        }
    }

    public m62 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (m62) invokeL.objValue;
    }

    public final void q0(hc4 hc4Var) {
        dy9 dy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, hc4Var) == null) && (dy9Var = this.g) != null) {
            dy9Var.onNext(hc4Var);
            this.g.onCompleted();
        }
    }

    public m62 r0(fi3 fi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, fi3Var)) == null) {
            p0(this.s, new c(this, fi3Var));
            return this;
        }
        return (m62) invokeL.objValue;
    }

    public void s0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pMSAppInfo) == null) {
            r0(new e(this, pMSAppInfo));
        }
    }

    public void A0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            fy2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized m62 f0(Collection collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, collection, obj)) == null) {
            synchronized (this) {
                if (collection != null && obj != null) {
                    this.u.a(new v(this, collection, obj));
                }
            }
            return this;
        }
        return (m62) invokeLL.objValue;
    }

    public final synchronized m62 h0(Collection collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, collection, obj)) == null) {
            synchronized (this) {
                if (collection != null && obj != null) {
                    this.u.a(new w(this, collection, obj));
                }
            }
            return this;
        }
        return (m62) invokeLL.objValue;
    }

    public final synchronized m62 p0(Collection collection, fi3 fi3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, fi3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, fi3Var));
            }
            return this;
        }
        return (m62) invokeLL.objValue;
    }

    public void t0(boolean z, ff3 ff3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, ff3Var) == null) {
            r0(new d(this, ff3Var, z));
        }
    }

    @Override // com.baidu.tieba.hb4
    public void C(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gc4Var) == null) {
            m02.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + gc4Var);
            if (gc4Var != null && gc4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public ff3 z0(lc4 lc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, lc4Var)) == null) {
            if (lc4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(11L);
                ff3Var.i(2310L);
                ff3Var.f("pkg info is empty");
                jf3.a().f(ff3Var);
                return ff3Var;
            }
            return null;
        }
        return (ff3) invokeL.objValue;
    }

    public ff3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    ff3 ff3Var = new ff3();
                    ff3Var.k(10L);
                    ff3Var.i(2903L);
                    ff3Var.d("Server未返回主包&AppInfo");
                    return ff3Var;
                }
                PMSAppInfo u2 = jb4.i().u(this.o);
                if (u2 == null) {
                    ff3 ff3Var2 = new ff3();
                    ff3Var2.k(10L);
                    ff3Var2.i(2904L);
                    ff3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return ff3Var2;
                }
                this.n = u2;
                e72.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (jb4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                ff3 ff3Var3 = new ff3();
                ff3Var3.k(10L);
                ff3Var3.i(2906L);
                ff3Var3.d("更新DB失败");
                return ff3Var3;
            }
            lc4 lc4Var = this.j;
            if (lc4Var != null) {
                e72.k(pMSAppInfo, lc4Var);
            } else if (f72.f(this.k)) {
                mc4 mc4Var = (mc4) this.k.get(0);
                this.q = mc4Var;
                mc4Var.o = this.o;
                e72.l(this.n, mc4Var);
            } else {
                PMSAppInfo u3 = jb4.i().u(this.o);
                if (u3 == null) {
                    ff3 ff3Var4 = new ff3();
                    ff3Var4.k(10L);
                    ff3Var4.i(2905L);
                    ff3Var4.d("Server未返回包数据，本地也没有数据");
                    return ff3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (jb4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                e72.o(this.n);
                return null;
            }
            ff3 ff3Var5 = new ff3();
            ff3Var5.k(10L);
            ff3Var5.i(2906L);
            ff3Var5.d("更新DB失败");
            return ff3Var5;
        }
        return (ff3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = jb4.i().u(this.o);
            m02.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                lc4 lc4Var = this.j;
                if (lc4Var != null) {
                    lc4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                jb4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(xx9.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(xx9.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(xx9.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(xx9.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(xx9.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                xx9.i(arrayList).u(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = jb4.i().u(this.o);
        if (u2 == null) {
            m02.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (jb4.i().l(this.n)) {
            e72.o(this.n);
        }
    }

    public ff3 x0(hc4 hc4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, hc4Var)) == null) {
            se2 se2Var = new se2();
            se2Var.b = hc4Var.i;
            se2Var.a = hc4Var.j;
            se2Var.c = hc4Var.a;
            se2Var.d = hc4Var.m;
            if (vd2.b(hc4Var.h, se2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ff3 ff3Var = new ff3();
                ff3Var.k(14L);
                ff3Var.b(2908L);
                ff3Var.d("Extension包更新失败");
                return ff3Var;
            }
            return null;
        }
        return (ff3) invokeL.objValue;
    }
}
