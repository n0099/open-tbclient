package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class k implements w {
    private final /* synthetic */ w arw;
    final /* synthetic */ i bAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, w wVar) {
        this.bAD = iVar;
        this.arw = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.arw.handleAction(26, obj);
        } else if (i == 10) {
            this.arw.handleAction(27, obj);
        } else if (i == 33) {
            this.bAD.azJ.Cc();
            this.arw.handleAction(33, obj);
        } else if (i == 34) {
            this.bAD.bAK.setEnabled(true);
        } else {
            this.arw.handleAction(i, obj);
        }
    }
}
