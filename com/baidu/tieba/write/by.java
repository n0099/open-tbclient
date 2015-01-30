package com.baidu.tieba.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class by implements Runnable {
    final /* synthetic */ bw chh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw bwVar) {
        this.chh = bwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.chh.this$0;
        writeImageActivity.dd(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
