package com.baidu.tieba.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class bx implements Runnable {
    final /* synthetic */ bw chg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar) {
        this.chg = bwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.chg.this$0;
        writeImageActivity.da(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
