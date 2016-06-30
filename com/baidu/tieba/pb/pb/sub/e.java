package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        af afVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        af afVar2;
        if (obj != null) {
            aVar2 = this.dWP.dWD;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.dWP.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    afVar2 = this.dWP.dWE;
                    afVar2.a(1, dVar.rg, dVar.eZR, true);
                    return;
                default:
                    return;
            }
        }
        afVar = this.dWP.dWE;
        aVar = this.dWP.dWD;
        afVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
