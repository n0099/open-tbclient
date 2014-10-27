package com.baidu.tieba.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ AppsActivity bqi;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private String url;

    public j(AppsActivity appsActivity, String str) {
        this.bqi = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.bqi.bqg;
        progressBar.setVisibility(0);
        linearLayout = this.bqi.bqf;
        linearLayout.setVisibility(8);
        baseWebView = this.bqi.mWebView;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Object... objArr) {
        if (this.url == null) {
            return null;
        }
        this.mNetWork = new com.baidu.tbadk.core.util.ac(this.url);
        this.mNetWork.mc().na().nd().Gm = false;
        this.mNetWork.k("client", "android");
        return this.mNetWork.lA();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        progressBar = this.bqi.bqg;
        progressBar.setVisibility(8);
        this.bqi.bqe = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean Uf;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.bqi.bqg;
        progressBar.setVisibility(8);
        if (this.mNetWork != null && this.mNetWork.mf() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.k.el().b(new k(this, str));
            com.baidu.tbadk.core.sharedPref.b.lk().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.bqi.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        Uf = this.bqi.Uf();
        if (!Uf && str == null) {
            baseWebView2 = this.bqi.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.bqi.bqf;
            linearLayout.setVisibility(0);
            this.bqi.showToast(this.bqi.getString(com.baidu.tieba.y.neterror));
            return;
        }
        String string = this.bqi.getString(com.baidu.tieba.y.server_404);
        baseWebView = this.bqi.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
