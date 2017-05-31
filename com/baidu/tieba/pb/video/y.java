package com.baidu.tieba.pb.video;

import android.os.Handler;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void axy() {
        PbActivity pbActivity;
        Handler handler;
        pbActivity = this.eAW.elf;
        pbActivity.setSwipeBackEnabled(true);
        handler = this.eAW.mHandler;
        handler.postDelayed(new z(this), 50L);
    }

    @Override // com.baidu.tieba.play.c.b
    public void axx() {
        PbActivity pbActivity;
        pbActivity = this.eAW.elf;
        pbActivity.setSwipeBackEnabled(false);
        this.eAW.eAP = false;
    }
}
