package com.baidu.tieba.tblauncher.a;

import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements LeftNaviScanMessage.b {
    final /* synthetic */ e ddY;
    private final /* synthetic */ int ddZ;
    private final /* synthetic */ int dea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar, int i, int i2) {
        this.ddY = eVar;
        this.ddZ = i;
        this.dea = i2;
    }

    @Override // com.baidu.tieba.tblauncher.LeftNaviScanMessage.b
    public void bw(List<a> list) {
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
                if (bVar.getType() == this.ddZ) {
                    bVar.lp(this.dea);
                    break;
                }
            }
            i++;
        }
        dVar = this.ddY.ddT;
        if (dVar != null && bVar != null) {
            dVar2 = this.ddY.ddT;
            dVar2.A(bVar);
        }
    }
}
