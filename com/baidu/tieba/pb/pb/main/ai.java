package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ai implements a.InterfaceC0033a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0033a
    public void a(boolean z, boolean z2, String str) {
        fx fxVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        PbModel pbModel;
        PbModel pbModel2;
        fx fxVar2;
        PbModel pbModel3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        fxVar = this.enc.elU;
        fxVar.aMB();
        if (z) {
            aVar = this.enc.dHz;
            if (aVar != null) {
                aVar4 = this.enc.dHz;
                aVar4.ac(z2);
            }
            pbModel = this.enc.ele;
            pbModel.iu(z2);
            pbModel2 = this.enc.ele;
            if (!pbModel2.nD()) {
                fxVar2 = this.enc.elU;
                pbModel3 = this.enc.ele;
                fxVar2.l(pbModel3.getPbData());
            } else {
                this.enc.aJS();
            }
            if (z2) {
                aVar2 = this.enc.dHz;
                if (aVar2 != null) {
                    aVar3 = this.enc.dHz;
                    if (aVar3.nG() != null) {
                        this.enc.showToast(w.l.add_mark_on_pb);
                        return;
                    } else {
                        this.enc.showToast(this.enc.getPageContext().getString(w.l.add_mark));
                        return;
                    }
                }
                return;
            }
            this.enc.showToast(this.enc.getPageContext().getString(w.l.remove_mark));
            return;
        }
        this.enc.showToast(this.enc.getPageContext().getString(w.l.update_mark_failed));
    }
}
