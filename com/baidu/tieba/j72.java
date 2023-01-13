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
import com.baidu.tieba.f72;
import com.baidu.tieba.k8a;
import com.baidu.tieba.n43;
import com.baidu.tieba.td3;
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
/* loaded from: classes5.dex */
public abstract class j72 extends n72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public dc4 A;
    public q8a<hd4> B;
    public String c;
    public q8a<? super id4> d;
    public q8a<? super jd4> e;
    public q8a<? super gd4> f;
    public q8a<? super ed4> g;
    public q8a<? super kd4> h;
    public rh4 i;
    public id4 j;
    public List<jd4> k;
    public gd4 l;
    public ed4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public jd4 q;
    public long r;
    public final Set<s72> s;
    public final Set<cj3<PMSAppInfo>> t;
    public final mi3 u;
    public ac4<id4> v;
    public ac4<jd4> w;
    public final ac4<kd4> x;
    public ac4<gd4> y;
    public ac4<ed4> z;

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

    /* loaded from: classes5.dex */
    public class a extends xb4<id4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        /* renamed from: com.baidu.tieba.j72$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0326a implements cj3<n43.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0326a(a aVar) {
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
            @Override // com.baidu.tieba.cj3
            /* renamed from: b */
            public void a(n43.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    fc4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ac4
        /* renamed from: l */
        public String d(id4 id4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, id4Var)) == null) {
                int i = id4Var.h;
                if (i == 0) {
                    return b82.g();
                }
                if (i == 1) {
                    return b82.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: q */
        public void c(id4 id4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, id4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (j72.C) {
                op2.d(l0).e().d(1);
            }
            super.c(id4Var);
            j12.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.cc4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.xb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: o */
        public void e(id4 id4Var, dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, id4Var, dd4Var) == null) {
                super.e(id4Var, dd4Var);
                j12.k("SwanAppPkgDownloadCallback", "onDownloadError：" + dd4Var.toString());
                this.a.i.l(id4Var);
                cg3 cg3Var = new cg3();
                cg3Var.k(11L);
                cg3Var.i(dd4Var.a);
                cg3Var.d("主包下载失败");
                cg3Var.f(dd4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(id4Var, cg3Var));
                }
                f72.c().a(id4Var, this.a.k0(), cg3Var);
                nk4.k(id4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: p */
        public void i(id4 id4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, id4Var) == null) {
                String l0 = this.a.l0();
                if (j72.C) {
                    op2.d(l0).e().d(1);
                }
                super.i(id4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                cg3 z0 = this.a.z0(id4Var);
                j12.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + id4Var.i);
                if (z0 == null) {
                    j72 j72Var = this.a;
                    j72Var.j = id4Var;
                    j72Var.i.m(id4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(id4Var);
                        if (j72.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    f72.c().b(id4Var, this.a.k0());
                    return;
                }
                this.a.i.l(id4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(id4Var, z0));
                }
                f72.c().a(id4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: r */
        public void f(id4 id4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, id4Var) == null) {
                String l0 = this.a.l0();
                if (j72.C) {
                    op2.d(l0).e().d(1);
                }
                super.f(id4Var);
                if (j72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(id4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: s */
        public dd4 h(id4 id4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{id4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (j72.C) {
                    op2.d(l0).f(id4Var.toString()).d(1);
                }
                C0326a c0326a = new C0326a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                hn2 hn2Var = new hn2();
                hn2Var.u(c0326a);
                hn2Var.K(bundle);
                hn2Var.J(new gn2(id4Var, this.a));
                hn2Var.J(new en2(id4Var.m, this.a));
                hn2Var.M(readableByteChannel);
                boolean N = hn2Var.N();
                hn2Var.o(c0326a);
                if (j72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    j12.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    nk4.L(file);
                }
                if (N) {
                    return new dd4(2300, "业务层处理下载流成功");
                }
                return new dd4(2301, "业务层处理下载流失败");
            }
            return (dd4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ cj3 b;

        public b(j72 j72Var, Collection collection, cj3 cj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, collection, cj3Var};
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
            this.b = cj3Var;
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

    /* loaded from: classes5.dex */
    public class c implements cj3<s72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj3 a;
        public final /* synthetic */ j72 b;

        public c(j72 j72Var, cj3 cj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, cj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j72Var;
            this.a = cj3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.j72.Q(com.baidu.tieba.j72, java.util.Collection, java.lang.Object):com.baidu.tieba.j72
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(com.baidu.tieba.s72 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.j72.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.cj3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.j72 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.j72.P(r0)
                com.baidu.tieba.j72.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.j72.c.a(com.baidu.tieba.s72):void");
        }
    }

    /* loaded from: classes5.dex */
    public class d implements cj3<s72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cg3 a;
        public final /* synthetic */ boolean b;

        public d(j72 j72Var, cg3 cg3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, cg3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cg3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s72Var) == null) {
                s72Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements cj3<s72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(j72 j72Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(s72 s72Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s72Var) == null) {
                s72Var.b(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements f72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id4 a;
        public final /* synthetic */ j72 b;

        public f(j72 j72Var, id4 id4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, id4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j72Var;
            this.a = id4Var;
        }

        @Override // com.baidu.tieba.f72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                j72 j72Var = this.b;
                id4 id4Var = this.a;
                j72Var.j = id4Var;
                j72Var.i.m(id4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.f72.c
        public void b(PMSDownloadType pMSDownloadType, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cg3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, cg3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements f72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd4 a;
        public final /* synthetic */ j72 b;

        public g(j72 j72Var, jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, jd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j72Var;
            this.a = jd4Var;
        }

        @Override // com.baidu.tieba.f72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                j72 j72Var = this.b;
                if (j72Var.k == null) {
                    j72Var.k = new ArrayList();
                }
                jd4 jd4Var = this.a;
                j72 j72Var2 = this.b;
                jd4Var.o = j72Var2.o;
                j72Var2.k.add(jd4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.f72.c
        public void b(PMSDownloadType pMSDownloadType, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cg3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, cg3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements f72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd4 a;
        public final /* synthetic */ j72 b;

        public h(j72 j72Var, gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, gd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j72Var;
            this.a = gd4Var;
        }

        @Override // com.baidu.tieba.f72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                j72 j72Var = this.b;
                gd4 gd4Var = this.a;
                j72Var.l = gd4Var;
                j72Var.i.m(gd4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.f72.c
        public void b(PMSDownloadType pMSDownloadType, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cg3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, cg3Var));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements f72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed4 a;
        public final /* synthetic */ j72 b;

        public i(j72 j72Var, ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, ed4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j72Var;
            this.a = ed4Var;
        }

        @Override // com.baidu.tieba.f72.c
        public void b(PMSDownloadType pMSDownloadType, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cg3Var) == null) {
                j12.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + cg3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.f72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                j12.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                j72 j72Var = this.b;
                ed4 ed4Var = this.a;
                j72Var.m = ed4Var;
                j72Var.i.m(ed4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends q8a<hd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 e;

        public j(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l8a
        /* renamed from: g */
        public void onNext(hd4 hd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hd4Var) == null) {
                j12.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + hd4Var.i);
            }
        }

        @Override // com.baidu.tieba.l8a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                j12.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.l8a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                j12.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements k8a.a<id4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public k(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public void call(q8a<? super id4> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, q8aVar) != null) {
                return;
            }
            this.a.d = q8aVar;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements k8a.a<jd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public l(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public void call(q8a<? super jd4> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, q8aVar) != null) {
                return;
            }
            this.a.e = q8aVar;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements k8a.a<gd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public m(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public void call(q8a<? super gd4> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, q8aVar) != null) {
                return;
            }
            this.a.f = q8aVar;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements k8a.a<ed4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public n(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public void call(q8a<? super ed4> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, q8aVar) != null) {
                return;
            }
            this.a.g = q8aVar;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements k8a.a<kd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public o(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public void call(q8a<? super kd4> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, q8aVar) != null) {
                return;
            }
            this.a.h = q8aVar;
        }
    }

    /* loaded from: classes5.dex */
    public class p extends q72<j72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(j72 j72Var, j72 j72Var2) {
            super(j72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, j72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q72, com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: s */
        public void c(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, jd4Var) == null) {
                super.c(jd4Var);
                j12.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: u */
        public void f(jd4 jd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jd4Var) == null) {
                super.f(jd4Var);
                this.c.E0(jd4Var);
            }
        }

        @Override // com.baidu.tieba.q72, com.baidu.tieba.xb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.q72
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q72
        public void p(@NonNull jd4 jd4Var, @Nullable cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, jd4Var, cg3Var) == null) {
                super.p(jd4Var, cg3Var);
                j12.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + jd4Var.i);
                j72 j72Var = this.c;
                if (j72Var.k == null) {
                    j72Var.k = new ArrayList();
                }
                j72 j72Var2 = this.c;
                jd4Var.o = j72Var2.o;
                if (cg3Var == null) {
                    j72Var2.k.add(jd4Var);
                    this.c.i.m(jd4Var);
                    f72.c().b(jd4Var, this.c.k0());
                } else {
                    j72Var2.i.l(jd4Var);
                    f72.c().a(jd4Var, this.c.k0(), cg3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(jd4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: q */
        public void e(jd4 jd4Var, dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, jd4Var, dd4Var) == null) {
                super.q(jd4Var, dd4Var);
                j12.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + dd4Var.toString());
                this.c.i.l(jd4Var);
                cg3 cg3Var = new cg3();
                cg3Var.k(12L);
                cg3Var.i(dd4Var.a);
                cg3Var.d("分包下载失败");
                cg3Var.f(dd4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(jd4Var, cg3Var));
                }
                f72.c().a(jd4Var, this.c.k0(), cg3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends o72<j72> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(j72 j72Var, j72 j72Var2) {
            super(j72Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, j72Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n72) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j72Var;
        }

        @Override // com.baidu.tieba.o72
        public void u(kd4 kd4Var, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, kd4Var, cg3Var) == null) {
                j12.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + cg3Var);
                this.b.i.l(kd4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(kd4Var, cg3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o72, com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: v */
        public void c(kd4 kd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, kd4Var) == null) {
                super.c(kd4Var);
                j12.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.xb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.o72
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.o72
        public void r(@NonNull kd4 kd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, kd4Var) == null) {
                this.b.i.m(kd4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(kd4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o72, com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: w */
        public void f(kd4 kd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, kd4Var) == null) {
                super.f(kd4Var);
                if (j72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends xb4<gd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public r(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ac4
        /* renamed from: l */
        public String d(gd4 gd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gd4Var)) == null) {
                int i = gd4Var.h;
                if (i == 0) {
                    return b82.h();
                }
                if (i == 1) {
                    return b82.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: q */
        public void c(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gd4Var) == null) {
                super.c(gd4Var);
                j12.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.cc4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.xb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: o */
        public void e(gd4 gd4Var, dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gd4Var, dd4Var) == null) {
                super.e(gd4Var, dd4Var);
                j12.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + dd4Var.toString());
                this.a.i.l(gd4Var);
                cg3 cg3Var = new cg3();
                cg3Var.k(13L);
                cg3Var.i(dd4Var.a);
                cg3Var.d("Framework包下载失败");
                cg3Var.f(dd4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(gd4Var, cg3Var));
                }
                f72.c().a(gd4Var, this.a.k0(), cg3Var);
                nk4.k(gd4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: p */
        public void i(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, gd4Var) == null) {
                super.i(gd4Var);
                j12.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + gd4Var.i);
                cg3 y0 = this.a.y0(gd4Var);
                if (y0 == null) {
                    j72 j72Var = this.a;
                    j72Var.l = gd4Var;
                    j72Var.i.m(gd4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(gd4Var);
                        this.a.f.onCompleted();
                    }
                    f72.c().b(gd4Var, this.a.k0());
                    return;
                }
                this.a.i.l(gd4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(gd4Var, y0));
                }
                f72.c().a(gd4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: r */
        public void f(gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, gd4Var) == null) {
                super.f(gd4Var);
                if (j72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(gd4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s extends xb4<ed4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public s(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ac4
        /* renamed from: l */
        public String d(ed4 ed4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ed4Var)) == null) {
                int i = ed4Var.h;
                if (i == 0) {
                    return b82.d();
                }
                if (i == 1) {
                    return b82.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: q */
        public void c(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ed4Var) == null) {
                super.c(ed4Var);
                j12.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.cc4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.xb4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: o */
        public void e(ed4 ed4Var, dd4 dd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ed4Var, dd4Var) == null) {
                super.e(ed4Var, dd4Var);
                j12.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + dd4Var.toString());
                this.a.i.l(ed4Var);
                cg3 cg3Var = new cg3();
                cg3Var.k(14L);
                cg3Var.i(dd4Var.a);
                cg3Var.d("Extension下载失败");
                cg3Var.f(dd4Var.toString());
                if (j72.C) {
                    Log.e("SwanAppPkgDownloadCallback", cg3Var.toString());
                }
                this.a.q0(ed4Var);
                f72.c().a(ed4Var, this.a.k0(), cg3Var);
                nk4.k(ed4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: p */
        public void i(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ed4Var) == null) {
                super.i(ed4Var);
                j12.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + ed4Var.i);
                cg3 x0 = this.a.x0(ed4Var);
                if (x0 == null) {
                    j72 j72Var = this.a;
                    j72Var.m = ed4Var;
                    j72Var.i.m(ed4Var);
                    this.a.q0(ed4Var);
                    f72.c().b(ed4Var, this.a.k0());
                    return;
                }
                if (j72.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + ed4Var.toString());
                }
                this.a.i.l(ed4Var);
                this.a.q0(ed4Var);
                f72.c().a(ed4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
        /* renamed from: r */
        public void f(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ed4Var) == null) {
                super.f(ed4Var);
                if (j72.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(ed4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements dc4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j72 a;

        public t(j72 j72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j72Var;
        }

        @Override // com.baidu.tieba.dc4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (j72.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                j72 j72Var = this.a;
                j72Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    j72Var.o0(pMSAppInfo);
                    h03.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements cj3<cj3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(j72 j72Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(cj3<PMSAppInfo> cj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cj3Var) == null) {
                cj3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(j72 j72Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, collection, obj};
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

    /* loaded from: classes5.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(j72 j72Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836132, "Lcom/baidu/tieba/j72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836132, "Lcom/baidu/tieba/j72;");
                return;
            }
        }
        C = tk1.a;
    }

    @Override // com.baidu.tieba.ec4
    public ac4<jd4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (ac4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.ec4
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
            return fc4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public dc4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (dc4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public ac4<kd4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (ac4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public ac4<ed4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (ac4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public ac4<gd4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (ac4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec4
    public ac4<id4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (ac4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            j12.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public j72(String str) {
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
        this.u = new mi3();
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

    @Override // com.baidu.tieba.ec4
    public void G(rh4 rh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rh4Var) == null) {
            super.G(rh4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (rh4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + rh4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = rh4Var;
            if (!rh4Var.k()) {
                n0();
            }
        }
    }

    public cg3 y0(gd4 gd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, gd4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + gd4Var);
            }
            td3.b c2 = td3.c(gd4Var, gd4Var.h);
            if (!TextUtils.isEmpty(gd4Var.a)) {
                j12.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + gd4Var.a);
                nk4.k(gd4Var.a);
            }
            if (!c2.c()) {
                cg3 cg3Var = new cg3();
                cg3Var.k(13L);
                cg3Var.b(2907L);
                cg3Var.d("Core包更新失败");
                return cg3Var;
            }
            return null;
        }
        return (cg3) invokeL.objValue;
    }

    public final void B0(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ed4Var) == null) {
            f72.c().d(ed4Var, new i(this, ed4Var));
        }
    }

    public final void C0(gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gd4Var) == null) {
            f72.c().d(gd4Var, new h(this, gd4Var));
        }
    }

    public final void D0(id4 id4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, id4Var) == null) {
            f72.c().d(id4Var, new f(this, id4Var));
        }
    }

    public final void E0(jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jd4Var) == null) {
            f72.c().d(jd4Var, new g(this, jd4Var));
        }
    }

    public j72 e0(cj3<PMSAppInfo> cj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, cj3Var)) == null) {
            f0(this.t, cj3Var);
            return this;
        }
        return (j72) invokeL.objValue;
    }

    public synchronized j72 g0(s72 s72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, s72Var)) == null) {
            synchronized (this) {
                f0(this.s, s72Var);
            }
            return this;
        }
        return (j72) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                gc4.i().z(this.o, i2);
            } else {
                gc4.i().z(this.o, 0);
            }
        }
    }

    public j72 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (j72) invokeL.objValue;
    }

    public final void q0(ed4 ed4Var) {
        q8a<? super ed4> q8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, ed4Var) == null) && (q8aVar = this.g) != null) {
            q8aVar.onNext(ed4Var);
            this.g.onCompleted();
        }
    }

    public j72 r0(@NonNull cj3<s72> cj3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, cj3Var)) == null) {
            p0(this.s, new c(this, cj3Var));
            return this;
        }
        return (j72) invokeL.objValue;
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
            cz2.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> j72 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (j72) invokeLL.objValue;
    }

    public final synchronized <CallbackT> j72 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (j72) invokeLL.objValue;
    }

    public final synchronized <CallbackT> j72 p0(@NonNull Collection<CallbackT> collection, @NonNull cj3<CallbackT> cj3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, cj3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, cj3Var));
            }
            return this;
        }
        return (j72) invokeLL.objValue;
    }

    public void t0(boolean z, cg3 cg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, cg3Var) == null) {
            r0(new d(this, cg3Var, z));
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ com.baidu.tieba.j72 Q(com.baidu.tieba.j72 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.j72.Q(com.baidu.tieba.j72, java.util.Collection, java.lang.Object):com.baidu.tieba.j72");
    }

    @Override // com.baidu.tieba.ec4
    public void C(dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dd4Var) == null) {
            j12.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + dd4Var);
            if (dd4Var != null && dd4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public cg3 z0(id4 id4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, id4Var)) == null) {
            if (id4Var == null) {
                cg3 cg3Var = new cg3();
                cg3Var.k(11L);
                cg3Var.i(2310L);
                cg3Var.f("pkg info is empty");
                gg3.a().f(cg3Var);
                return cg3Var;
            }
            return null;
        }
        return (cg3) invokeL.objValue;
    }

    public cg3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    cg3 cg3Var = new cg3();
                    cg3Var.k(10L);
                    cg3Var.i(2903L);
                    cg3Var.d("Server未返回主包&AppInfo");
                    return cg3Var;
                }
                PMSAppInfo u2 = gc4.i().u(this.o);
                if (u2 == null) {
                    cg3 cg3Var2 = new cg3();
                    cg3Var2.k(10L);
                    cg3Var2.i(2904L);
                    cg3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return cg3Var2;
                }
                this.n = u2;
                b82.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (gc4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                cg3 cg3Var3 = new cg3();
                cg3Var3.k(10L);
                cg3Var3.i(2906L);
                cg3Var3.d("更新DB失败");
                return cg3Var3;
            }
            id4 id4Var = this.j;
            if (id4Var != null) {
                b82.k(pMSAppInfo, id4Var);
            } else if (c82.f(this.k)) {
                jd4 jd4Var = this.k.get(0);
                this.q = jd4Var;
                jd4Var.o = this.o;
                b82.l(this.n, jd4Var);
            } else {
                PMSAppInfo u3 = gc4.i().u(this.o);
                if (u3 == null) {
                    cg3 cg3Var4 = new cg3();
                    cg3Var4.k(10L);
                    cg3Var4.i(2905L);
                    cg3Var4.d("Server未返回包数据，本地也没有数据");
                    return cg3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (gc4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                b82.o(this.n);
                return null;
            }
            cg3 cg3Var5 = new cg3();
            cg3Var5.k(10L);
            cg3Var5.i(2906L);
            cg3Var5.d("更新DB失败");
            return cg3Var5;
        }
        return (cg3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = gc4.i().u(this.o);
            j12.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                id4 id4Var = this.j;
                if (id4Var != null) {
                    id4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                gc4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(k8a.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(k8a.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(k8a.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(k8a.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(k8a.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                k8a.i(arrayList).u(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = gc4.i().u(this.o);
        if (u2 == null) {
            j12.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (gc4.i().l(this.n)) {
            b82.o(this.n);
        }
    }

    public cg3 x0(ed4 ed4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, ed4Var)) == null) {
            pf2 pf2Var = new pf2();
            pf2Var.b = ed4Var.i;
            pf2Var.a = ed4Var.j;
            pf2Var.c = ed4Var.a;
            pf2Var.d = ed4Var.m;
            if (se2.b(ed4Var.h, pf2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                cg3 cg3Var = new cg3();
                cg3Var.k(14L);
                cg3Var.b(2908L);
                cg3Var.d("Extension包更新失败");
                return cg3Var;
            }
            return null;
        }
        return (cg3) invokeL.objValue;
    }
}
