package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonThreadFragment f2265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonThreadFragment personThreadFragment) {
        this.f2265a = personThreadFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.f2265a.b;
        if (qVar != null) {
            qVar2 = this.f2265a.b;
            qVar2.a(true);
        }
    }
}
