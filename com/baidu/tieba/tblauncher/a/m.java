package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements LeftNaviScanMessage.b {
    final /* synthetic */ d cVQ;
    private final /* synthetic */ int cVR;
    private final /* synthetic */ int cVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar, int i, int i2) {
        this.cVQ = dVar;
        this.cVR = i;
        this.cVS = i2;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void l(List<com.baidu.tieba.tbadkCore.f.a> list) {
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
                if (aVar.getType() == this.cVR) {
                    aVar.kK(this.cVS);
                    break;
                }
            }
            i++;
        }
        dVar = this.cVQ.cVL;
        if (dVar != null && aVar != null) {
            dVar2 = this.cVQ.cVL;
            dVar2.A(aVar);
        }
    }
}
