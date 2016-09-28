package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends Handler {
    final /* synthetic */ ab ftT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.ftT = abVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ab.a aVar;
        ab.a aVar2;
        if (message.what == 2) {
            this.ftT.count = 0;
            this.ftT.emJ = 0L;
            this.ftT.emK = 0L;
        } else if (message.what == 1) {
            i = this.ftT.count;
            if (i == 1) {
                aVar = this.ftT.ftS;
                if (aVar != null) {
                    aVar2 = this.ftT.ftS;
                    aVar2.acq();
                }
                this.ftT.count = 0;
                this.ftT.emJ = 0L;
                this.ftT.emK = 0L;
            }
        }
    }
}
