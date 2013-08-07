package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TagContentActivity f1658a;
    private com.baidu.tieba.util.u b;
    private String c;

    private be(TagContentActivity tagContentActivity) {
        this.f1658a = tagContentActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(TagContentActivity tagContentActivity, be beVar) {
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
        this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/tag/tagthread");
        this.b.b(false);
        if (TiebaApplication.f().au() == 1) {
            this.b.a("night_type", "1");
        }
        com.baidu.tieba.util.u uVar = this.b;
        str = this.f1658a.b;
        uVar.a("tag_id", str);
        com.baidu.tieba.util.u uVar2 = this.b;
        str2 = this.f1658a.f1628a;
        uVar2.a("tag_name", str2);
        com.baidu.tieba.util.u uVar3 = this.b;
        str3 = this.f1658a.c;
        uVar3.a("tag_is_selected", str3);
        com.baidu.tieba.util.u uVar4 = this.b;
        str4 = this.f1658a.y;
        uVar4.a("pn", str4);
        this.b.a("_version_more", "1");
        this.b.a("platform", "android");
        z = TagContentActivity.w;
        if (z) {
            TagContentActivity.w = false;
            this.b.a("msg_click", "1");
            com.baidu.tieba.util.u uVar5 = this.b;
            j = TagContentActivity.x;
            uVar5.a("message_id", String.valueOf(j));
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
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("TagAsyncTask", "doInBackground", "error = " + e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        this.f1658a.v = false;
        super.cancel(true);
        this.f1658a.p = null;
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
        linearLayout = this.f1658a.o;
        linearLayout.setOnClickListener(null);
        if (this.b != null && this.b.e() && str != null && str.length() > 0) {
            baseWebView2 = this.f1658a.m;
            baseWebView2.loadDataWithBaseURL(com.baidu.tieba.data.g.f1011a, str, "text/html", BdUtil.UTF8, "");
            textView2 = this.f1658a.t;
            textView2.setVisibility(8);
            baseWebView3 = this.f1658a.m;
            baseWebView3.setVisibility(0);
        } else {
            this.f1658a.s = false;
            textView = this.f1658a.t;
            textView.setVisibility(0);
            baseWebView = this.f1658a.m;
            baseWebView.setVisibility(8);
            linearLayout2 = this.f1658a.o;
            onClickListener = this.f1658a.l;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.f1658a.p = null;
        this.f1658a.r = true;
        this.f1658a.n();
    }
}
