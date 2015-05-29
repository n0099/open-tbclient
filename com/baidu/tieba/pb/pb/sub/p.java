package com.baidu.tieba.pb.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.i {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        s sVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        s sVar2;
        if (obj != null) {
            aVar2 = this.bPw.bPo;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.bPw.a((com.baidu.tieba.tbadkCore.h.c) obj);
                    return;
                case 1:
                    com.baidu.tieba.tbadkCore.h.e eVar = (com.baidu.tieba.tbadkCore.h.e) obj;
                    sVar2 = this.bPw.bPq;
                    sVar2.a(1, eVar.AA, eVar.ctT, true);
                    return;
                default:
                    return;
            }
        }
        sVar = this.bPw.bPq;
        aVar = this.bPw.bPo;
        sVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
