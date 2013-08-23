package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyClassicalActivity f1677a;
    private com.baidu.tieba.util.v b;
    private String c;

    private b(DailyClassicalActivity dailyClassicalActivity) {
        this.f1677a = dailyClassicalActivity;
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
        this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/tag/gettogether");
        this.b.b(false);
        if (TiebaApplication.g().an() == 1) {
            this.b.a("night_type", "1");
        }
        com.baidu.tieba.util.v vVar = this.b;
        str = this.f1677a.s;
        vVar.a("pn", str);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = DailyClassicalActivity.q;
        if (z) {
            DailyClassicalActivity.q = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.util.v vVar2 = this.b;
            j = DailyClassicalActivity.r;
            vVar2.a("message_id", String.valueOf(j));
        }
        Address aK = TiebaApplication.g().aK();
        if (aK != null && TiebaApplication.g().v()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
        }
        try {
            this.c = this.b.j();
            if (this.b.d()) {
                return this.c;
            }
        } catch (Exception e) {
            aq.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1677a.p = false;
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
        this.f1677a.k = null;
        linearLayout = this.f1677a.j;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.d() && str != null && str.length() > 0) {
            baseWebView2 = this.f1677a.f;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.f1014a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f1677a.n;
            textView2.setVisibility(8);
            baseWebView3 = this.f1677a.f;
            baseWebView3.setVisibility(0);
        } else {
            this.f1677a.m = false;
            textView = this.f1677a.n;
            textView.setVisibility(0);
            baseWebView = this.f1677a.f;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f1677a.j;
            onClickListener = this.f1677a.e;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.f1677a.l = true;
        this.f1677a.l();
    }
}
