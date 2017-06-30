package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ak implements a.InterfaceC0035a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0035a
    public void a(boolean z, boolean z2, String str) {
        gg ggVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        PbModel pbModel;
        PbModel pbModel2;
        gg ggVar2;
        PbModel pbModel3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        ggVar = this.ewh.euU;
        ggVar.aQz();
        if (z) {
            aVar = this.ewh.dPW;
            if (aVar != null) {
                aVar4 = this.ewh.dPW;
                aVar4.ac(z2);
            }
            pbModel = this.ewh.eue;
            pbModel.iQ(z2);
            pbModel2 = this.ewh.eue;
            if (!pbModel2.nz()) {
                ggVar2 = this.ewh.euU;
                pbModel3 = this.ewh.eue;
                ggVar2.l(pbModel3.getPbData());
            } else {
                this.ewh.aNO();
            }
            if (z2) {
                aVar2 = this.ewh.dPW;
                if (aVar2 != null) {
                    aVar3 = this.ewh.dPW;
                    if (aVar3.nC() != null) {
                        this.ewh.showToast(w.l.add_mark_on_pb);
                        return;
                    } else {
                        this.ewh.showToast(this.ewh.getPageContext().getString(w.l.add_mark));
                        return;
                    }
                }
                return;
            }
            this.ewh.showToast(this.ewh.getPageContext().getString(w.l.remove_mark));
            return;
        }
        this.ewh.showToast(this.ewh.getPageContext().getString(w.l.update_mark_failed));
    }
}
