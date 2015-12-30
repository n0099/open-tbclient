package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ LinkedList bMO;
    final /* synthetic */ z cfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.cfX = zVar;
        this.bMO = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Ha */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.Yx().l(this.bMO);
    }
}
