package com.baidu.tieba.setting.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, String> {
    private com.baidu.tbadk.core.util.aa Ok = null;
    final /* synthetic */ AppsActivity cat;
    private String url;

    public i(AppsActivity appsActivity, String str) {
        this.cat = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.cat.caq;
        progressBar.setVisibility(0);
        linearLayout = this.cat.cap;
        linearLayout.setVisibility(8);
        baseWebView = this.cat.mWebView;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public String doInBackground(Object... objArr) {
        if (this.url == null) {
            return null;
        }
        this.Ok = new com.baidu.tbadk.core.util.aa(this.url);
        this.Ok.sp().tp().ts().Ws = false;
        this.Ok.o("client", "android");
        return this.Ok.rO();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.Ok != null) {
            this.Ok.hh();
        }
        progressBar = this.cat.caq;
        progressBar.setVisibility(8);
        this.cat.cao = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean agA;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.cat.caq;
        progressBar.setVisibility(8);
        if (this.Ok != null && this.Ok.ss() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.l.hJ().c(new j(this, str));
            com.baidu.tbadk.core.sharedPref.b.rB().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.cat.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        agA = this.cat.agA();
        if (!agA && str == null) {
            baseWebView2 = this.cat.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.cat.cap;
            linearLayout.setVisibility(0);
            this.cat.showToast(this.cat.getPageContext().getString(com.baidu.tieba.y.neterror));
            return;
        }
        String string = this.cat.getPageContext().getString(com.baidu.tieba.y.server_404);
        baseWebView = this.cat.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
