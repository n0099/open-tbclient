package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.e.p;
import com.bytedance.sdk.openadsdk.j.h;
import com.bytedance.sdk.openadsdk.r.q;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f29261a;

    /* renamed from: b  reason: collision with root package name */
    public m f29262b;

    /* renamed from: c  reason: collision with root package name */
    public String f29263c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29264d;

    /* renamed from: e  reason: collision with root package name */
    public String f29265e;

    /* renamed from: f  reason: collision with root package name */
    public SSWebView f29266f;

    /* renamed from: g  reason: collision with root package name */
    public w f29267g;

    /* renamed from: h  reason: collision with root package name */
    public p f29268h;

    /* renamed from: i  reason: collision with root package name */
    public j f29269i;
    public int j;
    public String k;
    public boolean l;
    public final AtomicBoolean m;
    public int n;
    public int o;
    public int p;
    public float q;
    public com.bytedance.sdk.openadsdk.j.a r;
    public h s;

    public a(Activity activity, m mVar, String str, int i2, int i3, int i4, float f2, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, mVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = "";
        this.l = false;
        this.m = new AtomicBoolean(true);
        this.r = new com.bytedance.sdk.openadsdk.j.a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f29270a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i7 = newInitContext2.flag;
                    if ((i7 & 1) != 0) {
                        int i8 = i7 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f29270a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public int a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    SSWebView sSWebView = this.f29270a.f29266f;
                    int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
                    com.bytedance.sdk.component.utils.j.c("TTAndroidObject", "mWebView>>>>height=" + measuredHeight);
                    return measuredHeight <= 0 ? q.d((Context) this.f29270a.f29261a) : measuredHeight;
                }
                return invokeV.intValue;
            }

            @Override // com.bytedance.sdk.openadsdk.j.a
            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    SSWebView sSWebView = this.f29270a.f29266f;
                    int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
                    com.bytedance.sdk.component.utils.j.c("TTAndroidObject", "mWebView>>>>width=" + measuredWidth);
                    return measuredWidth <= 0 ? q.c((Context) this.f29270a.f29261a) : measuredWidth;
                }
                return invokeV.intValue;
            }
        };
        this.s = new h(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f29271a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i7 = newInitContext2.flag;
                    if ((i7 & 1) != 0) {
                        int i8 = i7 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f29271a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.j.h
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    SSWebView sSWebView = this.f29271a.f29266f;
                    if (sSWebView == null) {
                        com.bytedance.sdk.component.utils.j.b("BaseEndCard", "webView has destroy when onPauseWebView");
                        return;
                    }
                    sSWebView.onPause();
                    com.bytedance.sdk.component.utils.j.b("BaseEndCard", "js make webView onPause OK");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.j.h
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    SSWebView sSWebView = this.f29271a.f29266f;
                    if (sSWebView == null) {
                        com.bytedance.sdk.component.utils.j.b("BaseEndCard", "webView has destroy when onPauseWebViewTimers");
                        return;
                    }
                    sSWebView.pauseTimers();
                    com.bytedance.sdk.component.utils.j.b("BaseEndCard", "js make webView pauseTimers OK");
                }
            }
        };
        this.f29261a = activity;
        this.f29262b = mVar;
        this.f29263c = str;
        this.n = i2;
        this.o = i3;
        this.p = i4;
        this.q = f2;
        this.f29264d = z;
        this.f29265e = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) || this.f29267g == null || this.f29261a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            this.f29267g.a("resize", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || this.f29267g == null || this.f29261a.isFinishing()) {
            return;
        }
        try {
            this.f29267g.b(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                q.a((View) this.f29266f, 0.0f);
            }
            q.a((View) this.f29266f, 0);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            q.a((View) this.f29266f, 8);
        }
    }

    public void f() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (sSWebView = this.f29266f) != null && sSWebView.canGoBack()) {
            this.f29266f.goBack();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f29268h = null;
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SSWebView sSWebView = this.f29266f;
            if (sSWebView != null) {
                sSWebView.onResume();
            }
            w wVar = this.f29267g;
            if (wVar != null) {
                wVar.q();
                SSWebView sSWebView2 = this.f29266f;
                if (sSWebView2 != null) {
                    if (sSWebView2.getVisibility() == 0) {
                        this.f29267g.b(true);
                        a(true);
                        a(false, true);
                    } else {
                        this.f29267g.b(false);
                        a(false);
                        a(true, false);
                    }
                }
            }
            j jVar = this.f29269i;
            if (jVar != null) {
                jVar.c();
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            SSWebView sSWebView = this.f29266f;
            if (sSWebView != null) {
                sSWebView.onPause();
            }
            w wVar = this.f29267g;
            if (wVar != null) {
                wVar.r();
                this.f29267g.b(false);
                a(false);
                a(true, false);
            }
        }
    }

    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (jVar = this.f29269i) == null) {
            return;
        }
        jVar.d();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            SSWebView sSWebView = this.f29266f;
            if (sSWebView != null) {
                sSWebView.destroy();
                aa.a(this.f29261a, this.f29266f);
                aa.a(this.f29266f);
            }
            this.f29266f = null;
            w wVar = this.f29267g;
            if (wVar != null) {
                wVar.s();
            }
            p pVar = this.f29268h;
            if (pVar != null) {
                pVar.a(true);
                this.f29268h.s();
            }
            j jVar = this.f29269i;
            if (jVar != null) {
                jVar.e();
            }
        }
    }

    public void n() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (sSWebView = this.f29266f) == null) {
            return;
        }
        sSWebView.onResume();
        this.f29266f.resumeTimers();
        q.a((View) this.f29266f, 1.0f);
    }

    public void o() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (pVar = this.f29268h) == null) {
            return;
        }
        pVar.m();
    }

    public void p() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (pVar = this.f29268h) == null) {
            return;
        }
        pVar.l();
    }

    public void q() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (pVar = this.f29268h) == null) {
            return;
        }
        pVar.n();
    }

    public void r() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (pVar = this.f29268h) == null) {
            return;
        }
        pVar.o();
    }

    public void s() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (pVar = this.f29268h) == null) {
            return;
        }
        pVar.c();
        this.f29268h.h();
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            w wVar = this.f29267g;
            if (wVar == null) {
                return false;
            }
            return wVar.k();
        }
        return invokeV.booleanValue;
    }

    public void a() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sSWebView = this.f29266f) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f29272a;

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
                this.f29272a = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @RequiresApi(api = 16)
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.f29272a.f29266f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        this.f29272a.f29266f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    int measuredWidth = this.f29272a.f29266f.getMeasuredWidth();
                    int measuredHeight = this.f29272a.f29266f.getMeasuredHeight();
                    if (this.f29272a.f29266f.getVisibility() == 0) {
                        this.f29272a.b(measuredWidth, measuredHeight);
                    }
                }
            }
        });
    }

    public void d() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (jVar = this.f29269i) == null) {
            return;
        }
        jVar.a(System.currentTimeMillis());
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m.get() : invokeV.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.f29267g == null || this.f29261a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.f29267g.a("viewableChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.f29267g == null || this.f29261a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.f29267g.a("volumeChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f29267g == null || this.f29261a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.f29267g.a("endcard_control_event", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f29267g == null || this.f29261a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
            this.f29267g.b("showDownloadStatus", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) || j2 <= 0) {
            return;
        }
        a(i2, (int) ((j * 100) / j2));
    }

    public void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f29261a).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(com.bytedance.sdk.openadsdk.r.h.a(sSWebView, 3613));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.f29266f.setLayerType(0, null);
        }
    }

    public void a(boolean z, int i2, String str) {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || (pVar = this.f29268h) == null) {
            return;
        }
        if (z) {
            pVar.b();
        } else {
            pVar.a(i2, str);
        }
    }
}
