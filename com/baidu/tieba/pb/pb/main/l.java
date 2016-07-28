package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements cq.a {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void j(int i, long j) {
        dh dhVar;
        dh dhVar2;
        ew ewVar;
        dh dhVar3;
        if (i != 0) {
            this.ebT.showToast(u.j.operation_failed);
            return;
        }
        this.ebT.nA(2);
        ep.aJZ().reset();
        dhVar = this.ebT.eas;
        dhVar.aJn();
        dhVar2 = this.ebT.eas;
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = dhVar2.getPbData().aGZ();
        if (aGZ != null) {
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = aGZ.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.s next = it.next();
                if (ev.g(next) && next.bfL().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                ewVar = this.ebT.ebb;
                dhVar3 = this.ebT.eas;
                ewVar.j(dhVar3.getPbData());
            }
            this.ebT.showToast(u.j.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void onError(int i, String str) {
        this.ebT.showToast(u.j.operation_failed);
    }
}
