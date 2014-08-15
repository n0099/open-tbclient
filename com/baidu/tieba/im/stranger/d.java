package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.a = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void a() {
        i iVar;
        i iVar2;
        h hVar;
        h hVar2;
        i iVar3;
        h hVar3;
        iVar = this.a.b;
        if (iVar != null) {
            iVar2 = this.a.b;
            if (iVar2.a() != null) {
                hVar = this.a.c;
                if (hVar != null) {
                    hVar2 = this.a.c;
                    if (hVar2.a().size() == 0) {
                        this.a.finish();
                    }
                    iVar3 = this.a.b;
                    f a = iVar3.a();
                    hVar3 = this.a.c;
                    a.a(hVar3.a());
                }
            }
        }
    }
}
