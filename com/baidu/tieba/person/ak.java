package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ak implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ ai a;

    private ak(ai aiVar) {
        this.a = aiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ai aiVar, ak akVar) {
        this(aiVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.w() == -124) {
            ai.a(this.a, sVar);
        }
    }
}
