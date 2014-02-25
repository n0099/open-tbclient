package com.baidu.tieba.mention;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ c a;

    private g(c cVar) {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(c cVar, g gVar) {
        this(cVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.w() == -124) {
            c.a(this.a, sVar);
        }
    }
}
