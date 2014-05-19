package com.baidu.tieba.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ AppsActivity a;
    private com.baidu.tbadk.core.util.al b = null;
    private String c;

    public i(AppsActivity appsActivity, String str) {
        this.a = appsActivity;
        this.c = null;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.a.f;
        progressBar.setVisibility(0);
        linearLayout = this.a.e;
        linearLayout.setVisibility(8);
        baseWebView = this.a.b;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (this.c == null) {
            return null;
        }
        this.b = new com.baidu.tbadk.core.util.al(this.c);
        this.b.a().a().a().g = false;
        this.b.a("client", "android");
        return this.b.i();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean d;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        if (this.b != null && this.b.c() && str != null && str.length() > 0) {
            com.baidu.tieba.util.k.a(str, 7);
            com.baidu.tbadk.core.sharedPref.b.a().b("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.a.b;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        d = this.a.d();
        if (!d && str == null) {
            baseWebView2 = this.a.b;
            baseWebView2.setVisibility(8);
            linearLayout = this.a.e;
            linearLayout.setVisibility(0);
            this.a.showToast(this.a.getString(com.baidu.tieba.u.system_no_service));
            return;
        }
        String string = this.a.getString(com.baidu.tieba.u.server_404);
        baseWebView = this.a.b;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
