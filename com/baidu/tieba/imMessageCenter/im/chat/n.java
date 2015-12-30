package com.baidu.tieba.imMessageCenter.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ LinkedList bMO;
    final /* synthetic */ m cdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, LinkedList linkedList) {
        this.cdj = mVar;
        this.bMO = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Ha */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Yx().l(this.bMO);
    }
}
