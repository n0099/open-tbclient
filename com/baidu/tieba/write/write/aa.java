package com.baidu.tieba.write.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ WriteActivity fVn;
    private final /* synthetic */ View fVo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, View view) {
        this.fVn = writeActivity;
        this.fVo = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fVo.performClick();
        this.fVn.bbv();
    }
}
