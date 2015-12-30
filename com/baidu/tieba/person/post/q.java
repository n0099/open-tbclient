package com.baidu.tieba.person.post;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.g {
    final /* synthetic */ p cVF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.cVF = pVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        if (obj != null) {
            aVar2 = this.cVF.cFn;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cVF.a((a.b) obj);
                    return;
                default:
                    return;
            }
        }
        p pVar = this.cVF;
        aVar = this.cVF.cFn;
        pVar.a(aVar.getLoadDataMode(), false, null, false);
    }
}
