package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ m bJJ;
    private final /* synthetic */ LinkedList btB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.bJJ = mVar;
        this.btB = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gl */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.TU().k(this.btB);
    }
}
