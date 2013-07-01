package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ai;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
import com.baidu.tieba.view.BaseWebView;
import java.net.URLDecoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewHomeActivity f1388a;
    private r b;
    private String c;

    private e(NewHomeActivity newHomeActivity) {
        this.f1388a = newHomeActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(NewHomeActivity newHomeActivity, e eVar) {
        this(newHomeActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        boolean z;
        String q;
        String e;
        long j;
        this.b = new r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/tag/allthread");
        this.b.d(true);
        this.b.a(false);
        if (TiebaApplication.f().at() == 1) {
            this.b.a("night_type", "1");
        }
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        r rVar = this.b;
        str = this.f1388a.x;
        rVar.a("pn", str);
        z = NewHomeActivity.v;
        if (z) {
            NewHomeActivity.v = false;
            this.b.a("msg_click", "1");
            r rVar2 = this.b;
            j = NewHomeActivity.w;
            rVar2.a("message_id", String.valueOf(j));
        }
        q = this.f1388a.q();
        if (q != null && q.length() > 0) {
            this.b.a("tid_list", q);
        }
        String E = TiebaApplication.E();
        if ((E == null || E.length() == 0) && (e = ai.e()) != null && e.length() > 0) {
            this.b.a("tag_info", e);
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
        } catch (Exception e2) {
            z.b("RecommendAsyncTask", "doInBackground", "error = " + e2.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1388a.u = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        LinearLayout linearLayout;
        boolean z;
        TextView textView;
        BaseWebView baseWebView;
        LinearLayout linearLayout2;
        View.OnClickListener onClickListener;
        BaseWebView baseWebView2;
        TextView textView2;
        BaseWebView baseWebView3;
        linearLayout = this.f1388a.n;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.d() || str == null || str.length() <= 0) {
            this.f1388a.r = false;
            this.f1388a.p();
            z = this.f1388a.p;
            if (!z) {
                textView = this.f1388a.s;
                textView.setVisibility(0);
                baseWebView = this.f1388a.l;
                baseWebView.setVisibility(8);
                linearLayout2 = this.f1388a.n;
                onClickListener = this.f1388a.k;
                linearLayout2.setOnClickListener(onClickListener);
            }
        } else {
            DatabaseService.a(str, 10);
            baseWebView2 = this.f1388a.l;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.f787a, str, "text/html", BdUtil.UTF8, "");
            this.f1388a.p = true;
            textView2 = this.f1388a.s;
            textView2.setVisibility(8);
            baseWebView3 = this.f1388a.l;
            baseWebView3.setVisibility(0);
            int indexOf = str.indexOf("dataType=\"idSet\">");
            if (indexOf != -1) {
                int length = indexOf + "dataType=\"idSet\">".length();
                int i = length;
                while (i < str.length() && str.charAt(i) != '<') {
                    i++;
                }
                this.f1388a.c(URLDecoder.decode(str.substring(length, i)));
            }
        }
        this.f1388a.q = true;
        this.f1388a.r();
    }
}
