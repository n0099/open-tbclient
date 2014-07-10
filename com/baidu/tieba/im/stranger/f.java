package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ StrangerListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(StrangerListActivity strangerListActivity) {
        this.a = strangerListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        v vVar;
        o oVar;
        o oVar2;
        v vVar2;
        o oVar3;
        this.a.closeLoadingDialog();
        vVar = this.a.b;
        if (vVar.a() != null) {
            oVar = this.a.c;
            if (oVar != null) {
                oVar2 = this.a.c;
                if (oVar2.b().size() == 0) {
                    this.a.finish();
                }
                vVar2 = this.a.b;
                m a = vVar2.a();
                oVar3 = this.a.c;
                a.a(oVar3.b());
            }
        }
    }
}
