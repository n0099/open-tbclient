package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1663a;
    private final /* synthetic */ com.baidu.tieba.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, com.baidu.tieba.data.o oVar) {
        this.f1663a = cVar;
        this.b = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.f1663a.i;
        com.baidu.tieba.util.am.a(activity, this.b.a(), (String) null);
    }
}
