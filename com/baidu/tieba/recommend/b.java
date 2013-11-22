package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DailyClassicalActivity f2290a;
    private ap b;
    private String c;

    private b(DailyClassicalActivity dailyClassicalActivity) {
        this.f2290a = dailyClassicalActivity;
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
        this.b = new ap(com.baidu.tieba.data.h.f1201a + "c/s/tag/gettogether");
        this.b.b(false);
        if (TiebaApplication.g().ap() == 1) {
            this.b.a("night_type", SocialConstants.TRUE);
        }
        ap apVar = this.b;
        str = this.f2290a.q;
        apVar.a("pn", str);
        this.b.a("_version_more", SocialConstants.TRUE);
        this.b.a("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        z = DailyClassicalActivity.o;
        if (z) {
            boolean unused = DailyClassicalActivity.o = false;
            this.b.a("msg_click", SocialConstants.TRUE);
            ap apVar2 = this.b;
            j = DailyClassicalActivity.p;
            apVar2.a("message_id", String.valueOf(j));
        }
        Address aP = TiebaApplication.g().aP();
        if (aP != null && TiebaApplication.g().t()) {
            this.b.a("lbs", String.valueOf(aP.getLatitude()) + "," + String.valueOf(aP.getLongitude()));
        }
        try {
            this.c = this.b.l();
            if (this.b.d()) {
                return this.c;
            }
        } catch (Exception e) {
            bg.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.j();
        }
        this.f2290a.n = false;
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
        this.f2290a.i = null;
        linearLayout = this.f2290a.h;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.d() || str == null || str.length() <= 0) {
            this.f2290a.k = false;
            textView = this.f2290a.l;
            textView.setVisibility(0);
            baseWebView = this.f2290a.f;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f2290a.h;
            onClickListener = this.f2290a.e;
            linearLayout2.setOnClickListener(onClickListener);
        } else {
            baseWebView2 = this.f2290a.f;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.h.f1201a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f2290a.l;
            textView2.setVisibility(8);
            baseWebView3 = this.f2290a.f;
            baseWebView3.setVisibility(0);
        }
        this.f2290a.j = true;
        this.f2290a.e();
    }
}
