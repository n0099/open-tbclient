package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ cm a;

    private cw(cm cmVar) {
        this.a = cmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cw(cm cmVar, cw cwVar) {
        this(cmVar);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || sVar.w() != -124) {
            return;
        }
        this.a.b(sVar);
    }
}
