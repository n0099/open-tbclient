package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.w;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0030a {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0030a
    public void a(boolean z, boolean z2, String str) {
        fa faVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        PbModel pbModel;
        PbModel pbModel2;
        fa faVar2;
        PbModel pbModel3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        faVar = this.elO.ekM;
        faVar.aNe();
        if (z) {
            aVar = this.elO.dIP;
            if (aVar != null) {
                aVar4 = this.elO.dIP;
                aVar4.ac(z2);
            }
            pbModel = this.elO.ejZ;
            pbModel.ir(z2);
            pbModel2 = this.elO.ejZ;
            if (!pbModel2.nH()) {
                faVar2 = this.elO.ekM;
                pbModel3 = this.elO.ejZ;
                faVar2.k(pbModel3.getPbData());
            } else {
                this.elO.aKx();
            }
            if (z2) {
                aVar2 = this.elO.dIP;
                if (aVar2 != null) {
                    aVar3 = this.elO.dIP;
                    MarkData nK = aVar3.nK();
                    if (nK != null) {
                        this.elO.showToast(MessageFormat.format(this.elO.getPageContext().getString(w.l.add_mark_on_pb), Integer.valueOf(nK.getFloor())));
                        return;
                    } else {
                        this.elO.showToast(this.elO.getPageContext().getString(w.l.add_mark));
                        return;
                    }
                }
                return;
            }
            this.elO.showToast(this.elO.getPageContext().getString(w.l.remove_mark));
            return;
        }
        this.elO.showToast(this.elO.getPageContext().getString(w.l.update_mark_failed));
    }
}
