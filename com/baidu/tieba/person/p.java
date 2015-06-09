package com.baidu.tieba.person;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ n bRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bRA = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.bRA.this$0;
        editHeadActivity.iB(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
