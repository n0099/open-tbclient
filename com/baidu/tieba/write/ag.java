package com.baidu.tieba.write;

import java.util.Date;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ WriteActivity cgS;
    private final /* synthetic */ Date cgT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity, Date date) {
        this.cgS = writeActivity;
        this.cgT = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.g gVar;
        gVar = this.cgS.cgR;
        gVar.updateTime(this.cgT.getHours(), this.cgT.getMinutes());
    }
}
