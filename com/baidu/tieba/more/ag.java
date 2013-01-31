package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class ag extends BroadcastReceiver {
    final /* synthetic */ MoreActivity a;

    private ag(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MoreActivity moreActivity, ag agVar) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MoreActivity.a(this.a);
    }
}
