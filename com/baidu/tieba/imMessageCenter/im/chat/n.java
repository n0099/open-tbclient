package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ LinkedList bQM;
    final /* synthetic */ m chI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.chI = mVar;
        this.bQM = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.abi().l(this.bQM);
    }
}
