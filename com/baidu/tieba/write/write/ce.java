package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class ce implements Runnable {
    final /* synthetic */ cc cDf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cc ccVar) {
        this.cDf = ccVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.cDf.this$0;
        writeImageActivity.iB(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
