package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cv;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements cv.a {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cv.a
    public void i(int i, long j) {
        PbModel pbModel;
        PbModel pbModel2;
        ey eyVar;
        PbModel pbModel3;
        if (i != 0) {
            this.ejU.showToast(w.l.operation_failed);
            return;
        }
        this.ejU.od(2);
        ep.aMK().reset();
        pbModel = this.ejU.eif;
        pbModel.aLU();
        pbModel2 = this.ejU.eif;
        ArrayList<PostData> aJz = pbModel2.getPbData().aJz();
        if (aJz != null) {
            Iterator<PostData> it = aJz.iterator();
            boolean z = false;
            while (it.hasNext()) {
                PostData next = it.next();
                if (ex.g(next) && next.biw().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                eyVar = this.ejU.eiS;
                pbModel3 = this.ejU.eif;
                eyVar.k(pbModel3.getPbData());
            }
            this.ejU.showToast(w.l.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.cv.a
    public void onError(int i, String str) {
        this.ejU.showToast(w.l.operation_failed);
    }
}
