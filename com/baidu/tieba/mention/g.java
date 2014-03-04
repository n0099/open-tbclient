package com.baidu.tieba.mention;
/* loaded from: classes.dex */
final class g implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ c a;

    private g(c cVar) {
        this.a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(c cVar, byte b) {
        this(cVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.v() == -124) {
            c.a(this.a, sVar);
        }
    }
}
