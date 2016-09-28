package com.baidu.tieba.play;

import com.baidu.tieba.play.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements h.b {
    final /* synthetic */ s eZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.eZb = sVar;
    }

    @Override // com.baidu.tieba.play.h.b
    public void baj() {
        int i;
        s sVar = this.eZb;
        i = sVar.eYY;
        sVar.eYY = i + 1;
    }
}
