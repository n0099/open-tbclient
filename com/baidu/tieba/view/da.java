package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        dc dcVar;
        dc dcVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            dcVar = this.a.o;
            if (dcVar != null) {
                dcVar2 = this.a.o;
                dcVar2.d();
            }
        }
    }
}
