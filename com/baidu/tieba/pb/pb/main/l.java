package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements cq.a {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void j(int i, long j) {
        dc dcVar;
        dc dcVar2;
        er erVar;
        dc dcVar3;
        if (i != 0) {
            this.eah.showToast(r.j.operation_failed);
            return;
        }
        this.eah.nz(2);
        ej.aLu().reset();
        dcVar = this.eah.dYA;
        dcVar.aKC();
        dcVar2 = this.eah.dYA;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = dcVar2.getPbData().aIm();
        if (aIm != null) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aIm.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                if (eq.h(next) && next.bgi().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                erVar = this.eah.dZk;
                dcVar3 = this.eah.dYA;
                erVar.j(dcVar3.getPbData());
            }
            this.eah.showToast(r.j.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void onError(int i, String str) {
        this.eah.showToast(r.j.operation_failed);
    }
}
