package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends Handler {
    final /* synthetic */ ab fBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.fBg = abVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        ab.a aVar;
        ab.a aVar2;
        if (message.what == 2) {
            this.fBg.count = 0;
            this.fBg.esG = 0L;
            this.fBg.esH = 0L;
        } else if (message.what == 1) {
            i = this.fBg.count;
            if (i == 1) {
                aVar = this.fBg.fBf;
                if (aVar != null) {
                    aVar2 = this.fBg.fBf;
                    aVar2.adv();
                }
                this.fBg.count = 0;
                this.fBg.esG = 0L;
                this.fBg.esH = 0L;
            }
        }
    }
}
