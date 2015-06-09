package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class am implements Runnable {
    final /* synthetic */ WriteActivity cCQ;
    private final /* synthetic */ Date cCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity, Date date) {
        this.cCQ = writeActivity;
        this.cCR = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.cCQ.cCP;
        aVar.updateTime(this.cCR.getHours(), this.cCR.getMinutes());
    }
}
