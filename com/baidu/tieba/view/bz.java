package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends com.baidu.tieba.util.bt {
    final /* synthetic */ NumCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(NumCountDownView numCountDownView, long j, long j2) {
        super(j, j2);
        this.a = numCountDownView;
    }

    @Override // com.baidu.tieba.util.bt
    public void a(long j) {
        this.a.a(j);
    }

    @Override // com.baidu.tieba.util.bt
    public void a() {
        ca caVar;
        ca caVar2;
        caVar = this.a.g;
        if (caVar != null) {
            caVar2 = this.a.g;
            caVar2.a();
        }
    }
}
