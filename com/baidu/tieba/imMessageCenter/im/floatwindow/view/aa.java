package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList cbK;
    final /* synthetic */ z cwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.cwa = zVar;
        this.cbK = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Iq */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.aeF().k(this.cbK);
    }
}
