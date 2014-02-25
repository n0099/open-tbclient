package com.baidu.tieba.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.recommend.WebviewHelper;
import com.baidu.tieba.view.BaseWebView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.HashMap;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class TbWebViewActivity extends com.baidu.tieba.f implements com.baidu.tieba.view.e {
    private static HashMap<String, ca> a = null;
    private boolean n;
    private com.baidu.tieba.recommend.ac o;
    private NavigationBar r;
    private boolean b = true;
    private String c = null;
    private String d = null;
    private boolean e = true;
    private boolean f = false;
    private boolean g = true;
    private RelativeLayout h = null;
    private BaseWebView i = null;
    private ProgressBar j = null;
    private LinearLayout k = null;
    private TextView l = null;
    private boolean m = false;
    private Handler p = new Handler();
    private Runnable q = new bw(this);

    @Override // com.baidu.tieba.f
    public boolean getGpuSwitch() {
        return TiebaApplication.g().u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tb_webview_activity);
        Intent intent = getIntent();
        this.c = intent.getStringExtra("tag_title");
        this.d = intent.getStringExtra("tag_url");
        this.e = intent.getBooleanExtra("tag_back", true);
        this.f = intent.getBooleanExtra("tag_cookie", false);
        this.g = intent.getBooleanExtra("tag_refresh", false);
        this.n = intent.getBooleanExtra("tag_enable_js", false);
        this.b = intent.getBooleanExtra("tag_navigation_bar", false);
        if (bs.c(this.d)) {
            BdUtilHelper.a((Context) this, getResources().getString(R.string.url_is_null));
            return;
        }
        b();
        if (this.f) {
            UtilHelper.c(this);
        }
        c();
    }

    private void b() {
        this.h = (RelativeLayout) findViewById(R.id.parent);
        this.r = (NavigationBar) findViewById(R.id.view_navigation_bar);
        if (this.b) {
            this.r.a(this.c);
            if (this.e) {
                this.r.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            }
            if (this.g) {
                this.r.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_refresh, new bx(this));
            }
        } else {
            this.r.setVisibility(8);
        }
        this.k = (LinearLayout) findViewById(R.id.webview_container);
        this.l = (TextView) this.k.findViewById(R.id.webview_crash_tip);
        this.j = (ProgressBar) findViewById(R.id.webview_progress);
        if (e()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
    }

    private void c() {
        if (!bs.c(this.d)) {
            if (this.d.indexOf("_client_version") < 0) {
                if (bs.c(Uri.parse(this.d).getQuery())) {
                    this.d = String.valueOf(this.d) + "?_client_version=" + com.baidu.tieba.data.i.u();
                } else {
                    this.d = String.valueOf(this.d) + "&_client_version=" + com.baidu.tieba.data.i.u();
                }
            }
            if (this.d.indexOf("nohead=1") < 0) {
                this.d = String.valueOf(this.d) + "&nohead=1";
            }
        }
        this.p.postDelayed(this.q, 500L);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, HashMap<String, ca> hashMap) {
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_title", str);
        intent.putExtra("tag_url", str2);
        intent.putExtra("tag_navigation_bar", true);
        intent.putExtra("tag_back", z);
        intent.putExtra("tag_refresh", z2);
        intent.putExtra("tag_cookie", z3);
        intent.putExtra("tag_enable_js", z4);
        a = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, String str, boolean z, HashMap<String, ca> hashMap) {
        Intent intent = new Intent(context, TbWebViewActivity.class);
        intent.putExtra("tag_url", str);
        intent.putExtra("tag_navigation_bar", false);
        intent.putExtra("tag_cookie", z);
        intent.putExtra("tag_enable_js", true);
        a = hashMap;
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        a(context, str, str2, true, z, true, false, null);
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void b(Context context, String str, String str2) {
        a(context, str, str2, true, false, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bq.a(this.h, i);
        if (this.i != null) {
            bq.a(this.i, i);
        }
        if (this.r != null && this.r.getVisibility() == 0) {
            this.r.c(i);
        }
    }

    @Override // com.baidu.tieba.view.e
    public boolean a(WebView webView, String str) {
        if (bs.c(str)) {
            return false;
        }
        if (WebviewHelper.commonJumpHelper(this, str)) {
            return true;
        }
        this.d = str;
        a();
        return true;
    }

    private void d() {
        if (a == null) {
            a = new HashMap<>();
        }
        if (!a.containsKey("TbJsBridge")) {
            a.put("TbJsBridge", new by(this));
        }
        for (String str : a.keySet()) {
            this.i.addJavascriptInterface(a.get(str).a(this), str);
        }
    }

    private boolean e() {
        if (this.i == null) {
            try {
                this.i = new BaseWebView(this);
                bq.a(this.i, TiebaApplication.g().al());
                this.i.getSettings().setJavaScriptEnabled(true);
                this.i.setOnLoadUrlListener(this);
                this.i.setHorizontalScrollBarEnabled(false);
                this.i.setHorizontalScrollbarOverlay(false);
                this.i.setInitialScale(100);
                this.i.setScrollBarStyle(33554432);
                this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.i.setWebChromeClient(new bz(this));
                this.k.addView(this.i);
                if (this.n) {
                    d();
                    return true;
                }
                return true;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "TbWebViewActivity.createWebView error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public void a() {
        this.l.setVisibility(8);
        if (!this.m) {
            this.m = true;
            if (this.i != null && URLUtil.isNetworkUrl(this.d)) {
                this.j.setVisibility(0);
                this.i.loadUrl(this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        boolean z;
        super.onResume();
        String str3 = "";
        com.baidu.tieba.account.o a2 = com.baidu.tieba.account.a.a(TiebaApplication.D());
        if (a2 != null) {
            if (a2.a != null) {
                str3 = a2.a;
            }
            if (a2.b != null) {
                str = str3;
                str2 = a2.b;
                com.baidu.tieba.recommend.ac acVar = new com.baidu.tieba.recommend.ac(str, str2);
                if (this.o == null && (this.o == null || !this.o.equals(acVar))) {
                    z = true;
                } else {
                    z = false;
                }
                this.o = acVar;
                if (this.i == null && z) {
                    UtilHelper.c(this);
                    this.p.postDelayed(this.q, 100L);
                    return;
                }
            }
        }
        str = str3;
        str2 = "";
        com.baidu.tieba.recommend.ac acVar2 = new com.baidu.tieba.recommend.ac(str, str2);
        if (this.o == null) {
        }
        z = false;
        this.o = acVar2;
        if (this.i == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.p != null) {
            this.p.removeCallbacks(this.q);
        }
        TiebaApplication.g().b((com.baidu.tieba.f) this);
    }
}
