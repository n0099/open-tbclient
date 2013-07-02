package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask {
    final /* synthetic */ DailyClassicalActivity a;
    private r b;
    private String c;

    private b(DailyClassicalActivity dailyClassicalActivity) {
        this.a = dailyClassicalActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(DailyClassicalActivity dailyClassicalActivity, b bVar) {
        this(dailyClassicalActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        boolean z;
        long j;
        this.b = new r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/tag/gettogether");
        this.b.a(false);
        if (TiebaApplication.f().at() == 1) {
            this.b.a("night_type", "1");
        }
        r rVar = this.b;
        str = this.a.s;
        rVar.a("pn", str);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = DailyClassicalActivity.q;
        if (z) {
            DailyClassicalActivity.q = false;
            this.b.a("msg_click", "1");
            r rVar2 = this.b;
            j = DailyClassicalActivity.r;
            rVar2.a("message_id", String.valueOf(j));
        }
        Address aP = TiebaApplication.f().aP();
        if (aP != null && TiebaApplication.f().u()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aP.getLatitude())) + "," + String.valueOf(aP.getLongitude()));
        }
        try {
            this.c = this.b.j();
            if (this.b.d()) {
                return this.c;
            }
        } catch (Exception e) {
            z.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.a.p = false;
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
        this.a.k = null;
        linearLayout = this.a.j;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.d() && str != null && str.length() > 0) {
            baseWebView2 = this.a.f;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.a.n;
            textView2.setVisibility(8);
            baseWebView3 = this.a.f;
            baseWebView3.setVisibility(0);
        } else {
            this.a.m = false;
            textView = this.a.n;
            textView.setVisibility(0);
            baseWebView = this.a.f;
            baseWebView.setVisibility(8);
            linearLayout2 = this.a.j;
            onClickListener = this.a.e;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.a.l = true;
        this.a.n();
    }
}
