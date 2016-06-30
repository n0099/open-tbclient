package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tieba.u;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0032a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0032a
    public void a(boolean z, boolean z2, String str) {
        es esVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        dg dgVar;
        dg dgVar2;
        es esVar2;
        dg dgVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        com.baidu.tbadk.baseEditMark.a aVar4;
        esVar = this.dPF.dOO;
        esVar.aHq();
        if (z) {
            aVar = this.dPF.dvH;
            if (aVar != null) {
                aVar4 = this.dPF.dvH;
                aVar4.Z(z2);
            }
            dgVar = this.dPF.dOf;
            dgVar.hy(z2);
            dgVar2 = this.dPF.dOf;
            if (!dgVar2.mK()) {
                esVar2 = this.dPF.dOO;
                dgVar3 = this.dPF.dOf;
                esVar2.j(dgVar3.getPbData());
            } else {
                this.dPF.aEP();
            }
            if (z2) {
                aVar2 = this.dPF.dvH;
                if (aVar2 != null) {
                    aVar3 = this.dPF.dvH;
                    MarkData mN = aVar3.mN();
                    if (mN != null) {
                        this.dPF.showToast(MessageFormat.format(this.dPF.getPageContext().getString(u.j.add_mark_on_pb), Integer.valueOf(mN.getFloor())));
                        return;
                    } else {
                        this.dPF.showToast(this.dPF.getPageContext().getString(u.j.add_mark));
                        return;
                    }
                }
                return;
            }
            this.dPF.showToast(this.dPF.getPageContext().getString(u.j.remove_mark));
            return;
        }
        this.dPF.showToast(this.dPF.getPageContext().getString(u.j.update_mark_failed));
    }
}
