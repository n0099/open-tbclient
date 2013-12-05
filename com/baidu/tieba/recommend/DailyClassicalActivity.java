package com.baidu.tieba.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class DailyClassicalActivity extends com.baidu.tieba.j implements com.baidu.tieba.view.d {
    private static boolean o = false;
    private static long p = 0;

    /* renamed from: a  reason: collision with root package name */
    private ImageView f2401a = null;
    private RelativeLayout b = null;
    private RelativeLayout c = null;
    private TextView d = null;
    private View.OnClickListener e = null;
    private BaseWebView f = null;
    private ProgressBar g = null;
    private LinearLayout h = null;
    private b i = null;
    private boolean j = false;
    private boolean k = true;
    private TextView l = null;
    private TextView m = null;
    private boolean n = false;
    private String q = SocialConstants.TRUE;

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
        return TiebaApplication.h().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.day_classical_activity);
        d();
    }

    private void d() {
        this.b = (RelativeLayout) findViewById(R.id.parent);
        this.c = (RelativeLayout) findViewById(R.id.title);
        this.d = (TextView) findViewById(R.id.title_text);
        this.h = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.f2401a = (ImageView) findViewById(R.id.back);
        this.l = (TextView) this.h.findViewById(R.id.webview_fail);
        this.m = (TextView) this.h.findViewById(R.id.webview_crash_tip);
        this.g = (ProgressBar) findViewById(R.id.tag_progress);
        this.e = new a(this);
        this.f2401a.setOnClickListener(this.e);
        if (f()) {
            this.m.setVisibility(8);
            a();
            return;
        }
        this.m.setVisibility(0);
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, DailyClassicalActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.a(this.b, i);
        ba.d(this.c, i);
        ba.e(this.d, i);
        ba.a(this.f2401a, i);
        if (this.f != null) {
            ba.a(this.f, i);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void a() {
        if (TiebaApplication.h().ao() == 0 && !f()) {
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
        if (!this.n) {
            this.n = true;
            this.g.setVisibility(0);
            this.j = false;
            this.k = true;
            g();
            this.i = new b(this, null);
            this.i.setPriority(3);
            this.i.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.j) {
            if (!this.k) {
                showToast(getResources().getString(R.string.neterror));
            }
            this.n = false;
            this.g.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.view.d
    public boolean a(WebView webView, String str) {
        if (!ab.a(this, str)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String a2 = a(str, "pn=");
                    if (a2 != null && a2.length() >= 0) {
                        this.q = a2;
                    }
                } else {
                    this.q = SocialConstants.TRUE;
                }
                a();
            } else {
                UtilHelper.c(this, str + "&_client_version=" + com.baidu.tieba.data.h.j());
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

    private boolean f() {
        boolean z = false;
        if (this.f == null) {
            try {
                if (UtilHelper.d(this)) {
                    super.showToast(getString(R.string.web_view_corrupted));
                } else {
                    this.f = new BaseWebView(this);
                    ba.a(this.f, TiebaApplication.h().an());
                    this.f.setOnLoadUrlListener(this);
                    this.f.setHorizontalScrollBarEnabled(false);
                    this.f.setHorizontalScrollbarOverlay(false);
                    this.f.setScrollBarStyle(33554432);
                    this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.h.addView(this.f);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                bd.b(getClass().getName(), "", "TabContentActivity.refreshFrs error = " + e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void g() {
        if (this.i != null) {
            this.i.cancel();
        }
    }
}
