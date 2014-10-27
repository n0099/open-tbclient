package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class cd extends BroadcastReceiver {
    final /* synthetic */ WriteImageActivity this$0;

    private cd(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cd(WriteImageActivity writeImageActivity, cd cdVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.this$0.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            WriteImageActivity.m(this.this$0);
            return;
        }
        this.this$0.showToast(intent.getStringExtra("error"));
        if (WriteImageActivity.i(this.this$0) != null) {
            WriteImageActivity.i(this.this$0).setEnabled(false);
        }
    }
}
