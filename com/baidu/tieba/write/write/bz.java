package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bz implements Runnable {
    final /* synthetic */ WriteImageActivity.a fJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteImageActivity.a aVar) {
        this.fJO = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.nT(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
