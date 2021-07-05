package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.v;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.e.p;
import com.bytedance.sdk.openadsdk.r.q;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NativeExpressView extends FrameLayout implements j, com.bytedance.sdk.openadsdk.theme.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int v = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public d A;
    public e B;
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> C;
    public final AtomicBoolean D;
    public final AtomicBoolean E;
    public String F;
    public float G;
    public float H;
    public final AtomicBoolean I;
    public com.bytedance.sdk.openadsdk.e.j J;
    public p K;
    public com.bytedance.sdk.openadsdk.core.dynamic.a.a L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public String S;
    public ThemeStatusBroadcastReceiver T;
    public String U;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30291a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30292b;

    /* renamed from: c  reason: collision with root package name */
    public int f30293c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f30294d;

    /* renamed from: e  reason: collision with root package name */
    public TTDislikeDialogAbstract f30295e;

    /* renamed from: f  reason: collision with root package name */
    public String f30296f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f30297g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f30298h;

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<SSWebView> f30299i;
    public w j;
    public String k;
    public AdSlot l;
    public com.bytedance.sdk.openadsdk.core.e.m m;
    public TTNativeExpressAd.ExpressVideoAdListener n;
    public FrameLayout o;
    public boolean p;
    public boolean q;
    public ScheduledFuture<?> r;
    public c s;
    public boolean t;
    public BackupView u;
    public String w;
    public int x;
    public int y;
    public TTNativeExpressAd.ExpressAdInteractionListener z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NativeExpressView f30307a;

        /* renamed from: b  reason: collision with root package name */
        public int f30308b;

        public a(NativeExpressView nativeExpressView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nativeExpressView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30307a = nativeExpressView;
            this.f30308b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f30308b == 1) {
                com.bytedance.sdk.component.utils.j.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                this.f30307a.a(false, 0.0f, 0.0f, 107, 1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1881890098, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/NativeExpressView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1881890098, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/NativeExpressView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30297g = new AtomicBoolean(false);
        this.f30291a = false;
        this.f30292b = true;
        this.f30293c = 0;
        this.k = "embeded_ad";
        this.C = Collections.synchronizedMap(new HashMap());
        this.D = new AtomicBoolean(false);
        this.E = new AtomicBoolean(false);
        this.F = null;
        this.q = false;
        this.t = false;
        this.I = new AtomicBoolean(false);
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = 0;
        this.U = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
        this.k = str;
        this.f30298h = context;
        this.m = mVar;
        b();
        a(adSlot);
        g();
    }

    private boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? TextUtils.equals(this.k, "embeded_ad") || TextUtils.equals(this.k, "splash_ad") : invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (A()) {
                this.M = true;
                return;
            }
            this.O = false;
            this.Q = true;
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.M) {
            com.bytedance.sdk.openadsdk.core.dynamic.a.a aVar = new com.bytedance.sdk.openadsdk.core.dynamic.a.a(this.f30298h, this.T);
            this.L = aVar;
            aVar.a(getWebView()).a(this.m).a(this.f30296f).b(this.w).a(this.x).c(com.bytedance.sdk.openadsdk.r.o.i(this.m)).a(this).a(getTemplateInfo()).b(getWebView()).a(this.K);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            a(getWebView());
            com.bytedance.sdk.openadsdk.e.j b2 = new com.bytedance.sdk.openadsdk.e.j(this.f30298h, this.m, getWebView()).b(false);
            this.J = b2;
            b2.a(this.K);
            getWebView().setWebViewClient(new f(this.f30298h, this.j, this.m, this.J, f()));
            getWebView().setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.j, this.J));
            getWebView().setDownloadListener(new DownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NativeExpressView f30300a;

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
                    this.f30300a = this;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        if (this.f30300a.C.containsKey(str)) {
                            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) this.f30300a.C.get(str);
                            if (aVar != null) {
                                aVar.e();
                                return;
                            }
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.e.m mVar = this.f30300a.m;
                        if (mVar != null && mVar.Y() != null) {
                            this.f30300a.m.Y().a();
                        }
                        NativeExpressView nativeExpressView = this.f30300a;
                        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(nativeExpressView.f30298h, str, nativeExpressView.m, nativeExpressView.k);
                        this.f30300a.C.put(str, a2);
                        a2.e();
                    }
                }
            });
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
                ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
                this.T = themeStatusBroadcastReceiver;
                this.f30298h.registerReceiver(themeStatusBroadcastReceiver, intentFilter);
                this.T.a(this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) ? !TextUtils.isEmpty(this.k) && this.k.equals("splash_ad") : invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getAdSlotType() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            String str = this.k;
            switch (str.hashCode()) {
                case -1695837674:
                    if (str.equals("banner_ad")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1364000502:
                    if (str.equals("rewarded_video")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -891990144:
                    if (str.equals("stream")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -764631662:
                    if (str.equals("fullscreen_interstitial_ad")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -712491894:
                    if (str.equals("embeded_ad")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 174971131:
                    if (str.equals("splash_ad")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1844104722:
                    if (str.equals("interaction")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1912999166:
                    if (str.equals("draw_ad")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 1:
                    return 9;
                case 2:
                    return 7;
                case 3:
                    return 8;
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                    return 3;
                case 7:
                    return 6;
                default:
                    return 5;
            }
        }
        return invokeV.intValue;
    }

    private JSONObject getMiddleTemplateInfo() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", this.G);
                jSONObject2.put("height", this.H);
                if (this.q) {
                    jSONObject2.put("isLandscape", true);
                }
                jSONObject.put("AdSize", jSONObject2);
                jSONObject.put("creative", a(true));
                String str2 = null;
                if (this.m.Q() != null) {
                    str2 = this.m.Q().e();
                    str = this.m.Q().f();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.U = str2;
                } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.m) != null) {
                    this.U = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.m).e();
                }
                jSONObject.put("template_Plugin", this.U);
                jSONObject.put("diff_template_Plugin", str);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    private JSONObject getTemplateInfo() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("width", this.G);
                jSONObject2.put("height", this.H);
                if (this.q) {
                    jSONObject2.put("isLandscape", true);
                }
                jSONObject.put("AdSize", jSONObject2);
                jSONObject.put("creative", a(false));
                if (this.m.P() != null) {
                    str = this.m.P().e();
                    str2 = this.m.P().f();
                } else {
                    str = null;
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.U = str;
                } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.m) != null) {
                    this.U = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.m).e();
                }
                jSONObject.put("template_Plugin", this.U);
                jSONObject.put("diff_template_Plugin", str2);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65564, this) == null) && this.M) {
            this.K.d();
            this.L.a();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            int i2 = this.f30293c;
            if (i2 == 1) {
                this.N = false;
                this.P = true;
                if (this.Q) {
                    return;
                }
                i();
            } else if (i2 != 2) {
                this.O = false;
                this.Q = true;
                if (this.P) {
                    return;
                }
                a(this.S);
            } else if (!this.P) {
                a(this.S);
            } else if (this.Q) {
            } else {
                i();
            }
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && this.M) {
            addView(this.L.b(), new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            DynamicRootView b2 = this.L.b();
            return (b2 == null || b2.getChildCount() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f30295e;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = this.f30294d;
            if (aVar != null) {
                aVar.showDislikeDialog();
            } else {
                TTDelegateActivity.a(getContext(), this.m);
            }
        }
    }

    private boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.m;
            return mVar != null && mVar.h() == 1 && com.bytedance.sdk.openadsdk.core.e.m.b(this.m);
        }
        return invokeV.booleanValue;
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            com.bytedance.sdk.openadsdk.k.a.a().a(com.bytedance.sdk.openadsdk.k.a.c.b().a(getAdSlotType()).c(this.F).g(com.bytedance.sdk.openadsdk.r.o.h(this.w)).a("dynamic_backup_render_new"));
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65571, this) == null) && this.m != null && this.D.getAndSet(false) && getWebView().getParent() == null && !this.t) {
            com.bytedance.sdk.component.utils.j.f("webviewpool", "attachCallback+++========-----------===========");
            g();
            k();
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65572, this) == null) || this.D.getAndSet(true) || this.t) {
            return;
        }
        b(m());
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            try {
                if (this.r == null || this.r.isCancelled()) {
                    return;
                }
                boolean cancel = this.r.cancel(false);
                com.bytedance.sdk.component.utils.j.b("NativeExpressView", "MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=" + cancel);
                this.r = null;
            } catch (Throwable unused) {
            }
        }
    }

    private void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            y();
            this.f30297g.set(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.theme.a
    public void a_(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.j == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.j.a("themeChange", jSONObject);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setBackgroundColor(0);
            if (getWebView().getParent() != null) {
                ((ViewGroup) getWebView().getParent()).removeView(getWebView());
            }
            e();
            getWebView().setBackgroundColor(0);
            a();
            h();
            d();
            if (Build.VERSION.SDK_INT >= 17) {
                com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(getWebView(), this.j);
            }
        }
    }

    public d getClickCreativeListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A : (d) invokeV.objValue;
    }

    public e getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.B : (e) invokeV.objValue;
    }

    public int getDynamicShowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.R : invokeV.intValue;
    }

    public int getExpectExpressHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Float.valueOf(this.H).intValue() : invokeV.intValue;
    }

    public int getExpectExpressWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Float.valueOf(this.G).intValue() : invokeV.intValue;
    }

    public w getJsObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : (w) invokeV.objValue;
    }

    public SSWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            WeakReference<SSWebView> weakReference = this.f30299i;
            if (weakReference != null && weakReference.get() != null) {
                return this.f30299i.get();
            }
            WeakReference<SSWebView> d2 = com.bytedance.sdk.openadsdk.core.widget.webview.d.a().d();
            this.f30299i = d2;
            if (d2 != null && d2.get() != null) {
                this.f30291a = true;
                return this.f30299i.get();
            }
            WeakReference<SSWebView> c2 = com.bytedance.sdk.openadsdk.core.widget.webview.d.a().c();
            this.f30299i = c2;
            if (c2 != null && c2.get() != null) {
                return this.f30299i.get();
            }
            SSWebView sSWebView = new SSWebView(com.bytedance.sdk.openadsdk.core.o.a());
            this.f30299i = new WeakReference<>(sSWebView);
            return sSWebView;
        }
        return (SSWebView) invokeV.objValue;
    }

    public void h() {
        JSONObject templateInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.K = new p(1, this.k, this.m);
            this.j = new w(this.f30298h);
            if ("feed_video_middle_page".equals(this.k)) {
                templateInfo = getMiddleTemplateInfo();
            } else {
                templateInfo = getTemplateInfo();
            }
            this.j.b(getWebView()).a(this.m).b(this.f30296f).c(this.w).a(this.k).a(this.x).d(com.bytedance.sdk.openadsdk.r.o.i(this.m)).a((j) this).a(templateInfo).a(getWebView()).a(this.K);
            c();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.j == null || this.I.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.j.a("expressShow", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void k() {
        v c2;
        m.a P;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.E.set(true);
            this.K.a();
            this.r = com.bytedance.sdk.component.e.e.d().schedule(new a(this, 1), com.bytedance.sdk.openadsdk.core.o.h().G(), TimeUnit.MILLISECONDS);
            if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e()) {
                q();
                a(false, 0.0f, 0.0f, 102, 1);
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d() != null) {
                this.S = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d().c();
            }
            if (TextUtils.isEmpty(this.S)) {
                q();
                a(false, 0.0f, 0.0f, 102, 1);
                return;
            }
            if ("feed_video_middle_page".equals(this.k)) {
                c2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.m);
                com.bytedance.sdk.openadsdk.core.e.m mVar = this.m;
                if (mVar != null) {
                    P = mVar.Q();
                }
                P = null;
            } else {
                c2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.m);
                com.bytedance.sdk.openadsdk.core.e.m mVar2 = this.m;
                if (mVar2 != null) {
                    P = mVar2.P();
                }
                P = null;
            }
            if (c2 == null && !a(P)) {
                q();
                a(false, 0.0f, 0.0f, 103, 1);
                return;
            }
            String f2 = c2 != null ? c2.f() : null;
            if (a(P) && !TextUtils.isEmpty(P.a())) {
                f2 = P.a();
            }
            if (com.bytedance.sdk.openadsdk.core.widget.webview.a.f.b(f2) && !"https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(this.S)) {
                q();
                a(false, 0.0f, 0.0f, 102, 1);
                return;
            }
            q();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && getWebView() != null && !this.I.get()) {
            try {
                getWebView().resumeTimers();
            } catch (Exception unused) {
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if ("embeded_ad".equals(this.k) || "draw_ad".equals(this.k)) {
                return false;
            }
            this.I.set(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                b(true);
                this.I.set(true);
                this.j = null;
                this.f30294d = null;
                this.f30295e = null;
                this.l = null;
                this.m = null;
                this.z = null;
                this.A = null;
                this.s = null;
                this.B = null;
                this.C.clear();
                this.n = null;
                removeAllViews();
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                y();
                if (this.f30298h != null) {
                    this.f30298h.unregisterReceiver(this.T);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.j.c("NativeExpressView", "detach error", th);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            try {
                b(true);
                this.I.set(true);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.j.a("NativeExpressView", "backupDestroy remove webview error", th);
            }
            try {
                if (this.o == null || this.o.getParent() == null) {
                    return;
                }
                removeView(this.o);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.j.a("NativeExpressView", "backupDestroy remove video container error", th2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
            com.bytedance.sdk.component.utils.j.f("webviewpool", "onAttachedToWindow+++");
            w();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDetachedFromWindow();
            x();
            com.bytedance.sdk.component.utils.j.f("webviewpool", "onDetachedFromWindow===");
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onFinishTemporaryDetach();
            com.bytedance.sdk.component.utils.j.f("webviewpool", "onFinishTemporaryDetach+++");
            w();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStartTemporaryDetach();
            com.bytedance.sdk.component.utils.j.f("webviewpool", "onStartTemporaryDetach===");
            x();
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void setBackupListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void setClickCreativeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dVar) == null) {
            this.A = dVar;
        }
    }

    public void setClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eVar) == null) {
            this.B = eVar;
        }
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.ui.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) {
            BackupView backupView = this.u;
            if (backupView != null) {
                backupView.setDislikeInner(aVar);
            }
            this.f30294d = aVar;
        }
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, expressAdInteractionListener) == null) {
            this.z = expressAdInteractionListener;
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, tTDislikeDialogAbstract) == null) {
            BackupView backupView = this.u;
            if (backupView != null) {
                backupView.setDislikeOuter(tTDislikeDialogAbstract);
            }
            this.f30295e = tTDislikeDialogAbstract;
        }
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, expressVideoAdListener) == null) {
            this.n = expressVideoAdListener;
        }
    }

    private void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, adSlot) == null) {
            this.l = adSlot;
            if (adSlot == null) {
                return;
            }
            this.G = adSlot.getExpressViewAcceptedWidth();
            this.H = this.l.getExpressViewAcceptedHeight();
        }
    }

    private void b(com.bytedance.sdk.openadsdk.core.e.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, pVar) == null) || pVar == null) {
            return;
        }
        boolean z = true;
        if (pVar.a() == 1) {
            boolean b2 = pVar.b();
            this.N = b2;
            if (b2 || !this.f30291a) {
                return;
            }
            com.bytedance.sdk.component.utils.j.f("webviewpool", "===onRenderResult mWebViewRenderSuc:" + this.N + " ,recycle 实例渲染失败，则移除");
            b(true);
        } else if (pVar.a() == 2) {
            this.O = (pVar.b() && s()) ? false : false;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f30296f = this.m.ak();
            this.w = this.m.ao();
            this.y = 3613;
            this.x = com.bytedance.sdk.openadsdk.r.o.a(this.k);
            this.F = this.l.getCodeId();
            if (A()) {
                this.f30292b = this.m.aF() == 1;
                this.f30293c = this.m.aE();
            }
            com.bytedance.sdk.component.utils.j.f("webviewpool", "===initData isBackupOpen:" + this.f30292b + "；mRenderSequenceType：" + this.f30293c);
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65555, this, z) == null) && z) {
            com.bytedance.sdk.component.utils.j.f("webviewpool", "===removeWebView =====");
            w wVar = this.j;
            if (wVar != null) {
                wVar.a();
            }
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.f30299i, !this.N);
        }
    }

    private void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f30298h).a(false).a(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearHistory();
            WebSettings settings = sSWebView.getSettings();
            settings.setUserAgentString(com.bytedance.sdk.openadsdk.r.h.a(sSWebView, this.y));
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setUseWideViewPort(true);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.j.f("NativeExpressView", e2.toString());
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, str) == null) || this.m == null || TextUtils.isEmpty(str) || !str.equals("feed_video_middle_page")) {
            return;
        }
        com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.m, "feed_video_middle_page", "middle_page_click");
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            com.bytedance.sdk.openadsdk.k.a.a().h(com.bytedance.sdk.openadsdk.k.a.c.b().a(getAdSlotType()).c(this.F).g(com.bytedance.sdk.openadsdk.r.o.h(this.w)).b(i2).h(com.bytedance.sdk.openadsdk.core.g.a(i2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, float f2, float f3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew mWebViewRenderComplete:" + this.P + "---mDynamicRenderComplete:" + this.Q);
            com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew== isSuc:" + z + ";errorCode:" + i2 + ";renderType:" + i3 + ";mHasRenderCallback.get()=" + this.f30297g.get());
            if (i3 == 1) {
                this.P = true;
            } else if (i3 == 2) {
                this.Q = true;
                if (z) {
                    this.K.e();
                } else {
                    this.K.f();
                }
            }
            if (this.f30297g.get()) {
                return;
            }
            boolean z2 = false;
            boolean z3 = i2 == 107;
            boolean z4 = (this.P && this.Q) || (this.P && this.f30293c == 0) || ((this.Q && this.f30293c == 1) || (z && this.P && this.f30293c == 2));
            com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew isTimeOut:" + z3 + "; isCanTryCallback:" + z4);
            if (!z3 && !z4) {
                q();
                return;
            }
            if (!z && i3 == 1) {
                com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew == webView 渲染失败，更新error，上报该埋点");
                this.K.a(i2);
                b(i2);
                q();
            }
            if (!z && i3 == 2) {
                com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew == dynamic 渲染失败，更新error，上报该埋点");
                this.K.a(i2);
                b(i2);
                q();
            }
            if (z && i3 == 1 && z4) {
                com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew == webView渲染成功, 则回调出去");
                z();
                this.K.b();
                a(f2, f3);
                a(true, (View) this, f2, f3, i2);
            } else if (z && i3 == 2 && z4) {
                com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew == dynamic 渲染成功, 则回调出去");
                this.R = 2;
                z();
                this.K.a(true);
                r();
                com.bytedance.sdk.openadsdk.e.d.h(com.bytedance.sdk.openadsdk.core.o.a(), this.m, this.k, "dynamic_backup_native_render", null);
                this.u = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                a(true, (View) this, f2, f3, i2);
            } else {
                z();
                this.K.a(true);
                if (this.f30292b) {
                    this.K.c();
                    c cVar = this.s;
                    if (cVar != null && cVar.a(this, i2)) {
                        z2 = true;
                    }
                    this.t = z2;
                    this.K.h();
                } else {
                    this.K.p();
                    this.K.q();
                }
                com.bytedance.sdk.component.utils.j.f("webviewpool", "onRenderReleaseCallbackNew == mIsBackupShow:" + this.t);
                if (this.t) {
                    this.R = 1;
                    v();
                    com.bytedance.sdk.openadsdk.e.d.h(com.bytedance.sdk.openadsdk.core.o.a(), this.m, this.k, "dynamic_backup_render", null);
                    BackupView backupView = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                    this.u = backupView;
                    backupView.setThemeChangeReceiver(this.T);
                    BackupView backupView2 = this.u;
                    float realWidth = backupView2 == null ? f2 : backupView2.getRealWidth();
                    BackupView backupView3 = this.u;
                    a(true, (View) this, realWidth, backupView3 == null ? f3 : backupView3.getRealHeight(), i2);
                } else {
                    a(false, (View) this, f2, f3, i2);
                }
            }
            this.K.r();
            this.K.s();
        }
    }

    private boolean a(m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, aVar)) == null) ? (aVar == null || TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.e())) ? false : true : invokeL.booleanValue;
    }

    private JSONObject a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65540, this, z)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.m.aj());
                if (this.m.Y() != null) {
                    jSONObject.put("icon", this.m.Y().a());
                }
                JSONArray jSONArray = new JSONArray();
                if (this.m.ad() != null) {
                    for (int i2 = 0; i2 < this.m.ad().size(); i2++) {
                        com.bytedance.sdk.openadsdk.core.e.l lVar = this.m.ad().get(i2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("height", lVar.c());
                        jSONObject2.put("width", lVar.b());
                        jSONObject2.put("url", lVar.a());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("image", jSONArray);
                jSONObject.put("image_mode", this.m.ap());
                jSONObject.put("interaction_type", this.m.X());
                jSONObject.put("is_compliance_template", a(this.m));
                jSONObject.put("title", this.m.ah());
                jSONObject.put("description", this.m.ai());
                jSONObject.put("source", this.m.W());
                if (this.m.al() != null) {
                    jSONObject.put("comment_num", this.m.al().f());
                    jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, this.m.al().e());
                    jSONObject.put("app_size", this.m.al().g());
                    jSONObject.put("app", this.m.al().h());
                }
                if (this.m.V() != null) {
                    jSONObject.put("video", this.m.V().p());
                }
                if (z) {
                    if (this.m.Q() != null) {
                        jSONObject.put("dynamic_creative", this.m.Q().g());
                    }
                } else if (this.m.P() != null) {
                    jSONObject.put("dynamic_creative", this.m.P().g());
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeZ.objValue;
    }

    private boolean a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, mVar)) == null) ? mVar != null && mVar.B() == 2 : invokeL.booleanValue;
    }

    public synchronized void a(com.bytedance.sdk.openadsdk.core.e.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, pVar) == null) {
            synchronized (this) {
                if (pVar == null) {
                    a(false, 0.0f, 0.0f, 105, 1);
                    return;
                }
                boolean b2 = pVar.b();
                com.bytedance.sdk.component.utils.j.f("webviewpool", "===onRenderResult isSuc:" + b2 + " ,isWebViewFromRecycle:" + this.f30291a + ";render end:" + System.currentTimeMillis());
                float c2 = (float) pVar.c();
                float d2 = (float) pVar.d();
                int i2 = b2 ? 0 : pVar.i();
                b(pVar);
                a(b2, c2, d2, i2, pVar.a());
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            com.bytedance.sdk.component.utils.j.f("webviewpool", "webViewRender start:" + System.currentTimeMillis());
            this.K.g();
            if (this.f30291a) {
                try {
                    com.bytedance.sdk.component.utils.i.a(this.f30299i.get(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                    return;
                } catch (Exception unused) {
                    b(true);
                    return;
                }
            }
            getWebView().loadUrl(com.bytedance.sdk.openadsdk.r.n.b(str));
        }
    }

    private void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 <= 0.0f || f3 <= 0.0f) {
            return;
        }
        SSWebView webView = getWebView();
        if (webView.getParent() != null) {
            ((ViewGroup) webView.getParent()).removeView(webView);
        }
        int b2 = (int) q.b(this.f30298h, f2);
        int b3 = (int) q.b(this.f30298h, f3);
        com.bytedance.sdk.component.utils.j.f("ExpressView", "width:" + b2);
        com.bytedance.sdk.component.utils.j.f("ExpressView", "height:" + b3);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) webView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(b2, b3);
        }
        layoutParams.width = b2;
        layoutParams.height = b3;
        webView.setLayoutParams(layoutParams);
        addView(webView);
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f29950a;
        int i4 = kVar.f29951b;
        int i5 = kVar.f29952c;
        int i6 = kVar.f29953d;
        String str = kVar.k;
        b(this.k);
        if (i2 == 1) {
            FrameLayout frameLayout = this.o;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            e eVar = this.B;
            if (eVar != null) {
                eVar.a(kVar);
                this.B.a(str);
                this.B.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.z;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.m.X());
            }
        } else if (i2 == 2) {
            d dVar = this.A;
            if (dVar != null) {
                dVar.a(kVar);
                this.A.a(str);
                this.A.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.z;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.m.X());
            }
        } else if (i2 == 3) {
            t();
        } else if (i2 != 4) {
        } else {
            FrameLayout frameLayout2 = this.o;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            com.bytedance.sdk.component.utils.j.b("ClickCreativeListener", "创意....mAdType=" + this.k + ",!mVideoPause=" + (true ^ this.p) + "，isAutoPlay=" + com.bytedance.sdk.openadsdk.r.o.j(this.m));
            if ("embeded_ad".equals(this.k) && u() && !this.p && com.bytedance.sdk.openadsdk.r.o.j(this.m)) {
                com.bytedance.sdk.component.utils.j.b("ClickCreativeListener", "创意....");
                d dVar2 = this.A;
                if (dVar2 != null) {
                    dVar2.a(kVar);
                    this.A.a(str);
                    this.A.a(this, i3, i4, i5, i6);
                }
            } else {
                com.bytedance.sdk.component.utils.j.b("ClickCreativeListener", "普通....");
                e eVar2 = this.B;
                if (eVar2 != null) {
                    eVar2.a(kVar);
                    this.B.a(kVar.k);
                    this.B.a(this, i3, i4, i5, i6);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.z;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.m.X());
            }
        }
    }

    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) || i2 == -1 || kVar == null) {
            return;
        }
        int i3 = kVar.f29950a;
        int i4 = kVar.f29951b;
        int i5 = kVar.f29952c;
        int i6 = kVar.f29953d;
        if (i2 == 1) {
            FrameLayout frameLayout = this.o;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            e eVar = this.B;
            if (eVar != null) {
                a(eVar.d(), z);
                this.B.a(kVar);
                this.B.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.z;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.m.X());
            }
        } else if (i2 == 2) {
            d dVar = this.A;
            if (dVar != null) {
                a(dVar.d(), z);
                this.A.a(kVar);
                this.A.a(this, i3, i4, i5, i6);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.z;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.m.X());
            }
        } else if (i2 == 3) {
            t();
        } else if (i2 != 4) {
        } else {
            FrameLayout frameLayout2 = this.o;
            if (frameLayout2 != null) {
                frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
            }
            com.bytedance.sdk.component.utils.j.b("ClickCreativeListener", "创意....mAdType=" + this.k + ",!mVideoPause=" + (true ^ this.p) + "，isAutoPlay=" + com.bytedance.sdk.openadsdk.r.o.j(this.m));
            if ("embeded_ad".equals(this.k) && u() && !this.p && com.bytedance.sdk.openadsdk.r.o.j(this.m)) {
                com.bytedance.sdk.component.utils.j.b("ClickCreativeListener", "创意....");
                d dVar2 = this.A;
                if (dVar2 != null) {
                    a(dVar2.d(), z);
                    this.A.a(kVar);
                    this.A.a(this, i3, i4, i5, i6);
                }
            } else {
                com.bytedance.sdk.component.utils.j.b("ClickCreativeListener", "普通....");
                if (this.B != null) {
                    a(this.A.d(), z);
                    this.B.a(kVar);
                    this.B.a(this, i3, i4, i5, i6);
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.z;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.m.X());
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65546, this, aVar, z) == null) && aVar != null && (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            com.bytedance.sdk.openadsdk.downloadnew.a.d dVar = (com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar;
            dVar.d(true);
            dVar.e(z);
        }
    }

    public void a(boolean z, float f2, float f3, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(z, f2, f3, i2, i3);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(this, z, f2, f3, i2, i3) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f30301a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ float f30302b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ float f30303c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ int f30304d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ int f30305e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ NativeExpressView f30306f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30306f = this;
                        this.f30301a = z;
                        this.f30302b = f2;
                        this.f30303c = f3;
                        this.f30304d = i2;
                        this.f30305e = i3;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            NativeExpressView nativeExpressView = this.f30306f;
                            if (nativeExpressView.m == null) {
                                return;
                            }
                            nativeExpressView.b(this.f30301a, this.f30302b, this.f30303c, this.f30304d, this.f30305e);
                        }
                    }
                });
            }
        }
    }

    private void a(boolean z, View view, float f2, float f3, int i2) {
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Boolean.valueOf(z), view, Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2)}) == null) || (expressAdInteractionListener = this.z) == null) {
            return;
        }
        if (z) {
            expressAdInteractionListener.onRenderSuccess(view, f2, f3);
        } else {
            expressAdInteractionListener.onRenderFail(view, com.bytedance.sdk.openadsdk.core.g.a(i2), i2);
        }
    }
}
