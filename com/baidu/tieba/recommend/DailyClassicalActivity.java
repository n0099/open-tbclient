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
public class DailyClassicalActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.d {
    private static boolean q = false;
    private static long r = 0;
    private Button c = null;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.day_classical_activity);
        l();
    }

    private void l() {
        this.d = (RelativeLayout) findViewById(R.id.parent);
        this.e = (RelativeLayout) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.title_text);
        this.j = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.c = (Button) findViewById(R.id.back);
        this.n = (TextView) this.j.findViewById(R.id.webview_fail);
        this.o = (TextView) this.j.findViewById(R.id.webview_crash_tip);
        this.i = (ProgressBar) findViewById(R.id.tag_progress);
        this.g = new a(this);
        this.c.setOnClickListener(this.g);
        if (n()) {
            this.o.setVisibility(8);
            i();
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
        ae.a(this.d, i);
        ae.c(this.e, i);
        ae.c(this.f, i);
        ae.e((TextView) this.c, i);
        if (this.h != null) {
            ae.a(this.h, i);
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.b().w());
        if (!this.p && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.b.longValue() && this.h != null) {
            i();
        }
    }

    public void i() {
        if (TiebaApplication.b().ai() == 0 && !n()) {
            this.o.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
        if (!this.p) {
            this.p = true;
            this.i.setVisibility(0);
            this.l = false;
            this.m = true;
            o();
            this.k = new b(this, null);
            this.k.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.l) {
            if (!this.m) {
                b(getResources().getString(R.string.neterror));
            }
            this.p = false;
            this.i.setVisibility(8);
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
                    PbActivity.a(this, a, "gettogether");
                }
            } else if (str.contains("kw=")) {
                String a2 = a(str, "kw=");
                if (a2 != null && a2.length() >= 0) {
                    FrsActivity.a(this, a2, "gettogether");
                }
            } else if (str.contains("tag_name=") && str.contains("tag_id=")) {
                String a3 = a(str, "tag_id=");
                String a4 = a(str, "tag_name=");
                String a5 = a(str, "tag_type=");
                String a6 = a(str, "tag_is_selected=");
                if (a3 != null && a3.length() >= 0) {
                    TagContentActivity.a(this, a3, a4, a5, a6);
                }
            }
            return true;
        }
        if (str.contains("jumptoapp_browser=classic_everyday")) {
            if (str.contains("pn=")) {
                String a7 = a(str, "pn=");
                if (a7 != null && a7.length() >= 0) {
                    this.s = a7;
                }
            } else {
                this.s = "1";
            }
            i();
        } else {
            ai.d(this, String.valueOf(str) + "&_client_version=" + com.baidu.tieba.a.i.h());
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

    private boolean n() {
        if (this.h == null) {
            try {
                this.h = new BaseWebView(this);
                ae.a(this.h, TiebaApplication.b().ah());
                this.h.setOnLoadUrlListener(this);
                this.h.setHorizontalScrollBarEnabled(false);
                this.h.setHorizontalScrollbarOverlay(false);
                this.h.setScrollBarStyle(33554432);
                this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.j.addView(this.h);
                return true;
            } catch (Exception e) {
                ag.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void o() {
        if (this.k != null) {
            this.k.a();
        }
    }
}
