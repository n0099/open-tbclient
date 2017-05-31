package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.util.v;
import java.util.LinkedList;
/* loaded from: classes2.dex */
class n extends v<Void> {
    private final /* synthetic */ LinkedList cRr;
    final /* synthetic */ m dja;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.dja = mVar;
        this.cRr = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: KF */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.m.aoD().n(this.cRr);
    }
}
