package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        an anVar;
        an anVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            anVar = this.a.o;
            if (anVar != null) {
                anVar2 = this.a.o;
                anVar2.d();
            }
        }
    }
}
