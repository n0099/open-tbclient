package com.baidu.tieba.recommend;

import android.location.Address;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.t;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends AsyncTask {
    final /* synthetic */ RecommendActivity a;
    private t b;
    private String c;

    private r(RecommendActivity recommendActivity) {
        this.a = recommendActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(RecommendActivity recommendActivity, r rVar) {
        this(recommendActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String str;
        boolean z;
        long j;
        this.b = new t("http://c.tieba.baidu.com/c/s/classic");
        this.b.a(false);
        if (TiebaApplication.b().ag() == 1) {
            this.b.a("night_type", "1");
        }
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        t tVar = this.b;
        str = this.a.p;
        tVar.a("page", str);
        z = RecommendActivity.m;
        if (z) {
            RecommendActivity.m = false;
            this.b.a("msg_click", "1");
            t tVar2 = this.b;
            j = RecommendActivity.n;
            tVar2.a("message_id", String.valueOf(j));
        }
        Address ax = TiebaApplication.b().ax();
        if (ax != null && TiebaApplication.b().l()) {
            this.b.a("lbs", String.valueOf(String.valueOf(ax.getLatitude())) + "," + String.valueOf(ax.getLongitude()));
        }
        try {
            this.c = this.b.i();
            if (this.b.c()) {
                return this.c;
            }
        } catch (Exception e) {
            ag.b("RecommendAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.l = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        LinearLayout linearLayout;
        boolean z;
        TextView textView;
        BaseWebView baseWebView;
        LinearLayout linearLayout2;
        View.OnClickListener onClickListener;
        BaseWebView baseWebView2;
        BaseWebView baseWebView3;
        TextView textView2;
        BaseWebView baseWebView4;
        linearLayout = this.a.e;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.c() || str == null || str.length() <= 0) {
            this.a.i = false;
            String b = com.baidu.tieba.c.k.b(6);
            if (b != null && b.length() > 1) {
                this.a.g = true;
                baseWebView2 = this.a.c;
                baseWebView2.loadDataWithBaseURL("http://c.tieba.baidu.com/", b, "text/html", BdUtil.UTF8, "");
            }
            z = this.a.g;
            if (!z) {
                textView = this.a.j;
                textView.setVisibility(0);
                baseWebView = this.a.c;
                baseWebView.setVisibility(8);
                linearLayout2 = this.a.e;
                onClickListener = this.a.q;
                linearLayout2.setOnClickListener(onClickListener);
            }
        } else {
            com.baidu.tieba.c.k.a(str, 6);
            baseWebView3 = this.a.c;
            baseWebView3.loadDataWithBaseURL("http://c.tieba.baidu.com/", str, "text/html", BdUtil.UTF8, "");
            this.a.g = true;
            textView2 = this.a.j;
            textView2.setVisibility(8);
            baseWebView4 = this.a.c;
            baseWebView4.setVisibility(0);
        }
        this.a.h = true;
        this.a.p();
    }
}
