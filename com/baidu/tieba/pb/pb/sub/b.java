package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.h.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        v vVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        v vVar2;
        if (obj != null) {
            aVar2 = this.cnS.cnI;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cnS.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    vVar2 = this.cnS.cnJ;
                    vVar2.a(1, dVar.An, dVar.ddm, true);
                    return;
                default:
                    return;
            }
        }
        vVar = this.cnS.cnJ;
        aVar = this.cnS.cnI;
        vVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
