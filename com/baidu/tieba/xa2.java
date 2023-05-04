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
import com.baidu.tieba.b83;
import com.baidu.tieba.hh3;
import com.baidu.tieba.j5b;
import com.baidu.tieba.ta2;
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
public abstract class xa2 extends bb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public rf4 A;
    public p5b<vg4> B;
    public String c;
    public p5b<? super wg4> d;
    public p5b<? super xg4> e;
    public p5b<? super ug4> f;
    public p5b<? super sg4> g;
    public p5b<? super yg4> h;
    public fl4 i;
    public wg4 j;
    public List<xg4> k;
    public ug4 l;
    public sg4 m;
    public PMSAppInfo n;
    public String o;
    public List<UbcFlowEvent> p;
    public xg4 q;
    public long r;
    public final Set<gb2> s;
    public final Set<qm3<PMSAppInfo>> t;
    public final am3 u;
    public of4<wg4> v;
    public of4<xg4> w;
    public final of4<yg4> x;
    public of4<ug4> y;
    public of4<sg4> z;

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
    public class a extends lf4<wg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        /* renamed from: com.baidu.tieba.xa2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0488a implements qm3<b83.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0488a(a aVar) {
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
            @Override // com.baidu.tieba.qm3
            /* renamed from: b */
            public void a(b83.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && "installer_on_pump_finish".equals(aVar.b)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("performance_ubc_event_id", "670");
                    bundle.putString("performance_ubc_extra_key_for_event", "na_stream_bump_end");
                    tf4.a(this.a.a, bundle, "event_performance_ubc");
                }
            }
        }

        public a(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: l */
        public String d(wg4 wg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, wg4Var)) == null) {
                int i = wg4Var.h;
                if (i == 0) {
                    return pb2.g();
                }
                if (i == 1) {
                    return pb2.i();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void c(wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048587, this, wg4Var) != null) {
                return;
            }
            String l0 = this.a.l0();
            if (xa2.C) {
                ct2.d(l0).e().d(1);
            }
            super.c(wg4Var);
            x42.k("SwanAppPkgDownloadCallback", "main onDownloadStart");
        }

        @Override // com.baidu.tieba.qf4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.lf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: o */
        public void e(wg4 wg4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, wg4Var, rg4Var) == null) {
                super.e(wg4Var, rg4Var);
                x42.k("SwanAppPkgDownloadCallback", "onDownloadError：" + rg4Var.toString());
                this.a.i.l(wg4Var);
                qj3 qj3Var = new qj3();
                qj3Var.k(11L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("主包下载失败");
                qj3Var.f(rg4Var.toString());
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(wg4Var, qj3Var));
                }
                ta2.c().a(wg4Var, this.a.k0(), qj3Var);
                bo4.k(wg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: p */
        public void i(wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, wg4Var) == null) {
                String l0 = this.a.l0();
                if (xa2.C) {
                    ct2.d(l0).e().d(1);
                }
                super.i(wg4Var);
                this.a.p.add(new UbcFlowEvent("na_pms_end_download"));
                qj3 z0 = this.a.z0(wg4Var);
                x42.k("SwanAppPkgDownloadCallback", "main onFileDownloaded: pmsPkgMain=" + wg4Var.i);
                if (z0 == null) {
                    xa2 xa2Var = this.a;
                    xa2Var.j = wg4Var;
                    xa2Var.i.m(wg4Var);
                    if (this.a.d != null) {
                        this.a.d.onNext(wg4Var);
                        if (xa2.C) {
                            Log.d("SwanAppPkgDownloadCallback", this.a.i0() + ": main onFileDownloaded: onCompleted");
                        }
                        this.a.d.onCompleted();
                    }
                    ta2.c().b(wg4Var, this.a.k0());
                    return;
                }
                this.a.i.l(wg4Var);
                if (this.a.d != null) {
                    this.a.d.onError(new PkgDownloadError(wg4Var, z0));
                }
                ta2.c().a(wg4Var, this.a.k0(), z0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: r */
        public void f(wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, wg4Var) == null) {
                String l0 = this.a.l0();
                if (xa2.C) {
                    ct2.d(l0).e().d(1);
                }
                super.f(wg4Var);
                if (xa2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": main onDownloading");
                }
                this.a.D0(wg4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: s */
        public rg4 h(wg4 wg4Var, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{wg4Var, file, Long.valueOf(j), readableByteChannel})) == null) {
                String l0 = this.a.l0();
                if (xa2.C) {
                    ct2.d(l0).f(wg4Var.toString()).d(1);
                }
                C0488a c0488a = new C0488a(this);
                Bundle bundle = new Bundle();
                bundle.putLong(CloudStabilityUBCUtils.KEY_LENGTH, j);
                bundle.putFloat("progress_granularity", 0.1f);
                vq2 vq2Var = new vq2();
                vq2Var.u(c0488a);
                vq2Var.K(bundle);
                vq2Var.J(new uq2(wg4Var, this.a));
                vq2Var.J(new sq2(wg4Var.m, this.a));
                vq2Var.M(readableByteChannel);
                boolean N = vq2Var.N();
                vq2Var.o(c0488a);
                if (xa2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": onProcessStream: installOk=" + N);
                }
                if (N) {
                    x42.k("SwanAppPkgDownloadCallback", "#onProcessStream del: " + file.getAbsolutePath());
                    bo4.L(file);
                }
                if (N) {
                    return new rg4(2300, "业务层处理下载流成功");
                }
                return new rg4(2301, "业务层处理下载流失败");
            }
            return (rg4) invokeCommon.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ qm3 b;

        public b(xa2 xa2Var, Collection collection, qm3 qm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, collection, qm3Var};
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
            this.b = qm3Var;
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
    public class c implements qm3<gb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm3 a;
        public final /* synthetic */ xa2 b;

        public c(xa2 xa2Var, qm3 qm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, qm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa2Var;
            this.a = qm3Var;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.xa2.Q(com.baidu.tieba.xa2, java.util.Collection, java.lang.Object):com.baidu.tieba.xa2
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
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(com.baidu.tieba.gb2 r5) {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.xa2.c.$ic
                if (r0 != 0) goto L13
            L4:
                com.baidu.tieba.qm3 r0 = r4.a
                r0.a(r5)
                com.baidu.tieba.xa2 r0 = r4.b
                java.util.Set r1 = com.baidu.tieba.xa2.P(r0)
                com.baidu.tieba.xa2.Q(r0, r1, r5)
                return
            L13:
                r2 = r0
                r3 = 1048577(0x100001, float:1.46937E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.xa2.c.a(com.baidu.tieba.gb2):void");
        }
    }

    /* loaded from: classes7.dex */
    public class d implements qm3<gb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj3 a;
        public final /* synthetic */ boolean b;

        public d(xa2 xa2Var, qj3 qj3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, qj3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj3Var;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(gb2 gb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gb2Var) == null) {
                gb2Var.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements qm3<gb2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public e(xa2 xa2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(gb2 gb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gb2Var) == null) {
                gb2Var.b(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wg4 a;
        public final /* synthetic */ xa2 b;

        public f(xa2 xa2Var, wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, wg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa2Var;
            this.a = wg4Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                xa2 xa2Var = this.b;
                wg4 wg4Var = this.a;
                xa2Var.j = wg4Var;
                xa2Var.i.m(wg4Var);
                if (this.b.d != null) {
                    this.b.d.onNext(this.a);
                    this.b.d.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.d != null) {
                    this.b.d.onError(new PkgDownloadError(this.a, qj3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xg4 a;
        public final /* synthetic */ xa2 b;

        public g(xa2 xa2Var, xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, xg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa2Var;
            this.a = xg4Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                xa2 xa2Var = this.b;
                if (xa2Var.k == null) {
                    xa2Var.k = new ArrayList();
                }
                xg4 xg4Var = this.a;
                xa2 xa2Var2 = this.b;
                xg4Var.o = xa2Var2.o;
                xa2Var2.k.add(xg4Var);
                this.b.i.m(this.a);
                if (this.b.e != null) {
                    this.b.e.onNext(this.a);
                    if (!this.b.i.i()) {
                        this.b.e.onCompleted();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.e != null) {
                    this.b.e.onError(new PkgDownloadError(this.a, qj3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug4 a;
        public final /* synthetic */ xa2 b;

        public h(xa2 xa2Var, ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, ug4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa2Var;
            this.a = ug4Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                xa2 xa2Var = this.b;
                ug4 ug4Var = this.a;
                xa2Var.l = ug4Var;
                xa2Var.i.m(ug4Var);
                if (this.b.f != null) {
                    this.b.f.onNext(this.a);
                    this.b.f.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) == null) {
                this.b.i.l(this.a);
                if (this.b.f != null) {
                    this.b.f.onError(new PkgDownloadError(this.a, qj3Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg4 a;
        public final /* synthetic */ xa2 b;

        public i(xa2 xa2Var, sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, sg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa2Var;
            this.a = sg4Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) == null) {
                x42.k("SwanAppPkgDownloadCallback", "Extension Repeat: onError ：" + pMSDownloadType + ":" + qj3Var.toString());
                this.b.i.l(this.a);
                this.b.q0(this.a);
            }
        }

        @Override // com.baidu.tieba.ta2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                x42.k("SwanAppPkgDownloadCallback", "Extension Repeat: onSuccess ：" + pMSDownloadType);
                xa2 xa2Var = this.b;
                sg4 sg4Var = this.a;
                xa2Var.m = sg4Var;
                xa2Var.i.m(sg4Var);
                this.b.q0(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends p5b<vg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 e;

        public j(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k5b
        /* renamed from: g */
        public void onNext(vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vg4Var) == null) {
                x42.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 单个包下载、业务层处理完成：" + vg4Var.i);
            }
        }

        @Override // com.baidu.tieba.k5b
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                x42.l("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载OnError", th);
                this.e.w0(th);
            }
        }

        @Override // com.baidu.tieba.k5b
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                x42.k("SwanAppPkgDownloadCallback", this.e.k0() + " : 包下载onCompleted");
                this.e.v0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements j5b.a<wg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public k(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public void call(p5b<? super wg4> p5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, p5bVar) != null) {
                return;
            }
            this.a.d = p5bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements j5b.a<xg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public l(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public void call(p5b<? super xg4> p5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, p5bVar) != null) {
                return;
            }
            this.a.e = p5bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class m implements j5b.a<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public m(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public void call(p5b<? super ug4> p5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, p5bVar) != null) {
                return;
            }
            this.a.f = p5bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements j5b.a<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public n(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public void call(p5b<? super sg4> p5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, p5bVar) != null) {
                return;
            }
            this.a.g = p5bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class o implements j5b.a<yg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public o(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j5b.a, com.baidu.tieba.x5b
        public void call(p5b<? super yg4> p5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, p5bVar) != null) {
                return;
            }
            this.a.h = p5bVar;
        }
    }

    /* loaded from: classes7.dex */
    public class p extends eb2<xa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(xa2 xa2Var, xa2 xa2Var2) {
            super(xa2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, xa2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((bb2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eb2, com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: s */
        public void c(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, xg4Var) == null) {
                super.c(xg4Var);
                x42.k("SwanAppPkgDownloadCallback", "sub onDownloadStart");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: u */
        public void f(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xg4Var) == null) {
                super.f(xg4Var);
                this.c.E0(xg4Var);
            }
        }

        @Override // com.baidu.tieba.eb2, com.baidu.tieba.lf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.eb2
        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c.o;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.eb2
        public void p(@NonNull xg4 xg4Var, @Nullable qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, xg4Var, qj3Var) == null) {
                super.p(xg4Var, qj3Var);
                x42.k("SwanAppPkgDownloadCallback", "sub onFileDownloaded: " + xg4Var.i);
                xa2 xa2Var = this.c;
                if (xa2Var.k == null) {
                    xa2Var.k = new ArrayList();
                }
                xa2 xa2Var2 = this.c;
                xg4Var.o = xa2Var2.o;
                if (qj3Var == null) {
                    xa2Var2.k.add(xg4Var);
                    this.c.i.m(xg4Var);
                    ta2.c().b(xg4Var, this.c.k0());
                } else {
                    xa2Var2.i.l(xg4Var);
                    ta2.c().a(xg4Var, this.c.k0(), qj3Var);
                }
                if (this.c.e != null) {
                    this.c.e.onNext(xg4Var);
                    if (!this.c.i.i()) {
                        this.c.e.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void e(xg4 xg4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, xg4Var, rg4Var) == null) {
                super.q(xg4Var, rg4Var);
                x42.k("SwanAppPkgDownloadCallback", "sub onDownloadError：" + rg4Var.toString());
                this.c.i.l(xg4Var);
                qj3 qj3Var = new qj3();
                qj3Var.k(12L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("分包下载失败");
                qj3Var.f(rg4Var.toString());
                if (this.c.e != null) {
                    this.c.e.onError(new PkgDownloadError(xg4Var, qj3Var));
                }
                ta2.c().a(xg4Var, this.c.k0(), qj3Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends cb2<xa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(xa2 xa2Var, xa2 xa2Var2) {
            super(xa2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, xa2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((bb2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa2Var;
        }

        @Override // com.baidu.tieba.cb2
        public void u(yg4 yg4Var, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, yg4Var, qj3Var) == null) {
                x42.k("SwanAppPkgDownloadCallback", "dependent onDownloadOrUnzipFail：" + qj3Var);
                this.b.i.l(yg4Var);
                if (this.b.h != null) {
                    this.b.h.onError(new PkgDownloadError(yg4Var, qj3Var));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb2, com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: v */
        public void c(yg4 yg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, yg4Var) == null) {
                super.c(yg4Var);
                x42.k("SwanAppPkgDownloadCallback", "dependent onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.lf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.j0();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.cb2
        public PMSDownloadType o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.k0();
            }
            return (PMSDownloadType) invokeV.objValue;
        }

        @Override // com.baidu.tieba.cb2
        public void r(@NonNull yg4 yg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, yg4Var) == null) {
                this.b.i.m(yg4Var);
                if (this.b.h != null) {
                    this.b.h.onNext(yg4Var);
                    if (!this.b.i.c()) {
                        this.b.h.onCompleted();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cb2, com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: w */
        public void f(yg4 yg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, yg4Var) == null) {
                super.f(yg4Var);
                if (xa2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.b.i0() + ": dependent onDownloading");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends lf4<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public r(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: l */
        public String d(ug4 ug4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ug4Var)) == null) {
                int i = ug4Var.h;
                if (i == 0) {
                    return pb2.h();
                }
                if (i == 1) {
                    return pb2.e();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void c(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ug4Var) == null) {
                super.c(ug4Var);
                x42.k("SwanAppPkgDownloadCallback", "framework onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.qf4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.lf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: o */
        public void e(ug4 ug4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ug4Var, rg4Var) == null) {
                super.e(ug4Var, rg4Var);
                x42.k("SwanAppPkgDownloadCallback", "framework onDownloadError：" + rg4Var.toString());
                this.a.i.l(ug4Var);
                qj3 qj3Var = new qj3();
                qj3Var.k(13L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("Framework包下载失败");
                qj3Var.f(rg4Var.toString());
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ug4Var, qj3Var));
                }
                ta2.c().a(ug4Var, this.a.k0(), qj3Var);
                bo4.k(ug4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: p */
        public void i(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ug4Var) == null) {
                super.i(ug4Var);
                x42.k("SwanAppPkgDownloadCallback", "framework onFileDownloaded: " + ug4Var.i);
                qj3 y0 = this.a.y0(ug4Var);
                if (y0 == null) {
                    xa2 xa2Var = this.a;
                    xa2Var.l = ug4Var;
                    xa2Var.i.m(ug4Var);
                    if (this.a.f != null) {
                        this.a.f.onNext(ug4Var);
                        this.a.f.onCompleted();
                    }
                    ta2.c().b(ug4Var, this.a.k0());
                    return;
                }
                this.a.i.l(ug4Var);
                if (this.a.f != null) {
                    this.a.f.onError(new PkgDownloadError(ug4Var, y0));
                }
                ta2.c().a(ug4Var, this.a.k0(), y0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: r */
        public void f(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, ug4Var) == null) {
                super.f(ug4Var);
                if (xa2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": framework onDownloading");
                }
                this.a.C0(ug4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends lf4<sg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public s(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: l */
        public String d(sg4 sg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sg4Var)) == null) {
                int i = sg4Var.h;
                if (i == 0) {
                    return pb2.d();
                }
                if (i == 1) {
                    return pb2.f();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void c(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, sg4Var) == null) {
                super.c(sg4Var);
                x42.k("SwanAppPkgDownloadCallback", "extension onDownloadStart");
            }
        }

        @Override // com.baidu.tieba.qf4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.lf4
        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.j0();
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: o */
        public void e(sg4 sg4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sg4Var, rg4Var) == null) {
                super.e(sg4Var, rg4Var);
                x42.k("SwanAppPkgDownloadCallback", "extension onDownloadError：" + rg4Var.toString());
                this.a.i.l(sg4Var);
                qj3 qj3Var = new qj3();
                qj3Var.k(14L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("Extension下载失败");
                qj3Var.f(rg4Var.toString());
                if (xa2.C) {
                    Log.e("SwanAppPkgDownloadCallback", qj3Var.toString());
                }
                this.a.q0(sg4Var);
                ta2.c().a(sg4Var, this.a.k0(), qj3Var);
                bo4.k(sg4Var.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: p */
        public void i(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, sg4Var) == null) {
                super.i(sg4Var);
                x42.k("SwanAppPkgDownloadCallback", "extension onFileDownloaded: " + sg4Var.i);
                qj3 x0 = this.a.x0(sg4Var);
                if (x0 == null) {
                    xa2 xa2Var = this.a;
                    xa2Var.m = sg4Var;
                    xa2Var.i.m(sg4Var);
                    this.a.q0(sg4Var);
                    ta2.c().b(sg4Var, this.a.k0());
                    return;
                }
                if (xa2.C) {
                    Log.e("SwanAppPkgDownloadCallback", "Extension 业务处理失败：" + sg4Var.toString());
                }
                this.a.i.l(sg4Var);
                this.a.q0(sg4Var);
                ta2.c().a(sg4Var, this.a.k0(), x0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: r */
        public void f(sg4 sg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, sg4Var) == null) {
                super.f(sg4Var);
                if (xa2.C) {
                    Log.i("SwanAppPkgDownloadCallback", this.a.i0() + ": extension onDownloading");
                }
                this.a.B0(sg4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements rf4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa2 a;

        public t(xa2 xa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa2Var;
        }

        @Override // com.baidu.tieba.rf4
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                if (xa2.C) {
                    Log.e("SwanAppPkgDownloadCallback", this.a.i0() + ": onSwanAppReceive: " + pMSAppInfo.toString());
                }
                xa2 xa2Var = this.a;
                xa2Var.n = pMSAppInfo;
                if (pMSAppInfo != null) {
                    xa2Var.o0(pMSAppInfo);
                    v33.k(this.a.n.pluginInfo, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements qm3<qm3<PMSAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PMSAppInfo a;

        public u(xa2 xa2Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, pMSAppInfo};
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
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(qm3<PMSAppInfo> qm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qm3Var) == null) {
                qm3Var.a(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;

        public v(xa2 xa2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, collection, obj};
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

        public w(xa2 xa2Var, Collection collection, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa2Var, collection, obj};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948293568, "Lcom/baidu/tieba/xa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948293568, "Lcom/baidu/tieba/xa2;");
                return;
            }
        }
        C = ho1.a;
    }

    @Override // com.baidu.tieba.sf4
    public of4<xg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.w;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.p.add(new UbcFlowEvent("na_pms_start_req"));
        }
    }

    @Override // com.baidu.tieba.sf4
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
            return tf4.b(this, "get_launch_id").getString("launch_id", "");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public rf4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.A;
        }
        return (rf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public of4<yg4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.x;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public of4<sg4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.z;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public of4<ug4> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public of4<wg4> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v;
        }
        return (of4) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.r;
            x42.i("SwanAppPkgDownloadCallback", "pms download time : " + currentTimeMillis);
        }
    }

    public xa2(String str) {
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
        this.u = new am3();
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

    @Override // com.baidu.tieba.sf4
    public void G(fl4 fl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fl4Var) == null) {
            super.G(fl4Var);
            this.r = System.currentTimeMillis();
            if (C) {
                Log.e("SwanAppPkgDownloadCallback", "mStartDownload=" + this.r);
            }
            if (fl4Var == null) {
                return;
            }
            if (C) {
                Log.i("SwanAppPkgDownloadCallback", i0() + ": onPrepareDownload: countSet=" + fl4Var.n());
            }
            this.p.add(new UbcFlowEvent("na_pms_start_download"));
            this.i = fl4Var;
            if (!fl4Var.k()) {
                n0();
            }
        }
    }

    public qj3 y0(ug4 ug4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, ug4Var)) == null) {
            if (C) {
                Log.d("SwanAppPkgDownloadCallback", "onFrameworkPkgDownload framework = " + ug4Var);
            }
            hh3.b c2 = hh3.c(ug4Var, ug4Var.h);
            if (!TextUtils.isEmpty(ug4Var.a)) {
                x42.k("SwanAppPkgDownloadCallback", "#onFrameworkPkgDownload del: " + ug4Var.a);
                bo4.k(ug4Var.a);
            }
            if (!c2.c()) {
                qj3 qj3Var = new qj3();
                qj3Var.k(13L);
                qj3Var.b(2907L);
                qj3Var.d("Core包更新失败");
                return qj3Var;
            }
            return null;
        }
        return (qj3) invokeL.objValue;
    }

    public final void B0(sg4 sg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sg4Var) == null) {
            ta2.c().d(sg4Var, new i(this, sg4Var));
        }
    }

    public final void C0(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ug4Var) == null) {
            ta2.c().d(ug4Var, new h(this, ug4Var));
        }
    }

    public final void D0(wg4 wg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wg4Var) == null) {
            ta2.c().d(wg4Var, new f(this, wg4Var));
        }
    }

    public final void E0(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xg4Var) == null) {
            ta2.c().d(xg4Var, new g(this, xg4Var));
        }
    }

    public xa2 e0(qm3<PMSAppInfo> qm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, qm3Var)) == null) {
            f0(this.t, qm3Var);
            return this;
        }
        return (xa2) invokeL.objValue;
    }

    public synchronized xa2 g0(gb2 gb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, gb2Var)) == null) {
            synchronized (this) {
                f0(this.s, gb2Var);
            }
            return this;
        }
        return (xa2) invokeL.objValue;
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 == 1013) {
                uf4.i().z(this.o, i2);
            } else {
                uf4.i().z(this.o, 0);
            }
        }
    }

    public xa2 o0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, pMSAppInfo)) == null) {
            p0(this.t, new u(this, pMSAppInfo));
            return this;
        }
        return (xa2) invokeL.objValue;
    }

    public final void q0(sg4 sg4Var) {
        p5b<? super sg4> p5bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, sg4Var) == null) && (p5bVar = this.g) != null) {
            p5bVar.onNext(sg4Var);
            this.g.onCompleted();
        }
    }

    public xa2 r0(@NonNull qm3<gb2> qm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, qm3Var)) == null) {
            p0(this.s, new c(this, qm3Var));
            return this;
        }
        return (xa2) invokeL.objValue;
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
            q23.a(this.o, str, this.p, str2);
            this.p.clear();
        }
    }

    public final synchronized <CallbackT> xa2 f0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (xa2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> xa2 h0(Collection<CallbackT> collection, CallbackT callbackt) {
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
        return (xa2) invokeLL.objValue;
    }

    public final synchronized <CallbackT> xa2 p0(@NonNull Collection<CallbackT> collection, @NonNull qm3<CallbackT> qm3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, collection, qm3Var)) == null) {
            synchronized (this) {
                this.u.a(new b(this, collection, qm3Var));
            }
            return this;
        }
        return (xa2) invokeLL.objValue;
    }

    public void t0(boolean z, qj3 qj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, qj3Var) == null) {
            r0(new d(this, qj3Var, z));
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
    public static /* synthetic */ com.baidu.tieba.xa2 Q(com.baidu.tieba.xa2 r0, java.util.Collection r1, java.lang.Object r2) {
        /*
            r0.h0(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.xa2.Q(com.baidu.tieba.xa2, java.util.Collection, java.lang.Object):com.baidu.tieba.xa2");
    }

    @Override // com.baidu.tieba.sf4
    public void C(rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rg4Var) == null) {
            x42.k("SwanAppPkgDownloadCallback", "onFetchError: error=" + rg4Var);
            if (rg4Var != null && rg4Var.a == 1010) {
                G0();
            }
            this.p.add(new UbcFlowEvent("na_pms_end_req"));
        }
    }

    public qj3 z0(wg4 wg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, wg4Var)) == null) {
            if (wg4Var == null) {
                qj3 qj3Var = new qj3();
                qj3Var.k(11L);
                qj3Var.i(2310L);
                qj3Var.f("pkg info is empty");
                uj3.a().f(qj3Var);
                return qj3Var;
            }
            return null;
        }
        return (qj3) invokeL.objValue;
    }

    public qj3 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PMSAppInfo pMSAppInfo = this.n;
            if (pMSAppInfo == null) {
                if (this.j == null) {
                    qj3 qj3Var = new qj3();
                    qj3Var.k(10L);
                    qj3Var.i(2903L);
                    qj3Var.d("Server未返回主包&AppInfo");
                    return qj3Var;
                }
                PMSAppInfo u2 = uf4.i().u(this.o);
                if (u2 == null) {
                    qj3 qj3Var2 = new qj3();
                    qj3Var2.k(10L);
                    qj3Var2.i(2904L);
                    qj3Var2.d("Server未返回AppInfo数据，本地也没有数据");
                    return qj3Var2;
                }
                this.n = u2;
                pb2.k(u2, this.j);
                this.n.initMaxAgeInfo();
                this.n.updateInstallSrc(J());
                if (uf4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                    return null;
                }
                qj3 qj3Var3 = new qj3();
                qj3Var3.k(10L);
                qj3Var3.i(2906L);
                qj3Var3.d("更新DB失败");
                return qj3Var3;
            }
            wg4 wg4Var = this.j;
            if (wg4Var != null) {
                pb2.k(pMSAppInfo, wg4Var);
            } else if (qb2.f(this.k)) {
                xg4 xg4Var = this.k.get(0);
                this.q = xg4Var;
                xg4Var.o = this.o;
                pb2.l(this.n, xg4Var);
            } else {
                PMSAppInfo u3 = uf4.i().u(this.o);
                if (u3 == null) {
                    qj3 qj3Var4 = new qj3();
                    qj3Var4.k(10L);
                    qj3Var4.i(2905L);
                    qj3Var4.d("Server未返回包数据，本地也没有数据");
                    return qj3Var4;
                }
                PMSAppInfo pMSAppInfo2 = this.n;
                pMSAppInfo2.appId = this.o;
                pMSAppInfo2.copyLocalAppInfoData(u3);
            }
            this.n.initMaxAgeInfo();
            this.n.updateInstallSrc(J());
            if (uf4.i().b(this.j, this.k, this.l, this.m, this.n)) {
                pb2.o(this.n);
                return null;
            }
            qj3 qj3Var5 = new qj3();
            qj3Var5.k(10L);
            qj3Var5.i(2906L);
            qj3Var5.d("更新DB失败");
            return qj3Var5;
        }
        return (qj3) invokeV.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PMSAppInfo u2 = uf4.i().u(this.o);
            x42.k("SwanAppPkgDownloadCallback", "updateMainMaxAgeTime: createTime=" + u2.createTime + " lastLaunchTime=" + u2.getLastLaunchTime() + " maxAge=" + u2.maxAge);
            if (u2 != null) {
                u2.initMaxAgeInfo();
                u2.updateInstallSrc(J());
                wg4 wg4Var = this.j;
                if (wg4Var != null) {
                    wg4Var.c = u2.createTime;
                }
                PMSAppInfo pMSAppInfo = this.n;
                if (pMSAppInfo != null) {
                    pMSAppInfo.createTime = u2.createTime;
                    pMSAppInfo.updateInstallSrc(J());
                }
                uf4.i().l(u2);
            }
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.i.f()) {
                arrayList.add(j5b.a(new k(this)));
            }
            if (this.i.h()) {
                arrayList.add(j5b.a(new l(this)));
            }
            if (this.i.e()) {
                arrayList.add(j5b.a(new m(this)));
            }
            if (this.i.d()) {
                arrayList.add(j5b.a(new n(this)));
            }
            if (this.i.b()) {
                arrayList.add(j5b.a(new o(this)));
            }
            if (!arrayList.isEmpty()) {
                j5b.k(arrayList).w(this.B);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.n == null) {
            return;
        }
        PMSAppInfo u2 = uf4.i().u(this.o);
        if (u2 == null) {
            x42.k("SwanAppPkgDownloadCallback", "Server未返回包数据，本地也没查到");
            return;
        }
        this.n.appId = this.o;
        u2.updateInstallSrc(J());
        this.n.copyLocalAppInfoData(u2);
        this.n.initMaxAgeInfo();
        if (uf4.i().l(this.n)) {
            pb2.o(this.n);
        }
    }

    public qj3 x0(sg4 sg4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, sg4Var)) == null) {
            dj2 dj2Var = new dj2();
            dj2Var.b = sg4Var.i;
            dj2Var.a = sg4Var.j;
            dj2Var.c = sg4Var.a;
            dj2Var.d = sg4Var.m;
            if (gi2.b(sg4Var.h, dj2Var) == null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                qj3 qj3Var = new qj3();
                qj3Var.k(14L);
                qj3Var.b(2908L);
                qj3Var.d("Extension包更新失败");
                return qj3Var;
            }
            return null;
        }
        return (qj3) invokeL.objValue;
    }
}
