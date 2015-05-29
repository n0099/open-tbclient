package com.baidu.tieba.person;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ n bRz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bRz = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.bRz.this$0;
        editHeadActivity.iB(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
