package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class cd implements Runnable {
    final /* synthetic */ cb cyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar) {
        this.cyq = cbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.cyq.this$0;
        writeImageActivity.hU(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
