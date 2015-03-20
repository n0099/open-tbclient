package com.baidu.tieba.setting.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, String> {
    private com.baidu.tbadk.core.util.aa Oi = null;
    final /* synthetic */ AppsActivity cae;
    private String url;

    public i(AppsActivity appsActivity, String str) {
        this.cae = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.cae.cab;
        progressBar.setVisibility(0);
        linearLayout = this.cae.caa;
        linearLayout.setVisibility(8);
        baseWebView = this.cae.mWebView;
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
        this.Oi = new com.baidu.tbadk.core.util.aa(this.url);
        this.Oi.sp().tp().ts().Wq = false;
        this.Oi.o("client", "android");
        return this.Oi.rO();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.Oi != null) {
            this.Oi.hh();
        }
        progressBar = this.cae.cab;
        progressBar.setVisibility(8);
        this.cae.bZZ = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean agl;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.cae.cab;
        progressBar.setVisibility(8);
        if (this.Oi != null && this.Oi.ss() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.l.hJ().c(new j(this, str));
            com.baidu.tbadk.core.sharedPref.b.rB().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.cae.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        agl = this.cae.agl();
        if (!agl && str == null) {
            baseWebView2 = this.cae.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.cae.caa;
            linearLayout.setVisibility(0);
            this.cae.showToast(this.cae.getPageContext().getString(com.baidu.tieba.y.neterror));
            return;
        }
        String string = this.cae.getPageContext().getString(com.baidu.tieba.y.server_404);
        baseWebView = this.cae.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
