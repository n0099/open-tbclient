package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class r implements w {
    private final /* synthetic */ w aCI;
    final /* synthetic */ l bGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, w wVar) {
        this.bGx = lVar;
        this.aCI = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aCI.handleAction(26, obj);
        } else if (i == 10) {
            this.aCI.handleAction(27, obj);
        } else if (i == 34) {
            this.bGx.bGi.setEnabled(true);
        } else if (i == 33) {
            this.bGx.bGi.setEnabled(false);
        } else {
            this.aCI.handleAction(i, obj);
        }
    }
}
