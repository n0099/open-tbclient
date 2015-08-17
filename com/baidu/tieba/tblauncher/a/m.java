package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements LeftNaviScanMessage.b {
    final /* synthetic */ d cNj;
    private final /* synthetic */ int cNk;
    private final /* synthetic */ int cNl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar, int i, int i2) {
        this.cNj = dVar;
        this.cNk = i;
        this.cNl = i2;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void k(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        int size = list.size();
        a aVar = null;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (list.get(i) instanceof a) {
                aVar = (a) list.get(i);
                if (aVar.getType() == this.cNk) {
                    aVar.jZ(this.cNl);
                    break;
                }
            }
            i++;
        }
        dVar = this.cNj.cNe;
        if (dVar != null && aVar != null) {
            dVar2 = this.cNj.cNe;
            dVar2.z(aVar);
        }
    }
}
