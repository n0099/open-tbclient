package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class j implements a.InterfaceC0039a {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0039a
    public void a(boolean z, boolean z2, String str) {
        cc ccVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        bl blVar;
        bl blVar2;
        cc ccVar2;
        bl blVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        ccVar = this.ciz.cia;
        ccVar.agB();
        if (z) {
            aVar = this.ciz.chW;
            if (aVar != null) {
                aVar4 = this.ciz.chW;
                aVar4.ab(z2);
            }
            blVar = this.ciz.chV;
            blVar.ez(z2);
            blVar2 = this.ciz.chV;
            if (!blVar2.qk()) {
                ccVar2 = this.ciz.cia;
                blVar3 = this.ciz.chV;
                ccVar2.h(blVar3.getPbData());
            } else {
                this.ciz.afs();
            }
            if (z2) {
                aVar2 = this.ciz.chW;
                if (aVar2 != null) {
                    aVar3 = this.ciz.chW;
                    MarkData qn = aVar3.qn();
                    if (qn != null) {
                        this.ciz.showToast(MessageFormat.format(this.ciz.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(qn.getFloor())));
                        return;
                    } else {
                        this.ciz.showToast(this.ciz.getPageContext().getString(i.h.add_mark));
                        return;
                    }
                }
                return;
            }
            this.ciz.showToast(this.ciz.getPageContext().getString(i.h.remove_mark));
            return;
        }
        this.ciz.showToast(this.ciz.getPageContext().getString(i.h.update_mark_failed));
    }
}
