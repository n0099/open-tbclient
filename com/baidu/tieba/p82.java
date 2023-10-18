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
import com.baidu.tieba.h6c;
import com.baidu.tieba.l82;
import com.baidu.tieba.t53;
import com.baidu.tieba.ze3;
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
/* loaded from: classes7.dex */
public abstract class p82 extends t82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public jd4 A;
    public n6c<ne4> B;
    public String c;
    public n6c<? super oe4> d;
    public n6c<? super pe4> e;
    public n6c<? super me4> f;
    public n6c<? super ke4> g;
    public n6c<? super qe4> h;
    public xi4 i;
    public oe4 j;
    public List<pe4> k;
    public me4 l;
    public ke4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public pe4 q;
    public long r;
    public final Set<y82> s;
    public final Set<ik3<PMSAppInfo>> t;
    public final sj3 u;
    public gd4<oe4> v;
    public gd4<pe4> w;
    public final gd4<qe4> x;
    public gd4<me4> y;
    public gd4<ke4> z;

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

    /* loaded from: classes7.dex */
    public class a extends dd4<oe4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        /* renamed from: com.baidu.tieba.p82$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0425a implements ik3<t53.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0425a(a aVar) {
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
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(t53.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    ld4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gd4
        /* renamed from: l */
        public String d(oe4 oe4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, oe4Var)) == null) {
                int i = oe4Var.h;
                if (i == 0) {
                    return h92.g();
                }
                if (i == 1) {
                    return h92.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void c(oe4 oe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, oe4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (p82.C) {
                uq2.d(l0).e().d(1);
            }
            super.c(oe4Var);
            p22.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.id4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.dd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: o */
        public void e(oe4 oe4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, oe4Var, je4Var) == null) {
                super.e(oe4Var, je4Var);
                p22.k("SwanAppPkgDownloadCallback", "onDownloadError：" + je4Var.toString());
                this.a.i.l(oe4Var);
                ih3 ih3Var = new ih3();
                ih3Var.k(11L);
                ih3Var.i(je4Var.a);
                ih3Var.d("主包下载失败");
                ih3Var.f(je4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(oe4Var, ih3Var));
                }
                l82.c().a(oe4Var, this.a.k0(), ih3Var);
                sl4.k(oe4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: p */
        public void i(oe4 oe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, oe4Var) == null) {
                String l0 = this.a.l0();
                if (p82.C) {
                    uq2.d(l0).e().d(1);
                }
                super.i(oe4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                ih3 z0 = this.a.z0(oe4Var);
                p22.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + oe4Var.i);
                if (z0 == null) {
                    p82 p82Var = this.a;
                    p82Var.j = oe4Var;
                    p82Var.i.m(oe4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(oe4Var);
                        if (p82.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    l82.c().b(oe4Var, this.a.k0());
                    return;
                }
                this.a.i.l(oe4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(oe4Var, z0));
                }
                l82.c().a(oe4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: r */
        public void f(oe4 oe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, oe4Var) == null) {
                String l0 = this.a.l0();
                if (p82.C) {
                    uq2.d(l0).e().d(1);
                }
                super.f(oe4Var);
                if (p82.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(oe4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: s */
        public je4 h(oe4 oe4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{oe4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (p82.C) {
                    uq2.d(l0).f(oe4Var.toString()).d(1);
                }
                C0425a c0425a = new C0425a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                no2 no2Var = new no2();
                no2Var.u(c0425a);
                no2Var.K(bundle);
                no2Var.J(new mo2(oe4Var, this.a));
                no2Var.J(new ko2(oe4Var.m, this.a));
                no2Var.M(readableByteChannel);
                boolean N = no2Var.N();
                no2Var.o(c0425a);
                if (p82.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    p22.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    sl4.L(file);
                }
                if (N) {
                    return new je4(2300, "业务层处理下载流成功");
                }
                return new je4(2301, "业务层处理下载流失败");
            }
            return (je4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ ik3 b;

        public b(p82 p82Var, Collection collection, ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, collection, ik3Var};
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
            this.b = ik3Var;
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

    /* loaded from: classes7.dex */
    public class c implements ik3<y82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;
        public final /* synthetic */ p82 b;

        public c(p82 p82Var, ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p82Var;
            this.a = ik3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.p82.Q(com.baidu.tieba.p82, java.util.Collection, java.lang.Object):com.baidu.tieba.p82
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(com.baidu.tieba.y82 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.p82.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.ik3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.p82 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.p82.P(r0)
                com.baidu.tieba.p82.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.p82.c.a(com.baidu.tieba.y82):void");
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ik3<y82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ih3 a;
        public final /* synthetic */ boolean b;

        public d(p82 p82Var, ih3 ih3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, ih3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ih3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(y82 y82Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y82Var) == null) {
                y82Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ik3<y82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(p82 p82Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(y82 y82Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y82Var) == null) {
                y82Var.b(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oe4 a;
        public final /* synthetic */ p82 b;

        public f(p82 p82Var, oe4 oe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, oe4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p82Var;
            this.a = oe4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                p82 p82Var = this.b;
                oe4 oe4Var = this.a;
                p82Var.j = oe4Var;
                p82Var.i.m(oe4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, ih3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe4 a;
        public final /* synthetic */ p82 b;

        public g(p82 p82Var, pe4 pe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, pe4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p82Var;
            this.a = pe4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                p82 p82Var = this.b;
                if (p82Var.k == null) {
                    p82Var.k = new ArrayList();
                }
                pe4 pe4Var = this.a;
                p82 p82Var2 = this.b;
                pe4Var.o = p82Var2.o;
                p82Var2.k.add(pe4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, ih3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me4 a;
        public final /* synthetic */ p82 b;

        public h(p82 p82Var, me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, me4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p82Var;
            this.a = me4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                p82 p82Var = this.b;
                me4 me4Var = this.a;
                p82Var.l = me4Var;
                p82Var.i.m(me4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, ih3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ke4 a;
        public final /* synthetic */ p82 b;

        public i(p82 p82Var, ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, ke4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p82Var;
            this.a = ke4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                p22.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + ih3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.l82.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                p22.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                p82 p82Var = this.b;
                ke4 ke4Var = this.a;
                p82Var.m = ke4Var;
                p82Var.i.m(ke4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends n6c<ne4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 e;

        public j(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i6c
        /* renamed from: g */
        public void onNext(ne4 ne4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ne4Var) == null) {
                p22.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + ne4Var.i);
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                p22.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                p22.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements h6c.a<oe4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public k(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super oe4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.d = n6cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements h6c.a<pe4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public l(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super pe4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.e = n6cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class m implements h6c.a<me4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public m(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super me4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.f = n6cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements h6c.a<ke4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public n(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super ke4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.g = n6cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class o implements h6c.a<qe4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public o(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super qe4> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, n6cVar) != null) {
                return;
            }
            this.a.h = n6cVar;
        }
    }

    /* loaded from: classes7.dex */
    public class p extends w82<p82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(p82 p82Var, p82 p82Var2) {
            super(p82Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, p82Var2};
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
            this.c = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w82, com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: s */
        public void c(pe4 pe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, pe4Var) == null) {
                super.c(pe4Var);
                p22.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: u */
        public void f(pe4 pe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pe4Var) == null) {
                super.f(pe4Var);
                this.c.E0(pe4Var);
            }
        }

        @Override // com.baidu.tieba.w82, com.baidu.tieba.dd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.w82
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.w82
        public void p(@NonNull pe4 pe4Var, @Nullable ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, pe4Var, ih3Var) == null) {
                super.p(pe4Var, ih3Var);
                p22.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + pe4Var.i);
                p82 p82Var = this.c;
                if (p82Var.k == null) {
                    p82Var.k = new ArrayList();
                }
                p82 p82Var2 = this.c;
                pe4Var.o = p82Var2.o;
                if (ih3Var == null) {
                    p82Var2.k.add(pe4Var);
                    this.c.i.m(pe4Var);
                    l82.c().b(pe4Var, this.c.k0());
                } else {
                    p82Var2.i.l(pe4Var);
                    l82.c().a(pe4Var, this.c.k0(), ih3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(pe4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void e(pe4 pe4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, pe4Var, je4Var) == null) {
                super.q(pe4Var, je4Var);
                p22.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + je4Var.toString());
                this.c.i.l(pe4Var);
                ih3 ih3Var = new ih3();
                ih3Var.k(12L);
                ih3Var.i(je4Var.a);
                ih3Var.d("分包下载失败");
                ih3Var.f(je4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(pe4Var, ih3Var));
                }
                l82.c().a(pe4Var, this.c.k0(), ih3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends u82<p82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(p82 p82Var, p82 p82Var2) {
            super(p82Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, p82Var2};
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
            this.b = p82Var;
        }

        @Override // com.baidu.tieba.u82
        public void u(qe4 qe4Var, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, qe4Var, ih3Var) == null) {
                p22.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + ih3Var);
                this.b.i.l(qe4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(qe4Var, ih3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u82, com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: v */
        public void c(qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, qe4Var) == null) {
                super.c(qe4Var);
                p22.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.dd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.u82
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.u82
        public void r(@NonNull qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, qe4Var) == null) {
                this.b.i.m(qe4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(qe4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.u82, com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: w */
        public void f(qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, qe4Var) == null) {
                super.f(qe4Var);
                if (p82.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends dd4<me4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public r(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gd4
        /* renamed from: l */
        public String d(me4 me4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, me4Var)) == null) {
                int i = me4Var.h;
                if (i == 0) {
                    return h92.h();
                }
                if (i == 1) {
                    return h92.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void c(me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, me4Var) == null) {
                super.c(me4Var);
                p22.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
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

        @Override // com.baidu.tieba.dd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: o */
        public void e(me4 me4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, me4Var, je4Var) == null) {
                super.e(me4Var, je4Var);
                p22.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + je4Var.toString());
                this.a.i.l(me4Var);
                ih3 ih3Var = new ih3();
                ih3Var.k(13L);
                ih3Var.i(je4Var.a);
                ih3Var.d("Framework包下载失败");
                ih3Var.f(je4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(me4Var, ih3Var));
                }
                l82.c().a(me4Var, this.a.k0(), ih3Var);
                sl4.k(me4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: p */
        public void i(me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, me4Var) == null) {
                super.i(me4Var);
                p22.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + me4Var.i);
                ih3 y0 = this.a.y0(me4Var);
                if (y0 == null) {
                    p82 p82Var = this.a;
                    p82Var.l = me4Var;
                    p82Var.i.m(me4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(me4Var);
                        this.a.f.onCompleted();
                    }
                    l82.c().b(me4Var, this.a.k0());
                    return;
                }
                this.a.i.l(me4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(me4Var, y0));
                }
                l82.c().a(me4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: r */
        public void f(me4 me4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, me4Var) == null) {
                super.f(me4Var);
                if (p82.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(me4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends dd4<ke4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public s(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gd4
        /* renamed from: l */
        public String d(ke4 ke4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ke4Var)) == null) {
                int i = ke4Var.h;
                if (i == 0) {
                    return h92.d();
                }
                if (i == 1) {
                    return h92.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: q */
        public void c(ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ke4Var) == null) {
                super.c(ke4Var);
                p22.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
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

        @Override // com.baidu.tieba.dd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: o */
        public void e(ke4 ke4Var, je4 je4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ke4Var, je4Var) == null) {
                super.e(ke4Var, je4Var);
                p22.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + je4Var.toString());
                this.a.i.l(ke4Var);
                ih3 ih3Var = new ih3();
                ih3Var.k(14L);
                ih3Var.i(je4Var.a);
                ih3Var.d("Extension下载失败");
                ih3Var.f(je4Var.toString());
                if (p82.C) {
                    Log.e("SwanAppPkgDownloadCallback", ih3Var.toString());
                }
                this.a.q0(ke4Var);
                l82.c().a(ke4Var, this.a.k0(), ih3Var);
                sl4.k(ke4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: p */
        public void i(ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ke4Var) == null) {
                super.i(ke4Var);
                p22.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + ke4Var.i);
                ih3 x0 = this.a.x0(ke4Var);
                if (x0 == null) {
                    p82 p82Var = this.a;
                    p82Var.m = ke4Var;
                    p82Var.i.m(ke4Var);
                    this.a.q0(ke4Var);
                    l82.c().b(ke4Var, this.a.k0());
                    return;
                }
                if (p82.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + ke4Var.toString());
                }
                this.a.i.l(ke4Var);
                this.a.q0(ke4Var);
                l82.c().a(ke4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
        /* renamed from: r */
        public void f(ke4 ke4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ke4Var) == null) {
                super.f(ke4Var);
                if (p82.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(ke4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements jd4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p82 a;

        public t(p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p82Var;
        }

        @Override // com.baidu.tieba.jd4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (p82.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                p82 p82Var = this.a;
                p82Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    p82Var.o0(pMSAppInfo);
                    n13.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements ik3<ik3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(p82 p82Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(ik3<PMSAppInfo> ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik3Var) == null) {
                ik3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(p82 p82Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, collection, obj};
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

    /* loaded from: classes7.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public w(p82 p82Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p82Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015839, "Lcom/baidu/tieba/p82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015839, "Lcom/baidu/tieba/p82;");
                return;
            }
        }
        C = am1.a;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<pe4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.kd4
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
            return ld4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public jd4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (jd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<qe4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<ke4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<me4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public gd4<oe4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (gd4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            p22.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public p82(String str) {
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
        this.u = new sj3();
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

    @Override // com.baidu.tieba.kd4
    public void G(xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xi4Var) == null) {
            super.G(xi4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (xi4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + xi4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = xi4Var;
            if (!xi4Var.k()) {
                n0();
            }
        }
    }

    public ih3 y0(me4 me4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, me4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + me4Var);
            }
            ze3.b c2 = ze3.c(me4Var, me4Var.h);
            if (!TextUtils.isEmpty(me4Var.a)) {
                p22.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + me4Var.a);
                sl4.k(me4Var.a);
            }
            if (!c2.c()) {
                ih3 ih3Var = new ih3();
                ih3Var.k(13L);
                ih3Var.b(2907L);
                ih3Var.d("Core包更新失败");
                return ih3Var;
            }
            return null;
        }
        return (ih3) invokeL.objValue;
    }

    public final void B0(ke4 ke4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ke4Var) == null) {
            l82.c().d(ke4Var, new i(this, ke4Var));
        }
    }

    public final void C0(me4 me4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, me4Var) == null) {
            l82.c().d(me4Var, new h(this, me4Var));
        }
    }

    public final void D0(oe4 oe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oe4Var) == null) {
            l82.c().d(oe4Var, new f(this, oe4Var));
        }
    }

    public final void E0(pe4 pe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pe4Var) == null) {
            l82.c().d(pe4Var, new g(this, pe4Var));
        }
    }

    public p82 e0(ik3<PMSAppInfo> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ik3Var)) == null) {
            f0(this.t, ik3Var);
            return this;
        }
        return (p82) invokeL.objValue;
    }

    public synchronized p82 g0(y82 y82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, y82Var)) == null) {
            synchronized (this) {
                f0(this.s, y82Var);
            }
            return this;
        }
        return (p82) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                md4.i().z(this.o, i2);
            } else {
                md4.i().z(this.o, 0);
            }
        }
    }

    public p82 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (p82) invokeL.objValue;
    }

    public final void q0(ke4 ke4Var) {
        n6c<? super ke4> n6cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, ke4Var) == null) && (n6cVar = this.g) != null) {
            n6cVar.onNext(ke4Var);
            this.g.onCompleted();
        }
    }

    public p82 r0(@NonNull ik3<y82> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, ik3Var)) == null) {
            p0(this.s, new c(this, ik3Var));
            return this;
        }
        return (p82) invokeL.objValue;
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
            i03.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> p82 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (p82) invokeLL.objValue;
    }

    public final synchronized <CallbackT> p82 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (p82) invokeLL.objValue;
    }

    public final synchronized <CallbackT> p82 p0(@NonNull Collection<CallbackT> collection, @NonNull ik3<CallbackT> ik3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, ik3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, ik3Var));
            }
            return this;
        }
        return (p82) invokeLL.objValue;
    }

    public void t0(boolean z, ih3 ih3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, ih3Var) == null) {
            r0(new d(this, ih3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.p82 Q(com.baidu.tieba.p82 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.p82.Q(com.baidu.tieba.p82, java.util.Collection, java.lang.Object):com.baidu.tieba.p82");
    }

    @Override // com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, je4Var) == null) {
            p22.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + je4Var);
            if (je4Var != null && je4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public ih3 z0(oe4 oe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, oe4Var)) == null) {
            if (oe4Var == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(11L);
                ih3Var.i(2310L);
                ih3Var.f("pkg info is empty");
                mh3.a().f(ih3Var);
                return ih3Var;
            }
            return null;
        }
        return (ih3) invokeL.objValue;
    }

    public ih3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    ih3 ih3Var = new ih3();
                    ih3Var.k(10L);
                    ih3Var.i(2903L);
                    ih3Var.d("Server未返回主包&AppInfo");
                    return ih3Var;
                }
                PMSAppInfo u2 = md4.i().u(this.o);
                if (u2 == null) {
                    ih3 ih3Var2 = new ih3();
                    ih3Var2.k(10L);
                    ih3Var2.i(2904L);
                    ih3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return ih3Var2;
                }
                this.n = u2;
                h92.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (md4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                ih3 ih3Var3 = new ih3();
                ih3Var3.k(10L);
                ih3Var3.i(2906L);
                ih3Var3.d("更新DB失败");
                return ih3Var3;
            }
            oe4 oe4Var = this.j;
            if (oe4Var != null) {
                h92.k(pMSAppInfo, oe4Var);
            } else if (i92.f(this.k)) {
                pe4 pe4Var = this.k.get(0);
                this.q = pe4Var;
                pe4Var.o = this.o;
                h92.l(this.n, pe4Var);
            } else {
                PMSAppInfo u3 = md4.i().u(this.o);
                if (u3 == null) {
                    ih3 ih3Var4 = new ih3();
                    ih3Var4.k(10L);
                    ih3Var4.i(2905L);
                    ih3Var4.d("Server未返回包数据，本地也没有数据");
                    return ih3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (md4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                h92.o(this.n);
                return null;
            }
            ih3 ih3Var5 = new ih3();
            ih3Var5.k(10L);
            ih3Var5.i(2906L);
            ih3Var5.d("更新DB失败");
            return ih3Var5;
        }
        return (ih3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = md4.i().u(this.o);
            p22.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                oe4 oe4Var = this.j;
                if (oe4Var != null) {
                    oe4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                md4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(h6c.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(h6c.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(h6c.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(h6c.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(h6c.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                h6c.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = md4.i().u(this.o);
        if (u2 == null) {
            p22.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (md4.i().l(this.n)) {
            h92.o(this.n);
        }
    }

    public ih3 x0(ke4 ke4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, ke4Var)) == null) {
            vg2 vg2Var = new vg2();
            vg2Var.b = ke4Var.i;
            vg2Var.a = ke4Var.j;
            vg2Var.c = ke4Var.a;
            vg2Var.d = ke4Var.m;
            if (yf2.b(ke4Var.h, vg2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ih3 ih3Var = new ih3();
                ih3Var.k(14L);
                ih3Var.b(2908L);
                ih3Var.d("Extension包更新失败");
                return ih3Var;
            }
            return null;
        }
        return (ih3) invokeL.objValue;
    }
}
