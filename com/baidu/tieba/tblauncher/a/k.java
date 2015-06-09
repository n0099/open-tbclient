package com.baidu.tieba.tblauncher.a;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.message.b {
    final /* synthetic */ d cwE;
    private final /* synthetic */ int cwF;
    private final /* synthetic */ int cwG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, int i, int i2) {
        this.cwE = dVar;
        this.cwF = i;
        this.cwG = i2;
    }

    @Override // com.baidu.tbadk.core.message.b
    public void k(List<com.baidu.tieba.tbadkCore.f.a> list) {
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
                if (aVar.getType() == this.cwF) {
                    aVar.jf(this.cwG);
                    break;
                }
            }
            i++;
        }
        dVar = this.cwE.cwB;
        if (dVar != null && aVar != null) {
            dVar2 = this.cwE.cwB;
            dVar2.y(aVar);
        }
    }
}
