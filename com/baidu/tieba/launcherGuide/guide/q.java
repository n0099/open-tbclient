package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p bSe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bSe = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        if (obj == null) {
            newUserGuideActivity4 = this.bSe.bSb;
            newUserGuideActivity4.showToast(i.h.neterror);
        } else if (obj instanceof x) {
            int g = com.baidu.adp.lib.g.b.g(((x) obj).getFid(), 0);
            aVar = this.bSe.bSc;
            aVar.hU(g);
            this.bSe.m(g, true);
            newUserGuideActivity = this.bSe.bSb;
            newUserGuideActivity.dG(true);
            newUserGuideActivity2 = this.bSe.bSb;
            newUserGuideActivity2.dF(true);
            newUserGuideActivity3 = this.bSe.bSb;
            TiebaStatic.eventStat(newUserGuideActivity3.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
        }
    }
}
