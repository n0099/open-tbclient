package com.baidu.tieba.person.post;

import com.baidu.tieba.tbadkCore.h.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p cmh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.cmh = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        if (obj != null) {
            aVar2 = this.cmh.cbI;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cmh.a((a.b) obj);
                    return;
                default:
                    return;
            }
        }
        p pVar = this.cmh;
        aVar = this.cmh.cbI;
        pVar.a(aVar.getLoadDataMode(), false, null, false);
    }
}
