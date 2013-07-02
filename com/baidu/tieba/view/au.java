package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        aw awVar;
        aw awVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            awVar = this.a.o;
            if (awVar != null) {
                awVar2 = this.a.o;
                awVar2.d();
            }
        }
    }
}
