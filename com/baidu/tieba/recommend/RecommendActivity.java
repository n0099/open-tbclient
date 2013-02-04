package com.baidu.tieba.recommend;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.view.BaseWebView;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class RecommendActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.e {
    private static boolean l = false;
    private static long m = 0;
    private BaseWebView b;
    private ProgressBar c;
    private LinearLayout d;
    private r e;
    private TextView i;
    private TextView j;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean k = false;
    private String n = "0";
    private View.OnClickListener o = new q(this);

    public static void a(long j) {
        m = j;
    }

    public static void a(boolean z) {
        l = z;
    }

    private void k() {
        this.d = (LinearLayout) findViewById(R.id.hotspot_webview_item);
        this.i = (TextView) this.d.findViewById(R.id.webview_fail);
        this.j = (TextView) this.d.findViewById(R.id.webview_crash_tip);
        this.c = (ProgressBar) findViewById(R.id.recommend_progress);
        if (TiebaApplication.a().ad() >= 5) {
            this.i.setVisibility(8);
            this.j.setVisibility(0);
        } else if (!l()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
            g();
        }
    }

    private boolean l() {
        if (this.b == null) {
            try {
                this.b = new BaseWebView(this);
                this.b.setOnLoadUrlListener(this);
                this.b.setHorizontalScrollBarEnabled(false);
                this.b.setHorizontalScrollbarOverlay(false);
                this.b.setScrollBarStyle(33554432);
                this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.d.addView(this.b);
                return true;
            } catch (Exception e) {
                ae.b(getClass().getName(), "", "RecommendActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void m() {
        if (this.e != null) {
            this.e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.g) {
            if (this.h) {
                TiebaApplication.a().a(System.currentTimeMillis());
                this.b.scrollTo(0, 0);
            } else {
                b(getResources().getString(R.string.neterror));
            }
            this.k = false;
            this.c.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.e
    public boolean a(WebView webView, String str) {
        int indexOf = str.indexOf("kz=") + 3;
        if (indexOf > 2) {
            int i = indexOf;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            String substring = str.substring(indexOf, i);
            if (substring != null && substring.length() >= 0) {
                PbActivity.a(this, substring, "hot_pblist");
            }
        } else {
            int indexOf2 = str.indexOf("kw=") + 3;
            if (indexOf2 > 2) {
                int i2 = indexOf2;
                while (i2 < str.length() && str.charAt(i2) != '&') {
                    i2++;
                }
                String decode = URLDecoder.decode(str.substring(indexOf2, i2));
                if (decode != null && decode.length() >= 0) {
                    FrsActivity.a(this, decode, (String) null);
                }
            } else if (str.indexOf("http://c.tieba.baidu.com/c/s/classic") != -1) {
                int indexOf3 = str.indexOf("page=");
                if (indexOf3 != -1) {
                    int i3 = indexOf3 + 5;
                    int i4 = i3;
                    while (i4 < str.length() && str.charAt(i4) != '&') {
                        i4++;
                    }
                    String decode2 = URLDecoder.decode(str.substring(i3, i4));
                    if (decode2 != null && decode2.length() >= 0) {
                        this.n = decode2;
                    }
                } else {
                    this.n = "0";
                }
                g();
            } else {
                ag.c(this, str);
            }
        }
        return true;
    }

    public void g() {
        if (TiebaApplication.a().ad() == 0 && !l()) {
            this.j.setVisibility(0);
            return;
        }
        this.j.setVisibility(8);
        if (this.k) {
            return;
        }
        this.k = true;
        this.c.setVisibility(0);
        this.g = false;
        this.h = true;
        m();
        this.e = new r(this, null);
        this.e.execute(new Object[0]);
    }

    public void h() {
        this.n = "0";
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.recommend_activity);
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.a().as();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        Long valueOf = Long.valueOf(TiebaApplication.a().s());
        if (!this.k && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.h.b.longValue() && this.b != null) {
            g();
        }
        super.onResume();
    }
}
