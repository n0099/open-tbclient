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
import java.net.URLDecoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends AsyncTask {
    final /* synthetic */ NewHomeActivity a;
    private com.baidu.tieba.c.t b;
    private String c;

    private s(NewHomeActivity newHomeActivity) {
        this.a = newHomeActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(NewHomeActivity newHomeActivity, s sVar) {
        this(newHomeActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String str;
        boolean z;
        String p;
        String e;
        long j;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/tag/allthread");
        this.b.d(true);
        this.b.a(false);
        if (TiebaApplication.b().ah() == 1) {
            this.b.a("night_type", "1");
        }
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        com.baidu.tieba.c.t tVar = this.b;
        str = this.a.w;
        tVar.a("pn", str);
        z = NewHomeActivity.u;
        if (z) {
            NewHomeActivity.u = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.c.t tVar2 = this.b;
            j = NewHomeActivity.v;
            tVar2.a("message_id", String.valueOf(j));
        }
        p = this.a.p();
        if (p != null && p.length() > 0) {
            this.b.a("tid_list", p);
        }
        String y = TiebaApplication.y();
        if ((y == null || y.length() == 0) && (e = com.baidu.tieba.b.f.e()) != null && e.length() > 0) {
            this.b.a("tag_info", e);
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
        } catch (Exception e2) {
            ag.b("RecommendAsyncTask", "doInBackground", "error = " + e2.getMessage());
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.t = false;
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
        TextView textView2;
        BaseWebView baseWebView3;
        linearLayout = this.a.m;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.c() || str == null || str.length() <= 0) {
            this.a.q = false;
            this.a.o();
            z = this.a.o;
            if (!z) {
                textView = this.a.r;
                textView.setVisibility(0);
                baseWebView = this.a.k;
                baseWebView.setVisibility(8);
                linearLayout2 = this.a.m;
                onClickListener = this.a.j;
                linearLayout2.setOnClickListener(onClickListener);
            }
        } else {
            com.baidu.tieba.c.k.a(str, 10);
            baseWebView2 = this.a.k;
            baseWebView2.loadDataWithBaseURL("http://c.tieba.baidu.com/", str, "text/html", BdUtil.UTF8, "");
            this.a.o = true;
            textView2 = this.a.r;
            textView2.setVisibility(8);
            baseWebView3 = this.a.k;
            baseWebView3.setVisibility(0);
            int indexOf = str.indexOf("dataType=\"idSet\">");
            if (indexOf != -1) {
                int length = indexOf + "dataType=\"idSet\">".length();
                int i = length;
                while (i < str.length() && str.charAt(i) != '<') {
                    i++;
                }
                this.a.c(URLDecoder.decode(str.substring(length, i)));
            }
        }
        this.a.p = true;
        this.a.q();
    }
}
