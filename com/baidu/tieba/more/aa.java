package com.baidu.tieba.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BroadcastReceiver {
    final /* synthetic */ MoreActivity this$0;

    private aa(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(MoreActivity moreActivity, aa aaVar) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        af afVar;
        afVar = this.this$0.buv;
        afVar.refreshNewVersion();
    }
}
