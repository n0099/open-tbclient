package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TagContentActivity f1391a;
    private r b;
    private String c;

    private h(TagContentActivity tagContentActivity) {
        this.f1391a = tagContentActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(TagContentActivity tagContentActivity, h hVar) {
        this(tagContentActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        long j;
        this.b = new r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/tag/tagthread");
        this.b.a(false);
        if (TiebaApplication.f().at() == 1) {
            this.b.a("night_type", "1");
        }
        r rVar = this.b;
        str = this.f1391a.b;
        rVar.a("tag_id", str);
        r rVar2 = this.b;
        str2 = this.f1391a.f1383a;
        rVar2.a("tag_name", str2);
        r rVar3 = this.b;
        str3 = this.f1391a.c;
        rVar3.a("tag_is_selected", str3);
        r rVar4 = this.b;
        str4 = this.f1391a.y;
        rVar4.a("pn", str4);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = TagContentActivity.w;
        if (z) {
            TagContentActivity.w = false;
            this.b.a("msg_click", "1");
            r rVar5 = this.b;
            j = TagContentActivity.x;
            rVar5.a("message_id", String.valueOf(j));
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
        } catch (Exception e) {
            z.b("TagAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1391a.v = false;
        super.cancel(true);
        this.f1391a.p = null;
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
        linearLayout = this.f1391a.o;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.d() && str != null && str.length() > 0) {
            baseWebView2 = this.f1391a.m;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.f787a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f1391a.t;
            textView2.setVisibility(8);
            baseWebView3 = this.f1391a.m;
            baseWebView3.setVisibility(0);
        } else {
            this.f1391a.s = false;
            textView = this.f1391a.t;
            textView.setVisibility(0);
            baseWebView = this.f1391a.m;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f1391a.o;
            onClickListener = this.f1391a.l;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.f1391a.p = null;
        this.f1391a.r = true;
        this.f1391a.p();
    }
}
