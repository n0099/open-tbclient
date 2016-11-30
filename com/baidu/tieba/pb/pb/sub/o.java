package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        ao aoVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ao aoVar2;
        boolean z = false;
        if (obj != null) {
            aVar2 = this.eEs.eEc;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    a.b bVar = (a.b) obj;
                    if (bVar.cAf || bVar.eFf <= 0 || bVar.fEy == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eEs.getPageContext(), 3, 1);
                    }
                    this.eEs.a(bVar, z);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    aoVar2 = this.eEs.eEd;
                    aoVar2.a(1, dVar.uc, dVar.fEA, true);
                    return;
                default:
                    return;
            }
        }
        aoVar = this.eEs.eEd;
        aVar = this.eEs.eEc;
        aoVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
