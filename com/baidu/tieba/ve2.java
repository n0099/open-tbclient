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
import com.baidu.tieba.fl3;
import com.baidu.tieba.re2;
import com.baidu.tieba.u1c;
import com.baidu.tieba.zb3;
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
public abstract class ve2 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public pj4 A;
    public a2c<tk4> B;
    public String c;
    public a2c<? super uk4> d;
    public a2c<? super vk4> e;
    public a2c<? super sk4> f;
    public a2c<? super qk4> g;
    public a2c<? super wk4> h;
    public dp4 i;
    public uk4 j;
    public List<vk4> k;
    public sk4 l;
    public qk4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public vk4 q;
    public long r;
    public final Set<ef2> s;
    public final Set<oq3<PMSAppInfo>> t;
    public final yp3 u;
    public mj4<uk4> v;
    public mj4<vk4> w;
    public final mj4<wk4> x;
    public mj4<sk4> y;
    public mj4<qk4> z;

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
    public class a extends jj4<uk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        /* renamed from: com.baidu.tieba.ve2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0509a implements oq3<zb3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0509a(a aVar) {
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
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(zb3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    rj4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(uk4 uk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, uk4Var)) == null) {
                int i = uk4Var.h;
                if (i == 0) {
                    return nf2.g();
                }
                if (i == 1) {
                    return nf2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void c(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, uk4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (ve2.C) {
                ax2.d(l0).e().d(1);
            }
            super.c(uk4Var);
            v82.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.oj4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.jj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(uk4 uk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, uk4Var, pk4Var) == null) {
                super.e(uk4Var, pk4Var);
                v82.k("SwanAppPkgDownloadCallback", "onDownloadError：" + pk4Var.toString());
                this.a.i.l(uk4Var);
                on3 on3Var = new on3();
                on3Var.k(11L);
                on3Var.i(pk4Var.a);
                on3Var.d("主包下载失败");
                on3Var.f(pk4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(uk4Var, on3Var));
                }
                re2.c().a(uk4Var, this.a.k0(), on3Var);
                zr4.k(uk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, uk4Var) == null) {
                String l0 = this.a.l0();
                if (ve2.C) {
                    ax2.d(l0).e().d(1);
                }
                super.i(uk4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                on3 z0 = this.a.z0(uk4Var);
                v82.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + uk4Var.i);
                if (z0 == null) {
                    ve2 ve2Var = this.a;
                    ve2Var.j = uk4Var;
                    ve2Var.i.m(uk4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(uk4Var);
                        if (ve2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    re2.c().b(uk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(uk4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(uk4Var, z0));
                }
                re2.c().a(uk4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void f(uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, uk4Var) == null) {
                String l0 = this.a.l0();
                if (ve2.C) {
                    ax2.d(l0).e().d(1);
                }
                super.f(uk4Var);
                if (ve2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(uk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: s */
        public pk4 h(uk4 uk4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{uk4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (ve2.C) {
                    ax2.d(l0).f(uk4Var.toString()).d(1);
                }
                C0509a c0509a = new C0509a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                tu2 tu2Var = new tu2();
                tu2Var.u(c0509a);
                tu2Var.K(bundle);
                tu2Var.J(new su2(uk4Var, this.a));
                tu2Var.J(new qu2(uk4Var.m, this.a));
                tu2Var.M(readableByteChannel);
                boolean N = tu2Var.N();
                tu2Var.o(c0509a);
                if (ve2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    v82.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    zr4.L(file);
                }
                if (N) {
                    return new pk4(2300, "业务层处理下载流成功");
                }
                return new pk4(2301, "业务层处理下载流失败");
            }
            return (pk4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ oq3 b;

        public b(ve2 ve2Var, Collection collection, oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, collection, oq3Var};
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
            this.b = oq3Var;
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
    public class c implements oq3<ef2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq3 a;
        public final /* synthetic */ ve2 b;

        public c(ve2 ve2Var, oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, oq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve2Var;
            this.a = oq3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.ve2.Q(com.baidu.tieba.ve2, java.util.Collection, java.lang.Object):com.baidu.tieba.ve2
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(com.baidu.tieba.ef2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.ve2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.oq3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.ve2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.ve2.P(r0)
                com.baidu.tieba.ve2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ve2.c.a(com.baidu.tieba.ef2):void");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements oq3<ef2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on3 a;
        public final /* synthetic */ boolean b;

        public d(ve2 ve2Var, on3 on3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, on3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = on3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(ef2 ef2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef2Var) == null) {
                ef2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements oq3<ef2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(ve2 ve2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(ef2 ef2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef2Var) == null) {
                ef2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk4 a;
        public final /* synthetic */ ve2 b;

        public f(ve2 ve2Var, uk4 uk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, uk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve2Var;
            this.a = uk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ve2 ve2Var = this.b;
                uk4 uk4Var = this.a;
                ve2Var.j = uk4Var;
                ve2Var.i.m(uk4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, on3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk4 a;
        public final /* synthetic */ ve2 b;

        public g(ve2 ve2Var, vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, vk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve2Var;
            this.a = vk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ve2 ve2Var = this.b;
                if (ve2Var.k == null) {
                    ve2Var.k = new ArrayList();
                }
                vk4 vk4Var = this.a;
                ve2 ve2Var2 = this.b;
                vk4Var.o = ve2Var2.o;
                ve2Var2.k.add(vk4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, on3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sk4 a;
        public final /* synthetic */ ve2 b;

        public h(ve2 ve2Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, sk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve2Var;
            this.a = sk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ve2 ve2Var = this.b;
                sk4 sk4Var = this.a;
                ve2Var.l = sk4Var;
                ve2Var.i.m(sk4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, on3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk4 a;
        public final /* synthetic */ ve2 b;

        public i(ve2 ve2Var, qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, qk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve2Var;
            this.a = qk4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) == null) {
                v82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + on3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                v82.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                ve2 ve2Var = this.b;
                qk4 qk4Var = this.a;
                ve2Var.m = qk4Var;
                ve2Var.i.m(qk4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends a2c<tk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 e;

        public j(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v1c
        /* renamed from: g */
        public void onNext(tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tk4Var) == null) {
                v82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + tk4Var.i);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                v82.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.v1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v82.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements u1c.a<uk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public k(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super uk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.d = a2cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements u1c.a<vk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public l(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super vk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.e = a2cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements u1c.a<sk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public m(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super sk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.f = a2cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class n implements u1c.a<qk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public n(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super qk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.g = a2cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements u1c.a<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public o(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
        public void call(a2c<? super wk4> a2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, a2cVar) != null) {
                return;
            }
            this.a.h = a2cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class p extends cf2<ve2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ve2 ve2Var, ve2 ve2Var2) {
            super(ve2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, ve2Var2};
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
            this.c = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cf2, com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: s */
        public void c(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, vk4Var) == null) {
                super.c(vk4Var);
                v82.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: u */
        public void f(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk4Var) == null) {
                super.f(vk4Var);
                this.c.E0(vk4Var);
            }
        }

        @Override // com.baidu.tieba.cf2, com.baidu.tieba.jj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.cf2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.cf2
        public void p(@NonNull vk4 vk4Var, @Nullable on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, vk4Var, on3Var) == null) {
                super.p(vk4Var, on3Var);
                v82.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + vk4Var.i);
                ve2 ve2Var = this.c;
                if (ve2Var.k == null) {
                    ve2Var.k = new ArrayList();
                }
                ve2 ve2Var2 = this.c;
                vk4Var.o = ve2Var2.o;
                if (on3Var == null) {
                    ve2Var2.k.add(vk4Var);
                    this.c.i.m(vk4Var);
                    re2.c().b(vk4Var, this.c.k0());
                } else {
                    ve2Var2.i.l(vk4Var);
                    re2.c().a(vk4Var, this.c.k0(), on3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(vk4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void e(vk4 vk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, vk4Var, pk4Var) == null) {
                super.q(vk4Var, pk4Var);
                v82.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + pk4Var.toString());
                this.c.i.l(vk4Var);
                on3 on3Var = new on3();
                on3Var.k(12L);
                on3Var.i(pk4Var.a);
                on3Var.d("分包下载失败");
                on3Var.f(pk4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(vk4Var, on3Var));
                }
                re2.c().a(vk4Var, this.c.k0(), on3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends af2<ve2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ve2 ve2Var, ve2 ve2Var2) {
            super(ve2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, ve2Var2};
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
            this.b = ve2Var;
        }

        @Override // com.baidu.tieba.af2
        public void u(wk4 wk4Var, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, wk4Var, on3Var) == null) {
                v82.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + on3Var);
                this.b.i.l(wk4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(wk4Var, on3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.af2, com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: v */
        public void c(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, wk4Var) == null) {
                super.c(wk4Var);
                v82.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.jj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.af2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.af2
        public void r(@NonNull wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, wk4Var) == null) {
                this.b.i.m(wk4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(wk4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.af2, com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: w */
        public void f(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, wk4Var) == null) {
                super.f(wk4Var);
                if (ve2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends jj4<sk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public r(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(sk4 sk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sk4Var)) == null) {
                int i = sk4Var.h;
                if (i == 0) {
                    return nf2.h();
                }
                if (i == 1) {
                    return nf2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void c(sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sk4Var) == null) {
                super.c(sk4Var);
                v82.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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

        @Override // com.baidu.tieba.jj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(sk4 sk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sk4Var, pk4Var) == null) {
                super.e(sk4Var, pk4Var);
                v82.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + pk4Var.toString());
                this.a.i.l(sk4Var);
                on3 on3Var = new on3();
                on3Var.k(13L);
                on3Var.i(pk4Var.a);
                on3Var.d("Framework包下载失败");
                on3Var.f(pk4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(sk4Var, on3Var));
                }
                re2.c().a(sk4Var, this.a.k0(), on3Var);
                zr4.k(sk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sk4Var) == null) {
                super.i(sk4Var);
                v82.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + sk4Var.i);
                on3 y0 = this.a.y0(sk4Var);
                if (y0 == null) {
                    ve2 ve2Var = this.a;
                    ve2Var.l = sk4Var;
                    ve2Var.i.m(sk4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(sk4Var);
                        this.a.f.onCompleted();
                    }
                    re2.c().b(sk4Var, this.a.k0());
                    return;
                }
                this.a.i.l(sk4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(sk4Var, y0));
                }
                re2.c().a(sk4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void f(sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, sk4Var) == null) {
                super.f(sk4Var);
                if (ve2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(sk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s extends jj4<qk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public s(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(qk4 qk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qk4Var)) == null) {
                int i = qk4Var.h;
                if (i == 0) {
                    return nf2.d();
                }
                if (i == 1) {
                    return nf2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void c(qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, qk4Var) == null) {
                super.c(qk4Var);
                v82.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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

        @Override // com.baidu.tieba.jj4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(qk4 qk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qk4Var, pk4Var) == null) {
                super.e(qk4Var, pk4Var);
                v82.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + pk4Var.toString());
                this.a.i.l(qk4Var);
                on3 on3Var = new on3();
                on3Var.k(14L);
                on3Var.i(pk4Var.a);
                on3Var.d("Extension下载失败");
                on3Var.f(pk4Var.toString());
                if (ve2.C) {
                    Log.e("SwanAppPkgDownloadCallback", on3Var.toString());
                }
                this.a.q0(qk4Var);
                re2.c().a(qk4Var, this.a.k0(), on3Var);
                zr4.k(qk4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, qk4Var) == null) {
                super.i(qk4Var);
                v82.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + qk4Var.i);
                on3 x0 = this.a.x0(qk4Var);
                if (x0 == null) {
                    ve2 ve2Var = this.a;
                    ve2Var.m = qk4Var;
                    ve2Var.i.m(qk4Var);
                    this.a.q0(qk4Var);
                    re2.c().b(qk4Var, this.a.k0());
                    return;
                }
                if (ve2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + qk4Var.toString());
                }
                this.a.i.l(qk4Var);
                this.a.q0(qk4Var);
                re2.c().a(qk4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void f(qk4 qk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, qk4Var) == null) {
                super.f(qk4Var);
                if (ve2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(qk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements pj4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ve2 a;

        public t(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ve2Var;
        }

        @Override // com.baidu.tieba.pj4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (ve2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                ve2 ve2Var = this.a;
                ve2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    ve2Var.o0(pMSAppInfo);
                    t73.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements oq3<oq3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(ve2 ve2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(oq3<PMSAppInfo> oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oq3Var) == null) {
                oq3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(ve2 ve2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, collection, obj};
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

        public w(ve2 ve2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948237830, "Lcom/baidu/tieba/ve2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948237830, "Lcom/baidu/tieba/ve2;");
                return;
            }
        }
        C = fs1.a;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<vk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.qj4
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
            return rj4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public pj4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<wk4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<qk4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<sk4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<uk4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (mj4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            v82.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public ve2(String str) {
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
        this.u = new yp3();
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

    @Override // com.baidu.tieba.qj4
    public void G(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dp4Var) == null) {
            super.G(dp4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (dp4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + dp4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = dp4Var;
            if (!dp4Var.k()) {
                n0();
            }
        }
    }

    public on3 y0(sk4 sk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, sk4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + sk4Var);
            }
            fl3.b c2 = fl3.c(sk4Var, sk4Var.h);
            if (!TextUtils.isEmpty(sk4Var.a)) {
                v82.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + sk4Var.a);
                zr4.k(sk4Var.a);
            }
            if (!c2.c()) {
                on3 on3Var = new on3();
                on3Var.k(13L);
                on3Var.b(2907L);
                on3Var.d("Core包更新失败");
                return on3Var;
            }
            return null;
        }
        return (on3) invokeL.objValue;
    }

    public final void B0(qk4 qk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qk4Var) == null) {
            re2.c().d(qk4Var, new i(this, qk4Var));
        }
    }

    public final void C0(sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sk4Var) == null) {
            re2.c().d(sk4Var, new h(this, sk4Var));
        }
    }

    public final void D0(uk4 uk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uk4Var) == null) {
            re2.c().d(uk4Var, new f(this, uk4Var));
        }
    }

    public final void E0(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk4Var) == null) {
            re2.c().d(vk4Var, new g(this, vk4Var));
        }
    }

    public ve2 e0(oq3<PMSAppInfo> oq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, oq3Var)) == null) {
            f0(this.t, oq3Var);
            return this;
        }
        return (ve2) invokeL.objValue;
    }

    public synchronized ve2 g0(ef2 ef2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ef2Var)) == null) {
            synchronized (this) {
                f0(this.s, ef2Var);
            }
            return this;
        }
        return (ve2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                sj4.i().z(this.o, i2);
            } else {
                sj4.i().z(this.o, 0);
            }
        }
    }

    public ve2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (ve2) invokeL.objValue;
    }

    public final void q0(qk4 qk4Var) {
        a2c<? super qk4> a2cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, qk4Var) == null) && (a2cVar = this.g) != null) {
            a2cVar.onNext(qk4Var);
            this.g.onCompleted();
        }
    }

    public ve2 r0(@NonNull oq3<ef2> oq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, oq3Var)) == null) {
            p0(this.s, new c(this, oq3Var));
            return this;
        }
        return (ve2) invokeL.objValue;
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
            o63.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> ve2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ve2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ve2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ve2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ve2 p0(@NonNull Collection<CallbackT> collection, @NonNull oq3<CallbackT> oq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, oq3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, oq3Var));
            }
            return this;
        }
        return (ve2) invokeLL.objValue;
    }

    public void t0(boolean z, on3 on3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, on3Var) == null) {
            r0(new d(this, on3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.ve2 Q(com.baidu.tieba.ve2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ve2.Q(com.baidu.tieba.ve2, java.util.Collection, java.lang.Object):com.baidu.tieba.ve2");
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pk4Var) == null) {
            v82.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + pk4Var);
            if (pk4Var != null && pk4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public on3 z0(uk4 uk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, uk4Var)) == null) {
            if (uk4Var == null) {
                on3 on3Var = new on3();
                on3Var.k(11L);
                on3Var.i(2310L);
                on3Var.f("pkg info is empty");
                sn3.a().f(on3Var);
                return on3Var;
            }
            return null;
        }
        return (on3) invokeL.objValue;
    }

    public on3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    on3 on3Var = new on3();
                    on3Var.k(10L);
                    on3Var.i(2903L);
                    on3Var.d("Server未返回主包&AppInfo");
                    return on3Var;
                }
                PMSAppInfo u2 = sj4.i().u(this.o);
                if (u2 == null) {
                    on3 on3Var2 = new on3();
                    on3Var2.k(10L);
                    on3Var2.i(2904L);
                    on3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return on3Var2;
                }
                this.n = u2;
                nf2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (sj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                on3 on3Var3 = new on3();
                on3Var3.k(10L);
                on3Var3.i(2906L);
                on3Var3.d("更新DB失败");
                return on3Var3;
            }
            uk4 uk4Var = this.j;
            if (uk4Var != null) {
                nf2.k(pMSAppInfo, uk4Var);
            } else if (of2.f(this.k)) {
                vk4 vk4Var = this.k.get(0);
                this.q = vk4Var;
                vk4Var.o = this.o;
                nf2.l(this.n, vk4Var);
            } else {
                PMSAppInfo u3 = sj4.i().u(this.o);
                if (u3 == null) {
                    on3 on3Var4 = new on3();
                    on3Var4.k(10L);
                    on3Var4.i(2905L);
                    on3Var4.d("Server未返回包数据，本地也没有数据");
                    return on3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (sj4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                nf2.o(this.n);
                return null;
            }
            on3 on3Var5 = new on3();
            on3Var5.k(10L);
            on3Var5.i(2906L);
            on3Var5.d("更新DB失败");
            return on3Var5;
        }
        return (on3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = sj4.i().u(this.o);
            v82.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                uk4 uk4Var = this.j;
                if (uk4Var != null) {
                    uk4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                sj4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(u1c.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(u1c.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(u1c.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(u1c.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(u1c.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                u1c.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = sj4.i().u(this.o);
        if (u2 == null) {
            v82.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (sj4.i().l(this.n)) {
            nf2.o(this.n);
        }
    }

    public on3 x0(qk4 qk4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, qk4Var)) == null) {
            bn2 bn2Var = new bn2();
            bn2Var.b = qk4Var.i;
            bn2Var.a = qk4Var.j;
            bn2Var.c = qk4Var.a;
            bn2Var.d = qk4Var.m;
            if (em2.b(qk4Var.h, bn2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                on3 on3Var = new on3();
                on3Var.k(14L);
                on3Var.b(2908L);
                on3Var.d("Extension包更新失败");
                return on3Var;
            }
            return null;
        }
        return (on3) invokeL.objValue;
    }
}
