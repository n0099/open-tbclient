package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i a;
    private final /* synthetic */ com.baidu.tieba.data.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.data.m mVar) {
        this.a = iVar;
        this.b = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.a.b;
        TiebaStatic.eventStat(activity, "recommend_to_pb", "click");
        bq a = bq.a();
        activity2 = this.a.b;
        a.a(activity2, new String[]{this.b.a()});
    }
}
