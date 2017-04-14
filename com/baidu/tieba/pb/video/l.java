package com.baidu.tieba.pb.video;

import android.os.Handler;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c.b {
    final /* synthetic */ d euY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.euY = dVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void ayH() {
        PbActivity pbActivity;
        Handler handler;
        pbActivity = this.euY.eig;
        pbActivity.setSwipeBackEnabled(true);
        handler = this.euY.mHandler;
        handler.postDelayed(new m(this), 50L);
    }

    @Override // com.baidu.tieba.play.c.b
    public void ayG() {
        PbActivity pbActivity;
        pbActivity = this.euY.eig;
        pbActivity.setSwipeBackEnabled(false);
        this.euY.euW = false;
    }
}
