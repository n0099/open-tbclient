package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements aj.a {
    final /* synthetic */ p cEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.cEi = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void g(String str, long j) {
        a aVar;
        int g = com.baidu.adp.lib.h.b.g(String.valueOf(j), 0);
        aVar = this.cEi.cEg;
        aVar.kG(g);
        this.cEi.q(g, false);
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void h(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.cEi.cEf;
        newUserGuideActivity.showToast(t.j.error);
    }
}
