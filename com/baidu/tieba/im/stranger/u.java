package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ o a;
    private final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar, l lVar) {
        this.a = oVar;
        this.b = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.i().w();
        com.baidu.tieba.im.pushNotify.a.i().b(false, (com.baidu.tieba.im.a<Void>) null);
        if (this.b != null) {
            this.b.a();
        }
    }
}
