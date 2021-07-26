package com.bytedance.sdk.openadsdk.core.video.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.i;
import com.bytedance.sdk.openadsdk.core.widget.i;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class a implements w.a, c, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public boolean B;
    public boolean C;
    public boolean D;
    public WeakReference<e> E;
    public int F;
    public boolean G;
    public boolean H;
    public final Runnable I;
    public final Runnable J;
    public final Runnable K;
    public boolean L;
    public long M;
    public final BroadcastReceiver N;
    public int O;
    public boolean P;

    /* renamed from: a  reason: collision with root package name */
    public i f30766a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f30767b;

    /* renamed from: c  reason: collision with root package name */
    public final m f30768c;

    /* renamed from: d  reason: collision with root package name */
    public long f30769d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Object> f30770e;

    /* renamed from: f  reason: collision with root package name */
    public long f30771f;

    /* renamed from: g  reason: collision with root package name */
    public long f30772g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30773h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f30774i;
    public com.bytedance.sdk.openadsdk.n.f.b j;
    public long k;
    public final ViewGroup l;
    public final w m;
    public long n;
    public long o;
    public com.bytedance.sdk.openadsdk.core.video.c.d p;
    public c.a q;
    public long r;
    public long s;
    public ArrayList<Runnable> t;
    public boolean u;
    public final boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.b.a$6  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30780a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-30500604, "Lcom/bytedance/sdk/openadsdk/core/video/b/a$6;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-30500604, "Lcom/bytedance/sdk/openadsdk/core/video/b/a$6;");
                    return;
                }
            }
            int[] iArr = new int[i.a.values().length];
            f30780a = iArr;
            try {
                iArr[i.a.f31096a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30780a[i.a.f31097b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30780a[i.a.f31098c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(Context context, ViewGroup viewGroup, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new w(this);
        this.n = 0L;
        this.o = 0L;
        this.r = 0L;
        this.s = 0L;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = false;
        this.A = 0L;
        this.B = false;
        this.C = false;
        this.D = false;
        this.f30770e = null;
        this.f30771f = 0L;
        this.f30772g = 0L;
        this.f30773h = false;
        this.f30774i = false;
        this.G = false;
        this.H = true;
        this.I = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30776a;

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
                this.f30776a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30776a.p == null) {
                    return;
                }
                this.f30776a.p.e();
            }
        };
        this.J = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30777a;

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
                this.f30777a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30777a.q == null) {
                    return;
                }
                this.f30777a.q.a();
            }
        };
        this.K = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30778a;

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
                this.f30778a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f30778a.p != null) {
                        a aVar = this.f30778a;
                        if (aVar.f30769d <= 0) {
                            aVar.p.e();
                        }
                        this.f30778a.p.f();
                    }
                    this.f30778a.m.postDelayed(this, 200L);
                }
            }
        };
        this.L = false;
        this.N = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30779a;

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
                this.f30779a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        this.f30779a.i();
                    } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                        this.f30779a.b(context2);
                    }
                }
            }
        };
        this.O = 1;
        this.P = false;
        this.O = n.c(context);
        this.l = viewGroup;
        this.f30767b = new WeakReference<>(context);
        this.f30768c = mVar;
        a(context);
        this.F = q.d(this.f30768c.ao());
        this.v = Build.VERSION.SDK_INT >= 17;
    }

    private void C() {
        int J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int a2 = a();
            if (a2 != 2 && a2 != 1) {
                J = a2 == 3 ? o.h().f(String.valueOf(this.F)) : 5;
            } else {
                J = o.h().J() * 1000;
            }
            this.m.removeCallbacks(this.J);
            this.m.postDelayed(this.J, J);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            E();
            this.m.postDelayed(this.K, 800L);
        }
    }

    private void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.m.removeCallbacks(this.K);
        }
    }

    private boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            WeakReference<Context> weakReference = this.f30767b;
            return (weakReference == null || weakReference.get() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void G() {
        ArrayList<Runnable> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (arrayList = this.t) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.t).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.t.clear();
    }

    private boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            m mVar = this.f30768c;
            return mVar == null || mVar.aJ() == 100.0f;
        }
        return invokeV.booleanValue;
    }

    private void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                if (N() != null && this.p != null && this.p.a() != null && this.l != null) {
                    MediaPlayer a2 = this.p.a();
                    int width = this.l.getWidth();
                    int height = this.l.getHeight();
                    float videoWidth = a2.getVideoWidth();
                    float videoHeight = a2.getVideoHeight();
                    float f2 = width;
                    float f3 = height;
                    if (videoWidth / (f2 * 1.0f) <= videoHeight / (f3 * 1.0f)) {
                        f2 = videoWidth * (f3 / (videoHeight * 1.0f));
                    } else {
                        f3 = (f2 / (videoWidth * 1.0f)) * videoHeight;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) f3);
                    layoutParams.addRule(13);
                    if (N() instanceof TextureView) {
                        ((TextureView) N()).setLayoutParams(layoutParams);
                    } else if (N() instanceof SurfaceView) {
                        ((SurfaceView) N()).setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable th) {
                k.c("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
            }
        }
    }

    private boolean J() throws Throwable {
        InterceptResult invokeV;
        com.bytedance.sdk.openadsdk.core.video.c.d dVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            WeakReference<Context> weakReference = this.f30767b;
            return weakReference == null || weakReference.get() == null || N() == null || (dVar = this.p) == null || dVar.a() == null || (mVar = this.f30768c) == null || mVar.P() != null || this.f30768c.k() == 1;
        }
        return invokeV.booleanValue;
    }

    private void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            try {
                if (this.f30767b != null && this.f30767b.get() != null && N() != null && this.p != null && this.p.a() != null && this.f30768c != null) {
                    int[] b2 = s.b(o.a());
                    MediaPlayer a2 = this.p.a();
                    boolean z = this.f30768c.aI() == 1;
                    float f2 = b2[0];
                    float f3 = b2[1];
                    float videoWidth = a2.getVideoWidth();
                    float videoHeight = a2.getVideoHeight();
                    if (z) {
                        if (videoWidth > videoHeight) {
                            a(f2, f3, videoWidth, videoHeight, true);
                            return;
                        }
                        f3 = (videoHeight * f2) / videoWidth;
                    } else if (videoWidth < videoHeight) {
                        a(f2, f3, videoWidth, videoHeight, false);
                        return;
                    } else {
                        f2 = (videoWidth * f3) / videoHeight;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) f3);
                    layoutParams.addRule(13);
                    if (N() == null || this.l == null) {
                        return;
                    }
                    if (N() instanceof TextureView) {
                        ((TextureView) N()).setLayoutParams(layoutParams);
                    } else if (N() instanceof SurfaceView) {
                        ((SurfaceView) N()).setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable th) {
                k.c("changeVideoSize", "changeVideoSizeByWidth error", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0126 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:5:0x0008, B:8:0x0029, B:12:0x0049, B:16:0x005f, B:22:0x007b, B:28:0x00f5, B:35:0x0109, B:37:0x0126, B:39:0x0146, B:41:0x0158, B:43:0x0160, B:47:0x017b, B:49:0x0183, B:44:0x016a, B:46:0x0172, B:50:0x018c, B:33:0x0103, B:20:0x006f), top: B:58:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0158 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:5:0x0008, B:8:0x0029, B:12:0x0049, B:16:0x005f, B:22:0x007b, B:28:0x00f5, B:35:0x0109, B:37:0x0126, B:39:0x0146, B:41:0x0158, B:43:0x0160, B:47:0x017b, B:49:0x0183, B:44:0x016a, B:46:0x0172, B:50:0x018c, B:33:0x0103, B:20:0x006f), top: B:58:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                k.c("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.f30768c.m());
                if (J()) {
                    return;
                }
                k.c("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
                int[] b2 = s.b(o.a());
                MediaPlayer a2 = this.p.a();
                boolean z = false;
                boolean z2 = this.f30768c.aI() == 1;
                float f2 = b2[0];
                float f3 = b2[1];
                float videoWidth = a2.getVideoWidth();
                float videoHeight = a2.getVideoHeight();
                if (z2) {
                    if (videoWidth > videoHeight) {
                        k.b("changeVideoSize", "横转竖屏单独适配.....");
                        a(f2, f3, videoWidth, videoHeight, true);
                        return;
                    }
                } else if (videoWidth < videoHeight) {
                    k.b("changeVideoSize", "竖屏转横单独适配.....");
                    a(f2, f3, videoWidth, videoHeight, false);
                    return;
                }
                float f4 = videoWidth / videoHeight;
                float f5 = f2 / f3;
                k.b("changeVideoSize", "screenHeight=" + f3 + ",screenWidth=" + f2);
                k.b("changeVideoSize", "videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                k.b("changeVideoSize", "视频宽高比,videoScale=" + f4 + ",屏幕宽高比.screenScale=" + f5 + ",VERTICAL_SCALE(9:16)=0.5625,HORIZONTAL_SCALE(16:9) =1.7777778");
                if (z2) {
                    if (f5 < 0.5625f && f4 == 0.5625f) {
                        videoWidth = (9.0f * f3) / 16.0f;
                        videoHeight = f3;
                        z = true;
                    }
                    k.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                    if (z) {
                        k.c("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f3 + "，videoWidth=" + f2);
                    } else {
                        f2 = videoWidth;
                        f3 = videoHeight;
                    }
                    int i2 = (int) f2;
                    int i3 = (int) f3;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
                    layoutParams.addRule(13);
                    if (N() != null) {
                        if (N() instanceof TextureView) {
                            ((TextureView) N()).setLayoutParams(layoutParams);
                        } else if (N() instanceof SurfaceView) {
                            ((SurfaceView) N()).setLayoutParams(layoutParams);
                        }
                        ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.height = i3;
                            layoutParams2.width = i2;
                            this.l.setLayoutParams(layoutParams2);
                        }
                    }
                    k.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
                }
                if (f5 > 1.7777778f && f4 == 1.7777778f) {
                    videoHeight = (9.0f * f2) / 16.0f;
                    videoWidth = f2;
                    z = true;
                }
                k.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                if (z) {
                }
                int i22 = (int) f2;
                int i32 = (int) f3;
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i22, i32);
                layoutParams3.addRule(13);
                if (N() != null) {
                }
                k.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
            } catch (Throwable th) {
                k.c("changeVideoSize", "changeSize error", th);
            }
        }
    }

    private void M() {
        int[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                if (this.f30767b != null && this.f30767b.get() != null && N() != null && this.p != null && this.p.a() != null && this.f30768c != null) {
                    boolean z = this.f30768c.aI() == 1;
                    float f2 = s.b(o.a())[1];
                    MediaPlayer a2 = this.p.a();
                    a(b2[0], f2, a2.getVideoWidth(), a2.getVideoHeight(), z);
                    k.b("changeVideoSize", "changeSize=end");
                }
            } catch (Throwable th) {
                k.a("changeVideoSize", "changeSize error", th);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b N() {
        InterceptResult invokeV;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            WeakReference<Context> weakReference = this.f30767b;
            if (weakReference == null || weakReference.get() == null || (iVar = this.f30766a) == null) {
                return null;
            }
            return iVar.o();
        }
        return (com.bytedance.sdk.openadsdk.core.video.renderview.b) invokeV.objValue;
    }

    private void O() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (iVar = this.f30766a) == null) {
            return;
        }
        iVar.c(0);
        this.f30766a.a(false, false);
        this.f30766a.b(false);
        this.f30766a.b();
        this.f30766a.d();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p.l() : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            return dVar != null && dVar.g();
        }
        return invokeV.booleanValue;
    }

    public abstract int a();

    public abstract void a(int i2, int i3);

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{bVar, surfaceHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048589, this, bVar, view, z) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0347c interfaceC0347c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, interfaceC0347c) == null) {
        }
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
        }
    }

    public abstract void e();

    public abstract void f();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, bVar, view) == null) {
        }
    }

    public abstract void g();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.b();
                this.f30766a.e();
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.f30766a;
            if (iVar2 != null) {
                iVar2.u();
            }
            d(-1L);
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.k = q();
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.b();
            }
            if (this.x || !this.w) {
                return;
            }
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (dVar = this.p) == null) {
            return;
        }
        dVar.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.e();
                this.f30766a.q();
                this.f30766a.u();
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.a(false, this.r, !this.z);
                D();
            }
            if (this.x || !this.w) {
                return;
            }
            d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.c();
                this.p = null;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.g();
            }
            w wVar = this.m;
            if (wVar != null) {
                wVar.removeCallbacks(this.J);
                this.m.removeCallbacks(this.I);
                this.m.removeCallbacksAndMessages(null);
                E();
            }
            this.q = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.r : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar == null) {
                return 0;
            }
            return dVar.q();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar == null) {
                return 0L;
            }
            return dVar.o() + this.A;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar == null) {
                return 0L;
            }
            return dVar.p() + this.A;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? com.bytedance.sdk.openadsdk.core.video.d.a.a(this.s, this.f30769d) : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f30769d : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.B : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.c.d v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.p : (com.bytedance.sdk.openadsdk.core.video.c.d) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.i w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f30766a : (com.bytedance.sdk.openadsdk.core.video.nativevideo.i) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.D : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && !this.x && this.w) {
            d();
        }
    }

    private void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65569, this, z) == null) {
            this.L = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.A = j;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.f30769d = j;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            this.r = j;
            long j2 = this.s;
            if (j2 > j) {
                j = j2;
            }
            this.s = j;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.e();
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.a(true, this.r, !this.z);
                D();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.H = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.z = z;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.b(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.D = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, bVar, view) == null) {
            a(bVar, view, false);
        }
    }

    @SuppressLint({"InflateParams"})
    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
            EnumSet noneOf = EnumSet.noneOf(b.a.class);
            noneOf.add(b.a.f30841a);
            noneOf.add(b.a.f30845e);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = new com.bytedance.sdk.openadsdk.core.video.nativevideo.i(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.f30768c, this);
            this.f30766a = iVar;
            iVar.a(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, bVar, view) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.g();
            }
            a(true, 3);
        }
    }

    private void b(com.bytedance.sdk.openadsdk.n.f.b bVar) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, this, bVar) == null) || bVar == null) {
            return;
        }
        this.j = bVar;
        if (this.p != null) {
            m mVar = this.f30768c;
            if (mVar != null) {
                x V = mVar.V();
                if (V != null) {
                    bVar.b(V.l());
                }
                bVar.f(String.valueOf(q.d(this.f30768c.ao())));
            }
            bVar.d(1);
            this.p.a(bVar);
        }
        this.n = System.currentTimeMillis();
        if (TextUtils.isEmpty(bVar.a())) {
            return;
        }
        this.f30766a.d(8);
        this.f30766a.d(0);
        a(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30775a;

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
                this.f30775a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f30775a.n = System.currentTimeMillis();
                    this.f30775a.f30766a.c(0);
                    if (this.f30775a.p != null && this.f30775a.r == 0) {
                        this.f30775a.p.a(true, 0L, !this.f30775a.z);
                    } else if (this.f30775a.p != null) {
                        this.f30775a.p.a(true, this.f30775a.r, !this.f30775a.z);
                    }
                    if (this.f30775a.m != null) {
                        this.f30775a.m.postDelayed(this.f30775a.I, 100L);
                    }
                    this.f30775a.D();
                }
            }
        });
    }

    private boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65563, this, i2)) == null) ? this.f30766a.b(i2) : invokeI.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, bVar, view) == null) {
            if (this.L) {
                f(false);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
                if (iVar != null) {
                    iVar.b(this.l);
                }
                a(1);
                return;
            }
            a(true, 3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            this.j = bVar;
            k.b("BaseVideoController", "video local url " + bVar.a());
            if (TextUtils.isEmpty(bVar.a())) {
                k.f("BaseVideoController", "No video info");
                return false;
            }
            f();
            this.f30773h = !bVar.a().startsWith("http");
            this.z = bVar.h();
            if (bVar.g() > 0) {
                long g2 = bVar.g();
                this.r = g2;
                long j = this.s;
                if (j > g2) {
                    g2 = j;
                }
                this.s = g2;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.e();
                this.f30766a.d();
                this.f30766a.c(bVar.e(), bVar.f());
                this.f30766a.c(this.l);
            }
            if (this.p == null) {
                this.p = new com.bytedance.sdk.openadsdk.core.video.c.d(this.m);
            }
            this.o = 0L;
            try {
                b(bVar);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean d(int i2) {
        InterceptResult invokeI;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, this, i2)) == null) {
            int c2 = n.c(o.a());
            if (c2 != 4 && c2 != 0) {
                i();
                this.B = true;
                this.C = false;
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
                if (iVar != null && (mVar = this.f30768c) != null) {
                    return iVar.a(i2, mVar.V(), true);
                }
            } else if (c2 == 4) {
                this.B = false;
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.f30766a;
                if (iVar2 != null) {
                    iVar2.q();
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65559, this, i2) == null) && F() && this.f30766a != null) {
            this.m.removeCallbacks(this.J);
            this.f30766a.w();
            long currentTimeMillis = System.currentTimeMillis() - this.n;
            this.o = currentTimeMillis;
            c.a aVar = this.q;
            if (aVar != null) {
                aVar.a(currentTimeMillis, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.r, this.f30769d));
            }
            if (q.d(this.f30768c)) {
                this.f30766a.a(this.f30768c, this.f30767b, true);
            }
            if (!this.x) {
                b();
                this.x = true;
                long j = this.f30769d;
                a(j, j);
                long j2 = this.f30769d;
                this.r = j2;
                this.s = j2;
            }
            this.D = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.r = j;
            long j2 = this.s;
            if (j2 > j) {
                j = j2;
            }
            this.s = j;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.y = z;
            this.f30766a.c(z);
        }
    }

    private void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, runnable) == null) {
            if (this.t == null) {
                this.t = new ArrayList<>();
            }
            this.t.add(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, map) == null) {
            this.f30770e = map;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.E = new WeakReference<>(eVar);
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, runnable) == null) || runnable == null) {
            return;
        }
        if (this.f30766a.k() && this.u) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, bVar, i2) == null) {
            if (this.p != null) {
                E();
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.q = aVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, bVar, view) == null) {
            b(bVar, view, false, false);
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, message) == null) || this.f30766a == null || message == null || (weakReference = this.f30767b) == null || weakReference.get() == null) {
            return;
        }
        int i2 = message.what;
        if (i2 == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.f30769d = ((Long) message.obj).longValue();
        } else if (i2 == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                long longValue = ((Long) obj2).longValue();
                this.r = longValue;
                long j = this.s;
                if (j > longValue) {
                    longValue = j;
                }
                this.s = longValue;
                a(this.r, this.f30769d);
            }
        } else if (i2 == 308) {
            a(308, 0);
        } else if (i2 == 311) {
            if (H()) {
                m mVar = this.f30768c;
                if (mVar != null && mVar.i() == 0) {
                    M();
                    return;
                }
                m mVar2 = this.f30768c;
                if (mVar2 != null && mVar2.i() == 2) {
                    K();
                    return;
                } else {
                    L();
                    return;
                }
            }
            I();
        } else if (i2 != 314) {
            switch (i2) {
                case 302:
                    b(i2);
                    return;
                case 303:
                    a(message.arg1, message.arg2);
                    this.m.removeCallbacks(this.J);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
                    if (iVar != null) {
                        iVar.w();
                    }
                    c.a aVar = this.q;
                    if (aVar != null) {
                        aVar.b(this.o, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.r, this.f30769d));
                        return;
                    }
                    return;
                case 304:
                    int i3 = message.arg1;
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.f30766a;
                    if (iVar2 != null) {
                        if (i3 == 3 || i3 == 702) {
                            this.f30766a.w();
                            this.m.removeCallbacks(this.J);
                            this.G = false;
                        } else if (i3 == 701) {
                            iVar2.t();
                            C();
                            this.G = true;
                        }
                    }
                    if (this.v && i3 == 3 && !this.w) {
                        this.f30772g = SystemClock.elapsedRealtime() - this.f30771f;
                        e();
                        this.w = true;
                        this.f30774i = true;
                        return;
                    }
                    return;
                case 305:
                    w wVar = this.m;
                    if (wVar != null) {
                        wVar.removeCallbacks(this.J);
                    }
                    if (!this.v && !this.w) {
                        this.f30772g = SystemClock.elapsedRealtime() - this.f30771f;
                        g();
                        this.w = true;
                    }
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar3 = this.f30766a;
                    if (iVar3 != null) {
                        iVar3.w();
                        return;
                    }
                    return;
                case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                    this.m.removeCallbacks(this.J);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar4 = this.f30766a;
                    if (iVar4 != null) {
                        iVar4.w();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.f30771f = SystemClock.elapsedRealtime();
        }
    }

    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{bVar, view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && F()) {
            f(!this.L);
            if (!(this.f30767b.get() instanceof Activity)) {
                k.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.L) {
                a(z ? 8 : 0);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
                if (iVar != null) {
                    iVar.a(this.l);
                    this.f30766a.b(false);
                }
            } else {
                a(1);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.f30766a;
                if (iVar2 != null) {
                    iVar2.b(this.l);
                    this.f30766a.b(false);
                }
            }
            WeakReference<e> weakReference = this.E;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, bVar, surfaceHolder) == null) {
            this.u = false;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, bVar, surfaceTexture) == null) {
            this.u = false;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        int c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, this, context) == null) && F() && this.O != (c2 = n.c(context))) {
            if (!this.C) {
                d(2);
            }
            this.O = c2;
        }
    }

    private void a(float f2, float f3, float f4, float f5, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(z)}) == null) {
            try {
                k.b("changeVideoSize", "screenWidth=" + f2 + ",screenHeight=" + f3);
                k.b("changeVideoSize", "videoHeight=" + f5 + ",videoWidth=" + f4);
                if (f4 <= 0.0f || f5 <= 0.0f) {
                    f4 = this.f30768c.V().c();
                    f5 = this.f30768c.V().b();
                }
                if (f5 > 0.0f && f4 > 0.0f) {
                    if (z) {
                        if (f4 < f5) {
                            return;
                        }
                        k.b("changeVideoSize", "竖屏模式下按视频宽度计算放大倍数值");
                        layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) ((f5 * f2) / f4));
                        layoutParams.addRule(13);
                    } else if (f4 > f5) {
                        return;
                    } else {
                        k.b("changeVideoSize", "横屏模式下按视频高度计算放大倍数值");
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) ((f4 * f3) / f5), (int) f3);
                        layoutParams2.addRule(13);
                        layoutParams = layoutParams2;
                    }
                    if (N() != null) {
                        if (N() instanceof TextureView) {
                            ((TextureView) N()).setLayoutParams(layoutParams);
                        } else if (N() instanceof SurfaceView) {
                            ((SurfaceView) N()).setLayoutParams(layoutParams);
                        }
                    }
                }
            } catch (Throwable th) {
                k.a("changeVideoSize", "changeSize error", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, bVar, view) == null) && this.p != null && F()) {
            if (this.p.g()) {
                i();
                this.f30766a.b(true, false);
                this.f30766a.c();
            } else if (!this.p.i()) {
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
                if (iVar != null) {
                    iVar.c(this.l);
                }
                d(this.r);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.f30766a;
                if (iVar2 != null) {
                    iVar2.b(false, false);
                }
            } else {
                k();
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar3 = this.f30766a;
                if (iVar3 != null) {
                    iVar3.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, bVar, i2) == null) || this.p == null) {
            return;
        }
        D();
        a(this.M, c(i2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{bVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && F()) {
            long l = (((float) (i2 * this.f30769d)) * 1.0f) / t.l(this.f30767b.get(), "tt_video_progress_max");
            if (this.f30769d > 0) {
                this.M = (int) l;
            } else {
                this.M = 0L;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.f30766a;
            if (iVar != null) {
                iVar.a(this.M);
            }
        }
    }

    private void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.r = j;
            this.f30769d = j2;
            this.f30766a.a(j, j2);
            this.f30766a.a(com.bytedance.sdk.openadsdk.core.video.d.a.a(j, j2));
            try {
                if (this.q != null) {
                    this.q.a(j, j2);
                }
            } catch (Throwable th) {
                k.c("BaseVideoController", "onProgressUpdate error: ", th);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && F()) {
            boolean z = i2 == 0 || i2 == 8;
            Context context = this.f30767b.get();
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
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{bVar, view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.y) {
                i();
            }
            if (z && !this.y && !A()) {
                this.f30766a.b(!B(), false);
                this.f30766a.a(z2, true, false);
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar != null && dVar.g()) {
                this.f30766a.c();
                this.f30766a.b();
                return;
            }
            this.f30766a.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bVar, surfaceHolder) == null) {
            this.u = true;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar == null) {
                return;
            }
            if (dVar != null) {
                dVar.a(true);
            }
            this.p.a(surfaceHolder);
            G();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bVar, surfaceTexture) == null) {
            this.u = true;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.p;
            if (dVar == null) {
                return;
            }
            if (dVar != null) {
                dVar.a(true);
            }
            this.p.a(surfaceTexture);
            G();
        }
    }

    private void a(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.p == null) {
            return;
        }
        if (z) {
            O();
        }
        this.p.a(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(i.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, aVar, str) == null) {
            int i2 = AnonymousClass6.f30780a[aVar.ordinal()];
            if (i2 == 1) {
                i();
            } else if (i2 == 2) {
                a(true, 3);
            } else if (i2 != 3) {
            } else {
                k();
                this.B = false;
                this.C = true;
            }
        }
    }
}
