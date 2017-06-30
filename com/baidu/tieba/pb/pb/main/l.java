package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.dm;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class l implements dm.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.dm.a
    public void i(int i, long j) {
        PbModel pbModel;
        PbModel pbModel2;
        gg ggVar;
        PbModel pbModel3;
        if (i != 0) {
            this.ewh.showToast(w.l.operation_failed);
            return;
        }
        this.ewh.oI(2);
        fp.aPV().reset();
        pbModel = this.ewh.eue;
        pbModel.aPb();
        pbModel2 = this.ewh.eue;
        ArrayList<PostData> aMx = pbModel2.getPbData().aMx();
        if (aMx != null) {
            Iterator<PostData> it = aMx.iterator();
            boolean z = false;
            while (it.hasNext()) {
                PostData next = it.next();
                if (gf.k(next) && next.bmC().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                ggVar = this.ewh.euU;
                pbModel3 = this.ewh.eue;
                ggVar.l(pbModel3.getPbData());
            }
            this.ewh.showToast(w.l.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.dm.a
    public void onError(int i, String str) {
        this.ewh.showToast(w.l.operation_failed);
    }
}
