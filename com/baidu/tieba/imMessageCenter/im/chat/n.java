package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList cRd;
    final /* synthetic */ m diN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.diN = mVar;
        this.cRd = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: LT */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.apQ().k(this.cRd);
    }
}
