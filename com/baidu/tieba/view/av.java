package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ax axVar;
        ax axVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            axVar = this.a.o;
            if (axVar != null) {
                axVar2 = this.a.o;
                axVar2.d();
            }
        }
    }
}
