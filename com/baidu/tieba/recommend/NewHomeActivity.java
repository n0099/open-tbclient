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
import com.baidu.browser.core.util.BdUtil;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class NewHomeActivity extends com.baidu.tieba.g implements com.baidu.tieba.view.d {
    private bg b;
    private Button c = null;
    private ImageView d = null;
    private ImageView e = null;
    private RelativeLayout f = null;
    private RelativeLayout g = null;
    private TextView j = null;
    private View.OnClickListener k = null;
    private BaseWebView l = null;
    private ProgressBar m = null;
    private LinearLayout n = null;
    private ax o = null;
    private boolean p = false;
    private boolean q = false;
    private boolean r = true;
    private TextView s = null;
    private TextView t = null;
    private boolean u = false;
    private String x = "1";
    private aw y;
    private static boolean v = false;
    private static long w = 0;

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayList f1628a = new ArrayList();

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_home_activity);
        m();
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            l();
        }
    }

    private void l() {
        String e = com.baidu.tieba.model.aq.e();
        if (e != null && e.length() > 0) {
            this.y = new aw(this, e);
            this.y.setPriority(3);
            this.y.execute(new String[0]);
        }
    }

    private void m() {
        this.f = (RelativeLayout) findViewById(R.id.parent);
        this.g = (RelativeLayout) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.title_text);
        this.d = (ImageView) findViewById(R.id.search);
        this.e = (ImageView) findViewById(R.id.refresh);
        this.c = (Button) findViewById(R.id.edit_tag_btn);
        this.n = (LinearLayout) findViewById(R.id.home_webview_item);
        this.s = (TextView) this.n.findViewById(R.id.webview_fail);
        this.t = (TextView) this.n.findViewById(R.id.webview_crash_tip);
        this.m = (ProgressBar) findViewById(R.id.recommend_progress);
        this.k = new av(this);
        this.c.setOnClickListener(this.k);
        this.d.setOnClickListener(this.k);
        this.e.setOnClickListener(this.k);
        if (TiebaApplication.f().av() >= 5) {
            this.s.setVisibility(8);
            this.t.setVisibility(0);
        } else if (q()) {
            this.t.setVisibility(8);
            n();
            b();
        } else {
            this.t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String b = DatabaseService.b(10);
        if (b != null && b.length() > 1) {
            this.p = true;
            this.l.loadDataWithBaseURL(com.baidu.tieba.data.g.f1013a, b, "text/html", BdUtil.UTF8, "");
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i2) {
            case -1:
                String E = TiebaApplication.E();
                if (E != null && E.length() > 0) {
                    l();
                }
                b();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.f().aS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        String str;
        String str2;
        super.onResume();
        String str3 = "";
        Token b = com.baidu.tieba.account.a.b(TiebaApplication.G());
        if (b != null) {
            if (b.mBduss != null) {
                str3 = b.mBduss;
            }
            if (b.mPtoken != null) {
                str = str3;
                str2 = b.mPtoken;
                bg bgVar = new bg(str, str2);
                boolean z = this.b == null && (this.b == null || !this.b.equals(bgVar));
                this.b = bgVar;
                if (this.l == null && z) {
                    b();
                    return;
                } else if (this.l == null && !this.u) {
                    if (System.currentTimeMillis() - Long.valueOf(TiebaApplication.f().D()).longValue() > com.baidu.tieba.data.g.d.longValue()) {
                        b();
                        return;
                    }
                    return;
                }
            }
        }
        str = str3;
        str2 = "";
        bg bgVar2 = new bg(str, str2);
        if (this.b == null) {
        }
        this.b = bgVar2;
        if (this.l == null) {
        }
        if (this.l == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.a(this.f, i);
        com.baidu.tieba.util.ah.d(this.g, i);
        com.baidu.tieba.util.ah.f(this.j, i);
        com.baidu.tieba.util.ah.b(this.e, i);
        com.baidu.tieba.util.ah.c(this.d, i);
        com.baidu.tieba.util.ah.g((TextView) this.c, i);
        if (this.l != null) {
            com.baidu.tieba.util.ah.a(this.l, i);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o() {
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
                    if (currentTimeMillis - l.longValue() < Util.MILLSECONDS_OF_DAY) {
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
        if (str != null && str.length() != 0 && (split = str.replace(" ", "").split(",")) != null && split.length != 0) {
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
        if (TiebaApplication.f().av() == 0 && !q()) {
            this.t.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
        if (!this.u) {
            this.u = true;
            this.m.setVisibility(0);
            this.q = false;
            this.r = true;
            r();
            this.o = new ax(this, null);
            this.o.setPriority(3);
            this.o.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.q) {
            if (!this.r) {
                a(getResources().getString(R.string.neterror));
            } else {
                TiebaApplication.f().a(System.currentTimeMillis());
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
        if (!bf.a(this, str)) {
            if (str.contains("c/s/tag/allthread")) {
                if (str.contains("pn=")) {
                    String a2 = bf.a(str, "pn=");
                    if (a2 != null && a2.length() >= 0) {
                        this.x = a2;
                    }
                } else {
                    this.x = "1";
                }
                b();
            } else {
                com.baidu.tieba.util.am.d(this, str);
            }
        }
        return true;
    }

    private boolean q() {
        boolean z = false;
        if (this.l == null) {
            try {
                if (com.baidu.tieba.util.am.f(this)) {
                    super.a(getString(R.string.web_view_corrupted));
                } else {
                    this.l = new BaseWebView(this);
                    com.baidu.tieba.util.ah.a(this.l, TiebaApplication.f().au());
                    this.l.setOnLoadUrlListener(this);
                    this.l.setHorizontalScrollBarEnabled(false);
                    this.l.setHorizontalScrollbarOverlay(false);
                    this.l.setScrollBarStyle(33554432);
                    this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.n.addView(this.l);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "", "NewHomeActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void r() {
        if (this.o != null) {
            this.o.cancel();
        }
    }
}
