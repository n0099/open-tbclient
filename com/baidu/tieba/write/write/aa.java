package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ WriteActivity dsa;
    private final /* synthetic */ Date dsb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, Date date) {
        this.dsa = writeActivity;
        this.dsb = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.dsa.drZ;
        aVar.updateTime(this.dsb.getHours(), this.dsb.getMinutes());
    }
}
