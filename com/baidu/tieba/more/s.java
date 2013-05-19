package com.baidu.tieba.more;

import android.content.SharedPreferences;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.a.a {
    final /* synthetic */ AppsActivity a;
    private com.baidu.tieba.d.t b = null;
    private String c;

    public s(AppsActivity appsActivity, String str) {
        this.a = appsActivity;
        this.c = null;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.a.h;
        progressBar.setVisibility(0);
        linearLayout = this.a.g;
        linearLayout.setVisibility(8);
        baseWebView = this.a.d;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public String a(Object... objArr) {
        if (this.c == null) {
            return null;
        }
        this.b = new com.baidu.tieba.d.t(this.c);
        this.b.a(false);
        this.b.a("client", "android");
        return this.b.i();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.f = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        ProgressBar progressBar;
        boolean m;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (this.b != null && this.b.c() && str != null && str.length() > 0) {
            com.baidu.tieba.d.k.a(str, 7);
            SharedPreferences.Editor edit = this.a.getSharedPreferences("settings", 0).edit();
            edit.putLong("app_inverval", System.currentTimeMillis());
            edit.commit();
            baseWebView3 = this.a.d;
            baseWebView3.loadDataWithBaseURL(com.baidu.tieba.a.i.e, str, "text/html", BdUtil.UTF8, "");
            return;
        }
        m = this.a.m();
        if (!m && str == null) {
            baseWebView2 = this.a.d;
            baseWebView2.setVisibility(8);
            linearLayout = this.a.g;
            linearLayout.setVisibility(0);
            this.a.a(this.a.getString(R.string.system_no_service));
            return;
        }
        String string = this.a.getString(R.string.server_404);
        baseWebView = this.a.d;
        baseWebView.loadDataWithBaseURL(com.baidu.tieba.a.i.e, string, "text/html", BdUtil.UTF8, "");
    }
}
