package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class be extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2109a;

    private be(WriteImageActivity writeImageActivity) {
        this.f2109a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(WriteImageActivity writeImageActivity, be beVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2109a.a_();
        if (intent.getBooleanExtra("result", false)) {
            WriteImageActivity.k(this.f2109a);
        } else {
            this.f2109a.a(intent.getStringExtra("error"));
        }
    }
}
