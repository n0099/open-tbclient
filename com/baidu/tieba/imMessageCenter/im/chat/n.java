package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ m bKe;
    private final /* synthetic */ LinkedList bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.bKe = mVar;
        this.bub = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Ge */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Ul().k(this.bub);
    }
}
