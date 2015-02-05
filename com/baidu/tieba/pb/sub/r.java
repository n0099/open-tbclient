package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class r implements w {
    private final /* synthetic */ w aCF;
    final /* synthetic */ l bGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, w wVar) {
        this.bGw = lVar;
        this.aCF = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aCF.handleAction(26, obj);
        } else if (i == 10) {
            this.aCF.handleAction(27, obj);
        } else if (i == 34) {
            this.bGw.bGh.setEnabled(true);
        } else if (i == 33) {
            this.bGw.bGh.setEnabled(false);
        } else {
            this.aCF.handleAction(i, obj);
        }
    }
}
