package com.baidu.tieba.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, String> {
    private com.baidu.tbadk.core.util.ad AO = null;
    final /* synthetic */ AppsActivity bvg;
    private String url;

    public i(AppsActivity appsActivity, String str) {
        this.bvg = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.bvg.bve;
        progressBar.setVisibility(0);
        linearLayout = this.bvg.bvd;
        linearLayout.setVisibility(8);
        baseWebView = this.bvg.mWebView;
        baseWebView.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public String doInBackground(Object... objArr) {
        if (this.url == null) {
            return null;
        }
        this.AO = new com.baidu.tbadk.core.util.ad(this.url);
        this.AO.oS().pZ().qc().KO = false;
        this.AO.o("client", "android");
        return this.AO.or();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.AO != null) {
            this.AO.dJ();
        }
        progressBar = this.bvg.bve;
        progressBar.setVisibility(8);
        this.bvg.bvc = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean UO;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.bvg.bve;
        progressBar.setVisibility(8);
        if (this.AO != null && this.AO.oV() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.l.ek().c(new j(this, str));
            com.baidu.tbadk.core.sharedPref.b.oc().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.bvg.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        UO = this.bvg.UO();
        if (!UO && str == null) {
            baseWebView2 = this.bvg.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.bvg.bvd;
            linearLayout.setVisibility(0);
            this.bvg.showToast(this.bvg.getPageContext().getString(com.baidu.tieba.z.neterror));
            return;
        }
        String string = this.bvg.getPageContext().getString(com.baidu.tieba.z.server_404);
        baseWebView = this.bvg.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
