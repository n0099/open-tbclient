package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.n;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class n implements a.InterfaceC0040a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0040a
    public void a(boolean z, boolean z2, String str) {
        da daVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        cc ccVar;
        cc ccVar2;
        da daVar2;
        cc ccVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        daVar = this.cCm.cBL;
        daVar.alB();
        if (z) {
            aVar = this.cCm.cBH;
            if (aVar != null) {
                aVar4 = this.cCm.cBH;
                aVar4.ab(z2);
            }
            ccVar = this.cCm.cBG;
            ccVar.ff(z2);
            ccVar2 = this.cCm.cBG;
            if (!ccVar2.qp()) {
                daVar2 = this.cCm.cBL;
                ccVar3 = this.cCm.cBG;
                daVar2.i(ccVar3.getPbData());
            } else {
                this.cCm.akk();
            }
            if (z2) {
                aVar2 = this.cCm.cBH;
                if (aVar2 != null) {
                    aVar3 = this.cCm.cBH;
                    MarkData qs = aVar3.qs();
                    if (qs != null) {
                        this.cCm.showToast(MessageFormat.format(this.cCm.getPageContext().getString(n.i.add_mark_on_pb), Integer.valueOf(qs.getFloor())));
                        return;
                    } else {
                        this.cCm.showToast(this.cCm.getPageContext().getString(n.i.add_mark));
                        return;
                    }
                }
                return;
            }
            this.cCm.showToast(this.cCm.getPageContext().getString(n.i.remove_mark));
            return;
        }
        this.cCm.showToast(this.cCm.getPageContext().getString(n.i.update_mark_failed));
    }
}
