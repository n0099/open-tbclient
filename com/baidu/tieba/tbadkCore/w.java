package com.baidu.tieba.tbadkCore;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.tbadkCore.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends Handler {
    final /* synthetic */ v fth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.fth = vVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        v.a aVar;
        v.a aVar2;
        if (message.what == 2) {
            this.fth.count = 0;
            this.fth.edW = 0L;
            this.fth.edX = 0L;
        } else if (message.what == 1) {
            i = this.fth.count;
            if (i == 1) {
                aVar = this.fth.ftg;
                if (aVar != null) {
                    aVar2 = this.fth.ftg;
                    aVar2.ZV();
                }
                this.fth.count = 0;
                this.fth.edW = 0L;
                this.fth.edX = 0L;
            }
        }
    }
}
