package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bx implements Runnable {
    final /* synthetic */ WriteImageActivity.a dec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(WriteImageActivity.a aVar) {
        this.dec = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.jD(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
