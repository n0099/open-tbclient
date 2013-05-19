package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.k;
import com.baidu.tieba.d.t;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.a {
    final /* synthetic */ RecommendActivity a;
    private t b;
    private String c;

    private g(RecommendActivity recommendActivity) {
        this.a = recommendActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(RecommendActivity recommendActivity, g gVar) {
        this(recommendActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        boolean z;
        long j;
        this.b = new t(com.baidu.tieba.a.i.h);
        this.b.a(false);
        if (TiebaApplication.d().ai() == 1) {
            this.b.a("night_type", "1");
        }
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        t tVar = this.b;
        str = this.a.p;
        tVar.a("page", str);
        z = RecommendActivity.m;
        if (z) {
            RecommendActivity.m = false;
            this.b.a("msg_click", "1");
            t tVar2 = this.b;
            j = RecommendActivity.n;
            tVar2.a("message_id", String.valueOf(j));
        }
        Address aC = TiebaApplication.d().aC();
        if (aC != null && TiebaApplication.d().o()) {
            this.b.a("lbs", String.valueOf(String.valueOf(aC.getLatitude())) + "," + String.valueOf(aC.getLongitude()));
        }
        try {
            this.c = this.b.i();
            if (this.b.c()) {
                return this.c;
            }
        } catch (Exception e) {
            ae.b("RecommendAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.l = false;
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
        BaseWebView baseWebView3;
        TextView textView2;
        BaseWebView baseWebView4;
        linearLayout = this.a.e;
        linearLayout.setOnClickListener(null);
        if (this.b == null || !this.b.c() || str == null || str.length() <= 0) {
            this.a.i = false;
            String b = k.b(6);
            if (b != null && b.length() > 1) {
                this.a.g = true;
                baseWebView2 = this.a.c;
                baseWebView2.loadDataWithBaseURL(com.baidu.tieba.a.i.e, b, "text/html", BdUtil.UTF8, "");
            }
            z = this.a.g;
            if (!z) {
                textView = this.a.j;
                textView.setVisibility(0);
                baseWebView = this.a.c;
                baseWebView.setVisibility(8);
                linearLayout2 = this.a.e;
                onClickListener = this.a.q;
                linearLayout2.setOnClickListener(onClickListener);
            }
        } else {
            k.a(str, 6);
            baseWebView3 = this.a.c;
            baseWebView3.loadDataWithBaseURL(com.baidu.tieba.a.i.e, str, "text/html", BdUtil.UTF8, "");
            this.a.g = true;
            textView2 = this.a.j;
            textView2.setVisibility(8);
            baseWebView4 = this.a.c;
            baseWebView4.setVisibility(0);
        }
        this.a.h = true;
        this.a.p();
    }
}
