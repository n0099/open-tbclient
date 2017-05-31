package com.baidu.tieba.play;

import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements y.b {
    final /* synthetic */ ak fbJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.fbJ = akVar;
    }

    @Override // com.baidu.tieba.play.y.b
    public void aXK() {
        int i;
        ak akVar = this.fbJ;
        i = akVar.fbG;
        akVar.fbG = i + 1;
    }
}
