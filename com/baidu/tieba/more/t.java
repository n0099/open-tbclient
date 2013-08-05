package com.baidu.tieba.more;

import android.content.SharedPreferences;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppsActivity f1426a;
    private com.baidu.tieba.util.u b = null;
    private String c;

    public t(AppsActivity appsActivity, String str) {
        this.f1426a = appsActivity;
        this.c = null;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.f1426a.f;
        progressBar.setVisibility(0);
        linearLayout = this.f1426a.e;
        linearLayout.setVisibility(8);
        baseWebView = this.f1426a.b;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        if (this.c == null) {
            return null;
        }
        this.b = new com.baidu.tieba.util.u(this.c);
        this.b.b(false);
        this.b.a("client", "android");
        return this.b.k();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.i();
        }
        progressBar = this.f1426a.f;
        progressBar.setVisibility(8);
        this.f1426a.d = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        boolean k;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.f1426a.f;
        progressBar.setVisibility(8);
        if (this.b != null && this.b.e() && str != null && str.length() > 0) {
            DatabaseService.a(str, 7);
            SharedPreferences.Editor edit = this.f1426a.getSharedPreferences("settings", 0).edit();
            edit.putLong("app_inverval", System.currentTimeMillis());
            edit.commit();
            baseWebView3 = this.f1426a.b;
            baseWebView3.loadDataWithBaseURL(com.baidu.tieba.data.g.f1013a, str, "text/html", BdUtil.UTF8, "");
            return;
        }
        k = this.f1426a.k();
        if (!k && str == null) {
            baseWebView2 = this.f1426a.b;
            baseWebView2.setVisibility(8);
            linearLayout = this.f1426a.e;
            linearLayout.setVisibility(0);
            this.f1426a.a(this.f1426a.getString(R.string.system_no_service));
            return;
        }
        String string = this.f1426a.getString(R.string.server_404);
        baseWebView = this.f1426a.b;
        baseWebView.loadDataWithBaseURL(com.baidu.tieba.data.g.f1013a, string, "text/html", BdUtil.UTF8, "");
    }
}
