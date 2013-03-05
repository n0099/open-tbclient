package com.baidu.tieba.more;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends AsyncTask {
    final /* synthetic */ AppsActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c;

    public s(AppsActivity appsActivity, String str) {
        this.a = appsActivity;
        this.c = null;
        this.c = str;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (this.c == null) {
            return null;
        }
        this.b = new com.baidu.tieba.c.t(this.c);
        this.b.a(false);
        this.b.a("client", "android");
        return this.b.i();
    }

    public void a() {
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean l;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (this.b != null && this.b.c() && str != null && str.length() > 0) {
            com.baidu.tieba.c.k.a(str, 7);
            SharedPreferences.Editor edit = this.a.getSharedPreferences("settings", 0).edit();
            edit.putLong("app_inverval", System.currentTimeMillis());
            edit.commit();
            baseWebView3 = this.a.d;
            baseWebView3.loadDataWithBaseURL("http://c.tieba.baidu.com/", str, "text/html", BdUtil.UTF8, "");
            return;
        }
        l = this.a.l();
        if (!l && str == null) {
            baseWebView2 = this.a.d;
            baseWebView2.setVisibility(8);
            linearLayout = this.a.g;
            linearLayout.setVisibility(0);
            this.a.b(this.a.getString(R.string.system_no_service));
            return;
        }
        String string = this.a.getString(R.string.server_404);
        baseWebView = this.a.d;
        baseWebView.loadDataWithBaseURL("http://c.tieba.baidu.com/", string, "text/html", BdUtil.UTF8, "");
    }
}
