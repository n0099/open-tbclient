package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class cd implements Runnable {
    final /* synthetic */ WriteImageActivity.a fet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(WriteImageActivity.a aVar) {
        this.fet = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.mo(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
