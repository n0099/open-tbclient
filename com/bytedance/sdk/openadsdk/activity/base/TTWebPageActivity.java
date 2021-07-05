package com.bytedance.sdk.openadsdk.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.component.a.e;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.preload.falconx.a.a;
import com.bytedance.sdk.openadsdk.r.b;
import com.bytedance.sdk.openadsdk.r.h;
import com.bytedance.sdk.openadsdk.r.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TTWebPageActivity extends Activity implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f29126c;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public a C;
    public int D;
    public int E;
    public AtomicBoolean F;
    public JSONArray G;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a H;
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> I;
    public String J;
    public TTAppDownloadListener K;

    /* renamed from: a  reason: collision with root package name */
    public TTAdDislike f29127a;

    /* renamed from: b  reason: collision with root package name */
    public j f29128b;

    /* renamed from: d  reason: collision with root package name */
    public SSWebView f29129d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f29130e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f29131f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f29132g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f29133h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f29134i;
    public TextView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public Context n;
    public int o;
    public ViewStub p;
    public ViewStub q;
    public ViewStub r;
    public Button s;
    public ProgressBar t;
    public String u;
    public String v;
    public w w;
    public int x;
    public String y;
    public m z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1111975292, "Lcom/bytedance/sdk/openadsdk/activity/base/TTWebPageActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1111975292, "Lcom/bytedance/sdk/openadsdk/activity/base/TTWebPageActivity;");
                return;
            }
        }
        f29126c = TTWebPageActivity.class.getSimpleName();
    }

    public TTWebPageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = 0;
        this.E = 0;
        this.F = new AtomicBoolean(true);
        this.G = null;
        this.I = Collections.synchronizedMap(new HashMap());
        this.J = "立即下载";
        this.K = new TTAppDownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTWebPageActivity f29137a;

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
                this.f29137a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
                    this.f29137a.a("下载中...");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
                    this.f29137a.a("下载失败");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
                    this.f29137a.a("点击安装");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
                    this.f29137a.a("暂停");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    TTWebPageActivity tTWebPageActivity = this.f29137a;
                    tTWebPageActivity.a(tTWebPageActivity.f());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, str, str2) == null) {
                    this.f29137a.a("点击打开");
                }
            }
        };
    }

    public static /* synthetic */ int c(TTWebPageActivity tTWebPageActivity) {
        int i2 = tTWebPageActivity.D;
        tTWebPageActivity.D = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int e(TTWebPageActivity tTWebPageActivity) {
        int i2 = tTWebPageActivity.E;
        tTWebPageActivity.E = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (i()) {
                if (q.a((WebView) this.f29129d)) {
                    return;
                }
                super.onBackPressed();
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            e();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.n = this;
            super.onCreate(bundle);
            try {
                o.a(this);
                setContentView(r.f(this, "tt_activity_ttlandingpage"));
            } catch (Throwable unused) {
            }
            g();
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.n).a(false).b(false).a(this.f29129d);
            Intent intent = getIntent();
            this.o = intent.getIntExtra(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 1);
            this.u = intent.getStringExtra(XAdRemoteAPKDownloadExtraInfo.ADID);
            this.v = intent.getStringExtra("log_extra");
            this.x = intent.getIntExtra("source", -1);
            String stringExtra = intent.getStringExtra("url");
            this.A = stringExtra;
            String stringExtra2 = intent.getStringExtra("web_title");
            intent.getStringExtra("icon_url");
            this.B = intent.getStringExtra("gecko_id");
            this.y = intent.getStringExtra("event_tag");
            if (b.b()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.z = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra3));
                    } catch (Exception e2) {
                        com.bytedance.sdk.component.utils.j.c(f29126c, "TTWebPageActivity - onCreate MultiGlobalInfo : ", e2);
                    }
                }
            } else {
                this.z = t.a().c();
                t.a().g();
            }
            m mVar = this.z;
            if (mVar != null && mVar.aG() != null) {
                this.z.aG().a("landing_page");
            }
            c(this.z);
            this.f29128b = new j(this, this.z, this.f29129d).b(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(XAdRemoteAPKDownloadExtraInfo.ADID, this.u);
                jSONObject.put("url", stringExtra);
                jSONObject.put("web_title", stringExtra2);
                jSONObject.put("is_multi_process", b.b());
                jSONObject.put("event_tag", this.y);
            } catch (JSONException unused2) {
            }
            this.f29128b.a(jSONObject);
            h();
            this.f29129d.setWebViewClient(new c(this, this.n, this.w, this.u, this.f29128b) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTWebPageActivity f29135a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r11, r12, r13, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r11, r12, r13, r14};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (w) objArr2[1], (String) objArr2[2], (j) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29135a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        try {
                            if (this.f29135a.t == null || this.f29135a.isFinishing()) {
                                return;
                            }
                            this.f29135a.t.setVisibility(8);
                        } catch (Throwable unused3) {
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
                        try {
                            if (TextUtils.isEmpty(this.f29135a.B)) {
                                return super.shouldInterceptRequest(webView, str);
                            }
                            TTWebPageActivity.c(this.f29135a);
                            WebResourceResponse a2 = com.bytedance.sdk.openadsdk.f.a.a().a(this.f29135a.C, this.f29135a.B, str);
                            if (a2 != null) {
                                TTWebPageActivity.e(this.f29135a);
                                Log.d(TTWebPageActivity.f29126c, "GeckoLog: hit++");
                                return a2;
                            }
                            return super.shouldInterceptRequest(webView, str);
                        } catch (Throwable th) {
                            Log.e(TTWebPageActivity.f29126c, "shouldInterceptRequest url error", th);
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                    return (WebResourceResponse) invokeLL.objValue;
                }
            });
            this.f29129d.getSettings().setUserAgentString(h.a(this.f29129d, this.o));
            if (Build.VERSION.SDK_INT >= 21) {
                this.f29129d.getSettings().setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.e.d.a(this.n, this.z);
            this.f29129d.loadUrl(stringExtra);
            this.f29129d.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this, this.w, this.f29128b) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTWebPageActivity f29145a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((w) objArr2[0], (j) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29145a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i2) == null) {
                        super.onProgressChanged(webView, i2);
                        if (this.f29145a.t == null || this.f29145a.isFinishing()) {
                            return;
                        }
                        if (i2 != 100 || !this.f29145a.t.isShown()) {
                            this.f29145a.t.setProgress(i2);
                        } else {
                            this.f29145a.t.setVisibility(8);
                        }
                    }
                }
            });
            this.f29129d.setDownloadListener(new DownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTWebPageActivity f29146a;

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
                    this.f29146a = this;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                        if (this.f29146a.I.containsKey(str)) {
                            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) this.f29146a.I.get(str);
                            if (aVar != null) {
                                aVar.e();
                                return;
                            }
                            return;
                        }
                        if (this.f29146a.z != null && this.f29146a.z.Y() != null) {
                            this.f29146a.z.Y().a();
                        }
                        TTWebPageActivity tTWebPageActivity = this.f29146a;
                        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTWebPageActivity, str, tTWebPageActivity.z, this.f29146a.y);
                        this.f29146a.I.put(str, a2);
                        a2.e();
                    }
                }
            });
            TextView textView = this.f29132g;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = r.a(this, "tt_web_title_default");
                }
                textView.setText(stringExtra2);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTWebPageActivity f29147a;

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
                        this.f29147a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            TTWebPageActivity tTWebPageActivity = this.f29147a;
                            tTWebPageActivity.a(tTWebPageActivity.z);
                        }
                    }
                });
            }
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTWebPageActivity f29148a;

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
                        this.f29148a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            TTWebPageActivity tTWebPageActivity = this.f29148a;
                            tTWebPageActivity.b(tTWebPageActivity.z);
                        }
                    }
                });
            }
            e();
            a(4);
            this.C = com.bytedance.sdk.openadsdk.f.a.a().b();
            com.bytedance.sdk.openadsdk.e.d.a(this.z, this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            try {
                if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                    viewGroup.removeAllViews();
                }
            } catch (Throwable unused) {
            }
            if (!TextUtils.isEmpty(this.B)) {
                d.a.a(this.E, this.D, this.z);
            }
            com.bytedance.sdk.openadsdk.f.a.a().a(this.C);
            aa.a(this.n, this.f29129d);
            aa.a(this.f29129d);
            this.f29129d = null;
            w wVar = this.w;
            if (wVar != null) {
                wVar.s();
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.H;
            if (aVar != null) {
                aVar.d();
            }
            Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.I;
            if (map != null) {
                for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().d();
                    }
                }
                this.I.clear();
            }
            j jVar = this.f29128b;
            if (jVar != null) {
                jVar.e();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            t.a().b(true);
            w wVar = this.w;
            if (wVar != null) {
                wVar.r();
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.H;
            if (aVar != null) {
                aVar.c();
            }
            Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.I;
            if (map != null) {
                for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().c();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            w wVar = this.w;
            if (wVar != null) {
                wVar.q();
            }
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.H;
            if (aVar != null) {
                aVar.b();
            }
            Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> map = this.I;
            if (map != null) {
                for (Map.Entry<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().b();
                    }
                }
            }
            j jVar = this.f29128b;
            if (jVar != null) {
                jVar.c();
            }
            j();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            j jVar = this.f29128b;
            if (jVar != null) {
                jVar.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void d() {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65553, this) == null) && (mVar = this.z) != null && mVar.X() == 4) {
            if (this.H == null) {
                com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.z, TextUtils.isEmpty(this.y) ? com.bytedance.sdk.openadsdk.r.o.a(this.x) : this.y);
                this.H = a2;
                a2.a(this.K, false);
            }
            this.H.a(this);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.H;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.H).g(false);
            }
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = new com.bytedance.sdk.openadsdk.core.b.a(this, this.z, "embeded_ad_landingpage", this.x);
            aVar2.a(true);
            aVar2.c(true);
            this.H.g();
            aVar2.a(this.H);
        }
    }

    private void e() {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && (mVar = this.z) != null && mVar.X() == 4) {
            ViewStub viewStub = this.r;
            if (viewStub != null) {
                viewStub.setVisibility(0);
            }
            Button button = (Button) findViewById(r.e(this, "tt_browser_download_btn"));
            this.s = button;
            if (button != null) {
                a(f());
                if (this.H == null) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.z, TextUtils.isEmpty(this.y) ? com.bytedance.sdk.openadsdk.r.o.a(this.x) : this.y);
                    this.H = a2;
                    a2.a(this.K, false);
                }
                this.H.a(this);
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.H;
                if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                    ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
                }
                com.bytedance.sdk.openadsdk.core.b.a aVar2 = new com.bytedance.sdk.openadsdk.core.b.a(this, this.z, "embeded_ad_landingpage", this.x);
                aVar2.a(true);
                aVar2.c(true);
                this.s.setOnClickListener(aVar2);
                this.s.setOnTouchListener(aVar2);
                aVar2.a(this.H);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            m mVar = this.z;
            if (mVar != null && !TextUtils.isEmpty(mVar.aj())) {
                this.J = this.z.aj();
            }
            return this.J;
        }
        return (String) invokeV.objValue;
    }

    private void g() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.f29129d = (SSWebView) findViewById(r.e(this, "tt_browser_webview"));
            this.r = (ViewStub) findViewById(r.e(this, "tt_browser_download_btn_stub"));
            this.p = (ViewStub) findViewById(r.e(this, "tt_browser_titlebar_view_stub"));
            this.q = (ViewStub) findViewById(r.e(this, "tt_browser_titlebar_dark_view_stub"));
            int n = com.bytedance.sdk.openadsdk.core.h.d().n();
            if (n == 0) {
                ViewStub viewStub2 = this.p;
                if (viewStub2 != null) {
                    viewStub2.setVisibility(0);
                }
            } else if (n == 1 && (viewStub = this.q) != null) {
                viewStub.setVisibility(0);
            }
            ImageView imageView = (ImageView) findViewById(r.e(this, "tt_titlebar_back"));
            this.f29130e = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTWebPageActivity f29140a;

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
                        this.f29140a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f29140a.f29129d == null) {
                            return;
                        }
                        if (this.f29140a.f29129d.canGoBack()) {
                            this.f29140a.f29129d.goBack();
                        } else if (this.f29140a.i()) {
                            this.f29140a.onBackPressed();
                        } else {
                            this.f29140a.finish();
                        }
                    }
                });
            }
            ImageView imageView2 = (ImageView) findViewById(r.e(this, "tt_titlebar_close"));
            this.f29131f = imageView2;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTWebPageActivity f29141a;

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
                        this.f29141a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f29141a.finish();
                        }
                    }
                });
            }
            this.f29132g = (TextView) findViewById(r.e(this, "tt_titlebar_title"));
            this.f29133h = (TextView) findViewById(r.e(this, "tt_titlebar_dislike"));
            this.f29134i = (TextView) findViewById(r.e(this, "tt_titlebar_developer"));
            this.j = (TextView) findViewById(r.e(this, "tt_titlebar_app_name"));
            this.k = (TextView) findViewById(r.e(this, "tt_titlebar_app_detail"));
            this.l = (TextView) findViewById(r.e(this, "tt_titlebar_app_privacy"));
            this.m = (LinearLayout) findViewById(r.e(this, "tt_titlebar_detail_layout"));
            TextView textView = this.f29133h;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTWebPageActivity f29142a;

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
                        this.f29142a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f29142a.a();
                        }
                    }
                });
            }
            this.t = (ProgressBar) findViewById(r.e(this, "tt_browser_progress"));
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.z);
            w wVar = new w(this);
            this.w = wVar;
            wVar.b(this.f29129d).a(this.z).a(arrayList).b(this.u).c(this.v).a(this.x).d(com.bytedance.sdk.openadsdk.r.o.i(this.z)).a(this.f29129d).a(this);
            this.w.b().a("adInfoStash", (e<?, ?>) new e<JSONObject, JSONObject>(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTWebPageActivity f29143a;

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
                    this.f29143a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.bytedance.sdk.component.a.e
                @Nullable
                public JSONObject a(@NonNull JSONObject jSONObject, @NonNull f fVar) throws Exception {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, fVar)) == null) {
                        this.f29143a.w.d(jSONObject);
                        return null;
                    }
                    return (JSONObject) invokeLL.objValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) ? m.c(this.z) : invokeV.booleanValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || this.z == null) {
            return;
        }
        JSONArray b2 = b(this.A);
        int d2 = com.bytedance.sdk.openadsdk.r.o.d(this.v);
        int c2 = com.bytedance.sdk.openadsdk.r.o.c(this.v);
        p<com.bytedance.sdk.openadsdk.e.a> f2 = o.f();
        if (b2 == null || f2 == null || d2 <= 0 || c2 <= 0) {
            return;
        }
        n nVar = new n();
        nVar.f29993d = b2;
        AdSlot m = this.z.m();
        if (m == null) {
            return;
        }
        m.setAdCount(6);
        f2.a(m, nVar, c2, new p.b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTWebPageActivity f29144a;

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
                this.f29144a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f29144a.a(0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
                    return;
                }
                try {
                    this.f29144a.F.set(false);
                    this.f29144a.w.b(new JSONObject(aVar.d()));
                } catch (Exception unused) {
                    this.f29144a.a(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, mVar) == null) || mVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.b.a(this.n, mVar.U());
    }

    private void c(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, mVar) == null) {
            if (mVar == null) {
                LinearLayout linearLayout = this.m;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            String U = mVar.U();
            if (TextUtils.isEmpty(U)) {
                LinearLayout linearLayout2 = this.m;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                    return;
                }
                return;
            }
            try {
                if (TextUtils.isEmpty(U)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.e.c b2 = com.bytedance.sdk.openadsdk.core.b.b(new JSONObject(U));
                if (b2 == null) {
                    if (this.m != null) {
                        this.m.setVisibility(8);
                    }
                } else if (TextUtils.isEmpty(b2.f())) {
                    if (this.m != null) {
                        this.m.setVisibility(8);
                    }
                } else {
                    if (this.m != null) {
                        this.m.setVisibility(0);
                    }
                    String b3 = b2.b();
                    String c2 = b2.c();
                    String g2 = b2.g();
                    if (TextUtils.isEmpty(g2)) {
                        g2 = com.bytedance.sdk.openadsdk.downloadnew.a.f.a(mVar);
                    }
                    if (this.f29134i != null) {
                        this.f29134i.setText(String.format(r.a(this.n, "tt_open_app_detail_developer"), c2));
                    }
                    if (this.j != null) {
                        this.j.setText(String.format(r.a(this.n, "tt_open_landing_page_app_name"), g2, b3));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, mVar) == null) || mVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.b.a(this.n, mVar.ak(), mVar.U(), new b.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTWebPageActivity f29136a;

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
                this.f29136a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f29136a.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.b.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        }, com.bytedance.sdk.openadsdk.downloadnew.a.f.a(mVar), mVar.X() == 4);
    }

    private JSONArray b(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            JSONArray jSONArray = this.G;
            if (jSONArray != null && jSONArray.length() > 0) {
                return this.G;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int indexOf = str.indexOf("?id=");
            int indexOf2 = str.indexOf("&");
            if (indexOf == -1 || indexOf2 == -1 || (i2 = indexOf + 4) >= indexOf2) {
                return null;
            }
            String substring = str.substring(i2, indexOf2);
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(substring);
            return jSONArray2;
        }
        return (JSONArray) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, str) == null) || TextUtils.isEmpty(str) || (button = this.s) == null) {
            return;
        }
        button.post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTWebPageActivity.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f29138a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TTWebPageActivity f29139b;

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
                this.f29139b = this;
                this.f29138a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f29139b.s == null || this.f29139b.isFinishing()) {
                    return;
                }
                this.f29139b.s.setText(this.f29138a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            if (i()) {
                q.a((View) this.f29131f, 4);
            } else if (this.f29131f == null || !i()) {
            } else {
                q.a((View) this.f29131f, i2);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f29127a = new com.bytedance.sdk.openadsdk.dislike.ui.a(this, this.z.aG(), this.y, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.d
    public void a(boolean z, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, jSONArray) == null) || !z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.G = jSONArray;
        j();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.z == null || isFinishing()) {
            return;
        }
        if (this.f29127a == null) {
            b();
        }
        this.f29127a.showDislikeDialog();
    }
}
