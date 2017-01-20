package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {
    final /* synthetic */ y foG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.foG = yVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        y.a aVar;
        y.a aVar2;
        if (message.what == 2) {
            this.foG.count = 0;
            this.foG.ega = 0L;
            this.foG.egb = 0L;
        } else if (message.what == 1) {
            i = this.foG.count;
            if (i == 1) {
                aVar = this.foG.foF;
                if (aVar != null) {
                    aVar2 = this.foG.foF;
                    aVar2.YV();
                }
                this.foG.count = 0;
                this.foG.ega = 0L;
                this.foG.egb = 0L;
            }
        }
    }
}
