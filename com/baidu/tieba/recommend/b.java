package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ DailyClassicalActivity a;
    private at b;
    private String c;

    private b(DailyClassicalActivity dailyClassicalActivity) {
        this.a = dailyClassicalActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(DailyClassicalActivity dailyClassicalActivity, a aVar) {
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
        this.b = new at(com.baidu.tieba.data.h.a + "c/s/tag/gettogether");
        this.b.b(false);
        if (TiebaApplication.g().an() == 1) {
            this.b.a("night_type", SocialConstants.TRUE);
        }
        at atVar = this.b;
        str = this.a.q;
        atVar.a("pn", str);
        this.b.a("_version_more", SocialConstants.TRUE);
        this.b.a("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        z = DailyClassicalActivity.o;
        if (z) {
            boolean unused = DailyClassicalActivity.o = false;
            this.b.a("msg_click", SocialConstants.TRUE);
            at atVar2 = this.b;
            j = DailyClassicalActivity.p;
            atVar2.a("message_id", String.valueOf(j));
        }
        Address aQ = TiebaApplication.g().aQ();
        if (aQ != null && TiebaApplication.g().t()) {
            this.b.a("lbs", String.valueOf(aQ.getLatitude()) + "," + String.valueOf(aQ.getLongitude()));
        }
        try {
            this.c = this.b.l();
            if (this.b.d()) {
                return this.c;
            }
        } catch (Exception e) {
            bo.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.j();
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
        if (this.b == null || !this.b.d() || str == null || str.length() <= 0) {
            this.a.k = false;
            textView = this.a.l;
            textView.setVisibility(0);
            baseWebView = this.a.f;
            baseWebView.setVisibility(8);
            linearLayout2 = this.a.h;
            onClickListener = this.a.e;
            linearLayout2.setOnClickListener(onClickListener);
        } else {
            baseWebView2 = this.a.f;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.h.a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.a.l;
            textView2.setVisibility(8);
            baseWebView3 = this.a.f;
            baseWebView3.setVisibility(0);
        }
        this.a.j = true;
        this.a.e();
    }
}
