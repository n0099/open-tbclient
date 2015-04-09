package com.baidu.tieba.launcherGuide.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ j bwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bwZ = jVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.bwZ.Wq();
                return;
            case 1:
                this.bwZ.Wp();
                return;
            default:
                return;
        }
    }
}
