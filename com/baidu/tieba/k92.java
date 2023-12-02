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
import com.baidu.tieba.doc;
import com.baidu.tieba.g92;
import com.baidu.tieba.o63;
import com.baidu.tieba.uf3;
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
public abstract class k92 extends o92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public ee4 A;
    public joc<if4> B;
    public String c;
    public joc<? super jf4> d;
    public joc<? super kf4> e;
    public joc<? super hf4> f;
    public joc<? super ff4> g;
    public joc<? super lf4> h;
    public sj4 i;
    public jf4 j;
    public List<kf4> k;
    public hf4 l;
    public ff4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public kf4 q;
    public long r;
    public final Set<t92> s;
    public final Set<dl3<PMSAppInfo>> t;
    public final nk3 u;
    public be4<jf4> v;
    public be4<kf4> w;
    public final be4<lf4> x;
    public be4<hf4> y;
    public be4<ff4> z;

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
    public class a extends yd4<jf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        /* renamed from: com.baidu.tieba.k92$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0378a implements dl3<o63.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0378a(a aVar) {
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
            @Override // com.baidu.tieba.dl3
            /* renamed from: b */
            public void a(o63.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    ge4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.be4
        /* renamed from: l */
        public String d(jf4 jf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jf4Var)) == null) {
                int i = jf4Var.h;
                if (i == 0) {
                    return ca2.g();
                }
                if (i == 1) {
                    return ca2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void c(jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, jf4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (k92.C) {
                pr2.d(l0).e().d(1);
            }
            super.c(jf4Var);
            k32.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.de4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.yd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: o */
        public void e(jf4 jf4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, jf4Var, ef4Var) == null) {
                super.e(jf4Var, ef4Var);
                k32.k("SwanAppPkgDownloadCallback", "onDownloadError：" + ef4Var.toString());
                this.a.i.l(jf4Var);
                di3 di3Var = new di3();
                di3Var.k(11L);
                di3Var.i(ef4Var.a);
                di3Var.d("主包下载失败");
                di3Var.f(ef4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(jf4Var, di3Var));
                }
                g92.c().a(jf4Var, this.a.k0(), di3Var);
                nm4.k(jf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: p */
        public void i(jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, jf4Var) == null) {
                String l0 = this.a.l0();
                if (k92.C) {
                    pr2.d(l0).e().d(1);
                }
                super.i(jf4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                di3 z0 = this.a.z0(jf4Var);
                k32.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + jf4Var.i);
                if (z0 == null) {
                    k92 k92Var = this.a;
                    k92Var.j = jf4Var;
                    k92Var.i.m(jf4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(jf4Var);
                        if (k92.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    g92.c().b(jf4Var, this.a.k0());
                    return;
                }
                this.a.i.l(jf4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(jf4Var, z0));
                }
                g92.c().a(jf4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: r */
        public void f(jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, jf4Var) == null) {
                String l0 = this.a.l0();
                if (k92.C) {
                    pr2.d(l0).e().d(1);
                }
                super.f(jf4Var);
                if (k92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(jf4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: s */
        public ef4 h(jf4 jf4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{jf4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (k92.C) {
                    pr2.d(l0).f(jf4Var.toString()).d(1);
                }
                C0378a c0378a = new C0378a(this);
                Bundle bundle = new Bundle();
                bundle.putLong("length", j);
                bundle.putFloat("progress_granularity", 0.1f);
                ip2 ip2Var = new ip2();
                ip2Var.u(c0378a);
                ip2Var.K(bundle);
                ip2Var.J(new hp2(jf4Var, this.a));
                ip2Var.J(new fp2(jf4Var.m, this.a));
                ip2Var.M(readableByteChannel);
                boolean N = ip2Var.N();
                ip2Var.o(c0378a);
                if (k92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    k32.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    nm4.L(file);
                }
                if (N) {
                    return new ef4(2300, "业务层处理下载流成功");
                }
                return new ef4(2301, "业务层处理下载流失败");
            }
            return (ef4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ dl3 b;

        public b(k92 k92Var, Collection collection, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, collection, dl3Var};
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
            this.b = dl3Var;
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
    public class c implements dl3<t92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ k92 b;

        public c(k92 k92Var, dl3 dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, dl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k92Var;
            this.a = dl3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.k92.Q(com.baidu.tieba.k92, java.util.Collection, java.lang.Object):com.baidu.tieba.k92
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
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(com.baidu.tieba.t92 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.k92.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.dl3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.k92 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.k92.P(r0)
                com.baidu.tieba.k92.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.k92.c.a(com.baidu.tieba.t92):void");
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dl3<t92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di3 a;
        public final /* synthetic */ boolean b;

        public d(k92 k92Var, di3 di3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, di3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = di3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(t92 t92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t92Var) == null) {
                t92Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements dl3<t92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(k92 k92Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(t92 t92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t92Var) == null) {
                t92Var.b(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jf4 a;
        public final /* synthetic */ k92 b;

        public f(k92 k92Var, jf4 jf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, jf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k92Var;
            this.a = jf4Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                k92 k92Var = this.b;
                jf4 jf4Var = this.a;
                k92Var.j = jf4Var;
                k92Var.i.m(jf4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, di3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kf4 a;
        public final /* synthetic */ k92 b;

        public g(k92 k92Var, kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, kf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k92Var;
            this.a = kf4Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                k92 k92Var = this.b;
                if (k92Var.k == null) {
                    k92Var.k = new ArrayList();
                }
                kf4 kf4Var = this.a;
                k92 k92Var2 = this.b;
                kf4Var.o = k92Var2.o;
                k92Var2.k.add(kf4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, di3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf4 a;
        public final /* synthetic */ k92 b;

        public h(k92 k92Var, hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, hf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k92Var;
            this.a = hf4Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                k92 k92Var = this.b;
                hf4 hf4Var = this.a;
                k92Var.l = hf4Var;
                k92Var.i.m(hf4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, di3Var));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff4 a;
        public final /* synthetic */ k92 b;

        public i(k92 k92Var, ff4 ff4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, ff4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k92Var;
            this.a = ff4Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) == null) {
                k32.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + di3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.g92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                k32.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                k92 k92Var = this.b;
                ff4 ff4Var = this.a;
                k92Var.m = ff4Var;
                k92Var.i.m(ff4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends joc<if4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 e;

        public j(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eoc
        /* renamed from: g */
        public void onNext(if4 if4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, if4Var) == null) {
                k32.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + if4Var.i);
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                k32.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                k32.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements doc.a<jf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public k(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super jf4> jocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jocVar) != null) {
                return;
            }
            this.a.d = jocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class l implements doc.a<kf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public l(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super kf4> jocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jocVar) != null) {
                return;
            }
            this.a.e = jocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class m implements doc.a<hf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public m(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super hf4> jocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jocVar) != null) {
                return;
            }
            this.a.f = jocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class n implements doc.a<ff4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public n(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super ff4> jocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jocVar) != null) {
                return;
            }
            this.a.g = jocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class o implements doc.a<lf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public o(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.roc
        /* renamed from: a */
        public void call(joc<? super lf4> jocVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jocVar) != null) {
                return;
            }
            this.a.h = jocVar;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends r92<k92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(k92 k92Var, k92 k92Var2) {
            super(k92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, k92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((o92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r92, com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: s */
        public void c(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, kf4Var) == null) {
                super.c(kf4Var);
                k32.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: u */
        public void f(kf4 kf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kf4Var) == null) {
                super.f(kf4Var);
                this.c.E0(kf4Var);
            }
        }

        @Override // com.baidu.tieba.r92, com.baidu.tieba.yd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.r92
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.r92
        public void p(@NonNull kf4 kf4Var, @Nullable di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, kf4Var, di3Var) == null) {
                super.p(kf4Var, di3Var);
                k32.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + kf4Var.i);
                k92 k92Var = this.c;
                if (k92Var.k == null) {
                    k92Var.k = new ArrayList();
                }
                k92 k92Var2 = this.c;
                kf4Var.o = k92Var2.o;
                if (di3Var == null) {
                    k92Var2.k.add(kf4Var);
                    this.c.i.m(kf4Var);
                    g92.c().b(kf4Var, this.c.k0());
                } else {
                    k92Var2.i.l(kf4Var);
                    g92.c().a(kf4Var, this.c.k0(), di3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(kf4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void e(kf4 kf4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, kf4Var, ef4Var) == null) {
                super.q(kf4Var, ef4Var);
                k32.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + ef4Var.toString());
                this.c.i.l(kf4Var);
                di3 di3Var = new di3();
                di3Var.k(12L);
                di3Var.i(ef4Var.a);
                di3Var.d("分包下载失败");
                di3Var.f(ef4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(kf4Var, di3Var));
                }
                g92.c().a(kf4Var, this.c.k0(), di3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends p92<k92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(k92 k92Var, k92 k92Var2) {
            super(k92Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, k92Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((o92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k92Var;
        }

        @Override // com.baidu.tieba.p92
        public void u(lf4 lf4Var, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, lf4Var, di3Var) == null) {
                k32.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + di3Var);
                this.b.i.l(lf4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(lf4Var, di3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p92, com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: v */
        public void c(lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, lf4Var) == null) {
                super.c(lf4Var);
                k32.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.yd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.p92
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.p92
        public void r(@NonNull lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, lf4Var) == null) {
                this.b.i.m(lf4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(lf4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p92, com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: w */
        public void f(lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, lf4Var) == null) {
                super.f(lf4Var);
                if (k92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends yd4<hf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public r(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.be4
        /* renamed from: l */
        public String d(hf4 hf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hf4Var)) == null) {
                int i = hf4Var.h;
                if (i == 0) {
                    return ca2.h();
                }
                if (i == 1) {
                    return ca2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void c(hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hf4Var) == null) {
                super.c(hf4Var);
                k32.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.de4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.yd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: o */
        public void e(hf4 hf4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hf4Var, ef4Var) == null) {
                super.e(hf4Var, ef4Var);
                k32.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + ef4Var.toString());
                this.a.i.l(hf4Var);
                di3 di3Var = new di3();
                di3Var.k(13L);
                di3Var.i(ef4Var.a);
                di3Var.d("Framework包下载失败");
                di3Var.f(ef4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(hf4Var, di3Var));
                }
                g92.c().a(hf4Var, this.a.k0(), di3Var);
                nm4.k(hf4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: p */
        public void i(hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hf4Var) == null) {
                super.i(hf4Var);
                k32.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + hf4Var.i);
                di3 y0 = this.a.y0(hf4Var);
                if (y0 == null) {
                    k92 k92Var = this.a;
                    k92Var.l = hf4Var;
                    k92Var.i.m(hf4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(hf4Var);
                        this.a.f.onCompleted();
                    }
                    g92.c().b(hf4Var, this.a.k0());
                    return;
                }
                this.a.i.l(hf4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(hf4Var, y0));
                }
                g92.c().a(hf4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: r */
        public void f(hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hf4Var) == null) {
                super.f(hf4Var);
                if (k92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(hf4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s extends yd4<ff4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public s(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.be4
        /* renamed from: l */
        public String d(ff4 ff4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ff4Var)) == null) {
                int i = ff4Var.h;
                if (i == 0) {
                    return ca2.d();
                }
                if (i == 1) {
                    return ca2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: q */
        public void c(ff4 ff4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ff4Var) == null) {
                super.c(ff4Var);
                k32.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.de4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.yd4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: o */
        public void e(ff4 ff4Var, ef4 ef4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ff4Var, ef4Var) == null) {
                super.e(ff4Var, ef4Var);
                k32.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + ef4Var.toString());
                this.a.i.l(ff4Var);
                di3 di3Var = new di3();
                di3Var.k(14L);
                di3Var.i(ef4Var.a);
                di3Var.d("Extension下载失败");
                di3Var.f(ef4Var.toString());
                if (k92.C) {
                    Log.e("SwanAppPkgDownloadCallback", di3Var.toString());
                }
                this.a.q0(ff4Var);
                g92.c().a(ff4Var, this.a.k0(), di3Var);
                nm4.k(ff4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: p */
        public void i(ff4 ff4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ff4Var) == null) {
                super.i(ff4Var);
                k32.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + ff4Var.i);
                di3 x0 = this.a.x0(ff4Var);
                if (x0 == null) {
                    k92 k92Var = this.a;
                    k92Var.m = ff4Var;
                    k92Var.i.m(ff4Var);
                    this.a.q0(ff4Var);
                    g92.c().b(ff4Var, this.a.k0());
                    return;
                }
                if (k92.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + ff4Var.toString());
                }
                this.a.i.l(ff4Var);
                this.a.q0(ff4Var);
                g92.c().a(ff4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
        /* renamed from: r */
        public void f(ff4 ff4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ff4Var) == null) {
                super.f(ff4Var);
                if (k92.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(ff4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements ee4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k92 a;

        public t(k92 k92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k92Var;
        }

        @Override // com.baidu.tieba.ee4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (k92.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                k92 k92Var = this.a;
                k92Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    k92Var.o0(pMSAppInfo);
                    i23.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements dl3<dl3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(k92 k92Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(dl3<PMSAppInfo> dl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dl3Var) == null) {
                dl3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(k92 k92Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, collection, obj};
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

        public w(k92 k92Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k92Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867845, "Lcom/baidu/tieba/k92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867845, "Lcom/baidu/tieba/k92;");
                return;
            }
        }
        C = vm1.a;
    }

    @Override // com.baidu.tieba.fe4
    public be4<kf4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.fe4
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
            return ge4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public ee4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (ee4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public be4<lf4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public be4<ff4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public be4<hf4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (be4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe4
    public be4<jf4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (be4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            k32.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public k92(String str) {
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
        this.u = new nk3();
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

    @Override // com.baidu.tieba.fe4
    public void G(sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sj4Var) == null) {
            super.G(sj4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (sj4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + sj4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = sj4Var;
            if (!sj4Var.k()) {
                n0();
            }
        }
    }

    public di3 y0(hf4 hf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, hf4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + hf4Var);
            }
            uf3.b c2 = uf3.c(hf4Var, hf4Var.h);
            if (!TextUtils.isEmpty(hf4Var.a)) {
                k32.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + hf4Var.a);
                nm4.k(hf4Var.a);
            }
            if (!c2.c()) {
                di3 di3Var = new di3();
                di3Var.k(13L);
                di3Var.b(2907L);
                di3Var.d("Core包更新失败");
                return di3Var;
            }
            return null;
        }
        return (di3) invokeL.objValue;
    }

    public final void B0(ff4 ff4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ff4Var) == null) {
            g92.c().d(ff4Var, new i(this, ff4Var));
        }
    }

    public final void C0(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hf4Var) == null) {
            g92.c().d(hf4Var, new h(this, hf4Var));
        }
    }

    public final void D0(jf4 jf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jf4Var) == null) {
            g92.c().d(jf4Var, new f(this, jf4Var));
        }
    }

    public final void E0(kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kf4Var) == null) {
            g92.c().d(kf4Var, new g(this, kf4Var));
        }
    }

    public k92 e0(dl3<PMSAppInfo> dl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, dl3Var)) == null) {
            f0(this.t, dl3Var);
            return this;
        }
        return (k92) invokeL.objValue;
    }

    public synchronized k92 g0(t92 t92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, t92Var)) == null) {
            synchronized (this) {
                f0(this.s, t92Var);
            }
            return this;
        }
        return (k92) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                he4.i().z(this.o, i2);
            } else {
                he4.i().z(this.o, 0);
            }
        }
    }

    public k92 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (k92) invokeL.objValue;
    }

    public final void q0(ff4 ff4Var) {
        joc<? super ff4> jocVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, ff4Var) == null) && (jocVar = this.g) != null) {
            jocVar.onNext(ff4Var);
            this.g.onCompleted();
        }
    }

    public k92 r0(@NonNull dl3<t92> dl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, dl3Var)) == null) {
            p0(this.s, new c(this, dl3Var));
            return this;
        }
        return (k92) invokeL.objValue;
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
            d13.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> k92 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (k92) invokeLL.objValue;
    }

    public final synchronized <CallbackT> k92 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (k92) invokeLL.objValue;
    }

    public final synchronized <CallbackT> k92 p0(@NonNull Collection<CallbackT> collection, @NonNull dl3<CallbackT> dl3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, dl3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, dl3Var));
            }
            return this;
        }
        return (k92) invokeLL.objValue;
    }

    public void t0(boolean z, di3 di3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, di3Var) == null) {
            r0(new d(this, di3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.k92 Q(com.baidu.tieba.k92 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.k92.Q(com.baidu.tieba.k92, java.util.Collection, java.lang.Object):com.baidu.tieba.k92");
    }

    @Override // com.baidu.tieba.fe4
    public void C(ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ef4Var) == null) {
            k32.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + ef4Var);
            if (ef4Var != null && ef4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public di3 z0(jf4 jf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, jf4Var)) == null) {
            if (jf4Var == null) {
                di3 di3Var = new di3();
                di3Var.k(11L);
                di3Var.i(2310L);
                di3Var.f("pkg info is empty");
                hi3.a().f(di3Var);
                return di3Var;
            }
            return null;
        }
        return (di3) invokeL.objValue;
    }

    public di3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    di3 di3Var = new di3();
                    di3Var.k(10L);
                    di3Var.i(2903L);
                    di3Var.d("Server未返回主包&AppInfo");
                    return di3Var;
                }
                PMSAppInfo u2 = he4.i().u(this.o);
                if (u2 == null) {
                    di3 di3Var2 = new di3();
                    di3Var2.k(10L);
                    di3Var2.i(2904L);
                    di3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return di3Var2;
                }
                this.n = u2;
                ca2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (he4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                di3 di3Var3 = new di3();
                di3Var3.k(10L);
                di3Var3.i(2906L);
                di3Var3.d("更新DB失败");
                return di3Var3;
            }
            jf4 jf4Var = this.j;
            if (jf4Var != null) {
                ca2.k(pMSAppInfo, jf4Var);
            } else if (da2.f(this.k)) {
                kf4 kf4Var = this.k.get(0);
                this.q = kf4Var;
                kf4Var.o = this.o;
                ca2.l(this.n, kf4Var);
            } else {
                PMSAppInfo u3 = he4.i().u(this.o);
                if (u3 == null) {
                    di3 di3Var4 = new di3();
                    di3Var4.k(10L);
                    di3Var4.i(2905L);
                    di3Var4.d("Server未返回包数据，本地也没有数据");
                    return di3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (he4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                ca2.o(this.n);
                return null;
            }
            di3 di3Var5 = new di3();
            di3Var5.k(10L);
            di3Var5.i(2906L);
            di3Var5.d("更新DB失败");
            return di3Var5;
        }
        return (di3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = he4.i().u(this.o);
            k32.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                jf4 jf4Var = this.j;
                if (jf4Var != null) {
                    jf4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                he4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(doc.d(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(doc.d(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(doc.d(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(doc.d(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(doc.d(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                doc.q(arrayList).F(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = he4.i().u(this.o);
        if (u2 == null) {
            k32.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (he4.i().l(this.n)) {
            ca2.o(this.n);
        }
    }

    public di3 x0(ff4 ff4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, ff4Var)) == null) {
            qh2 qh2Var = new qh2();
            qh2Var.b = ff4Var.i;
            qh2Var.a = ff4Var.j;
            qh2Var.c = ff4Var.a;
            qh2Var.d = ff4Var.m;
            if (tg2.b(ff4Var.h, qh2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                di3 di3Var = new di3();
                di3Var.k(14L);
                di3Var.b(2908L);
                di3Var.d("Extension包更新失败");
                return di3Var;
            }
            return null;
        }
        return (di3) invokeL.objValue;
    }
}
