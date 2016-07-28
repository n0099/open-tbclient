package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ LinkedList cJV;
    final /* synthetic */ m dbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.dbx = mVar;
        this.cJV = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Jn */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.anF().k(this.cJV);
    }
}
