package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bz implements Runnable {
    final /* synthetic */ WriteImageActivity.a fVF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteImageActivity.a aVar) {
        this.fVF = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.oL(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
