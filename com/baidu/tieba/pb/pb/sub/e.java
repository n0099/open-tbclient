package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        af afVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        af afVar2;
        if (obj != null) {
            aVar2 = this.ejr.ejf;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.ejr.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    afVar2 = this.ejr.ejg;
                    afVar2.a(1, dVar.rJ, dVar.fmU, true);
                    return;
                default:
                    return;
            }
        }
        afVar = this.ejr.ejg;
        aVar = this.ejr.ejf;
        afVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
