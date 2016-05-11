package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        y yVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        y yVar2;
        if (obj != null) {
            aVar2 = this.dqn.dqd;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.dqn.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    yVar2 = this.dqn.dqe;
                    yVar2.a(1, dVar.rg, dVar.evb, true);
                    return;
                default:
                    return;
            }
        }
        yVar = this.dqn.dqe;
        aVar = this.dqn.dqd;
        yVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
