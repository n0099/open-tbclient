package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends Handler {
    final /* synthetic */ x ftc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.ftc = xVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        x.a aVar;
        x.a aVar2;
        if (message.what == 2) {
            this.ftc.count = 0;
            this.ftc.eiw = 0L;
            this.ftc.eix = 0L;
        } else if (message.what == 1) {
            i = this.ftc.count;
            if (i == 1) {
                aVar = this.ftc.ftb;
                if (aVar != null) {
                    aVar2 = this.ftc.ftb;
                    aVar2.ZU();
                }
                this.ftc.count = 0;
                this.ftc.eiw = 0L;
                this.ftc.eix = 0L;
            }
        }
    }
}
