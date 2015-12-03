package com.baidu.tieba.person.post;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p cRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.cRd = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        if (obj != null) {
            aVar2 = this.cRd.cBI;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cRd.a((a.b) obj);
                    return;
                default:
                    return;
            }
        }
        p pVar = this.cRd;
        aVar = this.cRd.cBI;
        pVar.a(aVar.getLoadDataMode(), false, null, false);
    }
}
