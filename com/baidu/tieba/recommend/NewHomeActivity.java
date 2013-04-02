package com.baidu.tieba.recommend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.browser.core.util.BdUtil;
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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NewHomeActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.d {
    private Button d = null;
    private Button e = null;
    private Button f = null;
    private RelativeLayout g = null;
    private RelativeLayout h = null;
    private TextView i = null;
    private View.OnClickListener j = null;
    private BaseWebView k = null;
    private ProgressBar l = null;
    private LinearLayout m = null;
    private s n = null;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private TextView r = null;
    private TextView s = null;
    private boolean t = false;
    private String w = "1";
    private r x;
    private static boolean u = false;
    private static long v = 0;
    public static ArrayList c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_home_activity);
        n();
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            m();
        }
    }

    private void m() {
        String e = com.baidu.tieba.b.f.e();
        if (e != null && e.length() > 0) {
            this.x = new r(this, e);
            this.x.execute(new String[0]);
        }
    }

    private void n() {
        this.g = (RelativeLayout) findViewById(R.id.parent);
        this.h = (RelativeLayout) findViewById(R.id.title);
        this.i = (TextView) findViewById(R.id.title_text);
        this.e = (Button) findViewById(R.id.search);
        this.f = (Button) findViewById(R.id.refresh);
        this.d = (Button) findViewById(R.id.edit_tag_btn);
        this.m = (LinearLayout) findViewById(R.id.home_webview_item);
        this.r = (TextView) this.m.findViewById(R.id.webview_fail);
        this.s = (TextView) this.m.findViewById(R.id.webview_crash_tip);
        this.l = (ProgressBar) findViewById(R.id.recommend_progress);
        this.j = new q(this);
        this.d.setOnClickListener(this.j);
        this.e.setOnClickListener(this.j);
        this.f.setOnClickListener(this.j);
        if (TiebaApplication.b().ai() >= 5) {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
        } else if (r()) {
            this.s.setVisibility(8);
            o();
            i();
        } else {
            this.s.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String b = com.baidu.tieba.c.k.b(10);
        if (b != null && b.length() > 1) {
            this.o = true;
            this.k.loadDataWithBaseURL("http://c.tieba.baidu.com/", b, "text/html", BdUtil.UTF8, "");
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i2) {
            case -1:
                String y = TiebaApplication.y();
                if (y != null && y.length() > 0) {
                    m();
                }
                i();
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
        TiebaApplication.b().aB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.b().w());
        if (!this.t && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.b.longValue() && this.k != null) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ae.a(this.g, i);
        ae.c(this.h, i);
        ae.c(this.i, i);
        ae.e((View) this.f, i);
        ae.f(this.e, i);
        ae.d((TextView) this.d, i);
        if (this.k != null) {
            ae.a(this.k, i);
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
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

    public void i() {
        if (TiebaApplication.b().ai() == 0 && !r()) {
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
        if (!this.t) {
            this.t = true;
            this.l.setVisibility(0);
            this.p = false;
            this.q = true;
            s();
            this.n = new s(this, null);
            this.n.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.p) {
            if (!this.q) {
                b(getResources().getString(R.string.neterror));
            } else {
                TiebaApplication.b().b(System.currentTimeMillis());
            }
            this.t = false;
            this.l.setVisibility(8);
        }
    }

    public void j() {
        this.w = "1";
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (str != null && str.contains("jump_tieba_native=1")) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                DailyClassicalActivity.a(this);
            } else if (str.contains("nearby=1")) {
                MainTabActivity.a(this, "goto_nearby");
            } else if (str.contains("kz=")) {
                String a = a(str, "kz=");
                if (a != null && a.length() >= 0) {
                    PbActivity.a(this, a, "allthread");
                }
            } else if (str.contains("kw=")) {
                String a2 = a(str, "kw=");
                if (a2 != null && a2.length() >= 0) {
                    FrsActivity.a(this, a2, "allthread");
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
        if (str.contains("c/s/tag/allthread")) {
            if (str.contains("pn=")) {
                String a7 = a(str, "pn=");
                if (a7 != null && a7.length() >= 0) {
                    this.w = a7;
                }
            } else {
                this.w = "1";
            }
            i();
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

    public static void a(boolean z) {
        u = z;
    }

    public static void a(long j) {
        v = j;
    }

    private boolean r() {
        if (this.k == null) {
            try {
                this.k = new BaseWebView(this);
                ae.a(this.k, TiebaApplication.b().ah());
                this.k.setOnLoadUrlListener(this);
                this.k.setHorizontalScrollBarEnabled(false);
                this.k.setHorizontalScrollbarOverlay(false);
                this.k.setScrollBarStyle(33554432);
                this.k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.m.addView(this.k);
                return true;
            } catch (Exception e) {
                ag.b(getClass().getName(), "", "NewHomeActivity.refreshFrs error = " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.n != null) {
            this.n.a();
        }
    }
}
