package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.dc3;
import com.baidu.tieba.gob;
import com.baidu.tieba.jl3;
import com.baidu.tieba.ve2;
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
/* loaded from: classes8.dex */
public abstract class ze2 extends df2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public tj4 A;
    public mob<xk4> B;
    public String c;
    public mob<? super yk4> d;
    public mob<? super zk4> e;
    public mob<? super wk4> f;
    public mob<? super uk4> g;
    public mob<? super al4> h;
    public hp4 i;
    public yk4 j;
    public List<zk4> k;
    public wk4 l;
    public uk4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public zk4 q;
    public long r;
    public final Set<if2> s;
    public final Set<sq3<PMSAppInfo>> t;
    public final cq3 u;
    public qj4<yk4> v;
    public qj4<zk4> w;
    public final qj4<al4> x;
    public qj4<wk4> y;
    public qj4<uk4> z;

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

    /* loaded from: classes8.dex */
    public class a extends nj4<yk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        /* renamed from: com.baidu.tieba.ze2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0536a implements sq3<dc3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0536a(a aVar) {
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
            @Override // com.baidu.tieba.sq3
            /* renamed from: b */
            public void a(dc3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    vj4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(yk4 yk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yk4Var)) == null) {
                int i = yk4Var.h;
                if (i == 0) {
                    return rf2.g();
                }
                if (i == 1) {
                    return rf2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void c(yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, yk4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (ze2.C) {
                ex2.d(l0).e().d(1);
            }
            super.c(yk4Var);
            z82.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.sj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.nj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(yk4 yk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, yk4Var, tk4Var) == null) {
                super.e(yk4Var, tk4Var);
                z82.k("SwanAppPkgDownloadCallback", "onDownloadError：" + tk4Var.toString());
                this.a.i.l(yk4Var);
                sn3 sn3Var = new sn3();
                sn3Var.k(11L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("主包下载失败");
                sn3Var.f(tk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(yk4Var, sn3Var));
                }
                ve2.c().a(yk4Var, this.a.k0(), sn3Var);
                ds4.k(yk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, yk4Var) == null) {
                String l0 = this.a.l0();
                if (ze2.C) {
                    ex2.d(l0).e().d(1);
                }
                super.i(yk4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                sn3 z0 = this.a.z0(yk4Var);
                z82.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + yk4Var.i);
                if (z0 == null) {
                    ze2 ze2Var = this.a;
                    ze2Var.j = yk4Var;
                    ze2Var.i.m(yk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(yk4Var);
                        if (ze2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    ve2.c().b(yk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(yk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(yk4Var, z0));
                }
                ve2.c().a(yk4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: r */
        public void f(yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, yk4Var) == null) {
                String l0 = this.a.l0();
                if (ze2.C) {
                    ex2.d(l0).e().d(1);
                }
                super.f(yk4Var);
                if (ze2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(yk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: s */
        public tk4 h(yk4 yk4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{yk4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (ze2.C) {
                    ex2.d(l0).f(yk4Var.toString()).d(1);
                }
                C0536a c0536a = new C0536a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                xu2 xu2Var = new xu2();
                xu2Var.u(c0536a);
                xu2Var.K(bundle);
                xu2Var.J(new wu2(yk4Var, this.a));
                xu2Var.J(new uu2(yk4Var.m, this.a));
                xu2Var.M(readableByteChannel);
                boolean N = xu2Var.N();
                xu2Var.o(c0536a);
                if (ze2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    z82.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    ds4.L(file);
                }
                if (N) {
                    return new tk4(2300, "业务层处理下载流成功");
                }
                return new tk4(2301, "业务层处理下载流失败");
            }
            return (tk4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ sq3 b;

        public b(ze2 ze2Var, Collection collection, sq3 sq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, collection, sq3Var};
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
            this.b = sq3Var;
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

    /* loaded from: classes8.dex */
    public class c implements sq3<if2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq3 a;
        public final /* synthetic */ ze2 b;

        public c(ze2 ze2Var, sq3 sq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, sq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze2Var;
            this.a = sq3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.ze2.Q(com.baidu.tieba.ze2, java.util.Collection, java.lang.Object):com.baidu.tieba.ze2
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
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(com.baidu.tieba.if2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.ze2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.sq3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.ze2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.ze2.P(r0)
                com.baidu.tieba.ze2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ze2.c.a(com.baidu.tieba.if2):void");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements sq3<if2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sn3 a;
        public final /* synthetic */ boolean b;

        public d(ze2 ze2Var, sn3 sn3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, sn3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sn3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(if2 if2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, if2Var) == null) {
                if2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements sq3<if2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(ze2 ze2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(if2 if2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, if2Var) == null) {
                if2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk4 a;
        public final /* synthetic */ ze2 b;

        public f(ze2 ze2Var, yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, yk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze2Var;
            this.a = yk4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ze2 ze2Var = this.b;
                yk4 yk4Var = this.a;
                ze2Var.j = yk4Var;
                ze2Var.i.m(yk4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, sn3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk4 a;
        public final /* synthetic */ ze2 b;

        public g(ze2 ze2Var, zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, zk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze2Var;
            this.a = zk4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ze2 ze2Var = this.b;
                if (ze2Var.k == null) {
                    ze2Var.k = new ArrayList();
                }
                zk4 zk4Var = this.a;
                ze2 ze2Var2 = this.b;
                zk4Var.o = ze2Var2.o;
                ze2Var2.k.add(zk4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, sn3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wk4 a;
        public final /* synthetic */ ze2 b;

        public h(ze2 ze2Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, wk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze2Var;
            this.a = wk4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ze2 ze2Var = this.b;
                wk4 wk4Var = this.a;
                ze2Var.l = wk4Var;
                ze2Var.i.m(wk4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, sn3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk4 a;
        public final /* synthetic */ ze2 b;

        public i(ze2 ze2Var, uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, uk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze2Var;
            this.a = uk4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) == null) {
                z82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + sn3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.ve2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                z82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                ze2 ze2Var = this.b;
                uk4 uk4Var = this.a;
                ze2Var.m = uk4Var;
                ze2Var.i.m(uk4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends mob<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 e;

        public j(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hob
        /* renamed from: g */
        public void onNext(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xk4Var) == null) {
                z82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + xk4Var.i);
            }
        }

        @Override // com.baidu.tieba.hob
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                z82.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.hob
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                z82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements gob.a<yk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public k(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super yk4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.d = mobVar;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements gob.a<zk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public l(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super zk4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.e = mobVar;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements gob.a<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public m(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super wk4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.f = mobVar;
        }
    }

    /* loaded from: classes8.dex */
    public class n implements gob.a<uk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public n(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super uk4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.g = mobVar;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements gob.a<al4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public o(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.a, com.baidu.tieba.uob
        public void call(mob<? super al4> mobVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mobVar) != null) {
                return;
            }
            this.a.h = mobVar;
        }
    }

    /* loaded from: classes8.dex */
    public class p extends gf2<ze2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ze2 ze2Var, ze2 ze2Var2) {
            super(ze2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, ze2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((df2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gf2, com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: s */
        public void c(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, zk4Var) == null) {
                super.c(zk4Var);
                z82.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: u */
        public void f(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zk4Var) == null) {
                super.f(zk4Var);
                this.c.E0(zk4Var);
            }
        }

        @Override // com.baidu.tieba.gf2, com.baidu.tieba.nj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.gf2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.gf2
        public void p(@NonNull zk4 zk4Var, @Nullable sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, zk4Var, sn3Var) == null) {
                super.p(zk4Var, sn3Var);
                z82.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + zk4Var.i);
                ze2 ze2Var = this.c;
                if (ze2Var.k == null) {
                    ze2Var.k = new ArrayList();
                }
                ze2 ze2Var2 = this.c;
                zk4Var.o = ze2Var2.o;
                if (sn3Var == null) {
                    ze2Var2.k.add(zk4Var);
                    this.c.i.m(zk4Var);
                    ve2.c().b(zk4Var, this.c.k0());
                } else {
                    ze2Var2.i.l(zk4Var);
                    ve2.c().a(zk4Var, this.c.k0(), sn3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(zk4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void e(zk4 zk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, zk4Var, tk4Var) == null) {
                super.q(zk4Var, tk4Var);
                z82.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + tk4Var.toString());
                this.c.i.l(zk4Var);
                sn3 sn3Var = new sn3();
                sn3Var.k(12L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("分包下载失败");
                sn3Var.f(tk4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(zk4Var, sn3Var));
                }
                ve2.c().a(zk4Var, this.c.k0(), sn3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends ef2<ze2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ze2 ze2Var, ze2 ze2Var2) {
            super(ze2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, ze2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((df2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze2Var;
        }

        @Override // com.baidu.tieba.ef2
        public void u(al4 al4Var, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, al4Var, sn3Var) == null) {
                z82.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + sn3Var);
                this.b.i.l(al4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(al4Var, sn3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ef2, com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: v */
        public void c(al4 al4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, al4Var) == null) {
                super.c(al4Var);
                z82.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.nj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ef2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ef2
        public void r(@NonNull al4 al4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, al4Var) == null) {
                this.b.i.m(al4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(al4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ef2, com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: w */
        public void f(al4 al4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, al4Var) == null) {
                super.f(al4Var);
                if (ze2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends nj4<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public r(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(wk4 wk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wk4Var)) == null) {
                int i = wk4Var.h;
                if (i == 0) {
                    return rf2.h();
                }
                if (i == 1) {
                    return rf2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void c(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, wk4Var) == null) {
                super.c(wk4Var);
                z82.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.sj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.nj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(wk4 wk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wk4Var, tk4Var) == null) {
                super.e(wk4Var, tk4Var);
                z82.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + tk4Var.toString());
                this.a.i.l(wk4Var);
                sn3 sn3Var = new sn3();
                sn3Var.k(13L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("Framework包下载失败");
                sn3Var.f(tk4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(wk4Var, sn3Var));
                }
                ve2.c().a(wk4Var, this.a.k0(), sn3Var);
                ds4.k(wk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, wk4Var) == null) {
                super.i(wk4Var);
                z82.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + wk4Var.i);
                sn3 y0 = this.a.y0(wk4Var);
                if (y0 == null) {
                    ze2 ze2Var = this.a;
                    ze2Var.l = wk4Var;
                    ze2Var.i.m(wk4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(wk4Var);
                        this.a.f.onCompleted();
                    }
                    ve2.c().b(wk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(wk4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(wk4Var, y0));
                }
                ve2.c().a(wk4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: r */
        public void f(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, wk4Var) == null) {
                super.f(wk4Var);
                if (ze2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(wk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s extends nj4<uk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public s(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(uk4 uk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uk4Var)) == null) {
                int i = uk4Var.h;
                if (i == 0) {
                    return rf2.d();
                }
                if (i == 1) {
                    return rf2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void c(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, uk4Var) == null) {
                super.c(uk4Var);
                z82.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.sj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.nj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(uk4 uk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uk4Var, tk4Var) == null) {
                super.e(uk4Var, tk4Var);
                z82.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + tk4Var.toString());
                this.a.i.l(uk4Var);
                sn3 sn3Var = new sn3();
                sn3Var.k(14L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("Extension下载失败");
                sn3Var.f(tk4Var.toString());
                if (ze2.C) {
                    Log.e("SwanAppPkgDownloadCallback", sn3Var.toString());
                }
                this.a.q0(uk4Var);
                ve2.c().a(uk4Var, this.a.k0(), sn3Var);
                ds4.k(uk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, uk4Var) == null) {
                super.i(uk4Var);
                z82.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + uk4Var.i);
                sn3 x0 = this.a.x0(uk4Var);
                if (x0 == null) {
                    ze2 ze2Var = this.a;
                    ze2Var.m = uk4Var;
                    ze2Var.i.m(uk4Var);
                    this.a.q0(uk4Var);
                    ve2.c().b(uk4Var, this.a.k0());
                    return;
                }
                if (ze2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + uk4Var.toString());
                }
                this.a.i.l(uk4Var);
                this.a.q0(uk4Var);
                ve2.c().a(uk4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: r */
        public void f(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, uk4Var) == null) {
                super.f(uk4Var);
                if (ze2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(uk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements tj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze2 a;

        public t(ze2 ze2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze2Var;
        }

        @Override // com.baidu.tieba.tj4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (ze2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                ze2 ze2Var = this.a;
                ze2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    ze2Var.o0(pMSAppInfo);
                    x73.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements sq3<sq3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(ze2 ze2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(sq3<PMSAppInfo> sq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sq3Var) == null) {
                sq3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(ze2 ze2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, collection, obj};
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

    /* loaded from: classes8.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(ze2 ze2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948356994, "Lcom/baidu/tieba/ze2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948356994, "Lcom/baidu/tieba/ze2;");
                return;
            }
        }
        C = js1.a;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<zk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.uj4
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
            return vj4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public tj4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (tj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<al4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<uk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<wk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<yk4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (qj4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            z82.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public ze2(String str) {
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
        this.u = new cq3();
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

    @Override // com.baidu.tieba.uj4
    public void G(hp4 hp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hp4Var) == null) {
            super.G(hp4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (hp4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + hp4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = hp4Var;
            if (!hp4Var.k()) {
                n0();
            }
        }
    }

    public sn3 y0(wk4 wk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, wk4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + wk4Var);
            }
            jl3.b c2 = jl3.c(wk4Var, wk4Var.h);
            if (!TextUtils.isEmpty(wk4Var.a)) {
                z82.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + wk4Var.a);
                ds4.k(wk4Var.a);
            }
            if (!c2.c()) {
                sn3 sn3Var = new sn3();
                sn3Var.k(13L);
                sn3Var.b(2907L);
                sn3Var.d("Core包更新失败");
                return sn3Var;
            }
            return null;
        }
        return (sn3) invokeL.objValue;
    }

    public final void B0(uk4 uk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uk4Var) == null) {
            ve2.c().d(uk4Var, new i(this, uk4Var));
        }
    }

    public final void C0(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wk4Var) == null) {
            ve2.c().d(wk4Var, new h(this, wk4Var));
        }
    }

    public final void D0(yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yk4Var) == null) {
            ve2.c().d(yk4Var, new f(this, yk4Var));
        }
    }

    public final void E0(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zk4Var) == null) {
            ve2.c().d(zk4Var, new g(this, zk4Var));
        }
    }

    public ze2 e0(sq3<PMSAppInfo> sq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, sq3Var)) == null) {
            f0(this.t, sq3Var);
            return this;
        }
        return (ze2) invokeL.objValue;
    }

    public synchronized ze2 g0(if2 if2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, if2Var)) == null) {
            synchronized (this) {
                f0(this.s, if2Var);
            }
            return this;
        }
        return (ze2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                wj4.i().z(this.o, i2);
            } else {
                wj4.i().z(this.o, 0);
            }
        }
    }

    public ze2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (ze2) invokeL.objValue;
    }

    public final void q0(uk4 uk4Var) {
        mob<? super uk4> mobVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, uk4Var) == null) && (mobVar = this.g) != null) {
            mobVar.onNext(uk4Var);
            this.g.onCompleted();
        }
    }

    public ze2 r0(@NonNull sq3<if2> sq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, sq3Var)) == null) {
            p0(this.s, new c(this, sq3Var));
            return this;
        }
        return (ze2) invokeL.objValue;
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
            s63.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> ze2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ze2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ze2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ze2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ze2 p0(@NonNull Collection<CallbackT> collection, @NonNull sq3<CallbackT> sq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, sq3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, sq3Var));
            }
            return this;
        }
        return (ze2) invokeLL.objValue;
    }

    public void t0(boolean z, sn3 sn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, sn3Var) == null) {
            r0(new d(this, sn3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.ze2 Q(com.baidu.tieba.ze2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ze2.Q(com.baidu.tieba.ze2, java.util.Collection, java.lang.Object):com.baidu.tieba.ze2");
    }

    @Override // com.baidu.tieba.uj4
    public void C(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tk4Var) == null) {
            z82.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + tk4Var);
            if (tk4Var != null && tk4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public sn3 z0(yk4 yk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, yk4Var)) == null) {
            if (yk4Var == null) {
                sn3 sn3Var = new sn3();
                sn3Var.k(11L);
                sn3Var.i(2310L);
                sn3Var.f("pkg info is empty");
                wn3.a().f(sn3Var);
                return sn3Var;
            }
            return null;
        }
        return (sn3) invokeL.objValue;
    }

    public sn3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    sn3 sn3Var = new sn3();
                    sn3Var.k(10L);
                    sn3Var.i(2903L);
                    sn3Var.d("Server未返回主包&AppInfo");
                    return sn3Var;
                }
                PMSAppInfo u2 = wj4.i().u(this.o);
                if (u2 == null) {
                    sn3 sn3Var2 = new sn3();
                    sn3Var2.k(10L);
                    sn3Var2.i(2904L);
                    sn3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return sn3Var2;
                }
                this.n = u2;
                rf2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (wj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                sn3 sn3Var3 = new sn3();
                sn3Var3.k(10L);
                sn3Var3.i(2906L);
                sn3Var3.d("更新DB失败");
                return sn3Var3;
            }
            yk4 yk4Var = this.j;
            if (yk4Var != null) {
                rf2.k(pMSAppInfo, yk4Var);
            } else if (sf2.f(this.k)) {
                zk4 zk4Var = this.k.get(0);
                this.q = zk4Var;
                zk4Var.o = this.o;
                rf2.l(this.n, zk4Var);
            } else {
                PMSAppInfo u3 = wj4.i().u(this.o);
                if (u3 == null) {
                    sn3 sn3Var4 = new sn3();
                    sn3Var4.k(10L);
                    sn3Var4.i(2905L);
                    sn3Var4.d("Server未返回包数据，本地也没有数据");
                    return sn3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (wj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                rf2.o(this.n);
                return null;
            }
            sn3 sn3Var5 = new sn3();
            sn3Var5.k(10L);
            sn3Var5.i(2906L);
            sn3Var5.d("更新DB失败");
            return sn3Var5;
        }
        return (sn3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = wj4.i().u(this.o);
            z82.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                yk4 yk4Var = this.j;
                if (yk4Var != null) {
                    yk4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                wj4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(gob.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(gob.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(gob.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(gob.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(gob.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                gob.k(arrayList).w(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = wj4.i().u(this.o);
        if (u2 == null) {
            z82.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (wj4.i().l(this.n)) {
            rf2.o(this.n);
        }
    }

    public sn3 x0(uk4 uk4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, uk4Var)) == null) {
            fn2 fn2Var = new fn2();
            fn2Var.b = uk4Var.i;
            fn2Var.a = uk4Var.j;
            fn2Var.c = uk4Var.a;
            fn2Var.d = uk4Var.m;
            if (im2.b(uk4Var.h, fn2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                sn3 sn3Var = new sn3();
                sn3Var.k(14L);
                sn3Var.b(2908L);
                sn3Var.d("Extension包更新失败");
                return sn3Var;
            }
            return null;
        }
        return (sn3) invokeL.objValue;
    }
}
