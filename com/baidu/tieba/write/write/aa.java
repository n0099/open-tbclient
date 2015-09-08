package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ WriteActivity ddQ;
    private final /* synthetic */ Date ddR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, Date date) {
        this.ddQ = writeActivity;
        this.ddR = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.ddQ.ddP;
        aVar.updateTime(this.ddR.getHours(), this.ddR.getMinutes());
    }
}
