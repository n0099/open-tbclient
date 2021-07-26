package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.i;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.e.b.o;
import com.bytedance.sdk.openadsdk.q.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class g implements w.a, c, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public WeakReference<c.InterfaceC0347c> E;
    public WeakReference<a> F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public com.bytedance.sdk.openadsdk.n.f.b L;
    public final Runnable M;
    public final Runnable N;
    public final Runnable O;
    public int P;
    public long Q;
    public long R;
    public long S;
    public boolean T;
    public long U;
    public final BroadcastReceiver V;
    public int W;
    public boolean X;

    /* renamed from: a  reason: collision with root package name */
    public i f30848a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f30849b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<ViewGroup> f30850c;

    /* renamed from: d  reason: collision with root package name */
    public final w f30851d;

    /* renamed from: e  reason: collision with root package name */
    public long f30852e;

    /* renamed from: f  reason: collision with root package name */
    public long f30853f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.c.d f30854g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f30855h;

    /* renamed from: i  reason: collision with root package name */
    public long f30856i;
    public long j;
    public long k;
    public List<Runnable> l;
    public boolean m;
    public final WeakReference<Context> n;
    public final boolean o;
    public boolean p;
    public boolean q;
    public final m r;
    public boolean s;
    public boolean t;
    public String u;
    public boolean v;
    public boolean w;
    public WeakReference<e> x;
    public long y;
    public boolean z;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.g$8  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass8 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30865a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1033707622, "Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/g$8;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1033707622, "Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/g$8;");
                    return;
                }
            }
            int[] iArr = new int[i.a.values().length];
            f30865a = iArr;
            try {
                iArr[i.a.f31096a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30865a[i.a.f31097b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30865a[i.a.f31098c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i2);

        void g();
    }

    public g(Context context, ViewGroup viewGroup, m mVar, String str, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30851d = new w(this);
        this.f30852e = 0L;
        this.f30853f = 0L;
        this.f30856i = 0L;
        this.j = 0L;
        this.m = false;
        this.p = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = "embeded_ad";
        this.v = false;
        this.w = true;
        this.y = 0L;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = true;
        this.M = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30860a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30860a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30860a.f30854g == null) {
                    return;
                }
                this.f30860a.f30854g.e();
            }
        };
        this.N = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30861a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30861a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30861a.f30855h == null) {
                    return;
                }
                this.f30861a.f30855h.a();
            }
        };
        this.O = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30862a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30862a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f30862a.f30854g != null) {
                        if (this.f30862a.k <= 0) {
                            this.f30862a.f30854g.e();
                        }
                        this.f30862a.f30854g.f();
                    }
                    this.f30862a.f30851d.postDelayed(this, 200L);
                }
            }
        };
        this.P = 0;
        this.Q = 0L;
        this.f30849b = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30863a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30863a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar;
                i iVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (iVar = (gVar = this.f30863a).f30848a) == null) {
                    return;
                }
                iVar.a(gVar.r, this.f30863a.n, false);
                this.f30863a.f30848a.w();
                this.f30863a.c(true);
                k.f("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        };
        this.R = 0L;
        this.S = 0L;
        this.T = false;
        this.V = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30864a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30864a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        this.f30864a.i();
                    } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                        this.f30864a.d(context2);
                    }
                }
            }
        };
        this.W = 1;
        this.X = false;
        this.W = n.c(context);
        a(z);
        this.u = str;
        try {
            this.G = viewGroup.getWidth();
            this.H = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f30850c = new WeakReference<>(viewGroup);
        this.n = new WeakReference<>(context);
        this.r = mVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
        this.v = z2;
        this.w = z3;
    }

    private boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            k.b("NativeVideoController", "retryCount=" + this.I);
            int i2 = this.I;
            if (1 <= i2) {
                i iVar = this.f30848a;
                if (iVar != null) {
                    iVar.w();
                    this.f30848a.a(this.r, this.n, false);
                }
                return false;
            } else if (this.f30854g == null) {
                return false;
            } else {
                this.I = i2 + 1;
                k.b("NativeVideoController", "isPlaying=" + this.f30854g.g() + ",isPaused=" + this.f30854g.i() + ",isPrepared=" + this.f30854g.k() + ",isStarted=" + this.f30854g.h());
                return (this.f30854g.g() && this.f30854g.i() && this.f30854g.k() && this.f30854g.h()) ? false : true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            C();
            this.f30851d.postDelayed(this.O, 800L);
        }
    }

    private void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f30851d.removeCallbacks(this.O);
        }
    }

    private boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            WeakReference<Context> weakReference = this.n;
            return (weakReference == null || weakReference.get() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void E() {
        List<Runnable> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (list = this.l) == null || list.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.l).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.l.clear();
    }

    private void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.a(false, this.f30856i, !this.t);
                B();
            }
            if (this.p) {
                o.a aVar = new o.a();
                aVar.a(n());
                aVar.c(q());
                aVar.b(o());
                com.bytedance.sdk.openadsdk.e.a.a.c(this.n.get(), w(), aVar);
            }
        }
    }

    private void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.S = SystemClock.elapsedRealtime() - this.R;
            if (this.p) {
                return;
            }
            o.a aVar = new o.a();
            aVar.b(this.D);
            com.bytedance.sdk.openadsdk.e.a.a.a(this.n.get(), this.f30848a, aVar);
            this.p = true;
        }
    }

    private void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f30850c.get() == null || y.a(this.f30850c.get(), 20, 0)) {
            return;
        }
        k.f("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
        this.f30848a.a(this.r, this.n, false);
        c(true);
        m();
    }

    private void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            k.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
            if (this.f30850c.get() == null || y.a(this.f30850c.get(), 20, 0)) {
                return;
            }
            k.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
            j();
        }
    }

    private boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            m mVar = this.r;
            return mVar != null && mVar.i() == 1 && "draw_ad".equals(this.u) && this.f30850c.get() != null;
        }
        return invokeV.booleanValue;
    }

    private void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && D()) {
            g(!this.T);
            if (!(this.n.get() instanceof Activity)) {
                k.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.b(this.f30850c.get());
                this.f30848a.b(false);
            }
            a(1);
            WeakReference<e> weakReference = this.x;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.T);
            }
        }
    }

    private void L() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (iVar = this.f30848a) == null) {
            return;
        }
        iVar.c(0);
        this.f30848a.a(false, false);
        this.f30848a.b(false);
        this.f30848a.b();
        this.f30848a.d();
    }

    private void M() {
        WeakReference<Context> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (weakReference = this.n) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.e.a.a.a(weakReference.get(), this.r, this.f30848a, this.L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{bVar, surfaceHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, map) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, bVar, view) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.e();
            }
            i iVar2 = this.f30848a;
            if (iVar2 != null) {
                iVar2.u();
            }
            F();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            a(true, 3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.c();
                this.f30854g = null;
            }
            if (!q.b(this.r) || this.P == 2) {
                this.f30848a.a(this.r, this.n, true);
            }
            w wVar = this.f30851d;
            if (wVar != null) {
                wVar.removeCallbacks(this.O);
                this.f30851d.removeCallbacks(this.N);
                this.f30851d.removeCallbacks(this.M);
                this.f30851d.removeCallbacksAndMessages(null);
            }
            C();
            List<Runnable> list = this.l;
            if (list != null) {
                list.clear();
            }
            if (this.s) {
                z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f30856i : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (v() == null) {
                return 0L;
            }
            return v().n();
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (v() == null) {
                return 0;
            }
            return v().q();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar == null) {
                return 0L;
            }
            return dVar.o() + this.y;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? com.bytedance.sdk.openadsdk.core.video.d.a.a(this.j, this.k) : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.z : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.c.d v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.f30854g : (com.bytedance.sdk.openadsdk.core.video.c.d) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public i w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.f30848a : (i) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.B : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && this.X && this.K) {
            Context applicationContext = com.bytedance.sdk.openadsdk.core.o.a().getApplicationContext();
            this.X = false;
            try {
                applicationContext.unregisterReceiver(this.V);
            } catch (Throwable unused) {
            }
        }
    }

    @SuppressLint({"InflateParams"})
    private void b(Context context) {
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, context) == null) {
            EnumSet noneOf = EnumSet.noneOf(b.a.class);
            noneOf.add(b.a.f30841a);
            noneOf.add(b.a.f30845e);
            if (this.s) {
                inflate = c(context);
            } else {
                inflate = LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_detail_layout"), (ViewGroup) null, false);
            }
            View view = inflate;
            if (view == null) {
                return;
            }
            if (this.s) {
                this.f30848a = new i(context, view, true, noneOf, this.r, this, b());
            } else {
                this.f30848a = new h(context, view, true, noneOf, this.r, this, false);
            }
            this.f30848a.a(this);
        }
    }

    private View c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, context)) == null) {
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setId(t.e(context, "tt_root_view"));
            relativeLayout.setBackgroundColor(-16777216);
            RelativeLayout relativeLayout2 = new RelativeLayout(context);
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            relativeLayout2.setId(t.e(context, "tt_video_loading_retry_layout"));
            relativeLayout2.setBackgroundColor(0);
            relativeLayout2.setGravity(17);
            relativeLayout2.setLayoutParams(layoutParams);
            relativeLayout.addView(relativeLayout2);
            ImageView imageView = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            imageView.setId(t.e(context, "tt_video_loading_cover_image"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(layoutParams2);
            relativeLayout2.addView(imageView);
            ProgressBar progressBar = new ProgressBar(context);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
            progressBar.setId(t.e(context, "tt_video_loading_progress"));
            layoutParams3.addRule(13, -1);
            progressBar.setLayoutParams(layoutParams3);
            progressBar.setIndeterminateDrawable(t.c(context, "tt_video_loading_progress_bar"));
            relativeLayout2.addView(progressBar);
            ImageView imageView2 = new ImageView(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            imageView2.setId(t.e(context, "tt_video_play"));
            layoutParams4.addRule(13, -1);
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            imageView2.setImageResource(t.d(context, "tt_play_movebar_textpage"));
            imageView2.setVisibility(8);
            imageView2.setLayoutParams(layoutParams4);
            relativeLayout.addView(imageView2);
            ProgressBar progressBar2 = new ProgressBar(context, null, t.g(context, "tt_Widget_ProgressBar_Horizontal"));
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
            progressBar2.setMax(100);
            progressBar2.setId(t.e(context, "tt_video_progress"));
            progressBar2.setBackgroundColor(0);
            progressBar2.setIndeterminateDrawable(null);
            progressBar2.setProgressDrawable(t.c(context, "tt_video_progress_drawable"));
            progressBar2.setVisibility(8);
            layoutParams5.addRule(12, -1);
            progressBar2.setLayoutParams(layoutParams5);
            relativeLayout.addView(progressBar2);
            ViewStub viewStub = new ViewStub(context);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
            viewStub.setId(t.e(context, "tt_video_ad_cover"));
            viewStub.setLayoutParams(layoutParams6);
            viewStub.setLayoutResource(t.f(context, "tt_video_ad_cover_layout"));
            relativeLayout.addView(viewStub);
            ViewStub viewStub2 = new ViewStub(context);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.addRule(13, -1);
            viewStub2.setId(t.e(context, "tt_video_draw_layout_viewStub"));
            viewStub2.setLayoutParams(layoutParams7);
            viewStub2.setLayoutResource(t.f(context, "tt_video_draw_btn_layout"));
            relativeLayout.addView(viewStub2);
            return relativeLayout;
        }
        return (View) invokeL.objValue;
    }

    private void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65576, this, z) == null) {
            this.T = z;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048614, this, j) == null) {
            this.f30856i = j;
            long j2 = this.j;
            if (j2 > j) {
                j = j2;
            }
            this.j = j;
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.e();
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.a(true, this.f30856i, !this.t);
                B();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, bVar, view) == null) {
            a(bVar, view, false);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.e();
            }
            i iVar2 = this.f30848a;
            if (iVar2 != null && z) {
                iVar2.u();
            }
            F();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || n.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0) {
            return;
        }
        m();
        com.bytedance.sdk.openadsdk.n.f.b bVar = this.L;
        if (bVar == null) {
            return;
        }
        bVar.a(this.r.V().i());
        this.L.d(this.r.ak());
        this.L.b(this.G);
        this.L.c(this.H);
        this.L.a((List<String>) null);
        this.L.e(this.r.ao());
        this.L.a(0L);
        this.L.a(c());
        com.bytedance.sdk.openadsdk.n.f.b bVar2 = this.L;
        bVar2.c(bVar2.c());
        a(this.L);
        c(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.b();
            }
            if (this.q || !this.p) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                    o.a aVar = new o.a();
                    aVar.a(n());
                    aVar.c(q());
                    aVar.b(o());
                    com.bytedance.sdk.openadsdk.e.a.a.b(this.n.get(), this.f30848a, aVar);
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", Boolean.TRUE);
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.t.a().b()) {
                o.a aVar2 = new o.a();
                aVar2.a(n());
                aVar2.c(q());
                aVar2.b(o());
                com.bytedance.sdk.openadsdk.e.a.a.b(this.n.get(), this.f30848a, aVar2);
            }
            com.bytedance.sdk.openadsdk.core.t.a().a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (dVar = this.f30854g) == null) {
            return;
        }
        dVar.b();
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            return dVar == null || dVar.l();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && !this.X && this.K) {
            Context applicationContext = com.bytedance.sdk.openadsdk.core.o.a().getApplicationContext();
            this.X = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                applicationContext.registerReceiver(this.V, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, drawVideoListener) == null) || (iVar = this.f30848a) == null) {
            return;
        }
        iVar.a(drawVideoListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.K = z;
        }
    }

    public void a(NativeVideoTsView.b bVar) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) && this.s && (iVar = this.f30848a) != null) {
            iVar.a(new NativeVideoTsView.b(this, bVar) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NativeVideoTsView.b f30857a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f30858b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30858b = this;
                    this.f30857a = bVar;
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                public void a(View view, int i2) {
                    NativeVideoTsView.b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) || (bVar2 = this.f30857a) == null) {
                        return;
                    }
                    bVar2.a(view, i2);
                }
            });
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            return dVar != null && dVar.g();
        }
        return invokeV.booleanValue;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || i2 == 0 || i3 == 0) {
            return;
        }
        this.G = i2;
        this.H = i3;
        k.b("NativeVideoController", BigImageLoaderProc.NCDN_PER + i2 + "height=" + i3);
    }

    public void d() {
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            k.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
            try {
                if (this.n != null && this.n.get() != null && a() != null && this.f30854g != null && this.f30854g.a() != null && this.f30850c != null && this.f30850c.get() != null) {
                    MediaPlayer a2 = this.f30854g.a();
                    int videoWidth = a2.getVideoWidth();
                    int videoHeight = a2.getVideoHeight();
                    int width = this.f30850c.get().getWidth();
                    int height = this.f30850c.get().getHeight();
                    if (width > 0 && height > 0 && videoHeight > 0 && videoWidth > 0) {
                        if (videoWidth == videoHeight) {
                            i3 = width > height ? height : width;
                            i2 = i3;
                        } else if (videoWidth > videoHeight) {
                            i3 = (int) ((width * 1.0d) / ((videoWidth * 1.0f) / videoHeight));
                            i2 = width;
                        } else {
                            i2 = (int) ((height * 1.0d) / ((videoHeight * 1.0f) / videoWidth));
                            i3 = height;
                        }
                        if (i3 <= height && i3 > 0) {
                            height = i3;
                        }
                        if (!a(videoWidth, videoHeight, i2, width)) {
                            width = i2;
                        }
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(width, height);
                        layoutParams2.addRule(13);
                        if (a() instanceof TextureView) {
                            ((TextureView) a()).setLayoutParams(layoutParams2);
                            k.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                        } else if (a() instanceof SurfaceView) {
                            ((SurfaceView) a()).setLayoutParams(layoutParams2);
                            k.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                        }
                        if (!c(videoWidth, videoHeight) || (layoutParams = this.f30850c.get().getLayoutParams()) == null) {
                            return;
                        }
                        layoutParams.height = height;
                        layoutParams.width = width;
                        this.f30850c.get().setLayoutParams(layoutParams);
                        this.f30848a.a(layoutParams.width, layoutParams.height);
                        return;
                    }
                    k.b("ChangeVideoSize", " container or video exist size <= 0");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[step-1] >>>>> mContextRef=");
                sb.append(this.n);
                sb.append(",mContextRef.get()=");
                sb.append(this.n != null ? this.n.get() : null);
                sb.append(",getIRenderView() =");
                sb.append(a());
                k.b("ChangeVideoSize", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[step-1] >>>>> mMediaPlayerProxy == null:");
                boolean z = true;
                sb2.append(this.f30854g == null);
                sb2.append(",mMediaPlayerProxy.getMediaPlayer() == null:");
                if (this.f30854g == null || this.f30854g.a() != null) {
                    z = false;
                }
                sb2.append(z);
                k.b("ChangeVideoSize", sb2.toString());
            } catch (Throwable th) {
                k.b("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! ：" + th.toString());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0347c interfaceC0347c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, interfaceC0347c) == null) {
            this.E = new WeakReference<>(interfaceC0347c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, bVar)) == null) {
            k.b("tag_video_play", "[video] start NativeVideoController#playVideoUrl and video url is :\r\n" + bVar.a());
            if (TextUtils.isEmpty(bVar.a())) {
                k.f("tag_video_play", "[video] play video stop , because no video info");
                return false;
            }
            this.L = bVar;
            M();
            this.t = bVar.h();
            this.f30856i = bVar.g();
            if (bVar.g() <= 0) {
                this.q = false;
                this.p = false;
            }
            if (bVar.g() > 0) {
                long g2 = bVar.g();
                this.f30856i = g2;
                long j = this.j;
                if (j > g2) {
                    g2 = j;
                }
                this.j = g2;
            }
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.e();
                if (this.P == 0) {
                    this.f30848a.d();
                }
                this.f30848a.c(bVar.e(), bVar.f());
                this.f30848a.c(this.f30850c.get());
                this.f30848a.a(bVar.e(), bVar.f());
            }
            if (this.f30854g == null) {
                this.f30854g = new com.bytedance.sdk.openadsdk.core.video.c.d(this.f30851d);
            }
            k.b("tag_video_play", "[video] new MediaPlayer");
            this.f30853f = 0L;
            try {
                b(bVar);
                return true;
            } catch (Exception e2) {
                k.f("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + e2.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.s : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.y = j;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.t = z;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.b(z);
            }
        }
    }

    private void b(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, bVar) == null) {
            k.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
            if (bVar == null) {
                k.b("tag_video_play", "VideoUrlModel is null  !!!");
                return;
            }
            if (this.f30854g != null) {
                m mVar = this.r;
                if (mVar != null) {
                    if (mVar.V() != null) {
                        bVar.b(this.r.V().l());
                    }
                    bVar.f(String.valueOf(q.d(this.r.ao())));
                }
                bVar.d(0);
                this.f30854g.a(bVar);
                k.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
            }
            this.f30852e = System.currentTimeMillis();
            if (!TextUtils.isEmpty(bVar.a())) {
                this.f30848a.d(8);
                this.f30848a.d(0);
                a(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ g f30859a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30859a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f30859a.f30852e = System.currentTimeMillis();
                            this.f30859a.f30848a.c(0);
                            if (this.f30859a.f30854g != null && this.f30859a.f30856i == 0) {
                                this.f30859a.f30854g.a(true, 0L, !this.f30859a.t);
                            } else if (this.f30859a.f30854g != null) {
                                this.f30859a.f30854g.a(true, this.f30859a.f30856i, !this.f30859a.t);
                            }
                            if (this.f30859a.f30851d != null) {
                                this.f30859a.f30851d.postDelayed(this.f30859a.M, 100L);
                            }
                            this.f30859a.B();
                        }
                    }
                });
            }
            if (this.s) {
                g();
            }
        }
    }

    private void b(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65560, this, i2) == null) {
            this.P++;
            if (D() && (iVar = this.f30848a) != null) {
                iVar.w();
                c.a aVar = this.f30855h;
                if (aVar != null) {
                    aVar.a(this.f30853f, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.f30856i, this.k));
                }
                this.f30853f = System.currentTimeMillis() - this.f30852e;
                if (!q.b(this.r) || this.P >= 2) {
                    this.f30848a.a(this.r, this.n, true);
                }
                if (!this.q) {
                    o.a aVar2 = new o.a();
                    aVar2.a(n());
                    aVar2.c(q());
                    aVar2.b(o());
                    aVar2.f(p());
                    com.bytedance.sdk.openadsdk.e.a.a.g(this.n.get(), this.f30848a, aVar2);
                    this.q = true;
                    long j = this.k;
                    a(j, j);
                    long j2 = this.k;
                    this.f30856i = j2;
                    this.j = j2;
                }
                if (!this.s && this.T) {
                    e(this.f30848a, null);
                }
                this.B = true;
                if (!q.b(this.r) || this.P >= 2) {
                    return;
                }
                h();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f30856i = j;
            long j2 = this.j;
            if (j2 > j) {
                j = j2;
            }
            this.j = j;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, bVar, view) == null) {
            if (this.T) {
                g(false);
                i iVar = this.f30848a;
                if (iVar != null) {
                    iVar.b(this.f30850c.get());
                }
                a(1);
                return;
            }
            a(true, 3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.s = z;
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.c(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.x = new WeakReference<>(eVar);
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, runnable) == null) || runnable == null) {
            return;
        }
        if (this.f30848a.k() && this.m) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    private boolean d(int i2) {
        InterceptResult invokeI;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65571, this, i2)) == null) {
            int c2 = n.c(com.bytedance.sdk.openadsdk.core.o.a());
            if (c2 == 0) {
                i();
                this.z = true;
                i iVar = this.f30848a;
                if (iVar != null) {
                    iVar.a(this.r, this.n, false);
                }
            }
            if (c2 != 4 && c2 != 0) {
                i iVar2 = this.f30848a;
                if (iVar2 != null) {
                    iVar2.e();
                }
                i();
                this.z = true;
                this.A = false;
                i iVar3 = this.f30848a;
                if (iVar3 != null && (mVar = this.r) != null) {
                    return iVar3.a(i2, mVar.V(), this.w);
                }
            } else if (c2 == 4) {
                this.z = false;
                i iVar4 = this.f30848a;
                if (iVar4 != null) {
                    iVar4.q();
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.f30855h = aVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.s) {
                this.Q = q();
            }
            if (!this.q && this.p) {
                if (z) {
                    o.a aVar = new o.a();
                    aVar.a(n());
                    aVar.c(q());
                    aVar.b(o());
                    aVar.e(i2);
                    aVar.f(p());
                    com.bytedance.sdk.openadsdk.e.a.a.f(this.n.get(), this.f30848a, aVar);
                    this.q = false;
                } else {
                    o.a aVar2 = new o.a();
                    aVar2.a(n());
                    aVar2.c(q());
                    aVar2.b(o());
                    com.bytedance.sdk.openadsdk.e.a.a.b(this.n.get(), this.f30848a, aVar2);
                }
            }
            m();
        }
    }

    public g(Context context, ViewGroup viewGroup, m mVar, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30851d = new w(this);
        this.f30852e = 0L;
        this.f30853f = 0L;
        this.f30856i = 0L;
        this.j = 0L;
        this.m = false;
        this.p = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = "embeded_ad";
        this.v = false;
        this.w = true;
        this.y = 0L;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = true;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = true;
        this.M = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30860a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30860a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30860a.f30854g == null) {
                    return;
                }
                this.f30860a.f30854g.e();
            }
        };
        this.N = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30861a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30861a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30861a.f30855h == null) {
                    return;
                }
                this.f30861a.f30855h.a();
            }
        };
        this.O = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30862a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30862a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f30862a.f30854g != null) {
                        if (this.f30862a.k <= 0) {
                            this.f30862a.f30854g.e();
                        }
                        this.f30862a.f30854g.f();
                    }
                    this.f30862a.f30851d.postDelayed(this, 200L);
                }
            }
        };
        this.P = 0;
        this.Q = 0L;
        this.f30849b = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30863a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30863a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar;
                i iVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (iVar = (gVar = this.f30863a).f30848a) == null) {
                    return;
                }
                iVar.a(gVar.r, this.f30863a.n, false);
                this.f30863a.f30848a.w();
                this.f30863a.c(true);
                k.f("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        };
        this.R = 0L;
        this.S = 0L;
        this.T = false;
        this.V = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f30864a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f30864a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        this.f30864a.i();
                    } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                        this.f30864a.d(context2);
                    }
                }
            }
        };
        this.W = 1;
        this.X = false;
        this.W = n.c(context);
        try {
            this.G = viewGroup.getWidth();
            this.H = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f30850c = new WeakReference<>(viewGroup);
        this.u = str;
        this.n = new WeakReference<>(context);
        this.r = mVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
        this.v = z;
        this.w = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, context) == null) {
            int c2 = n.c(context);
            a(context, c2);
            if (c2 == 4) {
                this.z = false;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.k = j;
        }
    }

    private void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, runnable) == null) {
            if (this.l == null) {
                this.l = Collections.synchronizedList(new ArrayList());
            }
            this.l.add(runnable);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.t : invokeV.booleanValue;
    }

    private boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65567, this, i2, i3)) == null) ? i2 < i3 && J() : invokeII.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.D = z;
        }
    }

    private boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65572, this, i2, i3)) == null) {
            k.b("TTVideoWebPageActivity", "OnError - Error code: " + i2 + " Extra code: " + i3);
            boolean z = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
            if (i3 == 1 || i3 == 700 || i3 == 800) {
                return true;
            }
            return z;
        }
        return invokeII.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, bVar, view) == null) {
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.g();
            }
            a(true, 3);
        }
    }

    private void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65561, this, i2, i3) == null) || this.n == null) {
            return;
        }
        o.a aVar = new o.a();
        aVar.b(o());
        aVar.c(q());
        aVar.a(n());
        aVar.a(i2);
        aVar.b(i3);
        com.bytedance.sdk.openadsdk.e.a.a.d(this.n.get(), w(), aVar);
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<a> weakReference2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, message) == null) || this.f30848a == null || message == null || (weakReference = this.n) == null || weakReference.get() == null) {
            return;
        }
        int i2 = message.what;
        if (i2 == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.k = ((Long) message.obj).longValue();
        } else if (i2 == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                long longValue = ((Long) obj2).longValue();
                this.f30856i = longValue;
                long j = this.j;
                if (j > longValue) {
                    longValue = j;
                }
                this.j = longValue;
                a(this.f30856i, this.k);
            }
        } else if (i2 == 308) {
            k.f("NativeVideoController", "播放器状态出错 STAT_ERROR 200 、、、、、、、");
            H();
            b(308, 0);
        } else if (i2 != 309) {
            switch (i2) {
                case 302:
                    b(i2);
                    return;
                case 303:
                    int i3 = message.arg1;
                    int i4 = message.arg2;
                    b(i3, i4);
                    k.f("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!f() || i4 == -1004) {
                        k.f("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i3 + "," + i4);
                        if (d(i3, i4)) {
                            k.f("NativeVideoController", "出错后展示结果页、、、、、、、");
                            this.f30848a.a(this.r, this.n, false);
                            c(true);
                            m();
                        }
                        i iVar = this.f30848a;
                        if (iVar != null) {
                            iVar.w();
                        }
                        c.a aVar = this.f30855h;
                        if (aVar != null) {
                            aVar.b(this.f30853f, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.f30856i, this.k));
                        }
                        WeakReference<c.InterfaceC0347c> weakReference3 = this.E;
                        if (weakReference3 == null || weakReference3.get() == null || f()) {
                            return;
                        }
                        this.E.get().a(i3, i4);
                        return;
                    }
                    return;
                case 304:
                    int i5 = message.arg1;
                    i iVar2 = this.f30848a;
                    if (iVar2 != null) {
                        if (i5 == 3 || i5 == 702) {
                            this.f30848a.w();
                            this.f30851d.removeCallbacks(this.f30849b);
                            this.J = false;
                        } else if (i5 == 701) {
                            iVar2.t();
                            this.f30851d.postDelayed(this.f30849b, 8000L);
                            this.J = true;
                        }
                    }
                    if (this.o && i5 == 3) {
                        if (this.s && (weakReference2 = this.F) != null && weakReference2.get() != null) {
                            this.F.get().g();
                        }
                        this.f30851d.removeCallbacks(this.f30849b);
                    }
                    if (this.o && i5 == 3) {
                        G();
                        return;
                    }
                    return;
                case 305:
                    WeakReference<c.InterfaceC0347c> weakReference4 = this.E;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        this.E.get().i_();
                    }
                    w wVar = this.f30851d;
                    if (wVar != null) {
                        wVar.removeCallbacks(this.N);
                    }
                    if (!this.o) {
                        G();
                    }
                    i iVar3 = this.f30848a;
                    if (iVar3 != null) {
                        iVar3.w();
                    }
                    this.f30851d.removeCallbacks(this.f30849b);
                    return;
                case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                    i iVar4 = this.f30848a;
                    if (iVar4 != null) {
                        iVar4.w();
                        return;
                    }
                    return;
                default:
                    switch (i2) {
                        case 311:
                            d();
                            return;
                        case 312:
                            if (A()) {
                                k.f("NativeVideoController", "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                                m();
                                this.f30854g = null;
                                com.bytedance.sdk.openadsdk.n.f.b bVar = this.L;
                                if (bVar == null) {
                                    return;
                                }
                                bVar.a(this.r.V().i());
                                this.L.d(this.r.ak());
                                this.L.b(this.G);
                                this.L.c(this.H);
                                this.L.a((List<String>) null);
                                this.L.e(this.r.ao());
                                this.L.a(0L);
                                this.L.a(c());
                                com.bytedance.sdk.openadsdk.n.f.b bVar2 = this.L;
                                bVar2.c(bVar2.c());
                                a(this.L);
                                return;
                            }
                            k.c("NativeVideoController", "不满足条件，无法重试");
                            b(312, 0);
                            return;
                        case 313:
                            I();
                            WeakReference<a> weakReference5 = this.F;
                            if (weakReference5 == null || weakReference5.get() == null) {
                                return;
                            }
                            this.F.get().g();
                            return;
                        case 314:
                            try {
                                ((Boolean) message.obj).booleanValue();
                            } catch (Throwable unused) {
                            }
                            this.R = SystemClock.elapsedRealtime();
                            return;
                        default:
                            return;
                    }
            }
        } else {
            k.c("NativeVideoController", "SSMediaPlayerWrapper 释放了。。。。。");
        }
    }

    private boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65566, this, i2)) == null) ? this.f30848a.b(i2) : invokeI.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.B = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, bVar, i2) == null) {
            if (this.f30854g != null) {
                C();
            }
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, bVar, view) == null) {
            b(bVar, view, false, false);
        }
    }

    public void b(b bVar, View view, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{bVar, view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && D()) {
            g(!this.T);
            if (!(this.n.get() instanceof Activity)) {
                k.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.T) {
                a(z ? 8 : 0);
                i iVar = this.f30848a;
                if (iVar != null) {
                    iVar.a(this.f30850c.get());
                    this.f30848a.b(false);
                }
            } else {
                a(1);
                i iVar2 = this.f30848a;
                if (iVar2 != null) {
                    iVar2.b(this.f30850c.get());
                    this.f30848a.b(false);
                }
            }
            WeakReference<e> weakReference = this.x;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.T);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, bVar, surfaceHolder) == null) {
            this.m = false;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, bVar, surfaceTexture) == null) {
            this.m = false;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65558, this, i2, i3, i4, i5)) == null) ? (i4 > i5 && !c(i2, i3)) || i4 <= 0 : invokeIIII.booleanValue;
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b a() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Context> weakReference = this.n;
            if (weakReference == null || weakReference.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || (iVar = this.f30848a) == null) {
                return null;
            }
            return iVar.o();
        }
        return (com.bytedance.sdk.openadsdk.core.video.renderview.b) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, bVar, view) == null) && this.f30854g != null && D()) {
            if (this.f30854g.g()) {
                i();
                this.f30848a.b(true, false);
                this.f30848a.c();
            } else if (!this.f30854g.i()) {
                i iVar = this.f30848a;
                if (iVar != null) {
                    iVar.c(this.f30850c.get());
                }
                d(this.f30856i);
                i iVar2 = this.f30848a;
                if (iVar2 != null) {
                    iVar2.b(false, false);
                }
            } else {
                f(false);
                i iVar3 = this.f30848a;
                if (iVar3 != null) {
                    iVar3.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, i2) == null) || this.f30854g == null) {
            return;
        }
        B();
        a(this.U, c(i2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{bVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && D()) {
            long l = (((float) (i2 * this.k)) * 1.0f) / t.l(this.n.get(), "tt_video_progress_max");
            if (this.k > 0) {
                this.U = (int) l;
            } else {
                this.U = 0L;
            }
            i iVar = this.f30848a;
            if (iVar != null) {
                iVar.a(this.U);
            }
        }
    }

    private void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f30856i = j;
            this.k = j2;
            this.f30848a.a(j, j2);
            this.f30848a.a(com.bytedance.sdk.openadsdk.core.video.d.a.a(j, j2));
            try {
                if (this.f30855h != null) {
                    this.f30855h.a(j, j2);
                }
            } catch (Throwable th) {
                k.c("NativeVideoController", "onProgressUpdate error: ", th);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && D()) {
            boolean z = i2 == 0 || i2 == 8;
            Context context = this.n.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{bVar, view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.s) {
                i();
            }
            if (z && !this.s && !e()) {
                this.f30848a.b(!f(), false);
                this.f30848a.a(z2, true, false);
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null && dVar.g()) {
                this.f30848a.c();
                this.f30848a.b();
                return;
            }
            this.f30848a.c();
        }
    }

    public void a(b bVar, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, bVar, view, z) == null) {
            K();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bVar, surfaceHolder) == null) {
            this.m = true;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar2 = this.f30854g;
            if (dVar2 == null) {
                return;
            }
            dVar2.a(surfaceHolder);
            E();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bVar, surfaceTexture) == null) {
            this.m = true;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.f30854g;
            if (dVar != null) {
                dVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar2 = this.f30854g;
            if (dVar2 == null) {
                return;
            }
            dVar2.a(surfaceTexture);
            E();
        }
    }

    private void a(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.f30854g == null) {
            return;
        }
        if (z) {
            L();
        }
        this.f30854g.a(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(i.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, aVar, str) == null) {
            int i2 = AnonymousClass8.f30865a[aVar.ordinal()];
            if (i2 == 1) {
                i();
            } else if (i2 == 2) {
                a(true, 3);
            } else if (i2 != 3) {
            } else {
                k();
                this.z = false;
                this.A = true;
            }
        }
    }

    private void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65555, this, context, i2) == null) || !D() || context == null || this.W == i2) {
            return;
        }
        this.W = i2;
        if (i2 != 4 && i2 != 0) {
            this.A = false;
        }
        if (!this.A && !x() && this.v) {
            d(2);
        }
        WeakReference<a> weakReference = this.F;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.F.get().a(this.W);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            int c2 = n.c(context);
            a(context, c2);
            if (c2 == 4) {
                this.z = false;
                k();
            }
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            this.F = new WeakReference<>(aVar);
        }
    }
}
