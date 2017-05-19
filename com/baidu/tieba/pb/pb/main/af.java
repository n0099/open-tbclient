package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class af implements a.InterfaceC0033a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0033a
    public void a(boolean z, boolean z2, String str) {
        fm fmVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        PbModel pbModel;
        PbModel pbModel2;
        fm fmVar2;
        PbModel pbModel3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        fmVar = this.ehy.egt;
        fmVar.aLF();
        if (z) {
            aVar = this.ehy.dCb;
            if (aVar != null) {
                aVar4 = this.ehy.dCb;
                aVar4.ad(z2);
            }
            pbModel = this.ehy.efE;
            pbModel.m15if(z2);
            pbModel2 = this.ehy.efE;
            if (!pbModel2.nL()) {
                fmVar2 = this.ehy.egt;
                pbModel3 = this.ehy.efE;
                fmVar2.l(pbModel3.getPbData());
            } else {
                this.ehy.aJa();
            }
            if (z2) {
                aVar2 = this.ehy.dCb;
                if (aVar2 != null) {
                    aVar3 = this.ehy.dCb;
                    if (aVar3.nO() != null) {
                        this.ehy.showToast(w.l.add_mark_on_pb);
                        return;
                    } else {
                        this.ehy.showToast(this.ehy.getPageContext().getString(w.l.add_mark));
                        return;
                    }
                }
                return;
            }
            this.ehy.showToast(this.ehy.getPageContext().getString(w.l.remove_mark));
            return;
        }
        this.ehy.showToast(this.ehy.getPageContext().getString(w.l.update_mark_failed));
    }
}
