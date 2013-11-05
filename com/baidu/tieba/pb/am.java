package com.baidu.tieba.pb;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.model.bh {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2049a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewPbActivity newPbActivity) {
        this.f2049a = newPbActivity;
    }

    @Override // com.baidu.tieba.model.bh
    public void a(boolean z, boolean z2, String str) {
        bt btVar;
        com.baidu.tieba.model.bf bfVar;
        com.baidu.tieba.model.bl blVar;
        com.baidu.tieba.model.bl blVar2;
        bt btVar2;
        com.baidu.tieba.model.bl blVar3;
        btVar = this.f2049a.u;
        btVar.A();
        if (z) {
            bfVar = this.f2049a.p;
            bfVar.a(z2);
            blVar = this.f2049a.o;
            blVar.c(z2);
            blVar2 = this.f2049a.o;
            if (blVar2.s()) {
                this.f2049a.u();
            } else {
                btVar2 = this.f2049a.u;
                blVar3 = this.f2049a.o;
                btVar2.a(blVar3.k());
            }
            if (z2) {
                this.f2049a.a(this.f2049a.getString(R.string.add_mark));
                return;
            } else {
                this.f2049a.a(this.f2049a.getString(R.string.remove_mark));
                return;
            }
        }
        this.f2049a.a(str);
    }
}
