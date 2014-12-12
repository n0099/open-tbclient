package com.baidu.tieba.write;

import java.util.Date;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ WriteActivity cft;
    private final /* synthetic */ Date cfu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity, Date date) {
        this.cft = writeActivity;
        this.cfu = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.b bVar;
        bVar = this.cft.cfs;
        bVar.updateTime(this.cfu.getHours(), this.cfu.getMinutes());
    }
}
