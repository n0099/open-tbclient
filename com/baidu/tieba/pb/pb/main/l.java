package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cx;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements cx.a {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cx.a
    public void j(int i, long j) {
        PbModel pbModel;
        PbModel pbModel2;
        fa faVar;
        PbModel pbModel3;
        if (i != 0) {
            this.elO.showToast(w.l.operation_failed);
            return;
        }
        this.elO.of(2);
        er.aMB().reset();
        pbModel = this.elO.ejZ;
        pbModel.aLL();
        pbModel2 = this.elO.ejZ;
        ArrayList<PostData> aJs = pbModel2.getPbData().aJs();
        if (aJs != null) {
            Iterator<PostData> it = aJs.iterator();
            boolean z = false;
            while (it.hasNext()) {
                PostData next = it.next();
                if (ez.g(next) && next.bhL().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                faVar = this.elO.ekM;
                pbModel3 = this.elO.ejZ;
                faVar.k(pbModel3.getPbData());
            }
            this.elO.showToast(w.l.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cx.a
    public void onError(int i, String str) {
        this.elO.showToast(w.l.operation_failed);
    }
}
