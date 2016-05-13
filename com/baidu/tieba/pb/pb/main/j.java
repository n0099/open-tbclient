package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.cj;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class j implements cj.a {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.cj.a
    public void i(int i, long j) {
        cw cwVar;
        cw cwVar2;
        el elVar;
        cw cwVar3;
        if (i == 0) {
            ee.ayD().reset();
            cwVar = this.djE.dih;
            cwVar.axT();
            cwVar2 = this.djE.dih;
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = cwVar2.getPbData().avF();
            if (avF != null) {
                Iterator<com.baidu.tieba.tbadkCore.data.s> it = avF.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.s next = it.next();
                    if (ek.g(next) && next.aUi().getTemplateId() == j) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    elVar = this.djE.diR;
                    cwVar3 = this.djE.dih;
                    elVar.j(cwVar3.getPbData());
                }
                this.djE.showToast(t.j.operation_success);
                return;
            }
            return;
        }
        this.djE.showToast(t.j.operation_failed);
    }

    @Override // com.baidu.tieba.pb.pb.main.cj.a
    public void onError(int i, String str) {
        this.djE.showToast(t.j.operation_failed);
    }
}
