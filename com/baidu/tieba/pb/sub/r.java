package com.baidu.tieba.pb.sub;

import com.baidu.tbadk.editortool.w;
/* loaded from: classes.dex */
class r implements w {
    private final /* synthetic */ w aBH;
    final /* synthetic */ l bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, w wVar) {
        this.bEM = lVar;
        this.aBH = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aBH.handleAction(26, obj);
        } else if (i == 10) {
            this.aBH.handleAction(27, obj);
        } else if (i == 34) {
            this.bEM.bEx.setEnabled(true);
        } else if (i == 33) {
            this.bEM.bEx.setEnabled(false);
        } else {
            this.aBH.handleAction(i, obj);
        }
    }
}
