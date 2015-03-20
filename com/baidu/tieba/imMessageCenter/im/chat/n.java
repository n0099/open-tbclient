package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aYY;
    final /* synthetic */ m bpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.bpb = mVar;
        this.aYY = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.PZ().j(this.aYY);
    }
}
