package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        w wVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        w wVar2;
        if (obj != null) {
            aVar2 = this.cHd.cGT;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cHd.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    wVar2 = this.cHd.cGU;
                    wVar2.a(1, dVar.At, dVar.dBx, true);
                    return;
                default:
                    return;
            }
        }
        wVar = this.cHd.cGU;
        aVar = this.cHd.cGT;
        wVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
