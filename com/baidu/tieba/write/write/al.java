package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ WriteActivity cyx;
    private final /* synthetic */ Date cyy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity, Date date) {
        this.cyx = writeActivity;
        this.cyy = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.cyx.cyw;
        aVar.updateTime(this.cyy.getHours(), this.cyy.getMinutes());
    }
}
