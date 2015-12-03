package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements aj.a {
    final /* synthetic */ p ciY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.ciY = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void g(String str, long j) {
        a aVar;
        int g = com.baidu.adp.lib.h.b.g(String.valueOf(j), 0);
        aVar = this.ciY.ciW;
        aVar.jd(g);
        this.ciY.o(g, false);
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void h(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.ciY.ciV;
        newUserGuideActivity.showToast(n.i.error);
    }
}
