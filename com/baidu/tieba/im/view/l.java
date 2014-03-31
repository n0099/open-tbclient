package com.baidu.tieba.im.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends com.baidu.tbadk.coreExtra.c.b {
    final /* synthetic */ NumCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(NumCountDownView numCountDownView, long j, long j2) {
        super(j, j2);
        this.a = numCountDownView;
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void a(long j) {
        NumCountDownView.a(this.a, j);
    }

    @Override // com.baidu.tbadk.coreExtra.c.b
    public final void c() {
        m mVar;
        m unused;
        mVar = this.a.g;
        if (mVar != null) {
            unused = this.a.g;
        }
    }
}
