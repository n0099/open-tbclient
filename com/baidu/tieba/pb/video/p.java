package com.baidu.tieba.pb.video;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements c.g {
    final /* synthetic */ d euY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(d dVar) {
        this.euY = dVar;
    }

    @Override // com.baidu.tieba.play.c.g
    public void onStop() {
        com.baidu.tieba.play.c cVar;
        PbActivity pbActivity;
        cVar = this.euY.eoR;
        if (cVar.ayx()) {
            pbActivity = this.euY.eig;
            pbActivity.setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tieba.play.c.g
    public void onStart() {
        com.baidu.tieba.play.c cVar;
        PbActivity pbActivity;
        cVar = this.euY.eoR;
        if (cVar.ayx()) {
            pbActivity = this.euY.eig;
            pbActivity.setSwipeBackEnabled(false);
        }
    }
}
