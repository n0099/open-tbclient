package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ WriteActivity fea;
    private final /* synthetic */ View feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity, View view) {
        this.fea = writeActivity;
        this.feb = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.feb.performClick();
        this.fea.bcq();
    }
}
