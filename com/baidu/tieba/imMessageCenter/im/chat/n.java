package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ m bGt;
    private final /* synthetic */ LinkedList bqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.bGt = mVar;
        this.bqp = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Gr */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Tm().k(this.bqp);
    }
}
