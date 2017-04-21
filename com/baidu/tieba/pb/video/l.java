package com.baidu.tieba.pb.video;

import android.os.Handler;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c.b {
    final /* synthetic */ d exo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.exo = dVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void azI() {
        PbActivity pbActivity;
        Handler handler;
        pbActivity = this.exo.ekw;
        pbActivity.setSwipeBackEnabled(true);
        handler = this.exo.mHandler;
        handler.postDelayed(new m(this), 50L);
    }

    @Override // com.baidu.tieba.play.c.b
    public void azH() {
        PbActivity pbActivity;
        pbActivity = this.exo.ekw;
        pbActivity.setSwipeBackEnabled(false);
        this.exo.exm = false;
    }
}
