package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ z bMT;
    private final /* synthetic */ LinkedList bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.bMT = zVar;
        this.bub = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Ge */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Ul().k(this.bub);
    }
}
