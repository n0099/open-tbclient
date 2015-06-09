package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.i {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        s sVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        s sVar2;
        if (obj != null) {
            aVar2 = this.bPx.bPp;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.bPx.a((com.baidu.tieba.tbadkCore.h.c) obj);
                    return;
                case 1:
                    com.baidu.tieba.tbadkCore.h.e eVar = (com.baidu.tieba.tbadkCore.h.e) obj;
                    sVar2 = this.bPx.bPr;
                    sVar2.a(1, eVar.AA, eVar.ctU, true);
                    return;
                default:
                    return;
            }
        }
        sVar = this.bPx.bPr;
        aVar = this.bPx.bPp;
        sVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
