package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1686a;
    private final /* synthetic */ com.baidu.tieba.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, com.baidu.tieba.data.o oVar) {
        this.f1686a = hVar;
        this.b = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.f1686a.i;
        UtilHelper.a(activity, this.b.a(), (String) null);
    }
}
