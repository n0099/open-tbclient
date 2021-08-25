package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.component.reward.b.a;
import com.bytedance.sdk.openadsdk.component.reward.b.d;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.component.reward.view.c;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.e.f;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.b.b;
import com.bytedance.sdk.openadsdk.e.b.o;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.dxmpay.wallet.download.PayDownloadModule;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class TTBaseVideoActivity extends Activity implements w.a, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public e C;
    public com.bytedance.sdk.openadsdk.core.b.e D;
    public View.OnClickListener E;
    public float F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public final a.InterfaceC1895a K;
    public DownloadListener L;

    /* renamed from: a  reason: collision with root package name */
    public final String f65254a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65255b;

    /* renamed from: c  reason: collision with root package name */
    public m f65256c;

    /* renamed from: d  reason: collision with root package name */
    public int f65257d;

    /* renamed from: e  reason: collision with root package name */
    public String f65258e;

    /* renamed from: f  reason: collision with root package name */
    public String f65259f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f65260g;

    /* renamed from: h  reason: collision with root package name */
    public TTAdDislike f65261h;

    /* renamed from: i  reason: collision with root package name */
    public c f65262i;

    /* renamed from: j  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.component.reward.view.a f65263j;
    public com.bytedance.sdk.openadsdk.component.reward.b.c k;
    public com.bytedance.sdk.openadsdk.component.reward.b.e l;
    public a m;
    public d n;
    public com.bytedance.sdk.openadsdk.component.reward.b.b o;
    public com.bytedance.sdk.openadsdk.component.reward.view.b p;
    public final AtomicBoolean q;
    public final AtomicBoolean r;
    public final AtomicBoolean s;
    public IListenerManager t;
    public boolean u;
    public int v;
    public final w w;
    public com.bytedance.sdk.openadsdk.core.widget.d x;
    public boolean y;
    public com.bytedance.sdk.openadsdk.component.reward.c.a z;

    public TTBaseVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65254a = x() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.f65262i = new c(this);
        this.f65263j = new com.bytedance.sdk.openadsdk.component.reward.view.a(this);
        this.k = new com.bytedance.sdk.openadsdk.component.reward.b.c(this);
        this.l = new com.bytedance.sdk.openadsdk.component.reward.b.e(this);
        this.m = new a(this);
        this.n = new d(this);
        this.o = new com.bytedance.sdk.openadsdk.component.reward.b.b(this);
        this.p = new com.bytedance.sdk.openadsdk.component.reward.view.b(this);
        this.q = new AtomicBoolean(false);
        this.r = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.u = false;
        this.w = new w(Looper.getMainLooper(), this);
        this.y = false;
        this.G = 1;
        this.J = true;
        this.K = new a.InterfaceC1895a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTBaseVideoActivity f65264a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65264a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.InterfaceC1895a
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.f65264a.a(str, jSONObject);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.InterfaceC1895a
            public void a(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f65264a.a(view);
                }
            }
        };
        this.C = new e(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTBaseVideoActivity f65277a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65277a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.i.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f65277a.o();
                }
            }
        };
        this.L = new DownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTBaseVideoActivity f65278a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65278a = this;
            }

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                    this.f65278a.m.a(str);
                    this.f65278a.B();
                }
            }
        };
    }

    private void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            k.b("TTBaseVideoActivity", "initAdType start");
            if (x()) {
                return;
            }
            com.bytedance.sdk.openadsdk.component.reward.c.a a2 = com.bytedance.sdk.openadsdk.component.reward.c.b.a(this, this.f65256c, this.H, this.I, this.G, this.F);
            this.z = a2;
            if (a2 != null) {
                k.b("TTBaseVideoActivity", "initAdType end, type : " + this.z.getClass().getSimpleName());
                this.z.a(this.k, this.n, this.l);
                this.z.a(this.f65262i);
                this.z.a(this.D);
                this.z.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f65256c.ap() == 15 || this.f65256c.ap() == 5 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.bytedance.sdk.openadsdk.component.reward.c.a aVar = this.z;
            if (aVar != null && !aVar.c()) {
                HashMap hashMap = new HashMap();
                if (y()) {
                    hashMap.put("dynamic_show_type", Integer.valueOf(this.p.h() ? 1 : 0));
                }
                if (!TextUtils.isEmpty(this.f65259f)) {
                    hashMap.put("rit_scene", this.f65259f);
                }
                com.bytedance.sdk.openadsdk.e.d.a(this.f65255b, this.f65256c, this.f65254a, hashMap);
                A();
                return;
            }
            k.b("TTBaseVideoActivity", "bindVideoAd start");
            boolean a2 = a(this.n.e(), false);
            if (!y()) {
                this.n.A();
            }
            if (a2) {
                return;
            }
            a(false);
            this.n.a(1, 4);
        }
    }

    private boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            m mVar = this.f65256c;
            return mVar == null || mVar.A() != 1;
        }
        return invokeV.booleanValue;
    }

    private void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.bytedance.sdk.openadsdk.e.d.a(this.f65256c, this);
            this.f65257d = q.d(this.f65256c.ao());
            this.u = o.h().c(this.f65257d);
            this.F = this.f65256c.aJ();
            this.G = this.f65256c.aI();
        }
    }

    private void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            try {
                if (this.J && s.b((Activity) this) && this.G == 1 && getResources().getConfiguration().orientation == 1 && Build.VERSION.SDK_INT >= 19) {
                    this.w.post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ TTBaseVideoActivity f65268a;

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
                            this.f65268a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    if (Math.abs(s.g(this.f65268a.f65255b) - this.f65268a.getWindow().getDecorView().getHeight()) == 0) {
                                        View decorView = this.f65268a.getWindow().getDecorView();
                                        if (decorView.isAttachedToWindow()) {
                                            decorView.setPadding(decorView.getPaddingLeft(), decorView.getPaddingTop() + ((int) s.i(this.f65268a.f65255b)), decorView.getPaddingRight(), decorView.getPaddingBottom());
                                        }
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    });
                }
                this.J = false;
            } catch (Exception unused) {
            }
        }
    }

    private float I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? s.c(this.f65255b, s.g(this.f65255b)) : invokeV.floatValue;
    }

    private float J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? s.c(this.f65255b, s.h(this.f65255b)) : invokeV.floatValue;
    }

    private float[] K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int c2 = s.c(this, s.i(this));
            float I = I();
            float J = J();
            if ((this.G == 1) != (I > J)) {
                float f2 = I + J;
                J = f2 - J;
                I = f2 - J;
            }
            if (this.G == 1) {
                I -= c2;
            } else {
                J -= c2;
            }
            return new float[]{J, I};
        }
        return (float[]) invokeV.objValue;
    }

    private String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.n.a() ? "video_player" : com.bytedance.sdk.openadsdk.core.e.o.a(this.f65256c) ? this.o.n() : "endcard" : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        com.bytedance.sdk.openadsdk.core.w jsObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.o.b(this.u);
            if (this.p.a() == null || (jsObject = this.p.a().getJsObject()) == null || isFinishing()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", 1);
                jsObject.a("playableStateChange", jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public abstract void b(String str);

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.F != 100.0f && Build.VERSION.SDK_INT != 26) {
                setTheme(t.g(this, "tt_full_screen_interaction"));
                s.d((Activity) this);
            }
            setContentView(this.f65262i.a(this.f65256c));
            k();
            h();
            this.f65262i.a(this.f65256c, this.f65254a, this.G, x(), f());
            c cVar = this.f65262i;
            com.bytedance.sdk.openadsdk.core.b.e eVar = this.D;
            cVar.a(eVar, eVar, this.E);
            this.k.a();
            this.k.a(this.f65256c.aM());
            this.k.b(this.u);
            z();
            this.f65263j.a(this.f65256c, f(), this.G);
            this.f65263j.a(this.D);
            this.l.a(this.k, this.f65256c, this.f65254a, this.G, this.H, this.I, this.F, x(), this.f65259f);
            this.l.a(this.B, this.C, this.L);
            this.o.a(this.l, this.f65256c, this.f65254a, this.k);
            if (com.bytedance.sdk.openadsdk.core.e.o.a(this.f65256c)) {
                this.o.a(this.D);
                if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c)) {
                    this.f65262i.d();
                }
            }
            this.v = (int) this.n.B();
            if (this.m.c()) {
                this.D.a(this.m.b());
                this.m.a(this.K);
            }
            this.m.a(new a.b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65285a;

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
                    this.f65285a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        if (z) {
                            this.f65285a.l.a(1, 0);
                        }
                        this.f65285a.a("点击开始下载");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void b(boolean z, long j2, long j3, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                        if (z) {
                            this.f65285a.l.a(j3, j2, 4);
                        }
                        this.f65285a.a(PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z, long j2, long j3, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                        if (z) {
                            this.f65285a.l.a(j3, j2, 2);
                        }
                        this.f65285a.a("下载暂停");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z, long j2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), str, str2}) == null) {
                        if (z) {
                            this.f65285a.l.a(5, 100);
                        }
                        this.f65285a.a("点击安装");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                        if (z) {
                            this.f65285a.l.a(6, 100);
                        }
                        this.f65285a.a("点击打开");
                    }
                }
            });
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            m mVar = this.f65256c;
            if (mVar == null) {
                return "立即下载";
            }
            if (TextUtils.isEmpty(mVar.aj())) {
                return this.f65256c.X() != 4 ? "查看详情" : "立即下载";
            }
            return this.f65256c.aj();
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            k.b("TTBaseVideoActivity", "startBindAd");
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c)) {
                this.l.a();
                a(false);
                this.o.h();
            } else if (y()) {
                d(0);
                q();
            } else {
                this.l.a();
                com.bytedance.sdk.openadsdk.component.reward.c.a aVar = this.z;
                if (aVar != null) {
                    aVar.a(this.f65262i.e());
                }
                E();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            com.bytedance.sdk.openadsdk.core.b.e eVar = new com.bytedance.sdk.openadsdk.core.b.e(this, this, this.f65256c, this.f65254a, x() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65286a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this, r12, r13, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, this, r12, r13, Integer.valueOf(r14)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65286a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.e
                public void b(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        k.b("TTBaseVideoActivity", "onRewardBarClick");
                        this.f65286a.a(view, i2, i3, i4, i5);
                        TTBaseVideoActivity tTBaseVideoActivity = this.f65286a;
                        tTBaseVideoActivity.m.a(view, tTBaseVideoActivity.K);
                        if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65286a.f65256c) && view.getId() == t.e(this.f65286a, "tt_playable_play")) {
                            this.f65286a.o.l();
                        }
                    }
                }
            };
            this.D = eVar;
            eVar.a(this.f65262i.a());
            if (!TextUtils.isEmpty(this.f65259f)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.f65259f);
                this.D.a(hashMap);
            }
            this.E = new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65265a;

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
                    this.f65265a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        try {
                            this.f65265a.a(view);
                        } catch (Exception e2) {
                            k.f("TTBaseVideoActivity", "onClickReport error :" + e2.getMessage());
                        }
                    }
                }
            };
        }
    }

    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            try {
                long m = this.n.m();
                int n = this.n.n();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", m);
                    jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, n);
                    return jSONObject;
                } catch (Throwable unused) {
                    return jSONObject;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            HashMap hashMap = new HashMap();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c)) {
                this.o.a(hashMap);
            }
            Context context = this.f65255b;
            m mVar = this.f65256c;
            String str = this.f65254a;
            if (x()) {
                hashMap = null;
            }
            com.bytedance.sdk.openadsdk.e.d.f(context, mVar, str, "click_close", hashMap);
        }
    }

    public void k() {
        float min;
        float max;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int i4 = 0;
            if (this.G == 2) {
                setRequestedOrientation(0);
            } else {
                setRequestedOrientation(1);
            }
            float J = J();
            float I = I();
            if (this.G == 2) {
                min = Math.max(J, I);
                max = Math.min(J, I);
            } else {
                min = Math.min(J, I);
                max = Math.max(J, I);
            }
            Context context = this.f65255b;
            int c2 = s.c(context, s.i(context));
            if (this.G != 2) {
                if (s.b((Activity) this)) {
                    max -= c2;
                }
            } else if (s.b((Activity) this)) {
                min -= c2;
            }
            if (x()) {
                this.H = (int) min;
                this.I = (int) max;
                return;
            }
            int i5 = 20;
            if (this.G != 2) {
                float f2 = this.F;
                if (f2 != 0.0f && f2 != 100.0f) {
                    float f3 = 20;
                    i2 = (int) Math.max((max - (((min - f3) - f3) / f2)) / 2.0f, 0.0f);
                    i3 = i2;
                    i4 = 20;
                }
                i2 = 0;
                i3 = 0;
                i5 = 0;
            } else {
                float f4 = this.F;
                if (f4 != 0.0f && f4 != 100.0f) {
                    float f5 = 20;
                    i4 = (int) Math.max((min - (((max - f5) - f5) * f4)) / 2.0f, 0.0f);
                    i5 = i4;
                    i2 = 20;
                    i3 = 20;
                }
                i2 = 0;
                i3 = 0;
                i5 = 0;
            }
            float f6 = i4;
            float f7 = i5;
            this.H = (int) ((min - f6) - f7);
            float f8 = i2;
            float f9 = i3;
            this.I = (int) ((max - f8) - f9);
            getWindow().getDecorView().setPadding(s.d(this, f6), s.d(this, f8), s.d(this, f7), s.d(this, f9));
            k.b("TTBaseVideoActivity", "initScreenOrientationAndSize , orientation: " + this.G + "; aspectRatio: " + this.F + "; width: " + min + "; height: " + max);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            n();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.w.removeMessages(700);
            this.w.removeMessages(600);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onAttachedToWindow();
            s.a((Activity) this);
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65269a;

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
                    this.f65269a = this;
                }

                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) && i2 == 0) {
                        try {
                            if (this.f65269a.isFinishing()) {
                                return;
                            }
                            this.f65269a.getWindow().getDecorView().postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.13.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass13 f65270a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f65270a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        s.a((Activity) this.f65270a.f65269a);
                                    }
                                }
                            }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && m.c(this.f65256c)) {
            this.l.p();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bundle) == null) {
            super.onCreate(bundle);
            a(getIntent());
            b(bundle);
            try {
                requestWindowFeature(1);
                getWindow().addFlags(1024);
                getWindow().addFlags(16777216);
                o.a(this);
            } catch (Throwable unused) {
            }
            if (bundle != null && bundle.getLong("video_current") > 0) {
                this.n.a(bundle.getLong("video_current", 0L));
            }
            this.f65255b = this;
            if (a(bundle)) {
                G();
                e();
                C();
                g();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDestroy();
            k.b("TTBaseVideoActivity", MissionEvent.MESSAGE_DESTROY);
            com.bytedance.sdk.openadsdk.component.reward.view.b bVar = this.p;
            if (bVar != null) {
                bVar.f();
            }
            TTAdDislike tTAdDislike = this.f65261h;
            if (tTAdDislike != null) {
                tTAdDislike.resetDislikeStatus();
            }
            this.w.removeCallbacksAndMessages(null);
            this.n.c(x());
            this.m.f();
            com.bytedance.sdk.openadsdk.component.reward.c.a aVar = this.z;
            if (aVar != null && !aVar.b() && !this.q.get()) {
                this.l.x();
            }
            this.l.e();
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                try {
                    a("recycleRes", 0L, 0L, "", "");
                } catch (Throwable th) {
                    k.c("TTBaseVideoActivity", "remove from ITTAppDownloadListener throw Exception : ", th);
                }
            }
            this.o.e();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onPause();
            k.b("TTBaseVideoActivity", MissionEvent.MESSAGE_PAUSE);
            if (!u()) {
                this.n.g();
            }
            this.m.e();
            this.o.d();
            this.l.c();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c)) {
                this.w.removeMessages(600);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            k.b("TTBaseVideoActivity", "onResume");
            H();
            if (this.q.get()) {
                this.k.a(this.f65256c.aM());
            }
            this.l.b();
            this.n.b(this.q.get() || u(), this);
            this.m.d();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c)) {
                this.o.a("return_foreground");
                com.bytedance.sdk.openadsdk.core.widget.d dVar = this.x;
                if (dVar == null || !dVar.isShowing()) {
                    this.o.k();
                }
            }
            this.o.c();
            com.bytedance.sdk.openadsdk.component.reward.view.b bVar = this.p;
            if (bVar != null) {
                bVar.g();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putString("material_meta", this.f65256c != null ? this.f65256c.aP().toString() : null);
                bundle.putString("multi_process_meta_md5", this.f65258e);
                bundle.putString("video_cache_url", this.n.y());
                bundle.putLong("video_current", this.n.o());
                bundle.putBoolean("is_mute", this.u);
                bundle.putString("rit_scene", this.f65259f);
                bundle.putBoolean("has_show_skip_btn", this.r.get());
            } catch (Throwable unused) {
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onStart();
            this.l.l();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onStop();
            k.b("TTBaseVideoActivity", MissionEvent.MESSAGE_STOP);
            this.l.k();
            this.l.d();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c)) {
                this.o.j();
                this.w.removeMessages(600);
                this.o.a("go_background");
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            k.b("TTBaseVideoActivity", "initExpressView");
            float[] fArr = {this.H, this.I};
            if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
                k.b("TTBaseVideoActivity", "get root view size error, so run backup");
                fArr = K();
            }
            this.p.a(this.f65256c, new AdSlot.Builder().setCodeId(String.valueOf(q.d(this.f65256c.ao()))).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.f65254a);
            this.p.a(new i(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65279a;

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
                    this.f65279a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        TTBaseVideoActivity tTBaseVideoActivity = this.f65279a;
                        if (tTBaseVideoActivity.u != z) {
                            tTBaseVideoActivity.k.d();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f65279a.k.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public long c() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        k.f("TTBaseVideoActivity", "onGetCurrentPlayTime mVideoCurrent:" + this.f65279a.n.C());
                        return this.f65279a.n.C();
                    }
                    return invokeV.longValue;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public int d() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        if (this.f65279a.p.c()) {
                            return 4;
                        }
                        if (this.f65279a.p.d()) {
                            return 5;
                        }
                        if (this.f65279a.n.c()) {
                            return 1;
                        }
                        if (this.f65279a.n.a()) {
                            return 2;
                        }
                        if (this.f65279a.n.b()) {
                        }
                        return 3;
                    }
                    return invokeV.intValue;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        this.f65279a.v();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        this.f65279a.M();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65279a.k.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        boolean z = false;
                        if (i2 != 1) {
                            if (i2 == 2) {
                                this.f65279a.n.z();
                                return;
                            } else if (i2 == 3) {
                                TTBaseVideoActivity tTBaseVideoActivity = this.f65279a;
                                tTBaseVideoActivity.n.a((tTBaseVideoActivity.q.get() || this.f65279a.u()) ? true : true, this.f65279a);
                                return;
                            } else if (i2 == 4) {
                                this.f65279a.n.h();
                                return;
                            } else if (i2 != 5) {
                                return;
                            }
                        }
                        if (this.f65279a.n.a() || this.f65279a.n.b()) {
                            return;
                        }
                        this.f65279a.a(0L, false);
                    }
                }
            });
            this.p.a(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65280a;

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
                    this.f65280a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
                        this.f65280a.l.a();
                        k.b("TTBaseVideoActivity", "onRenderFail、、、code:" + i2);
                        this.f65280a.p.e().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f65281a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f65281a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f65281a.f65280a.a(false);
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f2, float f3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || com.bytedance.sdk.openadsdk.core.e.o.j(this.f65280a.f65256c)) {
                        return;
                    }
                    if (this.f65280a.p.h()) {
                        this.f65280a.b(true);
                    }
                    this.f65280a.d(8);
                    this.f65280a.l.a();
                    if (this.f65280a.p.h()) {
                        TTBaseVideoActivity tTBaseVideoActivity = this.f65280a;
                        if (tTBaseVideoActivity.z != null) {
                            tTBaseVideoActivity.p.b().setBackgroundColor(-16777216);
                            TTBaseVideoActivity tTBaseVideoActivity2 = this.f65280a;
                            com.bytedance.sdk.openadsdk.component.reward.c.a aVar = tTBaseVideoActivity2.z;
                            if (aVar != null) {
                                aVar.a(tTBaseVideoActivity2.f65262i.e());
                            }
                            this.f65280a.E();
                        }
                    }
                    if (this.f65280a.f65256c.V() != null && this.f65280a.D()) {
                        this.f65280a.A = true;
                    }
                    this.f65280a.E();
                }
            });
            Context context = this.f65255b;
            m mVar = this.f65256c;
            String str = this.f65254a;
            com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(this, context, mVar, str, q.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65282a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context, mVar, str, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, mVar, str, Integer.valueOf(r14)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65282a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b, com.bytedance.sdk.openadsdk.core.b.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        super.a(view, i2, i3, i4, i5);
                        this.f65282a.a(view, i2, i3, i4, i5);
                    }
                }
            };
            if (!TextUtils.isEmpty(this.f65259f)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.f65259f);
                eVar.a(hashMap);
            }
            Context context2 = this.f65255b;
            m mVar2 = this.f65256c;
            String str2 = this.f65254a;
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this, context2, mVar2, str2, q.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65283a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(context2, mVar2, str2, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context2, mVar2, str2, Integer.valueOf(r14)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65283a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.a, com.bytedance.sdk.openadsdk.core.b.b, com.bytedance.sdk.openadsdk.core.b.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        super.a(view, i2, i3, i4, i5);
                        this.f65283a.a(view, i2, i3, i4, i5);
                    }
                }
            };
            if (!TextUtils.isEmpty(this.f65259f)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rit_scene", this.f65259f);
                dVar.a(hashMap2);
            }
            this.p.a(eVar, dVar, this.f65263j);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.f65262i.e().addView(this.p.a(), layoutParams);
            if (!this.p.h()) {
                b(false);
            }
            this.p.j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            Message message = new Message();
            message.what = 400;
            if (x()) {
                p();
            }
            this.w.sendMessageDelayed(message, 2000L);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.w.removeMessages(400);
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? o.h().j(String.valueOf(this.f65257d)) != 1 : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            TTAdDislike tTAdDislike = this.f65261h;
            if (tTAdDislike != null) {
                return tTAdDislike.isShow();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || isFinishing()) {
            return;
        }
        if (this.f65261h == null) {
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = new com.bytedance.sdk.openadsdk.dislike.ui.a(this, this.f65256c.aG(), this.f65254a, true);
            this.f65261h = aVar;
            aVar.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65284a;

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
                    this.f65284a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f65284a.n.b()) {
                        this.f65284a.n.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i2, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) && this.f65284a.n.b()) {
                        this.f65284a.n.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f65284a.n.a()) {
                        this.f65284a.n.l();
                    }
                }
            });
        }
        this.f65261h.setDislikeSource(L());
        this.f65261h.showDislikeDialog();
    }

    public boolean w() {
        InterceptResult invokeV;
        com.bytedance.sdk.openadsdk.core.w jsObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.q.get()) {
                return false;
            }
            boolean o = this.o.o();
            if (this.p.a() != null && (jsObject = this.p.a().getJsObject()) != null && !isFinishing()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("state", 0);
                    jsObject.a("playableStateChange", jSONObject);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return o;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean x();

    public abstract boolean y();

    public abstract void z();

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            v();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.l.i();
            j();
            this.o.a();
            finish();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            o.a aVar = new o.a();
            aVar.a(this.n.o());
            aVar.c(this.n.s());
            aVar.b(this.n.p());
            aVar.e(3);
            aVar.f(this.n.q());
            com.bytedance.sdk.openadsdk.e.a.a.f(this.f65255b, this.n.D(), aVar);
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f65259f)) {
                hashMap.put("rit_scene", this.f65259f);
            }
            hashMap.put("play_type", Integer.valueOf(this.n.f()));
            this.n.j();
            this.n.a(FreeSpaceBox.TYPE, (Map<String, Object>) null);
            this.k.d(false);
            if (x()) {
                b("onSkippedVideo");
            } else {
                b("onSkippedVideo");
            }
            j();
            this.o.a();
            c(true);
        }
    }

    private void b(View view) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, view) == null) || F() || this.f65256c == null || view == null) {
            return;
        }
        if (view.getId() == t.e(this, "tt_rb_score") || view.getId() == t.e(this, "tt_comment_vertical") || view.getId() == t.e(this, "tt_reward_ad_appname") || view.getId() == t.e(this, "tt_reward_ad_icon") || view.getId() == t.e(this, "tt_video_reward_bar") || view.getId() == t.e(this, "tt_click_lower_non_content_layout") || view.getId() == t.e(this, "tt_click_upper_non_content_layout") || view.getId() == t.e(this, "tt_reward_ad_download") || view.getId() == t.e(this, "tt_video_reward_container") || view.getId() == t.e(this, "tt_reward_ad_download_backup")) {
            if (TextUtils.isEmpty(this.f65259f)) {
                hashMap = null;
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rit_scene", this.f65259f);
                hashMap = hashMap2;
            }
            com.bytedance.sdk.openadsdk.e.d.a(this.f65255b, "click_other", this.f65256c, new f.a().e(0).d(0).c(0).b(0).b(System.currentTimeMillis()).a(0L).b(s.a(this.f65262i.a())).a(s.a((View) null)).c(s.c(this.f65262i.a())).d(s.c((View) null)).f(1).g(-1).h(0).a((SparseArray<c.a>) null).a(h.d().b() ? 1 : 2).a(), this.f65254a, true, (Map<String, Object>) hashMap);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.q.get() && !this.o.p()) {
                this.u = !this.u;
                com.bytedance.sdk.openadsdk.component.reward.c.a aVar = this.z;
                if (aVar != null && aVar.a() != null) {
                    this.z.a().a(this.u);
                }
                this.n.b(this.u);
                return;
            }
            this.o.m();
        }
    }

    public IListenerManager c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (this.t == null) {
                this.t = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(i2));
            }
            return this.t;
        }
        return (IListenerManager) invokeI.objValue;
    }

    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        String stringExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle)) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                Intent intent = getIntent();
                if (intent != null && (stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA)) != null) {
                    try {
                        this.f65256c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        k.c("TTBaseVideoActivity", "initData MultiGlobalInfo throws ", e2);
                    }
                }
            } else {
                this.f65256c = com.bytedance.sdk.openadsdk.core.t.a().c();
            }
            this.m.a(this.f65256c, this.f65254a);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.core.t.a().g();
            }
            if (bundle != null) {
                try {
                    this.f65256c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(bundle.getString("material_meta")));
                    this.r.set(bundle.getBoolean("has_show_skip_btn"));
                    if (this.r.get()) {
                        this.k.d(true);
                        this.k.a(null, getString(t.b(this.f65255b, "tt_reward_screen_skip_tx")));
                        this.k.f(true);
                    }
                } catch (Throwable unused) {
                }
                this.m.a();
            }
            com.bytedance.sdk.openadsdk.core.d.a().a(this.f65256c);
            if (this.f65256c == null) {
                k.f("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
                finish();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            k.b("TTBaseVideoActivity", "startVideoPlayFinishPage : " + t());
            com.bytedance.sdk.openadsdk.component.reward.c.a aVar = this.z;
            if ((aVar != null && !aVar.b()) || !t()) {
                finish();
            } else {
                a(z);
            }
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (this.f65260g == null) {
                this.f65260g = new ProgressBar(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
                layoutParams.gravity = 17;
                this.f65260g.setLayoutParams(layoutParams);
                this.f65260g.setIndeterminateDrawable(getResources().getDrawable(t.d(this, "tt_video_loading_progress_bar")));
                this.f65262i.e().addView(this.f65260g);
            }
            this.f65260g.setVisibility(i2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            k.b("TTBaseVideoActivity", "showEndCard start");
            if ((Build.VERSION.SDK_INT >= 17 && isDestroyed()) || isFinishing() || this.q.getAndSet(true)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.e.o.a(this.f65256c)) {
                this.o.b();
            }
            k.b("TTBaseVideoActivity", "showEndCard execute");
            this.o.a(this.u);
            this.l.j();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c)) {
                return;
            }
            TTAdDislike tTAdDislike = this.f65261h;
            if (tTAdDislike != null) {
                tTAdDislike.resetDislikeStatus();
            }
            com.bytedance.sdk.openadsdk.core.widget.d dVar = this.x;
            if (dVar != null && dVar.isShowing()) {
                this.x.dismiss();
            }
            if (y() && com.bytedance.sdk.openadsdk.core.e.o.a(this.f65256c)) {
                this.k.c(true);
                if (z) {
                    this.k.d(true);
                }
            }
            this.f65262i.a(8);
            if (this.l.q()) {
                if (!m.d(this.f65256c) && !com.bytedance.sdk.openadsdk.core.e.o.a(this.f65256c)) {
                    k.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android");
                    this.l.a(true, 0, (String) null);
                }
                this.l.n();
                this.w.sendEmptyMessageDelayed(500, 100L);
                return;
            }
            k.b("TTBaseVideoActivity", "showEndCard isEndCardLoadSuc=" + this.l.r() + " so load back up end card");
            if (!m.d(this.f65256c)) {
                k.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page");
                this.l.a(false, 408, "end_card_timeout");
            }
            this.l.m();
            this.l.o();
            this.l.F();
            this.f65263j.a();
            this.k.e(true);
            this.k.c(false);
            this.k.d(false);
            this.k.a(this.f65256c.aM());
            this.n.i();
        }
    }

    public IListenerManager b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(i2)) : (IListenerManager) invokeI.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.q.get()) {
            return;
        }
        if (!z) {
            this.k.c(false);
            this.k.a(false);
            this.k.d(false);
            this.k.e(false);
        } else {
            this.k.a(this.f65256c.aM());
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65256c) || D()) {
                this.k.c(true);
            }
            if (!D() && (!(this.z instanceof com.bytedance.sdk.openadsdk.component.reward.c.c) || !y())) {
                this.k.e(true);
            } else {
                this.k.d(true);
            }
        }
        if (z) {
            if (!x() && (this.F != FullRewardExpressView.f65772c || !D())) {
                this.f65262i.b(8);
                this.f65262i.a(8);
                return;
            }
            this.f65262i.b(0);
            this.f65262i.a(0);
            return;
        }
        this.f65262i.b(4);
        this.f65262i.a(8);
    }

    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) || bundle == null) {
            return;
        }
        this.f65258e = bundle.getString("multi_process_meta_md5");
        this.n.a(bundle.getString("video_cache_url"));
        this.u = bundle.getBoolean("is_mute");
        this.f65259f = bundle.getString("rit_scene");
    }

    public boolean a(long j2, boolean z, Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), map})) == null) {
            if (this.n.w()) {
                if (!z || !this.n.x()) {
                    Message message = new Message();
                    message.what = 300;
                    this.w.sendMessageDelayed(message, 5000L);
                }
                boolean a2 = this.n.a(j2, this.u);
                if (a2 && !z) {
                    k.e("AdEvent", "pangolin ad show " + q.a(this.f65256c, (View) null));
                    com.bytedance.sdk.openadsdk.e.d.a(this.f65255b, this.f65256c, this.f65254a, map);
                    A();
                }
                return a2;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            runOnUiThread(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65266a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65267b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65267b = this;
                    this.f65266a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f65266a)) {
                        return;
                    }
                    this.f65267b.f65263j.a(this.f65266a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == t.e(this, "tt_rb_score")) {
            a("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == t.e(this, "tt_comment_vertical")) {
            a("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == t.e(this, "tt_reward_ad_appname")) {
            a("click_play_source", (JSONObject) null);
        } else if (view.getId() == t.e(this, "tt_reward_ad_icon")) {
            a("click_play_logo", (JSONObject) null);
        } else if (view.getId() != t.e(this, "tt_video_reward_bar") && view.getId() != t.e(this, "tt_click_lower_non_content_layout") && view.getId() != t.e(this, "tt_click_upper_non_content_layout")) {
            if (view.getId() == t.e(this, "tt_reward_ad_download")) {
                a("click_start_play", i());
            } else if (view.getId() == t.e(this, "tt_video_reward_container")) {
                a("click_video", i());
            } else if (view.getId() == t.e(this, "tt_reward_ad_download_backup")) {
                a("fallback_endcard_click", i());
            }
        } else {
            a("click_start_play_bar", i());
        }
        b(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, this, str, jSONObject) == null) {
            Context context = this.f65255b;
            m mVar = this.f65256c;
            String str2 = this.f65254a;
            if (!x()) {
                jSONObject = null;
            }
            com.bytedance.sdk.openadsdk.e.d.a(context, mVar, str2, str, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            k.b("TTBaseVideoActivity", "handleMsg:" + message.what);
            int i2 = message.what;
            if (i2 == 300) {
                this.n.r();
                this.n.j();
                a(false);
                if (x()) {
                    p();
                }
            } else if (i2 == 400) {
                this.n.j();
                a(false);
            } else if (i2 == 500) {
                if (!com.bytedance.sdk.openadsdk.core.e.o.a(this.f65256c)) {
                    this.k.c(false);
                }
                this.l.f();
                this.k.a(1.0f);
                this.n.i();
            } else if (i2 == 600) {
                this.k.e(true);
            } else if (i2 != 700) {
            } else {
                this.l.I();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 <= 0) {
                this.k.e(true);
            } else {
                this.w.sendEmptyMessageDelayed(600, i2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 700;
            this.w.sendMessageDelayed(obtain, j2);
        }
    }

    private void a(String str, long j2, long j3, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) {
            com.bytedance.sdk.component.d.e.c(new g(this, "executeMultiProcessAppDownloadCallBack", str, j2, j3, str2, str3) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65271a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f65272b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f65273c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f65274d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f65275e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f65276f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str, Long.valueOf(j2), Long.valueOf(j3), str2, str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65276f = this;
                    this.f65271a = str;
                    this.f65272b = j2;
                    this.f65273c = j3;
                    this.f65274d = str2;
                    this.f65275e = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f65276f.b(3).executeAppDownloadCallback(this.f65276f.f65258e, this.f65271a, this.f65272b, this.f65273c, this.f65274d, this.f65275e);
                        } catch (Throwable th) {
                            k.c("TTBaseVideoActivity", "executeAppDownloadCallback execute throw Exception : ", th);
                        }
                    }
                }
            }, 5);
        }
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, intent) == null) || intent == null) {
            return;
        }
        this.f65262i.a(intent.getBooleanExtra("show_download_bar", true));
        this.f65259f = intent.getStringExtra("rit_scene");
        this.n.a(intent.getStringExtra("video_cache_url"));
        this.f65258e = intent.getStringExtra("multi_process_meta_md5");
    }
}
