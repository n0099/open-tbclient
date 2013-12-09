package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bq implements cm {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(NewPbActivity newPbActivity) {
        this.f2192a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cm
    public void a(String str) {
        cr crVar;
        cr crVar2;
        if (!com.baidu.tieba.util.bb.c(str)) {
            crVar = this.f2192a.y;
            if (com.baidu.tieba.util.bb.c(crVar.J())) {
                crVar2 = this.f2192a.y;
                crVar2.d(str);
            }
        }
    }
}
