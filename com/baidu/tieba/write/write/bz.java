package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bz implements Runnable {
    final /* synthetic */ WriteImageActivity.a dsm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteImageActivity.a aVar) {
        this.dsm = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.kb(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
