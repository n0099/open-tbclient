package com.baidu.tieba.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ AppsActivity a;
    private com.baidu.tieba.util.an b = null;
    private String c;

    public v(AppsActivity appsActivity, String str) {
        this.a = appsActivity;
        this.c = null;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
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
    /* renamed from: d */
    public String a(Object... objArr) {
        if (this.c == null) {
            return null;
        }
        this.b = new com.baidu.tieba.util.an(this.c);
        this.b.b(false);
        this.b.a("client", SocialConstants.ANDROID_CLIENT_TYPE);
        return this.b.l();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
        }
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        boolean d;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        if (this.b == null || !this.b.d() || str == null || str.length() <= 0) {
            d = this.a.d();
            if (!d && str == null) {
                baseWebView2 = this.a.b;
                baseWebView2.setVisibility(8);
                linearLayout = this.a.e;
                linearLayout.setVisibility(0);
                this.a.showToast(this.a.getString(R.string.system_no_service));
                return;
            }
            String string = this.a.getString(R.string.server_404);
            baseWebView = this.a.b;
            baseWebView.loadDataWithBaseURL(com.baidu.tieba.data.h.a, string, "text/html", BdUtil.UTF8, "");
            return;
        }
        DatabaseService.a(str, 7);
        com.baidu.tieba.sharedPref.b.a().b("app_inverval", System.currentTimeMillis());
        baseWebView3 = this.a.b;
        baseWebView3.loadDataWithBaseURL(com.baidu.tieba.data.h.a, str, "text/html", BdUtil.UTF8, "");
    }
}
