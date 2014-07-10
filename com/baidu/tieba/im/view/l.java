package com.baidu.tieba.im.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.coreExtra.c.c {
    final /* synthetic */ NumCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(NumCountDownView numCountDownView, long j, long j2) {
        super(j, j2);
        this.a = numCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void a(long j) {
        this.a.a(j);
    }

    @Override // com.baidu.tbadk.coreExtra.c.c
    public void c() {
        m mVar;
        m mVar2;
        mVar = this.a.g;
        if (mVar != null) {
            mVar2 = this.a.g;
            mVar2.a();
        }
    }
}
