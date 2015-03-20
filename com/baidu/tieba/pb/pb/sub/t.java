package com.baidu.tieba.pb.pb.sub;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ l bOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar, com.baidu.tbadk.editortool.v vVar) {
        this.bOf = lVar;
        this.aIB = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 0) {
            this.aIB.handleAction(26, obj);
        } else if (i == 10) {
            this.aIB.handleAction(27, obj);
        } else if (i != 34 && i != 33) {
            this.aIB.handleAction(i, obj);
        }
    }
}
