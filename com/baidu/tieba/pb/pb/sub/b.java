package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.g.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity cmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.cmC = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        t tVar;
        com.baidu.tieba.tbadkCore.g.a aVar;
        com.baidu.tieba.tbadkCore.g.a aVar2;
        t tVar2;
        if (obj != null) {
            aVar2 = this.cmC.cmu;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cmC.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    tVar2 = this.cmC.cmv;
                    tVar2.a(1, dVar.An, dVar.dbb, true);
                    return;
                default:
                    return;
            }
        }
        tVar = this.cmC.cmv;
        aVar = this.cmC.cmu;
        tVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
