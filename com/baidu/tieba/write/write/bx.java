package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bx implements Runnable {
    final /* synthetic */ WriteImageActivity.a dqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(WriteImageActivity.a aVar) {
        this.dqu = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.jY(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
