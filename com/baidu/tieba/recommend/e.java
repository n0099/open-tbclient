package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.af;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.k;
import com.baidu.tieba.d.t;
import com.baidu.tieba.view.BaseWebView;
import java.net.URLDecoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.a.a {
    final /* synthetic */ NewHomeActivity a;
    private t b;
    private String c;

    private e(NewHomeActivity newHomeActivity) {
        this.a = newHomeActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(NewHomeActivity newHomeActivity, e eVar) {
        this(newHomeActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        boolean z;
        String q;
        String e;
        long j;
        this.b = new t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/tag/allthread");
        this.b.d(true);
        this.b.a(false);
        if (TiebaApplication.e().as() == 1) {
            this.b.a("night_type", "1");
        }
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        t tVar = this.b;
        str = this.a.x;
        tVar.a("pn", str);
        z = NewHomeActivity.v;
        if (z) {
            NewHomeActivity.v = false;
            this.b.a("msg_click", "1");
            t tVar2 = this.b;
            j = NewHomeActivity.w;
            tVar2.a("message_id", String.valueOf(j));
        }
        q = this.a.q();
        if (q != null && q.length() > 0) {
            this.b.a("tid_list", q);
        }
        String C = TiebaApplication.C();
        if ((C == null || C.length() == 0) && (e = af.e()) != null && e.length() > 0) {
            this.b.a("tag_info", e);
        }
        Address aM = TiebaApplication.e().aM();
        if (aM != null && TiebaApplication.e().q()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aM.getLatitude())) + "," + String.valueOf(aM.getLongitude()));
        }
        try {
            this.c = this.b.i();
            if (this.b.c()) {
                return this.c;
            }
        } catch (Exception e2) {
            ae.b("RecommendAsyncTask", "doInBackground", "error = " + e2.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.u = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
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
        linearLayout = this.a.n;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.c() || str == null || str.length() <= 0) {
            this.a.r = false;
            this.a.p();
            z = this.a.p;
            if (!z) {
                textView = this.a.s;
                textView.setVisibility(0);
                baseWebView = this.a.l;
                baseWebView.setVisibility(8);
                linearLayout2 = this.a.n;
                onClickListener = this.a.k;
                linearLayout2.setOnClickListener(onClickListener);
            }
        } else {
            k.a(str, 10);
            baseWebView2 = this.a.l;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.a.i.e, str, "text/html", BdUtil.UTF8, "");
            this.a.p = true;
            textView2 = this.a.s;
            textView2.setVisibility(8);
            baseWebView3 = this.a.l;
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
        this.a.q = true;
        this.a.r();
    }
}
