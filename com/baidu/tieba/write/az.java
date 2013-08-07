package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class az extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1894a;

    private az(WriteImageActivity writeImageActivity) {
        this.f1894a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(WriteImageActivity writeImageActivity, az azVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1894a.a_();
        if (intent.getBooleanExtra("result", false)) {
            WriteImageActivity.k(this.f1894a);
        } else {
            this.f1894a.a(intent.getStringExtra("error"));
        }
    }
}
