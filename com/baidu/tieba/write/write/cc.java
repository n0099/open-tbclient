package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class cc implements Runnable {
    final /* synthetic */ cb cyM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.cyM = cbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.cyM.this$0;
        writeImageActivity.hX(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
