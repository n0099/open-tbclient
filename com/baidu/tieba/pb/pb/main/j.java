package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class j implements a.InterfaceC0039a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0039a
    public void a(boolean z, boolean z2, String str) {
        cb cbVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        bk bkVar;
        bk bkVar2;
        cb cbVar2;
        bk bkVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        cbVar = this.cbo.caQ;
        cbVar.aep();
        if (z) {
            aVar = this.cbo.caM;
            if (aVar != null) {
                aVar4 = this.cbo.caM;
                aVar4.ab(z2);
            }
            bkVar = this.cbo.caL;
            bkVar.em(z2);
            bkVar2 = this.cbo.caL;
            if (!bkVar2.qr()) {
                cbVar2 = this.cbo.caQ;
                bkVar3 = this.cbo.caL;
                cbVar2.h(bkVar3.getPbData());
            } else {
                this.cbo.adh();
            }
            if (z2) {
                aVar2 = this.cbo.caM;
                if (aVar2 != null) {
                    aVar3 = this.cbo.caM;
                    MarkData qu = aVar3.qu();
                    if (qu != null) {
                        this.cbo.showToast(MessageFormat.format(this.cbo.getPageContext().getString(i.C0057i.add_mark_on_pb), Integer.valueOf(qu.getFloor())));
                        return;
                    } else {
                        this.cbo.showToast(this.cbo.getPageContext().getString(i.C0057i.add_mark));
                        return;
                    }
                }
                return;
            }
            this.cbo.showToast(this.cbo.getPageContext().getString(i.C0057i.remove_mark));
            return;
        }
        this.cbo.showToast(this.cbo.getPageContext().getString(i.C0057i.update_mark_failed));
    }
}
