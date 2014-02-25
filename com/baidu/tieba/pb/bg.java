package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bg implements com.baidu.tieba.view.by {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.by
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        cu cuVar;
        z2 = this.a.d;
        if (!z2 && z) {
            bbVar = this.a.w;
            if (!bbVar.k()) {
                bbVar2 = this.a.w;
                if (bbVar2.p()) {
                    cuVar = this.a.C;
                    cuVar.q();
                }
            }
        }
    }
}
