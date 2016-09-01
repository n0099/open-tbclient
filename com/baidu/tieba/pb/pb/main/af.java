package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.t;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class af implements a.InterfaceC0032a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        ex exVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        dh dhVar;
        dh dhVar2;
        ex exVar2;
        dh dhVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        exVar = this.eob.enh;
        exVar.aPs();
        if (z) {
            aVar = this.eob.dKY;
            if (aVar != null) {
                aVar4 = this.eob.dKY;
                aVar4.ad(z2);
            }
            dhVar = this.eob.emx;
            dhVar.ie(z2);
            dhVar2 = this.eob.emx;
            if (!dhVar2.nv()) {
                exVar2 = this.eob.enh;
                dhVar3 = this.eob.emx;
                exVar2.j(dhVar3.getPbData());
            } else {
                this.eob.aMS();
            }
            if (z2) {
                aVar2 = this.eob.dKY;
                if (aVar2 != null) {
                    aVar3 = this.eob.dKY;
                    MarkData ny = aVar3.ny();
                    if (ny != null) {
                        this.eob.showToast(MessageFormat.format(this.eob.getPageContext().getString(t.j.add_mark_on_pb), Integer.valueOf(ny.getFloor())));
                        return;
                    } else {
                        this.eob.showToast(this.eob.getPageContext().getString(t.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.eob.showToast(this.eob.getPageContext().getString(t.j.remove_mark));
            return;
        }
        this.eob.showToast(this.eob.getPageContext().getString(t.j.update_mark_failed));
    }
}
