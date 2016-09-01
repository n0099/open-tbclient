package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        ag agVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ag agVar2;
        boolean z = false;
        if (obj != null) {
            aVar2 = this.evy.evm;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    a.b bVar = (a.b) obj;
                    if (bVar.cuz || bVar.ewn <= 0 || bVar.fuM == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.evy.getPageContext(), 3, 1);
                    }
                    this.evy.a(bVar, z);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    agVar2 = this.evy.evn;
                    agVar2.a(1, dVar.ub, dVar.fuO, true);
                    return;
                default:
                    return;
            }
        }
        agVar = this.evy.evn;
        aVar = this.evy.evm;
        agVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
