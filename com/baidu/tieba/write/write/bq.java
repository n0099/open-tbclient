package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bq implements Runnable {
    final /* synthetic */ WriteImageActivity.a cUY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteImageActivity.a aVar) {
        this.cUY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.jv(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
