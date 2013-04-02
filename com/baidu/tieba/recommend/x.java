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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends AsyncTask {
    final /* synthetic */ TagContentActivity a;
    private com.baidu.tieba.c.t b;
    private String c;

    private x(TagContentActivity tagContentActivity) {
        this.a = tagContentActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(TagContentActivity tagContentActivity, x xVar) {
        this(tagContentActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        long j;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/tag/tagthread");
        this.b.a(false);
        if (TiebaApplication.b().ah() == 1) {
            this.b.a("night_type", "1");
        }
        com.baidu.tieba.c.t tVar = this.b;
        str = this.a.d;
        tVar.a("tag_id", str);
        com.baidu.tieba.c.t tVar2 = this.b;
        str2 = this.a.c;
        tVar2.a("tag_name", str2);
        com.baidu.tieba.c.t tVar3 = this.b;
        str3 = this.a.e;
        tVar3.a("tag_is_selected", str3);
        com.baidu.tieba.c.t tVar4 = this.b;
        str4 = this.a.y;
        tVar4.a("pn", str4);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = TagContentActivity.w;
        if (z) {
            TagContentActivity.w = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.c.t tVar5 = this.b;
            j = TagContentActivity.x;
            tVar5.a("message_id", String.valueOf(j));
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
        } catch (Exception e) {
            ag.b("TagAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.v = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
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
        linearLayout = this.a.o;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.c() && str != null && str.length() > 0) {
            baseWebView2 = this.a.m;
            baseWebView2.loadDataWithBaseURL("http://c.tieba.baidu.com/", str, "text/html", BdUtil.UTF8, "");
            textView2 = this.a.t;
            textView2.setVisibility(8);
            baseWebView3 = this.a.m;
            baseWebView3.setVisibility(0);
        } else {
            this.a.s = false;
            textView = this.a.t;
            textView.setVisibility(0);
            baseWebView = this.a.m;
            baseWebView.setVisibility(8);
            linearLayout2 = this.a.o;
            onClickListener = this.a.l;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.a.r = true;
        this.a.o();
    }
}
