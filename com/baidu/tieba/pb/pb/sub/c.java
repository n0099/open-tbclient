package com.baidu.tieba.pb.pb.sub;

import com.baidu.tieba.tbadkCore.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.g {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        w wVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        w wVar2;
        if (obj != null) {
            aVar2 = this.cTK.cTA;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    this.cTK.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    wVar2 = this.cTK.cTB;
                    wVar2.a(1, dVar.AD, dVar.dZa, true);
                    return;
                default:
                    return;
            }
        }
        wVar = this.cTK.cTB;
        aVar = this.cTK.cTA;
        wVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
