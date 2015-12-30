package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cf;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class br implements cf.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cf.b
    public void g(int i, long j) {
        cf cfVar;
        cf cfVar2;
        dk dkVar;
        cf cfVar3;
        if (i == 0) {
            dd.amq().reset();
            cfVar = this.cFS.cFl;
            cfVar.amc();
            cfVar2 = this.cFS.cFl;
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = cfVar2.getPbData().akI();
            if (akI != null) {
                Iterator<com.baidu.tieba.tbadkCore.data.r> it = akI.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.r next = it.next();
                    if (dj.e(next) && next.aFA().getTemplateId() == j) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    dkVar = this.cFS.cFq;
                    cfVar3 = this.cFS.cFl;
                    dkVar.i(cfVar3.getPbData());
                }
                this.cFS.showToast(n.j.operation_success);
                return;
            }
            return;
        }
        this.cFS.showToast(n.j.operation_failed);
    }

    @Override // com.baidu.tieba.pb.pb.main.cf.b
    public void onError(int i, String str) {
        this.cFS.showToast(n.j.operation_failed);
    }
}
