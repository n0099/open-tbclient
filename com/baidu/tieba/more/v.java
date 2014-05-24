package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class v extends BroadcastReceiver {
    final /* synthetic */ MoreActivity this$0;

    private v(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(MoreActivity moreActivity, v vVar) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MoreActivity.a(this.this$0).c();
    }
}
