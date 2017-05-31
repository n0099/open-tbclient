package com.baidu.tieba.write.album;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements o {
    final /* synthetic */ ac fVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ac acVar) {
        this.fVw = acVar;
    }

    @Override // com.baidu.tieba.write.album.o
    public void onPreLoad() {
    }

    @Override // com.baidu.tieba.write.album.o
    public void cO(List<e> list) {
        p pVar;
        pVar = this.fVw.fTx;
        pVar.cQ(list);
    }
}
