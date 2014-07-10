package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ o a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.tieba.im.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, String str, com.baidu.tieba.im.a aVar) {
        this.a = oVar;
        this.b = str;
        this.c = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.i().d(this.b);
        com.baidu.tieba.im.pushNotify.a.i().b(false, this.c);
    }
}
