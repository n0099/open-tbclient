package com.baidu.tieba.recommend;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.af;
import com.baidu.tieba.d.ac;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.ag;
import com.baidu.tieba.d.k;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NewHomeActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.d {
    private j d;
    private Button e = null;
    private ImageView f = null;
    private ImageView g = null;
    private RelativeLayout h = null;
    private RelativeLayout i = null;
    private TextView j = null;
    private View.OnClickListener k = null;
    private BaseWebView l = null;
    private ProgressBar m = null;
    private LinearLayout n = null;
    private e o = null;
    private boolean p = false;
    private boolean q = false;
    private boolean r = true;
    private TextView s = null;
    private TextView t = null;
    private boolean u = false;
    private String x = "1";
    private d y;
    private static boolean v = false;
    private static long w = 0;
    public static final ArrayList c = new ArrayList();

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.e().s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_home_activity);
        o();
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            n();
        }
    }

    private void n() {
        String e = af.e();
        if (e != null && e.length() > 0) {
            this.y = new d(this, e);
            this.y.setPriority(3);
            this.y.execute(new String[0]);
        }
    }

    private void o() {
        this.h = (RelativeLayout) findViewById(R.id.parent);
        this.i = (RelativeLayout) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.title_text);
        this.f = (ImageView) findViewById(R.id.search);
        this.g = (ImageView) findViewById(R.id.refresh);
        this.e = (Button) findViewById(R.id.edit_tag_btn);
        this.n = (LinearLayout) findViewById(R.id.home_webview_item);
        this.s = (TextView) this.n.findViewById(R.id.webview_fail);
        this.t = (TextView) this.n.findViewById(R.id.webview_crash_tip);
        this.m = (ProgressBar) findViewById(R.id.recommend_progress);
        this.k = new c(this);
        this.e.setOnClickListener(this.k);
        this.f.setOnClickListener(this.k);
        this.g.setOnClickListener(this.k);
        if (TiebaApplication.e().at() >= 5) {
            this.s.setVisibility(8);
            this.t.setVisibility(0);
        } else if (s()) {
            this.t.setVisibility(8);
            p();
            b();
        } else {
            this.t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        String b = k.b(10);
        if (b != null && b.length() > 1) {
            this.p = true;
            this.l.loadDataWithBaseURL(com.baidu.tieba.a.i.e, b, "text/html", BdUtil.UTF8, "");
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i2) {
            case -1:
                String C = TiebaApplication.C();
                if (C != null && C.length() > 0) {
                    n();
                }
                b();
                return;
            default:
                return;
        }
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
        TiebaApplication.e().aL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        super.onResume();
        String str3 = "";
        Token b = com.baidu.tieba.account.a.b(TiebaApplication.D());
        if (b != null) {
            if (b.mBduss != null) {
                str3 = b.mBduss;
            }
            if (b.mPtoken != null) {
                str = str3;
                str2 = b.mPtoken;
                j jVar = new j(str, str2);
                boolean z = this.d == null && (this.d == null || !this.d.equals(jVar));
                this.d = jVar;
                if (this.l == null && z) {
                    b();
                    return;
                } else if (this.l == null && !this.u) {
                    if (System.currentTimeMillis() - Long.valueOf(TiebaApplication.e().A()).longValue() > com.baidu.tieba.a.i.b.longValue()) {
                        b();
                        return;
                    }
                    return;
                }
            }
        }
        str = str3;
        str2 = "";
        j jVar2 = new j(str, str2);
        if (this.d == null) {
        }
        this.d = jVar2;
        if (this.l == null) {
        }
        if (this.l == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ac.a(this.h, i);
        ac.d(this.i, i);
        ac.f(this.j, i);
        ac.b(this.g, i);
        ac.c(this.f, i);
        ac.g((TextView) this.e, i);
        if (this.l != null) {
            ac.a(this.l, i);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String q() {
        Long l;
        SharedPreferences sharedPreferences = getSharedPreferences("post_info", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("post_ids", null);
        String string2 = sharedPreferences.getString("post_times", null);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (string != null && string.length() > 0) {
            String[] split = string.split(",");
            String[] split2 = string2.split(",");
            if (split == null || split.length == 0 || split.length > 100) {
                edit.putString("post_ids", null);
                edit.putString("post_times", null);
                edit.commit();
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (split.length > 0 && split.length == split2.length) {
                for (int i = 0; i < split.length; i++) {
                    try {
                        l = Long.valueOf(Long.parseLong(split2[i]));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        l = 0L;
                    }
                    if (currentTimeMillis - l.longValue() < 86400000) {
                        stringBuffer.append(String.valueOf(split[i]) + ",");
                        stringBuffer2.append(String.valueOf(split2[i]) + ",");
                    }
                }
            } else {
                edit.putString("post_ids", null);
                edit.putString("post_times", null);
                edit.commit();
                return null;
            }
        }
        if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ',') {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
        }
        String stringBuffer3 = stringBuffer.toString();
        String stringBuffer4 = stringBuffer2.toString();
        edit.putString("post_ids", stringBuffer3);
        edit.putString("post_times", stringBuffer4);
        edit.commit();
        return stringBuffer3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String[] split;
        int i = 0;
        if (str != null && str.length() != 0 && (split = str.replace(HanziToPinyin.Token.SEPARATOR, "").split(",")) != null && split.length != 0) {
            SharedPreferences sharedPreferences = getSharedPreferences("post_info", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("post_ids", null);
            String string2 = sharedPreferences.getString("post_times", null);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (string == null || string.length() <= 0) {
                while (i < split.length - 1) {
                    if (i != split.length - 1) {
                        stringBuffer.append(String.valueOf(split[i]) + ",");
                        stringBuffer2.append(String.valueOf(valueOf) + ",");
                    } else {
                        stringBuffer.append(split[i]);
                        stringBuffer2.append(valueOf);
                    }
                    i++;
                }
            } else {
                String[] split2 = string.split(",");
                String[] split3 = string2.split(",");
                if (split2 == null || split2.length == 0) {
                    while (i < split.length - 1) {
                        if (i != split.length - 1) {
                            stringBuffer.append(String.valueOf(split[i]) + ",");
                            stringBuffer2.append(String.valueOf(valueOf) + ",");
                        } else {
                            stringBuffer.append(split[i]);
                            stringBuffer2.append(valueOf);
                        }
                        i++;
                    }
                    String stringBuffer3 = stringBuffer.toString();
                    String stringBuffer4 = stringBuffer2.toString();
                    edit.putString("post_ids", stringBuffer3);
                    edit.putString("post_times", stringBuffer4);
                    edit.commit();
                    return;
                }
                for (int i2 = 0; i2 < split.length; i2++) {
                    boolean z = false;
                    for (String str2 : split2) {
                        if (split[i2].equals(str2)) {
                            z = true;
                        }
                    }
                    if (!z) {
                        stringBuffer.append(String.valueOf(split[i2]) + ",");
                        stringBuffer2.append(String.valueOf(valueOf) + ",");
                    }
                }
                while (i < split2.length) {
                    if (i != split2.length - 1) {
                        stringBuffer.append(String.valueOf(split2[i]) + ",");
                        stringBuffer2.append(String.valueOf(split3[i]) + ",");
                    } else {
                        stringBuffer.append(split2[i]);
                        stringBuffer2.append(split3[i]);
                    }
                    i++;
                }
            }
            if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == ',') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            }
            String stringBuffer5 = stringBuffer.toString();
            String stringBuffer6 = stringBuffer2.toString();
            edit.putString("post_ids", stringBuffer5);
            edit.putString("post_times", stringBuffer6);
            edit.commit();
        }
    }

    public void b() {
        if (TiebaApplication.e().at() == 0 && !s()) {
            this.t.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
        if (!this.u) {
            this.u = true;
            this.m.setVisibility(0);
            this.q = false;
            this.r = true;
            t();
            this.o = new e(this, null);
            this.o.setPriority(3);
            this.o.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.q) {
            if (!this.r) {
                a(getResources().getString(R.string.neterror));
            } else {
                TiebaApplication.e().b(System.currentTimeMillis());
            }
            this.u = false;
            this.m.setVisibility(8);
        }
    }

    public void c() {
        this.x = "1";
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!i.a(this, str)) {
            if (str.contains("c/s/tag/allthread")) {
                if (str.contains("pn=")) {
                    String a = i.a(str, "pn=");
                    if (a != null && a.length() >= 0) {
                        this.x = a;
                    }
                } else {
                    this.x = "1";
                }
                b();
            } else {
                ag.d(this, str);
            }
        }
        return true;
    }

    public static void a(boolean z) {
        v = z;
    }

    public static void a(long j) {
        w = j;
    }

    private boolean s() {
        if (this.l == null) {
            try {
                this.l = new BaseWebView(this);
                ac.a(this.l, TiebaApplication.e().as());
                this.l.setOnLoadUrlListener(this);
                this.l.setHorizontalScrollBarEnabled(false);
                this.l.setHorizontalScrollbarOverlay(false);
                this.l.setScrollBarStyle(33554432);
                this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.n.addView(this.l);
                return true;
            } catch (Exception e) {
                ae.b(getClass().getName(), "", "NewHomeActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void t() {
        if (this.o != null) {
            this.o.cancel();
        }
    }
}
