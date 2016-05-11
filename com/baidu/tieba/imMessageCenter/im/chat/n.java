package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList cbK;
    final /* synthetic */ m ctk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.ctk = mVar;
        this.cbK = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Io */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.aeD().k(this.cbK);
    }
}
