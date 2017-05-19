package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class cb implements Runnable {
    final /* synthetic */ WriteImageActivity.a fTi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(WriteImageActivity.a aVar) {
        this.fTi = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.ob(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
