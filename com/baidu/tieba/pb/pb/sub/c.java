package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        x xVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        x xVar2;
        if (obj != null) {
            aVar2 = this.doF.dov;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.doF.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    xVar2 = this.doF.dow;
                    xVar2.a(1, dVar.AU, dVar.erS, true);
                    return;
                default:
                    return;
            }
        }
        xVar = this.doF.dow;
        aVar = this.doF.dov;
        xVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
