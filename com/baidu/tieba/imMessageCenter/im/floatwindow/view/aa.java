package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ z bIB;
    private final /* synthetic */ LinkedList bpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.bIB = zVar;
        this.bpR = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Tk().k(this.bpR);
    }
}
