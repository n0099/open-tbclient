package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.g.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        t tVar;
        com.baidu.tieba.tbadkCore.g.a aVar;
        com.baidu.tieba.tbadkCore.g.a aVar2;
        t tVar2;
        if (obj != null) {
            aVar2 = this.cmr.cmj;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cmr.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    tVar2 = this.cmr.cmk;
                    tVar2.a(1, dVar.An, dVar.daB, true);
                    return;
                default:
                    return;
            }
        }
        tVar = this.cmr.cmk;
        aVar = this.cmr.cmj;
        tVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
