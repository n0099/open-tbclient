package com.baidu.tieba.write;

import java.util.Date;
/* loaded from: classes.dex */
class bd implements Runnable {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ Date b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity, Date date) {
        this.a = writeActivity;
        this.b = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.d dVar;
        dVar = this.a.Z;
        dVar.updateTime(this.b.getHours(), this.b.getMinutes());
    }
}
