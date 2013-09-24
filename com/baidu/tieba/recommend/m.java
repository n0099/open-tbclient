package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1763a;
    private final /* synthetic */ com.baidu.tieba.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar, com.baidu.tieba.data.o oVar) {
        this.f1763a = hVar;
        this.b = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.f1763a.i;
        StatService.onEvent(activity, "recommend_to_pb", "click");
        activity2 = this.f1763a.i;
        UtilHelper.a(activity2, this.b.a(), (String) null);
    }
}
