package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cr;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class m implements cr.a {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cr.a
    public void j(int i, long j) {
        dj djVar;
        dj djVar2;
        ey eyVar;
        dj djVar3;
        if (i != 0) {
            this.evL.showToast(r.j.operation_failed);
            return;
        }
        this.evL.ox(2);
        eq.aRA().reset();
        djVar = this.evL.euf;
        djVar.aQF();
        djVar2 = this.evL.euf;
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = djVar2.getPbData().aOm();
        if (aOm != null) {
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = aOm.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.q next = it.next();
                if (ex.h(next) && next.bmt().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                eyVar = this.evL.euP;
                djVar3 = this.evL.euf;
                eyVar.j(djVar3.getPbData());
            }
            this.evL.showToast(r.j.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cr.a
    public void onError(int i, String str) {
        this.evL.showToast(r.j.operation_failed);
    }
}
