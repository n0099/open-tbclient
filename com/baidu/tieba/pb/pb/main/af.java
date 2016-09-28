package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.r;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class af implements a.InterfaceC0032a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.eqa = pbActivity;
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
        exVar = this.eqa.epe;
        exVar.aQb();
        if (z) {
            aVar = this.eqa.dMU;
            if (aVar != null) {
                aVar4 = this.eqa.dMU;
                aVar4.ad(z2);
            }
            dhVar = this.eqa.eov;
            dhVar.ih(z2);
            dhVar2 = this.eqa.eov;
            if (!dhVar2.nv()) {
                exVar2 = this.eqa.epe;
                dhVar3 = this.eqa.eov;
                exVar2.j(dhVar3.getPbData());
            } else {
                this.eqa.aNy();
            }
            if (z2) {
                aVar2 = this.eqa.dMU;
                if (aVar2 != null) {
                    aVar3 = this.eqa.dMU;
                    MarkData ny = aVar3.ny();
                    if (ny != null) {
                        this.eqa.showToast(MessageFormat.format(this.eqa.getPageContext().getString(r.j.add_mark_on_pb), Integer.valueOf(ny.getFloor())));
                        return;
                    } else {
                        this.eqa.showToast(this.eqa.getPageContext().getString(r.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.eqa.showToast(this.eqa.getPageContext().getString(r.j.remove_mark));
            return;
        }
        this.eqa.showToast(this.eqa.getPageContext().getString(r.j.update_mark_failed));
    }
}
