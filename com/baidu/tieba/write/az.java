package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2800a;

    private az(WriteImageActivity writeImageActivity) {
        this.f2800a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(WriteImageActivity writeImageActivity, ap apVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2800a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.f2800a.c();
        } else {
            this.f2800a.showToast(intent.getStringExtra("error"));
        }
    }
}
