package com.baidu.tieba.launcherGuide.guide;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p cEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.cEi = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        if (obj == null) {
            newUserGuideActivity4 = this.cEi.cEf;
            newUserGuideActivity4.showToast(t.j.neterror);
        } else if (obj instanceof x) {
            int g = com.baidu.adp.lib.h.b.g(((x) obj).getFid(), 0);
            aVar = this.cEi.cEg;
            aVar.kF(g);
            this.cEi.q(g, true);
            newUserGuideActivity = this.cEi.cEf;
            newUserGuideActivity.eR(true);
            newUserGuideActivity2 = this.cEi.cEf;
            newUserGuideActivity2.eQ(true);
            newUserGuideActivity3 = this.cEi.cEf;
            TiebaStatic.eventStat(newUserGuideActivity3.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
        }
    }
}
