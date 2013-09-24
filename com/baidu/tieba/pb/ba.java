package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ba implements com.baidu.tieba.view.az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(NewPbActivity newPbActivity) {
        this.f1547a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bd bdVar;
        com.baidu.tieba.model.bd bdVar2;
        br brVar;
        z2 = this.f1547a.c;
        if (!z2 && z) {
            bdVar = this.f1547a.n;
            if (!bdVar.i()) {
                bdVar2 = this.f1547a.n;
                if (bdVar2.n()) {
                    brVar = this.f1547a.t;
                    brVar.x();
                }
            }
        }
    }
}
