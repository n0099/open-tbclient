package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        ag agVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        ag agVar2;
        boolean z = false;
        if (obj != null) {
            aVar2 = this.exF.exs;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    a.b bVar = (a.b) obj;
                    if (bVar.cuW || bVar.eyv <= 0 || bVar.fxt == 1) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.exF.getPageContext(), 3, 1);
                    }
                    this.exF.a(bVar, z);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    agVar2 = this.exF.exu;
                    agVar2.a(1, dVar.ub, dVar.fxv, true);
                    return;
                default:
                    return;
            }
        }
        agVar = this.exF.exu;
        aVar = this.exF.exs;
        agVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
