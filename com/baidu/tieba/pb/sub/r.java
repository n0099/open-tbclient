package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements w {
    private final /* synthetic */ w arw;
    final /* synthetic */ l bAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, w wVar) {
        this.bAZ = lVar;
        this.arw = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.arw.handleAction(26, obj);
        } else if (i == 10) {
            this.arw.handleAction(27, obj);
        } else if (i == 34) {
            this.bAZ.bAK.setEnabled(true);
        } else if (i == 33) {
            this.bAZ.bAK.setEnabled(false);
        } else {
            this.arw.handleAction(i, obj);
        }
    }
}
