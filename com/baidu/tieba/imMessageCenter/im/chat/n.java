package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.util.v;
import java.util.LinkedList;
/* loaded from: classes2.dex */
class n extends v<Void> {
    private final /* synthetic */ LinkedList cLT;
    final /* synthetic */ m ddF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.ddF = mVar;
        this.cLT = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: LK */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.m.anD().k(this.cLT);
    }
}
