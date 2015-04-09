package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ l bOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar, com.baidu.tbadk.editortool.v vVar) {
        this.bOv = lVar;
        this.aIJ = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aIJ.handleAction(26, obj);
        } else if (i == 10) {
            this.aIJ.handleAction(27, obj);
        } else if (i != 34 && i != 33) {
            this.aIJ.handleAction(i, obj);
        }
    }
}
