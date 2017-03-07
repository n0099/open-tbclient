package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bt implements Runnable {
    final /* synthetic */ WriteImageActivity.a fQT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(WriteImageActivity.a aVar) {
        this.fQT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.nY(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
