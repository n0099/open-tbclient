package com.baidu.tieba;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f2029a;
    private com.baidu.tieba.util.ag b;
    private String c;

    private p(CommonWebviewActivity commonWebviewActivity) {
        this.f2029a = commonWebviewActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(CommonWebviewActivity commonWebviewActivity, o oVar) {
        this(commonWebviewActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:13:0x00a9, B:15:0x00b1, B:17:0x00bf, B:18:0x00c7, B:20:0x00cf, B:22:0x00d2), top: B:27:0x00a9 }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(Object... objArr) {
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        long j;
        str = this.f2029a.b;
        this.b = new com.baidu.tieba.util.ag(str);
        this.b.b(false);
        if (TiebaApplication.g().as() == 1) {
            this.b.a("night_type", SocialConstants.TRUE);
        }
        com.baidu.tieba.util.ag agVar = this.b;
        str2 = this.f2029a.w;
        agVar.a("pn", str2);
        this.b.a("_version_more", SocialConstants.TRUE);
        this.b.a("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        z = CommonWebviewActivity.u;
        if (z) {
            boolean unused = CommonWebviewActivity.u = false;
            this.b.a("msg_click", SocialConstants.TRUE);
            com.baidu.tieba.util.ag agVar2 = this.b;
            j = CommonWebviewActivity.v;
            agVar2.a("message_id", String.valueOf(j));
        }
        Address aP = TiebaApplication.g().aP();
        if (aP != null && TiebaApplication.g().t()) {
            this.b.a("lbs", String.valueOf(aP.getLatitude()) + "," + String.valueOf(aP.getLongitude()));
        }
        try {
            str3 = this.f2029a.x;
        } catch (Exception e) {
            be.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        if (str3 != null) {
            str4 = this.f2029a.x;
            if (str4.equals("get")) {
                this.c = this.b.k();
                if (this.b.d()) {
                    return this.c;
                }
                return null;
            }
        }
        this.c = this.b.j();
        if (this.b.d()) {
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f2029a.t = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        LinearLayout linearLayout;
        TextView textView;
        BaseWebView baseWebView;
        LinearLayout linearLayout2;
        View.OnClickListener onClickListener;
        BaseWebView baseWebView2;
        TextView textView2;
        BaseWebView baseWebView3;
        this.f2029a.o = null;
        linearLayout = this.f2029a.n;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.d() || str == null || str.length() <= 0) {
            this.f2029a.q = false;
            textView = this.f2029a.r;
            textView.setVisibility(0);
            baseWebView = this.f2029a.l;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f2029a.n;
            onClickListener = this.f2029a.k;
            linearLayout2.setOnClickListener(onClickListener);
        } else {
            baseWebView2 = this.f2029a.l;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.h.f1165a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f2029a.r;
            textView2.setVisibility(8);
            baseWebView3 = this.f2029a.l;
            baseWebView3.setVisibility(0);
        }
        this.f2029a.p = true;
        this.f2029a.f();
    }
}
