package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ com.baidu.tieba.data.p a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(h hVar, com.baidu.tieba.data.p pVar) {
        this.b = hVar;
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.b.i;
        by.a(activity, "recommend_to_pb", "click");
        activity2 = this.b.i;
        UtilHelper.a(activity2, this.a.a(), null, null);
    }
}
