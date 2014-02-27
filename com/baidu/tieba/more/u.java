package com.baidu.tieba.more;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ AppsActivity a;
    private ba b = null;
    private String c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Object... objArr) {
        if (this.c == null) {
            return null;
        }
        this.b = new ba(this.c);
        this.b.b(false);
        this.b.a("client", SocialConstants.ANDROID_CLIENT_TYPE);
        return this.b.l();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        ProgressBar progressBar;
        boolean c;
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        LinearLayout linearLayout;
        BaseWebView baseWebView3;
        String str2 = str;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        if (this.b != null && this.b.d() && str2 != null && str2.length() > 0) {
            DatabaseService.a(str2, 7);
            com.baidu.tieba.sharedPref.b.a().b("app_inverval", System.currentTimeMillis());
            baseWebView3 = this.a.b;
            baseWebView3.loadDataWithBaseURL(com.baidu.tieba.data.i.a, str2, "text/html", "utf-8", "");
            return;
        }
        c = this.a.c();
        if (c || str2 != null) {
            String string = this.a.getString(R.string.server_404);
            baseWebView = this.a.b;
            baseWebView.loadDataWithBaseURL(com.baidu.tieba.data.i.a, string, "text/html", "utf-8", "");
            return;
        }
        baseWebView2 = this.a.b;
        baseWebView2.setVisibility(8);
        linearLayout = this.a.e;
        linearLayout.setVisibility(0);
        this.a.showToast(this.a.getString(R.string.system_no_service));
    }

    public u(AppsActivity appsActivity, String str) {
        this.a = appsActivity;
        this.c = null;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
        }
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
