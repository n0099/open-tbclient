package com.baidu.tieba.pb.video;

import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements c.g {
    final /* synthetic */ d ewS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(d dVar) {
        this.ewS = dVar;
    }

    @Override // com.baidu.tieba.play.c.g
    public void onStop() {
        com.baidu.tieba.play.c cVar;
        PbActivity pbActivity;
        cVar = this.ewS.eqI;
        if (cVar.ayT()) {
            pbActivity = this.ewS.eka;
            pbActivity.setSwipeBackEnabled(true);
        }
    }

    @Override // com.baidu.tieba.play.c.g
    public void onStart() {
        com.baidu.tieba.play.c cVar;
        PbActivity pbActivity;
        cVar = this.ewS.eqI;
        if (cVar.ayT()) {
            pbActivity = this.ewS.eka;
            pbActivity.setSwipeBackEnabled(false);
        }
    }
}
