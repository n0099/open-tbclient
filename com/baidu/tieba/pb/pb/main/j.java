package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class j implements a.InterfaceC0039a {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.ciK = pbActivity;
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
        ccVar = this.ciK.cim;
        ccVar.agB();
        if (z) {
            aVar = this.ciK.cii;
            if (aVar != null) {
                aVar4 = this.ciK.cii;
                aVar4.ab(z2);
            }
            blVar = this.ciK.cih;
            blVar.ez(z2);
            blVar2 = this.ciK.cih;
            if (!blVar2.qk()) {
                ccVar2 = this.ciK.cim;
                blVar3 = this.ciK.cih;
                ccVar2.h(blVar3.getPbData());
            } else {
                this.ciK.afs();
            }
            if (z2) {
                aVar2 = this.ciK.cii;
                if (aVar2 != null) {
                    aVar3 = this.ciK.cii;
                    MarkData qn = aVar3.qn();
                    if (qn != null) {
                        this.ciK.showToast(MessageFormat.format(this.ciK.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(qn.getFloor())));
                        return;
                    } else {
                        this.ciK.showToast(this.ciK.getPageContext().getString(i.h.add_mark));
                        return;
                    }
                }
                return;
            }
            this.ciK.showToast(this.ciK.getPageContext().getString(i.h.remove_mark));
            return;
        }
        this.ciK.showToast(this.ciK.getPageContext().getString(i.h.update_mark_failed));
    }
}
