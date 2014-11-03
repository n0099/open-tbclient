package com.baidu.tieba.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class by implements Runnable {
    final /* synthetic */ bw bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw bwVar) {
        this.bUy = bwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.bUy.this$0;
        writeImageActivity.cl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
