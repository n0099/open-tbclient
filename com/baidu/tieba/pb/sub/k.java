package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class k implements w {
    private final /* synthetic */ w aCF;
    final /* synthetic */ i bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, w wVar) {
        this.bGa = iVar;
        this.aCF = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aCF.handleAction(26, obj);
        } else if (i == 10) {
            this.aCF.handleAction(27, obj);
        } else if (i == 33) {
            this.bGa.aCC.agd();
            this.aCF.handleAction(33, obj);
        } else if (i == 34) {
            this.bGa.bGh.setEnabled(true);
        } else {
            this.aCF.handleAction(i, obj);
        }
    }
}
