package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.view.BaseWebView;
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
    private Button h = null;
    private RelativeLayout i = null;
    private RelativeLayout j = null;
    private TextView k = null;
    private View.OnClickListener l = null;
    private BaseWebView m = null;
    private ProgressBar n = null;
    private LinearLayout o = null;
    private x p = null;
    private w q = null;
    private boolean r = false;
    private boolean s = true;
    private TextView t = null;
    private TextView u = null;
    private boolean v = false;
    private String y = "1";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tag_content_activity);
        m();
        n();
    }

    private void m() {
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

    private void n() {
        this.i = (RelativeLayout) findViewById(R.id.parent);
        this.j = (RelativeLayout) findViewById(R.id.title);
        this.k = (TextView) findViewById(R.id.title_text);
        this.o = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.g = (Button) findViewById(R.id.attention);
        this.h = (Button) findViewById(R.id.back);
        this.t = (TextView) this.o.findViewById(R.id.webview_fail);
        this.u = (TextView) this.o.findViewById(R.id.webview_crash_tip);
        this.n = (ProgressBar) findViewById(R.id.tag_progress);
        this.l = new v(this);
        this.g.setOnClickListener(this.l);
        this.h.setOnClickListener(this.l);
        if (this.f.booleanValue()) {
            this.g.setVisibility(8);
        }
        this.k.setText(this.c);
        if (p()) {
            this.u.setVisibility(8);
            j();
            return;
        }
        this.u.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        this.g.setVisibility(8);
        String y = TiebaApplication.y();
        this.q = new w(this, y != null && y.length() > 0);
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
        ae.a(this.i, i);
        ae.c(this.j, i);
        ae.c(this.k, i);
        ae.e((TextView) this.h, i);
        ae.d((TextView) this.g, i);
        if (this.m != null) {
            ae.a(this.m, i);
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.b().w());
        if (!this.v && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.b.longValue() && this.m != null) {
            j();
        }
    }

    public void j() {
        if (TiebaApplication.b().ai() == 0 && !p()) {
            this.u.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
        if (!this.v) {
            this.v = true;
            this.n.setVisibility(0);
            this.r = false;
            this.s = true;
            q();
            this.p = new x(this, null);
            this.p.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.r) {
            if (!this.s) {
                b(getResources().getString(R.string.neterror));
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
                    PbActivity.a(this, a, "tagthread");
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
            j();
        } else {
            ai.d(this, str);
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

    private boolean p() {
        if (this.m == null) {
            try {
                this.m = new BaseWebView(this);
                ae.a(this.m, TiebaApplication.b().ah());
                this.m.setOnLoadUrlListener(this);
                this.m.setHorizontalScrollBarEnabled(false);
                this.m.setHorizontalScrollbarOverlay(false);
                this.m.setScrollBarStyle(33554432);
                this.m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.o.addView(this.m);
                return true;
            } catch (Exception e) {
                ag.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void q() {
        if (this.p != null) {
            this.p.a();
        }
    }
}
