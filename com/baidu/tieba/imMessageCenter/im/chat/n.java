package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList cHg;
    final /* synthetic */ m cYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.cYA = mVar;
        this.cHg = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.amU().k(this.cHg);
    }
}
