package com.baidu.tieba.write;

import java.util.Date;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ WriteActivity cgR;
    private final /* synthetic */ Date cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity, Date date) {
        this.cgR = writeActivity;
        this.cgS = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.g gVar;
        gVar = this.cgR.cgQ;
        gVar.updateTime(this.cgS.getHours(), this.cgS.getMinutes());
    }
}
