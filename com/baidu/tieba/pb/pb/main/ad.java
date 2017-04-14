package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.w;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0028a {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0028a
    public void a(boolean z, boolean z2, String str) {
        ey eyVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        PbModel pbModel;
        PbModel pbModel2;
        ey eyVar2;
        PbModel pbModel3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        eyVar = this.ejU.eiS;
        eyVar.aNn();
        if (z) {
            aVar = this.ejU.dFo;
            if (aVar != null) {
                aVar4 = this.ejU.dFo;
                aVar4.ae(z2);
            }
            pbModel = this.ejU.eif;
            pbModel.iq(z2);
            pbModel2 = this.ejU.eif;
            if (!pbModel2.oe()) {
                eyVar2 = this.ejU.eiS;
                pbModel3 = this.ejU.eif;
                eyVar2.k(pbModel3.getPbData());
            } else {
                this.ejU.aKE();
            }
            if (z2) {
                aVar2 = this.ejU.dFo;
                if (aVar2 != null) {
                    aVar3 = this.ejU.dFo;
                    MarkData oh = aVar3.oh();
                    if (oh != null) {
                        this.ejU.showToast(MessageFormat.format(this.ejU.getPageContext().getString(w.l.add_mark_on_pb), Integer.valueOf(oh.getFloor())));
                        return;
                    } else {
                        this.ejU.showToast(this.ejU.getPageContext().getString(w.l.add_mark));
                        return;
                    }
                }
                return;
            }
            this.ejU.showToast(this.ejU.getPageContext().getString(w.l.remove_mark));
            return;
        }
        this.ejU.showToast(this.ejU.getPageContext().getString(w.l.update_mark_failed));
    }
}
