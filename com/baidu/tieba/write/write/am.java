package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class am implements Runnable {
    final /* synthetic */ WriteActivity cCP;
    private final /* synthetic */ Date cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity, Date date) {
        this.cCP = writeActivity;
        this.cCQ = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.cCP.cCO;
        aVar.updateTime(this.cCQ.getHours(), this.cCQ.getMinutes());
    }
}
