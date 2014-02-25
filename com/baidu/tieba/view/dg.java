package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        di diVar;
        di diVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            diVar = this.a.o;
            if (diVar != null) {
                diVar2 = this.a.o;
                diVar2.d();
            }
        }
    }
}
