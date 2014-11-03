package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i bIp;
    private final /* synthetic */ com.baidu.tieba.data.m bIq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.data.m mVar) {
        this.bIp = iVar;
        this.bIq = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.bIp.aBP;
        TiebaStatic.eventStat(activity, "recommend_to_pb", "click");
        bg mR = bg.mR();
        activity2 = this.bIp.aBP;
        mR.b(activity2, new String[]{this.bIq.getLink()});
    }
}
