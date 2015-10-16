package com.baidu.tieba.launcherGuide.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h bRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bRT = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.bRT.aaC();
                return;
            case 1:
                this.bRT.aaB();
                return;
            default:
                return;
        }
    }
}
