package com.baidu.tieba.write;

import java.util.Date;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ WriteActivity bTX;
    private final /* synthetic */ Date bTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity, Date date) {
        this.bTX = writeActivity;
        this.bTY = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.c cVar;
        cVar = this.bTX.bTW;
        cVar.updateTime(this.bTY.getHours(), this.bTY.getMinutes());
    }
}
