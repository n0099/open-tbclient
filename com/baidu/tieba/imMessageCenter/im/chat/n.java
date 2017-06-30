package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.util.w;
import java.util.LinkedList;
/* loaded from: classes2.dex */
class n extends w<Void> {
    private final /* synthetic */ LinkedList cZn;
    final /* synthetic */ m dqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.dqW = mVar;
        this.cZn = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: Ld */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.m.aso().o(this.cZn);
    }
}
