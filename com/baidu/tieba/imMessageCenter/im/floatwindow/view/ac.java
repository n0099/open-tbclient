package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class ac extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ LinkedList aYY;
    final /* synthetic */ ab brI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, LinkedList linkedList) {
        this.brI = abVar;
        this.aYY = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.n.PZ().j(this.aYY);
    }
}
