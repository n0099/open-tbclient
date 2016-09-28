package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import java.util.LinkedList;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.t<Void> {
    private final /* synthetic */ LinkedList cWX;
    final /* synthetic */ z drs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, LinkedList linkedList) {
        this.drs = zVar;
        this.cWX = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Mt */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.l.asT().k(this.cWX);
    }
}
