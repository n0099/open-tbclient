package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2258a;

    private w(EditHeadActivity editHeadActivity) {
        this.f2258a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f2258a.a_();
        if (intent.getBooleanExtra("result", false)) {
            this.f2258a.d();
        } else {
            this.f2258a.a(intent.getStringExtra("error"));
        }
    }
}
