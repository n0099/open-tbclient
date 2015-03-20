package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ WriteActivity cyc;
    private final /* synthetic */ Date cyd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity, Date date) {
        this.cyc = writeActivity;
        this.cyd = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.cyc.cyb;
        aVar.updateTime(this.cyd.getHours(), this.cyd.getMinutes());
    }
}
