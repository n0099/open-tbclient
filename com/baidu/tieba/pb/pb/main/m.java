package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class m implements cq.a {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void j(int i, long j) {
        dh dhVar;
        dh dhVar2;
        ex exVar;
        dh dhVar3;
        if (i != 0) {
            this.eqa.showToast(r.j.operation_failed);
            return;
        }
        this.eqa.on(2);
        ep.aPz().reset();
        dhVar = this.eqa.eov;
        dhVar.aOM();
        dhVar2 = this.eqa.eov;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = dhVar2.getPbData().aMt();
        if (aMt != null) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aMt.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                if (ew.g(next) && next.bjY().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                exVar = this.eqa.epe;
                dhVar3 = this.eqa.eov;
                exVar.j(dhVar3.getPbData());
            }
            this.eqa.showToast(r.j.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void onError(int i, String str) {
        this.eqa.showToast(r.j.operation_failed);
    }
}
