package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class d extends BroadcastReceiver {
    final /* synthetic */ AboutActivity a;

    private d(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(AboutActivity aboutActivity, d dVar) {
        this(aboutActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AboutActivity.c(this.a);
    }
}
