package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bs implements Runnable {
    final /* synthetic */ WriteImageActivity.a etD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(WriteImageActivity.a aVar) {
        this.etD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.kW(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
