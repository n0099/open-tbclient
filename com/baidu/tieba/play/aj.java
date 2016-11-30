package com.baidu.tieba.play;

import com.baidu.tieba.play.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements w.b {
    final /* synthetic */ ah fgo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.fgo = ahVar;
    }

    @Override // com.baidu.tieba.play.w.b
    public void bcI() {
        int i;
        ah ahVar = this.fgo;
        i = ahVar.fgl;
        ahVar.fgl = i + 1;
    }
}
