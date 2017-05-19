package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.da;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class m implements da.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.da.a
    public void i(int i, long j) {
        PbModel pbModel;
        PbModel pbModel2;
        fm fmVar;
        PbModel pbModel3;
        if (i != 0) {
            this.ehy.showToast(w.l.operation_failed);
            return;
        }
        this.ehy.nZ(2);
        ex.aLb().reset();
        pbModel = this.ehy.efE;
        pbModel.aKk();
        pbModel2 = this.ehy.efE;
        ArrayList<PostData> aHI = pbModel2.getPbData().aHI();
        if (aHI != null) {
            Iterator<PostData> it = aHI.iterator();
            boolean z = false;
            while (it.hasNext()) {
                PostData next = it.next();
                if (fl.h(next) && next.bgU().getTemplateId() == j) {
                    it.remove();
                    z = true;
                }
            }
            if (z) {
                fmVar = this.ehy.egt;
                pbModel3 = this.ehy.efE;
                fmVar.l(pbModel3.getPbData());
            }
            this.ehy.showToast(w.l.operation_success);
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.da.a
    public void onError(int i, String str) {
        this.ehy.showToast(w.l.operation_failed);
    }
}
