package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.n;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class p implements a.InterfaceC0040a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0040a
    public void a(boolean z, boolean z2, String str) {
        dk dkVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        cf cfVar;
        cf cfVar2;
        dk dkVar2;
        cf cfVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        dkVar = this.cFS.cFq;
        dkVar.amN();
        if (z) {
            aVar = this.cFS.cFm;
            if (aVar != null) {
                aVar4 = this.cFS.cFm;
                aVar4.Y(z2);
            }
            cfVar = this.cFS.cFl;
            cfVar.fe(z2);
            cfVar2 = this.cFS.cFl;
            if (!cfVar2.pN()) {
                dkVar2 = this.cFS.cFq;
                cfVar3 = this.cFS.cFl;
                dkVar2.i(cfVar3.getPbData());
            } else {
                this.cFS.alr();
            }
            if (z2) {
                aVar2 = this.cFS.cFm;
                if (aVar2 != null) {
                    aVar3 = this.cFS.cFm;
                    MarkData pQ = aVar3.pQ();
                    if (pQ != null) {
                        this.cFS.showToast(MessageFormat.format(this.cFS.getPageContext().getString(n.j.add_mark_on_pb), Integer.valueOf(pQ.getFloor())));
                        return;
                    } else {
                        this.cFS.showToast(this.cFS.getPageContext().getString(n.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.cFS.showToast(this.cFS.getPageContext().getString(n.j.remove_mark));
            return;
        }
        this.cFS.showToast(this.cFS.getPageContext().getString(n.j.update_mark_failed));
    }
}
