package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList cRR;
    final /* synthetic */ m djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.djD = mVar;
        this.cRR = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Mw */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.m.aqK().k(this.cRR);
    }
}
