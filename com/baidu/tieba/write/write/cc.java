package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class cc implements Runnable {
    final /* synthetic */ cb cyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.cyq = cbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.cyq.this$0;
        writeImageActivity.hU(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
