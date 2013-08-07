package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.BaseWebView;
import java.net.URLDecoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewHomeActivity f1650a;
    private com.baidu.tieba.util.u b;
    private String c;

    private ax(NewHomeActivity newHomeActivity) {
        this.f1650a = newHomeActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(NewHomeActivity newHomeActivity, ax axVar) {
        this(newHomeActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        boolean z;
        String o;
        String e;
        long j;
        this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/tag/allthread");
        this.b.e(true);
        this.b.b(false);
        if (TiebaApplication.f().au() == 1) {
            this.b.a("night_type", "1");
        }
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        com.baidu.tieba.util.u uVar = this.b;
        str = this.f1650a.x;
        uVar.a("pn", str);
        z = NewHomeActivity.v;
        if (z) {
            NewHomeActivity.v = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.util.u uVar2 = this.b;
            j = NewHomeActivity.w;
            uVar2.a("message_id", String.valueOf(j));
        }
        o = this.f1650a.o();
        if (o != null && o.length() > 0) {
            this.b.a("tid_list", o);
        }
        String E = TiebaApplication.E();
        if ((E == null || E.length() == 0) && (e = com.baidu.tieba.model.aq.e()) != null && e.length() > 0) {
            this.b.a("tag_info", e);
        }
        Address aT = TiebaApplication.f().aT();
        if (aT != null && TiebaApplication.f().u()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aT.getLatitude())) + "," + String.valueOf(aT.getLongitude()));
        }
        try {
            this.c = this.b.k();
            if (this.b.e()) {
                return this.c;
            }
        } catch (Exception e2) {
            com.baidu.tieba.util.aj.b("RecommendAsyncTask", "doInBackground", "error = " + e2.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        this.f1650a.u = false;
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
        linearLayout = this.f1650a.n;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.e() || str == null || str.length() <= 0) {
            this.f1650a.r = false;
            this.f1650a.n();
            z = this.f1650a.p;
            if (!z) {
                textView = this.f1650a.s;
                textView.setVisibility(0);
                baseWebView = this.f1650a.l;
                baseWebView.setVisibility(8);
                linearLayout2 = this.f1650a.n;
                onClickListener = this.f1650a.k;
                linearLayout2.setOnClickListener(onClickListener);
            }
        } else {
            DatabaseService.a(str, 10);
            baseWebView2 = this.f1650a.l;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.f1011a, str, "text/html", BdUtil.UTF8, "");
            this.f1650a.p = true;
            textView2 = this.f1650a.s;
            textView2.setVisibility(8);
            baseWebView3 = this.f1650a.l;
            baseWebView3.setVisibility(0);
            int indexOf = str.indexOf("dataType=\"idSet\">");
            if (indexOf != -1) {
                int length = indexOf + "dataType=\"idSet\">".length();
                int i = length;
                while (i < str.length() && str.charAt(i) != '<') {
                    i++;
                }
                this.f1650a.c(URLDecoder.decode(str.substring(length, i)));
            }
        }
        this.f1650a.q = true;
        this.f1650a.p();
    }
}
