package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.p<Void> {
    private final /* synthetic */ LinkedList cbf;
    final /* synthetic */ m csn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.csn = mVar;
        this.cbf = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.aeE().l(this.cbf);
    }
}
