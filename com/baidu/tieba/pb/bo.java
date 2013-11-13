package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class bo implements ck {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(NewPbActivity newPbActivity) {
        this.f2099a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.ck
    public void a(String str) {
        cp cpVar;
        cp cpVar2;
        if (!com.baidu.tieba.util.be.c(str)) {
            cpVar = this.f2099a.y;
            if (com.baidu.tieba.util.be.c(cpVar.J())) {
                cpVar2 = this.f2099a.y;
                cpVar2.d(str);
            }
        }
    }
}
