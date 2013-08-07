package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class TagContentActivity extends com.baidu.tieba.g implements com.baidu.tieba.view.d {
    private static boolean w = false;
    private static long x = 0;

    /* renamed from: a  reason: collision with root package name */
    private String f1628a = null;
    private String b = null;
    private String c = null;
    private Boolean d = false;
    private Button e = null;
    private ImageView f = null;
    private RelativeLayout g = null;
    private RelativeLayout j = null;
    private TextView k = null;
    private View.OnClickListener l = null;
    private BaseWebView m = null;
    private ProgressBar n = null;
    private LinearLayout o = null;
    private be p = null;
    private bd q = null;
    private boolean r = false;
    private boolean s = true;
    private TextView t = null;
    private TextView u = null;
    private boolean v = false;
    private String y = "1";

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tag_content_activity);
        l();
        m();
    }

    private void l() {
        this.f1628a = getIntent().getStringExtra("tag_name");
        this.b = getIntent().getStringExtra("tag_id");
        if (NewHomeActivity.f1626a.contains(this.b)) {
            this.c = "1";
            this.d = true;
            return;
        }
        this.c = getIntent().getStringExtra("tag_is_selected");
        if (this.c == "1") {
            this.d = true;
        }
    }

    private void m() {
        this.g = (RelativeLayout) findViewById(R.id.parent);
        this.j = (RelativeLayout) findViewById(R.id.title);
        this.k = (TextView) findViewById(R.id.title_text);
        this.o = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.e = (Button) findViewById(R.id.attention);
        this.f = (ImageView) findViewById(R.id.back);
        this.t = (TextView) this.o.findViewById(R.id.webview_fail);
        this.u = (TextView) this.o.findViewById(R.id.webview_crash_tip);
        this.n = (ProgressBar) findViewById(R.id.tag_progress);
        this.l = new bc(this);
        this.e.setOnClickListener(this.l);
        this.f.setOnClickListener(this.l);
        if (this.d.booleanValue()) {
            this.e.setVisibility(8);
        }
        this.k.setText(this.f1628a);
        if (o()) {
            this.u.setVisibility(8);
            c();
            return;
        }
        this.u.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.e.setVisibility(8);
        String E = TiebaApplication.E();
        this.q = new bd(this, E != null && E.length() > 0);
        this.q.setPriority(3);
        this.q.execute(new Object[0]);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, TagContentActivity.class);
        intent.putExtra("tag_id", str);
        intent.putExtra("tag_name", str2);
        intent.putExtra("tag_type", str3);
        intent.putExtra("tag_is_selected", str4);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.a(this.g, i);
        com.baidu.tieba.util.ah.d(this.j, i);
        com.baidu.tieba.util.ah.f(this.k, i);
        com.baidu.tieba.util.ah.a(this.f, i);
        com.baidu.tieba.util.ah.g((TextView) this.e, i);
        if (this.m != null) {
            com.baidu.tieba.util.ah.a(this.m, i);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.f().D());
        if (!this.v && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.data.g.d.longValue() && this.m != null) {
            c();
        }
    }

    public void c() {
        if (TiebaApplication.f().av() == 0 && !o()) {
            this.u.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
        if (!this.v) {
            this.v = true;
            this.n.setVisibility(0);
            this.r = false;
            this.s = true;
            p();
            this.p = new be(this, null);
            this.p.setPriority(3);
            this.p.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.r) {
            if (!this.s) {
                a(getResources().getString(R.string.neterror));
            }
            this.v = false;
            this.n.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!bf.a(this, str)) {
            if (str.contains("c/s/tag/tagthread")) {
                if (str.contains("pn=")) {
                    String a2 = a(str, "pn=");
                    if (a2 != null && a2.length() >= 0) {
                        this.y = a2;
                    }
                } else {
                    this.y = "1";
                }
                c();
            } else {
                com.baidu.tieba.util.am.d(this, str);
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
        boolean z = false;
        if (this.m == null) {
            try {
                if (com.baidu.tieba.util.am.f(this)) {
                    super.a(getString(R.string.web_view_corrupted));
                } else {
                    this.m = new BaseWebView(this);
                    com.baidu.tieba.util.ah.a(this.m, TiebaApplication.f().au());
                    this.m.setOnLoadUrlListener(this);
                    this.m.setHorizontalScrollBarEnabled(false);
                    this.m.setHorizontalScrollbarOverlay(false);
                    this.m.setScrollBarStyle(33554432);
                    this.m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.o.addView(this.m);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void p() {
        if (this.p != null) {
            this.p.cancel();
        }
    }
}
