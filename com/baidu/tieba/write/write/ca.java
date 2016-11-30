package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class ca implements Runnable {
    final /* synthetic */ WriteImageActivity.a gpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteImageActivity.a aVar) {
        this.gpG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.pW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
