package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends Handler {
    final /* synthetic */ ab dys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.dys = abVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ab.a aVar;
        ab.a aVar2;
        if (message.what == 2) {
            this.dys.count = 0;
            this.dys.czE = 0L;
            this.dys.czF = 0L;
        } else if (message.what == 1) {
            i = this.dys.count;
            if (i == 1) {
                aVar = this.dys.dyr;
                if (aVar != null) {
                    aVar2 = this.dys.dyr;
                    aVar2.NW();
                }
                this.dys.count = 0;
                this.dys.czE = 0L;
                this.dys.czF = 0L;
            }
        }
    }
}
