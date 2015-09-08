package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ z bJi;
    private final /* synthetic */ LinkedList bqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.bJi = zVar;
        this.bqp = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Gr */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Tm().k(this.bqp);
    }
}
