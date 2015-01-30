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
    final /* synthetic */ AppsActivity bvh;
    private String url;

    public i(AppsActivity appsActivity, String str) {
        this.bvh = appsActivity;
        this.url = null;
        this.url = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        BaseWebView baseWebView;
        progressBar = this.bvh.bvf;
        progressBar.setVisibility(0);
        linearLayout = this.bvh.bve;
        linearLayout.setVisibility(8);
        baseWebView = this.bvh.mWebView;
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
        this.AR = new com.baidu.tbadk.core.util.ad(this.url);
        this.AR.oZ().qg().qj().KR = false;
        this.AR.o("client", "android");
        return this.AR.oy();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.AR != null) {
            this.AR.dJ();
        }
        progressBar = this.bvh.bvf;
        progressBar.setVisibility(8);
        this.bvh.bvd = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        boolean UT;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.bvh.bvf;
        progressBar.setVisibility(8);
        if (this.AR != null && this.AR.pc() && str != null && str.length() > 0) {
            com.baidu.adp.lib.g.l.ek().c(new j(this, str));
            com.baidu.tbadk.core.sharedPref.b.oj().putLong("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.bvh.mWebView;
            baseWebView3.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            return;
        }
        UT = this.bvh.UT();
        if (!UT && str == null) {
            baseWebView2 = this.bvh.mWebView;
            baseWebView2.setVisibility(8);
            linearLayout = this.bvh.bve;
            linearLayout.setVisibility(0);
            this.bvh.showToast(this.bvh.getPageContext().getString(com.baidu.tieba.z.neterror));
            return;
        }
        String string = this.bvh.getPageContext().getString(com.baidu.tieba.z.server_404);
        baseWebView = this.bvh.mWebView;
        baseWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, string, "text/html", "utf-8", "");
    }
}
