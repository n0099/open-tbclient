package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ m bFM;
    private final /* synthetic */ LinkedList bpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.bFM = mVar;
        this.bpR = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Tk().k(this.bpR);
    }
}
