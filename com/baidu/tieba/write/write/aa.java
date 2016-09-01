package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ WriteActivity gfs;
    private final /* synthetic */ View gft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, View view) {
        this.gfs = writeActivity;
        this.gft = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gft.performClick();
        this.gfs.bfa();
    }
}
