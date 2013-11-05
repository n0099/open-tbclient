package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.view.az {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.f2069a = newPbActivity;
    }

    @Override // com.baidu.tieba.view.az
    public void a(boolean z) {
        boolean z2;
        com.baidu.tieba.model.bl blVar;
        com.baidu.tieba.model.bl blVar2;
        bt btVar;
        z2 = this.f2069a.c;
        if (!z2 && z) {
            blVar = this.f2069a.o;
            if (!blVar.i()) {
                blVar2 = this.f2069a.o;
                if (blVar2.n()) {
                    btVar = this.f2069a.u;
                    btVar.x();
                }
            }
        }
    }
}
