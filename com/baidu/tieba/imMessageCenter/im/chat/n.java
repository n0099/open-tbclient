package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ m bJy;
    private final /* synthetic */ LinkedList btq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.bJy = mVar;
        this.btq = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gl */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.TU().k(this.btq);
    }
}
