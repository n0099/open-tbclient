package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ DailyClassicalActivity a;
    private ak b;
    private String c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        LinearLayout linearLayout;
        TextView textView;
        BaseWebView baseWebView;
        LinearLayout linearLayout2;
        View.OnClickListener onClickListener;
        BaseWebView baseWebView2;
        TextView textView2;
        BaseWebView baseWebView3;
        String str2 = str;
        this.a.i = null;
        linearLayout = this.a.h;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.c() && str2 != null && str2.length() > 0) {
            baseWebView2 = this.a.f;
            baseWebView2.loadDataWithBaseURL(com.baidu.tbadk.core.data.n.a, str2, "text/html", "utf-8", "");
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
        DailyClassicalActivity.f(this.a);
    }

    private c(DailyClassicalActivity dailyClassicalActivity) {
        this.a = dailyClassicalActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(DailyClassicalActivity dailyClassicalActivity, byte b) {
        this(dailyClassicalActivity);
    }

    private String a() {
        String str;
        boolean z;
        long j;
        this.b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/tag/gettogether");
        this.b.a().a().a().g = false;
        if (TbadkApplication.j().l() == 1) {
            this.b.a("night_type", "1");
        }
        ak akVar = this.b;
        str = this.a.q;
        akVar.a("pn", str);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = DailyClassicalActivity.o;
        if (z) {
            DailyClassicalActivity.o = false;
            this.b.a("msg_click", "1");
            ak akVar2 = this.b;
            j = DailyClassicalActivity.p;
            akVar2.a("message_id", String.valueOf(j));
        }
        Address b = com.baidu.adp.lib.c.a.a().b(false);
        if (b != null && com.baidu.tieba.r.c().j()) {
            this.b.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
        }
        try {
            this.c = this.b.i();
            if (this.b.c()) {
                return this.c;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.n = false;
        super.cancel(true);
    }
}
