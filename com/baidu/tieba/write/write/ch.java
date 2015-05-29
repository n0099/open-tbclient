package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class ch implements Runnable {
    final /* synthetic */ cc cDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cc ccVar) {
        this.cDe = ccVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.cDe.this$0;
        writeImageActivity.iB(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
