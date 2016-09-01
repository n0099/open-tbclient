package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cq;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class m implements cq.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void j(int i, long j) {
        dh dhVar;
        dh dhVar2;
        ex exVar;
        dh dhVar3;
        if (i != 0) {
            this.eob.showToast(t.j.operation_failed);
            return;
        }
        this.eob.od(2);
        ep.aOQ().reset();
        dhVar = this.eob.emx;
        dhVar.aOe();
        dhVar2 = this.eob.emx;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = dhVar2.getPbData().aLR();
        if (aLR != null) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aLR.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                if (ew.g(next) && next.bjm().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                exVar = this.eob.enh;
                dhVar3 = this.eob.emx;
                exVar.j(dhVar3.getPbData());
            }
            this.eob.showToast(t.j.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cq.a
    public void onError(int i, String str) {
        this.eob.showToast(t.j.operation_failed);
    }
}
