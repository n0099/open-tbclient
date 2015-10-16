package com.baidu.tieba.person.post;

import com.baidu.tieba.tbadkCore.g.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p crV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.crV = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.g.a aVar;
        com.baidu.tieba.tbadkCore.g.a aVar2;
        if (obj != null) {
            aVar2 = this.crV.cij;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.crV.a((a.b) obj);
                    return;
                default:
                    return;
            }
        }
        p pVar = this.crV;
        aVar = this.crV.cij;
        pVar.a(aVar.getLoadDataMode(), false, null, false);
    }
}
