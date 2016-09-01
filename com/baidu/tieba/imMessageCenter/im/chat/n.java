package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ LinkedList cVA;
    final /* synthetic */ m dnf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.dnf = mVar;
        this.cVA = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.asu().k(this.cVA);
    }
}
