package com.baidu.tieba.person.post;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.g {
    final /* synthetic */ q dEO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.dEO = qVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        if (obj != null) {
            aVar2 = this.dEO.diO;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.dEO.a((a.b) obj);
                    return;
                default:
                    return;
            }
        }
        q qVar = this.dEO;
        aVar = this.dEO.diO;
        qVar.a(aVar.getLoadDataMode(), false, null, false);
    }
}
