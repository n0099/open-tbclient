package com.baidu.tieba.launcherGuide.guide;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h ciB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.ciB = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.ciB.aez();
                return;
            case 1:
                this.ciB.aey();
                return;
            default:
                return;
        }
    }
}
