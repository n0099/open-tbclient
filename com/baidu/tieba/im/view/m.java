package com.baidu.tieba.im.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.coreExtra.c.c {
    final /* synthetic */ NumCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(NumCountDownView numCountDownView, long j, long j2) {
        super(j, j2);
        this.a = numCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void a(long j) {
        this.a.a(j);
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
        n nVar;
        n nVar2;
        nVar = this.a.g;
        if (nVar != null) {
            nVar2 = this.a.g;
            nVar2.a();
        }
    }
}
