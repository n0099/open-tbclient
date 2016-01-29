package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ LinkedList bQM;
    final /* synthetic */ z ckx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.ckx = zVar;
        this.bQM = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.abi().l(this.bQM);
    }
}
