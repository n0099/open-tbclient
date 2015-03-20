package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ i bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, com.baidu.tbadk.editortool.v vVar) {
        this.bNJ = iVar;
        this.aIB = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aIB.handleAction(26, obj);
        } else if (i == 10) {
            this.aIB.handleAction(27, obj);
        } else if (i == 33) {
            this.bNJ.aIy.alQ();
            this.aIB.handleAction(33, obj);
        } else if (i != 34) {
            this.aIB.handleAction(i, obj);
        }
    }
}
