package com.baidu.tieba.write;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2654a;

    private bf(WriteImageActivity writeImageActivity) {
        this.f2654a = writeImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(WriteImageActivity writeImageActivity, av avVar) {
        this(writeImageActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2654a.a_();
        if (intent.getBooleanExtra("result", false)) {
            this.f2654a.d();
        } else {
            this.f2654a.a(intent.getStringExtra("error"));
        }
    }
}
