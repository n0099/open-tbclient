package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        am amVar;
        am amVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            amVar = this.a.o;
            if (amVar != null) {
                amVar2 = this.a.o;
                amVar2.d();
            }
        }
    }
}
