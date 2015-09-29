package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements ai.a {
    final /* synthetic */ p bSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.bSe = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void g(String str, long j) {
        a aVar;
        int g = com.baidu.adp.lib.g.b.g(String.valueOf(j), 0);
        aVar = this.bSe.bSc;
        aVar.hV(g);
        this.bSe.m(g, false);
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void h(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.bSe.bSb;
        newUserGuideActivity.showToast(i.h.error);
    }
}
