package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class bv extends BroadcastReceiver {
    final /* synthetic */ WriteImageActivity a;

    private bv(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bv(WriteImageActivity writeImageActivity, bv bvVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            WriteImageActivity.l(this.a);
            return;
        }
        this.a.showToast(intent.getStringExtra("error"));
        if (WriteImageActivity.i(this.a) != null) {
            WriteImageActivity.i(this.a).setEnabled(false);
        }
    }
}
