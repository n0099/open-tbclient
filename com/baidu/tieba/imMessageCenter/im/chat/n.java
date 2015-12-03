package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ LinkedList bJg;
    final /* synthetic */ m bZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.bZj = mVar;
        this.bJg = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Xr().l(this.bJg);
    }
}
