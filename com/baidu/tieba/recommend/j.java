package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bIb;
    private final /* synthetic */ com.baidu.tieba.data.m bIc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.data.m mVar) {
        this.bIb = iVar;
        this.bIc = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.bIb.aBF;
        TiebaStatic.eventStat(activity, "recommend_to_pb", "click");
        bf mR = bf.mR();
        activity2 = this.bIb.aBF;
        mR.b(activity2, new String[]{this.bIc.getLink()});
    }
}
