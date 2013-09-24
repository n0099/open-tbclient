package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class av implements cz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewPbActivity newPbActivity) {
        this.f1541a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cz
    public void a(com.baidu.tieba.data.bd bdVar) {
        com.baidu.tieba.model.bg bgVar;
        com.baidu.tieba.model.bg bgVar2;
        br brVar;
        bgVar = this.f1541a.r;
        if (bgVar != null) {
            bgVar2 = this.f1541a.r;
            if (bgVar2.e()) {
                brVar = this.f1541a.t;
                brVar.D();
            }
        }
    }
}
