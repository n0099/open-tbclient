package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class r implements w {
    private final /* synthetic */ w arn;
    final /* synthetic */ l bAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, w wVar) {
        this.bAL = lVar;
        this.arn = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.arn.handleAction(26, obj);
        } else if (i == 10) {
            this.arn.handleAction(27, obj);
        } else if (i == 34) {
            this.bAL.bAw.setEnabled(true);
        } else if (i == 33) {
            this.bAL.bAw.setEnabled(false);
        } else {
            this.arn.handleAction(i, obj);
        }
    }
}
