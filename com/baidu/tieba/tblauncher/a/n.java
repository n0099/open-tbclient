package com.baidu.tieba.tblauncher.a;

import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements LeftNaviScanMessage.b {
    private final /* synthetic */ int ddA;
    final /* synthetic */ e ddy;
    private final /* synthetic */ int ddz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar, int i, int i2) {
        this.ddy = eVar;
        this.ddz = i;
        this.ddA = i2;
    }

    @Override // com.baidu.tieba.tblauncher.LeftNaviScanMessage.b
    public void bv(List<a> list) {
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
                if (bVar.getType() == this.ddz) {
                    bVar.ln(this.ddA);
                    break;
                }
            }
            i++;
        }
        dVar = this.ddy.ddt;
        if (dVar != null && bVar != null) {
            dVar2 = this.ddy.ddt;
            dVar2.A(bVar);
        }
    }
}
