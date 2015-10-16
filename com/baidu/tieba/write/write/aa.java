package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ WriteActivity dqi;
    private final /* synthetic */ Date dqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, Date date) {
        this.dqi = writeActivity;
        this.dqj = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.dqi.dqh;
        aVar.updateTime(this.dqj.getHours(), this.dqj.getMinutes());
    }
}
