package com.baidu.tieba.launcherGuide.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j bwJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bwJ = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.bwJ.Wd();
                return;
            case 1:
                this.bwJ.Wc();
                return;
            default:
                return;
        }
    }
}
