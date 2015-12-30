package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bv implements Runnable {
    final /* synthetic */ WriteImageActivity.a dYO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WriteImageActivity.a aVar) {
        this.dYO = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.kP(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
