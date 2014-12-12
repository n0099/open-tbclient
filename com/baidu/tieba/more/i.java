package com.baidu.tieba.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, String> {
    private com.baidu.tbadk.core.util.ad AR = null;
    final /* synthetic */ AppsActivity btK;
    private String url;

    public i(AppsActivity appsActivity, String str) {
        this.btK = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.btK.btI;
        progressBar.setVisibility(0);
        linearLayout = this.btK.btH;
        linearLayout.setVisibility(8);
        baseWebView = this.btK.mWebView;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Object... objArr) {
        if (this.url == null) {
            return null;
        }
        this.AR = new com.baidu.tbadk.core.util.ad(this.url);
        this.AR.oW().pV().pY().Ky = false;
        this.AR.o("client", "android");
        return this.AR.ov();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.AR != null) {
            this.AR.dL();
        }
        progressBar = this.btK.btI;
        progressBar.setVisibility(8);
        this.btK.btG = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean Uv;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.btK.btI;
        progressBar.setVisibility(8);
        if (this.AR != null && this.AR.oZ() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.l.em().c(new j(this, str));
            com.baidu.tbadk.core.sharedPref.b.og().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.btK.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        Uv = this.btK.Uv();
        if (!Uv && str == null) {
            baseWebView2 = this.btK.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.btK.btH;
            linearLayout.setVisibility(0);
            this.btK.showToast(this.btK.getPageContext().getString(com.baidu.tieba.z.neterror));
            return;
        }
        String string = this.btK.getPageContext().getString(com.baidu.tieba.z.server_404);
        baseWebView = this.btK.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
