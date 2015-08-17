package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.h.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity cfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.cfY = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        t tVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        t tVar2;
        if (obj != null) {
            aVar2 = this.cfY.cfQ;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cfY.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    tVar2 = this.cfY.cfR;
                    tVar2.a(1, dVar.Ao, dVar.cKw, true);
                    return;
                default:
                    return;
            }
        }
        tVar = this.cfY.cfR;
        aVar = this.cfY.cfQ;
        tVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
