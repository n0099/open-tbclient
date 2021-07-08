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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.u;
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
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.video.b.b;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.j.e;
import com.bytedance.sdk.openadsdk.r.o;
import com.bytedance.sdk.openadsdk.r.q;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class TTBaseVideoActivity extends Activity implements u.a, b {
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
    public final a.InterfaceC0329a J;
    public DownloadListener K;

    /* renamed from: a  reason: collision with root package name */
    public final String f29082a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29083b;

    /* renamed from: c  reason: collision with root package name */
    public m f29084c;

    /* renamed from: d  reason: collision with root package name */
    public int f29085d;

    /* renamed from: e  reason: collision with root package name */
    public String f29086e;

    /* renamed from: f  reason: collision with root package name */
    public String f29087f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f29088g;

    /* renamed from: h  reason: collision with root package name */
    public TTAdDislike f29089h;

    /* renamed from: i  reason: collision with root package name */
    public c f29090i;
    public com.bytedance.sdk.openadsdk.component.reward.view.a j;
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
    public final u w;
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
        this.f29082a = x() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.f29090i = new c(this);
        this.j = new com.bytedance.sdk.openadsdk.component.reward.view.a(this);
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
        this.w = new u(Looper.getMainLooper(), this);
        this.y = false;
        this.G = 1;
        this.J = new a.InterfaceC0329a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTBaseVideoActivity f29091a;

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
                this.f29091a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.InterfaceC0329a
            public void a(String str, JSONObject jSONObject) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
                    this.f29091a.a(str, jSONObject);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.InterfaceC0329a
            public void a(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f29091a.a(view);
                }
            }
        };
        this.C = new e(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTBaseVideoActivity f29102a;

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
                this.f29102a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.j.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f29102a.o();
                }
            }
        };
        this.K = new DownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTBaseVideoActivity f29103a;

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
                this.f29103a = this;
            }

            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                    this.f29103a.m.a(str);
                    this.f29103a.B();
                }
            }
        };
    }

    private void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            j.b("TTBaseVideoActivity", "initAdType start");
            if (x()) {
                return;
            }
            com.bytedance.sdk.openadsdk.component.reward.c.a a2 = com.bytedance.sdk.openadsdk.component.reward.c.b.a(this, this.f29084c, this.H, this.I, this.G, this.F);
            this.z = a2;
            if (a2 != null) {
                j.b("TTBaseVideoActivity", "initAdType end, type : " + this.z.getClass().getSimpleName());
                this.z.a(this.k, this.n, this.l);
                this.z.a(this.f29090i);
                this.z.a(this.D);
                this.z.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f29084c.ap() == 15 || this.f29084c.ap() == 5 : invokeV.booleanValue;
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
                if (!TextUtils.isEmpty(this.f29087f)) {
                    hashMap.put("rit_scene", this.f29087f);
                }
                com.bytedance.sdk.openadsdk.e.d.a(this.f29083b, this.f29084c, this.f29082a, hashMap);
                A();
                return;
            }
            j.b("TTBaseVideoActivity", "bindVideoAd start");
            boolean a2 = a(this.n.e(), false);
            if (!y()) {
                this.n.y();
            }
            if (a2) {
                return;
            }
            a(false);
            this.n.a(1);
        }
    }

    private boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            m mVar = this.f29084c;
            return mVar == null || mVar.A() != 1;
        }
        return invokeV.booleanValue;
    }

    private void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.bytedance.sdk.openadsdk.e.d.a(this.f29084c, this);
            this.f29085d = o.d(this.f29084c.ao());
            this.u = com.bytedance.sdk.openadsdk.core.o.h().c(this.f29085d);
            this.F = this.f29084c.aJ();
            this.G = this.f29084c.aI();
        }
    }

    private float H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? q.c(this.f29083b, q.h(this.f29083b)) : invokeV.floatValue;
    }

    private float I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? q.c(this.f29083b, q.i(this.f29083b)) : invokeV.floatValue;
    }

    private float[] J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int c2 = q.c(this, q.j(this));
            float H = H();
            float I = I();
            if ((this.G == 1) != (H > I)) {
                float f2 = H + I;
                I = f2 - I;
                H = f2 - I;
            }
            if (this.G == 1) {
                H -= c2;
            } else {
                I -= c2;
            }
            return new float[]{I, H};
        }
        return (float[]) invokeV.objValue;
    }

    private String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.n.a() ? "video_player" : com.bytedance.sdk.openadsdk.core.e.o.a(this.f29084c) ? this.o.n() : "endcard" : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        w jsObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
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
                setTheme(r.g(this, "tt_full_screen_interaction"));
                q.d((Activity) this);
            }
            setContentView(this.f29090i.a(this.f29084c));
            k();
            h();
            this.f29090i.a(this.f29084c, this.f29082a, this.G, x(), f());
            c cVar = this.f29090i;
            com.bytedance.sdk.openadsdk.core.b.e eVar = this.D;
            cVar.a(eVar, eVar, this.E);
            this.k.a();
            this.k.a(this.f29084c.aM());
            this.k.b(this.u);
            z();
            this.j.a(this.f29084c, f(), this.G);
            this.j.a(this.D);
            this.l.a(this.k, this.f29084c, this.f29082a, this.G, this.H, this.I, this.F, x(), this.f29087f);
            this.l.a(this.B, this.C, this.K);
            this.o.a(this.l, this.f29084c, this.f29082a, this.k);
            if (com.bytedance.sdk.openadsdk.core.e.o.a(this.f29084c)) {
                this.o.a(this.D);
                if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c)) {
                    this.f29090i.d();
                }
            }
            this.v = (int) this.n.z();
            if (this.m.c()) {
                this.D.a(this.m.b());
                this.m.a(this.J);
            }
            this.m.a(new a.b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29110a;

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
                    this.f29110a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        if (z) {
                            this.f29110a.l.a(1, 0);
                        }
                        this.f29110a.a("点击开始下载");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void b(boolean z, long j, long j2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
                        if (z) {
                            this.f29110a.l.a(j2, j, 4);
                        }
                        this.f29110a.a("下载失败");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z, long j, long j2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
                        if (z) {
                            this.f29110a.l.a(j2, j, 2);
                        }
                        this.f29110a.a("下载暂停");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z, long j, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, str2}) == null) {
                        if (z) {
                            this.f29110a.l.a(5, 100);
                        }
                        this.f29110a.a("点击安装");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.b.a.b
                public void a(boolean z, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                        if (z) {
                            this.f29110a.l.a(6, 100);
                        }
                        this.f29110a.a("点击打开");
                    }
                }
            });
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            m mVar = this.f29084c;
            if (mVar == null) {
                return "立即下载";
            }
            if (TextUtils.isEmpty(mVar.aj())) {
                return this.f29084c.X() != 4 ? "查看详情" : "立即下载";
            }
            return this.f29084c.aj();
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            j.b("TTBaseVideoActivity", "startBindAd");
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c)) {
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
                    aVar.a(this.f29090i.e());
                }
                E();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            com.bytedance.sdk.openadsdk.core.b.e eVar = new com.bytedance.sdk.openadsdk.core.b.e(this, this, this.f29084c, this.f29082a, x() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29111a;

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
                    this.f29111a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.e
                public void b(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        j.b("TTBaseVideoActivity", "onRewardBarClick");
                        this.f29111a.a(view, i2, i3, i4, i5);
                        TTBaseVideoActivity tTBaseVideoActivity = this.f29111a;
                        tTBaseVideoActivity.m.a(view, tTBaseVideoActivity.J);
                        if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29111a.f29084c) && view.getId() == r.e(this.f29111a, "tt_playable_play")) {
                            this.f29111a.o.l();
                        }
                    }
                }
            };
            this.D = eVar;
            eVar.a(this.f29090i.a());
            if (!TextUtils.isEmpty(this.f29087f)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.f29087f);
                this.D.a(hashMap);
            }
            this.E = new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29112a;

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
                    this.f29112a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        try {
                            this.f29112a.a(view);
                        } catch (Exception e2) {
                            j.f("TTBaseVideoActivity", "onClickReport error :" + e2.getMessage());
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
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c)) {
                this.o.a(hashMap);
            }
            Context context = this.f29083b;
            m mVar = this.f29084c;
            String str = this.f29082a;
            if (x()) {
                hashMap = null;
            }
            com.bytedance.sdk.openadsdk.e.d.g(context, mVar, str, "click_close", hashMap);
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
            float I = I();
            float H = H();
            if (this.G == 2) {
                min = Math.max(I, H);
                max = Math.min(I, H);
            } else {
                min = Math.min(I, H);
                max = Math.max(I, H);
            }
            Context context = this.f29083b;
            int c2 = q.c(context, q.j(context));
            if (this.G != 2) {
                if (q.b((Activity) this)) {
                    max -= c2;
                }
            } else if (q.b((Activity) this)) {
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
            getWindow().getDecorView().setPadding(q.d(this, f6), q.d(this, f8), q.d(this, f7), q.d(this, f9));
            j.b("TTBaseVideoActivity", "initScreenOrientationAndSize , orientation: " + this.G + "; aspectRatio: " + this.F + "; width: " + min + "; height: " + max);
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
            q.a((Activity) this);
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29094a;

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
                    this.f29094a = this;
                }

                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) && i2 == 0) {
                        try {
                            if (this.f29094a.isFinishing()) {
                                return;
                            }
                            this.f29094a.getWindow().getDecorView().postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f29095a;

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
                                    this.f29095a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        q.a((Activity) this.f29095a.f29094a);
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
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && m.c(this.f29084c)) {
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
                com.bytedance.sdk.openadsdk.core.o.a(this);
            } catch (Throwable unused) {
            }
            if (bundle != null && bundle.getLong("video_current") > 0) {
                this.n.a(bundle.getLong("video_current", 0L));
            }
            this.f29083b = this;
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
            j.b("TTBaseVideoActivity", MissionEvent.MESSAGE_DESTROY);
            com.bytedance.sdk.openadsdk.component.reward.view.b bVar = this.p;
            if (bVar != null) {
                bVar.f();
            }
            TTAdDislike tTAdDislike = this.f29089h;
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
                    j.c("TTBaseVideoActivity", "remove from ITTAppDownloadListener throw Exception : ", th);
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
            j.b("TTBaseVideoActivity", MissionEvent.MESSAGE_PAUSE);
            if (!u()) {
                this.n.g();
            }
            this.m.e();
            this.o.d();
            this.l.c();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c)) {
                this.w.removeMessages(600);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            j.b("TTBaseVideoActivity", MissionEvent.MESSAGE_RESUME);
            if (this.q.get()) {
                this.k.a(this.f29084c.aM());
            }
            this.l.b();
            this.n.b(this.q.get() || u(), this);
            this.m.d();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c)) {
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
                bundle.putString("material_meta", this.f29084c != null ? this.f29084c.aO().toString() : null);
                bundle.putString("multi_process_meta_md5", this.f29086e);
                bundle.putString("video_cache_url", this.n.w());
                bundle.putLong("video_current", this.n.o());
                bundle.putBoolean("is_mute", this.u);
                bundle.putString("rit_scene", this.f29087f);
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
            j.b("TTBaseVideoActivity", MissionEvent.MESSAGE_STOP);
            this.l.k();
            this.l.d();
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c)) {
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
            j.b("TTBaseVideoActivity", "initExpressView");
            float[] fArr = {this.H, this.I};
            if (fArr[0] < 10.0f || fArr[1] < 10.0f) {
                j.b("TTBaseVideoActivity", "get root view size error, so run backup");
                fArr = J();
            }
            this.p.a(this.f29084c, new AdSlot.Builder().setCodeId(String.valueOf(o.d(this.f29084c.ao()))).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.f29082a);
            this.p.a(new g(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29104a;

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
                    this.f29104a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        TTBaseVideoActivity tTBaseVideoActivity = this.f29104a;
                        if (tTBaseVideoActivity.u != z) {
                            tTBaseVideoActivity.k.d();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f29104a.k.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public long c() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        j.f("TTBaseVideoActivity", "onGetCurrentPlayTime mVideoCurrent:" + this.f29104a.n.A());
                        return this.f29104a.n.A();
                    }
                    return invokeV.longValue;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public int d() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        if (this.f29104a.p.c()) {
                            return 4;
                        }
                        if (this.f29104a.p.d()) {
                            return 5;
                        }
                        if (this.f29104a.n.c()) {
                            return 1;
                        }
                        if (this.f29104a.n.a()) {
                            return 2;
                        }
                        if (this.f29104a.n.b()) {
                        }
                        return 3;
                    }
                    return invokeV.intValue;
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                        this.f29104a.v();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        this.f29104a.L();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29104a.k.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        boolean z = false;
                        if (i2 != 1) {
                            if (i2 == 2) {
                                this.f29104a.n.x();
                                return;
                            } else if (i2 == 3) {
                                TTBaseVideoActivity tTBaseVideoActivity = this.f29104a;
                                tTBaseVideoActivity.n.a((tTBaseVideoActivity.q.get() || this.f29104a.u()) ? true : true, this.f29104a);
                                return;
                            } else if (i2 == 4) {
                                this.f29104a.n.h();
                                return;
                            } else if (i2 != 5) {
                                return;
                            }
                        }
                        if (this.f29104a.n.a() || this.f29104a.n.b()) {
                            return;
                        }
                        this.f29104a.a(0L, false);
                    }
                }
            });
            this.p.a(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29105a;

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
                    this.f29105a = this;
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
                        this.f29105a.l.a();
                        j.b("TTBaseVideoActivity", "onRenderFail、、、code:" + i2);
                        this.f29105a.p.e().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f29106a;

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
                                this.f29106a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f29106a.f29105a.a(false);
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f2, float f3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || com.bytedance.sdk.openadsdk.core.e.o.j(this.f29105a.f29084c)) {
                        return;
                    }
                    if (this.f29105a.p.h()) {
                        this.f29105a.b(true);
                    }
                    this.f29105a.d(8);
                    this.f29105a.l.a();
                    if (this.f29105a.p.h()) {
                        TTBaseVideoActivity tTBaseVideoActivity = this.f29105a;
                        if (tTBaseVideoActivity.z != null) {
                            tTBaseVideoActivity.p.b().setBackgroundColor(-16777216);
                            TTBaseVideoActivity tTBaseVideoActivity2 = this.f29105a;
                            com.bytedance.sdk.openadsdk.component.reward.c.a aVar = tTBaseVideoActivity2.z;
                            if (aVar != null) {
                                aVar.a(tTBaseVideoActivity2.f29090i.e());
                            }
                            this.f29105a.E();
                        }
                    }
                    if (this.f29105a.f29084c.V() != null && this.f29105a.D()) {
                        this.f29105a.A = true;
                    }
                    this.f29105a.E();
                }
            });
            Context context = this.f29083b;
            m mVar = this.f29084c;
            String str = this.f29082a;
            com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(this, context, mVar, str, o.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29107a;

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
                    this.f29107a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b, com.bytedance.sdk.openadsdk.core.b.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        super.a(view, i2, i3, i4, i5);
                        this.f29107a.a(view, i2, i3, i4, i5);
                    }
                }
            };
            if (!TextUtils.isEmpty(this.f29087f)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.f29087f);
                eVar.a(hashMap);
            }
            Context context2 = this.f29083b;
            m mVar2 = this.f29084c;
            String str2 = this.f29082a;
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this, context2, mVar2, str2, o.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29108a;

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
                    this.f29108a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.a, com.bytedance.sdk.openadsdk.core.b.b, com.bytedance.sdk.openadsdk.core.b.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        super.a(view, i2, i3, i4, i5);
                        this.f29108a.a(view, i2, i3, i4, i5);
                    }
                }
            };
            if (!TextUtils.isEmpty(this.f29087f)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rit_scene", this.f29087f);
                dVar.a(hashMap2);
            }
            this.p.a(eVar, dVar, this.j);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.f29090i.e().addView(this.p.a(), layoutParams);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? com.bytedance.sdk.openadsdk.core.o.h().j(String.valueOf(this.f29085d)) != 1 : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            TTAdDislike tTAdDislike = this.f29089h;
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
        if (this.f29089h == null) {
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = new com.bytedance.sdk.openadsdk.dislike.ui.a(this, this.f29084c.aG(), this.f29082a, true);
            this.f29089h = aVar;
            aVar.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29109a;

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
                    this.f29109a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f29109a.n.b()) {
                        this.f29109a.n.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i2, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) && this.f29109a.n.b()) {
                        this.f29109a.n.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f29109a.n.a()) {
                        this.f29109a.n.l();
                    }
                }
            });
        }
        this.f29089h.setDislikeSource(K());
        this.f29089h.showDislikeDialog();
    }

    public boolean w() {
        InterceptResult invokeV;
        w jsObject;
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
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f29087f)) {
                hashMap.put("rit_scene", this.f29087f);
            }
            hashMap.put("play_type", Integer.valueOf(this.n.f()));
            this.n.j();
            this.n.a("feed_break", hashMap);
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
        if (!(interceptable == null || interceptable.invokeL(65553, this, view) == null) || F() || this.f29084c == null || view == null) {
            return;
        }
        if (view.getId() == r.e(this, "tt_rb_score") || view.getId() == r.e(this, "tt_comment_vertical") || view.getId() == r.e(this, "tt_reward_ad_appname") || view.getId() == r.e(this, "tt_reward_ad_icon") || view.getId() == r.e(this, "tt_video_reward_bar") || view.getId() == r.e(this, "tt_click_lower_non_content_layout") || view.getId() == r.e(this, "tt_click_upper_non_content_layout") || view.getId() == r.e(this, "tt_reward_ad_download") || view.getId() == r.e(this, "tt_video_reward_container") || view.getId() == r.e(this, "tt_reward_ad_download_backup")) {
            if (TextUtils.isEmpty(this.f29087f)) {
                hashMap = null;
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("rit_scene", this.f29087f);
                hashMap = hashMap2;
            }
            com.bytedance.sdk.openadsdk.e.d.a(this.f29083b, "click_other", this.f29084c, new f.a().e(0).d(0).c(0).b(0).b(System.currentTimeMillis()).a(0L).b(q.a(this.f29090i.a())).a(q.a((View) null)).c(q.c(this.f29090i.a())).d(q.c((View) null)).f(1).g(-1).h(0).a((SparseArray<c.a>) null).a(h.d().b() ? 1 : 2).a(), this.f29082a, true, (Map<String, Object>) hashMap);
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
                        this.f29084c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        j.c("TTBaseVideoActivity", "initData MultiGlobalInfo throws ", e2);
                    }
                }
            } else {
                this.f29084c = t.a().c();
            }
            this.m.a(this.f29084c, this.f29082a);
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                t.a().g();
            }
            if (bundle != null) {
                try {
                    this.f29084c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(bundle.getString("material_meta")));
                    this.r.set(bundle.getBoolean("has_show_skip_btn"));
                    if (this.r.get()) {
                        this.k.d(true);
                        this.k.a(null, getString(r.b(this.f29083b, "tt_reward_screen_skip_tx")));
                        this.k.f(true);
                    }
                } catch (Throwable unused) {
                }
                this.m.a();
            }
            com.bytedance.sdk.openadsdk.core.d.a().a(this.f29084c);
            if (this.f29084c == null) {
                j.f("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
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
            j.b("TTBaseVideoActivity", "startVideoPlayFinishPage : " + t());
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
            if (this.f29088g == null) {
                this.f29088g = new ProgressBar(this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
                layoutParams.gravity = 17;
                this.f29088g.setLayoutParams(layoutParams);
                this.f29088g.setIndeterminateDrawable(getResources().getDrawable(r.d(this, "tt_video_loading_progress_bar")));
                this.f29090i.e().addView(this.f29088g);
            }
            this.f29088g.setVisibility(i2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            j.b("TTBaseVideoActivity", "showEndCard start");
            if ((Build.VERSION.SDK_INT >= 17 && isDestroyed()) || isFinishing() || this.q.getAndSet(true)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.e.o.a(this.f29084c)) {
                this.o.b();
            }
            j.b("TTBaseVideoActivity", "showEndCard execute");
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c)) {
                return;
            }
            TTAdDislike tTAdDislike = this.f29089h;
            if (tTAdDislike != null) {
                tTAdDislike.resetDislikeStatus();
            }
            com.bytedance.sdk.openadsdk.core.widget.d dVar = this.x;
            if (dVar != null && dVar.isShowing()) {
                this.x.dismiss();
            }
            this.l.j();
            this.o.a(this.u);
            if (y() && com.bytedance.sdk.openadsdk.core.e.o.a(this.f29084c)) {
                this.k.c(true);
                if (z) {
                    this.k.d(true);
                }
            }
            if (this.l.q()) {
                if (!m.d(this.f29084c) && !com.bytedance.sdk.openadsdk.core.e.o.a(this.f29084c)) {
                    j.b("TTBaseVideoActivity", "TimeTrackLog report Success from Android");
                    this.l.a(true, 0, (String) null);
                }
                this.f29090i.a(8);
                this.l.n();
                this.w.sendEmptyMessageDelayed(500, 100L);
                return;
            }
            j.b("TTBaseVideoActivity", "showEndCard isEndCardLoadSuc=" + this.l.r() + " so load back up end card");
            if (!m.d(this.f29084c)) {
                j.b("TTBaseVideoActivity", "TimeTrackLog report 408 from backup page");
                this.l.a(false, 408, "end_card_timeout");
            }
            this.l.m();
            this.l.o();
            this.l.G();
            this.j.a();
            this.k.e(true);
            this.k.c(false);
            this.k.d(false);
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
            this.k.a(this.f29084c.aM());
            if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29084c) || D()) {
                this.k.c(true);
            }
            if (!D() && (!(this.z instanceof com.bytedance.sdk.openadsdk.component.reward.c.c) || !y())) {
                this.k.e(true);
            } else {
                this.k.d(true);
            }
        }
        if (z) {
            if (!x() && (this.F != FullRewardExpressView.f29586c || !D())) {
                this.f29090i.b(8);
                this.f29090i.a(8);
                return;
            }
            this.f29090i.b(0);
            this.f29090i.a(0);
            return;
        }
        this.f29090i.b(4);
        this.f29090i.a(8);
    }

    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) || bundle == null) {
            return;
        }
        this.f29086e = bundle.getString("multi_process_meta_md5");
        this.n.a(bundle.getString("video_cache_url"));
        this.u = bundle.getBoolean("is_mute");
        this.f29087f = bundle.getString("rit_scene");
    }

    public boolean a(long j, boolean z, Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), map})) == null) {
            if (this.n.u()) {
                if (!z || !this.n.v()) {
                    Message message = new Message();
                    message.what = 300;
                    this.w.sendMessageDelayed(message, 5000L);
                }
                boolean a2 = this.n.a(j, this.u);
                if (a2 && !z) {
                    j.e("AdEvent", "pangolin ad show " + o.a(this.f29084c, (View) null));
                    com.bytedance.sdk.openadsdk.e.d.a(this.f29083b, this.f29084c, this.f29082a, map);
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
            runOnUiThread(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f29092a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29093b;

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
                    this.f29093b = this;
                    this.f29092a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f29092a)) {
                        return;
                    }
                    this.f29093b.j.a(this.f29092a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == r.e(this, "tt_rb_score")) {
            a("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == r.e(this, "tt_comment_vertical")) {
            a("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == r.e(this, "tt_reward_ad_appname")) {
            a("click_play_source", (JSONObject) null);
        } else if (view.getId() == r.e(this, "tt_reward_ad_icon")) {
            a("click_play_logo", (JSONObject) null);
        } else if (view.getId() != r.e(this, "tt_video_reward_bar") && view.getId() != r.e(this, "tt_click_lower_non_content_layout") && view.getId() != r.e(this, "tt_click_upper_non_content_layout")) {
            if (view.getId() == r.e(this, "tt_reward_ad_download")) {
                a("click_start_play", i());
            } else if (view.getId() == r.e(this, "tt_video_reward_container")) {
                a("click_video", i());
            } else if (view.getId() == r.e(this, "tt_reward_ad_download_backup")) {
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
        if (interceptable == null || interceptable.invokeLL(65552, this, str, jSONObject) == null) {
            Context context = this.f29083b;
            m mVar = this.f29084c;
            String str2 = this.f29082a;
            if (!x()) {
                jSONObject = null;
            }
            com.bytedance.sdk.openadsdk.e.d.a(context, mVar, str2, str, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            j.b("TTBaseVideoActivity", "handleMsg:" + message.what);
            int i2 = message.what;
            if (i2 == 300) {
                this.n.p();
                this.n.j();
                a(false);
                if (x()) {
                    p();
                }
            } else if (i2 == 400) {
                this.n.j();
                a(false);
            } else if (i2 == 500) {
                if (!com.bytedance.sdk.openadsdk.core.e.o.a(this.f29084c)) {
                    this.k.c(false);
                }
                this.l.f();
                this.k.a(1.0f);
                this.n.i();
            } else if (i2 == 600) {
                this.k.e(true);
            } else if (i2 != 700) {
            } else {
                this.l.J();
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
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 700;
            this.w.sendMessageDelayed(obtain, j);
        }
    }

    private void a(String str, long j, long j2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2, str3}) == null) {
            com.bytedance.sdk.component.e.e.c(new com.bytedance.sdk.component.e.g(this, "executeMultiProcessAppDownloadCallBack", str, j, j2, str2, str3) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f29096a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f29097b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f29098c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f29099d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f29100e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ TTBaseVideoActivity f29101f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str, Long.valueOf(j), Long.valueOf(j2), str2, str3};
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
                    this.f29101f = this;
                    this.f29096a = str;
                    this.f29097b = j;
                    this.f29098c = j2;
                    this.f29099d = str2;
                    this.f29100e = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f29101f.b(3).executeAppDownloadCallback(this.f29101f.f29086e, this.f29096a, this.f29097b, this.f29098c, this.f29099d, this.f29100e);
                        } catch (Throwable th) {
                            j.c("TTBaseVideoActivity", "executeAppDownloadCallback execute throw Exception : ", th);
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
        this.f29090i.a(intent.getBooleanExtra("show_download_bar", true));
        this.f29087f = intent.getStringExtra("rit_scene");
        this.n.a(intent.getStringExtra("video_cache_url"));
        this.f29086e = intent.getStringExtra("multi_process_meta_md5");
    }
}
