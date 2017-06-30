package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends Handler {
    final /* synthetic */ v fLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.fLc = vVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        v.a aVar;
        v.a aVar2;
        if (message.what == 2) {
            this.fLc.count = 0;
            this.fLc.esu = 0L;
            this.fLc.esv = 0L;
        } else if (message.what == 1) {
            i = this.fLc.count;
            if (i == 1) {
                aVar = this.fLc.fLb;
                if (aVar != null) {
                    aVar2 = this.fLc.fLb;
                    aVar2.aeO();
                }
                this.fLc.count = 0;
                this.fLc.esu = 0L;
                this.fLc.esv = 0L;
            }
        }
    }
}
