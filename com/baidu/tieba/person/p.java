package com.baidu.tieba.person;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ n bPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bPg = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.bPg.this$0;
        editHeadActivity.hU(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
