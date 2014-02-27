package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class c extends BroadcastReceiver {
    final /* synthetic */ AboutActivity a;

    private c(AboutActivity aboutActivity) {
        this.a = aboutActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AboutActivity aboutActivity, byte b) {
        this(aboutActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (AboutActivity.a(this.a) != null) {
            AboutActivity.a(this.a).e();
        }
    }
}
