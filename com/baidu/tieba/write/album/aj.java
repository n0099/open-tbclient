package com.baidu.tieba.write.album;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements o {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ac acVar) {
        this.ggh = acVar;
    }

    @Override // com.baidu.tieba.write.album.o
    public void onPreLoad() {
    }

    @Override // com.baidu.tieba.write.album.o
    public void dd(List<e> list) {
        p pVar;
        pVar = this.ggh.gei;
        pVar.df(list);
    }
}
