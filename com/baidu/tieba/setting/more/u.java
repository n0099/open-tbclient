package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BroadcastReceiver {
    final /* synthetic */ MoreActivity this$0;

    private u(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(MoreActivity moreActivity, u uVar) {
        this(moreActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        aa aaVar;
        aaVar = this.this$0.caQ;
        aaVar.refreshNewVersion();
    }
}
