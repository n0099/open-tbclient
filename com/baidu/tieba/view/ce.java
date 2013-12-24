package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        cg cgVar;
        cg cgVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            cgVar = this.a.o;
            if (cgVar != null) {
                cgVar2 = this.a.o;
                cgVar2.d();
            }
        }
    }
}
