package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        av avVar;
        av avVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            avVar = this.a.o;
            if (avVar != null) {
                avVar2 = this.a.o;
                avVar2.d();
            }
        }
    }
}
