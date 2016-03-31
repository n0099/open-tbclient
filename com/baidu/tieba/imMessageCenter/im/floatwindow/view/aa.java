package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.p<Void> {
    private final /* synthetic */ LinkedList cbf;
    final /* synthetic */ z cvd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.cvd = zVar;
        this.cbf = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.aeE().l(this.cbf);
    }
}
