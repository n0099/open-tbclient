package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class s extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity a;

    private s(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(EditHeadActivity editHeadActivity, s sVar) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.a.a();
        if (intent.getBooleanExtra("result", false)) {
            EditHeadActivity.h(this.a);
        } else {
            this.a.b(intent.getStringExtra("error"));
        }
    }
}
