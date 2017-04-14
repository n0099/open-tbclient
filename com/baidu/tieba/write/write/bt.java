package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bt implements Runnable {
    final /* synthetic */ WriteImageActivity.a fSD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(WriteImageActivity.a aVar) {
        this.fSD = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = WriteImageActivity.this;
        writeImageActivity.oc(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
