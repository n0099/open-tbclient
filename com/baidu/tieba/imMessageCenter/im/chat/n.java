package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList bbV;
    final /* synthetic */ m brX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.brX = mVar;
        this.bbV = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.RB().j(this.bbV);
    }
}
