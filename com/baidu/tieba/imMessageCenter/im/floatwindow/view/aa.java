package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList cHg;
    final /* synthetic */ z dbq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.dbq = zVar;
        this.cHg = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.amU().k(this.cHg);
    }
}
