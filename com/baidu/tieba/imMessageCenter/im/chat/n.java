package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ LinkedList cWX;
    final /* synthetic */ m doD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.doD = mVar;
        this.cWX = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Mt */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.asT().k(this.cWX);
    }
}
