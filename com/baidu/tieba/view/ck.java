package com.baidu.tieba.view;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck extends Handler {
    final /* synthetic */ WaterFallView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(WaterFallView waterFallView) {
        this.a = waterFallView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        cm cmVar;
        cm cmVar2;
        super.handleMessage(message);
        if (message.what == 101) {
            cmVar = this.a.o;
            if (cmVar != null) {
                cmVar2 = this.a.o;
                cmVar2.d();
            }
        }
    }
}
