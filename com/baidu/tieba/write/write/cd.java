package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class cd implements Runnable {
    final /* synthetic */ cb cyM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar) {
        this.cyM = cbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.cyM.this$0;
        writeImageActivity.hX(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
