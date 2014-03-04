package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class ak implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ai a;

    private ak(ai aiVar) {
        this.a = aiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ai aiVar, byte b) {
        this(aiVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.v() == -124) {
            ai.a(this.a, sVar);
        }
    }
}
