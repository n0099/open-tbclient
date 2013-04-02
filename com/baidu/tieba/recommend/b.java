package com.baidu.tieba.recommend;

import android.location.Address;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends AsyncTask {
    final /* synthetic */ DailyClassicalActivity a;
    private com.baidu.tieba.c.t b;
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String str;
        boolean z;
        long j;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/tag/gettogether");
        this.b.a(false);
        if (TiebaApplication.b().ah() == 1) {
            this.b.a("night_type", "1");
        }
        com.baidu.tieba.c.t tVar = this.b;
        str = this.a.s;
        tVar.a("pn", str);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = DailyClassicalActivity.q;
        if (z) {
            DailyClassicalActivity.q = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.c.t tVar2 = this.b;
            j = DailyClassicalActivity.r;
            tVar2.a("message_id", String.valueOf(j));
        }
        Address aC = TiebaApplication.b().aC();
        if (aC != null && TiebaApplication.b().m()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aC.getLatitude())) + "," + String.valueOf(aC.getLongitude()));
        }
        try {
            this.c = this.b.i();
            if (this.b.c()) {
                return this.c;
            }
        } catch (Exception e) {
            ag.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.p = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        LinearLayout linearLayout;
        TextView textView;
        BaseWebView baseWebView;
        LinearLayout linearLayout2;
        View.OnClickListener onClickListener;
        BaseWebView baseWebView2;
        TextView textView2;
        BaseWebView baseWebView3;
        linearLayout = this.a.j;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.c() && str != null && str.length() > 0) {
            baseWebView2 = this.a.h;
            baseWebView2.loadDataWithBaseURL("http://c.tieba.baidu.com/", str, "text/html", BdUtil.UTF8, "");
            textView2 = this.a.n;
            textView2.setVisibility(8);
            baseWebView3 = this.a.h;
            baseWebView3.setVisibility(0);
        } else {
            this.a.m = false;
            textView = this.a.n;
            textView.setVisibility(0);
            baseWebView = this.a.h;
            baseWebView.setVisibility(8);
            linearLayout2 = this.a.j;
            onClickListener = this.a.g;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.a.l = true;
        this.a.m();
    }
}
