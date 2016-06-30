package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ WriteActivity fJw;
    private final /* synthetic */ View fJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, View view) {
        this.fJw = writeActivity;
        this.fJx = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fJx.performClick();
        this.fJw.bkL();
    }
}
