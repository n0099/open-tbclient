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
import com.baidu.tieba.fh3;
import com.baidu.tieba.n1b;
import com.baidu.tieba.ra2;
import com.baidu.tieba.z73;
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
public abstract class va2 extends za2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public pf4 A;
    public t1b<tg4> B;
    public String c;
    public t1b<? super ug4> d;
    public t1b<? super vg4> e;
    public t1b<? super sg4> f;
    public t1b<? super qg4> g;
    public t1b<? super wg4> h;
    public dl4 i;
    public ug4 j;
    public List<vg4> k;
    public sg4 l;
    public qg4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public vg4 q;
    public long r;
    public final Set<eb2> s;
    public final Set<om3<PMSAppInfo>> t;
    public final yl3 u;
    public mf4<ug4> v;
    public mf4<vg4> w;
    public final mf4<wg4> x;
    public mf4<sg4> y;
    public mf4<qg4> z;

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
    public class a extends jf4<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        /* renamed from: com.baidu.tieba.va2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0442a implements om3<z73.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0442a(a aVar) {
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
            @Override // com.baidu.tieba.om3
            /* renamed from: b */
            public void a(z73.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    rf4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mf4
        /* renamed from: l */
        public String d(ug4 ug4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ug4Var)) == null) {
                int i = ug4Var.h;
                if (i == 0) {
                    return nb2.g();
                }
                if (i == 1) {
                    return nb2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void c(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, ug4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (va2.C) {
                at2.d(l0).e().d(1);
            }
            super.c(ug4Var);
            v42.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.of4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.jf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: o */
        public void e(ug4 ug4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, ug4Var, pg4Var) == null) {
                super.e(ug4Var, pg4Var);
                v42.k("SwanAppPkgDownloadCallback", "onDownloadError：" + pg4Var.toString());
                this.a.i.l(ug4Var);
                oj3 oj3Var = new oj3();
                oj3Var.k(11L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("主包下载失败");
                oj3Var.f(pg4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ug4Var, oj3Var));
                }
                ra2.c().a(ug4Var, this.a.k0(), oj3Var);
                zn4.k(ug4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: p */
        public void i(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ug4Var) == null) {
                String l0 = this.a.l0();
                if (va2.C) {
                    at2.d(l0).e().d(1);
                }
                super.i(ug4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                oj3 z0 = this.a.z0(ug4Var);
                v42.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + ug4Var.i);
                if (z0 == null) {
                    va2 va2Var = this.a;
                    va2Var.j = ug4Var;
                    va2Var.i.m(ug4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(ug4Var);
                        if (va2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    ra2.c().b(ug4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ug4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(ug4Var, z0));
                }
                ra2.c().a(ug4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: r */
        public void f(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, ug4Var) == null) {
                String l0 = this.a.l0();
                if (va2.C) {
                    at2.d(l0).e().d(1);
                }
                super.f(ug4Var);
                if (va2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(ug4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: s */
        public pg4 h(ug4 ug4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{ug4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (va2.C) {
                    at2.d(l0).f(ug4Var.toString()).d(1);
                }
                C0442a c0442a = new C0442a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                tq2 tq2Var = new tq2();
                tq2Var.u(c0442a);
                tq2Var.K(bundle);
                tq2Var.J(new sq2(ug4Var, this.a));
                tq2Var.J(new qq2(ug4Var.m, this.a));
                tq2Var.M(readableByteChannel);
                boolean N = tq2Var.N();
                tq2Var.o(c0442a);
                if (va2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    v42.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    zn4.L(file);
                }
                if (N) {
                    return new pg4(2300, "业务层处理下载流成功");
                }
                return new pg4(2301, "业务层处理下载流失败");
            }
            return (pg4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ om3 b;

        public b(va2 va2Var, Collection collection, om3 om3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, collection, om3Var};
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
            this.b = om3Var;
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
    public class c implements om3<eb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ om3 a;
        public final /* synthetic */ va2 b;

        public c(va2 va2Var, om3 om3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, om3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = va2Var;
            this.a = om3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.va2.Q(com.baidu.tieba.va2, java.util.Collection, java.lang.Object):com.baidu.tieba.va2
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
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(com.baidu.tieba.eb2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.va2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.om3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.va2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.va2.P(r0)
                com.baidu.tieba.va2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.va2.c.a(com.baidu.tieba.eb2):void");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements om3<eb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj3 a;
        public final /* synthetic */ boolean b;

        public d(va2 va2Var, oj3 oj3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, oj3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eb2Var) == null) {
                eb2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements om3<eb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(va2 va2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eb2Var) == null) {
                eb2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug4 a;
        public final /* synthetic */ va2 b;

        public f(va2 va2Var, ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, ug4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = va2Var;
            this.a = ug4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                va2 va2Var = this.b;
                ug4 ug4Var = this.a;
                va2Var.j = ug4Var;
                va2Var.i.m(ug4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, oj3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg4 a;
        public final /* synthetic */ va2 b;

        public g(va2 va2Var, vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, vg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = va2Var;
            this.a = vg4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                va2 va2Var = this.b;
                if (va2Var.k == null) {
                    va2Var.k = new ArrayList();
                }
                vg4 vg4Var = this.a;
                va2 va2Var2 = this.b;
                vg4Var.o = va2Var2.o;
                va2Var2.k.add(vg4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, oj3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;
        public final /* synthetic */ va2 b;

        public h(va2 va2Var, sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = va2Var;
            this.a = sg4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                va2 va2Var = this.b;
                sg4 sg4Var = this.a;
                va2Var.l = sg4Var;
                va2Var.i.m(sg4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, oj3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg4 a;
        public final /* synthetic */ va2 b;

        public i(va2 va2Var, qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, qg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = va2Var;
            this.a = qg4Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) == null) {
                v42.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + oj3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.ra2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                v42.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                va2 va2Var = this.b;
                qg4 qg4Var = this.a;
                va2Var.m = qg4Var;
                va2Var.i.m(qg4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends t1b<tg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 e;

        public j(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o1b
        /* renamed from: g */
        public void onNext(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tg4Var) == null) {
                v42.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + tg4Var.i);
            }
        }

        @Override // com.baidu.tieba.o1b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                v42.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.o1b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v42.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements n1b.a<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public k(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super ug4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.d = t1bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements n1b.a<vg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public l(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super vg4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.e = t1bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements n1b.a<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public m(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super sg4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.f = t1bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements n1b.a<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public n(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super qg4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.g = t1bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements n1b.a<wg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public o(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n1b.a, com.baidu.tieba.b2b
        public void call(t1b<? super wg4> t1bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, t1bVar) != null) {
                return;
            }
            this.a.h = t1bVar;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends cb2<va2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(va2 va2Var, va2 va2Var2) {
            super(va2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, va2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((za2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb2, com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: s */
        public void c(vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, vg4Var) == null) {
                super.c(vg4Var);
                v42.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: u */
        public void f(vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vg4Var) == null) {
                super.f(vg4Var);
                this.c.E0(vg4Var);
            }
        }

        @Override // com.baidu.tieba.cb2, com.baidu.tieba.jf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.cb2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.cb2
        public void p(@NonNull vg4 vg4Var, @Nullable oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, vg4Var, oj3Var) == null) {
                super.p(vg4Var, oj3Var);
                v42.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + vg4Var.i);
                va2 va2Var = this.c;
                if (va2Var.k == null) {
                    va2Var.k = new ArrayList();
                }
                va2 va2Var2 = this.c;
                vg4Var.o = va2Var2.o;
                if (oj3Var == null) {
                    va2Var2.k.add(vg4Var);
                    this.c.i.m(vg4Var);
                    ra2.c().b(vg4Var, this.c.k0());
                } else {
                    va2Var2.i.l(vg4Var);
                    ra2.c().a(vg4Var, this.c.k0(), oj3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(vg4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void e(vg4 vg4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, vg4Var, pg4Var) == null) {
                super.q(vg4Var, pg4Var);
                v42.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + pg4Var.toString());
                this.c.i.l(vg4Var);
                oj3 oj3Var = new oj3();
                oj3Var.k(12L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("分包下载失败");
                oj3Var.f(pg4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(vg4Var, oj3Var));
                }
                ra2.c().a(vg4Var, this.c.k0(), oj3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends ab2<va2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(va2 va2Var, va2 va2Var2) {
            super(va2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, va2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((za2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = va2Var;
        }

        @Override // com.baidu.tieba.ab2
        public void u(wg4 wg4Var, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, wg4Var, oj3Var) == null) {
                v42.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + oj3Var);
                this.b.i.l(wg4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(wg4Var, oj3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab2, com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: v */
        public void c(wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, wg4Var) == null) {
                super.c(wg4Var);
                v42.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.jf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ab2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ab2
        public void r(@NonNull wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, wg4Var) == null) {
                this.b.i.m(wg4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(wg4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ab2, com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: w */
        public void f(wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, wg4Var) == null) {
                super.f(wg4Var);
                if (va2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends jf4<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public r(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mf4
        /* renamed from: l */
        public String d(sg4 sg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sg4Var)) == null) {
                int i = sg4Var.h;
                if (i == 0) {
                    return nb2.h();
                }
                if (i == 1) {
                    return nb2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void c(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sg4Var) == null) {
                super.c(sg4Var);
                v42.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.of4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.jf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: o */
        public void e(sg4 sg4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sg4Var, pg4Var) == null) {
                super.e(sg4Var, pg4Var);
                v42.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + pg4Var.toString());
                this.a.i.l(sg4Var);
                oj3 oj3Var = new oj3();
                oj3Var.k(13L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("Framework包下载失败");
                oj3Var.f(pg4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(sg4Var, oj3Var));
                }
                ra2.c().a(sg4Var, this.a.k0(), oj3Var);
                zn4.k(sg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: p */
        public void i(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sg4Var) == null) {
                super.i(sg4Var);
                v42.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + sg4Var.i);
                oj3 y0 = this.a.y0(sg4Var);
                if (y0 == null) {
                    va2 va2Var = this.a;
                    va2Var.l = sg4Var;
                    va2Var.i.m(sg4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(sg4Var);
                        this.a.f.onCompleted();
                    }
                    ra2.c().b(sg4Var, this.a.k0());
                    return;
                }
                this.a.i.l(sg4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(sg4Var, y0));
                }
                ra2.c().a(sg4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: r */
        public void f(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, sg4Var) == null) {
                super.f(sg4Var);
                if (va2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(sg4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends jf4<qg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public s(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mf4
        /* renamed from: l */
        public String d(qg4 qg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, qg4Var)) == null) {
                int i = qg4Var.h;
                if (i == 0) {
                    return nb2.d();
                }
                if (i == 1) {
                    return nb2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void c(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, qg4Var) == null) {
                super.c(qg4Var);
                v42.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.of4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.jf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: o */
        public void e(qg4 qg4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qg4Var, pg4Var) == null) {
                super.e(qg4Var, pg4Var);
                v42.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + pg4Var.toString());
                this.a.i.l(qg4Var);
                oj3 oj3Var = new oj3();
                oj3Var.k(14L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("Extension下载失败");
                oj3Var.f(pg4Var.toString());
                if (va2.C) {
                    Log.e("SwanAppPkgDownloadCallback", oj3Var.toString());
                }
                this.a.q0(qg4Var);
                ra2.c().a(qg4Var, this.a.k0(), oj3Var);
                zn4.k(qg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: p */
        public void i(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, qg4Var) == null) {
                super.i(qg4Var);
                v42.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + qg4Var.i);
                oj3 x0 = this.a.x0(qg4Var);
                if (x0 == null) {
                    va2 va2Var = this.a;
                    va2Var.m = qg4Var;
                    va2Var.i.m(qg4Var);
                    this.a.q0(qg4Var);
                    ra2.c().b(qg4Var, this.a.k0());
                    return;
                }
                if (va2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + qg4Var.toString());
                }
                this.a.i.l(qg4Var);
                this.a.q0(qg4Var);
                ra2.c().a(qg4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: r */
        public void f(qg4 qg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, qg4Var) == null) {
                super.f(qg4Var);
                if (va2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(qg4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements pf4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 a;

        public t(va2 va2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va2Var;
        }

        @Override // com.baidu.tieba.pf4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (va2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                va2 va2Var = this.a;
                va2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    va2Var.o0(pMSAppInfo);
                    t33.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements om3<om3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(va2 va2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(om3<PMSAppInfo> om3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, om3Var) == null) {
                om3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(va2 va2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, collection, obj};
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

        public w(va2 va2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948233986, "Lcom/baidu/tieba/va2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948233986, "Lcom/baidu/tieba/va2;");
                return;
            }
        }
        C = fo1.a;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<vg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (mf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.qf4
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
            return rf4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public pf4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (pf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<wg4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (mf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<qg4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (mf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<sg4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (mf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<ug4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (mf4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            v42.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public va2(String str) {
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
        this.u = new yl3();
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

    @Override // com.baidu.tieba.qf4
    public void G(dl4 dl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dl4Var) == null) {
            super.G(dl4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (dl4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + dl4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = dl4Var;
            if (!dl4Var.k()) {
                n0();
            }
        }
    }

    public oj3 y0(sg4 sg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, sg4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + sg4Var);
            }
            fh3.b c2 = fh3.c(sg4Var, sg4Var.h);
            if (!TextUtils.isEmpty(sg4Var.a)) {
                v42.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + sg4Var.a);
                zn4.k(sg4Var.a);
            }
            if (!c2.c()) {
                oj3 oj3Var = new oj3();
                oj3Var.k(13L);
                oj3Var.b(2907L);
                oj3Var.d("Core包更新失败");
                return oj3Var;
            }
            return null;
        }
        return (oj3) invokeL.objValue;
    }

    public final void B0(qg4 qg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qg4Var) == null) {
            ra2.c().d(qg4Var, new i(this, qg4Var));
        }
    }

    public final void C0(sg4 sg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sg4Var) == null) {
            ra2.c().d(sg4Var, new h(this, sg4Var));
        }
    }

    public final void D0(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ug4Var) == null) {
            ra2.c().d(ug4Var, new f(this, ug4Var));
        }
    }

    public final void E0(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vg4Var) == null) {
            ra2.c().d(vg4Var, new g(this, vg4Var));
        }
    }

    public va2 e0(om3<PMSAppInfo> om3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, om3Var)) == null) {
            f0(this.t, om3Var);
            return this;
        }
        return (va2) invokeL.objValue;
    }

    public synchronized va2 g0(eb2 eb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, eb2Var)) == null) {
            synchronized (this) {
                f0(this.s, eb2Var);
            }
            return this;
        }
        return (va2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                sf4.i().z(this.o, i2);
            } else {
                sf4.i().z(this.o, 0);
            }
        }
    }

    public va2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (va2) invokeL.objValue;
    }

    public final void q0(qg4 qg4Var) {
        t1b<? super qg4> t1bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, qg4Var) == null) && (t1bVar = this.g) != null) {
            t1bVar.onNext(qg4Var);
            this.g.onCompleted();
        }
    }

    public va2 r0(@NonNull om3<eb2> om3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, om3Var)) == null) {
            p0(this.s, new c(this, om3Var));
            return this;
        }
        return (va2) invokeL.objValue;
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
            o23.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> va2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (va2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> va2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (va2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> va2 p0(@NonNull Collection<CallbackT> collection, @NonNull om3<CallbackT> om3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, om3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, om3Var));
            }
            return this;
        }
        return (va2) invokeLL.objValue;
    }

    public void t0(boolean z, oj3 oj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, oj3Var) == null) {
            r0(new d(this, oj3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.va2 Q(com.baidu.tieba.va2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.va2.Q(com.baidu.tieba.va2, java.util.Collection, java.lang.Object):com.baidu.tieba.va2");
    }

    @Override // com.baidu.tieba.qf4
    public void C(pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pg4Var) == null) {
            v42.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + pg4Var);
            if (pg4Var != null && pg4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public oj3 z0(ug4 ug4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, ug4Var)) == null) {
            if (ug4Var == null) {
                oj3 oj3Var = new oj3();
                oj3Var.k(11L);
                oj3Var.i(2310L);
                oj3Var.f("pkg info is empty");
                sj3.a().f(oj3Var);
                return oj3Var;
            }
            return null;
        }
        return (oj3) invokeL.objValue;
    }

    public oj3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    oj3 oj3Var = new oj3();
                    oj3Var.k(10L);
                    oj3Var.i(2903L);
                    oj3Var.d("Server未返回主包&AppInfo");
                    return oj3Var;
                }
                PMSAppInfo u2 = sf4.i().u(this.o);
                if (u2 == null) {
                    oj3 oj3Var2 = new oj3();
                    oj3Var2.k(10L);
                    oj3Var2.i(2904L);
                    oj3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return oj3Var2;
                }
                this.n = u2;
                nb2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (sf4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                oj3 oj3Var3 = new oj3();
                oj3Var3.k(10L);
                oj3Var3.i(2906L);
                oj3Var3.d("更新DB失败");
                return oj3Var3;
            }
            ug4 ug4Var = this.j;
            if (ug4Var != null) {
                nb2.k(pMSAppInfo, ug4Var);
            } else if (ob2.f(this.k)) {
                vg4 vg4Var = this.k.get(0);
                this.q = vg4Var;
                vg4Var.o = this.o;
                nb2.l(this.n, vg4Var);
            } else {
                PMSAppInfo u3 = sf4.i().u(this.o);
                if (u3 == null) {
                    oj3 oj3Var4 = new oj3();
                    oj3Var4.k(10L);
                    oj3Var4.i(2905L);
                    oj3Var4.d("Server未返回包数据，本地也没有数据");
                    return oj3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (sf4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                nb2.o(this.n);
                return null;
            }
            oj3 oj3Var5 = new oj3();
            oj3Var5.k(10L);
            oj3Var5.i(2906L);
            oj3Var5.d("更新DB失败");
            return oj3Var5;
        }
        return (oj3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = sf4.i().u(this.o);
            v42.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                ug4 ug4Var = this.j;
                if (ug4Var != null) {
                    ug4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                sf4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(n1b.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(n1b.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(n1b.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(n1b.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(n1b.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                n1b.i(arrayList).u(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = sf4.i().u(this.o);
        if (u2 == null) {
            v42.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (sf4.i().l(this.n)) {
            nb2.o(this.n);
        }
    }

    public oj3 x0(qg4 qg4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, qg4Var)) == null) {
            bj2 bj2Var = new bj2();
            bj2Var.b = qg4Var.i;
            bj2Var.a = qg4Var.j;
            bj2Var.c = qg4Var.a;
            bj2Var.d = qg4Var.m;
            if (ei2.b(qg4Var.h, bj2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                oj3 oj3Var = new oj3();
                oj3Var.k(14L);
                oj3Var.b(2908L);
                oj3Var.d("Extension包更新失败");
                return oj3Var;
            }
            return null;
        }
        return (oj3) invokeL.objValue;
    }
}
