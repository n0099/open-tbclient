package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2698a;

    private ay(WriteImageActivity writeImageActivity) {
        this.f2698a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ay(WriteImageActivity writeImageActivity, ao aoVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2698a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.f2698a.c();
        } else {
            this.f2698a.showToast(intent.getStringExtra("error"));
        }
    }
}
