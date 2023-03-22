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
import com.baidu.tieba.dh3;
import com.baidu.tieba.ora;
import com.baidu.tieba.pa2;
import com.baidu.tieba.x73;
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
public abstract class ta2 extends xa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public nf4 A;
    public ura<rg4> B;
    public String c;
    public ura<? super sg4> d;
    public ura<? super tg4> e;
    public ura<? super qg4> f;
    public ura<? super og4> g;
    public ura<? super ug4> h;
    public bl4 i;
    public sg4 j;
    public List<tg4> k;
    public qg4 l;
    public og4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public tg4 q;
    public long r;
    public final Set<cb2> s;
    public final Set<mm3<PMSAppInfo>> t;
    public final wl3 u;
    public kf4<sg4> v;
    public kf4<tg4> w;
    public final kf4<ug4> x;
    public kf4<qg4> y;
    public kf4<og4> z;

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

    /* loaded from: classes6.dex */
    public class a extends hf4<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        /* renamed from: com.baidu.tieba.ta2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0431a implements mm3<x73.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0431a(a aVar) {
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
            @Override // com.baidu.tieba.mm3
            /* renamed from: b */
            public void a(x73.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    pf4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf4
        /* renamed from: l */
        public String d(sg4 sg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sg4Var)) == null) {
                int i = sg4Var.h;
                if (i == 0) {
                    return lb2.g();
                }
                if (i == 1) {
                    return lb2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void c(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, sg4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (ta2.C) {
                ys2.d(l0).e().d(1);
            }
            super.c(sg4Var);
            t42.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.mf4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.hf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: o */
        public void e(sg4 sg4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, sg4Var, ng4Var) == null) {
                super.e(sg4Var, ng4Var);
                t42.k("SwanAppPkgDownloadCallback", "onDownloadError：" + ng4Var.toString());
                this.a.i.l(sg4Var);
                mj3 mj3Var = new mj3();
                mj3Var.k(11L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("主包下载失败");
                mj3Var.f(ng4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(sg4Var, mj3Var));
                }
                pa2.c().a(sg4Var, this.a.k0(), mj3Var);
                xn4.k(sg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: p */
        public void i(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sg4Var) == null) {
                String l0 = this.a.l0();
                if (ta2.C) {
                    ys2.d(l0).e().d(1);
                }
                super.i(sg4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                mj3 z0 = this.a.z0(sg4Var);
                t42.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + sg4Var.i);
                if (z0 == null) {
                    ta2 ta2Var = this.a;
                    ta2Var.j = sg4Var;
                    ta2Var.i.m(sg4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(sg4Var);
                        if (ta2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    pa2.c().b(sg4Var, this.a.k0());
                    return;
                }
                this.a.i.l(sg4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(sg4Var, z0));
                }
                pa2.c().a(sg4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: r */
        public void f(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, sg4Var) == null) {
                String l0 = this.a.l0();
                if (ta2.C) {
                    ys2.d(l0).e().d(1);
                }
                super.f(sg4Var);
                if (ta2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(sg4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: s */
        public ng4 h(sg4 sg4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{sg4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (ta2.C) {
                    ys2.d(l0).f(sg4Var.toString()).d(1);
                }
                C0431a c0431a = new C0431a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                rq2 rq2Var = new rq2();
                rq2Var.u(c0431a);
                rq2Var.K(bundle);
                rq2Var.J(new qq2(sg4Var, this.a));
                rq2Var.J(new oq2(sg4Var.m, this.a));
                rq2Var.M(readableByteChannel);
                boolean N = rq2Var.N();
                rq2Var.o(c0431a);
                if (ta2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    t42.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    xn4.L(file);
                }
                if (N) {
                    return new ng4(2300, "业务层处理下载流成功");
                }
                return new ng4(2301, "业务层处理下载流失败");
            }
            return (ng4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ mm3 b;

        public b(ta2 ta2Var, Collection collection, mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, collection, mm3Var};
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
            this.b = mm3Var;
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
    public class c implements mm3<cb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;
        public final /* synthetic */ ta2 b;

        public c(ta2 ta2Var, mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta2Var;
            this.a = mm3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.ta2.Q(com.baidu.tieba.ta2, java.util.Collection, java.lang.Object):com.baidu.tieba.ta2
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
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(com.baidu.tieba.cb2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.ta2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.mm3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.ta2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.ta2.P(r0)
                com.baidu.tieba.ta2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ta2.c.a(com.baidu.tieba.cb2):void");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements mm3<cb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mj3 a;
        public final /* synthetic */ boolean b;

        public d(ta2 ta2Var, mj3 mj3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, mj3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mj3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(cb2 cb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cb2Var) == null) {
                cb2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements mm3<cb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(ta2 ta2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(cb2 cb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cb2Var) == null) {
                cb2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;
        public final /* synthetic */ ta2 b;

        public f(ta2 ta2Var, sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta2Var;
            this.a = sg4Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ta2 ta2Var = this.b;
                sg4 sg4Var = this.a;
                ta2Var.j = sg4Var;
                ta2Var.i.m(sg4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, mj3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg4 a;
        public final /* synthetic */ ta2 b;

        public g(ta2 ta2Var, tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, tg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta2Var;
            this.a = tg4Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ta2 ta2Var = this.b;
                if (ta2Var.k == null) {
                    ta2Var.k = new ArrayList();
                }
                tg4 tg4Var = this.a;
                ta2 ta2Var2 = this.b;
                tg4Var.o = ta2Var2.o;
                ta2Var2.k.add(tg4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, mj3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg4 a;
        public final /* synthetic */ ta2 b;

        public h(ta2 ta2Var, qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, qg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta2Var;
            this.a = qg4Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                ta2 ta2Var = this.b;
                qg4 qg4Var = this.a;
                ta2Var.l = qg4Var;
                ta2Var.i.m(qg4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, mj3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ og4 a;
        public final /* synthetic */ ta2 b;

        public i(ta2 ta2Var, og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, og4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta2Var;
            this.a = og4Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) == null) {
                t42.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + mj3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.pa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                t42.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                ta2 ta2Var = this.b;
                og4 og4Var = this.a;
                ta2Var.m = og4Var;
                ta2Var.i.m(og4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends ura<rg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 e;

        public j(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pra
        /* renamed from: g */
        public void onNext(rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rg4Var) == null) {
                t42.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + rg4Var.i);
            }
        }

        @Override // com.baidu.tieba.pra
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                t42.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.pra
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                t42.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ora.a<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public k(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super sg4> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uraVar) != null) {
                return;
            }
            this.a.d = uraVar;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ora.a<tg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public l(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super tg4> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uraVar) != null) {
                return;
            }
            this.a.e = uraVar;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ora.a<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public m(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super qg4> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uraVar) != null) {
                return;
            }
            this.a.f = uraVar;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements ora.a<og4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public n(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super og4> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uraVar) != null) {
                return;
            }
            this.a.g = uraVar;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements ora.a<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public o(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super ug4> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, uraVar) != null) {
                return;
            }
            this.a.h = uraVar;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends ab2<ta2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ta2 ta2Var, ta2 ta2Var2) {
            super(ta2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, ta2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((xa2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab2, com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: s */
        public void c(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, tg4Var) == null) {
                super.c(tg4Var);
                t42.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: u */
        public void f(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tg4Var) == null) {
                super.f(tg4Var);
                this.c.E0(tg4Var);
            }
        }

        @Override // com.baidu.tieba.ab2, com.baidu.tieba.hf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ab2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ab2
        public void p(@NonNull tg4 tg4Var, @Nullable mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, tg4Var, mj3Var) == null) {
                super.p(tg4Var, mj3Var);
                t42.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + tg4Var.i);
                ta2 ta2Var = this.c;
                if (ta2Var.k == null) {
                    ta2Var.k = new ArrayList();
                }
                ta2 ta2Var2 = this.c;
                tg4Var.o = ta2Var2.o;
                if (mj3Var == null) {
                    ta2Var2.k.add(tg4Var);
                    this.c.i.m(tg4Var);
                    pa2.c().b(tg4Var, this.c.k0());
                } else {
                    ta2Var2.i.l(tg4Var);
                    pa2.c().a(tg4Var, this.c.k0(), mj3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(tg4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void e(tg4 tg4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, tg4Var, ng4Var) == null) {
                super.q(tg4Var, ng4Var);
                t42.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + ng4Var.toString());
                this.c.i.l(tg4Var);
                mj3 mj3Var = new mj3();
                mj3Var.k(12L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("分包下载失败");
                mj3Var.f(ng4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(tg4Var, mj3Var));
                }
                pa2.c().a(tg4Var, this.c.k0(), mj3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends ya2<ta2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ta2 ta2Var, ta2 ta2Var2) {
            super(ta2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, ta2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((xa2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta2Var;
        }

        @Override // com.baidu.tieba.ya2
        public void u(ug4 ug4Var, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, ug4Var, mj3Var) == null) {
                t42.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + mj3Var);
                this.b.i.l(ug4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(ug4Var, mj3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ya2, com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: v */
        public void c(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ug4Var) == null) {
                super.c(ug4Var);
                t42.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.hf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ya2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ya2
        public void r(@NonNull ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ug4Var) == null) {
                this.b.i.m(ug4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(ug4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ya2, com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: w */
        public void f(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ug4Var) == null) {
                super.f(ug4Var);
                if (ta2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends hf4<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public r(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf4
        /* renamed from: l */
        public String d(qg4 qg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qg4Var)) == null) {
                int i = qg4Var.h;
                if (i == 0) {
                    return lb2.h();
                }
                if (i == 1) {
                    return lb2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void c(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, qg4Var) == null) {
                super.c(qg4Var);
                t42.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.mf4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.hf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: o */
        public void e(qg4 qg4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qg4Var, ng4Var) == null) {
                super.e(qg4Var, ng4Var);
                t42.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + ng4Var.toString());
                this.a.i.l(qg4Var);
                mj3 mj3Var = new mj3();
                mj3Var.k(13L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("Framework包下载失败");
                mj3Var.f(ng4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(qg4Var, mj3Var));
                }
                pa2.c().a(qg4Var, this.a.k0(), mj3Var);
                xn4.k(qg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: p */
        public void i(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, qg4Var) == null) {
                super.i(qg4Var);
                t42.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + qg4Var.i);
                mj3 y0 = this.a.y0(qg4Var);
                if (y0 == null) {
                    ta2 ta2Var = this.a;
                    ta2Var.l = qg4Var;
                    ta2Var.i.m(qg4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(qg4Var);
                        this.a.f.onCompleted();
                    }
                    pa2.c().b(qg4Var, this.a.k0());
                    return;
                }
                this.a.i.l(qg4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(qg4Var, y0));
                }
                pa2.c().a(qg4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: r */
        public void f(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, qg4Var) == null) {
                super.f(qg4Var);
                if (ta2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(qg4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends hf4<og4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public s(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf4
        /* renamed from: l */
        public String d(og4 og4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, og4Var)) == null) {
                int i = og4Var.h;
                if (i == 0) {
                    return lb2.d();
                }
                if (i == 1) {
                    return lb2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void c(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, og4Var) == null) {
                super.c(og4Var);
                t42.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.mf4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.hf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: o */
        public void e(og4 og4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, og4Var, ng4Var) == null) {
                super.e(og4Var, ng4Var);
                t42.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + ng4Var.toString());
                this.a.i.l(og4Var);
                mj3 mj3Var = new mj3();
                mj3Var.k(14L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("Extension下载失败");
                mj3Var.f(ng4Var.toString());
                if (ta2.C) {
                    Log.e("SwanAppPkgDownloadCallback", mj3Var.toString());
                }
                this.a.q0(og4Var);
                pa2.c().a(og4Var, this.a.k0(), mj3Var);
                xn4.k(og4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: p */
        public void i(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, og4Var) == null) {
                super.i(og4Var);
                t42.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + og4Var.i);
                mj3 x0 = this.a.x0(og4Var);
                if (x0 == null) {
                    ta2 ta2Var = this.a;
                    ta2Var.m = og4Var;
                    ta2Var.i.m(og4Var);
                    this.a.q0(og4Var);
                    pa2.c().b(og4Var, this.a.k0());
                    return;
                }
                if (ta2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + og4Var.toString());
                }
                this.a.i.l(og4Var);
                this.a.q0(og4Var);
                pa2.c().a(og4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: r */
        public void f(og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, og4Var) == null) {
                super.f(og4Var);
                if (ta2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(og4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements nf4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 a;

        public t(ta2 ta2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ta2Var;
        }

        @Override // com.baidu.tieba.nf4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (ta2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                ta2 ta2Var = this.a;
                ta2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    ta2Var.o0(pMSAppInfo);
                    r33.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements mm3<mm3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(ta2 ta2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(mm3<PMSAppInfo> mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mm3Var) == null) {
                mm3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(ta2 ta2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, collection, obj};
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

        public w(ta2 ta2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948174404, "Lcom/baidu/tieba/ta2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948174404, "Lcom/baidu/tieba/ta2;");
                return;
            }
        }
        C = do1.a;
    }

    @Override // com.baidu.tieba.of4
    public kf4<tg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.of4
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
            return pf4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public nf4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (nf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public kf4<ug4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public kf4<og4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public kf4<qg4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public kf4<sg4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (kf4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            t42.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public ta2(String str) {
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
        this.u = new wl3();
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

    @Override // com.baidu.tieba.of4
    public void G(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bl4Var) == null) {
            super.G(bl4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (bl4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + bl4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = bl4Var;
            if (!bl4Var.k()) {
                n0();
            }
        }
    }

    public mj3 y0(qg4 qg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, qg4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + qg4Var);
            }
            dh3.b c2 = dh3.c(qg4Var, qg4Var.h);
            if (!TextUtils.isEmpty(qg4Var.a)) {
                t42.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + qg4Var.a);
                xn4.k(qg4Var.a);
            }
            if (!c2.c()) {
                mj3 mj3Var = new mj3();
                mj3Var.k(13L);
                mj3Var.b(2907L);
                mj3Var.d("Core包更新失败");
                return mj3Var;
            }
            return null;
        }
        return (mj3) invokeL.objValue;
    }

    public final void B0(og4 og4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, og4Var) == null) {
            pa2.c().d(og4Var, new i(this, og4Var));
        }
    }

    public final void C0(qg4 qg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qg4Var) == null) {
            pa2.c().d(qg4Var, new h(this, qg4Var));
        }
    }

    public final void D0(sg4 sg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sg4Var) == null) {
            pa2.c().d(sg4Var, new f(this, sg4Var));
        }
    }

    public final void E0(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tg4Var) == null) {
            pa2.c().d(tg4Var, new g(this, tg4Var));
        }
    }

    public ta2 e0(mm3<PMSAppInfo> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, mm3Var)) == null) {
            f0(this.t, mm3Var);
            return this;
        }
        return (ta2) invokeL.objValue;
    }

    public synchronized ta2 g0(cb2 cb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cb2Var)) == null) {
            synchronized (this) {
                f0(this.s, cb2Var);
            }
            return this;
        }
        return (ta2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                qf4.i().z(this.o, i2);
            } else {
                qf4.i().z(this.o, 0);
            }
        }
    }

    public ta2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (ta2) invokeL.objValue;
    }

    public final void q0(og4 og4Var) {
        ura<? super og4> uraVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, og4Var) == null) && (uraVar = this.g) != null) {
            uraVar.onNext(og4Var);
            this.g.onCompleted();
        }
    }

    public ta2 r0(@NonNull mm3<cb2> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, mm3Var)) == null) {
            p0(this.s, new c(this, mm3Var));
            return this;
        }
        return (ta2) invokeL.objValue;
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
            m23.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> ta2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ta2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ta2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (ta2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> ta2 p0(@NonNull Collection<CallbackT> collection, @NonNull mm3<CallbackT> mm3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, mm3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, mm3Var));
            }
            return this;
        }
        return (ta2) invokeLL.objValue;
    }

    public void t0(boolean z, mj3 mj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, mj3Var) == null) {
            r0(new d(this, mj3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.ta2 Q(com.baidu.tieba.ta2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.ta2.Q(com.baidu.tieba.ta2, java.util.Collection, java.lang.Object):com.baidu.tieba.ta2");
    }

    @Override // com.baidu.tieba.of4
    public void C(ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ng4Var) == null) {
            t42.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + ng4Var);
            if (ng4Var != null && ng4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public mj3 z0(sg4 sg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, sg4Var)) == null) {
            if (sg4Var == null) {
                mj3 mj3Var = new mj3();
                mj3Var.k(11L);
                mj3Var.i(2310L);
                mj3Var.f("pkg info is empty");
                qj3.a().f(mj3Var);
                return mj3Var;
            }
            return null;
        }
        return (mj3) invokeL.objValue;
    }

    public mj3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    mj3 mj3Var = new mj3();
                    mj3Var.k(10L);
                    mj3Var.i(2903L);
                    mj3Var.d("Server未返回主包&AppInfo");
                    return mj3Var;
                }
                PMSAppInfo u2 = qf4.i().u(this.o);
                if (u2 == null) {
                    mj3 mj3Var2 = new mj3();
                    mj3Var2.k(10L);
                    mj3Var2.i(2904L);
                    mj3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return mj3Var2;
                }
                this.n = u2;
                lb2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (qf4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                mj3 mj3Var3 = new mj3();
                mj3Var3.k(10L);
                mj3Var3.i(2906L);
                mj3Var3.d("更新DB失败");
                return mj3Var3;
            }
            sg4 sg4Var = this.j;
            if (sg4Var != null) {
                lb2.k(pMSAppInfo, sg4Var);
            } else if (mb2.f(this.k)) {
                tg4 tg4Var = this.k.get(0);
                this.q = tg4Var;
                tg4Var.o = this.o;
                lb2.l(this.n, tg4Var);
            } else {
                PMSAppInfo u3 = qf4.i().u(this.o);
                if (u3 == null) {
                    mj3 mj3Var4 = new mj3();
                    mj3Var4.k(10L);
                    mj3Var4.i(2905L);
                    mj3Var4.d("Server未返回包数据，本地也没有数据");
                    return mj3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (qf4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                lb2.o(this.n);
                return null;
            }
            mj3 mj3Var5 = new mj3();
            mj3Var5.k(10L);
            mj3Var5.i(2906L);
            mj3Var5.d("更新DB失败");
            return mj3Var5;
        }
        return (mj3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = qf4.i().u(this.o);
            t42.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                sg4 sg4Var = this.j;
                if (sg4Var != null) {
                    sg4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                qf4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(ora.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(ora.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(ora.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(ora.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(ora.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                ora.i(arrayList).u(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = qf4.i().u(this.o);
        if (u2 == null) {
            t42.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (qf4.i().l(this.n)) {
            lb2.o(this.n);
        }
    }

    public mj3 x0(og4 og4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, og4Var)) == null) {
            zi2 zi2Var = new zi2();
            zi2Var.b = og4Var.i;
            zi2Var.a = og4Var.j;
            zi2Var.c = og4Var.a;
            zi2Var.d = og4Var.m;
            if (ci2.b(og4Var.h, zi2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                mj3 mj3Var = new mj3();
                mj3Var.k(14L);
                mj3Var.b(2908L);
                mj3Var.d("Extension包更新失败");
                return mj3Var;
            }
            return null;
        }
        return (mj3) invokeL.objValue;
    }
}
