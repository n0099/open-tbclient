package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ i bNZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, com.baidu.tbadk.editortool.v vVar) {
        this.bNZ = iVar;
        this.aIJ = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aIJ.handleAction(26, obj);
        } else if (i == 10) {
            this.aIJ.handleAction(27, obj);
        } else if (i == 33) {
            this.bNZ.aIG.amf();
            this.aIJ.handleAction(33, obj);
        } else if (i != 34) {
            this.aIJ.handleAction(i, obj);
        }
    }
}
