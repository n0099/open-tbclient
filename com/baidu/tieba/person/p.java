package com.baidu.tieba.person;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ n bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bPw = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.bPw.this$0;
        editHeadActivity.hX(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
