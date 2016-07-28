package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends Handler {
    final /* synthetic */ ac fjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.fjt = acVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ac.a aVar;
        ac.a aVar2;
        if (message.what == 2) {
            this.fjt.count = 0;
            this.fjt.dYD = 0L;
            this.fjt.dYE = 0L;
        } else if (message.what == 1) {
            i = this.fjt.count;
            if (i == 1) {
                aVar = this.fjt.fjs;
                if (aVar != null) {
                    aVar2 = this.fjt.fjs;
                    aVar2.Xg();
                }
                this.fjt.count = 0;
                this.fjt.dYD = 0L;
                this.fjt.dYE = 0L;
            }
        }
    }
}
