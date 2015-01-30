package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class k implements w {
    private final /* synthetic */ w aCI;
    final /* synthetic */ i bGb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, w wVar) {
        this.bGb = iVar;
        this.aCI = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aCI.handleAction(26, obj);
        } else if (i == 10) {
            this.aCI.handleAction(27, obj);
        } else if (i == 33) {
            this.bGb.aCF.agi();
            this.aCI.handleAction(33, obj);
        } else if (i == 34) {
            this.bGb.bGi.setEnabled(true);
        } else {
            this.aCI.handleAction(i, obj);
        }
    }
}
