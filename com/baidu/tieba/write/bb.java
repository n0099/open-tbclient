package com.baidu.tieba.write;

import java.util.Date;
/* loaded from: classes.dex */
class bb implements Runnable {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ Date b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, Date date) {
        this.a = writeActivity;
        this.b = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.e eVar;
        eVar = this.a.ab;
        eVar.updateTime(this.b.getHours(), this.b.getMinutes());
    }
}
