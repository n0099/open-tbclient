package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ LinkedList bJg;
    final /* synthetic */ z cbX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.cbX = zVar;
        this.bJg = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Xr().l(this.bJg);
    }
}
