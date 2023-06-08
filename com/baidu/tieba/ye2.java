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
import com.baidu.tieba.cc3;
import com.baidu.tieba.il3;
import com.baidu.tieba.nmb;
import com.baidu.tieba.ue2;
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
public abstract class ye2 extends cf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public sj4 A;
    public tmb<wk4> B;
    public String c;
    public tmb<? super xk4> d;
    public tmb<? super yk4> e;
    public tmb<? super vk4> f;
    public tmb<? super tk4> g;
    public tmb<? super zk4> h;
    public gp4 i;
    public xk4 j;
    public List<yk4> k;
    public vk4 l;
    public tk4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public yk4 q;
    public long r;
    public final Set<hf2> s;
    public final Set<rq3<PMSAppInfo>> t;
    public final bq3 u;
    public pj4<xk4> v;
    public pj4<yk4> w;
    public final pj4<zk4> x;
    public pj4<vk4> y;
    public pj4<tk4> z;

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
    public class a extends mj4<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        /* renamed from: com.baidu.tieba.ye2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0530a implements rq3<cc3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0530a(a aVar) {
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
            @Override // com.baidu.tieba.rq3
            /* renamed from: b */
            public void a(cc3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    uj4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj4
        /* renamed from: l */
        public String d(xk4 xk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xk4Var)) == null) {
                int i = xk4Var.h;
                if (i == 0) {
                    return qf2.g();
                }
                if (i == 1) {
                    return qf2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: q */
        public void c(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, xk4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (ye2.C) {
                dx2.d(l0).e().d(1);
            }
            super.c(xk4Var);
            y82.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.rj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.mj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: o */
        public void e(xk4 xk4Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, xk4Var, sk4Var) == null) {
                super.e(xk4Var, sk4Var);
                y82.k("SwanAppPkgDownloadCallback", "onDownloadError：" + sk4Var.toString());
                this.a.i.l(xk4Var);
                rn3 rn3Var = new rn3();
                rn3Var.k(11L);
                rn3Var.i(sk4Var.a);
                rn3Var.d("主包下载失败");
                rn3Var.f(sk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xk4Var, rn3Var));
                }
                ue2.c().a(xk4Var, this.a.k0(), rn3Var);
                cs4.k(xk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: p */
        public void i(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, xk4Var) == null) {
                String l0 = this.a.l0();
                if (ye2.C) {
                    dx2.d(l0).e().d(1);
                }
                super.i(xk4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                rn3 z0 = this.a.z0(xk4Var);
                y82.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + xk4Var.i);
                if (z0 == null) {
                    ye2 ye2Var = this.a;
                    ye2Var.j = xk4Var;
                    ye2Var.i.m(xk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(xk4Var);
                        if (ye2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    ue2.c().b(xk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(xk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xk4Var, z0));
                }
                ue2.c().a(xk4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: r */
        public void f(xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, xk4Var) == null) {
                String l0 = this.a.l0();
                if (ye2.C) {
                    dx2.d(l0).e().d(1);
                }
                super.f(xk4Var);
                if (ye2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(xk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: s */
        public sk4 h(xk4 xk4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{xk4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (ye2.C) {
                    dx2.d(l0).f(xk4Var.toString()).d(1);
                }
                C0530a c0530a = new C0530a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                wu2 wu2Var = new wu2();
                wu2Var.u(c0530a);
                wu2Var.K(bundle);
                wu2Var.J(new vu2(xk4Var, this.a));
                wu2Var.J(new tu2(xk4Var.m, this.a));
                wu2Var.M(readableByteChannel);
                boolean N = wu2Var.N();
                wu2Var.o(c0530a);
                if (ye2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    y82.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    cs4.L(file);
                }
                if (N) {
                    return new sk4(2300, "业务层处理下载流成功");
                }
                return new sk4(2301, "业务层处理下载流失败");
            }
            return (sk4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ rq3 b;

        public b(ye2 ye2Var, Collection collection, rq3 rq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, collection, rq3Var};
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
            this.b = rq3Var;
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
    public class c implements rq3<hf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq3 a;
        public final /* synthetic */ ye2 b;

        public c(ye2 ye2Var, rq3 rq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, rq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ye2Var;
            this.a = rq3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.ye2.Q(com.baidu.tieba.ye2, java.util.Collection, java.lang.Object):com.baidu.tieba.ye2
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
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(com.baidu.tieba.hf2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.ye2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.rq3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.ye2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.ye2.P(r0)
                com.baidu.tieba.ye2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ye2.c.a(com.baidu.tieba.hf2):void");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements rq3<hf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rn3 a;
        public final /* synthetic */ boolean b;

        public d(ye2 ye2Var, rn3 rn3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, rn3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rn3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hf2Var) == null) {
                hf2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements rq3<hf2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(ye2 ye2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(hf2 hf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hf2Var) == null) {
                hf2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk4 a;
        public final /* synthetic */ ye2 b;

        public f(ye2 ye2Var, xk4 xk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, xk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ye2Var;
            this.a = xk4Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ye2 ye2Var = this.b;
                xk4 xk4Var = this.a;
                ye2Var.j = xk4Var;
                ye2Var.i.m(xk4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, rn3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yk4 a;
        public final /* synthetic */ ye2 b;

        public g(ye2 ye2Var, yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, yk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ye2Var;
            this.a = yk4Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ye2 ye2Var = this.b;
                if (ye2Var.k == null) {
                    ye2Var.k = new ArrayList();
                }
                yk4 yk4Var = this.a;
                ye2 ye2Var2 = this.b;
                yk4Var.o = ye2Var2.o;
                ye2Var2.k.add(yk4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, rn3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk4 a;
        public final /* synthetic */ ye2 b;

        public h(ye2 ye2Var, vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, vk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ye2Var;
            this.a = vk4Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ye2 ye2Var = this.b;
                vk4 vk4Var = this.a;
                ye2Var.l = vk4Var;
                ye2Var.i.m(vk4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, rn3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tk4 a;
        public final /* synthetic */ ye2 b;

        public i(ye2 ye2Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, tk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ye2Var;
            this.a = tk4Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) == null) {
                y82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + rn3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.ue2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                y82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                ye2 ye2Var = this.b;
                tk4 tk4Var = this.a;
                ye2Var.m = tk4Var;
                ye2Var.i.m(tk4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends tmb<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 e;

        public j(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.omb
        /* renamed from: g */
        public void onNext(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wk4Var) == null) {
                y82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + wk4Var.i);
            }
        }

        @Override // com.baidu.tieba.omb
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                y82.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.omb
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements nmb.a<xk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public k(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public void call(tmb<? super xk4> tmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, tmbVar) != null) {
                return;
            }
            this.a.d = tmbVar;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements nmb.a<yk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public l(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public void call(tmb<? super yk4> tmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, tmbVar) != null) {
                return;
            }
            this.a.e = tmbVar;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements nmb.a<vk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public m(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public void call(tmb<? super vk4> tmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, tmbVar) != null) {
                return;
            }
            this.a.f = tmbVar;
        }
    }

    /* loaded from: classes8.dex */
    public class n implements nmb.a<tk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public n(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public void call(tmb<? super tk4> tmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, tmbVar) != null) {
                return;
            }
            this.a.g = tmbVar;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements nmb.a<zk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public o(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nmb.a, com.baidu.tieba.bnb
        public void call(tmb<? super zk4> tmbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, tmbVar) != null) {
                return;
            }
            this.a.h = tmbVar;
        }
    }

    /* loaded from: classes8.dex */
    public class p extends ff2<ye2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ye2 ye2Var, ye2 ye2Var2) {
            super(ye2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, ye2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((cf2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ff2, com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: s */
        public void c(yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, yk4Var) == null) {
                super.c(yk4Var);
                y82.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: u */
        public void f(yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yk4Var) == null) {
                super.f(yk4Var);
                this.c.E0(yk4Var);
            }
        }

        @Override // com.baidu.tieba.ff2, com.baidu.tieba.mj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ff2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ff2
        public void p(@NonNull yk4 yk4Var, @Nullable rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, yk4Var, rn3Var) == null) {
                super.p(yk4Var, rn3Var);
                y82.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + yk4Var.i);
                ye2 ye2Var = this.c;
                if (ye2Var.k == null) {
                    ye2Var.k = new ArrayList();
                }
                ye2 ye2Var2 = this.c;
                yk4Var.o = ye2Var2.o;
                if (rn3Var == null) {
                    ye2Var2.k.add(yk4Var);
                    this.c.i.m(yk4Var);
                    ue2.c().b(yk4Var, this.c.k0());
                } else {
                    ye2Var2.i.l(yk4Var);
                    ue2.c().a(yk4Var, this.c.k0(), rn3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(yk4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: q */
        public void e(yk4 yk4Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, yk4Var, sk4Var) == null) {
                super.q(yk4Var, sk4Var);
                y82.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + sk4Var.toString());
                this.c.i.l(yk4Var);
                rn3 rn3Var = new rn3();
                rn3Var.k(12L);
                rn3Var.i(sk4Var.a);
                rn3Var.d("分包下载失败");
                rn3Var.f(sk4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(yk4Var, rn3Var));
                }
                ue2.c().a(yk4Var, this.c.k0(), rn3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends df2<ye2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ye2 ye2Var, ye2 ye2Var2) {
            super(ye2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, ye2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((cf2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ye2Var;
        }

        @Override // com.baidu.tieba.df2
        public void u(zk4 zk4Var, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, zk4Var, rn3Var) == null) {
                y82.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + rn3Var);
                this.b.i.l(zk4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(zk4Var, rn3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df2, com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: v */
        public void c(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, zk4Var) == null) {
                super.c(zk4Var);
                y82.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.mj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.df2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.df2
        public void r(@NonNull zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, zk4Var) == null) {
                this.b.i.m(zk4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(zk4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.df2, com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: w */
        public void f(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, zk4Var) == null) {
                super.f(zk4Var);
                if (ye2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends mj4<vk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public r(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj4
        /* renamed from: l */
        public String d(vk4 vk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vk4Var)) == null) {
                int i = vk4Var.h;
                if (i == 0) {
                    return qf2.h();
                }
                if (i == 1) {
                    return qf2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: q */
        public void c(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, vk4Var) == null) {
                super.c(vk4Var);
                y82.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.rj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.mj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: o */
        public void e(vk4 vk4Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk4Var, sk4Var) == null) {
                super.e(vk4Var, sk4Var);
                y82.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + sk4Var.toString());
                this.a.i.l(vk4Var);
                rn3 rn3Var = new rn3();
                rn3Var.k(13L);
                rn3Var.i(sk4Var.a);
                rn3Var.d("Framework包下载失败");
                rn3Var.f(sk4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(vk4Var, rn3Var));
                }
                ue2.c().a(vk4Var, this.a.k0(), rn3Var);
                cs4.k(vk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: p */
        public void i(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, vk4Var) == null) {
                super.i(vk4Var);
                y82.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + vk4Var.i);
                rn3 y0 = this.a.y0(vk4Var);
                if (y0 == null) {
                    ye2 ye2Var = this.a;
                    ye2Var.l = vk4Var;
                    ye2Var.i.m(vk4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(vk4Var);
                        this.a.f.onCompleted();
                    }
                    ue2.c().b(vk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(vk4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(vk4Var, y0));
                }
                ue2.c().a(vk4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: r */
        public void f(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, vk4Var) == null) {
                super.f(vk4Var);
                if (ye2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(vk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s extends mj4<tk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public s(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj4
        /* renamed from: l */
        public String d(tk4 tk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tk4Var)) == null) {
                int i = tk4Var.h;
                if (i == 0) {
                    return qf2.d();
                }
                if (i == 1) {
                    return qf2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: q */
        public void c(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, tk4Var) == null) {
                super.c(tk4Var);
                y82.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.rj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.mj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: o */
        public void e(tk4 tk4Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tk4Var, sk4Var) == null) {
                super.e(tk4Var, sk4Var);
                y82.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + sk4Var.toString());
                this.a.i.l(tk4Var);
                rn3 rn3Var = new rn3();
                rn3Var.k(14L);
                rn3Var.i(sk4Var.a);
                rn3Var.d("Extension下载失败");
                rn3Var.f(sk4Var.toString());
                if (ye2.C) {
                    Log.e("SwanAppPkgDownloadCallback", rn3Var.toString());
                }
                this.a.q0(tk4Var);
                ue2.c().a(tk4Var, this.a.k0(), rn3Var);
                cs4.k(tk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: p */
        public void i(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, tk4Var) == null) {
                super.i(tk4Var);
                y82.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + tk4Var.i);
                rn3 x0 = this.a.x0(tk4Var);
                if (x0 == null) {
                    ye2 ye2Var = this.a;
                    ye2Var.m = tk4Var;
                    ye2Var.i.m(tk4Var);
                    this.a.q0(tk4Var);
                    ue2.c().b(tk4Var, this.a.k0());
                    return;
                }
                if (ye2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + tk4Var.toString());
                }
                this.a.i.l(tk4Var);
                this.a.q0(tk4Var);
                ue2.c().a(tk4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: r */
        public void f(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, tk4Var) == null) {
                super.f(tk4Var);
                if (ye2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(tk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements sj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public t(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        @Override // com.baidu.tieba.sj4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (ye2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                ye2 ye2Var = this.a;
                ye2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    ye2Var.o0(pMSAppInfo);
                    w73.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements rq3<rq3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(ye2 ye2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(rq3<PMSAppInfo> rq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rq3Var) == null) {
                rq3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(ye2 ye2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, collection, obj};
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

        public w(ye2 ye2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948327203, "Lcom/baidu/tieba/ye2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948327203, "Lcom/baidu/tieba/ye2;");
                return;
            }
        }
        C = is1.a;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<yk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.tj4
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
            return uj4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public sj4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (sj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<zk4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<tk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<vk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<xk4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (pj4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            y82.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public ye2(String str) {
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
        this.u = new bq3();
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

    @Override // com.baidu.tieba.tj4
    public void G(gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gp4Var) == null) {
            super.G(gp4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (gp4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + gp4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = gp4Var;
            if (!gp4Var.k()) {
                n0();
            }
        }
    }

    public rn3 y0(vk4 vk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, vk4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + vk4Var);
            }
            il3.b c2 = il3.c(vk4Var, vk4Var.h);
            if (!TextUtils.isEmpty(vk4Var.a)) {
                y82.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + vk4Var.a);
                cs4.k(vk4Var.a);
            }
            if (!c2.c()) {
                rn3 rn3Var = new rn3();
                rn3Var.k(13L);
                rn3Var.b(2907L);
                rn3Var.d("Core包更新失败");
                return rn3Var;
            }
            return null;
        }
        return (rn3) invokeL.objValue;
    }

    public final void B0(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tk4Var) == null) {
            ue2.c().d(tk4Var, new i(this, tk4Var));
        }
    }

    public final void C0(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vk4Var) == null) {
            ue2.c().d(vk4Var, new h(this, vk4Var));
        }
    }

    public final void D0(xk4 xk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xk4Var) == null) {
            ue2.c().d(xk4Var, new f(this, xk4Var));
        }
    }

    public final void E0(yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yk4Var) == null) {
            ue2.c().d(yk4Var, new g(this, yk4Var));
        }
    }

    public ye2 e0(rq3<PMSAppInfo> rq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rq3Var)) == null) {
            f0(this.t, rq3Var);
            return this;
        }
        return (ye2) invokeL.objValue;
    }

    public synchronized ye2 g0(hf2 hf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hf2Var)) == null) {
            synchronized (this) {
                f0(this.s, hf2Var);
            }
            return this;
        }
        return (ye2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                vj4.i().z(this.o, i2);
            } else {
                vj4.i().z(this.o, 0);
            }
        }
    }

    public ye2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (ye2) invokeL.objValue;
    }

    public final void q0(tk4 tk4Var) {
        tmb<? super tk4> tmbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, tk4Var) == null) && (tmbVar = this.g) != null) {
            tmbVar.onNext(tk4Var);
            this.g.onCompleted();
        }
    }

    public ye2 r0(@NonNull rq3<hf2> rq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, rq3Var)) == null) {
            p0(this.s, new c(this, rq3Var));
            return this;
        }
        return (ye2) invokeL.objValue;
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
            r63.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> ye2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ye2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ye2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ye2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ye2 p0(@NonNull Collection<CallbackT> collection, @NonNull rq3<CallbackT> rq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, rq3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, rq3Var));
            }
            return this;
        }
        return (ye2) invokeLL.objValue;
    }

    public void t0(boolean z, rn3 rn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, rn3Var) == null) {
            r0(new d(this, rn3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.ye2 Q(com.baidu.tieba.ye2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ye2.Q(com.baidu.tieba.ye2, java.util.Collection, java.lang.Object):com.baidu.tieba.ye2");
    }

    @Override // com.baidu.tieba.tj4
    public void C(sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sk4Var) == null) {
            y82.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + sk4Var);
            if (sk4Var != null && sk4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public rn3 z0(xk4 xk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, xk4Var)) == null) {
            if (xk4Var == null) {
                rn3 rn3Var = new rn3();
                rn3Var.k(11L);
                rn3Var.i(2310L);
                rn3Var.f("pkg info is empty");
                vn3.a().f(rn3Var);
                return rn3Var;
            }
            return null;
        }
        return (rn3) invokeL.objValue;
    }

    public rn3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    rn3 rn3Var = new rn3();
                    rn3Var.k(10L);
                    rn3Var.i(2903L);
                    rn3Var.d("Server未返回主包&AppInfo");
                    return rn3Var;
                }
                PMSAppInfo u2 = vj4.i().u(this.o);
                if (u2 == null) {
                    rn3 rn3Var2 = new rn3();
                    rn3Var2.k(10L);
                    rn3Var2.i(2904L);
                    rn3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return rn3Var2;
                }
                this.n = u2;
                qf2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (vj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                rn3 rn3Var3 = new rn3();
                rn3Var3.k(10L);
                rn3Var3.i(2906L);
                rn3Var3.d("更新DB失败");
                return rn3Var3;
            }
            xk4 xk4Var = this.j;
            if (xk4Var != null) {
                qf2.k(pMSAppInfo, xk4Var);
            } else if (rf2.f(this.k)) {
                yk4 yk4Var = this.k.get(0);
                this.q = yk4Var;
                yk4Var.o = this.o;
                qf2.l(this.n, yk4Var);
            } else {
                PMSAppInfo u3 = vj4.i().u(this.o);
                if (u3 == null) {
                    rn3 rn3Var4 = new rn3();
                    rn3Var4.k(10L);
                    rn3Var4.i(2905L);
                    rn3Var4.d("Server未返回包数据，本地也没有数据");
                    return rn3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (vj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                qf2.o(this.n);
                return null;
            }
            rn3 rn3Var5 = new rn3();
            rn3Var5.k(10L);
            rn3Var5.i(2906L);
            rn3Var5.d("更新DB失败");
            return rn3Var5;
        }
        return (rn3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = vj4.i().u(this.o);
            y82.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                xk4 xk4Var = this.j;
                if (xk4Var != null) {
                    xk4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                vj4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(nmb.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(nmb.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(nmb.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(nmb.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(nmb.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                nmb.k(arrayList).w(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = vj4.i().u(this.o);
        if (u2 == null) {
            y82.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (vj4.i().l(this.n)) {
            qf2.o(this.n);
        }
    }

    public rn3 x0(tk4 tk4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, tk4Var)) == null) {
            en2 en2Var = new en2();
            en2Var.b = tk4Var.i;
            en2Var.a = tk4Var.j;
            en2Var.c = tk4Var.a;
            en2Var.d = tk4Var.m;
            if (hm2.b(tk4Var.h, en2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                rn3 rn3Var = new rn3();
                rn3Var.k(14L);
                rn3Var.b(2908L);
                rn3Var.d("Extension包更新失败");
                return rn3Var;
            }
            return null;
        }
        return (rn3) invokeL.objValue;
    }
}
