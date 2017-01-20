package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.r;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0031a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0031a
    public void a(boolean z, boolean z2, String str) {
        ez ezVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        PbModel pbModel;
        PbModel pbModel2;
        ez ezVar2;
        PbModel pbModel3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        ezVar = this.eiV.ehV;
        ezVar.aNL();
        if (z) {
            aVar = this.eiV.dGi;
            if (aVar != null) {
                aVar4 = this.eiV.dGi;
                aVar4.ad(z2);
            }
            pbModel = this.eiV.ehh;
            pbModel.iw(z2);
            pbModel2 = this.eiV.ehh;
            if (!pbModel2.nt()) {
                ezVar2 = this.eiV.ehV;
                pbModel3 = this.eiV.ehh;
                ezVar2.j(pbModel3.getPbData());
            } else {
                this.eiV.aLc();
            }
            if (z2) {
                aVar2 = this.eiV.dGi;
                if (aVar2 != null) {
                    aVar3 = this.eiV.dGi;
                    MarkData nw = aVar3.nw();
                    if (nw != null) {
                        this.eiV.showToast(MessageFormat.format(this.eiV.getPageContext().getString(r.l.add_mark_on_pb), Integer.valueOf(nw.getFloor())));
                        return;
                    } else {
                        this.eiV.showToast(this.eiV.getPageContext().getString(r.l.add_mark));
                        return;
                    }
                }
                return;
            }
            this.eiV.showToast(this.eiV.getPageContext().getString(r.l.remove_mark));
            return;
        }
        this.eiV.showToast(this.eiV.getPageContext().getString(r.l.update_mark_failed));
    }
}
