package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.p f2283a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar, com.baidu.tieba.data.p pVar) {
        this.b = hVar;
        this.f2283a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.b.i;
        StatService.onEvent(activity, "recommend_to_pb", "click");
        activity2 = this.b.i;
        UtilHelper.a(activity2, this.f2283a.a(), (String) null);
    }
}
