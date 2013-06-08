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
import com.baidu.tieba.d.ac;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class DailyClassicalActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.d {
    private static boolean q = false;
    private static long r = 0;
    private ImageView c = null;
    private RelativeLayout d = null;
    private RelativeLayout e = null;
    private TextView f = null;
    private View.OnClickListener g = null;
    private BaseWebView h = null;
    private ProgressBar i = null;
    private LinearLayout j = null;
    private b k = null;
    private boolean l = false;
    private boolean m = true;
    private TextView n = null;
    private TextView o = null;
    private boolean p = false;
    private String s = "1";

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.d().r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.day_classical_activity);
        m();
    }

    private void m() {
        this.d = (RelativeLayout) findViewById(R.id.parent);
        this.e = (RelativeLayout) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.title_text);
        this.j = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.c = (ImageView) findViewById(R.id.back);
        this.n = (TextView) this.j.findViewById(R.id.webview_fail);
        this.o = (TextView) this.j.findViewById(R.id.webview_crash_tip);
        this.i = (ProgressBar) findViewById(R.id.tag_progress);
        this.g = new a(this);
        this.c.setOnClickListener(this.g);
        if (o()) {
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
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ac.a(this.d, i);
        ac.d(this.e, i);
        ac.f(this.f, i);
        ac.a(this.c, i);
        if (this.h != null) {
            ac.a(this.h, i);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.d().z());
        if (!this.p && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.b.longValue() && this.h != null) {
            b();
        }
    }

    public void b() {
        if (TiebaApplication.d().as() == 0 && !o()) {
            this.o.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
        if (!this.p) {
            this.p = true;
            this.i.setVisibility(0);
            this.l = false;
            this.m = true;
            p();
            this.k = new b(this, null);
            this.k.setPriority(3);
            this.k.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.l) {
            if (!this.m) {
                a(getResources().getString(R.string.neterror));
            }
            this.p = false;
            this.i.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!i.a(this, str)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String a = a(str, "pn=");
                    if (a != null && a.length() >= 0) {
                        this.s = a;
                    }
                } else {
                    this.s = "1";
                }
                b();
            } else {
                ag.d(this, String.valueOf(str) + "&_client_version=" + com.baidu.tieba.a.i.i());
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

    private boolean o() {
        if (this.h == null) {
            try {
                this.h = new BaseWebView(this);
                ac.a(this.h, TiebaApplication.d().ar());
                this.h.setOnLoadUrlListener(this);
                this.h.setHorizontalScrollBarEnabled(false);
                this.h.setHorizontalScrollbarOverlay(false);
                this.h.setScrollBarStyle(33554432);
                this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.j.addView(this.h);
                return true;
            } catch (Exception e) {
                ae.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void p() {
        if (this.k != null) {
            this.k.cancel();
        }
    }
}
