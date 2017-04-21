package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends Handler {
    final /* synthetic */ x fxc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.fxc = xVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        x.a aVar;
        x.a aVar2;
        if (message.what == 2) {
            this.fxc.count = 0;
            this.fxc.eiT = 0L;
            this.fxc.eiU = 0L;
        } else if (message.what == 1) {
            i = this.fxc.count;
            if (i == 1) {
                aVar = this.fxc.fxb;
                if (aVar != null) {
                    aVar2 = this.fxc.fxb;
                    aVar2.abt();
                }
                this.fxc.count = 0;
                this.fxc.eiT = 0L;
                this.fxc.eiU = 0L;
            }
        }
    }
}
