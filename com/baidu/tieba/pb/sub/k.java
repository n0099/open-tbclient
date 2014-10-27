package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class k implements w {
    private final /* synthetic */ w arn;
    final /* synthetic */ i bAp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, w wVar) {
        this.bAp = iVar;
        this.arn = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.arn.handleAction(26, obj);
        } else if (i == 10) {
            this.arn.handleAction(27, obj);
        } else if (i == 33) {
            this.bAp.azA.Ca();
            this.arn.handleAction(33, obj);
        } else if (i == 34) {
            this.bAp.bAw.setEnabled(true);
        } else {
            this.arn.handleAction(i, obj);
        }
    }
}
