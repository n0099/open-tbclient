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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ac;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.LotteryActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class RecommendActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.d {
    private static boolean m = false;
    private static long n = 0;
    private BaseWebView c;
    private ProgressBar d;
    private LinearLayout e;
    private g f;
    private TextView j;
    private TextView k;
    private boolean g = false;
    private boolean h = false;
    private boolean i = true;
    private boolean l = false;
    private RelativeLayout o = null;
    private String p = "0";
    private View.OnClickListener q = new f(this);

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.d().q();
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.recommend_activity);
        this.b = TiebaApplication.d().ai();
        m();
        ac.a(this.o, this.b);
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
        TiebaApplication.d().aB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.d().y());
        if (!this.l && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.b.longValue() && this.c != null) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ac.a(this.o, i);
        if (this.c != null) {
            ac.a(this.c, i);
            b();
        }
    }

    private void m() {
        this.o = (RelativeLayout) findViewById(R.id.parent);
        this.e = (LinearLayout) findViewById(R.id.hotspot_webview_item);
        this.j = (TextView) this.e.findViewById(R.id.webview_fail);
        this.k = (TextView) this.e.findViewById(R.id.webview_crash_tip);
        this.d = (ProgressBar) findViewById(R.id.recommend_progress);
        if (TiebaApplication.d().aj() >= 5) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
        } else if (n()) {
            this.k.setVisibility(8);
            b();
        } else {
            this.k.setVisibility(0);
        }
    }

    private boolean n() {
        if (this.c == null) {
            try {
                this.c = new BaseWebView(this);
                ac.a(this.c, TiebaApplication.d().ai());
                this.c.setOnLoadUrlListener(this);
                this.c.setHorizontalScrollBarEnabled(false);
                this.c.setHorizontalScrollbarOverlay(false);
                this.c.setScrollBarStyle(33554432);
                this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.e.addView(this.c);
                return true;
            } catch (Exception e) {
                ae.b(getClass().getName(), "", "RecommendActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void o() {
        if (this.f != null) {
            this.f.cancel();
        }
    }

    public void b() {
        if (TiebaApplication.d().aj() == 0 && !n()) {
            this.k.setVisibility(0);
            return;
        }
        this.k.setVisibility(8);
        if (!this.l) {
            this.l = true;
            this.d.setVisibility(0);
            this.h = false;
            this.i = true;
            o();
            this.f = new g(this, null);
            this.f.setPriority(3);
            this.f.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.h) {
            if (!this.i) {
                a(getResources().getString(R.string.neterror));
            } else {
                TiebaApplication.d().b(System.currentTimeMillis());
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
                    NewPbActivity.a(this, substring, null, "hot_pblist");
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
                    Token b = com.baidu.tieba.account.a.b(TiebaApplication.A());
                    if (b != null) {
                        LotteryActivity.a(this, str, decode2, b.mBduss, b.mPtoken, TiebaApplication.B());
                    } else {
                        LotteryActivity.a(this, str, decode2, null, null, TiebaApplication.B());
                    }
                } else if (str.indexOf(com.baidu.tieba.a.i.h) != -1) {
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
                    b();
                } else {
                    ag.c(this, str);
                }
            }
        }
        return true;
    }
}
