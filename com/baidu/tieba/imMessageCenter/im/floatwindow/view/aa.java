package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ z bMy;
    private final /* synthetic */ LinkedList btB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.bMy = zVar;
        this.btB = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gh */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.TQ().k(this.btB);
    }
}
