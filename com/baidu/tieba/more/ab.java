package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class ab extends BroadcastReceiver {
    final /* synthetic */ MoreActivity this$0;

    private ab(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(MoreActivity moreActivity, ab abVar) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MoreActivity.a(this.this$0).b();
    }
}
