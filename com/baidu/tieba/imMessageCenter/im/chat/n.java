package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList cOM;
    final /* synthetic */ m dgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.dgv = mVar;
        this.cOM = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Li */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.aqw().k(this.cOM);
    }
}
