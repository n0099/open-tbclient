package com.baidu.tieba.play;

import com.baidu.tieba.play.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements y.b {
    final /* synthetic */ ak flZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.flZ = akVar;
    }

    @Override // com.baidu.tieba.play.y.b
    public void bbV() {
        int i;
        ak akVar = this.flZ;
        i = akVar.flW;
        akVar.flW = i + 1;
    }
}
