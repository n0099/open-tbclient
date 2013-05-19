package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class ba extends BroadcastReceiver {
    final /* synthetic */ WriteImageActivity a;

    private ba(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(WriteImageActivity writeImageActivity, ba baVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.a_();
        if (intent.getBooleanExtra("result", false)) {
            WriteImageActivity.k(this.a);
        } else {
            this.a.a(intent.getStringExtra("error"));
        }
    }
}
