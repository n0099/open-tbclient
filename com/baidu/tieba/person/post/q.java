package com.baidu.tieba.person.post;

import com.baidu.tieba.tbadkCore.g.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p crK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.crK = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.g.a aVar;
        com.baidu.tieba.tbadkCore.g.a aVar2;
        if (obj != null) {
            aVar2 = this.crK.chX;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.crK.a((a.b) obj);
                    return;
                default:
                    return;
            }
        }
        p pVar = this.crK;
        aVar = this.crK.chX;
        pVar.a(aVar.getLoadDataMode(), false, null, false);
    }
}
