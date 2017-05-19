package com.baidu.tieba.pb.video;

import android.os.Handler;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c.b {
    final /* synthetic */ g esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.esY = gVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void awF() {
        PbActivity pbActivity;
        Handler handler;
        pbActivity = this.esY.efF;
        pbActivity.setSwipeBackEnabled(true);
        handler = this.esY.mHandler;
        handler.postDelayed(new p(this), 50L);
    }

    @Override // com.baidu.tieba.play.c.b
    public void awE() {
        PbActivity pbActivity;
        pbActivity = this.esY.efF;
        pbActivity.setSwipeBackEnabled(false);
        this.esY.esW = false;
    }
}
