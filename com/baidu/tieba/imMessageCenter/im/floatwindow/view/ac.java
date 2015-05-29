package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class ac extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList bbV;
    final /* synthetic */ ab buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, LinkedList linkedList) {
        this.buK = abVar;
        this.bbV = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.RB().j(this.bbV);
    }
}
