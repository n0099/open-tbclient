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
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ac;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class TagContentActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.d {
    private static boolean w = false;
    private static long x = 0;
    private String c = null;
    private String d = null;
    private String e = null;
    private Boolean f = false;
    private Button g = null;
    private ImageView h = null;
    private RelativeLayout i = null;
    private RelativeLayout j = null;
    private TextView k = null;
    private View.OnClickListener l = null;
    private BaseWebView m = null;
    private ProgressBar n = null;
    private LinearLayout o = null;
    private j p = null;
    private i q = null;
    private boolean r = false;
    private boolean s = true;
    private TextView t = null;
    private TextView u = null;
    private boolean v = false;
    private String y = "1";

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.d().q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tag_content_activity);
        n();
        o();
    }

    private void n() {
        this.c = getIntent().getStringExtra("tag_name");
        this.d = getIntent().getStringExtra("tag_id");
        if (NewHomeActivity.c.contains(this.d)) {
            this.e = "1";
            this.f = true;
            return;
        }
        this.e = getIntent().getStringExtra("tag_is_selected");
        if (this.e == "1") {
            this.f = true;
        }
    }

    private void o() {
        this.i = (RelativeLayout) findViewById(R.id.parent);
        this.j = (RelativeLayout) findViewById(R.id.title);
        this.k = (TextView) findViewById(R.id.title_text);
        this.o = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.g = (Button) findViewById(R.id.attention);
        this.h = (ImageView) findViewById(R.id.back);
        this.t = (TextView) this.o.findViewById(R.id.webview_fail);
        this.u = (TextView) this.o.findViewById(R.id.webview_crash_tip);
        this.n = (ProgressBar) findViewById(R.id.tag_progress);
        this.l = new h(this);
        this.g.setOnClickListener(this.l);
        this.h.setOnClickListener(this.l);
        if (this.f.booleanValue()) {
            this.g.setVisibility(8);
        }
        this.k.setText(this.c);
        if (q()) {
            this.u.setVisibility(8);
            c();
            return;
        }
        this.u.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.g.setVisibility(8);
        String z = TiebaApplication.z();
        this.q = new i(this, z != null && z.length() > 0);
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
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ac.a(this.i, i);
        ac.d(this.j, i);
        ac.f(this.k, i);
        ac.a(this.h, i);
        ac.g((TextView) this.g, i);
        if (this.m != null) {
            ac.a(this.m, i);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.d().y());
        if (!this.v && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.b.longValue() && this.m != null) {
            c();
        }
    }

    public void c() {
        if (TiebaApplication.d().aj() == 0 && !q()) {
            this.u.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
        if (!this.v) {
            this.v = true;
            this.n.setVisibility(0);
            this.r = false;
            this.s = true;
            r();
            this.p = new j(this, null);
            this.p.setPriority(3);
            this.p.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
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
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("nearby=1")) {
                MainTabActivity.a(this, "goto_nearby");
            } else if (str.contains("kz=")) {
                String a = a(str, "kz=");
                if (a != null && a.length() >= 0) {
                    NewPbActivity.a(this, a, null, "tagthread");
                }
            } else if (str.contains("kw=")) {
                String a2 = a(str, "kw=");
                if (a2 != null && a2.length() >= 0) {
                    FrsActivity.a(this, a2, "tagthread");
                }
            }
            return true;
        }
        if (str.contains("c/s/tag/tagthread")) {
            if (str.contains("pn=")) {
                String a3 = a(str, "pn=");
                if (a3 != null && a3.length() >= 0) {
                    this.y = a3;
                }
            } else {
                this.y = "1";
            }
            c();
        } else {
            ag.d(this, str);
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

    private boolean q() {
        if (this.m == null) {
            try {
                this.m = new BaseWebView(this);
                ac.a(this.m, TiebaApplication.d().ai());
                this.m.setOnLoadUrlListener(this);
                this.m.setHorizontalScrollBarEnabled(false);
                this.m.setHorizontalScrollbarOverlay(false);
                this.m.setScrollBarStyle(33554432);
                this.m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.o.addView(this.m);
                return true;
            } catch (Exception e) {
                ae.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.p != null) {
            this.p.cancel();
        }
    }
}
