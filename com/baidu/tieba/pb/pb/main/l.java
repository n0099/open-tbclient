package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cp;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements cp.a {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cp.a
    public void i(int i, long j) {
        dg dgVar;
        dg dgVar2;
        es esVar;
        dg dgVar3;
        if (i != 0) {
            this.dPF.showToast(u.j.operation_failed);
            return;
        }
        this.dPF.ni(2);
        el.aGM().reset();
        dgVar = this.dPF.dOf;
        dgVar.aGc();
        dgVar2 = this.dPF.dOf;
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = dgVar2.getPbData().aDP();
        if (aDP != null) {
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = aDP.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.s next = it.next();
                if (er.f(next) && next.bcw().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                esVar = this.dPF.dOO;
                dgVar3 = this.dPF.dOf;
                esVar.j(dgVar3.getPbData());
            }
            this.dPF.showToast(u.j.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cp.a
    public void onError(int i, String str) {
        this.dPF.showToast(u.j.operation_failed);
    }
}
