package com.baidu.tieba.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class cb implements Runnable {
    final /* synthetic */ bw cfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bw bwVar) {
        this.cfH = bwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.cfH.this$0;
        writeImageActivity.de(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
