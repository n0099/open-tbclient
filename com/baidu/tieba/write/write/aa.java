package com.baidu.tieba.write.write;

import java.util.Date;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ WriteActivity dpI;
    private final /* synthetic */ Date dpJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, Date date) {
        this.dpI = writeActivity;
        this.dpJ = date;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.view.a aVar;
        aVar = this.dpI.dpH;
        aVar.updateTime(this.dpJ.getHours(), this.dpJ.getMinutes());
    }
}
