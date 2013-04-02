package com.baidu.tieba.recommend;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.loginshare.Token;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.LotteryActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.view.BaseWebView;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class RecommendActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.d {
    private static boolean m = false;
    private static long n = 0;
    private BaseWebView c;
    private ProgressBar d;
    private LinearLayout e;
    private u f;
    private TextView j;
    private TextView k;
    private boolean g = false;
    private boolean h = false;
    private boolean i = true;
    private boolean l = false;
    private RelativeLayout o = null;
    private String p = "0";
    private View.OnClickListener q = new t(this);

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.recommend_activity);
        this.b = TiebaApplication.b().ah();
        l();
        ae.a(this.o, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.b().aB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.b().w());
        if (!this.l && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.b.longValue() && this.c != null) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ae.a(this.o, i);
        if (this.c != null) {
            ae.a(this.c, i);
            i();
        }
    }

    private void l() {
        this.o = (RelativeLayout) findViewById(R.id.parent);
        this.e = (LinearLayout) findViewById(R.id.hotspot_webview_item);
        this.j = (TextView) this.e.findViewById(R.id.webview_fail);
        this.k = (TextView) this.e.findViewById(R.id.webview_crash_tip);
        this.d = (ProgressBar) findViewById(R.id.recommend_progress);
        if (TiebaApplication.b().ai() >= 5) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
        } else if (m()) {
            this.k.setVisibility(8);
            i();
        } else {
            this.k.setVisibility(0);
        }
    }

    private boolean m() {
        if (this.c == null) {
            try {
                this.c = new BaseWebView(this);
                ae.a(this.c, TiebaApplication.b().ah());
                this.c.setOnLoadUrlListener(this);
                this.c.setHorizontalScrollBarEnabled(false);
                this.c.setHorizontalScrollbarOverlay(false);
                this.c.setScrollBarStyle(33554432);
                this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.e.addView(this.c);
                return true;
            } catch (Exception e) {
                ag.b(getClass().getName(), "", "RecommendActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void n() {
        if (this.f != null) {
            this.f.a();
        }
    }

    public void i() {
        if (TiebaApplication.b().ai() == 0 && !m()) {
            this.k.setVisibility(0);
            return;
        }
        this.k.setVisibility(8);
        if (!this.l) {
            this.l = true;
            this.d.setVisibility(0);
            this.h = false;
            this.i = true;
            n();
            this.f = new u(this, null);
            this.f.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.h) {
            if (!this.i) {
                b(getResources().getString(R.string.neterror));
            } else {
                TiebaApplication.b().b(System.currentTimeMillis());
                this.c.scrollTo(0, 0);
            }
            this.l = false;
            this.d.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        int indexOf;
        if (str.contains("nearby=1")) {
            MainTabActivity.a(this, "goto_nearby");
        } else {
            int indexOf2 = str.indexOf("kz=") + 3;
            if (indexOf2 > 2) {
                int i = indexOf2;
                while (i < str.length() && str.charAt(i) != '&') {
                    i++;
                }
                String substring = str.substring(indexOf2, i);
                if (substring != null && substring.length() >= 0) {
                    PbActivity.a(this, substring, "hot_pblist");
                }
            } else {
                int indexOf3 = str.indexOf("kw=") + 3;
                if (indexOf3 > 2) {
                    int i2 = indexOf3;
                    while (i2 < str.length() && str.charAt(i2) != '&') {
                        i2++;
                    }
                    String decode = URLDecoder.decode(str.substring(indexOf3, i2));
                    if (decode != null && decode.length() >= 0) {
                        FrsActivity.a(this, decode, "tb_remindlist");
                    }
                } else if (str.indexOf("jump_lottery_native=1") != -1 && (indexOf = str.indexOf("lotteryurl=")) != -1) {
                    int i3 = indexOf + 11;
                    int i4 = i3;
                    while (i4 < str.length() && str.charAt(i4) != '&') {
                        i4++;
                    }
                    String decode2 = URLDecoder.decode(str.substring(i3, i4));
                    Token b = com.baidu.tieba.account.a.b(TiebaApplication.z());
                    if (b != null) {
                        LotteryActivity.a(this, str, decode2, b.mBduss, b.mPtoken, TiebaApplication.A());
                    } else {
                        LotteryActivity.a(this, str, decode2, null, null, TiebaApplication.A());
                    }
                } else if (str.indexOf("http://c.tieba.baidu.com/c/s/classic") != -1) {
                    int indexOf4 = str.indexOf("page=");
                    if (indexOf4 != -1) {
                        int i5 = indexOf4 + 5;
                        int i6 = i5;
                        while (i6 < str.length() && str.charAt(i6) != '&') {
                            i6++;
                        }
                        String decode3 = URLDecoder.decode(str.substring(i5, i6));
                        if (decode3 != null && decode3.length() >= 0) {
                            this.p = decode3;
                        }
                    } else {
                        this.p = "0";
                    }
                    i();
                } else {
                    ai.c(this, str);
                }
            }
        }
        return true;
    }
}
