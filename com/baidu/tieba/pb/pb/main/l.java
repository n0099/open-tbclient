package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cy;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements cy.a {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cy.a
    public void j(int i, long j) {
        PbModel pbModel;
        PbModel pbModel2;
        ez ezVar;
        PbModel pbModel3;
        if (i != 0) {
            this.eiV.showToast(r.l.operation_failed);
            return;
        }
        this.eiV.or(2);
        eq.aNi().reset();
        pbModel = this.eiV.ehh;
        pbModel.aMp();
        pbModel2 = this.eiV.ehh;
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = pbModel2.getPbData().aKb();
        if (aKb != null) {
            Iterator<com.baidu.tieba.tbadkCore.data.p> it = aKb.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.data.p next = it.next();
                if (ey.g(next) && next.bhY().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                ezVar = this.eiV.ehV;
                pbModel3 = this.eiV.ehh;
                ezVar.j(pbModel3.getPbData());
            }
            this.eiV.showToast(r.l.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cy.a
    public void onError(int i, String str) {
        this.eiV.showToast(r.l.operation_failed);
    }
}
