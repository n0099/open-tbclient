package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
final class af extends BroadcastReceiver {
    final /* synthetic */ MoreActivity a;

    private af(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(MoreActivity moreActivity, byte b) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        MoreActivity.a(this.a).d();
    }
}
