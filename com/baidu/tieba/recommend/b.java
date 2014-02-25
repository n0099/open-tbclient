package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ DailyClassicalActivity a;
    private ba b;
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
        this.b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/tag/gettogether");
        this.b.b(false);
        if (TiebaApplication.g().al() == 1) {
            this.b.a("night_type", SocialConstants.TRUE);
        }
        ba baVar = this.b;
        str = this.a.q;
        baVar.a("pn", str);
        this.b.a("_version_more", SocialConstants.TRUE);
        this.b.a("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        z = DailyClassicalActivity.o;
        if (z) {
            DailyClassicalActivity.o = false;
            this.b.a("msg_click", SocialConstants.TRUE);
            ba baVar2 = this.b;
            j = DailyClassicalActivity.p;
            baVar2.a("message_id", String.valueOf(j));
        }
        Address b = com.baidu.adp.lib.c.a.a().b(false);
        if (b != null && TiebaApplication.g().t()) {
            this.b.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
        }
        try {
            this.c = this.b.m();
            if (this.b.e()) {
                return this.c;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.k();
        }
        this.a.n = false;
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
        this.a.i = null;
        linearLayout = this.a.h;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.e() && str != null && str.length() > 0) {
            baseWebView2 = this.a.f;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.i.a, str, "text/html", "utf-8", "");
            textView2 = this.a.l;
            textView2.setVisibility(8);
            baseWebView3 = this.a.f;
            baseWebView3.setVisibility(0);
        } else {
            this.a.k = false;
            textView = this.a.l;
            textView.setVisibility(0);
            baseWebView = this.a.f;
            baseWebView.setVisibility(8);
            linearLayout2 = this.a.h;
            onClickListener = this.a.e;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.a.j = true;
        this.a.e();
    }
}
