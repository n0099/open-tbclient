package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends Handler {
    final /* synthetic */ z cHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.cHO = zVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        z.a aVar;
        z.a aVar2;
        if (message.what == 2) {
            this.cHO.count = 0;
            this.cHO.car = 0L;
            this.cHO.cas = 0L;
        } else if (message.what == 1) {
            i = this.cHO.count;
            if (i == 1) {
                aVar = this.cHO.cHN;
                if (aVar != null) {
                    aVar2 = this.cHO.cHN;
                    aVar2.Ms();
                }
                this.cHO.count = 0;
                this.cHO.car = 0L;
                this.cHO.cas = 0L;
            }
        }
    }
}
