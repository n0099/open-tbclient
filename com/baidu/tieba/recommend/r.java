package com.baidu.tieba.recommend;

import android.location.Location;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ae;
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
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        t tVar = this.b;
        str = this.a.n;
        tVar.a("page", str);
        z = RecommendActivity.l;
        if (z) {
            RecommendActivity.l = false;
            this.b.a("msg_click", "1");
            t tVar2 = this.b;
            j = RecommendActivity.m;
            tVar2.a("message_id", String.valueOf(j));
        }
        Location at = TiebaApplication.a().at();
        if (at != null && TiebaApplication.a().j()) {
            this.b.a("lbs", String.valueOf(String.valueOf(at.getLatitude())) + "," + String.valueOf(at.getLongitude()));
        }
        try {
            this.c = this.b.i();
            if (this.b.c()) {
                return this.c;
            }
        } catch (Exception e) {
            ae.b("RecommendAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.k = false;
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
        linearLayout = this.a.d;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.c() || str == null || str.length() <= 0) {
            this.a.h = false;
            String a = com.baidu.tieba.c.k.a(6);
            if (a != null && a.length() > 1) {
                this.a.f = true;
                baseWebView2 = this.a.b;
                baseWebView2.loadDataWithBaseURL("http://c.tieba.baidu.com/", a, "text/html", "utf-8", "");
            }
            z = this.a.f;
            if (!z) {
                textView = this.a.i;
                textView.setVisibility(0);
                baseWebView = this.a.b;
                baseWebView.setVisibility(8);
                linearLayout2 = this.a.d;
                onClickListener = this.a.o;
                linearLayout2.setOnClickListener(onClickListener);
            }
        } else {
            com.baidu.tieba.c.k.a(str, 6);
            baseWebView3 = this.a.b;
            baseWebView3.loadDataWithBaseURL("http://c.tieba.baidu.com/", str, "text/html", "utf-8", "");
            this.a.f = true;
            textView2 = this.a.i;
            textView2.setVisibility(8);
            baseWebView4 = this.a.b;
            baseWebView4.setVisibility(0);
        }
        this.a.g = true;
        this.a.n();
    }
}
