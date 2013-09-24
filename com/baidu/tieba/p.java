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
public class p extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CommonWebviewActivity f1512a;
    private com.baidu.tieba.util.z b;
    private String c;

    private p(CommonWebviewActivity commonWebviewActivity) {
        this.f1512a = commonWebviewActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(CommonWebviewActivity commonWebviewActivity, p pVar) {
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
        str = this.f1512a.b;
        this.b = new com.baidu.tieba.util.z(str);
        this.b.b(false);
        if (TiebaApplication.g().ap() == 1) {
            this.b.a("night_type", "1");
        }
        com.baidu.tieba.util.z zVar = this.b;
        str2 = this.f1512a.w;
        zVar.a("pn", str2);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = CommonWebviewActivity.u;
        if (z) {
            CommonWebviewActivity.u = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.util.z zVar2 = this.b;
            j = CommonWebviewActivity.v;
            zVar2.a("message_id", String.valueOf(j));
        }
        Address aK = TiebaApplication.g().aK();
        if (aK != null && TiebaApplication.g().t()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
        }
        try {
            str3 = this.f1512a.x;
        } catch (Exception e) {
            com.baidu.tieba.util.av.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        if (str3 != null) {
            str4 = this.f1512a.x;
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
        this.f1512a.t = false;
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
        this.f1512a.o = null;
        linearLayout = this.f1512a.n;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.d() && str != null && str.length() > 0) {
            baseWebView2 = this.f1512a.l;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.f1032a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f1512a.r;
            textView2.setVisibility(8);
            baseWebView3 = this.f1512a.l;
            baseWebView3.setVisibility(0);
        } else {
            this.f1512a.q = false;
            textView = this.f1512a.r;
            textView.setVisibility(0);
            baseWebView = this.f1512a.l;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f1512a.n;
            onClickListener = this.f1512a.k;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.f1512a.p = true;
        this.f1512a.m();
    }
}
