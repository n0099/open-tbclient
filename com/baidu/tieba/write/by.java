package com.baidu.tieba.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class by implements Runnable {
    final /* synthetic */ bw bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw bwVar) {
        this.bUj = bwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.bUj.this$0;
        writeImageActivity.cl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
