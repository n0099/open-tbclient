package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements LeftNaviScanMessage.b {
    final /* synthetic */ e dcL;
    private final /* synthetic */ int dcM;
    private final /* synthetic */ int dcN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar, int i, int i2) {
        this.dcL = eVar;
        this.dcM = i;
        this.dcN = i2;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void l(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        int size = list.size();
        b bVar = null;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (list.get(i) instanceof b) {
                bVar = (b) list.get(i);
                if (bVar.getType() == this.dcM) {
                    bVar.lq(this.dcN);
                    break;
                }
            }
            i++;
        }
        dVar = this.dcL.dcG;
        if (dVar != null && bVar != null) {
            dVar2 = this.dcL.dcG;
            dVar2.A(bVar);
        }
    }
}
