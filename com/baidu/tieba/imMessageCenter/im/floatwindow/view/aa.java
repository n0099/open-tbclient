package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ LinkedList cVA;
    final /* synthetic */ z dpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.dpV = zVar;
        this.cVA = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.asu().k(this.cVA);
    }
}
