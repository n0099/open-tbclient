package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ WriteActivity feb;
    private final /* synthetic */ View fec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity, View view) {
        this.feb = writeActivity;
        this.fec = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fec.performClick();
        this.feb.bcj();
    }
}
