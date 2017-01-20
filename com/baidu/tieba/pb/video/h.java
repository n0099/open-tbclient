package com.baidu.tieba.pb.video;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements c.b {
    final /* synthetic */ d etA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.etA = dVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void azF() {
        PbActivity pbActivity;
        pbActivity = this.etA.ehi;
        pbActivity.setSwipeBackEnabled(true);
    }

    @Override // com.baidu.tieba.play.c.b
    public void azE() {
        PbActivity pbActivity;
        pbActivity = this.etA.ehi;
        pbActivity.setSwipeBackEnabled(false);
    }
}
