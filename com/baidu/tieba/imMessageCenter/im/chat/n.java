package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList bbW;
    final /* synthetic */ m brY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.brY = mVar;
        this.bbW = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.RC().j(this.bbW);
    }
}
