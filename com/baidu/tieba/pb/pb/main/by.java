package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cm;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class by implements cm.b {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.b
    public void h(int i, long j) {
        cm cmVar;
        cm cmVar2;
        dz dzVar;
        cm cmVar3;
        if (i == 0) {
            ds.aqK().reset();
            cmVar = this.cNq.cMF;
            cmVar.aqg();
            cmVar2 = this.cNq.cMF;
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = cmVar2.getPbData().aoG();
            if (aoG != null) {
                Iterator<com.baidu.tieba.tbadkCore.data.r> it = aoG.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.r next = it.next();
                    if (dy.g(next) && next.aMF().getTemplateId() == j) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    dzVar = this.cNq.cMK;
                    cmVar3 = this.cNq.cMF;
                    dzVar.j(cmVar3.getPbData());
                }
                this.cNq.showToast(t.j.operation_success);
                return;
            }
            return;
        }
        this.cNq.showToast(t.j.operation_failed);
    }

    @Override // com.baidu.tieba.pb.pb.main.cm.b
    public void onError(int i, String str) {
        this.cNq.showToast(t.j.operation_failed);
    }
}
