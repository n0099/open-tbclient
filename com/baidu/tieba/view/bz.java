package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bz extends com.baidu.tieba.util.bt {
    final /* synthetic */ NumCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(NumCountDownView numCountDownView, long j, long j2) {
        super(j, j2);
        this.a = numCountDownView;
    }

    @Override // com.baidu.tieba.util.bt
    public final void a(long j) {
        NumCountDownView.a(this.a, j);
    }

    @Override // com.baidu.tieba.util.bt
    public final void a() {
        ca caVar;
        ca unused;
        caVar = this.a.g;
        if (caVar != null) {
            unused = this.a.g;
        }
    }
}
