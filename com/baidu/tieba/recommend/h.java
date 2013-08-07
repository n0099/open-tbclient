package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1665a;
    private final /* synthetic */ com.baidu.tieba.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, com.baidu.tieba.data.o oVar) {
        this.f1665a = cVar;
        this.b = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.f1665a.i;
        StatService.onEvent(activity, "recommend_to_pb", "click");
        activity2 = this.f1665a.i;
        com.baidu.tieba.util.am.a(activity2, this.b.a(), (String) null);
    }
}
