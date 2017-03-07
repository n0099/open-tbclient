package com.baidu.tieba.pb.video;

import android.os.Handler;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements c.b {
    final /* synthetic */ d ewS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.ewS = dVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void azd() {
        PbActivity pbActivity;
        Handler handler;
        pbActivity = this.ewS.eka;
        pbActivity.setSwipeBackEnabled(true);
        handler = this.ewS.mHandler;
        handler.postDelayed(new m(this), 50L);
    }

    @Override // com.baidu.tieba.play.c.b
    public void azc() {
        PbActivity pbActivity;
        pbActivity = this.ewS.eka;
        pbActivity.setSwipeBackEnabled(false);
        this.ewS.ewQ = false;
    }
}
