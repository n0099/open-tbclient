package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ay implements com.baidu.tieba.view.ax {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1501a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewPbActivity newPbActivity) {
        this.f1501a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.ax
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        bo boVar;
        z2 = this.f1501a.c;
        if (!z2 && z) {
            bbVar = this.f1501a.k;
            if (!bbVar.i()) {
                bbVar2 = this.f1501a.k;
                if (bbVar2.n()) {
                    boVar = this.f1501a.q;
                    boVar.n();
                }
            }
        }
    }
}
