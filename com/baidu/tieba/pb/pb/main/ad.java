package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.u;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0032a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        ew ewVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        dh dhVar;
        dh dhVar2;
        ew ewVar2;
        dh dhVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        ewVar = this.ebT.ebb;
        ewVar.aKB();
        if (z) {
            aVar = this.ebT.dzj;
            if (aVar != null) {
                aVar4 = this.ebT.dzj;
                aVar4.ab(z2);
            }
            dhVar = this.ebT.eas;
            dhVar.hJ(z2);
            dhVar2 = this.ebT.eas;
            if (!dhVar2.mA()) {
                ewVar2 = this.ebT.ebb;
                dhVar3 = this.ebT.eas;
                ewVar2.j(dhVar3.getPbData());
            } else {
                this.ebT.aIa();
            }
            if (z2) {
                aVar2 = this.ebT.dzj;
                if (aVar2 != null) {
                    aVar3 = this.ebT.dzj;
                    MarkData mD = aVar3.mD();
                    if (mD != null) {
                        this.ebT.showToast(MessageFormat.format(this.ebT.getPageContext().getString(u.j.add_mark_on_pb), Integer.valueOf(mD.getFloor())));
                        return;
                    } else {
                        this.ebT.showToast(this.ebT.getPageContext().getString(u.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.ebT.showToast(this.ebT.getPageContext().getString(u.j.remove_mark));
            return;
        }
        this.ebT.showToast(this.ebT.getPageContext().getString(u.j.update_mark_failed));
    }
}
