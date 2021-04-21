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
import android.util.Log;
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
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog;
import com.bytedance.sdk.openadsdk.dislike.LandingDislikeToast;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TTVideoWebPageActivity extends Activity implements d {
    public long A;
    public l B;
    public RelativeLayout G;
    public TextView H;
    public RoundImageView I;
    public TextView J;
    public TextView K;
    public ViewStub L;
    public Button M;
    public ProgressBar N;
    public a O;
    public i R;
    public String S;
    public int X;
    public com.bytedance.sdk.openadsdk.multipro.b.a Y;
    public j Z;

    /* renamed from: a  reason: collision with root package name */
    public LandingDislikeDialog f27171a;
    public String ac;
    public com.bytedance.sdk.openadsdk.preload.falconx.a.a ad;

    /* renamed from: b  reason: collision with root package name */
    public LandingCommentDialog f27172b;

    /* renamed from: c  reason: collision with root package name */
    public LandingDislikeToast f27173c;

    /* renamed from: f  reason: collision with root package name */
    public NativeVideoTsView f27176f;

    /* renamed from: g  reason: collision with root package name */
    public c f27177g;

    /* renamed from: h  reason: collision with root package name */
    public SSWebView f27178h;
    public ImageView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public LinearLayout q;
    public Context r;
    public int s;
    public String t;
    public String u;
    public x v;
    public int w;
    public RelativeLayout x;
    public FrameLayout y;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f27174d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f27175e = new AtomicBoolean(false);
    public int z = -1;
    public int C = 0;
    public int D = 0;
    public int E = 0;
    public int F = 0;
    public final Map<String, a> P = Collections.synchronizedMap(new HashMap());
    public boolean Q = false;
    public boolean T = false;
    public boolean U = true;
    public boolean V = false;
    public String W = null;
    public AtomicBoolean aa = new AtomicBoolean(true);
    public JSONArray ab = null;
    public int ae = 0;
    public int af = 0;
    public String ag = "立即下载";
    public TTAppDownloadListener ah = new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.14
        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("下载中...");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("下载失败");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            TTVideoWebPageActivity.this.a("点击安装");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            TTVideoWebPageActivity.this.a("暂停");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.a(tTVideoWebPageActivity.h());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
            TTVideoWebPageActivity.this.a("点击打开");
        }
    };
    public com.bytedance.sdk.openadsdk.core.a.a ai = null;
    public final e aj = new e() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.4
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
        public void a(boolean z) {
            TTVideoWebPageActivity.this.Q = z;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                al.a((View) TTVideoWebPageActivity.this.f27178h, 8);
                al.a((View) TTVideoWebPageActivity.this.x, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.y.getLayoutParams();
                TTVideoWebPageActivity.this.D = marginLayoutParams.leftMargin;
                TTVideoWebPageActivity.this.C = marginLayoutParams.topMargin;
                TTVideoWebPageActivity.this.E = marginLayoutParams.width;
                TTVideoWebPageActivity.this.F = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoWebPageActivity.this.y.setLayoutParams(marginLayoutParams);
                return;
            }
            al.a((View) TTVideoWebPageActivity.this.f27178h, 0);
            al.a((View) TTVideoWebPageActivity.this.x, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.y.getLayoutParams();
            marginLayoutParams2.width = TTVideoWebPageActivity.this.E;
            marginLayoutParams2.height = TTVideoWebPageActivity.this.F;
            marginLayoutParams2.leftMargin = TTVideoWebPageActivity.this.D;
            marginLayoutParams2.topMargin = TTVideoWebPageActivity.this.C;
            TTVideoWebPageActivity.this.y.setLayoutParams(marginLayoutParams2);
        }
    };
    public boolean ak = false;
    public final BroadcastReceiver al = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int c2 = com.bytedance.sdk.openadsdk.utils.x.c(TTVideoWebPageActivity.this.getApplicationContext());
                if (TTVideoWebPageActivity.this.X == 0 && c2 != 0 && TTVideoWebPageActivity.this.f27178h != null && TTVideoWebPageActivity.this.W != null) {
                    TTVideoWebPageActivity.this.f27178h.loadUrl(TTVideoWebPageActivity.this.W);
                }
                NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.f27176f;
                if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !TTVideoWebPageActivity.this.v() && TTVideoWebPageActivity.this.X != c2) {
                    ((f) TTVideoWebPageActivity.this.f27176f.getNativeVideoController()).a(context);
                }
                TTVideoWebPageActivity.this.X = c2;
            }
        }
    };

    public static /* synthetic */ int c(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i = tTVideoWebPageActivity.ae;
        tTVideoWebPageActivity.ae = i + 1;
        return i;
    }

    public static /* synthetic */ int e(TTVideoWebPageActivity tTVideoWebPageActivity) {
        int i = tTVideoWebPageActivity.af;
        tTVideoWebPageActivity.af = i + 1;
        return i;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if (this.Q && (nativeVideoTsView = this.f27176f) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.f27176f.getNativeVideoController()).e(null, null);
            this.Q = false;
        } else if (q()) {
            if (al.a((WebView) this.f27178h)) {
                return;
            }
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        g();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            p.a(this);
        } catch (Throwable unused2) {
        }
        this.X = com.bytedance.sdk.openadsdk.utils.x.c(getApplicationContext());
        setContentView(ad.f(this, "tt_activity_videolandingpage"));
        this.r = this;
        Intent intent = getIntent();
        this.s = intent.getIntExtra("sdk_version", 1);
        this.t = intent.getStringExtra(XAdRemoteAPKDownloadExtraInfo.ADID);
        this.u = intent.getStringExtra("log_extra");
        this.w = intent.getIntExtra("source", -1);
        this.W = intent.getStringExtra("url");
        this.ac = intent.getStringExtra("gecko_id");
        String stringExtra = intent.getStringExtra("web_title");
        this.S = intent.getStringExtra("event_tag");
        this.V = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.A = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
        if (b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.B = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra3));
                } catch (Exception unused3) {
                }
            }
            l lVar = this.B;
            if (lVar != null) {
                this.z = lVar.aq();
            }
        } else {
            l c2 = u.a().c();
            this.B = c2;
            if (c2 != null) {
                this.z = c2.aq();
            }
            u.a().g();
        }
        if (stringExtra2 != null) {
            try {
                this.Y = com.bytedance.sdk.openadsdk.multipro.b.a.a(new JSONObject(stringExtra2));
            } catch (Exception unused4) {
            }
            com.bytedance.sdk.openadsdk.multipro.b.a aVar = this.Y;
            if (aVar != null) {
                this.A = aVar.f29578g;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.B == null) {
                try {
                    this.B = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                } catch (Throwable unused5) {
                }
            }
            long j = bundle.getLong("video_play_position");
            if (j > 0) {
                this.A = j;
            }
        }
        this.R = new i(this.B, this.S);
        i();
        a(this.B);
        n();
        p();
        a(4);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.r).a(Build.VERSION.SDK_INT >= 16).b(false).a(this.f27178h);
        this.Z = new j(this, this.B, this.f27178h).a(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(XAdRemoteAPKDownloadExtraInfo.ADID, this.t);
            jSONObject.put("url", this.W);
            jSONObject.put("web_title", stringExtra);
            jSONObject.put("is_multi_process", b.b());
            jSONObject.put("event_tag", this.S);
        } catch (JSONException unused6) {
        }
        this.Z.a(jSONObject);
        this.f27178h.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.r, this.v, this.t, this.Z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoWebPageActivity.this.N == null || TTVideoWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTVideoWebPageActivity.this.N.setVisibility(8);
                } catch (Throwable unused7) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (TextUtils.isEmpty(TTVideoWebPageActivity.this.ac)) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                    TTVideoWebPageActivity.c(TTVideoWebPageActivity.this);
                    WebResourceResponse a2 = com.bytedance.sdk.openadsdk.d.a.a().a(TTVideoWebPageActivity.this.ad, TTVideoWebPageActivity.this.ac, str);
                    if (a2 != null) {
                        TTVideoWebPageActivity.e(TTVideoWebPageActivity.this);
                        Log.d("TTVideoWebPageActivity", "GeckoLog: hit++");
                        return a2;
                    }
                    return super.shouldInterceptRequest(webView, str);
                } catch (Throwable th) {
                    Log.e("TTVideoWebPageActivity", "shouldInterceptRequest url error", th);
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        this.f27178h.getSettings().setUserAgentString(r.a(this.f27178h, this.s));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f27178h.getSettings().setMixedContentMode(0);
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.r, this.B);
        this.f27178h.loadUrl(this.W);
        this.f27178h.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.v, this.Z) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoWebPageActivity.this.N == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i != 100 || !TTVideoWebPageActivity.this.N.isShown()) {
                    TTVideoWebPageActivity.this.N.setProgress(i);
                } else {
                    TTVideoWebPageActivity.this.N.setVisibility(8);
                }
            }
        });
        this.f27178h.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.10
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTVideoWebPageActivity.this.P.containsKey(str)) {
                    a aVar2 = (a) TTVideoWebPageActivity.this.P.get(str);
                    if (aVar2 != null) {
                        aVar2.e();
                        return;
                    }
                    return;
                }
                if (TTVideoWebPageActivity.this.B != null && TTVideoWebPageActivity.this.B.aa() != null) {
                    TTVideoWebPageActivity.this.B.aa().a();
                }
                TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(tTVideoWebPageActivity, str, tTVideoWebPageActivity.B, TTVideoWebPageActivity.this.S);
                TTVideoWebPageActivity.this.P.put(str, a2);
                a2.e();
            }
        });
        TextView textView = this.k;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = ad.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        TextView textView2 = this.o;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.b(tTVideoWebPageActivity.B);
                }
            });
        }
        TextView textView3 = this.p;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                    tTVideoWebPageActivity.c(tTVideoWebPageActivity.B);
                }
            });
        }
        a();
        j();
        g();
        this.ad = com.bytedance.sdk.openadsdk.d.a.a().b();
        com.bytedance.sdk.openadsdk.c.d.a(this.B, this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        b();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.ac)) {
            d.a.a(this.af, this.ae, this.B);
        }
        com.bytedance.sdk.openadsdk.d.a.a().a(this.ad);
        aa.a(this.r, this.f27178h);
        aa.a(this.f27178h);
        this.f27178h = null;
        a aVar = this.O;
        if (aVar != null) {
            aVar.d();
        }
        Map<String, a> map = this.P;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().d();
                }
            }
            this.P.clear();
        }
        x xVar = this.v;
        if (xVar != null) {
            xVar.o();
        }
        NativeVideoTsView nativeVideoTsView = this.f27176f;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.f27176f.getNativeVideoController().m();
        }
        this.f27176f = null;
        this.B = null;
        j jVar = this.Z;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (e() && !this.f27174d.get()) {
                this.T = true;
                this.f27177g.i();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.f("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        x xVar = this.v;
        if (xVar != null) {
            xVar.n();
        }
        a aVar = this.O;
        if (aVar != null) {
            aVar.c();
        }
        Map<String, a> map = this.P;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().c();
                }
            }
        }
        if (v() || ((nativeVideoTsView2 = this.f27176f) != null && nativeVideoTsView2.getNativeVideoController() != null && this.f27176f.getNativeVideoController().w())) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.TRUE);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.TRUE);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.TRUE);
        }
        if (v() || (nativeVideoTsView = this.f27176f) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        a(this.f27176f.getNativeVideoController());
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.U = false;
        if (this.T && f() && !this.f27174d.get()) {
            this.T = false;
            this.f27177g.k();
        }
        x xVar = this.v;
        if (xVar != null) {
            xVar.m();
        }
        a aVar = this.O;
        if (aVar != null) {
            aVar.b();
        }
        Map<String, a> map = this.P;
        if (map != null) {
            for (Map.Entry<String, a> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().b();
                }
            }
        }
        j jVar = this.Z;
        if (jVar != null) {
            jVar.b();
        }
        r();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        l lVar = this.B;
        bundle.putString("material_meta", lVar != null ? lVar.aL().toString() : null);
        bundle.putLong("video_play_position", this.A);
        bundle.putBoolean("is_complete", v());
        long j = this.A;
        NativeVideoTsView nativeVideoTsView = this.f27176f;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            j = this.f27176f.getNativeVideoController().n();
        }
        bundle.putLong("video_play_position", j);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        j jVar = this.Z;
        if (jVar != null) {
            jVar.c();
        }
    }

    private void g() {
        l lVar = this.B;
        if (lVar == null || lVar.Z() != 4) {
            return;
        }
        this.L.setVisibility(0);
        Button button = (Button) findViewById(ad.e(this, "tt_browser_download_btn"));
        this.M = button;
        if (button != null) {
            a(h());
            if (this.O != null) {
                if (TextUtils.isEmpty(this.S)) {
                    ak.a(this.w);
                }
                this.O.a(this.ah, false);
            }
            this.M.setOnClickListener(this.ai);
            this.M.setOnTouchListener(this.ai);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        l lVar = this.B;
        if (lVar != null && !TextUtils.isEmpty(lVar.al())) {
            this.ag = this.B.al();
        }
        return this.ag;
    }

    private void i() {
        this.N = (ProgressBar) findViewById(ad.e(this, "tt_browser_progress"));
        this.L = (ViewStub) findViewById(ad.e(this, "tt_browser_download_btn_stub"));
        this.f27178h = (SSWebView) findViewById(ad.e(this, "tt_browser_webview"));
        this.i = (ImageView) findViewById(ad.e(this, "tt_titlebar_back"));
        l lVar = this.B;
        if (lVar != null) {
            lVar.c("landing_page");
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoWebPageActivity.this.f27178h != null) {
                        if (TTVideoWebPageActivity.this.f27178h.canGoBack()) {
                            TTVideoWebPageActivity.this.f27178h.goBack();
                        } else if (TTVideoWebPageActivity.this.q()) {
                            TTVideoWebPageActivity.this.onBackPressed();
                        } else {
                            Map<String, Object> map = null;
                            NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.f27176f;
                            if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
                                map = ak.a(TTVideoWebPageActivity.this.B, TTVideoWebPageActivity.this.f27176f.getNativeVideoController().o(), TTVideoWebPageActivity.this.f27176f.getNativeVideoController().u());
                            }
                            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                            com.bytedance.sdk.openadsdk.c.d.a(tTVideoWebPageActivity, tTVideoWebPageActivity.B, "embeded_ad", "detail_back", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), map);
                            TTVideoWebPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(ad.e(this, "tt_titlebar_close"));
        this.j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.f27176f;
                    if (nativeVideoTsView != null) {
                        Map<String, Object> a2 = nativeVideoTsView.getNativeVideoController() != null ? ak.a(TTVideoWebPageActivity.this.B, TTVideoWebPageActivity.this.f27176f.getNativeVideoController().o(), TTVideoWebPageActivity.this.f27176f.getNativeVideoController().u()) : null;
                        TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
                        com.bytedance.sdk.openadsdk.c.d.a(tTVideoWebPageActivity, tTVideoWebPageActivity.B, "embeded_ad", "detail_skip", TTVideoWebPageActivity.this.k(), TTVideoWebPageActivity.this.l(), a2);
                    }
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(ad.e(this, "tt_titlebar_dislike"));
        this.l = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.c();
                }
            });
        }
        this.k = (TextView) findViewById(ad.e(this, "tt_titlebar_title"));
        this.m = (TextView) findViewById(ad.e(this, "tt_video_developer"));
        this.n = (TextView) findViewById(ad.e(this, "tt_video_app_name"));
        this.o = (TextView) findViewById(ad.e(this, "tt_video_app_detail"));
        this.p = (TextView) findViewById(ad.e(this, "tt_video_app_privacy"));
        this.q = (LinearLayout) findViewById(ad.e(this, "tt_video_app_detail_layout"));
        this.y = (FrameLayout) findViewById(ad.e(this, "tt_native_video_container"));
        this.x = (RelativeLayout) findViewById(ad.e(this, "tt_native_video_titlebar"));
        this.G = (RelativeLayout) findViewById(ad.e(this, "tt_rl_download"));
        this.H = (TextView) findViewById(ad.e(this, "tt_video_btn_ad_image_tv"));
        this.J = (TextView) findViewById(ad.e(this, "tt_video_ad_name"));
        this.K = (TextView) findViewById(ad.e(this, "tt_video_ad_button"));
        this.I = (RoundImageView) findViewById(ad.e(this, "tt_video_ad_logo_image"));
        m();
    }

    private void j() {
        if (l.c(this.B)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.f27176f = new NativeVideoTsView(this.r, this.B, true, true);
                } else {
                    this.f27176f = new NativeVideoTsView(this.r, this.B, true, false);
                }
                if (this.f27176f.getNativeVideoController() != null) {
                    this.f27176f.getNativeVideoController().b(false);
                }
                if (!this.V) {
                    this.A = 0L;
                }
                if (this.Y != null && this.f27176f.getNativeVideoController() != null) {
                    this.f27176f.getNativeVideoController().b(this.Y.f29578g);
                    this.f27176f.getNativeVideoController().c(this.Y.f29576e);
                }
                if (this.f27176f.a(this.A, this.U, v())) {
                    this.y.setVisibility(0);
                    this.y.removeAllViews();
                    this.y.addView(this.f27176f);
                }
                if (this.f27176f.getNativeVideoController() != null) {
                    this.f27176f.getNativeVideoController().b(false);
                    this.f27176f.getNativeVideoController().a(this.aj);
                    this.f27176f.setIsQuiet(p.h().a(ak.d(this.B.ap())));
                }
                if (v()) {
                    this.f27176f.b(true);
                }
                this.f27177g = this.f27176f.getNativeVideoController();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (com.bytedance.sdk.openadsdk.utils.x.c(this) == 0) {
                try {
                    Toast.makeText(this, ad.b(this, "tt_no_network"), 0).show();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long k() {
        NativeVideoTsView nativeVideoTsView = this.f27176f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.f27176f.getNativeVideoController().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        NativeVideoTsView nativeVideoTsView = this.f27176f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.f27176f.getNativeVideoController().r();
    }

    private void m() {
        String Y;
        l lVar = this.B;
        if (lVar == null || lVar.Z() != 4) {
            return;
        }
        al.a((View) this.G, 0);
        if (!TextUtils.isEmpty(this.B.aj())) {
            Y = this.B.aj();
        } else if (!TextUtils.isEmpty(this.B.ak())) {
            Y = this.B.ak();
        } else {
            Y = !TextUtils.isEmpty(this.B.Y()) ? this.B.Y() : "";
        }
        if (this.B.aa() != null && this.B.aa().a() != null) {
            al.a((View) this.I, 0);
            al.a((View) this.H, 4);
            com.bytedance.sdk.openadsdk.i.e.c().a(this.B.aa().a(), this.I);
        } else if (!TextUtils.isEmpty(Y)) {
            al.a((View) this.I, 4);
            al.a((View) this.H, 0);
            this.H.setText(Y.substring(0, 1));
        }
        if (!TextUtils.isEmpty(Y)) {
            this.J.setText(Y);
        }
        if (!TextUtils.isEmpty(this.B.al())) {
            this.K.setText(this.B.al());
        }
        al.a((View) this.J, 0);
        al.a((View) this.K, 0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void n() {
        l lVar = this.B;
        if (lVar == null || lVar.Z() != 4) {
            return;
        }
        a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.B, this.S);
        this.O = a2;
        a2.a(this);
        a aVar = this.O;
        if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.B, "embeded_ad_landingpage", this.w);
        this.ai = aVar2;
        aVar2.a(true);
        this.ai.c(true);
        this.K.setOnClickListener(this.ai);
        this.K.setOnTouchListener(this.ai);
        this.ai.a(this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void o() {
        l lVar = this.B;
        if (lVar == null || lVar.Z() != 4) {
            return;
        }
        a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this, this.B, this.S);
        this.O = a2;
        a2.a(this);
        a aVar = this.O;
        if (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.O).g(false);
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this, this.B, "embeded_ad_landingpage", this.w);
        this.ai = aVar2;
        aVar2.a(true);
        this.ai.c(true);
        this.O.g();
        this.ai.a(this.O);
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.B);
        x xVar = new x(this);
        this.v = xVar;
        xVar.b(this.f27178h).a(this.B).a(arrayList).b(this.t).c(this.u).a(this.w).a(this.f27178h).d(ak.i(this.B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return l.f(this.B);
    }

    private void r() {
        if (this.B == null) {
            return;
        }
        JSONArray b2 = b(this.W);
        int d2 = ak.d(this.u);
        int c2 = ak.c(this.u);
        q<com.bytedance.sdk.openadsdk.c.a> f2 = p.f();
        if (b2 == null || f2 == null || d2 <= 0 || c2 <= 0) {
            return;
        }
        m mVar = new m();
        mVar.f27889d = b2;
        AdSlot p = this.B.p();
        if (p == null) {
            return;
        }
        p.setAdCount(6);
        f2.a(p, mVar, c2, new q.b() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                TTVideoWebPageActivity.this.a(0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar != null) {
                    try {
                        TTVideoWebPageActivity.this.aa.set(false);
                        TTVideoWebPageActivity.this.v.b(new JSONObject(aVar.d()));
                    } catch (Exception unused) {
                        TTVideoWebPageActivity.this.a(0);
                    }
                }
            }
        });
    }

    private void s() {
        LandingDislikeToast landingDislikeToast = this.f27173c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("您已成功提交反馈，请勿重复提交哦！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        LandingDislikeToast landingDislikeToast = this.f27173c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("感谢您的反馈！\n我们将为您带来更优质的广告体验");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        LandingDislikeToast landingDislikeToast = this.f27173c;
        if (landingDislikeToast == null) {
            return;
        }
        landingDislikeToast.a("输入为空或者输入特殊字符，请重新输入");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        NativeVideoTsView nativeVideoTsView = this.f27176f;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.f27176f.getNativeVideoController().w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l lVar) {
        if (lVar == null) {
            return;
        }
        g.a(this.r, lVar.W());
    }

    public void d() {
        if (this.f27172b == null) {
            LandingCommentDialog landingCommentDialog = new LandingCommentDialog(this, this.B);
            this.f27172b = landingCommentDialog;
            landingCommentDialog.setCallback(new LandingCommentDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.f27174d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.f27177g.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.f27174d.set(false);
                    if (!TTVideoWebPageActivity.this.f27175e.get()) {
                        TTVideoWebPageActivity.this.f27171a.a();
                        return;
                    }
                    TTVideoWebPageActivity.this.f27171a.a(true);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.f27177g.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingCommentDialog.a
                public void a(String str, boolean z) {
                    if (z && !TTVideoWebPageActivity.this.f27175e.get()) {
                        TTVideoWebPageActivity.this.f27175e.set(true);
                        TTVideoWebPageActivity.this.t();
                    } else if (!z) {
                        TTVideoWebPageActivity.this.u();
                    }
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.f27177g.k();
                    }
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f27172b);
            this.f27172b.setVisibility(8);
        }
        if (this.f27171a == null) {
            LandingDislikeDialog landingDislikeDialog = new LandingDislikeDialog(this, this.B, this.S);
            this.f27171a = landingDislikeDialog;
            landingDislikeDialog.setCallback(new LandingDislikeDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.8
                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(View view) {
                    TTVideoWebPageActivity.this.f27174d.set(true);
                    if (TTVideoWebPageActivity.this.e()) {
                        TTVideoWebPageActivity.this.f27177g.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void b(View view) {
                    TTVideoWebPageActivity.this.f27174d.set(false);
                    if (TTVideoWebPageActivity.this.f()) {
                        TTVideoWebPageActivity.this.f27177g.k();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (TTVideoWebPageActivity.this.f27175e.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTVideoWebPageActivity.this.f27175e.set(true);
                    TTVideoWebPageActivity.this.t();
                    TTVideoWebPageActivity.this.f27172b.a();
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.a
                public void a() {
                    TTVideoWebPageActivity.this.f27172b.b();
                    TTVideoWebPageActivity.this.f27174d.set(true);
                }
            });
            ((FrameLayout) findViewById(16908290)).addView(this.f27171a);
        }
        if (this.f27173c == null) {
            this.f27173c = new LandingDislikeToast(this);
            ((FrameLayout) findViewById(16908290)).addView(this.f27173c);
        }
    }

    public boolean e() {
        c cVar = this.f27177g;
        return (cVar == null || cVar.u() == null || !this.f27177g.u().g()) ? false : true;
    }

    public boolean f() {
        c cVar = this.f27177g;
        return (cVar == null || cVar.u() == null || !this.f27177g.u().i()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar) {
        if (lVar == null) {
            return;
        }
        g.a(this.r, lVar.am(), lVar.W(), new g.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.13
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                TTVideoWebPageActivity.this.o();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
            }
        }, com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar), lVar.Z() == 4);
    }

    public void c() {
        if (isFinishing()) {
            return;
        }
        if (this.f27175e.get()) {
            s();
            return;
        }
        if (this.f27171a == null) {
            d();
        }
        this.f27171a.a();
    }

    private void a(l lVar) {
        if (lVar == null) {
            return;
        }
        String W = lVar.W();
        if (TextUtils.isEmpty(W)) {
            LinearLayout linearLayout = this.q;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(W)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(W));
            if (b2 == null) {
                if (this.q != null) {
                    this.q.setVisibility(8);
                }
            } else if (TextUtils.isEmpty(b2.f())) {
                if (this.q != null) {
                    this.q.setVisibility(8);
                }
            } else {
                if (this.q != null) {
                    this.q.setVisibility(0);
                }
                String b3 = b2.b();
                String c2 = b2.c();
                String g2 = b2.g();
                if (TextUtils.isEmpty(g2)) {
                    g2 = com.bytedance.sdk.openadsdk.downloadnew.a.f.a(lVar);
                }
                if (this.m != null) {
                    this.m.setText(String.format(ad.a(this.r, "tt_open_app_detail_developer"), c2));
                }
                if (this.n != null) {
                    this.n.setText(String.format(ad.a(this.r, "tt_open_landing_page_app_name"), g2, b3));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        try {
            this.r.unregisterReceiver(this.al);
        } catch (Exception unused) {
        }
    }

    private JSONArray b(String str) {
        int i;
        JSONArray jSONArray = this.ab;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.ab;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf("&");
        if (indexOf == -1 || indexOf2 == -1 || (i = indexOf + 4) >= indexOf2) {
            return null;
        }
        String substring = str.substring(i, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(substring);
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.M) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTVideoWebPageActivity.15
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoWebPageActivity.this.M == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.M.setText(str);
            }
        });
    }

    private void a(c cVar) {
        com.bytedance.sdk.openadsdk.utils.u.f("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cVar.w() + ",position=" + cVar.n() + ",totalPlayDuration=" + cVar.p() + ",duration=" + cVar.s());
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.w()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.n()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.p()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.s()));
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.r.registerReceiver(this.al, intentFilter);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (q()) {
            al.a((View) this.j, 4);
        } else if (this.j == null || !q()) {
        } else {
            al.a((View) this.j, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.d
    public void a(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.ab = jSONArray;
        r();
    }

    public static boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() == null) {
                return false;
            }
            return TTVideoWebPageActivity.class.getName().equals(intent.getComponent().getClassName());
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.a("TTVideoWebPageActivity", "isThisClass error", th);
            return false;
        }
    }
}
