package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bq implements cm {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(NewPbActivity newPbActivity) {
        this.f2084a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cm
    public void a(String str) {
        cr crVar;
        cr crVar2;
        if (!com.baidu.tieba.util.be.c(str)) {
            crVar = this.f2084a.y;
            if (com.baidu.tieba.util.be.c(crVar.J())) {
                crVar2 = this.f2084a.y;
                crVar2.d(str);
            }
        }
    }
}
