package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.tieba.util.bv {
    final /* synthetic */ NumCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(NumCountDownView numCountDownView, long j, long j2) {
        super(j, j2);
        this.a = numCountDownView;
    }

    @Override // com.baidu.tieba.util.bv
    public void a(long j) {
        this.a.a(j);
    }

    @Override // com.baidu.tieba.util.bv
    public void a() {
        bt btVar;
        bt btVar2;
        btVar = this.a.g;
        if (btVar != null) {
            btVar2 = this.a.g;
            btVar2.a();
        }
    }
}
