package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class cw implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ cm a;

    private cw(cm cmVar) {
        this.a = cmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cw(cm cmVar, byte b) {
        this(cmVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && sVar.v() == -124) {
            cm.a(this.a, sVar);
        }
    }
}
