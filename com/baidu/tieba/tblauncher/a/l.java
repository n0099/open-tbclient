package com.baidu.tieba.tblauncher.a;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.message.b {
    final /* synthetic */ d cst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.cst = dVar;
    }

    @Override // com.baidu.tbadk.core.message.b
    public void j(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.j.d dVar;
        com.baidu.tbadk.mvc.j.d dVar2;
        int size = list.size();
        a aVar = null;
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof a) {
                aVar = (a) list.get(i);
                if (aVar.getType() == 0) {
                    break;
                }
            }
        }
        dVar = this.cst.csq;
        if (dVar != null && aVar != null) {
            dVar2 = this.cst.csq;
            this.cst.mView = ((b) dVar2.z(aVar)).aoI();
        }
    }
}
