package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class u extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity a;

    private u(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(EditHeadActivity editHeadActivity, u uVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.a_();
        if (intent.getBooleanExtra("result", false)) {
            EditHeadActivity.h(this.a);
        } else {
            this.a.a(intent.getStringExtra("error"));
        }
    }
}
