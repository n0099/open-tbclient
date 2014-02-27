package com.baidu.tieba.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cd extends com.baidu.tieba.util.bt {
    final /* synthetic */ ProgressCountDownView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(ProgressCountDownView progressCountDownView, long j, long j2) {
        super(j, j2);
        this.a = progressCountDownView;
    }

    @Override // com.baidu.tieba.util.bt
    public final void a(long j) {
        ProgressCountDownView.a(this.a, j);
        ProgressCountDownView.b(this.a, j);
    }

    @Override // com.baidu.tieba.util.bt
    public final void a() {
        ce ceVar;
        ce ceVar2;
        ceVar = this.a.g;
        if (ceVar != null) {
            ceVar2 = this.a.g;
            ceVar2.a();
        }
    }
}
