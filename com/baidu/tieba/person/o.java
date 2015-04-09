package com.baidu.tieba.person;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ n bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bPw = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.bPw.this$0;
        editHeadActivity.hX(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}
