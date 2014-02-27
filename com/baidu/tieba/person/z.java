package com.baidu.tieba.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class z extends BroadcastReceiver {
    final /* synthetic */ EditHeadActivity a;

    private z(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(EditHeadActivity editHeadActivity, byte b) {
        this(editHeadActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.releaseResouce();
        if (intent.getBooleanExtra("result", false)) {
            EditHeadActivity.h(this.a);
            return;
        }
        this.a.showToast(intent.getStringExtra("error"));
        if (EditHeadActivity.d(this.a) != null) {
            EditHeadActivity.d(this.a).setEnabled(false);
        }
    }
}
