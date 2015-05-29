package com.baidu.tieba.setting.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, String> {
    private com.baidu.tbadk.core.util.aa OE = null;
    final /* synthetic */ AppsActivity ceP;
    private String url;

    public i(AppsActivity appsActivity, String str) {
        this.ceP = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.ceP.ceM;
        progressBar.setVisibility(0);
        linearLayout = this.ceP.ceL;
        linearLayout.setVisibility(8);
        baseWebView = this.ceP.mWebView;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public String doInBackground(Object... objArr) {
        if (this.url == null) {
            return null;
        }
        this.OE = new com.baidu.tbadk.core.util.aa(this.url);
        this.OE.sX().tS().tV().Xe = false;
        this.OE.o("client", "android");
        return this.OE.sw();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.OE != null) {
            this.OE.gS();
        }
        progressBar = this.ceP.ceM;
        progressBar.setVisibility(8);
        this.ceP.ceK = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean ait;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.ceP.ceM;
        progressBar.setVisibility(8);
        if (this.OE != null && this.OE.ta() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.l.ht().c(new j(this, str));
            com.baidu.tbadk.core.sharedPref.b.sl().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.ceP.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        ait = this.ceP.ait();
        if (!ait && str == null) {
            baseWebView2 = this.ceP.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.ceP.ceL;
            linearLayout.setVisibility(0);
            this.ceP.showToast(this.ceP.getPageContext().getString(com.baidu.tieba.t.neterror));
            return;
        }
        String string = this.ceP.getPageContext().getString(com.baidu.tieba.t.server_404);
        baseWebView = this.ceP.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
