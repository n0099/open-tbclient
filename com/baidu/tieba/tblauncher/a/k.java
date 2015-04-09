package com.baidu.tieba.tblauncher.a;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.message.b {
    final /* synthetic */ d cst;
    private final /* synthetic */ int csu;
    private final /* synthetic */ int csv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, int i, int i2) {
        this.cst = dVar;
        this.csu = i;
        this.csv = i2;
    }

    @Override // com.baidu.tbadk.core.message.b
    public void j(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.j.d dVar;
        com.baidu.tbadk.mvc.j.d dVar2;
        int size = list.size();
        a aVar = null;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (list.get(i) instanceof a) {
                aVar = (a) list.get(i);
                if (aVar.getType() == this.csu) {
                    aVar.iJ(this.csv);
                    break;
                }
            }
            i++;
        }
        dVar = this.cst.csq;
        if (dVar != null && aVar != null) {
            dVar2 = this.cst.csq;
            dVar2.y(aVar);
        }
    }
}
