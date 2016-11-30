package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.s<Void> {
    private final /* synthetic */ LinkedList dcJ;
    final /* synthetic */ z dwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.dwZ = zVar;
        this.dcJ = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Nb */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.auQ().k(this.dcJ);
    }
}
