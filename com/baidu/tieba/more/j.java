package com.baidu.tieba.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ AppsActivity bqw;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private String url;

    public j(AppsActivity appsActivity, String str) {
        this.bqw = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.bqw.bqu;
        progressBar.setVisibility(0);
        linearLayout = this.bqw.bqt;
        linearLayout.setVisibility(8);
        baseWebView = this.bqw.mWebView;
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
        this.mNetWork.mc().na().nd().Gn = false;
        this.mNetWork.k("client", "android");
        return this.mNetWork.lA();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        progressBar = this.bqw.bqu;
        progressBar.setVisibility(8);
        this.bqw.bqs = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean Ui;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.bqw.bqu;
        progressBar.setVisibility(8);
        if (this.mNetWork != null && this.mNetWork.mf() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.k.el().b(new k(this, str));
            com.baidu.tbadk.core.sharedPref.b.lk().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.bqw.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        Ui = this.bqw.Ui();
        if (!Ui && str == null) {
            baseWebView2 = this.bqw.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.bqw.bqt;
            linearLayout.setVisibility(0);
            this.bqw.showToast(this.bqw.getString(com.baidu.tieba.y.neterror));
            return;
        }
        String string = this.bqw.getString(com.baidu.tieba.y.server_404);
        baseWebView = this.bqw.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
