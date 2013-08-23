package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ao;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class DailyClassicalActivity extends com.baidu.tieba.g implements com.baidu.tieba.view.d {
    private static boolean q = false;
    private static long r = 0;

    /* renamed from: a  reason: collision with root package name */
    private ImageView f1668a = null;
    private RelativeLayout b = null;
    private RelativeLayout c = null;
    private TextView d = null;
    private View.OnClickListener e = null;
    private BaseWebView f = null;
    private ProgressBar g = null;
    private LinearLayout j = null;
    private b k = null;
    private boolean l = false;
    private boolean m = true;
    private TextView n = null;
    private TextView o = null;
    private boolean p = false;
    private String s = "1";

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.g().w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.day_classical_activity);
        k();
    }

    private void k() {
        this.b = (RelativeLayout) findViewById(R.id.parent);
        this.c = (RelativeLayout) findViewById(R.id.title);
        this.d = (TextView) findViewById(R.id.title_text);
        this.j = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.f1668a = (ImageView) findViewById(R.id.back);
        this.n = (TextView) this.j.findViewById(R.id.webview_fail);
        this.o = (TextView) this.j.findViewById(R.id.webview_crash_tip);
        this.g = (ProgressBar) findViewById(R.id.tag_progress);
        this.e = new a(this);
        this.f1668a.setOnClickListener(this.e);
        if (m()) {
            this.o.setVisibility(8);
            b();
            return;
        }
        this.o.setVisibility(0);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, DailyClassicalActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        ao.a(this.b, i);
        ao.d(this.c, i);
        ao.f(this.d, i);
        ao.a(this.f1668a, i);
        if (this.f != null) {
            ao.a(this.f, i);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.g().D());
        if (!this.p && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.data.g.d.longValue() && this.f != null) {
            b();
        }
    }

    public void b() {
        if (TiebaApplication.g().ao() == 0 && !m()) {
            this.o.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
        if (!this.p) {
            this.p = true;
            this.g.setVisibility(0);
            this.l = false;
            this.m = true;
            n();
            this.k = new b(this, null);
            this.k.setPriority(3);
            this.k.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.l) {
            if (!this.m) {
                a(getResources().getString(R.string.neterror));
            }
            this.p = false;
            this.g.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!ae.a(this, str)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String a2 = a(str, "pn=");
                    if (a2 != null && a2.length() >= 0) {
                        this.s = a2;
                    }
                } else {
                    this.s = "1";
                }
                b();
            } else {
                UtilHelper.d(this, String.valueOf(str) + "&_client_version=" + com.baidu.tieba.data.g.j());
            }
        }
        return true;
    }

    private String a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            return URLDecoder.decode(str.substring(length, i));
        }
        return "";
    }

    private boolean m() {
        boolean z = false;
        if (this.f == null) {
            try {
                if (UtilHelper.f(this)) {
                    super.a(getString(R.string.web_view_corrupted));
                } else {
                    this.f = new BaseWebView(this);
                    ao.a(this.f, TiebaApplication.g().an());
                    this.f.setOnLoadUrlListener(this);
                    this.f.setHorizontalScrollBarEnabled(false);
                    this.f.setHorizontalScrollbarOverlay(false);
                    this.f.setScrollBarStyle(33554432);
                    this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.j.addView(this.f);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                aq.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void n() {
        if (this.k != null) {
            this.k.cancel();
        }
    }
}
