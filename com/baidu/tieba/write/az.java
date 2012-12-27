package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class az extends BroadcastReceiver {
    final /* synthetic */ WriteImageActivity a;

    private az(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(WriteImageActivity writeImageActivity, az azVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.a();
        if (intent.getBooleanExtra("result", false)) {
            WriteImageActivity.k(this.a);
        } else {
            this.a.b(intent.getStringExtra("error"));
        }
    }
}
