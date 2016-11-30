package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.r;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class af implements a.InterfaceC0032a {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        ey eyVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        dj djVar;
        dj djVar2;
        ey eyVar2;
        dj djVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        eyVar = this.evL.euP;
        eyVar.aSc();
        if (z) {
            aVar = this.evL.dSz;
            if (aVar != null) {
                aVar4 = this.evL.dSz;
                aVar4.ad(z2);
            }
            djVar = this.evL.euf;
            djVar.iz(z2);
            djVar2 = this.evL.euf;
            if (!djVar2.nz()) {
                eyVar2 = this.evL.euP;
                djVar3 = this.evL.euf;
                eyVar2.j(djVar3.getPbData());
            } else {
                this.evL.aPq();
            }
            if (z2) {
                aVar2 = this.evL.dSz;
                if (aVar2 != null) {
                    aVar3 = this.evL.dSz;
                    MarkData nC = aVar3.nC();
                    if (nC != null) {
                        this.evL.showToast(MessageFormat.format(this.evL.getPageContext().getString(r.j.add_mark_on_pb), Integer.valueOf(nC.getFloor())));
                        return;
                    } else {
                        this.evL.showToast(this.evL.getPageContext().getString(r.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.evL.showToast(this.evL.getPageContext().getString(r.j.remove_mark));
            return;
        }
        this.evL.showToast(this.evL.getPageContext().getString(r.j.update_mark_failed));
    }
}
