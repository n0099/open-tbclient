package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ h a;
    private final /* synthetic */ com.baidu.tieba.data.q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar, com.baidu.tieba.data.q qVar) {
        this.a = hVar;
        this.b = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.a.i;
        cb.a(activity, "recommend_to_pb", "click");
        activity2 = this.a.i;
        UtilHelper.a(activity2, this.b.a(), null, null);
    }
}
