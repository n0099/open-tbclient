package com.baidu.tieba;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f1294a;
    private com.baidu.tieba.util.v b;
    private String c;

    private m(CommonWebviewActivity commonWebviewActivity) {
        this.f1294a = commonWebviewActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(CommonWebviewActivity commonWebviewActivity, m mVar) {
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
        str = this.f1294a.b;
        this.b = new com.baidu.tieba.util.v(str);
        this.b.b(false);
        if (TiebaApplication.g().an() == 1) {
            this.b.a("night_type", "1");
        }
        com.baidu.tieba.util.v vVar = this.b;
        str2 = this.f1294a.w;
        vVar.a("pn", str2);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = CommonWebviewActivity.u;
        if (z) {
            CommonWebviewActivity.u = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.util.v vVar2 = this.b;
            j = CommonWebviewActivity.v;
            vVar2.a("message_id", String.valueOf(j));
        }
        Address aK = TiebaApplication.g().aK();
        if (aK != null && TiebaApplication.g().v()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
        }
        try {
            str3 = this.f1294a.x;
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        if (str3 != null) {
            str4 = this.f1294a.x;
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
        this.f1294a.t = false;
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
        this.f1294a.o = null;
        linearLayout = this.f1294a.n;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.d() && str != null && str.length() > 0) {
            baseWebView2 = this.f1294a.l;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.f1014a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f1294a.r;
            textView2.setVisibility(8);
            baseWebView3 = this.f1294a.l;
            baseWebView3.setVisibility(0);
        } else {
            this.f1294a.q = false;
            textView = this.f1294a.r;
            textView.setVisibility(0);
            baseWebView = this.f1294a.l;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f1294a.n;
            onClickListener = this.f1294a.k;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.f1294a.p = true;
        this.f1294a.l();
    }
}
