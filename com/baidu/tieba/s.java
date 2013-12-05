package com.baidu.tieba;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f2430a;
    private com.baidu.tieba.util.am b;
    private String c;

    private s(CommonWebviewActivity commonWebviewActivity) {
        this.f2430a = commonWebviewActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(CommonWebviewActivity commonWebviewActivity, p pVar) {
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
        str = this.f2430a.b;
        this.b = new com.baidu.tieba.util.am(str);
        this.b.b(false);
        if (TiebaApplication.h().an() == 1) {
            this.b.a("night_type", SocialConstants.TRUE);
        }
        com.baidu.tieba.util.am amVar = this.b;
        str2 = this.f2430a.s;
        amVar.a("pn", str2);
        this.b.a("_version_more", SocialConstants.TRUE);
        this.b.a("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        z = CommonWebviewActivity.q;
        if (z) {
            boolean unused = CommonWebviewActivity.q = false;
            this.b.a("msg_click", SocialConstants.TRUE);
            com.baidu.tieba.util.am amVar2 = this.b;
            j = CommonWebviewActivity.r;
            amVar2.a("message_id", String.valueOf(j));
        }
        Address aQ = TiebaApplication.h().aQ();
        if (aQ != null && TiebaApplication.h().u()) {
            this.b.a("lbs", String.valueOf(aQ.getLatitude()) + "," + String.valueOf(aQ.getLongitude()));
        }
        try {
            str3 = this.f2430a.t;
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        if (str3 != null) {
            str4 = this.f2430a.t;
            if (str4.equals("get")) {
                this.c = this.b.m();
                if (this.b.d()) {
                    return this.c;
                }
                return null;
            }
        }
        this.c = this.b.l();
        if (this.b.d()) {
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        this.f2430a.p = false;
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
        this.f2430a.k = null;
        linearLayout = this.f2430a.j;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.d() || str == null || str.length() <= 0) {
            this.f2430a.m = false;
            textView = this.f2430a.n;
            textView.setVisibility(0);
            baseWebView = this.f2430a.h;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f2430a.j;
            onClickListener = this.f2430a.v;
            linearLayout2.setOnClickListener(onClickListener);
        } else {
            baseWebView2 = this.f2430a.h;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.h.f1248a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f2430a.n;
            textView2.setVisibility(8);
            baseWebView3 = this.f2430a.h;
            baseWebView3.setVisibility(0);
        }
        this.f2430a.l = true;
        this.f2430a.e();
    }
}
