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
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.e.q;
import com.bytedance.sdk.openadsdk.i.h;
import com.bytedance.sdk.openadsdk.q.i;
import com.bytedance.sdk.openadsdk.q.s;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f65351a;

    /* renamed from: b  reason: collision with root package name */
    public m f65352b;

    /* renamed from: c  reason: collision with root package name */
    public String f65353c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f65354d;

    /* renamed from: e  reason: collision with root package name */
    public String f65355e;

    /* renamed from: f  reason: collision with root package name */
    public SSWebView f65356f;

    /* renamed from: g  reason: collision with root package name */
    public w f65357g;

    /* renamed from: h  reason: collision with root package name */
    public q f65358h;

    /* renamed from: i  reason: collision with root package name */
    public j f65359i;

    /* renamed from: j  reason: collision with root package name */
    public int f65360j;
    public String k;
    public boolean l;
    public final AtomicBoolean m;
    public int n;
    public int o;
    public int p;
    public float q;
    public com.bytedance.sdk.openadsdk.i.a r;
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
        this.f65360j = 0;
        this.k = "";
        this.l = false;
        this.m = new AtomicBoolean(true);
        this.r = new com.bytedance.sdk.openadsdk.i.a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65361a;

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
                this.f65361a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.i.a
            public int a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    SSWebView sSWebView = this.f65361a.f65356f;
                    int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
                    k.c("TTAndroidObject", "mWebView>>>>height=" + measuredHeight);
                    return measuredHeight <= 0 ? s.d((Context) this.f65361a.f65351a) : measuredHeight;
                }
                return invokeV.intValue;
            }

            @Override // com.bytedance.sdk.openadsdk.i.a
            public int b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    SSWebView sSWebView = this.f65361a.f65356f;
                    int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
                    k.c("TTAndroidObject", "mWebView>>>>width=" + measuredWidth);
                    return measuredWidth <= 0 ? s.c((Context) this.f65361a.f65351a) : measuredWidth;
                }
                return invokeV.intValue;
            }
        };
        this.s = new h(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65362a;

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
                this.f65362a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.i.h
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    SSWebView sSWebView = this.f65362a.f65356f;
                    if (sSWebView == null) {
                        k.b("BaseEndCard", "webView has destroy when onPauseWebView");
                        return;
                    }
                    sSWebView.onPause();
                    k.b("BaseEndCard", "js make webView onPause OK");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.h
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    SSWebView sSWebView = this.f65362a.f65356f;
                    if (sSWebView == null) {
                        k.b("BaseEndCard", "webView has destroy when onPauseWebViewTimers");
                        return;
                    }
                    sSWebView.pauseTimers();
                    k.b("BaseEndCard", "js make webView pauseTimers OK");
                }
            }
        };
        this.f65351a = activity;
        this.f65352b = mVar;
        this.f65353c = str;
        this.n = i2;
        this.o = i3;
        this.p = i4;
        this.q = f2;
        this.f65354d = z;
        this.f65355e = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) || this.f65357g == null || this.f65351a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
            this.f65357g.a("resize", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || this.f65357g == null || this.f65351a.isFinishing()) {
            return;
        }
        try {
            this.f65357g.b(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                s.a((View) this.f65356f, 0.0f);
            }
            s.a((View) this.f65356f, 0);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            s.a((View) this.f65356f, 8);
        }
    }

    public void f() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (sSWebView = this.f65356f) != null && sSWebView.canGoBack()) {
            this.f65356f.goBack();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f65358h = null;
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f65360j : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SSWebView sSWebView = this.f65356f;
            if (sSWebView != null) {
                sSWebView.onResume();
            }
            w wVar = this.f65357g;
            if (wVar != null) {
                wVar.q();
                SSWebView sSWebView2 = this.f65356f;
                if (sSWebView2 != null) {
                    if (sSWebView2.getVisibility() == 0) {
                        this.f65357g.b(true);
                        a(true);
                        a(false, true);
                    } else {
                        this.f65357g.b(false);
                        a(false);
                        a(true, false);
                    }
                }
            }
            j jVar = this.f65359i;
            if (jVar != null) {
                jVar.c();
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            SSWebView sSWebView = this.f65356f;
            if (sSWebView != null) {
                sSWebView.onPause();
            }
            w wVar = this.f65357g;
            if (wVar != null) {
                wVar.r();
                this.f65357g.b(false);
                a(false);
                a(true, false);
            }
        }
    }

    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (jVar = this.f65359i) == null) {
            return;
        }
        jVar.d();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            SSWebView sSWebView = this.f65356f;
            if (sSWebView != null) {
                sSWebView.destroy();
                aa.a(this.f65351a, this.f65356f);
                aa.a(this.f65356f);
            }
            this.f65356f = null;
            w wVar = this.f65357g;
            if (wVar != null) {
                wVar.s();
            }
            q qVar = this.f65358h;
            if (qVar != null) {
                qVar.a(true);
                this.f65358h.t();
            }
            j jVar = this.f65359i;
            if (jVar != null) {
                jVar.e();
            }
        }
    }

    public void n() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (sSWebView = this.f65356f) == null) {
            return;
        }
        sSWebView.onResume();
        this.f65356f.resumeTimers();
        s.a((View) this.f65356f, 1.0f);
    }

    public void o() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (qVar = this.f65358h) == null) {
            return;
        }
        qVar.n();
    }

    public void p() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (qVar = this.f65358h) == null) {
            return;
        }
        qVar.m();
    }

    public void q() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (qVar = this.f65358h) == null) {
            return;
        }
        qVar.o();
    }

    public void r() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (qVar = this.f65358h) == null) {
            return;
        }
        qVar.p();
    }

    public void s() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (qVar = this.f65358h) == null) {
            return;
        }
        qVar.c();
        this.f65358h.h();
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            w wVar = this.f65357g;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sSWebView = this.f65356f) == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65363a;

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
                this.f65363a = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @RequiresApi(api = 16)
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.f65363a.f65356f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        this.f65363a.f65356f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    int measuredWidth = this.f65363a.f65356f.getMeasuredWidth();
                    int measuredHeight = this.f65363a.f65356f.getMeasuredHeight();
                    if (this.f65363a.f65356f.getVisibility() == 0) {
                        this.f65363a.b(measuredWidth, measuredHeight);
                    }
                }
            }
        });
    }

    public void d() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (jVar = this.f65359i) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.f65357g == null || this.f65351a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.f65357g.a("viewableChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.f65357g == null || this.f65351a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.f65357g.a("volumeChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f65357g == null || this.f65351a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.f65357g.a("endcard_control_event", jSONObject);
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
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.f65357g == null || this.f65351a.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
            this.f65357g.b("showDownloadStatus", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) || j3 <= 0) {
            return;
        }
        a(i2, (int) ((j2 * 100) / j3));
    }

    public void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.c.a(this.f65351a).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(i.a(sSWebView, 3703));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.f65356f.setLayerType(0, null);
        }
    }

    public void a(boolean z, int i2, String str) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) || (qVar = this.f65358h) == null) {
            return;
        }
        if (z) {
            qVar.b();
        } else {
            qVar.a(i2, str);
        }
    }
}
