package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class s implements a.InterfaceC0041a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0041a
    public void a(boolean z, boolean z2, String str) {
        dz dzVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        cm cmVar;
        cm cmVar2;
        dz dzVar2;
        cm cmVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        dzVar = this.cNq.cMK;
        dzVar.ark();
        if (z) {
            aVar = this.cNq.cMG;
            if (aVar != null) {
                aVar4 = this.cNq.cMG;
                aVar4.Y(z2);
            }
            cmVar = this.cNq.cMF;
            cmVar.ft(z2);
            cmVar2 = this.cNq.cMF;
            if (!cmVar2.qg()) {
                dzVar2 = this.cNq.cMK;
                cmVar3 = this.cNq.cMF;
                dzVar2.j(cmVar3.getPbData());
            } else {
                this.cNq.apv();
            }
            if (z2) {
                aVar2 = this.cNq.cMG;
                if (aVar2 != null) {
                    aVar3 = this.cNq.cMG;
                    MarkData qj = aVar3.qj();
                    if (qj != null) {
                        this.cNq.showToast(MessageFormat.format(this.cNq.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(qj.getFloor())));
                        return;
                    } else {
                        this.cNq.showToast(this.cNq.getPageContext().getString(t.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.cNq.showToast(this.cNq.getPageContext().getString(t.j.remove_mark));
            return;
        }
        this.cNq.showToast(this.cNq.getPageContext().getString(t.j.update_mark_failed));
    }
}
