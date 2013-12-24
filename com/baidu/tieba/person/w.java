package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity a;

    private w(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            this.a.c();
        } else {
            this.a.showToast(intent.getStringExtra("error"));
        }
    }
}
