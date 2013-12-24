package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ PersonThreadFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonThreadFragment personThreadFragment) {
        this.a = personThreadFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.a.b;
        if (qVar != null) {
            qVar2 = this.a.b;
            qVar2.a(true);
        }
    }
}
