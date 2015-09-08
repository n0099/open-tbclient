package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.i;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class j implements a.InterfaceC0039a {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.ccj = pbActivity;
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
        cbVar = this.ccj.cbL;
        cbVar.aeD();
        if (z) {
            aVar = this.ccj.cbH;
            if (aVar != null) {
                aVar4 = this.ccj.cbH;
                aVar4.ab(z2);
            }
            bkVar = this.ccj.cbG;
            bkVar.eu(z2);
            bkVar2 = this.ccj.cbG;
            if (!bkVar2.qo()) {
                cbVar2 = this.ccj.cbL;
                bkVar3 = this.ccj.cbG;
                cbVar2.h(bkVar3.getPbData());
            } else {
                this.ccj.adu();
            }
            if (z2) {
                aVar2 = this.ccj.cbH;
                if (aVar2 != null) {
                    aVar3 = this.ccj.cbH;
                    MarkData qr = aVar3.qr();
                    if (qr != null) {
                        this.ccj.showToast(MessageFormat.format(this.ccj.getPageContext().getString(i.h.add_mark_on_pb), Integer.valueOf(qr.getFloor())));
                        return;
                    } else {
                        this.ccj.showToast(this.ccj.getPageContext().getString(i.h.add_mark));
                        return;
                    }
                }
                return;
            }
            this.ccj.showToast(this.ccj.getPageContext().getString(i.h.remove_mark));
            return;
        }
        this.ccj.showToast(this.ccj.getPageContext().getString(i.h.update_mark_failed));
    }
}
