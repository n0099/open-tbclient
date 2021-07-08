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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.i;
import com.bytedance.sdk.openadsdk.core.widget.i;
import com.bytedance.sdk.openadsdk.r.o;
import com.bytedance.sdk.openadsdk.r.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class a implements u.a, c, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public WeakReference<e> D;
    public int E;
    public boolean F;
    public boolean G;
    public com.bytedance.sdk.openadsdk.o.f.b H;
    public final Runnable I;
    public final Runnable J;
    public final Runnable K;
    public boolean L;
    public long M;
    public final BroadcastReceiver N;
    public int O;
    public boolean P;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f30593a;

    /* renamed from: b  reason: collision with root package name */
    public final m f30594b;

    /* renamed from: c  reason: collision with root package name */
    public long f30595c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Object> f30596d;

    /* renamed from: e  reason: collision with root package name */
    public long f30597e;

    /* renamed from: f  reason: collision with root package name */
    public long f30598f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30599g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30600h;

    /* renamed from: i  reason: collision with root package name */
    public long f30601i;
    public i j;
    public final ViewGroup k;
    public final u l;
    public long m;
    public long n;
    public com.bytedance.sdk.openadsdk.core.video.c.d o;
    public c.a p;
    public long q;
    public long r;
    public ArrayList<Runnable> s;
    public boolean t;
    public final boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public long z;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.b.a$6  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30607a;
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
            f30607a = iArr;
            try {
                iArr[i.a.f30913a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30607a[i.a.f30914b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30607a[i.a.f30915c.ordinal()] = 3;
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
        this.l = new u(this);
        this.m = 0L;
        this.n = 0L;
        this.q = 0L;
        this.r = 0L;
        this.v = false;
        this.w = false;
        this.x = true;
        this.y = false;
        this.z = 0L;
        this.A = false;
        this.B = false;
        this.C = false;
        this.f30596d = null;
        this.f30597e = 0L;
        this.f30598f = 0L;
        this.f30599g = false;
        this.f30600h = false;
        this.F = false;
        this.G = true;
        this.I = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30603a;

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
                this.f30603a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30603a.o == null) {
                    return;
                }
                this.f30603a.o.e();
            }
        };
        this.J = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30604a;

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
                this.f30604a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30604a.p == null) {
                    return;
                }
                this.f30604a.p.a();
            }
        };
        this.K = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30605a;

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
                this.f30605a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f30605a.o != null) {
                        a aVar = this.f30605a;
                        if (aVar.f30595c <= 0) {
                            aVar.o.e();
                        }
                        this.f30605a.o.f();
                    }
                    this.f30605a.l.postDelayed(this, 200L);
                }
            }
        };
        this.L = false;
        this.N = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30606a;

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
                this.f30606a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) {
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        this.f30606a.i();
                    } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                        this.f30606a.b(context2);
                    }
                }
            }
        };
        this.O = 1;
        this.P = false;
        this.O = com.bytedance.sdk.component.utils.m.c(context);
        this.k = viewGroup;
        this.f30593a = new WeakReference<>(context);
        this.f30594b = mVar;
        a(context);
        this.E = o.d(this.f30594b.ao());
        this.u = Build.VERSION.SDK_INT >= 17;
    }

    private void D() {
        int J;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int a2 = a();
            if (a2 != 2 && a2 != 1) {
                J = a2 == 3 ? com.bytedance.sdk.openadsdk.core.o.h().f(String.valueOf(this.E)) : 5;
            } else {
                J = com.bytedance.sdk.openadsdk.core.o.h().J() * 1000;
            }
            this.l.removeCallbacks(this.J);
            this.l.postDelayed(this.J, J);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            F();
            this.l.postDelayed(this.K, 800L);
        }
    }

    private void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.l.removeCallbacks(this.K);
        }
    }

    private boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            WeakReference<Context> weakReference = this.f30593a;
            return (weakReference == null || weakReference.get() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void H() {
        ArrayList<Runnable> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (arrayList = this.s) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.s).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.s.clear();
    }

    private boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            m mVar = this.f30594b;
            return mVar == null || mVar.aJ() == 100.0f;
        }
        return invokeV.booleanValue;
    }

    private void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                if (O() != null && this.o != null && this.o.a() != null && this.k != null) {
                    MediaPlayer a2 = this.o.a();
                    int width = this.k.getWidth();
                    int height = this.k.getHeight();
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
                    if (O() instanceof TextureView) {
                        ((TextureView) O()).setLayoutParams(layoutParams);
                    } else if (O() instanceof SurfaceView) {
                        ((SurfaceView) O()).setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable th) {
                j.c("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
            }
        }
    }

    private boolean K() throws Throwable {
        InterceptResult invokeV;
        com.bytedance.sdk.openadsdk.core.video.c.d dVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            WeakReference<Context> weakReference = this.f30593a;
            return weakReference == null || weakReference.get() == null || O() == null || (dVar = this.o) == null || dVar.a() == null || (mVar = this.f30594b) == null || mVar.P() != null || this.f30594b.k() == 1;
        }
        return invokeV.booleanValue;
    }

    private void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            try {
                if (this.f30593a != null && this.f30593a.get() != null && O() != null && this.o != null && this.o.a() != null && this.f30594b != null) {
                    int[] b2 = q.b(com.bytedance.sdk.openadsdk.core.o.a());
                    MediaPlayer a2 = this.o.a();
                    boolean z = this.f30594b.aI() == 1;
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
                    if (O() == null || this.k == null) {
                        return;
                    }
                    if (O() instanceof TextureView) {
                        ((TextureView) O()).setLayoutParams(layoutParams);
                    } else if (O() instanceof SurfaceView) {
                        ((SurfaceView) O()).setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable th) {
                j.c("changeVideoSize", "changeVideoSizeByWidth error", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0126 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:5:0x0008, B:8:0x0029, B:12:0x0049, B:16:0x005f, B:22:0x007b, B:28:0x00f5, B:35:0x0109, B:37:0x0126, B:39:0x0146, B:41:0x0158, B:43:0x0160, B:47:0x017b, B:49:0x0183, B:44:0x016a, B:46:0x0172, B:50:0x018c, B:33:0x0103, B:20:0x006f), top: B:58:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0158 A[Catch: all -> 0x0192, TryCatch #0 {all -> 0x0192, blocks: (B:5:0x0008, B:8:0x0029, B:12:0x0049, B:16:0x005f, B:22:0x007b, B:28:0x00f5, B:35:0x0109, B:37:0x0126, B:39:0x0146, B:41:0x0158, B:43:0x0160, B:47:0x017b, B:49:0x0183, B:44:0x016a, B:46:0x0172, B:50:0x018c, B:33:0x0103, B:20:0x006f), top: B:58:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                j.c("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.f30594b.m());
                if (K()) {
                    return;
                }
                j.c("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
                int[] b2 = q.b(com.bytedance.sdk.openadsdk.core.o.a());
                MediaPlayer a2 = this.o.a();
                boolean z = false;
                boolean z2 = this.f30594b.aI() == 1;
                float f2 = b2[0];
                float f3 = b2[1];
                float videoWidth = a2.getVideoWidth();
                float videoHeight = a2.getVideoHeight();
                if (z2) {
                    if (videoWidth > videoHeight) {
                        j.b("changeVideoSize", "横转竖屏单独适配.....");
                        a(f2, f3, videoWidth, videoHeight, true);
                        return;
                    }
                } else if (videoWidth < videoHeight) {
                    j.b("changeVideoSize", "竖屏转横单独适配.....");
                    a(f2, f3, videoWidth, videoHeight, false);
                    return;
                }
                float f4 = videoWidth / videoHeight;
                float f5 = f2 / f3;
                j.b("changeVideoSize", "screenHeight=" + f3 + ",screenWidth=" + f2);
                j.b("changeVideoSize", "videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                j.b("changeVideoSize", "视频宽高比,videoScale=" + f4 + ",屏幕宽高比.screenScale=" + f5 + ",VERTICAL_SCALE(9:16)=0.5625,HORIZONTAL_SCALE(16:9) =1.7777778");
                if (z2) {
                    if (f5 < 0.5625f && f4 == 0.5625f) {
                        videoWidth = (9.0f * f3) / 16.0f;
                        videoHeight = f3;
                        z = true;
                    }
                    j.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                    if (z) {
                        j.c("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f3 + "，videoWidth=" + f2);
                    } else {
                        f2 = videoWidth;
                        f3 = videoHeight;
                    }
                    int i2 = (int) f2;
                    int i3 = (int) f3;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
                    layoutParams.addRule(13);
                    if (O() != null) {
                        if (O() instanceof TextureView) {
                            ((TextureView) O()).setLayoutParams(layoutParams);
                        } else if (O() instanceof SurfaceView) {
                            ((SurfaceView) O()).setLayoutParams(layoutParams);
                        }
                        ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.height = i3;
                            layoutParams2.width = i2;
                            this.k.setLayoutParams(layoutParams2);
                        }
                    }
                    j.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
                }
                if (f5 > 1.7777778f && f4 == 1.7777778f) {
                    videoHeight = (9.0f * f2) / 16.0f;
                    videoWidth = f2;
                    z = true;
                }
                j.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                if (z) {
                }
                int i22 = (int) f2;
                int i32 = (int) f3;
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i22, i32);
                layoutParams3.addRule(13);
                if (O() != null) {
                }
                j.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
            } catch (Throwable th) {
                j.c("changeVideoSize", "changeSize error", th);
            }
        }
    }

    private void N() {
        int[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                if (this.f30593a != null && this.f30593a.get() != null && O() != null && this.o != null && this.o.a() != null && this.f30594b != null) {
                    boolean z = this.f30594b.aI() == 1;
                    float f2 = q.b(com.bytedance.sdk.openadsdk.core.o.a())[1];
                    MediaPlayer a2 = this.o.a();
                    a(b2[0], f2, a2.getVideoWidth(), a2.getVideoHeight(), z);
                    j.b("changeVideoSize", "changeSize=end");
                }
            } catch (Throwable th) {
                j.a("changeVideoSize", "changeSize error", th);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b O() {
        InterceptResult invokeV;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            WeakReference<Context> weakReference = this.f30593a;
            if (weakReference == null || weakReference.get() == null || (iVar = this.j) == null) {
                return null;
            }
            return iVar.o();
        }
        return (com.bytedance.sdk.openadsdk.core.video.renderview.b) invokeV.objValue;
    }

    private void P() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (iVar = this.j) == null) {
            return;
        }
        iVar.c(0);
        this.j.a(false, false);
        this.j.b(false);
        this.j.b();
        this.j.d();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            return dVar != null && dVar.g();
        }
        return invokeV.booleanValue;
    }

    public Map<String, Object> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            Map<String, Object> map = this.f30596d;
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, Object> a2 = o.a(this.f30598f, this.f30594b, u());
            if (a2 != null) {
                for (Map.Entry<String, Object> entry2 : a2.entrySet()) {
                    hashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, Object> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            Map<String, Object> a2 = o.a(this.f30594b, o(), u());
            if (a2 != null) {
                for (Map.Entry<String, Object> entry : a2.entrySet()) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, Object> map = this.f30596d;
            if (map != null) {
                for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                    hashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public abstract int a();

    public abstract void a(int i2, int i3);

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{bVar, surfaceHolder, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, bVar, view, z) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0345c interfaceC0345c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, interfaceC0345c) == null) {
        }
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
        }
    }

    public abstract void f();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, bVar, view) == null) {
        }
    }

    public abstract void g();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f30601i = p();
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.b();
            }
            if (this.w || !this.v) {
                return;
            }
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (dVar = this.o) == null) {
            return;
        }
        dVar.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.e();
                this.j.q();
                this.j.u();
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.a(false, this.q, !this.y);
                E();
            }
            if (this.w || !this.v) {
                return;
            }
            d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.c();
                this.o = null;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.g();
            }
            u uVar = this.l;
            if (uVar != null) {
                uVar.removeCallbacks(this.J);
                this.l.removeCallbacks(this.I);
                this.l.removeCallbacksAndMessages(null);
                F();
            }
            this.p = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.q : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (u() == null) {
                return 0L;
            }
            return u().n();
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar == null) {
                return 0L;
            }
            return dVar.o() + this.z;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar == null) {
                return 0L;
            }
            return dVar.p() + this.z;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? com.bytedance.sdk.openadsdk.core.video.d.a.a(this.r, this.f30595c) : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f30595c : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.A : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.c.d u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.o : (com.bytedance.sdk.openadsdk.core.video.c.d) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.i v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.j : (com.bytedance.sdk.openadsdk.core.video.nativevideo.i) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.C : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && !this.w && this.v) {
            d();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.o.l() : invokeV.booleanValue;
    }

    private void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65570, this, z) == null) {
            this.L = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.x = z;
            this.j.c(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.f30595c = j;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.C = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, bVar, view) == null) {
            a(bVar, view, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.G = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.b();
                this.j.e();
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.j;
            if (iVar2 != null) {
                iVar2.u();
            }
            d(-1L);
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.y = z;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.b(z);
            }
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            this.q = j;
            long j2 = this.r;
            if (j2 > j) {
                j = j2;
            }
            this.r = j;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.e();
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.a(true, this.q, !this.y);
                E();
            }
        }
    }

    @SuppressLint({"InflateParams"})
    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, context) == null) {
            EnumSet noneOf = EnumSet.noneOf(b.a.class);
            noneOf.add(b.a.f30661a);
            noneOf.add(b.a.f30665e);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = new com.bytedance.sdk.openadsdk.core.video.nativevideo.i(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(r.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.f30594b, this);
            this.j = iVar;
            iVar.a(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.z = j;
        }
    }

    private void b(com.bytedance.sdk.openadsdk.o.f.b bVar) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, this, bVar) == null) || bVar == null) {
            return;
        }
        this.H = bVar;
        if (this.o != null) {
            m mVar = this.f30594b;
            if (mVar != null) {
                x V = mVar.V();
                if (V != null) {
                    bVar.b(V.l());
                }
                bVar.f(String.valueOf(o.d(this.f30594b.ao())));
            }
            bVar.d(1);
            this.o.a(bVar);
        }
        this.m = System.currentTimeMillis();
        if (TextUtils.isEmpty(bVar.a())) {
            return;
        }
        this.j.d(8);
        this.j.d(0);
        a(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f30602a;

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
                this.f30602a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f30602a.m = System.currentTimeMillis();
                    this.f30602a.j.c(0);
                    if (this.f30602a.o == null || this.f30602a.q != 0) {
                        if (this.f30602a.o != null) {
                            this.f30602a.o.a(true, this.f30602a.q, !this.f30602a.y);
                        }
                    } else {
                        this.f30602a.o.a(true, 0L, !this.f30602a.y);
                    }
                    if (this.f30602a.l != null) {
                        this.f30602a.l.postDelayed(this.f30602a.I, 100L);
                    }
                    this.f30602a.E();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, bVar, view) == null) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.g();
            }
            a(true);
        }
    }

    private boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65564, this, i2)) == null) ? this.j.b(i2) : invokeI.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, bVar, view) == null) {
            if (this.L) {
                g(false);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
                if (iVar != null) {
                    iVar.b(this.k);
                }
                a(1);
                return;
            }
            a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(com.bytedance.sdk.openadsdk.o.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            this.H = bVar;
            j.b("BaseVideoController", "video local url " + bVar.a());
            if (TextUtils.isEmpty(bVar.a())) {
                j.f("BaseVideoController", "No video info");
                return false;
            }
            f();
            this.f30599g = !bVar.a().startsWith("http");
            this.y = bVar.h();
            if (bVar.g() > 0) {
                long g2 = bVar.g();
                this.q = g2;
                long j = this.r;
                if (j > g2) {
                    g2 = j;
                }
                this.r = g2;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.e();
                this.j.d();
                this.j.c(bVar.e(), bVar.f());
                this.j.c(this.k);
            }
            if (this.o == null) {
                this.o = new com.bytedance.sdk.openadsdk.core.video.c.d(this.l);
            }
            this.n = 0L;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(65565, this, i2)) == null) {
            int c2 = com.bytedance.sdk.component.utils.m.c(com.bytedance.sdk.openadsdk.core.o.a());
            if (c2 != 4 && c2 != 0) {
                i();
                this.A = true;
                this.B = false;
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
                if (iVar != null && (mVar = this.f30594b) != null) {
                    return iVar.a(i2, mVar.V(), true);
                }
            } else if (c2 == 4) {
                this.A = false;
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.j;
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
        if ((interceptable == null || interceptable.invokeI(65559, this, i2) == null) && G() && this.j != null) {
            this.l.removeCallbacks(this.J);
            this.j.w();
            long currentTimeMillis = System.currentTimeMillis() - this.m;
            this.n = currentTimeMillis;
            c.a aVar = this.p;
            if (aVar != null) {
                aVar.a(currentTimeMillis, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.q, this.f30595c));
            }
            if (o.d(this.f30594b)) {
                this.j.a(this.f30594b, this.f30593a, true);
            }
            if (!this.w) {
                b();
                this.w = true;
                long j = this.f30595c;
                a(j, j);
                long j2 = this.f30595c;
                this.q = j2;
                this.r = j2;
            }
            this.C = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.q = j;
            long j2 = this.r;
            if (j2 > j) {
                j = j2;
            }
            this.r = j;
        }
    }

    private void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, runnable) == null) {
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            this.s.add(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            this.f30596d = map;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.D = new WeakReference<>(eVar);
        }
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, runnable) == null) || runnable == null) {
            return;
        }
        if (this.j.k() && this.t) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, bVar, i2) == null) {
            if (this.o != null) {
                F();
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.p = aVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            l();
        }
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, message) == null) || this.j == null || message == null || (weakReference = this.f30593a) == null || weakReference.get() == null) {
            return;
        }
        int i2 = message.what;
        if (i2 == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.f30595c = ((Long) message.obj).longValue();
        } else if (i2 == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                long longValue = ((Long) obj2).longValue();
                this.q = longValue;
                long j = this.r;
                if (j > longValue) {
                    longValue = j;
                }
                this.r = longValue;
                a(this.q, this.f30595c);
            }
        } else if (i2 == 308) {
            a(308, 0);
        } else if (i2 == 311) {
            if (I()) {
                m mVar = this.f30594b;
                if (mVar != null && mVar.i() == 0) {
                    N();
                    return;
                }
                m mVar2 = this.f30594b;
                if (mVar2 != null && mVar2.i() == 2) {
                    L();
                    return;
                } else {
                    M();
                    return;
                }
            }
            J();
        } else if (i2 != 314) {
            switch (i2) {
                case 302:
                    b(i2);
                    return;
                case 303:
                    a(message.arg1, message.arg2);
                    this.l.removeCallbacks(this.J);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
                    if (iVar != null) {
                        iVar.w();
                    }
                    c.a aVar = this.p;
                    if (aVar != null) {
                        aVar.b(this.n, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.q, this.f30595c));
                        return;
                    }
                    return;
                case 304:
                    int i3 = message.arg1;
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.j;
                    if (iVar2 != null) {
                        if (i3 == 3 || i3 == 702) {
                            this.j.w();
                            this.l.removeCallbacks(this.J);
                            this.F = false;
                        } else if (i3 == 701) {
                            iVar2.t();
                            D();
                            this.F = true;
                        }
                    }
                    if (this.u && i3 == 3 && !this.v) {
                        this.f30598f = SystemClock.elapsedRealtime() - this.f30597e;
                        e();
                        this.v = true;
                        this.f30600h = true;
                        return;
                    }
                    return;
                case 305:
                    u uVar = this.l;
                    if (uVar != null) {
                        uVar.removeCallbacks(this.J);
                    }
                    if (!this.u && !this.v) {
                        this.f30598f = SystemClock.elapsedRealtime() - this.f30597e;
                        g();
                        this.v = true;
                    }
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar3 = this.j;
                    if (iVar3 != null) {
                        iVar3.w();
                        return;
                    }
                    return;
                case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                    this.l.removeCallbacks(this.J);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar4 = this.j;
                    if (iVar4 != null) {
                        iVar4.w();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.f30597e = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, bVar, view) == null) {
            b(bVar, view, false, false);
        }
    }

    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{bVar, view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && G()) {
            g(!this.L);
            if (!(this.f30593a.get() instanceof Activity)) {
                j.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.L) {
                a(z ? 8 : 0);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
                if (iVar != null) {
                    iVar.a(this.k);
                    this.j.b(false);
                }
            } else {
                a(1);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.j;
                if (iVar2 != null) {
                    iVar2.b(this.k);
                    this.j.b(false);
                }
            }
            WeakReference<e> weakReference = this.D;
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
            this.t = false;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, bVar, surfaceTexture) == null) {
            this.t = false;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        int c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, this, context) == null) && G() && this.O != (c2 = com.bytedance.sdk.component.utils.m.c(context))) {
            if (!this.B) {
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
                j.b("changeVideoSize", "screenWidth=" + f2 + ",screenHeight=" + f3);
                j.b("changeVideoSize", "videoHeight=" + f5 + ",videoWidth=" + f4);
                if (f4 <= 0.0f || f5 <= 0.0f) {
                    f4 = this.f30594b.V().c();
                    f5 = this.f30594b.V().b();
                }
                if (f5 > 0.0f && f4 > 0.0f) {
                    if (z) {
                        if (f4 < f5) {
                            return;
                        }
                        j.b("changeVideoSize", "竖屏模式下按视频宽度计算放大倍数值");
                        layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) ((f5 * f2) / f4));
                        layoutParams.addRule(13);
                    } else if (f4 > f5) {
                        return;
                    } else {
                        j.b("changeVideoSize", "横屏模式下按视频高度计算放大倍数值");
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) ((f4 * f3) / f5), (int) f3);
                        layoutParams2.addRule(13);
                        layoutParams = layoutParams2;
                    }
                    if (O() != null) {
                        if (O() instanceof TextureView) {
                            ((TextureView) O()).setLayoutParams(layoutParams);
                        } else if (O() instanceof SurfaceView) {
                            ((SurfaceView) O()).setLayoutParams(layoutParams);
                        }
                    }
                }
            } catch (Throwable th) {
                j.a("changeVideoSize", "changeSize error", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, bVar, view) == null) && this.o != null && G()) {
            if (this.o.g()) {
                i();
                this.j.b(true, false);
                this.j.c();
            } else if (!this.o.i()) {
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
                if (iVar != null) {
                    iVar.c(this.k);
                }
                d(this.q);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar2 = this.j;
                if (iVar2 != null) {
                    iVar2.b(false, false);
                }
            } else {
                k();
                com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar3 = this.j;
                if (iVar3 != null) {
                    iVar3.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, i2) == null) || this.o == null) {
            return;
        }
        E();
        a(this.M, c(i2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{bVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && G()) {
            long l = (((float) (i2 * this.f30595c)) * 1.0f) / r.l(this.f30593a.get(), "tt_video_progress_max");
            if (this.f30595c > 0) {
                this.M = (int) l;
            } else {
                this.M = 0L;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.i iVar = this.j;
            if (iVar != null) {
                iVar.a(this.M);
            }
        }
    }

    private void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.q = j;
            this.f30595c = j2;
            this.j.a(j, j2);
            this.j.a(com.bytedance.sdk.openadsdk.core.video.d.a.a(j, j2));
            try {
                if (this.p != null) {
                    this.p.a(j, j2);
                }
            } catch (Throwable th) {
                j.c("BaseVideoController", "onProgressUpdate error: ", th);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && G()) {
            boolean z = i2 == 0 || i2 == 8;
            Context context = this.f30593a.get();
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
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{bVar, view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.x) {
                i();
            }
            if (z && !this.x && !z()) {
                this.j.b(!A(), false);
                this.j.a(z2, true, false);
            }
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar != null && dVar.g()) {
                this.j.c();
                this.j.b();
                return;
            }
            this.j.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bVar, surfaceHolder) == null) {
            this.t = true;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar == null) {
                return;
            }
            if (dVar != null) {
                dVar.a(true);
            }
            this.o.a(surfaceHolder);
            H();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bVar, surfaceTexture) == null) {
            this.t = true;
            com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.o;
            if (dVar == null) {
                return;
            }
            if (dVar != null) {
                dVar.a(true);
            }
            this.o.a(surfaceTexture);
            H();
        }
    }

    private void a(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) || this.o == null) {
            return;
        }
        if (z) {
            P();
        }
        this.o.a(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(i.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, aVar, str) == null) {
            int i2 = AnonymousClass6.f30607a[aVar.ordinal()];
            if (i2 == 1) {
                i();
            } else if (i2 == 2) {
                a(true);
            } else if (i2 != 3) {
            } else {
                k();
                this.A = false;
                this.B = true;
            }
        }
    }
}
