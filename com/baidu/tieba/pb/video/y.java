package com.baidu.tieba.pb.video;

import android.os.Handler;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ l eKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.eKu = lVar;
    }

    @Override // com.baidu.tieba.play.c.b
    public void aBx() {
        PbActivity pbActivity;
        Handler handler;
        pbActivity = this.eKu.euf;
        pbActivity.setSwipeBackEnabled(true);
        handler = this.eKu.mHandler;
        handler.postDelayed(new z(this), 50L);
    }

    @Override // com.baidu.tieba.play.c.b
    public void aBw() {
        PbActivity pbActivity;
        pbActivity = this.eKu.euf;
        pbActivity.setSwipeBackEnabled(false);
        this.eKu.eKn = false;
    }
}
