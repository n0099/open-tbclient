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
import com.baidu.tieba.cb3;
import com.baidu.tieba.ik3;
import com.baidu.tieba.ud2;
import com.baidu.tieba.x0c;
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
public abstract class yd2 extends ce2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public si4 A;
    public d1c<wj4> B;
    public String c;
    public d1c<? super xj4> d;
    public d1c<? super yj4> e;
    public d1c<? super vj4> f;
    public d1c<? super tj4> g;
    public d1c<? super zj4> h;
    public go4 i;
    public xj4 j;
    public List<yj4> k;
    public vj4 l;
    public tj4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public yj4 q;
    public long r;
    public final Set<he2> s;
    public final Set<rp3<PMSAppInfo>> t;
    public final bp3 u;
    public pi4<xj4> v;
    public pi4<yj4> w;
    public final pi4<zj4> x;
    public pi4<vj4> y;
    public pi4<tj4> z;

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
    public class a extends mi4<xj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        /* renamed from: com.baidu.tieba.yd2$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0545a implements rp3<cb3.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0545a(a aVar) {
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
            @Override // com.baidu.tieba.rp3
            /* renamed from: b */
            public void a(cb3.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    ui4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pi4
        /* renamed from: l */
        public String d(xj4 xj4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xj4Var)) == null) {
                int i = xj4Var.h;
                if (i == 0) {
                    return qe2.g();
                }
                if (i == 1) {
                    return qe2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: q */
        public void c(xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, xj4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (yd2.C) {
                dw2.d(l0).e().d(1);
            }
            super.c(xj4Var);
            y72.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.ri4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.mi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: o */
        public void e(xj4 xj4Var, sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, xj4Var, sj4Var) == null) {
                super.e(xj4Var, sj4Var);
                y72.k("SwanAppPkgDownloadCallback", "onDownloadError：" + sj4Var.toString());
                this.a.i.l(xj4Var);
                rm3 rm3Var = new rm3();
                rm3Var.k(11L);
                rm3Var.i(sj4Var.a);
                rm3Var.d("主包下载失败");
                rm3Var.f(sj4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xj4Var, rm3Var));
                }
                ud2.c().a(xj4Var, this.a.k0(), rm3Var);
                cr4.k(xj4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: p */
        public void i(xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, xj4Var) == null) {
                String l0 = this.a.l0();
                if (yd2.C) {
                    dw2.d(l0).e().d(1);
                }
                super.i(xj4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                rm3 z0 = this.a.z0(xj4Var);
                y72.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + xj4Var.i);
                if (z0 == null) {
                    yd2 yd2Var = this.a;
                    yd2Var.j = xj4Var;
                    yd2Var.i.m(xj4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(xj4Var);
                        if (yd2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    ud2.c().b(xj4Var, this.a.k0());
                    return;
                }
                this.a.i.l(xj4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(xj4Var, z0));
                }
                ud2.c().a(xj4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: r */
        public void f(xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, xj4Var) == null) {
                String l0 = this.a.l0();
                if (yd2.C) {
                    dw2.d(l0).e().d(1);
                }
                super.f(xj4Var);
                if (yd2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(xj4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: s */
        public sj4 h(xj4 xj4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{xj4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (yd2.C) {
                    dw2.d(l0).f(xj4Var.toString()).d(1);
                }
                C0545a c0545a = new C0545a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                wt2 wt2Var = new wt2();
                wt2Var.u(c0545a);
                wt2Var.K(bundle);
                wt2Var.J(new vt2(xj4Var, this.a));
                wt2Var.J(new tt2(xj4Var.m, this.a));
                wt2Var.M(readableByteChannel);
                boolean N = wt2Var.N();
                wt2Var.o(c0545a);
                if (yd2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    y72.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    cr4.L(file);
                }
                if (N) {
                    return new sj4(2300, "业务层处理下载流成功");
                }
                return new sj4(2301, "业务层处理下载流失败");
            }
            return (sj4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ rp3 b;

        public b(yd2 yd2Var, Collection collection, rp3 rp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, collection, rp3Var};
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
            this.b = rp3Var;
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
    public class c implements rp3<he2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp3 a;
        public final /* synthetic */ yd2 b;

        public c(yd2 yd2Var, rp3 rp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, rp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yd2Var;
            this.a = rp3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.yd2.Q(com.baidu.tieba.yd2, java.util.Collection, java.lang.Object):com.baidu.tieba.yd2
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
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(com.baidu.tieba.he2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.yd2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.rp3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.yd2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.yd2.P(r0)
                com.baidu.tieba.yd2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.yd2.c.a(com.baidu.tieba.he2):void");
        }
    }

    /* loaded from: classes8.dex */
    public class d implements rp3<he2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm3 a;
        public final /* synthetic */ boolean b;

        public d(yd2 yd2Var, rm3 rm3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, rm3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, he2Var) == null) {
                he2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements rp3<he2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(yd2 yd2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(he2 he2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, he2Var) == null) {
                he2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj4 a;
        public final /* synthetic */ yd2 b;

        public f(yd2 yd2Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, xj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yd2Var;
            this.a = xj4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                yd2 yd2Var = this.b;
                xj4 xj4Var = this.a;
                yd2Var.j = xj4Var;
                yd2Var.i.m(xj4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, rm3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj4 a;
        public final /* synthetic */ yd2 b;

        public g(yd2 yd2Var, yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, yj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yd2Var;
            this.a = yj4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                yd2 yd2Var = this.b;
                if (yd2Var.k == null) {
                    yd2Var.k = new ArrayList();
                }
                yj4 yj4Var = this.a;
                yd2 yd2Var2 = this.b;
                yj4Var.o = yd2Var2.o;
                yd2Var2.k.add(yj4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, rm3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj4 a;
        public final /* synthetic */ yd2 b;

        public h(yd2 yd2Var, vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, vj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yd2Var;
            this.a = vj4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                yd2 yd2Var = this.b;
                vj4 vj4Var = this.a;
                yd2Var.l = vj4Var;
                yd2Var.i.m(vj4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, rm3Var));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ud2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tj4 a;
        public final /* synthetic */ yd2 b;

        public i(yd2 yd2Var, tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, tj4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yd2Var;
            this.a = tj4Var;
        }

        @Override // com.baidu.tieba.ud2.c
        public void b(PMSDownloadType pMSDownloadType, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rm3Var) == null) {
                y72.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + rm3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.ud2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                y72.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                yd2 yd2Var = this.b;
                tj4 tj4Var = this.a;
                yd2Var.m = tj4Var;
                yd2Var.i.m(tj4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends d1c<wj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 e;

        public j(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y0c
        /* renamed from: g */
        public void onNext(wj4 wj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wj4Var) == null) {
                y72.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + wj4Var.i);
            }
        }

        @Override // com.baidu.tieba.y0c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                y72.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.y0c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y72.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements x0c.a<xj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public k(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public void call(d1c<? super xj4> d1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d1cVar) != null) {
                return;
            }
            this.a.d = d1cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements x0c.a<yj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public l(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public void call(d1c<? super yj4> d1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d1cVar) != null) {
                return;
            }
            this.a.e = d1cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements x0c.a<vj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public m(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public void call(d1c<? super vj4> d1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d1cVar) != null) {
                return;
            }
            this.a.f = d1cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class n implements x0c.a<tj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public n(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public void call(d1c<? super tj4> d1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d1cVar) != null) {
                return;
            }
            this.a.g = d1cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements x0c.a<zj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public o(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x0c.a, com.baidu.tieba.l1c
        public void call(d1c<? super zj4> d1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, d1cVar) != null) {
                return;
            }
            this.a.h = d1cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class p extends fe2<yd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(yd2 yd2Var, yd2 yd2Var2) {
            super(yd2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, yd2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ce2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fe2, com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: s */
        public void c(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, yj4Var) == null) {
                super.c(yj4Var);
                y72.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: u */
        public void f(yj4 yj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yj4Var) == null) {
                super.f(yj4Var);
                this.c.E0(yj4Var);
            }
        }

        @Override // com.baidu.tieba.fe2, com.baidu.tieba.mi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fe2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.fe2
        public void p(@NonNull yj4 yj4Var, @Nullable rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, yj4Var, rm3Var) == null) {
                super.p(yj4Var, rm3Var);
                y72.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + yj4Var.i);
                yd2 yd2Var = this.c;
                if (yd2Var.k == null) {
                    yd2Var.k = new ArrayList();
                }
                yd2 yd2Var2 = this.c;
                yj4Var.o = yd2Var2.o;
                if (rm3Var == null) {
                    yd2Var2.k.add(yj4Var);
                    this.c.i.m(yj4Var);
                    ud2.c().b(yj4Var, this.c.k0());
                } else {
                    yd2Var2.i.l(yj4Var);
                    ud2.c().a(yj4Var, this.c.k0(), rm3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(yj4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: q */
        public void e(yj4 yj4Var, sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, yj4Var, sj4Var) == null) {
                super.q(yj4Var, sj4Var);
                y72.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + sj4Var.toString());
                this.c.i.l(yj4Var);
                rm3 rm3Var = new rm3();
                rm3Var.k(12L);
                rm3Var.i(sj4Var.a);
                rm3Var.d("分包下载失败");
                rm3Var.f(sj4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(yj4Var, rm3Var));
                }
                ud2.c().a(yj4Var, this.c.k0(), rm3Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends de2<yd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(yd2 yd2Var, yd2 yd2Var2) {
            super(yd2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, yd2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ce2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yd2Var;
        }

        @Override // com.baidu.tieba.de2
        public void u(zj4 zj4Var, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, zj4Var, rm3Var) == null) {
                y72.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + rm3Var);
                this.b.i.l(zj4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(zj4Var, rm3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.de2, com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: v */
        public void c(zj4 zj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, zj4Var) == null) {
                super.c(zj4Var);
                y72.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.mi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.de2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.de2
        public void r(@NonNull zj4 zj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, zj4Var) == null) {
                this.b.i.m(zj4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(zj4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.de2, com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: w */
        public void f(zj4 zj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, zj4Var) == null) {
                super.f(zj4Var);
                if (yd2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends mi4<vj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public r(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pi4
        /* renamed from: l */
        public String d(vj4 vj4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vj4Var)) == null) {
                int i = vj4Var.h;
                if (i == 0) {
                    return qe2.h();
                }
                if (i == 1) {
                    return qe2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: q */
        public void c(vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, vj4Var) == null) {
                super.c(vj4Var);
                y72.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ri4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.mi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: o */
        public void e(vj4 vj4Var, sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vj4Var, sj4Var) == null) {
                super.e(vj4Var, sj4Var);
                y72.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + sj4Var.toString());
                this.a.i.l(vj4Var);
                rm3 rm3Var = new rm3();
                rm3Var.k(13L);
                rm3Var.i(sj4Var.a);
                rm3Var.d("Framework包下载失败");
                rm3Var.f(sj4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(vj4Var, rm3Var));
                }
                ud2.c().a(vj4Var, this.a.k0(), rm3Var);
                cr4.k(vj4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: p */
        public void i(vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, vj4Var) == null) {
                super.i(vj4Var);
                y72.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + vj4Var.i);
                rm3 y0 = this.a.y0(vj4Var);
                if (y0 == null) {
                    yd2 yd2Var = this.a;
                    yd2Var.l = vj4Var;
                    yd2Var.i.m(vj4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(vj4Var);
                        this.a.f.onCompleted();
                    }
                    ud2.c().b(vj4Var, this.a.k0());
                    return;
                }
                this.a.i.l(vj4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(vj4Var, y0));
                }
                ud2.c().a(vj4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: r */
        public void f(vj4 vj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, vj4Var) == null) {
                super.f(vj4Var);
                if (yd2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(vj4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s extends mi4<tj4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public s(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pi4
        /* renamed from: l */
        public String d(tj4 tj4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tj4Var)) == null) {
                int i = tj4Var.h;
                if (i == 0) {
                    return qe2.d();
                }
                if (i == 1) {
                    return qe2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: q */
        public void c(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, tj4Var) == null) {
                super.c(tj4Var);
                y72.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.ri4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.mi4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: o */
        public void e(tj4 tj4Var, sj4 sj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tj4Var, sj4Var) == null) {
                super.e(tj4Var, sj4Var);
                y72.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + sj4Var.toString());
                this.a.i.l(tj4Var);
                rm3 rm3Var = new rm3();
                rm3Var.k(14L);
                rm3Var.i(sj4Var.a);
                rm3Var.d("Extension下载失败");
                rm3Var.f(sj4Var.toString());
                if (yd2.C) {
                    Log.e("SwanAppPkgDownloadCallback", rm3Var.toString());
                }
                this.a.q0(tj4Var);
                ud2.c().a(tj4Var, this.a.k0(), rm3Var);
                cr4.k(tj4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: p */
        public void i(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, tj4Var) == null) {
                super.i(tj4Var);
                y72.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + tj4Var.i);
                rm3 x0 = this.a.x0(tj4Var);
                if (x0 == null) {
                    yd2 yd2Var = this.a;
                    yd2Var.m = tj4Var;
                    yd2Var.i.m(tj4Var);
                    this.a.q0(tj4Var);
                    ud2.c().b(tj4Var, this.a.k0());
                    return;
                }
                if (yd2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + tj4Var.toString());
                }
                this.a.i.l(tj4Var);
                this.a.q0(tj4Var);
                ud2.c().a(tj4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mi4, com.baidu.tieba.pi4
        /* renamed from: r */
        public void f(tj4 tj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, tj4Var) == null) {
                super.f(tj4Var);
                if (yd2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(tj4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements si4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2 a;

        public t(yd2 yd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yd2Var;
        }

        @Override // com.baidu.tieba.si4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (yd2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                yd2 yd2Var = this.a;
                yd2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    yd2Var.o0(pMSAppInfo);
                    w63.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements rp3<rp3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(yd2 yd2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(rp3<PMSAppInfo> rp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rp3Var) == null) {
                rp3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(yd2 yd2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, collection, obj};
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

        public w(yd2 yd2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948326242, "Lcom/baidu/tieba/yd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948326242, "Lcom/baidu/tieba/yd2;");
                return;
            }
        }
        C = ir1.a;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<yj4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (pi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.ti4
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
            return ui4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public si4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (si4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<zj4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (pi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<tj4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (pi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<vj4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (pi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public pi4<xj4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (pi4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            y72.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public yd2(String str) {
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
        this.u = new bp3();
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

    @Override // com.baidu.tieba.ti4
    public void G(go4 go4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, go4Var) == null) {
            super.G(go4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (go4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + go4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = go4Var;
            if (!go4Var.k()) {
                n0();
            }
        }
    }

    public rm3 y0(vj4 vj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, vj4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + vj4Var);
            }
            ik3.b c2 = ik3.c(vj4Var, vj4Var.h);
            if (!TextUtils.isEmpty(vj4Var.a)) {
                y72.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + vj4Var.a);
                cr4.k(vj4Var.a);
            }
            if (!c2.c()) {
                rm3 rm3Var = new rm3();
                rm3Var.k(13L);
                rm3Var.b(2907L);
                rm3Var.d("Core包更新失败");
                return rm3Var;
            }
            return null;
        }
        return (rm3) invokeL.objValue;
    }

    public final void B0(tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tj4Var) == null) {
            ud2.c().d(tj4Var, new i(this, tj4Var));
        }
    }

    public final void C0(vj4 vj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vj4Var) == null) {
            ud2.c().d(vj4Var, new h(this, vj4Var));
        }
    }

    public final void D0(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xj4Var) == null) {
            ud2.c().d(xj4Var, new f(this, xj4Var));
        }
    }

    public final void E0(yj4 yj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yj4Var) == null) {
            ud2.c().d(yj4Var, new g(this, yj4Var));
        }
    }

    public yd2 e0(rp3<PMSAppInfo> rp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rp3Var)) == null) {
            f0(this.t, rp3Var);
            return this;
        }
        return (yd2) invokeL.objValue;
    }

    public synchronized yd2 g0(he2 he2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, he2Var)) == null) {
            synchronized (this) {
                f0(this.s, he2Var);
            }
            return this;
        }
        return (yd2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                vi4.i().z(this.o, i2);
            } else {
                vi4.i().z(this.o, 0);
            }
        }
    }

    public yd2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (yd2) invokeL.objValue;
    }

    public final void q0(tj4 tj4Var) {
        d1c<? super tj4> d1cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, tj4Var) == null) && (d1cVar = this.g) != null) {
            d1cVar.onNext(tj4Var);
            this.g.onCompleted();
        }
    }

    public yd2 r0(@NonNull rp3<he2> rp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, rp3Var)) == null) {
            p0(this.s, new c(this, rp3Var));
            return this;
        }
        return (yd2) invokeL.objValue;
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
            r53.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> yd2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (yd2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> yd2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (yd2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> yd2 p0(@NonNull Collection<CallbackT> collection, @NonNull rp3<CallbackT> rp3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, rp3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, rp3Var));
            }
            return this;
        }
        return (yd2) invokeLL.objValue;
    }

    public void t0(boolean z, rm3 rm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, rm3Var) == null) {
            r0(new d(this, rm3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.yd2 Q(com.baidu.tieba.yd2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.yd2.Q(com.baidu.tieba.yd2, java.util.Collection, java.lang.Object):com.baidu.tieba.yd2");
    }

    @Override // com.baidu.tieba.ti4
    public void C(sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sj4Var) == null) {
            y72.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + sj4Var);
            if (sj4Var != null && sj4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public rm3 z0(xj4 xj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, xj4Var)) == null) {
            if (xj4Var == null) {
                rm3 rm3Var = new rm3();
                rm3Var.k(11L);
                rm3Var.i(2310L);
                rm3Var.f("pkg info is empty");
                vm3.a().f(rm3Var);
                return rm3Var;
            }
            return null;
        }
        return (rm3) invokeL.objValue;
    }

    public rm3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    rm3 rm3Var = new rm3();
                    rm3Var.k(10L);
                    rm3Var.i(2903L);
                    rm3Var.d("Server未返回主包&AppInfo");
                    return rm3Var;
                }
                PMSAppInfo u2 = vi4.i().u(this.o);
                if (u2 == null) {
                    rm3 rm3Var2 = new rm3();
                    rm3Var2.k(10L);
                    rm3Var2.i(2904L);
                    rm3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return rm3Var2;
                }
                this.n = u2;
                qe2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (vi4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                rm3 rm3Var3 = new rm3();
                rm3Var3.k(10L);
                rm3Var3.i(2906L);
                rm3Var3.d("更新DB失败");
                return rm3Var3;
            }
            xj4 xj4Var = this.j;
            if (xj4Var != null) {
                qe2.k(pMSAppInfo, xj4Var);
            } else if (re2.f(this.k)) {
                yj4 yj4Var = this.k.get(0);
                this.q = yj4Var;
                yj4Var.o = this.o;
                qe2.l(this.n, yj4Var);
            } else {
                PMSAppInfo u3 = vi4.i().u(this.o);
                if (u3 == null) {
                    rm3 rm3Var4 = new rm3();
                    rm3Var4.k(10L);
                    rm3Var4.i(2905L);
                    rm3Var4.d("Server未返回包数据，本地也没有数据");
                    return rm3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (vi4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                qe2.o(this.n);
                return null;
            }
            rm3 rm3Var5 = new rm3();
            rm3Var5.k(10L);
            rm3Var5.i(2906L);
            rm3Var5.d("更新DB失败");
            return rm3Var5;
        }
        return (rm3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = vi4.i().u(this.o);
            y72.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                xj4 xj4Var = this.j;
                if (xj4Var != null) {
                    xj4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                vi4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(x0c.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(x0c.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(x0c.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(x0c.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(x0c.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                x0c.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = vi4.i().u(this.o);
        if (u2 == null) {
            y72.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (vi4.i().l(this.n)) {
            qe2.o(this.n);
        }
    }

    public rm3 x0(tj4 tj4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, tj4Var)) == null) {
            em2 em2Var = new em2();
            em2Var.b = tj4Var.i;
            em2Var.a = tj4Var.j;
            em2Var.c = tj4Var.a;
            em2Var.d = tj4Var.m;
            if (hl2.b(tj4Var.h, em2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                rm3 rm3Var = new rm3();
                rm3Var.k(14L);
                rm3Var.b(2908L);
                rm3Var.d("Extension包更新失败");
                return rm3Var;
            }
            return null;
        }
        return (rm3) invokeL.objValue;
    }
}
