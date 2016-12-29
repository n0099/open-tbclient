package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.r;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0032a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        er erVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        dc dcVar;
        dc dcVar2;
        er erVar2;
        dc dcVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        erVar = this.eah.dZk;
        erVar.aLW();
        if (z) {
            aVar = this.eah.dxb;
            if (aVar != null) {
                aVar4 = this.eah.dxb;
                aVar4.ad(z2);
            }
            dcVar = this.eah.dYA;
            dcVar.im(z2);
            dcVar2 = this.eah.dYA;
            if (!dcVar2.nz()) {
                erVar2 = this.eah.dZk;
                dcVar3 = this.eah.dYA;
                erVar2.j(dcVar3.getPbData());
            } else {
                this.eah.aJp();
            }
            if (z2) {
                aVar2 = this.eah.dxb;
                if (aVar2 != null) {
                    aVar3 = this.eah.dxb;
                    MarkData nC = aVar3.nC();
                    if (nC != null) {
                        this.eah.showToast(MessageFormat.format(this.eah.getPageContext().getString(r.j.add_mark_on_pb), Integer.valueOf(nC.getFloor())));
                        return;
                    } else {
                        this.eah.showToast(this.eah.getPageContext().getString(r.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.eah.showToast(this.eah.getPageContext().getString(r.j.remove_mark));
            return;
        }
        this.eah.showToast(this.eah.getPageContext().getString(r.j.update_mark_failed));
    }
}
