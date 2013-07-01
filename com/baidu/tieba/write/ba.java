package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class ba extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1580a;

    private ba(WriteImageActivity writeImageActivity) {
        this.f1580a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(WriteImageActivity writeImageActivity, ba baVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1580a.a_();
        if (intent.getBooleanExtra("result", false)) {
            WriteImageActivity.k(this.f1580a);
        } else {
            this.f1580a.a(intent.getStringExtra("error"));
        }
    }
}
