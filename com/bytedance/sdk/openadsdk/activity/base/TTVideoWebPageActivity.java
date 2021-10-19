package com.bytedance.sdk.openadsdk.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.e.i;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.g;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.downloadnew.a.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.q.c;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import com.dxmpay.wallet.download.PayDownloadModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TTVideoWebPageActivity extends Activity implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public RelativeLayout C;
    public TextView D;
    public RoundImageView E;
    public TextView F;
    public TextView G;
    public ViewStub H;
    public Button I;
    public ProgressBar J;
    public a K;
    public final Map<String, a> L;
    public boolean M;
    public i N;
    public String O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public String S;
    public int T;
    public com.bytedance.sdk.openadsdk.multipro.b.a U;
    public j V;
    public AtomicBoolean W;
    public JSONArray X;
    public String Y;
    public com.bytedance.sdk.openadsdk.preload.falconx.a.a Z;

    /* renamed from: a  reason: collision with root package name */
    public TTAdDislike f65912a;
    public int aa;
    public int ab;
    public String ac;
    public TTAppDownloadListener ad;
    public com.bytedance.sdk.openadsdk.core.b.a ae;
    public final e af;
    public boolean ag;
    public final BroadcastReceiver ah;

    /* renamed from: b  reason: collision with root package name */
    public NativeVideoTsView f65913b;

    /* renamed from: c  reason: collision with root package name */
    public c f65914c;

    /* renamed from: d  reason: collision with root package name */
    public SSWebView f65915d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f65916e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f65917f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f65918g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65919h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65920i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f65921j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public Context n;
    public int o;
    public String p;
    public String q;
    public w r;
    public int s;
    public RelativeLayout t;
    public FrameLayout u;
    public int v;
    public long w;
    public m x;
    public int y;
    public int z;

    public TTVideoWebPageActivity() {
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
        this.v = -1;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.L = Collections.synchronizedMap(new HashMap());
        this.M = false;
        this.P = false;
        this.Q = true;
        this.R = false;
        this.S = null;
        this.W = new AtomicBoolean(true);
        this.X = null;
        this.aa = 0;
        this.ab = 0;
        this.ac = "立即下载";
        this.ad = new TTAppDownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTVideoWebPageActivity f65926a;

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
                this.f65926a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    this.f65926a.a("下载中...");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    this.f65926a.a(PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
                    this.f65926a.a("点击安装");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    this.f65926a.a("暂停");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = this.f65926a;
                    tTVideoWebPageActivity.a(tTVideoWebPageActivity.i());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, str, str2) == null) {
                    this.f65926a.a("点击打开");
                }
            }
        };
        this.ae = null;
        this.af = new e(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTVideoWebPageActivity f65932a;

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
                this.f65932a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    this.f65932a.M = z;
                    if (this.f65932a.isFinishing()) {
                        return;
                    }
                    if (z) {
                        s.a((View) this.f65932a.f65915d, 8);
                        s.a((View) this.f65932a.t, 8);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f65932a.u.getLayoutParams();
                        this.f65932a.z = marginLayoutParams.leftMargin;
                        this.f65932a.y = marginLayoutParams.topMargin;
                        this.f65932a.A = marginLayoutParams.width;
                        this.f65932a.B = marginLayoutParams.height;
                        marginLayoutParams.width = -1;
                        marginLayoutParams.height = -1;
                        marginLayoutParams.topMargin = 0;
                        marginLayoutParams.leftMargin = 0;
                        this.f65932a.u.setLayoutParams(marginLayoutParams);
                        return;
                    }
                    s.a((View) this.f65932a.f65915d, 0);
                    s.a((View) this.f65932a.t, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f65932a.u.getLayoutParams();
                    marginLayoutParams2.width = this.f65932a.A;
                    marginLayoutParams2.height = this.f65932a.B;
                    marginLayoutParams2.leftMargin = this.f65932a.z;
                    marginLayoutParams2.topMargin = this.f65932a.y;
                    this.f65932a.u.setLayoutParams(marginLayoutParams2);
                }
            }
        };
        this.ag = false;
        this.ah = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTVideoWebPageActivity f65933a;

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
                this.f65933a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    int c2 = n.c(this.f65933a.getApplicationContext());
                    if (this.f65933a.T == 0 && c2 != 0 && this.f65933a.f65915d != null && this.f65933a.S != null) {
                        this.f65933a.f65915d.loadUrl(this.f65933a.S);
                    }
                    NativeVideoTsView nativeVideoTsView = this.f65933a.f65913b;
                    if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !this.f65933a.t() && this.f65933a.T != c2) {
                        ((g) this.f65933a.f65913b.getNativeVideoController()).a(context);
                    }
                    this.f65933a.T = c2;
                }
            }
        };
    }

    public static /* synthetic */ int c(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i2 = tTVideoWebPageActivity.aa;
        tTVideoWebPageActivity.aa = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int e(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i2 = tTVideoWebPageActivity.ab;
        tTVideoWebPageActivity.ab = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.M && (nativeVideoTsView = this.f65913b) != null && nativeVideoTsView.getNativeVideoController() != null) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.f65913b.getNativeVideoController()).e(null, null);
                this.M = false;
            } else if (r()) {
                if (s.a((WebView) this.f65915d)) {
                    return;
                }
                super.onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            h();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                getWindow().addFlags(16777216);
            } catch (Throwable unused) {
            }
            try {
                o.a(this);
            } catch (Throwable unused2) {
            }
            this.T = n.c(getApplicationContext());
            setContentView(t.f(this, "tt_activity_videolandingpage"));
            this.n = this;
            Intent intent = getIntent();
            this.o = intent.getIntExtra(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 1);
            this.p = intent.getStringExtra(XAdRemoteAPKDownloadExtraInfo.ADID);
            this.q = intent.getStringExtra("log_extra");
            this.s = intent.getIntExtra("source", -1);
            this.S = intent.getStringExtra("url");
            this.Y = intent.getStringExtra("gecko_id");
            String stringExtra = intent.getStringExtra("web_title");
            this.O = intent.getStringExtra("event_tag");
            this.R = intent.getBooleanExtra("video_is_auto_play", true);
            if (bundle != null && bundle.getLong("video_play_position") > 0) {
                this.w = bundle.getLong("video_play_position", 0L);
            }
            String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (b.b()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.x = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra3));
                    } catch (Exception unused3) {
                    }
                }
                m mVar = this.x;
                if (mVar != null) {
                    this.v = mVar.ap();
                }
            } else {
                m c2 = com.bytedance.sdk.openadsdk.core.t.a().c();
                this.x = c2;
                if (c2 != null) {
                    this.v = c2.ap();
                }
                com.bytedance.sdk.openadsdk.core.t.a().g();
            }
            if (stringExtra2 != null) {
                try {
                    this.U = com.bytedance.sdk.openadsdk.multipro.b.a.a(new JSONObject(stringExtra2));
                } catch (Exception unused4) {
                }
                com.bytedance.sdk.openadsdk.multipro.b.a aVar = this.U;
                if (aVar != null) {
                    this.w = aVar.f68465g;
                }
            }
            if (bundle != null) {
                String string = bundle.getString("material_meta");
                if (this.x == null) {
                    try {
                        this.x = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(string));
                    } catch (Throwable unused5) {
                    }
                }
                long j2 = bundle.getLong("video_play_position");
                if (j2 > 0) {
                    this.w = j2;
                }
            }
            this.N = new i(this.x, this.O);
            j();
            a(this.x);
            o();
            q();
            a(4);
            com.bytedance.sdk.openadsdk.core.widget.webview.c.a(this.n).a(Build.VERSION.SDK_INT >= 16).b(false).a(this.f65915d);
            this.V = new j(this, this.x, this.f65915d).b(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(XAdRemoteAPKDownloadExtraInfo.ADID, this.p);
                jSONObject.put("url", this.S);
                jSONObject.put("web_title", stringExtra);
                jSONObject.put("is_multi_process", b.b());
                jSONObject.put("event_tag", this.O);
            } catch (JSONException unused6) {
            }
            this.V.a(jSONObject);
            this.f65915d.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.e(this, this.n, this.r, this.p, this.V) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTVideoWebPageActivity f65922a;

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
                    this.f65922a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        try {
                            if (this.f65922a.J == null || this.f65922a.isFinishing()) {
                                return;
                            }
                            this.f65922a.J.setVisibility(8);
                        } catch (Throwable unused7) {
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
                        try {
                            if (TextUtils.isEmpty(this.f65922a.Y)) {
                                return super.shouldInterceptRequest(webView, str);
                            }
                            TTVideoWebPageActivity.c(this.f65922a);
                            WebResourceResponse a2 = com.bytedance.sdk.openadsdk.f.a.a().a(this.f65922a.Z, this.f65922a.Y, str);
                            if (a2 != null) {
                                TTVideoWebPageActivity.e(this.f65922a);
                                return a2;
                            }
                            return super.shouldInterceptRequest(webView, str);
                        } catch (Throwable unused7) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                    return (WebResourceResponse) invokeLL.objValue;
                }
            });
            this.f65915d.getSettings().setUserAgentString(com.bytedance.sdk.openadsdk.q.i.a(this.f65915d, this.o));
            if (Build.VERSION.SDK_INT >= 21) {
                this.f65915d.getSettings().setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.e.d.a(this.n, this.x);
            this.f65915d.loadUrl(this.S);
            this.f65915d.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.d(this, this.r, this.V) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTVideoWebPageActivity f65936a;

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
                    this.f65936a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i2) == null) {
                        super.onProgressChanged(webView, i2);
                        if (this.f65936a.J == null || this.f65936a.isFinishing()) {
                            return;
                        }
                        if (i2 != 100 || !this.f65936a.J.isShown()) {
                            this.f65936a.J.setProgress(i2);
                        } else {
                            this.f65936a.J.setVisibility(8);
                        }
                    }
                }
            });
            this.f65915d.setDownloadListener(new DownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTVideoWebPageActivity f65937a;

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
                    this.f65937a = this;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j3)}) == null) {
                        if (this.f65937a.L.containsKey(str)) {
                            a aVar2 = (a) this.f65937a.L.get(str);
                            if (aVar2 != null) {
                                aVar2.e();
                                return;
                            }
                            return;
                        }
                        if (this.f65937a.x != null && this.f65937a.x.Y() != null) {
                            this.f65937a.x.Y().a();
                        }
                        TTVideoWebPageActivity tTVideoWebPageActivity = this.f65937a;
                        a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTVideoWebPageActivity, str, tTVideoWebPageActivity.x, this.f65937a.O);
                        this.f65937a.L.put(str, a2);
                        a2.e();
                    }
                }
            });
            TextView textView = this.f65918g;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = t.a(this, "tt_web_title_default");
                }
                textView.setText(stringExtra);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTVideoWebPageActivity f65923a;

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
                        this.f65923a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            TTVideoWebPageActivity tTVideoWebPageActivity = this.f65923a;
                            tTVideoWebPageActivity.b(tTVideoWebPageActivity.x);
                        }
                    }
                });
            }
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTVideoWebPageActivity f65924a;

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
                        this.f65924a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            TTVideoWebPageActivity tTVideoWebPageActivity = this.f65924a;
                            tTVideoWebPageActivity.c(tTVideoWebPageActivity.x);
                        }
                    }
                });
            }
            a();
            k();
            h();
            this.Z = com.bytedance.sdk.openadsdk.f.a.a().b();
            com.bytedance.sdk.openadsdk.e.d.a(this.x, this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            b();
            try {
                if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                    viewGroup.removeAllViews();
                }
            } catch (Throwable unused) {
            }
            if (!TextUtils.isEmpty(this.Y)) {
                d.a.a(this.ab, this.aa, this.x);
            }
            com.bytedance.sdk.openadsdk.f.a.a().a(this.Z);
            aa.a(this.n, this.f65915d);
            aa.a(this.f65915d);
            this.f65915d = null;
            a aVar = this.K;
            if (aVar != null) {
                aVar.d();
            }
            Map<String, a> map = this.L;
            if (map != null) {
                for (Map.Entry<String, a> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().d();
                    }
                }
                this.L.clear();
            }
            w wVar = this.r;
            if (wVar != null) {
                wVar.s();
            }
            NativeVideoTsView nativeVideoTsView = this.f65913b;
            if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
                this.f65913b.getNativeVideoController().m();
            }
            this.f65913b = null;
            this.x = null;
            j jVar = this.V;
            if (jVar != null) {
                jVar.e();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            try {
                if (e() && !g()) {
                    this.P = true;
                    this.f65914c.j();
                }
            } catch (Throwable th) {
                k.f("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
            }
            w wVar = this.r;
            if (wVar != null) {
                wVar.r();
            }
            a aVar = this.K;
            if (aVar != null) {
                aVar.c();
            }
            Map<String, a> map = this.L;
            if (map != null) {
                for (Map.Entry<String, a> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().c();
                    }
                }
            }
            if (t() || ((nativeVideoTsView2 = this.f65913b) != null && nativeVideoTsView2.getNativeVideoController() != null && this.f65913b.getNativeVideoController().x())) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.TRUE);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.TRUE);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.TRUE);
            }
            if (t() || (nativeVideoTsView = this.f65913b) == null || nativeVideoTsView.getNativeVideoController() == null) {
                return;
            }
            a(this.f65913b.getNativeVideoController());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            this.Q = false;
            if (this.P && f() && !g()) {
                this.P = false;
                this.f65914c.k();
            }
            w wVar = this.r;
            if (wVar != null) {
                wVar.q();
            }
            a aVar = this.K;
            if (aVar != null) {
                aVar.b();
            }
            Map<String, a> map = this.L;
            if (map != null) {
                for (Map.Entry<String, a> entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().b();
                    }
                }
            }
            j jVar = this.V;
            if (jVar != null) {
                jVar.c();
            }
            s();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            m mVar = this.x;
            bundle.putString("material_meta", mVar != null ? mVar.aP().toString() : null);
            bundle.putLong("video_play_position", this.w);
            bundle.putBoolean("is_complete", t());
            long j2 = this.w;
            NativeVideoTsView nativeVideoTsView = this.f65913b;
            if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
                j2 = this.f65913b.getNativeVideoController().n();
            }
            bundle.putLong("video_play_position", j2);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
            j jVar = this.V;
            if (jVar != null) {
                jVar.d();
            }
        }
    }

    private void h() {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65563, this) == null) && (mVar = this.x) != null && mVar.X() == 4) {
            this.H.setVisibility(0);
            Button button = (Button) findViewById(t.e(this, "tt_browser_download_btn"));
            this.I = button;
            if (button != null) {
                a(i());
                if (this.K != null) {
                    if (TextUtils.isEmpty(this.O)) {
                        q.a(this.s);
                    }
                    this.K.a(this.ad, false);
                }
                this.I.setOnClickListener(this.ae);
                this.I.setOnTouchListener(this.ae);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            m mVar = this.x;
            if (mVar != null && !TextUtils.isEmpty(mVar.aj())) {
                this.ac = this.x.aj();
            }
            return this.ac;
        }
        return (String) invokeV.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.J = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
            this.H = (ViewStub) findViewById(t.e(this, "tt_browser_download_btn_stub"));
            this.f65915d = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
            this.f65916e = (ImageView) findViewById(t.e(this, "tt_titlebar_back"));
            m mVar = this.x;
            if (mVar != null && mVar.aG() != null) {
                this.x.aG().a("landing_page");
            }
            ImageView imageView = this.f65916e;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTVideoWebPageActivity f65929a;

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
                        this.f65929a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f65929a.f65915d == null) {
                            return;
                        }
                        if (this.f65929a.f65915d.canGoBack()) {
                            this.f65929a.f65915d.goBack();
                        } else if (this.f65929a.r()) {
                            this.f65929a.onBackPressed();
                        } else {
                            Map<String, Object> map = null;
                            NativeVideoTsView nativeVideoTsView = this.f65929a.f65913b;
                            if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
                                map = q.a(this.f65929a.x, this.f65929a.f65913b.getNativeVideoController().o(), this.f65929a.f65913b.getNativeVideoController().v());
                            }
                            TTVideoWebPageActivity tTVideoWebPageActivity = this.f65929a;
                            com.bytedance.sdk.openadsdk.e.d.a(tTVideoWebPageActivity, tTVideoWebPageActivity.x, "embeded_ad", "detail_back", this.f65929a.l(), this.f65929a.m(), map);
                            this.f65929a.finish();
                        }
                    }
                });
            }
            ImageView imageView2 = (ImageView) findViewById(t.e(this, "tt_titlebar_close"));
            this.f65917f = imageView2;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTVideoWebPageActivity f65930a;

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
                        this.f65930a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            NativeVideoTsView nativeVideoTsView = this.f65930a.f65913b;
                            if (nativeVideoTsView != null) {
                                Map<String, Object> a2 = nativeVideoTsView.getNativeVideoController() != null ? q.a(this.f65930a.x, this.f65930a.f65913b.getNativeVideoController().o(), this.f65930a.f65913b.getNativeVideoController().v()) : null;
                                TTVideoWebPageActivity tTVideoWebPageActivity = this.f65930a;
                                com.bytedance.sdk.openadsdk.e.d.a(tTVideoWebPageActivity, tTVideoWebPageActivity.x, "embeded_ad", "detail_skip", this.f65930a.l(), this.f65930a.m(), a2);
                            }
                            this.f65930a.finish();
                        }
                    }
                });
            }
            TextView textView = (TextView) findViewById(t.e(this, "tt_titlebar_dislike"));
            this.f65919h = textView;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTVideoWebPageActivity f65931a;

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
                        this.f65931a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f65931a.c();
                        }
                    }
                });
            }
            this.f65918g = (TextView) findViewById(t.e(this, "tt_titlebar_title"));
            this.f65920i = (TextView) findViewById(t.e(this, "tt_video_developer"));
            this.f65921j = (TextView) findViewById(t.e(this, "tt_video_app_name"));
            this.k = (TextView) findViewById(t.e(this, "tt_video_app_detail"));
            this.l = (TextView) findViewById(t.e(this, "tt_video_app_privacy"));
            this.m = (LinearLayout) findViewById(t.e(this, "tt_video_app_detail_layout"));
            this.u = (FrameLayout) findViewById(t.e(this, "tt_native_video_container"));
            this.t = (RelativeLayout) findViewById(t.e(this, "tt_native_video_titlebar"));
            this.C = (RelativeLayout) findViewById(t.e(this, "tt_rl_download"));
            this.D = (TextView) findViewById(t.e(this, "tt_video_btn_ad_image_tv"));
            this.F = (TextView) findViewById(t.e(this, "tt_video_ad_name"));
            this.G = (TextView) findViewById(t.e(this, "tt_video_ad_button"));
            this.E = (RoundImageView) findViewById(t.e(this, "tt_video_ad_logo_image"));
            n();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65569, this) == null) && m.b(this.x)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.f65913b = new NativeVideoTsView(this.n, this.x, true, true);
                } else {
                    this.f65913b = new NativeVideoTsView(this.n, this.x, true, false);
                }
                if (this.f65913b.getNativeVideoController() != null) {
                    this.f65913b.getNativeVideoController().a(false);
                }
                if (!this.R) {
                    this.w = 0L;
                }
                if (this.U != null && this.f65913b.getNativeVideoController() != null) {
                    this.f65913b.getNativeVideoController().b(this.U.f68465g);
                    this.f65913b.getNativeVideoController().c(this.U.f68463e);
                }
                if (this.f65913b.a(this.w, this.Q, t())) {
                    this.u.setVisibility(0);
                    this.u.removeAllViews();
                    this.u.addView(this.f65913b);
                }
                if (this.f65913b.getNativeVideoController() != null) {
                    this.f65913b.getNativeVideoController().a(false);
                    this.f65913b.getNativeVideoController().a(this.af);
                    this.f65913b.setIsQuiet(o.h().b(q.d(this.x.ao())));
                }
                if (t()) {
                    this.f65913b.b(true);
                }
                this.f65914c = this.f65913b.getNativeVideoController();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (n.c(this) == 0) {
                try {
                    Toast.makeText(this, t.b(this, "tt_no_network"), 0).show();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            NativeVideoTsView nativeVideoTsView = this.f65913b;
            if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
                return 0L;
            }
            return this.f65913b.getNativeVideoController().q();
        }
        return invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            NativeVideoTsView nativeVideoTsView = this.f65913b;
            if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
                return 0;
            }
            return this.f65913b.getNativeVideoController().s();
        }
        return invokeV.intValue;
    }

    private void n() {
        m mVar;
        String W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65575, this) == null) && (mVar = this.x) != null && mVar.X() == 4) {
            s.a((View) this.C, 0);
            if (!TextUtils.isEmpty(this.x.ah())) {
                W = this.x.ah();
            } else if (!TextUtils.isEmpty(this.x.ai())) {
                W = this.x.ai();
            } else {
                W = !TextUtils.isEmpty(this.x.W()) ? this.x.W() : "";
            }
            l Y = this.x.Y();
            if (Y != null && Y.a() != null) {
                s.a((View) this.E, 0);
                s.a((View) this.D, 4);
                ImageLoaderWrapper.from(Y).to(this.E);
            } else if (!TextUtils.isEmpty(W)) {
                s.a((View) this.E, 4);
                s.a((View) this.D, 0);
                this.D.setText(W.substring(0, 1));
            }
            if (!TextUtils.isEmpty(W)) {
                this.F.setText(W);
            }
            if (!TextUtils.isEmpty(this.x.aj())) {
                this.G.setText(this.x.aj());
            }
            s.a((View) this.F, 0);
            s.a((View) this.G, 0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void o() {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65577, this) == null) && (mVar = this.x) != null && mVar.X() == 4) {
            a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.x, this.O);
            this.K = a2;
            a2.a(this);
            a aVar = this.K;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
            }
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = new com.bytedance.sdk.openadsdk.core.b.a(this, this.x, "embeded_ad_landingpage", this.s);
            this.ae = aVar2;
            aVar2.a(true);
            this.ae.c(true);
            this.G.setOnClickListener(this.ae);
            this.G.setOnTouchListener(this.ae);
            this.ae.a(this.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void p() {
        m mVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65579, this) == null) && (mVar = this.x) != null && mVar.X() == 4) {
            a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.x, this.O);
            this.K = a2;
            a2.a(this);
            a aVar = this.K;
            if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
                ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.K).g(false);
            }
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = new com.bytedance.sdk.openadsdk.core.b.a(this, this.x, "embeded_ad_landingpage", this.s);
            this.ae = aVar2;
            aVar2.a(true);
            this.ae.c(true);
            this.K.g();
            this.ae.a(this.K);
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.x);
            w wVar = new w(this);
            this.r = wVar;
            wVar.b(this.f65915d).a(this.x).a(arrayList).b(this.p).c(this.q).a(this.s).a(this.f65915d).d(q.i(this.x));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) ? m.c(this.x) : invokeV.booleanValue;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65585, this) == null) || this.x == null) {
            return;
        }
        JSONArray b2 = b(this.S);
        int d2 = q.d(this.q);
        int c2 = q.c(this.q);
        p<com.bytedance.sdk.openadsdk.e.a> f2 = o.f();
        if (b2 == null || f2 == null || d2 <= 0 || c2 <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
        nVar.f66838d = b2;
        AdSlot m = this.x.m();
        if (m == null) {
            return;
        }
        m.setAdCount(6);
        f2.a(m, nVar, c2, new p.b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTVideoWebPageActivity f65934a;

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
                this.f65934a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f65934a.a(0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
                    return;
                }
                try {
                    this.f65934a.W.set(false);
                    this.f65934a.r.b(new JSONObject(aVar.d()));
                } catch (Exception unused) {
                    this.f65934a.a(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, this)) == null) {
            NativeVideoTsView nativeVideoTsView = this.f65913b;
            if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
                return true;
            }
            return this.f65913b.getNativeVideoController().x();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TTAdDislike tTAdDislike = this.f65912a;
            if (tTAdDislike != null) {
                return tTAdDislike.isShow();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, mVar) == null) || mVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.q.c.a(this.n, mVar.U());
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.bytedance.sdk.openadsdk.dislike.ui.a aVar = new com.bytedance.sdk.openadsdk.dislike.ui.a(this, this.x.aG(), this.O, true);
            this.f65912a = aVar;
            aVar.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTVideoWebPageActivity f65935a;

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
                    this.f65935a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f65935a.f()) {
                        this.f65935a.f65914c.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int i2, String str, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) && this.f65935a.f()) {
                        this.f65935a.f65914c.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f65935a.e()) {
                        this.f65935a.f65914c.i();
                    }
                }
            });
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.f65914c;
            return (cVar == null || cVar.v() == null || !this.f65914c.v().g()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c cVar = this.f65914c;
            return (cVar == null || cVar.v() == null || !this.f65914c.v().i()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, mVar) == null) || mVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.q.c.a(this.n, mVar.ak(), mVar.U(), new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTVideoWebPageActivity f65925a;

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
                this.f65925a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f65925a.p();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.c.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        }, f.a(mVar), mVar.X() == 4);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || isFinishing() || this.x == null) {
            return;
        }
        if (this.f65912a == null) {
            d();
        }
        this.f65912a.showDislikeDialog();
    }

    private void a(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, mVar) == null) || mVar == null) {
            return;
        }
        String U = mVar.U();
        if (TextUtils.isEmpty(U)) {
            LinearLayout linearLayout = this.m;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
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
                    g2 = f.a(mVar);
                }
                if (this.f65920i != null) {
                    this.f65920i.setText(String.format(t.a(this.n, "tt_open_app_detail_developer"), c2));
                }
                if (this.f65921j != null) {
                    this.f65921j.setText(String.format(t.a(this.n, "tt_open_landing_page_app_name"), g2, b3));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.n.unregisterReceiver(this.ah);
            } catch (Exception unused) {
            }
        }
    }

    private JSONArray b(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            JSONArray jSONArray = this.X;
            if (jSONArray != null && jSONArray.length() > 0) {
                return this.X;
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
        if (!(interceptable == null || interceptable.invokeL(65544, this, str) == null) || TextUtils.isEmpty(str) || (button = this.I) == null) {
            return;
        }
        button.post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f65927a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TTVideoWebPageActivity f65928b;

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
                this.f65928b = this;
                this.f65927a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f65928b.I == null || this.f65928b.isFinishing()) {
                    return;
                }
                this.f65928b.I.setText(this.f65927a);
            }
        });
    }

    private void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, cVar) == null) {
            k.f("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cVar.x() + ",position=" + cVar.n() + ",totalPlayDuration=" + cVar.q() + ",duration=" + cVar.t());
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.TRUE);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.TRUE);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.x()));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.n()));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.q()));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.t()));
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.n.registerReceiver(this.ah, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            if (r()) {
                s.a((View) this.f65917f, 4);
            } else if (this.f65917f == null || !r()) {
            } else {
                s.a((View) this.f65917f, i2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.d
    public void a(boolean z, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, jSONArray) == null) || !z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.X = jSONArray;
        s();
    }

    public static boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, intent)) == null) {
            if (intent == null) {
                return false;
            }
            try {
                if (intent.getComponent() == null) {
                    return false;
                }
                return TTVideoWebPageActivity.class.getName().equals(intent.getComponent().getClassName());
            } catch (Throwable th) {
                k.a("TTVideoWebPageActivity", "isThisClass error", th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
