package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2396a;

    private w(EditHeadActivity editHeadActivity) {
        this.f2396a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2396a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.f2396a.c();
        } else {
            this.f2396a.showToast(intent.getStringExtra("error"));
        }
    }
}
