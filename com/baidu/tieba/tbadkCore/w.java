package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends Handler {
    final /* synthetic */ v fAY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.fAY = vVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        v.a aVar;
        v.a aVar2;
        if (message.what == 2) {
            this.fAY.count = 0;
            this.fAY.ejw = 0L;
            this.fAY.ejx = 0L;
        } else if (message.what == 1) {
            i = this.fAY.count;
            if (i == 1) {
                aVar = this.fAY.fAX;
                if (aVar != null) {
                    aVar2 = this.fAY.fAX;
                    aVar2.aaX();
                }
                this.fAY.count = 0;
                this.fAY.ejw = 0L;
                this.fAY.ejx = 0L;
            }
        }
    }
}
