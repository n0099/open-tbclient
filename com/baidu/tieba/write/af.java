package com.baidu.tieba.write;

import java.util.Date;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ WriteActivity bUm;
    private final /* synthetic */ Date bUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity, Date date) {
        this.bUm = writeActivity;
        this.bUn = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.c cVar;
        cVar = this.bUm.bUl;
        cVar.updateTime(this.bUn.getHours(), this.bUn.getMinutes());
    }
}
