package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends com.baidu.tieba.util.bv {
    final /* synthetic */ ProgressCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.a = progressCountDownView;
    }

    @Override // com.baidu.tieba.util.bv
    public void a(long j) {
        this.a.a(j);
        this.a.b(j);
    }

    @Override // com.baidu.tieba.util.bv
    public void a() {
        bx bxVar;
        bx bxVar2;
        bxVar = this.a.g;
        if (bxVar != null) {
            bxVar2 = this.a.g;
            bxVar2.a();
        }
    }
}
