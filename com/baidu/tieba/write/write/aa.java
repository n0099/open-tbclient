package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ WriteActivity cUM;
    private final /* synthetic */ Date cUN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, Date date) {
        this.cUM = writeActivity;
        this.cUN = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.cUM.cUL;
        aVar.updateTime(this.cUN.getHours(), this.cUN.getMinutes());
    }
}
