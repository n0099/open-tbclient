package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class k implements w {
    private final /* synthetic */ w aBH;
    final /* synthetic */ i bEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, w wVar) {
        this.bEq = iVar;
        this.aBH = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aBH.handleAction(26, obj);
        } else if (i == 10) {
            this.aBH.handleAction(27, obj);
        } else if (i == 33) {
            this.bEq.aBE.afE();
            this.aBH.handleAction(33, obj);
        } else if (i == 34) {
            this.bEq.bEx.setEnabled(true);
        } else {
            this.aBH.handleAction(i, obj);
        }
    }
}
