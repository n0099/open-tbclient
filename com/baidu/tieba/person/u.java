package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1736a;

    private u(EditHeadActivity editHeadActivity) {
        this.f1736a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(EditHeadActivity editHeadActivity, u uVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f1736a.a_();
        if (intent.getBooleanExtra("result", false)) {
            this.f1736a.d();
        } else {
            this.f1736a.a(intent.getStringExtra("error"));
        }
    }
}
