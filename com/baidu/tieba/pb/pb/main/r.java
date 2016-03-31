package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.df;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class r implements df.b {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.df.b
    public void i(int i, long j) {
        df dfVar;
        df dfVar2;
        eu euVar;
        df dfVar3;
        if (i == 0) {
            en.aya().reset();
            dfVar = this.dht.dfV;
            dfVar.axv();
            dfVar2 = this.dht.dfV;
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = dfVar2.getPbData().avw();
            if (avw != null) {
                Iterator<com.baidu.tieba.tbadkCore.data.s> it = avw.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.s next = it.next();
                    if (et.g(next) && next.aTC().getTemplateId() == j) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    euVar = this.dht.dgF;
                    dfVar3 = this.dht.dfV;
                    euVar.j(dfVar3.getPbData());
                }
                this.dht.showToast(t.j.operation_success);
                return;
            }
            return;
        }
        this.dht.showToast(t.j.operation_failed);
    }

    @Override // com.baidu.tieba.pb.pb.main.df.b
    public void onError(int i, String str) {
        this.dht.showToast(t.j.operation_failed);
    }
}
