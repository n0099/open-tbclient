package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ DailyClassicalActivity a;
    private al b;
    private String c;

    private c(DailyClassicalActivity dailyClassicalActivity) {
        this.a = dailyClassicalActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(DailyClassicalActivity dailyClassicalActivity, c cVar) {
        this(dailyClassicalActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String str;
        boolean z;
        long j;
        this.b = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/tag/gettogether");
        this.b.a().a().a().g = false;
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.b.a("night_type", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        }
        al alVar = this.b;
        str = this.a.q;
        alVar.a("pn", str);
        this.b.a("_version_more", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        this.b.a("platform", "android");
        z = DailyClassicalActivity.o;
        if (z) {
            DailyClassicalActivity.o = false;
            this.b.a("msg_click", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            al alVar2 = this.b;
            j = DailyClassicalActivity.p;
            alVar2.a("message_id", String.valueOf(j));
        }
        Address b = com.baidu.adp.lib.c.a.a().b(false);
        if (b != null && ad.c().m()) {
            this.b.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
        }
        try {
            this.c = this.b.i();
            if (this.b.c()) {
                return this.c;
            }
        } catch (Exception e) {
            BdLog.e("ContentAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.n = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
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
        this.a.i = null;
        linearLayout = this.a.h;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.c() && str != null && str.length() > 0) {
            baseWebView2 = this.a.f;
            baseWebView2.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
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
